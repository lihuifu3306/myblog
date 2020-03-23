package com.crazy.article.config.redis;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-23 10:57
 */
@Configuration
public class MyRedisConfig {

    /*@Bean
    public <T, R> RedisTemplate<T, R> redisTemplate(RedisConnectionFactory redisConnectionFactory, Class<R> rClass) throws UnknownHostException {
        RedisTemplate<T,R> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<R> serializer = new Jackson2JsonRedisSerializer<>(rClass);
        template.setDefaultSerializer(serializer);
        return template;
    }*/

    /**
     * springboot2.0 和1.0缓存管理器的实现改变很大
     * 2.0不用给每个对象配置缓存管理器来实现存储json数据
     * 集中化配置就可以
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);
        //设置默认超过期时间是30天
        defaultCacheConfig.entryTtl(Duration.ofDays(30));
        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }
}
