package it.servizidigitali.gestionepagamenti.integration.common.client.model;

import java.io.InputStream;

import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo;

/**
 * @author pindi
 *
 */
public class VerificaPagamentoMarcaDaBolloRisposta extends VerificaPagamentoRisposta {

	private MarcaDaBollo marcaDaBollo;
	private InputStream marcaDaBolloInputStream;

	/**
	 * @return the marcaDaBollo
	 */
	public MarcaDaBollo getMarcaDaBollo() {
		return marcaDaBollo;
	}

	/**
	 * @param marcaDaBollo the marcaDaBollo to set
	 */
	public void setMarcaDaBollo(MarcaDaBollo marcaDaBollo) {
		this.marcaDaBollo = marcaDaBollo;
	}

	/**
	 * @return the marcaDaBolloInputStream
	 */
	public InputStream getMarcaDaBolloInputStream() {
		return marcaDaBolloInputStream;
	}

	/**
	 * @param marcaDaBolloInputStream the marcaDaBolloInputStream to set
	 */
	public void setMarcaDaBolloInputStream(InputStream marcaDaBolloInputStream) {
		this.marcaDaBolloInputStream = marcaDaBolloInputStream;
	}

}
