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

package it.servizidigitali.common.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ComuneEstero service. Represents a row in the &quot;comune_estero&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.common.model.impl.ComuneEsteroModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.common.model.impl.ComuneEsteroImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComuneEstero
 * @generated
 */
@ProviderType
public interface ComuneEsteroModel extends BaseModel<ComuneEstero> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a comune estero model instance should use the {@link ComuneEstero} interface instead.
	 */

	/**
	 * Returns the primary key of this comune estero.
	 *
	 * @return the primary key of this comune estero
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this comune estero.
	 *
	 * @param primaryKey the primary key of this comune estero
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the comune estero ID of this comune estero.
	 *
	 * @return the comune estero ID of this comune estero
	 */
	public long getComuneEsteroId();

	/**
	 * Sets the comune estero ID of this comune estero.
	 *
	 * @param comuneEsteroId the comune estero ID of this comune estero
	 */
	public void setComuneEsteroId(long comuneEsteroId);

	/**
	 * Returns the codice of this comune estero.
	 *
	 * @return the codice of this comune estero
	 */
	public int getCodice();

	/**
	 * Sets the codice of this comune estero.
	 *
	 * @param codice the codice of this comune estero
	 */
	public void setCodice(int codice);

	/**
	 * Returns the denominazione of this comune estero.
	 *
	 * @return the denominazione of this comune estero
	 */
	@AutoEscape
	public String getDenominazione();

	/**
	 * Sets the denominazione of this comune estero.
	 *
	 * @param denominazione the denominazione of this comune estero
	 */
	public void setDenominazione(String denominazione);

	@Override
	public ComuneEstero cloneWithOriginalValues();

}