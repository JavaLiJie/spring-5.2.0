import com.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring
 * @ClassName Test3
 * @description:$
 * @author: 李杰
 * @create: 2020-05-26 20:29
 * @Version 1.0
 **/

public class Test3 {
	public static void main(String[] args) {
		//ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		System.out.println(applicationContext.getBean("user"));
	}

}