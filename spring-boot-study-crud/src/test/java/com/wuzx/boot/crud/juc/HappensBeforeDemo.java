package com.wuzx.boot.crud.juc;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: HappensBeforeDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-05 23:00
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class HappensBeforeDemo {

    public static void main(String[] args) {
        int a =1;
        int b =2;

        try {
            a=3;
            b=1/0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("a = " +a);
        }
    }
}
