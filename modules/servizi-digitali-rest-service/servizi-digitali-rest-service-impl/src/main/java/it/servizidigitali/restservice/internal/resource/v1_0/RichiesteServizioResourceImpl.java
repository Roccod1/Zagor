package it.servizidigitali.restservice.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import it.servizidigitali.restservice.dto.v1_0.InsertRichiestaServizioRequest;
import it.servizidigitali.restservice.dto.v1_0.RichiestaServizio;
import it.servizidigitali.restservice.dto.v1_0.UpdateRichiestaServizioRequest;
import it.servizidigitali.restservice.dto.v1_0.UpdateStatoRichiestaServizioRequest;
import it.servizidigitali.restservice.internal.constant.ServiziDigitaliRestConstants;
import it.servizidigitali.restservice.internal.converter.EntityToSchemaModelConverter;
import it.servizidigitali.restservice.internal.util.MessageUtil;
import it.servizidigitali.restservice.resource.v1_0.RichiesteServizioResource;
import it.servizidigitali.richieste.common.enumeration.StatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

/**
 * @author pindi
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/richieste-servizio.properties", scope = ServiceScope.PROTOTYPE, service = RichiesteServizioResource.class)
public class RichiesteServizioResourceImpl extends BaseRichiesteServizioResourceImpl {

	private static final Log log = LogFactoryUtil.getLog(RichiesteServizioResourceImpl.class.getName());

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private EntityToSchemaModelConverter entityToSchemaModelConverter;

	// @Reference
	// private CommunicationEngineSender communicationEngineSender;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Override
	public Page<RichiestaServizio> searchRichiesteServizio(Integer page, Integer size, String q) {

		ArrayList<RichiestaServizio> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			RichiestaServizio r = new RichiestaServizio();
			r.setId(Long.valueOf(i));

			if (Validator.isNotNull(user)) {
				r.setStato(user.getScreenName());
			}

			l.add(r);
		}
		return Page.of(l);

	}

	@Override
	public RichiestaServizio insertRichiestaServizio(InsertRichiestaServizioRequest insertRichiestaServizioRequest) throws Exception {

		RichiestaServizio r = new RichiestaServizio();
		r.setId(99l);

		return r;

	}

	@Override
	public RichiestaServizio getRichiestaServizio(Long id) throws Exception {

		Richiesta richiesta = richiestaLocalService.getRichiesta(id);
		RichiestaServizio richiestaServizio = entityToSchemaModelConverter.getRichiestaServizio(richiesta);

		return richiestaServizio;
	}

	@Override
	public RichiestaServizio updateStatoRichiestaServizio(UpdateStatoRichiestaServizioRequest updateStatoRichiestaServizioRequest) throws Exception {

		MessageUtil messageUtil = new MessageUtil(ServiziDigitaliRestConstants.BUNDLE_SYMBOLIC_NAME, null);

		Richiesta richiesta = richiestaLocalService.getRichiesta(updateStatoRichiestaServizioRequest.getId());
		if (richiesta == null) {
			String message = messageUtil.getMessage("resourceNotFoundMessage", "Richiesta");
			throw new NotFoundException(message);
		}

		StatoRichiesta statoRichiesta = StatoRichiesta.valueOf(updateStatoRichiestaServizioRequest.getStato());
		richiestaLocalService.updateStatoRichiesta(richiesta.getRichiestaId(), statoRichiesta.name(), updateStatoRichiestaServizioRequest.getNote());
		richiesta = richiestaLocalService.getRichiesta(updateStatoRichiestaServizioRequest.getId());

		RichiestaServizio richiestaServizio = entityToSchemaModelConverter.getRichiestaServizio(richiesta);
		// try {
		//
		// User user = userLocalService.getUser(richiesta.getUserId());
		// Organization organization =
		// organizationLocalService.getOrganization(groupLocalService.getGroup(richiesta.getGroupId()).getOrganizationId());
		//
		// String oggetto = organization.getName() + "Notifica Cambiamento di stato richiesta " +
		// richiesta.getRichiestaId();
		// String testo = "Gentile " + user.getFullName() + ",<br/> La richiesta in oggetto, da lei
		// inoltrata con descrizione : " + richiesta.getOggetto()
		// + ", ha subito un aggiornamento dallo stato <b>" +
		// messageUtil.getMessage("stato-richiesta-" + richiesta.getStato()) + "</b> allo stato <b>"
		// + messageUtil.getMessage("stato-richiesta-" +
		// updateStatoRichiestaServizioRequest.getStato()) + "</b>";
		//
		// Utente utente = new Utente();
		// utente.setEmail(user.getEmailAddress());
		// List<Utente> utenti = Arrays.asList(utente);
		//
		// Comunicazione comunicazione = new Comunicazione(oggetto, testo, utenti, null, false,
		// null);
		// communicationEngineSender.sendNow(comunicazione, Canale.EMAIL);
		// }
		// catch (Exception e) {
		// log.error("Impossibile aggiornare lo stato delle richiesta " + richiesta.getRichiestaId()
		// + " : " + e.getMessage(), e);
		// throw e;
		// }

		return richiestaServizio;

	}

	@Override
	public RichiestaServizio patchRichiestaServizio(UpdateRichiestaServizioRequest updateRichiestaServizioRequest) throws Exception {
		RichiestaServizio r = new RichiestaServizio();
		r.setId(99L);
		r.setStato(updateRichiestaServizioRequest.getStato());
		return r;
	}

	@Context
	private User user;

}