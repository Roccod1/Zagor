package it.servizidigitali.gestioneenti.frontend.service;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoLocalService;
import it.servizidigitali.scrivaniaoperatore.service.DestinazioneUsoServizioEnteLocalService;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoServizioEntePK;

@Component(name = "gestioneEntiMiddlewareService", immediate = true, service = GestioneEntiMiddlewareService.class)
public class GestioneEntiMiddlewareService {

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private LayoutLocalService layoutLocalService;

	@Reference
	private JournalArticleLocalService journalArticleLocalService;

	@Reference
	private DDMStructureLocalService dDMStructureLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private DestinazioneUsoLocalService destinazioneUsoLocalService;
	
	@Reference
	private DestinazioneUsoServizioEnteLocalService destinazioneUsoServizioEnteLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _log = LogFactoryUtil.getLog(GestioneEntiMiddlewareService.class);

	/**
	 * Ritorna le pagine che e' possibile utilizzare per URI pubblica o URI guest
	 */
	public Map<String, List<Layout>> getListaPagineUtilizzabili(long organizationId, long servizioId, long companyId) throws Exception {

		User defaultUser = userLocalService.getDefaultUser(companyId);
		Organization organization = organizationLocalService.getOrganization(organizationId);
		long groupId = organization.getGroup().getGroupId();

		Map<String, List<Layout>> pagineDivise = new HashMap<String, List<Layout>>();
		List<Layout> listaUriPrivata = new ArrayList<Layout>();
		List<Layout> listaUriPubblica = new ArrayList<Layout>();

		if (Validator.isNull(groupId)) {
			throw new NullPointerException("groupId e' null");
		}

		if (Validator.isNull(organizationId)) {
			throw new NullPointerException("organizationId e' null");
		}

		if (Validator.isNull(companyId)) {
			throw new NullPointerException("companyId e' null");
		}

		// ottengo la pagina parent
		Layout parentLayout = layoutLocalService.getLayoutByFriendlyURL(groupId, false, GestioneEntiPortletKeys.SERVIZI_FRIENDLY_URL);

		if (Validator.isNotNull(parentLayout)) {
			// ottengo tutte le pagine dei servizi
			List<Layout> listaPagine = layoutLocalService.getLayouts(groupId, false, parentLayout.getLayoutId());
			List<Layout> listaPagineFinita = null;
			if (Validator.isNotNull(listaPagine)) {
				List<ServizioEnte> listaServiziEnte = servizioEnteLocalService.getServiziEnte(organizationId);
				listaPagineFinita = new ArrayList<Layout>(listaPagine);
				// rimuovo dalla lista servizi quelli gia' attivi per lo specifico ente
				for (Layout layout : listaPagine) {
					for (ServizioEnte servizioEnte : listaServiziEnte) {
						if ((layout.getLayoutId() == servizioEnte.getPublicLayoutId()) || (layout.getLayoutId() == servizioEnte.getPrivateLayoutId())) {
							if (servizioEnte.getServizioId() != servizioId) {
								listaPagineFinita.remove(layout);
							}
						}
					}
				}
			}

			for (Layout layout : listaPagineFinita) {
				boolean control = LayoutPermissionUtil.contains(PermissionCheckerFactoryUtil.create(defaultUser), layout, ActionKeys.VIEW);
				if (control) {
					listaUriPubblica.add(layout);
				}
				else {
					listaUriPrivata.add(layout);
				}
			}

		}

		pagineDivise.put(GestioneEntiPortletKeys.LISTA_URI_PRIVATE, listaUriPrivata);
		pagineDivise.put(GestioneEntiPortletKeys.LISTA_URI_PUBBLICHE, listaUriPubblica);

		return pagineDivise;
	}

