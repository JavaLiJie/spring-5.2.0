package com.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @ClassName MyBeanFactoryPostProcessor
 * @description:$
 * @author: 李杰
 * @create: 2020-05-26 20:27
 * @Version 1.0
 **/

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//修改普通bean的beanclass，来修改bean的类型
		BeanDefinition user = beanFactory.getBeanDefinition("user");
		user.setBeanClassName("com.bean.NewUser");
	}
}