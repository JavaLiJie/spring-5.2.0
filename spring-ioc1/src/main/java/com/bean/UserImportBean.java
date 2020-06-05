package com.bean;

/**
 * @program: spring
 * @ClassName UserImportBean
 * @description:学习import注解
 * @author: 李杰
 * @create: 2020-05-30 14:21
 * @Version 1.0
 **/

public class UserImportBean {
	private String name;
	private String age;

	public UserImportBean() {
		System.out.println("UserImportBean无参构造");
	}

	public UserImportBean(String name, String age) {
		this.name = name;
		this.age = age;
		System.out.println("UserImportBean有参构造");
	}

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