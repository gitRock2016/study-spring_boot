package com.example.demo.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory fac) {
		
		RedisCacheManagerBuilder builder = RedisCacheManager.builder(fac);
		builder
			.cacheDefaults(
					RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)))
			.withCacheConfiguration("cache1", 
					RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
			.withCacheConfiguration("cache2", 
					RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)));

		return builder.build();
	}
}
