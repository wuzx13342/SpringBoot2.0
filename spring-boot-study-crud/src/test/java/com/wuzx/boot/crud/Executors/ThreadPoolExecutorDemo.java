package com.wuzx.boot.crud.Executors;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @PackgeName: com.wuzx.boot.crud.Executors
 * @ClassName: ThreadPoolExecutorDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-10 11:31
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ThreadPoolExecutorDemo extends ThreadPoolExecutor {

    private ConcurrentHashMap<String, Date> satrtTimes;//保存任务开始的执行时间，当任务结束时。

    public ThreadPoolExecutorDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.satrtTimes= new ConcurrentHashMap<>();
    }

    @Override
    public void shutdown(){
        System.out.println("已经执行的任务数："+this.getCompletedTaskCount()+"，"+"当前活动线程数："+this.getActiveCount()+"，当前排队线程数："+this.getQueue().size());
        System.out.println();
        super.shutdown();
    }

    @Override
    protected void beforeExecute(Thread t,Runnable r){
        satrtTimes.put(String.valueOf(r.hashCode()),new Date());
        super.beforeExecute(t,r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date startDate = satrtTimes.remove(String.valueOf(r.hashCode()));
        Date finishDate = new Date();

        long diff = finishDate.getTime() - startDate.getTime();
            // 统计任务耗时、初始线程数、核心线程数、正在执行的任务数量、
            // 已完成任务数量、任务总数、队列里缓存的任务数量、
            // 池中存在的最大线程数、最大允许的线程数、线程空闲时间、线程池是否关闭、线程池 是否终止
        System.out.print("任务耗时:"+diff+"\n");
        System.out.print("初始线程数:"+this.getPoolSize()+"\n");
        System.out.print("核心线程数:"+this.getCorePoolSize()+"\n");
        System.out.print("正在执行的任务数量:"+this.getActiveCount()+"\n");
        System.out.print("已经执行的任务数:"+this.getCompletedTaskCount()+"\n");
        System.out.print("任务总数:"+this.getTaskCount()+"\n");
        System.out.print("最大允许的线程数:"+this.getMaximumPoolSize()+"\n");
        System.out.print("线程空闲时间:"+this.getKeepAliveTime(TimeUnit.MILLISECONDS)+"\n");
        System.out.println();
        super.afterExecute(r, t);
    }
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutorDemo(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new
                SynchronousQueue ());
    }
}

