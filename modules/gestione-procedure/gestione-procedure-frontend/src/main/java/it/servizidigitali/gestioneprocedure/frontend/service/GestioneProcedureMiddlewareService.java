package it.servizidigitali.gestioneprocedure.frontend.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.ProceduraFormLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

@Component(name = "gestioneProcedureMiddlewareService", immediate = true, service = GestioneProcedureMiddlewareService.class)
public class GestioneProcedureMiddlewareService {

	private static final Log _log = LogFactoryUtil.getLog(GestioneProcedureMiddlewareService.class);

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private FormLocalService formLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private ProceduraFormLocalService proceduraFormLocalService;

	public Procedura getProcedura(long groupId, long servizioId, boolean attiva) {
		Procedura procedura = null;

		List<Procedura> listaProcedure = proceduraLocalService.getProcedureByGroupIdServizioIdAttiva(groupId,
				servizioId, attiva);

		if (Validator.isNotNull(listaProcedure) && !listaProcedure.isEmpty()) {
			for (Procedura p : listaProcedure) {
				Form form = getFormPrincipaleProcedura(p.getProceduraId());
				if (Validator.isNotNull(form)) {
					procedura = p;
				}
			}
		}

		return procedura;
	}

	public List<Servizio> getServiziByOrganizationAttivo(long organizationId) throws Exception {

		List<Long> listaServiziEnte = servizioEnteLocalService.getListaServiziByOrganizationAttivo(organizationId,
				true);
		List<Servizio> listaServizi = new ArrayList<Servizio>();

		if (Validator.isNotNull(listaServiziEnte)) {
			for (Long idServizio : listaServiziEnte) {
				Servizio servizio = servizioLocalService.getServizio(idServizio);

				if (Validator.isNotNull(servizio)) {
					listaServizi.add(servizio);
				} else {
					_log.error("Impossibile recuperare il servizio per ID: " + idServizio);
				}
			}
		} else {
			_log.error("Impossibile recuperare la lista dei servizi per questa organizzazione : " + organizationId);
		}

		return listaServizi;

	}

	public Form getFormPrincipaleProcedura(long proceduraId) {
		List<ProceduraForm> listaProceduraForm = new ArrayList<ProceduraForm>();

		listaProceduraForm = proceduraFormLocalService.getListaProceduraFormProcedura(proceduraId);

		Form formPrincipale = null;
		List<Form> listaFormPrincipali = new ArrayList<Form>();

		try {
			if (Validator.isNotNull(listaProceduraForm) && !listaProceduraForm.isEmpty()) {
				for (ProceduraForm proceduraForm : listaProceduraForm) {
					Form form = null;

					if (Validator.isNotNull(proceduraForm)) {
						form = formLocalService.getForm(proceduraForm.getFormId());

						if (Validator.isNotNull(form)) {
							if (form.getPrincipale()) {
								listaFormPrincipali.add(form);
							}
						}
					}

				}

				if (!listaFormPrincipali.isEmpty()) {
					if (listaFormPrincipali.size() == 1) {
						formPrincipale = listaFormPrincipali.get(0);
					} else {
						_log.error("Trovato piu' di un form principale per la procedura con ID : " + proceduraId);
					}
				} else {
					_log.error("Non e' stato trovato nessun form principale per la procedura con ID : " + proceduraId);
				}
			}

		} catch (Exception e) {
			_log.error("Errore durante il recupero del form principale : " + e.getMessage());
		}

		return formPrincipale;
	}

	public String getFormIntegrativiProcedura(long proceduraId) throws PortalException {
		List<ProceduraForm> listaProceduraForm = new ArrayList<ProceduraForm>();
		List<String> listaFormIntegrativiProcedura = new ArrayList<String>();

		listaProceduraForm = proceduraFormLocalService.getListaProceduraFormProcedura(proceduraId);

		if (Validator.isNotNull(listaProceduraForm) && !listaProceduraForm.isEmpty()) {
			for (ProceduraForm proceduraForm : listaProceduraForm) {
				Form form = null;

				if (Validator.isNotNull(proceduraForm)) {
					form = formLocalService.getForm(proceduraForm.getFormId());

					if (Validator.isNotNull(form)) {
						if (!form.getPrincipale()) {
							listaFormIntegrativiProcedura.add(String.valueOf(form.getFormId()));
						}
					}
				}

			}
		}

		String listaId = String.join(",", listaFormIntegrativiProcedura);
		listaId = "[" + listaId + "]";
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(listaId);
		String jsonArrayString = JSONFactoryUtil.createJSONSerializer().serialize(jsonArray);

		return jsonArrayString;
	}

