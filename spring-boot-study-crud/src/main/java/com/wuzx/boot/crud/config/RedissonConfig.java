package com.wuzx.boot.crud.config;

import lombok.Data;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

    private static final String REDIS_PROTOCOL = "redis://";

    /**
     * 获取redisson配置类
     * */
    public Config getConfig() {
        Config config = new Config();
        config.useSingleServer().setAddress(REDIS_PROTOCOL + host + ":" + port)
                .setDatabase(1)
                .setConnectTimeout(timeout);
        System.out.println("================config:" + host + "," + port);
        return config;
    }
}
