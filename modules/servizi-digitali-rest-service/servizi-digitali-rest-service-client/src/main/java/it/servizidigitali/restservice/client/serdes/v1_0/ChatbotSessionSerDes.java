package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.ChatbotSession;
import it.servizidigitali.restservice.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class ChatbotSessionSerDes {

	public static ChatbotSession toDTO(String json) {
		ChatbotSessionJSONParser chatbotSessionJSONParser =
			new ChatbotSessionJSONParser();

		return chatbotSessionJSONParser.parseToDTO(json);
	}

	public static ChatbotSession[] toDTOs(String json) {
		ChatbotSessionJSONParser chatbotSessionJSONParser =
			new ChatbotSessionJSONParser();

		return chatbotSessionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ChatbotSession chatbotSession) {
		if (chatbotSession == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chatbotSession.getFallbackCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fallbackCount\": ");

			sb.append(chatbotSession.getFallbackCount());
		}

		if (chatbotSession.getLastDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(chatbotSession.getLastDate()));

			sb.append("\"");
		}

		if (chatbotSession.getLastIntentMatched() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastIntentMatched\": ");

			sb.append("\"");

			sb.append(_escape(chatbotSession.getLastIntentMatched()));

			sb.append("\"");
		}

		if (chatbotSession.getLastMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastMessage\": ");

			sb.append("\"");

			sb.append(_escape(chatbotSession.getLastMessage()));

			sb.append("\"");
		}

		if (chatbotSession.getMessageCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"messageCount\": ");

			sb.append(chatbotSession.getMessageCount());
		}

		if (chatbotSession.getNegativeCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"negativeCount\": ");

			sb.append(chatbotSession.getNegativeCount());
		}

		if (chatbotSession.getPositiveCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"positiveCount\": ");

			sb.append(chatbotSession.getPositiveCount());
		}

		if (chatbotSession.getResetCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resetCount\": ");

			sb.append(chatbotSession.getResetCount());
		}

		if (chatbotSession.getSessionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sessionId\": ");

			sb.append("\"");

			sb.append(_escape(chatbotSession.getSessionId()));

			sb.append("\"");
		}

		if (chatbotSession.getStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(chatbotSession.getStartDate()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ChatbotSessionJSONParser chatbotSessionJSONParser =
			new ChatbotSessionJSONParser();

		return chatbotSessionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ChatbotSession chatbotSession) {
		if (chatbotSession == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chatbotSession.getFallbackCount() == null) {
			map.put("fallbackCount", null);
		}
		else {
			map.put(
				"fallbackCount",
				String.valueOf(chatbotSession.getFallbackCount()));
		}

		if (chatbotSession.getLastDate() == null) {
			map.put("lastDate", null);
		}
		else {
			map.put(
				"lastDate",
				liferayToJSONDateFormat.format(chatbotSession.getLastDate()));
		}

		if (chatbotSession.getLastIntentMatched() == null) {
			map.put("lastIntentMatched", null);
		}
		else {
			map.put(
				"lastIntentMatched",
				String.valueOf(chatbotSession.getLastIntentMatched()));
		}

		if (chatbotSession.getLastMessage() == null) {
			map.put("lastMessage", null);
		}
		else {
			map.put(
				"lastMessage", String.valueOf(chatbotSession.getLastMessage()));
		}

		if (chatbotSession.getMessageCount() == null) {
			map.put("messageCount", null);
		}
		else {
			map.put(
				"messageCount",
				String.valueOf(chatbotSession.getMessageCount()));
		}

		if (chatbotSession.getNegativeCount() == null) {
			map.put("negativeCount", null);
		}
		else {
			map.put(
				"negativeCount",
				String.valueOf(chatbotSession.getNegativeCount()));
		}

		if (chatbotSession.getPositiveCount() == null) {
			map.put("positiveCount", null);
		}
		else {
			map.put(
				"positiveCount",
				String.valueOf(chatbotSession.getPositiveCount()));
		}

		if (chatbotSession.getResetCount() == null) {
			map.put("resetCount", null);
		}
		else {
			map.put(
				"resetCount", String.valueOf(chatbotSession.getResetCount()));
		}

		if (chatbotSession.getSessionId() == null) {
			map.put("sessionId", null);
		}
		else {
			map.put("sessionId", String.valueOf(chatbotSession.getSessionId()));
		}

		if (chatbotSession.getStartDate() == null) {
			map.put("startDate", null);
		}
		else {
			map.put(
				"startDate",
				liferayToJSONDateFormat.format(chatbotSession.getStartDate()));
		}

		return map;
	}

	public static class ChatbotSessionJSONParser
		extends BaseJSONParser<ChatbotSession> {

		@Override
		protected ChatbotSession createDTO() {
			return new ChatbotSession();
		}

		@Override
		protected ChatbotSession[] createDTOArray(int size) {
			return new ChatbotSession[size];
		}

		@Override
		protected void setField(
			ChatbotSession chatbotSession, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "fallbackCount")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setFallbackCount(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastDate")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setLastDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastIntentMatched")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setLastIntentMatched(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastMessage")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setLastMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "messageCount")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setMessageCount(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "negativeCount")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setNegativeCount(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "positiveCount")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setPositiveCount(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "resetCount")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setResetCount(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sessionId")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setSessionId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					chatbotSession.setStartDate(
						toDate((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}