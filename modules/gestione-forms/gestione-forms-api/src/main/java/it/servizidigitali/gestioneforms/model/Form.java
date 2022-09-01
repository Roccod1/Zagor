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

package it.servizidigitali.gestioneforms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Form service. Represents a row in the &quot;form&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FormModel
 * @generated
 */
@ImplementationClassName("it.servizidigitali.gestioneforms.model.impl.FormImpl")
@ProviderType
public interface Form extends FormModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.servizidigitali.gestioneforms.model.impl.FormImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Form, Long> FORM_ID_ACCESSOR =
		new Accessor<Form, Long>() {

			@Override
			public Long get(Form form) {
				return form.getFormId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Form> getTypeClass() {
				return Form.class;
			}

		};

	public java.util.List
		<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
			getListaDefinizioneAllegato();

	public void setListaDefinizioneAllegato(
		java.util.List
			<it.servizidigitali.gestioneforms.model.DefinizioneAllegato>
				listaDefinizioneAllegato);

	public String getNomeEnte();

	public void setNomeEnte(String nomeEnte);

}