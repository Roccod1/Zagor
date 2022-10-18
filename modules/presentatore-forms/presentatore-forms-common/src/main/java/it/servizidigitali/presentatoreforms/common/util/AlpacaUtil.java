package it.servizidigitali.presentatoreforms.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.util.Map.Entry;
import java.util.Set;

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.presentatoreforms.common.enumeration.AlpacaKey;
import it.servizidigitali.presentatoreforms.common.enumeration.AlpacaOptionType;
import it.servizidigitali.presentatoreforms.common.enumeration.AlpacaSchemaType;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonOptionsStructure;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonSchemaStructure;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.model.Placeholders;

public class AlpacaUtil {

	private static final String ALLEGATI = "<div class='text-center' style='page-break-before: always'>Allegati Richiesti</div><br><br><h4 style='text-align: left;'>Gli allegati riportati di seguito con la spunta, sono obbligatori per l'invio della pratica:</h4><br>";
	private static final String ALLEGATO_CHECKBOX = "allegato-checkbox-";
	private static final String HTML_SPAZIO_ALLEGATI = "<div data-alpaca-wizard-role='step' data-alpaca-wizard-step-title='StepAllegati'>";
	private static final String SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH = "/o/api/alpaca";

	public static final Log log = LogFactoryUtil.getLog(AlpacaUtil.class);

	/**
	 * Restituisce true se il form con gli allegati non ha campi, caso EGOV-2 -> ALLEGATI
	 *
	 * @throws JSONException
	 */

	public static boolean isEmptyForm(String modelloForm) {
		if (Validator.isNull(modelloForm)) {
			return true;
		}

		Gson gson = new Gson();

		AlpacaJsonStructure alpacaStructure = gson.fromJson(modelloForm, AlpacaJsonStructure.class);
		AlpacaJsonSchemaStructure jsonSchema = gson.fromJson(gson.toJson(alpacaStructure.getSchema()), AlpacaJsonSchemaStructure.class);
		JsonObject properties = jsonSchema.getProperties();

		return properties.entrySet().isEmpty();
	}

	/**
	 * ggiunge alle options gli allegati passati come parametro.
	 *
	 * @param json
	 * @param definizioneAllegati
	 * @param addDataSources
	 * @return
	 */
	public static JsonObject loadOptions(final String json, final List<DefinizioneAllegato> definizioneAllegati, boolean addDataSources, String portalURL) {
		Gson gson = new Gson();
		AlpacaJsonOptionsStructure jsonOptions = gson.fromJson(json, AlpacaJsonOptionsStructure.class);
		JsonObject fields = jsonOptions.getFields();
		int i = 0;

		// stabilisci order
		int fieldsSize = fields.entrySet().size();

		// Aggiunge la sezione degli allegati nel form
		for (Iterator<DefinizioneAllegato> iterator = definizioneAllegati.iterator(); iterator.hasNext(); i++) {
			DefinizioneAllegato allegato = iterator.next();

			JsonObject value = new JsonObject();
			if (i == 0) {
				value.addProperty(AlpacaKey.LABEL.getName(), ALLEGATI);
			}

			String fieldClass = allegato.getCodiciTipologiaDocumento();
			if (fieldClass != null) {
				fieldClass = fieldClass.replaceAll(",", " ");
			}

			value.addProperty(AlpacaKey.TYPE.getName(), AlpacaOptionType.CHECKBOX.getName());
			value.addProperty(AlpacaKey.RIGHT_LABEL.getName(), allegato.getDenominazione());
			value.addProperty(AlpacaKey.ORDER.getName(), ++fieldsSize);
			if (fieldClass != null) {
				value.addProperty(AlpacaKey.FIELD_CLASS.getName(), fieldClass);
			}
			fields.add(generateAllegatoCheckboxName(allegato), value);
		}

		if (addDataSources) {
			aggiungiDataSource(fields, portalURL);
		}

		return gson.toJsonTree(jsonOptions).getAsJsonObject();
	}

