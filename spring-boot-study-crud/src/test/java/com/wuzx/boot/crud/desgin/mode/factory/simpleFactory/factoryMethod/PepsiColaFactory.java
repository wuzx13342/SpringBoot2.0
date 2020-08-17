package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod
 * @ClassName: PepsiColaFactory
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:12
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: PepsiColaFactory定义子类工厂，它继承抽象工厂，实现了对某一产品等级的产品的获得
 */
public class PepsiColaFactory implements ColaFactory {
    @Override
    public Cola produce(Class<Cola> cola) {
        if(cola.isInstance(PepsiCola.class)){
            return new PepsiCola();
        }
        return null;
    }
}
