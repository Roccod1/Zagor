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

package it.servizidigitali.accreditamentoenti.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ResponsabileEnte service. Represents a row in the &quot;responsabile_ente&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.accreditamentoenti.model.impl.ResponsabileEnteImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResponsabileEnte
 * @generated
 */
@ProviderType
public interface ResponsabileEnteModel
	extends BaseModel<ResponsabileEnte>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a responsabile ente model instance should use the {@link ResponsabileEnte} interface instead.
	 */

	/**
	 * Returns the primary key of this responsabile ente.
	 *
	 * @return the primary key of this responsabile ente
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this responsabile ente.
	 *
	 * @param primaryKey the primary key of this responsabile ente
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this responsabile ente.
	 *
	 * @return the uuid of this responsabile ente
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this responsabile ente.
	 *
	 * @param uuid the uuid of this responsabile ente
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the responsabile ente ID of this responsabile ente.
	 *
	 * @return the responsabile ente ID of this responsabile ente
	 */
	public long getResponsabileEnteId();

	/**
	 * Sets the responsabile ente ID of this responsabile ente.
	 *
	 * @param responsabileEnteId the responsabile ente ID of this responsabile ente
	 */
	public void setResponsabileEnteId(long responsabileEnteId);

	/**
	 * Returns the group ID of this responsabile ente.
	 *
	 * @return the group ID of this responsabile ente
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this responsabile ente.
	 *
	 * @param groupId the group ID of this responsabile ente
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this responsabile ente.
	 *
	 * @return the company ID of this responsabile ente
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this responsabile ente.
	 *
	 * @param companyId the company ID of this responsabile ente
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this responsabile ente.
	 *
	 * @return the user ID of this responsabile ente
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this responsabile ente.
	 *
	 * @param userId the user ID of this responsabile ente
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this responsabile ente.
	 *
	 * @return the user uuid of this responsabile ente
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this responsabile ente.
	 *
	 * @param userUuid the user uuid of this responsabile ente
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this responsabile ente.
	 *
	 * @return the user name of this responsabile ente
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this responsabile ente.
	 *
	 * @param userName the user name of this responsabile ente
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this responsabile ente.
	 *
	 * @return the create date of this responsabile ente
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this responsabile ente.
	 *
	 * @param createDate the create date of this responsabile ente
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this responsabile ente.
	 *
	 * @return the modified date of this responsabile ente
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this responsabile ente.
	 *
	 * @param modifiedDate the modified date of this responsabile ente
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the responsabile user ID of this responsabile ente.
	 *
	 * @return the responsabile user ID of this responsabile ente
	 */
	public long getResponsabileUserId();

	/**
	 * Sets the responsabile user ID of this responsabile ente.
	 *
	 * @param responsabileUserId the responsabile user ID of this responsabile ente
	 */
	public void setResponsabileUserId(long responsabileUserId);

	/**
	 * Returns the responsabile user uuid of this responsabile ente.
	 *
	 * @return the responsabile user uuid of this responsabile ente
	 */
	public String getResponsabileUserUuid();

	/**
	 * Sets the responsabile user uuid of this responsabile ente.
	 *
	 * @param responsabileUserUuid the responsabile user uuid of this responsabile ente
	 */
	public void setResponsabileUserUuid(String responsabileUserUuid);

	/**
	 * Returns the ente ID of this responsabile ente.
	 *
	 * @return the ente ID of this responsabile ente
	 */
	public long getEnteId();

	/**
	 * Sets the ente ID of this responsabile ente.
	 *
	 * @param enteId the ente ID of this responsabile ente
	 */
	public void setEnteId(long enteId);

	@Override
	public ResponsabileEnte cloneWithOriginalValues();

}