package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.UpdateStatoRichiestaServizioRequest;
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
public class UpdateStatoRichiestaServizioRequestSerDes {

	public static UpdateStatoRichiestaServizioRequest toDTO(String json) {
		UpdateStatoRichiestaServizioRequestJSONParser
			updateStatoRichiestaServizioRequestJSONParser =
				new UpdateStatoRichiestaServizioRequestJSONParser();

		return updateStatoRichiestaServizioRequestJSONParser.parseToDTO(json);
	}

	public static UpdateStatoRichiestaServizioRequest[] toDTOs(String json) {
		UpdateStatoRichiestaServizioRequestJSONParser
			updateStatoRichiestaServizioRequestJSONParser =
				new UpdateStatoRichiestaServizioRequestJSONParser();

		return updateStatoRichiestaServizioRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		UpdateStatoRichiestaServizioRequest
			updateStatoRichiestaServizioRequest) {

		if (updateStatoRichiestaServizioRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (updateStatoRichiestaServizioRequest.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(updateStatoRichiestaServizioRequest.getId());
		}

		if (updateStatoRichiestaServizioRequest.getStato() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stato\": ");

			sb.append("\"");

			sb.append(_escape(updateStatoRichiestaServizioRequest.getStato()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		UpdateStatoRichiestaServizioRequestJSONParser
			updateStatoRichiestaServizioRequestJSONParser =
				new UpdateStatoRichiestaServizioRequestJSONParser();

		return updateStatoRichiestaServizioRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		UpdateStatoRichiestaServizioRequest
			updateStatoRichiestaServizioRequest) {

		if (updateStatoRichiestaServizioRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (updateStatoRichiestaServizioRequest.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put(
				"id",
				String.valueOf(updateStatoRichiestaServizioRequest.getId()));
		}

		if (updateStatoRichiestaServizioRequest.getStato() == null) {
			map.put("stato", null);
		}
		else {
			map.put(
				"stato",
				String.valueOf(updateStatoRichiestaServizioRequest.getStato()));
		}

		return map;
	}

	public static class UpdateStatoRichiestaServizioRequestJSONParser
		extends BaseJSONParser<UpdateStatoRichiestaServizioRequest> {

		@Override
		protected UpdateStatoRichiestaServizioRequest createDTO() {
			return new UpdateStatoRichiestaServizioRequest();
		}

		@Override
		protected UpdateStatoRichiestaServizioRequest[] createDTOArray(
			int size) {

			return new UpdateStatoRichiestaServizioRequest[size];
		}

		@Override
		protected void setField(
			UpdateStatoRichiestaServizioRequest
				updateStatoRichiestaServizioRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					updateStatoRichiestaServizioRequest.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stato")) {
				if (jsonParserFieldValue != null) {
					updateStatoRichiestaServizioRequest.setStato(
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