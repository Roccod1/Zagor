package it.servizidigitali.presentatoreforms.frontend.util.alpaca;

import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.enumeration.AlpacaKey;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.enumeration.AlpacaOptionType;
import it.servizidigitali.presentatoreforms.frontend.util.alpaca.enumeration.AlpacaSchemaType;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonSchemaStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.frontend.util.model.FormData;
import it.servizidigitali.presentatoreforms.frontend.util.model.Placeholder;
import it.servizidigitali.presentatoreforms.frontend.util.model.Placeholders;


public class AlpacaUtil {
	private static final String ALLEGATI = "<div class='text-center' style='page-break-before: always'>Allegati Richiesti</div><br><br><h4 style='text-align: left;'>Gli allegati riportati di seguito con la spunta, sono obbligatori per l'invio della pratica:</h4><br>";
	private static final String ALLEGATO_CHECKBOX = "allegato-checkbox-";
	private static final String HTML_SPAZIO_ALLEGATI = "<div data-alpaca-wizard-role='step' data-alpaca-wizard-step-title='StepAllegati'>";
	private static final String CUSTOM_FIELD_DATA_SOURCE = "";
	private static final String PUBLIC_SERVER_ADDRESS = "";
	private static final String FORM_PRESENTER_PORTLET_API_ALPACA_PATH = "";
	
	public static final Log log = LogFactoryUtil.getLog(AlpacaUtil.class);
	
	/**
	 * Restituisce true se il form con gli allegati non ha campi, caso EGOV-2 -> ALLEGATI
	 * @throws JSONException 
	 */
	
	public static boolean isEmptyForm(String modelloForm) throws JSONException {
		
		JSONDeserializer<AlpacaJsonStructure> desAlpacaJsonStructure = JSONFactoryUtil.createJSONDeserializer();
		JSONDeserializer<AlpacaJsonSchemaStructure> desAlpacaJsonSchemaStructure = JSONFactoryUtil.createJSONDeserializer();

		
		if (Validator.isNull(modelloForm)) {
			return true;
		}

		AlpacaJsonStructure alpacaStructure = desAlpacaJsonStructure.deserialize(modelloForm, AlpacaJsonStructure.class);
		AlpacaJsonSchemaStructure jsonSchema = desAlpacaJsonSchemaStructure.deserialize(alpacaStructure.getSchema().toString(), AlpacaJsonSchemaStructure.class);
		
		String properties = JSONFactoryUtil.createJSONSerializer().serialize(jsonSchema.getProperties());
		
		JSONObject propertiesObject = JSONFactoryUtil.createJSONObject(properties);
		
		if(Validator.isNull(propertiesObject)) {
			return true;
		}
		
		return false;

	}
	
	/**
	 * Aggiunge alle options gli allegati passati come parametro.
	 *
	 * @param json Il json da utilizzare come schema.
	 * @param definizioneAllegati
	 * @param enteId L'id dell'ente.
	 * @param addDataSources
	 * @return Restituisce le options con gli allegati.
	 * @throws JSONException 
	 */
	public static JSONObject loadOptions(final String json, final List<DefinizioneAllegato> definizioneAllegati) throws JSONException {
		
		JSONDeserializer<AlpacaJsonOptionsStructure> des = JSONFactoryUtil.createJSONDeserializer();
		AlpacaJsonOptionsStructure jsonOptions = des.deserialize(json, AlpacaJsonOptionsStructure.class);
		String fields = JSONFactoryUtil.createJSONSerializer().serialize(jsonOptions.getFields());
		JSONObject fieldsObject = JSONFactoryUtil.createJSONObject(fields);
		int i = 0;

		// stabilisci order
		int fieldsSize = fields.length();

		// Aggiunge la sezione degli allegati nel form
		for (Iterator<DefinizioneAllegato> iterator = definizioneAllegati.iterator(); iterator.hasNext(); i++) {
			DefinizioneAllegato allegato = iterator.next();

			JSONObject value = JSONFactoryUtil.createJSONObject();
			if (i == 0) {
				value.put(AlpacaKey.LABEL.getName(), ALLEGATI);
			}

			String fieldClass = allegato.getCodiciTipologiaDocumento();
			if (fieldClass != null) {
				fieldClass = fieldClass.replaceAll(",", " ");
			}

			value.put(AlpacaKey.TYPE.getName(), AlpacaOptionType.CHECKBOX.getName());
			value.put(AlpacaKey.RIGHT_LABEL.getName(), allegato.getDenominazione());
			value.put(AlpacaKey.ORDER.getName(), ++fieldsSize);
			if (fieldClass != null) {
				value.put(AlpacaKey.FIELD_CLASS.getName(), fieldClass);
			}
			fieldsObject.put(generateAllegatoCheckboxName(allegato), value);
		}
		
		// capire a cosa serve questo aggiungiDataSource
		// capire come implementarlo

//		if (addDataSources) {
//			aggiungiDataSource(fields, enteId);
//		}
		
		jsonOptions.setFields(fieldsObject);

		return JSONFactoryUtil.createJSONObject(JSONFactoryUtil.createJSONSerializer().serialize(jsonOptions));
	}
	
