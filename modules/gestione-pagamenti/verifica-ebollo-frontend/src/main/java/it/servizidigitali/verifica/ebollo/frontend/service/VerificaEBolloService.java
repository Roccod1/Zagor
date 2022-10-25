package it.servizidigitali.verifica.ebollo.frontend.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.security.Key;
import java.security.KeyException;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.List;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration;
import it.servizidigitali.gestionepagamenti.common.factory.PagamentiServiceFactory;
import it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient;
import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo;
import it.servizidigitali.gestionepagamenti.integration.common.service.PagamentiService;

@Component(immediate = true, service = VerificaEBolloService.class, configurationPid = {"it.servizidigitali.gestionepagamenti.common.configuration.ClientPagamentiEnteConfiguration"})
public class VerificaEBolloService {
	
	@Reference
	private PagamentiServiceFactory pagamentiServiceFactory;

	private volatile ClientPagamentiEnteConfiguration accountClientPagamentiEnteConfiguration;
	private ConfigurationProvider configurationProvider;
	
	private static final Log LOG = LogFactoryUtil.getLog(VerificaEBolloService.class.getName());

	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}
	
	public boolean checkFileHashMatch(long groupId, File documento, File xmlBollo) {
		
		boolean match = false;
		
		try {
			accountClientPagamentiEnteConfiguration = configurationProvider.getGroupConfiguration(ClientPagamentiEnteConfiguration.class, groupId);
			PagamentiService pagamentiService = pagamentiServiceFactory.getPagamentiService(TipoPagamentiClient.valueOf(accountClientPagamentiEnteConfiguration.tipoPagamentiClient()));
			
			MarcaDaBollo marcaDaBollo = pagamentiService.unmarshal(new FileInputStream(xmlBollo));
			String xmlHashImpronta = new String(marcaDaBollo.getImprontaDocumento().getValore());
			
			String hashDocumento = this.getFileHash(documento);
			
			match = hashDocumento.equals(xmlHashImpronta);
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return match;
	}

	private String getFileHash(File file) {
		String hashDocumento = null;

		try {

			byte[] fileBytes = Files.readAllBytes(file.toPath());

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] result = md.digest(fileBytes);

			StringBuilder builder = new StringBuilder();

			for (byte b : result) {
				builder.append(String.format("%02x", b));
			}

			hashDocumento = builder.toString();

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return hashDocumento;
	}

	public boolean checkSignature(File xmlBollo) throws Exception {

		boolean isValid = false;
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			dbf.setNamespaceAware(true);

			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(new FileInputStream(xmlBollo));

			NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
			if (nl.getLength() == 0) {
				throw new Exception("Cannot find Signature element");
			}

			DOMValidateContext valContext = new DOMValidateContext(new KeyValueKeySelector(), nl.item(0));

			XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");

			XMLSignature signature = factory.unmarshalXMLSignature(valContext);
			
			isValid = signature.validate(valContext);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return isValid;
	}

	/**
	 * A simple KeySelectorResult containing a public key.
	 */
	private static class SimpleKeySelectorResult implements KeySelectorResult {
		private final Key key;

		SimpleKeySelectorResult(Key key) {
			this.key = key;
		}

		public Key getKey() {
			return key;
		}
	}

	private static class KeyValueKeySelector extends KeySelector {

		public KeySelectorResult select(KeyInfo keyInfo, KeySelector.Purpose purpose, AlgorithmMethod method,
				XMLCryptoContext context) throws KeySelectorException {

			if (keyInfo == null) {
				throw new KeySelectorException("Null KeyInfo object!");
			}
			SignatureMethod sm = (SignatureMethod) method;
			List<XMLStructure> list = keyInfo.getContent();

			for (int i = 0; i < list.size(); i++) {
				XMLStructure xmlStructure = (XMLStructure) list.get(i);
				if (xmlStructure instanceof KeyValue) {
					PublicKey pk = null;
					try {
						pk = ((KeyValue) xmlStructure).getPublicKey();
					} catch (KeyException ke) {
						throw new KeySelectorException(ke);
					}
					// make sure algorithm is compatible with method
					if (algEquals(sm.getAlgorithm(), pk.getAlgorithm())) {
						return new SimpleKeySelectorResult(pk);
					}
				}
			}
			throw new KeySelectorException("No KeyValue element found!");
		}

		static boolean algEquals(String algURI, String algName) {
			if (algName.equalsIgnoreCase("DSA")
					&& algURI.equalsIgnoreCase("http://www.w3.org/2009/xmldsig11#dsa-sha256")) {
				return true;
			} else if (algName.equalsIgnoreCase("RSA")
					&& algURI.equalsIgnoreCase("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256")) {
				return true;
			} else {
				return false;
			}
		}
	}
}
