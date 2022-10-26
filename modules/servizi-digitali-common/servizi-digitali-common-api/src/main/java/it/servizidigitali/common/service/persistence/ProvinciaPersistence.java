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

import it.servizidigitali.common.exception.NoSuchProvinciaException;
import it.servizidigitali.common.model.Provincia;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the provincia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProvinciaUtil
 * @generated
 */
@ProviderType
public interface ProvinciaPersistence extends BasePersistence<Provincia> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProvinciaUtil} to access the provincia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public Provincia findByCodiceNUTS1(String codiceNUTS1)
		throws NoSuchProvinciaException;

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchByCodiceNUTS1(String codiceNUTS1);

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchByCodiceNUTS1(
		String codiceNUTS1, boolean useFinderCache);

	/**
	 * Removes the provincia where codiceNUTS1 = &#63; from the database.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the provincia that was removed
	 */
	public Provincia removeByCodiceNUTS1(String codiceNUTS1)
		throws NoSuchProvinciaException;

	/**
	 * Returns the number of provincias where codiceNUTS1 = &#63;.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the number of matching provincias
	 */
	public int countByCodiceNUTS1(String codiceNUTS1);

	/**
	 * Returns all the provincias where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @return the matching provincias
	 */
	public java.util.List<Provincia> findByCodiceRegione(long codiceRegione);

	/**
	 * Returns a range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of matching provincias
	 */
	public java.util.List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end);

	/**
	 * Returns an ordered range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provincias
	 */
	public java.util.List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching provincias
	 */
	public java.util.List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public Provincia findByCodiceRegione_First(
			long codiceRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Provincia>
				orderByComparator)
		throws NoSuchProvinciaException;

	/**
	 * Returns the first provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchByCodiceRegione_First(
		long codiceRegione,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns the last provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public Provincia findByCodiceRegione_Last(
			long codiceRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Provincia>
				orderByComparator)
		throws NoSuchProvinciaException;

	/**
	 * Returns the last provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchByCodiceRegione_Last(
		long codiceRegione,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns the provincias before and after the current provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param provinciaId the primary key of the current provincia
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public Provincia[] findByCodiceRegione_PrevAndNext(
			long provinciaId, long codiceRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Provincia>
				orderByComparator)
		throws NoSuchProvinciaException;

	/**
	 * Removes all the provincias where codiceRegione = &#63; from the database.
	 *
	 * @param codiceRegione the codice regione
	 */
	public void removeByCodiceRegione(long codiceRegione);

	/**
	 * Returns the number of provincias where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @return the number of matching provincias
	 */
	public int countByCodiceRegione(long codiceRegione);

	/**
	 * Returns all the provincias where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @return the matching provincias
	 */
	public java.util.List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione);

	/**
	 * Returns a range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of matching provincias
	 */
	public java.util.List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end);

	/**
	 * Returns an ordered range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provincias
	 */
	public java.util.List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching provincias
	 */
	public java.util.List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public Provincia findByDenominazioneRegione_First(
			String denominazioneRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Provincia>
				orderByComparator)
		throws NoSuchProvinciaException;

	/**
	 * Returns the first provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchByDenominazioneRegione_First(
		String denominazioneRegione,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns the last provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public Provincia findByDenominazioneRegione_Last(
			String denominazioneRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Provincia>
				orderByComparator)
		throws NoSuchProvinciaException;

	/**
	 * Returns the last provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchByDenominazioneRegione_Last(
		String denominazioneRegione,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns the provincias before and after the current provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param provinciaId the primary key of the current provincia
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public Provincia[] findByDenominazioneRegione_PrevAndNext(
			long provinciaId, String denominazioneRegione,
			com.liferay.portal.kernel.util.OrderByComparator<Provincia>
				orderByComparator)
		throws NoSuchProvinciaException;

	/**
	 * Removes all the provincias where denominazioneRegione = &#63; from the database.
	 *
	 * @param denominazioneRegione the denominazione regione
	 */
	public void removeByDenominazioneRegione(String denominazioneRegione);

	/**
	 * Returns the number of provincias where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @return the number of matching provincias
	 */
	public int countByDenominazioneRegione(String denominazioneRegione);

	/**
	 * Returns the provincia where sigla = &#63; or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param sigla the sigla
	 * @return the matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	public Provincia findBySigla(String sigla) throws NoSuchProvinciaException;

	/**
	 * Returns the provincia where sigla = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sigla the sigla
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchBySigla(String sigla);

	/**
	 * Returns the provincia where sigla = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sigla the sigla
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	public Provincia fetchBySigla(String sigla, boolean useFinderCache);

	/**
	 * Removes the provincia where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 * @return the provincia that was removed
	 */
	public Provincia removeBySigla(String sigla)
		throws NoSuchProvinciaException;

	/**
	 * Returns the number of provincias where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching provincias
	 */
	public int countBySigla(String sigla);

	/**
	 * Caches the provincia in the entity cache if it is enabled.
	 *
	 * @param provincia the provincia
	 */
	public void cacheResult(Provincia provincia);

	/**
	 * Caches the provincias in the entity cache if it is enabled.
	 *
	 * @param provincias the provincias
	 */
	public void cacheResult(java.util.List<Provincia> provincias);

	/**
	 * Creates a new provincia with the primary key. Does not add the provincia to the database.
	 *
	 * @param provinciaId the primary key for the new provincia
	 * @return the new provincia
	 */
	public Provincia create(long provinciaId);

	/**
	 * Removes the provincia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia that was removed
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public Provincia remove(long provinciaId) throws NoSuchProvinciaException;

	public Provincia updateImpl(Provincia provincia);

	/**
	 * Returns the provincia with the primary key or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	public Provincia findByPrimaryKey(long provinciaId)
		throws NoSuchProvinciaException;

	/**
	 * Returns the provincia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia, or <code>null</code> if a provincia with the primary key could not be found
	 */
	public Provincia fetchByPrimaryKey(long provinciaId);

	/**
	 * Returns all the provincias.
	 *
	 * @return the provincias
	 */
	public java.util.List<Provincia> findAll();

	/**
	 * Returns a range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of provincias
	 */
	public java.util.List<Provincia> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provincias
	 */
	public java.util.List<Provincia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator);

	/**
	 * Returns an ordered range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of provincias
	 */
	public java.util.List<Provincia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Provincia>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the provincias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of provincias.
	 *
	 * @return the number of provincias
	 */
	public int countAll();

}