package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.UpdateStatoRichiestaServizioRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class UpdateStatoRichiestaServizioRequest
	implements Cloneable, Serializable {

	public static UpdateStatoRichiestaServizioRequest toDTO(String json) {
		return UpdateStatoRichiestaServizioRequestSerDes.toDTO(json);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

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
	public UpdateStatoRichiestaServizioRequest clone()
		throws CloneNotSupportedException {

		return (UpdateStatoRichiestaServizioRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UpdateStatoRichiestaServizioRequest)) {
			return false;
		}

		UpdateStatoRichiestaServizioRequest
			updateStatoRichiestaServizioRequest =
				(UpdateStatoRichiestaServizioRequest)object;

		return Objects.equals(
			toString(), updateStatoRichiestaServizioRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return UpdateStatoRichiestaServizioRequestSerDes.toJSON(this);
	}

}