	/**
	 * Aggiunge allo schema gli allegati passati come parametro.
	 *
	 * @param json Il json da utilizzare come schema.
	 * @param definizioneAllegati La lista delle definizioni degli allegati.
	 * @return Restituisce lo schema con gli allegati.
	 * @throws JSONException 
	 */
	public static JSONObject addAttachmentsToSchema(final String json, final List<DefinizioneAllegato> definizioneAllegati) throws JSONException {
		JSONDeserializer<AlpacaJsonSchemaStructure> desAlpacaJsonSchemaStructure = JSONFactoryUtil.createJSONDeserializer();
		AlpacaJsonSchemaStructure jsonSchema = desAlpacaJsonSchemaStructure.deserialize(json, AlpacaJsonSchemaStructure.class);
		String properties = JSONFactoryUtil.createJSONSerializer().serialize(jsonSchema.getProperties());
		String dependencies = JSONFactoryUtil.createJSONSerializer().serialize(jsonSchema.getDependencies());
		
		JSONObject propertiesObject = JSONFactoryUtil.createJSONObject(properties);
		JSONObject dependenciesObject = JSONFactoryUtil.createJSONObject(dependencies);
		
		System.out.println(propertiesObject);

		for (DefinizioneAllegato allegato : definizioneAllegati) {
			JSONObject value = JSONFactoryUtil.createJSONObject();
			value.put(AlpacaKey.TYPE.getName(), AlpacaSchemaType.BOOLEAN.getName());
			value.put(AlpacaKey.DEFAULT.getName(), allegato.isObbligatorio());
			value.put(AlpacaKey.READONLY.getName(), allegato.isObbligatorio());
			propertiesObject.put(generateAllegatoCheckboxName(allegato), value);
		}
		
		jsonSchema.setProperties(propertiesObject);
		jsonSchema.setDependencies(dependenciesObject);
		
		return JSONFactoryUtil.createJSONObject(JSONFactoryUtil.createJSONSerializer().serialize(jsonSchema));
	}
	
	/**
	 * Carica il campo data con i valori passati.
	 *
	 * @param data I dati da caricare nel {@link JsonObject}.
	 * @return Restituisce un {@link JsonObject} con i dati caricati al suo interno.
	 */
	private static JSONObject loadData(final String data) throws JSONException{
		return JSONFactoryUtil.createJSONObject(data);
	}
	
	/**
	 *
	 * @param view
	 * @param definizioneAllegati
	 * @return
	 * @throws JSONException 
	 */
	public static JSONObject addAttachmentsToView(final String view, final List<DefinizioneAllegato> definizioneAllegati) throws JSONException {
		JSONObject jsonView = JSONFactoryUtil.createJSONObject(view);
		return jsonView;
	}
	
