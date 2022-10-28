package it.servizidigitali.presentatoreforms.common.service.integration.enumeration;

/**
 * @author pindi
 *
 */
public enum BackofficeServiceExceptionLanguageCode {

	DATA_MINIMA_CERT_MORTE("backoffice-service-exception-condizione-data-non-verificata-cert-morte"), //
	DATA_MINIMA_CERT_NASCITA("backoffice-service-exception-condizione-data-non-verificata-cert-nascita"), //
	SOGGETTO_NON_DECEDUTO("backoffice-service-exception-condizione-morte-non-verificata"), //
	COMUNE_NON_CORRETTO("backoffice-service-exception-condizione-comune-nascita-non-verificata"), //
	SOGGETTO_NON_CONIUGATO("backoffice-service-exception-condizione-coniugato-non-verificata"), //
	SOGGETTO_CONIUGATO("backoffice-service-exception-condizione-non-coniugato-non-verificata"), //
	SOGGETTO_NON_LIBERO("backoffice-service-exception-condizione-libero-non-verificata"), //
	POSIZIONI_ELETTORALI_VUOTE("backoffice-service-exception-condizione-posizioni-elettorali-vuote"), //
	SOGGETTO_NON_VEDOVO("backoffice-service-exception-condizione-vedovanza-non-verificata"), //
	SOGGETTO_NON_IN_VITA("backoffice-service-exception-condizione-in-vita-non-verificata"), //
	SOGGETTO_DECEDUTO_CERTIFICATO_NON_DISPONIBILE("backoffice-service-exception-condizione-deceduto-messaggio-generico");

	private String liferayLanguageKey;

	private BackofficeServiceExceptionLanguageCode(String liferayLanguageKey) {
		this.liferayLanguageKey = liferayLanguageKey;
	}

	/**
	 * @return the liferayLanguageKey
	 */
	public String getLiferayLanguageKey() {
		return liferayLanguageKey;
	}
}
