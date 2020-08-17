package com.wuzx.boot.crud.crud.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: ConditionDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 16:21
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: TODO condition#condition.await();必须在lock 和 unlock之间执行
 */
public class ConditionWaitDemo implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionWaitDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();//竞争锁
            try {
                System.out.println("begin -  ConditionWait 1-A");
                condition.await();//阻塞 必须在锁之间使用
                System.out.println("end -  ConditionWait 1-B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
