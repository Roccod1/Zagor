package it.servizidigitali.restservice.jwt.utility.internal.impl;

import java.util.Date;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Portal;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import aQute.bnd.annotation.metatype.Configurable;
import it.servizidigitali.restservice.jwt.utility.api.JwtUtilityService;
import it.servizidigitali.restservice.jwt.utility.constant.JWTUtilityConstant;
import it.servizidigitali.restservice.jwt.utility.exception.JwtException;
import it.servizidigitali.restservice.jwt.utility.internal.configuration.JwtUtilityServiceConfiguration;

/**
 * @author pascal
 */
@Component(
	configurationPid = "it.servizidigitali.restservice.jwt.utility.internal.configuration.JwtUtilityServiceConfiguration",
	immediate = true,
	property = {
	},
	service = JwtUtilityService.class
)
public class JwtUtilityServiceImpl implements JwtUtilityService {

	@Override
	public  String getJWTUserToken(HttpServletRequest request) {
		SignedJWT  signedJWT = null;
		try {
			User user = _portal.getUser(request);
			if (user != null) {
				
				JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
				Date now = new Date();
				claimsSet.issueTime(now);
				long validityInSeconds = _configuration.tokenValidity();
				if (validityInSeconds > 0) {
					claimsSet.expirationTime(new Date(now.getTime() + (validityInSeconds * 1000)));
				} else {
					claimsSet.expirationTime(new Date(now.getTime()));
				}
				claimsSet.notBeforeTime(now);
				claimsSet.claim(JWTUtilityConstant.CLAIM_USERNAME, user.getScreenName());
				claimsSet.claim(JWTUtilityConstant.CLAIM_USERID, user.getUserId());
				
				JWSSigner signer = new MACSigner(getSharedSecret());
				
				JWSAlgorithm algorithm = JWSAlgorithm.HS256;
				JWSHeader jwsHeader = new JWSHeader.Builder(algorithm).build();
				
				signedJWT = new SignedJWT(jwsHeader, claimsSet.build());
				signedJWT.sign(signer);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (KeyLengthException e) {
			_log.error(e);
		} catch (JOSEException e) {
			_log.error(e);
		}catch (Exception e) {
			_log.error(e);
		}

		return signedJWT!=null ? signedJWT.serialize() : null;
	}
	
	@Override
	public JWT verifyJwt(String token) throws JwtException {
		try {
			
			JWSAlgorithm algorithm = JWSAlgorithm.HS256;
			
			SignedJWT parsedTokenJWT = SignedJWT.parse(token);
			
			if( ! algorithm.getName().equalsIgnoreCase(parsedTokenJWT.getHeader().getAlgorithm().getName())) {
				throw new JwtException("VERIFY_JWT_TOKEN", "Algoritmo non corretto");
			}

			JWSVerifier verifier = new MACVerifier(getSharedSecret());
			
			boolean signResult = false;
			
			try {
				signResult = parsedTokenJWT.verify(verifier);
			}catch (Exception e) {
				throw new JwtException("VERIFY_JWT_TOKEN", "Impossibile verificare la firma");
			}
			
			if(!signResult) {
				throw new JwtException("VERIFY_JWT_TOKEN", "Firma non valida");
			}
			
			Date now = new Date();

			Date expirationTime = parsedTokenJWT.getJWTClaimsSet().getExpirationTime();

			if(null == expirationTime || now.after(expirationTime) ) {
				throw new JwtException("VERIFY_JWT_TOKEN", "Validità non corretta o token scaduto");
			}

			return parsedTokenJWT;
		}catch (Exception e) {
			_log.error("Impossibile effettuare il parsing del token jwt", e);
			throw new JwtException("VERIFY_JWT_TOKEN", e.getMessage());
		}
	}
	
	private byte[] getSharedSecret() throws Exception {
		String jwtSecret = Base64.encode(_configuration.jwtSecret().getBytes());
		
		Mac sha256HMAC = Mac.getInstance(JWTUtilityConstant.SIGN_ALGORITHM_INSTANCE_NAME);
		SecretKeySpec secretKey = new SecretKeySpec(jwtSecret.getBytes(StringPool.UTF8), JWTUtilityConstant.SIGN_ALGORITHM_INSTANCE_NAME);
		sha256HMAC.init(secretKey);
		
		String sharedSecret = Base64.encode(sha256HMAC.doFinal(jwtSecret.getBytes(StringPool.UTF8)));
		return sharedSecret.getBytes();
	}

	@Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(JwtUtilityServiceConfiguration.class, properties);
	}
	
	private JwtUtilityServiceConfiguration _configuration;
	
	@Reference
	private Portal _portal;
	
	private final static Log _log = LogFactoryUtil.getLog(JwtUtilityServiceImpl.class);
	
}