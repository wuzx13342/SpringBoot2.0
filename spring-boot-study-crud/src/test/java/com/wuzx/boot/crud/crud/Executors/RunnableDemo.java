package com.wuzx.boot.crud.crud.Executors;

import java.util.concurrent.*;

/**
 * @PackgeName: com.wuzx.boot.crud.Executors
 * @ClassName: RunnableDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-10 09:13
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class RunnableDemo  implements Runnable {

    private static final int corePoolSize = 3;

    private static final int maxPoolSize = 3;

    private static final int capacity = 20;

    private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.DiscardPolicy();

    private static ExecutorService executorService1 = Executors.newSingleThreadExecutor();

    private static ExecutorService executorService2 = Executors.newFixedThreadPool(2);

    private static ExecutorService executorService3 = Executors.newCachedThreadPool();

    private static ExecutorService executorService4 = Executors.newScheduledThreadPool(3);

    private static ExecutorService executorService5 = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 5L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(capacity), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
           Thread t =new Thread(r);
            System.out.println("我是自定义线程工厂: " +r);
            return t;
        }
    }, defaultHandler);



    @Override
    public void run() {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            executorService3.execute(new RunnableDemo());
        }
        executorService3.shutdown();
    }

}
