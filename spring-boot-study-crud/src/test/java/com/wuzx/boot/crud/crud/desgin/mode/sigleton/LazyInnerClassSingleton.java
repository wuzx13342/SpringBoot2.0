package com.wuzx.boot.crud.crud.desgin.mode.sigleton;

import java.lang.reflect.Constructor;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.sigleton
 * @ClassName: LazyInnerClassSingleton
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 11:08
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:静态内部类的实现懒汉式(最牛逼的单例写法)
 */
public class LazyInnerClassSingleton {
    //默认先初始化内部类 如果没有使用，则内部类不会加载
    private LazyInnerClassSingleton() {

        if(LazyHolder.LAZY != null){

            throw new  RuntimeException("不允许创建多个实例！");
        }
    }

    //static是为了使单例的空间共享 保证这个方法不会被重写重载
    private static final LazyInnerClassSingleton getInstance() {
        //返回结果之前肯定会加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }


    public static void main(String[] args) {

        try {
            Class<?> clazz = EnumSingleton.class;

            Constructor c =clazz.getDeclaredConstructor(null);

            c.setAccessible(true);

            Object o1 =c.newInstance();

            Object o2 =c.newInstance();

            System.out.println(o1==o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
