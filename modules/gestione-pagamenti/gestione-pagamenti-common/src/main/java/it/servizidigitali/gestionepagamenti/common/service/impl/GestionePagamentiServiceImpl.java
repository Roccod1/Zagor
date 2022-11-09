package it.servizidigitali.gestionepagamenti.common.service.impl;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Random;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.utility.enumeration.OrganizationCustomAttributes;
import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;
import it.servizidigitali.gestionepagamenti.common.enumeration.CanalePagamento;
import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.common.exception.GestionePagamentiServiceException;
import it.servizidigitali.gestionepagamenti.common.service.GestionePagamentiService;
import it.servizidigitali.gestionepagamenti.integration.common.client.PagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.integration.common.client.model.PagamentoDovutoRisposta;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.service.PagamentoLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 *
 */
@Component(name = "gestionePagamentiService", service = GestionePagamentiService.class, immediate = true, configurationPid = "it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration")
public class GestionePagamentiServiceImpl implements GestionePagamentiService {

	private static final String DESCRIZIONE_RICHIESTA = "Richiesta pagamento Marca da Bollo - ID: %s";

	private static final Log log = LogFactoryUtil.getLog(GestionePagamentiServiceImpl.class.getName());

	private volatile ClientPagamentiEnteConfiguration clientPagamentiEnteConfiguration;

	private ConfigurationProvider configurationProvider;

	@Reference
	private PagamentiClient pagamentiClient;

	@Reference
	private PagamentoLocalService pagamentoLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Override
	public String pagaBollo(byte[] file, String fileName, long richiestaId, long proceduraId, long servizioId, long organizationId, long userId, long groupId, long companyId, String callbackUrl)
			throws GestionePagamentiServiceException {

		try {
			clientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, groupId);

			Servizio servizio = servizioLocalService.getServizioById(servizioId);
			String nomeServizio = servizio.getNome();
			String codiceServizio = servizio.getCodice();

			Organization organization = organizationLocalService.getOrganization(organizationId);
			String codiceOrganizzazione = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_IPA.getNomeAttributo()).toString();

			String codiceIstat = organization.getExpandoBridge().getAttribute(OrganizationCustomAttributes.CODICE_ISTAT.getNomeAttributo()).toString();
			Comune comune = comuneLocalService.getComuneByCodiceISTAT(codiceIstat);
			String provinciaResidenza = null;
			if (Validator.isNotNull(comune)) {
				provinciaResidenza = comune.getProvincia().getSigla();
			}

			User user = userLocalService.getUser(userId);
			String idFiscaleCliente = user.getScreenName();
			String denominazioneCliente = user.getFullName();
			String emailQuietanza = user.getEmailAddress();

			String username = clientPagamentiEnteConfiguration.clientUsername();
			String password = clientPagamentiEnteConfiguration.clientPassword();
			String wsdlUrl = clientPagamentiEnteConfiguration.clientWsdlUrl();
			BigDecimal importoBollo = clientPagamentiEnteConfiguration.importoPagamentoMarcaBolloDigitale();
			String codiceDovuto = clientPagamentiEnteConfiguration.codiceDovutoPagamentoMarcaBolloDigitale();
			String prefissoCausale = clientPagamentiEnteConfiguration.prefissoCausalePagamentoMarcaBolloDigitale();
			String causale = prefissoCausale + "-" + fileName;
			String idCredito = codiceOrganizzazione + "-" + prefissoCausale + "-" + " - " + fileName;
			String iud = randomString(35);

			MarcaDaBollo marcaDaBollo = new MarcaDaBollo();
			marcaDaBollo.setHashDocumento(getFileHash(file));
			marcaDaBollo.setImporto(importoBollo);
			marcaDaBollo.setCodiceDovuto(codiceDovuto);
			marcaDaBollo.setCodiceOrganizzazione(codiceOrganizzazione);
			marcaDaBollo.setIdFiscaleCliente(idFiscaleCliente);
			marcaDaBollo.setDenominazioneCliente(denominazioneCliente);
			marcaDaBollo.setEmailQuietanza(emailQuietanza);
			marcaDaBollo.setCausale(causale);
			marcaDaBollo.setIdCredito(idCredito);
			marcaDaBollo.setIud(iud);
			marcaDaBollo.setProvinciaResidenza(provinciaResidenza);

			PagamentoDovutoRisposta pagamentoDovutoRisposta = pagamentiClient.pagaDovuto(marcaDaBollo, username, password, wsdlUrl, callbackUrl);

