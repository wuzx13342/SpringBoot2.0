package com.wuzx.boot.crud.crud.desgin.mode.proxy;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.proxy
 * @ClassName: ZhangSan
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 17:29
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ZhangSan implements IPerson {
    @Override
    public void findLove() {
        System.out.println("张三要求：长的高");
    }
}
