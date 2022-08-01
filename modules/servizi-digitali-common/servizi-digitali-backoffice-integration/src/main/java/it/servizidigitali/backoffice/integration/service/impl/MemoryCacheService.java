package it.servizidigitali.backoffice.integration.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.backoffice.integration.service.CacheService;
import it.servizidigitali.backoffice.integration.service.MemoryCache;
import it.servizidigitali.backoffice.integration.service.MemoryCache.CacheEntry;

/**
 * @author pindi
 *
 */
@Component(name = "memoryCacheService", immediate = true, service = CacheService.class)
public class MemoryCacheService implements CacheService {

	private static final Log log = LogFactoryUtil.getLog(MemoryCacheService.class.getName());

	private Integer validitaDatiCacheInMinuti = 30;

	@Override
	public <T> T getFromCache(String codiceFiscale, Class<T> type) {
		if (codiceFiscale != null && MemoryCache.getInstance().getCacheMap().containsKey(codiceFiscale.toUpperCase())) {
			CacheEntry cacheEntry = MemoryCache.getInstance().getCacheMap().get(codiceFiscale.toUpperCase());
			Map<String, Serializable> cachableMap = cacheEntry.getCachableMap();
			if (cachableMap == null || !cachableMap.containsKey(type.getName())) {
				return null;
			}
			return deserialize((String) cachableMap.get(type.getName()), type);
		}

		return null;
	}

	@Override
	public void putInCache(String codiceFiscale, Serializable instance) {
		CacheEntry cacheEntry = MemoryCache.getInstance().getCacheMap().get(codiceFiscale.toUpperCase());
		if (cacheEntry == null) {
			cacheEntry = new CacheEntry();
			MemoryCache.getInstance().getCacheMap().put(codiceFiscale.toUpperCase(), cacheEntry);
		}
		long timeToLive = System.currentTimeMillis() + validitaDatiCacheInMinuti * 60 * 1000;
		cacheEntry.setTimeToLive(timeToLive);
		cacheEntry.getCachableMap().put(instance.getClass().getName(), serialize(instance));

	}

	@Override
	public synchronized void cleanCache() {
		if (!MemoryCache.getInstance().getCacheMap().isEmpty()) {
			log.debug("Starting in memory map clean process");
			for (Entry<String, CacheEntry> entry : MemoryCache.getInstance().getCacheMap().entrySet()) {
				CacheEntry value = entry.getValue();
				Long expires = value.getTimeToLive();
				if (expires - System.currentTimeMillis() <= 0) {
					MemoryCache.getInstance().getCacheMap().remove(entry.getKey());
					log.debug(entry.getKey() + " removed from Map");

				}
			}
			log.debug("In memory map clean process ended");
		}
	}

	@Override
	public synchronized void deleteFromCache(String codiceFiscale) {
		if (codiceFiscale != null) {
			MemoryCache.getInstance().getCacheMap().remove(codiceFiscale.toUpperCase());
		}
	}

	private <T> String serialize(T instance) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		try {
			return mapper.writeValueAsString(instance);
		}
		catch (JsonParseException e) {
			log.error("serialize :: " + e.getMessage(), e);
		}
		catch (JsonMappingException e) {
			log.error("serialize :: " + e.getMessage(), e);
		}
		catch (IOException e) {
			log.error("serialize :: " + e.getMessage(), e);
		}
		return null;
	}

	private <T> T deserialize(String jsonData, Class<T> type) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		try {
			return mapper.readValue(jsonData, type);
		}
		catch (JsonParseException e) {
			log.error("deserialize :: " + e.getMessage(), e);
		}
		catch (JsonMappingException e) {
			log.error("deserialize :: " + e.getMessage(), e);
		}
		catch (IOException e) {
			log.error("deserialize :: " + e.getMessage(), e);
		}
		return null;
	}
}
