import com.AppConfig;
import com.bean.UserImportBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring
 * @ClassName ImportTest
 * @description:$
 * @author: 李杰
 * @create: 2020-05-30 14:32
 * @Version 1.0
 **/


public class ImportTest {

	@Test
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		//获取import注册的bean
		System.out.println(applicationContext.getBean(UserImportBean.class));
	}

}