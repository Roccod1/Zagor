package it.servizidigitali.scrivaniaoperatore.frontend.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.CamundaClient;
import it.servizidigitali.camunda.integration.client.exception.CamundaClientException;
import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.camunda.integration.client.model.VariableInstance;
import it.servizidigitali.common.utility.enumeration.OrganizationRole;
import it.servizidigitali.communication.enumeration.Canale;
import it.servizidigitali.communication.model.Comunicazione;
import it.servizidigitali.communication.model.EsitoComunicazione;
import it.servizidigitali.communication.model.Utente;
import it.servizidigitali.communication.sender.CommunicationSender;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneCanaleComunicazioneLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AzioneUtente;
import it.servizidigitali.scrivaniaoperatore.frontend.enumeration.CamundaActionsVariable;
import it.servizidigitali.scrivaniaoperatore.frontend.enumeration.CamundaCodiciOperazioniUtente;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.CommentoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "scrivaniaOperatoreFrontendService", service = ScrivaniaOperatoreFrontendService.class, immediate = true)
public class ScrivaniaOperatoreFrontendService {

	private static final Log log = LogFactoryUtil.getLog(ScrivaniaOperatoreFrontendService.class.getName());

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private CamundaClient camundaClient;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserGroupRoleLocalService userGroupRoleLocalService;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private CommentoRichiestaLocalService commentoRichiestaLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private UtenteOrganizzazioneCanaleComunicazioneLocalService utenteOrganizzazioneCanaleComunicazioneLocalService;

	@Reference
	private CommunicationSender communicationSender;

	/**
	 *
	 * @param serviceContext
	 * @return
	 */
	public List<ServizioEnte> getServiziEnte(ServiceContext serviceContext) {
		try {
			List<ServizioEnte> serviziEnte = servizioEnteLocalService.getServiziEnteByOrganizationIdSubOrganizationIdsAttivo(serviceContext.getScopeGroup().getOrganizationId(),
					getUserSubOrganizationIds(serviceContext), true, serviceContext.getScopeGroupId(), serviceContext.getCompanyId());

			return serviziEnte;
		}
		catch (PortalException e) {
			log.error("getServiziEnte :: " + e.getMessage(), e);
		}

		return null;
	}

	/**
	 * @param serviceContext
	 * @return
	 */
	public Set<Long> getProcedureIds(ServiceContext serviceContext) {

		List<ServizioEnte> serviziEnte = getServiziEnte(serviceContext);

		List<Long> serviziEnteIds = serviziEnte.stream().map(ServizioEnte::getServizioId).collect(Collectors.toList());

		return getProcedureIds(serviziEnteIds, serviceContext);

	}

	/**
	 * @param serviceContext
	 * @param serviziEnteIds
	 * @return
	 */
	public Set<Long> getProcedureIds(List<Long> serviziEnteIds, ServiceContext serviceContext) {

		List<Procedura> procedure = proceduraLocalService.getProcedureByServiziIdsGroupIdAttiva(serviziEnteIds, serviceContext.getScopeGroupId(), true);

		return procedure.stream().map(Procedura::getProceduraId).collect(Collectors.toSet());
	}

	/**
	 *
	 * @param serviceContext
	 * @return
	 */
	public Map<String, Task> getUserTasks(ServiceContext serviceContext) {
		try {
			long userId = serviceContext.getUserId();
			User currentUser = userLocalService.getUser(userId);

			List<Task> searchTasks = camundaClient.searchTasks(String.valueOf(serviceContext.getScopeGroup().getOrganizationId()), currentUser.getScreenName(), null);
			Map<String, Task> map = new HashMap<>();
			for (Task task : searchTasks) {
				map.put(task.getProcessInstanceId(), task);
			}

			return map;
		}
		catch (PortalException e) {
			log.error("getProcessInstanceIds :: " + e.getMessage(), e);
		}
		catch (CamundaClientException e) {
			log.error("getProcessInstanceIds :: " + e.getMessage(), e);
		}
		return null;
	}

