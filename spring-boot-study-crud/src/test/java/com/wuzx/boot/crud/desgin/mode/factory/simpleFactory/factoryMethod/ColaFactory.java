package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod
 * @ClassName: ColaFactory
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:10
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: ColaFacotry定义抽象工厂，指定要生产此类产品的规范（存在的方法与属性），指定工厂方法
 */
public interface ColaFactory {

    Cola produce(Class<Cola> cola);
}
