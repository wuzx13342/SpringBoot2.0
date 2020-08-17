package com.wuzx.boot.crud.crud.desgin.mode.decorator;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.decorator
 * @ClassName: BatterCakeTest
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 15:27
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:测试类
 */
public class BatterCakeTest {

    public static void main(String[] args) {

        BatterCake batterCake;

        batterCake = new BaseBatterCake();

        batterCake =new EggDecorator(batterCake);

        batterCake = new EggDecorator(batterCake);

        batterCake= new SausageDecorator(batterCake);

        batterCake= new SausageDecorator(batterCake);



        System.out.println(batterCake.getMsg()+  ",总价：" + batterCake.getPrice());
    }
}
