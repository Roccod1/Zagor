package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.UpdateRichiestaServizioRequest;
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
public class UpdateRichiestaServizioRequestSerDes {

	public static UpdateRichiestaServizioRequest toDTO(String json) {
		UpdateRichiestaServizioRequestJSONParser
			updateRichiestaServizioRequestJSONParser =
				new UpdateRichiestaServizioRequestJSONParser();

		return updateRichiestaServizioRequestJSONParser.parseToDTO(json);
	}

	public static UpdateRichiestaServizioRequest[] toDTOs(String json) {
		UpdateRichiestaServizioRequestJSONParser
			updateRichiestaServizioRequestJSONParser =
				new UpdateRichiestaServizioRequestJSONParser();

		return updateRichiestaServizioRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		UpdateRichiestaServizioRequest updateRichiestaServizioRequest) {

		if (updateRichiestaServizioRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (updateRichiestaServizioRequest.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(updateRichiestaServizioRequest.getId());
		}

		if (updateRichiestaServizioRequest.getStato() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stato\": ");

			sb.append("\"");

			sb.append(_escape(updateRichiestaServizioRequest.getStato()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		UpdateRichiestaServizioRequestJSONParser
			updateRichiestaServizioRequestJSONParser =
				new UpdateRichiestaServizioRequestJSONParser();

		return updateRichiestaServizioRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		UpdateRichiestaServizioRequest updateRichiestaServizioRequest) {

		if (updateRichiestaServizioRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (updateRichiestaServizioRequest.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put(
				"id", String.valueOf(updateRichiestaServizioRequest.getId()));
		}

		if (updateRichiestaServizioRequest.getStato() == null) {
			map.put("stato", null);
		}
		else {
			map.put(
				"stato",
				String.valueOf(updateRichiestaServizioRequest.getStato()));
		}

		return map;
	}

	public static class UpdateRichiestaServizioRequestJSONParser
		extends BaseJSONParser<UpdateRichiestaServizioRequest> {

		@Override
		protected UpdateRichiestaServizioRequest createDTO() {
			return new UpdateRichiestaServizioRequest();
		}

		@Override
		protected UpdateRichiestaServizioRequest[] createDTOArray(int size) {
			return new UpdateRichiestaServizioRequest[size];
		}

		@Override
		protected void setField(
			UpdateRichiestaServizioRequest updateRichiestaServizioRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					updateRichiestaServizioRequest.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stato")) {
				if (jsonParserFieldValue != null) {
					updateRichiestaServizioRequest.setStato(
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