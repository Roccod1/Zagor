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

package it.servizidigitali.gestionecomunicazioni.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LetturaComunicazione service. Represents a row in the &quot;lettura_comunicazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LetturaComunicazioneModel
 * @generated
 */
@ImplementationClassName(
	"it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneImpl"
)
@ProviderType
public interface LetturaComunicazione
	extends LetturaComunicazioneModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LetturaComunicazione, Long>
		COMUNICAZIONE_ID_ACCESSOR = new Accessor<LetturaComunicazione, Long>() {

			@Override
			public Long get(LetturaComunicazione letturaComunicazione) {
				return letturaComunicazione.getComunicazioneId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LetturaComunicazione> getTypeClass() {
				return LetturaComunicazione.class;
			}

		};
	public static final Accessor<LetturaComunicazione, Long> USER_ID_ACCESSOR =
		new Accessor<LetturaComunicazione, Long>() {

			@Override
			public Long get(LetturaComunicazione letturaComunicazione) {
				return letturaComunicazione.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LetturaComunicazione> getTypeClass() {
				return LetturaComunicazione.class;
			}

		};

}