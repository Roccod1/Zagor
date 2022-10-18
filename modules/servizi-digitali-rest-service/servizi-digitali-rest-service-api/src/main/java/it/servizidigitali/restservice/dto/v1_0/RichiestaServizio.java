package it.servizidigitali.restservice.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pindi
 * @generated
 */
@Generated("")
@GraphQLName("RichiestaServizio")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "RichiestaServizio")
public class RichiestaServizio implements Serializable {

	public static RichiestaServizio toDTO(String json) {
		return ObjectMapperUtil.readValue(RichiestaServizio.class, json);
	}

	public static RichiestaServizio unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(RichiestaServizio.class, json);
	}

	@Schema
	public String getCodiceAreaTematica() {
		return codiceAreaTematica;
	}

	public void setCodiceAreaTematica(String codiceAreaTematica) {
		this.codiceAreaTematica = codiceAreaTematica;
	}

	@JsonIgnore
	public void setCodiceAreaTematica(
		UnsafeSupplier<String, Exception> codiceAreaTematicaUnsafeSupplier) {

		try {
			codiceAreaTematica = codiceAreaTematicaUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String codiceAreaTematica;

	@Schema(description = "Codice Fiscale delegato")
	public String getCodiceFiscaleDelegato() {
		return codiceFiscaleDelegato;
	}

	public void setCodiceFiscaleDelegato(String codiceFiscaleDelegato) {
		this.codiceFiscaleDelegato = codiceFiscaleDelegato;
	}

	@JsonIgnore
	public void setCodiceFiscaleDelegato(
		UnsafeSupplier<String, Exception> codiceFiscaleDelegatoUnsafeSupplier) {

		try {
			codiceFiscaleDelegato = codiceFiscaleDelegatoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Codice Fiscale delegato")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String codiceFiscaleDelegato;

	@Schema(description = "Codice Fiscale richiedente")
	public String getCodiceFiscaleRichiedente() {
		return codiceFiscaleRichiedente;
	}

	public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
		this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
	}

	@JsonIgnore
	public void setCodiceFiscaleRichiedente(
		UnsafeSupplier<String, Exception>
			codiceFiscaleRichiedenteUnsafeSupplier) {

		try {
			codiceFiscaleRichiedente =
				codiceFiscaleRichiedenteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Codice Fiscale richiedente")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String codiceFiscaleRichiedente;

	@Schema
	public String getCodiceIdentificativoServizio() {
		return codiceIdentificativoServizio;
	}

	public void setCodiceIdentificativoServizio(
		String codiceIdentificativoServizio) {

		this.codiceIdentificativoServizio = codiceIdentificativoServizio;
	}

	@JsonIgnore
	public void setCodiceIdentificativoServizio(
		UnsafeSupplier<String, Exception>
			codiceIdentificativoServizioUnsafeSupplier) {

		try {
			codiceIdentificativoServizio =
				codiceIdentificativoServizioUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String codiceIdentificativoServizio;

	@Schema(description = "Data aggiornamento")
	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	@JsonIgnore
	public void setDataAggiornamento(
		UnsafeSupplier<Date, Exception> dataAggiornamentoUnsafeSupplier) {

		try {
			dataAggiornamento = dataAggiornamentoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Data aggiornamento")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dataAggiornamento;

	@Schema(description = "Data inserimento")
	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	@JsonIgnore
	public void setDataInserimento(
		UnsafeSupplier<Date, Exception> dataInserimentoUnsafeSupplier) {

		try {
			dataInserimento = dataInserimentoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Data inserimento")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dataInserimento;

	@Schema(description = "Data protocollo")
	public Date getDataProtocollo() {
		return dataProtocollo;
	}

	public void setDataProtocollo(Date dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}

	@JsonIgnore
	public void setDataProtocollo(
		UnsafeSupplier<Date, Exception> dataProtocolloUnsafeSupplier) {

		try {
			dataProtocollo = dataProtocolloUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Data protocollo")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dataProtocollo;

	@Schema(description = "Data protocollo esterno")
	public Date getDataProtocolloEsterno() {
		return dataProtocolloEsterno;
	}

	public void setDataProtocolloEsterno(Date dataProtocolloEsterno) {
		this.dataProtocolloEsterno = dataProtocolloEsterno;
	}

	@JsonIgnore
	public void setDataProtocolloEsterno(
		UnsafeSupplier<Date, Exception> dataProtocolloEsternoUnsafeSupplier) {

		try {
			dataProtocolloEsterno = dataProtocolloEsternoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Data protocollo esterno")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dataProtocolloEsterno;

	@Schema
	public String getDenominazioneAreaTematica() {
		return denominazioneAreaTematica;
	}

	public void setDenominazioneAreaTematica(String denominazioneAreaTematica) {
		this.denominazioneAreaTematica = denominazioneAreaTematica;
	}

	@JsonIgnore
	public void setDenominazioneAreaTematica(
		UnsafeSupplier<String, Exception>
			denominazioneAreaTematicaUnsafeSupplier) {

		try {
			denominazioneAreaTematica =
				denominazioneAreaTematicaUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String denominazioneAreaTematica;

	@Schema
	public String getDenominazioneEnte() {
		return denominazioneEnte;
	}

	public void setDenominazioneEnte(String denominazioneEnte) {
		this.denominazioneEnte = denominazioneEnte;
	}

	@JsonIgnore
	public void setDenominazioneEnte(
		UnsafeSupplier<String, Exception> denominazioneEnteUnsafeSupplier) {

		try {
			denominazioneEnte = denominazioneEnteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String denominazioneEnte;

	@Schema(description = "Denominazione richiedente")
	public String getDenominazioneRichiedente() {
		return denominazioneRichiedente;
	}

	public void setDenominazioneRichiedente(String denominazioneRichiedente) {
		this.denominazioneRichiedente = denominazioneRichiedente;
	}

	@JsonIgnore
	public void setDenominazioneRichiedente(
		UnsafeSupplier<String, Exception>
			denominazioneRichiedenteUnsafeSupplier) {

		try {
			denominazioneRichiedente =
				denominazioneRichiedenteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Denominazione richiedente")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String denominazioneRichiedente;

	@Schema
	public String getDenominazioneServizio() {
		return denominazioneServizio;
	}

	public void setDenominazioneServizio(String denominazioneServizio) {
		this.denominazioneServizio = denominazioneServizio;
	}

	@JsonIgnore
	public void setDenominazioneServizio(
		UnsafeSupplier<String, Exception> denominazioneServizioUnsafeSupplier) {

		try {
			denominazioneServizio = denominazioneServizioUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String denominazioneServizio;

	@Schema(description = "Email richiedente")
	public String getEmailRichiedente() {
		return emailRichiedente;
	}

	public void setEmailRichiedente(String emailRichiedente) {
		this.emailRichiedente = emailRichiedente;
	}

	@JsonIgnore
	public void setEmailRichiedente(
		UnsafeSupplier<String, Exception> emailRichiedenteUnsafeSupplier) {

		try {
			emailRichiedente = emailRichiedenteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Email richiedente")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String emailRichiedente;

	@Schema(description = "Id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Id")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long id;

	@Schema
	@Valid
	public Number getIdProcedura() {
		return idProcedura;
	}

	public void setIdProcedura(Number idProcedura) {
		this.idProcedura = idProcedura;
	}

	@JsonIgnore
	public void setIdProcedura(
		UnsafeSupplier<Number, Exception> idProceduraUnsafeSupplier) {

		try {
			idProcedura = idProceduraUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Number idProcedura;

	@Schema
	public String getIdentificativoEnte() {
		return identificativoEnte;
	}

	public void setIdentificativoEnte(String identificativoEnte) {
		this.identificativoEnte = identificativoEnte;
	}

	@JsonIgnore
	public void setIdentificativoEnte(
		UnsafeSupplier<String, Exception> identificativoEnteUnsafeSupplier) {

		try {
			identificativoEnte = identificativoEnteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String identificativoEnte;

	@Schema
	public String getIdentificativoProcesso() {
		return identificativoProcesso;
	}

	public void setIdentificativoProcesso(String identificativoProcesso) {
		this.identificativoProcesso = identificativoProcesso;
	}

	@JsonIgnore
	public void setIdentificativoProcesso(
		UnsafeSupplier<String, Exception>
			identificativoProcessoUnsafeSupplier) {

		try {
			identificativoProcesso = identificativoProcessoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String identificativoProcesso;

	@Schema(description = "Note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@JsonIgnore
	public void setNote(UnsafeSupplier<String, Exception> noteUnsafeSupplier) {
		try {
			note = noteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Note")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String note;

	@Schema(description = "Numero protocollo")
	public String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	public void setNumeroProtocollo(String numeroProtocollo) {
		this.numeroProtocollo = numeroProtocollo;
	}

	@JsonIgnore
	public void setNumeroProtocollo(
		UnsafeSupplier<String, Exception> numeroProtocolloUnsafeSupplier) {

		try {
			numeroProtocollo = numeroProtocolloUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Numero protocollo")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String numeroProtocollo;

	@Schema(description = "Numero protocollo esterno")
	public String getNumeroProtocolloEsterno() {
		return numeroProtocolloEsterno;
	}

	public void setNumeroProtocolloEsterno(String numeroProtocolloEsterno) {
		this.numeroProtocolloEsterno = numeroProtocolloEsterno;
	}

	@JsonIgnore
	public void setNumeroProtocolloEsterno(
		UnsafeSupplier<String, Exception>
			numeroProtocolloEsternoUnsafeSupplier) {

		try {
			numeroProtocolloEsterno =
				numeroProtocolloEsternoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Numero protocollo esterno")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String numeroProtocolloEsterno;

	@Schema(description = "Oggetto")
	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	@JsonIgnore
	public void setOggetto(
		UnsafeSupplier<String, Exception> oggettoUnsafeSupplier) {

		try {
			oggetto = oggettoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Oggetto")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String oggetto;

	@Schema(description = "PIVA richiedente")
	public String getPartitaIvaRichiedente() {
		return partitaIvaRichiedente;
	}

	public void setPartitaIvaRichiedente(String partitaIvaRichiedente) {
		this.partitaIvaRichiedente = partitaIvaRichiedente;
	}

	@JsonIgnore
	public void setPartitaIvaRichiedente(
		UnsafeSupplier<String, Exception> partitaIvaRichiedenteUnsafeSupplier) {

		try {
			partitaIvaRichiedente = partitaIvaRichiedenteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "PIVA richiedente")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String partitaIvaRichiedente;

	@Schema(description = "Stato")
	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	@JsonIgnore
	public void setStato(
		UnsafeSupplier<String, Exception> statoUnsafeSupplier) {

		try {
			stato = statoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Stato")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String stato;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (codiceAreaTematica != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceAreaTematica\": ");

			sb.append("\"");

			sb.append(_escape(codiceAreaTematica));

			sb.append("\"");
		}

		if (codiceFiscaleDelegato != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceFiscaleDelegato\": ");

			sb.append("\"");

			sb.append(_escape(codiceFiscaleDelegato));

			sb.append("\"");
		}

		if (codiceFiscaleRichiedente != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceFiscaleRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(codiceFiscaleRichiedente));

			sb.append("\"");
		}

		if (codiceIdentificativoServizio != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceIdentificativoServizio\": ");

			sb.append("\"");

			sb.append(_escape(codiceIdentificativoServizio));

			sb.append("\"");
		}

		if (dataAggiornamento != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataAggiornamento\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dataAggiornamento));

			sb.append("\"");
		}

		if (dataInserimento != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataInserimento\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dataInserimento));

			sb.append("\"");
		}

		if (dataProtocollo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataProtocollo\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dataProtocollo));

			sb.append("\"");
		}

		if (dataProtocolloEsterno != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataProtocolloEsterno\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dataProtocolloEsterno));

			sb.append("\"");
		}

		if (denominazioneAreaTematica != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneAreaTematica\": ");

			sb.append("\"");

			sb.append(_escape(denominazioneAreaTematica));

			sb.append("\"");
		}

		if (denominazioneEnte != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneEnte\": ");

			sb.append("\"");

			sb.append(_escape(denominazioneEnte));

			sb.append("\"");
		}

		if (denominazioneRichiedente != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(denominazioneRichiedente));

			sb.append("\"");
		}

		if (denominazioneServizio != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneServizio\": ");

			sb.append("\"");

			sb.append(_escape(denominazioneServizio));

			sb.append("\"");
		}

		if (emailRichiedente != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(emailRichiedente));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (idProcedura != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"idProcedura\": ");

			sb.append(idProcedura);
		}

		if (identificativoEnte != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"identificativoEnte\": ");

			sb.append("\"");

			sb.append(_escape(identificativoEnte));

			sb.append("\"");
		}

		if (identificativoProcesso != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"identificativoProcesso\": ");

			sb.append("\"");

			sb.append(_escape(identificativoProcesso));

			sb.append("\"");
		}

		if (note != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"note\": ");

			sb.append("\"");

			sb.append(_escape(note));

			sb.append("\"");
		}

		if (numeroProtocollo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"numeroProtocollo\": ");

			sb.append("\"");

			sb.append(_escape(numeroProtocollo));

			sb.append("\"");
		}

		if (numeroProtocolloEsterno != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"numeroProtocolloEsterno\": ");

			sb.append("\"");

			sb.append(_escape(numeroProtocolloEsterno));

			sb.append("\"");
		}

		if (oggetto != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"oggetto\": ");

			sb.append("\"");

			sb.append(_escape(oggetto));

			sb.append("\"");
		}

		if (partitaIvaRichiedente != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"partitaIvaRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(partitaIvaRichiedente));

			sb.append("\"");
		}

		if (stato != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stato\": ");

			sb.append("\"");

			sb.append(_escape(stato));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "it.servizidigitali.restservice.dto.v1_0.RichiestaServizio",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}