	private static void aggiungiDataSource(final JsonObject fields, String portalURL) {

		for (Entry<String, JsonElement> entry : fields.entrySet()) {

			if (!(entry.getValue() instanceof JsonObject)) {
				log.error("Tipo di dato non valido: " + entry.getKey());
				continue;
			}

			JsonObject object = entry.getValue().getAsJsonObject();
			if (object.get(AlpacaKey.TYPE.getName()) == null) {
				log.error("Il parametro Type risulta mancante: " + entry.getKey());
				continue;
			}

			String type = object.get(AlpacaKey.TYPE.getName()).getAsString();

			// Se a sua volta questo è un oggetto complesso
			if (object.has(AlpacaKey.FIELDS.getName())) {
				JsonObject fieldsObject = object.get(AlpacaKey.FIELDS.getName()).getAsJsonObject();

				if (!fieldsObject.entrySet().isEmpty()) {
					aggiungiDataSource(fieldsObject, portalURL);
				}
			}

			if (type.equalsIgnoreCase(AlpacaOptionType.NAZIONE.getName())) {
				String url = portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/stati-esteri";
				object.addProperty(AlpacaKey.DATA_SOURCE.getName(), url);
			}

			if (type.equalsIgnoreCase(AlpacaOptionType.PROVINCIA.getName())) {
				String url = portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/province";
				object.addProperty(AlpacaKey.DATA_SOURCE.getName(), url);
			}

			if (type.equalsIgnoreCase(AlpacaOptionType.COMUNE.getName())) {
				String url = portalURL + SERVIZI_DIGITALI_REST_CUSTOM_API_ALPACA_PATH + "/comuni";
				object.addProperty(AlpacaKey.DATA_SOURCE.getName(), url);
			}
		}
	}

	/**
	 * Aggiunge allo schema gli allegati passati come parametro.
	 *
	 * @param json Il json da utilizzare come schema.
	 * @param definizioneAllegati La lista delle definizioni degli allegati.
	 * @return Restituisce lo schema con gli allegati.
	 * @throws JSONException
	 */
	public static JsonObject addAttachmentsToSchema(final String json, final List<DefinizioneAllegato> definizioneAllegati) {
		Gson gson = new Gson();

		AlpacaJsonSchemaStructure jsonSchema = gson.fromJson(json, AlpacaJsonSchemaStructure.class);
		JsonObject properties = jsonSchema.getProperties();

		for (DefinizioneAllegato allegato : definizioneAllegati) {
			JsonObject value = new JsonObject();
			value.addProperty(AlpacaKey.TYPE.getName(), AlpacaSchemaType.BOOLEAN.getName());
			value.addProperty(AlpacaKey.DEFAULT.getName(), allegato.isObbligatorio());
			value.addProperty(AlpacaKey.READONLY.getName(), allegato.isObbligatorio());
			properties.add(generateAllegatoCheckboxName(allegato), value);
		}
		return gson.toJsonTree(jsonSchema).getAsJsonObject();
	}

	/**
	 * Converte i componenti dell'AlpacaJsonStructure in JsonObject
	 *
	 * @param placeholders L'oggetto {@link Placeholders} da utilizzare per la sostituzione.
	 * @param alpacaStructure La struttura JSON da utilizzare e sostituire.
	 * @return Restituisce la stringa con i placeholder sostituiti.
	 */
	public static AlpacaJsonStructure convertiComponentiAlpacaStructure(final AlpacaJsonStructure alpacaStructure) {
		Gson gson = new Gson();
		String options = gson.toJson(alpacaStructure.getOptions());
		String schema = gson.toJson(alpacaStructure.getSchema());
		JsonObject jsonOptions = gson.fromJson(options, JsonObject.class);
		JsonObject jsonSchema = gson.fromJson(schema, JsonObject.class);
		alpacaStructure.setSchema(gson.toJsonTree(jsonSchema).getAsJsonObject());
		alpacaStructure.setOptions(gson.toJsonTree(jsonOptions).getAsJsonObject());
		return alpacaStructure;
	}

