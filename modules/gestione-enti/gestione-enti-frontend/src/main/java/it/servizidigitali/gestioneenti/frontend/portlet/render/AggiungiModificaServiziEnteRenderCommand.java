package it.servizidigitali.gestioneenti.frontend.portlet.render;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.frontend.service.GestioneEntiMiddlewareService;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoLocalService;

/**
 * @author pindi
 */

@Component(immediate = true, //
		property = { //
				"javax.portlet.name=" + GestioneEntiPortletKeys.GESTIONEENTI, //
				"mvc.command.name=" + GestioneEntiPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME //
		}, //
		service = MVCRenderCommand.class //
) //
public class AggiungiModificaServiziEnteRenderCommand implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(AggiungiModificaServiziEnteRenderCommand.class);

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private GestioneEntiMiddlewareService gestioneEntiMiddlewareService;
	
	@Reference
	private DestinazioneUsoLocalService destinazioneUsoLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Long organizationId = ParamUtil.getLong(renderRequest, GestioneEntiPortletKeys.ORGANIZZAZIONE_ID);
		Long servizioId = ParamUtil.getLong(renderRequest, GestioneEntiPortletKeys.SERVIZIO_ID);
		List<Servizio> listaServizi = new ArrayList<Servizio>();
		List<DestinazioneUso> listaDestinazioniUso = new ArrayList<DestinazioneUso>();
		
		String listaFormatiFirmaDigitaleString = "";
		
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		List<JournalArticle> listaArticoliCatalogoServizi = new ArrayList<JournalArticle>();
		Map<String, List<Layout>> pagineDisponibili = null;
		
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			listaArticoliCatalogoServizi = gestioneEntiMiddlewareService.getListaArticleIdDisponibili(organizationId, servizioId);
			listaDestinazioniUso = destinazioneUsoLocalService.getDestinazioneUsos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			pagineDisponibili = gestioneEntiMiddlewareService.getListaPagineUtilizzabili(organizationId, servizioId, themeDisplay.getCompanyId());
			
			// creo copia servizioId per non sovrascrivere l'originale
			Long tempServizioId = servizioId;

			if (Validator.isNotNull(organizationId)) {
				Organization organization = organizationLocalService.getOrganization(organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE, organization);

				List<Organization> organizations = organizationLocalService.getOrganizations(themeDisplay.getCompanyId(), organizationId);
				renderRequest.setAttribute(GestioneEntiPortletKeys.SOTTO_ORGANIZZAZIONI, organizations);

				/*
				 * se servizioId non e' null si tratta di modifica servizio esistente quindi imposto
				 * la lista completa per poter visualizzare il nome del servizio associato a
				 * servizioEnte altrimenti filtro la lista rimuovendo i servizi gia' attivi per
				 * l'ente
				 */
				if (Validator.isNotNull(servizioId)) {
					ServizioEntePK servizioEntePK = new ServizioEntePK(servizioId, organizationId);
					ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);
					
					List<DestinazioneUso> listaDestinazioniUsoServizio = gestioneEntiMiddlewareService.getListaDestinazioniUsoServizio(servizioId, organizationId, organization.getGroupId(), organization.getCompanyId());
					
					if(Validator.isNotNull(servizioEnte.getFormatiFirmaDigitale())) {
						listaFormatiFirmaDigitaleString = gestioneEntiMiddlewareService.getStringSelectMultipla(servizioEnte.getFormatiFirmaDigitale());
						renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_FORMATI_FIRMA_DIGITALE, listaFormatiFirmaDigitaleString);
					}else {
						renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_FORMATI_FIRMA_DIGITALE, GestioneEntiPortletKeys.LISTA_VUOTA);
					}
					
					if(Validator.isNotNull(listaDestinazioniUsoServizio) && !listaDestinazioniUsoServizio.isEmpty()) {
						listaDestinazioniUso = listaDestinazioniUso.stream()
																   .filter(destinazioneUso -> !listaDestinazioniUsoServizio.contains(destinazioneUso))
																   .collect(Collectors.toList());
												
						renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_DESTINAZIONI_USO_SERVIZIO, listaDestinazioniUsoServizio);
					}
					
					renderRequest.setAttribute(GestioneEntiPortletKeys.SERVIZIO_ENTE, servizioEnte);
					tempServizioId = null;
				}else {
					renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_FORMATI_FIRMA_DIGITALE, GestioneEntiPortletKeys.LISTA_VUOTA);
				}

			}
			listaServizi = gestioneEntiMiddlewareService.getListaServiziAttivabili(tempServizioId, organizationId);
		}
		catch (Exception e) {
			_log.error("Errore durante il caricamento dell'ente_servizio : ", e);
			SessionErrors.add(renderRequest, GestioneEntiPortletKeys.ERRORE_IMPOSSIBILE_CARICARE_I_DATI);
			return GestioneEntiPortletKeys.JSP_LISTA_SERVIZI_ENTE;
		}
		
		renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_URI_PUBBLICHE, pagineDisponibili.get(GestioneEntiPortletKeys.LISTA_URI_PUBBLICHE));
		renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_URI_PRIVATE, pagineDisponibili.get(GestioneEntiPortletKeys.LISTA_URI_PRIVATE));
		renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_SERVIZI, listaServizi);
		renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_DESTINAZIONI_USO, listaDestinazioniUso);
		renderRequest.setAttribute(GestioneEntiPortletKeys.LISTA_ARTICLE_CATALOGO_SERVIZI, listaArticoliCatalogoServizi);

		return GestioneEntiPortletKeys.JSP_INSERIMENTO_MODIFICA;
	}
}