package it.servizidigitali.scrivaniaoperatore.frontend.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.camunda.integration.client.model.Task;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.AzioneUtente;
import it.servizidigitali.scrivaniaoperatore.frontend.dto.RichiestaDTO;
import it.servizidigitali.scrivaniaoperatore.frontend.enumeration.CamundaCodiciOperazioniUtente;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;
import it.servizidigitali.scrivaniaoperatore.frontend.util.MapUtil;
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
	private MapUtil mapUtil;

	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		long id = ParamUtil.getLong(request, "id");

		ServiceContext ctx;
		try {
			ctx = ServiceContextFactory.getInstance(request);
		}
		catch (PortalException e) {
			throw new RuntimeException(e);
		}

		RichiestaDTO richiesta = mapUtil.mapRichiesta(ctx.getCompanyId(), richiestaLocalService.fetchRichiesta(id));
		Map<String, Task> userTasks = scrivaniaOperatoreFrontendService.getUserTasks(ctx);
		boolean inCarico = userTasks.containsKey(richiesta.getProcessInstanceId());
				
		List<AzioneUtente> azioni = scrivaniaOperatoreFrontendService.getAzioniUtenteDettaglioRichiesta(id, ctx);
		Map<CamundaCodiciOperazioniUtente, Boolean> azioniMask = getAzioniMask(azioni);
		
		// TODO caricamento responsabili ed altri responsabili per modale
		// List<User> responsabili =
		// scrivaniaOperatoreFrontendService.getOrganizationUsersByRole(servizio.getSubOrganizationId(),
		// OrganizationRole.RESPONSABILE, ctx.getCompanyId());
		// List<User> altriResponsabili =
		// scrivaniaOperatoreFrontendService.getOrganizationUsersByRole(servizio.getSubOrganizationId(),
		// OrganizationRole.ALTRO_RESPONSABILE, ctx.getCompanyId());
		
		request.setAttribute("hasAssegnaAltroResponsabile", azioniMask.get(CamundaCodiciOperazioniUtente.ASSEGNA_ALTRO_RESPONSABILE));
		request.setAttribute("hasAssegnaResponsabile", azioniMask.get(CamundaCodiciOperazioniUtente.ASSEGNA_RESPONSABILE));
		request.setAttribute("hasEsitoPositivo", azioniMask.get(CamundaCodiciOperazioniUtente.ESITO_PROCEDIMENTO_POSITIVO));
		request.setAttribute("hasEsitoNegativo", azioniMask.get(CamundaCodiciOperazioniUtente.ESITO_PROCEDIMENTO_NEGATIVO));
		request.setAttribute("hasRichiediModificheRichiedente", azioniMask.get(CamundaCodiciOperazioniUtente.RICHIESTA_INTEGRAZIONE));
		request.setAttribute("hasRilascia", azioniMask.get(CamundaCodiciOperazioniUtente.RILASCIA_TASK));
		
		request.setAttribute("richiesta", richiesta);
		request.setAttribute("inCarico", inCarico);
		request.setAttribute("titleArgs", new String[] { String.valueOf(richiesta.getId()), richiesta.getServizio() });
		//TODO dimensione modello compilato dal cittadino
		request.setAttribute("modelloArgs", "100 MB");
		
		return "/dettaglio.jsp";
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
