package it.servizidigitali.gestionepagamenti.mypay.constant;

public interface MyPayConstants {

	String ID_SESSION = "idSession";
	String TIMESTAMP_CONFERMA = "timestampConferma";
	String REDIRECT_MYPAY = "redirectMyPay";

	String CODICE_IUV = "codiceIUV";
	String ID_RICHIESTA = "idRichiesta";

	String INFO_AGGIUNTIVE_MARCA_BOLLO_DIGITALE_HASH_DOCUMENTO_KEY = "_MARCA_BOLLO_DIGITALE_HASH_DOCUMENTO";
	String INFO_AGGIUNTIVE_MARCA_BOLLO_DIGITALE_PROVINCIA_RESIDENZA_KEY = "_MARCA_BOLLO_DIGITALE_PROVINCIA_RESIDENZA";

	String PARAM_TIPO_PAGAMENTO = "tipo_p";
	String TIPO_PAGAMENTO_AVVISO = "downloadAvviso";

	String BOLLO_DIGITALE_IUBD = "iubd";
	String BOLLO_DIGITALE_DATA_ORA_ACQUISTO = "dataAcquistoBolloDigitale";
	String BOLLO_DIGITALE_IMPORTO_PAGATO = "importoPagatoBolloDigitale";
	String BOLLO_DIGITALE_ESITO_VERIFICHE = "esitoVerificheBolloDigitale";
	String BOLLO_DIGITALE_ERRORE = "errorePagamentoBolloDigitale";

	String BOLLO_DIGITALE_OBJECT = "BOLLO_DIGITALE_OBJECT";
}
