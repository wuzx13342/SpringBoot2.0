package com.wuzx.boot.crud.crud.Enable;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @PackgeName: com.wuzx.boot.crud.Enable
 * @ClassName: EnableHelloWorldBootstrap
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-13 13:06
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 启动函数
 */
@EnableHelloWorld(name="wzx",value="111")
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = applicationContext.getBean("helloWorld",String.class);

        System.out.println("Hello,World : "+helloWorld);

        applicationContext.close();
    }

}
