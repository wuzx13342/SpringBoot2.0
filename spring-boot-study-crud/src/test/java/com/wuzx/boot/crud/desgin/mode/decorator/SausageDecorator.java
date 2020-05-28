package com.wuzx.boot.crud.desgin.mode.decorator;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.decorator
 * @ClassName: SausageDecorator
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 15:25
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:香肠装饰器
 */
public class SausageDecorator extends BatterCakeDecorator{

    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }


    @Override
    protected String getMsg() {
        return super.getMsg()+"+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+2;
    }
}
