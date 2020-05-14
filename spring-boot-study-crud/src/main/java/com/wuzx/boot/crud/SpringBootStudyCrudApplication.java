package com.wuzx.boot.crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 主启动类
 */
// 扫描 Mapper 接口
@MapperScan("com.wuzx.boot.crud.mapper")
@SpringBootApplication
public class SpringBootStudyCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyCrudApplication.class, args);
    }

}
