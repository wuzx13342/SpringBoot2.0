package com.wuzx.boot.crud.crud.desgin.mode.proxy;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.proxy
 * @ClassName: Proxy
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 16:38
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:代理lei
 */
public class Proxy implements ISubject {


    private ISubject iSubject;

    public Proxy(ISubject iSubject){
        this.iSubject=iSubject;
    }

    public void request() {
        before();
        iSubject.request();
        after();
    }

    public void before(){
        System.out.println("called before request()");
    }

    public void after(){
        System.out.println("called before request()");
    }

    public static void main(String[] args) {
        Proxy proxy =new Proxy(new RealSubject());
        proxy.request();
    }
}
