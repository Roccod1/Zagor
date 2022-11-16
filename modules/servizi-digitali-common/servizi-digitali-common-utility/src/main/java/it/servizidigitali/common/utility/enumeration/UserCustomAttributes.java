package it.servizidigitali.common.utility.enumeration;

/**
 * @author pindi
 *
 */
public enum UserCustomAttributes {

	ACCETTA_PRIVACY("accettaPrivacy"), //
	EMAIL_AGGIUNTIVA("emailAggiuntiva"), //
	LIVELLO_SPID("livelloSPID"), //
	PEC("pec"), //
	RESIDENZA("residenza"), //
	TELEFONO("telefono"), //
	SPID_CODE("spidCode"), //
	LOGIN_SENZA_EMAIL("loginSenzaEmail"), //
	LOGIN_SENZA_CODICE_FISCALE("loginSenzaCodiceFiscale"), //
	TIPO_LOGIN("tipoLogin");

	private String nomeAttributo;

	/**
	 *
	 */
	private UserCustomAttributes(String nomeAttributo) {
		this.nomeAttributo = nomeAttributo;
	}

	/**
	 * @return the nomeAttributo
	 */
	public String getNomeAttributo() {
		return nomeAttributo;
	}
}
