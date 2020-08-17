package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factoryMethod
 * @ClassName: CoCoCola
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:09
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:CoCoCola同样继承Cola，也是要生产的产品之一
 */
public class CoCoCola extends Cola {

    @Override
    protected void drinks() {
        System.out.println("drinks CoCoCola");
    }
}
