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

package it.servizidigitali.gestioneenti.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EnteServizio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnteServizio
 * @generated
 */
public class EnteServizioWrapper
	extends BaseModelWrapper<EnteServizio>
	implements EnteServizio, ModelWrapper<EnteServizio> {

	public EnteServizioWrapper(EnteServizio enteServizio) {
		super(enteServizio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("servizioId", getServizioId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uri", getUri());
		attributes.put("uriGuest", getUriGuest());
		attributes.put("uriScheda", getUriScheda());
		attributes.put("autenticazione", isAutenticazione());
		attributes.put("dataInizioAttivazione", getDataInizioAttivazione());
		attributes.put("dataFineAttivazione", getDataFineAttivazione());
		attributes.put("cittadino", isCittadino());
		attributes.put("azienda", isAzienda());
		attributes.put("delega", isDelega());
		attributes.put("chatbot", isChatbot());
		attributes.put("prenotabile", isPrenotabile());
		attributes.put("privacyDelega", isPrivacyDelega());
		attributes.put("allegatoDelega", isAllegatoDelega());
		attributes.put("timbroCertificato", isTimbroCertificato());
		attributes.put("iseeInps", isIseeInps());
		attributes.put("attivo", isAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long servizioId = (Long)attributes.get("servizioId");

		if (servizioId != null) {
			setServizioId(servizioId);
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

		String uri = (String)attributes.get("uri");

		if (uri != null) {
			setUri(uri);
		}

		String uriGuest = (String)attributes.get("uriGuest");

		if (uriGuest != null) {
			setUriGuest(uriGuest);
		}

		String uriScheda = (String)attributes.get("uriScheda");

		if (uriScheda != null) {
			setUriScheda(uriScheda);
		}

		Boolean autenticazione = (Boolean)attributes.get("autenticazione");

		if (autenticazione != null) {
			setAutenticazione(autenticazione);
		}

		Date dataInizioAttivazione = (Date)attributes.get(
			"dataInizioAttivazione");

		if (dataInizioAttivazione != null) {
			setDataInizioAttivazione(dataInizioAttivazione);
		}

		Date dataFineAttivazione = (Date)attributes.get("dataFineAttivazione");

		if (dataFineAttivazione != null) {
			setDataFineAttivazione(dataFineAttivazione);
		}

		Boolean cittadino = (Boolean)attributes.get("cittadino");

		if (cittadino != null) {
			setCittadino(cittadino);
		}

		Boolean azienda = (Boolean)attributes.get("azienda");

		if (azienda != null) {
			setAzienda(azienda);
		}

		Boolean delega = (Boolean)attributes.get("delega");

		if (delega != null) {
			setDelega(delega);
		}

		Boolean chatbot = (Boolean)attributes.get("chatbot");

		if (chatbot != null) {
			setChatbot(chatbot);
		}

		Boolean prenotabile = (Boolean)attributes.get("prenotabile");

		if (prenotabile != null) {
			setPrenotabile(prenotabile);
		}

		Boolean privacyDelega = (Boolean)attributes.get("privacyDelega");

		if (privacyDelega != null) {
			setPrivacyDelega(privacyDelega);
		}

		Boolean allegatoDelega = (Boolean)attributes.get("allegatoDelega");

		if (allegatoDelega != null) {
			setAllegatoDelega(allegatoDelega);
		}

		Boolean timbroCertificato = (Boolean)attributes.get(
			"timbroCertificato");

		if (timbroCertificato != null) {
			setTimbroCertificato(timbroCertificato);
		}

		Boolean iseeInps = (Boolean)attributes.get("iseeInps");

		if (iseeInps != null) {
			setIseeInps(iseeInps);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public EnteServizio cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allegato delega of this ente servizio.
	 *
	 * @return the allegato delega of this ente servizio
	 */
	@Override
	public boolean getAllegatoDelega() {
		return model.getAllegatoDelega();
	}

	/**
	 * Returns the attivo of this ente servizio.
	 *
	 * @return the attivo of this ente servizio
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the autenticazione of this ente servizio.
	 *
	 * @return the autenticazione of this ente servizio
	 */
	@Override
	public boolean getAutenticazione() {
		return model.getAutenticazione();
	}

	/**
	 * Returns the azienda of this ente servizio.
	 *
	 * @return the azienda of this ente servizio
	 */
	@Override
	public boolean getAzienda() {
		return model.getAzienda();
	}

	/**
	 * Returns the chatbot of this ente servizio.
	 *
	 * @return the chatbot of this ente servizio
	 */
	@Override
	public boolean getChatbot() {
		return model.getChatbot();
	}

	/**
	 * Returns the cittadino of this ente servizio.
	 *
	 * @return the cittadino of this ente servizio
	 */
	@Override
	public boolean getCittadino() {
		return model.getCittadino();
	}

	/**
	 * Returns the company ID of this ente servizio.
	 *
	 * @return the company ID of this ente servizio
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ente servizio.
	 *
	 * @return the create date of this ente servizio
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine attivazione of this ente servizio.
	 *
	 * @return the data fine attivazione of this ente servizio
	 */
	@Override
	public Date getDataFineAttivazione() {
		return model.getDataFineAttivazione();
	}

	/**
	 * Returns the data inizio attivazione of this ente servizio.
	 *
	 * @return the data inizio attivazione of this ente servizio
	 */
	@Override
	public Date getDataInizioAttivazione() {
		return model.getDataInizioAttivazione();
	}

	/**
	 * Returns the delega of this ente servizio.
	 *
	 * @return the delega of this ente servizio
	 */
	@Override
	public boolean getDelega() {
		return model.getDelega();
	}

	/**
	 * Returns the group ID of this ente servizio.
	 *
	 * @return the group ID of this ente servizio
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the isee inps of this ente servizio.
	 *
	 * @return the isee inps of this ente servizio
	 */
	@Override
	public boolean getIseeInps() {
		return model.getIseeInps();
	}

	/**
	 * Returns the modified date of this ente servizio.
	 *
	 * @return the modified date of this ente servizio
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this ente servizio.
	 *
	 * @return the organization ID of this ente servizio
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the prenotabile of this ente servizio.
	 *
	 * @return the prenotabile of this ente servizio
	 */
	@Override
	public boolean getPrenotabile() {
		return model.getPrenotabile();
	}

	/**
	 * Returns the primary key of this ente servizio.
	 *
	 * @return the primary key of this ente servizio
	 */
	@Override
	public it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the privacy delega of this ente servizio.
	 *
	 * @return the privacy delega of this ente servizio
	 */
	@Override
	public boolean getPrivacyDelega() {
		return model.getPrivacyDelega();
	}

	/**
	 * Returns the servizio ID of this ente servizio.
	 *
	 * @return the servizio ID of this ente servizio
	 */
	@Override
	public long getServizioId() {
		return model.getServizioId();
	}

	/**
	 * Returns the timbro certificato of this ente servizio.
	 *
	 * @return the timbro certificato of this ente servizio
	 */
	@Override
	public boolean getTimbroCertificato() {
		return model.getTimbroCertificato();
	}

	/**
	 * Returns the uri of this ente servizio.
	 *
	 * @return the uri of this ente servizio
	 */
	@Override
	public String getUri() {
		return model.getUri();
	}

	/**
	 * Returns the uri guest of this ente servizio.
	 *
	 * @return the uri guest of this ente servizio
	 */
	@Override
	public String getUriGuest() {
		return model.getUriGuest();
	}

	/**
	 * Returns the uri scheda of this ente servizio.
	 *
	 * @return the uri scheda of this ente servizio
	 */
	@Override
	public String getUriScheda() {
		return model.getUriScheda();
	}

	/**
	 * Returns the user ID of this ente servizio.
	 *
	 * @return the user ID of this ente servizio
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ente servizio.
	 *
	 * @return the user name of this ente servizio
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ente servizio.
	 *
	 * @return the user uuid of this ente servizio
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ente servizio.
	 *
	 * @return the uuid of this ente servizio
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is allegato delega.
	 *
	 * @return <code>true</code> if this ente servizio is allegato delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllegatoDelega() {
		return model.isAllegatoDelega();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is attivo.
	 *
	 * @return <code>true</code> if this ente servizio is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is autenticazione.
	 *
	 * @return <code>true</code> if this ente servizio is autenticazione; <code>false</code> otherwise
	 */
	@Override
	public boolean isAutenticazione() {
		return model.isAutenticazione();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is azienda.
	 *
	 * @return <code>true</code> if this ente servizio is azienda; <code>false</code> otherwise
	 */
	@Override
	public boolean isAzienda() {
		return model.isAzienda();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is chatbot.
	 *
	 * @return <code>true</code> if this ente servizio is chatbot; <code>false</code> otherwise
	 */
	@Override
	public boolean isChatbot() {
		return model.isChatbot();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is cittadino.
	 *
	 * @return <code>true</code> if this ente servizio is cittadino; <code>false</code> otherwise
	 */
	@Override
	public boolean isCittadino() {
		return model.isCittadino();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is delega.
	 *
	 * @return <code>true</code> if this ente servizio is delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isDelega() {
		return model.isDelega();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is isee inps.
	 *
	 * @return <code>true</code> if this ente servizio is isee inps; <code>false</code> otherwise
	 */
	@Override
	public boolean isIseeInps() {
		return model.isIseeInps();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is prenotabile.
	 *
	 * @return <code>true</code> if this ente servizio is prenotabile; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrenotabile() {
		return model.isPrenotabile();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is privacy delega.
	 *
	 * @return <code>true</code> if this ente servizio is privacy delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrivacyDelega() {
		return model.isPrivacyDelega();
	}

	/**
	 * Returns <code>true</code> if this ente servizio is timbro certificato.
	 *
	 * @return <code>true</code> if this ente servizio is timbro certificato; <code>false</code> otherwise
	 */
	@Override
	public boolean isTimbroCertificato() {
		return model.isTimbroCertificato();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this ente servizio is allegato delega.
	 *
	 * @param allegatoDelega the allegato delega of this ente servizio
	 */
	@Override
	public void setAllegatoDelega(boolean allegatoDelega) {
		model.setAllegatoDelega(allegatoDelega);
	}

	/**
	 * Sets whether this ente servizio is attivo.
	 *
	 * @param attivo the attivo of this ente servizio
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets whether this ente servizio is autenticazione.
	 *
	 * @param autenticazione the autenticazione of this ente servizio
	 */
	@Override
	public void setAutenticazione(boolean autenticazione) {
		model.setAutenticazione(autenticazione);
	}

	/**
	 * Sets whether this ente servizio is azienda.
	 *
	 * @param azienda the azienda of this ente servizio
	 */
	@Override
	public void setAzienda(boolean azienda) {
		model.setAzienda(azienda);
	}

	/**
	 * Sets whether this ente servizio is chatbot.
	 *
	 * @param chatbot the chatbot of this ente servizio
	 */
	@Override
	public void setChatbot(boolean chatbot) {
		model.setChatbot(chatbot);
	}

	/**
	 * Sets whether this ente servizio is cittadino.
	 *
	 * @param cittadino the cittadino of this ente servizio
	 */
	@Override
	public void setCittadino(boolean cittadino) {
		model.setCittadino(cittadino);
	}

	/**
	 * Sets the company ID of this ente servizio.
	 *
	 * @param companyId the company ID of this ente servizio
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ente servizio.
	 *
	 * @param createDate the create date of this ente servizio
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine attivazione of this ente servizio.
	 *
	 * @param dataFineAttivazione the data fine attivazione of this ente servizio
	 */
	@Override
	public void setDataFineAttivazione(Date dataFineAttivazione) {
		model.setDataFineAttivazione(dataFineAttivazione);
	}

	/**
	 * Sets the data inizio attivazione of this ente servizio.
	 *
	 * @param dataInizioAttivazione the data inizio attivazione of this ente servizio
	 */
	@Override
	public void setDataInizioAttivazione(Date dataInizioAttivazione) {
		model.setDataInizioAttivazione(dataInizioAttivazione);
	}

	/**
	 * Sets whether this ente servizio is delega.
	 *
	 * @param delega the delega of this ente servizio
	 */
	@Override
	public void setDelega(boolean delega) {
		model.setDelega(delega);
	}

	/**
	 * Sets the group ID of this ente servizio.
	 *
	 * @param groupId the group ID of this ente servizio
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this ente servizio is isee inps.
	 *
	 * @param iseeInps the isee inps of this ente servizio
	 */
	@Override
	public void setIseeInps(boolean iseeInps) {
		model.setIseeInps(iseeInps);
	}

	/**
	 * Sets the modified date of this ente servizio.
	 *
	 * @param modifiedDate the modified date of this ente servizio
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this ente servizio.
	 *
	 * @param organizationId the organization ID of this ente servizio
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets whether this ente servizio is prenotabile.
	 *
	 * @param prenotabile the prenotabile of this ente servizio
	 */
	@Override
	public void setPrenotabile(boolean prenotabile) {
		model.setPrenotabile(prenotabile);
	}

	/**
	 * Sets the primary key of this ente servizio.
	 *
	 * @param primaryKey the primary key of this ente servizio
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.gestioneenti.service.persistence.EnteServizioPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this ente servizio is privacy delega.
	 *
	 * @param privacyDelega the privacy delega of this ente servizio
	 */
	@Override
	public void setPrivacyDelega(boolean privacyDelega) {
		model.setPrivacyDelega(privacyDelega);
	}

	/**
	 * Sets the servizio ID of this ente servizio.
	 *
	 * @param servizioId the servizio ID of this ente servizio
	 */
	@Override
	public void setServizioId(long servizioId) {
		model.setServizioId(servizioId);
	}

	/**
	 * Sets whether this ente servizio is timbro certificato.
	 *
	 * @param timbroCertificato the timbro certificato of this ente servizio
	 */
	@Override
	public void setTimbroCertificato(boolean timbroCertificato) {
		model.setTimbroCertificato(timbroCertificato);
	}

	/**
	 * Sets the uri of this ente servizio.
	 *
	 * @param uri the uri of this ente servizio
	 */
	@Override
	public void setUri(String uri) {
		model.setUri(uri);
	}

	/**
	 * Sets the uri guest of this ente servizio.
	 *
	 * @param uriGuest the uri guest of this ente servizio
	 */
	@Override
	public void setUriGuest(String uriGuest) {
		model.setUriGuest(uriGuest);
	}

	/**
	 * Sets the uri scheda of this ente servizio.
	 *
	 * @param uriScheda the uri scheda of this ente servizio
	 */
	@Override
	public void setUriScheda(String uriScheda) {
		model.setUriScheda(uriScheda);
	}

	/**
	 * Sets the user ID of this ente servizio.
	 *
	 * @param userId the user ID of this ente servizio
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ente servizio.
	 *
	 * @param userName the user name of this ente servizio
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ente servizio.
	 *
	 * @param userUuid the user uuid of this ente servizio
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ente servizio.
	 *
	 * @param uuid the uuid of this ente servizio
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
	protected EnteServizioWrapper wrap(EnteServizio enteServizio) {
		return new EnteServizioWrapper(enteServizio);
	}

}