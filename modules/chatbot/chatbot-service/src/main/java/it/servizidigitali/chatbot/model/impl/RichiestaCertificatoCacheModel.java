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

package it.servizidigitali.chatbot.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.chatbot.model.RichiestaCertificato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiestaCertificato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RichiestaCertificatoCacheModel
	implements CacheModel<RichiestaCertificato>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RichiestaCertificatoCacheModel)) {
			return false;
		}

		RichiestaCertificatoCacheModel richiestaCertificatoCacheModel =
			(RichiestaCertificatoCacheModel)object;

		if (richiestaCertificatoId ==
				richiestaCertificatoCacheModel.richiestaCertificatoId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, richiestaCertificatoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", richiestaCertificatoId=");
		sb.append(richiestaCertificatoId);
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
		sb.append(", codiceFiscale=");
		sb.append(codiceFiscale);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", errore=");
		sb.append(errore);
		sb.append(", servizioId=");
		sb.append(servizioId);
		sb.append(", destinazioneUsoId=");
		sb.append(destinazioneUsoId);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiestaCertificato toEntityModel() {
		RichiestaCertificatoImpl richiestaCertificatoImpl =
			new RichiestaCertificatoImpl();

		if (uuid == null) {
			richiestaCertificatoImpl.setUuid("");
		}
		else {
			richiestaCertificatoImpl.setUuid(uuid);
		}

		richiestaCertificatoImpl.setRichiestaCertificatoId(
			richiestaCertificatoId);
		richiestaCertificatoImpl.setGroupId(groupId);
		richiestaCertificatoImpl.setCompanyId(companyId);
		richiestaCertificatoImpl.setUserId(userId);

		if (userName == null) {
			richiestaCertificatoImpl.setUserName("");
		}
		else {
			richiestaCertificatoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			richiestaCertificatoImpl.setCreateDate(null);
		}
		else {
			richiestaCertificatoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			richiestaCertificatoImpl.setModifiedDate(null);
		}
		else {
			richiestaCertificatoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (codiceFiscale == null) {
			richiestaCertificatoImpl.setCodiceFiscale("");
		}
		else {
			richiestaCertificatoImpl.setCodiceFiscale(codiceFiscale);
		}

		if (stato == null) {
			richiestaCertificatoImpl.setStato("");
		}
		else {
			richiestaCertificatoImpl.setStato(stato);
		}

		if (errore == null) {
			richiestaCertificatoImpl.setErrore("");
		}
		else {
			richiestaCertificatoImpl.setErrore(errore);
		}

		richiestaCertificatoImpl.setServizioId(servizioId);
		richiestaCertificatoImpl.setDestinazioneUsoId(destinazioneUsoId);
		richiestaCertificatoImpl.setRichiestaId(richiestaId);

		richiestaCertificatoImpl.resetOriginalValues();

		return richiestaCertificatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		richiestaCertificatoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		codiceFiscale = objectInput.readUTF();
		stato = objectInput.readUTF();
		errore = objectInput.readUTF();

		servizioId = objectInput.readLong();

		destinazioneUsoId = objectInput.readLong();

		richiestaId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(richiestaCertificatoId);

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

		if (codiceFiscale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceFiscale);
		}

		if (stato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stato);
		}

		if (errore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errore);
		}

		objectOutput.writeLong(servizioId);

		objectOutput.writeLong(destinazioneUsoId);

		objectOutput.writeLong(richiestaId);
	}

	public String uuid;
	public long richiestaCertificatoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String codiceFiscale;
	public String stato;
	public String errore;
	public long servizioId;
	public long destinazioneUsoId;
	public long richiestaId;

}