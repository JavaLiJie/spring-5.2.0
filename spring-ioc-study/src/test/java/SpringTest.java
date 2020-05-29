/*

//import com.bean.Lj;
//import com.bean.Lj2;
import com.applicationContextStudy.myApplicationContextAware;
import com.bean.LiYaYuan;
import com.bean.Lj;
//import com.config.AppConfig1;
import com.bean.LjByName;
import com.config.AppConfig2;
//import com.service.UserService;
import com.config.AppConfig3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

*/
/**
 * @program: spring
 * @description:测试类
 * @author: 李杰
 * @create: 2020-05-04 12:27
 * @Version 1.0
 **//*



public class SpringTest {
	@Test
	public void test(){
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring1.xml");
		*/
/*ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig1.class);
		Lj lj = (Lj) applicationContext.getBean("lj");
		lj.setName("AAA");
		System.out.println(lj.toString());
		UserService userService = (UserService) applicationContext.getBean("userService");
		UserService userService1 = new UserService(lj);*//*

		//userService.test();

		//System.out.println(applicationContext.getBean("myFactoryBean"));//Lj
		//System.out.println(applicationContext.getBean("&myFactoryBean"));//MyFactoryBean
		//涉及到factorybean实现类的获取时， 只有前面有&符号才会不处理，直接返回这个对应的bean。否则会去调这个factorybean的getobject方法

		//ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig2.class);
		//Lj2 lj2 = (Lj2) applicationContext.getBean("getLj2");//@bean 默认返回值会以 方法名 作为bean的name放到容器中。
		//Lj2 lj2 = (Lj2) applicationContext.getBean("aaa");//@bean(name="aaa") 也可以通过name指定放到容器中的name
		//Lj2 lj2 = applicationContext.getBean(Lj2.class);//或者直接根据类型到容器中获取
		//System.out.println(lj2);
		//applicationContext.getBean(SuperLj.class);

		*/
/*使用通用applicationcontext类：GenericApplicationContext
		* 再根据bean定义的方式，选用不同的BeanDefinitionReader实现类，来读取不同格式的bean定义
		* 调用refresh就可以完成初始化。最后就可以用GenericApplicationContext来获取bean
		* BeanDefinitionReader：顶层接口，bean定义阅读器
		* *//*


		GenericApplicationContext ctx = new GenericApplicationContext();
		//定义读取器
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
		PropertiesBeanDefinitionReader propReader = new PropertiesBeanDefinitionReader(ctx);
		//读取配置文件
		xmlReader.loadBeanDefinitions(new ClassPathResource("spring1.xml"));
		propReader.loadBeanDefinitions(new ClassPathResource("otherBeans.properties"));
		ctx.refresh();
		myApplicationContextAware myApplicationContextAware = (myApplicationContextAware) ctx.getBean("myApplicationContextAware");

		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig2.class);
		//Lj lj = (Lj) applicationContext.getBean("lj");MyImportSelector配置的lj无法通过name来获取，No bean named 'lj' available
		Lj bean = applicationContext.getBean(Lj.class);
		//MyImportBeanDefinitionRegistrar配置的LjByName可以通过类型或者name来获取
		LjByName bean1 = applicationContext.getBean(LjByName.class);
		LjByName bean2 = (LjByName)applicationContext.getBean("ljByName");

		ApplicationContext applicationContext3=new AnnotationConfigApplicationContext(AppConfig3.class);
		LiYaYuan liYaYuan = (LiYaYuan) applicationContext3.getBean("liYaYuan");
		*/
/*Lijie无参构造+++++++
		  LiYaYuan无参构造+++++++
		  结合打印的日志可知，会先等LiYaYuan条件里面引用的类Lijie先注入，然后再注入自己
		  如果将条件里的Lijie类没有写注入的方法，就会导致报错No bean named 'liYaYuan' available*//*



	}

}*/
