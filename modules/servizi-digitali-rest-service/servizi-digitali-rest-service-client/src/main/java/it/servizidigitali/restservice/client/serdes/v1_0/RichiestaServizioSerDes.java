package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.RichiestaServizio;
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
public class RichiestaServizioSerDes {

	public static RichiestaServizio toDTO(String json) {
		RichiestaServizioJSONParser richiestaServizioJSONParser =
			new RichiestaServizioJSONParser();

		return richiestaServizioJSONParser.parseToDTO(json);
	}

	public static RichiestaServizio[] toDTOs(String json) {
		RichiestaServizioJSONParser richiestaServizioJSONParser =
			new RichiestaServizioJSONParser();

		return richiestaServizioJSONParser.parseToDTOs(json);
	}

	public static String toJSON(RichiestaServizio richiestaServizio) {
		if (richiestaServizio == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (richiestaServizio.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(richiestaServizio.getId());
		}

		if (richiestaServizio.getStato() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stato\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getStato()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		RichiestaServizioJSONParser richiestaServizioJSONParser =
			new RichiestaServizioJSONParser();

		return richiestaServizioJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		RichiestaServizio richiestaServizio) {

		if (richiestaServizio == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (richiestaServizio.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(richiestaServizio.getId()));
		}

		if (richiestaServizio.getStato() == null) {
			map.put("stato", null);
		}
		else {
			map.put("stato", String.valueOf(richiestaServizio.getStato()));
		}

		return map;
	}

	public static class RichiestaServizioJSONParser
		extends BaseJSONParser<RichiestaServizio> {

		@Override
		protected RichiestaServizio createDTO() {
			return new RichiestaServizio();
		}

		@Override
		protected RichiestaServizio[] createDTOArray(int size) {
			return new RichiestaServizio[size];
		}

		@Override
		protected void setField(
			RichiestaServizio richiestaServizio, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stato")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setStato((String)jsonParserFieldValue);
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