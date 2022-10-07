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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.math.BigDecimal;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Pagamento service. Represents a row in the &quot;pagamento&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.servizidigitali.gestionepagamenti.model.impl.PagamentoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.servizidigitali.gestionepagamenti.model.impl.PagamentoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Pagamento
 * @generated
 */
@ProviderType
public interface PagamentoModel
	extends BaseModel<Pagamento>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pagamento model instance should use the {@link Pagamento} interface instead.
	 */

	/**
	 * Returns the primary key of this pagamento.
	 *
	 * @return the primary key of this pagamento
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pagamento.
	 *
	 * @param primaryKey the primary key of this pagamento
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this pagamento.
	 *
	 * @return the uuid of this pagamento
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this pagamento.
	 *
	 * @param uuid the uuid of this pagamento
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the pagamento ID of this pagamento.
	 *
	 * @return the pagamento ID of this pagamento
	 */
	public long getPagamentoId();

	/**
	 * Sets the pagamento ID of this pagamento.
	 *
	 * @param pagamentoId the pagamento ID of this pagamento
	 */
	public void setPagamentoId(long pagamentoId);

	/**
	 * Returns the group ID of this pagamento.
	 *
	 * @return the group ID of this pagamento
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this pagamento.
	 *
	 * @param groupId the group ID of this pagamento
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this pagamento.
	 *
	 * @return the company ID of this pagamento
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this pagamento.
	 *
	 * @param companyId the company ID of this pagamento
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this pagamento.
	 *
	 * @return the user ID of this pagamento
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this pagamento.
	 *
	 * @param userId the user ID of this pagamento
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this pagamento.
	 *
	 * @return the user uuid of this pagamento
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this pagamento.
	 *
	 * @param userUuid the user uuid of this pagamento
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this pagamento.
	 *
	 * @return the user name of this pagamento
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this pagamento.
	 *
	 * @param userName the user name of this pagamento
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this pagamento.
	 *
	 * @return the create date of this pagamento
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this pagamento.
	 *
	 * @param createDate the create date of this pagamento
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this pagamento.
	 *
	 * @return the modified date of this pagamento
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this pagamento.
	 *
	 * @param modifiedDate the modified date of this pagamento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the id credito of this pagamento.
	 *
	 * @return the id credito of this pagamento
	 */
	@AutoEscape
	public String getIdCredito();

	/**
	 * Sets the id credito of this pagamento.
	 *
	 * @param idCredito the id credito of this pagamento
	 */
	public void setIdCredito(String idCredito);

	/**
	 * Returns the id fiscale cliente of this pagamento.
	 *
	 * @return the id fiscale cliente of this pagamento
	 */
	@AutoEscape
	public String getIdFiscaleCliente();

	/**
	 * Sets the id fiscale cliente of this pagamento.
	 *
	 * @param idFiscaleCliente the id fiscale cliente of this pagamento
	 */
	public void setIdFiscaleCliente(String idFiscaleCliente);

	/**
	 * Returns the denominazione cliente of this pagamento.
	 *
	 * @return the denominazione cliente of this pagamento
	 */
	@AutoEscape
	public String getDenominazioneCliente();

	/**
	 * Sets the denominazione cliente of this pagamento.
	 *
	 * @param denominazioneCliente the denominazione cliente of this pagamento
	 */
	public void setDenominazioneCliente(String denominazioneCliente);

	/**
	 * Returns the email quietanza of this pagamento.
	 *
	 * @return the email quietanza of this pagamento
	 */
	@AutoEscape
	public String getEmailQuietanza();

	/**
	 * Sets the email quietanza of this pagamento.
	 *
	 * @param emailQuietanza the email quietanza of this pagamento
	 */
	public void setEmailQuietanza(String emailQuietanza);

	/**
	 * Returns the causale of this pagamento.
	 *
	 * @return the causale of this pagamento
	 */
	@AutoEscape
	public String getCausale();

	/**
	 * Sets the causale of this pagamento.
	 *
	 * @param causale the causale of this pagamento
	 */
	public void setCausale(String causale);

	/**
	 * Returns the servizio ID of this pagamento.
	 *
	 * @return the servizio ID of this pagamento
	 */
	public long getServizioId();

	/**
	 * Sets the servizio ID of this pagamento.
	 *
	 * @param servizioId the servizio ID of this pagamento
	 */
	public void setServizioId(long servizioId);

	/**
	 * Returns the nome servizio of this pagamento.
	 *
	 * @return the nome servizio of this pagamento
	 */
	@AutoEscape
	public String getNomeServizio();

	/**
	 * Sets the nome servizio of this pagamento.
	 *
	 * @param nomeServizio the nome servizio of this pagamento
	 */
	public void setNomeServizio(String nomeServizio);

	/**
	 * Returns the importo of this pagamento.
	 *
	 * @return the importo of this pagamento
	 */
	public BigDecimal getImporto();

	/**
	 * Sets the importo of this pagamento.
	 *
	 * @param importo the importo of this pagamento
	 */
	public void setImporto(BigDecimal importo);

	/**
	 * Returns the commissioni of this pagamento.
	 *
	 * @return the commissioni of this pagamento
	 */
	public BigDecimal getCommissioni();

	/**
	 * Sets the commissioni of this pagamento.
	 *
	 * @param commissioni the commissioni of this pagamento
	 */
	public void setCommissioni(BigDecimal commissioni);

	/**
	 * Returns the canale of this pagamento.
	 *
	 * @return the canale of this pagamento
	 */
	@AutoEscape
	public String getCanale();

	/**
	 * Sets the canale of this pagamento.
	 *
	 * @param canale the canale of this pagamento
	 */
	public void setCanale(String canale);

	/**
	 * Returns the gateway of this pagamento.
	 *
	 * @return the gateway of this pagamento
	 */
	@AutoEscape
	public String getGateway();

	/**
	 * Sets the gateway of this pagamento.
	 *
	 * @param gateway the gateway of this pagamento
	 */
	public void setGateway(String gateway);

	/**
	 * Returns the iud of this pagamento.
	 *
	 * @return the iud of this pagamento
	 */
	@AutoEscape
	public String getIud();

	/**
	 * Sets the iud of this pagamento.
	 *
	 * @param iud the iud of this pagamento
	 */
	public void setIud(String iud);

	/**
	 * Returns the iuv of this pagamento.
	 *
	 * @return the iuv of this pagamento
	 */
	@AutoEscape
	public String getIuv();

	/**
	 * Sets the iuv of this pagamento.
	 *
	 * @param iuv the iuv of this pagamento
	 */
	public void setIuv(String iuv);

	/**
	 * Returns the id sessione of this pagamento.
	 *
	 * @return the id sessione of this pagamento
	 */
	@AutoEscape
	public String getIdSessione();

	/**
	 * Sets the id sessione of this pagamento.
	 *
	 * @param idSessione the id sessione of this pagamento
	 */
	public void setIdSessione(String idSessione);

	/**
	 * Returns the path avviso of this pagamento.
	 *
	 * @return the path avviso of this pagamento
	 */
	@AutoEscape
	public String getPathAvviso();

	/**
	 * Sets the path avviso of this pagamento.
	 *
	 * @param pathAvviso the path avviso of this pagamento
	 */
	public void setPathAvviso(String pathAvviso);

	/**
	 * Returns the email inviata of this pagamento.
	 *
	 * @return the email inviata of this pagamento
	 */
	public boolean getEmailInviata();

	/**
	 * Returns <code>true</code> if this pagamento is email inviata.
	 *
	 * @return <code>true</code> if this pagamento is email inviata; <code>false</code> otherwise
	 */
	public boolean isEmailInviata();

	/**
	 * Sets whether this pagamento is email inviata.
	 *
	 * @param emailInviata the email inviata of this pagamento
	 */
	public void setEmailInviata(boolean emailInviata);

	/**
	 * Returns the stato of this pagamento.
	 *
	 * @return the stato of this pagamento
	 */
	@AutoEscape
	public String getStato();

	/**
	 * Sets the stato of this pagamento.
	 *
	 * @param stato the stato of this pagamento
	 */
	public void setStato(String stato);

	/**
	 * Returns the richiesta ID of this pagamento.
	 *
	 * @return the richiesta ID of this pagamento
	 */
	public long getRichiestaId();

	/**
	 * Sets the richiesta ID of this pagamento.
	 *
	 * @param richiestaId the richiesta ID of this pagamento
	 */
	public void setRichiestaId(long richiestaId);

	@Override
	public Pagamento cloneWithOriginalValues();

}