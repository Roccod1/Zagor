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
@GraphQLName("ChatbotSession")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ChatbotSession")
public class ChatbotSession implements Serializable {

	public static ChatbotSession toDTO(String json) {
		return ObjectMapperUtil.readValue(ChatbotSession.class, json);
	}

	public static ChatbotSession unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(ChatbotSession.class, json);
	}

	@Schema
	public Integer getFallbackCount() {
		return fallbackCount;
	}

	public void setFallbackCount(Integer fallbackCount) {
		this.fallbackCount = fallbackCount;
	}

	@JsonIgnore
	public void setFallbackCount(
		UnsafeSupplier<Integer, Exception> fallbackCountUnsafeSupplier) {

		try {
			fallbackCount = fallbackCountUnsafeSupplier.get();
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
	protected Integer fallbackCount;

	@Schema
	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	@JsonIgnore
	public void setLastDate(
		UnsafeSupplier<Date, Exception> lastDateUnsafeSupplier) {

		try {
			lastDate = lastDateUnsafeSupplier.get();
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
	protected Date lastDate;

	@Schema
	public String getLastIntentMatched() {
		return lastIntentMatched;
	}

	public void setLastIntentMatched(String lastIntentMatched) {
		this.lastIntentMatched = lastIntentMatched;
	}

	@JsonIgnore
	public void setLastIntentMatched(
		UnsafeSupplier<String, Exception> lastIntentMatchedUnsafeSupplier) {

		try {
			lastIntentMatched = lastIntentMatchedUnsafeSupplier.get();
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
	protected String lastIntentMatched;

	@Schema
	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	@JsonIgnore
	public void setLastMessage(
		UnsafeSupplier<String, Exception> lastMessageUnsafeSupplier) {

		try {
			lastMessage = lastMessageUnsafeSupplier.get();
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
	protected String lastMessage;

	@Schema
	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	@JsonIgnore
	public void setMessageCount(
		UnsafeSupplier<Integer, Exception> messageCountUnsafeSupplier) {

		try {
			messageCount = messageCountUnsafeSupplier.get();
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
	protected Integer messageCount;

	@Schema
	public Integer getNegativeCount() {
		return negativeCount;
	}

	public void setNegativeCount(Integer negativeCount) {
		this.negativeCount = negativeCount;
	}

	@JsonIgnore
	public void setNegativeCount(
		UnsafeSupplier<Integer, Exception> negativeCountUnsafeSupplier) {

		try {
			negativeCount = negativeCountUnsafeSupplier.get();
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
	protected Integer negativeCount;

	@Schema
	public Integer getPositiveCount() {
		return positiveCount;
	}

	public void setPositiveCount(Integer positiveCount) {
		this.positiveCount = positiveCount;
	}

	@JsonIgnore
	public void setPositiveCount(
		UnsafeSupplier<Integer, Exception> positiveCountUnsafeSupplier) {

		try {
			positiveCount = positiveCountUnsafeSupplier.get();
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
	protected Integer positiveCount;

	@Schema
	public Integer getResetCount() {
		return resetCount;
	}

	public void setResetCount(Integer resetCount) {
		this.resetCount = resetCount;
	}

	@JsonIgnore
	public void setResetCount(
		UnsafeSupplier<Integer, Exception> resetCountUnsafeSupplier) {

		try {
			resetCount = resetCountUnsafeSupplier.get();
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
	protected Integer resetCount;

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

	@Schema
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonIgnore
	public void setStartDate(
		UnsafeSupplier<Date, Exception> startDateUnsafeSupplier) {

		try {
			startDate = startDateUnsafeSupplier.get();
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
	protected Date startDate;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatbotSession)) {
			return false;
		}

		ChatbotSession chatbotSession = (ChatbotSession)object;

		return Objects.equals(toString(), chatbotSession.toString());
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

		if (fallbackCount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fallbackCount\": ");

			sb.append(fallbackCount);
		}

		if (lastDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(lastDate));

			sb.append("\"");
		}

		if (lastIntentMatched != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastIntentMatched\": ");

			sb.append("\"");

			sb.append(_escape(lastIntentMatched));

			sb.append("\"");
		}

		if (lastMessage != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastMessage\": ");

			sb.append("\"");

			sb.append(_escape(lastMessage));

			sb.append("\"");
		}

		if (messageCount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"messageCount\": ");

			sb.append(messageCount);
		}

		if (negativeCount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"negativeCount\": ");

			sb.append(negativeCount);
		}

		if (positiveCount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"positiveCount\": ");

			sb.append(positiveCount);
		}

		if (resetCount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resetCount\": ");

			sb.append(resetCount);
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

		if (startDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(startDate));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "it.servizidigitali.restservice.dto.v1_0.ChatbotSession",
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