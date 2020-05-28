package com.wuzx.boot.crud.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @PackgeName: com.wuzx.boot.crud.Aop
 * @ClassName: ControllerAspect
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-27 21:20
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 调用controller切面
 */
@Component
@Aspect
@Slf4j
public class ControllerAspect {

    @Pointcut("execution(* com.wuzx.boot.crud.controller..*.*(..))")
    public void aspect(){

    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("before 通知" +joinPoint);
        log.info("before 通知" +joinPoint);
    }

    @After("aspect()")
    public void after(JoinPoint joinPoint){
        System.out.println("after 通知" +joinPoint);
        log.info("after 通知" +joinPoint);
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            System.out.println("around通知 通知" +pjp);
            log.info("around通知 "+pjp + "\tUse time: " +(end-start) + " ms!");
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.info("around通知 "+pjp + "\tUse time: " +(end-start) + " ms with exception: "+e.getMessage());
        }
         return pjp.proceed();
    }
}