	/**
	 * Carica la struttura Json di Alpaca nell'oggetto {@link FormData}.
	 *
	 * @param ddf La definizione del form.
	 * @param savedJson I dati di {@link FormData} che contengono quelli di Alpaca (schema, options,
	 *        data, view) da utilizzare per fare la sostituzione.
	 * @param enteId L'ente id utilizzato come discriminante per capire se siamo o meno in modalità
	 *        lettura.
	 * @param addDataSources
	 * @return Restituisce un'istanza di {@link AlpacaJsonStructure} che contiene i dati relativi al
	 *         form.
	 */
	public static FormData loadFormData(final Form form, final String savedJson) throws JSONException{
		log.debug("loadFormData");
		FormData formData = new FormData();
		JSONDeserializer<AlpacaJsonStructure> des = JSONFactoryUtil.createJSONDeserializer();
		
		
		// temp poiché listaAllegati arriva null
		
		List<DefinizioneAllegato> listaAllegati = new ArrayList<>();
		if (savedJson == null) {
			AlpacaJsonStructure alpacaStructure = des.deserialize(form.getJson(), AlpacaJsonStructure.class);

			alpacaStructure.setSchema(addAttachmentsToSchema(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getSchema()), listaAllegati));
			alpacaStructure.setOptions(loadOptions(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getOptions()), listaAllegati));
			alpacaStructure.setData(loadData(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getData())));
			alpacaStructure.setView(addAttachmentsToView(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getView()), listaAllegati));
			formData.setAlpaca(alpacaStructure);
		}
		else {
			// This should overwrite the past configuration
			JSONDeserializer<FormData> desFormData = JSONFactoryUtil.createJSONDeserializer();
			formData = desFormData.deserialize(savedJson, FormData.class);
		}

		return formData;
	}
	
	private static String generateAllegatoCheckboxName(final DefinizioneAllegato allegato) {
		return ALLEGATO_CHECKBOX + allegato.getDefinizioneAllegatoId();
	}
	
	/**
	 * Carica il campo view con i valori passati.
	 *
	 * @param data I dati da caricare nel {@link JsonObject}.
	 * @return Restituisce un {@link JsonObject} con i dati caricati al suo interno.
	 * @throws JSONException 
	 */
	private static JSONObject parseView(final String view) throws JSONException {
		return JSONFactoryUtil.createJSONObject(view);
	}
	
	/**
	 * Carica la struttura Json di della view nell'oggetto {@link AlpacaJsonStructure}.
	 *
	 * @param alpacaStructure Contiene la view in formato LinkedTreeMap<>
	 * @return Restituisce un'istanza di {@link AlpacaJsonStructure} che contiene i dati relativi al
	 *         form con la view in formato json.
	 * @throws JSONException 
	 */
	public static AlpacaJsonStructure loadView(final AlpacaJsonStructure alpacaStructure) throws JSONException {
		/* se la view è null, setto la view di default ovvero "locale": "it_IT"; */
		if (alpacaStructure.getView() == null || (alpacaStructure.getView() != null && "".equals(alpacaStructure.getView()))) {
			LinkedHashMap<String, String> view = new LinkedHashMap<>();
			view.put("locale", "it_IT");
			alpacaStructure.setView(view);
		}
		alpacaStructure.setView(AlpacaUtil.parseView(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getView())));
		return alpacaStructure;
	}
	
	/**
	 * Carica la struttura Json di Alpaca se il form con gli allegati non ha campi, caso EGOV-2 ->
	 * ALLEGATI
	 *
	 * @param ddf La definizione del form.
	 * @throws JSONException 
	 */
	public static FormData loadFormDataWhenEmptyFields(final Form form) throws JSONException {
		log.debug("loadFormData");
		JSONDeserializer<AlpacaJsonStructure> des = JSONFactoryUtil.createJSONDeserializer();
		FormData formData = new FormData();
		

		AlpacaJsonStructure alpacaStructure = des.deserialize(form.getJson(), AlpacaJsonStructure.class);
		alpacaStructure.setSchema(addAttachmentsToSchema(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
		// alpacaStructure.setOptions(loadOptions(gson.toJson(alpacaStructure.getOptions()),
		// ddf.getDefinizioneAllegati(), enteId));
		alpacaStructure.setData(loadData(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getData())));
		alpacaStructure.setView(addAttachmentsToView(JSONFactoryUtil.createJSONSerializer().serialize(alpacaStructure.getView()), form.getListaDefinizioneAllegato()));
		formData.setAlpaca(alpacaStructure);

		return formData;
	}
	
	/**
	 * Restituisce true se la key passata è un allegato checkbox.
	 *
	 * @param key La key da controllare.
	 * @return Restituisce true se la chiave passata è un allegato checkbox, false in caso
	 *         contrario.
	 */
	public static boolean isAllegatoCheckboxName(final String key) {
		return key.startsWith(ALLEGATO_CHECKBOX);
	}
	
	/**
	 * Find all the searchList {@link String}s in text and replace them using replacementList
	 * {@link String}s.
	 *
	 * @param text The text from which find the searchList.
	 * @param searchList The list of {@link String} to find.
	 * @param replacementList The list of {@link String} to use to replace.
	 * @return Returns the replaced {@link String}.
	 */
//	private static String replaceEach(String text, String[] searchList, String[] replacementList) {
//		for (int i = 0; i < searchList.length; i++) {
//			text = StringUtils.replace(text, searchList[i], replacementList[i]);
//		}
//		return text;
//	}
	
	/**
	 * Costruisce l'URL per i contatti.
	 *
	 * @param idComune L'id del comune.
	 * @param codiceServizio Il codice del servizio.
	 * @return Restituisce l'URL per i contatti in base i parametri passati.
	 */
	public static String buildContattiUrl(String idComune, String codiceServizio) {
		return CUSTOM_FIELD_DATA_SOURCE + "/contatti/" + idComune + "/" + codiceServizio + "/" + codiceServizio + ".json";
	}
	
	/**
	 * Risolve il valore dei placeholder.
	 *
	 * @param text La stringa su cui effettuare le sostituzioni.
	 * @param placeholders I placeholders da utilizzare.
	 * @return Restituisce la stringa con i placeholder sostituiti.
	 */
//	public static String risolviPlaceholder(String text, Placeholders placeholders) {
//		List<Placeholder> placeholderList = placeholders.getList();
//		List<String> keys = new ArrayList<String>();
//		List<String> values = new ArrayList<String>();
//		for (Placeholder placeholder : placeholderList) {
//			keys.add(placeholder.getKey());
//			values.add(placeholder.getValue());
//		}
//		String[] searchList = keys.toArray(new String[keys.size()]);
//		String[] replacementList = values.toArray(new String[values.size()]);
//		return replaceEach(text, searchList, replacementList);
//	}
	

}
