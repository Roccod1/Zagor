package it.servizidigitali.restservice.jwt.utility.internal.auth.verifier;

import java.util.Arrays;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AccessControlContext;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifier;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifierResult;
import com.liferay.portal.kernel.security.service.access.policy.ServiceAccessPolicy;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.Validator;
import com.nimbusds.jwt.JWT;

import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.jwt.utility.constant.JWTUtilityConstant;
import it.servizidigitali.restservice.jwt.utility.exception.JwtException;

public class JwtAuthVerifier implements AuthVerifier {

	public JwtAuthVerifier(JwtUtilityService jwtUtilityService) {
		super();
		this._jwtUtilityService = jwtUtilityService;
	}

	@Override
	public String getAuthType() {
		Class<?> clazz = getClass();

		return clazz.getSimpleName();
	}

	@Override
	public AuthVerifierResult verify(AccessControlContext accessControlContext, Properties properties)
			throws AuthException {

		AuthVerifierResult authVerifierResult = new AuthVerifierResult();

		String jwtToken = getJWTToken(accessControlContext);
		
		if(Validator.isNull(jwtToken)) {
			return authVerifierResult;
		}
		
		try {
			JWT jwt = _jwtUtilityService.verifyJwt(jwtToken);
			Long userId = jwt.getJWTClaimsSet().getLongClaim(JWTUtilityConstant.CLAIM_USERID);
			
			authVerifierResult.setState(AuthVerifierResult.State.SUCCESS);
			authVerifierResult.setUserId(userId);
			
			authVerifierResult.getSettings().put(ServiceAccessPolicy.SERVICE_ACCESS_POLICY_NAMES, Arrays.asList(JWTUtilityConstant.SAP_NAME));
			
		}catch (JwtException e) {
			_log.error("Token JWT non valido: " + e.getDescription());
			return authVerifierResult;
		}
		catch (Exception e) {
			_log.error("Verifica del token jwt fallita ", e);
			return authVerifierResult;
		}

		return authVerifierResult;
		
	}


	private String getJWTToken(AccessControlContext accessControlContext) {
		HttpServletRequest httpServletRequest = accessControlContext.getRequest();
		String authorization = httpServletRequest.getHeader(
				HttpHeaders.AUTHORIZATION);

		if (Validator.isBlank(authorization)) {
			return null;
		}
		
		String[] authorizationParts = authorization.split("\\s");

		String scheme = authorizationParts[0];

		if (!StringUtil.equalsIgnoreCase(scheme, _TOKEN_KEY)) {
			return null;
		}

		String token = authorizationParts[1];

		if (Validator.isBlank(token)) {
			return null;
		}
		
		return token;
		
	}
	
	public void setJwtUtilityService(JwtUtilityService jwtUtilityService) {
		this._jwtUtilityService = jwtUtilityService;
	}
	
	private static final String _TOKEN_KEY = "Bearer";
	
	private static final Log _log = LogFactoryUtil.getLog(JwtAuthVerifier.class);

	private JwtUtilityService _jwtUtilityService;
	
}
