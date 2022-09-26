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

import it.servizidigitali.common.exception.NoSuchComuneException;
import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneTable;
import it.servizidigitali.common.model.impl.ComuneImpl;
import it.servizidigitali.common.model.impl.ComuneModelImpl;
import it.servizidigitali.common.service.persistence.ComunePersistence;
import it.servizidigitali.common.service.persistence.ComuneUtil;
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
 * The persistence implementation for the comune service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ComunePersistence.class, BasePersistence.class})
public class ComunePersistenceImpl
	extends BasePersistenceImpl<Comune> implements ComunePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ComuneUtil</code> to access the comune persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ComuneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCodiceIstatAN;
	private FinderPath _finderPathCountByCodiceIstatAN;

	/**
	 * Returns the comune where codiceIstatAN = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByCodiceIstatAN(String codiceIstatAN)
		throws NoSuchComuneException {

		Comune comune = fetchByCodiceIstatAN(codiceIstatAN);

		if (comune == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codiceIstatAN=");
			sb.append(codiceIstatAN);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchComuneException(sb.toString());
		}

		return comune;
	}

	/**
	 * Returns the comune where codiceIstatAN = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByCodiceIstatAN(String codiceIstatAN) {
		return fetchByCodiceIstatAN(codiceIstatAN, true);
	}

	/**
	 * Returns the comune where codiceIstatAN = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByCodiceIstatAN(
		String codiceIstatAN, boolean useFinderCache) {

		codiceIstatAN = Objects.toString(codiceIstatAN, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codiceIstatAN};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodiceIstatAN, finderArgs);
		}

		if (result instanceof Comune) {
			Comune comune = (Comune)result;

			if (!Objects.equals(codiceIstatAN, comune.getCodiceIstatAN())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COMUNE_WHERE);

			boolean bindCodiceIstatAN = false;

			if (codiceIstatAN.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEISTATAN_CODICEISTATAN_3);
			}
			else {
				bindCodiceIstatAN = true;

				sb.append(_FINDER_COLUMN_CODICEISTATAN_CODICEISTATAN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceIstatAN) {
					queryPos.add(codiceIstatAN);
				}

				List<Comune> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodiceIstatAN, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {codiceIstatAN};
							}

							_log.warn(
								"ComunePersistenceImpl.fetchByCodiceIstatAN(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Comune comune = list.get(0);

					result = comune;

					cacheResult(comune);
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
			return (Comune)result;
		}
	}

	/**
	 * Removes the comune where codiceIstatAN = &#63; from the database.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the comune that was removed
	 */
	@Override
	public Comune removeByCodiceIstatAN(String codiceIstatAN)
		throws NoSuchComuneException {

		Comune comune = findByCodiceIstatAN(codiceIstatAN);

		return remove(comune);
	}

	/**
	 * Returns the number of comunes where codiceIstatAN = &#63;.
	 *
	 * @param codiceIstatAN the codice istat an
	 * @return the number of matching comunes
	 */
	@Override
	public int countByCodiceIstatAN(String codiceIstatAN) {
		codiceIstatAN = Objects.toString(codiceIstatAN, "");

		FinderPath finderPath = _finderPathCountByCodiceIstatAN;

		Object[] finderArgs = new Object[] {codiceIstatAN};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNE_WHERE);

			boolean bindCodiceIstatAN = false;

			if (codiceIstatAN.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEISTATAN_CODICEISTATAN_3);
			}
			else {
				bindCodiceIstatAN = true;

				sb.append(_FINDER_COLUMN_CODICEISTATAN_CODICEISTATAN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceIstatAN) {
					queryPos.add(codiceIstatAN);
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

	private static final String _FINDER_COLUMN_CODICEISTATAN_CODICEISTATAN_2 =
		"comune.codiceIstatAN = ?";

	private static final String _FINDER_COLUMN_CODICEISTATAN_CODICEISTATAN_3 =
		"(comune.codiceIstatAN IS NULL OR comune.codiceIstatAN = '')";

	private FinderPath _finderPathFetchByCodiceCatastale;
	private FinderPath _finderPathCountByCodiceCatastale;

	/**
	 * Returns the comune where codiceCatastale = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByCodiceCatastale(String codiceCatastale)
		throws NoSuchComuneException {

		Comune comune = fetchByCodiceCatastale(codiceCatastale);

		if (comune == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codiceCatastale=");
			sb.append(codiceCatastale);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchComuneException(sb.toString());
		}

		return comune;
	}

	/**
	 * Returns the comune where codiceCatastale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByCodiceCatastale(String codiceCatastale) {
		return fetchByCodiceCatastale(codiceCatastale, true);
	}

	/**
	 * Returns the comune where codiceCatastale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceCatastale the codice catastale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByCodiceCatastale(
		String codiceCatastale, boolean useFinderCache) {

		codiceCatastale = Objects.toString(codiceCatastale, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codiceCatastale};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodiceCatastale, finderArgs);
		}

		if (result instanceof Comune) {
			Comune comune = (Comune)result;

			if (!Objects.equals(codiceCatastale, comune.getCodiceCatastale())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COMUNE_WHERE);

			boolean bindCodiceCatastale = false;

			if (codiceCatastale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICECATASTALE_CODICECATASTALE_3);
			}
			else {
				bindCodiceCatastale = true;

				sb.append(_FINDER_COLUMN_CODICECATASTALE_CODICECATASTALE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceCatastale) {
					queryPos.add(codiceCatastale);
				}

				List<Comune> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodiceCatastale, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {codiceCatastale};
							}

							_log.warn(
								"ComunePersistenceImpl.fetchByCodiceCatastale(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Comune comune = list.get(0);

					result = comune;

					cacheResult(comune);
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
			return (Comune)result;
		}
	}

	/**
	 * Removes the comune where codiceCatastale = &#63; from the database.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the comune that was removed
	 */
	@Override
	public Comune removeByCodiceCatastale(String codiceCatastale)
		throws NoSuchComuneException {

		Comune comune = findByCodiceCatastale(codiceCatastale);

		return remove(comune);
	}

	/**
	 * Returns the number of comunes where codiceCatastale = &#63;.
	 *
	 * @param codiceCatastale the codice catastale
	 * @return the number of matching comunes
	 */
	@Override
	public int countByCodiceCatastale(String codiceCatastale) {
		codiceCatastale = Objects.toString(codiceCatastale, "");

		FinderPath finderPath = _finderPathCountByCodiceCatastale;

		Object[] finderArgs = new Object[] {codiceCatastale};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNE_WHERE);

			boolean bindCodiceCatastale = false;

			if (codiceCatastale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICECATASTALE_CODICECATASTALE_3);
			}
			else {
				bindCodiceCatastale = true;

				sb.append(_FINDER_COLUMN_CODICECATASTALE_CODICECATASTALE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceCatastale) {
					queryPos.add(codiceCatastale);
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
		_FINDER_COLUMN_CODICECATASTALE_CODICECATASTALE_2 =
			"comune.codiceCatastale = ?";

	private static final String
		_FINDER_COLUMN_CODICECATASTALE_CODICECATASTALE_3 =
			"(comune.codiceCatastale IS NULL OR comune.codiceCatastale = '')";

	private FinderPath _finderPathFetchByCodiceComune;
	private FinderPath _finderPathCountByCodiceComune;

	/**
	 * Returns the comune where codiceComune = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param codiceComune the codice comune
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByCodiceComune(int codiceComune)
		throws NoSuchComuneException {

		Comune comune = fetchByCodiceComune(codiceComune);

		if (comune == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codiceComune=");
			sb.append(codiceComune);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchComuneException(sb.toString());
		}

		return comune;
	}

	/**
	 * Returns the comune where codiceComune = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceComune the codice comune
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByCodiceComune(int codiceComune) {
		return fetchByCodiceComune(codiceComune, true);
	}

	/**
	 * Returns the comune where codiceComune = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceComune the codice comune
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByCodiceComune(
		int codiceComune, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {codiceComune};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodiceComune, finderArgs);
		}

		if (result instanceof Comune) {
			Comune comune = (Comune)result;

			if (codiceComune != comune.getCodiceComune()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COMUNE_WHERE);

			sb.append(_FINDER_COLUMN_CODICECOMUNE_CODICECOMUNE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceComune);

				List<Comune> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodiceComune, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {codiceComune};
							}

							_log.warn(
								"ComunePersistenceImpl.fetchByCodiceComune(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Comune comune = list.get(0);

					result = comune;

					cacheResult(comune);
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
			return (Comune)result;
		}
	}

	/**
	 * Removes the comune where codiceComune = &#63; from the database.
	 *
	 * @param codiceComune the codice comune
	 * @return the comune that was removed
	 */
	@Override
	public Comune removeByCodiceComune(int codiceComune)
		throws NoSuchComuneException {

		Comune comune = findByCodiceComune(codiceComune);

		return remove(comune);
	}

	/**
	 * Returns the number of comunes where codiceComune = &#63;.
	 *
	 * @param codiceComune the codice comune
	 * @return the number of matching comunes
	 */
	@Override
	public int countByCodiceComune(int codiceComune) {
		FinderPath finderPath = _finderPathCountByCodiceComune;

		Object[] finderArgs = new Object[] {codiceComune};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNE_WHERE);

			sb.append(_FINDER_COLUMN_CODICECOMUNE_CODICECOMUNE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(codiceComune);

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

	private static final String _FINDER_COLUMN_CODICECOMUNE_CODICECOMUNE_2 =
		"comune.codiceComune = ?";

	private FinderPath _finderPathFetchByDenominazione;
	private FinderPath _finderPathCountByDenominazione;

	/**
	 * Returns the comune where denominazione = &#63; or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByDenominazione(String denominazione)
		throws NoSuchComuneException {

		Comune comune = fetchByDenominazione(denominazione);

		if (comune == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("denominazione=");
			sb.append(denominazione);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchComuneException(sb.toString());
		}

		return comune;
	}

	/**
	 * Returns the comune where denominazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByDenominazione(String denominazione) {
		return fetchByDenominazione(denominazione, true);
	}

	/**
	 * Returns the comune where denominazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param denominazione the denominazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByDenominazione(
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

		if (result instanceof Comune) {
			Comune comune = (Comune)result;

			if (!Objects.equals(denominazione, comune.getDenominazione())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COMUNE_WHERE);

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

				List<Comune> list = query.list();

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
								"ComunePersistenceImpl.fetchByDenominazione(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Comune comune = list.get(0);

					result = comune;

					cacheResult(comune);
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
			return (Comune)result;
		}
	}

	/**
	 * Removes the comune where denominazione = &#63; from the database.
	 *
	 * @param denominazione the denominazione
	 * @return the comune that was removed
	 */
	@Override
	public Comune removeByDenominazione(String denominazione)
		throws NoSuchComuneException {

		Comune comune = findByDenominazione(denominazione);

		return remove(comune);
	}

	/**
	 * Returns the number of comunes where denominazione = &#63;.
	 *
	 * @param denominazione the denominazione
	 * @return the number of matching comunes
	 */
	@Override
	public int countByDenominazione(String denominazione) {
		denominazione = Objects.toString(denominazione, "");

		FinderPath finderPath = _finderPathCountByDenominazione;

		Object[] finderArgs = new Object[] {denominazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNE_WHERE);

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
		"lower(comune.denominazione) = ?";

	private static final String _FINDER_COLUMN_DENOMINAZIONE_DENOMINAZIONE_3 =
		"(comune.denominazione IS NULL OR comune.denominazione = '')";

	private FinderPath _finderPathWithPaginationFindByidRegione;
	private FinderPath _finderPathWithoutPaginationFindByidRegione;
	private FinderPath _finderPathCountByidRegione;

	/**
	 * Returns all the comunes where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @return the matching comunes
	 */
	@Override
	public List<Comune> findByidRegione(long idRegione) {
		return findByidRegione(
			idRegione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of matching comunes
	 */
	@Override
	public List<Comune> findByidRegione(long idRegione, int start, int end) {
		return findByidRegione(idRegione, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunes
	 */
	@Override
	public List<Comune> findByidRegione(
		long idRegione, int start, int end,
		OrderByComparator<Comune> orderByComparator) {

		return findByidRegione(idRegione, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunes where idRegione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idRegione the id regione
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunes
	 */
	@Override
	public List<Comune> findByidRegione(
		long idRegione, int start, int end,
		OrderByComparator<Comune> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByidRegione;
				finderArgs = new Object[] {idRegione};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByidRegione;
			finderArgs = new Object[] {
				idRegione, start, end, orderByComparator
			};
		}

		List<Comune> list = null;

		if (useFinderCache) {
			list = (List<Comune>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comune comune : list) {
					if (idRegione != comune.getIdRegione()) {
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

			sb.append(_SQL_SELECT_COMUNE_WHERE);

			sb.append(_FINDER_COLUMN_IDREGIONE_IDREGIONE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComuneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idRegione);

				list = (List<Comune>)QueryUtil.list(
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
	 * Returns the first comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByidRegione_First(
			long idRegione, OrderByComparator<Comune> orderByComparator)
		throws NoSuchComuneException {

		Comune comune = fetchByidRegione_First(idRegione, orderByComparator);

		if (comune != null) {
			return comune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegione=");
		sb.append(idRegione);

		sb.append("}");

		throw new NoSuchComuneException(sb.toString());
	}

	/**
	 * Returns the first comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByidRegione_First(
		long idRegione, OrderByComparator<Comune> orderByComparator) {

		List<Comune> list = findByidRegione(idRegione, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByidRegione_Last(
			long idRegione, OrderByComparator<Comune> orderByComparator)
		throws NoSuchComuneException {

		Comune comune = fetchByidRegione_Last(idRegione, orderByComparator);

		if (comune != null) {
			return comune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idRegione=");
		sb.append(idRegione);

		sb.append("}");

		throw new NoSuchComuneException(sb.toString());
	}

	/**
	 * Returns the last comune in the ordered set where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByidRegione_Last(
		long idRegione, OrderByComparator<Comune> orderByComparator) {

		int count = countByidRegione(idRegione);

		if (count == 0) {
			return null;
		}

		List<Comune> list = findByidRegione(
			idRegione, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunes before and after the current comune in the ordered set where idRegione = &#63;.
	 *
	 * @param comuneId the primary key of the current comune
	 * @param idRegione the id regione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	@Override
	public Comune[] findByidRegione_PrevAndNext(
			long comuneId, long idRegione,
			OrderByComparator<Comune> orderByComparator)
		throws NoSuchComuneException {

		Comune comune = findByPrimaryKey(comuneId);

		Session session = null;

		try {
			session = openSession();

			Comune[] array = new ComuneImpl[3];

			array[0] = getByidRegione_PrevAndNext(
				session, comune, idRegione, orderByComparator, true);

			array[1] = comune;

			array[2] = getByidRegione_PrevAndNext(
				session, comune, idRegione, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comune getByidRegione_PrevAndNext(
		Session session, Comune comune, long idRegione,
		OrderByComparator<Comune> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNE_WHERE);

		sb.append(_FINDER_COLUMN_IDREGIONE_IDREGIONE_2);

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
			sb.append(ComuneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(idRegione);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comune)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comune> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunes where idRegione = &#63; from the database.
	 *
	 * @param idRegione the id regione
	 */
	@Override
	public void removeByidRegione(long idRegione) {
		for (Comune comune :
				findByidRegione(
					idRegione, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comune);
		}
	}

	/**
	 * Returns the number of comunes where idRegione = &#63;.
	 *
	 * @param idRegione the id regione
	 * @return the number of matching comunes
	 */
	@Override
	public int countByidRegione(long idRegione) {
		FinderPath finderPath = _finderPathCountByidRegione;

		Object[] finderArgs = new Object[] {idRegione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNE_WHERE);

			sb.append(_FINDER_COLUMN_IDREGIONE_IDREGIONE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idRegione);

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

	private static final String _FINDER_COLUMN_IDREGIONE_IDREGIONE_2 =
		"comune.idRegione = ?";

	private FinderPath _finderPathWithPaginationFindByIdProvincia;
	private FinderPath _finderPathWithoutPaginationFindByIdProvincia;
	private FinderPath _finderPathCountByIdProvincia;

	/**
	 * Returns all the comunes where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @return the matching comunes
	 */
	@Override
	public List<Comune> findByIdProvincia(long idProvincia) {
		return findByIdProvincia(
			idProvincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of matching comunes
	 */
	@Override
	public List<Comune> findByIdProvincia(
		long idProvincia, int start, int end) {

		return findByIdProvincia(idProvincia, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunes
	 */
	@Override
	public List<Comune> findByIdProvincia(
		long idProvincia, int start, int end,
		OrderByComparator<Comune> orderByComparator) {

		return findByIdProvincia(
			idProvincia, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunes where idProvincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param idProvincia the id provincia
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunes
	 */
	@Override
	public List<Comune> findByIdProvincia(
		long idProvincia, int start, int end,
		OrderByComparator<Comune> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIdProvincia;
				finderArgs = new Object[] {idProvincia};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIdProvincia;
			finderArgs = new Object[] {
				idProvincia, start, end, orderByComparator
			};
		}

		List<Comune> list = null;

		if (useFinderCache) {
			list = (List<Comune>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comune comune : list) {
					if (idProvincia != comune.getIdProvincia()) {
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

			sb.append(_SQL_SELECT_COMUNE_WHERE);

			sb.append(_FINDER_COLUMN_IDPROVINCIA_IDPROVINCIA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComuneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idProvincia);

				list = (List<Comune>)QueryUtil.list(
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
	 * Returns the first comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByIdProvincia_First(
			long idProvincia, OrderByComparator<Comune> orderByComparator)
		throws NoSuchComuneException {

		Comune comune = fetchByIdProvincia_First(
			idProvincia, orderByComparator);

		if (comune != null) {
			return comune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idProvincia=");
		sb.append(idProvincia);

		sb.append("}");

		throw new NoSuchComuneException(sb.toString());
	}

	/**
	 * Returns the first comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByIdProvincia_First(
		long idProvincia, OrderByComparator<Comune> orderByComparator) {

		List<Comune> list = findByIdProvincia(
			idProvincia, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune
	 * @throws NoSuchComuneException if a matching comune could not be found
	 */
	@Override
	public Comune findByIdProvincia_Last(
			long idProvincia, OrderByComparator<Comune> orderByComparator)
		throws NoSuchComuneException {

		Comune comune = fetchByIdProvincia_Last(idProvincia, orderByComparator);

		if (comune != null) {
			return comune;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idProvincia=");
		sb.append(idProvincia);

		sb.append("}");

		throw new NoSuchComuneException(sb.toString());
	}

	/**
	 * Returns the last comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comune, or <code>null</code> if a matching comune could not be found
	 */
	@Override
	public Comune fetchByIdProvincia_Last(
		long idProvincia, OrderByComparator<Comune> orderByComparator) {

		int count = countByIdProvincia(idProvincia);

		if (count == 0) {
			return null;
		}

		List<Comune> list = findByIdProvincia(
			idProvincia, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunes before and after the current comune in the ordered set where idProvincia = &#63;.
	 *
	 * @param comuneId the primary key of the current comune
	 * @param idProvincia the id provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	@Override
	public Comune[] findByIdProvincia_PrevAndNext(
			long comuneId, long idProvincia,
			OrderByComparator<Comune> orderByComparator)
		throws NoSuchComuneException {

		Comune comune = findByPrimaryKey(comuneId);

		Session session = null;

		try {
			session = openSession();

			Comune[] array = new ComuneImpl[3];

			array[0] = getByIdProvincia_PrevAndNext(
				session, comune, idProvincia, orderByComparator, true);

			array[1] = comune;

			array[2] = getByIdProvincia_PrevAndNext(
				session, comune, idProvincia, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comune getByIdProvincia_PrevAndNext(
		Session session, Comune comune, long idProvincia,
		OrderByComparator<Comune> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNE_WHERE);

		sb.append(_FINDER_COLUMN_IDPROVINCIA_IDPROVINCIA_2);

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
			sb.append(ComuneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(idProvincia);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(comune)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comune> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunes where idProvincia = &#63; from the database.
	 *
	 * @param idProvincia the id provincia
	 */
	@Override
	public void removeByIdProvincia(long idProvincia) {
		for (Comune comune :
				findByIdProvincia(
					idProvincia, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comune);
		}
	}

	/**
	 * Returns the number of comunes where idProvincia = &#63;.
	 *
	 * @param idProvincia the id provincia
	 * @return the number of matching comunes
	 */
	@Override
	public int countByIdProvincia(long idProvincia) {
		FinderPath finderPath = _finderPathCountByIdProvincia;

		Object[] finderArgs = new Object[] {idProvincia};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNE_WHERE);

			sb.append(_FINDER_COLUMN_IDPROVINCIA_IDPROVINCIA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idProvincia);

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

	private static final String _FINDER_COLUMN_IDPROVINCIA_IDPROVINCIA_2 =
		"comune.idProvincia = ?";

	public ComunePersistenceImpl() {
		setModelClass(Comune.class);

		setModelImplClass(ComuneImpl.class);
		setModelPKClass(long.class);

		setTable(ComuneTable.INSTANCE);
	}

	/**
	 * Caches the comune in the entity cache if it is enabled.
	 *
	 * @param comune the comune
	 */
	@Override
	public void cacheResult(Comune comune) {
		entityCache.putResult(ComuneImpl.class, comune.getPrimaryKey(), comune);

		finderCache.putResult(
			_finderPathFetchByCodiceIstatAN,
			new Object[] {comune.getCodiceIstatAN()}, comune);

		finderCache.putResult(
			_finderPathFetchByCodiceCatastale,
			new Object[] {comune.getCodiceCatastale()}, comune);

		finderCache.putResult(
			_finderPathFetchByCodiceComune,
			new Object[] {comune.getCodiceComune()}, comune);

		finderCache.putResult(
			_finderPathFetchByDenominazione,
			new Object[] {comune.getDenominazione()}, comune);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the comunes in the entity cache if it is enabled.
	 *
	 * @param comunes the comunes
	 */
	@Override
	public void cacheResult(List<Comune> comunes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (comunes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Comune comune : comunes) {
			if (entityCache.getResult(
					ComuneImpl.class, comune.getPrimaryKey()) == null) {

				cacheResult(comune);
			}
		}
	}

	/**
	 * Clears the cache for all comunes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ComuneImpl.class);

		finderCache.clearCache(ComuneImpl.class);
	}

	/**
	 * Clears the cache for the comune.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comune comune) {
		entityCache.removeResult(ComuneImpl.class, comune);
	}

	@Override
	public void clearCache(List<Comune> comunes) {
		for (Comune comune : comunes) {
			entityCache.removeResult(ComuneImpl.class, comune);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ComuneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ComuneImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ComuneModelImpl comuneModelImpl) {
		Object[] args = new Object[] {comuneModelImpl.getCodiceIstatAN()};

		finderCache.putResult(
			_finderPathCountByCodiceIstatAN, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodiceIstatAN, args, comuneModelImpl);

		args = new Object[] {comuneModelImpl.getCodiceCatastale()};

		finderCache.putResult(
			_finderPathCountByCodiceCatastale, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodiceCatastale, args, comuneModelImpl);

		args = new Object[] {comuneModelImpl.getCodiceComune()};

		finderCache.putResult(
			_finderPathCountByCodiceComune, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodiceComune, args, comuneModelImpl);

		args = new Object[] {comuneModelImpl.getDenominazione()};

		finderCache.putResult(
			_finderPathCountByDenominazione, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDenominazione, args, comuneModelImpl);
	}

	/**
	 * Creates a new comune with the primary key. Does not add the comune to the database.
	 *
	 * @param comuneId the primary key for the new comune
	 * @return the new comune
	 */
	@Override
	public Comune create(long comuneId) {
		Comune comune = new ComuneImpl();

		comune.setNew(true);
		comune.setPrimaryKey(comuneId);

		return comune;
	}

	/**
	 * Removes the comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune that was removed
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	@Override
	public Comune remove(long comuneId) throws NoSuchComuneException {
		return remove((Serializable)comuneId);
	}

	/**
	 * Removes the comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comune
	 * @return the comune that was removed
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	@Override
	public Comune remove(Serializable primaryKey) throws NoSuchComuneException {
		Session session = null;

		try {
			session = openSession();

			Comune comune = (Comune)session.get(ComuneImpl.class, primaryKey);

			if (comune == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComuneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(comune);
		}
		catch (NoSuchComuneException noSuchEntityException) {
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
	protected Comune removeImpl(Comune comune) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comune)) {
				comune = (Comune)session.get(
					ComuneImpl.class, comune.getPrimaryKeyObj());
			}

			if (comune != null) {
				session.delete(comune);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (comune != null) {
			clearCache(comune);
		}

		return comune;
	}

	@Override
	public Comune updateImpl(Comune comune) {
		boolean isNew = comune.isNew();

		if (!(comune instanceof ComuneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(comune.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(comune);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in comune proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Comune implementation " +
					comune.getClass());
		}

		ComuneModelImpl comuneModelImpl = (ComuneModelImpl)comune;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(comune);
			}
			else {
				comune = (Comune)session.merge(comune);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ComuneImpl.class, comuneModelImpl, false, true);

		cacheUniqueFindersCache(comuneModelImpl);

		if (isNew) {
			comune.setNew(false);
		}

		comune.resetOriginalValues();

		return comune;
	}

	/**
	 * Returns the comune with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comune
	 * @return the comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	@Override
	public Comune findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComuneException {

		Comune comune = fetchByPrimaryKey(primaryKey);

		if (comune == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComuneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return comune;
	}

	/**
	 * Returns the comune with the primary key or throws a <code>NoSuchComuneException</code> if it could not be found.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune
	 * @throws NoSuchComuneException if a comune with the primary key could not be found
	 */
	@Override
	public Comune findByPrimaryKey(long comuneId) throws NoSuchComuneException {
		return findByPrimaryKey((Serializable)comuneId);
	}

	/**
	 * Returns the comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comuneId the primary key of the comune
	 * @return the comune, or <code>null</code> if a comune with the primary key could not be found
	 */
	@Override
	public Comune fetchByPrimaryKey(long comuneId) {
		return fetchByPrimaryKey((Serializable)comuneId);
	}

	/**
	 * Returns all the comunes.
	 *
	 * @return the comunes
	 */
	@Override
	public List<Comune> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @return the range of comunes
	 */
	@Override
	public List<Comune> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comunes
	 */
	@Override
	public List<Comune> findAll(
		int start, int end, OrderByComparator<Comune> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComuneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunes
	 * @param end the upper bound of the range of comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comunes
	 */
	@Override
	public List<Comune> findAll(
		int start, int end, OrderByComparator<Comune> orderByComparator,
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

		List<Comune> list = null;

		if (useFinderCache) {
			list = (List<Comune>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMUNE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMUNE;

				sql = sql.concat(ComuneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Comune>)QueryUtil.list(
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
	 * Removes all the comunes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Comune comune : findAll()) {
			remove(comune);
		}
	}

	/**
	 * Returns the number of comunes.
	 *
	 * @return the number of comunes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMUNE);

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
		return "comuneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMUNE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ComuneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comune persistence.
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

		_finderPathFetchByCodiceIstatAN = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodiceIstatAN",
			new String[] {String.class.getName()},
			new String[] {"codiceIstatAN"}, true);

		_finderPathCountByCodiceIstatAN = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceIstatAN",
			new String[] {String.class.getName()},
			new String[] {"codiceIstatAN"}, false);

		_finderPathFetchByCodiceCatastale = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodiceCatastale",
			new String[] {String.class.getName()},
			new String[] {"codiceCatastale"}, true);

		_finderPathCountByCodiceCatastale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceCatastale",
			new String[] {String.class.getName()},
			new String[] {"codiceCatastale"}, false);

		_finderPathFetchByCodiceComune = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodiceComune",
			new String[] {Integer.class.getName()},
			new String[] {"codiceComune"}, true);

		_finderPathCountByCodiceComune = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceComune",
			new String[] {Integer.class.getName()},
			new String[] {"codiceComune"}, false);

		_finderPathFetchByDenominazione = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDenominazione",
			new String[] {String.class.getName()},
			new String[] {"denominazione"}, true);

		_finderPathCountByDenominazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDenominazione",
			new String[] {String.class.getName()},
			new String[] {"denominazione"}, false);

		_finderPathWithPaginationFindByidRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByidRegione",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idRegione"}, true);

		_finderPathWithoutPaginationFindByidRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByidRegione",
			new String[] {Long.class.getName()}, new String[] {"idRegione"},
			true);

		_finderPathCountByidRegione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByidRegione",
			new String[] {Long.class.getName()}, new String[] {"idRegione"},
			false);

		_finderPathWithPaginationFindByIdProvincia = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdProvincia",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idProvincia"}, true);

		_finderPathWithoutPaginationFindByIdProvincia = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdProvincia",
			new String[] {Long.class.getName()}, new String[] {"idProvincia"},
			true);

		_finderPathCountByIdProvincia = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdProvincia",
			new String[] {Long.class.getName()}, new String[] {"idProvincia"},
			false);

		_setComuneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setComuneUtilPersistence(null);

		entityCache.removeCache(ComuneImpl.class.getName());
	}

	private void _setComuneUtilPersistence(
		ComunePersistence comunePersistence) {

		try {
			Field field = ComuneUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, comunePersistence);
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

	private static final String _SQL_SELECT_COMUNE =
		"SELECT comune FROM Comune comune";

	private static final String _SQL_SELECT_COMUNE_WHERE =
		"SELECT comune FROM Comune comune WHERE ";

	private static final String _SQL_COUNT_COMUNE =
		"SELECT COUNT(comune) FROM Comune comune";

	private static final String _SQL_COUNT_COMUNE_WHERE =
		"SELECT COUNT(comune) FROM Comune comune WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "comune.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Comune exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Comune exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ComunePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ComuneModelArgumentsResolver _comuneModelArgumentsResolver;

}