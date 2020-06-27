package com.bean;

import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @ClassName Lj
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:09
 * @Version 1.0
 **/

@Component
public class Lj {
private String name;
private String age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}