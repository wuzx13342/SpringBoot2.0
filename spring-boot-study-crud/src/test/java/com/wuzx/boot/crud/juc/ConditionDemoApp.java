package com.wuzx.boot.crud.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: ConditionDemoApp
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 16:29
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 获得锁 TODO 原理分析：
 * 　　TODO ConditionObject是同步器AQS的内部类，因为Condition的操作需要获取相关联的锁，所以作为同步器的内部类也较为合理。
 *        每个Condition对象都包含着一个队列(等待队列)，该队列是condition对象实现等待/通知的功能的关键。
 * 　　TODO 等待队列：
 * 　 TODO  等待队列是一个FIFO的队列，在队列中的每个节点都包含了一个线程引用，该线程就是在Condition对象上等待的线程，
 *       如果一个线程调用了Condition.await()方法，那么该线程将会释放锁、构造成节点加入等待队列并进入等待状态。
 *       事实上，节点的定义复用了同步器中节点的定义，也就是说，同步队列和等待队列中节点类型都是同步器的静态内部类AbstractQueuedSynchronizer.Node。
 *
 */
public class ConditionDemoApp {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition =lock.newCondition();

        new Thread(new ConditionWaitDemo(lock,condition)).start();
        new Thread(new ConditionNotifyDemo(lock,condition)).start();

    }
}
