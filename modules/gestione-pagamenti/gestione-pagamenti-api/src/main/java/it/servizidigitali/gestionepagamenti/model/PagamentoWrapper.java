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

package it.servizidigitali.gestionepagamenti.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Pagamento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Pagamento
 * @generated
 */
public class PagamentoWrapper
	extends BaseModelWrapper<Pagamento>
	implements ModelWrapper<Pagamento>, Pagamento {

	public PagamentoWrapper(Pagamento pagamento) {
		super(pagamento);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("pagamentoId", getPagamentoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("idCredito", getIdCredito());
		attributes.put("idFiscaleCliente", getIdFiscaleCliente());
		attributes.put("denominazioneCliente", getDenominazioneCliente());
		attributes.put("emailQuietanza", getEmailQuietanza());
		attributes.put("causale", getCausale());
		attributes.put("descrizioneServizio", getDescrizioneServizio());
		attributes.put("importo", getImporto());
		attributes.put("commissioni", getCommissioni());
		attributes.put("canale", getCanale());
		attributes.put("iud", getIud());
		attributes.put("iuv", getIuv());
		attributes.put("idSessione", getIdSessione());
		attributes.put("pathAvviso", getPathAvviso());
		attributes.put("emailInviata", isEmailInviata());
		attributes.put("stato", getStato());
		attributes.put("richiestaId", getRichiestaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long pagamentoId = (Long)attributes.get("pagamentoId");

		if (pagamentoId != null) {
			setPagamentoId(pagamentoId);
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

		String idCredito = (String)attributes.get("idCredito");

		if (idCredito != null) {
			setIdCredito(idCredito);
		}

		String idFiscaleCliente = (String)attributes.get("idFiscaleCliente");

		if (idFiscaleCliente != null) {
			setIdFiscaleCliente(idFiscaleCliente);
		}

		String denominazioneCliente = (String)attributes.get(
			"denominazioneCliente");

		if (denominazioneCliente != null) {
			setDenominazioneCliente(denominazioneCliente);
		}

		String emailQuietanza = (String)attributes.get("emailQuietanza");

		if (emailQuietanza != null) {
			setEmailQuietanza(emailQuietanza);
		}

		String causale = (String)attributes.get("causale");

		if (causale != null) {
			setCausale(causale);
		}

		String descrizioneServizio = (String)attributes.get(
			"descrizioneServizio");

		if (descrizioneServizio != null) {
			setDescrizioneServizio(descrizioneServizio);
		}

		BigDecimal importo = (BigDecimal)attributes.get("importo");

		if (importo != null) {
			setImporto(importo);
		}

		BigDecimal commissioni = (BigDecimal)attributes.get("commissioni");

		if (commissioni != null) {
			setCommissioni(commissioni);
		}

		String canale = (String)attributes.get("canale");

		if (canale != null) {
			setCanale(canale);
		}

		String iud = (String)attributes.get("iud");

		if (iud != null) {
			setIud(iud);
		}

		String iuv = (String)attributes.get("iuv");

		if (iuv != null) {
			setIuv(iuv);
		}

		String idSessione = (String)attributes.get("idSessione");

		if (idSessione != null) {
			setIdSessione(idSessione);
		}

		String pathAvviso = (String)attributes.get("pathAvviso");

		if (pathAvviso != null) {
			setPathAvviso(pathAvviso);
		}

		Boolean emailInviata = (Boolean)attributes.get("emailInviata");

		if (emailInviata != null) {
			setEmailInviata(emailInviata);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Long richiestaId = (Long)attributes.get("richiestaId");

		if (richiestaId != null) {
			setRichiestaId(richiestaId);
		}
	}

	@Override
	public Pagamento cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the canale of this pagamento.
	 *
	 * @return the canale of this pagamento
	 */
	@Override
	public String getCanale() {
		return model.getCanale();
	}

	/**
	 * Returns the causale of this pagamento.
	 *
	 * @return the causale of this pagamento
	 */
	@Override
	public String getCausale() {
		return model.getCausale();
	}

	/**
	 * Returns the commissioni of this pagamento.
	 *
	 * @return the commissioni of this pagamento
	 */
	@Override
	public BigDecimal getCommissioni() {
		return model.getCommissioni();
	}

	/**
	 * Returns the company ID of this pagamento.
	 *
	 * @return the company ID of this pagamento
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pagamento.
	 *
	 * @return the create date of this pagamento
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the denominazione cliente of this pagamento.
	 *
	 * @return the denominazione cliente of this pagamento
	 */
	@Override
	public String getDenominazioneCliente() {
		return model.getDenominazioneCliente();
	}

	/**
	 * Returns the descrizione servizio of this pagamento.
	 *
	 * @return the descrizione servizio of this pagamento
	 */
	@Override
	public String getDescrizioneServizio() {
		return model.getDescrizioneServizio();
	}

	/**
	 * Returns the email inviata of this pagamento.
	 *
	 * @return the email inviata of this pagamento
	 */
	@Override
	public boolean getEmailInviata() {
		return model.getEmailInviata();
	}

	/**
	 * Returns the email quietanza of this pagamento.
	 *
	 * @return the email quietanza of this pagamento
	 */
	@Override
	public String getEmailQuietanza() {
		return model.getEmailQuietanza();
	}

	/**
	 * Returns the group ID of this pagamento.
	 *
	 * @return the group ID of this pagamento
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id credito of this pagamento.
	 *
	 * @return the id credito of this pagamento
	 */
	@Override
	public String getIdCredito() {
		return model.getIdCredito();
	}

	/**
	 * Returns the id fiscale cliente of this pagamento.
	 *
	 * @return the id fiscale cliente of this pagamento
	 */
	@Override
	public String getIdFiscaleCliente() {
		return model.getIdFiscaleCliente();
	}

	/**
	 * Returns the id sessione of this pagamento.
	 *
	 * @return the id sessione of this pagamento
	 */
	@Override
	public String getIdSessione() {
		return model.getIdSessione();
	}

	/**
	 * Returns the importo of this pagamento.
	 *
	 * @return the importo of this pagamento
	 */
	@Override
	public BigDecimal getImporto() {
		return model.getImporto();
	}

	/**
	 * Returns the iud of this pagamento.
	 *
	 * @return the iud of this pagamento
	 */
	@Override
	public String getIud() {
		return model.getIud();
	}

	/**
	 * Returns the iuv of this pagamento.
	 *
	 * @return the iuv of this pagamento
	 */
	@Override
	public String getIuv() {
		return model.getIuv();
	}

	/**
	 * Returns the modified date of this pagamento.
	 *
	 * @return the modified date of this pagamento
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pagamento ID of this pagamento.
	 *
	 * @return the pagamento ID of this pagamento
	 */
	@Override
	public long getPagamentoId() {
		return model.getPagamentoId();
	}

	/**
	 * Returns the path avviso of this pagamento.
	 *
	 * @return the path avviso of this pagamento
	 */
	@Override
	public String getPathAvviso() {
		return model.getPathAvviso();
	}

	/**
	 * Returns the primary key of this pagamento.
	 *
	 * @return the primary key of this pagamento
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the richiesta ID of this pagamento.
	 *
	 * @return the richiesta ID of this pagamento
	 */
	@Override
	public long getRichiestaId() {
		return model.getRichiestaId();
	}

	/**
	 * Returns the stato of this pagamento.
	 *
	 * @return the stato of this pagamento
	 */
	@Override
	public String getStato() {
		return model.getStato();
	}

	/**
	 * Returns the user ID of this pagamento.
	 *
	 * @return the user ID of this pagamento
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pagamento.
	 *
	 * @return the user name of this pagamento
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pagamento.
	 *
	 * @return the user uuid of this pagamento
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this pagamento.
	 *
	 * @return the uuid of this pagamento
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this pagamento is email inviata.
	 *
	 * @return <code>true</code> if this pagamento is email inviata; <code>false</code> otherwise
	 */
	@Override
	public boolean isEmailInviata() {
		return model.isEmailInviata();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the canale of this pagamento.
	 *
	 * @param canale the canale of this pagamento
	 */
	@Override
	public void setCanale(String canale) {
		model.setCanale(canale);
	}

	/**
	 * Sets the causale of this pagamento.
	 *
	 * @param causale the causale of this pagamento
	 */
	@Override
	public void setCausale(String causale) {
		model.setCausale(causale);
	}

	/**
	 * Sets the commissioni of this pagamento.
	 *
	 * @param commissioni the commissioni of this pagamento
	 */
	@Override
	public void setCommissioni(BigDecimal commissioni) {
		model.setCommissioni(commissioni);
	}

	/**
	 * Sets the company ID of this pagamento.
	 *
	 * @param companyId the company ID of this pagamento
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pagamento.
	 *
	 * @param createDate the create date of this pagamento
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the denominazione cliente of this pagamento.
	 *
	 * @param denominazioneCliente the denominazione cliente of this pagamento
	 */
	@Override
	public void setDenominazioneCliente(String denominazioneCliente) {
		model.setDenominazioneCliente(denominazioneCliente);
	}

	/**
	 * Sets the descrizione servizio of this pagamento.
	 *
	 * @param descrizioneServizio the descrizione servizio of this pagamento
	 */
	@Override
	public void setDescrizioneServizio(String descrizioneServizio) {
		model.setDescrizioneServizio(descrizioneServizio);
	}

	/**
	 * Sets whether this pagamento is email inviata.
	 *
	 * @param emailInviata the email inviata of this pagamento
	 */
	@Override
	public void setEmailInviata(boolean emailInviata) {
		model.setEmailInviata(emailInviata);
	}

	/**
	 * Sets the email quietanza of this pagamento.
	 *
	 * @param emailQuietanza the email quietanza of this pagamento
	 */
	@Override
	public void setEmailQuietanza(String emailQuietanza) {
		model.setEmailQuietanza(emailQuietanza);
	}

	/**
	 * Sets the group ID of this pagamento.
	 *
	 * @param groupId the group ID of this pagamento
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id credito of this pagamento.
	 *
	 * @param idCredito the id credito of this pagamento
	 */
	@Override
	public void setIdCredito(String idCredito) {
		model.setIdCredito(idCredito);
	}

	/**
	 * Sets the id fiscale cliente of this pagamento.
	 *
	 * @param idFiscaleCliente the id fiscale cliente of this pagamento
	 */
	@Override
	public void setIdFiscaleCliente(String idFiscaleCliente) {
		model.setIdFiscaleCliente(idFiscaleCliente);
	}

	/**
	 * Sets the id sessione of this pagamento.
	 *
	 * @param idSessione the id sessione of this pagamento
	 */
	@Override
	public void setIdSessione(String idSessione) {
		model.setIdSessione(idSessione);
	}

	/**
	 * Sets the importo of this pagamento.
	 *
	 * @param importo the importo of this pagamento
	 */
	@Override
	public void setImporto(BigDecimal importo) {
		model.setImporto(importo);
	}

	/**
	 * Sets the iud of this pagamento.
	 *
	 * @param iud the iud of this pagamento
	 */
	@Override
	public void setIud(String iud) {
		model.setIud(iud);
	}

	/**
	 * Sets the iuv of this pagamento.
	 *
	 * @param iuv the iuv of this pagamento
	 */
	@Override
	public void setIuv(String iuv) {
		model.setIuv(iuv);
	}

	/**
	 * Sets the modified date of this pagamento.
	 *
	 * @param modifiedDate the modified date of this pagamento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pagamento ID of this pagamento.
	 *
	 * @param pagamentoId the pagamento ID of this pagamento
	 */
	@Override
	public void setPagamentoId(long pagamentoId) {
		model.setPagamentoId(pagamentoId);
	}

	/**
	 * Sets the path avviso of this pagamento.
	 *
	 * @param pathAvviso the path avviso of this pagamento
	 */
	@Override
	public void setPathAvviso(String pathAvviso) {
		model.setPathAvviso(pathAvviso);
	}

	/**
	 * Sets the primary key of this pagamento.
	 *
	 * @param primaryKey the primary key of this pagamento
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the richiesta ID of this pagamento.
	 *
	 * @param richiestaId the richiesta ID of this pagamento
	 */
	@Override
	public void setRichiestaId(long richiestaId) {
		model.setRichiestaId(richiestaId);
	}

	/**
	 * Sets the stato of this pagamento.
	 *
	 * @param stato the stato of this pagamento
	 */
	@Override
	public void setStato(String stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the user ID of this pagamento.
	 *
	 * @param userId the user ID of this pagamento
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pagamento.
	 *
	 * @param userName the user name of this pagamento
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pagamento.
	 *
	 * @param userUuid the user uuid of this pagamento
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this pagamento.
	 *
	 * @param uuid the uuid of this pagamento
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
	protected PagamentoWrapper wrap(Pagamento pagamento) {
		return new PagamentoWrapper(pagamento);
	}

}