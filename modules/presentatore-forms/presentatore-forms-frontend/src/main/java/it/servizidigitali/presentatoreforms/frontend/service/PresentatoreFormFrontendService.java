package it.servizidigitali.presentatoreforms.frontend.service;

import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoLocalService;
import it.servizidigitali.scrivaniaoperatore.service.IstanzaFormLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "presentatoreFormFrontendService", immediate = true, service = PresentatoreFormFrontendService.class)
public class PresentatoreFormFrontendService {

	private static final Log log = LogFactoryUtil.getLog(PresentatoreFormFrontendService.class.getName());

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private IstanzaFormLocalService istanzaFormLocalService;

	@Reference
	private DestinazioneUsoLocalService destinazioneUsoLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	/**
	 * Ritorna il servizio attuale sulla base della pagina in cui è in esecuzione la portlet.
	 *
	 * @param themeDisplay
	 * @return
	 */
	public ServizioEnte getServizioEnteByPage(ThemeDisplay themeDisplay) {

		Layout layout = themeDisplay.getLayout();

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);

		return servizioEnte;
	}

	/**
	 * Carica la procedura corrente (associata al servizio corrente).
	 *
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	public Procedura getCurrentProcedura(ThemeDisplay themeDisplay) throws PortalException {

		Layout layout = themeDisplay.getLayout();

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);

		return proceduraLocalService.getProceduraByServizioIdGroupIdAttiva(servizioEnte.getServizioId(), servizioEnte.getGroupId(), true);
	}

	/**
	 * Ritorna il form principale associato alla procedura passata in input.
	 *
	 * @param proceduraId
	 * @return
	 */
	public Form getFormPrincipaleProcedura(long proceduraId) {
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

	/**
	 * Elimina la richiesta in bozza associata all'utente.
	 *
	 * @param screenName
	 * @param proceduraId
	 */
	public void deleteRichiesteBozzaUtente(String screenName, long proceduraId, long formId) {
		Richiesta richiestaBozza = getRichiestaBozza(screenName, proceduraId);
		if (Validator.isNotNull(richiestaBozza)) {
			IstanzaForm istanzaFormBozza = getIstanzaFormRichiesta(richiestaBozza.getRichiestaId(), formId);

			if (Validator.isNotNull(istanzaFormBozza)) {
				try {
					istanzaFormLocalService.deleteIstanzaForm(istanzaFormBozza.getIstanzaFormId());
					richiestaLocalService.deleteRichiesta(richiestaBozza.getRichiestaId());
				}
				catch (Exception e) {
					log.error("Errore durante l'eliminazione della richiesta in bozza dell'utente con CF : " + screenName + e.getMessage(), e);
				}
			}

		}
	}

	/**
	 * Ritorna la richiesta in bozza associata all'utente, se esiste.
	 *
	 * @param screenName
	 * @param proceduraId
	 * @return
	 */
	public Richiesta getRichiestaBozza(String screenName, long proceduraId) {
		List<Richiesta> listaRichieste = richiestaLocalService.getRichiesteByCodiceFiscaleStatoProceduraId(screenName, StatoRichiesta.BOZZA.name(), proceduraId);
		if (Validator.isNotNull(listaRichieste) && !listaRichieste.isEmpty()) {
			return listaRichieste.get(0);
		}
		return null;

	}

	/**
	 *
	 * @param richiestaId
	 * @param formId
	 * @return
	 */
	public IstanzaForm getIstanzaFormRichiesta(long richiestaId, long formId) {
		return istanzaFormLocalService.getIstanzaFormByRichiestaIdFormId(richiestaId, formId);
	}

	public Richiesta createOrUpdateRichiesta(User user, Servizio servizio, long proceduraId, String dataForm, String stato, long groupId) {

		Richiesta richiesta = null;
		IstanzaForm istanzaForm = null;
		Form form = null;

		Gson gson = new Gson();
		AlpacaJsonStructure alpacaStructure = gson.fromJson(dataForm, AlpacaJsonStructure.class);

		if (Validator.isNotNull(alpacaStructure)) {
			FormData formData = new FormData();
			formData.setAlpaca(alpacaStructure);
			String jsonToSave = gson.toJson(formData);

			// recupero richiesta se esiste altrimenti ne creo una nuova
			richiesta = getRichiestaBozza(user.getScreenName(), proceduraId);
			form = getFormPrincipaleProcedura(proceduraId);

			if (Validator.isNotNull(form)) {

				if (Validator.isNotNull(StatoRichiesta.valueOf(stato))) {
					// recupero richiesta esistente
					if (Validator.isNotNull(richiesta)) {
						log.debug("Recuperata richiesta in stato BOZZA con id: " + richiesta.getRichiestaId());
						istanzaForm = getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());
					}
					else {
						// creazione nuova richiesta
						richiesta = richiestaLocalService.createRichiesta(counterLocalService.increment());
						richiesta.setCodiceFiscale(user.getScreenName());
						richiesta.setUserId(user.getUserId());
						richiesta.setUserName(user.getFullName());
						richiesta.setEmail(user.getEmailAddress());
						richiesta.setOggetto(servizio.getNome());
						richiesta.setProceduraId(proceduraId);
						richiesta.setStato(StatoRichiesta.BOZZA.name());
						richiesta.setServizioId(servizio.getServizioId());
						richiesta.setGroupId(groupId);
						richiesta = richiestaLocalService.updateRichiesta(richiesta);

						istanzaForm = istanzaFormLocalService.createIstanzaForm(counterLocalService.increment());
						istanzaForm.setGroupId(groupId);
						istanzaForm.setUserId(user.getUserId());
						istanzaForm.setUserName(user.getFullName());
						istanzaForm.setRichiestaId(richiesta.getRichiestaId());
						istanzaForm.setFormId(form.getFormId());
					}
					// aggiorno stato richiesta
					richiesta.setStato(stato);
					richiestaLocalService.updateRichiesta(richiesta);
					// aggiorno json in istanza form
					istanzaForm.setJson(jsonToSave);
					istanzaFormLocalService.updateIstanzaForm(istanzaForm);
				}
				else {
					log.error("Valore non valido per lo stato della richiesta: " + stato);
				}

			}
			else {
				log.error("Nessun form principale associato alla procedura con id: " + proceduraId);
			}

		}

		return richiesta;
	}

	/**
	 *
	 * @param themeDisplay
	 * @return
	 */
	public List<DestinazioneUso> getDestinazioniUso(ThemeDisplay themeDisplay) {
		long organizationId = themeDisplay.getSiteGroup().getOrganizationId();
		long groupId = themeDisplay.getSiteGroupId();
		long companyId = themeDisplay.getCompanyId();
		return destinazioneUsoLocalService.getDestinazioniUsoByOrganizationId(organizationId, groupId, companyId);
	}

	public DestinazioneUso checkDestinazioneUso(long destinazioneUsoId, long servizioId, long organizationId, long groupId, long companyId) {
		DestinazioneUso destinazioneUso = null;

		try {

			if (destinazioneUsoId > 0) {
				DestinazioneUso destinazioneUsoSelezionato = destinazioneUsoLocalService.getDestinazioneUso(destinazioneUsoId);

				if (Validator.isNotNull(destinazioneUsoSelezionato)) {
					List<DestinazioneUso> listaDestinazioniServizio = destinazioneUsoLocalService.getDestinazioniUsoByServizioIdOrganizationId(servizioId, organizationId, groupId, companyId);

					if (Validator.isNotNull(listaDestinazioniServizio) && !listaDestinazioniServizio.isEmpty()) {
						if (listaDestinazioniServizio.contains(destinazioneUsoSelezionato)) {
							destinazioneUso = destinazioneUsoSelezionato;
						}
					}

				}
			}

		}
		catch (Exception e) {
			log.error("PresentatoreFormFrontendService :: getDestinazioneUsoServizio :: " + e.getMessage(), e);
		}

		return destinazioneUso;
	}
}
