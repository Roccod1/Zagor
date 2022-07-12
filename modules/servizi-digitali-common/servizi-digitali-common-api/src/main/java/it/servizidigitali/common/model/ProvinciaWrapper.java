/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.servizidigitali.common.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Provincia}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Provincia
 * @generated
 */
public class ProvinciaWrapper
	extends BaseModelWrapper<Provincia>
	implements ModelWrapper<Provincia>, Provincia {

	public ProvinciaWrapper(Provincia provincia) {
		super(provincia);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("provinciaId", getProvinciaId());
		attributes.put("codiceRipartizione", getCodiceRipartizione());
		attributes.put("codiceNUTS1", getCodiceNUTS1());
		attributes.put("ripartizioneGeograficaM", getRipartizioneGeograficaM());
		attributes.put("ripartizioneGeografica", getRipartizioneGeografica());
		attributes.put("denominazioneRegioneM", getDenominazioneRegioneM());
		attributes.put("denominazioneRegione", getDenominazioneRegione());
		attributes.put("denominazioneProvincia", getDenominazioneProvincia());
		attributes.put("codiceRegione", getCodiceRegione());
		attributes.put("codiceNUTS2", getCodiceNUTS2());
		attributes.put("codiceNUTS3", getCodiceNUTS3());
		attributes.put("sigla", getSigla());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long provinciaId = (Long)attributes.get("provinciaId");

		if (provinciaId != null) {
			setProvinciaId(provinciaId);
		}

		Integer codiceRipartizione = (Integer)attributes.get(
			"codiceRipartizione");

		if (codiceRipartizione != null) {
			setCodiceRipartizione(codiceRipartizione);
		}

		String codiceNUTS1 = (String)attributes.get("codiceNUTS1");

		if (codiceNUTS1 != null) {
			setCodiceNUTS1(codiceNUTS1);
		}

		String ripartizioneGeograficaM = (String)attributes.get(
			"ripartizioneGeograficaM");

		if (ripartizioneGeograficaM != null) {
			setRipartizioneGeograficaM(ripartizioneGeograficaM);
		}

		String ripartizioneGeografica = (String)attributes.get(
			"ripartizioneGeografica");

		if (ripartizioneGeografica != null) {
			setRipartizioneGeografica(ripartizioneGeografica);
		}

		String denominazioneRegioneM = (String)attributes.get(
			"denominazioneRegioneM");

		if (denominazioneRegioneM != null) {
			setDenominazioneRegioneM(denominazioneRegioneM);
		}

		String denominazioneRegione = (String)attributes.get(
			"denominazioneRegione");

		if (denominazioneRegione != null) {
			setDenominazioneRegione(denominazioneRegione);
		}

		String denominazioneProvincia = (String)attributes.get(
			"denominazioneProvincia");

		if (denominazioneProvincia != null) {
			setDenominazioneProvincia(denominazioneProvincia);
		}

		Long codiceRegione = (Long)attributes.get("codiceRegione");

		if (codiceRegione != null) {
			setCodiceRegione(codiceRegione);
		}

		String codiceNUTS2 = (String)attributes.get("codiceNUTS2");

		if (codiceNUTS2 != null) {
			setCodiceNUTS2(codiceNUTS2);
		}

		String codiceNUTS3 = (String)attributes.get("codiceNUTS3");

		if (codiceNUTS3 != null) {
			setCodiceNUTS3(codiceNUTS3);
		}

		String sigla = (String)attributes.get("sigla");

		if (sigla != null) {
			setSigla(sigla);
		}
	}

	@Override
	public Provincia cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice nuts1 of this provincia.
	 *
	 * @return the codice nuts1 of this provincia
	 */
	@Override
	public String getCodiceNUTS1() {
		return model.getCodiceNUTS1();
	}

	/**
	 * Returns the codice nuts2 of this provincia.
	 *
	 * @return the codice nuts2 of this provincia
	 */
	@Override
	public String getCodiceNUTS2() {
		return model.getCodiceNUTS2();
	}

	/**
	 * Returns the codice nuts3 of this provincia.
	 *
	 * @return the codice nuts3 of this provincia
	 */
	@Override
	public String getCodiceNUTS3() {
		return model.getCodiceNUTS3();
	}

	/**
	 * Returns the codice regione of this provincia.
	 *
	 * @return the codice regione of this provincia
	 */
	@Override
	public long getCodiceRegione() {
		return model.getCodiceRegione();
	}

	/**
	 * Returns the codice ripartizione of this provincia.
	 *
	 * @return the codice ripartizione of this provincia
	 */
	@Override
	public int getCodiceRipartizione() {
		return model.getCodiceRipartizione();
	}

	/**
	 * Returns the denominazione provincia of this provincia.
	 *
	 * @return the denominazione provincia of this provincia
	 */
	@Override
	public String getDenominazioneProvincia() {
		return model.getDenominazioneProvincia();
	}

	/**
	 * Returns the denominazione regione of this provincia.
	 *
	 * @return the denominazione regione of this provincia
	 */
	@Override
	public String getDenominazioneRegione() {
		return model.getDenominazioneRegione();
	}

	/**
	 * Returns the denominazione regione m of this provincia.
	 *
	 * @return the denominazione regione m of this provincia
	 */
	@Override
	public String getDenominazioneRegioneM() {
		return model.getDenominazioneRegioneM();
	}

	/**
	 * Returns the primary key of this provincia.
	 *
	 * @return the primary key of this provincia
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia ID of this provincia.
	 *
	 * @return the provincia ID of this provincia
	 */
	@Override
	public long getProvinciaId() {
		return model.getProvinciaId();
	}

	/**
	 * Returns the ripartizione geografica of this provincia.
	 *
	 * @return the ripartizione geografica of this provincia
	 */
	@Override
	public String getRipartizioneGeografica() {
		return model.getRipartizioneGeografica();
	}

	/**
	 * Returns the ripartizione geografica m of this provincia.
	 *
	 * @return the ripartizione geografica m of this provincia
	 */
	@Override
	public String getRipartizioneGeograficaM() {
		return model.getRipartizioneGeograficaM();
	}

	/**
	 * Returns the sigla of this provincia.
	 *
	 * @return the sigla of this provincia
	 */
	@Override
	public String getSigla() {
		return model.getSigla();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codice nuts1 of this provincia.
	 *
	 * @param codiceNUTS1 the codice nuts1 of this provincia
	 */
	@Override
	public void setCodiceNUTS1(String codiceNUTS1) {
		model.setCodiceNUTS1(codiceNUTS1);
	}

	/**
	 * Sets the codice nuts2 of this provincia.
	 *
	 * @param codiceNUTS2 the codice nuts2 of this provincia
	 */
	@Override
	public void setCodiceNUTS2(String codiceNUTS2) {
		model.setCodiceNUTS2(codiceNUTS2);
	}

	/**
	 * Sets the codice nuts3 of this provincia.
	 *
	 * @param codiceNUTS3 the codice nuts3 of this provincia
	 */
	@Override
	public void setCodiceNUTS3(String codiceNUTS3) {
		model.setCodiceNUTS3(codiceNUTS3);
	}

	/**
	 * Sets the codice regione of this provincia.
	 *
	 * @param codiceRegione the codice regione of this provincia
	 */
	@Override
	public void setCodiceRegione(long codiceRegione) {
		model.setCodiceRegione(codiceRegione);
	}

	/**
	 * Sets the codice ripartizione of this provincia.
	 *
	 * @param codiceRipartizione the codice ripartizione of this provincia
	 */
	@Override
	public void setCodiceRipartizione(int codiceRipartizione) {
		model.setCodiceRipartizione(codiceRipartizione);
	}

	/**
	 * Sets the denominazione provincia of this provincia.
	 *
	 * @param denominazioneProvincia the denominazione provincia of this provincia
	 */
	@Override
	public void setDenominazioneProvincia(String denominazioneProvincia) {
		model.setDenominazioneProvincia(denominazioneProvincia);
	}

	/**
	 * Sets the denominazione regione of this provincia.
	 *
	 * @param denominazioneRegione the denominazione regione of this provincia
	 */
	@Override
	public void setDenominazioneRegione(String denominazioneRegione) {
		model.setDenominazioneRegione(denominazioneRegione);
	}

	/**
	 * Sets the denominazione regione m of this provincia.
	 *
	 * @param denominazioneRegioneM the denominazione regione m of this provincia
	 */
	@Override
	public void setDenominazioneRegioneM(String denominazioneRegioneM) {
		model.setDenominazioneRegioneM(denominazioneRegioneM);
	}

	/**
	 * Sets the primary key of this provincia.
	 *
	 * @param primaryKey the primary key of this provincia
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia ID of this provincia.
	 *
	 * @param provinciaId the provincia ID of this provincia
	 */
	@Override
	public void setProvinciaId(long provinciaId) {
		model.setProvinciaId(provinciaId);
	}

	/**
	 * Sets the ripartizione geografica of this provincia.
	 *
	 * @param ripartizioneGeografica the ripartizione geografica of this provincia
	 */
	@Override
	public void setRipartizioneGeografica(String ripartizioneGeografica) {
		model.setRipartizioneGeografica(ripartizioneGeografica);
	}

	/**
	 * Sets the ripartizione geografica m of this provincia.
	 *
	 * @param ripartizioneGeograficaM the ripartizione geografica m of this provincia
	 */
	@Override
	public void setRipartizioneGeograficaM(String ripartizioneGeograficaM) {
		model.setRipartizioneGeograficaM(ripartizioneGeograficaM);
	}

	/**
	 * Sets the sigla of this provincia.
	 *
	 * @param sigla the sigla of this provincia
	 */
	@Override
	public void setSigla(String sigla) {
		model.setSigla(sigla);
	}

	@Override
	protected ProvinciaWrapper wrap(Provincia provincia) {
		return new ProvinciaWrapper(provincia);
	}

}