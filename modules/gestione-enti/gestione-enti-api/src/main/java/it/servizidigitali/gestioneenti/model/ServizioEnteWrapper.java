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
 * This class is a wrapper for {@link ServizioEnte}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEnte
 * @generated
 */
public class ServizioEnteWrapper
	extends BaseModelWrapper<ServizioEnte>
	implements ModelWrapper<ServizioEnte>, ServizioEnte {

	public ServizioEnteWrapper(ServizioEnte servizioEnte) {
		super(servizioEnte);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("servizioId", getServizioId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("privateLayoutId", getPrivateLayoutId());
		attributes.put("publicLayoutId", getPublicLayoutId());
		attributes.put("uriEsterna", getUriEsterna());
		attributes.put(
			"catalogoServizioArticleId", getCatalogoServizioArticleId());
		attributes.put("subOrganizationId", getSubOrganizationId());
		attributes.put("autenticazione", isAutenticazione());
		attributes.put("livelloAutenticazione", getLivelloAutenticazione());
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

		Long servizioId = (Long)attributes.get("servizioId");

		if (servizioId != null) {
			setServizioId(servizioId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
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

		Long privateLayoutId = (Long)attributes.get("privateLayoutId");

		if (privateLayoutId != null) {
			setPrivateLayoutId(privateLayoutId);
		}

		Long publicLayoutId = (Long)attributes.get("publicLayoutId");

		if (publicLayoutId != null) {
			setPublicLayoutId(publicLayoutId);
		}

		String uriEsterna = (String)attributes.get("uriEsterna");

		if (uriEsterna != null) {
			setUriEsterna(uriEsterna);
		}

		Long catalogoServizioArticleId = (Long)attributes.get(
			"catalogoServizioArticleId");

		if (catalogoServizioArticleId != null) {
			setCatalogoServizioArticleId(catalogoServizioArticleId);
		}

		Long subOrganizationId = (Long)attributes.get("subOrganizationId");

		if (subOrganizationId != null) {
			setSubOrganizationId(subOrganizationId);
		}

		Boolean autenticazione = (Boolean)attributes.get("autenticazione");

		if (autenticazione != null) {
			setAutenticazione(autenticazione);
		}

		Integer livelloAutenticazione = (Integer)attributes.get(
			"livelloAutenticazione");

		if (livelloAutenticazione != null) {
			setLivelloAutenticazione(livelloAutenticazione);
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
	public ServizioEnte cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allegato delega of this servizio ente.
	 *
	 * @return the allegato delega of this servizio ente
	 */
	@Override
	public boolean getAllegatoDelega() {
		return model.getAllegatoDelega();
	}

	/**
	 * Returns the attivo of this servizio ente.
	 *
	 * @return the attivo of this servizio ente
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the autenticazione of this servizio ente.
	 *
	 * @return the autenticazione of this servizio ente
	 */
	@Override
	public boolean getAutenticazione() {
		return model.getAutenticazione();
	}

	/**
	 * Returns the azienda of this servizio ente.
	 *
	 * @return the azienda of this servizio ente
	 */
	@Override
	public boolean getAzienda() {
		return model.getAzienda();
	}

	/**
	 * Returns the catalogo servizio article ID of this servizio ente.
	 *
	 * @return the catalogo servizio article ID of this servizio ente
	 */
	@Override
	public long getCatalogoServizioArticleId() {
		return model.getCatalogoServizioArticleId();
	}

	/**
	 * Returns the chatbot of this servizio ente.
	 *
	 * @return the chatbot of this servizio ente
	 */
	@Override
	public boolean getChatbot() {
		return model.getChatbot();
	}

	/**
	 * Returns the cittadino of this servizio ente.
	 *
	 * @return the cittadino of this servizio ente
	 */
	@Override
	public boolean getCittadino() {
		return model.getCittadino();
	}

	@Override
	public String getCodiceIPA() {
		return model.getCodiceIPA();
	}

	/**
	 * Returns the company ID of this servizio ente.
	 *
	 * @return the company ID of this servizio ente
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this servizio ente.
	 *
	 * @return the create date of this servizio ente
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data fine attivazione of this servizio ente.
	 *
	 * @return the data fine attivazione of this servizio ente
	 */
	@Override
	public Date getDataFineAttivazione() {
		return model.getDataFineAttivazione();
	}

	/**
	 * Returns the data inizio attivazione of this servizio ente.
	 *
	 * @return the data inizio attivazione of this servizio ente
	 */
	@Override
	public Date getDataInizioAttivazione() {
		return model.getDataInizioAttivazione();
	}

	/**
	 * Returns the delega of this servizio ente.
	 *
	 * @return the delega of this servizio ente
	 */
	@Override
	public boolean getDelega() {
		return model.getDelega();
	}

	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the group ID of this servizio ente.
	 *
	 * @return the group ID of this servizio ente
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the isee inps of this servizio ente.
	 *
	 * @return the isee inps of this servizio ente
	 */
	@Override
	public boolean getIseeInps() {
		return model.getIseeInps();
	}

	/**
	 * Returns the livello autenticazione of this servizio ente.
	 *
	 * @return the livello autenticazione of this servizio ente
	 */
	@Override
	public int getLivelloAutenticazione() {
		return model.getLivelloAutenticazione();
	}

	/**
	 * Returns the modified date of this servizio ente.
	 *
	 * @return the modified date of this servizio ente
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	@Override
	public String getNome() {
		return model.getNome();
	}

	@Override
	public com.liferay.portal.kernel.model.Organization getOrganization() {
		return model.getOrganization();
	}

	/**
	 * Returns the organization ID of this servizio ente.
	 *
	 * @return the organization ID of this servizio ente
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the prenotabile of this servizio ente.
	 *
	 * @return the prenotabile of this servizio ente
	 */
	@Override
	public boolean getPrenotabile() {
		return model.getPrenotabile();
	}

	/**
	 * Returns the primary key of this servizio ente.
	 *
	 * @return the primary key of this servizio ente
	 */
	@Override
	public it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the privacy delega of this servizio ente.
	 *
	 * @return the privacy delega of this servizio ente
	 */
	@Override
	public boolean getPrivacyDelega() {
		return model.getPrivacyDelega();
	}

	/**
	 * Returns the private layout ID of this servizio ente.
	 *
	 * @return the private layout ID of this servizio ente
	 */
	@Override
	public long getPrivateLayoutId() {
		return model.getPrivateLayoutId();
	}

	/**
	 * Returns the public layout ID of this servizio ente.
	 *
	 * @return the public layout ID of this servizio ente
	 */
	@Override
	public long getPublicLayoutId() {
		return model.getPublicLayoutId();
	}

	/**
	 * Returns the servizio ID of this servizio ente.
	 *
	 * @return the servizio ID of this servizio ente
	 */
	@Override
	public long getServizioId() {
		return model.getServizioId();
	}

	/**
	 * Returns the sub organization ID of this servizio ente.
	 *
	 * @return the sub organization ID of this servizio ente
	 */
	@Override
	public long getSubOrganizationId() {
		return model.getSubOrganizationId();
	}

	/**
	 * Returns the timbro certificato of this servizio ente.
	 *
	 * @return the timbro certificato of this servizio ente
	 */
	@Override
	public boolean getTimbroCertificato() {
		return model.getTimbroCertificato();
	}

	/**
	 * Returns the uri esterna of this servizio ente.
	 *
	 * @return the uri esterna of this servizio ente
	 */
	@Override
	public String getUriEsterna() {
		return model.getUriEsterna();
	}

	/**
	 * Returns the user ID of this servizio ente.
	 *
	 * @return the user ID of this servizio ente
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this servizio ente.
	 *
	 * @return the user name of this servizio ente
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this servizio ente.
	 *
	 * @return the user uuid of this servizio ente
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this servizio ente.
	 *
	 * @return the uuid of this servizio ente
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is allegato delega.
	 *
	 * @return <code>true</code> if this servizio ente is allegato delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllegatoDelega() {
		return model.isAllegatoDelega();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is attivo.
	 *
	 * @return <code>true</code> if this servizio ente is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is autenticazione.
	 *
	 * @return <code>true</code> if this servizio ente is autenticazione; <code>false</code> otherwise
	 */
	@Override
	public boolean isAutenticazione() {
		return model.isAutenticazione();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is azienda.
	 *
	 * @return <code>true</code> if this servizio ente is azienda; <code>false</code> otherwise
	 */
	@Override
	public boolean isAzienda() {
		return model.isAzienda();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is chatbot.
	 *
	 * @return <code>true</code> if this servizio ente is chatbot; <code>false</code> otherwise
	 */
	@Override
	public boolean isChatbot() {
		return model.isChatbot();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is cittadino.
	 *
	 * @return <code>true</code> if this servizio ente is cittadino; <code>false</code> otherwise
	 */
	@Override
	public boolean isCittadino() {
		return model.isCittadino();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is delega.
	 *
	 * @return <code>true</code> if this servizio ente is delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isDelega() {
		return model.isDelega();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is isee inps.
	 *
	 * @return <code>true</code> if this servizio ente is isee inps; <code>false</code> otherwise
	 */
	@Override
	public boolean isIseeInps() {
		return model.isIseeInps();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is prenotabile.
	 *
	 * @return <code>true</code> if this servizio ente is prenotabile; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrenotabile() {
		return model.isPrenotabile();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is privacy delega.
	 *
	 * @return <code>true</code> if this servizio ente is privacy delega; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrivacyDelega() {
		return model.isPrivacyDelega();
	}

	/**
	 * Returns <code>true</code> if this servizio ente is timbro certificato.
	 *
	 * @return <code>true</code> if this servizio ente is timbro certificato; <code>false</code> otherwise
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
	 * Sets whether this servizio ente is allegato delega.
	 *
	 * @param allegatoDelega the allegato delega of this servizio ente
	 */
	@Override
	public void setAllegatoDelega(boolean allegatoDelega) {
		model.setAllegatoDelega(allegatoDelega);
	}

	/**
	 * Sets whether this servizio ente is attivo.
	 *
	 * @param attivo the attivo of this servizio ente
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets whether this servizio ente is autenticazione.
	 *
	 * @param autenticazione the autenticazione of this servizio ente
	 */
	@Override
	public void setAutenticazione(boolean autenticazione) {
		model.setAutenticazione(autenticazione);
	}

	/**
	 * Sets whether this servizio ente is azienda.
	 *
	 * @param azienda the azienda of this servizio ente
	 */
	@Override
	public void setAzienda(boolean azienda) {
		model.setAzienda(azienda);
	}

	/**
	 * Sets the catalogo servizio article ID of this servizio ente.
	 *
	 * @param catalogoServizioArticleId the catalogo servizio article ID of this servizio ente
	 */
	@Override
	public void setCatalogoServizioArticleId(long catalogoServizioArticleId) {
		model.setCatalogoServizioArticleId(catalogoServizioArticleId);
	}

	/**
	 * Sets whether this servizio ente is chatbot.
	 *
	 * @param chatbot the chatbot of this servizio ente
	 */
	@Override
	public void setChatbot(boolean chatbot) {
		model.setChatbot(chatbot);
	}

	/**
	 * Sets whether this servizio ente is cittadino.
	 *
	 * @param cittadino the cittadino of this servizio ente
	 */
	@Override
	public void setCittadino(boolean cittadino) {
		model.setCittadino(cittadino);
	}

	@Override
	public void setCodiceIPA(String codiceIPA) {
		model.setCodiceIPA(codiceIPA);
	}

	/**
	 * Sets the company ID of this servizio ente.
	 *
	 * @param companyId the company ID of this servizio ente
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this servizio ente.
	 *
	 * @param createDate the create date of this servizio ente
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine attivazione of this servizio ente.
	 *
	 * @param dataFineAttivazione the data fine attivazione of this servizio ente
	 */
	@Override
	public void setDataFineAttivazione(Date dataFineAttivazione) {
		model.setDataFineAttivazione(dataFineAttivazione);
	}

	/**
	 * Sets the data inizio attivazione of this servizio ente.
	 *
	 * @param dataInizioAttivazione the data inizio attivazione of this servizio ente
	 */
	@Override
	public void setDataInizioAttivazione(Date dataInizioAttivazione) {
		model.setDataInizioAttivazione(dataInizioAttivazione);
	}

	/**
	 * Sets whether this servizio ente is delega.
	 *
	 * @param delega the delega of this servizio ente
	 */
	@Override
	public void setDelega(boolean delega) {
		model.setDelega(delega);
	}

	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the group ID of this servizio ente.
	 *
	 * @param groupId the group ID of this servizio ente
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this servizio ente is isee inps.
	 *
	 * @param iseeInps the isee inps of this servizio ente
	 */
	@Override
	public void setIseeInps(boolean iseeInps) {
		model.setIseeInps(iseeInps);
	}

	/**
	 * Sets the livello autenticazione of this servizio ente.
	 *
	 * @param livelloAutenticazione the livello autenticazione of this servizio ente
	 */
	@Override
	public void setLivelloAutenticazione(int livelloAutenticazione) {
		model.setLivelloAutenticazione(livelloAutenticazione);
	}

	/**
	 * Sets the modified date of this servizio ente.
	 *
	 * @param modifiedDate the modified date of this servizio ente
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	@Override
	public void setOrganization(
		com.liferay.portal.kernel.model.Organization organization) {

		model.setOrganization(organization);
	}

	/**
	 * Sets the organization ID of this servizio ente.
	 *
	 * @param organizationId the organization ID of this servizio ente
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets whether this servizio ente is prenotabile.
	 *
	 * @param prenotabile the prenotabile of this servizio ente
	 */
	@Override
	public void setPrenotabile(boolean prenotabile) {
		model.setPrenotabile(prenotabile);
	}

	/**
	 * Sets the primary key of this servizio ente.
	 *
	 * @param primaryKey the primary key of this servizio ente
	 */
	@Override
	public void setPrimaryKey(
		it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this servizio ente is privacy delega.
	 *
	 * @param privacyDelega the privacy delega of this servizio ente
	 */
	@Override
	public void setPrivacyDelega(boolean privacyDelega) {
		model.setPrivacyDelega(privacyDelega);
	}

	/**
	 * Sets the private layout ID of this servizio ente.
	 *
	 * @param privateLayoutId the private layout ID of this servizio ente
	 */
	@Override
	public void setPrivateLayoutId(long privateLayoutId) {
		model.setPrivateLayoutId(privateLayoutId);
	}

	/**
	 * Sets the public layout ID of this servizio ente.
	 *
	 * @param publicLayoutId the public layout ID of this servizio ente
	 */
	@Override
	public void setPublicLayoutId(long publicLayoutId) {
		model.setPublicLayoutId(publicLayoutId);
	}

	/**
	 * Sets the servizio ID of this servizio ente.
	 *
	 * @param servizioId the servizio ID of this servizio ente
	 */
	@Override
	public void setServizioId(long servizioId) {
		model.setServizioId(servizioId);
	}

	/**
	 * Sets the sub organization ID of this servizio ente.
	 *
	 * @param subOrganizationId the sub organization ID of this servizio ente
	 */
	@Override
	public void setSubOrganizationId(long subOrganizationId) {
		model.setSubOrganizationId(subOrganizationId);
	}

	/**
	 * Sets whether this servizio ente is timbro certificato.
	 *
	 * @param timbroCertificato the timbro certificato of this servizio ente
	 */
	@Override
	public void setTimbroCertificato(boolean timbroCertificato) {
		model.setTimbroCertificato(timbroCertificato);
	}

	/**
	 * Sets the uri esterna of this servizio ente.
	 *
	 * @param uriEsterna the uri esterna of this servizio ente
	 */
	@Override
	public void setUriEsterna(String uriEsterna) {
		model.setUriEsterna(uriEsterna);
	}

	/**
	 * Sets the user ID of this servizio ente.
	 *
	 * @param userId the user ID of this servizio ente
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this servizio ente.
	 *
	 * @param userName the user name of this servizio ente
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this servizio ente.
	 *
	 * @param userUuid the user uuid of this servizio ente
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this servizio ente.
	 *
	 * @param uuid the uuid of this servizio ente
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
	protected ServizioEnteWrapper wrap(ServizioEnte servizioEnte) {
		return new ServizioEnteWrapper(servizioEnte);
	}

}