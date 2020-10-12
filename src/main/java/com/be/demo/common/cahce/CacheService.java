package com.be.demo.common.cahce;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@Autowired
	@Qualifier("redisTemplateStringObject")
	private RedisTemplate<String, Object> redisTemplateStringObject;

	@Value("${spring.redis.cache.enabled:true}")
	private boolean cacheEnabled;

	/**
	 * Clear redis cache, clear all keys
	 */
	public void clearAllCaches() {
		redisTemplateStringObject.execute((RedisCallback<Object>) connection -> {
			connection.flushAll();
			return null;
		});
	}

	/**
	 * Add key and value to redis cache with ttlMinutes as the key expiration in
	 * minutes
	 *
	 * @param key
	 * @param toBeCached
	 * @param ttlMinutes
	 */
	public void cachePut(String key, Object toBeCached, long ttlMinutes) {
		if (!cacheEnabled)
			return;

		redisTemplateStringObject.opsForValue().set(key, toBeCached, ttlMinutes, TimeUnit.MINUTES);
	}

	/**
	 * Add key and value to redis cache with no expiration of key
	 *
	 * @param key
	 * @param toBeCached
	 */
	public void cachePut(String key, Object toBeCached) {
		if (!cacheEnabled)
			return;

		if (toBeCached == null)
			return;

		cachePut(key, toBeCached, -1);
	}

	/**
	 * Get the value for the given key from redis cache
	 *
	 * @param key
	 * @param type
	 * @return
	 */
	public <T> T cacheGet(String key, Class<T> type) {
		if (!cacheEnabled)
			return null;

		return (T) redisTemplateStringObject.opsForValue().get(key);

	}
}
