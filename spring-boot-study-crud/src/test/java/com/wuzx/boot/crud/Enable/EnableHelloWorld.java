package com.wuzx.boot.crud.Enable;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * @PackgeName: com.wuzx.boot.crud.Enable
 * @ClassName: EnableHelloWorld
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-13 12:35
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: @Enable 模块注解基于接口实现
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.TYPE})
@Documented
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

    String name();

    String value();
}
