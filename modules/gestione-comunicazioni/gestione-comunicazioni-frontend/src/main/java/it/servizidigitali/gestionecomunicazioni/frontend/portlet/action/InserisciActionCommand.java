package it.servizidigitali.gestionecomunicazioni.frontend.portlet.action;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.exception.ComunicazioneDescrizioneException;
import it.servizidigitali.gestionecomunicazioni.exception.ComunicazioneOrganizzazioneException;
import it.servizidigitali.gestionecomunicazioni.exception.ComunicazioneTitoloException;
import it.servizidigitali.gestionecomunicazioni.exception.ComunicazioneDataFineException;
import it.servizidigitali.gestionecomunicazioni.frontend.constants.GestioneComunicazioniFrontendPortletKeys;
import it.servizidigitali.gestionecomunicazioni.service.ComunicazioneLocalService;

@Component(
		immediate = true,
		service = MVCActionCommand.class,
		property = {
				"javax.portlet.name=" + GestioneComunicazioniFrontendPortletKeys.GESTIONECOMUNICAZIONI,
				"mvc.command.name=/action/inserisci"
		}
)
public class InserisciActionCommand extends BaseMVCActionCommand {

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	
	@Reference
	private ComunicazioneLocalService comunicazioneLocalService;
	@Reference
	private UserLocalService userLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		String titolo = ParamUtil.getString(request, "titolo").trim();
		long tipologia = ParamUtil.getLong(request, "tipologia");
		String descrizione = ParamUtil.getString(request, "descrizione");
		String dataInizio = ParamUtil.getString(request, "dataInizio");
		String dataFine = ParamUtil.getString(request, "dataFine");
		//String procedura = ParamUtil.getString(request, "procedura");
		long organizzazione = ParamUtil.getLong(request, "organizzazione");
		long utente = ParamUtil.getLong(request, "utente");

		MutableRenderParameters params = response.getRenderParameters();
		
		try {
			ServiceContext ctx = ServiceContextFactory.getInstance(request);
			User user = userLocalService.getUser(ctx.getUserId());
			
			comunicazioneLocalService.addComunicazione(
					ctx.getScopeGroupId(),
					ctx.getCompanyId(),
					ctx.getUserId(),
					ctx.getScopeGroup().getOrganizationId(),
					user.getFullName(),
					titolo,
					descrizione,
					getLocalDateTime(dataInizio),
					getLocalDateTime(dataFine),
					tipologia,
					utente,
					organizzazione
			);
		} catch (ComunicazioneTitoloException e) {
			params.setValue("mvcRenderCommandName", "/render/nuova");
			SessionErrors.add(request, "errore-titolo");
		} catch (ComunicazioneDescrizioneException e) {
			params.setValue("mvcRenderCommandName", "/render/nuova");
			SessionErrors.add(request, "errore-descrizione");
		} catch (ComunicazioneOrganizzazioneException e) {
			params.setValue("mvcRenderCommandName", "/render/nuova");
			SessionErrors.add(request, "errore-ente");
		} catch (ComunicazioneDataFineException e) {
			params.setValue("mvcRenderCommandName", "/render/nuova");
			SessionErrors.add(request, "errore-data-fine");
		} catch (Exception e) {
			params.setValue("mvcRenderCommandName", "/render/nuova");
			SessionErrors.add(request, "errore-generico");
		}
	}
	
	private Date getLocalDateTime(String val) {
		if (val.isEmpty()) {
			return null;
		} else {
			try {
				return FORMATTER.parse(val);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
