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

package it.servizidigitali.gestioneprocessi.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Processo service. Represents a row in the &quot;processo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestioneprocessi.model.impl.ProcessoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Processo
 * @generated
 */
@ProviderType
public interface ProcessoModel
	extends BaseModel<Processo>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a processo model instance should use the {@link Processo} interface instead.
	 */

	/**
	 * Returns the primary key of this processo.
	 *
	 * @return the primary key of this processo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this processo.
	 *
	 * @param primaryKey the primary key of this processo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this processo.
	 *
	 * @return the uuid of this processo
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this processo.
	 *
	 * @param uuid the uuid of this processo
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the processo ID of this processo.
	 *
	 * @return the processo ID of this processo
	 */
	public long getProcessoId();

	/**
	 * Sets the processo ID of this processo.
	 *
	 * @param processoId the processo ID of this processo
	 */
	public void setProcessoId(long processoId);

	/**
	 * Returns the group ID of this processo.
	 *
	 * @return the group ID of this processo
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this processo.
	 *
	 * @param groupId the group ID of this processo
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this processo.
	 *
	 * @return the company ID of this processo
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this processo.
	 *
	 * @param companyId the company ID of this processo
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this processo.
	 *
	 * @return the user ID of this processo
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this processo.
	 *
	 * @param userId the user ID of this processo
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this processo.
	 *
	 * @return the user uuid of this processo
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this processo.
	 *
	 * @param userUuid the user uuid of this processo
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this processo.
	 *
	 * @return the user name of this processo
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this processo.
	 *
	 * @param userName the user name of this processo
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this processo.
	 *
	 * @return the create date of this processo
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this processo.
	 *
	 * @param createDate the create date of this processo
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this processo.
	 *
	 * @return the modified date of this processo
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this processo.
	 *
	 * @param modifiedDate the modified date of this processo
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the codice of this processo.
	 *
	 * @return the codice of this processo
	 */
	@AutoEscape
	public String getCodice();

	/**
	 * Sets the codice of this processo.
	 *
	 * @param codice the codice of this processo
	 */
	public void setCodice(String codice);

	/**
	 * Returns the nome of this processo.
	 *
	 * @return the nome of this processo
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this processo.
	 *
	 * @param nome the nome of this processo
	 */
	public void setNome(String nome);

	/**
	 * Returns the stato of this processo.
	 *
	 * @return the stato of this processo
	 */
	@AutoEscape
	public String getStato();

	/**
	 * Sets the stato of this processo.
	 *
	 * @param stato the stato of this processo
	 */
	public void setStato(String stato);

	/**
	 * Returns the multiente of this processo.
	 *
	 * @return the multiente of this processo
	 */
	public boolean getMultiente();

	/**
	 * Returns <code>true</code> if this processo is multiente.
	 *
	 * @return <code>true</code> if this processo is multiente; <code>false</code> otherwise
	 */
	public boolean isMultiente();

	/**
	 * Sets whether this processo is multiente.
	 *
	 * @param multiente the multiente of this processo
	 */
	public void setMultiente(boolean multiente);

	/**
	 * Returns the file entry ID of this processo.
	 *
	 * @return the file entry ID of this processo
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this processo.
	 *
	 * @param fileEntryId the file entry ID of this processo
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the attivo of this processo.
	 *
	 * @return the attivo of this processo
	 */
	public boolean getAttivo();

	/**
	 * Returns <code>true</code> if this processo is attivo.
	 *
	 * @return <code>true</code> if this processo is attivo; <code>false</code> otherwise
	 */
	public boolean isAttivo();

	/**
	 * Sets whether this processo is attivo.
	 *
	 * @param attivo the attivo of this processo
	 */
	public void setAttivo(boolean attivo);

	@Override
	public Processo cloneWithOriginalValues();

}