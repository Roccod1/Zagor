package it.servizidigitali.gestionepagamenti.integration.common.client.model;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pindi
 *
 */
public class VerificaPagamentoMarcaDaBolloRisposta extends VerificaPagamentoRisposta {

	private String iubd;
	private Date oraAcquisto;
	private BigDecimal importo;
	private String tipo;
	private ImprontaDocumento improntaDocumento;
	private PSP psp;
	private InputStream marcaDaBollo;

	public class PSP {

		private String codiceFiscale;
		private String denominazione;

		/**
		 * @return the codiceFiscale
		 */
		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		/**
		 * @param codiceFiscale the codiceFiscale to set
		 */
		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		/**
		 * @return the denominazione
		 */
		public String getDenominazione() {
			return denominazione;
		}

		/**
		 * @param denominazione the denominazione to set
		 */
		public void setDenominazione(String denominazione) {
			this.denominazione = denominazione;
		}

	}

	public class ImprontaDocumento {

		private String algoritmo;
		private byte[] valore;

		/**
		 * @return the algoritmo
		 */
		public String getAlgoritmo() {
			return algoritmo;
		}

		/**
		 * @param algoritmo the algoritmo to set
		 */
		public void setAlgoritmo(String algoritmo) {
			this.algoritmo = algoritmo;
		}

		/**
		 * @return the valore
		 */
		public byte[] getValore() {
			return valore;
		}

		/**
		 * @param valore the valore to set
		 */
		public void setValore(byte[] valore) {
			this.valore = valore;
		}

	}

	/**
	 * @return the iubd
	 */
	public String getIubd() {
		return iubd;
	}

	/**
	 * @param iubd the iubd to set
	 */
	public void setIubd(String iubd) {
		this.iubd = iubd;
	}

	/**
	 * @return the oraAcquisto
	 */
	public Date getOraAcquisto() {
		return oraAcquisto;
	}

	/**
	 * @param oraAcquisto the oraAcquisto to set
	 */
	public void setOraAcquisto(Date oraAcquisto) {
		this.oraAcquisto = oraAcquisto;
	}

	/**
	 * @return the importo
	 */
	public BigDecimal getImporto() {
		return importo;
	}

	/**
	 * @param importo the importo to set
	 */
	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the improntaDocumento
	 */
	public ImprontaDocumento getImprontaDocumento() {
		return improntaDocumento;
	}

	/**
	 * @param improntaDocumento the improntaDocumento to set
	 */
	public void setImprontaDocumento(ImprontaDocumento improntaDocumento) {
		this.improntaDocumento = improntaDocumento;
	}

	/**
	 * @return the psp
	 */
	public PSP getPsp() {
		return psp;
	}

	/**
	 * @param psp the psp to set
	 */
	public void setPsp(PSP psp) {
		this.psp = psp;
	}

	/**
	 * @return the marcaDaBollo
	 */
	public InputStream getMarcaDaBollo() {
		return marcaDaBollo;
	}

	/**
	 * @param marcaDaBollo the marcaDaBollo to set
	 */
	public void setMarcaDaBollo(InputStream marcaDaBollo) {
		this.marcaDaBollo = marcaDaBollo;
	}

}
