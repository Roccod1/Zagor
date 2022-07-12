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

import it.servizidigitali.common.model.StatoEstero;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatoEstero in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StatoEsteroCacheModel
	implements CacheModel<StatoEstero>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StatoEsteroCacheModel)) {
			return false;
		}

		StatoEsteroCacheModel statoEsteroCacheModel =
			(StatoEsteroCacheModel)object;

		if (statoEsteroId == statoEsteroCacheModel.statoEsteroId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, statoEsteroId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{statoEsteroId=");
		sb.append(statoEsteroId);
		sb.append(", continente=");
		sb.append(continente);
		sb.append(", codiceArea=");
		sb.append(codiceArea);
		sb.append(", codiceStato=");
		sb.append(codiceStato);
		sb.append(", denominazione=");
		sb.append(denominazione);
		sb.append(", denominazioneEng=");
		sb.append(denominazioneEng);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoEstero toEntityModel() {
		StatoEsteroImpl statoEsteroImpl = new StatoEsteroImpl();

		statoEsteroImpl.setStatoEsteroId(statoEsteroId);
		statoEsteroImpl.setContinente(continente);
		statoEsteroImpl.setCodiceArea(codiceArea);
		statoEsteroImpl.setCodiceStato(codiceStato);

		if (denominazione == null) {
			statoEsteroImpl.setDenominazione("");
		}
		else {
			statoEsteroImpl.setDenominazione(denominazione);
		}

		if (denominazioneEng == null) {
			statoEsteroImpl.setDenominazioneEng("");
		}
		else {
			statoEsteroImpl.setDenominazioneEng(denominazioneEng);
		}

		statoEsteroImpl.resetOriginalValues();

		return statoEsteroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		statoEsteroId = objectInput.readLong();

		continente = objectInput.readInt();

		codiceArea = objectInput.readInt();

		codiceStato = objectInput.readInt();
		denominazione = objectInput.readUTF();
		denominazioneEng = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(statoEsteroId);

		objectOutput.writeInt(continente);

		objectOutput.writeInt(codiceArea);

		objectOutput.writeInt(codiceStato);

		if (denominazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazione);
		}

		if (denominazioneEng == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(denominazioneEng);
		}
	}

	public long statoEsteroId;
	public int continente;
	public int codiceArea;
	public int codiceStato;
	public String denominazione;
	public String denominazioneEng;

}