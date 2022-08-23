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

import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione;
import it.servizidigitali.gestionecomunicazioni.service.persistence.LetturaComunicazionePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LetturaComunicazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LetturaComunicazioneCacheModel
	implements CacheModel<LetturaComunicazione>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LetturaComunicazioneCacheModel)) {
			return false;
		}

		LetturaComunicazioneCacheModel letturaComunicazioneCacheModel =
			(LetturaComunicazioneCacheModel)object;

		if (letturaComunicazionePK.equals(
				letturaComunicazioneCacheModel.letturaComunicazionePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, letturaComunicazionePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{comunicazioneId=");
		sb.append(comunicazioneId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", dataLettura=");
		sb.append(dataLettura);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LetturaComunicazione toEntityModel() {
		LetturaComunicazioneImpl letturaComunicazioneImpl =
			new LetturaComunicazioneImpl();

		letturaComunicazioneImpl.setComunicazioneId(comunicazioneId);
		letturaComunicazioneImpl.setUserId(userId);

		if (dataLettura == Long.MIN_VALUE) {
			letturaComunicazioneImpl.setDataLettura(null);
		}
		else {
			letturaComunicazioneImpl.setDataLettura(new Date(dataLettura));
		}

		letturaComunicazioneImpl.resetOriginalValues();

		return letturaComunicazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		comunicazioneId = objectInput.readLong();

		userId = objectInput.readLong();
		dataLettura = objectInput.readLong();

		letturaComunicazionePK = new LetturaComunicazionePK(
			comunicazioneId, userId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(comunicazioneId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(dataLettura);
	}

	public long comunicazioneId;
	public long userId;
	public long dataLettura;
	public transient LetturaComunicazionePK letturaComunicazionePK;

}