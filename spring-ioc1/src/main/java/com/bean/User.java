package com.bean;

import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @ClassName User
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:20
 * @Version 1.0
 **/

/*@Component*/
public class User {
private String name;
private String age;

	public User() {
		System.out.println("无参构造执行");
	}
}