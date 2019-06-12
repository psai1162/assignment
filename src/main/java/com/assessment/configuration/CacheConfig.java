package com.assessment.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
// we need to add spring's @EnableCaching to spring beans so that spring's annotation-driven cache management is enabled
}
