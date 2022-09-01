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

package it.servizidigitali.gestioneprocedure.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.base.ProceduraFormLocalServiceBaseImpl;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.servizidigitali.gestioneprocedure.model.ProceduraForm",
	service = AopService.class
)
public class ProceduraFormLocalServiceImpl
	extends ProceduraFormLocalServiceBaseImpl {
	
	@Reference
	private FormLocalService formLocalService;
	
	public List<ProceduraForm> salvaListaFormIntegrativi (String[] listaFormIntegrativi, long idProcedura){
		List<ProceduraForm> listaProceduraFormIntegrativi = new ArrayList<ProceduraForm>();
		
		if(Validator.isNotNull(listaFormIntegrativi)) {
			for(String idForm : listaFormIntegrativi) {
				
				ProceduraForm proceduraForm = null;
				
				ProceduraFormPK proceduraFormPk = new ProceduraFormPK();
				proceduraFormPk.setFormId(Long.valueOf(idForm));
				proceduraFormPk.setProceduraId(idProcedura);
				
				proceduraForm = proceduraFormPersistence.create(proceduraFormPk);
				proceduraFormPersistence.update(proceduraForm);
				
				listaProceduraFormIntegrativi.add(proceduraForm);
				
			}
		}
		
		return listaProceduraFormIntegrativi;
	}
	
	public String getFormIntegrativiProcedura(long idProcedura) throws PortalException {
		List<ProceduraForm> listaProceduraForm = new ArrayList<ProceduraForm>();
		List<String> listaFormIntegrativiProcedura = new ArrayList<String>();
		
		listaProceduraForm = proceduraFormPersistence.findByproceduraId(idProcedura);
		
		if(!listaProceduraForm.isEmpty()) {
			for(ProceduraForm proceduraForm : listaProceduraForm) {
				Form form = null;
				
				if(Validator.isNotNull(proceduraForm)) {
					form = formLocalService.getForm(proceduraForm.getFormId());
					
					if(Validator.isNotNull(form)) {
						if(!form.getPrincipale()) {
							listaFormIntegrativiProcedura.add(String.valueOf(form.getFormId()));
						}
					}
				}
				
			}
		}
		
		String listaId = String.join(",", listaFormIntegrativiProcedura);
		listaId = "[" + listaId + "]";
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(listaId);
		String jsonArrayString = JSONFactoryUtil.createJSONSerializer().serialize(jsonArray);
		
		return jsonArrayString;
	}
	
	public long getFormPrincipaleProcedura(long idProcedura) throws PortalException {
		long idFormPrincipale = 0;
		List<ProceduraForm> listaProceduraForm = new ArrayList<ProceduraForm>();
		
		listaProceduraForm = proceduraFormPersistence.findByproceduraId(idProcedura);
		
		if(!listaProceduraForm.isEmpty()) {
			for(ProceduraForm proceduraForm : listaProceduraForm) {
				Form form = null;
				
				if(Validator.isNotNull(proceduraForm)) {
					form = formLocalService.getForm(proceduraForm.getFormId());
					
					if(Validator.isNotNull(form)) {
						if(form.getPrincipale()) {
							idFormPrincipale = form.getFormId();
						}
					}
				}
				
			}
		}
		
		return idFormPrincipale;
	}
}