package it.servizidigitali.restservice.internal.converter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.LayoutUtility;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;
import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.AreaTematicaLocalService;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.restservice.dto.v1_0.DestinazioneUso;
import it.servizidigitali.restservice.dto.v1_0.InfoServizioEnte;
import it.servizidigitali.restservice.dto.v1_0.RichiestaServizio;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoLocalService;

/**
 * @author pindi
 *
 */
@Component(immediate = true, name = "entityToSchemaModelConverter", service = EntityToSchemaModelConverter.class)
public class EntityToSchemaModelConverter {

	private static final String HOME_SCHEDA_SERVIZIO_PATH = "/home/-/scheda-servizio/";

	private static final Log log = LogFactoryUtil.getLog(EntityToSchemaModelConverter.class.getName());

	@Reference
	private TipologiaLocalService tipologiaLocalService;

	@Reference
	private LayoutUtility layoutUtility;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private DestinazioneUsoLocalService destinazioneUsoLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private AreaTematicaLocalService areaTematicaLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ProcessoLocalService processoLocalService;

	/**
	 *
	 * @param servizioEnte
	 * @param organization
	 * @param servizio
	 * @return
	 */
	public InfoServizioEnte getInfoServizioEnte(ServizioEnte servizioEnte, Organization organization, Servizio servizio) {

		InfoServizioEnte infoServizioEnte = new InfoServizioEnte();
		Serializable codIPA = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_IPA.getNomeAttributo());
		infoServizioEnte.setCodiceIpa(codIPA != null ? codIPA.toString() : null);
		infoServizioEnte.setActive(servizioEnte.isAttivo());
		infoServizioEnte.setCode(servizio.getCodice());
		infoServizioEnte.setDescription(servizio.getDescrizione());
		infoServizioEnte.setId(servizioEnte.getServizioId());
		infoServizioEnte.setNomeComune(organization.getName());
		infoServizioEnte.setTitle(servizio.getNome());
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

		String pathServizio = getPathServizio(servizioEnte, organization);

		infoServizioEnte.setServiceOnlineUrl(pathServizio);

		List<DestinazioneUso> destinazioneUso = getDestinazioniUso(servizioEnte.getServizioId(), organization.getOrganizationId(), organization.getGroupId(), organization.getCompanyId());

		if (destinazioneUso != null && !destinazioneUso.isEmpty()) {
			infoServizioEnte.setDestinazioneUsos(destinazioneUso.toArray(new DestinazioneUso[0]));
		}

		infoServizioEnte.setServiceCardUrl(getSchedaServizioPath(servizioEnte.getServizioId(), organization.getOrganizationId(), organization.getCompanyId()));

