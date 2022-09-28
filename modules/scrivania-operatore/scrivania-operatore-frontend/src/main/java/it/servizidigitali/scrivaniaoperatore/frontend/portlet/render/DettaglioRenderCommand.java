package it.servizidigitali.scrivaniaoperatore.frontend.portlet.render;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.common.utility.enumeration.OrganizationRole;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AllegatoDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AttivitaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AzioneUtente;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.CommentoDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.UserDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.enumeration.CamundaCodiciOperazioniUtente;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;
import it.servizidigitali.scrivaniaoperatore.frontend.util.MapUtil;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AttivitaRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(//
		immediate = true, //
		service = MVCRenderCommand.class, //
		property = { //
				"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE, //
				"mvc.command.name=/render/dettaglio"//
		}//
)
public class DettaglioRenderCommand implements MVCRenderCommand {

	@Reference
	private RichiestaLocalService richiestaLocalService;
	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;
	@Reference
	private AttivitaRichiestaLocalService attivitaRichiestaLocalService;
	@Reference
	private MapUtil mapUtil;
	@Reference
	private ProceduraLocalService proceduraLocalService;
	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		long id = ParamUtil.getLong(request, "id");
		String dettaglioTab = ParamUtil.getString(request, "dettaglioTab", ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_DATI);
		
		ServiceContext ctx;
		try {
			ctx = ServiceContextFactory.getInstance(request);
		}
		catch (PortalException e) {
			throw new RuntimeException(e);
		}

		Richiesta richiestaModel = richiestaLocalService.fetchRichiesta(id);
		RichiestaDTO richiesta = mapUtil.mapRichiesta(ctx.getCompanyId(), richiestaModel);
		Procedura proceduraModel = proceduraLocalService.fetchProcedura(richiestaModel.getProceduraId());
		ServizioEnte servizio = servizioEnteLocalService.fetchServizioEnte(new ServizioEntePK(proceduraModel.getServizioId(), ctx.getThemeDisplay().getSiteGroup().getOrganizationId()));
		
		List<UserDTO> responsabili = getResponsabili(ctx, servizio);
		List<UserDTO> altriResponsabili = getAltriResponsabili(ctx, servizio);
		request.setAttribute("responsabili", responsabili);
		request.setAttribute("altriResponsabili", altriResponsabili);

		List<AzioneUtente> azioni = scrivaniaOperatoreFrontendService.getAzioniUtenteDettaglioRichiesta(id, ctx);
		Map<CamundaCodiciOperazioniUtente, Boolean> azioniMask = getAzioniMask(azioni);
		String assegnaResponsabileVar = azioni.stream()
				.filter(x -> CamundaCodiciOperazioniUtente.ASSEGNA_RESPONSABILE.equals(CamundaCodiciOperazioniUtente.valueOf(x.getCodiceAzioneUtente())))
				.map(x -> x.getVariableSet())
				.findFirst()
				.orElse(null);
		request.setAttribute("assegnaResponsabileVar", assegnaResponsabileVar);
		request.setAttribute("hasAssegnaAltroResponsabile", azioniMask.get(CamundaCodiciOperazioniUtente.ASSEGNA_ALTRO_RESPONSABILE));
		request.setAttribute("hasAssegnaResponsabile", azioniMask.get(CamundaCodiciOperazioniUtente.ASSEGNA_RESPONSABILE));
		request.setAttribute("hasEsitoPositivo", azioniMask.get(CamundaCodiciOperazioniUtente.ESITO_PROCEDIMENTO_POSITIVO));
		request.setAttribute("hasEsitoNegativo", azioniMask.get(CamundaCodiciOperazioniUtente.ESITO_PROCEDIMENTO_NEGATIVO));
		request.setAttribute("hasRichiediModificheRichiedente", azioniMask.get(CamundaCodiciOperazioniUtente.RICHIESTA_INTEGRAZIONE));
		request.setAttribute("hasRilascia", azioniMask.get(CamundaCodiciOperazioniUtente.RILASCIA_TASK));

		Map<String, Task> userTasks = scrivaniaOperatoreFrontendService.getUserTasks(ctx);
		boolean inCarico = userTasks.containsKey(richiesta.getProcessInstanceId());
		request.setAttribute("inCarico", inCarico);
		
