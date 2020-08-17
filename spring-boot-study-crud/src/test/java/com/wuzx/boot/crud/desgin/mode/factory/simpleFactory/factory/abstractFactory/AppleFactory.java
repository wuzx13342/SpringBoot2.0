package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: AppleFactory
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:36
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: AppleFactory具体工厂的实现一
 */
public class AppleFactory implements AbstractFactory {

    @Override
    public Phone producePhone() {
        return new Iphone();
    }

    @Override
    public Computer produceComputer() {

        return new Mac();
    }
}
