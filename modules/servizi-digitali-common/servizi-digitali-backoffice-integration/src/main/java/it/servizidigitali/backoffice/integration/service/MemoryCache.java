package it.servizidigitali.backoffice.integration.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe singleton per il salvataggio ed il caricamento degli oggetti condivisi in memoria.
 *
 * @author Gianluca Pindinelli
 *
 */
public class MemoryCache {

	private static MemoryCache memoryCacheInstance = null;

	private final Map<String, CacheEntry> cacheMap = new HashMap<String, MemoryCache.CacheEntry>();

	private MemoryCache() {

	}

	public static MemoryCache getInstance() {
		if (memoryCacheInstance == null) {
			memoryCacheInstance = new MemoryCache();
		}

		return memoryCacheInstance;
	}

	public static class CacheEntry {

		private long timeToLive;
		private Map<String, Serializable> serializableMap = new HashMap<String, Serializable>();

		/**
		 * @return the timeToLive
		 */
		public long getTimeToLive() {
			return timeToLive;
		}

		/**
		 * @param timeToLive the timeToLive to set
		 */
		public void setTimeToLive(long timeToLive) {
			this.timeToLive = timeToLive;
		}

		/**
		 * @return the serializableMap
		 */
		public Map<String, Serializable> getCachableMap() {
			return serializableMap;
		}

		/**
		 * @param serializableMap the serializableMap to set
		 */
		public void setCachableMap(Map<String, Serializable> cachableMap) {
			this.serializableMap = cachableMap;
		}
	}

	/**
	 * @return the cacheMap
	 */
	public Map<String, CacheEntry> getCacheMap() {
		return cacheMap;
	}

}
