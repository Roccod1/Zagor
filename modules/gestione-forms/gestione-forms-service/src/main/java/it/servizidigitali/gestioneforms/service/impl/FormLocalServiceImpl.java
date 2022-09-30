/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package it.servizidigitali.gestioneforms.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.base.FormLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneforms.model.Form", service = AopService.class)
public class FormLocalServiceImpl extends FormLocalServiceBaseImpl {
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private GroupLocalService groupLocalService;

	public static final Log _log = LogFactoryUtil.getLog(FormLocalServiceImpl.class);

	@Override
	public List<Form> search(String nome, Date dataInserimentoDa, Date dataInserimentoA, long groupId, int inizio, int fine, OrderByComparator<Form> comparator) throws PortalException {
		

		List<Form> listaForm = formFinder.findFormByFilter(nome, dataInserimentoDa, dataInserimentoA, inizio, fine, comparator);
		Group group = null;
		Organization organization = null;

		for (Form form : listaForm) {
			group = groupLocalService.getGroup(form.getGroupId());
			long organizationIdSite = groupLocalService.getGroup(groupId).getOrganizationId();
			
			if(organizationIdSite==0) {
				
				if (group.getOrganizationId() > 0) {
					organization = organizationLocalService.getOrganization(group.getOrganizationId());
					form.setNomeEnte(organization.getName());
				}else {
					form.setNomeEnte("-");
				}
				
			}
		}

		return listaForm;
	}
	
	@Override
	public long count(String nome, Date dataInserimentoDa, Date dataInserimentoA) throws PortalException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Form.class, classLoader);
		
		if(Validator.isNotNull(nome)) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + nome + StringPool.PERCENT));
		}
		
		if(Validator.isNotNull(dataInserimentoDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", dataInserimentoDa));
		}
		
		if(Validator.isNotNull(dataInserimentoA)) {
			dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", dataInserimentoA));
		}
		
		long totale = formPersistence.countWithDynamicQuery(dynamicQuery);
		
		return totale;
	}

	@Override
	public List<Form> getListaFormByOrganizationPrincipale(long groupId, boolean principale) throws Exception {

		List<Form> listaForm = formPersistence.findByprincipaleAndGroupId(principale, groupId);

		if (Validator.isNotNull(listaForm) && !listaForm.isEmpty()) {
			for (Form form : listaForm) {
				List<DefinizioneAllegato> listaAllegati = definizioneAllegatoPersistence.findByformIdAndEliminato(form.getFormId(), false);

				if (Validator.isNotNull(listaAllegati)) {
					form.setListaDefinizioneAllegato(listaAllegati);
				}
				else {
					_log.error(":: getListaFormByOrganizationPrincipale :: Impossibile recuperare la lista degli allegati per il form con ID : " + form.getFormId());
				}
			}
		}
		else {
			_log.error(":: getListaFormByOrganizationPrincipale :: Impossibile recuperare la lista dei form dell'ente con ID : " + groupId);
		}

		return listaForm;
	}
}