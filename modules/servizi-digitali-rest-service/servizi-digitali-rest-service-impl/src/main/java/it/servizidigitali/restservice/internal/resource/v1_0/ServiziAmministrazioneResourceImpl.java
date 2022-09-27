package it.servizidigitali.restservice.internal.resource.v1_0;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.vulcan.pagination.Page;

import it.servizidigitali.restservice.dto.v1_0.InfoServizioAmministrazione;
import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.resource.v1_0.ServiziAmministrazioneResource;

/**
 * @author pindi
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/servizi-amministrazione.properties",
	scope = ServiceScope.PROTOTYPE,
	service = ServiziAmministrazioneResource.class
)
public class ServiziAmministrazioneResourceImpl
	extends BaseServiziAmministrazioneResourceImpl {
	
	
	@Override
		public Page<InfoServizioAmministrazione> getServiziAmministrazione(String nomeComune,
				@NotNull Long codiceTipologiaServizio, String amministrazione) throws Exception {
			// TODO Auto-generated method stub
			return super.getServiziAmministrazione(nomeComune, codiceTipologiaServizio, amministrazione);
		}
	
	
	@Reference
	private JwtUtilityService _jwtUtilityService;
	
}