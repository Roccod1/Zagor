package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.DestinazioneUso;
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
public class DestinazioneUsoSerDes {

	public static DestinazioneUso toDTO(String json) {
		DestinazioneUsoJSONParser destinazioneUsoJSONParser =
			new DestinazioneUsoJSONParser();

		return destinazioneUsoJSONParser.parseToDTO(json);
	}

	public static DestinazioneUso[] toDTOs(String json) {
		DestinazioneUsoJSONParser destinazioneUsoJSONParser =
			new DestinazioneUsoJSONParser();

		return destinazioneUsoJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DestinazioneUso destinazioneUso) {
		if (destinazioneUso == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (destinazioneUso.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(destinazioneUso.getDescription()));

			sb.append("\"");
		}

		if (destinazioneUso.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(destinazioneUso.getId());
		}

		if (destinazioneUso.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(destinazioneUso.getMessage()));

			sb.append("\"");
		}

		if (destinazioneUso.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(destinazioneUso.getName()));

			sb.append("\"");
		}

		if (destinazioneUso.getPayment() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"payment\": ");

			sb.append(destinazioneUso.getPayment());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DestinazioneUsoJSONParser destinazioneUsoJSONParser =
			new DestinazioneUsoJSONParser();

		return destinazioneUsoJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DestinazioneUso destinazioneUso) {
		if (destinazioneUso == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (destinazioneUso.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(destinazioneUso.getDescription()));
		}

		if (destinazioneUso.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(destinazioneUso.getId()));
		}

		if (destinazioneUso.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(destinazioneUso.getMessage()));
		}

		if (destinazioneUso.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(destinazioneUso.getName()));
		}

		if (destinazioneUso.getPayment() == null) {
			map.put("payment", null);
		}
		else {
			map.put("payment", String.valueOf(destinazioneUso.getPayment()));
		}

		return map;
	}

	public static class DestinazioneUsoJSONParser
		extends BaseJSONParser<DestinazioneUso> {

		@Override
		protected DestinazioneUso createDTO() {
			return new DestinazioneUso();
		}

		@Override
		protected DestinazioneUso[] createDTOArray(int size) {
			return new DestinazioneUso[size];
		}

		@Override
		protected void setField(
			DestinazioneUso destinazioneUso, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					destinazioneUso.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					destinazioneUso.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					destinazioneUso.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					destinazioneUso.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "payment")) {
				if (jsonParserFieldValue != null) {
					destinazioneUso.setPayment((Boolean)jsonParserFieldValue);
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