package com.wuzx.boot.crud.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: AbstractFactory
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:31
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 抽象工厂
 */
public interface AbstractFactory {

    public Phone producePhone();

    public Computer produceComputer();
}
