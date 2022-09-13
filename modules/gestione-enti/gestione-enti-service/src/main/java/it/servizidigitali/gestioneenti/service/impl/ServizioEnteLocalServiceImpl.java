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

package it.servizidigitali.gestioneenti.service.impl;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.base.ServizioEnteLocalServiceBaseImpl;

/**
 * @author filierim
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneenti.model.ServizioEnte", service = AopService.class)
public class ServizioEnteLocalServiceImpl extends ServizioEnteLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ServizioEnteLocalServiceImpl.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Override
	public List<ServizioEnte> getServizioEntes(int start, int end) {
		List<ServizioEnte> servizioEntes = super.getServizioEntes(start, end);

		if (servizioEntes != null) {
			for (ServizioEnte servizioEnte : servizioEntes) {
				fillServizioEnte(servizioEnte);
			}
		}

		return servizioEntes;
	}

	@Override
	public List<ServizioEnte> getServiziEnte(long organizationId) {
		return servizioEntePersistence.findByOrganizationId(organizationId);
	}

	private void fillServizioEnte(ServizioEnte servizioEnte) {

		long organizationId = servizioEnte.getOrganizationId();
		if (organizationId != 0l) {
			try {
				Organization organization = organizationLocalService.getOrganization(organizationId);
				servizioEnte.setOrganization(organization);
				servizioEnte.setCodiceIPA(organization.getExpandoBridge().getAttribute("codiceIPA").toString());
				servizioEnte.setNome(organization.getName());
				servizioEnte.setDescrizione(organization.getComments());
			}
			catch (PortalException e) {
				_log.error(e);
			}
		}

	}

	@Override
	public List<Organization> findOrganizationsByParams(String nome, String codiceIpa, int cur, int delta, String orderByCol, String orderByType) throws Exception {
		_log.debug("Ricerca Organizzazioni :: INIZIO");

		List<Organization> listaOrganizations = null;
		ClassLoader classLoader = getClass().getClassLoader();

		// preparo i parametri per ordinamento e paginazione
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		int inizio = posizioni[0];
		int fine = posizioni[1];
		if (Validator.isNull(orderByCol)) {
			_log.debug("Nessun ordinamento impostato. Uso di default organizationId");
			orderByCol = "organizationId";
		}

		if (inizio <= 0 || fine <= 0) {
			_log.debug("Posizione iniziale o finale sono minori o uguali a zero. Imposto inizio e fine al valore ALL_POS");
			inizio = QueryUtil.ALL_POS;
			fine = QueryUtil.ALL_POS;
		}

		boolean direzione = "desc".equals(orderByType.toLowerCase()) ? false : true;
		OrderByComparator<Organization> ordine = OrderByComparatorFactoryUtil.create("Organization", orderByCol, direzione);

		DynamicQuery listaOrganizationQuery = DynamicQueryFactoryUtil.forClass(Organization.class, classLoader);

		if (Validator.isNotNull(codiceIpa)) {
			_log.debug("codiceIpa: " + codiceIpa);
			// ottengo l'id del custom field "codiceIpa"
			DynamicQuery expandoColumn = DynamicQueryFactoryUtil.forClass(ExpandoColumn.class, classLoader);
			expandoColumn.add(RestrictionsFactoryUtil.eq("name", "codiceIPA"));
			expandoColumn.setProjection(ProjectionFactoryUtil.property("columnId"));

			// ottengo la lista di id che rispecchiano il filtro per codiceIpa
			DynamicQuery expandoValue = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, classLoader);
			expandoValue.add(RestrictionsFactoryUtil.like("data", StringPool.PERCENT + codiceIpa + StringPool.PERCENT));
			expandoValue.add(PropertyFactoryUtil.forName("columnId").in(expandoColumn));
			expandoValue.setProjection(ProjectionFactoryUtil.property("classPK"));

			// aggiungo il filtro per codiceIpa alla dynamicquery globale per ottenere le
			// Organization
			listaOrganizationQuery.add(PropertyFactoryUtil.forName("organizationId").in(expandoValue));
		}

		if (Validator.isNotNull(nome)) {
			_log.debug("nome: " + nome);
			listaOrganizationQuery.add(RestrictionsFactoryUtil.like("name", (StringPool.PERCENT + nome + StringPool.PERCENT)));
		}

		// solo organizzazioni di primo livello
		listaOrganizationQuery.add(RestrictionsFactoryUtil.eq("parentOrganizationId", 0L));
		// eseguo la dynamic query

		try {
			listaOrganizations = organizationLocalService.dynamicQuery(listaOrganizationQuery, inizio, fine, ordine);
		}
		catch (Exception e) {
			_log.error("findOrganizationsByParams :: " + e.getMessage(), e);
		}

		_log.debug("Ricerca Organizzazioni :: FINE");
		return listaOrganizations;
	}

	@Override
	public List<Object> getListaServiziByCompanyOrganizationAttivo(long companyId, long organizationId, boolean attivo) throws Exception {

		ClassLoader classLoader = getClassLoader();
		DynamicQuery servizioEnteDynamicQuery = DynamicQueryFactoryUtil.forClass(ServizioEnte.class, classLoader);

		servizioEnteDynamicQuery.add(RestrictionsFactoryUtil.eq("attivo", attivo));

		if (companyId > 0) {
			servizioEnteDynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		}

		if (organizationId > 0) {
			servizioEnteDynamicQuery.add(RestrictionsFactoryUtil.eq("primaryKey.organizationId", organizationId));
		}
		// imposto projection per ottenere solo gli id delle entity
		servizioEnteDynamicQuery.setProjection(ProjectionFactoryUtil.property("primaryKey.servizioId"));

		return servizioEntePersistence.findWithDynamicQuery(servizioEnteDynamicQuery);
	}

	@Override
	public List<Long> getListaServiziByOrganizationAttivo(long organizationId, boolean attivo) throws Exception {

		ClassLoader classLoader = getClassLoader();
		DynamicQuery servizioEnteDynamicQuery = DynamicQueryFactoryUtil.forClass(ServizioEnte.class, classLoader);

		servizioEnteDynamicQuery.add(RestrictionsFactoryUtil.eq("attivo", attivo));

		if (organizationId > 0) {
			servizioEnteDynamicQuery.add(RestrictionsFactoryUtil.eq("primaryKey.organizationId", organizationId));
		}
		// imposto projection per ottenere solo gli id delle entity
		servizioEnteDynamicQuery.setProjection(ProjectionFactoryUtil.property("primaryKey.servizioId"));

		return servizioEntePersistence.findWithDynamicQuery(servizioEnteDynamicQuery);
	}

	@Override
	public ServizioEnte getServizioEnteByGroupIdLayoutId(long groupId, long layoutId) {
		ServizioEnte servizioEnte = servizioEnteFinder.findServizioEnteByGroupIdLayoutId(groupId, layoutId);
		return servizioEnte;
	}
}