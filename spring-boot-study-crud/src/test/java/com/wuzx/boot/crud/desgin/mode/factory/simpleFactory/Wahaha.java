package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory
 * @ClassName: Wahaha
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 11:10
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:具体产品娃哈哈
 */
public class Wahaha extends Drinks{

    @Override
    protected void produce() {
        System.out.println("drink Wahaha");
    }
}
