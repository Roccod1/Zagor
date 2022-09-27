package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.DestinazioneUso;
import it.servizidigitali.restservice.client.dto.v1_0.InfoServizioAmministrazione;
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
public class InfoServizioAmministrazioneSerDes {

	public static InfoServizioAmministrazione toDTO(String json) {
		InfoServizioAmministrazioneJSONParser
			infoServizioAmministrazioneJSONParser =
				new InfoServizioAmministrazioneJSONParser();

		return infoServizioAmministrazioneJSONParser.parseToDTO(json);
	}

	public static InfoServizioAmministrazione[] toDTOs(String json) {
		InfoServizioAmministrazioneJSONParser
			infoServizioAmministrazioneJSONParser =
				new InfoServizioAmministrazioneJSONParser();

		return infoServizioAmministrazioneJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		InfoServizioAmministrazione infoServizioAmministrazione) {

		if (infoServizioAmministrazione == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (infoServizioAmministrazione.getActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"active\": ");

			sb.append(infoServizioAmministrazione.getActive());
		}

		if (infoServizioAmministrazione.getChatbotInline() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chatbotInline\": ");

			sb.append(infoServizioAmministrazione.getChatbotInline());
		}

		if (infoServizioAmministrazione.getChatbotInlineIntent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chatbotInlineIntent\": ");

			sb.append(infoServizioAmministrazione.getChatbotInlineIntent());
		}

		if (infoServizioAmministrazione.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioAmministrazione.getCode()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getCodiceIpa() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceIpa\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioAmministrazione.getCodiceIpa()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getCorrelatedPaymentServiceCode() !=
				null) {

			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"correlatedPaymentServiceCode\": ");

			sb.append("\"");

			sb.append(
				_escape(
					infoServizioAmministrazione.
						getCorrelatedPaymentServiceCode()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioAmministrazione.getDescription()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getDestinazioneUsos() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"destinazioneUsos\": ");

			sb.append("[");

			for (int i = 0;
				 i < infoServizioAmministrazione.getDestinazioneUsos().length;
				 i++) {

				sb.append(
					String.valueOf(
						infoServizioAmministrazione.getDestinazioneUsos()[i]));

				if ((i + 1) <
						infoServizioAmministrazione.
							getDestinazioneUsos().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (infoServizioAmministrazione.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(infoServizioAmministrazione.getId());
		}

		if (infoServizioAmministrazione.getNomeComune() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nomeComune\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioAmministrazione.getNomeComune()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getServiceCardUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceCardUrl\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioAmministrazione.getServiceCardUrl()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getServiceOnlineUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceOnlineUrl\": ");

			sb.append("\"");

			sb.append(
				_escape(infoServizioAmministrazione.getServiceOnlineUrl()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(infoServizioAmministrazione.getTitle()));

			sb.append("\"");
		}

		if (infoServizioAmministrazione.getUsableByChatbot() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"usableByChatbot\": ");

			sb.append(infoServizioAmministrazione.getUsableByChatbot());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		InfoServizioAmministrazioneJSONParser
			infoServizioAmministrazioneJSONParser =
				new InfoServizioAmministrazioneJSONParser();

		return infoServizioAmministrazioneJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		InfoServizioAmministrazione infoServizioAmministrazione) {

		if (infoServizioAmministrazione == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (infoServizioAmministrazione.getActive() == null) {
			map.put("active", null);
		}
		else {
			map.put(
				"active",
				String.valueOf(infoServizioAmministrazione.getActive()));
		}

		if (infoServizioAmministrazione.getChatbotInline() == null) {
			map.put("chatbotInline", null);
		}
		else {
			map.put(
				"chatbotInline",
				String.valueOf(infoServizioAmministrazione.getChatbotInline()));
		}

		if (infoServizioAmministrazione.getChatbotInlineIntent() == null) {
			map.put("chatbotInlineIntent", null);
		}
		else {
			map.put(
				"chatbotInlineIntent",
				String.valueOf(
					infoServizioAmministrazione.getChatbotInlineIntent()));
		}

		if (infoServizioAmministrazione.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put(
				"code", String.valueOf(infoServizioAmministrazione.getCode()));
		}

		if (infoServizioAmministrazione.getCodiceIpa() == null) {
			map.put("codiceIpa", null);
		}
		else {
			map.put(
				"codiceIpa",
				String.valueOf(infoServizioAmministrazione.getCodiceIpa()));
		}

		if (infoServizioAmministrazione.getCorrelatedPaymentServiceCode() ==
				null) {

			map.put("correlatedPaymentServiceCode", null);
		}
		else {
			map.put(
				"correlatedPaymentServiceCode",
				String.valueOf(
					infoServizioAmministrazione.
						getCorrelatedPaymentServiceCode()));
		}

		if (infoServizioAmministrazione.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(infoServizioAmministrazione.getDescription()));
		}

		if (infoServizioAmministrazione.getDestinazioneUsos() == null) {
			map.put("destinazioneUsos", null);
		}
		else {
			map.put(
				"destinazioneUsos",
				String.valueOf(
					infoServizioAmministrazione.getDestinazioneUsos()));
		}

		if (infoServizioAmministrazione.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(infoServizioAmministrazione.getId()));
		}

		if (infoServizioAmministrazione.getNomeComune() == null) {
			map.put("nomeComune", null);
		}
		else {
			map.put(
				"nomeComune",
				String.valueOf(infoServizioAmministrazione.getNomeComune()));
		}

		if (infoServizioAmministrazione.getServiceCardUrl() == null) {
			map.put("serviceCardUrl", null);
		}
		else {
			map.put(
				"serviceCardUrl",
				String.valueOf(
					infoServizioAmministrazione.getServiceCardUrl()));
		}

		if (infoServizioAmministrazione.getServiceOnlineUrl() == null) {
			map.put("serviceOnlineUrl", null);
		}
		else {
			map.put(
				"serviceOnlineUrl",
				String.valueOf(
					infoServizioAmministrazione.getServiceOnlineUrl()));
		}

		if (infoServizioAmministrazione.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put(
				"title",
				String.valueOf(infoServizioAmministrazione.getTitle()));
		}

		if (infoServizioAmministrazione.getUsableByChatbot() == null) {
			map.put("usableByChatbot", null);
		}
		else {
			map.put(
				"usableByChatbot",
				String.valueOf(
					infoServizioAmministrazione.getUsableByChatbot()));
		}

		return map;
	}

	public static class InfoServizioAmministrazioneJSONParser
		extends BaseJSONParser<InfoServizioAmministrazione> {

		@Override
		protected InfoServizioAmministrazione createDTO() {
			return new InfoServizioAmministrazione();
		}

		@Override
		protected InfoServizioAmministrazione[] createDTOArray(int size) {
			return new InfoServizioAmministrazione[size];
		}

		@Override
		protected void setField(
			InfoServizioAmministrazione infoServizioAmministrazione,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "active")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setActive(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "chatbotInline")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setChatbotInline(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "chatbotInlineIntent")) {

				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setChatbotInlineIntent(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "codiceIpa")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setCodiceIpa(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "correlatedPaymentServiceCode")) {

				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setCorrelatedPaymentServiceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "destinazioneUsos")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setDestinazioneUsos(
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
					infoServizioAmministrazione.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nomeComune")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setNomeComune(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceCardUrl")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setServiceCardUrl(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceOnlineUrl")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setServiceOnlineUrl(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setTitle(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "usableByChatbot")) {
				if (jsonParserFieldValue != null) {
					infoServizioAmministrazione.setUsableByChatbot(
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