package com.haozileung.infra.utils;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(CacheUtil.class);
	private static volatile CacheManager cacheManager = CacheManager
			.getInstance();

	private static Cache getOrAddCache(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			synchronized (cacheManager) {
				cache = cacheManager.getCache(cacheName);
				if (cache == null) {
					logger.warn("Could not find cache config [" + cacheName
							+ "], using default.");
					cacheManager.addCacheIfAbsent(cacheName);
					cache = cacheManager.getCache(cacheName);
					logger.debug("Cache [" + cacheName + "] started.");
				}
			}
		}
		return cache;
	}

	/**
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, Object key, Object value) {
		getOrAddCache(cacheName).put(new Element(key, value));
	}

	/**
	 * @param cacheName
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(String cacheName, Object key) {
		Element element = getOrAddCache(cacheName).get(key);
		return element != null ? (T) element.getObjectValue() : null;
	}

	/**
	 * @param cacheName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List getKeys(String cacheName) {
		return getOrAddCache(cacheName).getKeys();
	}

	/**
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, Object key) {
		getOrAddCache(cacheName).remove(key);
	}

	/**
	 * @param cacheName
	 */
	public static void removeAll(String cacheName) {
		getOrAddCache(cacheName).removeAll();
	}
}
