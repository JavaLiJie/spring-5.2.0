package com.service;


import com.bean.Lj;
import com.bean.Lj;
import org.springframework.stereotype.Component;


/**
 * @program: spring
 * @description:学习注解注入
 * @author: 李杰
 * @create: 2020-05-04 12:12
 * @Version 1.0
 **/


@Component
public class UserService {


	//@Resource//package javax.annotation;根据注解类所属包名，是spring集成：jdk提供的注解
	/*@Target({TYPE, FIELD, METHOD})
	* TYPE: 类、接口(包括注释类型)或enum声明
	* FIELD:字段声明(包括enum常量)
	* METHOD:方法声明*/
	//@Resource(name = "lj")
	//private Lj a;

	/*public void test(){
		System.out.println(a.toString()+"++++++++++++++++");
	}*/
	/*@Autowired 无法修饰Map，必须是实体类
	private Map<String,String> map;*/
	//package org.springframework.beans.factory.annotation;根据注解类所属包名，可知是spring自己的。
	/*@Target({CONSTRUCTOR,METHOD,PARAMETER,FIELD,ANNOTATION_TYPE})
	* CONSTRUCTOR:构造函数声明
	* METHOD:方法声明
	* PARAMETER:正式的参数声明
	* FIELD:字段声明(包括enum常量)
	* ANNOTATION_TYPE: 注解类型声明
	* */
	/*public UserService() {
		//不能在构造方法就操作lj，因为启动时，初始化容器时，上面的lj可能还没注入到UserService中。
		lj.setName("aaa");//会在这报空指针。
		System.out.println(lj.toString());
	}*/
	public UserService(Lj aaa) {
		/*因为@Autowired可以直接用于参数，这样直接在方法体执行先，先让LJ注入进来，就可以避免了上面的问题
		 *如果下面的无参构造函数没有，只有这一个构造函数，那么这里参数上就可以不加@Autowired，因为当容器加载时，这个类被加注解要被扫描，
		 * 发现这个类只有这一个构造器，默认会调这个构造函数进行注入，参数如果引用了其他类Lj，就可以会自动将容器里的Lj注入到这个类里(当然前提是Lj这个类被加载到容器里了)。
		 * 有无参构造就会调无参构造，不调这个。
		 * */
		aaa.setName("aaa");
		System.out.println(aaa.toString()+"****************有参");
	}

	public UserService() {
		System.out.println("无参");
	}
}
