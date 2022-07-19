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

package it.servizidigitali.profiloutente.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UtenteOrganizzazione service. Represents a row in the &quot;utente_organizzazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneModel
 * @generated
 */
@ImplementationClassName(
	"it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneImpl"
)
@ProviderType
public interface UtenteOrganizzazione
	extends PersistedModel, UtenteOrganizzazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UtenteOrganizzazione, Long>
		UTENTE_ID_ACCESSOR = new Accessor<UtenteOrganizzazione, Long>() {

			@Override
			public Long get(UtenteOrganizzazione utenteOrganizzazione) {
				return utenteOrganizzazione.getUtenteId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UtenteOrganizzazione> getTypeClass() {
				return UtenteOrganizzazione.class;
			}

		};
	public static final Accessor<UtenteOrganizzazione, Long>
		ORGANIZATION_ID_ACCESSOR = new Accessor<UtenteOrganizzazione, Long>() {

			@Override
			public Long get(UtenteOrganizzazione utenteOrganizzazione) {
				return utenteOrganizzazione.getOrganizationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UtenteOrganizzazione> getTypeClass() {
				return UtenteOrganizzazione.class;
			}

		};

}