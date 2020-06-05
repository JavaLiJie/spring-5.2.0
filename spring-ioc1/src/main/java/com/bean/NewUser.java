package com.bean;

/**
 * @program: spring
 * @ClassName NewUser
 * @description:$
 * @author: 李杰
 * @create: 2020-05-26 20:28
 * @Version 1.0
 **/


public class NewUser {
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

	public NewUser() {
		System.out.println("NewUser无参构造执行");
	}

}