package com.wuzx.boot.crud.crud.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: ConditionNotifyDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 16:25
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ConditionNotifyDemo implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionNotifyDemo(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();//竞争锁
            System.out.println("begin - ConditionNotify 2—A");
            condition.signal();//唤醒阻塞的线程
            System.out.println("end - ConditionSignal 2-B");
        } finally {
            lock.unlock();
        }

    }
}
