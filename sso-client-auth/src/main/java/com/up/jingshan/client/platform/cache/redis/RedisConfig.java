package com.up.jingshan.client.platform.cache.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @author YuanJingshan
 * @version 1.fontawesome
 * @description redis 配置类
 * @date 2020/1/3
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 创建JedisPoolConfig对象,在该对象中完成一些连接池的配置
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    /**
     * 创建JedisConnectionFactory：配置redis 连接信息
     *
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        return new JedisConnectionFactory(jedisPoolConfig);
    }

    /**
     * 创建 RedisTemplate:用于执行 Redis 操作的方法
     *
     * @param jedisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 关联
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        // 为 key 设置序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 为 value 设置序列化器
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    /**
     * 实例化缓存管理器
     *
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        // 更改值的序列化方式，否则在Redis可视化软件中会显示乱码。默认为JdkSerializationRedisSerializer
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(new GenericJackson2JsonRedisSerializer());
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeValuesWith(pair)      // 设置序列化方式
                .entryTtl(Duration.ofHours(1)); // 设置过期时间
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(factory))
                .cacheDefaults(defaultCacheConfig).build();
    }

    /**
     * 缓存对象集合中，缓存是以 key-value 形式保存的。
     * 当不指定缓存的 key 时，SpringBoot 会使用 SimpleKeyGenerator 生成 key。
     *
     * @return
     */
    @Bean
    public KeyGenerator wiselyKeyGenerator() {
        // key前缀，用于区分不同项目的缓存，建议每个项目单独设置
        final String PRE_KEY = "test";
        final char sp = ':';
        KeyGenerator keyGenerator = (Object target, Method method, Object... params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(PRE_KEY);
            sb.append(sp);
            sb.append(target.getClass().getSimpleName());
            sb.append(sp);
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(sp);
                sb.append(obj.toString());
            }
            return sb.toString();
        };
        return keyGenerator;
    }

}