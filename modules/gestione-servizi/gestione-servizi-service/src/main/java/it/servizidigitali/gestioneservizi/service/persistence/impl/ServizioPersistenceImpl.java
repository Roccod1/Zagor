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

package it.servizidigitali.gestioneservizi.service.persistence.impl;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.gestioneservizi.exception.NoSuchServizioException;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.ServizioTable;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.model.impl.ServizioImpl;
import it.servizidigitali.gestioneservizi.model.impl.ServizioModelImpl;
import it.servizidigitali.gestioneservizi.service.persistence.ServizioPersistence;
import it.servizidigitali.gestioneservizi.service.persistence.ServizioUtil;
import it.servizidigitali.gestioneservizi.service.persistence.impl.constants.PersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
 * The persistence implementation for the servizio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ServizioPersistence.class, BasePersistence.class})
public class ServizioPersistenceImpl
	extends BasePersistenceImpl<Servizio> implements ServizioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServizioUtil</code> to access the servizio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServizioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Servizio> list = null;

		if (useFinderCache) {
			list = (List<Servizio>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Servizio servizio : list) {
					if (!uuid.equals(servizio.getUuid())) {
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

			sb.append(_SQL_SELECT_SERVIZIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServizioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Servizio>)QueryUtil.list(
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
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUuid_First(
			String uuid, OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = fetchByUuid_First(uuid, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchServizioException(sb.toString());
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUuid_First(
		String uuid, OrderByComparator<Servizio> orderByComparator) {

		List<Servizio> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUuid_Last(
			String uuid, OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = fetchByUuid_Last(uuid, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchServizioException(sb.toString());
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUuid_Last(
		String uuid, OrderByComparator<Servizio> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Servizio> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio[] findByUuid_PrevAndNext(
			long servizioId, String uuid,
			OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		uuid = Objects.toString(uuid, "");

		Servizio servizio = findByPrimaryKey(servizioId);

		Session session = null;

		try {
			session = openSession();

			Servizio[] array = new ServizioImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, servizio, uuid, orderByComparator, true);

			array[1] = servizio;

			array[2] = getByUuid_PrevAndNext(
				session, servizio, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Servizio getByUuid_PrevAndNext(
		Session session, Servizio servizio, String uuid,
		OrderByComparator<Servizio> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVIZIO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(ServizioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(servizio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Servizio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Servizio servizio :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizios
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVIZIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"servizio.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(servizio.uuid IS NULL OR servizio.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUUID_G(String uuid, long groupId)
		throws NoSuchServizioException {

		Servizio servizio = fetchByUUID_G(uuid, groupId);

		if (servizio == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchServizioException(sb.toString());
		}

		return servizio;
	}

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the servizio where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof Servizio) {
			Servizio servizio = (Servizio)result;

			if (!Objects.equals(uuid, servizio.getUuid()) ||
				(groupId != servizio.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SERVIZIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Servizio> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Servizio servizio = list.get(0);

					result = servizio;

					cacheResult(servizio);
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
			return (Servizio)result;
		}
	}

	/**
	 * Removes the servizio where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the servizio that was removed
	 */
	@Override
	public Servizio removeByUUID_G(String uuid, long groupId)
		throws NoSuchServizioException {

		Servizio servizio = findByUUID_G(uuid, groupId);

		return remove(servizio);
	}

	/**
	 * Returns the number of servizios where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servizios
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVIZIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"servizio.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(servizio.uuid IS NULL OR servizio.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"servizio.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servizios
	 */
	@Override
	public List<Servizio> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Servizio> list = null;

		if (useFinderCache) {
			list = (List<Servizio>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Servizio servizio : list) {
					if (!uuid.equals(servizio.getUuid()) ||
						(companyId != servizio.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SERVIZIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServizioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Servizio>)QueryUtil.list(
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
	 * Returns the first servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchServizioException(sb.toString());
	}

	/**
	 * Returns the first servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Servizio> orderByComparator) {

		List<Servizio> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchServizioException(sb.toString());
	}

	/**
	 * Returns the last servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Servizio> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Servizio> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio[] findByUuid_C_PrevAndNext(
			long servizioId, String uuid, long companyId,
			OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		uuid = Objects.toString(uuid, "");

		Servizio servizio = findByPrimaryKey(servizioId);

		Session session = null;

		try {
			session = openSession();

			Servizio[] array = new ServizioImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, servizio, uuid, companyId, orderByComparator, true);

			array[1] = servizio;

			array[2] = getByUuid_C_PrevAndNext(
				session, servizio, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Servizio getByUuid_C_PrevAndNext(
		Session session, Servizio servizio, String uuid, long companyId,
		OrderByComparator<Servizio> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SERVIZIO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(ServizioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(servizio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Servizio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizios where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Servizio servizio :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servizios
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVIZIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"servizio.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(servizio.uuid IS NULL OR servizio.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"servizio.companyId = ?";

	private FinderPath _finderPathFetchByCodice;
	private FinderPath _finderPathCountByCodice;

	/**
	 * Returns the servizio where codice = &#63; or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByCodice(String codice) throws NoSuchServizioException {
		Servizio servizio = fetchByCodice(codice);

		if (servizio == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codice=");
			sb.append(codice);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchServizioException(sb.toString());
		}

		return servizio;
	}

	/**
	 * Returns the servizio where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByCodice(String codice) {
		return fetchByCodice(codice, true);
	}

	/**
	 * Returns the servizio where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByCodice(String codice, boolean useFinderCache) {
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

		if (result instanceof Servizio) {
			Servizio servizio = (Servizio)result;

			if (!Objects.equals(codice, servizio.getCodice())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SERVIZIO_WHERE);

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

				List<Servizio> list = query.list();

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
								"ServizioPersistenceImpl.fetchByCodice(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Servizio servizio = list.get(0);

					result = servizio;

					cacheResult(servizio);
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
			return (Servizio)result;
		}
	}

	/**
	 * Removes the servizio where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the servizio that was removed
	 */
	@Override
	public Servizio removeByCodice(String codice)
		throws NoSuchServizioException {

		Servizio servizio = findByCodice(codice);

		return remove(servizio);
	}

	/**
	 * Returns the number of servizios where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching servizios
	 */
	@Override
	public int countByCodice(String codice) {
		codice = Objects.toString(codice, "");

		FinderPath finderPath = _finderPathCountByCodice;

		Object[] finderArgs = new Object[] {codice};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVIZIO_WHERE);

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
		"servizio.codice = ?";

	private static final String _FINDER_COLUMN_CODICE_CODICE_3 =
		"(servizio.codice IS NULL OR servizio.codice = '')";

	private FinderPath _finderPathWithPaginationFindByAttivo;
	private FinderPath _finderPathWithoutPaginationFindByAttivo;
	private FinderPath _finderPathCountByAttivo;

	/**
	 * Returns all the servizios where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching servizios
	 */
	@Override
	public List<Servizio> findByAttivo(boolean attivo) {
		return findByAttivo(attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of matching servizios
	 */
	@Override
	public List<Servizio> findByAttivo(boolean attivo, int start, int end) {
		return findByAttivo(attivo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return findByAttivo(attivo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizios
	 */
	@Override
	public List<Servizio> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Servizio> orderByComparator, boolean useFinderCache) {

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

		List<Servizio> list = null;

		if (useFinderCache) {
			list = (List<Servizio>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Servizio servizio : list) {
					if (attivo != servizio.isAttivo()) {
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

			sb.append(_SQL_SELECT_SERVIZIO_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServizioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

				list = (List<Servizio>)QueryUtil.list(
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
	 * Returns the first servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByAttivo_First(
			boolean attivo, OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = fetchByAttivo_First(attivo, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchServizioException(sb.toString());
	}

	/**
	 * Returns the first servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByAttivo_First(
		boolean attivo, OrderByComparator<Servizio> orderByComparator) {

		List<Servizio> list = findByAttivo(attivo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio
	 * @throws NoSuchServizioException if a matching servizio could not be found
	 */
	@Override
	public Servizio findByAttivo_Last(
			boolean attivo, OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = fetchByAttivo_Last(attivo, orderByComparator);

		if (servizio != null) {
			return servizio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchServizioException(sb.toString());
	}

	/**
	 * Returns the last servizio in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio, or <code>null</code> if a matching servizio could not be found
	 */
	@Override
	public Servizio fetchByAttivo_Last(
		boolean attivo, OrderByComparator<Servizio> orderByComparator) {

		int count = countByAttivo(attivo);

		if (count == 0) {
			return null;
		}

		List<Servizio> list = findByAttivo(
			attivo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizios before and after the current servizio in the ordered set where attivo = &#63;.
	 *
	 * @param servizioId the primary key of the current servizio
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio[] findByAttivo_PrevAndNext(
			long servizioId, boolean attivo,
			OrderByComparator<Servizio> orderByComparator)
		throws NoSuchServizioException {

		Servizio servizio = findByPrimaryKey(servizioId);

		Session session = null;

		try {
			session = openSession();

			Servizio[] array = new ServizioImpl[3];

			array[0] = getByAttivo_PrevAndNext(
				session, servizio, attivo, orderByComparator, true);

			array[1] = servizio;

			array[2] = getByAttivo_PrevAndNext(
				session, servizio, attivo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Servizio getByAttivo_PrevAndNext(
		Session session, Servizio servizio, boolean attivo,
		OrderByComparator<Servizio> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVIZIO_WHERE);

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
			sb.append(ServizioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(attivo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(servizio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Servizio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizios where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	@Override
	public void removeByAttivo(boolean attivo) {
		for (Servizio servizio :
				findByAttivo(
					attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching servizios
	 */
	@Override
	public int countByAttivo(boolean attivo) {
		FinderPath finderPath = _finderPathCountByAttivo;

		Object[] finderArgs = new Object[] {attivo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVIZIO_WHERE);

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
		"servizio.attivo = ?";

	public ServizioPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Servizio.class);

		setModelImplClass(ServizioImpl.class);
		setModelPKClass(long.class);

		setTable(ServizioTable.INSTANCE);
	}

	/**
	 * Caches the servizio in the entity cache if it is enabled.
	 *
	 * @param servizio the servizio
	 */
	@Override
	public void cacheResult(Servizio servizio) {
		entityCache.putResult(
			ServizioImpl.class, servizio.getPrimaryKey(), servizio);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {servizio.getUuid(), servizio.getGroupId()}, servizio);

		finderCache.putResult(
			_finderPathFetchByCodice, new Object[] {servizio.getCodice()},
			servizio);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the servizios in the entity cache if it is enabled.
	 *
	 * @param servizios the servizios
	 */
	@Override
	public void cacheResult(List<Servizio> servizios) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (servizios.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Servizio servizio : servizios) {
			if (entityCache.getResult(
					ServizioImpl.class, servizio.getPrimaryKey()) == null) {

				cacheResult(servizio);
			}
		}
	}

	/**
	 * Clears the cache for all servizios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServizioImpl.class);

		finderCache.clearCache(ServizioImpl.class);
	}

	/**
	 * Clears the cache for the servizio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Servizio servizio) {
		entityCache.removeResult(ServizioImpl.class, servizio);
	}

	@Override
	public void clearCache(List<Servizio> servizios) {
		for (Servizio servizio : servizios) {
			entityCache.removeResult(ServizioImpl.class, servizio);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ServizioImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ServizioImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ServizioModelImpl servizioModelImpl) {

		Object[] args = new Object[] {
			servizioModelImpl.getUuid(), servizioModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, servizioModelImpl);

		args = new Object[] {servizioModelImpl.getCodice()};

		finderCache.putResult(_finderPathCountByCodice, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodice, args, servizioModelImpl);
	}

	/**
	 * Creates a new servizio with the primary key. Does not add the servizio to the database.
	 *
	 * @param servizioId the primary key for the new servizio
	 * @return the new servizio
	 */
	@Override
	public Servizio create(long servizioId) {
		Servizio servizio = new ServizioImpl();

		servizio.setNew(true);
		servizio.setPrimaryKey(servizioId);

		String uuid = PortalUUIDUtil.generate();

		servizio.setUuid(uuid);

		servizio.setCompanyId(CompanyThreadLocal.getCompanyId());

		return servizio;
	}

	/**
	 * Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio remove(long servizioId) throws NoSuchServizioException {
		return remove((Serializable)servizioId);
	}

	/**
	 * Removes the servizio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the servizio
	 * @return the servizio that was removed
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio remove(Serializable primaryKey)
		throws NoSuchServizioException {

		Session session = null;

		try {
			session = openSession();

			Servizio servizio = (Servizio)session.get(
				ServizioImpl.class, primaryKey);

			if (servizio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServizioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(servizio);
		}
		catch (NoSuchServizioException noSuchEntityException) {
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
	protected Servizio removeImpl(Servizio servizio) {
		servizioToTipologiaTableMapper.deleteLeftPrimaryKeyTableMappings(
			servizio.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(servizio)) {
				servizio = (Servizio)session.get(
					ServizioImpl.class, servizio.getPrimaryKeyObj());
			}

			if (servizio != null) {
				session.delete(servizio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (servizio != null) {
			clearCache(servizio);
		}

		return servizio;
	}

	@Override
	public Servizio updateImpl(Servizio servizio) {
		boolean isNew = servizio.isNew();

		if (!(servizio instanceof ServizioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(servizio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(servizio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in servizio proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Servizio implementation " +
					servizio.getClass());
		}

		ServizioModelImpl servizioModelImpl = (ServizioModelImpl)servizio;

		if (Validator.isNull(servizio.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			servizio.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (servizio.getCreateDate() == null)) {
			if (serviceContext == null) {
				servizio.setCreateDate(date);
			}
			else {
				servizio.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!servizioModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				servizio.setModifiedDate(date);
			}
			else {
				servizio.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(servizio);
			}
			else {
				servizio = (Servizio)session.merge(servizio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServizioImpl.class, servizioModelImpl, false, true);

		cacheUniqueFindersCache(servizioModelImpl);

		if (isNew) {
			servizio.setNew(false);
		}

		servizio.resetOriginalValues();

		return servizio;
	}

	/**
	 * Returns the servizio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio
	 * @return the servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServizioException {

		Servizio servizio = fetchByPrimaryKey(primaryKey);

		if (servizio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServizioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return servizio;
	}

	/**
	 * Returns the servizio with the primary key or throws a <code>NoSuchServizioException</code> if it could not be found.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio
	 * @throws NoSuchServizioException if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio findByPrimaryKey(long servizioId)
		throws NoSuchServizioException {

		return findByPrimaryKey((Serializable)servizioId);
	}

	/**
	 * Returns the servizio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servizioId the primary key of the servizio
	 * @return the servizio, or <code>null</code> if a servizio with the primary key could not be found
	 */
	@Override
	public Servizio fetchByPrimaryKey(long servizioId) {
		return fetchByPrimaryKey((Serializable)servizioId);
	}

	/**
	 * Returns all the servizios.
	 *
	 * @return the servizios
	 */
	@Override
	public List<Servizio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of servizios
	 */
	@Override
	public List<Servizio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizios
	 */
	@Override
	public List<Servizio> findAll(
		int start, int end, OrderByComparator<Servizio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of servizios
	 */
	@Override
	public List<Servizio> findAll(
		int start, int end, OrderByComparator<Servizio> orderByComparator,
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

		List<Servizio> list = null;

		if (useFinderCache) {
			list = (List<Servizio>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVIZIO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVIZIO;

				sql = sql.concat(ServizioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Servizio>)QueryUtil.list(
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
	 * Removes all the servizios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Servizio servizio : findAll()) {
			remove(servizio);
		}
	}

	/**
	 * Returns the number of servizios.
	 *
	 * @return the number of servizios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SERVIZIO);

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

	/**
	 * Returns the primaryKeys of tipologias associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return long[] of the primaryKeys of tipologias associated with the servizio
	 */
	@Override
	public long[] getTipologiaPrimaryKeys(long pk) {
		long[] pks = servizioToTipologiaTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the servizio associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return the servizios associated with the tipologia
	 */
	@Override
	public List<Servizio> getTipologiaServizios(long pk) {
		return getTipologiaServizios(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the servizio associated with the tipologia.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the tipologia
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of servizios associated with the tipologia
	 */
	@Override
	public List<Servizio> getTipologiaServizios(long pk, int start, int end) {
		return getTipologiaServizios(pk, start, end, null);
	}

	/**
	 * Returns all the servizio associated with the tipologia.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the tipologia
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizios associated with the tipologia
	 */
	@Override
	public List<Servizio> getTipologiaServizios(
		long pk, int start, int end,
		OrderByComparator<Servizio> orderByComparator) {

		return servizioToTipologiaTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipologias associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return the number of tipologias associated with the servizio
	 */
	@Override
	public int getTipologiasSize(long pk) {
		long[] pks = servizioToTipologiaTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the tipologia is associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPK the primary key of the tipologia
	 * @return <code>true</code> if the tipologia is associated with the servizio; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTipologia(long pk, long tipologiaPK) {
		return servizioToTipologiaTableMapper.containsTableMapping(
			pk, tipologiaPK);
	}

	/**
	 * Returns <code>true</code> if the servizio has any tipologias associated with it.
	 *
	 * @param pk the primary key of the servizio to check for associations with tipologias
	 * @return <code>true</code> if the servizio has any tipologias associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTipologias(long pk) {
		if (getTipologiasSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPK the primary key of the tipologia
	 */
	@Override
	public void addTipologia(long pk, long tipologiaPK) {
		Servizio servizio = fetchByPrimaryKey(pk);

		if (servizio == null) {
			servizioToTipologiaTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, tipologiaPK);
		}
		else {
			servizioToTipologiaTableMapper.addTableMapping(
				servizio.getCompanyId(), pk, tipologiaPK);
		}
	}

	/**
	 * Adds an association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologia the tipologia
	 */
	@Override
	public void addTipologia(long pk, Tipologia tipologia) {
		Servizio servizio = fetchByPrimaryKey(pk);

		if (servizio == null) {
			servizioToTipologiaTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				tipologia.getPrimaryKey());
		}
		else {
			servizioToTipologiaTableMapper.addTableMapping(
				servizio.getCompanyId(), pk, tipologia.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPKs the primary keys of the tipologias
	 */
	@Override
	public void addTipologias(long pk, long[] tipologiaPKs) {
		long companyId = 0;

		Servizio servizio = fetchByPrimaryKey(pk);

		if (servizio == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = servizio.getCompanyId();
		}

		servizioToTipologiaTableMapper.addTableMappings(
			companyId, pk, tipologiaPKs);
	}

	/**
	 * Adds an association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologias the tipologias
	 */
	@Override
	public void addTipologias(long pk, List<Tipologia> tipologias) {
		addTipologias(
			pk,
			ListUtil.toLongArray(tipologias, Tipologia.TIPOLOGIA_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the servizio and its tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio to clear the associated tipologias from
	 */
	@Override
	public void clearTipologias(long pk) {
		servizioToTipologiaTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPK the primary key of the tipologia
	 */
	@Override
	public void removeTipologia(long pk, long tipologiaPK) {
		servizioToTipologiaTableMapper.deleteTableMapping(pk, tipologiaPK);
	}

	/**
	 * Removes the association between the servizio and the tipologia. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologia the tipologia
	 */
	@Override
	public void removeTipologia(long pk, Tipologia tipologia) {
		servizioToTipologiaTableMapper.deleteTableMapping(
			pk, tipologia.getPrimaryKey());
	}

	/**
	 * Removes the association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPKs the primary keys of the tipologias
	 */
	@Override
	public void removeTipologias(long pk, long[] tipologiaPKs) {
		servizioToTipologiaTableMapper.deleteTableMappings(pk, tipologiaPKs);
	}

	/**
	 * Removes the association between the servizio and the tipologias. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologias the tipologias
	 */
	@Override
	public void removeTipologias(long pk, List<Tipologia> tipologias) {
		removeTipologias(
			pk,
			ListUtil.toLongArray(tipologias, Tipologia.TIPOLOGIA_ID_ACCESSOR));
	}

	/**
	 * Sets the tipologias associated with the servizio, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologiaPKs the primary keys of the tipologias to be associated with the servizio
	 */
	@Override
	public void setTipologias(long pk, long[] tipologiaPKs) {
		Set<Long> newTipologiaPKsSet = SetUtil.fromArray(tipologiaPKs);
		Set<Long> oldTipologiaPKsSet = SetUtil.fromArray(
			servizioToTipologiaTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeTipologiaPKsSet = new HashSet<Long>(oldTipologiaPKsSet);

		removeTipologiaPKsSet.removeAll(newTipologiaPKsSet);

		servizioToTipologiaTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeTipologiaPKsSet));

		newTipologiaPKsSet.removeAll(oldTipologiaPKsSet);

		long companyId = 0;

		Servizio servizio = fetchByPrimaryKey(pk);

		if (servizio == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = servizio.getCompanyId();
		}

		servizioToTipologiaTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newTipologiaPKsSet));
	}

	/**
	 * Sets the tipologias associated with the servizio, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the servizio
	 * @param tipologias the tipologias to be associated with the servizio
	 */
	@Override
	public void setTipologias(long pk, List<Tipologia> tipologias) {
		try {
			long[] tipologiaPKs = new long[tipologias.size()];

			for (int i = 0; i < tipologias.size(); i++) {
				Tipologia tipologia = tipologias.get(i);

				tipologiaPKs[i] = tipologia.getPrimaryKey();
			}

			setTipologias(pk, tipologiaPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "servizioId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVIZIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServizioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the servizio persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		servizioToTipologiaTableMapper = TableMapperFactory.getTableMapper(
			"servizio_tipologia#servizioId", "servizio_tipologia", "companyId",
			"servizioId", "tipologiaId", this, Tipologia.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

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

		_setServizioUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setServizioUtilPersistence(null);

		entityCache.removeCache(ServizioImpl.class.getName());

		TableMapperFactory.removeTableMapper("servizio_tipologia#servizioId");
	}

	private void _setServizioUtilPersistence(
		ServizioPersistence servizioPersistence) {

		try {
			Field field = ServizioUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, servizioPersistence);
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

	protected TableMapper<Servizio, Tipologia> servizioToTipologiaTableMapper;

	private static final String _SQL_SELECT_SERVIZIO =
		"SELECT servizio FROM Servizio servizio";

	private static final String _SQL_SELECT_SERVIZIO_WHERE =
		"SELECT servizio FROM Servizio servizio WHERE ";

	private static final String _SQL_COUNT_SERVIZIO =
		"SELECT COUNT(servizio) FROM Servizio servizio";

	private static final String _SQL_COUNT_SERVIZIO_WHERE =
		"SELECT COUNT(servizio) FROM Servizio servizio WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "servizio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Servizio exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Servizio exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServizioPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ServizioModelArgumentsResolver _servizioModelArgumentsResolver;

}