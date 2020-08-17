package com.wuzx.boot.crud.crud.desgin.mode.proxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.proxy
 * @ClassName: CglibMeipo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 09:23
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
//Cglib动态代理，实现MethodInterceptor接口
public class CglibMeipo implements MethodInterceptor {

    //定义获取代理对象方法
    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    //重写拦截方法
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);//方法执行，参数：target 目标对象 arr参数数组
        after();
        return obj;
    }


    void after(){
        System.out.println("如果合适的话就准备办事");
    }
    void before(){
        System.out.println("我是媒婆:我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    public static void main(String[] args) {
        try {
            Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
