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

package it.servizidigitali.gestionepagamenti.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestionepagamenti.model.Pagamento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing Pagamento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PagamentoCacheModel
	implements CacheModel<Pagamento>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PagamentoCacheModel)) {
			return false;
		}

		PagamentoCacheModel pagamentoCacheModel = (PagamentoCacheModel)object;

		if (pagamentoId == pagamentoCacheModel.pagamentoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pagamentoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", pagamentoId=");
		sb.append(pagamentoId);
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
		sb.append(", idCredito=");
		sb.append(idCredito);
		sb.append(", idFiscaleCliente=");
		sb.append(idFiscaleCliente);
		sb.append(", denominazioneCliente=");
		sb.append(denominazioneCliente);
		sb.append(", emailQuietanza=");
		sb.append(emailQuietanza);
		sb.append(", causale=");
		sb.append(causale);
		sb.append(", descrizioneServizio=");
		sb.append(descrizioneServizio);
		sb.append(", importo=");
		sb.append(importo);
		sb.append(", commissioni=");
		sb.append(commissioni);
		sb.append(", canale=");
		sb.append(canale);
		sb.append(", gateway=");
		sb.append(gateway);
		sb.append(", iud=");
		sb.append(iud);
		sb.append(", iuv=");
		sb.append(iuv);
		sb.append(", idSessione=");
		sb.append(idSessione);
		sb.append(", pathAvviso=");
		sb.append(pathAvviso);
		sb.append(", emailInviata=");
		sb.append(emailInviata);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", richiestaId=");
		sb.append(richiestaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pagamento toEntityModel() {
		PagamentoImpl pagamentoImpl = new PagamentoImpl();

		if (uuid == null) {
			pagamentoImpl.setUuid("");
		}
		else {
			pagamentoImpl.setUuid(uuid);
		}

		pagamentoImpl.setPagamentoId(pagamentoId);
		pagamentoImpl.setGroupId(groupId);
		pagamentoImpl.setCompanyId(companyId);
		pagamentoImpl.setUserId(userId);

		if (userName == null) {
			pagamentoImpl.setUserName("");
		}
		else {
			pagamentoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			pagamentoImpl.setCreateDate(null);
		}
		else {
			pagamentoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pagamentoImpl.setModifiedDate(null);
		}
		else {
			pagamentoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (idCredito == null) {
			pagamentoImpl.setIdCredito("");
		}
		else {
			pagamentoImpl.setIdCredito(idCredito);
		}

		if (idFiscaleCliente == null) {
			pagamentoImpl.setIdFiscaleCliente("");
		}
		else {
			pagamentoImpl.setIdFiscaleCliente(idFiscaleCliente);
		}

		if (denominazioneCliente == null) {
			pagamentoImpl.setDenominazioneCliente("");
		}
		else {
			pagamentoImpl.setDenominazioneCliente(denominazioneCliente);
		}

		if (emailQuietanza == null) {
			pagamentoImpl.setEmailQuietanza("");
		}
		else {
			pagamentoImpl.setEmailQuietanza(emailQuietanza);
		}

		if (causale == null) {
			pagamentoImpl.setCausale("");
		}
		else {
			pagamentoImpl.setCausale(causale);
		}

		if (descrizioneServizio == null) {
			pagamentoImpl.setDescrizioneServizio("");
		}
		else {
			pagamentoImpl.setDescrizioneServizio(descrizioneServizio);
		}

		pagamentoImpl.setImporto(importo);
		pagamentoImpl.setCommissioni(commissioni);

		if (canale == null) {
			pagamentoImpl.setCanale("");
		}
		else {
			pagamentoImpl.setCanale(canale);
		}

		if (gateway == null) {
			pagamentoImpl.setGateway("");
		}
		else {
			pagamentoImpl.setGateway(gateway);
		}

		if (iud == null) {
			pagamentoImpl.setIud("");
		}
		else {
			pagamentoImpl.setIud(iud);
		}

		if (iuv == null) {
			pagamentoImpl.setIuv("");
		}
		else {
			pagamentoImpl.setIuv(iuv);
		}

		if (idSessione == null) {
			pagamentoImpl.setIdSessione("");
		}
		else {
			pagamentoImpl.setIdSessione(idSessione);
		}

		if (pathAvviso == null) {
			pagamentoImpl.setPathAvviso("");
		}
		else {
			pagamentoImpl.setPathAvviso(pathAvviso);
		}

		pagamentoImpl.setEmailInviata(emailInviata);

		if (stato == null) {
			pagamentoImpl.setStato("");
		}
		else {
			pagamentoImpl.setStato(stato);
		}

		pagamentoImpl.setRichiestaId(richiestaId);

		pagamentoImpl.resetOriginalValues();

		return pagamentoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		pagamentoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		idCredito = objectInput.readUTF();
		idFiscaleCliente = objectInput.readUTF();
		denominazioneCliente = objectInput.readUTF();
		emailQuietanza = objectInput.readUTF();
		causale = objectInput.readUTF();
		descrizioneServizio = objectInput.readUTF();
		importo = (BigDecimal)objectInput.readObject();
		commissioni = (BigDecimal)objectInput.readObject();
		canale = objectInput.readUTF();
		gateway = objectInput.readUTF();
		iud = objectInput.readUTF();
		iuv = objectInput.readUTF();
		idSessione = objectInput.readUTF();
		pathAvviso = objectInput.readUTF();

		emailInviata = objectInput.readBoolean();
		stato = objectInput.readUTF();

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

		objectOutput.writeLong(pagamentoId);

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

		if (idCredito == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idCredito);
		}

		if (idFiscaleCliente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idFiscaleCliente);
		}

		if (denominazioneCliente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneCliente);
		}

		if (emailQuietanza == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailQuietanza);
		}

		if (causale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(causale);
		}

		if (descrizioneServizio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizioneServizio);
		}

		objectOutput.writeObject(importo);
		objectOutput.writeObject(commissioni);

		if (canale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(canale);
		}

		if (gateway == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gateway);
		}

		if (iud == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iud);
		}

		if (iuv == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iuv);
		}

		if (idSessione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idSessione);
		}

		if (pathAvviso == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pathAvviso);
		}

		objectOutput.writeBoolean(emailInviata);

		if (stato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stato);
		}

		objectOutput.writeLong(richiestaId);
	}

	public String uuid;
	public long pagamentoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String idCredito;
	public String idFiscaleCliente;
	public String denominazioneCliente;
	public String emailQuietanza;
	public String causale;
	public String descrizioneServizio;
	public BigDecimal importo;
	public BigDecimal commissioni;
	public String canale;
	public String gateway;
	public String iud;
	public String iuv;
	public String idSessione;
	public String pathAvviso;
	public boolean emailInviata;
	public String stato;
	public long richiestaId;

}