	/**
	 * Carica il campo data con i valori passati.
	 *
	 * @param data I dati da caricare nel {@link JsonObject}.
	 * @return Restituisce un {@link JsonObject} con i dati caricati al suo interno.
	 */
	private static JsonObject loadData(final String data) {
		return new JsonParser().parse(data).getAsJsonObject();
	}

	/**
	 *
	 * @param view
	 * @param definizioneAllegati
	 * @return
	 * @throws JSONException
	 */
	public static JsonObject addAttachmentsToView(final String view, final List<DefinizioneAllegato> definizioneAllegati) {
		if (view != null && !view.isEmpty()) {
			Gson gson = new Gson();
			// JsonObject jsonObject = new JsonParser().parse(view).getAsJsonObject();
			JsonObject jsonView = gson.fromJson(view, JsonObject.class);

			String finalHtmlAttachments = HTML_SPAZIO_ALLEGATI;
			String templateString = "";

			JsonElement jsonElementWizard = jsonView.get(AlpacaKey.WIZARD.getName());
			if (jsonElementWizard != null) {
				JsonObject wizard = jsonElementWizard.getAsJsonObject();
				if (wizard != null) {
					JsonObject bindings = wizard.get(AlpacaKey.BINDINGS.getName()).getAsJsonObject();
					JsonArray steps = wizard.get(AlpacaKey.STEPS.getName()).getAsJsonArray();
					if (steps != null) {
						int attachmentsStep = (steps.size() > 0) ? steps.size() : 1;
						for (DefinizioneAllegato allegato : definizioneAllegati) {
							bindings.addProperty(generateAllegatoCheckboxName(allegato), attachmentsStep);
							finalHtmlAttachments = finalHtmlAttachments + "<div class='row'><div class='col-md-12' data-alpaca-layout-binding='" + generateAllegatoCheckboxName(allegato)
									+ "'></div></div>";
						}
						finalHtmlAttachments = finalHtmlAttachments + "</div>";

						// wizard.remove(AlpacaKey.BINDINGS.getName());
						wizard.add(AlpacaKey.BINDINGS.getName(), bindings);

						JsonObject jsonElementLayout = jsonView.getAsJsonObject(AlpacaKey.LAYOUT.getName());
						if (jsonElementLayout != null) {
							JsonElement jsonElementTemplate = jsonElementLayout.get(AlpacaKey.TEMPLATE.getName());
							if (jsonElementTemplate != null) {
								templateString = jsonElementTemplate.getAsString();

								if (templateString.contains(HTML_SPAZIO_ALLEGATI)) {
									String newTemplateString = templateString.replace(HTML_SPAZIO_ALLEGATI, finalHtmlAttachments);
									jsonElementLayout.remove("template");
									jsonElementLayout.addProperty("template", newTemplateString);
								}
							}
						}
					}
				}
			}

			return jsonView;
		}

		return null;
	}

