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

import it.servizidigitali.common.model.Provincia;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Provincia in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProvinciaCacheModel
	implements CacheModel<Provincia>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProvinciaCacheModel)) {
			return false;
		}

		ProvinciaCacheModel provinciaCacheModel = (ProvinciaCacheModel)object;

		if (provinciaId == provinciaCacheModel.provinciaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, provinciaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{provinciaId=");
		sb.append(provinciaId);
		sb.append(", codiceRipartizione=");
		sb.append(codiceRipartizione);
		sb.append(", codiceNUTS1=");
		sb.append(codiceNUTS1);
		sb.append(", ripartizioneGeograficaM=");
		sb.append(ripartizioneGeograficaM);
		sb.append(", ripartizioneGeografica=");
		sb.append(ripartizioneGeografica);
		sb.append(", denominazioneRegioneM=");
		sb.append(denominazioneRegioneM);
		sb.append(", denominazioneRegione=");
		sb.append(denominazioneRegione);
		sb.append(", denominazioneProvincia=");
		sb.append(denominazioneProvincia);
		sb.append(", codiceRegione=");
		sb.append(codiceRegione);
		sb.append(", codiceNUTS2=");
		sb.append(codiceNUTS2);
		sb.append(", codiceNUTS3=");
		sb.append(codiceNUTS3);
		sb.append(", sigla=");
		sb.append(sigla);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Provincia toEntityModel() {
		ProvinciaImpl provinciaImpl = new ProvinciaImpl();

		provinciaImpl.setProvinciaId(provinciaId);
		provinciaImpl.setCodiceRipartizione(codiceRipartizione);

		if (codiceNUTS1 == null) {
			provinciaImpl.setCodiceNUTS1("");
		}
		else {
			provinciaImpl.setCodiceNUTS1(codiceNUTS1);
		}

		if (ripartizioneGeograficaM == null) {
			provinciaImpl.setRipartizioneGeograficaM("");
		}
		else {
			provinciaImpl.setRipartizioneGeograficaM(ripartizioneGeograficaM);
		}

		if (ripartizioneGeografica == null) {
			provinciaImpl.setRipartizioneGeografica("");
		}
		else {
			provinciaImpl.setRipartizioneGeografica(ripartizioneGeografica);
		}

		if (denominazioneRegioneM == null) {
			provinciaImpl.setDenominazioneRegioneM("");
		}
		else {
			provinciaImpl.setDenominazioneRegioneM(denominazioneRegioneM);
		}

		if (denominazioneRegione == null) {
			provinciaImpl.setDenominazioneRegione("");
		}
		else {
			provinciaImpl.setDenominazioneRegione(denominazioneRegione);
		}

		if (denominazioneProvincia == null) {
			provinciaImpl.setDenominazioneProvincia("");
		}
		else {
			provinciaImpl.setDenominazioneProvincia(denominazioneProvincia);
		}

		provinciaImpl.setCodiceRegione(codiceRegione);

		if (codiceNUTS2 == null) {
			provinciaImpl.setCodiceNUTS2("");
		}
		else {
			provinciaImpl.setCodiceNUTS2(codiceNUTS2);
		}

		if (codiceNUTS3 == null) {
			provinciaImpl.setCodiceNUTS3("");
		}
		else {
			provinciaImpl.setCodiceNUTS3(codiceNUTS3);
		}

		if (sigla == null) {
			provinciaImpl.setSigla("");
		}
		else {
			provinciaImpl.setSigla(sigla);
		}

		provinciaImpl.resetOriginalValues();

		return provinciaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		provinciaId = objectInput.readLong();

		codiceRipartizione = objectInput.readInt();
		codiceNUTS1 = objectInput.readUTF();
		ripartizioneGeograficaM = objectInput.readUTF();
		ripartizioneGeografica = objectInput.readUTF();
		denominazioneRegioneM = objectInput.readUTF();
		denominazioneRegione = objectInput.readUTF();
		denominazioneProvincia = objectInput.readUTF();

		codiceRegione = objectInput.readLong();
		codiceNUTS2 = objectInput.readUTF();
		codiceNUTS3 = objectInput.readUTF();
		sigla = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(provinciaId);

		objectOutput.writeInt(codiceRipartizione);

		if (codiceNUTS1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceNUTS1);
		}

		if (ripartizioneGeograficaM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ripartizioneGeograficaM);
		}

		if (ripartizioneGeografica == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ripartizioneGeografica);
		}

		if (denominazioneRegioneM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneRegioneM);
		}

		if (denominazioneRegione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneRegione);
		}

		if (denominazioneProvincia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneProvincia);
		}

		objectOutput.writeLong(codiceRegione);

		if (codiceNUTS2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceNUTS2);
		}

		if (codiceNUTS3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceNUTS3);
		}

		if (sigla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sigla);
		}
	}

	public long provinciaId;
	public int codiceRipartizione;
	public String codiceNUTS1;
	public String ripartizioneGeograficaM;
	public String ripartizioneGeografica;
	public String denominazioneRegioneM;
	public String denominazioneRegione;
	public String denominazioneProvincia;
	public long codiceRegione;
	public String codiceNUTS2;
	public String codiceNUTS3;
	public String sigla;

}