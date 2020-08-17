package com.wuzx.boot.crud.crud.desgin.mode.dependency;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.dependency
 * @ClassName: AICourse
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 16:50
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class AICourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom学习AI");
    }
}
