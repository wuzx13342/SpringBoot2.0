package com.wuzx.boot.crud.desgin.mode.proxy;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.proxy
 * @ClassName: RealSubject
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 16:29
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:代理简单实现
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {

        System.out.println("real service is called");
    }
}
