package it.servizidigitali.scrivaniacittadino.frontend.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.AttivitaRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.CommentoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author filierim
 */

@Component(immediate = true, property = { "javax.portlet.name=" + ScrivaniaCittadinoPortletKeys.SCRIVANIACITTADINO,
		"mvc.command.name=" + ScrivaniaCittadinoPortletKeys.RENDER_COMMAND_DETTAGLIO_RICHIESTA }, service = MVCRenderCommand.class)
public class DettaglioRichiestaCittadino implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(DettaglioRichiestaCittadino.class);

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private CommentoRichiestaLocalService commentoRichiestaLocalService;

	@Reference
	private AttivitaRichiestaLocalService attivitaRichiestaLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long richiestaId = ParamUtil.getLong(renderRequest, ScrivaniaCittadinoPortletKeys.PARAM_ID);
		int curCommenti = ParamUtil.getInteger(renderRequest, ScrivaniaCittadinoPortletKeys.CUR_COMMENTI);
		int curAttivita = ParamUtil.getInteger(renderRequest, ScrivaniaCittadinoPortletKeys.CUR_ATTIVITA);
		int deltaCommenti = ParamUtil.getInteger(renderRequest, ScrivaniaCittadinoPortletKeys.DELTA_COMMENTI, 5);
		int deltaAttivita = ParamUtil.getInteger(renderRequest, ScrivaniaCittadinoPortletKeys.DELTA_ATTIVITA, 5);
		String searchContainerName = ParamUtil.getString(renderRequest, ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_NAME, StringPool.BLANK);
		if (richiestaId > 0) {

			Richiesta richiesta = null;
			List<AllegatoRichiesta> listaAllegatiCittadino = new ArrayList<AllegatoRichiesta>();
			List<AllegatoRichiesta> listaProvvedimentiFinali = new ArrayList<AllegatoRichiesta>();
			List<CommentoRichiesta> listaCommentiRichiesta = new ArrayList<CommentoRichiesta>();
			List<AttivitaRichiesta> listaAttivitaRichiesta = new ArrayList<AttivitaRichiesta>();
			AllegatoRichiesta pdfRichiesta = null;

			ServiceContext serviceContext = null;
			ThemeDisplay themeDisplay = null;

			try {
				serviceContext = ServiceContextFactory.getInstance(renderRequest);
				themeDisplay = serviceContext.getThemeDisplay();
				long userId = themeDisplay.getUserId();

				richiesta = richiestaLocalService.getRichiesta(richiestaId);
				int attivitaRichiestaCount = 0;
				int commentiRichiestaCount = 0;

				int posizioni[] = new int[2];

				if (Validator.isNotNull(richiesta)) {
					List<AllegatoRichiesta> listaAllegatiRichiesta = allegatoRichiestaLocalService.getAllegatiRichiestaByRichiestaIdPrincipale(richiestaId, false);

					if (listaAllegatiRichiesta != null) {
						for (AllegatoRichiesta allegato : listaAllegatiRichiesta) {
							if (allegato.getUserId() != userId) {
								listaProvvedimentiFinali.add(allegato);
							}
							else {
								listaAllegatiCittadino.add(allegato);
							}
						}
					}

					posizioni = calcolaInizioFinePaginazione(ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_COMMENTI, searchContainerName, curCommenti, deltaCommenti);
					listaCommentiRichiesta = commentoRichiestaLocalService.getCommentiRichiestaByRichiestaIdVisibile(richiestaId, true, posizioni[0], posizioni[1]);
					commentiRichiestaCount = commentoRichiestaLocalService.countCommentiRichiestaByRichiestaIdVisibile(richiestaId, true);

					posizioni = calcolaInizioFinePaginazione(ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_ATTIVITA, searchContainerName, curAttivita, deltaAttivita);
					listaAttivitaRichiesta = attivitaRichiestaLocalService.getAttivitaRichiestaByRichiestaId(richiestaId, posizioni[0], posizioni[1]);
					attivitaRichiestaCount = attivitaRichiestaLocalService.countAttivitaRichiestaByRichiestaId(richiestaId);

					pdfRichiesta = allegatoRichiestaLocalService.getAllegatiRichiestaByRichiestaIdPrincipale(richiestaId, true).get(0);

				}

				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.ALLEGATI_RICHIESTA, listaAllegatiCittadino);
				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.PDF_RICHIESTA, pdfRichiesta);
				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.ALLEGATI_PROVVEDIMENTI_FINALI, listaProvvedimentiFinali);

				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.ATTIVITA_RICHIESTA, listaAttivitaRichiesta);
				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.ATTIVITA_RICHIESTA_COUNT, attivitaRichiestaCount);

				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.COMMENTI_RICHIESTA, listaCommentiRichiesta);
				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.COMMENTI_RICHIESTA_COUNT, commentiRichiestaCount);

				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.RICHIESTA, richiesta);
				renderRequest.setAttribute(ScrivaniaCittadinoPortletKeys.SEARCH_CONTAINER_NAME, searchContainerName);
				return ScrivaniaCittadinoPortletKeys.JSP_DETTAGLIO_RICHIESTA;
			}
			catch (PortalException e) {
				_log.error("Impossibile ottenere la richiesta :: [id: " + richiestaId + "] :: " + e.getMessage(), e);
			}

		}
		else {
			SessionErrors.add(renderRequest, ScrivaniaCittadinoPortletKeys.ERROR_IMPOSSIBILE_OTTENERE_DETTAGLIO);
		}
		return ScrivaniaCittadinoPortletKeys.JSP_HOME;
	}

	private int[] calcolaInizioFinePaginazione(String searchContainerName, String searchContainerNameParam, int cur, int delta) {
		int posizioni[] = new int[2];

		if (cur <= 0) {
			cur = 1;
		}

		posizioni = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		return posizioni;
	}
}