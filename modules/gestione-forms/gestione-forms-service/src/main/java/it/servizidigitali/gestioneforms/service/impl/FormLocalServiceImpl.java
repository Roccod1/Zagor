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

package it.servizidigitali.gestioneforms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.base.FormLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneforms.model.Form",
	service = AopService.class
)
public class FormLocalServiceImpl extends FormLocalServiceBaseImpl {
	
	public List<Form> search(String nome, Date dataInserimentoDa, Date dataInserimentoA, int delta, int cur, String orderByCol, String orderByType) throws PortalException{
		boolean direzione = false;
		
		if(orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}
		
		if(Validator.isNull(orderByCol)) {
			orderByCol = "formId";
		}
		
		OrderByComparator<Form> comparator = OrderByComparatorFactoryUtil.create("Form", orderByCol, direzione);
		
		List<Form> listaForm = formFinder.findFormByFilter(nome, dataInserimentoDa, dataInserimentoA, cur, delta, comparator);
		
		
		for(Form form : listaForm) {
			Group group = GroupLocalServiceUtil.getGroup(form.getGroupId());
			if(group.getOrganizationId()>0) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(group.getOrganizationId());
				form.setNomeEnte(organization.getName());
			}else {
				form.setNomeEnte("-");
			}
		}
		
		return listaForm;
	}
}