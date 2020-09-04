package org.study;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 添加应用
        tomcat.addContext("/",System.getProperty("user.dir"));

        Wrapper wrapper = tomcat.addServlet(
                "/","helloServlet",new HttpTest());
        wrapper.addMapping("/hello");

        tomcat.start();

        // 阻塞tomcat
        tomcat.getServer().await();

    }
}
