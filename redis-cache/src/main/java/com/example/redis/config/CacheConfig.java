package com.example.redis.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializer;


import java.time.Duration;
import static org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration configuration =  RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues() // null 캐싱하는지
                .entryTtl(Duration.ofSeconds(10)) //기본 캐시 유지시간
                .computePrefixWith(CacheKeyPrefix.simple()) //캐시 접두사
                .serializeValuesWith( //캐시 저장할 값 직렬화/역직렬화
                       SerializationPair.fromSerializer(RedisSerializer.java())
                );
        return RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(configuration)
                .build();
    }
}
