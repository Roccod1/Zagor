package it.servizidigitali.backoffice.integration.service;

import java.io.Serializable;

/**
 * @author pindi
 *
 */
public interface CacheService {

	/**
	 *
	 * @param <T>
	 * @param codiceFiscale
	 * @return
	 */
	<T> T getFromCache(String codiceFiscale, Class<T> type);

	/**
	 *
	 * @param codiceFiscale
	 * @param instance
	 */
	void putInCache(String codiceFiscale, Serializable instance);

	/**
	 *
	 * @param codiceFiscale
	 */
	void deleteFromCache(String codiceFiscale);

	/**
	 *
	 */
	void cleanCache();

}
