package com.wuzx.boot.crud.crud.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @PackgeName: com.wuzx.boot.crud.juc
 * @ClassName: CycliDataImportThread
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-08 22:07
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 基于CycliBarric实现数据导入
 */
public class CycliDataImportThread  extends Thread{

    private CyclicBarrier cyclicBarrier;

    private String path;

    public CycliDataImportThread(CyclicBarrier cyclicBarrier,String path){
        this.cyclicBarrier=cyclicBarrier;
        this.path=path;
    }

    @Override
    public void run() {
        System.out.println("开始导入渠道："+path+" 数据");
        //TODO
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
