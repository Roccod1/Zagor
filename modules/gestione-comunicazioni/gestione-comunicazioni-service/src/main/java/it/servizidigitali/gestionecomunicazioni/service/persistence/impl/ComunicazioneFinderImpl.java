package it.servizidigitali.gestionecomunicazioni.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.gestionecomunicazioni.model.ComunicazioneFilters;
import it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneImpl;
import it.servizidigitali.gestionecomunicazioni.service.persistence.ComunicazioneFinder;

@Component(immediate = true, service = ComunicazioneFinder.class)
public class ComunicazioneFinderImpl extends ComunicazioneFinderBaseImpl implements ComunicazioneFinder {

	@Reference
	private UserLocalService userLocalService;
	
	@SuppressWarnings("unchecked")
	public List<Comunicazione> findByFilters(ComunicazioneFilters filters, int start, int end) {
		Session session = null;
		
		try {
			session = openSession();
			
			SQLQuery sqlQuery = generaQuery(session, filters, false, start, end);			
			
			List<Comunicazione> list = ((List<Object[]>)sqlQuery.list())
					.stream()
					.map(this::mapComunicazione)
					.collect(Collectors.toList());
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByFilters(ComunicazioneFilters filters) {
		Session session = null;
		
		try {
			session = openSession();
			
			SQLQuery sqlQuery = generaQuery(session, filters, true, 0, 0);			
			
			int count = Integer.valueOf(sqlQuery.list().get(0).toString());
			return count;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeSession(session);
		}
	}

	private SQLQuery generaQuery(Session session, ComunicazioneFilters filters, boolean countQuery, int start, int end) {
		long[] ids;
		if (filters.getUsername() != null) {
			ids = searchUsers(filters.getUsername().toLowerCase());		
		} else {
			ids = null;
		}
		
		
		String sql;
		if (countQuery) {
			sql = "select count(*) ";
		} else {
			sql = "select c.comunicazioneId, c.dataInvio, c.titolo, c.tipologiaComunicazioneId, c.destinatarioOrganizationId, c.descrizione, c.codiceServizio ";
		}
		
		sql += "from comunicazione c left join lettura_comunicazione lc on c.comunicazioneId = lc.comunicazioneId where 1 = 1 ";
		if (filters.getStato() != null) {
			if (filters.getStato()) {
				sql += "and lc.dataLettura is not NULL and lc.userId = ? ";
			} else {
				sql += "and lc.dataLettura is NULL and (lc.userId = ? or lc.userId is NULL) ";
			}
		}
		if (filters.getOrganizzazione() != null) {
			sql += "and c.destinatarioOrganizationId = ? ";
		}
		if (filters.getTipologia() != null) {
			sql += "and c.tipologiaComunicazioneId = ? ";
		}
		if (filters.getUsername() != null) {
			sql += "and c.destinatarioUserId in " + generateGroup(ids.length) + " ";
		}
		if (filters.getDataInvioDa() != null) {
			sql += "and c.dataInvio >= ? ";
		}
		if (filters.getDataInvioA() != null) {
			sql += "and c.dataInvio <= ? ";
		}
		if(Validator.isNotNull(filters.getTitoloDescrizione())) {
			sql += "and (c.titolo like concat('%', ?, '%') or c.descrizione like concat('%', ?, '%')) ";
		}
		if(Validator.isNotNull(filters.getOrderByCol())) {
			sql += "order by ? ? ";
		}
		if (!countQuery) {
			sql += "limit ?, ?";
		}
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		
		QueryPos queryPos = QueryPos.getInstance(sqlQuery);
		
		if (filters.getStato() != null) {
			queryPos.add(filters.getUserId());
		}
		if (filters.getOrganizzazione() != null) {
			queryPos.add(filters.getOrganizzazione());
		}
		if (filters.getTipologia() != null) {
			queryPos.add(filters.getTipologia());
		}
		if (filters.getUsername() != null) {	
			queryPos.add(ids);
		}
		if (filters.getDataInvioDa() != null) {
			queryPos.add(filters.getDataInvioDa());
		}
		if (filters.getDataInvioA() != null) {
			queryPos.add(filters.getDataInvioA());
		}
		if(Validator.isNotNull(filters.getTitoloDescrizione())) {
			queryPos.add(filters.getTitoloDescrizione());
			queryPos.add(filters.getTitoloDescrizione());
		}
		if(Validator.isNotNull(filters.getOrderByCol())) {
			queryPos.add(filters.getOrderByCol());
			queryPos.add(Validator.isNotNull(filters.getOrderByType()) ? filters.getOrderByType() : "asc");
		}
		if (!countQuery) {
			queryPos.add(start);
			queryPos.add(end - start);
		}
		
		return sqlQuery;
	}
	
	private String generateGroup(int length) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("(");
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				buffer.append("?");
			} else {
				buffer.append(", ?");
			}
		}
		buffer.append(")");
		return buffer.toString();
	}

	private long[] searchUsers(String query) {
		String pattern = StringPool.PERCENT + query + StringPool.PERCENT;
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(User.class, getClass().getClassLoader());
		Criterion cfClause = RestrictionsFactoryUtil.ilike("screenName", pattern);
		Criterion fnClause = RestrictionsFactoryUtil.ilike("firstName", pattern);
		Criterion lnClause = RestrictionsFactoryUtil.ilike("lastName", pattern);
		Criterion nameClause = RestrictionsFactoryUtil.or(fnClause, lnClause);
		
		dq.add(RestrictionsFactoryUtil.or(nameClause, cfClause));
		dq.setProjection(ProjectionFactoryUtil.property("userId"));
		
		List<Long> ids = new ArrayList<>();
		ids.addAll(userLocalService.<Long>dynamicQuery(dq));
		ids.add(0L);
		
		return ids.stream().mapToLong(x -> x).toArray();
	}

	private Comunicazione mapComunicazione(Object[] x) {
		ComunicazioneImpl model = new ComunicazioneImpl();
		model.setComunicazioneId(Long.valueOf(x[0].toString()));
		Object dataInvio = x[1];
		model.setDataInvio(dataInvio != null ? (Date) dataInvio : null);
		model.setTitolo(x[2].toString());
		model.setTipologiaComunicazioneId(Long.valueOf(x[3].toString()));
		model.setDestinatarioOrganizationId(Long.valueOf(x[4].toString()));
		model.setDescrizione(Validator.isNotNull(x[5]) ? x[5].toString() : null);
		model.setCodiceServizio(Validator.isNotNull(x[6]) ? x[6].toString() : null);
		return model;
	}
}
