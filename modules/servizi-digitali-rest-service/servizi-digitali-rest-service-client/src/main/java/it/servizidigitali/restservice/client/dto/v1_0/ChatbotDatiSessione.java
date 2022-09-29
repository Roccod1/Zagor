package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.ChatbotDatiSessioneSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class ChatbotDatiSessione implements Cloneable, Serializable {

	public static ChatbotDatiSessione toDTO(String json) {
		return ChatbotDatiSessioneSerDes.toDTO(json);
	}

	public String getIntentMatched() {
		return intentMatched;
	}

	public void setIntentMatched(String intentMatched) {
		this.intentMatched = intentMatched;
	}

	public void setIntentMatched(
		UnsafeSupplier<String, Exception> intentMatchedUnsafeSupplier) {

		try {
			intentMatched = intentMatchedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String intentMatched;

	public Boolean getIsFallback() {
		return isFallback;
	}

	public void setIsFallback(Boolean isFallback) {
		this.isFallback = isFallback;
	}

	public void setIsFallback(
		UnsafeSupplier<Boolean, Exception> isFallbackUnsafeSupplier) {

		try {
			isFallback = isFallbackUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isFallback;

	public Boolean getIsMatched() {
		return isMatched;
	}

	public void setIsMatched(Boolean isMatched) {
		this.isMatched = isMatched;
	}

	public void setIsMatched(
		UnsafeSupplier<Boolean, Exception> isMatchedUnsafeSupplier) {

		try {
			isMatched = isMatchedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isMatched;

	public Boolean getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(Boolean isNegative) {
		this.isNegative = isNegative;
	}

	public void setIsNegative(
		UnsafeSupplier<Boolean, Exception> isNegativeUnsafeSupplier) {

		try {
			isNegative = isNegativeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isNegative;

	public Boolean getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(Boolean isPositive) {
		this.isPositive = isPositive;
	}

	public void setIsPositive(
		UnsafeSupplier<Boolean, Exception> isPositiveUnsafeSupplier) {

		try {
			isPositive = isPositiveUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isPositive;

	public Boolean getIsReset() {
		return isReset;
	}

	public void setIsReset(Boolean isReset) {
		this.isReset = isReset;
	}

	public void setIsReset(
		UnsafeSupplier<Boolean, Exception> isResetUnsafeSupplier) {

		try {
			isReset = isResetUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isReset;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public void setMessageDate(
		UnsafeSupplier<Date, Exception> messageDateUnsafeSupplier) {

		try {
			messageDate = messageDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date messageDate;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setSessionId(
		UnsafeSupplier<String, Exception> sessionIdUnsafeSupplier) {

		try {
			sessionId = sessionIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String sessionId;

	@Override
	public ChatbotDatiSessione clone() throws CloneNotSupportedException {
		return (ChatbotDatiSessione)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatbotDatiSessione)) {
			return false;
		}

		ChatbotDatiSessione chatbotDatiSessione = (ChatbotDatiSessione)object;

		return Objects.equals(toString(), chatbotDatiSessione.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ChatbotDatiSessioneSerDes.toJSON(this);
	}

}