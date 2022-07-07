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

package it.servizidigitali.gestioneprocessi.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the bytes column in Processo.
 *
 * @author Brian Wing Shun Chan
 * @see Processo
 * @generated
 */
public class ProcessoBytesBlobModel {

	public ProcessoBytesBlobModel() {
	}

	public ProcessoBytesBlobModel(long processoId) {
		_processoId = processoId;
	}

	public ProcessoBytesBlobModel(long processoId, Blob bytesBlob) {
		_processoId = processoId;
		_bytesBlob = bytesBlob;
	}

	public long getProcessoId() {
		return _processoId;
	}

	public void setProcessoId(long processoId) {
		_processoId = processoId;
	}

	public Blob getBytesBlob() {
		return _bytesBlob;
	}

	public void setBytesBlob(Blob bytesBlob) {
		_bytesBlob = bytesBlob;
	}

	private long _processoId;
	private Blob _bytesBlob;

}