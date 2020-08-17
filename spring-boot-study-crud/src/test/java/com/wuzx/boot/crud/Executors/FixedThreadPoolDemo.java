package com.wuzx.boot.crud.Executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @PackgeName: com.wuzx.boot.crud.Executors
 * @ClassName: FixedThreadPoolDemo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-04 17:22
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class FixedThreadPoolDemo {

    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);



    public void runing() throws InterruptedException {
        List<Runnable> tasks1 = Arrays.asList(
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task1");
                },
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task2");
                });
        // 往 FixedThreadPool 中提交 tasks1。此时因为线程池的容量为1，所以两个任务由1个线程执行。
        tasks1.forEach(fixedThreadPool::submit);
        // 等待前面两个任务结束
        Thread.sleep(1000L);
        // 定义任务组 tasks2
        List<Runnable> tasks2 = Arrays.asList(
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task3");
                },
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task4");
                });
        System.out.println(fixedThreadPool instanceof ThreadPoolExecutor); // 输出 true
        // 将 ExecutorService 强转为 ThreadPoolExecutor
        ThreadPoolExecutor configurableFixedThreadPool = (ThreadPoolExecutor) fixedThreadPool;
        // 改变容量
        configurableFixedThreadPool.setCorePoolSize(2);
        // 提交任务组 tasks2。此时由于线程池的容量变成了2，所以tasks2中的两个任务将分别由不同的线程执行（极端情况下也可能由一个线程执行，但此时线程池容量切切实实变成了2）。
        tasks2.forEach(fixedThreadPool::submit);
        // 关闭线程池
        fixedThreadPool.shutdown();
        // 等待任务执行结束
        fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
    }

    public static void main(String[] args) throws InterruptedException {
        FixedThreadPoolDemo  fixedThreadPoolDemo =new FixedThreadPoolDemo();
        fixedThreadPoolDemo.runing();
    }
}
