package it.servizidigitali.presentatoreforms.frontend.portlet.action;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoGenerazionePDF;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.DefinizioneAllegatoLocalService;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.presentatoreforms.common.model.AlpacaJsonStructure;
import it.servizidigitali.presentatoreforms.common.model.FormData;
import it.servizidigitali.presentatoreforms.common.service.AllegatoRichiestaService;
import it.servizidigitali.presentatoreforms.common.service.AlpacaService;
import it.servizidigitali.presentatoreforms.common.service.PDFService;
import it.servizidigitali.presentatoreforms.common.service.PDFServiceFactory;
import it.servizidigitali.presentatoreforms.common.service.integration.input.jsonenrich.model.UserPreferences;
import it.servizidigitali.presentatoreforms.common.service.integration.output.model.DichiarazioneRisposta;
import it.servizidigitali.presentatoreforms.common.util.AlpacaUtil;
import it.servizidigitali.presentatoreforms.frontend.constants.PresentatoreFormsPortletKeys;
import it.servizidigitali.presentatoreforms.frontend.service.PresentatoreFormFrontendService;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(//
		immediate = true, //
		property = { //
				"javax.portlet.name=" + PresentatoreFormsPortletKeys.PRESENTATOREFORMS, //
				"mvc.command.name=" + PresentatoreFormsPortletKeys.SALVA_INVIA_RICHIESTA_ACTION_COMMAND //
		}, //
		service = { MVCActionCommand.class }//
)
public class SalvaInviaRichiestaActionCommand extends BaseMVCActionCommand {

	public static final Log _log = LogFactoryUtil.getLog(SalvaInviaRichiestaActionCommand.class);

	@Reference
	private DefinizioneAllegatoLocalService definizioneAllegatoLocalService;

	@Reference
	private PresentatoreFormFrontendService presentatoreFormFrontendService;

	@Reference
	private AllegatoRichiestaService allegatoRichiestaService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private AlpacaService alpacaService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private PDFServiceFactory pdfServiceFactory;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ResourceBundleLoader resourceBundleLoader = ResourceBundleLoaderUtil.getResourceBundleLoaderByBundleSymbolicName(PresentatoreFormsPortletKeys.BUNDLE_SYMBOLIC_NAME);

		User user = themeDisplay.getUser();
		Procedura procedura = null;
		Form form = null;

		Servizio servizio = null;
		ServizioEnte servizioEnte = null;

		boolean firmaDocumentoAbilitata = false;
		boolean firmaDigitaleDocumentoAbilitata = false;
		List<String> listaFormatiFirma = null;

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		UserPreferences userPreferences = new UserPreferences();
		userPreferences.setCodiceFiscaleRichiedente(user.getScreenName());

		List<String> listaErrori = new ArrayList<String>();

