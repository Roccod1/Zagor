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

package it.servizidigitali.scrivaniaoperatore.model.impl;

import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.service.CommentoRichiestaLocalServiceUtil;

/**
 * The extended model base implementation for the CommentoRichiesta service. Represents a row in the &quot;commento_richiesta&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommentoRichiestaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentoRichiestaImpl
 * @see CommentoRichiesta
 * @generated
 */
public abstract class CommentoRichiestaBaseImpl
	extends CommentoRichiestaModelImpl implements CommentoRichiesta {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commento richiesta model instance should use the <code>CommentoRichiesta</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CommentoRichiestaLocalServiceUtil.addCommentoRichiesta(this);
		}
		else {
			CommentoRichiestaLocalServiceUtil.updateCommentoRichiesta(this);
		}
	}

}