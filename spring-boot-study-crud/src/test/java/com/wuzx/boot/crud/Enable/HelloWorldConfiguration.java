package com.wuzx.boot.crud.Enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackgeName: com.wuzx.boot.crud.Enable
 * @ClassName: HelloWorldConfiguration
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-13 13:01
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "hello,World,2020";
    }
}
