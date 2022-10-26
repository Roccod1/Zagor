package it.servizidigitali.gestionepagamenti.integration.common.client.model;

import it.servizidigitali.gestionepagamenti.integration.common.model.MarcaDaBollo;

/**
 * @author pindi
 *
 */
public class VerificaPagamentoMarcaDaBolloRisposta extends VerificaPagamentoRisposta {

	private MarcaDaBollo marcaDaBollo;
	private byte[] marcaDaBolloBytes;

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
	 * @return the marcaDaBolloBytes
	 */
	public byte[] getMarcaDaBolloBytes() {
		return marcaDaBolloBytes;
	}

	/**
	 * @param marcaDaBolloBytes the marcaDaBolloBytes to set
	 */
	public void setMarcaDaBolloBytes(byte[] marcaDaBolloBytes) {
		this.marcaDaBolloBytes = marcaDaBolloBytes;
	}
}
