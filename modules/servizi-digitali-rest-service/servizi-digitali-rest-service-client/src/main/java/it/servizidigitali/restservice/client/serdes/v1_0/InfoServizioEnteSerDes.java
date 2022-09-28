package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.DestinazioneUso;
import it.servizidigitali.restservice.client.dto.v1_0.InfoServizioEnte;
import it.servizidigitali.restservice.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class InfoServizioEnteSerDes {

	public static InfoServizioEnte toDTO(String json) {
		InfoServizioEnteJSONParser infoServizioEnteJSONParser =
			new InfoServizioEnteJSONParser();

		return infoServizioEnteJSONParser.parseToDTO(json);
	}

	public static InfoServizioEnte[] toDTOs(String json) {
		InfoServizioEnteJSONParser infoServizioEnteJSONParser =
			new InfoServizioEnteJSONParser();

		return infoServizioEnteJSONParser.parseToDTOs(json);
	}

	public static String toJSON(InfoServizioEnte infoServizioEnte) {
		if (infoServizioEnte == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (infoServizioEnte.getActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"active\": ");

			sb.append(infoServizioEnte.getActive());
		}

		if (infoServizioEnte.getChatbotInline() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chatbotInline\": ");

			sb.append(infoServizioEnte.getChatbotInline());
		}

		if (infoServizioEnte.getChatbotInlineIntent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chatbotInlineIntent\": ");

			sb.append(infoServizioEnte.getChatbotInlineIntent());
		}

		if (infoServizioEnte.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getCode()));

			sb.append("\"");
		}

		if (infoServizioEnte.getCodiceIpa() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceIpa\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getCodiceIpa()));

			sb.append("\"");
		}

		if (infoServizioEnte.getCorrelatedPaymentServiceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"correlatedPaymentServiceCode\": ");

			sb.append("\"");

			sb.append(
				_escape(infoServizioEnte.getCorrelatedPaymentServiceCode()));

			sb.append("\"");
		}

		if (infoServizioEnte.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getDescription()));

			sb.append("\"");
		}

		if (infoServizioEnte.getDestinazioneUsos() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"destinazioneUsos\": ");

			sb.append("[");

			for (int i = 0; i < infoServizioEnte.getDestinazioneUsos().length;
				 i++) {

				sb.append(
					String.valueOf(infoServizioEnte.getDestinazioneUsos()[i]));

				if ((i + 1) < infoServizioEnte.getDestinazioneUsos().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (infoServizioEnte.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(infoServizioEnte.getId());
		}

		if (infoServizioEnte.getNomeComune() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nomeComune\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getNomeComune()));

			sb.append("\"");
		}

		if (infoServizioEnte.getServiceCardUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceCardUrl\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getServiceCardUrl()));

			sb.append("\"");
		}

		if (infoServizioEnte.getServiceOnlineUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceOnlineUrl\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getServiceOnlineUrl()));

			sb.append("\"");
		}

		if (infoServizioEnte.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioEnte.getTitle()));

			sb.append("\"");
		}

		if (infoServizioEnte.getUsableByChatbot() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"usableByChatbot\": ");

			sb.append(infoServizioEnte.getUsableByChatbot());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		InfoServizioEnteJSONParser infoServizioEnteJSONParser =
			new InfoServizioEnteJSONParser();

		return infoServizioEnteJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(InfoServizioEnte infoServizioEnte) {
		if (infoServizioEnte == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (infoServizioEnte.getActive() == null) {
			map.put("active", null);
		}
		else {
			map.put("active", String.valueOf(infoServizioEnte.getActive()));
		}

		if (infoServizioEnte.getChatbotInline() == null) {
			map.put("chatbotInline", null);
		}
		else {
			map.put(
				"chatbotInline",
				String.valueOf(infoServizioEnte.getChatbotInline()));
		}

		if (infoServizioEnte.getChatbotInlineIntent() == null) {
			map.put("chatbotInlineIntent", null);
		}
		else {
			map.put(
				"chatbotInlineIntent",
				String.valueOf(infoServizioEnte.getChatbotInlineIntent()));
		}

		if (infoServizioEnte.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(infoServizioEnte.getCode()));
		}

		if (infoServizioEnte.getCodiceIpa() == null) {
			map.put("codiceIpa", null);
		}
		else {
			map.put(
				"codiceIpa", String.valueOf(infoServizioEnte.getCodiceIpa()));
		}

		if (infoServizioEnte.getCorrelatedPaymentServiceCode() == null) {
			map.put("correlatedPaymentServiceCode", null);
		}
		else {
			map.put(
				"correlatedPaymentServiceCode",
				String.valueOf(
					infoServizioEnte.getCorrelatedPaymentServiceCode()));
		}

		if (infoServizioEnte.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(infoServizioEnte.getDescription()));
		}

		if (infoServizioEnte.getDestinazioneUsos() == null) {
			map.put("destinazioneUsos", null);
		}
		else {
			map.put(
				"destinazioneUsos",
				String.valueOf(infoServizioEnte.getDestinazioneUsos()));
		}

		if (infoServizioEnte.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(infoServizioEnte.getId()));
		}

		if (infoServizioEnte.getNomeComune() == null) {
			map.put("nomeComune", null);
		}
		else {
			map.put(
				"nomeComune", String.valueOf(infoServizioEnte.getNomeComune()));
		}

		if (infoServizioEnte.getServiceCardUrl() == null) {
			map.put("serviceCardUrl", null);
		}
		else {
			map.put(
				"serviceCardUrl",
				String.valueOf(infoServizioEnte.getServiceCardUrl()));
		}

		if (infoServizioEnte.getServiceOnlineUrl() == null) {
			map.put("serviceOnlineUrl", null);
		}
		else {
			map.put(
				"serviceOnlineUrl",
				String.valueOf(infoServizioEnte.getServiceOnlineUrl()));
		}

		if (infoServizioEnte.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(infoServizioEnte.getTitle()));
		}

		if (infoServizioEnte.getUsableByChatbot() == null) {
			map.put("usableByChatbot", null);
		}
		else {
			map.put(
				"usableByChatbot",
				String.valueOf(infoServizioEnte.getUsableByChatbot()));
		}

		return map;
	}

	public static class InfoServizioEnteJSONParser
		extends BaseJSONParser<InfoServizioEnte> {

		@Override
		protected InfoServizioEnte createDTO() {
			return new InfoServizioEnte();
		}

		@Override
		protected InfoServizioEnte[] createDTOArray(int size) {
			return new InfoServizioEnte[size];
		}

		@Override
		protected void setField(
			InfoServizioEnte infoServizioEnte, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "active")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setActive((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "chatbotInline")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setChatbotInline(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "chatbotInlineIntent")) {

				if (jsonParserFieldValue != null) {
					infoServizioEnte.setChatbotInlineIntent(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codiceIpa")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setCodiceIpa((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "correlatedPaymentServiceCode")) {

				if (jsonParserFieldValue != null) {
					infoServizioEnte.setCorrelatedPaymentServiceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "destinazioneUsos")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setDestinazioneUsos(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> DestinazioneUsoSerDes.toDTO(
								(String)object)
						).toArray(
							size -> new DestinazioneUso[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nomeComune")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setNomeComune(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceCardUrl")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setServiceCardUrl(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceOnlineUrl")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setServiceOnlineUrl(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "usableByChatbot")) {
				if (jsonParserFieldValue != null) {
					infoServizioEnte.setUsableByChatbot(
						(Boolean)jsonParserFieldValue);
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