			Pagamento pagamento = this.manageRichiestaAndPagamento(file, fileName, richiestaId, groupId, companyId, userId, denominazioneCliente, idCredito, idFiscaleCliente, denominazioneCliente,
					emailQuietanza, causale, servizioId, nomeServizio, codiceServizio, importoBollo, null, CanalePagamento.WEB.toString(), TipoPagamentiClient.MYPAY.toString(), iud, null,
					pagamentoDovutoRisposta.getIdSessione(), null, false, StatoPagamento.IN_ATTESA.toString(), proceduraId);

			log.info("Created new pagamento with id: " + pagamento.getPagamentoId());

			return pagamentoDovutoRisposta.getRedirectUrl();

		}
		catch (Exception e) {
			log.error("pagaBollo :: " + e.getMessage(), e);
			throw new GestionePagamentiServiceException(e.getMessage(), e);
		}
	}

	public Pagamento manageRichiestaAndPagamento(byte[] file, String fileName, long richiestaId, long groupId, long companyId, long userId, String userName, String idCredito, String idFiscaleCliente,
			String denominazioneCliente, String emailQuietanza, String causale, long servizioId, String nomeServizio, String codiceServizio, BigDecimal importo, BigDecimal commissioni, String canale,
			String gateway, String iud, String iuv, String idSessione, String pathAvviso, boolean emailInviata, String stato, long proceduraId) throws Exception {

		Richiesta richiesta = richiestaLocalService.createRichiesta(counterLocalService.increment());
		if (richiestaId != 0) {
			richiesta = richiestaLocalService.getRichiesta(richiestaId);
		}
		else {
			richiesta = richiestaLocalService.createRichiesta(counterLocalService.increment());
		}

		richiesta.setGroupId(groupId);
		richiesta.setUserId(userId);
		richiesta.setUserName(userName);
		richiesta.setCodiceFiscale(idFiscaleCliente);
		richiesta.setEmail(emailQuietanza);
		richiesta.setOggetto(nomeServizio);
		richiesta.setStato(StatoRichiesta.ATTESA_PAGAMENTO.name());
		richiesta.setProceduraId(proceduraId);
		richiesta.setServizioId(servizioId);

		richiesta = richiestaLocalService.updateRichiesta(richiesta);

		long allegatoRichiestaId = 0;
		String idDocumentale = null;
		Pagamento pagamento = null;
		try {
			richiestaId = richiesta.getRichiestaId();
			String descrizioneAllegatoRichiesta = String.format(DESCRIZIONE_RICHIESTA, richiestaId);

			idDocumentale = fileServiceFactory.getActiveFileService().saveRequestFile(fileName, fileName, descrizioneAllegatoRichiesta, codiceServizio, richiestaId, new ByteArrayInputStream(file),
					ContentTypes.APPLICATION_OCTET_STREAM, userId, groupId);

			AllegatoRichiesta allegatoRichiesta = allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());
			allegatoRichiesta.setCompanyId(companyId);
			allegatoRichiesta.setDefinizioneAllegatoId(null);
			allegatoRichiesta.setDescrizione(descrizioneAllegatoRichiesta);
			allegatoRichiesta.setGroupId(groupId);
			allegatoRichiesta.setIdDocumentale(idDocumentale);
			allegatoRichiesta.setInterno(false);
			allegatoRichiesta.setNome(fileName);
			allegatoRichiesta.setPrincipale(true);
			allegatoRichiesta.setRichiestaId(richiestaId);
			allegatoRichiesta.setTitolo(fileName);
			allegatoRichiesta.setUserId(userId);
			allegatoRichiesta.setUserName(userName);
			allegatoRichiesta.setVisibile(true);

			allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiesta);

			allegatoRichiestaId = allegatoRichiesta.getAllegatoRichiestaId();

			pagamento = pagamentoLocalService.create(groupId, userId, userName, idCredito, idFiscaleCliente, denominazioneCliente, emailQuietanza, causale, servizioId, nomeServizio, importo,
					commissioni, canale, gateway, iud, iuv, idSessione, pathAvviso, emailInviata, stato, richiestaId);
		}
		catch (Exception e) {
			log.error("manageRichiestaAndPagamento :: " + e.getMessage(), e);

			// Rollback
			if (idDocumentale != null) {
				fileServiceFactory.getActiveFileService().deleteRequestFile(idDocumentale, groupId);
			}
			if (richiestaId != 0) {
				richiestaLocalService.deleteRichiesta(richiestaId);
			}
			if (allegatoRichiestaId != 0) {
				allegatoRichiestaLocalService.deleteAllegatoRichiesta(allegatoRichiestaId);
			}
			throw e;
		}

		return pagamento;

	}

	private String randomString(int length) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(length)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

	private String getFileHash(byte[] file) {
		String hashDocumento = null;

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] result = md.digest(file);

			StringBuilder builder = new StringBuilder();

			for (byte b : result) {
				builder.append(String.format("%02x", b));
			}

			hashDocumento = builder.toString();

		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return hashDocumento;
	}

}
