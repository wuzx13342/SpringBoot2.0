package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: HuaweiFactory
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:40
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: HuaweiFactory具体工厂的实现二
 */
public class HuaweiFactory implements AbstractFactory{

    @Override
    public Phone producePhone() {
        return new HuaweiPhone();
    }

    @Override
    public Computer produceComputer() {
        return new HuaweiMac();
    }
}
