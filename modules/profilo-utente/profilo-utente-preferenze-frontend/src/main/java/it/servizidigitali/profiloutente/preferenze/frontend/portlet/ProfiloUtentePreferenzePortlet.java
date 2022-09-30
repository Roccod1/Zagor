package it.servizidigitali.profiloutente.preferenze.frontend.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;
import it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration;
import it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys;
import it.servizidigitali.profiloutente.preferenze.frontend.service.ProfiloUtentePreferenzeMiddlewareService;
import it.servizidigitali.profiloutente.service.CanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneCanaleComunicazioneLocalService;
import it.servizidigitali.profiloutente.service.UtenteOrganizzazioneLocalService;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

/**
 * @author filierim
 */
@Component(immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=ProfiloUtentePreferenze", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + ProfiloUtentePreferenzePortletKeys.PROFILOUTENTEPREFERENZE, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user" //
		}, //
		service = Portlet.class, //
		configurationPid = "it.servizidigitali.profiloutente.portal.configuration.ProfiloUtenteConfiguration" //
) //
public class ProfiloUtentePreferenzePortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ProfiloUtentePreferenzePortlet.class);

	@Reference
	private CanaleComunicazioneLocalService canaleComunicazioneLocalService;

	@Reference
	private UtenteOrganizzazioneLocalService utenteOrganizzazioneLocalService;

	@Reference
	private UtenteOrganizzazioneCanaleComunicazioneLocalService utenteOrganizzazioneCanaleComunicazioneLocalService;
	
	@Reference
	private ProfiloUtentePreferenzeMiddlewareService profiloUtentePreferenzeMiddlewareService;

	private volatile ProfiloUtenteConfiguration profiloUtenteConfiguration;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		profiloUtenteConfiguration = ConfigurableUtil.createConfigurable(ProfiloUtenteConfiguration.class, props);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<Organization> listaOrganizzazioni = null;
		UtenteOrganizzazione utenteOrganizzazionePreferita = null;
		boolean privacyAccettata = false;

		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;
		User utenteCorrente = null;
		Group globalGroup = null;
		long currentOrganizationId = 0;
		
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, ProfiloUtentePreferenzePortletKeys.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, ProfiloUtentePreferenzePortletKeys.DEFAULT_DELTA);
		String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM);
		String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM);
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		
		/*
		 * Vengono impostati a -1 per ottenere la lista completa
		 */
		
		int inizio = -1;
		int fine = -1;
		
		boolean direzione = false;

		if (orderByType.equalsIgnoreCase("asc")) {
			direzione = true;
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "name";
		}

		OrderByComparator<Organization> comparator = OrderByComparatorFactoryUtil.create("Organization", orderByCol, direzione);
		
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			utenteCorrente = themeDisplay.getUser();
			currentOrganizationId = themeDisplay.getScopeGroup().getOrganizationId();
			globalGroup = GroupLocalServiceUtil.getCompanyGroup(themeDisplay.getCompanyId());

			renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.ORGANIZZAZIONE_ID_CORRENTE, currentOrganizationId);
			renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.PRIVACY_ARTICLE_ID, profiloUtenteConfiguration.checkPrivacyArticleId());
			renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.PRIVACY_ARTICLE_GROUP_ID, globalGroup.getGroupId());

			try {
				privacyAccettata = (boolean) utenteCorrente.getExpandoBridge().getAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_EXPANDO_ACCETTA_PRIVACY);
			}
			catch (NullPointerException npe) {
				_log.warn("Impossibile recuperare privacyUtente");
			}

			renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_ACCETTA_PRIVACY, privacyAccettata);

			if (currentOrganizationId > 0) {
				List<CanaleComunicazione> listaCanaliComunicazione = canaleComunicazioneLocalService.getCanaleComunicazionesAttivi(true);
				List<UtenteOrganizzazioneCanaleComunicazione> listaUtenteOrganizzazioneCanaleComunicazione = utenteOrganizzazioneCanaleComunicazioneLocalService
						.getListaCanaleComunicazioneByUtenteOrganization(utenteCorrente.getUserId(), currentOrganizationId);

				listaOrganizzazioni = profiloUtentePreferenzeMiddlewareService.getListaOrganizzazioni(inizio, fine, comparator);

				Organization organization = profiloUtentePreferenzeMiddlewareService.getOrganization(currentOrganizationId);

				UtenteOrganizzazionePK utenteOrganizzazionePK = new UtenteOrganizzazionePK(utenteCorrente.getUserId(), currentOrganizationId);
				UtenteOrganizzazione utenteOrganizzazione = utenteOrganizzazioneLocalService.fetchUtenteOrganizzazione(utenteOrganizzazionePK);

				if (Validator.isNull(utenteOrganizzazione)) {
					_log.warn("Nessun UtenteOrganizzazione con PK {utenteId=" + utenteCorrente.getUserId() + ", organizationId=" + currentOrganizationId + "}");
				}

				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_ORGANIZZAZIONE, utenteOrganizzazione);
				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.ORGANIZZAZIONE, organization);
				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_CANALI_COMUNICAZIONE, listaCanaliComunicazione);
				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_ORGANIZZAZIONI, listaOrganizzazioni);
				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_UTENTE_ORGANIZZAZIONE_CANALE_COMUNICAZIONE, listaUtenteOrganizzazioneCanaleComunicazione);
			}
			else {
				listaOrganizzazioni = profiloUtentePreferenzeMiddlewareService.getListaOrganizzazioni(inizio, fine, comparator);

				List<UtenteOrganizzazione> listaUtenteOrganizzazione = utenteOrganizzazioneLocalService.getByUtentePreferito(utenteCorrente.getUserId(), true);

				if (Validator.isNotNull(listaUtenteOrganizzazione) && !listaUtenteOrganizzazione.isEmpty()) {
					utenteOrganizzazionePreferita = listaUtenteOrganizzazione.get(0);
				}

				if (Validator.isNull(listaOrganizzazioni)) {
					listaOrganizzazioni = new ArrayList<Organization>();
				}
				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_ORGANIZZAZIONI, listaOrganizzazioni);
				renderRequest.setAttribute(ProfiloUtentePreferenzePortletKeys.UTENTE_ORGANIZZAZIONE_PREFERITA, utenteOrganizzazionePreferita);
			}

		}
		catch (Exception e) {
			SessionErrors.add(renderRequest, ProfiloUtentePreferenzePortletKeys.ERRORE_GENERICO);
			_log.error("Impossibile recuperare le informazion pe l'utente corrente ::" + e.getMessage(), e);
		}

		super.render(renderRequest, renderResponse);
	}
}