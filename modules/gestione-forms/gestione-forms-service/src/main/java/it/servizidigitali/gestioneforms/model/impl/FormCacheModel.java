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

package it.servizidigitali.gestioneforms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneforms.model.Form;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Form in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormCacheModel implements CacheModel<Form>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormCacheModel)) {
			return false;
		}

		FormCacheModel formCacheModel = (FormCacheModel)object;

		if (formId == formCacheModel.formId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, formId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", formId=");
		sb.append(formId);
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
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", json=");
		sb.append(json);
		sb.append(", principale=");
		sb.append(principale);
		sb.append(", multiutente=");
		sb.append(multiutente);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Form toEntityModel() {
		FormImpl formImpl = new FormImpl();

		if (uuid == null) {
			formImpl.setUuid("");
		}
		else {
			formImpl.setUuid(uuid);
		}

		formImpl.setFormId(formId);
		formImpl.setGroupId(groupId);
		formImpl.setCompanyId(companyId);
		formImpl.setUserId(userId);

		if (userName == null) {
			formImpl.setUserName("");
		}
		else {
			formImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			formImpl.setCreateDate(null);
		}
		else {
			formImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			formImpl.setModifiedDate(null);
		}
		else {
			formImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			formImpl.setNome("");
		}
		else {
			formImpl.setNome(nome);
		}

		if (descrizione == null) {
			formImpl.setDescrizione("");
		}
		else {
			formImpl.setDescrizione(descrizione);
		}

		if (codice == null) {
			formImpl.setCodice("");
		}
		else {
			formImpl.setCodice(codice);
		}

		if (json == null) {
			formImpl.setJson("");
		}
		else {
			formImpl.setJson(json);
		}

		formImpl.setPrincipale(principale);
		formImpl.setMultiutente(multiutente);
		formImpl.setOrganizationId(organizationId);

		formImpl.resetOriginalValues();

		return formImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		formId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		codice = objectInput.readUTF();
		json = objectInput.readUTF();

		principale = objectInput.readBoolean();

		multiutente = objectInput.readBoolean();

		organizationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(formId);

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

		if (codice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codice);
		}

		if (json == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(json);
		}

		objectOutput.writeBoolean(principale);

		objectOutput.writeBoolean(multiutente);

		objectOutput.writeLong(organizationId);
	}

	public String uuid;
	public long formId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descrizione;
	public String codice;
	public String json;
	public boolean principale;
	public boolean multiutente;
	public long organizationId;

}