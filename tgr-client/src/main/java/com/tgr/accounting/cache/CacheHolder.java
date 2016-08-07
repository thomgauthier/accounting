package com.tgr.accounting.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheHolder {

	private static CacheHolder cacheHolder;
	
	private Map<String, Object> cache = new HashMap<String, Object>();
	
	private CacheHolder() {
		
	}
	
	public static CacheHolder getInstance() {
		if (cacheHolder == null) {
			cacheHolder = new CacheHolder();
		}
		return cacheHolder;
	}
	
	public void put(String key, Object obj) {
		cache.put(key, obj);
	}
}
