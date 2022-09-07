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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.FormLocalService;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.service.base.ProceduraFormLocalServiceBaseImpl;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=it.servizidigitali.gestioneprocedure.model.ProceduraForm", service = AopService.class)
public class ProceduraFormLocalServiceImpl extends ProceduraFormLocalServiceBaseImpl {

	public static final Log _log = LogFactoryUtil.getLog(ProceduraFormLocalServiceImpl.class);

	@Reference
	private FormLocalService formLocalService;

	@Override
	public void salvaListaFormIntegrativi(String[] listaFormIntegrativi, long idProcedura) {
		List<ProceduraForm> listaProceduraForm1 = proceduraFormPersistence.findByProceduraId(idProcedura);
		List<ProceduraForm> listaProceduraForm2 = new ArrayList<ProceduraForm>();

		if (Validator.isNotNull(listaFormIntegrativi)) {
			for (String idForm : listaFormIntegrativi) {
				ProceduraFormPK proceduraFormPk = new ProceduraFormPK();
				proceduraFormPk.setProceduraId(idProcedura);
				proceduraFormPk.setFormId(Long.valueOf(idForm));
				ProceduraForm proceduraForm = proceduraFormPersistence.create(proceduraFormPk);
				listaProceduraForm2.add(proceduraForm);
			}
		}

		if (Validator.isNotNull(listaProceduraForm1)) {
			long idFormPrincipaleProcedura = getFormPrincipaleProcedura(idProcedura);
			if (Validator.isNotNull(listaProceduraForm2)) {
				List<ProceduraForm> elementiDaEliminare = listaProceduraForm1.stream()
						.filter(proceduraForm -> !listaProceduraForm2.contains(proceduraForm) && proceduraForm.getFormId() != idFormPrincipaleProcedura).collect(Collectors.toList());
				List<ProceduraForm> elementiDaAggiungere = listaProceduraForm2.stream()
						.filter(proceduraForm -> !listaProceduraForm1.contains(proceduraForm) && proceduraForm.getFormId() != idFormPrincipaleProcedura).collect(Collectors.toList());

				for (ProceduraForm proceduraForm : elementiDaEliminare) {
					proceduraFormPersistence.remove(proceduraForm);
				}

				for (ProceduraForm proceduraForm : elementiDaAggiungere) {
					proceduraFormPersistence.update(proceduraForm);
				}

			}
		}
		else {
			for (ProceduraForm proceduraForm : listaProceduraForm2) {
				proceduraFormPersistence.update(proceduraForm);
			}
		}

	}

	@Override
	public ProceduraForm salvaProceduraFormPrincipale(long idFormPrincipale, long idProcedura) {
		ProceduraForm proceduraForm = null;
		long idFormPrincipaleEsistente = getFormPrincipaleProcedura(idProcedura);

		if (idFormPrincipaleEsistente != idFormPrincipale) {

			ProceduraFormPK proceduraFormPk = new ProceduraFormPK();
			proceduraFormPk.setProceduraId(idProcedura);
			proceduraFormPk.setFormId(idFormPrincipale);

			proceduraForm = proceduraFormPersistence.create(proceduraFormPk);
			proceduraFormPersistence.update(proceduraForm);
		}

		return proceduraForm;
	}

	@Override
	public String getFormIntegrativiProcedura(long idProcedura) throws PortalException {
		List<ProceduraForm> listaProceduraForm = new ArrayList<ProceduraForm>();
		List<String> listaFormIntegrativiProcedura = new ArrayList<String>();

		listaProceduraForm = proceduraFormPersistence.findByProceduraId(idProcedura);

		if (!listaProceduraForm.isEmpty()) {
			for (ProceduraForm proceduraForm : listaProceduraForm) {
				Form form = null;

				if (Validator.isNotNull(proceduraForm)) {
					form = formLocalService.getForm(proceduraForm.getFormId());

					if (Validator.isNotNull(form)) {
						if (!form.getPrincipale()) {
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

	@Override
	public long getFormPrincipaleProcedura(long idProcedura) {
		long idFormPrincipale = 0;
		List<ProceduraForm> listaProceduraForm = new ArrayList<ProceduraForm>();

		listaProceduraForm = proceduraFormPersistence.findByProceduraId(idProcedura);

		if (!listaProceduraForm.isEmpty()) {
			for (ProceduraForm proceduraForm : listaProceduraForm) {
				Form form = null;

				if (Validator.isNotNull(proceduraForm)) {
					try {
						form = formLocalService.getForm(proceduraForm.getFormId());
					}
					catch (PortalException e) {
						_log.error("Non è stato possibile recuperare il form con ID : " + proceduraForm.getFormId());
					}

					if (Validator.isNotNull(form)) {
						if (form.getPrincipale()) {
							idFormPrincipale = form.getFormId();
						}
					}
				}

			}
		}

		return idFormPrincipale;
	}

}