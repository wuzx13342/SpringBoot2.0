package com.wuzx.boot.crud.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: HuaweiMac
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:41
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 具体的产品实现
 */
public class HuaweiMac extends Computer {
    @Override
    public void work() {
        System.out.println("HuaweiMac work");
    }
}
