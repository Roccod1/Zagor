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

package it.servizidigitali.gestioneprocessi.service.impl;

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
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.base.ProcessoLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneprocessi.model.Processo", service = AopService.class)
public class ProcessoLocalServiceImpl extends ProcessoLocalServiceBaseImpl {

	public static final Log _log = LogFactoryUtil.getLog(ProcessoLocalServiceImpl.class);
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private GroupLocalService groupLocalService;

	@Override
	public List<Processo> search(String nome, Date dataInserimentoDa, Date dataInserimentoA, long groupId, int delta, int cur, String orderByCol, String orderByType) throws PortalException {
		boolean direzione = false;

		if (orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "processoId";
		}

		OrderByComparator<Processo> comparator = OrderByComparatorFactoryUtil.create("Processo", orderByCol, direzione);
		List<Processo> listaProcesso = processoFinder.findByFilters(nome, dataInserimentoDa, dataInserimentoA, cur, delta, comparator);
		List<Processo> listaProcessoFiltrata = new ArrayList<Processo>();
		Group group = null;
		Organization organization = null;

		for (Processo processo : listaProcesso) {
			group = groupLocalService.getGroup(processo.getGroupId());
			long organizationIdSite = groupLocalService.getGroup(groupId).getOrganizationId();
			
			if(organizationIdSite==0) {
				
				if (group.getOrganizationId() > 0) {
					organization = organizationLocalService.getOrganization(group.getOrganizationId());
					processo.setNomeEnte(organization.getName());
				}else {
					processo.setNomeEnte("-");
				}
				
				listaProcessoFiltrata.add(processo);
			}else {
				if(group.getGroupId()==groupId) {
					
					if (group.getOrganizationId() > 0) {
						organization = organizationLocalService.getOrganization(group.getOrganizationId());
						processo.setNomeEnte(organization.getName());
					}else {
						processo.setNomeEnte("-");
					}
					
					listaProcessoFiltrata.add(processo);	

				}
				
				if(group.getOrganizationId()==0) {
					if(!listaProcessoFiltrata.contains(processo)) {
						processo.setNomeEnte("-");
						listaProcessoFiltrata.add(processo);
					}
				}
			}

		}

		return listaProcessoFiltrata;
	}

	@Override
	public Processo getProcessoByCodice(String codice) throws NoSuchProcessoException {
		Processo processo = processoPersistence.findByCodice(codice);
		return processo;
	}

	@Override
	public List<Processo> getListaProcessiByOrganizationAttivo(long groupId, boolean attivo) throws Exception {

		ClassLoader classLoader = getClassLoader();
		DynamicQuery processoDynamicQuery = DynamicQueryFactoryUtil.forClass(Processo.class, classLoader);

		processoDynamicQuery.add(RestrictionsFactoryUtil.eq("attivo", attivo));

		if (groupId > 0) {
			processoDynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		}

		return processoPersistence.findWithDynamicQuery(processoDynamicQuery);
	}

}