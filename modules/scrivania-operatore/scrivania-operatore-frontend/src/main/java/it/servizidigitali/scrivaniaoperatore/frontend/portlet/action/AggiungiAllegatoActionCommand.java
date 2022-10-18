package it.servizidigitali.scrivaniaoperatore.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.file.utility.factory.FileServiceFactory;
import it.servizidigitali.file.utility.service.FileService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.scrivaniaoperatore.frontend.constants.ScrivaniaOperatorePortletKeys;
import it.servizidigitali.scrivaniaoperatore.frontend.service.ScrivaniaOperatoreFrontendService;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.service.AllegatoRichiestaLocalService;
import it.servizidigitali.scrivaniaoperatore.service.RichiestaLocalService;

@Component(//
		immediate = true, //
		service = MVCActionCommand.class, //
		property = { //
				"javax.portlet.name=" + ScrivaniaOperatorePortletKeys.SCRIVANIAOPERATORE, //
				"mvc.command.name=/action/aggiungiAllegato"//
		}//
)
public class AggiungiAllegatoActionCommand extends BaseMVCActionCommand {

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("-yyyy-MM-dd-HH-mm-ss");

	@Reference
	private AllegatoRichiestaLocalService allegatoRichiestaLocalService;

	@Reference
	private Portal portal;

	@Reference
	private FileServiceFactory fileServiceFactory;

	@Reference
	private ScrivaniaOperatoreFrontendService scrivaniaOperatoreFrontendService;

	@Reference
	private RichiestaLocalService richiestaLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		long richiestaId = ParamUtil.getLong(request, "richiestaId");

		try {
			ServiceContext context = ServiceContextFactory.getInstance(request);
			UploadPortletRequest upr = portal.getUploadPortletRequest(request);

			Richiesta richiesta = richiestaLocalService.getRichiesta(richiestaId);
			long proceduraId = richiesta.getProceduraId();

			Servizio servizioByProceduraId = scrivaniaOperatoreFrontendService.getServizioByProceduraId(proceduraId);
			String titoloDocumento = ParamUtil.getString(request, "titoloDocumento");
			if (Validator.isNull(titoloDocumento)) {
				throw new PortletException("allegato vuoto");
			}

			boolean visibileAlCittadino = ParamUtil.getBoolean(request, "visibileAlCittadino");

			InputStream inputStream = upr.getFileAsStream("allegato");
			String name = upr.getFileName("allegato");
			if (name.isEmpty()) {
				throw new PortletException("allegato vuoto");
			}

			String fileName = generateFilename(name);

			String contentType = upr.getContentType("allegato");

			FileService activeFileService = fileServiceFactory.getActiveFileService();
			String idDocumentale = activeFileService.saveRequestFile(fileName, titoloDocumento, null, servizioByProceduraId.getCodice(), richiesta.getRichiestaId(), inputStream, contentType,
					richiesta.getUserId(), richiesta.getGroupId());
			long userId = context.getUserId();
			User user = userLocalService.getUser(userId);

			AllegatoRichiesta allegatoRichiesta = allegatoRichiestaLocalService.createAllegatoRichiesta(counterLocalService.increment());
			allegatoRichiesta.setGroupId(context.getScopeGroupId());
			allegatoRichiesta.setCompanyId(context.getCompanyId());
			allegatoRichiesta.setUserId(userId);
			allegatoRichiesta.setUserName(user.getFullName());
			allegatoRichiesta.setCreateDate(new Date());
			allegatoRichiesta.setModifiedDate(new Date());
			allegatoRichiesta.setNome(fileName);
			allegatoRichiesta.setTitolo(titoloDocumento);
			allegatoRichiesta.setDescrizione(null);
			allegatoRichiesta.setVisibile(visibileAlCittadino);
			allegatoRichiesta.setInterno(true);
			allegatoRichiesta.setIdDocumentale(idDocumentale);
			allegatoRichiesta.setRichiestaId(richiestaId);

			allegatoRichiestaLocalService.updateAllegatoRichiesta(allegatoRichiesta);
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(request, "errore-generico");
		}

		MutableRenderParameters renderParameters = response.getRenderParameters();
		renderParameters.setValue("mvcRenderCommandName", "/render/dettaglio");
		renderParameters.setValue("id", String.valueOf(richiestaId));
		renderParameters.setValue("dettaglioTab", ScrivaniaOperatorePortletKeys.DETTAGLIO_TAB_ALLEGATI);
		renderParameters.setValue("isMain", String.valueOf(false));
	}

	private String generateFilename(String fileName) {
		Date now = new Date();
		String datePart = FORMATTER.format(now);
		int pos = fileName.lastIndexOf('.');

		if (pos < 0) {
			return fileName + datePart;
		}
		else {
			String extension = fileName.substring(pos + 1);
			String name = fileName.substring(0, pos);
			return name + datePart + "." + extension;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AggiungiAllegatoActionCommand.class);
}
