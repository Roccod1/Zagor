package it.servizidigitali.communication.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 *
 * @author pindi
 *
 */
@ExtendedObjectClassDefinition(category = "third-party", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "it.servizidigitali.communication.configuration.AccountEnteConfiguration", name = "Configurazione account email/PEC Ente")
public interface AccountEnteConfiguration {

	@Meta.AD(required = false)
	String tenantId();

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita le configurazioni email seguenti")
	boolean accountEmailEnabled();

	@Meta.AD(deflt = "smtp", required = false)
	String emailProtocol();

	@Meta.AD(required = false)
	String emailHost();

	@Meta.AD(required = false)
	Integer emailPort();

	@Meta.AD(required = false)
	Integer emailSmtpSocketFactoryPort();

	@Meta.AD(deflt = "false", required = false)
	boolean emailSmtpAuth();

	@Meta.AD(deflt = "false", required = false)
	boolean emailSmtpStarttlsEnable();

	@Meta.AD(deflt = "false", required = false)
	boolean emailSmtpDebug();

	@Meta.AD(deflt = "false", required = false)
	boolean emailSmtpStarttlsRequired();

	@Meta.AD(deflt = "false", required = false)
	boolean emailSmtpSocketFactoryFallback();

	@Meta.AD(required = false)
	String emailSmtpSslProtocols();

	@Meta.AD(required = false)
	String emailFrom();

	@Meta.AD(required = false)
	String emailUsername();

	@Meta.AD(required = false)
	String emailPassword();

	@Meta.AD(deflt = "false", required = false, description = "Abilita/disabilita le configurazioni PEC seguenti")
	boolean accountPecEnabled();

	@Meta.AD(deflt = "smtp", required = false)
	String pecProtocol();

	@Meta.AD(required = false)
	String pecHost();

	@Meta.AD(required = false)
	Integer pecPort();

	@Meta.AD(required = false)
	Integer pecSmtpSocketFactoryPort();

	@Meta.AD(deflt = "false", required = false)
	boolean pecSmtpAuth();

	@Meta.AD(deflt = "false", required = false)
	boolean pecSmtpStarttlsEnable();

	@Meta.AD(deflt = "false", required = false)
	boolean pecSmtpDebug();

	@Meta.AD(deflt = "false", required = false)
	boolean pecSmtpStarttlsRequired();

	@Meta.AD(deflt = "false", required = false)
	boolean pecSmtpSocketFactoryFallback();

	@Meta.AD(required = false)
	String pecSmtpSslProtocols();

	@Meta.AD(required = false)
	String pecFrom();

	@Meta.AD(required = false)
	String pecUsername();

	@Meta.AD(required = false)
	String pecPassword();
}