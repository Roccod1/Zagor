package it.servizidigitali.gestioneprocedure.frontend.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;

@Component(name = "gestioneProcedureMiddlewareService", immediate = true, service = GestioneProcedureMiddlewareService.class)
public class GestioneProcedureMiddlewareService {
	
	private static final Log _log = LogFactoryUtil.getLog(GestioneProcedureMiddlewareService.class);
	
	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	public List<Servizio> getServiziByOrganizationAttivo(long organizationId) throws Exception{
		
		List<Long> listaServiziEnte = servizioEnteLocalService.getListaServiziByOrganizationAttivo(organizationId, true);
		List<Servizio> listaServizi = new ArrayList<Servizio>();
		
		if(Validator.isNotNull(listaServiziEnte)) {
			for(Long idServizio : listaServiziEnte) {
				Servizio servizio = servizioLocalService.getServizio(idServizio);
				
				if(Validator.isNotNull(servizio)) {
					listaServizi.add(servizio);
				}else {
					_log.error("Impossibile recuperare il servizio per ID: " + idServizio);
				}
			}
		}else {
			_log.error("Impossibile recuperare la lista dei servizi per questa organizzazione : " + organizationId);
		}
		
		return listaServizi;
		
	}
}
