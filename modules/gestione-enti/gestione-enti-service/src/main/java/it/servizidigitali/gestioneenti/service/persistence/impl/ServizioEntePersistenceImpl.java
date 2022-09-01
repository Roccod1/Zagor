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

package it.servizidigitali.gestioneenti.service.persistence.impl;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.gestioneenti.exception.NoSuchServizioEnteException;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.model.ServizioEnteTable;
import it.servizidigitali.gestioneenti.model.impl.ServizioEnteImpl;
import it.servizidigitali.gestioneenti.model.impl.ServizioEnteModelImpl;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePersistence;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEnteUtil;
import it.servizidigitali.gestioneenti.service.persistence.impl.constants.PersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the servizio ente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ServizioEntePersistence.class, BasePersistence.class})
public class ServizioEntePersistenceImpl
	extends BasePersistenceImpl<ServizioEnte>
	implements ServizioEntePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServizioEnteUtil</code> to access the servizio ente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServizioEnteImpl.class.getName();

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
	 * Returns all the servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

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

		List<ServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<ServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ServizioEnte servizioEnte : list) {
					if (!uuid.equals(servizioEnte.getUuid())) {
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

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

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
				sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
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

				list = (List<ServizioEnte>)QueryUtil.list(
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
	 * Returns the first servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByUuid_First(
			String uuid, OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByUuid_First(uuid, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByUuid_First(
		String uuid, OrderByComparator<ServizioEnte> orderByComparator) {

		List<ServizioEnte> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByUuid_Last(
			String uuid, OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByUuid_Last(uuid, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByUuid_Last(
		String uuid, OrderByComparator<ServizioEnte> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ServizioEnte> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte[] findByUuid_PrevAndNext(
			ServizioEntePK servizioEntePK, String uuid,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		uuid = Objects.toString(uuid, "");

		ServizioEnte servizioEnte = findByPrimaryKey(servizioEntePK);

		Session session = null;

		try {
			session = openSession();

			ServizioEnte[] array = new ServizioEnteImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, servizioEnte, uuid, orderByComparator, true);

			array[1] = servizioEnte;

			array[2] = getByUuid_PrevAndNext(
				session, servizioEnte, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServizioEnte getByUuid_PrevAndNext(
		Session session, ServizioEnte servizioEnte, String uuid,
		OrderByComparator<ServizioEnte> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

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
			sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(servizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizio entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ServizioEnte servizioEnte :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(servizioEnte);
		}
	}

	/**
	 * Returns the number of servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

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
		"servizioEnte.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(servizioEnte.uuid IS NULL OR servizioEnte.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByUUID_G(String uuid, long groupId)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByUUID_G(uuid, groupId);

		if (servizioEnte == null) {
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

			throw new NoSuchServizioEnteException(sb.toString());
		}

		return servizioEnte;
	}

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByUUID_G(
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

		if (result instanceof ServizioEnte) {
			ServizioEnte servizioEnte = (ServizioEnte)result;

			if (!Objects.equals(uuid, servizioEnte.getUuid()) ||
				(groupId != servizioEnte.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

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

				List<ServizioEnte> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ServizioEnte servizioEnte = list.get(0);

					result = servizioEnte;

					cacheResult(servizioEnte);
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
			return (ServizioEnte)result;
		}
	}

	/**
	 * Removes the servizio ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the servizio ente that was removed
	 */
	@Override
	public ServizioEnte removeByUUID_G(String uuid, long groupId)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = findByUUID_G(uuid, groupId);

		return remove(servizioEnte);
	}

	/**
	 * Returns the number of servizio entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

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
		"servizioEnte.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(servizioEnte.uuid IS NULL OR servizioEnte.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"servizioEnte.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

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

		List<ServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<ServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ServizioEnte servizioEnte : list) {
					if (!uuid.equals(servizioEnte.getUuid()) ||
						(companyId != servizioEnte.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

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
				sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
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

				list = (List<ServizioEnte>)QueryUtil.list(
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
	 * Returns the first servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		List<ServizioEnte> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ServizioEnte> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte[] findByUuid_C_PrevAndNext(
			ServizioEntePK servizioEntePK, String uuid, long companyId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		uuid = Objects.toString(uuid, "");

		ServizioEnte servizioEnte = findByPrimaryKey(servizioEntePK);

		Session session = null;

		try {
			session = openSession();

			ServizioEnte[] array = new ServizioEnteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, servizioEnte, uuid, companyId, orderByComparator,
				true);

			array[1] = servizioEnte;

			array[2] = getByUuid_C_PrevAndNext(
				session, servizioEnte, uuid, companyId, orderByComparator,
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

	protected ServizioEnte getByUuid_C_PrevAndNext(
		Session session, ServizioEnte servizioEnte, String uuid, long companyId,
		OrderByComparator<ServizioEnte> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

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
			sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(servizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizio entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ServizioEnte servizioEnte :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(servizioEnte);
		}
	}

	/**
	 * Returns the number of servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

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
		"servizioEnte.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(servizioEnte.uuid IS NULL OR servizioEnte.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"servizioEnte.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the servizio entes where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio entes where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganizationId;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganizationId;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<ServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<ServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ServizioEnte servizioEnte : list) {
					if (organizationId != servizioEnte.getOrganizationId()) {
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

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<ServizioEnte>)QueryUtil.list(
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
	 * Returns the first servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByOrganizationId_First(
			long organizationId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		List<ServizioEnte> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<ServizioEnte> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<ServizioEnte> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where organizationId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte[] findByOrganizationId_PrevAndNext(
			ServizioEntePK servizioEntePK, long organizationId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = findByPrimaryKey(servizioEntePK);

		Session session = null;

		try {
			session = openSession();

			ServizioEnte[] array = new ServizioEnteImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, servizioEnte, organizationId, orderByComparator, true);

			array[1] = servizioEnte;

			array[2] = getByOrganizationId_PrevAndNext(
				session, servizioEnte, organizationId, orderByComparator,
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

	protected ServizioEnte getByOrganizationId_PrevAndNext(
		Session session, ServizioEnte servizioEnte, long organizationId,
		OrderByComparator<ServizioEnte> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

		sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(servizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizio entes where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (ServizioEnte servizioEnte :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(servizioEnte);
		}
	}

	/**
	 * Returns the number of servizio entes where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 =
		"servizioEnte.id.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByServizioId;
	private FinderPath _finderPathWithoutPaginationFindByServizioId;
	private FinderPath _finderPathCountByServizioId;

	/**
	 * Returns all the servizio entes where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByServizioId(long servizioId) {
		return findByServizioId(
			servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end) {

		return findByServizioId(servizioId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator) {

		return findByServizioId(
			servizioId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio entes where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching servizio entes
	 */
	@Override
	public List<ServizioEnte> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<ServizioEnte> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByServizioId;
				finderArgs = new Object[] {servizioId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByServizioId;
			finderArgs = new Object[] {
				servizioId, start, end, orderByComparator
			};
		}

		List<ServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<ServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ServizioEnte servizioEnte : list) {
					if (servizioId != servizioEnte.getServizioId()) {
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

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

				list = (List<ServizioEnte>)QueryUtil.list(
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
	 * Returns the first servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByServizioId_First(
			long servizioId, OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByServizioId_First(
			servizioId, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByServizioId_First(
		long servizioId, OrderByComparator<ServizioEnte> orderByComparator) {

		List<ServizioEnte> list = findByServizioId(
			servizioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByServizioId_Last(
			long servizioId, OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByServizioId_Last(
			servizioId, orderByComparator);

		if (servizioEnte != null) {
			return servizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByServizioId_Last(
		long servizioId, OrderByComparator<ServizioEnte> orderByComparator) {

		int count = countByServizioId(servizioId);

		if (count == 0) {
			return null;
		}

		List<ServizioEnte> list = findByServizioId(
			servizioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizio entes before and after the current servizio ente in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioEntePK the primary key of the current servizio ente
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte[] findByServizioId_PrevAndNext(
			ServizioEntePK servizioEntePK, long servizioId,
			OrderByComparator<ServizioEnte> orderByComparator)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = findByPrimaryKey(servizioEntePK);

		Session session = null;

		try {
			session = openSession();

			ServizioEnte[] array = new ServizioEnteImpl[3];

			array[0] = getByServizioId_PrevAndNext(
				session, servizioEnte, servizioId, orderByComparator, true);

			array[1] = servizioEnte;

			array[2] = getByServizioId_PrevAndNext(
				session, servizioEnte, servizioId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServizioEnte getByServizioId_PrevAndNext(
		Session session, ServizioEnte servizioEnte, long servizioId,
		OrderByComparator<ServizioEnte> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

		sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

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
			sb.append(ServizioEnteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(servizioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(servizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizio entes where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	@Override
	public void removeByServizioId(long servizioId) {
		for (ServizioEnte servizioEnte :
				findByServizioId(
					servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(servizioEnte);
		}
	}

	/**
	 * Returns the number of servizio entes where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByServizioId(long servizioId) {
		FinderPath finderPath = _finderPathCountByServizioId;

		Object[] finderArgs = new Object[] {servizioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

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

	private static final String _FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2 =
		"servizioEnte.id.servizioId = ?";

	private FinderPath _finderPathFetchByGroupIdPrivateLayoutId;
	private FinderPath _finderPathCountByGroupIdPrivateLayoutId;

	/**
	 * Returns the servizio ente where groupId = &#63; and privateLayoutId = &#63; or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param privateLayoutId the private layout ID
	 * @return the matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByGroupIdPrivateLayoutId(
			long groupId, long privateLayoutId)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByGroupIdPrivateLayoutId(
			groupId, privateLayoutId);

		if (servizioEnte == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", privateLayoutId=");
			sb.append(privateLayoutId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchServizioEnteException(sb.toString());
		}

		return servizioEnte;
	}

	/**
	 * Returns the servizio ente where groupId = &#63; and privateLayoutId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param privateLayoutId the private layout ID
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByGroupIdPrivateLayoutId(
		long groupId, long privateLayoutId) {

		return fetchByGroupIdPrivateLayoutId(groupId, privateLayoutId, true);
	}

	/**
	 * Returns the servizio ente where groupId = &#63; and privateLayoutId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param privateLayoutId the private layout ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByGroupIdPrivateLayoutId(
		long groupId, long privateLayoutId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, privateLayoutId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupIdPrivateLayoutId, finderArgs);
		}

		if (result instanceof ServizioEnte) {
			ServizioEnte servizioEnte = (ServizioEnte)result;

			if ((groupId != servizioEnte.getGroupId()) ||
				(privateLayoutId != servizioEnte.getPrivateLayoutId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDPRIVATELAYOUTID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDPRIVATELAYOUTID_PRIVATELAYOUTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(privateLayoutId);

				List<ServizioEnte> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupIdPrivateLayoutId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, privateLayoutId
								};
							}

							_log.warn(
								"ServizioEntePersistenceImpl.fetchByGroupIdPrivateLayoutId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ServizioEnte servizioEnte = list.get(0);

					result = servizioEnte;

					cacheResult(servizioEnte);
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
			return (ServizioEnte)result;
		}
	}

	/**
	 * Removes the servizio ente where groupId = &#63; and privateLayoutId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param privateLayoutId the private layout ID
	 * @return the servizio ente that was removed
	 */
	@Override
	public ServizioEnte removeByGroupIdPrivateLayoutId(
			long groupId, long privateLayoutId)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = findByGroupIdPrivateLayoutId(
			groupId, privateLayoutId);

		return remove(servizioEnte);
	}

	/**
	 * Returns the number of servizio entes where groupId = &#63; and privateLayoutId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param privateLayoutId the private layout ID
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByGroupIdPrivateLayoutId(
		long groupId, long privateLayoutId) {

		FinderPath finderPath = _finderPathCountByGroupIdPrivateLayoutId;

		Object[] finderArgs = new Object[] {groupId, privateLayoutId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDPRIVATELAYOUTID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDPRIVATELAYOUTID_PRIVATELAYOUTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(privateLayoutId);

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
		_FINDER_COLUMN_GROUPIDPRIVATELAYOUTID_GROUPID_2 =
			"servizioEnte.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDPRIVATELAYOUTID_PRIVATELAYOUTID_2 =
			"servizioEnte.privateLayoutId = ?";

	private FinderPath _finderPathFetchByGroupIdPublicLayoutId;
	private FinderPath _finderPathCountByGroupIdPublicLayoutId;

	/**
	 * Returns the servizio ente where groupId = &#63; and publicLayoutId = &#63; or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param publicLayoutId the public layout ID
	 * @return the matching servizio ente
	 * @throws NoSuchServizioEnteException if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte findByGroupIdPublicLayoutId(
			long groupId, long publicLayoutId)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByGroupIdPublicLayoutId(
			groupId, publicLayoutId);

		if (servizioEnte == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", publicLayoutId=");
			sb.append(publicLayoutId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchServizioEnteException(sb.toString());
		}

		return servizioEnte;
	}

	/**
	 * Returns the servizio ente where groupId = &#63; and publicLayoutId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param publicLayoutId the public layout ID
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByGroupIdPublicLayoutId(
		long groupId, long publicLayoutId) {

		return fetchByGroupIdPublicLayoutId(groupId, publicLayoutId, true);
	}

	/**
	 * Returns the servizio ente where groupId = &#63; and publicLayoutId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param publicLayoutId the public layout ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching servizio ente, or <code>null</code> if a matching servizio ente could not be found
	 */
	@Override
	public ServizioEnte fetchByGroupIdPublicLayoutId(
		long groupId, long publicLayoutId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, publicLayoutId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupIdPublicLayoutId, finderArgs);
		}

		if (result instanceof ServizioEnte) {
			ServizioEnte servizioEnte = (ServizioEnte)result;

			if ((groupId != servizioEnte.getGroupId()) ||
				(publicLayoutId != servizioEnte.getPublicLayoutId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDPUBLICLAYOUTID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDPUBLICLAYOUTID_PUBLICLAYOUTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(publicLayoutId);

				List<ServizioEnte> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupIdPublicLayoutId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, publicLayoutId
								};
							}

							_log.warn(
								"ServizioEntePersistenceImpl.fetchByGroupIdPublicLayoutId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ServizioEnte servizioEnte = list.get(0);

					result = servizioEnte;

					cacheResult(servizioEnte);
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
			return (ServizioEnte)result;
		}
	}

	/**
	 * Removes the servizio ente where groupId = &#63; and publicLayoutId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param publicLayoutId the public layout ID
	 * @return the servizio ente that was removed
	 */
	@Override
	public ServizioEnte removeByGroupIdPublicLayoutId(
			long groupId, long publicLayoutId)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = findByGroupIdPublicLayoutId(
			groupId, publicLayoutId);

		return remove(servizioEnte);
	}

	/**
	 * Returns the number of servizio entes where groupId = &#63; and publicLayoutId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param publicLayoutId the public layout ID
	 * @return the number of matching servizio entes
	 */
	@Override
	public int countByGroupIdPublicLayoutId(long groupId, long publicLayoutId) {
		FinderPath finderPath = _finderPathCountByGroupIdPublicLayoutId;

		Object[] finderArgs = new Object[] {groupId, publicLayoutId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SERVIZIOENTE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDPUBLICLAYOUTID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDPUBLICLAYOUTID_PUBLICLAYOUTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(publicLayoutId);

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

	private static final String _FINDER_COLUMN_GROUPIDPUBLICLAYOUTID_GROUPID_2 =
		"servizioEnte.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDPUBLICLAYOUTID_PUBLICLAYOUTID_2 =
			"servizioEnte.publicLayoutId = ?";

	public ServizioEntePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ServizioEnte.class);

		setModelImplClass(ServizioEnteImpl.class);
		setModelPKClass(ServizioEntePK.class);

		setTable(ServizioEnteTable.INSTANCE);
	}

	/**
	 * Caches the servizio ente in the entity cache if it is enabled.
	 *
	 * @param servizioEnte the servizio ente
	 */
	@Override
	public void cacheResult(ServizioEnte servizioEnte) {
		entityCache.putResult(
			ServizioEnteImpl.class, servizioEnte.getPrimaryKey(), servizioEnte);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {servizioEnte.getUuid(), servizioEnte.getGroupId()},
			servizioEnte);

		finderCache.putResult(
			_finderPathFetchByGroupIdPrivateLayoutId,
			new Object[] {
				servizioEnte.getGroupId(), servizioEnte.getPrivateLayoutId()
			},
			servizioEnte);

		finderCache.putResult(
			_finderPathFetchByGroupIdPublicLayoutId,
			new Object[] {
				servizioEnte.getGroupId(), servizioEnte.getPublicLayoutId()
			},
			servizioEnte);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the servizio entes in the entity cache if it is enabled.
	 *
	 * @param servizioEntes the servizio entes
	 */
	@Override
	public void cacheResult(List<ServizioEnte> servizioEntes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (servizioEntes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ServizioEnte servizioEnte : servizioEntes) {
			if (entityCache.getResult(
					ServizioEnteImpl.class, servizioEnte.getPrimaryKey()) ==
						null) {

				cacheResult(servizioEnte);
			}
		}
	}

	/**
	 * Clears the cache for all servizio entes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServizioEnteImpl.class);

		finderCache.clearCache(ServizioEnteImpl.class);
	}

	/**
	 * Clears the cache for the servizio ente.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServizioEnte servizioEnte) {
		entityCache.removeResult(ServizioEnteImpl.class, servizioEnte);
	}

	@Override
	public void clearCache(List<ServizioEnte> servizioEntes) {
		for (ServizioEnte servizioEnte : servizioEntes) {
			entityCache.removeResult(ServizioEnteImpl.class, servizioEnte);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ServizioEnteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ServizioEnteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ServizioEnteModelImpl servizioEnteModelImpl) {

		Object[] args = new Object[] {
			servizioEnteModelImpl.getUuid(), servizioEnteModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, servizioEnteModelImpl);

		args = new Object[] {
			servizioEnteModelImpl.getGroupId(),
			servizioEnteModelImpl.getPrivateLayoutId()
		};

		finderCache.putResult(
			_finderPathCountByGroupIdPrivateLayoutId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGroupIdPrivateLayoutId, args,
			servizioEnteModelImpl);

		args = new Object[] {
			servizioEnteModelImpl.getGroupId(),
			servizioEnteModelImpl.getPublicLayoutId()
		};

		finderCache.putResult(
			_finderPathCountByGroupIdPublicLayoutId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGroupIdPublicLayoutId, args,
			servizioEnteModelImpl);
	}

	/**
	 * Creates a new servizio ente with the primary key. Does not add the servizio ente to the database.
	 *
	 * @param servizioEntePK the primary key for the new servizio ente
	 * @return the new servizio ente
	 */
	@Override
	public ServizioEnte create(ServizioEntePK servizioEntePK) {
		ServizioEnte servizioEnte = new ServizioEnteImpl();

		servizioEnte.setNew(true);
		servizioEnte.setPrimaryKey(servizioEntePK);

		String uuid = PortalUUIDUtil.generate();

		servizioEnte.setUuid(uuid);

		servizioEnte.setCompanyId(CompanyThreadLocal.getCompanyId());

		return servizioEnte;
	}

	/**
	 * Removes the servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente that was removed
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte remove(ServizioEntePK servizioEntePK)
		throws NoSuchServizioEnteException {

		return remove((Serializable)servizioEntePK);
	}

	/**
	 * Removes the servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the servizio ente
	 * @return the servizio ente that was removed
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte remove(Serializable primaryKey)
		throws NoSuchServizioEnteException {

		Session session = null;

		try {
			session = openSession();

			ServizioEnte servizioEnte = (ServizioEnte)session.get(
				ServizioEnteImpl.class, primaryKey);

			if (servizioEnte == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServizioEnteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(servizioEnte);
		}
		catch (NoSuchServizioEnteException noSuchEntityException) {
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
	protected ServizioEnte removeImpl(ServizioEnte servizioEnte) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(servizioEnte)) {
				servizioEnte = (ServizioEnte)session.get(
					ServizioEnteImpl.class, servizioEnte.getPrimaryKeyObj());
			}

			if (servizioEnte != null) {
				session.delete(servizioEnte);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (servizioEnte != null) {
			clearCache(servizioEnte);
		}

		return servizioEnte;
	}

	@Override
	public ServizioEnte updateImpl(ServizioEnte servizioEnte) {
		boolean isNew = servizioEnte.isNew();

		if (!(servizioEnte instanceof ServizioEnteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(servizioEnte.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					servizioEnte);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in servizioEnte proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServizioEnte implementation " +
					servizioEnte.getClass());
		}

		ServizioEnteModelImpl servizioEnteModelImpl =
			(ServizioEnteModelImpl)servizioEnte;

		if (Validator.isNull(servizioEnte.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			servizioEnte.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (servizioEnte.getCreateDate() == null)) {
			if (serviceContext == null) {
				servizioEnte.setCreateDate(date);
			}
			else {
				servizioEnte.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!servizioEnteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				servizioEnte.setModifiedDate(date);
			}
			else {
				servizioEnte.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(servizioEnte);
			}
			else {
				servizioEnte = (ServizioEnte)session.merge(servizioEnte);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServizioEnteImpl.class, servizioEnteModelImpl, false, true);

		cacheUniqueFindersCache(servizioEnteModelImpl);

		if (isNew) {
			servizioEnte.setNew(false);
		}

		servizioEnte.resetOriginalValues();

		return servizioEnte;
	}

	/**
	 * Returns the servizio ente with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio ente
	 * @return the servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServizioEnteException {

		ServizioEnte servizioEnte = fetchByPrimaryKey(primaryKey);

		if (servizioEnte == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServizioEnteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return servizioEnte;
	}

	/**
	 * Returns the servizio ente with the primary key or throws a <code>NoSuchServizioEnteException</code> if it could not be found.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente
	 * @throws NoSuchServizioEnteException if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte findByPrimaryKey(ServizioEntePK servizioEntePK)
		throws NoSuchServizioEnteException {

		return findByPrimaryKey((Serializable)servizioEntePK);
	}

	/**
	 * Returns the servizio ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servizioEntePK the primary key of the servizio ente
	 * @return the servizio ente, or <code>null</code> if a servizio ente with the primary key could not be found
	 */
	@Override
	public ServizioEnte fetchByPrimaryKey(ServizioEntePK servizioEntePK) {
		return fetchByPrimaryKey((Serializable)servizioEntePK);
	}

	/**
	 * Returns all the servizio entes.
	 *
	 * @return the servizio entes
	 */
	@Override
	public List<ServizioEnte> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @return the range of servizio entes
	 */
	@Override
	public List<ServizioEnte> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizio entes
	 */
	@Override
	public List<ServizioEnte> findAll(
		int start, int end, OrderByComparator<ServizioEnte> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio entes
	 * @param end the upper bound of the range of servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of servizio entes
	 */
	@Override
	public List<ServizioEnte> findAll(
		int start, int end, OrderByComparator<ServizioEnte> orderByComparator,
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

		List<ServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<ServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVIZIOENTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVIZIOENTE;

				sql = sql.concat(ServizioEnteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServizioEnte>)QueryUtil.list(
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
	 * Removes all the servizio entes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServizioEnte servizioEnte : findAll()) {
			remove(servizioEnte);
		}
	}

	/**
	 * Returns the number of servizio entes.
	 *
	 * @return the number of servizio entes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SERVIZIOENTE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "servizioEntePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVIZIOENTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServizioEnteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the servizio ente persistence.
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

		_finderPathWithPaginationFindByOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"organizationId"}, true);

		_finderPathWithoutPaginationFindByOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, true);

		_finderPathCountByOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"organizationId"}, false);

		_finderPathWithPaginationFindByServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServizioId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"servizioId"}, true);

		_finderPathWithoutPaginationFindByServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServizioId",
			new String[] {Long.class.getName()}, new String[] {"servizioId"},
			true);

		_finderPathCountByServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServizioId",
			new String[] {Long.class.getName()}, new String[] {"servizioId"},
			false);

		_finderPathFetchByGroupIdPrivateLayoutId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupIdPrivateLayoutId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "privateLayoutId"}, true);

		_finderPathCountByGroupIdPrivateLayoutId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdPrivateLayoutId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "privateLayoutId"}, false);

		_finderPathFetchByGroupIdPublicLayoutId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupIdPublicLayoutId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "publicLayoutId"}, true);

		_finderPathCountByGroupIdPublicLayoutId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdPublicLayoutId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "publicLayoutId"}, false);

		_setServizioEnteUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setServizioEnteUtilPersistence(null);

		entityCache.removeCache(ServizioEnteImpl.class.getName());
	}

	private void _setServizioEnteUtilPersistence(
		ServizioEntePersistence servizioEntePersistence) {

		try {
			Field field = ServizioEnteUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, servizioEntePersistence);
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

	private static final String _SQL_SELECT_SERVIZIOENTE =
		"SELECT servizioEnte FROM ServizioEnte servizioEnte";

	private static final String _SQL_SELECT_SERVIZIOENTE_WHERE =
		"SELECT servizioEnte FROM ServizioEnte servizioEnte WHERE ";

	private static final String _SQL_COUNT_SERVIZIOENTE =
		"SELECT COUNT(servizioEnte) FROM ServizioEnte servizioEnte";

	private static final String _SQL_COUNT_SERVIZIOENTE_WHERE =
		"SELECT COUNT(servizioEnte) FROM ServizioEnte servizioEnte WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "servizioEnte.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServizioEnte exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServizioEnte exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServizioEntePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"servizioId", "organizationId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ServizioEnteModelArgumentsResolver
		_servizioEnteModelArgumentsResolver;

}