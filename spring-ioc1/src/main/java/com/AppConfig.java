package com;

import com.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
public class AppConfig {

	@Bean
	public User user() {return new User();}

}