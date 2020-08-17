package com.wuzx.boot.crud.juc;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: ConditionTest
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-07 14:35
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 *  TODO 　1.概述  在java1.5之前，线程之间的通信主要通过notify和wait。
 *   而Condition支持多路等待，就是定义多个Condition，每个Condition控制一个支路，典型问题生产者和消费者问题现在可以通过这个接口来进行优化。
 * TODO 2.API
 *         1.await(),当前线程等待，同时释放当前锁,可以用signal()时或者signalAll()方法或者中断跳出等待，线程会重新获得锁并继续执行，
 *         和之前的Object的wait很像 --（await这个方法必须在lock和unlock之间调用）。
 *         2.awaitUninterruptibly()，与await()方法基本相同，但这个方法不会在等待过程中响应中断，也就是中断不会跳出等待，
 *         继续睡。
 *         3.singal()，用于唤醒一个在等待中的线程，和notify类型
 */
public class ConditionTest {
        private LinkedList<String> buffer;    //容器
        private int maxSize ;           //容器最大
        private Lock lock;
        private Condition fullCondition;
        private Condition notFullCondition;

        ConditionTest(int maxSize){
            this.maxSize = maxSize;
            buffer = new LinkedList<String>();
            lock = new ReentrantLock();
            fullCondition = lock.newCondition();
            notFullCondition = lock.newCondition();
        }

        public void set(String string) throws InterruptedException {
            lock.lock();    //获取锁
            try {
                while (maxSize == buffer.size()){
                    notFullCondition.await();       //满了，添加的线程进入等待状态
                }

                buffer.add(string);
                System.out.println("数组信息："+buffer);
                fullCondition.signal();
            } finally {
                lock.unlock();      //记得释放锁
            }
        }

        public String get() throws InterruptedException {
            String string;
            lock.lock();
            try {
                while (buffer.size() == 0){
                    fullCondition.await();
                }
                string = buffer.poll();
                notFullCondition.signal();
            } finally {
                lock.unlock();
            }
            System.out.println("数组获取："+string);
            return string;

        }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest test =new ConditionTest(10);
        for (int i = 0; i <10 ; i++) {
            test.set("i");
            test.get();
        }
    }
    }
