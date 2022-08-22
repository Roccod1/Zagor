package it.servizidigitali.communication.model;

import java.io.Serializable;

/**
 *
 * @author pindi
 */
public class DatiEnte implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tenantId;

	private String mailProtocol;
	private String mailHost;
	private Integer mailPort;
	private Integer mailSmtpSocketFactoryPort;
	private Boolean mailSmtpAuth;
	private Boolean mailSmtpStarttlsEnable;
	private Boolean mailSmtpDebug;
	private Boolean mailSmtpStarttlsRequired;
	private Boolean mailSmtpSocketFactoryFallback;
	private String mailSmtpSslProtocols;
	private String mailFrom;
	private String mailUsername;
	private String mailPassword;

	private String pecProtocol;
	private String pecHost;
	private Integer pecPort;
	private Integer pecSmtpSocketFactoryPort;
	private Boolean pecSmtpAuth;
	private Boolean pecSmtpStarttlsEnable;
	private Boolean pecSmtpDebug;
	private Boolean pecSmtpStarttlsRequired;
	private Boolean pecSmtpSocketFactoryFallback;
	private String pecSmtpSslProtocols;
	private String pecFrom;
	private String pecUsername;
	private String pecPassword;

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the mailProtocol
	 */
	public String getMailProtocol() {
		return mailProtocol;
	}

	/**
	 * @param mailProtocol the mailProtocol to set
	 */
	public void setMailProtocol(String mailProtocol) {
		this.mailProtocol = mailProtocol;
	}

	/**
	 * @return the mailHost
	 */
	public String getMailHost() {
		return mailHost;
	}

	/**
	 * @param mailHost the mailHost to set
	 */
	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	/**
	 * @return the mailPort
	 */
	public Integer getMailPort() {
		return mailPort;
	}

	/**
	 * @param mailPort the mailPort to set
	 */
	public void setMailPort(Integer mailPort) {
		this.mailPort = mailPort;
	}

	/**
	 * @return the mailSmtpSocketFactoryPort
	 */
	public Integer getMailSmtpSocketFactoryPort() {
		return mailSmtpSocketFactoryPort;
	}

	/**
	 * @param mailSmtpSocketFactoryPort the mailSmtpSocketFactoryPort to set
	 */
	public void setMailSmtpSocketFactoryPort(Integer mailSmtpSocketFactoryPort) {
		this.mailSmtpSocketFactoryPort = mailSmtpSocketFactoryPort;
	}

	/**
	 * @return the mailSmtpAuth
	 */
	public Boolean getMailSmtpAuth() {
		return mailSmtpAuth;
	}

	/**
	 * @param mailSmtpAuth the mailSmtpAuth to set
	 */
	public void setMailSmtpAuth(Boolean mailSmtpAuth) {
		this.mailSmtpAuth = mailSmtpAuth;
	}

	/**
	 * @return the mailSmtpStarttlsEnable
	 */
	public Boolean getMailSmtpStarttlsEnable() {
		return mailSmtpStarttlsEnable;
	}

	/**
	 * @param mailSmtpStarttlsEnable the mailSmtpStarttlsEnable to set
	 */
	public void setMailSmtpStarttlsEnable(Boolean mailSmtpStarttlsEnable) {
		this.mailSmtpStarttlsEnable = mailSmtpStarttlsEnable;
	}

	/**
	 * @return the mailSmtpDebug
	 */
	public Boolean getMailSmtpDebug() {
		return mailSmtpDebug;
	}

	/**
	 * @param mailSmtpDebug the mailSmtpDebug to set
	 */
	public void setMailSmtpDebug(Boolean mailSmtpDebug) {
		this.mailSmtpDebug = mailSmtpDebug;
	}

	/**
	 * @return the mailSmtpStarttlsRequired
	 */
	public Boolean getMailSmtpStarttlsRequired() {
		return mailSmtpStarttlsRequired;
	}

	/**
	 * @param mailSmtpStarttlsRequired the mailSmtpStarttlsRequired to set
	 */
	public void setMailSmtpStarttlsRequired(Boolean mailSmtpStarttlsRequired) {
		this.mailSmtpStarttlsRequired = mailSmtpStarttlsRequired;
	}

	/**
	 * @return the mailSmtpSocketFactoryFallback
	 */
	public Boolean getMailSmtpSocketFactoryFallback() {
		return mailSmtpSocketFactoryFallback;
	}

	/**
	 * @param mailSmtpSocketFactoryFallback the mailSmtpSocketFactoryFallback to set
	 */
	public void setMailSmtpSocketFactoryFallback(Boolean mailSmtpSocketFactoryFallback) {
		this.mailSmtpSocketFactoryFallback = mailSmtpSocketFactoryFallback;
	}

	/**
	 * @return the mailSmtpSslProtocols
	 */
	public String getMailSmtpSslProtocols() {
		return mailSmtpSslProtocols;
	}

	/**
	 * @param mailSmtpSslProtocols the mailSmtpSslProtocols to set
	 */
	public void setMailSmtpSslProtocols(String mailSmtpSslProtocols) {
		this.mailSmtpSslProtocols = mailSmtpSslProtocols;
	}

	/**
	 * @return the mailFrom
	 */
	public String getMailFrom() {
		return mailFrom;
	}

	/**
	 * @param mailFrom the mailFrom to set
	 */
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	/**
	 * @return the mailUsername
	 */
	public String getMailUsername() {
		return mailUsername;
	}

	/**
	 * @param mailUsername the mailUsername to set
	 */
	public void setMailUsername(String mailUsername) {
		this.mailUsername = mailUsername;
	}

	/**
	 * @return the mailPassword
	 */
	public String getMailPassword() {
		return mailPassword;
	}

	/**
	 * @param mailPassword the mailPassword to set
	 */
	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	/**
	 * @return the pecProtocol
	 */
	public String getPecProtocol() {
		return pecProtocol;
	}

	/**
	 * @param pecProtocol the pecProtocol to set
	 */
	public void setPecProtocol(String pecProtocol) {
		this.pecProtocol = pecProtocol;
	}

	/**
	 * @return the pecHost
	 */
	public String getPecHost() {
		return pecHost;
	}

	/**
	 * @param pecHost the pecHost to set
	 */
	public void setPecHost(String pecHost) {
		this.pecHost = pecHost;
	}

	/**
	 * @return the pecPort
	 */
	public Integer getPecPort() {
		return pecPort;
	}

	/**
	 * @param pecPort the pecPort to set
	 */
	public void setPecPort(Integer pecPort) {
		this.pecPort = pecPort;
	}

	/**
	 * @return the pecSmtpSocketFactoryPort
	 */
	public Integer getPecSmtpSocketFactoryPort() {
		return pecSmtpSocketFactoryPort;
	}

	/**
	 * @param pecSmtpSocketFactoryPort the pecSmtpSocketFactoryPort to set
	 */
	public void setPecSmtpSocketFactoryPort(Integer pecSmtpSocketFactoryPort) {
		this.pecSmtpSocketFactoryPort = pecSmtpSocketFactoryPort;
	}

	/**
	 * @return the pecSmtpAuth
	 */
	public Boolean getPecSmtpAuth() {
		return pecSmtpAuth;
	}

	/**
	 * @param pecSmtpAuth the pecSmtpAuth to set
	 */
	public void setPecSmtpAuth(Boolean pecSmtpAuth) {
		this.pecSmtpAuth = pecSmtpAuth;
	}

	/**
	 * @return the pecSmtpStarttlsEnable
	 */
	public Boolean getPecSmtpStarttlsEnable() {
		return pecSmtpStarttlsEnable;
	}

	/**
	 * @param pecSmtpStarttlsEnable the pecSmtpStarttlsEnable to set
	 */
	public void setPecSmtpStarttlsEnable(Boolean pecSmtpStarttlsEnable) {
		this.pecSmtpStarttlsEnable = pecSmtpStarttlsEnable;
	}

	/**
	 * @return the pecSmtpDebug
	 */
	public Boolean getPecSmtpDebug() {
		return pecSmtpDebug;
	}

	/**
	 * @param pecSmtpDebug the pecSmtpDebug to set
	 */
	public void setPecSmtpDebug(Boolean pecSmtpDebug) {
		this.pecSmtpDebug = pecSmtpDebug;
	}

	/**
	 * @return the pecSmtpStarttlsRequired
	 */
	public Boolean getPecSmtpStarttlsRequired() {
		return pecSmtpStarttlsRequired;
	}

	/**
	 * @param pecSmtpStarttlsRequired the pecSmtpStarttlsRequired to set
	 */
	public void setPecSmtpStarttlsRequired(Boolean pecSmtpStarttlsRequired) {
		this.pecSmtpStarttlsRequired = pecSmtpStarttlsRequired;
	}

	/**
	 * @return the pecSmtpSocketFactoryFallback
	 */
	public Boolean getPecSmtpSocketFactoryFallback() {
		return pecSmtpSocketFactoryFallback;
	}

	/**
	 * @param pecSmtpSocketFactoryFallback the pecSmtpSocketFactoryFallback to set
	 */
	public void setPecSmtpSocketFactoryFallback(Boolean pecSmtpSocketFactoryFallback) {
		this.pecSmtpSocketFactoryFallback = pecSmtpSocketFactoryFallback;
	}

	/**
	 * @return the pecSmtpSslProtocols
	 */
	public String getPecSmtpSslProtocols() {
		return pecSmtpSslProtocols;
	}

	/**
	 * @param pecSmtpSslProtocols the pecSmtpSslProtocols to set
	 */
	public void setPecSmtpSslProtocols(String pecSmtpSslProtocols) {
		this.pecSmtpSslProtocols = pecSmtpSslProtocols;
	}

	/**
	 * @return the pecFrom
	 */
	public String getPecFrom() {
		return pecFrom;
	}

	/**
	 * @param pecFrom the pecFrom to set
	 */
	public void setPecFrom(String pecFrom) {
		this.pecFrom = pecFrom;
	}

	/**
	 * @return the pecUsername
	 */
	public String getPecUsername() {
		return pecUsername;
	}

	/**
	 * @param pecUsername the pecUsername to set
	 */
	public void setPecUsername(String pecUsername) {
		this.pecUsername = pecUsername;
	}

	/**
	 * @return the pecPassword
	 */
	public String getPecPassword() {
		return pecPassword;
	}

	/**
	 * @param pecPassword the pecPassword to set
	 */
	public void setPecPassword(String pecPassword) {
		this.pecPassword = pecPassword;
	}

}
