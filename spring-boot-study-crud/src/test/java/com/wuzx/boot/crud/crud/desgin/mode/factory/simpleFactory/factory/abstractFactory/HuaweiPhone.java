package com.wuzx.boot.crud.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: HuaweiPhone
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:41
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class HuaweiPhone extends Phone {
    @Override
    public void call() {
        System.out.println("Huaweiphone call");
    }
}
