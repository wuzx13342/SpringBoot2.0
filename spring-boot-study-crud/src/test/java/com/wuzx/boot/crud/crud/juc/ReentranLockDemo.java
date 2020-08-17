package com.wuzx.boot.crud.crud.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: ReentranLockDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 14:02
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ReentranLockDemo {

    static Lock lock =new ReentrantLock();//可重入互斥锁

    static ReentrantReadWriteLock lock2 =new ReentrantReadWriteLock();//读写锁

    static StampedLock stampedLock  = new StampedLock();//jdk8 防止读锁过多导致线程饥饿，基于CAS实现的


    public static void main(String[] args) {

        lock.lock();
        lock.unlock();

        lock2.readLock();//读锁
        lock2.writeLock();//写锁

        stampedLock.readLock();//读锁
        stampedLock.writeLock();//写锁
    }
}
