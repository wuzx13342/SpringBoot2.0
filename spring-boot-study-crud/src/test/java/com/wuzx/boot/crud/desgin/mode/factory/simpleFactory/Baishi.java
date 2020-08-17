package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory
 * @ClassName: Baishi
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 11:09
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 具体产品百事可乐
 */
public class Baishi extends Drinks{

    @Override
    protected void produce() {
        System.out.println("drinks Baishi");
    }
}
