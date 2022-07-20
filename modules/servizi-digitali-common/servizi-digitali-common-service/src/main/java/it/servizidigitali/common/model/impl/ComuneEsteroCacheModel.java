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

import it.servizidigitali.common.model.ComuneEstero;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ComuneEstero in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ComuneEsteroCacheModel
	implements CacheModel<ComuneEstero>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComuneEsteroCacheModel)) {
			return false;
		}

		ComuneEsteroCacheModel comuneEsteroCacheModel =
			(ComuneEsteroCacheModel)object;

		if (comuneEsteroId == comuneEsteroCacheModel.comuneEsteroId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, comuneEsteroId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{comuneEsteroId=");
		sb.append(comuneEsteroId);
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", denominazione=");
		sb.append(denominazione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ComuneEstero toEntityModel() {
		ComuneEsteroImpl comuneEsteroImpl = new ComuneEsteroImpl();

		comuneEsteroImpl.setComuneEsteroId(comuneEsteroId);
		comuneEsteroImpl.setCodice(codice);

		if (denominazione == null) {
			comuneEsteroImpl.setDenominazione("");
		}
		else {
			comuneEsteroImpl.setDenominazione(denominazione);
		}

		comuneEsteroImpl.resetOriginalValues();

		return comuneEsteroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		comuneEsteroId = objectInput.readLong();

		codice = objectInput.readInt();
		denominazione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(comuneEsteroId);

		objectOutput.writeInt(codice);

		if (denominazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazione);
		}
	}

	public long comuneEsteroId;
	public int codice;
	public String denominazione;

}