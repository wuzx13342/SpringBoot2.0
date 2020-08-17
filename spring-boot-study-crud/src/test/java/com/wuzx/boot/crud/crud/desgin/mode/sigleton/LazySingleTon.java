package com.wuzx.boot.crud.crud.desgin.mode.sigleton;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.sigleton
 * @ClassName: LazySingleTon
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 10:51
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 懒汉式单例模式(时间换空间)
 */
public class LazySingleTon {

    private static volatile LazySingleTon lazySingleTon = null;

    private LazySingleTon() {
    }

    public static LazySingleTon getInstance() {

        if (null == lazySingleTon) {
            synchronized (LazySingleTon.class) {
                if (null == lazySingleTon) {
                    lazySingleTon = new LazySingleTon();
                }
            }

        }
        return lazySingleTon;
    }



}
