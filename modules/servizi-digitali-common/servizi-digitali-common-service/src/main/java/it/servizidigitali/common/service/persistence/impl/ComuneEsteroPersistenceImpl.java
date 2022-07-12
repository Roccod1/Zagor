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

package it.servizidigitali.common.service.persistence.impl;

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

import it.servizidigitali.common.exception.NoSuchComuneEsteroException;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.ComuneEsteroTable;
import it.servizidigitali.common.model.impl.ComuneEsteroImpl;
import it.servizidigitali.common.model.impl.ComuneEsteroModelImpl;
import it.servizidigitali.common.service.persistence.ComuneEsteroPersistence;
import it.servizidigitali.common.service.persistence.ComuneEsteroUtil;
import it.servizidigitali.common.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the comune estero service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ComuneEsteroPersistence.class, BasePersistence.class})
public class ComuneEsteroPersistenceImpl
	extends BasePersistenceImpl<ComuneEstero>
	implements ComuneEsteroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ComuneEsteroUtil</code> to access the comune estero persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ComuneEsteroImpl.class.getName();

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
	 * Returns the comune estero where codice = &#63; or throws a <code>NoSuchComuneEsteroException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero findByCodice(int codice)
		throws NoSuchComuneEsteroException {

		ComuneEstero comuneEstero = fetchByCodice(codice);

		if (comuneEstero == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codice=");
			sb.append(codice);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchComuneEsteroException(sb.toString());
		}

		return comuneEstero;
	}

	/**
	 * Returns the comune estero where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero fetchByCodice(int codice) {
		return fetchByCodice(codice, true);
	}

	/**
	 * Returns the comune estero where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero fetchByCodice(int codice, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codice};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodice, finderArgs);
		}

		if (result instanceof ComuneEstero) {
			ComuneEstero comuneEstero = (ComuneEstero)result;

			if (codice != comuneEstero.getCodice()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COMUNEESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CODICE_CODICE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codice);

				List<ComuneEstero> list = query.list();

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
								"ComuneEsteroPersistenceImpl.fetchByCodice(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ComuneEstero comuneEstero = list.get(0);

					result = comuneEstero;

					cacheResult(comuneEstero);
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
			return (ComuneEstero)result;
		}
	}

	/**
	 * Removes the comune estero where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the comune estero that was removed
	 */
	@Override
	public ComuneEstero removeByCodice(int codice)
		throws NoSuchComuneEsteroException {

		ComuneEstero comuneEstero = findByCodice(codice);

		return remove(comuneEstero);
	}

	/**
	 * Returns the number of comune esteros where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching comune esteros
	 */
	@Override
	public int countByCodice(int codice) {
		FinderPath finderPath = _finderPathCountByCodice;

		Object[] finderArgs = new Object[] {codice};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNEESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CODICE_CODICE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codice);

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
		"comuneEstero.codice = ?";

	private FinderPath _finderPathWithPaginationFindByDenominazioneLike;
	private FinderPath _finderPathWithPaginationCountByDenominazioneLike;

	/**
	 * Returns all the comune esteros where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune esteros
	 */
	@Override
	public List<ComuneEstero> findByDenominazioneLike(String denominazione) {
		return findByDenominazioneLike(
			denominazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of matching comune esteros
	 */
	@Override
	public List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end) {

		return findByDenominazioneLike(denominazione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comune esteros
	 */
	@Override
	public List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end,
		OrderByComparator<ComuneEstero> orderByComparator) {

		return findByDenominazioneLike(
			denominazione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comune esteros where denominazione LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param denominazione the denominazione
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comune esteros
	 */
	@Override
	public List<ComuneEstero> findByDenominazioneLike(
		String denominazione, int start, int end,
		OrderByComparator<ComuneEstero> orderByComparator,
		boolean useFinderCache) {

		denominazione = Objects.toString(denominazione, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByDenominazioneLike;
		finderArgs = new Object[] {
			denominazione, start, end, orderByComparator
		};

		List<ComuneEstero> list = null;

		if (useFinderCache) {
			list = (List<ComuneEstero>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ComuneEstero comuneEstero : list) {
					if (!StringUtil.wildcardMatches(
							comuneEstero.getDenominazione(), denominazione, '_',
							'%', '\\', true)) {

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

			sb.append(_SQL_SELECT_COMUNEESTERO_WHERE);

			boolean bindDenominazione = false;

			if (denominazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_3);
			}
			else {
				bindDenominazione = true;

				sb.append(_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComuneEsteroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDenominazione) {
					queryPos.add(denominazione);
				}

				list = (List<ComuneEstero>)QueryUtil.list(
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
	 * Returns the first comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero findByDenominazioneLike_First(
			String denominazione,
			OrderByComparator<ComuneEstero> orderByComparator)
		throws NoSuchComuneEsteroException {

		ComuneEstero comuneEstero = fetchByDenominazioneLike_First(
			denominazione, orderByComparator);

		if (comuneEstero != null) {
			return comuneEstero;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("denominazioneLIKE");
		sb.append(denominazione);

		sb.append("}");

		throw new NoSuchComuneEsteroException(sb.toString());
	}

	/**
	 * Returns the first comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero fetchByDenominazioneLike_First(
		String denominazione,
		OrderByComparator<ComuneEstero> orderByComparator) {

		List<ComuneEstero> list = findByDenominazioneLike(
			denominazione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune estero
	 * @throws NoSuchComuneEsteroException if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero findByDenominazioneLike_Last(
			String denominazione,
			OrderByComparator<ComuneEstero> orderByComparator)
		throws NoSuchComuneEsteroException {

		ComuneEstero comuneEstero = fetchByDenominazioneLike_Last(
			denominazione, orderByComparator);

		if (comuneEstero != null) {
			return comuneEstero;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("denominazioneLIKE");
		sb.append(denominazione);

		sb.append("}");

		throw new NoSuchComuneEsteroException(sb.toString());
	}

	/**
	 * Returns the last comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune estero, or <code>null</code> if a matching comune estero could not be found
	 */
	@Override
	public ComuneEstero fetchByDenominazioneLike_Last(
		String denominazione,
		OrderByComparator<ComuneEstero> orderByComparator) {

		int count = countByDenominazioneLike(denominazione);

		if (count == 0) {
			return null;
		}

		List<ComuneEstero> list = findByDenominazioneLike(
			denominazione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comune esteros before and after the current comune estero in the ordered set where denominazione LIKE &#63;.
	 *
	 * @param comuneEsteroId the primary key of the current comune estero
	 * @param denominazione the denominazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero[] findByDenominazioneLike_PrevAndNext(
			long comuneEsteroId, String denominazione,
			OrderByComparator<ComuneEstero> orderByComparator)
		throws NoSuchComuneEsteroException {

		denominazione = Objects.toString(denominazione, "");

		ComuneEstero comuneEstero = findByPrimaryKey(comuneEsteroId);

		Session session = null;

		try {
			session = openSession();

			ComuneEstero[] array = new ComuneEsteroImpl[3];

			array[0] = getByDenominazioneLike_PrevAndNext(
				session, comuneEstero, denominazione, orderByComparator, true);

			array[1] = comuneEstero;

			array[2] = getByDenominazioneLike_PrevAndNext(
				session, comuneEstero, denominazione, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ComuneEstero getByDenominazioneLike_PrevAndNext(
		Session session, ComuneEstero comuneEstero, String denominazione,
		OrderByComparator<ComuneEstero> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNEESTERO_WHERE);

		boolean bindDenominazione = false;

		if (denominazione.isEmpty()) {
			sb.append(_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_3);
		}
		else {
			bindDenominazione = true;

			sb.append(_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_2);
		}

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
			sb.append(ComuneEsteroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDenominazione) {
			queryPos.add(denominazione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comuneEstero)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComuneEstero> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comune esteros where denominazione LIKE &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 */
	@Override
	public void removeByDenominazioneLike(String denominazione) {
		for (ComuneEstero comuneEstero :
				findByDenominazioneLike(
					denominazione, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(comuneEstero);
		}
	}

	/**
	 * Returns the number of comune esteros where denominazione LIKE &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching comune esteros
	 */
	@Override
	public int countByDenominazioneLike(String denominazione) {
		denominazione = Objects.toString(denominazione, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByDenominazioneLike;

		Object[] finderArgs = new Object[] {denominazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNEESTERO_WHERE);

			boolean bindDenominazione = false;

			if (denominazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_3);
			}
			else {
				bindDenominazione = true;

				sb.append(_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDenominazione) {
					queryPos.add(denominazione);
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

	private static final String
		_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_2 =
			"comuneEstero.denominazione LIKE ?";

	private static final String
		_FINDER_COLUMN_DENOMINAZIONELIKE_DENOMINAZIONE_3 =
			"(comuneEstero.denominazione IS NULL OR comuneEstero.denominazione LIKE '')";

	public ComuneEsteroPersistenceImpl() {
		setModelClass(ComuneEstero.class);

		setModelImplClass(ComuneEsteroImpl.class);
		setModelPKClass(long.class);

		setTable(ComuneEsteroTable.INSTANCE);
	}

	/**
	 * Caches the comune estero in the entity cache if it is enabled.
	 *
	 * @param comuneEstero the comune estero
	 */
	@Override
	public void cacheResult(ComuneEstero comuneEstero) {
		entityCache.putResult(
			ComuneEsteroImpl.class, comuneEstero.getPrimaryKey(), comuneEstero);

		finderCache.putResult(
			_finderPathFetchByCodice, new Object[] {comuneEstero.getCodice()},
			comuneEstero);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the comune esteros in the entity cache if it is enabled.
	 *
	 * @param comuneEsteros the comune esteros
	 */
	@Override
	public void cacheResult(List<ComuneEstero> comuneEsteros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (comuneEsteros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ComuneEstero comuneEstero : comuneEsteros) {
			if (entityCache.getResult(
					ComuneEsteroImpl.class, comuneEstero.getPrimaryKey()) ==
						null) {

				cacheResult(comuneEstero);
			}
		}
	}

	/**
	 * Clears the cache for all comune esteros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ComuneEsteroImpl.class);

		finderCache.clearCache(ComuneEsteroImpl.class);
	}

	/**
	 * Clears the cache for the comune estero.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ComuneEstero comuneEstero) {
		entityCache.removeResult(ComuneEsteroImpl.class, comuneEstero);
	}

	@Override
	public void clearCache(List<ComuneEstero> comuneEsteros) {
		for (ComuneEstero comuneEstero : comuneEsteros) {
			entityCache.removeResult(ComuneEsteroImpl.class, comuneEstero);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ComuneEsteroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ComuneEsteroImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ComuneEsteroModelImpl comuneEsteroModelImpl) {

		Object[] args = new Object[] {comuneEsteroModelImpl.getCodice()};

		finderCache.putResult(_finderPathCountByCodice, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodice, args, comuneEsteroModelImpl);
	}

	/**
	 * Creates a new comune estero with the primary key. Does not add the comune estero to the database.
	 *
	 * @param comuneEsteroId the primary key for the new comune estero
	 * @return the new comune estero
	 */
	@Override
	public ComuneEstero create(long comuneEsteroId) {
		ComuneEstero comuneEstero = new ComuneEsteroImpl();

		comuneEstero.setNew(true);
		comuneEstero.setPrimaryKey(comuneEsteroId);

		return comuneEstero;
	}

	/**
	 * Removes the comune estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero that was removed
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero remove(long comuneEsteroId)
		throws NoSuchComuneEsteroException {

		return remove((Serializable)comuneEsteroId);
	}

	/**
	 * Removes the comune estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comune estero
	 * @return the comune estero that was removed
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero remove(Serializable primaryKey)
		throws NoSuchComuneEsteroException {

		Session session = null;

		try {
			session = openSession();

			ComuneEstero comuneEstero = (ComuneEstero)session.get(
				ComuneEsteroImpl.class, primaryKey);

			if (comuneEstero == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComuneEsteroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(comuneEstero);
		}
		catch (NoSuchComuneEsteroException noSuchEntityException) {
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
	protected ComuneEstero removeImpl(ComuneEstero comuneEstero) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comuneEstero)) {
				comuneEstero = (ComuneEstero)session.get(
					ComuneEsteroImpl.class, comuneEstero.getPrimaryKeyObj());
			}

			if (comuneEstero != null) {
				session.delete(comuneEstero);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (comuneEstero != null) {
			clearCache(comuneEstero);
		}

		return comuneEstero;
	}

	@Override
	public ComuneEstero updateImpl(ComuneEstero comuneEstero) {
		boolean isNew = comuneEstero.isNew();

		if (!(comuneEstero instanceof ComuneEsteroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(comuneEstero.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					comuneEstero);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in comuneEstero proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ComuneEstero implementation " +
					comuneEstero.getClass());
		}

		ComuneEsteroModelImpl comuneEsteroModelImpl =
			(ComuneEsteroModelImpl)comuneEstero;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(comuneEstero);
			}
			else {
				comuneEstero = (ComuneEstero)session.merge(comuneEstero);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ComuneEsteroImpl.class, comuneEsteroModelImpl, false, true);

		cacheUniqueFindersCache(comuneEsteroModelImpl);

		if (isNew) {
			comuneEstero.setNew(false);
		}

		comuneEstero.resetOriginalValues();

		return comuneEstero;
	}

	/**
	 * Returns the comune estero with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comune estero
	 * @return the comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComuneEsteroException {

		ComuneEstero comuneEstero = fetchByPrimaryKey(primaryKey);

		if (comuneEstero == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComuneEsteroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return comuneEstero;
	}

	/**
	 * Returns the comune estero with the primary key or throws a <code>NoSuchComuneEsteroException</code> if it could not be found.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero
	 * @throws NoSuchComuneEsteroException if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero findByPrimaryKey(long comuneEsteroId)
		throws NoSuchComuneEsteroException {

		return findByPrimaryKey((Serializable)comuneEsteroId);
	}

	/**
	 * Returns the comune estero with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comuneEsteroId the primary key of the comune estero
	 * @return the comune estero, or <code>null</code> if a comune estero with the primary key could not be found
	 */
	@Override
	public ComuneEstero fetchByPrimaryKey(long comuneEsteroId) {
		return fetchByPrimaryKey((Serializable)comuneEsteroId);
	}

	/**
	 * Returns all the comune esteros.
	 *
	 * @return the comune esteros
	 */
	@Override
	public List<ComuneEstero> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @return the range of comune esteros
	 */
	@Override
	public List<ComuneEstero> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comune esteros
	 */
	@Override
	public List<ComuneEstero> findAll(
		int start, int end, OrderByComparator<ComuneEstero> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comune esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comune esteros
	 * @param end the upper bound of the range of comune esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comune esteros
	 */
	@Override
	public List<ComuneEstero> findAll(
		int start, int end, OrderByComparator<ComuneEstero> orderByComparator,
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

		List<ComuneEstero> list = null;

		if (useFinderCache) {
			list = (List<ComuneEstero>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMUNEESTERO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMUNEESTERO;

				sql = sql.concat(ComuneEsteroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ComuneEstero>)QueryUtil.list(
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
	 * Removes all the comune esteros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ComuneEstero comuneEstero : findAll()) {
			remove(comuneEstero);
		}
	}

	/**
	 * Returns the number of comune esteros.
	 *
	 * @return the number of comune esteros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMUNEESTERO);

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
		return "comuneEsteroId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMUNEESTERO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ComuneEsteroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comune estero persistence.
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
			new String[] {Integer.class.getName()}, new String[] {"codice"},
			true);

		_finderPathCountByCodice = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodice",
			new String[] {Integer.class.getName()}, new String[] {"codice"},
			false);

		_finderPathWithPaginationFindByDenominazioneLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDenominazioneLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"denominazione"}, true);

		_finderPathWithPaginationCountByDenominazioneLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDenominazioneLike",
			new String[] {String.class.getName()},
			new String[] {"denominazione"}, false);

		_setComuneEsteroUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setComuneEsteroUtilPersistence(null);

		entityCache.removeCache(ComuneEsteroImpl.class.getName());
	}

	private void _setComuneEsteroUtilPersistence(
		ComuneEsteroPersistence comuneEsteroPersistence) {

		try {
			Field field = ComuneEsteroUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, comuneEsteroPersistence);
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

	private static final String _SQL_SELECT_COMUNEESTERO =
		"SELECT comuneEstero FROM ComuneEstero comuneEstero";

	private static final String _SQL_SELECT_COMUNEESTERO_WHERE =
		"SELECT comuneEstero FROM ComuneEstero comuneEstero WHERE ";

	private static final String _SQL_COUNT_COMUNEESTERO =
		"SELECT COUNT(comuneEstero) FROM ComuneEstero comuneEstero";

	private static final String _SQL_COUNT_COMUNEESTERO_WHERE =
		"SELECT COUNT(comuneEstero) FROM ComuneEstero comuneEstero WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "comuneEstero.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ComuneEstero exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ComuneEstero exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ComuneEsteroPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ComuneEsteroModelArgumentsResolver
		_comuneEsteroModelArgumentsResolver;

}