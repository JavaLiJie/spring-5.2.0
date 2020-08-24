package annotation;

import java.lang.annotation.*;

/**
 * 方法调用前后、异常及结果返回时记录日志
 * @author hlc
 *
 */
@Target({ElementType.TYPE})//注解用在类上
@Retention(RetentionPolicy.RUNTIME)//注解在运行时保留
@Documented//指定javadoc生成API文档时显示该注解信息
public @interface InvokeLog {

}
