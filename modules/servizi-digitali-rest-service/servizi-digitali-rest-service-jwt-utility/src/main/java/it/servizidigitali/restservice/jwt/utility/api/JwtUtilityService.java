package it.servizidigitali.restservice.jwt.utility.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.nimbusds.jwt.SignedJWT;

import it.servizidigitali.restservice.jwt.utility.exception.JwtException;

public interface JwtUtilityService {
	
	public String getJWTUserToken(HttpServletRequest request); 

	public String getJWTUserToken(Long companyId, String screenName); 
	
	public SignedJWT verifyJwt(String token) throws JwtException;
	
	public Map<String, Object> verifyJwtAndGetClaims(String token)  throws JwtException ;
	
}
