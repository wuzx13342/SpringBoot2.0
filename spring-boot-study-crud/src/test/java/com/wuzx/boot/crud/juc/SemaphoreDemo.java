package com.wuzx.boot.crud.juc;

import java.util.concurrent.Semaphore;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: SemaphoreDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 21:51
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 信号量 可以做限流
 *
 *    TODO 也是基于AQS实现的 共享锁实现的 acquireSharedInterruptibly(int arg)
 */
public class SemaphoreDemo {

    //限流（AQS）
    //permits;令牌
    //公平和非公平
    static class Car extends Thread{
        private int num;
        private Semaphore semaphore;

        public Car(int num,Semaphore semaphore){
            this.num=num;
            this.semaphore= semaphore;
        }
        public void run(){
            try {
                semaphore.acquire();//获得一个令牌，如果拿不到，就会阻塞
                System.out.println("第 "+num+" 抢占一个车位");
                Thread.sleep(2000);
                System.out.println("第 "+num+" 开走了！");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore =new Semaphore(3);
        for (int i = 0; i <6 ; i++) {
            new Car(i,semaphore).start();
        }
    }

}
