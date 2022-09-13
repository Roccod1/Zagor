/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package it.servizidigitali.gestioneprocedure.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.base.ProceduraFormLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneprocedure.model.ProceduraForm", service = AopService.class)
public class ProceduraFormLocalServiceImpl extends ProceduraFormLocalServiceBaseImpl {
	
	public List<ProceduraForm> getListaProceduraFormProcedura(long proceduraId){
		List<ProceduraForm> listaProceduraForm = null;
		
		if(proceduraId>0) {
			listaProceduraForm = new ArrayList<ProceduraForm>();
			listaProceduraForm = proceduraFormPersistence.findByProceduraId(proceduraId);
		}
		
		return listaProceduraForm;
	}
}