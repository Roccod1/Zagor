package it.servizidigitali.restservice.jwt.utility.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "api-authentication")
@Meta.OCD(
	id = "it.servizidigitali.restservice.jwt.utility.internal.configuration.JwtAuthVerifierConfiguration",
	name = "Servizi digitali JWT auth verifier"
)
public interface JwtAuthVerifierConfiguration {

	@Meta.AD(deflt = "true", name = "enabled", required = false)
	public boolean enabled();

	@Meta.AD(name = "hosts-allowed", required = false)
	public String hostsAllowed();

	@Meta.AD(name = "urls-excludes", required = false)
	public String urlsExcludes();

	@Meta.AD(name = "urls-includes", required = false)
	public String urlsIncludes();
	
}
