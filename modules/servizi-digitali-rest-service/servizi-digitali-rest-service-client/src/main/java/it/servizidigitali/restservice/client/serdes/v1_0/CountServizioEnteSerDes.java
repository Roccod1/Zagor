package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.CountServizioEnte;
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
public class CountServizioEnteSerDes {

	public static CountServizioEnte toDTO(String json) {
		CountServizioEnteJSONParser countServizioEnteJSONParser =
			new CountServizioEnteJSONParser();

		return countServizioEnteJSONParser.parseToDTO(json);
	}

	public static CountServizioEnte[] toDTOs(String json) {
		CountServizioEnteJSONParser countServizioEnteJSONParser =
			new CountServizioEnteJSONParser();

		return countServizioEnteJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CountServizioEnte countServizioEnte) {
		if (countServizioEnte == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (countServizioEnte.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(countServizioEnte.getId());
		}

		if (countServizioEnte.getServiceCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceCount\": ");

			sb.append(countServizioEnte.getServiceCount());
		}

		if (countServizioEnte.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(countServizioEnte.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CountServizioEnteJSONParser countServizioEnteJSONParser =
			new CountServizioEnteJSONParser();

		return countServizioEnteJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CountServizioEnte countServizioEnte) {

		if (countServizioEnte == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (countServizioEnte.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(countServizioEnte.getId()));
		}

		if (countServizioEnte.getServiceCount() == null) {
			map.put("serviceCount", null);
		}
		else {
			map.put(
				"serviceCount",
				String.valueOf(countServizioEnte.getServiceCount()));
		}

		if (countServizioEnte.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(countServizioEnte.getTitle()));
		}

		return map;
	}

	public static class CountServizioEnteJSONParser
		extends BaseJSONParser<CountServizioEnte> {

		@Override
		protected CountServizioEnte createDTO() {
			return new CountServizioEnte();
		}

		@Override
		protected CountServizioEnte[] createDTOArray(int size) {
			return new CountServizioEnte[size];
		}

		@Override
		protected void setField(
			CountServizioEnte countServizioEnte, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					countServizioEnte.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceCount")) {
				if (jsonParserFieldValue != null) {
					countServizioEnte.setServiceCount(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					countServizioEnte.setTitle((String)jsonParserFieldValue);
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