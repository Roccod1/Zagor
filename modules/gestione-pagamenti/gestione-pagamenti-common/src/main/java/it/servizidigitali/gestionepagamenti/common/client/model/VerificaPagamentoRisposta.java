package it.servizidigitali.gestionepagamenti.common.client.model;

import java.io.InputStream;

import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;

public class VerificaPagamentoRisposta {
	private String codiceIuv;
	private StatoPagamento statoPagamento;
	private String idRichiesta;
	private String codiceErrore;
	private String descrizioneErrore;
	private InputStream ricevutaPagamento;

	public String getCodiceIuv() {
		return codiceIuv;
	}

	public void setCodiceIuv(String codiceIuv) {
		this.codiceIuv = codiceIuv;
	}

	public StatoPagamento getStatoPagamento() {
		return statoPagamento;
	}

	public void setStatoPagamento(StatoPagamento statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getCodiceErrore() {
		return codiceErrore;
	}

	public void setCodiceErrore(String codiceErrore) {
		this.codiceErrore = codiceErrore;
	}

	public String getDescrizioneErrore() {
		return descrizioneErrore;
	}

	public void setDescrizioneErrore(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}

	public InputStream getRicevutaPagamento() {
		return ricevutaPagamento;
	}

	public void setRicevutaPagamento(InputStream ricevutaPagamento) {
		this.ricevutaPagamento = ricevutaPagamento;
	}

}
