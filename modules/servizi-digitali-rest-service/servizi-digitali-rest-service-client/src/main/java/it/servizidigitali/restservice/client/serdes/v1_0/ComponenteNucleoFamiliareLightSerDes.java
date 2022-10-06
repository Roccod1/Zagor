package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.ComponenteNucleoFamiliareLight;
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
public class ComponenteNucleoFamiliareLightSerDes {

	public static ComponenteNucleoFamiliareLight toDTO(String json) {
		ComponenteNucleoFamiliareLightJSONParser
			componenteNucleoFamiliareLightJSONParser =
				new ComponenteNucleoFamiliareLightJSONParser();

		return componenteNucleoFamiliareLightJSONParser.parseToDTO(json);
	}

	public static ComponenteNucleoFamiliareLight[] toDTOs(String json) {
		ComponenteNucleoFamiliareLightJSONParser
			componenteNucleoFamiliareLightJSONParser =
				new ComponenteNucleoFamiliareLightJSONParser();

		return componenteNucleoFamiliareLightJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		ComponenteNucleoFamiliareLight componenteNucleoFamiliareLight) {

		if (componenteNucleoFamiliareLight == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (componenteNucleoFamiliareLight.getCodiceFiscale() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceFiscale\": ");

			sb.append("\"");

			sb.append(
				_escape(componenteNucleoFamiliareLight.getCodiceFiscale()));

			sb.append("\"");
		}

		if (componenteNucleoFamiliareLight.getCognome() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cognome\": ");

			sb.append("\"");

			sb.append(_escape(componenteNucleoFamiliareLight.getCognome()));

			sb.append("\"");
		}

		if (componenteNucleoFamiliareLight.getDataNascita() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataNascita\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					componenteNucleoFamiliareLight.getDataNascita()));

			sb.append("\"");
		}

		if (componenteNucleoFamiliareLight.getNome() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nome\": ");

			sb.append("\"");

			sb.append(_escape(componenteNucleoFamiliareLight.getNome()));

			sb.append("\"");
		}

		if (componenteNucleoFamiliareLight.getSesso() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sesso\": ");

			sb.append("\"");

			sb.append(_escape(componenteNucleoFamiliareLight.getSesso()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ComponenteNucleoFamiliareLightJSONParser
			componenteNucleoFamiliareLightJSONParser =
				new ComponenteNucleoFamiliareLightJSONParser();

		return componenteNucleoFamiliareLightJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ComponenteNucleoFamiliareLight componenteNucleoFamiliareLight) {

		if (componenteNucleoFamiliareLight == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (componenteNucleoFamiliareLight.getCodiceFiscale() == null) {
			map.put("codiceFiscale", null);
		}
		else {
			map.put(
				"codiceFiscale",
				String.valueOf(
					componenteNucleoFamiliareLight.getCodiceFiscale()));
		}

		if (componenteNucleoFamiliareLight.getCognome() == null) {
			map.put("cognome", null);
		}
		else {
			map.put(
				"cognome",
				String.valueOf(componenteNucleoFamiliareLight.getCognome()));
		}

		if (componenteNucleoFamiliareLight.getDataNascita() == null) {
			map.put("dataNascita", null);
		}
		else {
			map.put(
				"dataNascita",
				liferayToJSONDateFormat.format(
					componenteNucleoFamiliareLight.getDataNascita()));
		}

		if (componenteNucleoFamiliareLight.getNome() == null) {
			map.put("nome", null);
		}
		else {
			map.put(
				"nome",
				String.valueOf(componenteNucleoFamiliareLight.getNome()));
		}

		if (componenteNucleoFamiliareLight.getSesso() == null) {
			map.put("sesso", null);
		}
		else {
			map.put(
				"sesso",
				String.valueOf(componenteNucleoFamiliareLight.getSesso()));
		}

		return map;
	}

	public static class ComponenteNucleoFamiliareLightJSONParser
		extends BaseJSONParser<ComponenteNucleoFamiliareLight> {

		@Override
		protected ComponenteNucleoFamiliareLight createDTO() {
			return new ComponenteNucleoFamiliareLight();
		}

		@Override
		protected ComponenteNucleoFamiliareLight[] createDTOArray(int size) {
			return new ComponenteNucleoFamiliareLight[size];
		}

		@Override
		protected void setField(
			ComponenteNucleoFamiliareLight componenteNucleoFamiliareLight,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "codiceFiscale")) {
				if (jsonParserFieldValue != null) {
					componenteNucleoFamiliareLight.setCodiceFiscale(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "cognome")) {
				if (jsonParserFieldValue != null) {
					componenteNucleoFamiliareLight.setCognome(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataNascita")) {
				if (jsonParserFieldValue != null) {
					componenteNucleoFamiliareLight.setDataNascita(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nome")) {
				if (jsonParserFieldValue != null) {
					componenteNucleoFamiliareLight.setNome(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sesso")) {
				if (jsonParserFieldValue != null) {
					componenteNucleoFamiliareLight.setSesso(
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