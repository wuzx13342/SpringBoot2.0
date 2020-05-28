package com.wuzx.boot.crud.desgin.mode.decorator;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.decorator
 * @ClassName: BatterCake
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 15:11
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:装饰器模式
 */
public abstract class BatterCake {

    protected abstract String getMsg();

    protected abstract int getPrice();

    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b =100;

        Integer c = Integer.valueOf(128);
        Integer d = 128;

        System.out.println("a==b: " + (a==b));

        System.out.println("c==d: " + (c==d));

    }
}
