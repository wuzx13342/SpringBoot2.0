package com.wuzx.boot.crud.desgin.mode.decorator;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.decorator
 * @ClassName: BatterCakeDecorator
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 15:14
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:抽象装饰器
 */
public abstract class BatterCakeDecorator extends BatterCake{

    //静态代理、委派
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake){
        this.batterCake =batterCake;
    }

    protected  abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.batterCake.getPrice();
    }
}
