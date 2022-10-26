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

import it.servizidigitali.common.exception.NoSuchProvinciaException;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.ProvinciaTable;
import it.servizidigitali.common.model.impl.ProvinciaImpl;
import it.servizidigitali.common.model.impl.ProvinciaModelImpl;
import it.servizidigitali.common.service.persistence.ProvinciaPersistence;
import it.servizidigitali.common.service.persistence.ProvinciaUtil;
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
 * The persistence implementation for the provincia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProvinciaPersistence.class, BasePersistence.class})
public class ProvinciaPersistenceImpl
	extends BasePersistenceImpl<Provincia> implements ProvinciaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProvinciaUtil</code> to access the provincia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProvinciaImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCodiceNUTS1;
	private FinderPath _finderPathCountByCodiceNUTS1;

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	@Override
	public Provincia findByCodiceNUTS1(String codiceNUTS1)
		throws NoSuchProvinciaException {

		Provincia provincia = fetchByCodiceNUTS1(codiceNUTS1);

		if (provincia == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codiceNUTS1=");
			sb.append(codiceNUTS1);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProvinciaException(sb.toString());
		}

		return provincia;
	}

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchByCodiceNUTS1(String codiceNUTS1) {
		return fetchByCodiceNUTS1(codiceNUTS1, true);
	}

	/**
	 * Returns the provincia where codiceNUTS1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchByCodiceNUTS1(
		String codiceNUTS1, boolean useFinderCache) {

		codiceNUTS1 = Objects.toString(codiceNUTS1, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codiceNUTS1};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodiceNUTS1, finderArgs);
		}

		if (result instanceof Provincia) {
			Provincia provincia = (Provincia)result;

			if (!Objects.equals(codiceNUTS1, provincia.getCodiceNUTS1())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROVINCIA_WHERE);

			boolean bindCodiceNUTS1 = false;

			if (codiceNUTS1.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICENUTS1_CODICENUTS1_3);
			}
			else {
				bindCodiceNUTS1 = true;

				sb.append(_FINDER_COLUMN_CODICENUTS1_CODICENUTS1_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceNUTS1) {
					queryPos.add(codiceNUTS1);
				}

				List<Provincia> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodiceNUTS1, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {codiceNUTS1};
							}

							_log.warn(
								"ProvinciaPersistenceImpl.fetchByCodiceNUTS1(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Provincia provincia = list.get(0);

					result = provincia;

					cacheResult(provincia);
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
			return (Provincia)result;
		}
	}

	/**
	 * Removes the provincia where codiceNUTS1 = &#63; from the database.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the provincia that was removed
	 */
	@Override
	public Provincia removeByCodiceNUTS1(String codiceNUTS1)
		throws NoSuchProvinciaException {

		Provincia provincia = findByCodiceNUTS1(codiceNUTS1);

		return remove(provincia);
	}

	/**
	 * Returns the number of provincias where codiceNUTS1 = &#63;.
	 *
	 * @param codiceNUTS1 the codice nuts1
	 * @return the number of matching provincias
	 */
	@Override
	public int countByCodiceNUTS1(String codiceNUTS1) {
		codiceNUTS1 = Objects.toString(codiceNUTS1, "");

		FinderPath finderPath = _finderPathCountByCodiceNUTS1;

		Object[] finderArgs = new Object[] {codiceNUTS1};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROVINCIA_WHERE);

			boolean bindCodiceNUTS1 = false;

			if (codiceNUTS1.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICENUTS1_CODICENUTS1_3);
			}
			else {
				bindCodiceNUTS1 = true;

				sb.append(_FINDER_COLUMN_CODICENUTS1_CODICENUTS1_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceNUTS1) {
					queryPos.add(codiceNUTS1);
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

	private static final String _FINDER_COLUMN_CODICENUTS1_CODICENUTS1_2 =
		"provincia.codiceNUTS1 = ?";

	private static final String _FINDER_COLUMN_CODICENUTS1_CODICENUTS1_3 =
		"(provincia.codiceNUTS1 IS NULL OR provincia.codiceNUTS1 = '')";

	private FinderPath _finderPathWithPaginationFindByCodiceRegione;
	private FinderPath _finderPathWithoutPaginationFindByCodiceRegione;
	private FinderPath _finderPathCountByCodiceRegione;

	/**
	 * Returns all the provincias where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @return the matching provincias
	 */
	@Override
	public List<Provincia> findByCodiceRegione(long codiceRegione) {
		return findByCodiceRegione(
			codiceRegione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of matching provincias
	 */
	@Override
	public List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end) {

		return findByCodiceRegione(codiceRegione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provincias
	 */
	@Override
	public List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator) {

		return findByCodiceRegione(
			codiceRegione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the provincias where codiceRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceRegione the codice regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching provincias
	 */
	@Override
	public List<Provincia> findByCodiceRegione(
		long codiceRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCodiceRegione;
				finderArgs = new Object[] {codiceRegione};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodiceRegione;
			finderArgs = new Object[] {
				codiceRegione, start, end, orderByComparator
			};
		}

		List<Provincia> list = null;

		if (useFinderCache) {
			list = (List<Provincia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Provincia provincia : list) {
					if (codiceRegione != provincia.getCodiceRegione()) {
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

			sb.append(_SQL_SELECT_PROVINCIA_WHERE);

			sb.append(_FINDER_COLUMN_CODICEREGIONE_CODICEREGIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProvinciaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceRegione);

				list = (List<Provincia>)QueryUtil.list(
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
	 * Returns the first provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	@Override
	public Provincia findByCodiceRegione_First(
			long codiceRegione, OrderByComparator<Provincia> orderByComparator)
		throws NoSuchProvinciaException {

		Provincia provincia = fetchByCodiceRegione_First(
			codiceRegione, orderByComparator);

		if (provincia != null) {
			return provincia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceRegione=");
		sb.append(codiceRegione);

		sb.append("}");

		throw new NoSuchProvinciaException(sb.toString());
	}

	/**
	 * Returns the first provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchByCodiceRegione_First(
		long codiceRegione, OrderByComparator<Provincia> orderByComparator) {

		List<Provincia> list = findByCodiceRegione(
			codiceRegione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	@Override
	public Provincia findByCodiceRegione_Last(
			long codiceRegione, OrderByComparator<Provincia> orderByComparator)
		throws NoSuchProvinciaException {

		Provincia provincia = fetchByCodiceRegione_Last(
			codiceRegione, orderByComparator);

		if (provincia != null) {
			return provincia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceRegione=");
		sb.append(codiceRegione);

		sb.append("}");

		throw new NoSuchProvinciaException(sb.toString());
	}

	/**
	 * Returns the last provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchByCodiceRegione_Last(
		long codiceRegione, OrderByComparator<Provincia> orderByComparator) {

		int count = countByCodiceRegione(codiceRegione);

		if (count == 0) {
			return null;
		}

		List<Provincia> list = findByCodiceRegione(
			codiceRegione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provincias before and after the current provincia in the ordered set where codiceRegione = &#63;.
	 *
	 * @param provinciaId the primary key of the current provincia
	 * @param codiceRegione the codice regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia[] findByCodiceRegione_PrevAndNext(
			long provinciaId, long codiceRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws NoSuchProvinciaException {

		Provincia provincia = findByPrimaryKey(provinciaId);

		Session session = null;

		try {
			session = openSession();

			Provincia[] array = new ProvinciaImpl[3];

			array[0] = getByCodiceRegione_PrevAndNext(
				session, provincia, codiceRegione, orderByComparator, true);

			array[1] = provincia;

			array[2] = getByCodiceRegione_PrevAndNext(
				session, provincia, codiceRegione, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Provincia getByCodiceRegione_PrevAndNext(
		Session session, Provincia provincia, long codiceRegione,
		OrderByComparator<Provincia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROVINCIA_WHERE);

		sb.append(_FINDER_COLUMN_CODICEREGIONE_CODICEREGIONE_2);

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
			sb.append(ProvinciaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(codiceRegione);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(provincia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Provincia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the provincias where codiceRegione = &#63; from the database.
	 *
	 * @param codiceRegione the codice regione
	 */
	@Override
	public void removeByCodiceRegione(long codiceRegione) {
		for (Provincia provincia :
				findByCodiceRegione(
					codiceRegione, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(provincia);
		}
	}

	/**
	 * Returns the number of provincias where codiceRegione = &#63;.
	 *
	 * @param codiceRegione the codice regione
	 * @return the number of matching provincias
	 */
	@Override
	public int countByCodiceRegione(long codiceRegione) {
		FinderPath finderPath = _finderPathCountByCodiceRegione;

		Object[] finderArgs = new Object[] {codiceRegione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROVINCIA_WHERE);

			sb.append(_FINDER_COLUMN_CODICEREGIONE_CODICEREGIONE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceRegione);

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

	private static final String _FINDER_COLUMN_CODICEREGIONE_CODICEREGIONE_2 =
		"provincia.codiceRegione = ?";

	private FinderPath _finderPathWithPaginationFindByDenominazioneRegione;
	private FinderPath _finderPathWithoutPaginationFindByDenominazioneRegione;
	private FinderPath _finderPathCountByDenominazioneRegione;

	/**
	 * Returns all the provincias where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @return the matching provincias
	 */
	@Override
	public List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione) {

		return findByDenominazioneRegione(
			denominazioneRegione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of matching provincias
	 */
	@Override
	public List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end) {

		return findByDenominazioneRegione(
			denominazioneRegione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provincias
	 */
	@Override
	public List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator) {

		return findByDenominazioneRegione(
			denominazioneRegione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the provincias where denominazioneRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching provincias
	 */
	@Override
	public List<Provincia> findByDenominazioneRegione(
		String denominazioneRegione, int start, int end,
		OrderByComparator<Provincia> orderByComparator,
		boolean useFinderCache) {

		denominazioneRegione = Objects.toString(denominazioneRegione, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDenominazioneRegione;
				finderArgs = new Object[] {denominazioneRegione};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDenominazioneRegione;
			finderArgs = new Object[] {
				denominazioneRegione, start, end, orderByComparator
			};
		}

		List<Provincia> list = null;

		if (useFinderCache) {
			list = (List<Provincia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Provincia provincia : list) {
					if (!denominazioneRegione.equals(
							provincia.getDenominazioneRegione())) {

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

			sb.append(_SQL_SELECT_PROVINCIA_WHERE);

			boolean bindDenominazioneRegione = false;

			if (denominazioneRegione.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_3);
			}
			else {
				bindDenominazioneRegione = true;

				sb.append(
					_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProvinciaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDenominazioneRegione) {
					queryPos.add(denominazioneRegione);
				}

				list = (List<Provincia>)QueryUtil.list(
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
	 * Returns the first provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	@Override
	public Provincia findByDenominazioneRegione_First(
			String denominazioneRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws NoSuchProvinciaException {

		Provincia provincia = fetchByDenominazioneRegione_First(
			denominazioneRegione, orderByComparator);

		if (provincia != null) {
			return provincia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("denominazioneRegione=");
		sb.append(denominazioneRegione);

		sb.append("}");

		throw new NoSuchProvinciaException(sb.toString());
	}

	/**
	 * Returns the first provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchByDenominazioneRegione_First(
		String denominazioneRegione,
		OrderByComparator<Provincia> orderByComparator) {

		List<Provincia> list = findByDenominazioneRegione(
			denominazioneRegione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	@Override
	public Provincia findByDenominazioneRegione_Last(
			String denominazioneRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws NoSuchProvinciaException {

		Provincia provincia = fetchByDenominazioneRegione_Last(
			denominazioneRegione, orderByComparator);

		if (provincia != null) {
			return provincia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("denominazioneRegione=");
		sb.append(denominazioneRegione);

		sb.append("}");

		throw new NoSuchProvinciaException(sb.toString());
	}

	/**
	 * Returns the last provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchByDenominazioneRegione_Last(
		String denominazioneRegione,
		OrderByComparator<Provincia> orderByComparator) {

		int count = countByDenominazioneRegione(denominazioneRegione);

		if (count == 0) {
			return null;
		}

		List<Provincia> list = findByDenominazioneRegione(
			denominazioneRegione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provincias before and after the current provincia in the ordered set where denominazioneRegione = &#63;.
	 *
	 * @param provinciaId the primary key of the current provincia
	 * @param denominazioneRegione the denominazione regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia[] findByDenominazioneRegione_PrevAndNext(
			long provinciaId, String denominazioneRegione,
			OrderByComparator<Provincia> orderByComparator)
		throws NoSuchProvinciaException {

		denominazioneRegione = Objects.toString(denominazioneRegione, "");

		Provincia provincia = findByPrimaryKey(provinciaId);

		Session session = null;

		try {
			session = openSession();

			Provincia[] array = new ProvinciaImpl[3];

			array[0] = getByDenominazioneRegione_PrevAndNext(
				session, provincia, denominazioneRegione, orderByComparator,
				true);

			array[1] = provincia;

			array[2] = getByDenominazioneRegione_PrevAndNext(
				session, provincia, denominazioneRegione, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Provincia getByDenominazioneRegione_PrevAndNext(
		Session session, Provincia provincia, String denominazioneRegione,
		OrderByComparator<Provincia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROVINCIA_WHERE);

		boolean bindDenominazioneRegione = false;

		if (denominazioneRegione.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_3);
		}
		else {
			bindDenominazioneRegione = true;

			sb.append(
				_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_2);
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
			sb.append(ProvinciaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDenominazioneRegione) {
			queryPos.add(denominazioneRegione);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(provincia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Provincia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the provincias where denominazioneRegione = &#63; from the database.
	 *
	 * @param denominazioneRegione the denominazione regione
	 */
	@Override
	public void removeByDenominazioneRegione(String denominazioneRegione) {
		for (Provincia provincia :
				findByDenominazioneRegione(
					denominazioneRegione, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(provincia);
		}
	}

	/**
	 * Returns the number of provincias where denominazioneRegione = &#63;.
	 *
	 * @param denominazioneRegione the denominazione regione
	 * @return the number of matching provincias
	 */
	@Override
	public int countByDenominazioneRegione(String denominazioneRegione) {
		denominazioneRegione = Objects.toString(denominazioneRegione, "");

		FinderPath finderPath = _finderPathCountByDenominazioneRegione;

		Object[] finderArgs = new Object[] {denominazioneRegione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROVINCIA_WHERE);

			boolean bindDenominazioneRegione = false;

			if (denominazioneRegione.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_3);
			}
			else {
				bindDenominazioneRegione = true;

				sb.append(
					_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDenominazioneRegione) {
					queryPos.add(denominazioneRegione);
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
		_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_2 =
			"provincia.denominazioneRegione = ?";

	private static final String
		_FINDER_COLUMN_DENOMINAZIONEREGIONE_DENOMINAZIONEREGIONE_3 =
			"(provincia.denominazioneRegione IS NULL OR provincia.denominazioneRegione = '')";

	private FinderPath _finderPathFetchBySigla;
	private FinderPath _finderPathCountBySigla;

	/**
	 * Returns the provincia where sigla = &#63; or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param sigla the sigla
	 * @return the matching provincia
	 * @throws NoSuchProvinciaException if a matching provincia could not be found
	 */
	@Override
	public Provincia findBySigla(String sigla) throws NoSuchProvinciaException {
		Provincia provincia = fetchBySigla(sigla);

		if (provincia == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sigla=");
			sb.append(sigla);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProvinciaException(sb.toString());
		}

		return provincia;
	}

	/**
	 * Returns the provincia where sigla = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sigla the sigla
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchBySigla(String sigla) {
		return fetchBySigla(sigla, true);
	}

	/**
	 * Returns the provincia where sigla = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sigla the sigla
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching provincia, or <code>null</code> if a matching provincia could not be found
	 */
	@Override
	public Provincia fetchBySigla(String sigla, boolean useFinderCache) {
		sigla = Objects.toString(sigla, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sigla};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchBySigla, finderArgs);
		}

		if (result instanceof Provincia) {
			Provincia provincia = (Provincia)result;

			if (!Objects.equals(sigla, provincia.getSigla())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROVINCIA_WHERE);

			boolean bindSigla = false;

			if (sigla.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
			}
			else {
				bindSigla = true;

				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSigla) {
					queryPos.add(sigla);
				}

				List<Provincia> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySigla, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {sigla};
							}

							_log.warn(
								"ProvinciaPersistenceImpl.fetchBySigla(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Provincia provincia = list.get(0);

					result = provincia;

					cacheResult(provincia);
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
			return (Provincia)result;
		}
	}

	/**
	 * Removes the provincia where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 * @return the provincia that was removed
	 */
	@Override
	public Provincia removeBySigla(String sigla)
		throws NoSuchProvinciaException {

		Provincia provincia = findBySigla(sigla);

		return remove(provincia);
	}

	/**
	 * Returns the number of provincias where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching provincias
	 */
	@Override
	public int countBySigla(String sigla) {
		sigla = Objects.toString(sigla, "");

		FinderPath finderPath = _finderPathCountBySigla;

		Object[] finderArgs = new Object[] {sigla};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROVINCIA_WHERE);

			boolean bindSigla = false;

			if (sigla.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_3);
			}
			else {
				bindSigla = true;

				sb.append(_FINDER_COLUMN_SIGLA_SIGLA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSigla) {
					queryPos.add(sigla);
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

	private static final String _FINDER_COLUMN_SIGLA_SIGLA_2 =
		"provincia.sigla = ?";

	private static final String _FINDER_COLUMN_SIGLA_SIGLA_3 =
		"(provincia.sigla IS NULL OR provincia.sigla = '')";

	public ProvinciaPersistenceImpl() {
		setModelClass(Provincia.class);

		setModelImplClass(ProvinciaImpl.class);
		setModelPKClass(long.class);

		setTable(ProvinciaTable.INSTANCE);
	}

	/**
	 * Caches the provincia in the entity cache if it is enabled.
	 *
	 * @param provincia the provincia
	 */
	@Override
	public void cacheResult(Provincia provincia) {
		entityCache.putResult(
			ProvinciaImpl.class, provincia.getPrimaryKey(), provincia);

		finderCache.putResult(
			_finderPathFetchByCodiceNUTS1,
			new Object[] {provincia.getCodiceNUTS1()}, provincia);

		finderCache.putResult(
			_finderPathFetchBySigla, new Object[] {provincia.getSigla()},
			provincia);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the provincias in the entity cache if it is enabled.
	 *
	 * @param provincias the provincias
	 */
	@Override
	public void cacheResult(List<Provincia> provincias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (provincias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Provincia provincia : provincias) {
			if (entityCache.getResult(
					ProvinciaImpl.class, provincia.getPrimaryKey()) == null) {

				cacheResult(provincia);
			}
		}
	}

	/**
	 * Clears the cache for all provincias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProvinciaImpl.class);

		finderCache.clearCache(ProvinciaImpl.class);
	}

	/**
	 * Clears the cache for the provincia.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Provincia provincia) {
		entityCache.removeResult(ProvinciaImpl.class, provincia);
	}

	@Override
	public void clearCache(List<Provincia> provincias) {
		for (Provincia provincia : provincias) {
			entityCache.removeResult(ProvinciaImpl.class, provincia);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProvinciaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProvinciaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProvinciaModelImpl provinciaModelImpl) {

		Object[] args = new Object[] {provinciaModelImpl.getCodiceNUTS1()};

		finderCache.putResult(
			_finderPathCountByCodiceNUTS1, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodiceNUTS1, args, provinciaModelImpl);

		args = new Object[] {provinciaModelImpl.getSigla()};

		finderCache.putResult(_finderPathCountBySigla, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySigla, args, provinciaModelImpl);
	}

	/**
	 * Creates a new provincia with the primary key. Does not add the provincia to the database.
	 *
	 * @param provinciaId the primary key for the new provincia
	 * @return the new provincia
	 */
	@Override
	public Provincia create(long provinciaId) {
		Provincia provincia = new ProvinciaImpl();

		provincia.setNew(true);
		provincia.setPrimaryKey(provinciaId);

		return provincia;
	}

	/**
	 * Removes the provincia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia that was removed
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia remove(long provinciaId) throws NoSuchProvinciaException {
		return remove((Serializable)provinciaId);
	}

	/**
	 * Removes the provincia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the provincia
	 * @return the provincia that was removed
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia remove(Serializable primaryKey)
		throws NoSuchProvinciaException {

		Session session = null;

		try {
			session = openSession();

			Provincia provincia = (Provincia)session.get(
				ProvinciaImpl.class, primaryKey);

			if (provincia == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvinciaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(provincia);
		}
		catch (NoSuchProvinciaException noSuchEntityException) {
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
	protected Provincia removeImpl(Provincia provincia) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(provincia)) {
				provincia = (Provincia)session.get(
					ProvinciaImpl.class, provincia.getPrimaryKeyObj());
			}

			if (provincia != null) {
				session.delete(provincia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (provincia != null) {
			clearCache(provincia);
		}

		return provincia;
	}

	@Override
	public Provincia updateImpl(Provincia provincia) {
		boolean isNew = provincia.isNew();

		if (!(provincia instanceof ProvinciaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(provincia.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(provincia);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in provincia proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Provincia implementation " +
					provincia.getClass());
		}

		ProvinciaModelImpl provinciaModelImpl = (ProvinciaModelImpl)provincia;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(provincia);
			}
			else {
				provincia = (Provincia)session.merge(provincia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProvinciaImpl.class, provinciaModelImpl, false, true);

		cacheUniqueFindersCache(provinciaModelImpl);

		if (isNew) {
			provincia.setNew(false);
		}

		provincia.resetOriginalValues();

		return provincia;
	}

	/**
	 * Returns the provincia with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the provincia
	 * @return the provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProvinciaException {

		Provincia provincia = fetchByPrimaryKey(primaryKey);

		if (provincia == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProvinciaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return provincia;
	}

	/**
	 * Returns the provincia with the primary key or throws a <code>NoSuchProvinciaException</code> if it could not be found.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia
	 * @throws NoSuchProvinciaException if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia findByPrimaryKey(long provinciaId)
		throws NoSuchProvinciaException {

		return findByPrimaryKey((Serializable)provinciaId);
	}

	/**
	 * Returns the provincia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param provinciaId the primary key of the provincia
	 * @return the provincia, or <code>null</code> if a provincia with the primary key could not be found
	 */
	@Override
	public Provincia fetchByPrimaryKey(long provinciaId) {
		return fetchByPrimaryKey((Serializable)provinciaId);
	}

	/**
	 * Returns all the provincias.
	 *
	 * @return the provincias
	 */
	@Override
	public List<Provincia> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @return the range of provincias
	 */
	@Override
	public List<Provincia> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provincias
	 */
	@Override
	public List<Provincia> findAll(
		int start, int end, OrderByComparator<Provincia> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the provincias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProvinciaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of provincias
	 * @param end the upper bound of the range of provincias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of provincias
	 */
	@Override
	public List<Provincia> findAll(
		int start, int end, OrderByComparator<Provincia> orderByComparator,
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

		List<Provincia> list = null;

		if (useFinderCache) {
			list = (List<Provincia>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROVINCIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROVINCIA;

				sql = sql.concat(ProvinciaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Provincia>)QueryUtil.list(
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
	 * Removes all the provincias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Provincia provincia : findAll()) {
			remove(provincia);
		}
	}

	/**
	 * Returns the number of provincias.
	 *
	 * @return the number of provincias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROVINCIA);

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
		return "provinciaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROVINCIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProvinciaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the provincia persistence.
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

		_finderPathFetchByCodiceNUTS1 = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodiceNUTS1",
			new String[] {String.class.getName()}, new String[] {"codiceNUTS1"},
			true);

		_finderPathCountByCodiceNUTS1 = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceNUTS1",
			new String[] {String.class.getName()}, new String[] {"codiceNUTS1"},
			false);

		_finderPathWithPaginationFindByCodiceRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodiceRegione",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"codiceRegione"}, true);

		_finderPathWithoutPaginationFindByCodiceRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodiceRegione",
			new String[] {Long.class.getName()}, new String[] {"codiceRegione"},
			true);

		_finderPathCountByCodiceRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceRegione",
			new String[] {Long.class.getName()}, new String[] {"codiceRegione"},
			false);

		_finderPathWithPaginationFindByDenominazioneRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDenominazioneRegione",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"denominazioneRegione"}, true);

		_finderPathWithoutPaginationFindByDenominazioneRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDenominazioneRegione", new String[] {String.class.getName()},
			new String[] {"denominazioneRegione"}, true);

		_finderPathCountByDenominazioneRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDenominazioneRegione",
			new String[] {String.class.getName()},
			new String[] {"denominazioneRegione"}, false);

		_finderPathFetchBySigla = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySigla",
			new String[] {String.class.getName()}, new String[] {"sigla"},
			true);

		_finderPathCountBySigla = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigla",
			new String[] {String.class.getName()}, new String[] {"sigla"},
			false);

		_setProvinciaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProvinciaUtilPersistence(null);

		entityCache.removeCache(ProvinciaImpl.class.getName());
	}

	private void _setProvinciaUtilPersistence(
		ProvinciaPersistence provinciaPersistence) {

		try {
			Field field = ProvinciaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, provinciaPersistence);
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

	private static final String _SQL_SELECT_PROVINCIA =
		"SELECT provincia FROM Provincia provincia";

	private static final String _SQL_SELECT_PROVINCIA_WHERE =
		"SELECT provincia FROM Provincia provincia WHERE ";

	private static final String _SQL_COUNT_PROVINCIA =
		"SELECT COUNT(provincia) FROM Provincia provincia";

	private static final String _SQL_COUNT_PROVINCIA_WHERE =
		"SELECT COUNT(provincia) FROM Provincia provincia WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "provincia.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Provincia exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Provincia exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProvinciaPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProvinciaModelArgumentsResolver _provinciaModelArgumentsResolver;

}