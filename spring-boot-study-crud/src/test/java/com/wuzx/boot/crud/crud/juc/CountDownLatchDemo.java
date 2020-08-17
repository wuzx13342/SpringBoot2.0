package com.wuzx.boot.crud.crud.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: CountDownLatchDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 21:21
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 计数器
 *   例如：启动时候预热各个缓存
 *   通过计数器达到前置操作完成之后，才能完成最后的操作
 *   TODO CountDownLatch 、SemaphoreDemo 是用到AQS的共享锁实现的 aqs->  sync#acquireSharedInterruptibly(1);
 *          ReentrantReadWriteLock 读锁也是基于aqs共享锁实现的
 *          共享锁的特性 : 不存在竞争
 *          1.多个线程通过调用tryAcquireShared方法获取共享资源，返回值大于等于0则获取资源成功,返回值小于0则获取失败。
 *          2.当前线程获取共享资源失败后，通过调用addWaiter方法把该线程封装为Node节点，并设置该节点为共享模式。然后把该节点添加到队列的尾部。
 *          3.添加到尾部后,判断该节点的上一个节点是不是队列的头节点，如果是头节点，那么该节点的上一个节点出队列并获取共享资源,
 *          同时调用setHeadAndPropagate方法把该节点设置为新的头节点,同时唤醒队列中【所有共享类型的节点,去获取共享资源】。
 *          如果获取失败，则再次加入到队列中。
 *          4.如果该节点的前驱节点不是头节点,那么通过for循环进行自旋转等待,直到当前节点的前驱节点是头节点，结束自旋。
 *
 * 这就是AQS共享模式竞争资源失败的大致流程,这里先让大家有一个大致的印象，下面通过源码具体分析是怎么进行操作的。
 */
public class CountDownLatchDemo extends Thread {

//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch =new CountDownLatch(3);
//        new Thread(()->{
//            System.out.println("Thread1");//3-2
//            countDownLatch.countDown();
//            System.out.println(Thread.currentThread().getName()+ "数量：" +countDownLatch.getCount());
//        }).start();
//        new Thread(()->{
//            System.out.println("Thread2");//2-1
//            countDownLatch.countDown();
//            System.out.println(Thread.currentThread().getName()+"数量：" +countDownLatch.getCount());
//        }).start();
//        new Thread(()->{
//            System.out.println("Thread3");//1-1
//            countDownLatch.countDown();
//            System.out.println(Thread.currentThread().getName()+"数量：" +countDownLatch.getCount());
//        }).start();
//        countDownLatch.await();
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getName()+"数量：" +countDownLatch.getCount());
//
//    }
    static CountDownLatch countDownLatch =new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new CountDownLatchDemo().start();
        }
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();//阻塞1000个线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO
        System.out.println("ThreadName: "+Thread.currentThread().getName());
    }
}
