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

package it.servizidigitali.gestionecomunicazioni.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Comunicazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ComunicazioneCacheModel
	implements CacheModel<Comunicazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComunicazioneCacheModel)) {
			return false;
		}

		ComunicazioneCacheModel comunicazioneCacheModel =
			(ComunicazioneCacheModel)object;

		if (comunicazioneId == comunicazioneCacheModel.comunicazioneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, comunicazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", comunicazioneId=");
		sb.append(comunicazioneId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", dataInvio=");
		sb.append(dataInvio);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append(", codiceServizio=");
		sb.append(codiceServizio);
		sb.append(", uriServizio=");
		sb.append(uriServizio);
		sb.append(", tipologiaComunicazioneId=");
		sb.append(tipologiaComunicazioneId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", destinatarioUserId=");
		sb.append(destinatarioUserId);
		sb.append(", destinatarioOrganizationId=");
		sb.append(destinatarioOrganizationId);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comunicazione toEntityModel() {
		ComunicazioneImpl comunicazioneImpl = new ComunicazioneImpl();

		if (uuid == null) {
			comunicazioneImpl.setUuid("");
		}
		else {
			comunicazioneImpl.setUuid(uuid);
		}

		comunicazioneImpl.setComunicazioneId(comunicazioneId);
		comunicazioneImpl.setGroupId(groupId);
		comunicazioneImpl.setCompanyId(companyId);
		comunicazioneImpl.setUserId(userId);

		if (userName == null) {
			comunicazioneImpl.setUserName("");
		}
		else {
			comunicazioneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			comunicazioneImpl.setCreateDate(null);
		}
		else {
			comunicazioneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			comunicazioneImpl.setModifiedDate(null);
		}
		else {
			comunicazioneImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (titolo == null) {
			comunicazioneImpl.setTitolo("");
		}
		else {
			comunicazioneImpl.setTitolo(titolo);
		}

		if (descrizione == null) {
			comunicazioneImpl.setDescrizione("");
		}
		else {
			comunicazioneImpl.setDescrizione(descrizione);
		}

		if (dataInvio == Long.MIN_VALUE) {
			comunicazioneImpl.setDataInvio(null);
		}
		else {
			comunicazioneImpl.setDataInvio(new Date(dataInvio));
		}

		if (dataInizio == Long.MIN_VALUE) {
			comunicazioneImpl.setDataInizio(null);
		}
		else {
			comunicazioneImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			comunicazioneImpl.setDataFine(null);
		}
		else {
			comunicazioneImpl.setDataFine(new Date(dataFine));
		}

		if (codiceServizio == null) {
			comunicazioneImpl.setCodiceServizio("");
		}
		else {
			comunicazioneImpl.setCodiceServizio(codiceServizio);
		}

		if (uriServizio == null) {
			comunicazioneImpl.setUriServizio("");
		}
		else {
			comunicazioneImpl.setUriServizio(uriServizio);
		}

		comunicazioneImpl.setTipologiaComunicazioneId(tipologiaComunicazioneId);
		comunicazioneImpl.setOrganizationId(organizationId);
		comunicazioneImpl.setDestinatarioUserId(destinatarioUserId);
		comunicazioneImpl.setDestinatarioOrganizationId(
			destinatarioOrganizationId);
		comunicazioneImpl.setCalendarBookingId(calendarBookingId);

		comunicazioneImpl.resetOriginalValues();

		return comunicazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		comunicazioneId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		titolo = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		dataInvio = objectInput.readLong();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();
		codiceServizio = objectInput.readUTF();
		uriServizio = objectInput.readUTF();

		tipologiaComunicazioneId = objectInput.readLong();

		organizationId = objectInput.readLong();

		destinatarioUserId = objectInput.readLong();

		destinatarioOrganizationId = objectInput.readLong();

		calendarBookingId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(comunicazioneId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (titolo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		objectOutput.writeLong(dataInvio);
		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		if (codiceServizio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceServizio);
		}

		if (uriServizio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uriServizio);
		}

		objectOutput.writeLong(tipologiaComunicazioneId);

		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(destinatarioUserId);

		objectOutput.writeLong(destinatarioOrganizationId);

		objectOutput.writeLong(calendarBookingId);
	}

	public String uuid;
	public long comunicazioneId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String titolo;
	public String descrizione;
	public long dataInvio;
	public long dataInizio;
	public long dataFine;
	public String codiceServizio;
	public String uriServizio;
	public long tipologiaComunicazioneId;
	public long organizationId;
	public long destinatarioUserId;
	public long destinatarioOrganizationId;
	public long calendarBookingId;

}