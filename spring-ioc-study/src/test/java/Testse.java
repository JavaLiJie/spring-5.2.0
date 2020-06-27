import com.config.AppConfig1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring
 * @ClassName Testse
 * @description:$
 * @author: 李杰
 * @create: 2020-06-27 17:07
 * @Version 1.0
 **/

public class Testse {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig1.class);
		System.out.println(applicationContext.getBean("lj"));
		System.out.println(applicationContext.getBean("lj"));
	}

}