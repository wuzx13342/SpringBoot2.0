package com.wuzx.boot.crud.Executors;

import java.util.concurrent.ExecutorService;

/**
 * @PackgeName: com.wuzx.boot.crud.Executors
 * @ClassName: ExcutorServiceDemoTest
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-10 17:25
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ExcutorServiceDemoTest implements Runnable{

    private static ExecutorService es =ThreadPoolExecutorDemo.newCachedThreadPool();
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            es.submit(new ExcutorServiceDemoTest());
            //es.execute(new ExcutorServiceDemoTest());

        }
        es.shutdown();
    }
}