	public void salvaListaFormIntegrativi(String[] listaFormIntegrativi, long proceduraId) {
		List<ProceduraForm> listaProceduraFormRecuperatiDb = proceduraFormLocalService.getListaProceduraFormProcedura(proceduraId);
		List<ProceduraForm> listaProceduraFormRecuperatiForm = new ArrayList<ProceduraForm>();

		Form formPrincipale = getFormPrincipaleProcedura(proceduraId);

		if (Validator.isNotNull(listaFormIntegrativi)) {
			for (String idForm : listaFormIntegrativi) {
				ProceduraFormPK proceduraFormPk = new ProceduraFormPK();
				proceduraFormPk.setProceduraId(proceduraId);
				proceduraFormPk.setFormId(Long.valueOf(idForm));
				ProceduraForm proceduraForm = proceduraFormLocalService.createProceduraForm(proceduraFormPk);
				listaProceduraFormRecuperatiForm.add(proceduraForm);
			}
		}

		if (Validator.isNotNull(listaProceduraFormRecuperatiDb) && !listaProceduraFormRecuperatiDb.isEmpty()) {

			if (Validator.isNotNull(listaProceduraFormRecuperatiForm) && Validator.isNotNull(formPrincipale)) {
				List<ProceduraForm> elementiDaEliminare = listaProceduraFormRecuperatiDb.stream().filter(proceduraForm -> !listaProceduraFormRecuperatiForm.contains(proceduraForm)
								&& proceduraForm.getFormId() != formPrincipale.getFormId()).collect(Collectors.toList());
				List<ProceduraForm> elementiDaAggiungere = listaProceduraFormRecuperatiForm.stream().filter(proceduraForm -> !listaProceduraFormRecuperatiDb.contains(proceduraForm)
								&& proceduraForm.getFormId() != formPrincipale.getFormId()).collect(Collectors.toList());

				for (ProceduraForm proceduraForm : elementiDaEliminare) {
					proceduraFormLocalService.deleteProceduraForm(proceduraForm);
				}

				for (ProceduraForm proceduraForm : elementiDaAggiungere) {
					proceduraFormLocalService.updateProceduraForm(proceduraForm);
				}

			}
		} else {
			for (ProceduraForm proceduraForm : listaProceduraFormRecuperatiForm) {
				proceduraFormLocalService.updateProceduraForm(proceduraForm);
			}
		}

	}

	public ProceduraForm salvaProceduraFormPrincipale(long idFormPrincipale, long proceduraId) {
		ProceduraForm proceduraForm = null;
		Form formPrincipale = getFormPrincipaleProcedura(proceduraId);
		long idFormPrincipaleEsistente = 0;

		if (Validator.isNotNull(formPrincipale)) {
			idFormPrincipaleEsistente = formPrincipale.getFormId();
		}

		if (idFormPrincipaleEsistente != idFormPrincipale) {

			ProceduraFormPK proceduraFormPk = new ProceduraFormPK();
			proceduraFormPk.setProceduraId(proceduraId);
			proceduraFormPk.setFormId(idFormPrincipale);

			proceduraForm = proceduraFormLocalService.createProceduraForm(proceduraFormPk);
			proceduraFormLocalService.updateProceduraForm(proceduraForm);
		}

		return proceduraForm;
	}

	public String getStringSelectMultipla(String string) throws JSONException {
		string = "[" + string + "]";
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(string);
		String jsonArrayString = JSONFactoryUtil.createJSONSerializer().serialize(jsonArray);

		return jsonArrayString;
	}

	public List<Servizio> getListaServiziAssociabiliProcedura(long organizationId, long groupId) {
		
		_log.debug("Recupero elenco servizi associabili a procedura per groupId: " + groupId);
		
		List<Servizio> listaServiziAssociabili = new ArrayList<>();

		try {
			//lista di tutti i servizi ente 
			List<Long> listaServizioEnteId =  servizioEnteLocalService.getListaServiziByOrganizationAttivo(organizationId, true);
			
			//lista dei servizi per specifico groupId che gia' associati ad una procedura
			List<Procedura> listaProcedure = proceduraLocalService.getProcedureByGroupIdAttiva(groupId, true);
			List<Long> listaServiziAssociatiId = listaProcedure.stream().map(p -> p.getServizioId()).collect(Collectors.toList());
			
			//lista servizi assegnabili ad una procedura
			List<Long> listaServiziAssegnabiliId = listaServizioEnteId.stream().filter(idServizio -> !listaServiziAssociatiId.contains(idServizio)).collect(Collectors.toList());
			
			if(Validator.isNotNull(listaServiziAssegnabiliId)) {
				for(Long servizioId : listaServiziAssegnabiliId) {
					Servizio servizio = servizioLocalService.getServizio(servizioId);
					listaServiziAssociabili.add(servizio);			
				}
			}
			
		} catch (Exception e) {
			_log.error("Errore durante il recupero dell'elenco servizi associabili a procedura: " + e);
		}
		
		return listaServiziAssociabili;
	}
}
