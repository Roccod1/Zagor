package it.servizidigitali.pagamento.ebollo.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;
import it.servizidigitali.gestionepagamenti.common.enumeration.CanalePagamento;
import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.integration.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.exception.PagamentiClientException;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;
import it.servizidigitali.gestioneprocedure.service.ProceduraLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

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
	private PagamentiClient pagamentiClient;

	@Reference
	private PagamentoLocalService pagamentoLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ProceduraLocalService proceduraLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Activate
	@Modified
	private void activate(Map<String, Object> props) {
		accountClientPagamentiEnteConfiguration = ConfigurableUtil.createConfigurable(ClientPagamentiEnteConfiguration.class, props);
	}

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	public String pagaBollo(long requestTimeMillis, byte[] fileBytes, String fileName, long siteGroupId, long servizioId, String nomeServizio, long userId, String codiceOrganizzazione,
			String provinciaResidenza, String idFiscaleCliente, String denominazioneCliente, String emailQuietanza, String callbackUrl) throws ConfigurationException, PagamentiClientException {

		LOG.debug("pagaBollo debug params | requestTimeMillis: " + requestTimeMillis + ", fileBytesLength: " + fileBytes.length + ", fileName: " + fileName + ", siteGroupId: " + siteGroupId
				+ ", userId: " + userId + ", codiceOrganizzazione: " + codiceOrganizzazione + ", provinciaResidenza: " + provinciaResidenza + ", idFiscaleCliente: " + idFiscaleCliente
				+ ", denominazioneCliente: " + denominazioneCliente + ", emailQuietanza: " + emailQuietanza + ", callbackUrl" + callbackUrl);

		accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, siteGroupId);

		String username = accountClientPagamentiEnteConfiguration.clientUsername();
		String password = accountClientPagamentiEnteConfiguration.clientPassword();
		String wsdlUrl = accountClientPagamentiEnteConfiguration.clientWsdlUrl();
		BigDecimal importoBollo = accountClientPagamentiEnteConfiguration.importoPagamentoMarcaBolloDigitale();
		String codiceDovuto = accountClientPagamentiEnteConfiguration.codiceDovutoPagamentoMarcaBolloDigitale();
		String prefissoCausale = accountClientPagamentiEnteConfiguration.prefissoCausalePagamentoMarcaBolloDigitale();
		String causale = prefissoCausale + "-" + fileName;
		String idCredito = codiceOrganizzazione + "-" + prefissoCausale + "-" + " - " + fileName + "_" + requestTimeMillis;
		String iud = randomString(35);

		MarcaDaBollo marcaDaBollo = new MarcaDaBollo();
		marcaDaBollo.setHashDocumento(getHashFromBytes(fileBytes));
		marcaDaBollo.setImporto(importoBollo);
		marcaDaBollo.setCodiceDovuto(codiceDovuto);
		marcaDaBollo.setCodiceOrganizzazione(codiceOrganizzazione);
		marcaDaBollo.setIdFiscaleCliente(idFiscaleCliente);
		marcaDaBollo.setDenominazioneCliente(denominazioneCliente);
		marcaDaBollo.setEmailQuietanza(emailQuietanza);
		marcaDaBollo.setCausale(causale);
		marcaDaBollo.setIdCredito(idCredito);
		marcaDaBollo.setStato(StatoPagamento.NUOVO.toString());
		marcaDaBollo.setIud(iud);
		marcaDaBollo.setProvinciaResidenza(provinciaResidenza);

		PagamentoDovutoRisposta pagamentoDovutoRisposta = pagamentiClient.pagaDovuto(marcaDaBollo, username, password, wsdlUrl, callbackUrl);

		Pagamento pagamento = this.manageRichiestaAndPagamento(siteGroupId, userId, denominazioneCliente, idCredito, idFiscaleCliente, denominazioneCliente, emailQuietanza, causale, servizioId,
				nomeServizio, importoBollo, null, CanalePagamento.WEB.toString(), TipoPagamentiClient.MYPAY.toString(), iud, null, pagamentoDovutoRisposta.getIdSessione(), null, false,
				StatoPagamento.IN_ATTESA.toString(), 0);

		LOG.info("Created new pagamento with id: " + pagamento.getPagamentoId());

		return pagamentoDovutoRisposta.getRedirectUrl();

	}

	private String getHashFromBytes(byte[] fileBytes) {
		String hashDocumento = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] result = md.digest(fileBytes);

			StringBuilder builder = new StringBuilder();

			for (byte b : result) {
				builder.append(String.format("%02x", b));
			}

			hashDocumento = builder.toString();

		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return hashDocumento;
	}

	private String randomString(int length) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(length)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

	public Pagamento manageRichiestaAndPagamento(long groupId, long userId, String userName, String idCredito, String idFiscaleCliente, String denominazioneCliente, String emailQuietanza,
			String causale, long servizioId, String nomeServizio, BigDecimal importo, BigDecimal commissioni, String canale, String gateway, String iud, String iuv, String idSessione,
			String pathAvviso, boolean emailInviata, String stato, long proceduraId) {

		Richiesta richiesta = richiestaLocalService.createRichiesta(counterLocalService.increment());
		richiesta.setGroupId(groupId);
		richiesta.setUserId(userId);
		richiesta.setUserName(userName);
		richiesta.setCodiceFiscale(idFiscaleCliente);
		richiesta.setEmail(emailQuietanza);
		richiesta.setStato(stato);
		richiesta.setProceduraId(proceduraId);
		richiesta.setServizioId(servizioId);

		// TODO salvare documento upload in allegato_richiesta
		// AllegatoRichiesta allegatoRichiesta =
		// allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());
		// allegatoRichiesta.setCompanyId(companyId);
		// allegatoRichiesta.setDefinizioneAllegatoId(definizioneAllegatoId);
		// allegatoRichiesta.setDescrizione(descrizione);
		// allegatoRichiesta.setGroupId(groupId);
		// allegatoRichiesta.setIdDocumentale(idDocumentale);
		// allegatoRichiesta.setInterno(interno);
		// allegatoRichiesta.setNome(nome);
		// allegatoRichiesta.setPrincipale(principale);
		// allegatoRichiesta.setRichiestaId(richiestaId);
		// allegatoRichiesta.setTitolo(titolo);
		// allegatoRichiesta.setUserId(userId);
		// allegatoRichiesta.setUserName(userName);
		// allegatoRichiesta.setVisibile(visibile);
		//
		//
		// fileServiceFactory.getActiveFileService().saveRequestFile(nomeFile, titolo, descrizione,
		// codiceServizio, richiestaId, inputStream, mimeType, userId, groupId);
		// richiesta = richiestaLocalService.updateRichiesta(richiesta);

		return pagamentoLocalService.create(groupId, userId, userName, idCredito, idFiscaleCliente, denominazioneCliente, emailQuietanza, causale, servizioId, nomeServizio, importo, commissioni,
				canale, gateway, iud, iuv, idSessione, pathAvviso, emailInviata, stato, richiesta.getRichiestaId());
	}

	/**
	 * Carica il servizio corrente in base alla pagina in cui è in esecuzione la portlet.
	 *
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	public Servizio getCurrentServizio(ThemeDisplay themeDisplay) throws PortalException {

		Layout layout = themeDisplay.getLayout();

		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		long layoutId = layout.getLayoutId();

		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnteByOrganizationIdLayoutId(organizationId, layoutId);
		if (servizioEnte != null) {
			return servizioLocalService.getServizio(servizioEnte.getServizioId());
		}

		return null;
	}
}
