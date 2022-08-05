package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.InsertRichiestaServizioRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class InsertRichiestaServizioRequest implements Cloneable, Serializable {

	public static InsertRichiestaServizioRequest toDTO(String json) {
		return InsertRichiestaServizioRequestSerDes.toDTO(json);
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public void setStato(
		UnsafeSupplier<String, Exception> statoUnsafeSupplier) {

		try {
			stato = statoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String stato;

	@Override
	public InsertRichiestaServizioRequest clone()
		throws CloneNotSupportedException {

		return (InsertRichiestaServizioRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InsertRichiestaServizioRequest)) {
			return false;
		}

		InsertRichiestaServizioRequest insertRichiestaServizioRequest =
			(InsertRichiestaServizioRequest)object;

		return Objects.equals(
			toString(), insertRichiestaServizioRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return InsertRichiestaServizioRequestSerDes.toJSON(this);
	}

}