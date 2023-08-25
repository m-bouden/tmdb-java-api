package com.api.tv.config;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Caching;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager createCacheWithinManager() {

        CacheConfiguration<String, Object> cacheConfig = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(10))
            .build();

        javax.cache.CacheManager cacheManager = Caching.getCachingProvider("org.ehcache.jsr107.EhcacheCachingProvider")
            .getCacheManager();

        cacheManager.createCache("genresCache", Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig));
        cacheManager.createCache("movieDetails", Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig));

        return new JCacheCacheManager(cacheManager);
    }
}
