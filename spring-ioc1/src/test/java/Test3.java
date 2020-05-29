import com.bean.NewUser;
import com.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user);
	}

}