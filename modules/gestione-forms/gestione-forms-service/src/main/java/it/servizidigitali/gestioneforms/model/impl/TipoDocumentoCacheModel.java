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

import it.servizidigitali.gestioneforms.model.TipoDocumento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TipoDocumento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TipoDocumentoCacheModel
	implements CacheModel<TipoDocumento>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TipoDocumentoCacheModel)) {
			return false;
		}

		TipoDocumentoCacheModel tipoDocumentoCacheModel =
			(TipoDocumentoCacheModel)object;

		if (tipoDocumentoId == tipoDocumentoCacheModel.tipoDocumentoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tipoDocumentoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tipoDocumentoId=");
		sb.append(tipoDocumentoId);
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
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", categoria=");
		sb.append(categoria);
		sb.append(", estensioniFile=");
		sb.append(estensioniFile);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", numeroRequired=");
		sb.append(numeroRequired);
		sb.append(", dataScadenzaRequired=");
		sb.append(dataScadenzaRequired);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipoDocumento toEntityModel() {
		TipoDocumentoImpl tipoDocumentoImpl = new TipoDocumentoImpl();

		if (uuid == null) {
			tipoDocumentoImpl.setUuid("");
		}
		else {
			tipoDocumentoImpl.setUuid(uuid);
		}

		tipoDocumentoImpl.setTipoDocumentoId(tipoDocumentoId);
		tipoDocumentoImpl.setGroupId(groupId);
		tipoDocumentoImpl.setCompanyId(companyId);
		tipoDocumentoImpl.setUserId(userId);

		if (userName == null) {
			tipoDocumentoImpl.setUserName("");
		}
		else {
			tipoDocumentoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tipoDocumentoImpl.setCreateDate(null);
		}
		else {
			tipoDocumentoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tipoDocumentoImpl.setModifiedDate(null);
		}
		else {
			tipoDocumentoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (codice == null) {
			tipoDocumentoImpl.setCodice("");
		}
		else {
			tipoDocumentoImpl.setCodice(codice);
		}

		if (nome == null) {
			tipoDocumentoImpl.setNome("");
		}
		else {
			tipoDocumentoImpl.setNome(nome);
		}

		if (descrizione == null) {
			tipoDocumentoImpl.setDescrizione("");
		}
		else {
			tipoDocumentoImpl.setDescrizione(descrizione);
		}

		if (categoria == null) {
			tipoDocumentoImpl.setCategoria("");
		}
		else {
			tipoDocumentoImpl.setCategoria(categoria);
		}

		if (estensioniFile == null) {
			tipoDocumentoImpl.setEstensioniFile("");
		}
		else {
			tipoDocumentoImpl.setEstensioniFile(estensioniFile);
		}

		if (stato == null) {
			tipoDocumentoImpl.setStato("");
		}
		else {
			tipoDocumentoImpl.setStato(stato);
		}

		tipoDocumentoImpl.setNumeroRequired(numeroRequired);
		tipoDocumentoImpl.setDataScadenzaRequired(dataScadenzaRequired);

		tipoDocumentoImpl.resetOriginalValues();

		return tipoDocumentoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tipoDocumentoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		codice = objectInput.readUTF();
		nome = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		categoria = objectInput.readUTF();
		estensioniFile = objectInput.readUTF();
		stato = objectInput.readUTF();

		numeroRequired = objectInput.readLong();

		dataScadenzaRequired = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(tipoDocumentoId);

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

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (categoria == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoria);
		}

		if (estensioniFile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(estensioniFile);
		}

		if (stato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stato);
		}

		objectOutput.writeLong(numeroRequired);

		objectOutput.writeLong(dataScadenzaRequired);
	}

	public String uuid;
	public long tipoDocumentoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String codice;
	public String nome;
	public String descrizione;
	public String categoria;
	public String estensioniFile;
	public String stato;
	public long numeroRequired;
	public long dataScadenzaRequired;

}