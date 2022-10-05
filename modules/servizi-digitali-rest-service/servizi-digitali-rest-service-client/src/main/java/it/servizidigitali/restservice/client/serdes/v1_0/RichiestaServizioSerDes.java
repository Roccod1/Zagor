package it.servizidigitali.restservice.client.serdes.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.RichiestaServizio;
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

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (richiestaServizio.getCodiceAreaTematica() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceAreaTematica\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getCodiceAreaTematica()));

			sb.append("\"");
		}

		if (richiestaServizio.getCodiceFiscaleDelegato() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceFiscaleDelegato\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getCodiceFiscaleDelegato()));

			sb.append("\"");
		}

		if (richiestaServizio.getCodiceFiscaleRichiedente() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceFiscaleRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getCodiceFiscaleRichiedente()));

			sb.append("\"");
		}

		if (richiestaServizio.getCodiceIdentificativoServizio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceIdentificativoServizio\": ");

			sb.append("\"");

			sb.append(
				_escape(richiestaServizio.getCodiceIdentificativoServizio()));

			sb.append("\"");
		}

		if (richiestaServizio.getDataAggiornamento() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataAggiornamento\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataAggiornamento()));

			sb.append("\"");
		}

		if (richiestaServizio.getDataInserimento() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataInserimento\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataInserimento()));

			sb.append("\"");
		}

		if (richiestaServizio.getDataProtocollo() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataProtocollo\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataProtocollo()));

			sb.append("\"");
		}

		if (richiestaServizio.getDataProtocolloEsterno() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataProtocolloEsterno\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataProtocolloEsterno()));

			sb.append("\"");
		}

		if (richiestaServizio.getDenominazioneAreaTematica() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneAreaTematica\": ");

			sb.append("\"");

			sb.append(
				_escape(richiestaServizio.getDenominazioneAreaTematica()));

			sb.append("\"");
		}

		if (richiestaServizio.getDenominazioneEnte() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneEnte\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getDenominazioneEnte()));

			sb.append("\"");
		}

		if (richiestaServizio.getDenominazioneRichiedente() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getDenominazioneRichiedente()));

			sb.append("\"");
		}

		if (richiestaServizio.getDenominazioneServizio() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"denominazioneServizio\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getDenominazioneServizio()));

			sb.append("\"");
		}

		if (richiestaServizio.getEmailRichiedente() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getEmailRichiedente()));

			sb.append("\"");
		}

		if (richiestaServizio.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(richiestaServizio.getId());
		}

		if (richiestaServizio.getIdProcedura() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"idProcedura\": ");

			sb.append(richiestaServizio.getIdProcedura());
		}

		if (richiestaServizio.getIdentificativoEnte() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"identificativoEnte\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getIdentificativoEnte()));

			sb.append("\"");
		}

		if (richiestaServizio.getIdentificativoProcesso() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"identificativoProcesso\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getIdentificativoProcesso()));

			sb.append("\"");
		}

		if (richiestaServizio.getNote() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"note\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getNote()));

			sb.append("\"");
		}

		if (richiestaServizio.getNumeroProtocollo() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"numeroProtocollo\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getNumeroProtocollo()));

			sb.append("\"");
		}

		if (richiestaServizio.getNumeroProtocolloEsterno() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"numeroProtocolloEsterno\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getNumeroProtocolloEsterno()));

			sb.append("\"");
		}

		if (richiestaServizio.getOggetto() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"oggetto\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getOggetto()));

			sb.append("\"");
		}

		if (richiestaServizio.getPartitaIvaRichiedente() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"partitaIvaRichiedente\": ");

			sb.append("\"");

			sb.append(_escape(richiestaServizio.getPartitaIvaRichiedente()));

			sb.append("\"");
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

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (richiestaServizio.getCodiceAreaTematica() == null) {
			map.put("codiceAreaTematica", null);
		}
		else {
			map.put(
				"codiceAreaTematica",
				String.valueOf(richiestaServizio.getCodiceAreaTematica()));
		}

		if (richiestaServizio.getCodiceFiscaleDelegato() == null) {
			map.put("codiceFiscaleDelegato", null);
		}
		else {
			map.put(
				"codiceFiscaleDelegato",
				String.valueOf(richiestaServizio.getCodiceFiscaleDelegato()));
		}

		if (richiestaServizio.getCodiceFiscaleRichiedente() == null) {
			map.put("codiceFiscaleRichiedente", null);
		}
		else {
			map.put(
				"codiceFiscaleRichiedente",
				String.valueOf(
					richiestaServizio.getCodiceFiscaleRichiedente()));
		}

		if (richiestaServizio.getCodiceIdentificativoServizio() == null) {
			map.put("codiceIdentificativoServizio", null);
		}
		else {
			map.put(
				"codiceIdentificativoServizio",
				String.valueOf(
					richiestaServizio.getCodiceIdentificativoServizio()));
		}

		if (richiestaServizio.getDataAggiornamento() == null) {
			map.put("dataAggiornamento", null);
		}
		else {
			map.put(
				"dataAggiornamento",
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataAggiornamento()));
		}

		if (richiestaServizio.getDataInserimento() == null) {
			map.put("dataInserimento", null);
		}
		else {
			map.put(
				"dataInserimento",
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataInserimento()));
		}

		if (richiestaServizio.getDataProtocollo() == null) {
			map.put("dataProtocollo", null);
		}
		else {
			map.put(
				"dataProtocollo",
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataProtocollo()));
		}

		if (richiestaServizio.getDataProtocolloEsterno() == null) {
			map.put("dataProtocolloEsterno", null);
		}
		else {
			map.put(
				"dataProtocolloEsterno",
				liferayToJSONDateFormat.format(
					richiestaServizio.getDataProtocolloEsterno()));
		}

		if (richiestaServizio.getDenominazioneAreaTematica() == null) {
			map.put("denominazioneAreaTematica", null);
		}
		else {
			map.put(
				"denominazioneAreaTematica",
				String.valueOf(
					richiestaServizio.getDenominazioneAreaTematica()));
		}

		if (richiestaServizio.getDenominazioneEnte() == null) {
			map.put("denominazioneEnte", null);
		}
		else {
			map.put(
				"denominazioneEnte",
				String.valueOf(richiestaServizio.getDenominazioneEnte()));
		}

		if (richiestaServizio.getDenominazioneRichiedente() == null) {
			map.put("denominazioneRichiedente", null);
		}
		else {
			map.put(
				"denominazioneRichiedente",
				String.valueOf(
					richiestaServizio.getDenominazioneRichiedente()));
		}

		if (richiestaServizio.getDenominazioneServizio() == null) {
			map.put("denominazioneServizio", null);
		}
		else {
			map.put(
				"denominazioneServizio",
				String.valueOf(richiestaServizio.getDenominazioneServizio()));
		}

		if (richiestaServizio.getEmailRichiedente() == null) {
			map.put("emailRichiedente", null);
		}
		else {
			map.put(
				"emailRichiedente",
				String.valueOf(richiestaServizio.getEmailRichiedente()));
		}

		if (richiestaServizio.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(richiestaServizio.getId()));
		}

		if (richiestaServizio.getIdProcedura() == null) {
			map.put("idProcedura", null);
		}
		else {
			map.put(
				"idProcedura",
				String.valueOf(richiestaServizio.getIdProcedura()));
		}

		if (richiestaServizio.getIdentificativoEnte() == null) {
			map.put("identificativoEnte", null);
		}
		else {
			map.put(
				"identificativoEnte",
				String.valueOf(richiestaServizio.getIdentificativoEnte()));
		}

		if (richiestaServizio.getIdentificativoProcesso() == null) {
			map.put("identificativoProcesso", null);
		}
		else {
			map.put(
				"identificativoProcesso",
				String.valueOf(richiestaServizio.getIdentificativoProcesso()));
		}

		if (richiestaServizio.getNote() == null) {
			map.put("note", null);
		}
		else {
			map.put("note", String.valueOf(richiestaServizio.getNote()));
		}

		if (richiestaServizio.getNumeroProtocollo() == null) {
			map.put("numeroProtocollo", null);
		}
		else {
			map.put(
				"numeroProtocollo",
				String.valueOf(richiestaServizio.getNumeroProtocollo()));
		}

		if (richiestaServizio.getNumeroProtocolloEsterno() == null) {
			map.put("numeroProtocolloEsterno", null);
		}
		else {
			map.put(
				"numeroProtocolloEsterno",
				String.valueOf(richiestaServizio.getNumeroProtocolloEsterno()));
		}

		if (richiestaServizio.getOggetto() == null) {
			map.put("oggetto", null);
		}
		else {
			map.put("oggetto", String.valueOf(richiestaServizio.getOggetto()));
		}

		if (richiestaServizio.getPartitaIvaRichiedente() == null) {
			map.put("partitaIvaRichiedente", null);
		}
		else {
			map.put(
				"partitaIvaRichiedente",
				String.valueOf(richiestaServizio.getPartitaIvaRichiedente()));
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

			if (Objects.equals(jsonParserFieldName, "codiceAreaTematica")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setCodiceAreaTematica(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "codiceFiscaleDelegato")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setCodiceFiscaleDelegato(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "codiceFiscaleRichiedente")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setCodiceFiscaleRichiedente(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "codiceIdentificativoServizio")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setCodiceIdentificativoServizio(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataAggiornamento")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setDataAggiornamento(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataInserimento")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setDataInserimento(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dataProtocollo")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setDataProtocollo(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "dataProtocolloEsterno")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setDataProtocolloEsterno(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "denominazioneAreaTematica")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setDenominazioneAreaTematica(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "denominazioneEnte")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setDenominazioneEnte(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "denominazioneRichiedente")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setDenominazioneRichiedente(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "denominazioneServizio")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setDenominazioneServizio(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailRichiedente")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setEmailRichiedente(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "idProcedura")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setIdProcedura(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "identificativoEnte")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setIdentificativoEnte(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "identificativoProcesso")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setIdentificativoProcesso(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "note")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setNote((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "numeroProtocollo")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setNumeroProtocollo(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "numeroProtocolloEsterno")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setNumeroProtocolloEsterno(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "oggetto")) {
				if (jsonParserFieldValue != null) {
					richiestaServizio.setOggetto((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "partitaIvaRichiedente")) {

				if (jsonParserFieldValue != null) {
					richiestaServizio.setPartitaIvaRichiedente(
						(String)jsonParserFieldValue);
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