package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.ChatbotAnswer;
import it.servizidigitali.restservice.client.json.BaseJSONParser;

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
public class ChatbotAnswerSerDes {

	public static ChatbotAnswer toDTO(String json) {
		ChatbotAnswerJSONParser chatbotAnswerJSONParser =
			new ChatbotAnswerJSONParser();

		return chatbotAnswerJSONParser.parseToDTO(json);
	}

	public static ChatbotAnswer[] toDTOs(String json) {
		ChatbotAnswerJSONParser chatbotAnswerJSONParser =
			new ChatbotAnswerJSONParser();

		return chatbotAnswerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ChatbotAnswer chatbotAnswer) {
		if (chatbotAnswer == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (chatbotAnswer.getMessaggio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"messaggio\": ");

			sb.append("\"");

			sb.append(_escape(chatbotAnswer.getMessaggio()));

			sb.append("\"");
		}

		if (chatbotAnswer.getPathServizio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pathServizio\": ");

			sb.append("\"");

			sb.append(_escape(chatbotAnswer.getPathServizio()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ChatbotAnswerJSONParser chatbotAnswerJSONParser =
			new ChatbotAnswerJSONParser();

		return chatbotAnswerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ChatbotAnswer chatbotAnswer) {
		if (chatbotAnswer == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (chatbotAnswer.getMessaggio() == null) {
			map.put("messaggio", null);
		}
		else {
			map.put("messaggio", String.valueOf(chatbotAnswer.getMessaggio()));
		}

		if (chatbotAnswer.getPathServizio() == null) {
			map.put("pathServizio", null);
		}
		else {
			map.put(
				"pathServizio",
				String.valueOf(chatbotAnswer.getPathServizio()));
		}

		return map;
	}

	public static class ChatbotAnswerJSONParser
		extends BaseJSONParser<ChatbotAnswer> {

		@Override
		protected ChatbotAnswer createDTO() {
			return new ChatbotAnswer();
		}

		@Override
		protected ChatbotAnswer[] createDTOArray(int size) {
			return new ChatbotAnswer[size];
		}

		@Override
		protected void setField(
			ChatbotAnswer chatbotAnswer, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "messaggio")) {
				if (jsonParserFieldValue != null) {
					chatbotAnswer.setMessaggio((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "pathServizio")) {
				if (jsonParserFieldValue != null) {
					chatbotAnswer.setPathServizio((String)jsonParserFieldValue);
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