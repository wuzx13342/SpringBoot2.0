package com.wuzx.boot.crud.crud.Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @PackgeName: com.wuzx.boot.crud.Executors
 * @ClassName: CallableDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-10 17:36
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class CallableDemo implements Callable<String> {


    @Override
    public String call(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask =new FutureTask(callableDemo);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
