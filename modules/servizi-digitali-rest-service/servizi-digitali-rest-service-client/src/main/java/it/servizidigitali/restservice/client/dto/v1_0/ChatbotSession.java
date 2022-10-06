package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.ChatbotSessionSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class ChatbotSession implements Cloneable, Serializable {

	public static ChatbotSession toDTO(String json) {
		return ChatbotSessionSerDes.toDTO(json);
	}

	public Integer getFallbackCount() {
		return fallbackCount;
	}

	public void setFallbackCount(Integer fallbackCount) {
		this.fallbackCount = fallbackCount;
	}

	public void setFallbackCount(
		UnsafeSupplier<Integer, Exception> fallbackCountUnsafeSupplier) {

		try {
			fallbackCount = fallbackCountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer fallbackCount;

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setLastDate(
		UnsafeSupplier<Date, Exception> lastDateUnsafeSupplier) {

		try {
			lastDate = lastDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date lastDate;

	public String getLastIntentMatched() {
		return lastIntentMatched;
	}

	public void setLastIntentMatched(String lastIntentMatched) {
		this.lastIntentMatched = lastIntentMatched;
	}

	public void setLastIntentMatched(
		UnsafeSupplier<String, Exception> lastIntentMatchedUnsafeSupplier) {

		try {
			lastIntentMatched = lastIntentMatchedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String lastIntentMatched;

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public void setLastMessage(
		UnsafeSupplier<String, Exception> lastMessageUnsafeSupplier) {

		try {
			lastMessage = lastMessageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String lastMessage;

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public void setMessageCount(
		UnsafeSupplier<Integer, Exception> messageCountUnsafeSupplier) {

		try {
			messageCount = messageCountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer messageCount;

	public Integer getNegativeCount() {
		return negativeCount;
	}

	public void setNegativeCount(Integer negativeCount) {
		this.negativeCount = negativeCount;
	}

	public void setNegativeCount(
		UnsafeSupplier<Integer, Exception> negativeCountUnsafeSupplier) {

		try {
			negativeCount = negativeCountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer negativeCount;

	public Integer getPositiveCount() {
		return positiveCount;
	}

	public void setPositiveCount(Integer positiveCount) {
		this.positiveCount = positiveCount;
	}

	public void setPositiveCount(
		UnsafeSupplier<Integer, Exception> positiveCountUnsafeSupplier) {

		try {
			positiveCount = positiveCountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer positiveCount;

	public Integer getResetCount() {
		return resetCount;
	}

	public void setResetCount(Integer resetCount) {
		this.resetCount = resetCount;
	}

	public void setResetCount(
		UnsafeSupplier<Integer, Exception> resetCountUnsafeSupplier) {

		try {
			resetCount = resetCountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer resetCount;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(
		UnsafeSupplier<Date, Exception> startDateUnsafeSupplier) {

		try {
			startDate = startDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date startDate;

	@Override
	public ChatbotSession clone() throws CloneNotSupportedException {
		return (ChatbotSession)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatbotSession)) {
			return false;
		}

		ChatbotSession chatbotSession = (ChatbotSession)object;

		return Objects.equals(toString(), chatbotSession.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ChatbotSessionSerDes.toJSON(this);
	}

}