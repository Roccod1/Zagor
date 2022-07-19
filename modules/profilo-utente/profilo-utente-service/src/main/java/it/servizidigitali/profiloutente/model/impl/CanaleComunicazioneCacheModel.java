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

package it.servizidigitali.profiloutente.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CanaleComunicazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CanaleComunicazioneCacheModel
	implements CacheModel<CanaleComunicazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CanaleComunicazioneCacheModel)) {
			return false;
		}

		CanaleComunicazioneCacheModel canaleComunicazioneCacheModel =
			(CanaleComunicazioneCacheModel)object;

		if (canaleComunicazioneId ==
				canaleComunicazioneCacheModel.canaleComunicazioneId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, canaleComunicazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", canaleComunicazioneId=");
		sb.append(canaleComunicazioneId);
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
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CanaleComunicazione toEntityModel() {
		CanaleComunicazioneImpl canaleComunicazioneImpl =
			new CanaleComunicazioneImpl();

		if (uuid == null) {
			canaleComunicazioneImpl.setUuid("");
		}
		else {
			canaleComunicazioneImpl.setUuid(uuid);
		}

		canaleComunicazioneImpl.setCanaleComunicazioneId(canaleComunicazioneId);
		canaleComunicazioneImpl.setGroupId(groupId);
		canaleComunicazioneImpl.setCompanyId(companyId);
		canaleComunicazioneImpl.setUserId(userId);

		if (userName == null) {
			canaleComunicazioneImpl.setUserName("");
		}
		else {
			canaleComunicazioneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			canaleComunicazioneImpl.setCreateDate(null);
		}
		else {
			canaleComunicazioneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			canaleComunicazioneImpl.setModifiedDate(null);
		}
		else {
			canaleComunicazioneImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			canaleComunicazioneImpl.setNome("");
		}
		else {
			canaleComunicazioneImpl.setNome(nome);
		}

		if (codice == null) {
			canaleComunicazioneImpl.setCodice("");
		}
		else {
			canaleComunicazioneImpl.setCodice(codice);
		}

		canaleComunicazioneImpl.setAttivo(attivo);

		canaleComunicazioneImpl.resetOriginalValues();

		return canaleComunicazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		canaleComunicazioneId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		codice = objectInput.readUTF();

		attivo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(canaleComunicazioneId);

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

		if (codice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codice);
		}

		objectOutput.writeBoolean(attivo);
	}

	public String uuid;
	public long canaleComunicazioneId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String codice;
	public boolean attivo;

}