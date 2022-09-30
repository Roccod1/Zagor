package it.servizidigitali.catalogoservizi.frontend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

@Component(name = "catalogoServiziMiddlewareService", immediate = true, service = CatalogoServiziMiddlewareService.class)
public class CatalogoServiziMiddlewareService {

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	public List<Servizio> getServizioByParams(String nome, long areaTematicaId, boolean attivo, long tipologiaId, long companyId, long groupId, long organizationId, int cur, int delta,
			String orderByCol, String orderByType) throws Exception {

		List<ServizioEnte> listaIdServiziEnteDisponibili = servizioEnteLocalService.getServiziEnteByCompanyOrganizationAttivo(companyId, organizationId, attivo);
		List<Long> serviziId = listaIdServiziEnteDisponibili.stream().map(ServizioEnte::getServizioId).collect(Collectors.toList());
		List<Servizio> listaServizi = servizioLocalService.getServiziUtilizzabili(serviziId, nome, areaTematicaId, tipologiaId, cur, delta, orderByCol, orderByType);

		return listaServizi;

	}

}
