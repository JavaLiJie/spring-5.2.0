package aspect;


import com.sgcc.utils.IcCommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.sgcc.utils.log.LogUtil;

import java.util.Map;


/**
 * 方法调用前后、异常及结果返回时记录日志
 * @author hlc
 */
@Aspect
@Component
public class InvokeLogAdvice {
	//此处日志log打印的所在类名是InvokeLogAdvice，因此需要通过切点signature获取目标类的类名和方法名
	private final static LogUtil log = new LogUtil(InvokeLogAdvice.class);

	private final static  String   ARGS="【日志流水号】:【{}】,调用类【{}】,调用方法【{}】入参【{}】";

	private final static  String   EX="【日志流水号】:【{}】,调用类【{}】,调用方法【{}】入参【{}】调用异常:{}";

	private final static  String   RETMSG="【日志流水号】:【{}】调用类【{}】,调用方法【{}】返回结果==>{}";

	private final static  String   END="【日志流水号】:【{}】调用类【{}】,调用方法【{}】调用结束=========耗时:{}毫秒=========>>>";

	private final static  String   ERRPRINTARGS="【日志流水号】:【{}】调用类【{}】,调用方法【{}】【切面打印参数】==异常信息：=======》{}";

	private static long executeTime;

	private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
	
	private static String logId;

	@Pointcut("execution(public * com.sgcc.controller.*.*(..))")//释放
	public void pointCutForRemove() {
	}
	@Pointcut("execution(public * com.sgcc.mq.consum.MessageActivityListener.consume(..))")//释放
	public void pointCutForRemove2() {
	}
	@Pointcut("@annotation(com.sgcc.utils.annotation.InvokeLogMethod)")//针对方法
	public void pointCut() {
	}
	@Pointcut("@within(com.sgcc.utils.annotation.InvokeLog)")//针对类
	public void pointCutForClass() {
	}

	//后置通知  打印返回报文 调用结束
	@AfterReturning(pointcut = "pointCut()", returning = "returnValue")
	public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		log.info(RETMSG,logId,className,methodName,returnValue==null?"":returnValue.toString());
		log.info(END,logId,className,methodName,executeTime);
	}

	//例外通知 异常 调用结束
	@AfterThrowing(pointcut = "pointCut()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Exception e) throws Exception {
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		log.error(EX,logId,className,methodName,e.getMessage());
		log.info(END,logId,className,methodName,executeTime);
	}
	//后置通知  打印返回报文 调用结束
	@AfterReturning(pointcut = "pointCutForClass()", returning = "returnValue")
	public void doAfterReturningForClass(JoinPoint joinPoint, Object returnValue) {
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		log.info(RETMSG,logId,className,methodName,returnValue==null?"":returnValue.toString());
		log.info(END,logId,className,methodName,executeTime);
	}

	//例外通知 异常 调用结束
	@AfterThrowing(pointcut = "pointCutForClass()", throwing = "e")
	public void doAfterThrowingForClass(JoinPoint joinPoint, Exception e) throws Exception {
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		log.error(EX,logId,className,methodName,e.getMessage());
		log.info(END,logId,className,methodName,executeTime);
	}

	//后置通知  打印返回报文 调用结束 -针对controller层进行清除threadLocal，防止内存泄漏com.sgcc.mq.consum.MessageActivityListener
	@AfterReturning(pointcut = "pointCutForRemove()", returning = "returnValue")
	public void doAfterReturningController(JoinPoint joinPoint, Object returnValue) {
		threadLocal.remove();
	}

	//例外通知 异常 调用结束 -针对controller层进行清除threadLocal，防止内存泄漏
	@AfterThrowing(pointcut = "pointCutForRemove()",  throwing = "e")
	public void doAfterThrowingController(JoinPoint joinPoint, Exception e) throws Exception {
		threadLocal.remove();
	}
	//后置通知  打印返回报文 调用结束 -针对controller层进行清除threadLocal，防止内存泄漏com.sgcc.mq.consum.MessageActivityListener
	@AfterReturning(pointcut = "pointCutForRemove2()", returning = "returnValue")
	public void doAfterReturningMq(JoinPoint joinPoint, Object returnValue) {
		threadLocal.remove();
	}

	//例外通知 异常 调用结束 -针对controller层进行清除threadLocal，防止内存泄漏
	@AfterThrowing(pointcut = "pointCutForRemove2()",  throwing = "e")
	public void doAfterThrowingMq(JoinPoint joinPoint, Exception e) throws Exception {
		threadLocal.remove();
	}

	/**
	 * 打印参数
	 *
	 * @param joinPoint
	 * @param LOGGER
	 */
	private void printArgs(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		//目标切点的类名和方法名
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		try {
			Object[] args = joinPoint.getArgs();
			int argLength = args.length;
			if (argLength == 0) return;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < argLength; i++) {
				Object arg = args[i];
				if (null==arg||arg.toString().equals("")) continue;
				if (arg instanceof Number || arg instanceof CharSequence || arg instanceof Character) {
					buffer.append(arg);
				} else {
					buffer.append(JSON.toJSONString(arg));
				}
				if (i < argLength - 1) {
					buffer.append(",");
				}
			}
			//将参数流转换成字符串
			String data = buffer.toString();
			//如果获取不到，则代表是整条链路的入口，需新生成日志ID
			if (IcCommonUtils.isNullForObject(threadLocal.get())){
				logId = IcCommonUtils.createUUID();
				threadLocal.set(logId);
			}else {
				logId= (String)threadLocal.get();
			}
			log.info(ARGS,InvokeLogAdvice.logId,className,methodName,data);
		} catch (Exception e) {
			log.error(ERRPRINTARGS,logId,className,methodName,e.getMessage());
		}
	
	}
	
	// 打印开始、请求报文、执行耗时
	@Around("pointCutForClass()")
	public Object logInvokeTime(ProceedingJoinPoint joinPoint) {
		long start = System.currentTimeMillis();//开始时间
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		Object result = new Object();
		try {
			printArgs(joinPoint);
			//如果没有参数为空，执行方法
			result = joinPoint.proceed();
		}catch(Throwable e){
			e.printStackTrace();
			log.error(ERRPRINTARGS,logId,className,methodName,e.getMessage());
		} finally {
			long end = System.currentTimeMillis();//结束时间
			executeTime = end - start;
		}
		return result;
	}
	// 打印开始、请求报文、执行耗时
	@Around("pointCut()")
	public Object logInvokeTimeForMethod(ProceedingJoinPoint joinPoint) {
		long start = System.currentTimeMillis();//开始时间
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		String methodName = signature.getName();
		Object result = new Object();
		try {
			printArgs(joinPoint);
			//如果没有参数为空，执行方法
			result = joinPoint.proceed();
		}catch(Throwable e){
			e.printStackTrace();
			log.error(ERRPRINTARGS,logId,className,methodName,e.getMessage());
		} finally {
			long end = System.currentTimeMillis();//结束时间
			executeTime = end - start;
		}
		return result;

	}

}
