/*
import ccom.bean.TestBean1;
import com.config.AppConfig1;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

*/
/**
 * @program: spring
 * @ClassName SpringTest2
 * @description:研究bean实例化原理$
 * @author: 李杰
 * @create: 2020-05-07 18:16
 * @Version 1.0
 **//*


public class SpringTest2 {

	@Test
	public void test(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
		TestBean1 testBean1 = (TestBean1) applicationContext.getBean("testBean1");
		TestBean1 testBean2 = (TestBean1) applicationContext.getBean("testBean2");
		//TestBean1 bean = applicationContext.getBean(TestBean1.class);//当配置两个时，就不能使用类型获取了，因为spring容器也不知道你需要哪一个。

	}
	@Test//模拟底层源码
	public void test2(){
		//创建简单注册器
		//BeanDefinitionRegistry beanDefinitionRegistry=new SimpleBeanDefinitionRegistry();
		//创建实现了注册器接口的工厂：一个成熟的bean factory，基于bean定义元数据，可通过后置处理器扩展
		//这个类中有存放映射的map：private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
		BeanDefinitionRegistry beanDefinitionRegistry=new DefaultListableBeanFactory();

		//创建读取器
		BeanDefinitionReader reader=new XmlBeanDefinitionReader(beanDefinitionRegistry);
		//读取放到映射中的bean
		reader.loadBeanDefinitions("spring2.xml");
		String[] beanDefinitionNames = beanDefinitionRegistry.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
			BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanDefinitionName);
			System.out.println(beanDefinition.toString());
			*/
/* class [com.bean.TestBean1]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0;
			autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null;
			 destroyMethodName=null; defined in class path resource [spring2.xml]*//*

		}

		//注册器是bean工厂类型的DefaultListableBeanFactory,就可以直接getbean来获取bean
		TestBean1 testBean1= (TestBean1) ((DefaultListableBeanFactory)beanDefinitionRegistry).getBean("testBean1");
	}


	@Test
	public void test3(){
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig1.class);
		//拿到实现注册器的bean工厂：DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) applicationContext).getDefaultListableBeanFactory();
		//直接进行注册，不用在类上加注解
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestBean1.class);
		defaultListableBeanFactory.registerBeanDefinition("testBean1",rootBeanDefinition);
		//对beandefinition进行设置属性值
		rootBeanDefinition.getPropertyValues().add("age","18");
		//注册后就可以到容器中拿到
		TestBean1 testBean1 = (TestBean1) defaultListableBeanFactory.getBean("testBean1");
		System.out.println("sssss"+testBean1.getAge());//sssss18

	}

}*/
