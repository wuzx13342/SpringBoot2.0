package com.wuzx.boot.crud.desgin.mode.dependency;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.dependency
 * @ClassName: JavaCourse
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 16:48
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class JavaCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom学习java");
    }
}
