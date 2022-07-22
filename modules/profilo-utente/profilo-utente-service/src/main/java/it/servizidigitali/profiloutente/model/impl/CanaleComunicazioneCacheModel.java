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

package it.servizidigitali.profiloutente.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CanaleComunicazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CanaleComunicazioneCacheModel
	implements CacheModel<CanaleComunicazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CanaleComunicazioneCacheModel)) {
			return false;
		}

		CanaleComunicazioneCacheModel canaleComunicazioneCacheModel =
			(CanaleComunicazioneCacheModel)object;

		if (canaleComunicazioneId ==
				canaleComunicazioneCacheModel.canaleComunicazioneId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, canaleComunicazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{canaleComunicazioneId=");
		sb.append(canaleComunicazioneId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CanaleComunicazione toEntityModel() {
		CanaleComunicazioneImpl canaleComunicazioneImpl =
			new CanaleComunicazioneImpl();

		canaleComunicazioneImpl.setCanaleComunicazioneId(canaleComunicazioneId);

		if (nome == null) {
			canaleComunicazioneImpl.setNome("");
		}
		else {
			canaleComunicazioneImpl.setNome(nome);
		}

		if (codice == null) {
			canaleComunicazioneImpl.setCodice("");
		}
		else {
			canaleComunicazioneImpl.setCodice(codice);
		}

		canaleComunicazioneImpl.setAttivo(attivo);

		canaleComunicazioneImpl.resetOriginalValues();

		return canaleComunicazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		canaleComunicazioneId = objectInput.readLong();
		nome = objectInput.readUTF();
		codice = objectInput.readUTF();

		attivo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(canaleComunicazioneId);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (codice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codice);
		}

		objectOutput.writeBoolean(attivo);
	}

	public long canaleComunicazioneId;
	public String nome;
	public String codice;
	public boolean attivo;

}