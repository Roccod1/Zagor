package it.servizidigitali.restservice.internal.resource.v1_0;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import it.servizidigitali.common.utility.OrganizationUtility;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.restservice.dto.v1_0.CountServizioEnte;
import it.servizidigitali.restservice.dto.v1_0.InfoServizioEnte;
import it.servizidigitali.restservice.internal.constant.ServiziDigitaliRestConstants;
import it.servizidigitali.restservice.internal.converter.EntityToSchemaModelConverter;
import it.servizidigitali.restservice.internal.util.MessageUtil;
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

	@Reference
	private OrganizationUtility _organizationUtility;

	@Reference
	private EntityToSchemaModelConverter entityToSchemaModelConverter;

	@Override
	public Page<InfoServizioEnte> getServiziEnte(String nomeComune, @NotNull Long codiceTipologiaServizio, String amministrazione) throws Exception {
		// TODO Auto-generated method stub
		return super.getServiziEnte(nomeComune, codiceTipologiaServizio, amministrazione);
	}

	@Override
	public Page<CountServizioEnte> getCountServizioEnte(String codiceServizio) throws Exception {
		// TODO Auto-generated method stub
		return super.getCountServizioEnte(codiceServizio);
	}

	@Override
	public InfoServizioEnte getInfoServizioEnte(@NotNull String codiceServizio, String nomeComune, String amministrazione) throws Exception {

		MessageUtil messageUtil = new MessageUtil(ServiziDigitaliRestConstants.BUNDLE_SYMBOLIC_NAME, null);

		Organization organization = _organizationUtility.getByName(nomeComune);

		// Amministrazione = codice ipa = query su expando bridge

		if (Validator.isNull(organization)) {

			String message = messageUtil.getMessage("resourceNotFoundMessage", "Organization");

			throw new NotFoundException(message);
		}

		Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
		if (servizio == null) {
			String message = messageUtil.getMessage("resourceNotFoundMessage", "Servizio");
			throw new NotFoundException(message);
		}
		ServizioEntePK servizioEntePK = new ServizioEntePK(servizio.getServizioId(), organization.getOrganizationId());
		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);

		if (servizioEnte == null || !servizioEnte.isAttivo()) {
			String message = messageUtil.getMessage("resourceNotFoundMessage", "Servizio ente");
			throw new NotFoundException(message);
		}

		InfoServizioEnte infoServizioEnte = entityToSchemaModelConverter.getInfoServizioEnte(servizioEnte, organization, servizio);

		return infoServizioEnte;
	}

}