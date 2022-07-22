package it.servizidigitali.file.utility.signature;

import java.security.cert.X509Certificate;

import it.servizidigitali.file.utility.exception.SignatureVerificationException;

/**
 * @author pindi
 *
 */
public interface SignatureVerification {

	/**
	 *
	 * @param sigbytes
	 * @param outputFile
	 * @param certificateFile
	 * @return
	 * @throws SignatureVerificationException
	 */
	boolean checkPkcs7Signature(byte[] sigbytes, String outputFile, String certificateFile) throws SignatureVerificationException;

	/**
	 *
	 * @param sigbytes
	 * @return
	 * @throws SignatureVerificationException
	 */
	X509Certificate getX509Certificate(byte[] sigbytes) throws SignatureVerificationException;

	/**
	 *
	 * @param sigbytes
	 * @return
	 * @throws SignatureVerificationException
	 */
	byte[] getData(byte[] sigbytes) throws SignatureVerificationException;

	/**
	 *
	 * @param byteArray
	 * @return
	 */
	boolean isCades(byte[] byteArray);

	/**
	 *
	 * @param byteArray
	 * @return
	 */
	boolean isPades(byte[] byteArray);

}
