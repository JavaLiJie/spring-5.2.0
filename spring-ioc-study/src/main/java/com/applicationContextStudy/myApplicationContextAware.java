package com.applicationContextStudy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: spring
 * @ClassName myApplicationContextAware
 * @description:实现ApplicationContextAware$
 * @author: 李杰
 * @create: 2020-05-04 13:06
 * @Version 1.0
 **/

public class myApplicationContextAware implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("执行setApplicationContext"+applicationContext);
	}
}