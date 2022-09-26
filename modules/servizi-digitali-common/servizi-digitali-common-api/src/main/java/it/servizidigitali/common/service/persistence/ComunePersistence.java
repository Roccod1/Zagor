/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.servizidigitali.common.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.common.exception.NoSuchComuneException;
import it.servizidigitali.common.model.Comune;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comune service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComuneUtil
 * @generated
 */
@ProviderType
public interface ComunePersistence extends BasePersistence<Comune> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComuneUtil} to access the comune persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the comune where codiceIstatAN = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByCodiceIstatAN(String codiceIstatAN)
		throws NoSuchComuneException;

	/**
	 * Returns the comune where codiceIstatAN = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByCodiceIstatAN(String codiceIstatAN);

	/**
	 * Returns the comune where codiceIstatAN = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByCodiceIstatAN(
		String codiceIstatAN, boolean useFinderCache);

	/**
	 * Removes the comune where codiceIstatAN = &#63; from the database.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the comune that was removed
	 */
	public Comune removeByCodiceIstatAN(String codiceIstatAN)
		throws NoSuchComuneException;

	/**
	 * Returns the number of comunes where codiceIstatAN = &#63;.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the number of matching comunes
	 */
	public int countByCodiceIstatAN(String codiceIstatAN);

	/**
	 * Returns the comune where codiceCatastale = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByCodiceCatastale(String codiceCatastale)
		throws NoSuchComuneException;

	/**
	 * Returns the comune where codiceCatastale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByCodiceCatastale(String codiceCatastale);

	/**
	 * Returns the comune where codiceCatastale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceCatastale the codice catastale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByCodiceCatastale(
		String codiceCatastale, boolean useFinderCache);

	/**
	 * Removes the comune where codiceCatastale = &#63; from the database.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the comune that was removed
	 */
	public Comune removeByCodiceCatastale(String codiceCatastale)
		throws NoSuchComuneException;

	/**
	 * Returns the number of comunes where codiceCatastale = &#63;.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the number of matching comunes
	 */
	public int countByCodiceCatastale(String codiceCatastale);

	/**
	 * Returns the comune where codiceComune = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceComune the codice comune
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByCodiceComune(int codiceComune)
		throws NoSuchComuneException;

	/**
	 * Returns the comune where codiceComune = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceComune the codice comune
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByCodiceComune(int codiceComune);

	/**
	 * Returns the comune where codiceComune = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceComune the codice comune
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByCodiceComune(int codiceComune, boolean useFinderCache);

	/**
	 * Removes the comune where codiceComune = &#63; from the database.
	 *
	 * @param codiceComune the codice comune
	 * @return the comune that was removed
	 */
	public Comune removeByCodiceComune(int codiceComune)
		throws NoSuchComuneException;

	/**
	 * Returns the number of comunes where codiceComune = &#63;.
	 *
	 * @param codiceComune the codice comune
	 * @return the number of matching comunes
	 */
	public int countByCodiceComune(int codiceComune);

	/**
	 * Returns the comune where denominazione = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByDenominazione(String denominazione)
		throws NoSuchComuneException;

	/**
	 * Returns the comune where denominazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByDenominazione(String denominazione);

	/**
	 * Returns the comune where denominazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByDenominazione(
		String denominazione, boolean useFinderCache);

	/**
	 * Removes the comune where denominazione = &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 * @return the comune that was removed
	 */
	public Comune removeByDenominazione(String denominazione)
		throws NoSuchComuneException;

	/**
	 * Returns the number of comunes where denominazione = &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching comunes
	 */
	public int countByDenominazione(String denominazione);

	/**
	 * Returns all the comunes where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @return the matching comunes
	 */
	public java.util.List<Comune> findByidRegione(long idRegione);

	/**
	 * Returns a range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of matching comunes
	 */
	public java.util.List<Comune> findByidRegione(
		long idRegione, int start, int end);

	/**
	 * Returns an ordered range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunes
	 */
	public java.util.List<Comune> findByidRegione(
		long idRegione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunes
	 */
	public java.util.List<Comune> findByidRegione(
		long idRegione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByidRegione_First(
			long idRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Comune>
				orderByComparator)
		throws NoSuchComuneException;

	/**
	 * Returns the first comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByidRegione_First(
		long idRegione,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns the last comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByidRegione_Last(
			long idRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Comune>
				orderByComparator)
		throws NoSuchComuneException;

	/**
	 * Returns the last comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByidRegione_Last(
		long idRegione,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns the comunes before and after the current comune in the ordered set where idRegione = &#63;.
	 *
	 * @param comuneId the primary key of the current comune
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public Comune[] findByidRegione_PrevAndNext(
			long comuneId, long idRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Comune>
				orderByComparator)
		throws NoSuchComuneException;

	/**
	 * Removes all the comunes where idRegione = &#63; from the database.
	 *
	 * @param idRegione the id regione
	 */
	public void removeByidRegione(long idRegione);

	/**
	 * Returns the number of comunes where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @return the number of matching comunes
	 */
	public int countByidRegione(long idRegione);

	/**
	 * Returns all the comunes where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @return the matching comunes
	 */
	public java.util.List<Comune> findByIdProvincia(long idProvincia);

	/**
	 * Returns a range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of matching comunes
	 */
	public java.util.List<Comune> findByIdProvincia(
		long idProvincia, int start, int end);

	/**
	 * Returns an ordered range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunes
	 */
	public java.util.List<Comune> findByIdProvincia(
		long idProvincia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunes
	 */
	public java.util.List<Comune> findByIdProvincia(
		long idProvincia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByIdProvincia_First(
			long idProvincia,
			com.liferay.portal.kernel.util.OrderByComparator<Comune>
				orderByComparator)
		throws NoSuchComuneException;

	/**
	 * Returns the first comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByIdProvincia_First(
		long idProvincia,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns the last comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	public Comune findByIdProvincia_Last(
			long idProvincia,
			com.liferay.portal.kernel.util.OrderByComparator<Comune>
				orderByComparator)
		throws NoSuchComuneException;

	/**
	 * Returns the last comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune, or <code>null</code> if a matching comune could not be found
	 */
	public Comune fetchByIdProvincia_Last(
		long idProvincia,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns the comunes before and after the current comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param comuneId the primary key of the current comune
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public Comune[] findByIdProvincia_PrevAndNext(
			long comuneId, long idProvincia,
			com.liferay.portal.kernel.util.OrderByComparator<Comune>
				orderByComparator)
		throws NoSuchComuneException;

	/**
	 * Removes all the comunes where idProvincia = &#63; from the database.
	 *
	 * @param idProvincia the id provincia
	 */
	public void removeByIdProvincia(long idProvincia);

	/**
	 * Returns the number of comunes where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @return the number of matching comunes
	 */
	public int countByIdProvincia(long idProvincia);

	/**
	 * Caches the comune in the entity cache if it is enabled.
	 *
	 * @param comune the comune
	 */
	public void cacheResult(Comune comune);

	/**
	 * Caches the comunes in the entity cache if it is enabled.
	 *
	 * @param comunes the comunes
	 */
	public void cacheResult(java.util.List<Comune> comunes);

	/**
	 * Creates a new comune with the primary key. Does not add the comune to the database.
	 *
	 * @param comuneId the primary key for the new comune
	 * @return the new comune
	 */
	public Comune create(long comuneId);

	/**
	 * Removes the comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune that was removed
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public Comune remove(long comuneId) throws NoSuchComuneException;

	public Comune updateImpl(Comune comune);

	/**
	 * Returns the comune with the primary key or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	public Comune findByPrimaryKey(long comuneId) throws NoSuchComuneException;

	/**
	 * Returns the comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune, or <code>null</code> if a comune with the primary key could not be found
	 */
	public Comune fetchByPrimaryKey(long comuneId);

	/**
	 * Returns all the comunes.
	 *
	 * @return the comunes
	 */
	public java.util.List<Comune> findAll();

	/**
	 * Returns a range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of comunes
	 */
	public java.util.List<Comune> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comunes
	 */
	public java.util.List<Comune> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comunes
	 */
	public java.util.List<Comune> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comune>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comunes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comunes.
	 *
	 * @return the number of comunes
	 */
	public int countAll();

}