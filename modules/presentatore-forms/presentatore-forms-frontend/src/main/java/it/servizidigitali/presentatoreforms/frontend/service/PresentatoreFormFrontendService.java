package it.servizidigitali.presentatoreforms.frontend.service;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaFilters;
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
	public void deleteRichiesteBozzaUtente(String screenName, long proceduraId) {
		RichiestaFilters richiestaFilters = new RichiestaFilters();
		List<Richiesta> listaRichiesteBozza = new ArrayList<Richiesta>();

		// TODO: Ottimizzare utilizzando il nuovo metodo per recuperare le richieste
		Set<Long> procedureIds = new HashSet<>();
		procedureIds.add(proceduraId);
		richiestaFilters.setCodiceFiscale(screenName);
		richiestaFilters.setProcedureIds(procedureIds);
		richiestaFilters.setTipo(StatoRichiesta.BOZZA.name());

		listaRichiesteBozza = richiestaLocalService.search(richiestaFilters, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		if (Validator.isNotNull(listaRichiesteBozza) && !listaRichiesteBozza.isEmpty()) {
			for (Richiesta richiesta : listaRichiesteBozza) {

				try {
					richiestaLocalService.deleteRichiesta(richiesta.getRichiestaId());
				}
				catch (Exception e) {
					log.error("Impossibile eliminare la richiesta con ID : " + richiesta.getRichiestaId());
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
}
