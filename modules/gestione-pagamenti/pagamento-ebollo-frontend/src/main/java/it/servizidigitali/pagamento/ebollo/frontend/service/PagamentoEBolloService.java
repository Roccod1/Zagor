package it.servizidigitali.pagamento.ebollo.frontend.service;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionepagamenti.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.common.client.exeption.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.common.client.model.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;
import it.servizidigitali.pagamento.ebollo.frontend.constants.PagamentoEbolloFrontendPortletKeys;

/**
 * @author pindi
 *
 */
@Component(immediate = true, service = PagamentoEBolloService.class, configurationPid = "it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration")
public class PagamentoEBolloService {

	private static final Log LOG = LogFactoryUtil.getLog(PagamentoEBolloService.class.getName());

	private volatile ClientPagamentiEnteConfiguration accountClientPagamentiEnteConfiguration;

	private ConfigurationProvider configurationProvider;
	
	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private PagamentiClient pagamentiClient;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		accountClientPagamentiEnteConfiguration = ConfigurableUtil.createConfigurable(ClientPagamentiEnteConfiguration.class, props);
	}

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	public String pagaBollo(ActionRequest actionRequest) throws ConfigurationException, PagamentiClientException {
		
		// TODO loggare parametri ingresso
		LOG.debug("pagaBollo: ");
		
		long requestTime = Timestamp.from(Instant.now()).getTime();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long siteOrganizationId = themeDisplay.getSiteGroup().getOrganizationId();
		
		String codiceOrganizzazione = null;
		
		if (siteOrganizationId != 0) {
			try {
				Organization organization = organizationLocalService.getOrganization(siteOrganizationId);
				codiceOrganizzazione = "-";
			} catch (PortalException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		File file = uploadPortletRequest.getFile(PagamentoEbolloFrontendPortletKeys.FILE_TO_UPLOAD_ATTRIBUTE);
		
		String fileName = uploadPortletRequest.getFileName(PagamentoEbolloFrontendPortletKeys.FILE_TO_UPLOAD_ATTRIBUTE);
		
		String hashDocumento = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
	        
	        byte[] result = md.digest(Files.readAllBytes(file.toPath()));
	        
	        StringBuilder builder = new StringBuilder();
	        
	        for (byte b : result) {
	        	builder.append(String.format("%02x", b));
			}
	        
	        hashDocumento = builder.toString();
	        
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, themeDisplay.getSiteGroupId());

		String username = accountClientPagamentiEnteConfiguration.clientUsername();
		String password = accountClientPagamentiEnteConfiguration.clientPassword();
		String wsdlUrl = accountClientPagamentiEnteConfiguration.clientWsdlUrl();
		BigDecimal importoBollo = accountClientPagamentiEnteConfiguration.importoBollo();
		String codiceDovuto = accountClientPagamentiEnteConfiguration.codiceDovuto();
		String prefissoCausale = accountClientPagamentiEnteConfiguration.prefissoCausale();
		String idServizio = accountClientPagamentiEnteConfiguration.idServizio();
		String descrizioneServizio = accountClientPagamentiEnteConfiguration.descrizioneServizio();
		String causale = prefissoCausale + fileName;
		String idCredito = codiceOrganizzazione + "-" + prefissoCausale + "-" + " - " + fileName + "_" + requestTime;
		
		User user = themeDisplay.getUser();
		
		String idFiscaleCliente = user.getScreenName();
		String denominazioneCliente = user.getFullName() + " (" + idFiscaleCliente + ")";
		String emailQuietanza = user.getEmailAddress();

		MarcaDaBollo marcaDaBollo = new MarcaDaBollo();
		marcaDaBollo.setHashDocumento(hashDocumento);
		marcaDaBollo.setImporto(importoBollo);
		marcaDaBollo.setCodiceDovuto(codiceDovuto);
		marcaDaBollo.setCodiceOrganizzazione(codiceOrganizzazione);
		marcaDaBollo.setIdFiscaleCliente(idFiscaleCliente);
		marcaDaBollo.setDenominazioneCliente(denominazioneCliente);
		marcaDaBollo.setEmailQuietanza(emailQuietanza);
		marcaDaBollo.setIdServizio(idServizio);
		marcaDaBollo.setDescrizioneServizio(descrizioneServizio);
		marcaDaBollo.setCausale(causale);
		marcaDaBollo.setIdCredito(idCredito);
		
		LiferayPortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPpid(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		 
        portletURL.getRenderParameters().setValue("mvcRenderCommandName", PagamentoEbolloFrontendPortletKeys.ESITO_PAGAMENTO_RENDER_COMMAND);
		
		PagamentoDovutoRisposta pagamentoDovutoRisposta = pagamentiClient.pagaDovuto(marcaDaBollo, username, password, wsdlUrl, portletURL.toString());

		return pagamentoDovutoRisposta.getRedirectUrl();

	}

}
