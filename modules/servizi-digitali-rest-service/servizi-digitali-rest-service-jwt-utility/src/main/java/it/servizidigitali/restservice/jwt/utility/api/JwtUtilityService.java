package it.servizidigitali.restservice.jwt.utility.api;

import javax.servlet.http.HttpServletRequest;

import com.nimbusds.jwt.JWT;

import it.servizidigitali.restservice.jwt.utility.exception.JwtException;

public interface JwtUtilityService {
	
	public String getJWTUserToken(HttpServletRequest request); 

	public String getJWTUserToken(Long companyId, String screenName); 
	
	public JWT verifyJwt(String token) throws JwtException;
	
}