	/**
	 *
	 * @param serviceContext
	 * @return
	 */
	public Map<String, Task> getOrganizationTasks(ServiceContext serviceContext) {
		try {
			List<Long> organizationIds = getUserSubOrganizationIds(serviceContext);

			List<String> organizationIdsStrings = organizationIds.stream().map(Object::toString).collect(Collectors.toList());

			List<Task> searchTasks = camundaClient.searchTasks(String.valueOf(serviceContext.getScopeGroup().getOrganizationId()), organizationIdsStrings, null, false);

			Map<String, Task> map = new HashMap<>();
			for (Task task : searchTasks) {
				map.put(task.getProcessInstanceId(), task);
			}

			return map;
		}
		catch (PortalException e1) {
			log.error("getProcessInstanceIds :: " + e1.getMessage(), e1);
		}
		catch (CamundaClientException e1) {
			log.error("getProcessInstanceIds :: " + e1.getMessage(), e1);
		}
		return null;
	}

	/**
	 *
	 * @param userId
	 * @param taskId
	 */
	public void prendiTaskInCarico(String userId, String taskId) {
		camundaClient.claim(userId, taskId);
	}

	/**
	 *
	 * @param userId
	 * @param taskId
	 */
	public void rilasciaTask(String userId, String taskId) {
		camundaClient.unclaim(taskId);
	}

	/**
	 *
	 * @param tasksMap
	 * @return
	 */
	public Set<String> getProcessInstanceIds(Map<String, Task> tasksMap) {
		Set<String> processInstanceIds = tasksMap.values().stream().map(Task::getProcessInstanceId).collect(Collectors.toSet());
		return processInstanceIds;
	}

	/**
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	private List<Long> getUserSubOrganizationIds(ServiceContext serviceContext) throws PortalException {

		long userId = serviceContext.getUserId();
		User currentUser = userLocalService.getUser(userId);
		List<Long> organizationIds = currentUser.getOrganizations().stream().map(Organization::getOrganizationId).collect(Collectors.toList());
		return organizationIds;
	}

	/**
	 *
	 * @param idRichiesta
	 * @param serviceContext
	 * @return
	 */
	public List<AzioneUtente> getAzioniUtenteDettaglioRichiesta(long idRichiesta, ServiceContext serviceContext) {

		List<AzioneUtente> azioniUtente = new ArrayList<AzioneUtente>();
		try {
			long userId = serviceContext.getUserId();
			User currentUser = userLocalService.getUser(userId);

			String tenantId = String.valueOf(serviceContext.getScopeGroup().getOrganizationId());
			List<Task> tasksByBusinessKey = camundaClient.getTasksByBusinessKey(tenantId, String.valueOf(idRichiesta), false);
			if (tasksByBusinessKey != null) {
				for (Task task : tasksByBusinessKey) {
					String assignee = task.getAssignee();
					if (assignee != null && assignee.contentEquals(currentUser.getScreenName())) {
						List<VariableInstance> variablesByTaskId = camundaClient.getVariablesByExecutionId(tenantId, task.getExecutionId());
						if (variablesByTaskId != null) {
							for (VariableInstance variableInstance : variablesByTaskId) {
								azioniUtente.addAll(getActionByVariable(variableInstance));
							}
						}
						if (task.getCandidateGroups() != null && !task.getCandidateGroups().isEmpty()) {
							AzioneUtente e = new AzioneUtente();
							e.setCodiceAzioneUtente(CamundaCodiciOperazioniUtente.RILASCIA_TASK.getValue());
							e.setDescrizione("Rilascia");
							azioniUtente.add(e);
						}
					}
				}
			}
		}
		catch (CamundaClientException e) {
			log.error("getAzioniUtenteDettaglioRichiesta :: " + e.getMessage(), e);
		}
		catch (PortalException e) {
			log.error("getAzioniUtenteDettaglioRichiesta :: " + e.getMessage(), e);
		}
		return azioniUtente;
	}

	/**
	 * Carica la lista degli utenti assegnati ad una organizzazione ed appartenenti al ruolo passati
	 * in input.
	 *
	 * @param organizationId
	 * @param organizationRole
	 * @return
	 */
	public List<User> getOrganizationUsersByRole(long organizationId, OrganizationRole organizationRole, long companyId) {

		List<User> users = null;

		try {

			Role role = roleLocalService.getRole(companyId, organizationRole.getChiave());
			Organization organization = organizationLocalService.getOrganization(organizationId);

			List<UserGroupRole> userGroupRolesByGroupAndRole = userGroupRoleLocalService.getUserGroupRolesByGroupAndRole(organization.getGroupId(), role.getRoleId());
			if (userGroupRolesByGroupAndRole != null) {
				users = new ArrayList<User>();
				for (UserGroupRole userGroupRole : userGroupRolesByGroupAndRole) {
					users.add(userGroupRole.getUser());
				}

				return users;
			}

		}
		catch (PortalException e) {
			log.error("getOrganizationUsersByRole :: " + e.getMessage(), e);
		}

		return null;
	}

