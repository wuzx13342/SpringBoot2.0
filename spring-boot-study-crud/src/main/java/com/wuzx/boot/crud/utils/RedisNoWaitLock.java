package com.wuzx.boot.crud.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁实现
 */
@Slf4j
@Component
public class RedisNoWaitLock {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 加锁
     *
     * @param lockKey   加锁的Key
     * @param timeStamp 时间戳：当前时间+超时时间
     * @return
     */
    public boolean lock(String lockKey, String timeStamp) {

        try {
            do {
                // 对应setnx命令，可以成功设置,也就是key不存在，获得锁成功
                if (redisTemplate.opsForValue().setIfAbsent(lockKey, timeStamp)) {
                    //添加超时时间，防止业务逻辑中锁释放失败，导致死锁
                    redisTemplate.expire(lockKey, 5, TimeUnit.SECONDS);
                    return true;
                }

            } while (true);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Boolean.FALSE;
    }

    /**
     * 释放锁
     *
     * @param lockKey
     */
    public  void release(String lockKey) {
        try {
            // 删除锁状态
            redisTemplate.opsForValue().getOperations().delete(lockKey);
        } catch (Exception e) {
            System.out.println("警报！警报！警报！解锁异常");
        }
    }
}