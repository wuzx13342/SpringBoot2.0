package com.wuzx.boot.crud.crud.juc;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: VolatileDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-06 10:33
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class VolatileDemo {

    int i = 0;
    volatile boolean flag = false;

    public void write() {
        i = 2;
        flag = true;
    }

    public void read() {
        if (flag){
            System.out.println("---i = " + i);
        }
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo =new VolatileDemo();
        volatileDemo.write();
        volatileDemo.read();

    }

}




