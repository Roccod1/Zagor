package it.servizidigitali.gestionepagamenti.frontend.service;

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
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.model.Pagamento;

@Component(name = "getOrganizzazioniService", immediate = true, service = GestionePagamentiService.class)
public class GestionePagamentiService {
	
	public static final Log LOG = LogFactoryUtil.getLog(GestionePagamentiService.class);

	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private GroupLocalService groupLocalService;
	
	public List<Organization> getAllParentsOrganizations() {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Organization.class, this.getClass().getClassLoader());
		dynamicQuery.add(RestrictionsFactoryUtil.eq("parentOrganizationId", 0L));
		
		return organizationLocalService.dynamicQuery(dynamicQuery);
	}
	
	public Organization getOrganization(long organizationId) {
		
		Organization organization = null;
		
		try {
			organization = organizationLocalService.getOrganization(organizationId);
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
		
		return organization;
	}
	
	public void initAdditionalData(Pagamento pagamento) {
		
		String stato = pagamento.getStato();
		
		if (Validator.isNotNull(stato)) {
			StatoPagamento statoPagamento = StatoPagamento.valueOf(stato);
			pagamento.setStatoEnum(statoPagamento);
		}
		
		String nomeOrganizzazione = "-";
		
		long groupId = pagamento.getGroupId();
		long organizationId = 0;
		Organization organization = null;
		
		if (groupId != 0) {
			try {
				Group group = groupLocalService.getGroup(groupId);
				
				organizationId = group.getOrganizationId();
				
			} catch (PortalException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		if (organizationId != 0) {
			organization = this.getOrganization(organizationId);
		}
		if (Validator.isNotNull(organization)) {
			nomeOrganizzazione = organization.getName();
		}
		pagamento.setNomeOrganizzazione(nomeOrganizzazione);
	}
}