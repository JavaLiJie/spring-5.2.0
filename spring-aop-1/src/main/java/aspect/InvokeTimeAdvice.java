package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sgcc.utils.annotation.ExecuteTime;
import com.sgcc.utils.log.LogUtil;


/**
 * 记录方法执行时长
 */
@Aspect
@Component
public class InvokeTimeAdvice {
	
	private final static LogUtil log = new LogUtil(InvokeTimeAdvice.class);
    @Pointcut("@annotation(executeTime)")
    public void pointCut(ExecuteTime executeTime) {
    }

    @Around("pointCut(executeTime)")
    public Object logInvokeTime(ProceedingJoinPoint joinPoint, ExecuteTime executeTime) throws Throwable {
        long start = System.currentTimeMillis();//开始时间
        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();//结束时间
            long duration = end - start;
            String methodName = joinPoint.getSignature().getName();//方法名
            log.info("【"+methodName+"】耗时："+duration+"ms");
        }
    }
}