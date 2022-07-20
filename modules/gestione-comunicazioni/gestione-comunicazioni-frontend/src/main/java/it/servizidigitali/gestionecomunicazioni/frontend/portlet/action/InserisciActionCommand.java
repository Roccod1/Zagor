package it.servizidigitali.gestionecomunicazioni.frontend.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		String titolo = ParamUtil.getString(request, "titolo");
		long tipologia = ParamUtil.getLong(request, "tipologia");
		String descrizione = ParamUtil.getString(request, "descrizione");
		String dataInizio = ParamUtil.getString(request, "dataInizio");
		String dataFine = ParamUtil.getString(request, "dataFine");
		String procedura = ParamUtil.getString(request, "procedura");
		long utente = ParamUtil.getLong(request, "utente");
		
		ServiceContext ctx = ServiceContextFactory.getInstance(request);
		try {
			comunicazioneLocalService.addComunicazione(
					ctx.getScopeGroupId(),
					ctx.getCompanyId(),
					ctx.getUserId(),
					titolo,
					descrizione,
					getLocalDateTime(dataInizio),
					getLocalDateTime(dataFine),
					tipologia,
					utente
			);
		} catch (Exception e) {
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

	private static final Log _log = LogFactoryUtil.getLog(InserisciActionCommand.class);
}
