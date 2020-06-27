package com.common;

import com.bean.Lj;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring
 * @ClassName MyImportBeanDefinitionRegistrar
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:13
 * @Version 1.0
 **/

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(Lj.class);
		registry.registerBeanDefinition("lj",rootBeanDefinition);
	}
}