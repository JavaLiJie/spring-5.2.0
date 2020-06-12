import com.bean.Lj;
import com.bean.Lj2;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @program: spring
 * @ClassName Test
 * @description:$
 * @author: 李杰
 * @create: 2020-06-03 23:50
 * @Version 1.0
 **/

public class Test {

	@org.junit.Test
	public static void main(String[] args) {
		ResourceLoader resourceLoader=new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("spring1.xml");
		//获取核心类DefaultListableBeanFactory
		DefaultListableBeanFactory registryBeanFactory= new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(registryBeanFactory);
		beanDefinitionReader.loadBeanDefinitions(resource);

		//创建BeanDefinition注册到 DefinitionMap
		registryBeanFactory.registerBeanDefinition("lj",new RootBeanDefinition(Lj.class));

		System.out.println(registryBeanFactory.getBean("lj"));

		//创建bean注册到单例池
		registryBeanFactory.registerSingleton("lj2",new Lj2());

		//获取DefinitionMap的所有Definition
		String[] beanDefinitionNames = registryBeanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("beanDefinitionName"+beanDefinitionName);
		}

		//获取单例池中的bean
		String[] singletonNames = registryBeanFactory.getSingletonNames();
		for (String singletonName : singletonNames) {
			System.out.println("singletonName"+singletonName);
		}
	}

}