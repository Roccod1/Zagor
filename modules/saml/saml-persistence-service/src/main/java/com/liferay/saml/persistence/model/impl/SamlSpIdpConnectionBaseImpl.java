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

package com.liferay.saml.persistence.model.impl;

import com.liferay.saml.persistence.model.SamlSpIdpConnection;
import com.liferay.saml.persistence.service.SamlSpIdpConnectionLocalServiceUtil;

/**
 * The extended model base implementation for the SamlSpIdpConnection service. Represents a row in the &quot;SamlSpIdpConnection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SamlSpIdpConnectionImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlSpIdpConnectionImpl
 * @see SamlSpIdpConnection
 * @generated
 */
public abstract class SamlSpIdpConnectionBaseImpl
	extends SamlSpIdpConnectionModelImpl implements SamlSpIdpConnection {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a saml sp idp connection model instance should use the <code>SamlSpIdpConnection</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			SamlSpIdpConnectionLocalServiceUtil.addSamlSpIdpConnection(this);
		}
		else {
			SamlSpIdpConnectionLocalServiceUtil.updateSamlSpIdpConnection(this);
		}
	}

}