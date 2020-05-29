/*
package com.config;

import ccom.bean.LiYaYuan;
import ccom.bean.Lijie;
import ccom.bean.MyConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @program: spring
 * @ClassName AppConfig3
 * @description:学习@Conditional 条件装配$
 * @author: 李杰
 * @create: 2020-05-07 17:01
 * @Version 1.0
 **//*


@Configuration
public class AppConfig3 {

	@Bean(name = "lijie")
	public Lijie getLijie(){
		return new Lijie();
	}//如果将这部分注掉，就会导致下面的条件无法成立，而报错。

	@Bean(name = "liYaYuan")
	@Conditional(value = MyConditional.class)//当MyConditional类的条件判断为true才会调这个方法进行注入LiYaYuan
	public LiYaYuan getLiYaYuan(){
		return new LiYaYuan();
	}
}*/
