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

package it.servizidigitali.gestioneservizi.model.impl;

import java.util.ArrayList;
import java.util.List;

import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.model.Tipologia;

/**
 * @author Brian Wing Shun Chan
 */
public class ServizioImpl extends ServizioBaseImpl {
	
	private List<Tipologia> listaTipologie = null;
	private AreaTematica areaTematica = null;
	
	public ServizioImpl() {
		this.listaTipologie = new ArrayList<Tipologia>();
	}
	
	public List<Tipologia> getListaTipologie() {
		return listaTipologie;
	}
	public void setListaTipologie(List<Tipologia> listaTipologie) {
		this.listaTipologie = listaTipologie;
	}

	public AreaTematica getAreaTematica() {
		return areaTematica;
	}

	public void setAreaTematica(AreaTematica areaTematica) {
		this.areaTematica = areaTematica;
	}
}