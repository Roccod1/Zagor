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

import it.servizidigitali.gestionecomunicazioni.exception.NoSuchTipologiaComunicazioneException;
import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tipologia comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComunicazioneUtil
 * @generated
 */
@ProviderType
public interface TipologiaComunicazionePersistence
	extends BasePersistence<TipologiaComunicazione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipologiaComunicazioneUtil} to access the tipologia comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the tipologia comunicazione in the entity cache if it is enabled.
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 */
	public void cacheResult(TipologiaComunicazione tipologiaComunicazione);

	/**
	 * Caches the tipologia comunicaziones in the entity cache if it is enabled.
	 *
	 * @param tipologiaComunicaziones the tipologia comunicaziones
	 */
	public void cacheResult(
		java.util.List<TipologiaComunicazione> tipologiaComunicaziones);

	/**
	 * Creates a new tipologia comunicazione with the primary key. Does not add the tipologia comunicazione to the database.
	 *
	 * @param tipologiaComunicazioneId the primary key for the new tipologia comunicazione
	 * @return the new tipologia comunicazione
	 */
	public TipologiaComunicazione create(long tipologiaComunicazioneId);

	/**
	 * Removes the tipologia comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 * @throws NoSuchTipologiaComunicazioneException if a tipologia comunicazione with the primary key could not be found
	 */
	public TipologiaComunicazione remove(long tipologiaComunicazioneId)
		throws NoSuchTipologiaComunicazioneException;

	public TipologiaComunicazione updateImpl(
		TipologiaComunicazione tipologiaComunicazione);

	/**
	 * Returns the tipologia comunicazione with the primary key or throws a <code>NoSuchTipologiaComunicazioneException</code> if it could not be found.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione
	 * @throws NoSuchTipologiaComunicazioneException if a tipologia comunicazione with the primary key could not be found
	 */
	public TipologiaComunicazione findByPrimaryKey(
			long tipologiaComunicazioneId)
		throws NoSuchTipologiaComunicazioneException;

	/**
	 * Returns the tipologia comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione, or <code>null</code> if a tipologia comunicazione with the primary key could not be found
	 */
	public TipologiaComunicazione fetchByPrimaryKey(
		long tipologiaComunicazioneId);

	/**
	 * Returns all the tipologia comunicaziones.
	 *
	 * @return the tipologia comunicaziones
	 */
	public java.util.List<TipologiaComunicazione> findAll();

	/**
	 * Returns a range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @return the range of tipologia comunicaziones
	 */
	public java.util.List<TipologiaComunicazione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologia comunicaziones
	 */
	public java.util.List<TipologiaComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaComunicazione>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipologia comunicaziones
	 */
	public java.util.List<TipologiaComunicazione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaComunicazione>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tipologia comunicaziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tipologia comunicaziones.
	 *
	 * @return the number of tipologia comunicaziones
	 */
	public int countAll();

}