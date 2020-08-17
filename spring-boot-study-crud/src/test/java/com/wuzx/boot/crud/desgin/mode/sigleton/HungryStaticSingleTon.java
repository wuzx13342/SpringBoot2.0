package com.wuzx.boot.crud.desgin.mode.sigleton;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.sigleton
 * @ClassName: HungryStaticSingleTon
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 11:05
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 静态代码块实现饿汉式
 */
public class HungryStaticSingleTon {

    private static HungryStaticSingleTon hungryStaticSingleTon;

    private HungryStaticSingleTon(){}

    static {
        hungryStaticSingleTon =new HungryStaticSingleTon();
    }

    public static HungryStaticSingleTon getInstance() {

        return hungryStaticSingleTon;
    }
}
