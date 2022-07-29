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

package it.servizidigitali.gestionecomunicazioni.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestionecomunicazioni.exception.NoSuchLetturaComunicazioneException;
import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lettura comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazioneUtil
 * @generated
 */
@ProviderType
public interface LetturaComunicazionePersistence
	extends BasePersistence<LetturaComunicazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LetturaComunicazioneUtil} to access the lettura comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the lettura comunicazione in the entity cache if it is enabled.
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 */
	public void cacheResult(LetturaComunicazione letturaComunicazione);

	/**
	 * Caches the lettura comunicaziones in the entity cache if it is enabled.
	 *
	 * @param letturaComunicaziones the lettura comunicaziones
	 */
	public void cacheResult(
		java.util.List<LetturaComunicazione> letturaComunicaziones);

	/**
	 * Creates a new lettura comunicazione with the primary key. Does not add the lettura comunicazione to the database.
	 *
	 * @param letturaComunicazionePK the primary key for the new lettura comunicazione
	 * @return the new lettura comunicazione
	 */
	public LetturaComunicazione create(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK letturaComunicazionePK);

	/**
	 * Removes the lettura comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	public LetturaComunicazione remove(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK)
		throws NoSuchLetturaComunicazioneException;

	public LetturaComunicazione updateImpl(
		LetturaComunicazione letturaComunicazione);

	/**
	 * Returns the lettura comunicazione with the primary key or throws a <code>NoSuchLetturaComunicazioneException</code> if it could not be found.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	public LetturaComunicazione findByPrimaryKey(
			it.servizidigitali.gestionecomunicazioni.service.persistence.
				LetturaComunicazionePK letturaComunicazionePK)
		throws NoSuchLetturaComunicazioneException;

	/**
	 * Returns the lettura comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione, or <code>null</code> if a lettura comunicazione with the primary key could not be found
	 */
	public LetturaComunicazione fetchByPrimaryKey(
		it.servizidigitali.gestionecomunicazioni.service.persistence.
			LetturaComunicazionePK letturaComunicazionePK);

	/**
	 * Returns all the lettura comunicaziones.
	 *
	 * @return the lettura comunicaziones
	 */
	public java.util.List<LetturaComunicazione> findAll();

	/**
	 * Returns a range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @return the range of lettura comunicaziones
	 */
	public java.util.List<LetturaComunicazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lettura comunicaziones
	 */
	public java.util.List<LetturaComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LetturaComunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lettura comunicaziones
	 */
	public java.util.List<LetturaComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LetturaComunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lettura comunicaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lettura comunicaziones.
	 *
	 * @return the number of lettura comunicaziones
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}