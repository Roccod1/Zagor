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

package it.servizidigitali.profiloutente.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.servizidigitali.profiloutente.exception.NoSuchCanaleComunicazioneException;
import it.servizidigitali.profiloutente.model.CanaleComunicazione;
import it.servizidigitali.profiloutente.model.CanaleComunicazioneTable;
import it.servizidigitali.profiloutente.model.impl.CanaleComunicazioneImpl;
import it.servizidigitali.profiloutente.model.impl.CanaleComunicazioneModelImpl;
import it.servizidigitali.profiloutente.service.persistence.CanaleComunicazionePersistence;
import it.servizidigitali.profiloutente.service.persistence.CanaleComunicazioneUtil;
import it.servizidigitali.profiloutente.service.persistence.impl.constants.PersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the canale comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {CanaleComunicazionePersistence.class, BasePersistence.class}
)
public class CanaleComunicazionePersistenceImpl
	extends BasePersistenceImpl<CanaleComunicazione>
	implements CanaleComunicazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CanaleComunicazioneUtil</code> to access the canale comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CanaleComunicazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCodice;
	private FinderPath _finderPathCountByCodice;

	/**
	 * Returns the canale comunicazione where codice = &#63; or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione findByCodice(String codice)
		throws NoSuchCanaleComunicazioneException {

		CanaleComunicazione canaleComunicazione = fetchByCodice(codice);

		if (canaleComunicazione == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codice=");
			sb.append(codice);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCanaleComunicazioneException(sb.toString());
		}

		return canaleComunicazione;
	}

	/**
	 * Returns the canale comunicazione where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione fetchByCodice(String codice) {
		return fetchByCodice(codice, true);
	}

	/**
	 * Returns the canale comunicazione where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione fetchByCodice(
		String codice, boolean useFinderCache) {

		codice = Objects.toString(codice, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codice};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodice, finderArgs);
		}

		if (result instanceof CanaleComunicazione) {
			CanaleComunicazione canaleComunicazione =
				(CanaleComunicazione)result;

			if (!Objects.equals(codice, canaleComunicazione.getCodice())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CANALECOMUNICAZIONE_WHERE);

			boolean bindCodice = false;

			if (codice.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICE_CODICE_3);
			}
			else {
				bindCodice = true;

				sb.append(_FINDER_COLUMN_CODICE_CODICE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodice) {
					queryPos.add(codice);
				}

				List<CanaleComunicazione> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodice, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {codice};
							}

							_log.warn(
								"CanaleComunicazionePersistenceImpl.fetchByCodice(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CanaleComunicazione canaleComunicazione = list.get(0);

					result = canaleComunicazione;

					cacheResult(canaleComunicazione);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CanaleComunicazione)result;
		}
	}

	/**
	 * Removes the canale comunicazione where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the canale comunicazione that was removed
	 */
	@Override
	public CanaleComunicazione removeByCodice(String codice)
		throws NoSuchCanaleComunicazioneException {

		CanaleComunicazione canaleComunicazione = findByCodice(codice);

		return remove(canaleComunicazione);
	}

	/**
	 * Returns the number of canale comunicaziones where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching canale comunicaziones
	 */
	@Override
	public int countByCodice(String codice) {
		codice = Objects.toString(codice, "");

		FinderPath finderPath = _finderPathCountByCodice;

		Object[] finderArgs = new Object[] {codice};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANALECOMUNICAZIONE_WHERE);

			boolean bindCodice = false;

			if (codice.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICE_CODICE_3);
			}
			else {
				bindCodice = true;

				sb.append(_FINDER_COLUMN_CODICE_CODICE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodice) {
					queryPos.add(codice);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODICE_CODICE_2 =
		"canaleComunicazione.codice = ?";

	private static final String _FINDER_COLUMN_CODICE_CODICE_3 =
		"(canaleComunicazione.codice IS NULL OR canaleComunicazione.codice = '')";

	private FinderPath _finderPathWithPaginationFindByAttivo;
	private FinderPath _finderPathWithoutPaginationFindByAttivo;
	private FinderPath _finderPathCountByAttivo;

	/**
	 * Returns all the canale comunicaziones where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findByAttivo(boolean attivo) {
		return findByAttivo(attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of matching canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end) {

		return findByAttivo(attivo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return findByAttivo(attivo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAttivo;
				finderArgs = new Object[] {attivo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAttivo;
			finderArgs = new Object[] {attivo, start, end, orderByComparator};
		}

		List<CanaleComunicazione> list = null;

		if (useFinderCache) {
			list = (List<CanaleComunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CanaleComunicazione canaleComunicazione : list) {
					if (attivo != canaleComunicazione.isAttivo()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CANALECOMUNICAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CanaleComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

				list = (List<CanaleComunicazione>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione findByAttivo_First(
			boolean attivo,
			OrderByComparator<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException {

		CanaleComunicazione canaleComunicazione = fetchByAttivo_First(
			attivo, orderByComparator);

		if (canaleComunicazione != null) {
			return canaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchCanaleComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione fetchByAttivo_First(
		boolean attivo,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		List<CanaleComunicazione> list = findByAttivo(
			attivo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione findByAttivo_Last(
			boolean attivo,
			OrderByComparator<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException {

		CanaleComunicazione canaleComunicazione = fetchByAttivo_Last(
			attivo, orderByComparator);

		if (canaleComunicazione != null) {
			return canaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchCanaleComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching canale comunicazione, or <code>null</code> if a matching canale comunicazione could not be found
	 */
	@Override
	public CanaleComunicazione fetchByAttivo_Last(
		boolean attivo,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		int count = countByAttivo(attivo);

		if (count == 0) {
			return null;
		}

		List<CanaleComunicazione> list = findByAttivo(
			attivo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the canale comunicaziones before and after the current canale comunicazione in the ordered set where attivo = &#63;.
	 *
	 * @param canaleComunicazioneId the primary key of the current canale comunicazione
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public CanaleComunicazione[] findByAttivo_PrevAndNext(
			long canaleComunicazioneId, boolean attivo,
			OrderByComparator<CanaleComunicazione> orderByComparator)
		throws NoSuchCanaleComunicazioneException {

		CanaleComunicazione canaleComunicazione = findByPrimaryKey(
			canaleComunicazioneId);

		Session session = null;

		try {
			session = openSession();

			CanaleComunicazione[] array = new CanaleComunicazioneImpl[3];

			array[0] = getByAttivo_PrevAndNext(
				session, canaleComunicazione, attivo, orderByComparator, true);

			array[1] = canaleComunicazione;

			array[2] = getByAttivo_PrevAndNext(
				session, canaleComunicazione, attivo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CanaleComunicazione getByAttivo_PrevAndNext(
		Session session, CanaleComunicazione canaleComunicazione,
		boolean attivo,
		OrderByComparator<CanaleComunicazione> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CANALECOMUNICAZIONE_WHERE);

		sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CanaleComunicazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(attivo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						canaleComunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CanaleComunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the canale comunicaziones where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	@Override
	public void removeByAttivo(boolean attivo) {
		for (CanaleComunicazione canaleComunicazione :
				findByAttivo(
					attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(canaleComunicazione);
		}
	}

	/**
	 * Returns the number of canale comunicaziones where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching canale comunicaziones
	 */
	@Override
	public int countByAttivo(boolean attivo) {
		FinderPath finderPath = _finderPathCountByAttivo;

		Object[] finderArgs = new Object[] {attivo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANALECOMUNICAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ATTIVO_ATTIVO_2 =
		"canaleComunicazione.attivo = ?";

	public CanaleComunicazionePersistenceImpl() {
		setModelClass(CanaleComunicazione.class);

		setModelImplClass(CanaleComunicazioneImpl.class);
		setModelPKClass(long.class);

		setTable(CanaleComunicazioneTable.INSTANCE);
	}

	/**
	 * Caches the canale comunicazione in the entity cache if it is enabled.
	 *
	 * @param canaleComunicazione the canale comunicazione
	 */
	@Override
	public void cacheResult(CanaleComunicazione canaleComunicazione) {
		entityCache.putResult(
			CanaleComunicazioneImpl.class, canaleComunicazione.getPrimaryKey(),
			canaleComunicazione);

		finderCache.putResult(
			_finderPathFetchByCodice,
			new Object[] {canaleComunicazione.getCodice()},
			canaleComunicazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the canale comunicaziones in the entity cache if it is enabled.
	 *
	 * @param canaleComunicaziones the canale comunicaziones
	 */
	@Override
	public void cacheResult(List<CanaleComunicazione> canaleComunicaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (canaleComunicaziones.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CanaleComunicazione canaleComunicazione : canaleComunicaziones) {
			if (entityCache.getResult(
					CanaleComunicazioneImpl.class,
					canaleComunicazione.getPrimaryKey()) == null) {

				cacheResult(canaleComunicazione);
			}
		}
	}

	/**
	 * Clears the cache for all canale comunicaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CanaleComunicazioneImpl.class);

		finderCache.clearCache(CanaleComunicazioneImpl.class);
	}

	/**
	 * Clears the cache for the canale comunicazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CanaleComunicazione canaleComunicazione) {
		entityCache.removeResult(
			CanaleComunicazioneImpl.class, canaleComunicazione);
	}

	@Override
	public void clearCache(List<CanaleComunicazione> canaleComunicaziones) {
		for (CanaleComunicazione canaleComunicazione : canaleComunicaziones) {
			entityCache.removeResult(
				CanaleComunicazioneImpl.class, canaleComunicazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CanaleComunicazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CanaleComunicazioneImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CanaleComunicazioneModelImpl canaleComunicazioneModelImpl) {

		Object[] args = new Object[] {canaleComunicazioneModelImpl.getCodice()};

		finderCache.putResult(_finderPathCountByCodice, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodice, args, canaleComunicazioneModelImpl);
	}

	/**
	 * Creates a new canale comunicazione with the primary key. Does not add the canale comunicazione to the database.
	 *
	 * @param canaleComunicazioneId the primary key for the new canale comunicazione
	 * @return the new canale comunicazione
	 */
	@Override
	public CanaleComunicazione create(long canaleComunicazioneId) {
		CanaleComunicazione canaleComunicazione = new CanaleComunicazioneImpl();

		canaleComunicazione.setNew(true);
		canaleComunicazione.setPrimaryKey(canaleComunicazioneId);

		return canaleComunicazione;
	}

	/**
	 * Removes the canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione that was removed
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public CanaleComunicazione remove(long canaleComunicazioneId)
		throws NoSuchCanaleComunicazioneException {

		return remove((Serializable)canaleComunicazioneId);
	}

	/**
	 * Removes the canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the canale comunicazione
	 * @return the canale comunicazione that was removed
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public CanaleComunicazione remove(Serializable primaryKey)
		throws NoSuchCanaleComunicazioneException {

		Session session = null;

		try {
			session = openSession();

			CanaleComunicazione canaleComunicazione =
				(CanaleComunicazione)session.get(
					CanaleComunicazioneImpl.class, primaryKey);

			if (canaleComunicazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCanaleComunicazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(canaleComunicazione);
		}
		catch (NoSuchCanaleComunicazioneException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CanaleComunicazione removeImpl(
		CanaleComunicazione canaleComunicazione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(canaleComunicazione)) {
				canaleComunicazione = (CanaleComunicazione)session.get(
					CanaleComunicazioneImpl.class,
					canaleComunicazione.getPrimaryKeyObj());
			}

			if (canaleComunicazione != null) {
				session.delete(canaleComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (canaleComunicazione != null) {
			clearCache(canaleComunicazione);
		}

		return canaleComunicazione;
	}

	@Override
	public CanaleComunicazione updateImpl(
		CanaleComunicazione canaleComunicazione) {

		boolean isNew = canaleComunicazione.isNew();

		if (!(canaleComunicazione instanceof CanaleComunicazioneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(canaleComunicazione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					canaleComunicazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in canaleComunicazione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CanaleComunicazione implementation " +
					canaleComunicazione.getClass());
		}

		CanaleComunicazioneModelImpl canaleComunicazioneModelImpl =
			(CanaleComunicazioneModelImpl)canaleComunicazione;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(canaleComunicazione);
			}
			else {
				canaleComunicazione = (CanaleComunicazione)session.merge(
					canaleComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CanaleComunicazioneImpl.class, canaleComunicazioneModelImpl, false,
			true);

		cacheUniqueFindersCache(canaleComunicazioneModelImpl);

		if (isNew) {
			canaleComunicazione.setNew(false);
		}

		canaleComunicazione.resetOriginalValues();

		return canaleComunicazione;
	}

	/**
	 * Returns the canale comunicazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the canale comunicazione
	 * @return the canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public CanaleComunicazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCanaleComunicazioneException {

		CanaleComunicazione canaleComunicazione = fetchByPrimaryKey(primaryKey);

		if (canaleComunicazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCanaleComunicazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return canaleComunicazione;
	}

	/**
	 * Returns the canale comunicazione with the primary key or throws a <code>NoSuchCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione
	 * @throws NoSuchCanaleComunicazioneException if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public CanaleComunicazione findByPrimaryKey(long canaleComunicazioneId)
		throws NoSuchCanaleComunicazioneException {

		return findByPrimaryKey((Serializable)canaleComunicazioneId);
	}

	/**
	 * Returns the canale comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param canaleComunicazioneId the primary key of the canale comunicazione
	 * @return the canale comunicazione, or <code>null</code> if a canale comunicazione with the primary key could not be found
	 */
	@Override
	public CanaleComunicazione fetchByPrimaryKey(long canaleComunicazioneId) {
		return fetchByPrimaryKey((Serializable)canaleComunicazioneId);
	}

	/**
	 * Returns all the canale comunicaziones.
	 *
	 * @return the canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @return the range of canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of canale comunicaziones
	 * @param end the upper bound of the range of canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of canale comunicaziones
	 */
	@Override
	public List<CanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<CanaleComunicazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CanaleComunicazione> list = null;

		if (useFinderCache) {
			list = (List<CanaleComunicazione>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CANALECOMUNICAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CANALECOMUNICAZIONE;

				sql = sql.concat(CanaleComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CanaleComunicazione>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the canale comunicaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CanaleComunicazione canaleComunicazione : findAll()) {
			remove(canaleComunicazione);
		}
	}

	/**
	 * Returns the number of canale comunicaziones.
	 *
	 * @return the number of canale comunicaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CANALECOMUNICAZIONE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "canaleComunicazioneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CANALECOMUNICAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CanaleComunicazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the canale comunicazione persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByCodice = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodice",
			new String[] {String.class.getName()}, new String[] {"codice"},
			true);

		_finderPathCountByCodice = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodice",
			new String[] {String.class.getName()}, new String[] {"codice"},
			false);

		_finderPathWithPaginationFindByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttivo",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"attivo"}, true);

		_finderPathWithoutPaginationFindByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttivo",
			new String[] {Boolean.class.getName()}, new String[] {"attivo"},
			true);

		_finderPathCountByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttivo",
			new String[] {Boolean.class.getName()}, new String[] {"attivo"},
			false);

		_setCanaleComunicazioneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCanaleComunicazioneUtilPersistence(null);

		entityCache.removeCache(CanaleComunicazioneImpl.class.getName());
	}

	private void _setCanaleComunicazioneUtilPersistence(
		CanaleComunicazionePersistence canaleComunicazionePersistence) {

		try {
			Field field = CanaleComunicazioneUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, canaleComunicazionePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PersistenceConstants.SERVICE_CONFIGURATION_FILTER, unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CANALECOMUNICAZIONE =
		"SELECT canaleComunicazione FROM CanaleComunicazione canaleComunicazione";

	private static final String _SQL_SELECT_CANALECOMUNICAZIONE_WHERE =
		"SELECT canaleComunicazione FROM CanaleComunicazione canaleComunicazione WHERE ";

	private static final String _SQL_COUNT_CANALECOMUNICAZIONE =
		"SELECT COUNT(canaleComunicazione) FROM CanaleComunicazione canaleComunicazione";

	private static final String _SQL_COUNT_CANALECOMUNICAZIONE_WHERE =
		"SELECT COUNT(canaleComunicazione) FROM CanaleComunicazione canaleComunicazione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "canaleComunicazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CanaleComunicazione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CanaleComunicazione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CanaleComunicazionePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CanaleComunicazioneModelArgumentsResolver
		_canaleComunicazioneModelArgumentsResolver;

}