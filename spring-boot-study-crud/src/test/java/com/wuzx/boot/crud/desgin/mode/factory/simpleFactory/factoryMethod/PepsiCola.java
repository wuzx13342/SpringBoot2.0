package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod
 * @ClassName: PepsiCola
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:08
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:.PepsiCola继承Cola，是要生产的产品之一
 */
public class PepsiCola extends Cola{
    @Override
    protected void drinks() {
        System.out.println("drinks PepsiCola");
    }
}
