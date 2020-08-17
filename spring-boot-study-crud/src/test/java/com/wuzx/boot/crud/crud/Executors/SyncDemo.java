package com.wuzx.boot.crud.crud.Executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PackgeName: com.wuzx.boot.crud.Executors
 * @ClassName: SyncDemo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-17 09:06
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class SyncDemo {

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);


    public static synchronized void test1(){
        System.out.println("方法1被执行完毕，当前线程: "+Thread.currentThread().getName());
    }

    public  static synchronized void test2(){
        System.out.println("方法2被执行完毕,当前线程: "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        List<Runnable> tasks1 = Arrays.asList(
                () -> {
                    test1();
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task1");
                },
                () -> {
                    test2();
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task2");
                });
        // 往 FixedThreadPool 中提交 tasks1。此时因为线程池的容量为1，所以两个任务由1个线程执行。
        tasks1.forEach(fixedThreadPool::submit);
    }
}
