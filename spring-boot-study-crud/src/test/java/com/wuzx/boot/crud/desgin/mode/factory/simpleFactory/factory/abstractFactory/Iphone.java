package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: Iphone
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:37
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: Iphone具体产品一
 */
public class Iphone extends Phone{
    @Override
    public void call() {
        System.out.println("Iphone Call");
    }
}
