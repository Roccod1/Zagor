package it.servizidigitali.communication.model.ce;

import java.io.Serializable;
import java.util.List;

/**
 * @author pindi
 *
 */
public class Message implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	private String subject;
	private Contact from;
	private List<Object> to;
	private List<Object> cc;
	private List<Object> bcc;
	private List<Attachment> attachments;
	private Boolean html;
	private Boolean important;
	private String channel;
	private String additionalInfo;
	private String url;
	private Object account;
	private String imageUrl;
	private String externalId;
	private String disclaimer;

	/**
	 * Se <code>true</code> l'invio ai destinatari avverrà in un'unica transazione (se permesso dal
	 * canale), altrimenti ci sarà un unico invio per più destinatari.
	 *
	 */
	private Boolean oneShot;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String toString = "";
		if (to != null) {
			for (int i = 0; i < to.size(); i++) {
				toString += to.get(i).toString();
				if (i < to.size() - 1) {
					toString += ", ";
				}
			}
		}

		return "Channel: " + channel + ", Subject: '" + subject + "', from: " + (from != null ? from.getEmail() : "(null)") + ", to: " + toString;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the from
	 */
	public Contact getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Contact from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public List<Object> getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(List<Object> to) {
		this.to = to;
	}

	/**
	 * @return the cc
	 */
	public List<Object> getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(List<Object> cc) {
		this.cc = cc;
	}

	/**
	 * @return the bcc
	 */
	public List<Object> getBcc() {
		return bcc;
	}

	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(List<Object> bcc) {
		this.bcc = bcc;
	}

	/**
	 * @return the attachments
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 * @return the html
	 */
	public Boolean getHtml() {
		return html;
	}

	/**
	 * @param html the html to set
	 */
	public void setHtml(Boolean html) {
		this.html = html;
	}

	/**
	 * @return the important
	 */
	public Boolean getImportant() {
		return important;
	}

	/**
	 * @param important the important to set
	 */
	public void setImportant(Boolean important) {
		this.important = important;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the additionalInfo
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	/**
	 * @return the oneShot
	 */
	public Boolean getOneShot() {
		return oneShot;
	}

	public void setOneShot(Boolean oneShot) {
		this.oneShot = oneShot;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the account
	 */
	public Object getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Object account) {
		this.account = account;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the externalId
	 */
	public String getExternalId() {
		return externalId;
	}

	/**
	 * @param externalId the externalId to set
	 */
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	/**
	 * @return the disclaimer
	 */
	public String getDisclaimer() {
		return disclaimer;
	}

	/**
	 * @param disclaimer the disclaimer to set
	 */
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

}
