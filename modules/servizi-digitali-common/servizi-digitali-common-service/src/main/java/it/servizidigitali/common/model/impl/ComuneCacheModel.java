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

package it.servizidigitali.common.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.common.model.Comune;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Comune in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ComuneCacheModel implements CacheModel<Comune>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComuneCacheModel)) {
			return false;
		}

		ComuneCacheModel comuneCacheModel = (ComuneCacheModel)object;

		if (comuneId == comuneCacheModel.comuneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, comuneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{comuneId=");
		sb.append(comuneId);
		sb.append(", codiceIstatAN=");
		sb.append(codiceIstatAN);
		sb.append(", codiceIstat1=");
		sb.append(codiceIstat1);
		sb.append(", codiceIstat103=");
		sb.append(codiceIstat103);
		sb.append(", codicestat107=");
		sb.append(codicestat107);
		sb.append(", denominazione=");
		sb.append(denominazione);
		sb.append(", capoluogo=");
		sb.append(capoluogo);
		sb.append(", zonaAltimetrica=");
		sb.append(zonaAltimetrica);
		sb.append(", altitudine=");
		sb.append(altitudine);
		sb.append(", comuneLitoraneo=");
		sb.append(comuneLitoraneo);
		sb.append(", comuneMontano=");
		sb.append(comuneMontano);
		sb.append(", codiceSistemaLocaleLavoro=");
		sb.append(codiceSistemaLocaleLavoro);
		sb.append(", denominazioneSistemaLocaleLavoro=");
		sb.append(denominazioneSistemaLocaleLavoro);
		sb.append(", superficie=");
		sb.append(superficie);
		sb.append(", popolazioneLegale=");
		sb.append(popolazioneLegale);
		sb.append(", popolazioneResidente1=");
		sb.append(popolazioneResidente1);
		sb.append(", popolazioneResidente2=");
		sb.append(popolazioneResidente2);
		sb.append(", popolazioneResidente3=");
		sb.append(popolazioneResidente3);
		sb.append(", codiceComune=");
		sb.append(codiceComune);
		sb.append(", codiceCatastale=");
		sb.append(codiceCatastale);
		sb.append(", idRegione=");
		sb.append(idRegione);
		sb.append(", idProvincia=");
		sb.append(idProvincia);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comune toEntityModel() {
		ComuneImpl comuneImpl = new ComuneImpl();

		comuneImpl.setComuneId(comuneId);

		if (codiceIstatAN == null) {
			comuneImpl.setCodiceIstatAN("");
		}
		else {
			comuneImpl.setCodiceIstatAN(codiceIstatAN);
		}

		if (codiceIstat1 == null) {
			comuneImpl.setCodiceIstat1("");
		}
		else {
			comuneImpl.setCodiceIstat1(codiceIstat1);
		}

		if (codiceIstat103 == null) {
			comuneImpl.setCodiceIstat103("");
		}
		else {
			comuneImpl.setCodiceIstat103(codiceIstat103);
		}

		if (codicestat107 == null) {
			comuneImpl.setCodicestat107("");
		}
		else {
			comuneImpl.setCodicestat107(codicestat107);
		}

		if (denominazione == null) {
			comuneImpl.setDenominazione("");
		}
		else {
			comuneImpl.setDenominazione(denominazione);
		}

		comuneImpl.setCapoluogo(capoluogo);

		if (zonaAltimetrica == null) {
			comuneImpl.setZonaAltimetrica("");
		}
		else {
			comuneImpl.setZonaAltimetrica(zonaAltimetrica);
		}

		if (altitudine == null) {
			comuneImpl.setAltitudine("");
		}
		else {
			comuneImpl.setAltitudine(altitudine);
		}

		comuneImpl.setComuneLitoraneo(comuneLitoraneo);

		if (comuneMontano == null) {
			comuneImpl.setComuneMontano("");
		}
		else {
			comuneImpl.setComuneMontano(comuneMontano);
		}

		if (codiceSistemaLocaleLavoro == null) {
			comuneImpl.setCodiceSistemaLocaleLavoro("");
		}
		else {
			comuneImpl.setCodiceSistemaLocaleLavoro(codiceSistemaLocaleLavoro);
		}

		if (denominazioneSistemaLocaleLavoro == null) {
			comuneImpl.setDenominazioneSistemaLocaleLavoro("");
		}
		else {
			comuneImpl.setDenominazioneSistemaLocaleLavoro(
				denominazioneSistemaLocaleLavoro);
		}

		if (superficie == null) {
			comuneImpl.setSuperficie("");
		}
		else {
			comuneImpl.setSuperficie(superficie);
		}

		if (popolazioneLegale == null) {
			comuneImpl.setPopolazioneLegale("");
		}
		else {
			comuneImpl.setPopolazioneLegale(popolazioneLegale);
		}

		if (popolazioneResidente1 == null) {
			comuneImpl.setPopolazioneResidente1("");
		}
		else {
			comuneImpl.setPopolazioneResidente1(popolazioneResidente1);
		}

		if (popolazioneResidente2 == null) {
			comuneImpl.setPopolazioneResidente2("");
		}
		else {
			comuneImpl.setPopolazioneResidente2(popolazioneResidente2);
		}

		if (popolazioneResidente3 == null) {
			comuneImpl.setPopolazioneResidente3("");
		}
		else {
			comuneImpl.setPopolazioneResidente3(popolazioneResidente3);
		}

		comuneImpl.setCodiceComune(codiceComune);

		if (codiceCatastale == null) {
			comuneImpl.setCodiceCatastale("");
		}
		else {
			comuneImpl.setCodiceCatastale(codiceCatastale);
		}

		comuneImpl.setIdRegione(idRegione);
		comuneImpl.setIdProvincia(idProvincia);

		comuneImpl.resetOriginalValues();

		return comuneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		comuneId = objectInput.readLong();
		codiceIstatAN = objectInput.readUTF();
		codiceIstat1 = objectInput.readUTF();
		codiceIstat103 = objectInput.readUTF();
		codicestat107 = objectInput.readUTF();
		denominazione = objectInput.readUTF();

		capoluogo = objectInput.readBoolean();
		zonaAltimetrica = objectInput.readUTF();
		altitudine = objectInput.readUTF();

		comuneLitoraneo = objectInput.readBoolean();
		comuneMontano = objectInput.readUTF();
		codiceSistemaLocaleLavoro = objectInput.readUTF();
		denominazioneSistemaLocaleLavoro = objectInput.readUTF();
		superficie = objectInput.readUTF();
		popolazioneLegale = objectInput.readUTF();
		popolazioneResidente1 = objectInput.readUTF();
		popolazioneResidente2 = objectInput.readUTF();
		popolazioneResidente3 = objectInput.readUTF();

		codiceComune = objectInput.readInt();
		codiceCatastale = objectInput.readUTF();

		idRegione = objectInput.readLong();

		idProvincia = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(comuneId);

		if (codiceIstatAN == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceIstatAN);
		}

		if (codiceIstat1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceIstat1);
		}

		if (codiceIstat103 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceIstat103);
		}

		if (codicestat107 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codicestat107);
		}

		if (denominazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazione);
		}

		objectOutput.writeBoolean(capoluogo);

		if (zonaAltimetrica == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zonaAltimetrica);
		}

		if (altitudine == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(altitudine);
		}

		objectOutput.writeBoolean(comuneLitoraneo);

		if (comuneMontano == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comuneMontano);
		}

		if (codiceSistemaLocaleLavoro == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceSistemaLocaleLavoro);
		}

		if (denominazioneSistemaLocaleLavoro == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneSistemaLocaleLavoro);
		}

		if (superficie == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(superficie);
		}

		if (popolazioneLegale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(popolazioneLegale);
		}

		if (popolazioneResidente1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(popolazioneResidente1);
		}

		if (popolazioneResidente2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(popolazioneResidente2);
		}

		if (popolazioneResidente3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(popolazioneResidente3);
		}

		objectOutput.writeInt(codiceComune);

		if (codiceCatastale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceCatastale);
		}

		objectOutput.writeLong(idRegione);

		objectOutput.writeLong(idProvincia);
	}

	public long comuneId;
	public String codiceIstatAN;
	public String codiceIstat1;
	public String codiceIstat103;
	public String codicestat107;
	public String denominazione;
	public boolean capoluogo;
	public String zonaAltimetrica;
	public String altitudine;
	public boolean comuneLitoraneo;
	public String comuneMontano;
	public String codiceSistemaLocaleLavoro;
	public String denominazioneSistemaLocaleLavoro;
	public String superficie;
	public String popolazioneLegale;
	public String popolazioneResidente1;
	public String popolazioneResidente2;
	public String popolazioneResidente3;
	public int codiceComune;
	public String codiceCatastale;
	public long idRegione;
	public long idProvincia;

}