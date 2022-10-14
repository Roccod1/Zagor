package it.servizidigitali.restservice.internal.resource.v1_0;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import it.servizidigitali.backoffice.integration.service.DatiAnagraficiPortletService;
import it.servizidigitali.common.utility.LayoutUtility;
import it.servizidigitali.common.utility.enumeration.StatoRichiestaCertificato;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.integration.exception.BackofficeServiceException;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.restservice.dto.v1_0.RichiestaCertificato;
import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.jwt.utility.constant.JWTUtilityConstant;
import it.servizidigitali.restservice.jwt.utility.exception.JwtException;
import it.servizidigitali.restservice.resource.v1_0.CertificatiResource;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoLocalService;

/**
 * @author pindi
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/certificati.properties", scope = ServiceScope.PROTOTYPE, service = CertificatiResource.class)
public class CertificatiResourceImpl extends BaseCertificatiResourceImpl {

	private static final Log log = LogFactoryUtil.getLog(CertificatiResourceImpl.class.getName());

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private LayoutUtility layoutUtility;

	@Reference
	private DestinazioneUsoLocalService destinazioneUsoLocalService;

	@Reference
	private DatiAnagraficiPortletService datiAnagraficiPortletService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private TipologiaLocalService tipologiaLocalService;

	@Override
	public RichiestaCertificato checkInvioCertificato(@NotNull String userToken, String nomeComune, Long idDestinazioneUso, String codiceServizio, String amministrazione, String codiceFiscale)
			throws Exception {

		RichiestaCertificato richiestaCertificato = new RichiestaCertificato();

		try {
			Map<String, Object> claims = _jwtUtilityService.verifyJwtAndGetClaims(userToken);

			String codiceFiscaleFromToken = (String) claims.get(JWTUtilityConstant.CLAIM_USERNAME);

			Organization organization = getOrganization(nomeComune, amministrazione);
			try {
				userLocalService.getUserByScreenName(organization.getCompanyId(), codiceFiscaleFromToken);
			}
			catch (NoSuchUserException e) {
				richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
				richiestaCertificato.setMessaggio("Utente " + codiceFiscaleFromToken + " non trovato.");
				return richiestaCertificato;
			}

			Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
			if (servizio == null || !servizio.isAttivo()) {
				richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
				richiestaCertificato.setMessaggio("Servizio " + codiceServizio + " non trovato.");
				return richiestaCertificato;
			}

			// TODO verificare come mai non carica le tipologie
			// List<Tipologia> tipologie = servizio.getListaTipologie();
			// if (tipologie == null || tipologie.isEmpty()) {
			// richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
			// richiestaCertificato.setMessaggio("Servizio " + codiceServizio + " non trovato.");
			// return richiestaCertificato;
			// }

			// boolean checkTipologia = false;
			// for (Tipologia tipologia : tipologie) {
			// if (tipologia.getCodice() != null &&
			// tipologia.getCodice().equals(TipoServizio.CERTIFICATO)) {
			// checkTipologia = true;
			// }
			// }

			// if (!checkTipologia) {
			// richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
			// richiestaCertificato.setMessaggio("Servizio " + codiceServizio + " non trovato.");
			// return richiestaCertificato;
			// }

			ServizioEntePK servizioEntePK = new ServizioEntePK(servizio.getServizioId(), organization.getOrganizationId());
			ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);

			if (servizioEnte == null || !servizioEnte.isAttivo()) {
				richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
				richiestaCertificato.setMessaggio("Servizio " + codiceServizio + " non trovato.");
				return richiestaCertificato;
			}

			List<DestinazioneUso> destinazioniUso = destinazioneUsoLocalService.getDestinazioniUsoByServizioIdOrganizationId(servizio.getServizioId(), organization.getOrganizationId(),
					organization.getGroupId(), organization.getCompanyId());

			if (destinazioniUso != null && !destinazioniUso.isEmpty()) {
				DestinazioneUso destinazioneUso = destinazioneUsoLocalService.getDestinazioneUso(idDestinazioneUso);
				if (destinazioneUso != null && destinazioneUso.isPagamentoBollo()) {
					richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
					// TODO spostare in Language.properties
					String messaggio = "Non &eacute; stato possibile procedere con la generazione automatica del {{nomeServizio}} in quanto la destinazione d'uso scelta prevede l'esecuzione di un pagamento elettronico. Accedi al servizio disponibile via web ({{linkServizio}}) per procedere con questa operazione.";
					messaggio = messaggio.replace("{{nomeServizio}}", servizio.getNome());
					String uri = layoutUtility.getPathByLayoutId(servizioEnte.getPrivateLayoutId(), organization.getGroupId(), organization.getCompanyId());
					messaggio = messaggio.replace("{{linkServizio}}", uri);
					richiestaCertificato.setMessaggio(messaggio);
					return richiestaCertificato;
				}
			}

			Procedura procedura = proceduraLocalService.getProceduraByServizioIdGroupIdAttiva(servizio.getServizioId(), organization.getGroupId(), true);
			Form form = getFormPrincipaleProcedura(procedura.getProceduraId());

			String portalUrl = layoutUtility.getSitePath(organization.getGroupId(), organization.getCompanyId());

			FormData formData = AlpacaUtil.loadFormData(form, null, true, portalUrl);
			AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

			UserPreferences userPreferences = new UserPreferences();
			userPreferences.setCodiceFiscaleRichiedente(codiceFiscaleFromToken);
			userPreferences.setCodiceFiscaleComponente(codiceFiscale);

			Gson gson = new Gson();
			JsonObject data = gson.fromJson(gson.toJson(alpacaStructure.getData()), JsonObject.class);

			alpacaService.loadData(data, gson.toJson(alpacaStructure.getSchema()), gson.toJson(alpacaStructure.getOptions()), procedura, userPreferences);

		}
		catch (JwtException e) {
			throw new ForbiddenException(e.getDescription());
		}
		catch (BackofficeServiceException e) {
			richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
			richiestaCertificato.setMessaggio(e.getMessage());
		}

		return richiestaCertificato;
	}

	private Form getFormPrincipaleProcedura(long proceduraId) {
		try {
			List<ProceduraForm> listaProceduraFormProcedura = proceduraFormLocalService.getListaProceduraFormProcedura(proceduraId);

			if (listaProceduraFormProcedura != null) {
				for (ProceduraForm proceduraForm : listaProceduraFormProcedura) {
					Form form = formLocalService.getForm(proceduraForm.getFormId());
					if (form.isPrincipale()) {
						form.setListaDefinizioneAllegato(definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId()));
						return form;
					}
				}
			}
		}
		catch (PortalException e) {
			log.warn("getFormPrincipaleProcedura :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public RichiestaCertificato invioCertificato(@NotNull String userToken, String nomeComune, Long idDestinazioneUso, String codiceServizio, String amministrazione, String codiceFiscale)
			throws Exception {

		try {

			RichiestaCertificato richiestaCertificato = new RichiestaCertificato();

			Map<String, Object> claims = _jwtUtilityService.verifyJwtAndGetClaims(userToken);
			String codiceFiscaleFromToken = (String) claims.get(JWTUtilityConstant.CLAIM_USERNAME);
			Organization organization = getOrganization(null, amministrazione);

			Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
			List<DestinazioneUso> destinazioniUso = destinazioneUsoLocalService.getDestinazioniUsoByServizioIdOrganizationId(servizio.getServizioId(), organization.getOrganizationId(),
					organization.getGroupId(), organization.getCompanyId());
			ServizioEntePK servizioEntePK = new ServizioEntePK(servizio.getServizioId(), organization.getOrganizationId());
			ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);

			if (destinazioniUso != null && !destinazioniUso.isEmpty()) {
				DestinazioneUso destinazioneUso = destinazioneUsoLocalService.getDestinazioneUso(idDestinazioneUso);
				if (destinazioneUso != null && destinazioneUso.isPagamentoBollo()) {
					richiestaCertificato.setStato(StatoRichiestaCertificato.ERRORE.name());
					// TODO spostare in Language.properties
					String messaggio = "Non &eacute; stato possibile procedere con la generazione automatica del {{nomeServizio}} in quanto la destinazione d'uso scelta prevede l'esecuzione di un pagamento elettronico. Accedi al servizio disponibile via web ({{linkServizio}}) per procedere con questa operazione.";
					messaggio = messaggio.replace("{{nomeServizio}}", servizio.getNome());
					String uri = layoutUtility.getPathByLayoutId(servizioEnte.getPrivateLayoutId(), organization.getGroupId(), organization.getCompanyId());
					messaggio = messaggio.replace("{{linkServizio}}", uri);
					richiestaCertificato.setMessaggio(messaggio);
					return richiestaCertificato;
				}
			}

			// TODO implementare servizio salvataggio richiesta certificato
			// richiestaCertificato.setDataInserimento(new Date());
			// richiestaCertificato.setStato(StatoRichiestaCertificato.NUOVA.name());
			// richiestaCertificato.setProfiloUtenteCittadino(profiloUtenteCittadino);
			// richiestaCertificato.setCodiceFiscale(codiceFiscale);
			// richiestaCertificato.setServizio(servizio);
			// richiestaCertificato.setComuneIsa(comuneIsa);

			if (idDestinazioneUso != null) {
				DestinazioneUso destinazioneUso = destinazioneUsoLocalService.getDestinazioneUso(idDestinazioneUso);
				if (destinazioneUso != null) {
					// richiestaCertificato.setDestinazioneUso(destinazioneUso);
				}
			}

			return richiestaCertificato;

		}
		catch (JwtException e) {
			throw new ForbiddenException(e.getDescription());

		}
	}

	private Organization getOrganization(String nomeComune, String amministrazione) {

		List<Organization> organizations;
		if (Validator.isNotNull(nomeComune)) {
			DynamicQuery query = organizationLocalService.dynamicQuery();
			query.add(RestrictionsFactoryUtil.eq("name", nomeComune));

			organizations = organizationLocalService.dynamicQuery(query);
		}
		else {
			ClassLoader classLoader = getClass().getClassLoader();

			DynamicQuery expandoColumn = DynamicQueryFactoryUtil.forClass(ExpandoColumn.class, classLoader);
			expandoColumn.add(RestrictionsFactoryUtil.eq("name", "codiceIPA"));
			expandoColumn.setProjection(ProjectionFactoryUtil.property("columnId"));

			DynamicQuery expandoValue = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, classLoader);
			expandoValue.add(RestrictionsFactoryUtil.eq("data", amministrazione));
			expandoValue.add(PropertyFactoryUtil.forName("columnId").in(expandoColumn));
			expandoValue.setProjection(ProjectionFactoryUtil.property("classPK"));

			DynamicQuery query = organizationLocalService.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("organizationId").in(expandoValue));

			organizations = organizationLocalService.dynamicQuery(query);
		}

		Organization organization;
		if (organizations.size() == 1) {
			organization = organizations.get(0);
		}
		else if (organizations.isEmpty()) {
			throw new NotFoundException("Ente non trovato");
		}
		else {
			throw new InternalServerErrorException("Enti multipli per filtro nomeComune o amministrazione");
		}
		return organization;
	}

	@Reference
	private JwtUtilityService _jwtUtilityService;

}