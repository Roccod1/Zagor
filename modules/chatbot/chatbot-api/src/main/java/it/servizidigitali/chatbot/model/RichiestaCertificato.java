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

package it.servizidigitali.chatbot.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RichiestaCertificato service. Represents a row in the &quot;richiesta_certificato&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificatoModel
 * @generated
 */
@ImplementationClassName(
	"it.servizidigitali.chatbot.model.impl.RichiestaCertificatoImpl"
)
@ProviderType
public interface RichiestaCertificato
	extends PersistedModel, RichiestaCertificatoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.chatbot.model.impl.RichiestaCertificatoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RichiestaCertificato, Long>
		RICHIESTA_CERTIFICATO_ID_ACCESSOR =
			new Accessor<RichiestaCertificato, Long>() {

				@Override
				public Long get(RichiestaCertificato richiestaCertificato) {
					return richiestaCertificato.getRichiestaCertificatoId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<RichiestaCertificato> getTypeClass() {
					return RichiestaCertificato.class;
				}

			};

}