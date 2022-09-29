package it.servizidigitali.restservice.internal.converter;

import com.liferay.portal.kernel.model.Organization;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.LayoutUtility;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.restservice.dto.v1_0.InfoServizioEnte;

/**
 * @author pindi
 *
 */
@Component(immediate = true, name = "entityToSchemaModelConverter", service = EntityToSchemaModelConverter.class)
public class EntityToSchemaModelConverter {

	@Reference
	private TipologiaLocalService tipologiaLocalService;

	@Reference
	private LayoutUtility layoutUtility;

	/**
	 *
	 * @param servizioEnte
	 * @param organization
	 * @param servizio
	 * @return
	 */
	public InfoServizioEnte getInfoServizioEnte(ServizioEnte servizioEnte, Organization organization, Servizio servizio) {

		InfoServizioEnte infoServizioEnte = new InfoServizioEnte();
		infoServizioEnte.setCodiceIpa(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_IPA.getNomeAttributo()).toString());
		infoServizioEnte.setActive(servizioEnte.isAttivo());
		infoServizioEnte.setCode(servizio.getCodice());
		infoServizioEnte.setDescription(servizioEnte.getDescrizione());
		infoServizioEnte.setId(servizioEnte.getServizioId());
		infoServizioEnte.setNomeComune(organization.getName());
		infoServizioEnte.setTitle(servizioEnte.getNome());
		infoServizioEnte.setUsableByChatbot(false);

		List<Tipologia> tipologie = tipologiaLocalService.getServizioTipologias(servizio.getServizioId());
		for (Tipologia tipologia : tipologie) {
			if (tipologia.getChatbotInlineIntent() != null) {
				infoServizioEnte.setChatbotInline(true);
				infoServizioEnte.setChatbotInlineIntent(tipologia.getChatbotInlineIntent());
				break;
			}
		}

		// TODO DA RENDERE DINAMICI
		switch (servizio.getCodice()) {
		case "SS01":
			infoServizioEnte.setCorrelatedPaymentServiceCode("PGSS1");
			break;
		case "SS04":
			infoServizioEnte.setCorrelatedPaymentServiceCode("PGSS4");
			break;

		default:
			break;
		}

		long publicLayoutId = servizioEnte.getPublicLayoutId();
		long privateLayoutId = servizioEnte.getPrivateLayoutId();

		String pathServizio = null;
		if (publicLayoutId != 0 || (publicLayoutId != 0 && privateLayoutId != 0)) {
			pathServizio = layoutUtility.getPathByLayoutId(publicLayoutId, organization.getGroupId(), organization.getCompanyId());
		}
		else if (privateLayoutId != 0) {
			pathServizio = layoutUtility.getPathByLayoutId(privateLayoutId, organization.getGroupId(), organization.getCompanyId());
		}

		infoServizioEnte.setServiceOnlineUrl(pathServizio);
		// TODO da completare
		// infoServizioEnte.setDestinazioneUsos(null);
		// infoServizioEnte.setServiceCardUrl();

		return infoServizioEnte;
	}

}