		request.setAttribute("dettaglioTab", dettaglioTab);
		request.setAttribute("richiesta", richiesta);
		request.setAttribute("titleArgs", new String[] { String.valueOf(richiesta.getId()), richiesta.getServizio() });
		
		List<AllegatoDTO> allegatiRichiestaOperatore = scrivaniaOperatoreFrontendService
				.getAllegatiRichiestaInterni(richiesta.getId()).stream()
				.map(x -> mapUtil.mapAllegato(ctx, x))
				.collect(Collectors.toList());
		request.setAttribute("allegatiOperatoreList", allegatiRichiestaOperatore);
		request.setAttribute("allegatiOperatoreCount", allegatiRichiestaOperatore.size());
		
		switch (dettaglioTab) {
		case ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_DATI:
			//TODO dimensione modello compilato dal cittadino
			request.setAttribute("modelloArgs", "100 MB");
				
			break;
		case ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_ALLEGATI:
			List<AllegatoDTO> allegatiRichiesta = scrivaniaOperatoreFrontendService
				.getAllegatiRichiestaRichiedente(richiesta.getId())
				.stream()
				.map(x -> mapUtil.mapAllegato(ctx, x))
				.collect(Collectors.toList());
			
			request.setAttribute("allegatiRichiedenteList", allegatiRichiesta);
			request.setAttribute("allegatiRichiedenteCount", allegatiRichiesta.size());
			break;
		case ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_COMMENTI:
			List<CommentoDTO> commenti = scrivaniaOperatoreFrontendService
				.getCommentiRichiesta(richiesta.getId())
				.stream()
				.map(x -> mapUtil.mapCommento(x))
				.collect(Collectors.toList());
			
			request.setAttribute("commentiCount", commenti.size());
			request.setAttribute("commentiList", commenti);
			break;
		case ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_ATTIVITA:
			List<AttivitaDTO> attivita = attivitaRichiestaLocalService
				.getAttivitaRichiestaByRichiestaId(id)
				.stream()
				.map(x -> mapUtil.mapAttivita(x))
				.collect(Collectors.toList());
			
			request.setAttribute("attivitaCount", attivita.size());
			request.setAttribute("attivitaList", attivita);
			break;
		default:
			throw new RuntimeException("dettaglioTab");
		}
		
		
		return "/dettaglio.jsp";
	}

	private List<UserDTO> getAltriResponsabili(ServiceContext ctx, ServizioEnte servizio) {
		List<User> lst = scrivaniaOperatoreFrontendService.getOrganizationUsersByRole(
				servizio.getSubOrganizationId(),
				OrganizationRole.ALTRO_RESPONSABILE, 
				ctx.getCompanyId());
		if (lst != null) {
			List<UserDTO> altriResponsabili = lst
					.stream()
					.map(x -> mapUtil.mapUser(x))
					.collect(Collectors.toList());
			return altriResponsabili;
		} else {
			return Collections.emptyList();
		}
	}

	private List<UserDTO> getResponsabili(ServiceContext ctx, ServizioEnte servizio) {
		List<User> lst = scrivaniaOperatoreFrontendService.getOrganizationUsersByRole(
				servizio.getSubOrganizationId(),
				OrganizationRole.RESPONSABILE, 
				ctx.getCompanyId());
		if (lst != null) {
			List<UserDTO> responsabili = lst
					.stream()
					.map(x -> mapUtil.mapUser(x))
					.collect(Collectors.toList());
			return responsabili;
		} else {
			return Collections.emptyList();
		}
	}

	private Map<CamundaCodiciOperazioniUtente, Boolean> getAzioniMask(List<AzioneUtente> azioni) {
		List<CamundaCodiciOperazioniUtente> azioniKeys = azioni.stream()
				.map(x -> x.getCodiceAzioneUtente())
				.map(x -> CamundaCodiciOperazioniUtente.valueOf(x))
				.collect(Collectors.toList());
		
		return Arrays.stream(CamundaCodiciOperazioniUtente.values())
				.collect(Collectors.toMap(x -> x, x -> azioniKeys.contains(x)));
	}
}
