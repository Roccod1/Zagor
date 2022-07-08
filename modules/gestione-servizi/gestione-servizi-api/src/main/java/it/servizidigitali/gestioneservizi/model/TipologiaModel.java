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
 * The base model interface for the Tipologia service. Represents a row in the &quot;tipologia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestioneservizi.model.impl.TipologiaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tipologia
 * @generated
 */
@ProviderType
public interface TipologiaModel
	extends BaseModel<Tipologia>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tipologia model instance should use the {@link Tipologia} interface instead.
	 */

	/**
	 * Returns the primary key of this tipologia.
	 *
	 * @return the primary key of this tipologia
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tipologia.
	 *
	 * @param primaryKey the primary key of this tipologia
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this tipologia.
	 *
	 * @return the uuid of this tipologia
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this tipologia.
	 *
	 * @param uuid the uuid of this tipologia
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the tipologia ID of this tipologia.
	 *
	 * @return the tipologia ID of this tipologia
	 */
	public long getTipologiaId();

	/**
	 * Sets the tipologia ID of this tipologia.
	 *
	 * @param tipologiaId the tipologia ID of this tipologia
	 */
	public void setTipologiaId(long tipologiaId);

	/**
	 * Returns the group ID of this tipologia.
	 *
	 * @return the group ID of this tipologia
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this tipologia.
	 *
	 * @param groupId the group ID of this tipologia
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this tipologia.
	 *
	 * @return the company ID of this tipologia
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this tipologia.
	 *
	 * @param companyId the company ID of this tipologia
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tipologia.
	 *
	 * @return the user ID of this tipologia
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this tipologia.
	 *
	 * @param userId the user ID of this tipologia
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tipologia.
	 *
	 * @return the user uuid of this tipologia
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this tipologia.
	 *
	 * @param userUuid the user uuid of this tipologia
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tipologia.
	 *
	 * @return the user name of this tipologia
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this tipologia.
	 *
	 * @param userName the user name of this tipologia
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this tipologia.
	 *
	 * @return the create date of this tipologia
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this tipologia.
	 *
	 * @param createDate the create date of this tipologia
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this tipologia.
	 *
	 * @return the modified date of this tipologia
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tipologia.
	 *
	 * @param modifiedDate the modified date of this tipologia
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nome of this tipologia.
	 *
	 * @return the nome of this tipologia
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this tipologia.
	 *
	 * @param nome the nome of this tipologia
	 */
	public void setNome(String nome);

	/**
	 * Returns the descrizione of this tipologia.
	 *
	 * @return the descrizione of this tipologia
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this tipologia.
	 *
	 * @param descrizione the descrizione of this tipologia
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the visibile of this tipologia.
	 *
	 * @return the visibile of this tipologia
	 */
	public boolean getVisibile();

	/**
	 * Returns <code>true</code> if this tipologia is visibile.
	 *
	 * @return <code>true</code> if this tipologia is visibile; <code>false</code> otherwise
	 */
	public boolean isVisibile();

	/**
	 * Sets whether this tipologia is visibile.
	 *
	 * @param visibile the visibile of this tipologia
	 */
	public void setVisibile(boolean visibile);

	/**
	 * Returns the invio email cittadino of this tipologia.
	 *
	 * @return the invio email cittadino of this tipologia
	 */
	public boolean getInvioEmailCittadino();

	/**
	 * Returns <code>true</code> if this tipologia is invio email cittadino.
	 *
	 * @return <code>true</code> if this tipologia is invio email cittadino; <code>false</code> otherwise
	 */
	public boolean isInvioEmailCittadino();

	/**
	 * Sets whether this tipologia is invio email cittadino.
	 *
	 * @param invioEmailCittadino the invio email cittadino of this tipologia
	 */
	public void setInvioEmailCittadino(boolean invioEmailCittadino);

	/**
	 * Returns the chatbot inline intent of this tipologia.
	 *
	 * @return the chatbot inline intent of this tipologia
	 */
	@AutoEscape
	public String getChatbotInlineIntent();

	/**
	 * Sets the chatbot inline intent of this tipologia.
	 *
	 * @param chatbotInlineIntent the chatbot inline intent of this tipologia
	 */
	public void setChatbotInlineIntent(String chatbotInlineIntent);

	@Override
	public Tipologia cloneWithOriginalValues();

}