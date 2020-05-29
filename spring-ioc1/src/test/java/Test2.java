import com.AppConfig;
import org.junit.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @program: spring
 * @ClassName Test2
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 21:06
 * @Version 1.0
 **/

public class Test2 {

	@Test
	public void test(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext();
		BeanDefinitionRegistry beanDefinitionRegistry=new SimpleBeanDefinitionRegistry();
		BeanDefinitionReader reader=new XmlBeanDefinitionReader(beanDefinitionRegistry);
		reader.loadBeanDefinitions("spring.xml");
		String[] beanDefinitionNames = beanDefinitionRegistry.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

	}

}