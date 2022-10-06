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

package it.servizidigitali.gestioneservizi.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestioneservizi.model.Tipologia;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tipologia in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TipologiaCacheModel
	implements CacheModel<Tipologia>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TipologiaCacheModel)) {
			return false;
		}

		TipologiaCacheModel tipologiaCacheModel = (TipologiaCacheModel)object;

		if (tipologiaId == tipologiaCacheModel.tipologiaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tipologiaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tipologiaId=");
		sb.append(tipologiaId);
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
		sb.append(", visibile=");
		sb.append(visibile);
		sb.append(", invioEmailCittadino=");
		sb.append(invioEmailCittadino);
		sb.append(", chatbotInlineIntent=");
		sb.append(chatbotInlineIntent);
		sb.append(", codice=");
		sb.append(codice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tipologia toEntityModel() {
		TipologiaImpl tipologiaImpl = new TipologiaImpl();

		if (uuid == null) {
			tipologiaImpl.setUuid("");
		}
		else {
			tipologiaImpl.setUuid(uuid);
		}

		tipologiaImpl.setTipologiaId(tipologiaId);
		tipologiaImpl.setGroupId(groupId);
		tipologiaImpl.setCompanyId(companyId);
		tipologiaImpl.setUserId(userId);

		if (userName == null) {
			tipologiaImpl.setUserName("");
		}
		else {
			tipologiaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tipologiaImpl.setCreateDate(null);
		}
		else {
			tipologiaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tipologiaImpl.setModifiedDate(null);
		}
		else {
			tipologiaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			tipologiaImpl.setNome("");
		}
		else {
			tipologiaImpl.setNome(nome);
		}

		if (descrizione == null) {
			tipologiaImpl.setDescrizione("");
		}
		else {
			tipologiaImpl.setDescrizione(descrizione);
		}

		tipologiaImpl.setVisibile(visibile);
		tipologiaImpl.setInvioEmailCittadino(invioEmailCittadino);

		if (chatbotInlineIntent == null) {
			tipologiaImpl.setChatbotInlineIntent("");
		}
		else {
			tipologiaImpl.setChatbotInlineIntent(chatbotInlineIntent);
		}

		if (codice == null) {
			tipologiaImpl.setCodice("");
		}
		else {
			tipologiaImpl.setCodice(codice);
		}

		tipologiaImpl.resetOriginalValues();

		return tipologiaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tipologiaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();

		visibile = objectInput.readBoolean();

		invioEmailCittadino = objectInput.readBoolean();
		chatbotInlineIntent = objectInput.readUTF();
		codice = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(tipologiaId);

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

		objectOutput.writeBoolean(visibile);

		objectOutput.writeBoolean(invioEmailCittadino);

		if (chatbotInlineIntent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chatbotInlineIntent);
		}

		if (codice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codice);
		}
	}

	public String uuid;
	public long tipologiaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descrizione;
	public boolean visibile;
	public boolean invioEmailCittadino;
	public String chatbotInlineIntent;
	public String codice;

}