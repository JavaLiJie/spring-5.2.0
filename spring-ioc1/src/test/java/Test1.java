import com.AppConfig;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring
 * @ClassName Test1
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:25
 * @Version 1.0
 **/

public class Test1 {

	@Test
	public void test(){
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println("userService.getUser()---***"+userService.getUser());
		System.out.println("userService.getUser()---***"+userService.getUseList());
		System.out.println("测试git上传-微星");
		System.out.println("测试git上传-RedminBook");
	}

}