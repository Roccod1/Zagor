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

package it.servizidigitali.gestioneservizi.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AreaTematica service. Represents a row in the &quot;area_tematica&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestioneservizi.model.impl.AreaTematicaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaTematica
 * @generated
 */
@ProviderType
public interface AreaTematicaModel
	extends BaseModel<AreaTematica>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a area tematica model instance should use the {@link AreaTematica} interface instead.
	 */

	/**
	 * Returns the primary key of this area tematica.
	 *
	 * @return the primary key of this area tematica
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this area tematica.
	 *
	 * @param primaryKey the primary key of this area tematica
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this area tematica.
	 *
	 * @return the uuid of this area tematica
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this area tematica.
	 *
	 * @param uuid the uuid of this area tematica
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the area tematica ID of this area tematica.
	 *
	 * @return the area tematica ID of this area tematica
	 */
	public long getAreaTematicaId();

	/**
	 * Sets the area tematica ID of this area tematica.
	 *
	 * @param areaTematicaId the area tematica ID of this area tematica
	 */
	public void setAreaTematicaId(long areaTematicaId);

	/**
	 * Returns the group ID of this area tematica.
	 *
	 * @return the group ID of this area tematica
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this area tematica.
	 *
	 * @param groupId the group ID of this area tematica
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this area tematica.
	 *
	 * @return the company ID of this area tematica
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this area tematica.
	 *
	 * @param companyId the company ID of this area tematica
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this area tematica.
	 *
	 * @return the user ID of this area tematica
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this area tematica.
	 *
	 * @param userId the user ID of this area tematica
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this area tematica.
	 *
	 * @return the user uuid of this area tematica
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this area tematica.
	 *
	 * @param userUuid the user uuid of this area tematica
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this area tematica.
	 *
	 * @return the user name of this area tematica
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this area tematica.
	 *
	 * @param userName the user name of this area tematica
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this area tematica.
	 *
	 * @return the create date of this area tematica
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this area tematica.
	 *
	 * @param createDate the create date of this area tematica
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this area tematica.
	 *
	 * @return the modified date of this area tematica
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this area tematica.
	 *
	 * @param modifiedDate the modified date of this area tematica
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nome of this area tematica.
	 *
	 * @return the nome of this area tematica
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this area tematica.
	 *
	 * @param nome the nome of this area tematica
	 */
	public void setNome(String nome);

	/**
	 * Returns the descrizione of this area tematica.
	 *
	 * @return the descrizione of this area tematica
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this area tematica.
	 *
	 * @param descrizione the descrizione of this area tematica
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the codice of this area tematica.
	 *
	 * @return the codice of this area tematica
	 */
	@AutoEscape
	public String getCodice();

	/**
	 * Sets the codice of this area tematica.
	 *
	 * @param codice the codice of this area tematica
	 */
	public void setCodice(String codice);

	/**
	 * Returns the sportello of this area tematica.
	 *
	 * @return the sportello of this area tematica
	 */
	@AutoEscape
	public String getSportello();

	/**
	 * Sets the sportello of this area tematica.
	 *
	 * @param sportello the sportello of this area tematica
	 */
	public void setSportello(String sportello);

	/**
	 * Returns the uri vocabolario of this area tematica.
	 *
	 * @return the uri vocabolario of this area tematica
	 */
	@AutoEscape
	public String getUriVocabolario();

	/**
	 * Sets the uri vocabolario of this area tematica.
	 *
	 * @param uriVocabolario the uri vocabolario of this area tematica
	 */
	public void setUriVocabolario(String uriVocabolario);

	/**
	 * Returns the ordine of this area tematica.
	 *
	 * @return the ordine of this area tematica
	 */
	public int getOrdine();

	/**
	 * Sets the ordine of this area tematica.
	 *
	 * @param ordine the ordine of this area tematica
	 */
	public void setOrdine(int ordine);

	/**
	 * Returns the visibile of this area tematica.
	 *
	 * @return the visibile of this area tematica
	 */
	public boolean getVisibile();

	/**
	 * Returns <code>true</code> if this area tematica is visibile.
	 *
	 * @return <code>true</code> if this area tematica is visibile; <code>false</code> otherwise
	 */
	public boolean isVisibile();

	/**
	 * Sets whether this area tematica is visibile.
	 *
	 * @param visibile the visibile of this area tematica
	 */
	public void setVisibile(boolean visibile);

	/**
	 * Returns the attiva of this area tematica.
	 *
	 * @return the attiva of this area tematica
	 */
	public boolean getAttiva();

	/**
	 * Returns <code>true</code> if this area tematica is attiva.
	 *
	 * @return <code>true</code> if this area tematica is attiva; <code>false</code> otherwise
	 */
	public boolean isAttiva();

	/**
	 * Sets whether this area tematica is attiva.
	 *
	 * @param attiva the attiva of this area tematica
	 */
	public void setAttiva(boolean attiva);

	@Override
	public AreaTematica cloneWithOriginalValues();

}