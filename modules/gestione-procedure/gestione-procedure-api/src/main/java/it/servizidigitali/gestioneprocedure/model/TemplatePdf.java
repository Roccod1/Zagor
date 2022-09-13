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

package it.servizidigitali.gestioneprocedure.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the TemplatePdf service. Represents a row in the &quot;template_pdf&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdfModel
 * @generated
 */
@ImplementationClassName(
	"it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfImpl"
)
@ProviderType
public interface TemplatePdf extends PersistedModel, TemplatePdfModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TemplatePdf, Long> TEMPLATE_PDF_ID_ACCESSOR =
		new Accessor<TemplatePdf, Long>() {

			@Override
			public Long get(TemplatePdf templatePdf) {
				return templatePdf.getTemplatePdfId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TemplatePdf> getTypeClass() {
				return TemplatePdf.class;
			}

		};

	public String getNomeFile();

	public void setNomeFile(String nomeFile);

}