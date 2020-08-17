package com.wuzx.boot.crud.desgin.mode.factory.simpleFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory
 * @ClassName: Client
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 11:15
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:应用层
 */
public class Client {
    public static void main(String[] args) {
        DrinksFactory factory = new DrinksFactory();
        Wahaha wahaha = (Wahaha) factory.produceDrink(Wahaha.class);
        wahaha.produce();
    }
}
