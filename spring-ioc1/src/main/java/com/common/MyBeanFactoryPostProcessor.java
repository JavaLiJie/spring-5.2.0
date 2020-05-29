package com.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @program: spring
 * @ClassName MyBeanFactoryPostProcessor
 * @description:$
 * @author: 李杰
 * @create: 2020-05-26 20:27
 * @Version 1.0
 **/

public class MyBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) registry.getBeanDefinition("user");
		beanDefinition.setBeanClassName("com.bean.NewUser");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/*GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
		beanDefinition.setBeanClassName("com.bean.NewUser");*/
	}


	/*@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
		beanDefinition.setBeanClassName("com.bean.NewUser");
	}*/
}