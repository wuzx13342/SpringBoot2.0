package com.wuzx.boot.crud.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: CycliBarrierDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 22:02
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 循环屏障 有点像CountDownLatch
 * TODO 可以使得一组线程达到一个同步点之前阻塞 ，
 *     CycliBarrier 底层是基于可重入锁 ReentranLock 和Condition实现的
 */
public class CycliBarrierDemo extends Thread{


    public static void main(String[] args) {

        //parties
        CyclicBarrier cyclicBarrier =new CyclicBarrier(3,new CycliBarrierDemo());
        new Thread(new CycliDataImportThread(cyclicBarrier,"用户渠道")).start();
        new Thread(new CycliDataImportThread(cyclicBarrier,"产品渠道")).start();
        new Thread(new CycliDataImportThread(cyclicBarrier,"订单渠道")).start();
    }

    @Override
    public void run() {
        System.out.println("所有数据导入完毕，开始处理数据");
    }
}
