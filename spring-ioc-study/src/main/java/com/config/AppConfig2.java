package com.config;

import com.bean.*;
import com.common.MyImportBeanDefinitionRegistrar;
import com.common.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: spring
 * @ClassName AppConfig2
 * @description:@bean和@Configuration
 * @author: 李杰
 * @create: 2020-05-06 16:20
 * @Version 1.0
 **/

@Configuration
//官方文档建议将原来的bean标签xml配置用Java配置来代替。
//Java配置通常@Bean在@Configuration类中使用带注释的方法，保证@bean对应的实体类是单例的。 还可以与@lazy联用，进行延迟加载初始化。
/*@Configuration将AppConfig2类变成cglib代理类类型的，从而通过ConfigurationClassEnhancer的intercept方法，来获取FactoryBean，并对要实例化的对象进行判断，是否是factorybean类型的还是普通类：
-->最后进一步调用ConfigurationClassEnhancer的resolveBeanReference来通过getbean判断是否容器中单例池中已存在这个bean来保证单例*/
//@Import(AppConfig1.class)//注解方式：将其他配置类加载进来
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})//注解方式：将其他配置类加载进来
/*根据@import源码，可知有两种自带的方式，实现ImportSelector来达到byType的方式获取bean
 * 实现ImportBeanDefinitionRegistrar来给beanName和beanDefinition建立映射
 */

public class AppConfig2 {

	@Bean//(name = "aaa") //这种方式拿到的bean是方法bean，官方推荐用这种方法替换调bean标签配置的。 默认返回值会以 方法名 作为bean的name放到容器中。
	public Lj2 getLj2(){
		return new Lj2();
	}

	@Bean
	public SuperLj getSuperLj(){
		//连着调用两次，看li2是否是单例。如果有@Configuration，构造函数只会调一次，单例
		//如果没有@Configuration，构造函数每次都会调用，多列bean
		System.out.println(getLj2()+"第一次调构造方法");
		return new SuperLj(getLj2());
	}
}