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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pindi
 * @generated
 */
@Generated("")
@GraphQLName("ChatbotDatiSessione")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ChatbotDatiSessione")
public class ChatbotDatiSessione implements Serializable {

	public static ChatbotDatiSessione toDTO(String json) {
		return ObjectMapperUtil.readValue(ChatbotDatiSessione.class, json);
	}

	public static ChatbotDatiSessione unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			ChatbotDatiSessione.class, json);
	}

	@Schema
	public String getIntentMatched() {
		return intentMatched;
	}

	public void setIntentMatched(String intentMatched) {
		this.intentMatched = intentMatched;
	}

	@JsonIgnore
	public void setIntentMatched(
		UnsafeSupplier<String, Exception> intentMatchedUnsafeSupplier) {

		try {
			intentMatched = intentMatchedUnsafeSupplier.get();
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
	protected String intentMatched;

	@Schema
	public Boolean getIsFallback() {
		return isFallback;
	}

	public void setIsFallback(Boolean isFallback) {
		this.isFallback = isFallback;
	}

	@JsonIgnore
	public void setIsFallback(
		UnsafeSupplier<Boolean, Exception> isFallbackUnsafeSupplier) {

		try {
			isFallback = isFallbackUnsafeSupplier.get();
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
	protected Boolean isFallback;

	@Schema
	public Boolean getIsMatched() {
		return isMatched;
	}

	public void setIsMatched(Boolean isMatched) {
		this.isMatched = isMatched;
	}

	@JsonIgnore
	public void setIsMatched(
		UnsafeSupplier<Boolean, Exception> isMatchedUnsafeSupplier) {

		try {
			isMatched = isMatchedUnsafeSupplier.get();
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
	protected Boolean isMatched;

	@Schema
	public Boolean getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(Boolean isNegative) {
		this.isNegative = isNegative;
	}

	@JsonIgnore
	public void setIsNegative(
		UnsafeSupplier<Boolean, Exception> isNegativeUnsafeSupplier) {

		try {
			isNegative = isNegativeUnsafeSupplier.get();
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
	protected Boolean isNegative;

	@Schema
	public Boolean getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(Boolean isPositive) {
		this.isPositive = isPositive;
	}

	@JsonIgnore
	public void setIsPositive(
		UnsafeSupplier<Boolean, Exception> isPositiveUnsafeSupplier) {

		try {
			isPositive = isPositiveUnsafeSupplier.get();
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
	protected Boolean isPositive;

	@Schema
	public Boolean getIsReset() {
		return isReset;
	}

	public void setIsReset(Boolean isReset) {
		this.isReset = isReset;
	}

	@JsonIgnore
	public void setIsReset(
		UnsafeSupplier<Boolean, Exception> isResetUnsafeSupplier) {

		try {
			isReset = isResetUnsafeSupplier.get();
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
	protected Boolean isReset;

	@Schema
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonIgnore
	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
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
	protected String message;

	@Schema
	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	@JsonIgnore
	public void setMessageDate(
		UnsafeSupplier<Date, Exception> messageDateUnsafeSupplier) {

		try {
			messageDate = messageDateUnsafeSupplier.get();
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
	protected Date messageDate;

	@Schema
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@JsonIgnore
	public void setSessionId(
		UnsafeSupplier<String, Exception> sessionIdUnsafeSupplier) {

		try {
			sessionId = sessionIdUnsafeSupplier.get();
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
	protected String sessionId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatbotDatiSessione)) {
			return false;
		}

		ChatbotDatiSessione chatbotDatiSessione = (ChatbotDatiSessione)object;

		return Objects.equals(toString(), chatbotDatiSessione.toString());
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

		if (intentMatched != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"intentMatched\": ");

			sb.append("\"");

			sb.append(_escape(intentMatched));

			sb.append("\"");
		}

		if (isFallback != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isFallback\": ");

			sb.append(isFallback);
		}

		if (isMatched != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isMatched\": ");

			sb.append(isMatched);
		}

		if (isNegative != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isNegative\": ");

			sb.append(isNegative);
		}

		if (isPositive != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isPositive\": ");

			sb.append(isPositive);
		}

		if (isReset != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isReset\": ");

			sb.append(isReset);
		}

		if (message != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(message));

			sb.append("\"");
		}

		if (messageDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"messageDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(messageDate));

			sb.append("\"");
		}

		if (sessionId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sessionId\": ");

			sb.append("\"");

			sb.append(_escape(sessionId));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "it.servizidigitali.restservice.dto.v1_0.ChatbotDatiSessione",
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