	/**
	 * Carica la struttura Json di Alpaca nell'oggetto {@link FormData}.
	 *
	 * @param form La definizione del form.
	 * @param savedJson I dati di {@link FormData} che contengono quelli di Alpaca (schema, options,
	 *        data, view) da utilizzare per fare la sostituzione.
	 * @param addDataSources
	 * @return Restituisce un'istanza di {@link AlpacaJsonStructure} che contiene i dati relativi al
	 *         form.
	 */
	public static FormData loadFormData(final Form form, final String savedJson, boolean addDataSources, String portalURL) {
		log.debug("loadFormData");
		Gson gson = new Gson();
		FormData formData = new FormData();
		if (savedJson == null) {
			AlpacaJsonStructure alpacaStructure = gson.fromJson(form.getJson(), AlpacaJsonStructure.class);
			alpacaStructure.setSchema(addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
			alpacaStructure.setOptions(loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), addDataSources, portalURL));
			alpacaStructure.setData(loadData(gson.toJson(alpacaStructure.getData())));
			alpacaStructure.setView(addAttachmentsToView(gson.toJson(alpacaStructure.getView()), form.getListaDefinizioneAllegato()));
			formData.setAlpaca(alpacaStructure);
		}
		else {
			// This should overwrite the past configuration
			formData = gson.fromJson(savedJson, FormData.class);
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

		Gson gson = new Gson();
		/* se la view è null, setto la view di default ovvero "locale": "it_IT"; */
		if (alpacaStructure.getView() == null || (alpacaStructure.getView() != null && "".equals(alpacaStructure.getView()))) {
			LinkedHashMap<String, String> view = new LinkedHashMap<>();
			view.put("locale", "it_IT");
			alpacaStructure.setView(view);
		}
		alpacaStructure.setView(AlpacaUtil.parseView(gson.toJson(alpacaStructure.getView())));
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
	 *
	 * @param alpacaJsonOptionsStructure
	 * @param type
	 * @return
	 */
	public static String getFieldNameDataContainer(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, String type) {

		Set<Entry<String, JsonElement>> optionsFields = alpacaJsonOptionsStructure.getFields().entrySet();

		if (optionsFields != null) {
			for (Entry<String, JsonElement> entry : optionsFields) {

				String key = entry.getKey();
				JsonElement value = entry.getValue();

				if (value != null && value.getAsJsonObject() != null) {

					JsonObject object = value.getAsJsonObject();

					if (object.get(AlpacaKey.TYPE.getName()) == null) {
						continue;
					}

					String alpacaType = object.get(AlpacaKey.TYPE.getName()).getAsString();
					if (alpacaType.equals(type)) {
						return key;
					}
				}
			}
		}

		return null;
	}

	/**
	 * @param alpacaJsonOptionsStructure
	 * @param types
	 * @return
	 */
	public static List<String> getFieldNameDataContainer(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, String[] types) {

		if (types != null) {
			List<String> fieldNames = new ArrayList<String>();
			for (String type : types) {
				String fieldNameDataContainer = getFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				if (fieldNameDataContainer != null) {
					fieldNames.add(fieldNameDataContainer);
				}
			}
			return fieldNames;

		}
		return null;
	}

	/**
	 * @param alpacaJsonOptionsStructure
	 * @param types
	 * @return
	 */
	public static List<String> getAllFieldNameDataContainer(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, String[] types) {

		if (types != null) {
			List<String> fieldNames = new ArrayList<String>();
			for (String type : types) {
				List<String> fieldNamesDataContainer = getAllFieldNameDataContainer(alpacaJsonOptionsStructure, type);
				if (fieldNamesDataContainer != null) {
					fieldNames.addAll(fieldNamesDataContainer);
				}
			}
			return fieldNames;

		}
		return null;
	}

	/**
	 *
	 * Metodo che ritorna tutti i fieldName del type cercato nel form: gestisce il caso in cui ci
	 * siano più field dello stesso type
	 *
	 * @param alpacaJsonOptionsStructure
	 * @param type
	 * @return
	 */
	public static List<String> getAllFieldNameDataContainer(AlpacaJsonOptionsStructure alpacaJsonOptionsStructure, String type) {

		Set<Entry<String, JsonElement>> optionsFields = alpacaJsonOptionsStructure.getFields().entrySet();
		List<String> fieldNames = new ArrayList<String>();
		if (optionsFields != null) {
			for (Entry<String, JsonElement> entry : optionsFields) {

				String key = entry.getKey();
				JsonElement value = entry.getValue();

				if (value != null && value.getAsJsonObject() != null) {

					JsonObject object = value.getAsJsonObject();

					if (object.get(AlpacaKey.TYPE.getName()) == null) {
						continue;
					}

					String alpacaType = object.get(AlpacaKey.TYPE.getName()).getAsString();
					if (alpacaType.equals(type)) {
						fieldNames.add(key);
					}
				}
			}
			return fieldNames.size() > 0 ? fieldNames : null;
		}

		return null;
	}

}