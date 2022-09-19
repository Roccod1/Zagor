package it.servizidigitali.gestionepagamenti.common.client.model;

/**
 * @author pindi
 *
 */
public class MarcaDaBollo extends Dovuto {

	private String hashDocumento;
	private String provinciaResidenza;

	/**
	 * @return the hashDocumento
	 */
	public String getHashDocumento() {
		return hashDocumento;
	}

	/**
	 * @param hashDocumento the hashDocumento to set
	 */
	public void setHashDocumento(String hashDocumento) {
		this.hashDocumento = hashDocumento;
	}

	/**
	 * @return the provinciaResidenza
	 */
	public String getProvinciaResidenza() {
		return provinciaResidenza;
	}

	/**
	 * @param provinciaResidenza the provinciaResidenza to set
	 */
	public void setProvinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}

}
