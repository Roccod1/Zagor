package it.servizidigitali.restservice.internal.resource.v1_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.ForbiddenException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.vulcan.pagination.Page;

import it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici;
import it.servizidigitali.backoffice.integration.service.AnagrafeIntegrationFactoryService;
import it.servizidigitali.common.utility.OrganizationUtility;
import it.servizidigitali.restservice.dto.v1_0.ComponenteNucleoFamiliareLight;
import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.jwt.utility.constant.JWTUtilityConstant;
import it.servizidigitali.restservice.jwt.utility.exception.JwtException;
import it.servizidigitali.restservice.resource.v1_0.DatiAnagraficiResource;

/**
 * @author pindi
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/dati-anagrafici.properties",
		scope = ServiceScope.PROTOTYPE, service = DatiAnagraficiResource.class
		)
public class DatiAnagraficiResourceImpl extends BaseDatiAnagraficiResourceImpl {

	@Override
	public Page<ComponenteNucleoFamiliareLight> getComponentiNucleoFamiliare(@NotNull String userToken,
			String nomeComune) throws Exception {

		try {
			Map<String, Object> claims = _jwtUtilityService.verifyJwtAndGetClaims(userToken);
			String codiceFiscale = (String)claims.get(JWTUtilityConstant.CLAIM_USERNAME);

			Organization organization = _organizationUtility.getByName(nomeComune);

			DatiAnagrafici datiAnagrafici = _anagrafeIntegrationFactoryService.getAnagrafeIntegrationService(organization.getOrganizationId())
					.getDatiAnagrafici(codiceFiscale, organization.getOrganizationId(), null);

			List<ComponenteNucleoFamiliareLight> res = new ArrayList<>();
			datiAnagrafici.getComponentiNucleoFamiliare().forEach( c -> {
				ComponenteNucleoFamiliareLight l = new ComponenteNucleoFamiliareLight();
				l.setCodiceFiscale(c.getCodiceFiscale());
				l.setCognome(c.getCognome());
				l.setDataNascita(c.getDataNascita());
				l.setNome(c.getNome());
				l.setSesso(c.getSesso());

				res.add(l);
			});

			Page<ComponenteNucleoFamiliareLight> page = Page.of(res);

			return page;
		}catch (JwtException e) {
			throw new ForbiddenException(e.getDescription());
		}
	}

	@Reference
	private JwtUtilityService _jwtUtilityService;

	@Reference
	private OrganizationUtility _organizationUtility;

	@Reference
	private AnagrafeIntegrationFactoryService _anagrafeIntegrationFactoryService;

}