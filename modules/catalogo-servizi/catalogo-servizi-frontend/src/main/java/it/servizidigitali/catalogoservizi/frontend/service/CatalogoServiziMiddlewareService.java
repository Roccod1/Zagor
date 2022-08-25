package it.servizidigitali.catalogoservizi.frontend.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

@Component(
	name="catalogoServiziMiddlewareService",
	immediate = true,
	service = CatalogoServiziMiddlewareService.class
)
public class CatalogoServiziMiddlewareService {

	@Reference
	private ServizioLocalService servizioLocalService;
	
	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	private static final Log _log = LogFactoryUtil.getLog(CatalogoServiziMiddlewareService.class);
	
	public List<Servizio> getServizioByParams(String nome, long areaTematicaId, boolean attivo, long tipologiaId, long companyId, long groupId, long organizationId, int cur, int delta, String orderByCol, String orderByType) throws Exception{
			
		List<Object> listaIdServiziEnteDisponibili = servizioEnteLocalService.getListaServiziByCompanyOrganizationAttivo(companyId, organizationId, attivo);
		List<Servizio> listaServizi = servizioLocalService.getServiziUtilizzabili(listaIdServiziEnteDisponibili, nome, areaTematicaId, tipologiaId, cur, delta, orderByCol, orderByType);
		
		return listaServizi;

	}
	
}
