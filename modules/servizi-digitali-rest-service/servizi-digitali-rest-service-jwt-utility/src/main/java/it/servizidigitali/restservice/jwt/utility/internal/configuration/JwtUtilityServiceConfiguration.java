package it.servizidigitali.restservice.jwt.utility.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;
import aQute.bnd.annotation.metatype.Meta.Type;

@Meta.OCD(
        id = "it.servizidigitali.restservice.jwt.utility.internal.configuration.JwtUtilityServiceConfiguration",
        name = "Configurazione utility JWT"
)
public interface JwtUtilityServiceConfiguration {
	
	@Meta.AD(
			name = "JWT Secret",
			deflt = "ServiziDigitali2022",
			type = Type.Password,
			required = false
	)
	String jwtSecret();
	
	@Meta.AD(
			name = "Validità token JWT",
			description = "In secondi",
			required = false,
			deflt = "600"
	)
	Long tokenValidity();
	
}
