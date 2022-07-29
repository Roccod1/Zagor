package it.servizidigitali.gestioneforms.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchPaginationUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.service.persistence.FormFinder;

@Component(service = FormFinder.class)
public class FormFinderImpl extends FormFinderBaseImpl implements FormFinder{
	
	public List<Form> findFormByFilter(String codice, Date dataInserimentoDa, Date dataInserimentoA, int cur, int delta, OrderByComparator<Form> ordine){
		List<Form> listaForm = new ArrayList<>();
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Form.class, classLoader);
		
		if(Validator.isNotNull(codice)) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("nome", StringPool.PERCENT + codice + StringPool.PERCENT));
		}
		
		if(Validator.isNotNull(dataInserimentoDa)) {
			dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", dataInserimentoDa));
		}
		
		if(Validator.isNotNull(dataInserimentoA)) {
			dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", dataInserimentoA));
		}
		
		int posizioni[] = SearchPaginationUtil.calculateStartAndEnd(cur, delta);
		
		int inizio = posizioni[0];
		int fine = posizioni[1];
		
		listaForm = formPersistence.findWithDynamicQuery(dynamicQuery,inizio,fine,ordine);
		
		return listaForm;
	}

}
