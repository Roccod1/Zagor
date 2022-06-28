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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.gestioneservizi.exception.NoSuchAreaTematicaException;
import it.servizidigitali.gestioneservizi.model.AreaTematica;
import it.servizidigitali.gestioneservizi.model.AreaTematicaTable;
import it.servizidigitali.gestioneservizi.model.impl.AreaTematicaImpl;
import it.servizidigitali.gestioneservizi.model.impl.AreaTematicaModelImpl;
import it.servizidigitali.gestioneservizi.service.persistence.AreaTematicaPersistence;
import it.servizidigitali.gestioneservizi.service.persistence.AreaTematicaUtil;
import it.servizidigitali.gestioneservizi.service.persistence.impl.constants.ServiziDigitaliGestioneServiziPersistenceConstants;

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
 * The persistence implementation for the area tematica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AreaTematicaPersistence.class, BasePersistence.class})
public class AreaTematicaPersistenceImpl
	extends BasePersistenceImpl<AreaTematica>
	implements AreaTematicaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AreaTematicaUtil</code> to access the area tematica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AreaTematicaImpl.class.getName();

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
	 * Returns all the area tematicas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator,
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

		List<AreaTematica> list = null;

		if (useFinderCache) {
			list = (List<AreaTematica>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AreaTematica areaTematica : list) {
					if (!uuid.equals(areaTematica.getUuid())) {
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

			sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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
				sb.append(AreaTematicaModelImpl.ORDER_BY_JPQL);
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

				list = (List<AreaTematica>)QueryUtil.list(
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
	 * Returns the first area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByUuid_First(
			String uuid, OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByUuid_First(uuid, orderByComparator);

		if (areaTematica != null) {
			return areaTematica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAreaTematicaException(sb.toString());
	}

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByUuid_First(
		String uuid, OrderByComparator<AreaTematica> orderByComparator) {

		List<AreaTematica> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByUuid_Last(
			String uuid, OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByUuid_Last(uuid, orderByComparator);

		if (areaTematica != null) {
			return areaTematica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAreaTematicaException(sb.toString());
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByUuid_Last(
		String uuid, OrderByComparator<AreaTematica> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AreaTematica> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where uuid = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica[] findByUuid_PrevAndNext(
			long areaTematicaId, String uuid,
			OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		uuid = Objects.toString(uuid, "");

		AreaTematica areaTematica = findByPrimaryKey(areaTematicaId);

		Session session = null;

		try {
			session = openSession();

			AreaTematica[] array = new AreaTematicaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, areaTematica, uuid, orderByComparator, true);

			array[1] = areaTematica;

			array[2] = getByUuid_PrevAndNext(
				session, areaTematica, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AreaTematica getByUuid_PrevAndNext(
		Session session, AreaTematica areaTematica, String uuid,
		OrderByComparator<AreaTematica> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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
			sb.append(AreaTematicaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(areaTematica)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AreaTematica> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the area tematicas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AreaTematica areaTematica :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(areaTematica);
		}
	}

	/**
	 * Returns the number of area tematicas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching area tematicas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AREATEMATICA_WHERE);

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
		"areaTematica.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(areaTematica.uuid IS NULL OR areaTematica.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByUUID_G(String uuid, long groupId)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByUUID_G(uuid, groupId);

		if (areaTematica == null) {
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

			throw new NoSuchAreaTematicaException(sb.toString());
		}

		return areaTematica;
	}

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the area tematica where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByUUID_G(
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

		if (result instanceof AreaTematica) {
			AreaTematica areaTematica = (AreaTematica)result;

			if (!Objects.equals(uuid, areaTematica.getUuid()) ||
				(groupId != areaTematica.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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

				List<AreaTematica> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AreaTematica areaTematica = list.get(0);

					result = areaTematica;

					cacheResult(areaTematica);
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
			return (AreaTematica)result;
		}
	}

	/**
	 * Removes the area tematica where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the area tematica that was removed
	 */
	@Override
	public AreaTematica removeByUUID_G(String uuid, long groupId)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = findByUUID_G(uuid, groupId);

		return remove(areaTematica);
	}

	/**
	 * Returns the number of area tematicas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching area tematicas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AREATEMATICA_WHERE);

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
		"areaTematica.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(areaTematica.uuid IS NULL OR areaTematica.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"areaTematica.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator,
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

		List<AreaTematica> list = null;

		if (useFinderCache) {
			list = (List<AreaTematica>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AreaTematica areaTematica : list) {
					if (!uuid.equals(areaTematica.getUuid()) ||
						(companyId != areaTematica.getCompanyId())) {

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

			sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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
				sb.append(AreaTematicaModelImpl.ORDER_BY_JPQL);
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

				list = (List<AreaTematica>)QueryUtil.list(
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
	 * Returns the first area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (areaTematica != null) {
			return areaTematica;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAreaTematicaException(sb.toString());
	}

	/**
	 * Returns the first area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AreaTematica> orderByComparator) {

		List<AreaTematica> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (areaTematica != null) {
			return areaTematica;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAreaTematicaException(sb.toString());
	}

	/**
	 * Returns the last area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AreaTematica> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AreaTematica> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica[] findByUuid_C_PrevAndNext(
			long areaTematicaId, String uuid, long companyId,
			OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		uuid = Objects.toString(uuid, "");

		AreaTematica areaTematica = findByPrimaryKey(areaTematicaId);

		Session session = null;

		try {
			session = openSession();

			AreaTematica[] array = new AreaTematicaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, areaTematica, uuid, companyId, orderByComparator,
				true);

			array[1] = areaTematica;

			array[2] = getByUuid_C_PrevAndNext(
				session, areaTematica, uuid, companyId, orderByComparator,
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

	protected AreaTematica getByUuid_C_PrevAndNext(
		Session session, AreaTematica areaTematica, String uuid, long companyId,
		OrderByComparator<AreaTematica> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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
			sb.append(AreaTematicaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(areaTematica)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AreaTematica> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the area tematicas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AreaTematica areaTematica :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(areaTematica);
		}
	}

	/**
	 * Returns the number of area tematicas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching area tematicas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AREATEMATICA_WHERE);

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
		"areaTematica.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(areaTematica.uuid IS NULL OR areaTematica.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"areaTematica.companyId = ?";

	private FinderPath _finderPathFetchByCodice;
	private FinderPath _finderPathCountByCodice;

	/**
	 * Returns the area tematica where codice = &#63; or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByCodice(String codice)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByCodice(codice);

		if (areaTematica == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codice=");
			sb.append(codice);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAreaTematicaException(sb.toString());
		}

		return areaTematica;
	}

	/**
	 * Returns the area tematica where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByCodice(String codice) {
		return fetchByCodice(codice, true);
	}

	/**
	 * Returns the area tematica where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByCodice(String codice, boolean useFinderCache) {
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

		if (result instanceof AreaTematica) {
			AreaTematica areaTematica = (AreaTematica)result;

			if (!Objects.equals(codice, areaTematica.getCodice())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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

				List<AreaTematica> list = query.list();

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
								"AreaTematicaPersistenceImpl.fetchByCodice(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AreaTematica areaTematica = list.get(0);

					result = areaTematica;

					cacheResult(areaTematica);
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
			return (AreaTematica)result;
		}
	}

	/**
	 * Removes the area tematica where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the area tematica that was removed
	 */
	@Override
	public AreaTematica removeByCodice(String codice)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = findByCodice(codice);

		return remove(areaTematica);
	}

	/**
	 * Returns the number of area tematicas where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching area tematicas
	 */
	@Override
	public int countByCodice(String codice) {
		codice = Objects.toString(codice, "");

		FinderPath finderPath = _finderPathCountByCodice;

		Object[] finderArgs = new Object[] {codice};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AREATEMATICA_WHERE);

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
		"areaTematica.codice = ?";

	private static final String _FINDER_COLUMN_CODICE_CODICE_3 =
		"(areaTematica.codice IS NULL OR areaTematica.codice = '')";

	private FinderPath _finderPathWithPaginationFindByAttiva;
	private FinderPath _finderPathWithoutPaginationFindByAttiva;
	private FinderPath _finderPathCountByAttiva;

	/**
	 * Returns all the area tematicas where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByAttiva(boolean attiva) {
		return findByAttiva(attiva, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByAttiva(boolean attiva, int start, int end) {
		return findByAttiva(attiva, start, end, null);
	}

	/**
	 * Returns an ordered range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator) {

		return findByAttiva(attiva, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the area tematicas where attiva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param attiva the attiva
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching area tematicas
	 */
	@Override
	public List<AreaTematica> findByAttiva(
		boolean attiva, int start, int end,
		OrderByComparator<AreaTematica> orderByComparator,
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

		List<AreaTematica> list = null;

		if (useFinderCache) {
			list = (List<AreaTematica>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AreaTematica areaTematica : list) {
					if (attiva != areaTematica.isAttiva()) {
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

			sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVA_ATTIVA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AreaTematicaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attiva);

				list = (List<AreaTematica>)QueryUtil.list(
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
	 * Returns the first area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByAttiva_First(
			boolean attiva, OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByAttiva_First(
			attiva, orderByComparator);

		if (areaTematica != null) {
			return areaTematica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attiva=");
		sb.append(attiva);

		sb.append("}");

		throw new NoSuchAreaTematicaException(sb.toString());
	}

	/**
	 * Returns the first area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByAttiva_First(
		boolean attiva, OrderByComparator<AreaTematica> orderByComparator) {

		List<AreaTematica> list = findByAttiva(attiva, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica
	 * @throws NoSuchAreaTematicaException if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica findByAttiva_Last(
			boolean attiva, OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByAttiva_Last(
			attiva, orderByComparator);

		if (areaTematica != null) {
			return areaTematica;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attiva=");
		sb.append(attiva);

		sb.append("}");

		throw new NoSuchAreaTematicaException(sb.toString());
	}

	/**
	 * Returns the last area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area tematica, or <code>null</code> if a matching area tematica could not be found
	 */
	@Override
	public AreaTematica fetchByAttiva_Last(
		boolean attiva, OrderByComparator<AreaTematica> orderByComparator) {

		int count = countByAttiva(attiva);

		if (count == 0) {
			return null;
		}

		List<AreaTematica> list = findByAttiva(
			attiva, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the area tematicas before and after the current area tematica in the ordered set where attiva = &#63;.
	 *
	 * @param areaTematicaId the primary key of the current area tematica
	 * @param attiva the attiva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica[] findByAttiva_PrevAndNext(
			long areaTematicaId, boolean attiva,
			OrderByComparator<AreaTematica> orderByComparator)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = findByPrimaryKey(areaTematicaId);

		Session session = null;

		try {
			session = openSession();

			AreaTematica[] array = new AreaTematicaImpl[3];

			array[0] = getByAttiva_PrevAndNext(
				session, areaTematica, attiva, orderByComparator, true);

			array[1] = areaTematica;

			array[2] = getByAttiva_PrevAndNext(
				session, areaTematica, attiva, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AreaTematica getByAttiva_PrevAndNext(
		Session session, AreaTematica areaTematica, boolean attiva,
		OrderByComparator<AreaTematica> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AREATEMATICA_WHERE);

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
			sb.append(AreaTematicaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(attiva);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(areaTematica)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AreaTematica> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the area tematicas where attiva = &#63; from the database.
	 *
	 * @param attiva the attiva
	 */
	@Override
	public void removeByAttiva(boolean attiva) {
		for (AreaTematica areaTematica :
				findByAttiva(
					attiva, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(areaTematica);
		}
	}

	/**
	 * Returns the number of area tematicas where attiva = &#63;.
	 *
	 * @param attiva the attiva
	 * @return the number of matching area tematicas
	 */
	@Override
	public int countByAttiva(boolean attiva) {
		FinderPath finderPath = _finderPathCountByAttiva;

		Object[] finderArgs = new Object[] {attiva};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AREATEMATICA_WHERE);

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
		"areaTematica.attiva = ?";

	public AreaTematicaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AreaTematica.class);

		setModelImplClass(AreaTematicaImpl.class);
		setModelPKClass(long.class);

		setTable(AreaTematicaTable.INSTANCE);
	}

	/**
	 * Caches the area tematica in the entity cache if it is enabled.
	 *
	 * @param areaTematica the area tematica
	 */
	@Override
	public void cacheResult(AreaTematica areaTematica) {
		entityCache.putResult(
			AreaTematicaImpl.class, areaTematica.getPrimaryKey(), areaTematica);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {areaTematica.getUuid(), areaTematica.getGroupId()},
			areaTematica);

		finderCache.putResult(
			_finderPathFetchByCodice, new Object[] {areaTematica.getCodice()},
			areaTematica);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the area tematicas in the entity cache if it is enabled.
	 *
	 * @param areaTematicas the area tematicas
	 */
	@Override
	public void cacheResult(List<AreaTematica> areaTematicas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (areaTematicas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AreaTematica areaTematica : areaTematicas) {
			if (entityCache.getResult(
					AreaTematicaImpl.class, areaTematica.getPrimaryKey()) ==
						null) {

				cacheResult(areaTematica);
			}
		}
	}

	/**
	 * Clears the cache for all area tematicas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AreaTematicaImpl.class);

		finderCache.clearCache(AreaTematicaImpl.class);
	}

	/**
	 * Clears the cache for the area tematica.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AreaTematica areaTematica) {
		entityCache.removeResult(AreaTematicaImpl.class, areaTematica);
	}

	@Override
	public void clearCache(List<AreaTematica> areaTematicas) {
		for (AreaTematica areaTematica : areaTematicas) {
			entityCache.removeResult(AreaTematicaImpl.class, areaTematica);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AreaTematicaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AreaTematicaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AreaTematicaModelImpl areaTematicaModelImpl) {

		Object[] args = new Object[] {
			areaTematicaModelImpl.getUuid(), areaTematicaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, areaTematicaModelImpl);

		args = new Object[] {areaTematicaModelImpl.getCodice()};

		finderCache.putResult(_finderPathCountByCodice, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodice, args, areaTematicaModelImpl);
	}

	/**
	 * Creates a new area tematica with the primary key. Does not add the area tematica to the database.
	 *
	 * @param areaTematicaId the primary key for the new area tematica
	 * @return the new area tematica
	 */
	@Override
	public AreaTematica create(long areaTematicaId) {
		AreaTematica areaTematica = new AreaTematicaImpl();

		areaTematica.setNew(true);
		areaTematica.setPrimaryKey(areaTematicaId);

		String uuid = PortalUUIDUtil.generate();

		areaTematica.setUuid(uuid);

		areaTematica.setCompanyId(CompanyThreadLocal.getCompanyId());

		return areaTematica;
	}

	/**
	 * Removes the area tematica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica that was removed
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica remove(long areaTematicaId)
		throws NoSuchAreaTematicaException {

		return remove((Serializable)areaTematicaId);
	}

	/**
	 * Removes the area tematica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the area tematica
	 * @return the area tematica that was removed
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica remove(Serializable primaryKey)
		throws NoSuchAreaTematicaException {

		Session session = null;

		try {
			session = openSession();

			AreaTematica areaTematica = (AreaTematica)session.get(
				AreaTematicaImpl.class, primaryKey);

			if (areaTematica == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAreaTematicaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(areaTematica);
		}
		catch (NoSuchAreaTematicaException noSuchEntityException) {
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
	protected AreaTematica removeImpl(AreaTematica areaTematica) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(areaTematica)) {
				areaTematica = (AreaTematica)session.get(
					AreaTematicaImpl.class, areaTematica.getPrimaryKeyObj());
			}

			if (areaTematica != null) {
				session.delete(areaTematica);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (areaTematica != null) {
			clearCache(areaTematica);
		}

		return areaTematica;
	}

	@Override
	public AreaTematica updateImpl(AreaTematica areaTematica) {
		boolean isNew = areaTematica.isNew();

		if (!(areaTematica instanceof AreaTematicaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(areaTematica.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					areaTematica);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in areaTematica proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AreaTematica implementation " +
					areaTematica.getClass());
		}

		AreaTematicaModelImpl areaTematicaModelImpl =
			(AreaTematicaModelImpl)areaTematica;

		if (Validator.isNull(areaTematica.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			areaTematica.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (areaTematica.getCreateDate() == null)) {
			if (serviceContext == null) {
				areaTematica.setCreateDate(date);
			}
			else {
				areaTematica.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!areaTematicaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				areaTematica.setModifiedDate(date);
			}
			else {
				areaTematica.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(areaTematica);
			}
			else {
				areaTematica = (AreaTematica)session.merge(areaTematica);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AreaTematicaImpl.class, areaTematicaModelImpl, false, true);

		cacheUniqueFindersCache(areaTematicaModelImpl);

		if (isNew) {
			areaTematica.setNew(false);
		}

		areaTematica.resetOriginalValues();

		return areaTematica;
	}

	/**
	 * Returns the area tematica with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the area tematica
	 * @return the area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAreaTematicaException {

		AreaTematica areaTematica = fetchByPrimaryKey(primaryKey);

		if (areaTematica == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAreaTematicaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return areaTematica;
	}

	/**
	 * Returns the area tematica with the primary key or throws a <code>NoSuchAreaTematicaException</code> if it could not be found.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica
	 * @throws NoSuchAreaTematicaException if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica findByPrimaryKey(long areaTematicaId)
		throws NoSuchAreaTematicaException {

		return findByPrimaryKey((Serializable)areaTematicaId);
	}

	/**
	 * Returns the area tematica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param areaTematicaId the primary key of the area tematica
	 * @return the area tematica, or <code>null</code> if a area tematica with the primary key could not be found
	 */
	@Override
	public AreaTematica fetchByPrimaryKey(long areaTematicaId) {
		return fetchByPrimaryKey((Serializable)areaTematicaId);
	}

	/**
	 * Returns all the area tematicas.
	 *
	 * @return the area tematicas
	 */
	@Override
	public List<AreaTematica> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @return the range of area tematicas
	 */
	@Override
	public List<AreaTematica> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of area tematicas
	 */
	@Override
	public List<AreaTematica> findAll(
		int start, int end, OrderByComparator<AreaTematica> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the area tematicas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaTematicaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of area tematicas
	 * @param end the upper bound of the range of area tematicas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of area tematicas
	 */
	@Override
	public List<AreaTematica> findAll(
		int start, int end, OrderByComparator<AreaTematica> orderByComparator,
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

		List<AreaTematica> list = null;

		if (useFinderCache) {
			list = (List<AreaTematica>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AREATEMATICA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AREATEMATICA;

				sql = sql.concat(AreaTematicaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AreaTematica>)QueryUtil.list(
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
	 * Removes all the area tematicas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AreaTematica areaTematica : findAll()) {
			remove(areaTematica);
		}
	}

	/**
	 * Returns the number of area tematicas.
	 *
	 * @return the number of area tematicas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AREATEMATICA);

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
		return "areaTematicaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AREATEMATICA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AreaTematicaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the area tematica persistence.
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

		_finderPathFetchByCodice = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodice",
			new String[] {String.class.getName()}, new String[] {"codice"},
			true);

		_finderPathCountByCodice = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodice",
			new String[] {String.class.getName()}, new String[] {"codice"},
			false);

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

		_setAreaTematicaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAreaTematicaUtilPersistence(null);

		entityCache.removeCache(AreaTematicaImpl.class.getName());
	}

	private void _setAreaTematicaUtilPersistence(
		AreaTematicaPersistence areaTematicaPersistence) {

		try {
			Field field = AreaTematicaUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, areaTematicaPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = ServiziDigitaliGestioneServiziPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ServiziDigitaliGestioneServiziPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ServiziDigitaliGestioneServiziPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AREATEMATICA =
		"SELECT areaTematica FROM AreaTematica areaTematica";

	private static final String _SQL_SELECT_AREATEMATICA_WHERE =
		"SELECT areaTematica FROM AreaTematica areaTematica WHERE ";

	private static final String _SQL_COUNT_AREATEMATICA =
		"SELECT COUNT(areaTematica) FROM AreaTematica areaTematica";

	private static final String _SQL_COUNT_AREATEMATICA_WHERE =
		"SELECT COUNT(areaTematica) FROM AreaTematica areaTematica WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "areaTematica.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AreaTematica exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AreaTematica exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AreaTematicaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AreaTematicaModelArgumentsResolver
		_areaTematicaModelArgumentsResolver;

}