		return infoServizioEnte;
	}

	public String getPathServizio(ServizioEnte servizioEnte, Organization organization) {
		long publicLayoutId = servizioEnte.getPublicLayoutId();
		long privateLayoutId = servizioEnte.getPrivateLayoutId();

		String pathServizio = null;
		if (publicLayoutId != 0 || (publicLayoutId != 0 && privateLayoutId != 0)) {
			pathServizio = layoutUtility.getPathByLayoutId(publicLayoutId, organization.getGroupId(), organization.getCompanyId());
		}
		else if (privateLayoutId != 0) {
			pathServizio = layoutUtility.getPathByLayoutId(privateLayoutId, organization.getGroupId(), organization.getCompanyId());
		}
		return pathServizio;
	}

	/**
	 *
	 * @param servizioId
	 * @param organizationId
	 * @param groupId
	 * @param companyId
	 * @return
	 */
	private List<DestinazioneUso> getDestinazioniUso(long servizioId, long organizationId, long groupId, long companyId) {

		List<it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso> destinazioniUso = destinazioneUsoLocalService.getDestinazioniUsoByServizioIdOrganizationId(servizioId, organizationId,
				groupId, companyId);

		List<DestinazioneUso> results = new ArrayList<DestinazioneUso>();

		for (it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso destinazioneUso : destinazioniUso) {
			DestinazioneUso destinazioneUsoResult = new DestinazioneUso();
			destinazioneUsoResult.setId(destinazioneUso.getDestinazioneUsoId());
			destinazioneUsoResult.setName(destinazioneUso.getNome());
			destinazioneUsoResult.setDescription(destinazioneUso.getDescrizione());
			destinazioneUsoResult.setPayment(destinazioneUso.getPagamentoBollo());
			results.add(destinazioneUsoResult);
		}
		return results;
	}

	/**
	 *
	 * @param servizioId
	 * @param organizationId
	 * @param companyId
	 * @return
	 */
	private String getSchedaServizioPath(long servizioId, long organizationId, long companyId) {

		ServizioEntePK servizioEntePK = new ServizioEntePK(servizioId, organizationId);

		try {
			ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);
			if (servizioEnte != null) {
				String schedaServizioPath = layoutUtility.getSitePath(organizationLocalService.getOrganization(organizationId).getGroupId(), companyId) + HOME_SCHEDA_SERVIZIO_PATH + servizioId;
				return schedaServizioPath;
			}
		}
		catch (Exception e) {
			log.error("getSchedaServizioPath :: " + e.getMessage(), e);
		}

		return null;
	}

	/**
	 *
	 * @param richiesta
	 * @return
	 * @throws PortalException
	 */
	public RichiestaServizio getRichiestaServizio(Richiesta richiesta) throws PortalException {

		if (richiesta == null) {
			return null;
		}

		User user = userLocalService.getUser(richiesta.getUserId());

		Procedura procedura = proceduraLocalService.getProcedura(richiesta.getProceduraId());
		Processo processo = processoLocalService.getProcesso(procedura.getProcessoId());
		Organization organization = organizationLocalService.getOrganization(groupLocalService.getGroup(richiesta.getGroupId()).getOrganizationId());

		Servizio servizio = servizioLocalService.getServizio(procedura.getServizioId());

		AreaTematica areaTematica = areaTematicaLocalService.getAreaTematica(servizio.getAreaTematicaId());

		RichiestaServizio richiestaServizio = new RichiestaServizio();
		richiestaServizio.setCodiceAreaTematica(areaTematica.getCodice());
		richiestaServizio.setCodiceFiscaleRichiedente(richiesta.getCodiceFiscale());
		richiestaServizio.setCodiceFiscaleDelegato(richiesta.getCodiceFiscaleDelegato());
		richiestaServizio.setCodiceIdentificativoServizio(servizio.getCodice());
		richiestaServizio.setDataAggiornamento(richiesta.getModifiedDate());
		richiestaServizio.setDataInserimento(richiesta.getCreateDate());
		richiestaServizio.setDataProtocollo(richiesta.getDataProtocollo());
		richiestaServizio.setDataProtocolloEsterno(richiesta.getDataProtocolloEsterno());
		richiestaServizio.setDenominazioneAreaTematica(areaTematica.getNome());
		richiestaServizio.setDenominazioneEnte(organization.getName());
		richiestaServizio.setDenominazioneRichiedente(richiesta.getCodiceFiscale());
		richiestaServizio.setDenominazioneServizio(servizio.getNome());
		richiestaServizio.setEmailRichiedente(user.getEmailAddress());
		richiestaServizio.setId(richiesta.getRichiestaId());
		richiestaServizio.setIdentificativoEnte(organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_IPA.getNomeAttributo()).toString());
		richiestaServizio.setIdentificativoProcesso(processo.getCodice());
		richiestaServizio.setIdProcedura(richiesta.getProceduraId());
		richiestaServizio.setNote(richiesta.getNote());
		richiestaServizio.setNumeroProtocollo(richiesta.getNumeroProtocollo());
		richiestaServizio.setNumeroProtocolloEsterno(richiesta.getNumeroProtocolloEsterno());
		richiestaServizio.setOggetto(richiesta.getOggetto());
		richiestaServizio.setPartitaIvaRichiedente(richiesta.getPartitaIva());
		richiestaServizio.setStato(richiesta.getStato());
		return richiestaServizio;
	}

}
