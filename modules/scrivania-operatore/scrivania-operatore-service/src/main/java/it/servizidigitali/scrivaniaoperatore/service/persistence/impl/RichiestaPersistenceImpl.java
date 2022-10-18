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

package it.servizidigitali.scrivaniaoperatore.service.persistence.impl;

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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;
import it.servizidigitali.scrivaniaoperatore.model.RichiestaTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.RichiestaModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.RichiestaUtil;
import it.servizidigitali.scrivaniaoperatore.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {RichiestaPersistence.class, BasePersistence.class})
public class RichiestaPersistenceImpl
	extends BasePersistenceImpl<Richiesta> implements RichiestaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RichiestaUtil</code> to access the richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RichiestaImpl.class.getName();

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
	 * Returns all the richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
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

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (!uuid.equals(richiesta.getUuid())) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

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
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByUuid_First(
			String uuid, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByUuid_First(uuid, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByUuid_First(
		String uuid, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByUuid_Last(
			String uuid, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByUuid_Last(uuid, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByUuid_Last(
		String uuid, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByUuid_PrevAndNext(
			long richiestaId, String uuid,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		uuid = Objects.toString(uuid, "");

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, richiesta, uuid, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByUuid_PrevAndNext(
				session, richiesta, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByUuid_PrevAndNext(
		Session session, Richiesta richiesta, String uuid,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Richiesta richiesta :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

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
		"richiesta.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(richiesta.uuid IS NULL OR richiesta.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByUUID_G(uuid, groupId);

		if (richiesta == null) {
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

			throw new NoSuchRichiestaException(sb.toString());
		}

		return richiesta;
	}

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByUUID_G(
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

		if (result instanceof Richiesta) {
			Richiesta richiesta = (Richiesta)result;

			if (!Objects.equals(uuid, richiesta.getUuid()) ||
				(groupId != richiesta.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

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

				List<Richiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Richiesta richiesta = list.get(0);

					result = richiesta;

					cacheResult(richiesta);
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
			return (Richiesta)result;
		}
	}

	/**
	 * Removes the richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the richiesta that was removed
	 */
	@Override
	public Richiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaException {

		Richiesta richiesta = findByUUID_G(uuid, groupId);

		return remove(richiesta);
	}

	/**
	 * Returns the number of richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

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
		"richiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(richiesta.uuid IS NULL OR richiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"richiesta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
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

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (!uuid.equals(richiesta.getUuid()) ||
						(companyId != richiesta.getCompanyId())) {

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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

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
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Richiesta> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByUuid_C_PrevAndNext(
			long richiestaId, String uuid, long companyId,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		uuid = Objects.toString(uuid, "");

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, richiesta, uuid, companyId, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByUuid_C_PrevAndNext(
				session, richiesta, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByUuid_C_PrevAndNext(
		Session session, Richiesta richiesta, String uuid, long companyId,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Richiesta richiesta :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

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
		"richiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(richiesta.uuid IS NULL OR richiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"richiesta.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCodiceFiscale;
	private FinderPath _finderPathWithoutPaginationFindByCodiceFiscale;
	private FinderPath _finderPathCountByCodiceFiscale;

	/**
	 * Returns all the richiestas where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscale(String codiceFiscale) {
		return findByCodiceFiscale(
			codiceFiscale, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end) {

		return findByCodiceFiscale(codiceFiscale, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByCodiceFiscale(
			codiceFiscale, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		codiceFiscale = Objects.toString(codiceFiscale, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCodiceFiscale;
				finderArgs = new Object[] {codiceFiscale};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodiceFiscale;
			finderArgs = new Object[] {
				codiceFiscale, start, end, orderByComparator
			};
		}

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (!codiceFiscale.equals(richiesta.getCodiceFiscale())) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			boolean bindCodiceFiscale = false;

			if (codiceFiscale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3);
			}
			else {
				bindCodiceFiscale = true;

				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscale) {
					queryPos.add(codiceFiscale);
				}

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByCodiceFiscale_First(
			String codiceFiscale,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByCodiceFiscale_First(
			codiceFiscale, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscale=");
		sb.append(codiceFiscale);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByCodiceFiscale_First(
		String codiceFiscale, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByCodiceFiscale(
			codiceFiscale, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByCodiceFiscale_Last(
			String codiceFiscale,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByCodiceFiscale_Last(
			codiceFiscale, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscale=");
		sb.append(codiceFiscale);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByCodiceFiscale_Last(
		String codiceFiscale, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByCodiceFiscale(codiceFiscale);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByCodiceFiscale(
			codiceFiscale, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByCodiceFiscale_PrevAndNext(
			long richiestaId, String codiceFiscale,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		codiceFiscale = Objects.toString(codiceFiscale, "");

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByCodiceFiscale_PrevAndNext(
				session, richiesta, codiceFiscale, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByCodiceFiscale_PrevAndNext(
				session, richiesta, codiceFiscale, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByCodiceFiscale_PrevAndNext(
		Session session, Richiesta richiesta, String codiceFiscale,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

		boolean bindCodiceFiscale = false;

		if (codiceFiscale.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3);
		}
		else {
			bindCodiceFiscale = true;

			sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2);
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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCodiceFiscale) {
			queryPos.add(codiceFiscale);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where codiceFiscale = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 */
	@Override
	public void removeByCodiceFiscale(String codiceFiscale) {
		for (Richiesta richiesta :
				findByCodiceFiscale(
					codiceFiscale, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByCodiceFiscale(String codiceFiscale) {
		codiceFiscale = Objects.toString(codiceFiscale, "");

		FinderPath finderPath = _finderPathCountByCodiceFiscale;

		Object[] finderArgs = new Object[] {codiceFiscale};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			boolean bindCodiceFiscale = false;

			if (codiceFiscale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3);
			}
			else {
				bindCodiceFiscale = true;

				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscale) {
					queryPos.add(codiceFiscale);
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

	private static final String _FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2 =
		"richiesta.codiceFiscale = ?";

	private static final String _FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3 =
		"(richiesta.codiceFiscale IS NULL OR richiesta.codiceFiscale = '')";

	private FinderPath _finderPathWithPaginationFindByPartitaIva;
	private FinderPath _finderPathWithoutPaginationFindByPartitaIva;
	private FinderPath _finderPathCountByPartitaIva;

	/**
	 * Returns all the richiestas where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByPartitaIva(String partitaIva) {
		return findByPartitaIva(
			partitaIva, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end) {

		return findByPartitaIva(partitaIva, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByPartitaIva(
			partitaIva, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where partitaIva = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param partitaIva the partita iva
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByPartitaIva(
		String partitaIva, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		partitaIva = Objects.toString(partitaIva, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPartitaIva;
				finderArgs = new Object[] {partitaIva};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPartitaIva;
			finderArgs = new Object[] {
				partitaIva, start, end, orderByComparator
			};
		}

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (!partitaIva.equals(richiesta.getPartitaIva())) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			boolean bindPartitaIva = false;

			if (partitaIva.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3);
			}
			else {
				bindPartitaIva = true;

				sb.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPartitaIva) {
					queryPos.add(partitaIva);
				}

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByPartitaIva_First(
			String partitaIva, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByPartitaIva_First(
			partitaIva, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("partitaIva=");
		sb.append(partitaIva);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByPartitaIva_First(
		String partitaIva, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByPartitaIva(
			partitaIva, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByPartitaIva_Last(
			String partitaIva, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByPartitaIva_Last(
			partitaIva, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("partitaIva=");
		sb.append(partitaIva);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByPartitaIva_Last(
		String partitaIva, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByPartitaIva(partitaIva);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByPartitaIva(
			partitaIva, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where partitaIva = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param partitaIva the partita iva
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByPartitaIva_PrevAndNext(
			long richiestaId, String partitaIva,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		partitaIva = Objects.toString(partitaIva, "");

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByPartitaIva_PrevAndNext(
				session, richiesta, partitaIva, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByPartitaIva_PrevAndNext(
				session, richiesta, partitaIva, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByPartitaIva_PrevAndNext(
		Session session, Richiesta richiesta, String partitaIva,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

		boolean bindPartitaIva = false;

		if (partitaIva.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3);
		}
		else {
			bindPartitaIva = true;

			sb.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2);
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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPartitaIva) {
			queryPos.add(partitaIva);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where partitaIva = &#63; from the database.
	 *
	 * @param partitaIva the partita iva
	 */
	@Override
	public void removeByPartitaIva(String partitaIva) {
		for (Richiesta richiesta :
				findByPartitaIva(
					partitaIva, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where partitaIva = &#63;.
	 *
	 * @param partitaIva the partita iva
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByPartitaIva(String partitaIva) {
		partitaIva = Objects.toString(partitaIva, "");

		FinderPath finderPath = _finderPathCountByPartitaIva;

		Object[] finderArgs = new Object[] {partitaIva};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			boolean bindPartitaIva = false;

			if (partitaIva.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3);
			}
			else {
				bindPartitaIva = true;

				sb.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPartitaIva) {
					queryPos.add(partitaIva);
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

	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2 =
		"richiesta.partitaIva = ?";

	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3 =
		"(richiesta.partitaIva IS NULL OR richiesta.partitaIva = '')";

	private FinderPath _finderPathWithPaginationFindByCodiceFiscaleDelegato;
	private FinderPath _finderPathWithoutPaginationFindByCodiceFiscaleDelegato;
	private FinderPath _finderPathCountByCodiceFiscaleDelegato;

	/**
	 * Returns all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato) {

		return findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end) {

		return findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByCodiceFiscaleDelegato(
		String codiceFiscaleDelegato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		codiceFiscaleDelegato = Objects.toString(codiceFiscaleDelegato, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCodiceFiscaleDelegato;
				finderArgs = new Object[] {codiceFiscaleDelegato};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodiceFiscaleDelegato;
			finderArgs = new Object[] {
				codiceFiscaleDelegato, start, end, orderByComparator
			};
		}

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (!codiceFiscaleDelegato.equals(
							richiesta.getCodiceFiscaleDelegato())) {

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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			boolean bindCodiceFiscaleDelegato = false;

			if (codiceFiscaleDelegato.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_3);
			}
			else {
				bindCodiceFiscaleDelegato = true;

				sb.append(
					_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscaleDelegato) {
					queryPos.add(codiceFiscaleDelegato);
				}

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByCodiceFiscaleDelegato_First(
			String codiceFiscaleDelegato,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByCodiceFiscaleDelegato_First(
			codiceFiscaleDelegato, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscaleDelegato=");
		sb.append(codiceFiscaleDelegato);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByCodiceFiscaleDelegato_First(
		String codiceFiscaleDelegato,
		OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByCodiceFiscaleDelegato_Last(
			String codiceFiscaleDelegato,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByCodiceFiscaleDelegato_Last(
			codiceFiscaleDelegato, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscaleDelegato=");
		sb.append(codiceFiscaleDelegato);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByCodiceFiscaleDelegato_Last(
		String codiceFiscaleDelegato,
		OrderByComparator<Richiesta> orderByComparator) {

		int count = countByCodiceFiscaleDelegato(codiceFiscaleDelegato);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByCodiceFiscaleDelegato(
			codiceFiscaleDelegato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where codiceFiscaleDelegato = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByCodiceFiscaleDelegato_PrevAndNext(
			long richiestaId, String codiceFiscaleDelegato,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		codiceFiscaleDelegato = Objects.toString(codiceFiscaleDelegato, "");

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByCodiceFiscaleDelegato_PrevAndNext(
				session, richiesta, codiceFiscaleDelegato, orderByComparator,
				true);

			array[1] = richiesta;

			array[2] = getByCodiceFiscaleDelegato_PrevAndNext(
				session, richiesta, codiceFiscaleDelegato, orderByComparator,
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

	protected Richiesta getByCodiceFiscaleDelegato_PrevAndNext(
		Session session, Richiesta richiesta, String codiceFiscaleDelegato,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

		boolean bindCodiceFiscaleDelegato = false;

		if (codiceFiscaleDelegato.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_3);
		}
		else {
			bindCodiceFiscaleDelegato = true;

			sb.append(
				_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_2);
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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCodiceFiscaleDelegato) {
			queryPos.add(codiceFiscaleDelegato);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where codiceFiscaleDelegato = &#63; from the database.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 */
	@Override
	public void removeByCodiceFiscaleDelegato(String codiceFiscaleDelegato) {
		for (Richiesta richiesta :
				findByCodiceFiscaleDelegato(
					codiceFiscaleDelegato, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where codiceFiscaleDelegato = &#63;.
	 *
	 * @param codiceFiscaleDelegato the codice fiscale delegato
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByCodiceFiscaleDelegato(String codiceFiscaleDelegato) {
		codiceFiscaleDelegato = Objects.toString(codiceFiscaleDelegato, "");

		FinderPath finderPath = _finderPathCountByCodiceFiscaleDelegato;

		Object[] finderArgs = new Object[] {codiceFiscaleDelegato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			boolean bindCodiceFiscaleDelegato = false;

			if (codiceFiscaleDelegato.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_3);
			}
			else {
				bindCodiceFiscaleDelegato = true;

				sb.append(
					_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscaleDelegato) {
					queryPos.add(codiceFiscaleDelegato);
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
		_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_2 =
			"richiesta.codiceFiscaleDelegato = ?";

	private static final String
		_FINDER_COLUMN_CODICEFISCALEDELEGATO_CODICEFISCALEDELEGATO_3 =
			"(richiesta.codiceFiscaleDelegato IS NULL OR richiesta.codiceFiscaleDelegato = '')";

	private FinderPath _finderPathWithPaginationFindByStato;
	private FinderPath _finderPathWithoutPaginationFindByStato;
	private FinderPath _finderPathCountByStato;

	/**
	 * Returns all the richiestas where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByStato(String stato) {
		return findByStato(stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByStato(String stato, int start, int end) {
		return findByStato(stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByStato(
		String stato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByStato(stato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByStato(
		String stato, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		stato = Objects.toString(stato, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStato;
				finderArgs = new Object[] {stato};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStato;
			finderArgs = new Object[] {stato, start, end, orderByComparator};
		}

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (!stato.equals(richiesta.getStato())) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			boolean bindStato = false;

			if (stato.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATO_STATO_3);
			}
			else {
				bindStato = true;

				sb.append(_FINDER_COLUMN_STATO_STATO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStato) {
					queryPos.add(stato);
				}

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByStato_First(
			String stato, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByStato_First(stato, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByStato_First(
		String stato, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByStato(stato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByStato_Last(
			String stato, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByStato_Last(stato, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByStato_Last(
		String stato, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByStato(stato);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByStato(
			stato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where stato = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByStato_PrevAndNext(
			long richiestaId, String stato,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		stato = Objects.toString(stato, "");

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByStato_PrevAndNext(
				session, richiesta, stato, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByStato_PrevAndNext(
				session, richiesta, stato, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByStato_PrevAndNext(
		Session session, Richiesta richiesta, String stato,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

		boolean bindStato = false;

		if (stato.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATO_STATO_3);
		}
		else {
			bindStato = true;

			sb.append(_FINDER_COLUMN_STATO_STATO_2);
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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStato) {
			queryPos.add(stato);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	@Override
	public void removeByStato(String stato) {
		for (Richiesta richiesta :
				findByStato(
					stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByStato(String stato) {
		stato = Objects.toString(stato, "");

		FinderPath finderPath = _finderPathCountByStato;

		Object[] finderArgs = new Object[] {stato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			boolean bindStato = false;

			if (stato.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATO_STATO_3);
			}
			else {
				bindStato = true;

				sb.append(_FINDER_COLUMN_STATO_STATO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStato) {
					queryPos.add(stato);
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

	private static final String _FINDER_COLUMN_STATO_STATO_2 =
		"richiesta.stato = ?";

	private static final String _FINDER_COLUMN_STATO_STATO_3 =
		"(richiesta.stato IS NULL OR richiesta.stato = '')";

	private FinderPath _finderPathWithPaginationFindByInvioGuest;
	private FinderPath _finderPathWithoutPaginationFindByInvioGuest;
	private FinderPath _finderPathCountByInvioGuest;

	/**
	 * Returns all the richiestas where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByInvioGuest(boolean invioGuest) {
		return findByInvioGuest(
			invioGuest, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end) {

		return findByInvioGuest(invioGuest, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByInvioGuest(
			invioGuest, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where invioGuest = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param invioGuest the invio guest
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByInvioGuest(
		boolean invioGuest, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInvioGuest;
				finderArgs = new Object[] {invioGuest};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInvioGuest;
			finderArgs = new Object[] {
				invioGuest, start, end, orderByComparator
			};
		}

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (invioGuest != richiesta.isInvioGuest()) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_INVIOGUEST_INVIOGUEST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(invioGuest);

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByInvioGuest_First(
			boolean invioGuest, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByInvioGuest_First(
			invioGuest, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invioGuest=");
		sb.append(invioGuest);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByInvioGuest_First(
		boolean invioGuest, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByInvioGuest(
			invioGuest, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByInvioGuest_Last(
			boolean invioGuest, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByInvioGuest_Last(
			invioGuest, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invioGuest=");
		sb.append(invioGuest);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByInvioGuest_Last(
		boolean invioGuest, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByInvioGuest(invioGuest);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByInvioGuest(
			invioGuest, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where invioGuest = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param invioGuest the invio guest
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByInvioGuest_PrevAndNext(
			long richiestaId, boolean invioGuest,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByInvioGuest_PrevAndNext(
				session, richiesta, invioGuest, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByInvioGuest_PrevAndNext(
				session, richiesta, invioGuest, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByInvioGuest_PrevAndNext(
		Session session, Richiesta richiesta, boolean invioGuest,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_INVIOGUEST_INVIOGUEST_2);

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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(invioGuest);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where invioGuest = &#63; from the database.
	 *
	 * @param invioGuest the invio guest
	 */
	@Override
	public void removeByInvioGuest(boolean invioGuest) {
		for (Richiesta richiesta :
				findByInvioGuest(
					invioGuest, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where invioGuest = &#63;.
	 *
	 * @param invioGuest the invio guest
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByInvioGuest(boolean invioGuest) {
		FinderPath finderPath = _finderPathCountByInvioGuest;

		Object[] finderArgs = new Object[] {invioGuest};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_INVIOGUEST_INVIOGUEST_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(invioGuest);

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

	private static final String _FINDER_COLUMN_INVIOGUEST_INVIOGUEST_2 =
		"richiesta.invioGuest = ?";

	private FinderPath _finderPathFetchByTokenVisualizzazione;
	private FinderPath _finderPathCountByTokenVisualizzazione;

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByTokenVisualizzazione(String tokenVisualizzazione)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByTokenVisualizzazione(tokenVisualizzazione);

		if (richiesta == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tokenVisualizzazione=");
			sb.append(tokenVisualizzazione);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRichiestaException(sb.toString());
		}

		return richiesta;
	}

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByTokenVisualizzazione(String tokenVisualizzazione) {
		return fetchByTokenVisualizzazione(tokenVisualizzazione, true);
	}

	/**
	 * Returns the richiesta where tokenVisualizzazione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByTokenVisualizzazione(
		String tokenVisualizzazione, boolean useFinderCache) {

		tokenVisualizzazione = Objects.toString(tokenVisualizzazione, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tokenVisualizzazione};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTokenVisualizzazione, finderArgs);
		}

		if (result instanceof Richiesta) {
			Richiesta richiesta = (Richiesta)result;

			if (!Objects.equals(
					tokenVisualizzazione,
					richiesta.getTokenVisualizzazione())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			boolean bindTokenVisualizzazione = false;

			if (tokenVisualizzazione.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TOKENVISUALIZZAZIONE_TOKENVISUALIZZAZIONE_3);
			}
			else {
				bindTokenVisualizzazione = true;

				sb.append(
					_FINDER_COLUMN_TOKENVISUALIZZAZIONE_TOKENVISUALIZZAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTokenVisualizzazione) {
					queryPos.add(tokenVisualizzazione);
				}

				List<Richiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTokenVisualizzazione, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									tokenVisualizzazione
								};
							}

							_log.warn(
								"RichiestaPersistenceImpl.fetchByTokenVisualizzazione(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Richiesta richiesta = list.get(0);

					result = richiesta;

					cacheResult(richiesta);
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
			return (Richiesta)result;
		}
	}

	/**
	 * Removes the richiesta where tokenVisualizzazione = &#63; from the database.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the richiesta that was removed
	 */
	@Override
	public Richiesta removeByTokenVisualizzazione(String tokenVisualizzazione)
		throws NoSuchRichiestaException {

		Richiesta richiesta = findByTokenVisualizzazione(tokenVisualizzazione);

		return remove(richiesta);
	}

	/**
	 * Returns the number of richiestas where tokenVisualizzazione = &#63;.
	 *
	 * @param tokenVisualizzazione the token visualizzazione
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByTokenVisualizzazione(String tokenVisualizzazione) {
		tokenVisualizzazione = Objects.toString(tokenVisualizzazione, "");

		FinderPath finderPath = _finderPathCountByTokenVisualizzazione;

		Object[] finderArgs = new Object[] {tokenVisualizzazione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			boolean bindTokenVisualizzazione = false;

			if (tokenVisualizzazione.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TOKENVISUALIZZAZIONE_TOKENVISUALIZZAZIONE_3);
			}
			else {
				bindTokenVisualizzazione = true;

				sb.append(
					_FINDER_COLUMN_TOKENVISUALIZZAZIONE_TOKENVISUALIZZAZIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTokenVisualizzazione) {
					queryPos.add(tokenVisualizzazione);
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
		_FINDER_COLUMN_TOKENVISUALIZZAZIONE_TOKENVISUALIZZAZIONE_2 =
			"richiesta.tokenVisualizzazione = ?";

	private static final String
		_FINDER_COLUMN_TOKENVISUALIZZAZIONE_TOKENVISUALIZZAZIONE_3 =
			"(richiesta.tokenVisualizzazione IS NULL OR richiesta.tokenVisualizzazione = '')";

	private FinderPath _finderPathWithPaginationFindByProceduraId;
	private FinderPath _finderPathWithoutPaginationFindByProceduraId;
	private FinderPath _finderPathCountByProceduraId;

	/**
	 * Returns all the richiestas where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByProceduraId(long proceduraId) {
		return findByProceduraId(
			proceduraId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end) {

		return findByProceduraId(proceduraId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByProceduraId(
			proceduraId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByProceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProceduraId;
				finderArgs = new Object[] {proceduraId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProceduraId;
			finderArgs = new Object[] {
				proceduraId, start, end, orderByComparator
			};
		}

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (proceduraId != richiesta.getProceduraId()) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByProceduraId_First(
			long proceduraId, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByProceduraId_First(
			proceduraId, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByProceduraId_First(
		long proceduraId, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByProceduraId(
			proceduraId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByProceduraId_Last(
			long proceduraId, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByProceduraId_Last(
			proceduraId, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByProceduraId_Last(
		long proceduraId, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByProceduraId(proceduraId);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByProceduraId(
			proceduraId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where proceduraId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByProceduraId_PrevAndNext(
			long richiestaId, long proceduraId,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByProceduraId_PrevAndNext(
				session, richiesta, proceduraId, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByProceduraId_PrevAndNext(
				session, richiesta, proceduraId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByProceduraId_PrevAndNext(
		Session session, Richiesta richiesta, long proceduraId,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(proceduraId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	@Override
	public void removeByProceduraId(long proceduraId) {
		for (Richiesta richiesta :
				findByProceduraId(
					proceduraId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByProceduraId(long proceduraId) {
		FinderPath finderPath = _finderPathCountByProceduraId;

		Object[] finderArgs = new Object[] {proceduraId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

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

	private static final String _FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2 =
		"richiesta.proceduraId = ?";

	private FinderPath _finderPathWithPaginationFindByServizioId;
	private FinderPath _finderPathWithoutPaginationFindByServizioId;
	private FinderPath _finderPathCountByServizioId;

	/**
	 * Returns all the richiestas where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching richiestas
	 */
	@Override
	public List<Richiesta> findByServizioId(long servizioId) {
		return findByServizioId(
			servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByServizioId(
		long servizioId, int start, int end) {

		return findByServizioId(servizioId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator) {

		return findByServizioId(
			servizioId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiestas
	 */
	@Override
	public List<Richiesta> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<Richiesta> orderByComparator,
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

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Richiesta richiesta : list) {
					if (servizioId != richiesta.getServizioId()) {
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

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Returns the first richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByServizioId_First(
			long servizioId, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByServizioId_First(
			servizioId, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the first richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByServizioId_First(
		long servizioId, OrderByComparator<Richiesta> orderByComparator) {

		List<Richiesta> list = findByServizioId(
			servizioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByServizioId_Last(
			long servizioId, OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByServizioId_Last(
			servizioId, orderByComparator);

		if (richiesta != null) {
			return richiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchRichiestaException(sb.toString());
	}

	/**
	 * Returns the last richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByServizioId_Last(
		long servizioId, OrderByComparator<Richiesta> orderByComparator) {

		int count = countByServizioId(servizioId);

		if (count == 0) {
			return null;
		}

		List<Richiesta> list = findByServizioId(
			servizioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestas before and after the current richiesta in the ordered set where servizioId = &#63;.
	 *
	 * @param richiestaId the primary key of the current richiesta
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta[] findByServizioId_PrevAndNext(
			long richiestaId, long servizioId,
			OrderByComparator<Richiesta> orderByComparator)
		throws NoSuchRichiestaException {

		Richiesta richiesta = findByPrimaryKey(richiestaId);

		Session session = null;

		try {
			session = openSession();

			Richiesta[] array = new RichiestaImpl[3];

			array[0] = getByServizioId_PrevAndNext(
				session, richiesta, servizioId, orderByComparator, true);

			array[1] = richiesta;

			array[2] = getByServizioId_PrevAndNext(
				session, richiesta, servizioId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Richiesta getByServizioId_PrevAndNext(
		Session session, Richiesta richiesta, long servizioId,
		OrderByComparator<Richiesta> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RICHIESTA_WHERE);

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
			sb.append(RichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(servizioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(richiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Richiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestas where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	@Override
	public void removeByServizioId(long servizioId) {
		for (Richiesta richiesta :
				findByServizioId(
					servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByServizioId(long servizioId) {
		FinderPath finderPath = _finderPathCountByServizioId;

		Object[] finderArgs = new Object[] {servizioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

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
		"richiesta.servizioId = ?";

	private FinderPath _finderPathFetchByProcessInstanceId;
	private FinderPath _finderPathCountByProcessInstanceId;

	/**
	 * Returns the richiesta where processInstanceId = &#63; or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the matching richiesta
	 * @throws NoSuchRichiestaException if a matching richiesta could not be found
	 */
	@Override
	public Richiesta findByProcessInstanceId(String processInstanceId)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByProcessInstanceId(processInstanceId);

		if (richiesta == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("processInstanceId=");
			sb.append(processInstanceId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRichiestaException(sb.toString());
		}

		return richiesta;
	}

	/**
	 * Returns the richiesta where processInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByProcessInstanceId(String processInstanceId) {
		return fetchByProcessInstanceId(processInstanceId, true);
	}

	/**
	 * Returns the richiesta where processInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param processInstanceId the process instance ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta, or <code>null</code> if a matching richiesta could not be found
	 */
	@Override
	public Richiesta fetchByProcessInstanceId(
		String processInstanceId, boolean useFinderCache) {

		processInstanceId = Objects.toString(processInstanceId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {processInstanceId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProcessInstanceId, finderArgs);
		}

		if (result instanceof Richiesta) {
			Richiesta richiesta = (Richiesta)result;

			if (!Objects.equals(
					processInstanceId, richiesta.getProcessInstanceId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_RICHIESTA_WHERE);

			boolean bindProcessInstanceId = false;

			if (processInstanceId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROCESSINSTANCEID_PROCESSINSTANCEID_3);
			}
			else {
				bindProcessInstanceId = true;

				sb.append(_FINDER_COLUMN_PROCESSINSTANCEID_PROCESSINSTANCEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcessInstanceId) {
					queryPos.add(processInstanceId);
				}

				List<Richiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProcessInstanceId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {processInstanceId};
							}

							_log.warn(
								"RichiestaPersistenceImpl.fetchByProcessInstanceId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Richiesta richiesta = list.get(0);

					result = richiesta;

					cacheResult(richiesta);
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
			return (Richiesta)result;
		}
	}

	/**
	 * Removes the richiesta where processInstanceId = &#63; from the database.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the richiesta that was removed
	 */
	@Override
	public Richiesta removeByProcessInstanceId(String processInstanceId)
		throws NoSuchRichiestaException {

		Richiesta richiesta = findByProcessInstanceId(processInstanceId);

		return remove(richiesta);
	}

	/**
	 * Returns the number of richiestas where processInstanceId = &#63;.
	 *
	 * @param processInstanceId the process instance ID
	 * @return the number of matching richiestas
	 */
	@Override
	public int countByProcessInstanceId(String processInstanceId) {
		processInstanceId = Objects.toString(processInstanceId, "");

		FinderPath finderPath = _finderPathCountByProcessInstanceId;

		Object[] finderArgs = new Object[] {processInstanceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTA_WHERE);

			boolean bindProcessInstanceId = false;

			if (processInstanceId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROCESSINSTANCEID_PROCESSINSTANCEID_3);
			}
			else {
				bindProcessInstanceId = true;

				sb.append(_FINDER_COLUMN_PROCESSINSTANCEID_PROCESSINSTANCEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProcessInstanceId) {
					queryPos.add(processInstanceId);
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
		_FINDER_COLUMN_PROCESSINSTANCEID_PROCESSINSTANCEID_2 =
			"richiesta.processInstanceId = ?";

	private static final String
		_FINDER_COLUMN_PROCESSINSTANCEID_PROCESSINSTANCEID_3 =
			"(richiesta.processInstanceId IS NULL OR richiesta.processInstanceId = '')";

	public RichiestaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Richiesta.class);

		setModelImplClass(RichiestaImpl.class);
		setModelPKClass(long.class);

		setTable(RichiestaTable.INSTANCE);
	}

	/**
	 * Caches the richiesta in the entity cache if it is enabled.
	 *
	 * @param richiesta the richiesta
	 */
	@Override
	public void cacheResult(Richiesta richiesta) {
		entityCache.putResult(
			RichiestaImpl.class, richiesta.getPrimaryKey(), richiesta);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {richiesta.getUuid(), richiesta.getGroupId()},
			richiesta);

		finderCache.putResult(
			_finderPathFetchByTokenVisualizzazione,
			new Object[] {richiesta.getTokenVisualizzazione()}, richiesta);

		finderCache.putResult(
			_finderPathFetchByProcessInstanceId,
			new Object[] {richiesta.getProcessInstanceId()}, richiesta);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the richiestas in the entity cache if it is enabled.
	 *
	 * @param richiestas the richiestas
	 */
	@Override
	public void cacheResult(List<Richiesta> richiestas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (richiestas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Richiesta richiesta : richiestas) {
			if (entityCache.getResult(
					RichiestaImpl.class, richiesta.getPrimaryKey()) == null) {

				cacheResult(richiesta);
			}
		}
	}

	/**
	 * Clears the cache for all richiestas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiestaImpl.class);

		finderCache.clearCache(RichiestaImpl.class);
	}

	/**
	 * Clears the cache for the richiesta.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Richiesta richiesta) {
		entityCache.removeResult(RichiestaImpl.class, richiesta);
	}

	@Override
	public void clearCache(List<Richiesta> richiestas) {
		for (Richiesta richiesta : richiestas) {
			entityCache.removeResult(RichiestaImpl.class, richiesta);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RichiestaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RichiestaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RichiestaModelImpl richiestaModelImpl) {

		Object[] args = new Object[] {
			richiestaModelImpl.getUuid(), richiestaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, richiestaModelImpl);

		args = new Object[] {richiestaModelImpl.getTokenVisualizzazione()};

		finderCache.putResult(
			_finderPathCountByTokenVisualizzazione, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTokenVisualizzazione, args, richiestaModelImpl);

		args = new Object[] {richiestaModelImpl.getProcessInstanceId()};

		finderCache.putResult(
			_finderPathCountByProcessInstanceId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProcessInstanceId, args, richiestaModelImpl);
	}

	/**
	 * Creates a new richiesta with the primary key. Does not add the richiesta to the database.
	 *
	 * @param richiestaId the primary key for the new richiesta
	 * @return the new richiesta
	 */
	@Override
	public Richiesta create(long richiestaId) {
		Richiesta richiesta = new RichiestaImpl();

		richiesta.setNew(true);
		richiesta.setPrimaryKey(richiestaId);

		String uuid = PortalUUIDUtil.generate();

		richiesta.setUuid(uuid);

		richiesta.setCompanyId(CompanyThreadLocal.getCompanyId());

		return richiesta;
	}

	/**
	 * Removes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta remove(long richiestaId) throws NoSuchRichiestaException {
		return remove((Serializable)richiestaId);
	}

	/**
	 * Removes the richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta
	 * @return the richiesta that was removed
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta remove(Serializable primaryKey)
		throws NoSuchRichiestaException {

		Session session = null;

		try {
			session = openSession();

			Richiesta richiesta = (Richiesta)session.get(
				RichiestaImpl.class, primaryKey);

			if (richiesta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiestaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(richiesta);
		}
		catch (NoSuchRichiestaException noSuchEntityException) {
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
	protected Richiesta removeImpl(Richiesta richiesta) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiesta)) {
				richiesta = (Richiesta)session.get(
					RichiestaImpl.class, richiesta.getPrimaryKeyObj());
			}

			if (richiesta != null) {
				session.delete(richiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (richiesta != null) {
			clearCache(richiesta);
		}

		return richiesta;
	}

	@Override
	public Richiesta updateImpl(Richiesta richiesta) {
		boolean isNew = richiesta.isNew();

		if (!(richiesta instanceof RichiestaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(richiesta.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(richiesta);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in richiesta proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Richiesta implementation " +
					richiesta.getClass());
		}

		RichiestaModelImpl richiestaModelImpl = (RichiestaModelImpl)richiesta;

		if (Validator.isNull(richiesta.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			richiesta.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (richiesta.getCreateDate() == null)) {
			if (serviceContext == null) {
				richiesta.setCreateDate(date);
			}
			else {
				richiesta.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!richiestaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				richiesta.setModifiedDate(date);
			}
			else {
				richiesta.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(richiesta);
			}
			else {
				richiesta = (Richiesta)session.merge(richiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RichiestaImpl.class, richiestaModelImpl, false, true);

		cacheUniqueFindersCache(richiestaModelImpl);

		if (isNew) {
			richiesta.setNew(false);
		}

		richiesta.resetOriginalValues();

		return richiesta;
	}

	/**
	 * Returns the richiesta with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta
	 * @return the richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiestaException {

		Richiesta richiesta = fetchByPrimaryKey(primaryKey);

		if (richiesta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiestaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return richiesta;
	}

	/**
	 * Returns the richiesta with the primary key or throws a <code>NoSuchRichiestaException</code> if it could not be found.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta
	 * @throws NoSuchRichiestaException if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta findByPrimaryKey(long richiestaId)
		throws NoSuchRichiestaException {

		return findByPrimaryKey((Serializable)richiestaId);
	}

	/**
	 * Returns the richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param richiestaId the primary key of the richiesta
	 * @return the richiesta, or <code>null</code> if a richiesta with the primary key could not be found
	 */
	@Override
	public Richiesta fetchByPrimaryKey(long richiestaId) {
		return fetchByPrimaryKey((Serializable)richiestaId);
	}

	/**
	 * Returns all the richiestas.
	 *
	 * @return the richiestas
	 */
	@Override
	public List<Richiesta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @return the range of richiestas
	 */
	@Override
	public List<Richiesta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiestas
	 */
	@Override
	public List<Richiesta> findAll(
		int start, int end, OrderByComparator<Richiesta> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestas
	 * @param end the upper bound of the range of richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of richiestas
	 */
	@Override
	public List<Richiesta> findAll(
		int start, int end, OrderByComparator<Richiesta> orderByComparator,
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

		List<Richiesta> list = null;

		if (useFinderCache) {
			list = (List<Richiesta>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RICHIESTA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTA;

				sql = sql.concat(RichiestaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Richiesta>)QueryUtil.list(
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
	 * Removes all the richiestas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Richiesta richiesta : findAll()) {
			remove(richiesta);
		}
	}

	/**
	 * Returns the number of richiestas.
	 *
	 * @return the number of richiestas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RICHIESTA);

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
		return "richiestaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RICHIESTA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RichiestaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta persistence.
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

		_finderPathWithPaginationFindByCodiceFiscale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodiceFiscale",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"codiceFiscale"}, true);

		_finderPathWithoutPaginationFindByCodiceFiscale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodiceFiscale",
			new String[] {String.class.getName()},
			new String[] {"codiceFiscale"}, true);

		_finderPathCountByCodiceFiscale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceFiscale",
			new String[] {String.class.getName()},
			new String[] {"codiceFiscale"}, false);

		_finderPathWithPaginationFindByPartitaIva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPartitaIva",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"partitaIva"}, true);

		_finderPathWithoutPaginationFindByPartitaIva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPartitaIva",
			new String[] {String.class.getName()}, new String[] {"partitaIva"},
			true);

		_finderPathCountByPartitaIva = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPartitaIva",
			new String[] {String.class.getName()}, new String[] {"partitaIva"},
			false);

		_finderPathWithPaginationFindByCodiceFiscaleDelegato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCodiceFiscaleDelegato",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"codiceFiscaleDelegato"}, true);

		_finderPathWithoutPaginationFindByCodiceFiscaleDelegato =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCodiceFiscaleDelegato",
				new String[] {String.class.getName()},
				new String[] {"codiceFiscaleDelegato"}, true);

		_finderPathCountByCodiceFiscaleDelegato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCodiceFiscaleDelegato",
			new String[] {String.class.getName()},
			new String[] {"codiceFiscaleDelegato"}, false);

		_finderPathWithPaginationFindByStato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStato",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stato"}, true);

		_finderPathWithoutPaginationFindByStato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStato",
			new String[] {String.class.getName()}, new String[] {"stato"},
			true);

		_finderPathCountByStato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStato",
			new String[] {String.class.getName()}, new String[] {"stato"},
			false);

		_finderPathWithPaginationFindByInvioGuest = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInvioGuest",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"invioGuest"}, true);

		_finderPathWithoutPaginationFindByInvioGuest = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInvioGuest",
			new String[] {Boolean.class.getName()}, new String[] {"invioGuest"},
			true);

		_finderPathCountByInvioGuest = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvioGuest",
			new String[] {Boolean.class.getName()}, new String[] {"invioGuest"},
			false);

		_finderPathFetchByTokenVisualizzazione = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTokenVisualizzazione",
			new String[] {String.class.getName()},
			new String[] {"tokenVisualizzazione"}, true);

		_finderPathCountByTokenVisualizzazione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTokenVisualizzazione",
			new String[] {String.class.getName()},
			new String[] {"tokenVisualizzazione"}, false);

		_finderPathWithPaginationFindByProceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProceduraId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"proceduraId"}, true);

		_finderPathWithoutPaginationFindByProceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProceduraId",
			new String[] {Long.class.getName()}, new String[] {"proceduraId"},
			true);

		_finderPathCountByProceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProceduraId",
			new String[] {Long.class.getName()}, new String[] {"proceduraId"},
			false);

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

		_finderPathFetchByProcessInstanceId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProcessInstanceId",
			new String[] {String.class.getName()},
			new String[] {"processInstanceId"}, true);

		_finderPathCountByProcessInstanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessInstanceId", new String[] {String.class.getName()},
			new String[] {"processInstanceId"}, false);

		_setRichiestaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRichiestaUtilPersistence(null);

		entityCache.removeCache(RichiestaImpl.class.getName());
	}

	private void _setRichiestaUtilPersistence(
		RichiestaPersistence richiestaPersistence) {

		try {
			Field field = RichiestaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, richiestaPersistence);
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

	private static final String _SQL_SELECT_RICHIESTA =
		"SELECT richiesta FROM Richiesta richiesta";

	private static final String _SQL_SELECT_RICHIESTA_WHERE =
		"SELECT richiesta FROM Richiesta richiesta WHERE ";

	private static final String _SQL_COUNT_RICHIESTA =
		"SELECT COUNT(richiesta) FROM Richiesta richiesta";

	private static final String _SQL_COUNT_RICHIESTA_WHERE =
		"SELECT COUNT(richiesta) FROM Richiesta richiesta WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "richiesta.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Richiesta exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Richiesta exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RichiestaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private RichiestaModelArgumentsResolver _richiestaModelArgumentsResolver;

}