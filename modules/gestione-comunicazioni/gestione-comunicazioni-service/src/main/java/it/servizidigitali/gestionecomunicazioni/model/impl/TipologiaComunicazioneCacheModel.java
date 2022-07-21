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

package it.servizidigitali.gestionecomunicazioni.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipologiaComunicazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TipologiaComunicazioneCacheModel
	implements CacheModel<TipologiaComunicazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TipologiaComunicazioneCacheModel)) {
			return false;
		}

		TipologiaComunicazioneCacheModel tipologiaComunicazioneCacheModel =
			(TipologiaComunicazioneCacheModel)object;

		if (tipologiaComunicazioneId ==
				tipologiaComunicazioneCacheModel.tipologiaComunicazioneId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tipologiaComunicazioneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{tipologiaComunicazioneId=");
		sb.append(tipologiaComunicazioneId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipologiaComunicazione toEntityModel() {
		TipologiaComunicazioneImpl tipologiaComunicazioneImpl =
			new TipologiaComunicazioneImpl();

		tipologiaComunicazioneImpl.setTipologiaComunicazioneId(
			tipologiaComunicazioneId);

		if (nome == null) {
			tipologiaComunicazioneImpl.setNome("");
		}
		else {
			tipologiaComunicazioneImpl.setNome(nome);
		}

		tipologiaComunicazioneImpl.resetOriginalValues();

		return tipologiaComunicazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tipologiaComunicazioneId = objectInput.readLong();
		nome = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tipologiaComunicazioneId);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}
	}

	public long tipologiaComunicazioneId;
	public String nome;

}