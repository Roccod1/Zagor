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

import it.servizidigitali.gestioneservizi.model.AreaTematica;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AreaTematica in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AreaTematicaCacheModel
	implements CacheModel<AreaTematica>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AreaTematicaCacheModel)) {
			return false;
		}

		AreaTematicaCacheModel areaTematicaCacheModel =
			(AreaTematicaCacheModel)object;

		if (areaTematicaId == areaTematicaCacheModel.areaTematicaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, areaTematicaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", areaTematicaId=");
		sb.append(areaTematicaId);
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
		sb.append(", sportello=");
		sb.append(sportello);
		sb.append(", uriVocabolario=");
		sb.append(uriVocabolario);
		sb.append(", denominazioneVocabolario=");
		sb.append(denominazioneVocabolario);
		sb.append(", ordine=");
		sb.append(ordine);
		sb.append(", visibile=");
		sb.append(visibile);
		sb.append(", attiva=");
		sb.append(attiva);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AreaTematica toEntityModel() {
		AreaTematicaImpl areaTematicaImpl = new AreaTematicaImpl();

		if (uuid == null) {
			areaTematicaImpl.setUuid("");
		}
		else {
			areaTematicaImpl.setUuid(uuid);
		}

		areaTematicaImpl.setAreaTematicaId(areaTematicaId);
		areaTematicaImpl.setGroupId(groupId);
		areaTematicaImpl.setCompanyId(companyId);
		areaTematicaImpl.setUserId(userId);

		if (userName == null) {
			areaTematicaImpl.setUserName("");
		}
		else {
			areaTematicaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			areaTematicaImpl.setCreateDate(null);
		}
		else {
			areaTematicaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			areaTematicaImpl.setModifiedDate(null);
		}
		else {
			areaTematicaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			areaTematicaImpl.setNome("");
		}
		else {
			areaTematicaImpl.setNome(nome);
		}

		if (descrizione == null) {
			areaTematicaImpl.setDescrizione("");
		}
		else {
			areaTematicaImpl.setDescrizione(descrizione);
		}

		if (codice == null) {
			areaTematicaImpl.setCodice("");
		}
		else {
			areaTematicaImpl.setCodice(codice);
		}

		if (sportello == null) {
			areaTematicaImpl.setSportello("");
		}
		else {
			areaTematicaImpl.setSportello(sportello);
		}

		if (uriVocabolario == null) {
			areaTematicaImpl.setUriVocabolario("");
		}
		else {
			areaTematicaImpl.setUriVocabolario(uriVocabolario);
		}

		if (denominazioneVocabolario == null) {
			areaTematicaImpl.setDenominazioneVocabolario("");
		}
		else {
			areaTematicaImpl.setDenominazioneVocabolario(
				denominazioneVocabolario);
		}

		areaTematicaImpl.setOrdine(ordine);
		areaTematicaImpl.setVisibile(visibile);
		areaTematicaImpl.setAttiva(attiva);

		areaTematicaImpl.resetOriginalValues();

		return areaTematicaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		areaTematicaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		codice = objectInput.readUTF();
		sportello = objectInput.readUTF();
		uriVocabolario = objectInput.readUTF();
		denominazioneVocabolario = objectInput.readUTF();

		ordine = objectInput.readInt();

		visibile = objectInput.readBoolean();

		attiva = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(areaTematicaId);

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

		if (sportello == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sportello);
		}

		if (uriVocabolario == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uriVocabolario);
		}

		if (denominazioneVocabolario == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneVocabolario);
		}

		objectOutput.writeInt(ordine);

		objectOutput.writeBoolean(visibile);

		objectOutput.writeBoolean(attiva);
	}

	public String uuid;
	public long areaTematicaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String descrizione;
	public String codice;
	public String sportello;
	public String uriVocabolario;
	public String denominazioneVocabolario;
	public int ordine;
	public boolean visibile;
	public boolean attiva;

}