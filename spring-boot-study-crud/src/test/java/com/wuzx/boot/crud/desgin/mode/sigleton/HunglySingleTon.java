package com.wuzx.boot.crud.desgin.mode.sigleton;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.sigleton
 * @ClassName: HunglySingleTon
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 10:58
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 饿汉式单例（空间换时间）
 */
public class HunglySingleTon {

    private static HunglySingleTon hunglySingleTon =new HunglySingleTon();

    private HunglySingleTon(){}

    public static HunglySingleTon getInstance() {

        return hunglySingleTon;
    }
}
