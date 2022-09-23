package it.servizidigitali.restservice.client.dto.v1_0;

import it.servizidigitali.restservice.client.function.UnsafeSupplier;
import it.servizidigitali.restservice.client.serdes.v1_0.ComponenteNucleoFamiliareLightSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public class ComponenteNucleoFamiliareLight implements Cloneable, Serializable {

	public static ComponenteNucleoFamiliareLight toDTO(String json) {
		return ComponenteNucleoFamiliareLightSerDes.toDTO(json);
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setCodiceFiscale(
		UnsafeSupplier<String, Exception> codiceFiscaleUnsafeSupplier) {

		try {
			codiceFiscale = codiceFiscaleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codiceFiscale;

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCognome(
		UnsafeSupplier<String, Exception> cognomeUnsafeSupplier) {

		try {
			cognome = cognomeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String cognome;

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setDataNascita(
		UnsafeSupplier<Date, Exception> dataNascitaUnsafeSupplier) {

		try {
			dataNascita = dataNascitaUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dataNascita;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNome(UnsafeSupplier<String, Exception> nomeUnsafeSupplier) {
		try {
			nome = nomeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String nome;

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public void setSesso(
		UnsafeSupplier<String, Exception> sessoUnsafeSupplier) {

		try {
			sesso = sessoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String sesso;

	@Override
	public ComponenteNucleoFamiliareLight clone()
		throws CloneNotSupportedException {

		return (ComponenteNucleoFamiliareLight)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComponenteNucleoFamiliareLight)) {
			return false;
		}

		ComponenteNucleoFamiliareLight componenteNucleoFamiliareLight =
			(ComponenteNucleoFamiliareLight)object;

		return Objects.equals(
			toString(), componenteNucleoFamiliareLight.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ComponenteNucleoFamiliareLightSerDes.toJSON(this);
	}

}