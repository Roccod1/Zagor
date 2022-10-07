package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.RichiestaServizioSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class RichiestaServizio implements Cloneable, Serializable {

	public static RichiestaServizio toDTO(String json) {
		return RichiestaServizioSerDes.toDTO(json);
	}

	public String getCodiceAreaTematica() {
		return codiceAreaTematica;
	}

	public void setCodiceAreaTematica(String codiceAreaTematica) {
		this.codiceAreaTematica = codiceAreaTematica;
	}

	public void setCodiceAreaTematica(
		UnsafeSupplier<String, Exception> codiceAreaTematicaUnsafeSupplier) {

		try {
			codiceAreaTematica = codiceAreaTematicaUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codiceAreaTematica;

	public String getCodiceFiscaleDelegato() {
		return codiceFiscaleDelegato;
	}

	public void setCodiceFiscaleDelegato(String codiceFiscaleDelegato) {
		this.codiceFiscaleDelegato = codiceFiscaleDelegato;
	}

	public void setCodiceFiscaleDelegato(
		UnsafeSupplier<String, Exception> codiceFiscaleDelegatoUnsafeSupplier) {

		try {
			codiceFiscaleDelegato = codiceFiscaleDelegatoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codiceFiscaleDelegato;

	public String getCodiceFiscaleRichiedente() {
		return codiceFiscaleRichiedente;
	}

	public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
		this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
	}

	public void setCodiceFiscaleRichiedente(
		UnsafeSupplier<String, Exception>
			codiceFiscaleRichiedenteUnsafeSupplier) {

		try {
			codiceFiscaleRichiedente =
				codiceFiscaleRichiedenteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codiceFiscaleRichiedente;

	public String getCodiceIdentificativoServizio() {
		return codiceIdentificativoServizio;
	}

	public void setCodiceIdentificativoServizio(
		String codiceIdentificativoServizio) {

		this.codiceIdentificativoServizio = codiceIdentificativoServizio;
	}

	public void setCodiceIdentificativoServizio(
		UnsafeSupplier<String, Exception>
			codiceIdentificativoServizioUnsafeSupplier) {

		try {
			codiceIdentificativoServizio =
				codiceIdentificativoServizioUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codiceIdentificativoServizio;

	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public void setDataAggiornamento(
		UnsafeSupplier<Date, Exception> dataAggiornamentoUnsafeSupplier) {

		try {
			dataAggiornamento = dataAggiornamentoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dataAggiornamento;

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public void setDataInserimento(
		UnsafeSupplier<Date, Exception> dataInserimentoUnsafeSupplier) {

		try {
			dataInserimento = dataInserimentoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dataInserimento;

	public Date getDataProtocollo() {
		return dataProtocollo;
	}

	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}

	public void setDataProtocollo(
		UnsafeSupplier<Date, Exception> dataProtocolloUnsafeSupplier) {

		try {
			dataProtocollo = dataProtocolloUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dataProtocollo;

	public Date getDataProtocolloEsterno() {
		return dataProtocolloEsterno;
	}

	public void setDataProtocolloEsterno(Date dataProtocolloEsterno) {
		this.dataProtocolloEsterno = dataProtocolloEsterno;
	}

	public void setDataProtocolloEsterno(
		UnsafeSupplier<Date, Exception> dataProtocolloEsternoUnsafeSupplier) {

		try {
			dataProtocolloEsterno = dataProtocolloEsternoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dataProtocolloEsterno;

	public String getDenominazioneAreaTematica() {
		return denominazioneAreaTematica;
	}

	public void setDenominazioneAreaTematica(String denominazioneAreaTematica) {
		this.denominazioneAreaTematica = denominazioneAreaTematica;
	}

	public void setDenominazioneAreaTematica(
		UnsafeSupplier<String, Exception>
			denominazioneAreaTematicaUnsafeSupplier) {

		try {
			denominazioneAreaTematica =
				denominazioneAreaTematicaUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String denominazioneAreaTematica;

	public String getDenominazioneEnte() {
		return denominazioneEnte;
	}

	public void setDenominazioneEnte(String denominazioneEnte) {
		this.denominazioneEnte = denominazioneEnte;
	}

	public void setDenominazioneEnte(
		UnsafeSupplier<String, Exception> denominazioneEnteUnsafeSupplier) {

		try {
			denominazioneEnte = denominazioneEnteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String denominazioneEnte;

	public String getDenominazioneRichiedente() {
		return denominazioneRichiedente;
	}

	public void setDenominazioneRichiedente(String denominazioneRichiedente) {
		this.denominazioneRichiedente = denominazioneRichiedente;
	}

	public void setDenominazioneRichiedente(
		UnsafeSupplier<String, Exception>
			denominazioneRichiedenteUnsafeSupplier) {

		try {
			denominazioneRichiedente =
				denominazioneRichiedenteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String denominazioneRichiedente;

	public String getDenominazioneServizio() {
		return denominazioneServizio;
	}

	public void setDenominazioneServizio(String denominazioneServizio) {
		this.denominazioneServizio = denominazioneServizio;
	}

	public void setDenominazioneServizio(
		UnsafeSupplier<String, Exception> denominazioneServizioUnsafeSupplier) {

		try {
			denominazioneServizio = denominazioneServizioUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String denominazioneServizio;

	public String getEmailRichiedente() {
		return emailRichiedente;
	}

	public void setEmailRichiedente(String emailRichiedente) {
		this.emailRichiedente = emailRichiedente;
	}

	public void setEmailRichiedente(
		UnsafeSupplier<String, Exception> emailRichiedenteUnsafeSupplier) {

		try {
			emailRichiedente = emailRichiedenteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String emailRichiedente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public Number getIdProcedura() {
		return idProcedura;
	}

	public void setIdProcedura(Number idProcedura) {
		this.idProcedura = idProcedura;
	}

	public void setIdProcedura(
		UnsafeSupplier<Number, Exception> idProceduraUnsafeSupplier) {

		try {
			idProcedura = idProceduraUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Number idProcedura;

	public String getIdentificativoEnte() {
		return identificativoEnte;
	}

	public void setIdentificativoEnte(String identificativoEnte) {
		this.identificativoEnte = identificativoEnte;
	}

	public void setIdentificativoEnte(
		UnsafeSupplier<String, Exception> identificativoEnteUnsafeSupplier) {

		try {
			identificativoEnte = identificativoEnteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String identificativoEnte;

	public String getIdentificativoProcesso() {
		return identificativoProcesso;
	}

	public void setIdentificativoProcesso(String identificativoProcesso) {
		this.identificativoProcesso = identificativoProcesso;
	}

	public void setIdentificativoProcesso(
		UnsafeSupplier<String, Exception>
			identificativoProcessoUnsafeSupplier) {

		try {
			identificativoProcesso = identificativoProcessoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String identificativoProcesso;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setNote(UnsafeSupplier<String, Exception> noteUnsafeSupplier) {
		try {
			note = noteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String note;

	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	public void setNumeroProtocollo(
		UnsafeSupplier<String, Exception> numeroProtocolloUnsafeSupplier) {

		try {
			numeroProtocollo = numeroProtocolloUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String numeroProtocollo;

	public String getNumeroProtocolloEsterno() {
		return numeroProtocolloEsterno;
	}

	public void setNumeroProtocolloEsterno(String numeroProtocolloEsterno) {
		this.numeroProtocolloEsterno = numeroProtocolloEsterno;
	}

	public void setNumeroProtocolloEsterno(
		UnsafeSupplier<String, Exception>
			numeroProtocolloEsternoUnsafeSupplier) {

		try {
			numeroProtocolloEsterno =
				numeroProtocolloEsternoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String numeroProtocolloEsterno;

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public void setOggetto(
		UnsafeSupplier<String, Exception> oggettoUnsafeSupplier) {

		try {
			oggetto = oggettoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String oggetto;

	public String getPartitaIvaRichiedente() {
		return partitaIvaRichiedente;
	}

	public void setPartitaIvaRichiedente(String partitaIvaRichiedente) {
		this.partitaIvaRichiedente = partitaIvaRichiedente;
	}

	public void setPartitaIvaRichiedente(
		UnsafeSupplier<String, Exception> partitaIvaRichiedenteUnsafeSupplier) {

		try {
			partitaIvaRichiedente = partitaIvaRichiedenteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String partitaIvaRichiedente;

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public void setStato(
		UnsafeSupplier<String, Exception> statoUnsafeSupplier) {

		try {
			stato = statoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String stato;

	@Override
	public RichiestaServizio clone() throws CloneNotSupportedException {
		return (RichiestaServizio)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RichiestaServizio)) {
			return false;
		}

		RichiestaServizio richiestaServizio = (RichiestaServizio)object;

		return Objects.equals(toString(), richiestaServizio.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return RichiestaServizioSerDes.toJSON(this);
	}

}