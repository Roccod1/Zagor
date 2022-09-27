package it.servizidigitali.restservice.internal.resource.v1_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.restservice.dto.v1_0.InfoServizioEnte;
import it.servizidigitali.restservice.resource.v1_0.ServiziResource;

/**
 * @author pindi
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/servizi.properties", scope = ServiceScope.PROTOTYPE, service = ServiziResource.class)
public class ServiziResourceImpl extends BaseServiziResourceImpl {

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private CompanyLocalService companyLocalService;

	@Override
	public InfoServizioEnte getInfoServizioEnte(@NotNull String codiceServizio, String nomeComune, String amministrazione) throws Exception {

		Company company = companyLocalService.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		long organizationId = organizationLocalService.getOrganizationId(company.getCompanyId(), nomeComune);

		if (organizationId == 0) {
			// TODO 404
		}

		Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
		if (servizio == null) {
			// TODO 404
		}
		ServizioEntePK servizioEntePK = new ServizioEntePK(servizio.getServizioId(), organizationId);
		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);

		if (servizioEnte == null || !servizioEnte.isAttivo()) {
			// TODO 404
		}

		Organization organization = organizationLocalService.getOrganization(organizationId);

		InfoServizioEnte infoServizioEnte = new InfoServizioEnte();
		infoServizioEnte.setCodiceIpa(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_IPA.getNomeAttributo()).toString());
		// TODO completare da servizioEnte

		return super.getInfoServizioEnte(codiceServizio, nomeComune, amministrazione);
	}

}