package com;

import com.bean.User;
import com.common.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: spring
 * @ClassName AppConfig
 * @description:$
 * @author: 李杰
 * @create: 2020-05-24 15:25
 * @Version 1.0
 **/

@ComponentScan("com")
@Configuration
@Import(MyImportSelector.class)//通过import将选择器注册到spring
public class AppConfig {

	@Bean//方法bean，注册时没有beanclass，而是通过factorymethod属性调用getbean
	public User user() {return new User();}

}