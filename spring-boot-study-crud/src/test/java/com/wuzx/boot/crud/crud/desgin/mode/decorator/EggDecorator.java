package com.wuzx.boot.crud.crud.desgin.mode.decorator;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.decorator
 * @ClassName: EggDecorator
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 15:23
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:鸡蛋装饰器
 */
public class EggDecorator extends BatterCakeDecorator {


    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
