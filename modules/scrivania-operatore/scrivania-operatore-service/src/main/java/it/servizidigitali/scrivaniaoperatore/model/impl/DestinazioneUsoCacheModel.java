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

package it.servizidigitali.scrivaniaoperatore.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing DestinazioneUso in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DestinazioneUsoCacheModel
	implements CacheModel<DestinazioneUso>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DestinazioneUsoCacheModel)) {
			return false;
		}

		DestinazioneUsoCacheModel destinazioneUsoCacheModel =
			(DestinazioneUsoCacheModel)object;

		if (destinazioneUsoId == destinazioneUsoCacheModel.destinazioneUsoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, destinazioneUsoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", destinazioneUsoId=");
		sb.append(destinazioneUsoId);
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
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", pagamentoBollo=");
		sb.append(pagamentoBollo);
		sb.append(", importo=");
		sb.append(importo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DestinazioneUso toEntityModel() {
		DestinazioneUsoImpl destinazioneUsoImpl = new DestinazioneUsoImpl();

		if (uuid == null) {
			destinazioneUsoImpl.setUuid("");
		}
		else {
			destinazioneUsoImpl.setUuid(uuid);
		}

		destinazioneUsoImpl.setDestinazioneUsoId(destinazioneUsoId);
		destinazioneUsoImpl.setGroupId(groupId);
		destinazioneUsoImpl.setCompanyId(companyId);
		destinazioneUsoImpl.setUserId(userId);

		if (userName == null) {
			destinazioneUsoImpl.setUserName("");
		}
		else {
			destinazioneUsoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			destinazioneUsoImpl.setCreateDate(null);
		}
		else {
			destinazioneUsoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			destinazioneUsoImpl.setModifiedDate(null);
		}
		else {
			destinazioneUsoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			destinazioneUsoImpl.setNome("");
		}
		else {
			destinazioneUsoImpl.setNome(nome);
		}

		if (descrizione == null) {
			destinazioneUsoImpl.setDescrizione("");
		}
		else {
			destinazioneUsoImpl.setDescrizione(descrizione);
		}

		destinazioneUsoImpl.setPagamentoBollo(pagamentoBollo);
		destinazioneUsoImpl.setImporto(importo);

		destinazioneUsoImpl.resetOriginalValues();

		return destinazioneUsoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		destinazioneUsoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();

		pagamentoBollo = objectInput.readBoolean();
		importo = (BigDecimal)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(destinazioneUsoId);

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

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		objectOutput.writeBoolean(pagamentoBollo);
		objectOutput.writeObject(importo);
	}

	public String uuid;
	public long destinazioneUsoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descrizione;
	public boolean pagamentoBollo;
	public BigDecimal importo;

}