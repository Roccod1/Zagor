package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.DestinazioneUso;
import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.InfoServizioAmministrazioneSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class InfoServizioAmministrazione implements Cloneable, Serializable {

	public static InfoServizioAmministrazione toDTO(String json) {
		return InfoServizioAmministrazioneSerDes.toDTO(json);
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setActive(
		UnsafeSupplier<Boolean, Exception> activeUnsafeSupplier) {

		try {
			active = activeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean active;

	public Boolean getChatbotInline() {
		return chatbotInline;
	}

	public void setChatbotInline(Boolean chatbotInline) {
		this.chatbotInline = chatbotInline;
	}

	public void setChatbotInline(
		UnsafeSupplier<Boolean, Exception> chatbotInlineUnsafeSupplier) {

		try {
			chatbotInline = chatbotInlineUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean chatbotInline;

	public Boolean getChatbotInlineIntent() {
		return chatbotInlineIntent;
	}

	public void setChatbotInlineIntent(Boolean chatbotInlineIntent) {
		this.chatbotInlineIntent = chatbotInlineIntent;
	}

	public void setChatbotInlineIntent(
		UnsafeSupplier<Boolean, Exception> chatbotInlineIntentUnsafeSupplier) {

		try {
			chatbotInlineIntent = chatbotInlineIntentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean chatbotInlineIntent;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCode(UnsafeSupplier<String, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String code;

	public String getCodiceIpa() {
		return codiceIpa;
	}

	public void setCodiceIpa(String codiceIpa) {
		this.codiceIpa = codiceIpa;
	}

	public void setCodiceIpa(
		UnsafeSupplier<String, Exception> codiceIpaUnsafeSupplier) {

		try {
			codiceIpa = codiceIpaUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codiceIpa;

	public String getCorrelatedPaymentServiceCode() {
		return correlatedPaymentServiceCode;
	}

	public void setCorrelatedPaymentServiceCode(
		String correlatedPaymentServiceCode) {

		this.correlatedPaymentServiceCode = correlatedPaymentServiceCode;
	}

	public void setCorrelatedPaymentServiceCode(
		UnsafeSupplier<String, Exception>
			correlatedPaymentServiceCodeUnsafeSupplier) {

		try {
			correlatedPaymentServiceCode =
				correlatedPaymentServiceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String correlatedPaymentServiceCode;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public DestinazioneUso[] getDestinazioneUsos() {
		return destinazioneUsos;
	}

	public void setDestinazioneUsos(DestinazioneUso[] destinazioneUsos) {
		this.destinazioneUsos = destinazioneUsos;
	}

	public void setDestinazioneUsos(
		UnsafeSupplier<DestinazioneUso[], Exception>
			destinazioneUsosUnsafeSupplier) {

		try {
			destinazioneUsos = destinazioneUsosUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected DestinazioneUso[] destinazioneUsos;

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

	public String getNomeComune() {
		return nomeComune;
	}

	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}

	public void setNomeComune(
		UnsafeSupplier<String, Exception> nomeComuneUnsafeSupplier) {

		try {
			nomeComune = nomeComuneUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String nomeComune;

	public String getServiceCardUrl() {
		return serviceCardUrl;
	}

	public void setServiceCardUrl(String serviceCardUrl) {
		this.serviceCardUrl = serviceCardUrl;
	}

	public void setServiceCardUrl(
		UnsafeSupplier<String, Exception> serviceCardUrlUnsafeSupplier) {

		try {
			serviceCardUrl = serviceCardUrlUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String serviceCardUrl;

	public String getServiceOnlineUrl() {
		return serviceOnlineUrl;
	}

	public void setServiceOnlineUrl(String serviceOnlineUrl) {
		this.serviceOnlineUrl = serviceOnlineUrl;
	}

	public void setServiceOnlineUrl(
		UnsafeSupplier<String, Exception> serviceOnlineUrlUnsafeSupplier) {

		try {
			serviceOnlineUrl = serviceOnlineUrlUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String serviceOnlineUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String title;

	public Boolean getUsableByChatbot() {
		return usableByChatbot;
	}

	public void setUsableByChatbot(Boolean usableByChatbot) {
		this.usableByChatbot = usableByChatbot;
	}

	public void setUsableByChatbot(
		UnsafeSupplier<Boolean, Exception> usableByChatbotUnsafeSupplier) {

		try {
			usableByChatbot = usableByChatbotUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean usableByChatbot;

	@Override
	public InfoServizioAmministrazione clone()
		throws CloneNotSupportedException {

		return (InfoServizioAmministrazione)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InfoServizioAmministrazione)) {
			return false;
		}

		InfoServizioAmministrazione infoServizioAmministrazione =
			(InfoServizioAmministrazione)object;

		return Objects.equals(
			toString(), infoServizioAmministrazione.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return InfoServizioAmministrazioneSerDes.toJSON(this);
	}

}