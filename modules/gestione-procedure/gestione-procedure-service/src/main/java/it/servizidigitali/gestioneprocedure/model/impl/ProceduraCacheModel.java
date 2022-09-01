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

package it.servizidigitali.gestioneprocedure.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneprocedure.model.Procedura;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Procedura in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProceduraCacheModel
	implements CacheModel<Procedura>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProceduraCacheModel)) {
			return false;
		}

		ProceduraCacheModel proceduraCacheModel = (ProceduraCacheModel)object;

		if (proceduraId == proceduraCacheModel.proceduraId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, proceduraId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", proceduraId=");
		sb.append(proceduraId);
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
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", pecDestinazione=");
		sb.append(pecDestinazione);
		sb.append(", step1Attivo=");
		sb.append(step1Attivo);
		sb.append(", step1TipoComponentiNucleoFamiliare=");
		sb.append(step1TipoComponentiNucleoFamiliare);
		sb.append(", step2TipoServizio=");
		sb.append(step2TipoServizio);
		sb.append(", step2TipiIntegrazioneBackoffice=");
		sb.append(step2TipiIntegrazioneBackoffice);
		sb.append(", attiva=");
		sb.append(attiva);
		sb.append(", servizioId=");
		sb.append(servizioId);
		sb.append(", processoId=");
		sb.append(processoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Procedura toEntityModel() {
		ProceduraImpl proceduraImpl = new ProceduraImpl();

		if (uuid == null) {
			proceduraImpl.setUuid("");
		}
		else {
			proceduraImpl.setUuid(uuid);
		}

		proceduraImpl.setProceduraId(proceduraId);
		proceduraImpl.setGroupId(groupId);
		proceduraImpl.setCompanyId(companyId);
		proceduraImpl.setUserId(userId);

		if (userName == null) {
			proceduraImpl.setUserName("");
		}
		else {
			proceduraImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			proceduraImpl.setCreateDate(null);
		}
		else {
			proceduraImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			proceduraImpl.setModifiedDate(null);
		}
		else {
			proceduraImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			proceduraImpl.setNome("");
		}
		else {
			proceduraImpl.setNome(nome);
		}

		if (pecDestinazione == null) {
			proceduraImpl.setPecDestinazione("");
		}
		else {
			proceduraImpl.setPecDestinazione(pecDestinazione);
		}

		proceduraImpl.setStep1Attivo(step1Attivo);

		if (step1TipoComponentiNucleoFamiliare == null) {
			proceduraImpl.setStep1TipoComponentiNucleoFamiliare("");
		}
		else {
			proceduraImpl.setStep1TipoComponentiNucleoFamiliare(
				step1TipoComponentiNucleoFamiliare);
		}

		if (step2TipoServizio == null) {
			proceduraImpl.setStep2TipoServizio("");
		}
		else {
			proceduraImpl.setStep2TipoServizio(step2TipoServizio);
		}

		if (step2TipiIntegrazioneBackoffice == null) {
			proceduraImpl.setStep2TipiIntegrazioneBackoffice("");
		}
		else {
			proceduraImpl.setStep2TipiIntegrazioneBackoffice(
				step2TipiIntegrazioneBackoffice);
		}

		proceduraImpl.setAttiva(attiva);
		proceduraImpl.setServizioId(servizioId);
		proceduraImpl.setProcessoId(processoId);

		proceduraImpl.resetOriginalValues();

		return proceduraImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		proceduraId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		pecDestinazione = objectInput.readUTF();

		step1Attivo = objectInput.readBoolean();
		step1TipoComponentiNucleoFamiliare = objectInput.readUTF();
		step2TipoServizio = objectInput.readUTF();
		step2TipiIntegrazioneBackoffice = objectInput.readUTF();

		attiva = objectInput.readBoolean();

		servizioId = objectInput.readLong();

		processoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(proceduraId);

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

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (pecDestinazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pecDestinazione);
		}

		objectOutput.writeBoolean(step1Attivo);

		if (step1TipoComponentiNucleoFamiliare == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(step1TipoComponentiNucleoFamiliare);
		}

		if (step2TipoServizio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(step2TipoServizio);
		}

		if (step2TipiIntegrazioneBackoffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(step2TipiIntegrazioneBackoffice);
		}

		objectOutput.writeBoolean(attiva);

		objectOutput.writeLong(servizioId);

		objectOutput.writeLong(processoId);
	}

	public String uuid;
	public long proceduraId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String pecDestinazione;
	public boolean step1Attivo;
	public String step1TipoComponentiNucleoFamiliare;
	public String step2TipoServizio;
	public String step2TipiIntegrazioneBackoffice;
	public boolean attiva;
	public long servizioId;
	public long processoId;

}