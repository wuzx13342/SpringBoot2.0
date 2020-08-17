package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: Mac
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:38
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:  Mac具体产品一
 */
public class Mac extends Computer{
    @Override
    public void work() {
        System.out.println("Mac work");
    }
}
