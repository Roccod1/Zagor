package it.servizidigitali.profiloutente.mieidati.frontend.portlet;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.backoffice.integration.exception.BackofficeIntegrationClientException;
import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationFactoryService;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationService;
import it.servizidigitali.profiloutente.mieidati.frontend.constants.ProfiloUtenteMieiDatiPortletKeys;

/**
 * @author filierim
 */
@Component(//
		immediate = true, //
		property = { //
				"com.liferay.portlet.display-category=category.servizidigitali", //
				"com.liferay.portlet.header-portlet-css=/css/main.css", //
				"com.liferay.portlet.instanceable=true", //
				"javax.portlet.display-name=ProfiloUtenteMieiDati", //
				"javax.portlet.init-param.template-path=/", //
				"javax.portlet.init-param.view-template=/view.jsp", //
				"javax.portlet.name=" + ProfiloUtenteMieiDatiPortletKeys.PROFILOUTENTEMIEIDATI, //
				"javax.portlet.resource-bundle=content.Language", //
				"javax.portlet.security-role-ref=power-user,user"//
		}, //
		service = Portlet.class//
) //
public class ProfiloUtenteMieiDatiPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ProfiloUtenteMieiDatiPortlet.class);

	@Reference
	private AnagrafeIntegrationFactoryService anagrafeIntegrationFactoryService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// pulisco gli errori precedenti
		String tabAttiva = ParamUtil.getString(renderRequest, ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA);
		if (Validator.isNull(tabAttiva)) {
			HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			tabAttiva = ParamUtil.getString(httpServletRequest, ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA);
		}
		ServiceContext serviceContext = null;
		ThemeDisplay themeDisplay = null;

		User utenteCorrente = null;
		DatiAnagrafici datiAnagrafici = null;
		Organization organization = null;
		boolean anpr = false;

		List<DatiAnagrafici.ComponenteNucleoFamiliare> listaComponentiNucleoFamiliare = new ArrayList<DatiAnagrafici.ComponenteNucleoFamiliare>();
		try {
			serviceContext = ServiceContextFactory.getInstance(renderRequest);
			themeDisplay = serviceContext.getThemeDisplay();
			utenteCorrente = themeDisplay.getUser();
			User user = themeDisplay.getUser();
			// recupero il siteGroupOrganizationId dal siteGroup
			Long siteGroupOrganizationId = themeDisplay.getSiteGroup().getOrganizationId();

			AnagrafeIntegrationService anagrafeIntegrationService = anagrafeIntegrationFactoryService.getAnagrafeIntegrationService(siteGroupOrganizationId);

			organization = organizationLocalService.fetchOrganization(siteGroupOrganizationId);
			if (Validator.isNotNull(organization)) {
				ExpandoBridge expandoOrganization = organization.getExpandoBridge();
				anpr = (boolean) expandoOrganization.getAttribute(ProfiloUtenteMieiDatiPortletKeys.EXPANDO_ORGANIZATION_ANPR);

				if (!anpr) {
					renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.NOME_FONTE, organization.getName());
				}
			}

			datiAnagrafici = anagrafeIntegrationService.getDatiAnagrafici(user.getScreenName(), siteGroupOrganizationId, null);
			if (datiAnagrafici != null && datiAnagrafici.getComponentiNucleoFamiliare() != null) {
				_log.debug("datiAnagrafici: " + datiAnagrafici.getComponentiNucleoFamiliare().size());
				listaComponentiNucleoFamiliare = datiAnagrafici.getComponentiNucleoFamiliare();
			}

			Serializable loginSenzaEmailString = user.getExpandoBridge().getAttribute(ProfiloUtenteMieiDatiPortletKeys.EXPANDO_LOGIN_SENZA_EMAIL);
			if (loginSenzaEmailString != null) {
				renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.LOGIN_SENZA_EMAIL, Boolean.parseBoolean(loginSenzaEmailString.toString()));
			}

		}
		catch (BackofficeIntegrationClientException e) {
			_log.error("render :: " + e.getMessage(), e);
			SessionErrors.add(renderRequest, ProfiloUtenteMieiDatiPortletKeys.ERRORE_BACKOFFICE);
		}
		catch (Exception e) {
			_log.error("render :: " + e.getMessage(), e);
		}

		renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.TAB_ATTIVA, tabAttiva);
		renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.COMPONENTI_NUCLEO_FAMILIARE, listaComponentiNucleoFamiliare);
		renderRequest.setAttribute(ProfiloUtenteMieiDatiPortletKeys.UTENTE, utenteCorrente);
		super.render(renderRequest, renderResponse);
	}

}