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

package it.servizidigitali.gestioneprocedure.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.gestioneprocedure.exception.NoSuchProceduraException;
import it.servizidigitali.gestioneprocedure.model.Procedura;
import it.servizidigitali.gestioneprocedure.model.ProceduraTable;
import it.servizidigitali.gestioneprocedure.model.impl.ProceduraImpl;
import it.servizidigitali.gestioneprocedure.model.impl.ProceduraModelImpl;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraPersistence;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraUtil;
import it.servizidigitali.gestioneprocedure.service.persistence.impl.constants.PersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the procedura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProceduraPersistence.class, BasePersistence.class})
public class ProceduraPersistenceImpl
	extends BasePersistenceImpl<Procedura> implements ProceduraPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProceduraUtil</code> to access the procedura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProceduraImpl.class.getName();

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
	 * Returns all the proceduras where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
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

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Procedura procedura : list) {
					if (!uuid.equals(procedura.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

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
				sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
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

				list = (List<Procedura>)QueryUtil.list(
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
	 * Returns the first procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByUuid_First(
			String uuid, OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByUuid_First(uuid, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByUuid_First(
		String uuid, OrderByComparator<Procedura> orderByComparator) {

		List<Procedura> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByUuid_Last(
			String uuid, OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByUuid_Last(uuid, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByUuid_Last(
		String uuid, OrderByComparator<Procedura> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Procedura> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where uuid = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura[] findByUuid_PrevAndNext(
			long proceduraId, String uuid,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		uuid = Objects.toString(uuid, "");

		Procedura procedura = findByPrimaryKey(proceduraId);

		Session session = null;

		try {
			session = openSession();

			Procedura[] array = new ProceduraImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, procedura, uuid, orderByComparator, true);

			array[1] = procedura;

			array[2] = getByUuid_PrevAndNext(
				session, procedura, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procedura getByUuid_PrevAndNext(
		Session session, Procedura procedura, String uuid,
		OrderByComparator<Procedura> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCEDURA_WHERE);

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
			sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(procedura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procedura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduras where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Procedura procedura :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

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
		"procedura.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(procedura.uuid IS NULL OR procedura.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProceduraException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByUUID_G(String uuid, long groupId)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByUUID_G(uuid, groupId);

		if (procedura == null) {
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

			throw new NoSuchProceduraException(sb.toString());
		}

		return procedura;
	}

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procedura where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByUUID_G(
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

		if (result instanceof Procedura) {
			Procedura procedura = (Procedura)result;

			if (!Objects.equals(uuid, procedura.getUuid()) ||
				(groupId != procedura.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

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

				List<Procedura> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Procedura procedura = list.get(0);

					result = procedura;

					cacheResult(procedura);
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
			return (Procedura)result;
		}
	}

	/**
	 * Removes the procedura where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedura that was removed
	 */
	@Override
	public Procedura removeByUUID_G(String uuid, long groupId)
		throws NoSuchProceduraException {

		Procedura procedura = findByUUID_G(uuid, groupId);

		return remove(procedura);
	}

	/**
	 * Returns the number of proceduras where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

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
		"procedura.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(procedura.uuid IS NULL OR procedura.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"procedura.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
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

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Procedura procedura : list) {
					if (!uuid.equals(procedura.getUuid()) ||
						(companyId != procedura.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

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
				sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
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

				list = (List<Procedura>)QueryUtil.list(
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
	 * Returns the first procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the first procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Procedura> orderByComparator) {

		List<Procedura> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the last procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Procedura> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Procedura> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura[] findByUuid_C_PrevAndNext(
			long proceduraId, String uuid, long companyId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		uuid = Objects.toString(uuid, "");

		Procedura procedura = findByPrimaryKey(proceduraId);

		Session session = null;

		try {
			session = openSession();

			Procedura[] array = new ProceduraImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, procedura, uuid, companyId, orderByComparator, true);

			array[1] = procedura;

			array[2] = getByUuid_C_PrevAndNext(
				session, procedura, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procedura getByUuid_C_PrevAndNext(
		Session session, Procedura procedura, String uuid, long companyId,
		OrderByComparator<Procedura> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROCEDURA_WHERE);

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
			sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(procedura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procedura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduras where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Procedura procedura :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

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
		"procedura.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(procedura.uuid IS NULL OR procedura.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"procedura.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAttiva;
	private FinderPath _finderPathWithoutPaginationFindByAttiva;
	private FinderPath _finderPathCountByAttiva;

	/**
	 * Returns all the proceduras where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the matching proceduras
	 */
	@Override
	public List<Procedura> findByAttiva(boolean attiva) {
		return findByAttiva(attiva, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	@Override
	public List<Procedura> findByAttiva(boolean attiva, int start, int end) {
		return findByAttiva(attiva, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return findByAttiva(attiva, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduras where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAttiva;
				finderArgs = new Object[] {attiva};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAttiva;
			finderArgs = new Object[] {attiva, start, end, orderByComparator};
		}

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Procedura procedura : list) {
					if (attiva != procedura.isAttiva()) {
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

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVA_ATTIVA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attiva);

				list = (List<Procedura>)QueryUtil.list(
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
	 * Returns the first procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByAttiva_First(
			boolean attiva, OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByAttiva_First(attiva, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attiva=");
		sb.append(attiva);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the first procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByAttiva_First(
		boolean attiva, OrderByComparator<Procedura> orderByComparator) {

		List<Procedura> list = findByAttiva(attiva, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByAttiva_Last(
			boolean attiva, OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByAttiva_Last(attiva, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attiva=");
		sb.append(attiva);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the last procedura in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByAttiva_Last(
		boolean attiva, OrderByComparator<Procedura> orderByComparator) {

		int count = countByAttiva(attiva);

		if (count == 0) {
			return null;
		}

		List<Procedura> list = findByAttiva(
			attiva, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where attiva = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura[] findByAttiva_PrevAndNext(
			long proceduraId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = findByPrimaryKey(proceduraId);

		Session session = null;

		try {
			session = openSession();

			Procedura[] array = new ProceduraImpl[3];

			array[0] = getByAttiva_PrevAndNext(
				session, procedura, attiva, orderByComparator, true);

			array[1] = procedura;

			array[2] = getByAttiva_PrevAndNext(
				session, procedura, attiva, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procedura getByAttiva_PrevAndNext(
		Session session, Procedura procedura, boolean attiva,
		OrderByComparator<Procedura> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCEDURA_WHERE);

		sb.append(_FINDER_COLUMN_ATTIVA_ATTIVA_2);

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
			sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(attiva);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procedura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procedura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduras where attiva = &#63; from the database.
	 *
	 * @param attiva the attiva
	 */
	@Override
	public void removeByAttiva(boolean attiva) {
		for (Procedura procedura :
				findByAttiva(
					attiva, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByAttiva(boolean attiva) {
		FinderPath finderPath = _finderPathCountByAttiva;

		Object[] finderArgs = new Object[] {attiva};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVA_ATTIVA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attiva);

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

	private static final String _FINDER_COLUMN_ATTIVA_ATTIVA_2 =
		"procedura.attiva = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroupIdServizioIdProcessoId;
	private FinderPath
		_finderPathWithoutPaginationFindByGroupIdServizioIdProcessoId;
	private FinderPath _finderPathCountByGroupIdServizioIdProcessoId;

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @return the matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId) {

		return findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end) {

		return findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdServizioIdProcessoId;
				finderArgs = new Object[] {groupId, servizioId, processoId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroupIdServizioIdProcessoId;
			finderArgs = new Object[] {
				groupId, servizioId, processoId, start, end, orderByComparator
			};
		}

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Procedura procedura : list) {
					if ((groupId != procedura.getGroupId()) ||
						(servizioId != procedura.getServizioId()) ||
						(processoId != procedura.getProcessoId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_SERVIZIOID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_PROCESSOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(servizioId);

				queryPos.add(processoId);

				list = (List<Procedura>)QueryUtil.list(
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
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByGroupIdServizioIdProcessoId_First(
			long groupId, long servizioId, long processoId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByGroupIdServizioIdProcessoId_First(
			groupId, servizioId, processoId, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", servizioId=");
		sb.append(servizioId);

		sb.append(", processoId=");
		sb.append(processoId);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByGroupIdServizioIdProcessoId_First(
		long groupId, long servizioId, long processoId,
		OrderByComparator<Procedura> orderByComparator) {

		List<Procedura> list = findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByGroupIdServizioIdProcessoId_Last(
			long groupId, long servizioId, long processoId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByGroupIdServizioIdProcessoId_Last(
			groupId, servizioId, processoId, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", servizioId=");
		sb.append(servizioId);

		sb.append(", processoId=");
		sb.append(processoId);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByGroupIdServizioIdProcessoId_Last(
		long groupId, long servizioId, long processoId,
		OrderByComparator<Procedura> orderByComparator) {

		int count = countByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId);

		if (count == 0) {
			return null;
		}

		List<Procedura> list = findByGroupIdServizioIdProcessoId(
			groupId, servizioId, processoId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura[] findByGroupIdServizioIdProcessoId_PrevAndNext(
			long proceduraId, long groupId, long servizioId, long processoId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = findByPrimaryKey(proceduraId);

		Session session = null;

		try {
			session = openSession();

			Procedura[] array = new ProceduraImpl[3];

			array[0] = getByGroupIdServizioIdProcessoId_PrevAndNext(
				session, procedura, groupId, servizioId, processoId,
				orderByComparator, true);

			array[1] = procedura;

			array[2] = getByGroupIdServizioIdProcessoId_PrevAndNext(
				session, procedura, groupId, servizioId, processoId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procedura getByGroupIdServizioIdProcessoId_PrevAndNext(
		Session session, Procedura procedura, long groupId, long servizioId,
		long processoId, OrderByComparator<Procedura> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PROCEDURA_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_SERVIZIOID_2);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_PROCESSOID_2);

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
			sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(servizioId);

		queryPos.add(processoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procedura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procedura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 */
	@Override
	public void removeByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId) {

		for (Procedura procedura :
				findByGroupIdServizioIdProcessoId(
					groupId, servizioId, processoId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63; and processoId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param processoId the processo ID
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByGroupIdServizioIdProcessoId(
		long groupId, long servizioId, long processoId) {

		FinderPath finderPath = _finderPathCountByGroupIdServizioIdProcessoId;

		Object[] finderArgs = new Object[] {groupId, servizioId, processoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_SERVIZIOID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_PROCESSOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(servizioId);

				queryPos.add(processoId);

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
		_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_GROUPID_2 =
			"procedura.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_SERVIZIOID_2 =
			"procedura.servizioId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDSERVIZIOIDPROCESSOID_PROCESSOID_2 =
			"procedura.processoId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdServizioId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdServizioId;
	private FinderPath _finderPathCountByGroupIdServizioId;

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @return the matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId) {

		return findByGroupIdServizioId(
			groupId, servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end) {

		return findByGroupIdServizioId(groupId, servizioId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return findByGroupIdServizioId(
			groupId, servizioId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioId(
		long groupId, long servizioId, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdServizioId;
				finderArgs = new Object[] {groupId, servizioId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdServizioId;
			finderArgs = new Object[] {
				groupId, servizioId, start, end, orderByComparator
			};
		}

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Procedura procedura : list) {
					if ((groupId != procedura.getGroupId()) ||
						(servizioId != procedura.getServizioId())) {

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

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOID_SERVIZIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(servizioId);

				list = (List<Procedura>)QueryUtil.list(
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
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByGroupIdServizioId_First(
			long groupId, long servizioId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByGroupIdServizioId_First(
			groupId, servizioId, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByGroupIdServizioId_First(
		long groupId, long servizioId,
		OrderByComparator<Procedura> orderByComparator) {

		List<Procedura> list = findByGroupIdServizioId(
			groupId, servizioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByGroupIdServizioId_Last(
			long groupId, long servizioId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByGroupIdServizioId_Last(
			groupId, servizioId, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByGroupIdServizioId_Last(
		long groupId, long servizioId,
		OrderByComparator<Procedura> orderByComparator) {

		int count = countByGroupIdServizioId(groupId, servizioId);

		if (count == 0) {
			return null;
		}

		List<Procedura> list = findByGroupIdServizioId(
			groupId, servizioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura[] findByGroupIdServizioId_PrevAndNext(
			long proceduraId, long groupId, long servizioId,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = findByPrimaryKey(proceduraId);

		Session session = null;

		try {
			session = openSession();

			Procedura[] array = new ProceduraImpl[3];

			array[0] = getByGroupIdServizioId_PrevAndNext(
				session, procedura, groupId, servizioId, orderByComparator,
				true);

			array[1] = procedura;

			array[2] = getByGroupIdServizioId_PrevAndNext(
				session, procedura, groupId, servizioId, orderByComparator,
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

	protected Procedura getByGroupIdServizioId_PrevAndNext(
		Session session, Procedura procedura, long groupId, long servizioId,
		OrderByComparator<Procedura> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROCEDURA_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOID_SERVIZIOID_2);

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
			sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(servizioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procedura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procedura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 */
	@Override
	public void removeByGroupIdServizioId(long groupId, long servizioId) {
		for (Procedura procedura :
				findByGroupIdServizioId(
					groupId, servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByGroupIdServizioId(long groupId, long servizioId) {
		FinderPath finderPath = _finderPathCountByGroupIdServizioId;

		Object[] finderArgs = new Object[] {groupId, servizioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOID_SERVIZIOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPIDSERVIZIOID_GROUPID_2 =
		"procedura.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDSERVIZIOID_SERVIZIOID_2 =
		"procedura.servizioId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdServizioIdAttiva;
	private FinderPath
		_finderPathWithoutPaginationFindByGroupIdServizioIdAttiva;
	private FinderPath _finderPathCountByGroupIdServizioIdAttiva;

	/**
	 * Returns all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @return the matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva) {

		return findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva, int start, int end) {

		return findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator) {

		return findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduras
	 */
	@Override
	public List<Procedura> findByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva, int start, int end,
		OrderByComparator<Procedura> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdServizioIdAttiva;
				finderArgs = new Object[] {groupId, servizioId, attiva};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdServizioIdAttiva;
			finderArgs = new Object[] {
				groupId, servizioId, attiva, start, end, orderByComparator
			};
		}

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Procedura procedura : list) {
					if ((groupId != procedura.getGroupId()) ||
						(servizioId != procedura.getServizioId()) ||
						(attiva != procedura.isAttiva())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_SERVIZIOID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_ATTIVA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(servizioId);

				queryPos.add(attiva);

				list = (List<Procedura>)QueryUtil.list(
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
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByGroupIdServizioIdAttiva_First(
			long groupId, long servizioId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByGroupIdServizioIdAttiva_First(
			groupId, servizioId, attiva, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", servizioId=");
		sb.append(servizioId);

		sb.append(", attiva=");
		sb.append(attiva);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the first procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByGroupIdServizioIdAttiva_First(
		long groupId, long servizioId, boolean attiva,
		OrderByComparator<Procedura> orderByComparator) {

		List<Procedura> list = findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura
	 * @throws NoSuchProceduraException if a matching procedura could not be found
	 */
	@Override
	public Procedura findByGroupIdServizioIdAttiva_Last(
			long groupId, long servizioId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByGroupIdServizioIdAttiva_Last(
			groupId, servizioId, attiva, orderByComparator);

		if (procedura != null) {
			return procedura;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", servizioId=");
		sb.append(servizioId);

		sb.append(", attiva=");
		sb.append(attiva);

		sb.append("}");

		throw new NoSuchProceduraException(sb.toString());
	}

	/**
	 * Returns the last procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura, or <code>null</code> if a matching procedura could not be found
	 */
	@Override
	public Procedura fetchByGroupIdServizioIdAttiva_Last(
		long groupId, long servizioId, boolean attiva,
		OrderByComparator<Procedura> orderByComparator) {

		int count = countByGroupIdServizioIdAttiva(groupId, servizioId, attiva);

		if (count == 0) {
			return null;
		}

		List<Procedura> list = findByGroupIdServizioIdAttiva(
			groupId, servizioId, attiva, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proceduras before and after the current procedura in the ordered set where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param proceduraId the primary key of the current procedura
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura[] findByGroupIdServizioIdAttiva_PrevAndNext(
			long proceduraId, long groupId, long servizioId, boolean attiva,
			OrderByComparator<Procedura> orderByComparator)
		throws NoSuchProceduraException {

		Procedura procedura = findByPrimaryKey(proceduraId);

		Session session = null;

		try {
			session = openSession();

			Procedura[] array = new ProceduraImpl[3];

			array[0] = getByGroupIdServizioIdAttiva_PrevAndNext(
				session, procedura, groupId, servizioId, attiva,
				orderByComparator, true);

			array[1] = procedura;

			array[2] = getByGroupIdServizioIdAttiva_PrevAndNext(
				session, procedura, groupId, servizioId, attiva,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procedura getByGroupIdServizioIdAttiva_PrevAndNext(
		Session session, Procedura procedura, long groupId, long servizioId,
		boolean attiva, OrderByComparator<Procedura> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PROCEDURA_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_SERVIZIOID_2);

		sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_ATTIVA_2);

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
			sb.append(ProceduraModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(servizioId);

		queryPos.add(attiva);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procedura)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procedura> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 */
	@Override
	public void removeByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva) {

		for (Procedura procedura :
				findByGroupIdServizioIdAttiva(
					groupId, servizioId, attiva, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras where groupId = &#63; and servizioId = &#63; and attiva = &#63;.
	 *
	 * @param groupId the group ID
	 * @param servizioId the servizio ID
	 * @param attiva the attiva
	 * @return the number of matching proceduras
	 */
	@Override
	public int countByGroupIdServizioIdAttiva(
		long groupId, long servizioId, boolean attiva) {

		FinderPath finderPath = _finderPathCountByGroupIdServizioIdAttiva;

		Object[] finderArgs = new Object[] {groupId, servizioId, attiva};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROCEDURA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_SERVIZIOID_2);

			sb.append(_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_ATTIVA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(servizioId);

				queryPos.add(attiva);

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
		_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_GROUPID_2 =
			"procedura.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_SERVIZIOID_2 =
			"procedura.servizioId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPIDSERVIZIOIDATTIVA_ATTIVA_2 =
			"procedura.attiva = ?";

	public ProceduraPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Procedura.class);

		setModelImplClass(ProceduraImpl.class);
		setModelPKClass(long.class);

		setTable(ProceduraTable.INSTANCE);
	}

	/**
	 * Caches the procedura in the entity cache if it is enabled.
	 *
	 * @param procedura the procedura
	 */
	@Override
	public void cacheResult(Procedura procedura) {
		entityCache.putResult(
			ProceduraImpl.class, procedura.getPrimaryKey(), procedura);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {procedura.getUuid(), procedura.getGroupId()},
			procedura);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the proceduras in the entity cache if it is enabled.
	 *
	 * @param proceduras the proceduras
	 */
	@Override
	public void cacheResult(List<Procedura> proceduras) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (proceduras.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Procedura procedura : proceduras) {
			if (entityCache.getResult(
					ProceduraImpl.class, procedura.getPrimaryKey()) == null) {

				cacheResult(procedura);
			}
		}
	}

	/**
	 * Clears the cache for all proceduras.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProceduraImpl.class);

		finderCache.clearCache(ProceduraImpl.class);
	}

	/**
	 * Clears the cache for the procedura.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Procedura procedura) {
		entityCache.removeResult(ProceduraImpl.class, procedura);
	}

	@Override
	public void clearCache(List<Procedura> proceduras) {
		for (Procedura procedura : proceduras) {
			entityCache.removeResult(ProceduraImpl.class, procedura);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProceduraImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProceduraImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProceduraModelImpl proceduraModelImpl) {

		Object[] args = new Object[] {
			proceduraModelImpl.getUuid(), proceduraModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, proceduraModelImpl);
	}

	/**
	 * Creates a new procedura with the primary key. Does not add the procedura to the database.
	 *
	 * @param proceduraId the primary key for the new procedura
	 * @return the new procedura
	 */
	@Override
	public Procedura create(long proceduraId) {
		Procedura procedura = new ProceduraImpl();

		procedura.setNew(true);
		procedura.setPrimaryKey(proceduraId);

		String uuid = PortalUUIDUtil.generate();

		procedura.setUuid(uuid);

		procedura.setCompanyId(CompanyThreadLocal.getCompanyId());

		return procedura;
	}

	/**
	 * Removes the procedura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura that was removed
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura remove(long proceduraId) throws NoSuchProceduraException {
		return remove((Serializable)proceduraId);
	}

	/**
	 * Removes the procedura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procedura
	 * @return the procedura that was removed
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura remove(Serializable primaryKey)
		throws NoSuchProceduraException {

		Session session = null;

		try {
			session = openSession();

			Procedura procedura = (Procedura)session.get(
				ProceduraImpl.class, primaryKey);

			if (procedura == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProceduraException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(procedura);
		}
		catch (NoSuchProceduraException noSuchEntityException) {
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
	protected Procedura removeImpl(Procedura procedura) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procedura)) {
				procedura = (Procedura)session.get(
					ProceduraImpl.class, procedura.getPrimaryKeyObj());
			}

			if (procedura != null) {
				session.delete(procedura);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (procedura != null) {
			clearCache(procedura);
		}

		return procedura;
	}

	@Override
	public Procedura updateImpl(Procedura procedura) {
		boolean isNew = procedura.isNew();

		if (!(procedura instanceof ProceduraModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(procedura.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(procedura);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in procedura proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Procedura implementation " +
					procedura.getClass());
		}

		ProceduraModelImpl proceduraModelImpl = (ProceduraModelImpl)procedura;

		if (Validator.isNull(procedura.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			procedura.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (procedura.getCreateDate() == null)) {
			if (serviceContext == null) {
				procedura.setCreateDate(date);
			}
			else {
				procedura.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!proceduraModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procedura.setModifiedDate(date);
			}
			else {
				procedura.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(procedura);
			}
			else {
				procedura = (Procedura)session.merge(procedura);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProceduraImpl.class, proceduraModelImpl, false, true);

		cacheUniqueFindersCache(proceduraModelImpl);

		if (isNew) {
			procedura.setNew(false);
		}

		procedura.resetOriginalValues();

		return procedura;
	}

	/**
	 * Returns the procedura with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procedura
	 * @return the procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProceduraException {

		Procedura procedura = fetchByPrimaryKey(primaryKey);

		if (procedura == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProceduraException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return procedura;
	}

	/**
	 * Returns the procedura with the primary key or throws a <code>NoSuchProceduraException</code> if it could not be found.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura
	 * @throws NoSuchProceduraException if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura findByPrimaryKey(long proceduraId)
		throws NoSuchProceduraException {

		return findByPrimaryKey((Serializable)proceduraId);
	}

	/**
	 * Returns the procedura with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proceduraId the primary key of the procedura
	 * @return the procedura, or <code>null</code> if a procedura with the primary key could not be found
	 */
	@Override
	public Procedura fetchByPrimaryKey(long proceduraId) {
		return fetchByPrimaryKey((Serializable)proceduraId);
	}

	/**
	 * Returns all the proceduras.
	 *
	 * @return the proceduras
	 */
	@Override
	public List<Procedura> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @return the range of proceduras
	 */
	@Override
	public List<Procedura> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proceduras
	 */
	@Override
	public List<Procedura> findAll(
		int start, int end, OrderByComparator<Procedura> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proceduras.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduras
	 * @param end the upper bound of the range of proceduras (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proceduras
	 */
	@Override
	public List<Procedura> findAll(
		int start, int end, OrderByComparator<Procedura> orderByComparator,
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

		List<Procedura> list = null;

		if (useFinderCache) {
			list = (List<Procedura>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDURA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDURA;

				sql = sql.concat(ProceduraModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Procedura>)QueryUtil.list(
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
	 * Removes all the proceduras from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Procedura procedura : findAll()) {
			remove(procedura);
		}
	}

	/**
	 * Returns the number of proceduras.
	 *
	 * @return the number of proceduras
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROCEDURA);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "proceduraId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDURA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProceduraModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procedura persistence.
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

		_finderPathWithPaginationFindByAttiva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttiva",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"attiva"}, true);

		_finderPathWithoutPaginationFindByAttiva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttiva",
			new String[] {Boolean.class.getName()}, new String[] {"attiva"},
			true);

		_finderPathCountByAttiva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttiva",
			new String[] {Boolean.class.getName()}, new String[] {"attiva"},
			false);

		_finderPathWithPaginationFindByGroupIdServizioIdProcessoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroupIdServizioIdProcessoId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"groupId", "servizioId", "processoId"}, true);

		_finderPathWithoutPaginationFindByGroupIdServizioIdProcessoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroupIdServizioIdProcessoId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"groupId", "servizioId", "processoId"}, true);

		_finderPathCountByGroupIdServizioIdProcessoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdServizioIdProcessoId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "servizioId", "processoId"}, false);

		_finderPathWithPaginationFindByGroupIdServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdServizioId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "servizioId"}, true);

		_finderPathWithoutPaginationFindByGroupIdServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdServizioId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "servizioId"}, true);

		_finderPathCountByGroupIdServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdServizioId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "servizioId"}, false);

		_finderPathWithPaginationFindByGroupIdServizioIdAttiva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdServizioIdAttiva",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId", "servizioId", "attiva"}, true);

		_finderPathWithoutPaginationFindByGroupIdServizioIdAttiva =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroupIdServizioIdAttiva",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Boolean.class.getName()
				},
				new String[] {"groupId", "servizioId", "attiva"}, true);

		_finderPathCountByGroupIdServizioIdAttiva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdServizioIdAttiva",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"groupId", "servizioId", "attiva"}, false);

		_setProceduraUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProceduraUtilPersistence(null);

		entityCache.removeCache(ProceduraImpl.class.getName());
	}

	private void _setProceduraUtilPersistence(
		ProceduraPersistence proceduraPersistence) {

		try {
			Field field = ProceduraUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, proceduraPersistence);
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

	private static final String _SQL_SELECT_PROCEDURA =
		"SELECT procedura FROM Procedura procedura";

	private static final String _SQL_SELECT_PROCEDURA_WHERE =
		"SELECT procedura FROM Procedura procedura WHERE ";

	private static final String _SQL_COUNT_PROCEDURA =
		"SELECT COUNT(procedura) FROM Procedura procedura";

	private static final String _SQL_COUNT_PROCEDURA_WHERE =
		"SELECT COUNT(procedura) FROM Procedura procedura WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "procedura.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Procedura exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Procedura exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProceduraPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProceduraModelArgumentsResolver _proceduraModelArgumentsResolver;

}