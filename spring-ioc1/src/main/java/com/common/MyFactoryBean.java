package com.common;

import com.bean.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @ClassName MyFactoryBean
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:22
 * @Version 1.0
 **/

@Component
public class MyFactoryBean implements FactoryBean<Object> {


	@Override
	public Object getObject() throws Exception {
		System.out.println("MyFactoryBean---getObject()");
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}