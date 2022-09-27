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
@GraphQLName("InfoServizioAmministrazione")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "InfoServizioAmministrazione")
public class InfoServizioAmministrazione implements Serializable {

	public static InfoServizioAmministrazione toDTO(String json) {
		return ObjectMapperUtil.readValue(
			InfoServizioAmministrazione.class, json);
	}

	public static InfoServizioAmministrazione unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			InfoServizioAmministrazione.class, json);
	}

	@Schema
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@JsonIgnore
	public void setActive(
		UnsafeSupplier<Boolean, Exception> activeUnsafeSupplier) {

		try {
			active = activeUnsafeSupplier.get();
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
	protected Boolean active;

	@Schema
	public Boolean getChatbotInline() {
		return chatbotInline;
	}

	public void setChatbotInline(Boolean chatbotInline) {
		this.chatbotInline = chatbotInline;
	}

	@JsonIgnore
	public void setChatbotInline(
		UnsafeSupplier<Boolean, Exception> chatbotInlineUnsafeSupplier) {

		try {
			chatbotInline = chatbotInlineUnsafeSupplier.get();
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
	protected Boolean chatbotInline;

	@Schema
	public Boolean getChatbotInlineIntent() {
		return chatbotInlineIntent;
	}

	public void setChatbotInlineIntent(Boolean chatbotInlineIntent) {
		this.chatbotInlineIntent = chatbotInlineIntent;
	}

	@JsonIgnore
	public void setChatbotInlineIntent(
		UnsafeSupplier<Boolean, Exception> chatbotInlineIntentUnsafeSupplier) {

		try {
			chatbotInlineIntent = chatbotInlineIntentUnsafeSupplier.get();
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
	protected Boolean chatbotInlineIntent;

	@Schema(description = "Codice del servizio")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonIgnore
	public void setCode(UnsafeSupplier<String, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Codice del servizio")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String code;

	@Schema
	public String getCodiceIpa() {
		return codiceIpa;
	}

	public void setCodiceIpa(String codiceIpa) {
		this.codiceIpa = codiceIpa;
	}

	@JsonIgnore
	public void setCodiceIpa(
		UnsafeSupplier<String, Exception> codiceIpaUnsafeSupplier) {

		try {
			codiceIpa = codiceIpaUnsafeSupplier.get();
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
	protected String codiceIpa;

	@Schema
	public String getCorrelatedPaymentServiceCode() {
		return correlatedPaymentServiceCode;
	}

	public void setCorrelatedPaymentServiceCode(
		String correlatedPaymentServiceCode) {

		this.correlatedPaymentServiceCode = correlatedPaymentServiceCode;
	}

	@JsonIgnore
	public void setCorrelatedPaymentServiceCode(
		UnsafeSupplier<String, Exception>
			correlatedPaymentServiceCodeUnsafeSupplier) {

		try {
			correlatedPaymentServiceCode =
				correlatedPaymentServiceCodeUnsafeSupplier.get();
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
	protected String correlatedPaymentServiceCode;

	@Schema(description = "Descrizione del servizio")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Descrizione del servizio")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String description;

	@Schema
	@Valid
	public DestinazioneUso[] getDestinazioneUsos() {
		return destinazioneUsos;
	}

	public void setDestinazioneUsos(DestinazioneUso[] destinazioneUsos) {
		this.destinazioneUsos = destinazioneUsos;
	}

	@JsonIgnore
	public void setDestinazioneUsos(
		UnsafeSupplier<DestinazioneUso[], Exception>
			destinazioneUsosUnsafeSupplier) {

		try {
			destinazioneUsos = destinazioneUsosUnsafeSupplier.get();
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
	protected DestinazioneUso[] destinazioneUsos;

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
	public String getNomeComune() {
		return nomeComune;
	}

	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}

	@JsonIgnore
	public void setNomeComune(
		UnsafeSupplier<String, Exception> nomeComuneUnsafeSupplier) {

		try {
			nomeComune = nomeComuneUnsafeSupplier.get();
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
	protected String nomeComune;

	@Schema(description = "Service card url")
	public String getServiceCardUrl() {
		return serviceCardUrl;
	}

	public void setServiceCardUrl(String serviceCardUrl) {
		this.serviceCardUrl = serviceCardUrl;
	}

	@JsonIgnore
	public void setServiceCardUrl(
		UnsafeSupplier<String, Exception> serviceCardUrlUnsafeSupplier) {

		try {
			serviceCardUrl = serviceCardUrlUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Service card url")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String serviceCardUrl;

	@Schema(description = "service online url")
	public String getServiceOnlineUrl() {
		return serviceOnlineUrl;
	}

	public void setServiceOnlineUrl(String serviceOnlineUrl) {
		this.serviceOnlineUrl = serviceOnlineUrl;
	}

	@JsonIgnore
	public void setServiceOnlineUrl(
		UnsafeSupplier<String, Exception> serviceOnlineUrlUnsafeSupplier) {

		try {
			serviceOnlineUrl = serviceOnlineUrlUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "service online url")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String serviceOnlineUrl;

	@Schema(description = "Titolo servizio")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Titolo servizio")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String title;

	@Schema
	public Boolean getUsableByChatbot() {
		return usableByChatbot;
	}

	public void setUsableByChatbot(Boolean usableByChatbot) {
		this.usableByChatbot = usableByChatbot;
	}

	@JsonIgnore
	public void setUsableByChatbot(
		UnsafeSupplier<Boolean, Exception> usableByChatbotUnsafeSupplier) {

		try {
			usableByChatbot = usableByChatbotUnsafeSupplier.get();
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
	protected Boolean usableByChatbot;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (active != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"active\": ");

			sb.append(active);
		}

		if (chatbotInline != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chatbotInline\": ");

			sb.append(chatbotInline);
		}

		if (chatbotInlineIntent != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chatbotInlineIntent\": ");

			sb.append(chatbotInlineIntent);
		}

		if (code != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(code));

			sb.append("\"");
		}

		if (codiceIpa != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceIpa\": ");

			sb.append("\"");

			sb.append(_escape(codiceIpa));

			sb.append("\"");
		}

		if (correlatedPaymentServiceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"correlatedPaymentServiceCode\": ");

			sb.append("\"");

			sb.append(_escape(correlatedPaymentServiceCode));

			sb.append("\"");
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (destinazioneUsos != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"destinazioneUsos\": ");

			sb.append("[");

			for (int i = 0; i < destinazioneUsos.length; i++) {
				sb.append(String.valueOf(destinazioneUsos[i]));

				if ((i + 1) < destinazioneUsos.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (nomeComune != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nomeComune\": ");

			sb.append("\"");

			sb.append(_escape(nomeComune));

			sb.append("\"");
		}

		if (serviceCardUrl != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceCardUrl\": ");

			sb.append("\"");

			sb.append(_escape(serviceCardUrl));

			sb.append("\"");
		}

		if (serviceOnlineUrl != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceOnlineUrl\": ");

			sb.append("\"");

			sb.append(_escape(serviceOnlineUrl));

			sb.append("\"");
		}

		if (title != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(title));

			sb.append("\"");
		}

		if (usableByChatbot != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"usableByChatbot\": ");

			sb.append(usableByChatbot);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "it.servizidigitali.restservice.dto.v1_0.InfoServizioAmministrazione",
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