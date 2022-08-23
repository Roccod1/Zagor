package it.servizidigitali.file.utility.signature.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.security.cert.X509Certificate;

import org.osgi.service.component.annotations.Component;

import it.linksmt.tools.versig.factory.SignatureManagerFactory;
import it.servizidigitali.file.utility.exception.SignatureVerificationException;
import it.servizidigitali.file.utility.signature.SignatureVerification;

/**
 * @author pindi
 *
 */
@Component(name = "signatureVerificationImpl", immediate = true, service = SignatureVerification.class)
public class SignatureVerificationImpl implements SignatureVerification {

	private static final Log log = LogFactoryUtil.getLog(SignatureVerificationImpl.class.getName());

	@Override
	public boolean isCades(byte[] byteArray) {
		return SignatureManagerFactory.isCades(byteArray);
	}

	@Override
	public boolean isPades(byte[] byteArray) {
		return SignatureManagerFactory.isPades(byteArray);
	}

	@Override
	public boolean checkPkcs7Signature(byte[] sigbytes, String outputFile, String certificateFile) throws SignatureVerificationException {
		try {
			boolean checkPkcs7Signature = SignatureManagerFactory.getSignatureManager(sigbytes).checkPkcs7Signature(sigbytes, outputFile, certificateFile);
			return checkPkcs7Signature;
		}
		catch (it.linksmt.tools.versig.exception.SignatureVerificationException e) {
			log.error("checkPkcs7Signature :: " + e.getMessage(), e);
			throw new SignatureVerificationException("checkPkcs7Signature :: " + e.getMessage(), e);
		}
	}

	@Override
	public byte[] getData(byte[] sigbytes) throws SignatureVerificationException {
		try {
			byte[] data = SignatureManagerFactory.getSignatureManager(sigbytes).getData(sigbytes);
			return data;
		}
		catch (it.linksmt.tools.versig.exception.SignatureVerificationException e) {
			log.error("getData :: " + e.getMessage(), e);
			throw new SignatureVerificationException("getData :: " + e.getMessage(), e);
		}
	}

	@Override
	public X509Certificate getX509Certificate(byte[] sigbytes) throws SignatureVerificationException {
		try {
			X509Certificate x509Certificate = SignatureManagerFactory.getSignatureManager(sigbytes).getX509Certificate(sigbytes, null);
			return x509Certificate;
		}
		catch (it.linksmt.tools.versig.exception.SignatureVerificationException e) {
			log.error("getX509Certificate :: " + e.getMessage(), e);
			throw new SignatureVerificationException("getX509Certificate :: " + e.getMessage(), e);
		}
	}

}