	/**
	 *
	 * @param variable
	 * @return
	 */
	private List<AzioneUtente> getActionByVariable(VariableInstance variable) {
		List<AzioneUtente> retVal = new ArrayList<>();

		// Imposta esito Positivo Negativo
		try {

			if (CamundaActionsVariable.VAR_IMPOSTAZIONE_VARIABILI.getValue().equalsIgnoreCase(variable.getName())) {
				AbstractMap mapVal = (AbstractMap) variable.getValue();
				if (mapVal == null && mapVal.isEmpty()) {
					return retVal;
				}

				Iterator keysIt = mapVal.keySet().iterator();
				while (keysIt.hasNext()) {
					Object key = keysIt.next();
					String varVal[] = String.valueOf(mapVal.get(key)).split(CamundaActionsVariable.VAL_SEPARATOR.getValue());

					AzioneUtente e = new AzioneUtente();

					e.setCodiceAzioneUtente(varVal[0] + "_" + varVal[1]);
					e.setDescrizione(String.valueOf(key));
					e.setVariableSet(varVal[0]);
					e.setVariableValue(varVal[1]);

					retVal.add(e);
				}
			}
			if (CamundaActionsVariable.VAR_ASSEGNAZIONE_RESPONSABILE.getValue().equalsIgnoreCase(variable.getName())) {

				AbstractMap mapVal = (AbstractMap) variable.getValue();
				if (mapVal == null && mapVal.isEmpty()) {
					return retVal;
				}

				Iterator keysIt = mapVal.keySet().iterator();
				while (keysIt.hasNext()) {
					Object key = keysIt.next();
					String varVal = String.valueOf(mapVal.get(key));

					AzioneUtente e = new AzioneUtente();

					e.setCodiceAzioneUtente(String.valueOf(key).replace(" ", "_").toUpperCase());
					e.setDescrizione(String.valueOf(key));
					e.setVariableSet(varVal);

					retVal.add(e);
				}
			}
			if (CamundaActionsVariable.VAR_RICHIESTA_INTEGRAZIONE.getValue().equalsIgnoreCase(variable.getName())) {

				String valRichiesta = (String) variable.getValue();
				if (valRichiesta.equalsIgnoreCase("true")) {
					AzioneUtente e = new AzioneUtente();

					e.setCodiceAzioneUtente(variable.getName());
					e.setDescrizione("Richiedi Modifiche\\Integrazioni al Richiedente");

					retVal.add(e);
				}
			}
			if (CamundaActionsVariable.VAR_RILASCIA_TASK.getValue().equalsIgnoreCase(variable.getName())) {

				AbstractMap mapVal = (AbstractMap) variable.getValue();
				if (mapVal == null && mapVal.isEmpty()) {
					return retVal;
				}

				Iterator keysIt = mapVal.keySet().iterator();
				while (keysIt.hasNext()) {
					Object key = keysIt.next();
					String varVal[] = String.valueOf(mapVal.get(key)).split(CamundaActionsVariable.VAL_SEPARATOR.getValue());

					AzioneUtente e = new AzioneUtente();

					e.setCodiceAzioneUtente(varVal[1]);
					e.setDescrizione(String.valueOf(key));
					e.setVariableSet(varVal[0]);
					e.setVariableValue(varVal[1]);

					retVal.add(e);
				}
			}

		}
		catch (Exception e) {
			log.error("Errore di lettura della variabile di processo. " + variable.getName() + " : " + String.valueOf(variable.getValue()));
		}

		return retVal;
	}

	/**
	 *
	 * @param richiestaId
	 * @return
	 */
	public List<AllegatoRichiesta> getAllegatiRichiestaRichiedente(long richiestaId) {
		List<AllegatoRichiesta> allegatiRichiesta = allegatoRichiestaLocalService.getAllegatiRichiestaByRichiestaIdGroupIdInterno(richiestaId, false);
		return allegatiRichiesta;
	}

