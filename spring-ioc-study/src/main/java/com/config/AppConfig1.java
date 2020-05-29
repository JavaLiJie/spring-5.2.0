package com.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring
 * @description:配置类
 * @author: 李杰
 * @create: 2020-05-04 12:04
 * @Version 1.0
 **/

@ComponentScan("com")//将service层加载到容器中
@Configuration//将这个类作为配置类
public class AppConfig1 {

}
