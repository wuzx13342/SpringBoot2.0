package com.wuzx.boot.crud.crud.desgin.mode.decorator;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.decorator
 * @ClassName: BaseBatterCake
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 15:13
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:基础类
 */
public class BaseBatterCake extends BatterCake{


    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
