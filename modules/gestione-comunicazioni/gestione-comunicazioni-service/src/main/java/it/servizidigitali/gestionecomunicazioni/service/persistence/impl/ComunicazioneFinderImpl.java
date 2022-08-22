package it.servizidigitali.gestionecomunicazioni.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.gestionecomunicazioni.model.ComunicazioneFilters;
import it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneImpl;
import it.servizidigitali.gestionecomunicazioni.service.persistence.ComunicazioneFinder;

@Component(immediate = true, service = ComunicazioneFinder.class)
public class ComunicazioneFinderImpl extends ComunicazioneFinderBaseImpl implements ComunicazioneFinder {

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
		String sql;
		if (countQuery) {
			sql = "select count(*) ";
		} else {
			sql = "select c.comunicazioneId, c.dataInvio, c.titolo, c.tipologiaComunicazioneId, c.destinatarioOrganizationId ";
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
			sql += "and lower(c.userName) like ? ";
		}
		if (filters.getDataInvioDa() != null) {
			sql += "and c.dataInvio >= ? ";
		}
		if (filters.getDataInvioA() != null) {
			sql += "and c.dataInvio <= ? ";
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
			String pattern = StringPool.PERCENT + filters.getUsername().toLowerCase() + StringPool.PERCENT;
			queryPos.add(pattern);
		}
		if (filters.getDataInvioDa() != null) {
			queryPos.add(filters.getDataInvioDa());
		}
		if (filters.getDataInvioA() != null) {
			queryPos.add(filters.getDataInvioA());
		}
		if (!countQuery) {
			queryPos.add(start);
			queryPos.add(end - start);
		}
		return sqlQuery;
	}
	
	private Comunicazione mapComunicazione(Object[] x) {
		ComunicazioneImpl model = new ComunicazioneImpl();
		model.setComunicazioneId(Long.valueOf(x[0].toString()));
		Object dataInvio = x[1];
		model.setDataInvio(dataInvio != null ? (Date) dataInvio : null);
		model.setTitolo(x[2].toString());
		model.setTipologiaComunicazioneId(Long.valueOf(x[3].toString()));
		model.setDestinatarioOrganizationId(Long.valueOf(x[4].toString()));
		return model;
	}
}
