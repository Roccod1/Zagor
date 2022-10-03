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

package it.servizidigitali.scrivaniaoperatore.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DestinazioneUso}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUso
 * @generated
 */
public class DestinazioneUsoWrapper
	extends BaseModelWrapper<DestinazioneUso>
	implements DestinazioneUso, ModelWrapper<DestinazioneUso> {

	public DestinazioneUsoWrapper(DestinazioneUso destinazioneUso) {
		super(destinazioneUso);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("destinazioneUsoId", getDestinazioneUsoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("descrizione", getDescrizione());
		attributes.put("pagamentoBollo", isPagamentoBollo());
		attributes.put("importo", getImporto());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long destinazioneUsoId = (Long)attributes.get("destinazioneUsoId");

		if (destinazioneUsoId != null) {
			setDestinazioneUsoId(destinazioneUsoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		Boolean pagamentoBollo = (Boolean)attributes.get("pagamentoBollo");

		if (pagamentoBollo != null) {
			setPagamentoBollo(pagamentoBollo);
		}

		BigDecimal importo = (BigDecimal)attributes.get("importo");

		if (importo != null) {
			setImporto(importo);
		}
	}

	@Override
	public DestinazioneUso cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this destinazione uso.
	 *
	 * @return the company ID of this destinazione uso
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this destinazione uso.
	 *
	 * @return the create date of this destinazione uso
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the descrizione of this destinazione uso.
	 *
	 * @return the descrizione of this destinazione uso
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the destinazione uso ID of this destinazione uso.
	 *
	 * @return the destinazione uso ID of this destinazione uso
	 */
	@Override
	public long getDestinazioneUsoId() {
		return model.getDestinazioneUsoId();
	}

	/**
	 * Returns the group ID of this destinazione uso.
	 *
	 * @return the group ID of this destinazione uso
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the importo of this destinazione uso.
	 *
	 * @return the importo of this destinazione uso
	 */
	@Override
	public BigDecimal getImporto() {
		return model.getImporto();
	}

	/**
	 * Returns the modified date of this destinazione uso.
	 *
	 * @return the modified date of this destinazione uso
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this destinazione uso.
	 *
	 * @return the nome of this destinazione uso
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the pagamento bollo of this destinazione uso.
	 *
	 * @return the pagamento bollo of this destinazione uso
	 */
	@Override
	public boolean getPagamentoBollo() {
		return model.getPagamentoBollo();
	}

	/**
	 * Returns the primary key of this destinazione uso.
	 *
	 * @return the primary key of this destinazione uso
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this destinazione uso.
	 *
	 * @return the user ID of this destinazione uso
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this destinazione uso.
	 *
	 * @return the user name of this destinazione uso
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this destinazione uso.
	 *
	 * @return the user uuid of this destinazione uso
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this destinazione uso.
	 *
	 * @return the uuid of this destinazione uso
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this destinazione uso is pagamento bollo.
	 *
	 * @return <code>true</code> if this destinazione uso is pagamento bollo; <code>false</code> otherwise
	 */
	@Override
	public boolean isPagamentoBollo() {
		return model.isPagamentoBollo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this destinazione uso.
	 *
	 * @param companyId the company ID of this destinazione uso
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this destinazione uso.
	 *
	 * @param createDate the create date of this destinazione uso
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the descrizione of this destinazione uso.
	 *
	 * @param descrizione the descrizione of this destinazione uso
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the destinazione uso ID of this destinazione uso.
	 *
	 * @param destinazioneUsoId the destinazione uso ID of this destinazione uso
	 */
	@Override
	public void setDestinazioneUsoId(long destinazioneUsoId) {
		model.setDestinazioneUsoId(destinazioneUsoId);
	}

	/**
	 * Sets the group ID of this destinazione uso.
	 *
	 * @param groupId the group ID of this destinazione uso
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the importo of this destinazione uso.
	 *
	 * @param importo the importo of this destinazione uso
	 */
	@Override
	public void setImporto(BigDecimal importo) {
		model.setImporto(importo);
	}

	/**
	 * Sets the modified date of this destinazione uso.
	 *
	 * @param modifiedDate the modified date of this destinazione uso
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this destinazione uso.
	 *
	 * @param nome the nome of this destinazione uso
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets whether this destinazione uso is pagamento bollo.
	 *
	 * @param pagamentoBollo the pagamento bollo of this destinazione uso
	 */
	@Override
	public void setPagamentoBollo(boolean pagamentoBollo) {
		model.setPagamentoBollo(pagamentoBollo);
	}

	/**
	 * Sets the primary key of this destinazione uso.
	 *
	 * @param primaryKey the primary key of this destinazione uso
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this destinazione uso.
	 *
	 * @param userId the user ID of this destinazione uso
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this destinazione uso.
	 *
	 * @param userName the user name of this destinazione uso
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this destinazione uso.
	 *
	 * @param userUuid the user uuid of this destinazione uso
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this destinazione uso.
	 *
	 * @param uuid the uuid of this destinazione uso
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DestinazioneUsoWrapper wrap(DestinazioneUso destinazioneUso) {
		return new DestinazioneUsoWrapper(destinazioneUso);
	}

}