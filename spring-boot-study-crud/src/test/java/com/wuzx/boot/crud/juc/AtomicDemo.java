package com.wuzx.boot.crud.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: AtomicDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-09 21:23
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 原子操作类 主要是通过 unsafe类里面的cas操作
 */
public class AtomicDemo {

    static  int count;

    static AtomicInteger atomicInteger=new AtomicInteger(0);

    //生成递增的序号
    static void incr(){
        atomicInteger.incrementAndGet();
        count++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(AtomicDemo::incr).start();
            System.out.println(count);
        }
    }
}
