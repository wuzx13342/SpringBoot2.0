package com.wuzx.boot.crud.crud.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: BlockingDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-09 18:28
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 阻塞队列 是一种FIFO队列
 *         TODO 底层是基于ReentranLock 和 Condition实现的
 *              take 调用了 Condition.await阻塞
 *              offer里面调用Condition.signal唤醒
 */
public class BlockingDemo {

    ArrayBlockingQueue<String> ab =new ArrayBlockingQueue<>(10);
    {
        init();//构造块初始化
    }
    public  void  init(){
        new Thread(()->{
            while (true) {
                try {
                    String data = ab.take();
                    System.out.println("receive: " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void addData(String data) throws InterruptedException {
        ab.add(data);
        System.out.println("sendData："+data);
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingDemo blockingDemo = new BlockingDemo();
        for (int i = 0; i <100 ; i++) {
            blockingDemo.addData("data:" +i);
        }
    }
}
