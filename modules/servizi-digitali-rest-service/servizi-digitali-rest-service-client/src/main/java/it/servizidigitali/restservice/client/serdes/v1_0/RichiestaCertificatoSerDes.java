package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.RichiestaCertificato;
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
public class RichiestaCertificatoSerDes {

	public static RichiestaCertificato toDTO(String json) {
		RichiestaCertificatoJSONParser richiestaCertificatoJSONParser =
			new RichiestaCertificatoJSONParser();

		return richiestaCertificatoJSONParser.parseToDTO(json);
	}

	public static RichiestaCertificato[] toDTOs(String json) {
		RichiestaCertificatoJSONParser richiestaCertificatoJSONParser =
			new RichiestaCertificatoJSONParser();

		return richiestaCertificatoJSONParser.parseToDTOs(json);
	}

	public static String toJSON(RichiestaCertificato richiestaCertificato) {
		if (richiestaCertificato == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (richiestaCertificato.getDataAggiornamento() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataAggiornamento\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					richiestaCertificato.getDataAggiornamento()));

			sb.append("\"");
		}

		if (richiestaCertificato.getDataInserimento() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataInserimento\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					richiestaCertificato.getDataInserimento()));

			sb.append("\"");
		}

		if (richiestaCertificato.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(richiestaCertificato.getEmail()));

			sb.append("\"");
		}

		if (richiestaCertificato.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(richiestaCertificato.getId());
		}

		if (richiestaCertificato.getMessaggio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"messaggio\": ");

			sb.append("\"");

			sb.append(_escape(richiestaCertificato.getMessaggio()));

			sb.append("\"");
		}

		if (richiestaCertificato.getStato() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stato\": ");

			sb.append("\"");

			sb.append(_escape(richiestaCertificato.getStato()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		RichiestaCertificatoJSONParser richiestaCertificatoJSONParser =
			new RichiestaCertificatoJSONParser();

		return richiestaCertificatoJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		RichiestaCertificato richiestaCertificato) {

		if (richiestaCertificato == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (richiestaCertificato.getDataAggiornamento() == null) {
			map.put("dataAggiornamento", null);
		}
		else {
			map.put(
				"dataAggiornamento",
				liferayToJSONDateFormat.format(
					richiestaCertificato.getDataAggiornamento()));
		}

		if (richiestaCertificato.getDataInserimento() == null) {
			map.put("dataInserimento", null);
		}
		else {
			map.put(
				"dataInserimento",
				liferayToJSONDateFormat.format(
					richiestaCertificato.getDataInserimento()));
		}

		if (richiestaCertificato.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(richiestaCertificato.getEmail()));
		}

		if (richiestaCertificato.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(richiestaCertificato.getId()));
		}

		if (richiestaCertificato.getMessaggio() == null) {
			map.put("messaggio", null);
		}
		else {
			map.put(
				"messaggio",
				String.valueOf(richiestaCertificato.getMessaggio()));
		}

		if (richiestaCertificato.getStato() == null) {
			map.put("stato", null);
		}
		else {
			map.put("stato", String.valueOf(richiestaCertificato.getStato()));
		}

		return map;
	}

	public static class RichiestaCertificatoJSONParser
		extends BaseJSONParser<RichiestaCertificato> {

		@Override
		protected RichiestaCertificato createDTO() {
			return new RichiestaCertificato();
		}

		@Override
		protected RichiestaCertificato[] createDTOArray(int size) {
			return new RichiestaCertificato[size];
		}

		@Override
		protected void setField(
			RichiestaCertificato richiestaCertificato,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "dataAggiornamento")) {
				if (jsonParserFieldValue != null) {
					richiestaCertificato.setDataAggiornamento(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataInserimento")) {
				if (jsonParserFieldValue != null) {
					richiestaCertificato.setDataInserimento(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					richiestaCertificato.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					richiestaCertificato.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "messaggio")) {
				if (jsonParserFieldValue != null) {
					richiestaCertificato.setMessaggio(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stato")) {
				if (jsonParserFieldValue != null) {
					richiestaCertificato.setStato((String)jsonParserFieldValue);
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