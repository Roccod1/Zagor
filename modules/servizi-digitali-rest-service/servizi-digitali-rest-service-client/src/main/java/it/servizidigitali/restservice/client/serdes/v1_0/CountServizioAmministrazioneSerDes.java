package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.CountServizioAmministrazione;
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
public class CountServizioAmministrazioneSerDes {

	public static CountServizioAmministrazione toDTO(String json) {
		CountServizioAmministrazioneJSONParser
			countServizioAmministrazioneJSONParser =
				new CountServizioAmministrazioneJSONParser();

		return countServizioAmministrazioneJSONParser.parseToDTO(json);
	}

	public static CountServizioAmministrazione[] toDTOs(String json) {
		CountServizioAmministrazioneJSONParser
			countServizioAmministrazioneJSONParser =
				new CountServizioAmministrazioneJSONParser();

		return countServizioAmministrazioneJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		CountServizioAmministrazione countServizioAmministrazione) {

		if (countServizioAmministrazione == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (countServizioAmministrazione.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(countServizioAmministrazione.getId());
		}

		if (countServizioAmministrazione.getServiceCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceCount\": ");

			sb.append(countServizioAmministrazione.getServiceCount());
		}

		if (countServizioAmministrazione.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(countServizioAmministrazione.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CountServizioAmministrazioneJSONParser
			countServizioAmministrazioneJSONParser =
				new CountServizioAmministrazioneJSONParser();

		return countServizioAmministrazioneJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CountServizioAmministrazione countServizioAmministrazione) {

		if (countServizioAmministrazione == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (countServizioAmministrazione.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(countServizioAmministrazione.getId()));
		}

		if (countServizioAmministrazione.getServiceCount() == null) {
			map.put("serviceCount", null);
		}
		else {
			map.put(
				"serviceCount",
				String.valueOf(countServizioAmministrazione.getServiceCount()));
		}

		if (countServizioAmministrazione.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put(
				"title",
				String.valueOf(countServizioAmministrazione.getTitle()));
		}

		return map;
	}

	public static class CountServizioAmministrazioneJSONParser
		extends BaseJSONParser<CountServizioAmministrazione> {

		@Override
		protected CountServizioAmministrazione createDTO() {
			return new CountServizioAmministrazione();
		}

		@Override
		protected CountServizioAmministrazione[] createDTOArray(int size) {
			return new CountServizioAmministrazione[size];
		}

		@Override
		protected void setField(
			CountServizioAmministrazione countServizioAmministrazione,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					countServizioAmministrazione.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceCount")) {
				if (jsonParserFieldValue != null) {
					countServizioAmministrazione.setServiceCount(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					countServizioAmministrazione.setTitle(
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