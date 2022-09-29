package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.ChatbotDatiSessione;
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
public class ChatbotDatiSessioneSerDes {

	public static ChatbotDatiSessione toDTO(String json) {
		ChatbotDatiSessioneJSONParser chatbotDatiSessioneJSONParser =
			new ChatbotDatiSessioneJSONParser();

		return chatbotDatiSessioneJSONParser.parseToDTO(json);
	}

	public static ChatbotDatiSessione[] toDTOs(String json) {
		ChatbotDatiSessioneJSONParser chatbotDatiSessioneJSONParser =
			new ChatbotDatiSessioneJSONParser();

		return chatbotDatiSessioneJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ChatbotDatiSessione chatbotDatiSessione) {
		if (chatbotDatiSessione == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chatbotDatiSessione.getIntentMatched() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"intentMatched\": ");

			sb.append("\"");

			sb.append(_escape(chatbotDatiSessione.getIntentMatched()));

			sb.append("\"");
		}

		if (chatbotDatiSessione.getIsFallback() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isFallback\": ");

			sb.append(chatbotDatiSessione.getIsFallback());
		}

		if (chatbotDatiSessione.getIsMatched() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isMatched\": ");

			sb.append(chatbotDatiSessione.getIsMatched());
		}

		if (chatbotDatiSessione.getIsNegative() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isNegative\": ");

			sb.append(chatbotDatiSessione.getIsNegative());
		}

		if (chatbotDatiSessione.getIsPositive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isPositive\": ");

			sb.append(chatbotDatiSessione.getIsPositive());
		}

		if (chatbotDatiSessione.getIsReset() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isReset\": ");

			sb.append(chatbotDatiSessione.getIsReset());
		}

		if (chatbotDatiSessione.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(chatbotDatiSessione.getMessage()));

			sb.append("\"");
		}

		if (chatbotDatiSessione.getMessageDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"messageDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					chatbotDatiSessione.getMessageDate()));

			sb.append("\"");
		}

		if (chatbotDatiSessione.getSessionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sessionId\": ");

			sb.append("\"");

			sb.append(_escape(chatbotDatiSessione.getSessionId()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ChatbotDatiSessioneJSONParser chatbotDatiSessioneJSONParser =
			new ChatbotDatiSessioneJSONParser();

		return chatbotDatiSessioneJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ChatbotDatiSessione chatbotDatiSessione) {

		if (chatbotDatiSessione == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chatbotDatiSessione.getIntentMatched() == null) {
			map.put("intentMatched", null);
		}
		else {
			map.put(
				"intentMatched",
				String.valueOf(chatbotDatiSessione.getIntentMatched()));
		}

		if (chatbotDatiSessione.getIsFallback() == null) {
			map.put("isFallback", null);
		}
		else {
			map.put(
				"isFallback",
				String.valueOf(chatbotDatiSessione.getIsFallback()));
		}

		if (chatbotDatiSessione.getIsMatched() == null) {
			map.put("isMatched", null);
		}
		else {
			map.put(
				"isMatched",
				String.valueOf(chatbotDatiSessione.getIsMatched()));
		}

		if (chatbotDatiSessione.getIsNegative() == null) {
			map.put("isNegative", null);
		}
		else {
			map.put(
				"isNegative",
				String.valueOf(chatbotDatiSessione.getIsNegative()));
		}

		if (chatbotDatiSessione.getIsPositive() == null) {
			map.put("isPositive", null);
		}
		else {
			map.put(
				"isPositive",
				String.valueOf(chatbotDatiSessione.getIsPositive()));
		}

		if (chatbotDatiSessione.getIsReset() == null) {
			map.put("isReset", null);
		}
		else {
			map.put(
				"isReset", String.valueOf(chatbotDatiSessione.getIsReset()));
		}

		if (chatbotDatiSessione.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put(
				"message", String.valueOf(chatbotDatiSessione.getMessage()));
		}

		if (chatbotDatiSessione.getMessageDate() == null) {
			map.put("messageDate", null);
		}
		else {
			map.put(
				"messageDate",
				liferayToJSONDateFormat.format(
					chatbotDatiSessione.getMessageDate()));
		}

		if (chatbotDatiSessione.getSessionId() == null) {
			map.put("sessionId", null);
		}
		else {
			map.put(
				"sessionId",
				String.valueOf(chatbotDatiSessione.getSessionId()));
		}

		return map;
	}

	public static class ChatbotDatiSessioneJSONParser
		extends BaseJSONParser<ChatbotDatiSessione> {

		@Override
		protected ChatbotDatiSessione createDTO() {
			return new ChatbotDatiSessione();
		}

		@Override
		protected ChatbotDatiSessione[] createDTOArray(int size) {
			return new ChatbotDatiSessione[size];
		}

		@Override
		protected void setField(
			ChatbotDatiSessione chatbotDatiSessione, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "intentMatched")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setIntentMatched(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isFallback")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setIsFallback(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isMatched")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setIsMatched(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isNegative")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setIsNegative(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isPositive")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setIsPositive(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isReset")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setIsReset(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setMessage(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "messageDate")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setMessageDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sessionId")) {
				if (jsonParserFieldValue != null) {
					chatbotDatiSessione.setSessionId(
						(String)jsonParserFieldValue);
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