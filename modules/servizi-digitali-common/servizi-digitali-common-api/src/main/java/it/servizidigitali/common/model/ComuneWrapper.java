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
 * This class is a wrapper for {@link Comune}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Comune
 * @generated
 */
public class ComuneWrapper
	extends BaseModelWrapper<Comune> implements Comune, ModelWrapper<Comune> {

	public ComuneWrapper(Comune comune) {
		super(comune);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("comuneId", getComuneId());
		attributes.put("codiceIstatAN", getCodiceIstatAN());
		attributes.put("codiceIstat1", getCodiceIstat1());
		attributes.put("codiceIstat103", getCodiceIstat103());
		attributes.put("codicestat107", getCodicestat107());
		attributes.put("denominazione", getDenominazione());
		attributes.put("capoluogo", isCapoluogo());
		attributes.put("zonaAltimetrica", getZonaAltimetrica());
		attributes.put("altitudine", getAltitudine());
		attributes.put("comuneLitoraneo", isComuneLitoraneo());
		attributes.put("comuneMontano", getComuneMontano());
		attributes.put(
			"codiceSistemaLocaleLavoro", getCodiceSistemaLocaleLavoro());
		attributes.put(
			"denominazioneSistemaLocaleLavoro",
			getDenominazioneSistemaLocaleLavoro());
		attributes.put("superficie", getSuperficie());
		attributes.put("popolazioneLegale", getPopolazioneLegale());
		attributes.put("popolazioneResidente1", getPopolazioneResidente1());
		attributes.put("popolazioneResidente2", getPopolazioneResidente2());
		attributes.put("popolazioneResidente3", getPopolazioneResidente3());
		attributes.put("codiceComune", getCodiceComune());
		attributes.put("codiceCatastale", getCodiceCatastale());
		attributes.put("idRegione", getIdRegione());
		attributes.put("idProvincia", getIdProvincia());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long comuneId = (Long)attributes.get("comuneId");

		if (comuneId != null) {
			setComuneId(comuneId);
		}

		String codiceIstatAN = (String)attributes.get("codiceIstatAN");

		if (codiceIstatAN != null) {
			setCodiceIstatAN(codiceIstatAN);
		}

		String codiceIstat1 = (String)attributes.get("codiceIstat1");

		if (codiceIstat1 != null) {
			setCodiceIstat1(codiceIstat1);
		}

		String codiceIstat103 = (String)attributes.get("codiceIstat103");

		if (codiceIstat103 != null) {
			setCodiceIstat103(codiceIstat103);
		}

		String codicestat107 = (String)attributes.get("codicestat107");

		if (codicestat107 != null) {
			setCodicestat107(codicestat107);
		}

		String denominazione = (String)attributes.get("denominazione");

		if (denominazione != null) {
			setDenominazione(denominazione);
		}

		Boolean capoluogo = (Boolean)attributes.get("capoluogo");

		if (capoluogo != null) {
			setCapoluogo(capoluogo);
		}

		String zonaAltimetrica = (String)attributes.get("zonaAltimetrica");

		if (zonaAltimetrica != null) {
			setZonaAltimetrica(zonaAltimetrica);
		}

		String altitudine = (String)attributes.get("altitudine");

		if (altitudine != null) {
			setAltitudine(altitudine);
		}

		Boolean comuneLitoraneo = (Boolean)attributes.get("comuneLitoraneo");

		if (comuneLitoraneo != null) {
			setComuneLitoraneo(comuneLitoraneo);
		}

		String comuneMontano = (String)attributes.get("comuneMontano");

		if (comuneMontano != null) {
			setComuneMontano(comuneMontano);
		}

		String codiceSistemaLocaleLavoro = (String)attributes.get(
			"codiceSistemaLocaleLavoro");

		if (codiceSistemaLocaleLavoro != null) {
			setCodiceSistemaLocaleLavoro(codiceSistemaLocaleLavoro);
		}

		String denominazioneSistemaLocaleLavoro = (String)attributes.get(
			"denominazioneSistemaLocaleLavoro");

		if (denominazioneSistemaLocaleLavoro != null) {
			setDenominazioneSistemaLocaleLavoro(
				denominazioneSistemaLocaleLavoro);
		}

		String superficie = (String)attributes.get("superficie");

		if (superficie != null) {
			setSuperficie(superficie);
		}

		String popolazioneLegale = (String)attributes.get("popolazioneLegale");

		if (popolazioneLegale != null) {
			setPopolazioneLegale(popolazioneLegale);
		}

		String popolazioneResidente1 = (String)attributes.get(
			"popolazioneResidente1");

		if (popolazioneResidente1 != null) {
			setPopolazioneResidente1(popolazioneResidente1);
		}

		String popolazioneResidente2 = (String)attributes.get(
			"popolazioneResidente2");

		if (popolazioneResidente2 != null) {
			setPopolazioneResidente2(popolazioneResidente2);
		}

		String popolazioneResidente3 = (String)attributes.get(
			"popolazioneResidente3");

		if (popolazioneResidente3 != null) {
			setPopolazioneResidente3(popolazioneResidente3);
		}

		Integer codiceComune = (Integer)attributes.get("codiceComune");

		if (codiceComune != null) {
			setCodiceComune(codiceComune);
		}

		String codiceCatastale = (String)attributes.get("codiceCatastale");

		if (codiceCatastale != null) {
			setCodiceCatastale(codiceCatastale);
		}

		Long idRegione = (Long)attributes.get("idRegione");

		if (idRegione != null) {
			setIdRegione(idRegione);
		}

		Long idProvincia = (Long)attributes.get("idProvincia");

		if (idProvincia != null) {
			setIdProvincia(idProvincia);
		}
	}

	@Override
	public Comune cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the altitudine of this comune.
	 *
	 * @return the altitudine of this comune
	 */
	@Override
	public String getAltitudine() {
		return model.getAltitudine();
	}

	/**
	 * Returns the capoluogo of this comune.
	 *
	 * @return the capoluogo of this comune
	 */
	@Override
	public boolean getCapoluogo() {
		return model.getCapoluogo();
	}

	/**
	 * Returns the codice catastale of this comune.
	 *
	 * @return the codice catastale of this comune
	 */
	@Override
	public String getCodiceCatastale() {
		return model.getCodiceCatastale();
	}

	/**
	 * Returns the codice comune of this comune.
	 *
	 * @return the codice comune of this comune
	 */
	@Override
	public int getCodiceComune() {
		return model.getCodiceComune();
	}

	/**
	 * Returns the codice istat1 of this comune.
	 *
	 * @return the codice istat1 of this comune
	 */
	@Override
	public String getCodiceIstat1() {
		return model.getCodiceIstat1();
	}

	/**
	 * Returns the codice istat103 of this comune.
	 *
	 * @return the codice istat103 of this comune
	 */
	@Override
	public String getCodiceIstat103() {
		return model.getCodiceIstat103();
	}

	/**
	 * Returns the codice istat an of this comune.
	 *
	 * @return the codice istat an of this comune
	 */
	@Override
	public String getCodiceIstatAN() {
		return model.getCodiceIstatAN();
	}

	/**
	 * Returns the codice sistema locale lavoro of this comune.
	 *
	 * @return the codice sistema locale lavoro of this comune
	 */
	@Override
	public String getCodiceSistemaLocaleLavoro() {
		return model.getCodiceSistemaLocaleLavoro();
	}

	/**
	 * Returns the codicestat107 of this comune.
	 *
	 * @return the codicestat107 of this comune
	 */
	@Override
	public String getCodicestat107() {
		return model.getCodicestat107();
	}

	/**
	 * Returns the comune ID of this comune.
	 *
	 * @return the comune ID of this comune
	 */
	@Override
	public long getComuneId() {
		return model.getComuneId();
	}

	/**
	 * Returns the comune litoraneo of this comune.
	 *
	 * @return the comune litoraneo of this comune
	 */
	@Override
	public boolean getComuneLitoraneo() {
		return model.getComuneLitoraneo();
	}

	/**
	 * Returns the comune montano of this comune.
	 *
	 * @return the comune montano of this comune
	 */
	@Override
	public String getComuneMontano() {
		return model.getComuneMontano();
	}

	/**
	 * Returns the denominazione of this comune.
	 *
	 * @return the denominazione of this comune
	 */
	@Override
	public String getDenominazione() {
		return model.getDenominazione();
	}

	/**
	 * Returns the denominazione sistema locale lavoro of this comune.
	 *
	 * @return the denominazione sistema locale lavoro of this comune
	 */
	@Override
	public String getDenominazioneSistemaLocaleLavoro() {
		return model.getDenominazioneSistemaLocaleLavoro();
	}

	/**
	 * Returns the id provincia of this comune.
	 *
	 * @return the id provincia of this comune
	 */
	@Override
	public long getIdProvincia() {
		return model.getIdProvincia();
	}

	/**
	 * Returns the id regione of this comune.
	 *
	 * @return the id regione of this comune
	 */
	@Override
	public long getIdRegione() {
		return model.getIdRegione();
	}

	/**
	 * Returns the popolazione legale of this comune.
	 *
	 * @return the popolazione legale of this comune
	 */
	@Override
	public String getPopolazioneLegale() {
		return model.getPopolazioneLegale();
	}

	/**
	 * Returns the popolazione residente1 of this comune.
	 *
	 * @return the popolazione residente1 of this comune
	 */
	@Override
	public String getPopolazioneResidente1() {
		return model.getPopolazioneResidente1();
	}

	/**
	 * Returns the popolazione residente2 of this comune.
	 *
	 * @return the popolazione residente2 of this comune
	 */
	@Override
	public String getPopolazioneResidente2() {
		return model.getPopolazioneResidente2();
	}

	/**
	 * Returns the popolazione residente3 of this comune.
	 *
	 * @return the popolazione residente3 of this comune
	 */
	@Override
	public String getPopolazioneResidente3() {
		return model.getPopolazioneResidente3();
	}

	/**
	 * Returns the primary key of this comune.
	 *
	 * @return the primary key of this comune
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the superficie of this comune.
	 *
	 * @return the superficie of this comune
	 */
	@Override
	public String getSuperficie() {
		return model.getSuperficie();
	}

	/**
	 * Returns the zona altimetrica of this comune.
	 *
	 * @return the zona altimetrica of this comune
	 */
	@Override
	public String getZonaAltimetrica() {
		return model.getZonaAltimetrica();
	}

	/**
	 * Returns <code>true</code> if this comune is capoluogo.
	 *
	 * @return <code>true</code> if this comune is capoluogo; <code>false</code> otherwise
	 */
	@Override
	public boolean isCapoluogo() {
		return model.isCapoluogo();
	}

	/**
	 * Returns <code>true</code> if this comune is comune litoraneo.
	 *
	 * @return <code>true</code> if this comune is comune litoraneo; <code>false</code> otherwise
	 */
	@Override
	public boolean isComuneLitoraneo() {
		return model.isComuneLitoraneo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the altitudine of this comune.
	 *
	 * @param altitudine the altitudine of this comune
	 */
	@Override
	public void setAltitudine(String altitudine) {
		model.setAltitudine(altitudine);
	}

	/**
	 * Sets whether this comune is capoluogo.
	 *
	 * @param capoluogo the capoluogo of this comune
	 */
	@Override
	public void setCapoluogo(boolean capoluogo) {
		model.setCapoluogo(capoluogo);
	}

	/**
	 * Sets the codice catastale of this comune.
	 *
	 * @param codiceCatastale the codice catastale of this comune
	 */
	@Override
	public void setCodiceCatastale(String codiceCatastale) {
		model.setCodiceCatastale(codiceCatastale);
	}

	/**
	 * Sets the codice comune of this comune.
	 *
	 * @param codiceComune the codice comune of this comune
	 */
	@Override
	public void setCodiceComune(int codiceComune) {
		model.setCodiceComune(codiceComune);
	}

	/**
	 * Sets the codice istat1 of this comune.
	 *
	 * @param codiceIstat1 the codice istat1 of this comune
	 */
	@Override
	public void setCodiceIstat1(String codiceIstat1) {
		model.setCodiceIstat1(codiceIstat1);
	}

	/**
	 * Sets the codice istat103 of this comune.
	 *
	 * @param codiceIstat103 the codice istat103 of this comune
	 */
	@Override
	public void setCodiceIstat103(String codiceIstat103) {
		model.setCodiceIstat103(codiceIstat103);
	}

	/**
	 * Sets the codice istat an of this comune.
	 *
	 * @param codiceIstatAN the codice istat an of this comune
	 */
	@Override
	public void setCodiceIstatAN(String codiceIstatAN) {
		model.setCodiceIstatAN(codiceIstatAN);
	}

	/**
	 * Sets the codice sistema locale lavoro of this comune.
	 *
	 * @param codiceSistemaLocaleLavoro the codice sistema locale lavoro of this comune
	 */
	@Override
	public void setCodiceSistemaLocaleLavoro(String codiceSistemaLocaleLavoro) {
		model.setCodiceSistemaLocaleLavoro(codiceSistemaLocaleLavoro);
	}

	/**
	 * Sets the codicestat107 of this comune.
	 *
	 * @param codicestat107 the codicestat107 of this comune
	 */
	@Override
	public void setCodicestat107(String codicestat107) {
		model.setCodicestat107(codicestat107);
	}

	/**
	 * Sets the comune ID of this comune.
	 *
	 * @param comuneId the comune ID of this comune
	 */
	@Override
	public void setComuneId(long comuneId) {
		model.setComuneId(comuneId);
	}

	/**
	 * Sets whether this comune is comune litoraneo.
	 *
	 * @param comuneLitoraneo the comune litoraneo of this comune
	 */
	@Override
	public void setComuneLitoraneo(boolean comuneLitoraneo) {
		model.setComuneLitoraneo(comuneLitoraneo);
	}

	/**
	 * Sets the comune montano of this comune.
	 *
	 * @param comuneMontano the comune montano of this comune
	 */
	@Override
	public void setComuneMontano(String comuneMontano) {
		model.setComuneMontano(comuneMontano);
	}

	/**
	 * Sets the denominazione of this comune.
	 *
	 * @param denominazione the denominazione of this comune
	 */
	@Override
	public void setDenominazione(String denominazione) {
		model.setDenominazione(denominazione);
	}

	/**
	 * Sets the denominazione sistema locale lavoro of this comune.
	 *
	 * @param denominazioneSistemaLocaleLavoro the denominazione sistema locale lavoro of this comune
	 */
	@Override
	public void setDenominazioneSistemaLocaleLavoro(
		String denominazioneSistemaLocaleLavoro) {

		model.setDenominazioneSistemaLocaleLavoro(
			denominazioneSistemaLocaleLavoro);
	}

	/**
	 * Sets the id provincia of this comune.
	 *
	 * @param idProvincia the id provincia of this comune
	 */
	@Override
	public void setIdProvincia(long idProvincia) {
		model.setIdProvincia(idProvincia);
	}

	/**
	 * Sets the id regione of this comune.
	 *
	 * @param idRegione the id regione of this comune
	 */
	@Override
	public void setIdRegione(long idRegione) {
		model.setIdRegione(idRegione);
	}

	/**
	 * Sets the popolazione legale of this comune.
	 *
	 * @param popolazioneLegale the popolazione legale of this comune
	 */
	@Override
	public void setPopolazioneLegale(String popolazioneLegale) {
		model.setPopolazioneLegale(popolazioneLegale);
	}

	/**
	 * Sets the popolazione residente1 of this comune.
	 *
	 * @param popolazioneResidente1 the popolazione residente1 of this comune
	 */
	@Override
	public void setPopolazioneResidente1(String popolazioneResidente1) {
		model.setPopolazioneResidente1(popolazioneResidente1);
	}

	/**
	 * Sets the popolazione residente2 of this comune.
	 *
	 * @param popolazioneResidente2 the popolazione residente2 of this comune
	 */
	@Override
	public void setPopolazioneResidente2(String popolazioneResidente2) {
		model.setPopolazioneResidente2(popolazioneResidente2);
	}

	/**
	 * Sets the popolazione residente3 of this comune.
	 *
	 * @param popolazioneResidente3 the popolazione residente3 of this comune
	 */
	@Override
	public void setPopolazioneResidente3(String popolazioneResidente3) {
		model.setPopolazioneResidente3(popolazioneResidente3);
	}

	/**
	 * Sets the primary key of this comune.
	 *
	 * @param primaryKey the primary key of this comune
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the superficie of this comune.
	 *
	 * @param superficie the superficie of this comune
	 */
	@Override
	public void setSuperficie(String superficie) {
		model.setSuperficie(superficie);
	}

	/**
	 * Sets the zona altimetrica of this comune.
	 *
	 * @param zonaAltimetrica the zona altimetrica of this comune
	 */
	@Override
	public void setZonaAltimetrica(String zonaAltimetrica) {
		model.setZonaAltimetrica(zonaAltimetrica);
	}

	@Override
	protected ComuneWrapper wrap(Comune comune) {
		return new ComuneWrapper(comune);
	}

}