package com.common;

import com.bean.User;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
   //该方法获取到registry，就可以自定义注册到容器各种bean。
    @Override
   public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
      //创建BeanDefinition
      RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(User.class);
      //对bean的属性进行设置
      rootBeanDefinition.getPropertyValues().addPropertyValue("name","xiaoming");

   }
}