	/**
	 *
	 * @param richiestaId
	 * @return
	 */
	public List<AllegatoRichiesta> getAllegatiRichiestaInterni(long richiestaId) {
		List<AllegatoRichiesta> allegatiRichiesta = allegatoRichiestaLocalService.getAllegatiRichiestaByRichiestaIdGroupIdInterno(richiestaId, true);
		return allegatiRichiesta;
	}

	/**
	 *
	 * @param richiestaId
	 * @return
	 */
	public List<CommentoRichiesta> getCommentiRichiesta(long richiestaId) {
		List<CommentoRichiesta> commentiRichiestaByRichiestaId = commentoRichiestaLocalService.getCommentiRichiestaByRichiestaId(richiestaId);
		return commentiRichiestaByRichiestaId;
	}

	/**
	 *
	 * @param richiestaId
	 * @param taskId
	 * @param variableSet
	 * @param variableValue
	 * @param commento
	 * @param fileEntryIds
	 * @param serviceContext
	 * @throws PortalException
	 */
	public void completaTask(long richiestaId, String taskId, String variableSet, String variableValue, String commento, List<Long> fileEntryIds, ServiceContext serviceContext)
			throws PortalException {

		String tenantId = String.valueOf(serviceContext.getScopeGroup().getOrganizationId());

		User currentUser = userLocalService.getUser(serviceContext.getUserId());

		if (fileEntryIds != null && !fileEntryIds.isEmpty()) {
			allegatoRichiestaLocalService.updateVisibilitaAllegatiRichiesta(richiestaId, fileEntryIds, true);
		}

		List<Task> tasksByBusinessKey = camundaClient.getTasksByBusinessKey(tenantId, String.valueOf(richiestaId), true);
		if (tasksByBusinessKey != null) {

			for (Task task : tasksByBusinessKey) {
				if (taskId.equalsIgnoreCase(task.getId()) && currentUser.getScreenName().equalsIgnoreCase(task.getAssignee())) {
					List<Entry<String, String>> variables = new ArrayList<Entry<String, String>>();

					if (Validator.isNotNull(variableSet)) {
						variables.add(new AbstractMap.SimpleEntry<String, String>(variableSet, variableValue != null ? variableValue : null));
					}
					camundaClient.completeTask(taskId, variables);
				}
			}
		}

		if (Validator.isNotNull(commento)) {
			commentoRichiestaLocalService.createCommentoRichiesta(commento, taskId, true, richiestaId, currentUser.getUserId(), currentUser.getFullName(), serviceContext.getScopeGroupId(),
					serviceContext.getCompanyId());
		}
	}

	/**
	 *
	 * @param userIdResponsabile
	 * @param richiestaId
	 * @param taskId
	 * @param variableSet
	 * @param commento
	 * @param serviceContext
	 * @throws PortalException
	 */
	public void assegnaResponsabile(long userIdResponsabile, long richiestaId, String taskId, String variableSet, String commento, ServiceContext serviceContext) throws PortalException {

		String tenantId = String.valueOf(serviceContext.getScopeGroup().getOrganizationId());

		User currentUser = userLocalService.getUser(serviceContext.getUserId());
		User responsabileUser = userLocalService.getUser(userIdResponsabile);

		List<Task> tasksByBusinessKey = camundaClient.getTasksByBusinessKey(tenantId, String.valueOf(richiestaId), true);
		if (tasksByBusinessKey != null) {

			for (Task task : tasksByBusinessKey) {
				if (taskId.equalsIgnoreCase(task.getId()) && currentUser.getScreenName().equalsIgnoreCase(task.getAssignee())) {
					List<Entry<String, String>> variables = new ArrayList<Entry<String, String>>();

					if (Validator.isNotNull(variableSet)) {
						variables.add(new AbstractMap.SimpleEntry<String, String>(variableSet, responsabileUser.getScreenName()));
					}
					camundaClient.completeTask(taskId, variables);
				}
			}
		}

		// Aggiunta commento, se presente
		if (Validator.isNotNull(commento)) {
			commentoRichiestaLocalService.createCommentoRichiesta(commento, taskId, false, richiestaId, currentUser.getUserId(), currentUser.getFullName(), serviceContext.getScopeGroupId(),
					serviceContext.getCompanyId());
		}

		// Aggiornamento stato pratica con commenti
		String note = "Pratica inoltrata a Responsabile " + responsabileUser.getFullName();
		richiestaLocalService.updateStatoRichiesta(richiestaId, StatoRichiesta.IN_LAVORAZIONE.name(), note);
	}

