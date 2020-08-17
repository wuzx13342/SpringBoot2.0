package com.wuzx.boot.crud.desgin.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.proxy
 * @ClassName: JdkMeipo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 17:22
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:jdk动态代理
 */
//JDK动态代理实现InvocationHandler接口
public class JdkMeipo implements InvocationHandler {

    private IPerson target;//需要代理的目标对象

    public IPerson getInstance(IPerson target){
        //为目标对象target赋值
        this.target = target;
        Class<?> clazz = target.getClass();
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    //定义获取代理对象方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }
    void after(){
        System.out.println("双方同意,开始交往");
    }
    void before(){
        System.out.println("我是媒婆,已经收集到你们的需求,开始物色");
    }

    public static void main(String[] args) {
        //实例化JDKProxy对象
        JdkMeipo jdkMeipo =new JdkMeipo();
        //获取代理对象
        IPerson zhangsan = jdkMeipo.getInstance(new ZhangSan());
        //执行新增方法
        zhangsan.findLove();

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();

    }
}
