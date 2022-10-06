package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.ChatbotAnswerSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class ChatbotAnswer implements Cloneable, Serializable {

	public static ChatbotAnswer toDTO(String json) {
		return ChatbotAnswerSerDes.toDTO(json);
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public void setMessaggio(
		UnsafeSupplier<String, Exception> messaggioUnsafeSupplier) {

		try {
			messaggio = messaggioUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String messaggio;

	public String getPathServizio() {
		return pathServizio;
	}

	public void setPathServizio(String pathServizio) {
		this.pathServizio = pathServizio;
	}

	public void setPathServizio(
		UnsafeSupplier<String, Exception> pathServizioUnsafeSupplier) {

		try {
			pathServizio = pathServizioUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String pathServizio;

	@Override
	public ChatbotAnswer clone() throws CloneNotSupportedException {
		return (ChatbotAnswer)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatbotAnswer)) {
			return false;
		}

		ChatbotAnswer chatbotAnswer = (ChatbotAnswer)object;

		return Objects.equals(toString(), chatbotAnswer.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ChatbotAnswerSerDes.toJSON(this);
	}

}