	/**
	 *
	 * @param richiestaId
	 * @param taskId
	 * @param commento
	 * @param formIntegrativiIds
	 * @param fileEntryIds
	 * @param serviceContext
	 * @throws Exception
	 */
	public void richiediIntegrazioni(long richiestaId, String taskId, String commento, List<Long> formIntegrativiIds, List<Long> fileEntryIds, ServiceContext serviceContext) throws Exception {

		if (formIntegrativiIds == null || formIntegrativiIds.isEmpty()) {
			throw new PortalException("Nessun form integrativo selezionato per la richiesta: ID RICHIESTA " + richiestaId);
		}

		long organizationId = serviceContext.getScopeGroup().getOrganizationId();
		String tenantId = String.valueOf(organizationId);

		User currentUser = userLocalService.getUser(serviceContext.getUserId());

		if (fileEntryIds != null && !fileEntryIds.isEmpty()) {
			allegatoRichiestaLocalService.updateVisibilitaAllegatiRichiesta(richiestaId, fileEntryIds, true);
		}

		if (Validator.isNotNull(commento)) {
			commentoRichiestaLocalService.createCommentoRichiesta(commento, taskId, true, richiestaId, currentUser.getUserId(), currentUser.getFullName(), serviceContext.getScopeGroupId(),
					serviceContext.getCompanyId());
		}

		// Aggiornamento stato richiesta
		richiestaLocalService.updateStatoRichiesta(richiestaId, StatoRichiesta.ATTESA_INTEGRAZIONI.name());

		// invio email al cittadino
		List<Canale> canali = utenteOrganizzazioneCanaleComunicazioneLocalService.getListaCanaleComunicazioneByUtenteOrganization(currentUser.getUserId(), organizationId).stream()
				.map(x -> x.getCanale()).map(x -> Canale.getSupportedChannel(x.getCodice())).collect(Collectors.toList());

		Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);

		String statoRichiestaLabel = getStatoRichiestaLabelValue(richiesta.getStato(), serviceContext.getLocale());

		for (Canale canale : canali) {
			Utente utente = new Utente();
			utente.setEmail(currentUser.getEmailAddress());
			// TODO rendere template FreeMarker con caricamento configurazione by site.
			String subject = "Notifica Richiesta documenti integrativi per la richiesta " + richiesta.getRichiestaId();
			String test = "Caro " + currentUser.getFullName() + ",<br/> La richiesta in oggetto, da lei inoltrata con descrizione : " + richiesta.getOggetto() + " in stato " + statoRichiestaLabel
					+ ", necessita di documenti integrativi.<br/> Visita il sito per integrare i documenti richiesti e inoltrare la domanda.";

			Comunicazione comunicazione = new Comunicazione(subject, test, Collections.singletonList(utente), null, true, null, richiesta.getCompanyId(), richiesta.getGroupId());
			log.debug("Invio comunicazione tramite canale '" + canale.getName() + "' a '" + currentUser.getScreenName() + "'");
			EsitoComunicazione esito = communicationSender.send(comunicazione, canale);
			log.debug("Comunicazione tramite canale '" + canale.getName() + "' a '" + currentUser.getScreenName() + "' inviata. MessageID: " + esito.getMessageId());

		}

		List<Task> tasksByBusinessKey = camundaClient.getTasksByBusinessKey(tenantId, String.valueOf(richiestaId), true);
		if (tasksByBusinessKey != null) {

			for (Task task : tasksByBusinessKey) {
				if (taskId.equalsIgnoreCase(task.getId()) && currentUser.getScreenName().equalsIgnoreCase(task.getAssignee())) {
					List<Entry<String, String>> variables = new ArrayList<Entry<String, String>>();
					camundaClient.completeTask(taskId, variables);
				}
			}
		}
	}

	private String getStatoRichiestaLabelValue(String stato, Locale locale) {
		return getLabelValue("stato-richiesta-" + stato, locale);
	}

	private String getLabelValue(String label, Locale locale) {
		return ResourceBundleUtil.getLocalizationMap(ResourceBundleLoaderUtil.getResourceBundleLoaderByBundleSymbolicName(ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE_BUNDLE_SYMBOLIC_NAME), label)
				.get(locale);
	}
}