		try {
			procedura = presentatoreFormFrontendService.getCurrentProcedura(themeDisplay);
			servizio = servizioLocalService.getServizio(procedura.getServizioId());
			form = presentatoreFormFrontendService.getFormPrincipaleProcedura(procedura.getProceduraId());
			servizioEnte = presentatoreFormFrontendService.getServizioEnteByPage(themeDisplay);

			if (Validator.isNotNull(servizioEnte)) {
				String listaFormatiFirmaDigitale = servizioEnte.getFormatiFirmaDigitale();
				firmaDocumentoAbilitata = servizioEnte.isRichiestaFirma();

				if (Validator.isNotNull(listaFormatiFirmaDigitale) && servizioEnte.getRichiestaFirma()) {
					listaFormatiFirma = new ArrayList<String>(Arrays.asList(listaFormatiFirmaDigitale.split(" , ")));
					firmaDigitaleDocumentoAbilitata = !listaFormatiFirma.isEmpty();
				}
			}

			if (Validator.isNotNull(procedura) && procedura.getProceduraId() > 0) {

				Richiesta richiesta = presentatoreFormFrontendService.getRichiestaBozza(user.getScreenName(), procedura.getProceduraId());

				if (Validator.isNotNull(form)) {
					String codiceFiscaleComponente = ParamUtil.getString(actionRequest, PresentatoreFormsPortletKeys.CODICE_FISCALE_COMPONENTE);

					byte[] allegatoBytes = null;
					File fileFirmato = uploadPortletRequest.getFile("uploadFileFirmato");
					if (!firmaDocumentoAbilitata && fileFirmato == null) {
						// generazione PDF interna
						PDFService pdfService = pdfServiceFactory.getPDFService(TipoGenerazionePDF.valueOf(procedura.getTipoGenerazionePDF()));

						IstanzaForm istanzaForm = presentatoreFormFrontendService.getIstanzaFormRichiesta(richiesta.getRichiestaId(), form.getFormId());

						FormData formData = AlpacaUtil.loadFormData(form, istanzaForm.getJson(), true, themeDisplay.getPortalURL());
						AlpacaJsonStructure alpacaStructure = formData.getAlpaca();

						Gson gson = new Gson();

						JsonParser jsonParser = new JsonParser();
						alpacaStructure.setSchema(AlpacaUtil.addAttachmentsToSchema(gson.toJson(alpacaStructure.getSchema()), form.getListaDefinizioneAllegato()));
						alpacaStructure.setOptions(AlpacaUtil.loadOptions(gson.toJson(alpacaStructure.getOptions()), form.getListaDefinizioneAllegato(), true, themeDisplay.getPortalURL()));
						alpacaStructure.setData(jsonParser.parse(gson.toJson(alpacaStructure.getData())).getAsJsonObject());

						allegatoBytes = pdfService.generaPDFAlpacaForm(user.getScreenName(), codiceFiscaleComponente, alpacaStructure, richiesta, false, "");

					}
					else {
						allegatoBytes = Files.readAllBytes(fileFirmato.toPath());
					}

					if (allegatoBytes != null) {
						if (firmaDigitaleDocumentoAbilitata) {
							// Verifica firma digitale documento
							listaErrori = allegatoRichiestaService.checkFirmaDigitaleDocumentoPrincipale(allegatoBytes, listaErrori, listaFormatiFirma, richiesta.getRichiestaId());

							if (Validator.isNotNull(listaErrori) && !listaErrori.isEmpty()) {
								_log.error("SalvaInviaRichiestaActionCommand :: Errore durante il controllo della firma digitale!");
								String errori = String.join(StringPool.PERIOD + StringPool.SPACE, listaErrori);
								actionRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_ERRORI, errori);
								actionResponse.getRenderParameters().setValue("mvcRenderCommandName", PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND);
								return;
							}
						}
						allegatoRichiestaService.salvaDocumentoPrincipaleRichiesta(allegatoBytes, servizio, richiesta.getRichiestaId(), user.getFullName(), user.getUserId(),
								themeDisplay.getSiteGroupId(), themeDisplay.getCompanyId());
						if (fileFirmato != null && fileFirmato.exists()) {
							fileFirmato.delete();
						}
					}
					else {
						_log.error("SalvaInviaRichiestaActionCommand :: Allegato firmato non presente!");
						listaErrori.add(resourceBundleLoader.loadResourceBundle(themeDisplay.getLocale()).getString("errore-durante-il-salvataggio-del-file-principale"));
						String errori = String.join(StringPool.PERIOD + StringPool.SPACE, listaErrori);
						actionRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_ERRORI, errori);
						actionResponse.getRenderParameters().setValue("mvcRenderCommandName", PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND);
						return;
					}

					List<DefinizioneAllegato> listaDefinizioneAllegato = definizioneAllegatoLocalService.getListaDefinizioneAllegatoByFormId(form.getFormId());
					if (Validator.isNotNull(listaDefinizioneAllegato) && !listaDefinizioneAllegato.isEmpty()) {
						for (DefinizioneAllegato definizioneAllegato : listaDefinizioneAllegato) {
							File allegato = uploadPortletRequest.getFile("allegato-" + definizioneAllegato.getDefinizioneAllegatoId());

							if (Validator.isNotNull(allegato)) {
								byte[] bytes = Files.readAllBytes(Paths.get(allegato.getAbsolutePath()));

								String nomeFile = uploadPortletRequest.getFileName("allegato-" + definizioneAllegato.getDefinizioneAllegatoId());
								allegatoRichiestaService.salvaAllegatoRichiesta(bytes, nomeFile, servizio, richiesta.getRichiestaId(), definizioneAllegato.getDefinizioneAllegatoId(),
										user.getFullName(), user.getUserId(), themeDisplay.getSiteGroupId());

								allegato.delete();
							}
							else {
								_log.error("SalvaInviaRichiestaActionCommand :: Non è presente l'allegato con ID definizione : " + definizioneAllegato.getDefinizioneAllegatoId());
								listaErrori.add(resourceBundleLoader.loadResourceBundle(themeDisplay.getLocale()).getString("errore-durante-il-salvataggio-dell-allegato") + ": "
										+ definizioneAllegato.getDenominazione());
								String errori = String.join(StringPool.PERIOD + StringPool.SPACE, listaErrori);
								actionRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_ERRORI, errori);
								actionResponse.getRenderParameters().setValue("mvcRenderCommandName", PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND);
								return;
							}
						}
					}

					if (Validator.isNotNull(richiesta)) {
						richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), StatoRichiesta.NUOVA.name());

						DichiarazioneRisposta risposta = alpacaService.sendData(richiesta, procedura, userPreferences);

						actionRequest.setAttribute(PresentatoreFormsPortletKeys.TITOLO_PORTLET_SERVIZIO, form.getNome());
						actionRequest.setAttribute(PresentatoreFormsPortletKeys.DICHIARAZIONE_RISPOSTA, risposta);
						actionRequest.setAttribute(PresentatoreFormsPortletKeys.INVIO_ISTANZA, true);
						actionResponse.getRenderParameters().setValue("mvcPath", PresentatoreFormsPortletKeys.JSP_ESITO_INVIO);
					}
					else {
						_log.error("SalvaInviaRichiestaActionCommand :: Non è presente una richiesta in stato bozza per il CF : " + user.getScreenName());
						listaErrori.add(resourceBundleLoader.loadResourceBundle(themeDisplay.getLocale()).getString("errore-durante-il-salvataggio-della-richiesta-con-id") + ": "
								+ richiesta.getRichiestaId());
						String errori = String.join(StringPool.PERIOD + StringPool.SPACE, listaErrori);
						actionRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_ERRORI, errori);
						actionResponse.getRenderParameters().setValue("mvcRenderCommandName", PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND);
						return;
					}

				}
			}
		}
		catch (Exception e) {
			_log.error("SalvaInviaRichiestaActionCommand :: Errore durante il salvataggio della richiesta!", e);
			listaErrori.add(resourceBundleLoader.loadResourceBundle(themeDisplay.getLocale()).getString("errore-durante-il-salvataggio-della-richiesta") + ": " + e.getMessage());
			listaErrori.add(resourceBundleLoader.loadResourceBundle(themeDisplay.getLocale()).getString("errore-contattare-amministratore-sistema"));
			String errori = String.join(StringPool.PERIOD + StringPool.SPACE, listaErrori);
			actionRequest.setAttribute(PresentatoreFormsPortletKeys.LISTA_ERRORI, errori);
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND);
			return;
		}
	}
}
