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

package it.servizidigitali.gestioneprocessi.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneprocessi.model.Processo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Processo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcessoCacheModel
	implements CacheModel<Processo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcessoCacheModel)) {
			return false;
		}

		ProcessoCacheModel processoCacheModel = (ProcessoCacheModel)object;

		if (processoId == processoCacheModel.processoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, processoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", processoId=");
		sb.append(processoId);
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
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", multiente=");
		sb.append(multiente);
		sb.append(", deploymentId=");
		sb.append(deploymentId);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Processo toEntityModel() {
		ProcessoImpl processoImpl = new ProcessoImpl();

		if (uuid == null) {
			processoImpl.setUuid("");
		}
		else {
			processoImpl.setUuid(uuid);
		}

		processoImpl.setProcessoId(processoId);
		processoImpl.setGroupId(groupId);
		processoImpl.setCompanyId(companyId);
		processoImpl.setUserId(userId);

		if (userName == null) {
			processoImpl.setUserName("");
		}
		else {
			processoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			processoImpl.setCreateDate(null);
		}
		else {
			processoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			processoImpl.setModifiedDate(null);
		}
		else {
			processoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (codice == null) {
			processoImpl.setCodice("");
		}
		else {
			processoImpl.setCodice(codice);
		}

		if (nome == null) {
			processoImpl.setNome("");
		}
		else {
			processoImpl.setNome(nome);
		}

		if (stato == null) {
			processoImpl.setStato("");
		}
		else {
			processoImpl.setStato(stato);
		}

		processoImpl.setMultiente(multiente);

		if (deploymentId == null) {
			processoImpl.setDeploymentId("");
		}
		else {
			processoImpl.setDeploymentId(deploymentId);
		}

		processoImpl.setAttivo(attivo);

		processoImpl.resetOriginalValues();

		return processoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		processoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		codice = objectInput.readUTF();
		nome = objectInput.readUTF();
		stato = objectInput.readUTF();

		multiente = objectInput.readBoolean();
		deploymentId = objectInput.readUTF();

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

		objectOutput.writeLong(processoId);

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

		if (codice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codice);
		}

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (stato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stato);
		}

		objectOutput.writeBoolean(multiente);

		if (deploymentId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deploymentId);
		}

		objectOutput.writeBoolean(attivo);
	}

	public String uuid;
	public long processoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String codice;
	public String nome;
	public String stato;
	public boolean multiente;
	public String deploymentId;
	public boolean attivo;

}