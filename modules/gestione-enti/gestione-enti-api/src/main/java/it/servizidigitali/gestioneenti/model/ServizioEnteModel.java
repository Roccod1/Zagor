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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ServizioEnte service. Represents a row in the &quot;servizio_ente&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestioneenti.model.impl.ServizioEnteImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioEnte
 * @generated
 */
@ProviderType
public interface ServizioEnteModel
	extends BaseModel<ServizioEnte>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a servizio ente model instance should use the {@link ServizioEnte} interface instead.
	 */

	/**
	 * Returns the primary key of this servizio ente.
	 *
	 * @return the primary key of this servizio ente
	 */
	public ServizioEntePK getPrimaryKey();

	/**
	 * Sets the primary key of this servizio ente.
	 *
	 * @param primaryKey the primary key of this servizio ente
	 */
	public void setPrimaryKey(ServizioEntePK primaryKey);

	/**
	 * Returns the uuid of this servizio ente.
	 *
	 * @return the uuid of this servizio ente
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this servizio ente.
	 *
	 * @param uuid the uuid of this servizio ente
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the servizio ID of this servizio ente.
	 *
	 * @return the servizio ID of this servizio ente
	 */
	public long getServizioId();

	/**
	 * Sets the servizio ID of this servizio ente.
	 *
	 * @param servizioId the servizio ID of this servizio ente
	 */
	public void setServizioId(long servizioId);

	/**
	 * Returns the organization ID of this servizio ente.
	 *
	 * @return the organization ID of this servizio ente
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this servizio ente.
	 *
	 * @param organizationId the organization ID of this servizio ente
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the group ID of this servizio ente.
	 *
	 * @return the group ID of this servizio ente
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this servizio ente.
	 *
	 * @param groupId the group ID of this servizio ente
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this servizio ente.
	 *
	 * @return the company ID of this servizio ente
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this servizio ente.
	 *
	 * @param companyId the company ID of this servizio ente
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this servizio ente.
	 *
	 * @return the user ID of this servizio ente
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this servizio ente.
	 *
	 * @param userId the user ID of this servizio ente
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this servizio ente.
	 *
	 * @return the user uuid of this servizio ente
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this servizio ente.
	 *
	 * @param userUuid the user uuid of this servizio ente
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this servizio ente.
	 *
	 * @return the user name of this servizio ente
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this servizio ente.
	 *
	 * @param userName the user name of this servizio ente
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this servizio ente.
	 *
	 * @return the create date of this servizio ente
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this servizio ente.
	 *
	 * @param createDate the create date of this servizio ente
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this servizio ente.
	 *
	 * @return the modified date of this servizio ente
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this servizio ente.
	 *
	 * @param modifiedDate the modified date of this servizio ente
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the uri of this servizio ente.
	 *
	 * @return the uri of this servizio ente
	 */
	@AutoEscape
	public String getUri();

	/**
	 * Sets the uri of this servizio ente.
	 *
	 * @param uri the uri of this servizio ente
	 */
	public void setUri(String uri);

	/**
	 * Returns the uri guest of this servizio ente.
	 *
	 * @return the uri guest of this servizio ente
	 */
	@AutoEscape
	public String getUriGuest();

	/**
	 * Sets the uri guest of this servizio ente.
	 *
	 * @param uriGuest the uri guest of this servizio ente
	 */
	public void setUriGuest(String uriGuest);

	/**
	 * Returns the catalogo servizio article ID of this servizio ente.
	 *
	 * @return the catalogo servizio article ID of this servizio ente
	 */
	public long getCatalogoServizioArticleId();

	/**
	 * Sets the catalogo servizio article ID of this servizio ente.
	 *
	 * @param catalogoServizioArticleId the catalogo servizio article ID of this servizio ente
	 */
	public void setCatalogoServizioArticleId(long catalogoServizioArticleId);

	/**
	 * Returns the autenticazione of this servizio ente.
	 *
	 * @return the autenticazione of this servizio ente
	 */
	public boolean getAutenticazione();

	/**
	 * Returns <code>true</code> if this servizio ente is autenticazione.
	 *
	 * @return <code>true</code> if this servizio ente is autenticazione; <code>false</code> otherwise
	 */
	public boolean isAutenticazione();

	/**
	 * Sets whether this servizio ente is autenticazione.
	 *
	 * @param autenticazione the autenticazione of this servizio ente
	 */
	public void setAutenticazione(boolean autenticazione);

	/**
	 * Returns the livello autenticazione of this servizio ente.
	 *
	 * @return the livello autenticazione of this servizio ente
	 */
	public int getLivelloAutenticazione();

	/**
	 * Sets the livello autenticazione of this servizio ente.
	 *
	 * @param livelloAutenticazione the livello autenticazione of this servizio ente
	 */
	public void setLivelloAutenticazione(int livelloAutenticazione);

	/**
	 * Returns the data inizio attivazione of this servizio ente.
	 *
	 * @return the data inizio attivazione of this servizio ente
	 */
	public Date getDataInizioAttivazione();

	/**
	 * Sets the data inizio attivazione of this servizio ente.
	 *
	 * @param dataInizioAttivazione the data inizio attivazione of this servizio ente
	 */
	public void setDataInizioAttivazione(Date dataInizioAttivazione);

	/**
	 * Returns the data fine attivazione of this servizio ente.
	 *
	 * @return the data fine attivazione of this servizio ente
	 */
	public Date getDataFineAttivazione();

	/**
	 * Sets the data fine attivazione of this servizio ente.
	 *
	 * @param dataFineAttivazione the data fine attivazione of this servizio ente
	 */
	public void setDataFineAttivazione(Date dataFineAttivazione);

	/**
	 * Returns the cittadino of this servizio ente.
	 *
	 * @return the cittadino of this servizio ente
	 */
	public boolean getCittadino();

	/**
	 * Returns <code>true</code> if this servizio ente is cittadino.
	 *
	 * @return <code>true</code> if this servizio ente is cittadino; <code>false</code> otherwise
	 */
	public boolean isCittadino();

	/**
	 * Sets whether this servizio ente is cittadino.
	 *
	 * @param cittadino the cittadino of this servizio ente
	 */
	public void setCittadino(boolean cittadino);

	/**
	 * Returns the azienda of this servizio ente.
	 *
	 * @return the azienda of this servizio ente
	 */
	public boolean getAzienda();

	/**
	 * Returns <code>true</code> if this servizio ente is azienda.
	 *
	 * @return <code>true</code> if this servizio ente is azienda; <code>false</code> otherwise
	 */
	public boolean isAzienda();

	/**
	 * Sets whether this servizio ente is azienda.
	 *
	 * @param azienda the azienda of this servizio ente
	 */
	public void setAzienda(boolean azienda);

	/**
	 * Returns the delega of this servizio ente.
	 *
	 * @return the delega of this servizio ente
	 */
	public boolean getDelega();

	/**
	 * Returns <code>true</code> if this servizio ente is delega.
	 *
	 * @return <code>true</code> if this servizio ente is delega; <code>false</code> otherwise
	 */
	public boolean isDelega();

	/**
	 * Sets whether this servizio ente is delega.
	 *
	 * @param delega the delega of this servizio ente
	 */
	public void setDelega(boolean delega);

	/**
	 * Returns the chatbot of this servizio ente.
	 *
	 * @return the chatbot of this servizio ente
	 */
	public boolean getChatbot();

	/**
	 * Returns <code>true</code> if this servizio ente is chatbot.
	 *
	 * @return <code>true</code> if this servizio ente is chatbot; <code>false</code> otherwise
	 */
	public boolean isChatbot();

	/**
	 * Sets whether this servizio ente is chatbot.
	 *
	 * @param chatbot the chatbot of this servizio ente
	 */
	public void setChatbot(boolean chatbot);

	/**
	 * Returns the prenotabile of this servizio ente.
	 *
	 * @return the prenotabile of this servizio ente
	 */
	public boolean getPrenotabile();

	/**
	 * Returns <code>true</code> if this servizio ente is prenotabile.
	 *
	 * @return <code>true</code> if this servizio ente is prenotabile; <code>false</code> otherwise
	 */
	public boolean isPrenotabile();

	/**
	 * Sets whether this servizio ente is prenotabile.
	 *
	 * @param prenotabile the prenotabile of this servizio ente
	 */
	public void setPrenotabile(boolean prenotabile);

	/**
	 * Returns the privacy delega of this servizio ente.
	 *
	 * @return the privacy delega of this servizio ente
	 */
	public boolean getPrivacyDelega();

	/**
	 * Returns <code>true</code> if this servizio ente is privacy delega.
	 *
	 * @return <code>true</code> if this servizio ente is privacy delega; <code>false</code> otherwise
	 */
	public boolean isPrivacyDelega();

	/**
	 * Sets whether this servizio ente is privacy delega.
	 *
	 * @param privacyDelega the privacy delega of this servizio ente
	 */
	public void setPrivacyDelega(boolean privacyDelega);

	/**
	 * Returns the allegato delega of this servizio ente.
	 *
	 * @return the allegato delega of this servizio ente
	 */
	public boolean getAllegatoDelega();

	/**
	 * Returns <code>true</code> if this servizio ente is allegato delega.
	 *
	 * @return <code>true</code> if this servizio ente is allegato delega; <code>false</code> otherwise
	 */
	public boolean isAllegatoDelega();

	/**
	 * Sets whether this servizio ente is allegato delega.
	 *
	 * @param allegatoDelega the allegato delega of this servizio ente
	 */
	public void setAllegatoDelega(boolean allegatoDelega);

	/**
	 * Returns the timbro certificato of this servizio ente.
	 *
	 * @return the timbro certificato of this servizio ente
	 */
	public boolean getTimbroCertificato();

	/**
	 * Returns <code>true</code> if this servizio ente is timbro certificato.
	 *
	 * @return <code>true</code> if this servizio ente is timbro certificato; <code>false</code> otherwise
	 */
	public boolean isTimbroCertificato();

	/**
	 * Sets whether this servizio ente is timbro certificato.
	 *
	 * @param timbroCertificato the timbro certificato of this servizio ente
	 */
	public void setTimbroCertificato(boolean timbroCertificato);

	/**
	 * Returns the isee inps of this servizio ente.
	 *
	 * @return the isee inps of this servizio ente
	 */
	public boolean getIseeInps();

	/**
	 * Returns <code>true</code> if this servizio ente is isee inps.
	 *
	 * @return <code>true</code> if this servizio ente is isee inps; <code>false</code> otherwise
	 */
	public boolean isIseeInps();

	/**
	 * Sets whether this servizio ente is isee inps.
	 *
	 * @param iseeInps the isee inps of this servizio ente
	 */
	public void setIseeInps(boolean iseeInps);

	/**
	 * Returns the attivo of this servizio ente.
	 *
	 * @return the attivo of this servizio ente
	 */
	public boolean getAttivo();

	/**
	 * Returns <code>true</code> if this servizio ente is attivo.
	 *
	 * @return <code>true</code> if this servizio ente is attivo; <code>false</code> otherwise
	 */
	public boolean isAttivo();

	/**
	 * Sets whether this servizio ente is attivo.
	 *
	 * @param attivo the attivo of this servizio ente
	 */
	public void setAttivo(boolean attivo);

	@Override
	public ServizioEnte cloneWithOriginalValues();

}