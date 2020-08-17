package com.wuzx.boot.crud.juc;


/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: SycnDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 13:57
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class SycnDemo2{

    public synchronized void demo(){
        System.out.println("demo");
        demo2();
    }

    private void demo2() {
        synchronized (this){
            System.out.println("demo2");
        }
    }

    public static void main(String[] args) {
        SycnDemo2 syncDemo = new SycnDemo2();
        syncDemo.demo();
    }
}
