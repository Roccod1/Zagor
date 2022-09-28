package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.CountServizioEnteSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class CountServizioEnte implements Cloneable, Serializable {

	public static CountServizioEnte toDTO(String json) {
		return CountServizioEnteSerDes.toDTO(json);
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

	public Long getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(Long serviceCount) {
		this.serviceCount = serviceCount;
	}

	public void setServiceCount(
		UnsafeSupplier<Long, Exception> serviceCountUnsafeSupplier) {

		try {
			serviceCount = serviceCountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long serviceCount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String title;

	@Override
	public CountServizioEnte clone() throws CloneNotSupportedException {
		return (CountServizioEnte)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CountServizioEnte)) {
			return false;
		}

		CountServizioEnte countServizioEnte = (CountServizioEnte)object;

		return Objects.equals(toString(), countServizioEnte.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CountServizioEnteSerDes.toJSON(this);
	}

}