	public List<Servizio> getListaServiziAttivabili(Long servizioId, Long organizationId) throws Exception {

		List<Servizio> listaFinita = null;

		if (Validator.isNull(organizationId)) {
			throw new NullPointerException("organizationId e' null");
		}

		try {
			List<Servizio> listaServizi = servizioLocalService.listaServiziAttivi(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(listaServizi)) {
				listaFinita = new ArrayList<Servizio>(listaServizi);

				if (Validator.isNotNull(servizioId)) {
					List<ServizioEnte> listaServiziAttivi = servizioEnteLocalService.getServiziEnte(organizationId);

					// rimuovo dalla lista servizi quelli gia' attivi per lo specifico ente
					for (Servizio servizio : listaServizi) {
						for (ServizioEnte servizioAttivo : listaServiziAttivi) {
							if (servizioAttivo.getServizioId() == servizio.getServizioId()) {
								listaFinita.remove(servizio);
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			_log.error("Impossibile ottenere la lista dei servizi Attivabili ::> " + e.getMessage(), e);
			throw new Exception(e);
		}

		return listaFinita;
	}

	public List<JournalArticle> getListaArticleIdDisponibili(long organizationId, long servizioId) throws PortalException {

		Organization organization = organizationLocalService.getOrganization(organizationId);
		long groupId = organization.getGroup().getGroupId();
		List<JournalArticle> listaArticoliCatalogoServizi = null;
		List<JournalArticle> tempList = null;
		String structureKey = "";
		List<DDMStructure> structures = DDMStructureLocalServiceUtil.getStructures(groupId);
		for (DDMStructure structure : structures) {
			if (GestioneEntiPortletKeys.STRUCTURE_NAME_SCHEDA_SERVIZIO.equalsIgnoreCase(structure.getName(Locale.ROOT))) {
				structureKey = structure.getStructureKey();
			}
		}

		if (Validator.isNotNull(structureKey)) {
			tempList = journalArticleLocalService.getArticlesByStructureId(groupId, structureKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			if (Validator.isNotNull(tempList)) {
				listaArticoliCatalogoServizi = new ArrayList<JournalArticle>(tempList);
				List<ServizioEnte> listaServiziAttivi = servizioEnteLocalService.getServiziEnte(organizationId);
				if (Validator.isNotNull(listaServiziAttivi)) {
					for (JournalArticle article : tempList) {
						for (ServizioEnte servizioEnte : listaServiziAttivi) {
							if (Long.parseLong(article.getArticleId()) == servizioEnte.getCatalogoServizioArticleId()) {
								if (servizioEnte.getServizioId() != servizioId) {
									listaArticoliCatalogoServizi.remove(article);
								}
							}
						}
					}
				}
			}
		}

		return listaArticoliCatalogoServizi;
	}
	
	public String getStringSelectMultipla(String string) throws JSONException {
		string = "[" + string + "]";
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(string);
		String jsonArrayString = JSONFactoryUtil.createJSONSerializer().serialize(jsonArray);

		return jsonArrayString;
	}
	
	public List<DestinazioneUso> getListaDestinazioniUsoServizio(long servizioId, long organizationId, long groupId, long companyId){
		List<DestinazioneUso> listaDestinazioniUso = new ArrayList<DestinazioneUso>();
		listaDestinazioniUso = destinazioneUsoLocalService.getDestinazioniUsoByServizioIdOrganizationId(servizioId, organizationId, groupId, companyId);
		return listaDestinazioniUso;
	}
	
	public void salvaDestinazioniUso(String[] destinazioniUsoSelezionate, long servizioId, String userName, long userId, long organizationId, long groupId, long companyId) {
		List<DestinazioneUsoServizioEnte> listaDestinazioniUsoServizio = destinazioneUsoServizioEnteLocalService.getDestinazioniUsoServizioEnteByServizioIdOrganizationId(servizioId, organizationId, groupId, companyId);
		List<DestinazioneUsoServizioEnte> listaDestinazioniUsoForm = new ArrayList<DestinazioneUsoServizioEnte>();
		
		for(String destinazioneUsoId : destinazioniUsoSelezionate) {
			DestinazioneUsoServizioEntePK pk = new DestinazioneUsoServizioEntePK();
			DestinazioneUsoServizioEnte destinazioneUsoServizioEnte = null;
			pk.setServizioId(servizioId);
			pk.setOrganizationId(organizationId);
			pk.setDestinazioneUsoId(Long.valueOf(destinazioneUsoId));
			
			if(Validator.isNotNull(pk)) {
				destinazioneUsoServizioEnte = destinazioneUsoServizioEnteLocalService.createDestinazioneUsoServizioEnte(pk);
				destinazioneUsoServizioEnte.setGroupId(groupId);
				destinazioneUsoServizioEnte.setUserId(userId);
				destinazioneUsoServizioEnte.setUserName(userName);
				listaDestinazioniUsoForm.add(destinazioneUsoServizioEnte);
			}
		}
		
		
		if(Validator.isNotNull(listaDestinazioniUsoServizio) && !listaDestinazioniUsoServizio.isEmpty()) {
			
			if(Validator.isNotNull(listaDestinazioniUsoForm) && !listaDestinazioniUsoForm.isEmpty()) {
				List<DestinazioneUsoServizioEnte> elementiDaEliminare = listaDestinazioniUsoServizio.stream()
						.filter(destinazioneUsoServizioEnte -> !listaDestinazioniUsoForm.contains(destinazioneUsoServizioEnte))
						.collect(Collectors.toList());
				
				List<DestinazioneUsoServizioEnte> elementiDaAggiungere = listaDestinazioniUsoForm.stream()
						.filter(destinazioneUsoServizioEnte -> !listaDestinazioniUsoServizio.contains(destinazioneUsoServizioEnte))
						.collect(Collectors.toList());
				
				for(DestinazioneUsoServizioEnte destinazioneUsoServizioEnte : elementiDaAggiungere) {
					destinazioneUsoServizioEnteLocalService.updateDestinazioneUsoServizioEnte(destinazioneUsoServizioEnte);
				}
				
				for(DestinazioneUsoServizioEnte destinazioneUsoServizioEnte : elementiDaEliminare) {
					destinazioneUsoServizioEnteLocalService.deleteDestinazioneUsoServizioEnte(destinazioneUsoServizioEnte);
				}
			}
			
		}else {	
			
			if(Validator.isNotNull(listaDestinazioniUsoForm) && !listaDestinazioniUsoForm.isEmpty()) {
				
				for(DestinazioneUsoServizioEnte destinazioneUsoServizioEnte : listaDestinazioniUsoForm) {
					destinazioneUsoServizioEnteLocalService.updateDestinazioneUsoServizioEnte(destinazioneUsoServizioEnte);
				}
				
			}
			
		}
	}

}
