package it.servizidigitali.communication.model.ce;

import java.io.Serializable;

/**
 * @author pindi
 *
 */

public class Account implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String host;
	private int port;
	private String protocol;
	private String username;
	private String password;
	private String type;
	private Integer socketFactoryPort;
	private Boolean debug;
	private Boolean socketFactoryFallback;
	private String from;

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the socketFactoryPort
	 */
	public Integer getSocketFactoryPort() {
		return socketFactoryPort;
	}

	/**
	 * @param socketFactoryPort the socketFactoryPort to set
	 */
	public void setSocketFactoryPort(Integer socketFactoryPort) {
		this.socketFactoryPort = socketFactoryPort;
	}

	/**
	 * @return the debug
	 */
	public Boolean getDebug() {
		return debug;
	}

	/**
	 * @param debug the debug to set
	 */
	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	/**
	 * @return the socketFactoryFallback
	 */
	public Boolean getSocketFactoryFallback() {
		return socketFactoryFallback;
	}

	/**
	 * @param socketFactoryFallback the socketFactoryFallback to set
	 */
	public void setSocketFactoryFallback(Boolean socketFactoryFallback) {
		this.socketFactoryFallback = socketFactoryFallback;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

}
