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

package it.servizidigitali.accreditamentoenti.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.accreditamentoenti.model.Ente;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ente in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EnteCacheModel implements CacheModel<Ente>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EnteCacheModel)) {
			return false;
		}

		EnteCacheModel enteCacheModel = (EnteCacheModel)object;

		if (enteId == enteCacheModel.enteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, enteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", enteId=");
		sb.append(enteId);
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
		sb.append(", denominazione=");
		sb.append(denominazione);
		sb.append(", strutturaRiferimento=");
		sb.append(strutturaRiferimento);
		sb.append(", sitoWeb=");
		sb.append(sitoWeb);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", codiceIPA=");
		sb.append(codiceIPA);
		sb.append(", pec=");
		sb.append(pec);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ente toEntityModel() {
		EnteImpl enteImpl = new EnteImpl();

		if (uuid == null) {
			enteImpl.setUuid("");
		}
		else {
			enteImpl.setUuid(uuid);
		}

		enteImpl.setEnteId(enteId);
		enteImpl.setGroupId(groupId);
		enteImpl.setCompanyId(companyId);
		enteImpl.setUserId(userId);

		if (userName == null) {
			enteImpl.setUserName("");
		}
		else {
			enteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			enteImpl.setCreateDate(null);
		}
		else {
			enteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enteImpl.setModifiedDate(null);
		}
		else {
			enteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (denominazione == null) {
			enteImpl.setDenominazione("");
		}
		else {
			enteImpl.setDenominazione(denominazione);
		}

		if (strutturaRiferimento == null) {
			enteImpl.setStrutturaRiferimento("");
		}
		else {
			enteImpl.setStrutturaRiferimento(strutturaRiferimento);
		}

		if (sitoWeb == null) {
			enteImpl.setSitoWeb("");
		}
		else {
			enteImpl.setSitoWeb(sitoWeb);
		}

		if (tipo == null) {
			enteImpl.setTipo("");
		}
		else {
			enteImpl.setTipo(tipo);
		}

		if (codiceIPA == null) {
			enteImpl.setCodiceIPA("");
		}
		else {
			enteImpl.setCodiceIPA(codiceIPA);
		}

		if (pec == null) {
			enteImpl.setPec("");
		}
		else {
			enteImpl.setPec(pec);
		}

		enteImpl.resetOriginalValues();

		return enteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		enteId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		denominazione = objectInput.readUTF();
		strutturaRiferimento = objectInput.readUTF();
		sitoWeb = objectInput.readUTF();
		tipo = objectInput.readUTF();
		codiceIPA = objectInput.readUTF();
		pec = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(enteId);

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

		if (denominazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazione);
		}

		if (strutturaRiferimento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(strutturaRiferimento);
		}

		if (sitoWeb == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sitoWeb);
		}

		if (tipo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipo);
		}

		if (codiceIPA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceIPA);
		}

		if (pec == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pec);
		}
	}

	public String uuid;
	public long enteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String denominazione;
	public String strutturaRiferimento;
	public String sitoWeb;
	public String tipo;
	public String codiceIPA;
	public String pec;

}