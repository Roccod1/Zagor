package it.servizidigitali.gestionepagamenti.common.enumeration;

/**
 * @author pindi
 *
 */
public enum TipoPagamentiClient {
	MYPAY("MYPAY");
	
	private String descrizione;
	
	private TipoPagamentiClient(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}
}
