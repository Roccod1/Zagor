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

package it.servizidigitali.scrivaniaoperatore.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DestinazioneUso service. Represents a row in the &quot;destinazione_uso&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DestinazioneUsoModel
 * @generated
 */
@ImplementationClassName(
	"it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoImpl"
)
@ProviderType
public interface DestinazioneUso extends DestinazioneUsoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DestinazioneUso, Long>
		DESTINAZIONE_USO_ID_ACCESSOR = new Accessor<DestinazioneUso, Long>() {

			@Override
			public Long get(DestinazioneUso destinazioneUso) {
				return destinazioneUso.getDestinazioneUsoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DestinazioneUso> getTypeClass() {
				return DestinazioneUso.class;
			}

		};

}