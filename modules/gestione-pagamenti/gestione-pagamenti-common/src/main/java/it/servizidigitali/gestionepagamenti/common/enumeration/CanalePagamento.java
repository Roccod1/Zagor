package it.servizidigitali.gestionepagamenti.common.enumeration;

/**
 * @author pindi
 *
 */
public enum CanalePagamento {

	WEB("WEB"), MOBILE("MOBILE"), ESTERNO("ESTERNO");
	
	private String descrizione;
	
	private CanalePagamento(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}
}
