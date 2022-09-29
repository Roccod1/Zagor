package it.servizidigitali.restservice.internal.resource.v1_0;

import it.servizidigitali.restservice.dto.v1_0.RichiestaCertificato;
import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.jwt.utility.constant.JWTUtilityConstant;
import it.servizidigitali.restservice.jwt.utility.exception.JwtException;
import it.servizidigitali.restservice.resource.v1_0.CertificatiResource;

import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.ForbiddenException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author pindi
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/certificati.properties",
		scope = ServiceScope.PROTOTYPE, service = CertificatiResource.class
		)
public class CertificatiResourceImpl extends BaseCertificatiResourceImpl {

	@Override
	public RichiestaCertificato checkInvioCertificato(@NotNull String userToken, String nomeComune,
			Long idDestinazioneUso, String codiceServizio, String amministrazione, String codiceFiscale)
					throws Exception {

		try {
			Map<String, Object> claims = _jwtUtilityService.verifyJwtAndGetClaims(userToken);
			String codiceFiscaleFromToken = (String)claims.get(JWTUtilityConstant.CLAIM_USERNAME);

			return super.checkInvioCertificato(userToken, nomeComune, idDestinazioneUso, codiceServizio, amministrazione,
					codiceFiscale);


		}catch (JwtException e) {
			throw new ForbiddenException(e.getDescription());

		}
	}
	
	@Override
		public RichiestaCertificato invioCertificato(@NotNull String userToken, String nomeComune, Long idDestinazioneUso,
				String codiceServizio, String amministrazione, String codiceFiscale) throws Exception {
		try {
			Map<String, Object> claims = _jwtUtilityService.verifyJwtAndGetClaims(userToken);
			String codiceFiscaleFromToken = (String)claims.get(JWTUtilityConstant.CLAIM_USERNAME);

			return super.invioCertificato(userToken, nomeComune, idDestinazioneUso, codiceServizio, amministrazione,
					codiceFiscale);


		}catch (JwtException e) {
			throw new ForbiddenException(e.getDescription());

		}
		}

	@Reference
	private JwtUtilityService _jwtUtilityService;

}