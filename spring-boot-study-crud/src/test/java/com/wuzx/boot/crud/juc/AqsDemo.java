package com.wuzx.boot.crud.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: AqsDemo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-11 15:04
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 基于AQS实现锁
 */
public class AqsDemo extends AbstractQueuedSynchronizer {

    public boolean lock() {
        return tryAcquire(1);
    }

    public boolean unlock() {
        return tryRelease(1);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        for (; ; ) {
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    System.out.println("当前获得锁的线程:" + Thread.currentThread());
                    return true;
                }
            }

        }
    }

    @Override
    protected boolean tryRelease(int arg) {
        if (getExclusiveOwnerThread() != Thread.currentThread()) {
            throw new IllegalMonitorStateException();
        } else {
            setState(getState() - 1);
            if (getState() == 0) {
                setExclusiveOwnerThread(null);
                System.out.println("当前释放锁的线程:" + Thread.currentThread());
            } else if (getState() <= 0) {
                throw new IllegalMonitorStateException();

            }
        }
        return true;
    }

    public static int sum = 0;

    public static void main(String[] args) {
        AqsDemo lock = new AqsDemo();
        Runnable runnable = () -> {
            lock.lock();
            sum += 1;
            System.out.println(sum);
            lock.unlock();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }
}
