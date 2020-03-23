package com.crazy.article.config.redis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-22 20:16
 * 定义自己的key生成策略
 */
@Configuration
public class MyCacheConfig {

    /*@Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + '[' + Arrays.asList(params) + ']';
            }
        };
    }*/
}
