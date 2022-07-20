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

import it.servizidigitali.common.exception.NoSuchStatoEsteroException;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.model.StatoEsteroTable;
import it.servizidigitali.common.model.impl.StatoEsteroImpl;
import it.servizidigitali.common.model.impl.StatoEsteroModelImpl;
import it.servizidigitali.common.service.persistence.StatoEsteroPersistence;
import it.servizidigitali.common.service.persistence.StatoEsteroUtil;
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
 * The persistence implementation for the stato estero service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {StatoEsteroPersistence.class, BasePersistence.class})
public class StatoEsteroPersistenceImpl
	extends BasePersistenceImpl<StatoEstero> implements StatoEsteroPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StatoEsteroUtil</code> to access the stato estero persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StatoEsteroImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCodiceStato;
	private FinderPath _finderPathCountByCodiceStato;

	/**
	 * Returns the stato estero where codiceStato = &#63; or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param codiceStato the codice stato
	 * @return the matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero findByCodiceStato(int codiceStato)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByCodiceStato(codiceStato);

		if (statoEstero == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codiceStato=");
			sb.append(codiceStato);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStatoEsteroException(sb.toString());
		}

		return statoEstero;
	}

	/**
	 * Returns the stato estero where codiceStato = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceStato the codice stato
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByCodiceStato(int codiceStato) {
		return fetchByCodiceStato(codiceStato, true);
	}

	/**
	 * Returns the stato estero where codiceStato = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceStato the codice stato
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByCodiceStato(
		int codiceStato, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codiceStato};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodiceStato, finderArgs);
		}

		if (result instanceof StatoEstero) {
			StatoEstero statoEstero = (StatoEstero)result;

			if (codiceStato != statoEstero.getCodiceStato()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STATOESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CODICESTATO_CODICESTATO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceStato);

				List<StatoEstero> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodiceStato, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {codiceStato};
							}

							_log.warn(
								"StatoEsteroPersistenceImpl.fetchByCodiceStato(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StatoEstero statoEstero = list.get(0);

					result = statoEstero;

					cacheResult(statoEstero);
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
			return (StatoEstero)result;
		}
	}

	/**
	 * Removes the stato estero where codiceStato = &#63; from the database.
	 *
	 * @param codiceStato the codice stato
	 * @return the stato estero that was removed
	 */
	@Override
	public StatoEstero removeByCodiceStato(int codiceStato)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = findByCodiceStato(codiceStato);

		return remove(statoEstero);
	}

	/**
	 * Returns the number of stato esteros where codiceStato = &#63;.
	 *
	 * @param codiceStato the codice stato
	 * @return the number of matching stato esteros
	 */
	@Override
	public int countByCodiceStato(int codiceStato) {
		FinderPath finderPath = _finderPathCountByCodiceStato;

		Object[] finderArgs = new Object[] {codiceStato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATOESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CODICESTATO_CODICESTATO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceStato);

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

	private static final String _FINDER_COLUMN_CODICESTATO_CODICESTATO_2 =
		"statoEstero.codiceStato = ?";

	private FinderPath _finderPathFetchByDenominazione;
	private FinderPath _finderPathCountByDenominazione;

	/**
	 * Returns the stato estero where denominazione = &#63; or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param denominazione the denominazione
	 * @return the matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero findByDenominazione(String denominazione)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByDenominazione(denominazione);

		if (statoEstero == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("denominazione=");
			sb.append(denominazione);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStatoEsteroException(sb.toString());
		}

		return statoEstero;
	}

	/**
	 * Returns the stato estero where denominazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByDenominazione(String denominazione) {
		return fetchByDenominazione(denominazione, true);
	}

	/**
	 * Returns the stato estero where denominazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByDenominazione(
		String denominazione, boolean useFinderCache) {

		denominazione = Objects.toString(denominazione, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {denominazione};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDenominazione, finderArgs);
		}

		if (result instanceof StatoEstero) {
			StatoEstero statoEstero = (StatoEstero)result;

			if (!Objects.equals(
					denominazione, statoEstero.getDenominazione())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STATOESTERO_WHERE);

			boolean bindDenominazione = false;

			if (denominazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_3);
			}
			else {
				bindDenominazione = true;

				sb.append(_FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDenominazione) {
					queryPos.add(StringUtil.toLowerCase(denominazione));
				}

				List<StatoEstero> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDenominazione, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {denominazione};
							}

							_log.warn(
								"StatoEsteroPersistenceImpl.fetchByDenominazione(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					StatoEstero statoEstero = list.get(0);

					result = statoEstero;

					cacheResult(statoEstero);
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
			return (StatoEstero)result;
		}
	}

	/**
	 * Removes the stato estero where denominazione = &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 * @return the stato estero that was removed
	 */
	@Override
	public StatoEstero removeByDenominazione(String denominazione)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = findByDenominazione(denominazione);

		return remove(statoEstero);
	}

	/**
	 * Returns the number of stato esteros where denominazione = &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching stato esteros
	 */
	@Override
	public int countByDenominazione(String denominazione) {
		denominazione = Objects.toString(denominazione, "");

		FinderPath finderPath = _finderPathCountByDenominazione;

		Object[] finderArgs = new Object[] {denominazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATOESTERO_WHERE);

			boolean bindDenominazione = false;

			if (denominazione.isEmpty()) {
				sb.append(_FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_3);
			}
			else {
				bindDenominazione = true;

				sb.append(_FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDenominazione) {
					queryPos.add(StringUtil.toLowerCase(denominazione));
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

	private static final String _FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_2 =
		"lower(statoEstero.denominazione) = ?";

	private static final String _FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_3 =
		"(statoEstero.denominazione IS NULL OR statoEstero.denominazione = '')";

	private FinderPath _finderPathWithPaginationFindByContinente;
	private FinderPath _finderPathWithoutPaginationFindByContinente;
	private FinderPath _finderPathCountByContinente;

	/**
	 * Returns all the stato esteros where continente = &#63;.
	 *
	 * @param continente the continente
	 * @return the matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByContinente(int continente) {
		return findByContinente(
			continente, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByContinente(
		int continente, int start, int end) {

		return findByContinente(continente, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByContinente(
		int continente, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator) {

		return findByContinente(
			continente, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato esteros where continente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param continente the continente
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByContinente(
		int continente, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContinente;
				finderArgs = new Object[] {continente};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContinente;
			finderArgs = new Object[] {
				continente, start, end, orderByComparator
			};
		}

		List<StatoEstero> list = null;

		if (useFinderCache) {
			list = (List<StatoEstero>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StatoEstero statoEstero : list) {
					if (continente != statoEstero.getContinente()) {
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

			sb.append(_SQL_SELECT_STATOESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CONTINENTE_CONTINENTE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatoEsteroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(continente);

				list = (List<StatoEstero>)QueryUtil.list(
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
	 * Returns the first stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero findByContinente_First(
			int continente, OrderByComparator<StatoEstero> orderByComparator)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByContinente_First(
			continente, orderByComparator);

		if (statoEstero != null) {
			return statoEstero;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("continente=");
		sb.append(continente);

		sb.append("}");

		throw new NoSuchStatoEsteroException(sb.toString());
	}

	/**
	 * Returns the first stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByContinente_First(
		int continente, OrderByComparator<StatoEstero> orderByComparator) {

		List<StatoEstero> list = findByContinente(
			continente, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero findByContinente_Last(
			int continente, OrderByComparator<StatoEstero> orderByComparator)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByContinente_Last(
			continente, orderByComparator);

		if (statoEstero != null) {
			return statoEstero;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("continente=");
		sb.append(continente);

		sb.append("}");

		throw new NoSuchStatoEsteroException(sb.toString());
	}

	/**
	 * Returns the last stato estero in the ordered set where continente = &#63;.
	 *
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByContinente_Last(
		int continente, OrderByComparator<StatoEstero> orderByComparator) {

		int count = countByContinente(continente);

		if (count == 0) {
			return null;
		}

		List<StatoEstero> list = findByContinente(
			continente, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato esteros before and after the current stato estero in the ordered set where continente = &#63;.
	 *
	 * @param statoEsteroId the primary key of the current stato estero
	 * @param continente the continente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero[] findByContinente_PrevAndNext(
			long statoEsteroId, int continente,
			OrderByComparator<StatoEstero> orderByComparator)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = findByPrimaryKey(statoEsteroId);

		Session session = null;

		try {
			session = openSession();

			StatoEstero[] array = new StatoEsteroImpl[3];

			array[0] = getByContinente_PrevAndNext(
				session, statoEstero, continente, orderByComparator, true);

			array[1] = statoEstero;

			array[2] = getByContinente_PrevAndNext(
				session, statoEstero, continente, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoEstero getByContinente_PrevAndNext(
		Session session, StatoEstero statoEstero, int continente,
		OrderByComparator<StatoEstero> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATOESTERO_WHERE);

		sb.append(_FINDER_COLUMN_CONTINENTE_CONTINENTE_2);

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
			sb.append(StatoEsteroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(continente);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(statoEstero)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StatoEstero> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato esteros where continente = &#63; from the database.
	 *
	 * @param continente the continente
	 */
	@Override
	public void removeByContinente(int continente) {
		for (StatoEstero statoEstero :
				findByContinente(
					continente, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statoEstero);
		}
	}

	/**
	 * Returns the number of stato esteros where continente = &#63;.
	 *
	 * @param continente the continente
	 * @return the number of matching stato esteros
	 */
	@Override
	public int countByContinente(int continente) {
		FinderPath finderPath = _finderPathCountByContinente;

		Object[] finderArgs = new Object[] {continente};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATOESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CONTINENTE_CONTINENTE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(continente);

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

	private static final String _FINDER_COLUMN_CONTINENTE_CONTINENTE_2 =
		"statoEstero.continente = ?";

	private FinderPath _finderPathWithPaginationFindByCodiceArea;
	private FinderPath _finderPathWithoutPaginationFindByCodiceArea;
	private FinderPath _finderPathCountByCodiceArea;

	/**
	 * Returns all the stato esteros where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @return the matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByCodiceArea(int codiceArea) {
		return findByCodiceArea(
			codiceArea, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end) {

		return findByCodiceArea(codiceArea, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator) {

		return findByCodiceArea(
			codiceArea, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato esteros where codiceArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param codiceArea the codice area
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stato esteros
	 */
	@Override
	public List<StatoEstero> findByCodiceArea(
		int codiceArea, int start, int end,
		OrderByComparator<StatoEstero> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCodiceArea;
				finderArgs = new Object[] {codiceArea};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodiceArea;
			finderArgs = new Object[] {
				codiceArea, start, end, orderByComparator
			};
		}

		List<StatoEstero> list = null;

		if (useFinderCache) {
			list = (List<StatoEstero>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (StatoEstero statoEstero : list) {
					if (codiceArea != statoEstero.getCodiceArea()) {
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

			sb.append(_SQL_SELECT_STATOESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CODICEAREA_CODICEAREA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatoEsteroModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceArea);

				list = (List<StatoEstero>)QueryUtil.list(
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
	 * Returns the first stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero findByCodiceArea_First(
			int codiceArea, OrderByComparator<StatoEstero> orderByComparator)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByCodiceArea_First(
			codiceArea, orderByComparator);

		if (statoEstero != null) {
			return statoEstero;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceArea=");
		sb.append(codiceArea);

		sb.append("}");

		throw new NoSuchStatoEsteroException(sb.toString());
	}

	/**
	 * Returns the first stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByCodiceArea_First(
		int codiceArea, OrderByComparator<StatoEstero> orderByComparator) {

		List<StatoEstero> list = findByCodiceArea(
			codiceArea, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero
	 * @throws NoSuchStatoEsteroException if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero findByCodiceArea_Last(
			int codiceArea, OrderByComparator<StatoEstero> orderByComparator)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByCodiceArea_Last(
			codiceArea, orderByComparator);

		if (statoEstero != null) {
			return statoEstero;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceArea=");
		sb.append(codiceArea);

		sb.append("}");

		throw new NoSuchStatoEsteroException(sb.toString());
	}

	/**
	 * Returns the last stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato estero, or <code>null</code> if a matching stato estero could not be found
	 */
	@Override
	public StatoEstero fetchByCodiceArea_Last(
		int codiceArea, OrderByComparator<StatoEstero> orderByComparator) {

		int count = countByCodiceArea(codiceArea);

		if (count == 0) {
			return null;
		}

		List<StatoEstero> list = findByCodiceArea(
			codiceArea, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stato esteros before and after the current stato estero in the ordered set where codiceArea = &#63;.
	 *
	 * @param statoEsteroId the primary key of the current stato estero
	 * @param codiceArea the codice area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero[] findByCodiceArea_PrevAndNext(
			long statoEsteroId, int codiceArea,
			OrderByComparator<StatoEstero> orderByComparator)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = findByPrimaryKey(statoEsteroId);

		Session session = null;

		try {
			session = openSession();

			StatoEstero[] array = new StatoEsteroImpl[3];

			array[0] = getByCodiceArea_PrevAndNext(
				session, statoEstero, codiceArea, orderByComparator, true);

			array[1] = statoEstero;

			array[2] = getByCodiceArea_PrevAndNext(
				session, statoEstero, codiceArea, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatoEstero getByCodiceArea_PrevAndNext(
		Session session, StatoEstero statoEstero, int codiceArea,
		OrderByComparator<StatoEstero> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATOESTERO_WHERE);

		sb.append(_FINDER_COLUMN_CODICEAREA_CODICEAREA_2);

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
			sb.append(StatoEsteroModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(codiceArea);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(statoEstero)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StatoEstero> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stato esteros where codiceArea = &#63; from the database.
	 *
	 * @param codiceArea the codice area
	 */
	@Override
	public void removeByCodiceArea(int codiceArea) {
		for (StatoEstero statoEstero :
				findByCodiceArea(
					codiceArea, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statoEstero);
		}
	}

	/**
	 * Returns the number of stato esteros where codiceArea = &#63;.
	 *
	 * @param codiceArea the codice area
	 * @return the number of matching stato esteros
	 */
	@Override
	public int countByCodiceArea(int codiceArea) {
		FinderPath finderPath = _finderPathCountByCodiceArea;

		Object[] finderArgs = new Object[] {codiceArea};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATOESTERO_WHERE);

			sb.append(_FINDER_COLUMN_CODICEAREA_CODICEAREA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceArea);

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

	private static final String _FINDER_COLUMN_CODICEAREA_CODICEAREA_2 =
		"statoEstero.codiceArea = ?";

	public StatoEsteroPersistenceImpl() {
		setModelClass(StatoEstero.class);

		setModelImplClass(StatoEsteroImpl.class);
		setModelPKClass(long.class);

		setTable(StatoEsteroTable.INSTANCE);
	}

	/**
	 * Caches the stato estero in the entity cache if it is enabled.
	 *
	 * @param statoEstero the stato estero
	 */
	@Override
	public void cacheResult(StatoEstero statoEstero) {
		entityCache.putResult(
			StatoEsteroImpl.class, statoEstero.getPrimaryKey(), statoEstero);

		finderCache.putResult(
			_finderPathFetchByCodiceStato,
			new Object[] {statoEstero.getCodiceStato()}, statoEstero);

		finderCache.putResult(
			_finderPathFetchByDenominazione,
			new Object[] {statoEstero.getDenominazione()}, statoEstero);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the stato esteros in the entity cache if it is enabled.
	 *
	 * @param statoEsteros the stato esteros
	 */
	@Override
	public void cacheResult(List<StatoEstero> statoEsteros) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (statoEsteros.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StatoEstero statoEstero : statoEsteros) {
			if (entityCache.getResult(
					StatoEsteroImpl.class, statoEstero.getPrimaryKey()) ==
						null) {

				cacheResult(statoEstero);
			}
		}
	}

	/**
	 * Clears the cache for all stato esteros.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoEsteroImpl.class);

		finderCache.clearCache(StatoEsteroImpl.class);
	}

	/**
	 * Clears the cache for the stato estero.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoEstero statoEstero) {
		entityCache.removeResult(StatoEsteroImpl.class, statoEstero);
	}

	@Override
	public void clearCache(List<StatoEstero> statoEsteros) {
		for (StatoEstero statoEstero : statoEsteros) {
			entityCache.removeResult(StatoEsteroImpl.class, statoEstero);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StatoEsteroImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StatoEsteroImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		StatoEsteroModelImpl statoEsteroModelImpl) {

		Object[] args = new Object[] {statoEsteroModelImpl.getCodiceStato()};

		finderCache.putResult(
			_finderPathCountByCodiceStato, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodiceStato, args, statoEsteroModelImpl);

		args = new Object[] {statoEsteroModelImpl.getDenominazione()};

		finderCache.putResult(
			_finderPathCountByDenominazione, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDenominazione, args, statoEsteroModelImpl);
	}

	/**
	 * Creates a new stato estero with the primary key. Does not add the stato estero to the database.
	 *
	 * @param statoEsteroId the primary key for the new stato estero
	 * @return the new stato estero
	 */
	@Override
	public StatoEstero create(long statoEsteroId) {
		StatoEstero statoEstero = new StatoEsteroImpl();

		statoEstero.setNew(true);
		statoEstero.setPrimaryKey(statoEsteroId);

		return statoEstero;
	}

	/**
	 * Removes the stato estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero that was removed
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero remove(long statoEsteroId)
		throws NoSuchStatoEsteroException {

		return remove((Serializable)statoEsteroId);
	}

	/**
	 * Removes the stato estero with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato estero
	 * @return the stato estero that was removed
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero remove(Serializable primaryKey)
		throws NoSuchStatoEsteroException {

		Session session = null;

		try {
			session = openSession();

			StatoEstero statoEstero = (StatoEstero)session.get(
				StatoEsteroImpl.class, primaryKey);

			if (statoEstero == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoEsteroException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(statoEstero);
		}
		catch (NoSuchStatoEsteroException noSuchEntityException) {
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
	protected StatoEstero removeImpl(StatoEstero statoEstero) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoEstero)) {
				statoEstero = (StatoEstero)session.get(
					StatoEsteroImpl.class, statoEstero.getPrimaryKeyObj());
			}

			if (statoEstero != null) {
				session.delete(statoEstero);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (statoEstero != null) {
			clearCache(statoEstero);
		}

		return statoEstero;
	}

	@Override
	public StatoEstero updateImpl(StatoEstero statoEstero) {
		boolean isNew = statoEstero.isNew();

		if (!(statoEstero instanceof StatoEsteroModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(statoEstero.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(statoEstero);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in statoEstero proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StatoEstero implementation " +
					statoEstero.getClass());
		}

		StatoEsteroModelImpl statoEsteroModelImpl =
			(StatoEsteroModelImpl)statoEstero;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(statoEstero);
			}
			else {
				statoEstero = (StatoEstero)session.merge(statoEstero);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StatoEsteroImpl.class, statoEsteroModelImpl, false, true);

		cacheUniqueFindersCache(statoEsteroModelImpl);

		if (isNew) {
			statoEstero.setNew(false);
		}

		statoEstero.resetOriginalValues();

		return statoEstero;
	}

	/**
	 * Returns the stato estero with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato estero
	 * @return the stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoEsteroException {

		StatoEstero statoEstero = fetchByPrimaryKey(primaryKey);

		if (statoEstero == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoEsteroException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return statoEstero;
	}

	/**
	 * Returns the stato estero with the primary key or throws a <code>NoSuchStatoEsteroException</code> if it could not be found.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero
	 * @throws NoSuchStatoEsteroException if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero findByPrimaryKey(long statoEsteroId)
		throws NoSuchStatoEsteroException {

		return findByPrimaryKey((Serializable)statoEsteroId);
	}

	/**
	 * Returns the stato estero with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statoEsteroId the primary key of the stato estero
	 * @return the stato estero, or <code>null</code> if a stato estero with the primary key could not be found
	 */
	@Override
	public StatoEstero fetchByPrimaryKey(long statoEsteroId) {
		return fetchByPrimaryKey((Serializable)statoEsteroId);
	}

	/**
	 * Returns all the stato esteros.
	 *
	 * @return the stato esteros
	 */
	@Override
	public List<StatoEstero> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @return the range of stato esteros
	 */
	@Override
	public List<StatoEstero> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato esteros
	 */
	@Override
	public List<StatoEstero> findAll(
		int start, int end, OrderByComparator<StatoEstero> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato esteros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatoEsteroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato esteros
	 * @param end the upper bound of the range of stato esteros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stato esteros
	 */
	@Override
	public List<StatoEstero> findAll(
		int start, int end, OrderByComparator<StatoEstero> orderByComparator,
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

		List<StatoEstero> list = null;

		if (useFinderCache) {
			list = (List<StatoEstero>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STATOESTERO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STATOESTERO;

				sql = sql.concat(StatoEsteroModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StatoEstero>)QueryUtil.list(
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
	 * Removes all the stato esteros from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoEstero statoEstero : findAll()) {
			remove(statoEstero);
		}
	}

	/**
	 * Returns the number of stato esteros.
	 *
	 * @return the number of stato esteros
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STATOESTERO);

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
		return "statoEsteroId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STATOESTERO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StatoEsteroModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato estero persistence.
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

		_finderPathFetchByCodiceStato = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodiceStato",
			new String[] {Integer.class.getName()},
			new String[] {"codiceStato"}, true);

		_finderPathCountByCodiceStato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceStato",
			new String[] {Integer.class.getName()},
			new String[] {"codiceStato"}, false);

		_finderPathFetchByDenominazione = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDenominazione",
			new String[] {String.class.getName()},
			new String[] {"denominazione"}, true);

		_finderPathCountByDenominazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDenominazione",
			new String[] {String.class.getName()},
			new String[] {"denominazione"}, false);

		_finderPathWithPaginationFindByContinente = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContinente",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"continente"}, true);

		_finderPathWithoutPaginationFindByContinente = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContinente",
			new String[] {Integer.class.getName()}, new String[] {"continente"},
			true);

		_finderPathCountByContinente = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContinente",
			new String[] {Integer.class.getName()}, new String[] {"continente"},
			false);

		_finderPathWithPaginationFindByCodiceArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodiceArea",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"codiceArea"}, true);

		_finderPathWithoutPaginationFindByCodiceArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodiceArea",
			new String[] {Integer.class.getName()}, new String[] {"codiceArea"},
			true);

		_finderPathCountByCodiceArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceArea",
			new String[] {Integer.class.getName()}, new String[] {"codiceArea"},
			false);

		_setStatoEsteroUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStatoEsteroUtilPersistence(null);

		entityCache.removeCache(StatoEsteroImpl.class.getName());
	}

	private void _setStatoEsteroUtilPersistence(
		StatoEsteroPersistence statoEsteroPersistence) {

		try {
			Field field = StatoEsteroUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, statoEsteroPersistence);
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

	private static final String _SQL_SELECT_STATOESTERO =
		"SELECT statoEstero FROM StatoEstero statoEstero";

	private static final String _SQL_SELECT_STATOESTERO_WHERE =
		"SELECT statoEstero FROM StatoEstero statoEstero WHERE ";

	private static final String _SQL_COUNT_STATOESTERO =
		"SELECT COUNT(statoEstero) FROM StatoEstero statoEstero";

	private static final String _SQL_COUNT_STATOESTERO_WHERE =
		"SELECT COUNT(statoEstero) FROM StatoEstero statoEstero WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "statoEstero.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StatoEstero exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StatoEstero exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StatoEsteroPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private StatoEsteroModelArgumentsResolver
		_statoEsteroModelArgumentsResolver;

}