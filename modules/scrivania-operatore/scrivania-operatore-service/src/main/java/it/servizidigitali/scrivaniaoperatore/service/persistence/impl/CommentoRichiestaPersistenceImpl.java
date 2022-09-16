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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchCommentoRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.CommentoRichiestaTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.CommentoRichiestaModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.CommentoRichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.CommentoRichiestaUtil;
import it.servizidigitali.scrivaniaoperatore.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the commento richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {CommentoRichiestaPersistence.class, BasePersistence.class}
)
public class CommentoRichiestaPersistenceImpl
	extends BasePersistenceImpl<CommentoRichiesta>
	implements CommentoRichiestaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommentoRichiestaUtil</code> to access the commento richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommentoRichiestaImpl.class.getName();

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
	 * Returns all the commento richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
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

		List<CommentoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<CommentoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentoRichiesta commentoRichiesta : list) {
					if (!uuid.equals(commentoRichiesta.getUuid())) {
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

			sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

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
				sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommentoRichiesta>)QueryUtil.list(
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
	 * Returns the first commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByUuid_First(
			String uuid, OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByUuid_First(
			uuid, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByUuid_First(
		String uuid, OrderByComparator<CommentoRichiesta> orderByComparator) {

		List<CommentoRichiesta> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByUuid_Last(
			String uuid, OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByUuid_Last(
			uuid, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByUuid_Last(
		String uuid, OrderByComparator<CommentoRichiesta> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommentoRichiesta> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta[] findByUuid_PrevAndNext(
			long commentoRichiestaId, String uuid,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		uuid = Objects.toString(uuid, "");

		CommentoRichiesta commentoRichiesta = findByPrimaryKey(
			commentoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			CommentoRichiesta[] array = new CommentoRichiestaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commentoRichiesta, uuid, orderByComparator, true);

			array[1] = commentoRichiesta;

			array[2] = getByUuid_PrevAndNext(
				session, commentoRichiesta, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentoRichiesta getByUuid_PrevAndNext(
		Session session, CommentoRichiesta commentoRichiesta, String uuid,
		OrderByComparator<CommentoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

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
			sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						commentoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commento richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommentoRichiesta commentoRichiesta :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commentoRichiesta);
		}
	}

	/**
	 * Returns the number of commento richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commento richiestas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENTORICHIESTA_WHERE);

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
		"commentoRichiesta.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commentoRichiesta.uuid IS NULL OR commentoRichiesta.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentoRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByUUID_G(uuid, groupId);

		if (commentoRichiesta == null) {
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

			throw new NoSuchCommentoRichiestaException(sb.toString());
		}

		return commentoRichiesta;
	}

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the commento richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByUUID_G(
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

		if (result instanceof CommentoRichiesta) {
			CommentoRichiesta commentoRichiesta = (CommentoRichiesta)result;

			if (!Objects.equals(uuid, commentoRichiesta.getUuid()) ||
				(groupId != commentoRichiesta.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

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

				List<CommentoRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CommentoRichiesta commentoRichiesta = list.get(0);

					result = commentoRichiesta;

					cacheResult(commentoRichiesta);
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
			return (CommentoRichiesta)result;
		}
	}

	/**
	 * Removes the commento richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the commento richiesta that was removed
	 */
	@Override
	public CommentoRichiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = findByUUID_G(uuid, groupId);

		return remove(commentoRichiesta);
	}

	/**
	 * Returns the number of commento richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching commento richiestas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENTORICHIESTA_WHERE);

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
		"commentoRichiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(commentoRichiesta.uuid IS NULL OR commentoRichiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"commentoRichiesta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
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

		List<CommentoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<CommentoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentoRichiesta commentoRichiesta : list) {
					if (!uuid.equals(commentoRichiesta.getUuid()) ||
						(companyId != commentoRichiesta.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

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
				sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommentoRichiesta>)QueryUtil.list(
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
	 * Returns the first commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		List<CommentoRichiesta> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommentoRichiesta> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta[] findByUuid_C_PrevAndNext(
			long commentoRichiestaId, String uuid, long companyId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		uuid = Objects.toString(uuid, "");

		CommentoRichiesta commentoRichiesta = findByPrimaryKey(
			commentoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			CommentoRichiesta[] array = new CommentoRichiestaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commentoRichiesta, uuid, companyId, orderByComparator,
				true);

			array[1] = commentoRichiesta;

			array[2] = getByUuid_C_PrevAndNext(
				session, commentoRichiesta, uuid, companyId, orderByComparator,
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

	protected CommentoRichiesta getByUuid_C_PrevAndNext(
		Session session, CommentoRichiesta commentoRichiesta, String uuid,
		long companyId, OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

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
			sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						commentoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commento richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommentoRichiesta commentoRichiesta :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commentoRichiesta);
		}
	}

	/**
	 * Returns the number of commento richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commento richiestas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENTORICHIESTA_WHERE);

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
		"commentoRichiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commentoRichiesta.uuid IS NULL OR commentoRichiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commentoRichiesta.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRichiestaId;
	private FinderPath _finderPathWithoutPaginationFindByRichiestaId;
	private FinderPath _finderPathCountByRichiestaId;

	/**
	 * Returns all the commento richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaId(long richiestaId) {
		return findByRichiestaId(
			richiestaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end) {

		return findByRichiestaId(richiestaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return findByRichiestaId(
			richiestaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRichiestaId;
				finderArgs = new Object[] {richiestaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRichiestaId;
			finderArgs = new Object[] {
				richiestaId, start, end, orderByComparator
			};
		}

		List<CommentoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<CommentoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentoRichiesta commentoRichiesta : list) {
					if (richiestaId != commentoRichiesta.getRichiestaId()) {
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

			sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				list = (List<CommentoRichiesta>)QueryUtil.list(
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
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByRichiestaId_First(
			long richiestaId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByRichiestaId_First(
			richiestaId, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByRichiestaId_First(
		long richiestaId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		List<CommentoRichiesta> list = findByRichiestaId(
			richiestaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByRichiestaId_Last(
			long richiestaId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByRichiestaId_Last(
			richiestaId, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		int count = countByRichiestaId(richiestaId);

		if (count == 0) {
			return null;
		}

		List<CommentoRichiesta> list = findByRichiestaId(
			richiestaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta[] findByRichiestaId_PrevAndNext(
			long commentoRichiestaId, long richiestaId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = findByPrimaryKey(
			commentoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			CommentoRichiesta[] array = new CommentoRichiestaImpl[3];

			array[0] = getByRichiestaId_PrevAndNext(
				session, commentoRichiesta, richiestaId, orderByComparator,
				true);

			array[1] = commentoRichiesta;

			array[2] = getByRichiestaId_PrevAndNext(
				session, commentoRichiesta, richiestaId, orderByComparator,
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

	protected CommentoRichiesta getByRichiestaId_PrevAndNext(
		Session session, CommentoRichiesta commentoRichiesta, long richiestaId,
		OrderByComparator<CommentoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

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
			sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(richiestaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commentoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commento richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	@Override
	public void removeByRichiestaId(long richiestaId) {
		for (CommentoRichiesta commentoRichiesta :
				findByRichiestaId(
					richiestaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commentoRichiesta);
		}
	}

	/**
	 * Returns the number of commento richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching commento richiestas
	 */
	@Override
	public int countByRichiestaId(long richiestaId) {
		FinderPath finderPath = _finderPathCountByRichiestaId;

		Object[] finderArgs = new Object[] {richiestaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENTORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

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

	private static final String _FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2 =
		"commentoRichiesta.richiestaId = ?";

	private FinderPath _finderPathWithPaginationFindByRichiestaIdVisibile;
	private FinderPath _finderPathWithoutPaginationFindByRichiestaIdVisibile;
	private FinderPath _finderPathCountByRichiestaIdVisibile;

	/**
	 * Returns all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return findByRichiestaIdVisibile(
			richiestaId, visibile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end) {

		return findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRichiestaIdVisibile;
				finderArgs = new Object[] {richiestaId, visibile};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRichiestaIdVisibile;
			finderArgs = new Object[] {
				richiestaId, visibile, start, end, orderByComparator
			};
		}

		List<CommentoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<CommentoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentoRichiesta commentoRichiesta : list) {
					if ((richiestaId != commentoRichiesta.getRichiestaId()) ||
						(visibile != commentoRichiesta.isVisibile())) {

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

			sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_VISIBILE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(visibile);

				list = (List<CommentoRichiesta>)QueryUtil.list(
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
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByRichiestaIdVisibile_First(
			long richiestaId, boolean visibile,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByRichiestaIdVisibile_First(
			richiestaId, visibile, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByRichiestaIdVisibile_First(
		long richiestaId, boolean visibile,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		List<CommentoRichiesta> list = findByRichiestaIdVisibile(
			richiestaId, visibile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByRichiestaIdVisibile_Last(
			long richiestaId, boolean visibile,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByRichiestaIdVisibile_Last(
			richiestaId, visibile, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByRichiestaIdVisibile_Last(
		long richiestaId, boolean visibile,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		int count = countByRichiestaIdVisibile(richiestaId, visibile);

		if (count == 0) {
			return null;
		}

		List<CommentoRichiesta> list = findByRichiestaIdVisibile(
			richiestaId, visibile, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta[] findByRichiestaIdVisibile_PrevAndNext(
			long commentoRichiestaId, long richiestaId, boolean visibile,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = findByPrimaryKey(
			commentoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			CommentoRichiesta[] array = new CommentoRichiestaImpl[3];

			array[0] = getByRichiestaIdVisibile_PrevAndNext(
				session, commentoRichiesta, richiestaId, visibile,
				orderByComparator, true);

			array[1] = commentoRichiesta;

			array[2] = getByRichiestaIdVisibile_PrevAndNext(
				session, commentoRichiesta, richiestaId, visibile,
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

	protected CommentoRichiesta getByRichiestaIdVisibile_PrevAndNext(
		Session session, CommentoRichiesta commentoRichiesta, long richiestaId,
		boolean visibile,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_VISIBILE_2);

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
			sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(richiestaId);

		queryPos.add(visibile);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commentoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commento richiestas where richiestaId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 */
	@Override
	public void removeByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		for (CommentoRichiesta commentoRichiesta :
				findByRichiestaIdVisibile(
					richiestaId, visibile, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commentoRichiesta);
		}
	}

	/**
	 * Returns the number of commento richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the number of matching commento richiestas
	 */
	@Override
	public int countByRichiestaIdVisibile(long richiestaId, boolean visibile) {
		FinderPath finderPath = _finderPathCountByRichiestaIdVisibile;

		Object[] finderArgs = new Object[] {richiestaId, visibile};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMENTORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_VISIBILE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(visibile);

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
		_FINDER_COLUMN_RICHIESTAIDVISIBILE_RICHIESTAID_2 =
			"commentoRichiesta.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_RICHIESTAIDVISIBILE_VISIBILE_2 =
		"commentoRichiesta.visibile = ?";

	private FinderPath _finderPathWithPaginationFindByTaskId;
	private FinderPath _finderPathWithoutPaginationFindByTaskId;
	private FinderPath _finderPathCountByTaskId;

	/**
	 * Returns all the commento richiestas where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByTaskId(String taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end) {

		return findByTaskId(taskId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commento richiestas where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findByTaskId(
		String taskId, int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
		boolean useFinderCache) {

		taskId = Objects.toString(taskId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTaskId;
				finderArgs = new Object[] {taskId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskId;
			finderArgs = new Object[] {taskId, start, end, orderByComparator};
		}

		List<CommentoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<CommentoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CommentoRichiesta commentoRichiesta : list) {
					if (!taskId.equals(commentoRichiesta.getTaskId())) {
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

			sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

			boolean bindTaskId = false;

			if (taskId.isEmpty()) {
				sb.append(_FINDER_COLUMN_TASKID_TASKID_3);
			}
			else {
				bindTaskId = true;

				sb.append(_FINDER_COLUMN_TASKID_TASKID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTaskId) {
					queryPos.add(taskId);
				}

				list = (List<CommentoRichiesta>)QueryUtil.list(
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
	 * Returns the first commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByTaskId_First(
			String taskId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByTaskId_First(
			taskId, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByTaskId_First(
		String taskId, OrderByComparator<CommentoRichiesta> orderByComparator) {

		List<CommentoRichiesta> list = findByTaskId(
			taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta findByTaskId_Last(
			String taskId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByTaskId_Last(
			taskId, orderByComparator);

		if (commentoRichiesta != null) {
			return commentoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchCommentoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commento richiesta, or <code>null</code> if a matching commento richiesta could not be found
	 */
	@Override
	public CommentoRichiesta fetchByTaskId_Last(
		String taskId, OrderByComparator<CommentoRichiesta> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<CommentoRichiesta> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commento richiestas before and after the current commento richiesta in the ordered set where taskId = &#63;.
	 *
	 * @param commentoRichiestaId the primary key of the current commento richiesta
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta[] findByTaskId_PrevAndNext(
			long commentoRichiestaId, String taskId,
			OrderByComparator<CommentoRichiesta> orderByComparator)
		throws NoSuchCommentoRichiestaException {

		taskId = Objects.toString(taskId, "");

		CommentoRichiesta commentoRichiesta = findByPrimaryKey(
			commentoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			CommentoRichiesta[] array = new CommentoRichiestaImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, commentoRichiesta, taskId, orderByComparator, true);

			array[1] = commentoRichiesta;

			array[2] = getByTaskId_PrevAndNext(
				session, commentoRichiesta, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentoRichiesta getByTaskId_PrevAndNext(
		Session session, CommentoRichiesta commentoRichiesta, String taskId,
		OrderByComparator<CommentoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_COMMENTORICHIESTA_WHERE);

		boolean bindTaskId = false;

		if (taskId.isEmpty()) {
			sb.append(_FINDER_COLUMN_TASKID_TASKID_3);
		}
		else {
			bindTaskId = true;

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);
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
			sb.append(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTaskId) {
			queryPos.add(taskId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commentoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommentoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commento richiestas where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(String taskId) {
		for (CommentoRichiesta commentoRichiesta :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commentoRichiesta);
		}
	}

	/**
	 * Returns the number of commento richiestas where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching commento richiestas
	 */
	@Override
	public int countByTaskId(String taskId) {
		taskId = Objects.toString(taskId, "");

		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMENTORICHIESTA_WHERE);

			boolean bindTaskId = false;

			if (taskId.isEmpty()) {
				sb.append(_FINDER_COLUMN_TASKID_TASKID_3);
			}
			else {
				bindTaskId = true;

				sb.append(_FINDER_COLUMN_TASKID_TASKID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTaskId) {
					queryPos.add(taskId);
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

	private static final String _FINDER_COLUMN_TASKID_TASKID_2 =
		"commentoRichiesta.taskId = ?";

	private static final String _FINDER_COLUMN_TASKID_TASKID_3 =
		"(commentoRichiesta.taskId IS NULL OR commentoRichiesta.taskId = '')";

	public CommentoRichiestaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CommentoRichiesta.class);

		setModelImplClass(CommentoRichiestaImpl.class);
		setModelPKClass(long.class);

		setTable(CommentoRichiestaTable.INSTANCE);
	}

	/**
	 * Caches the commento richiesta in the entity cache if it is enabled.
	 *
	 * @param commentoRichiesta the commento richiesta
	 */
	@Override
	public void cacheResult(CommentoRichiesta commentoRichiesta) {
		entityCache.putResult(
			CommentoRichiestaImpl.class, commentoRichiesta.getPrimaryKey(),
			commentoRichiesta);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				commentoRichiesta.getUuid(), commentoRichiesta.getGroupId()
			},
			commentoRichiesta);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the commento richiestas in the entity cache if it is enabled.
	 *
	 * @param commentoRichiestas the commento richiestas
	 */
	@Override
	public void cacheResult(List<CommentoRichiesta> commentoRichiestas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (commentoRichiestas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CommentoRichiesta commentoRichiesta : commentoRichiestas) {
			if (entityCache.getResult(
					CommentoRichiestaImpl.class,
					commentoRichiesta.getPrimaryKey()) == null) {

				cacheResult(commentoRichiesta);
			}
		}
	}

	/**
	 * Clears the cache for all commento richiestas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommentoRichiestaImpl.class);

		finderCache.clearCache(CommentoRichiestaImpl.class);
	}

	/**
	 * Clears the cache for the commento richiesta.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommentoRichiesta commentoRichiesta) {
		entityCache.removeResult(
			CommentoRichiestaImpl.class, commentoRichiesta);
	}

	@Override
	public void clearCache(List<CommentoRichiesta> commentoRichiestas) {
		for (CommentoRichiesta commentoRichiesta : commentoRichiestas) {
			entityCache.removeResult(
				CommentoRichiestaImpl.class, commentoRichiesta);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CommentoRichiestaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CommentoRichiestaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommentoRichiestaModelImpl commentoRichiestaModelImpl) {

		Object[] args = new Object[] {
			commentoRichiestaModelImpl.getUuid(),
			commentoRichiestaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, commentoRichiestaModelImpl);
	}

	/**
	 * Creates a new commento richiesta with the primary key. Does not add the commento richiesta to the database.
	 *
	 * @param commentoRichiestaId the primary key for the new commento richiesta
	 * @return the new commento richiesta
	 */
	@Override
	public CommentoRichiesta create(long commentoRichiestaId) {
		CommentoRichiesta commentoRichiesta = new CommentoRichiestaImpl();

		commentoRichiesta.setNew(true);
		commentoRichiesta.setPrimaryKey(commentoRichiestaId);

		String uuid = PortalUUIDUtil.generate();

		commentoRichiesta.setUuid(uuid);

		commentoRichiesta.setCompanyId(CompanyThreadLocal.getCompanyId());

		return commentoRichiesta;
	}

	/**
	 * Removes the commento richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta that was removed
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta remove(long commentoRichiestaId)
		throws NoSuchCommentoRichiestaException {

		return remove((Serializable)commentoRichiestaId);
	}

	/**
	 * Removes the commento richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commento richiesta
	 * @return the commento richiesta that was removed
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta remove(Serializable primaryKey)
		throws NoSuchCommentoRichiestaException {

		Session session = null;

		try {
			session = openSession();

			CommentoRichiesta commentoRichiesta =
				(CommentoRichiesta)session.get(
					CommentoRichiestaImpl.class, primaryKey);

			if (commentoRichiesta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentoRichiestaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commentoRichiesta);
		}
		catch (NoSuchCommentoRichiestaException noSuchEntityException) {
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
	protected CommentoRichiesta removeImpl(
		CommentoRichiesta commentoRichiesta) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commentoRichiesta)) {
				commentoRichiesta = (CommentoRichiesta)session.get(
					CommentoRichiestaImpl.class,
					commentoRichiesta.getPrimaryKeyObj());
			}

			if (commentoRichiesta != null) {
				session.delete(commentoRichiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (commentoRichiesta != null) {
			clearCache(commentoRichiesta);
		}

		return commentoRichiesta;
	}

	@Override
	public CommentoRichiesta updateImpl(CommentoRichiesta commentoRichiesta) {
		boolean isNew = commentoRichiesta.isNew();

		if (!(commentoRichiesta instanceof CommentoRichiestaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commentoRichiesta.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					commentoRichiesta);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commentoRichiesta proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommentoRichiesta implementation " +
					commentoRichiesta.getClass());
		}

		CommentoRichiestaModelImpl commentoRichiestaModelImpl =
			(CommentoRichiestaModelImpl)commentoRichiesta;

		if (Validator.isNull(commentoRichiesta.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commentoRichiesta.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (commentoRichiesta.getCreateDate() == null)) {
			if (serviceContext == null) {
				commentoRichiesta.setCreateDate(date);
			}
			else {
				commentoRichiesta.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!commentoRichiestaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commentoRichiesta.setModifiedDate(date);
			}
			else {
				commentoRichiesta.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(commentoRichiesta);
			}
			else {
				commentoRichiesta = (CommentoRichiesta)session.merge(
					commentoRichiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CommentoRichiestaImpl.class, commentoRichiestaModelImpl, false,
			true);

		cacheUniqueFindersCache(commentoRichiestaModelImpl);

		if (isNew) {
			commentoRichiesta.setNew(false);
		}

		commentoRichiesta.resetOriginalValues();

		return commentoRichiesta;
	}

	/**
	 * Returns the commento richiesta with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commento richiesta
	 * @return the commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommentoRichiestaException {

		CommentoRichiesta commentoRichiesta = fetchByPrimaryKey(primaryKey);

		if (commentoRichiesta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommentoRichiestaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commentoRichiesta;
	}

	/**
	 * Returns the commento richiesta with the primary key or throws a <code>NoSuchCommentoRichiestaException</code> if it could not be found.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta
	 * @throws NoSuchCommentoRichiestaException if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta findByPrimaryKey(long commentoRichiestaId)
		throws NoSuchCommentoRichiestaException {

		return findByPrimaryKey((Serializable)commentoRichiestaId);
	}

	/**
	 * Returns the commento richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentoRichiestaId the primary key of the commento richiesta
	 * @return the commento richiesta, or <code>null</code> if a commento richiesta with the primary key could not be found
	 */
	@Override
	public CommentoRichiesta fetchByPrimaryKey(long commentoRichiestaId) {
		return fetchByPrimaryKey((Serializable)commentoRichiestaId);
	}

	/**
	 * Returns all the commento richiestas.
	 *
	 * @return the commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @return the range of commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findAll(
		int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commento richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commento richiestas
	 * @param end the upper bound of the range of commento richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commento richiestas
	 */
	@Override
	public List<CommentoRichiesta> findAll(
		int start, int end,
		OrderByComparator<CommentoRichiesta> orderByComparator,
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

		List<CommentoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<CommentoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMMENTORICHIESTA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENTORICHIESTA;

				sql = sql.concat(CommentoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CommentoRichiesta>)QueryUtil.list(
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
	 * Removes all the commento richiestas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommentoRichiesta commentoRichiesta : findAll()) {
			remove(commentoRichiesta);
		}
	}

	/**
	 * Returns the number of commento richiestas.
	 *
	 * @return the number of commento richiestas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMMENTORICHIESTA);

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
		return "commentoRichiestaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMMENTORICHIESTA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommentoRichiestaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commento richiesta persistence.
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

		_finderPathWithPaginationFindByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRichiestaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"richiestaId"}, true);

		_finderPathWithoutPaginationFindByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRichiestaId",
			new String[] {Long.class.getName()}, new String[] {"richiestaId"},
			true);

		_finderPathCountByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRichiestaId",
			new String[] {Long.class.getName()}, new String[] {"richiestaId"},
			false);

		_finderPathWithPaginationFindByRichiestaIdVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRichiestaIdVisibile",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"richiestaId", "visibile"}, true);

		_finderPathWithoutPaginationFindByRichiestaIdVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRichiestaIdVisibile",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"richiestaId", "visibile"}, true);

		_finderPathCountByRichiestaIdVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRichiestaIdVisibile",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"richiestaId", "visibile"}, false);

		_finderPathWithPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"taskId"}, true);

		_finderPathWithoutPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaskId",
			new String[] {String.class.getName()}, new String[] {"taskId"},
			true);

		_finderPathCountByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaskId",
			new String[] {String.class.getName()}, new String[] {"taskId"},
			false);

		_setCommentoRichiestaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCommentoRichiestaUtilPersistence(null);

		entityCache.removeCache(CommentoRichiestaImpl.class.getName());
	}

	private void _setCommentoRichiestaUtilPersistence(
		CommentoRichiestaPersistence commentoRichiestaPersistence) {

		try {
			Field field = CommentoRichiestaUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, commentoRichiestaPersistence);
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

	private static final String _SQL_SELECT_COMMENTORICHIESTA =
		"SELECT commentoRichiesta FROM CommentoRichiesta commentoRichiesta";

	private static final String _SQL_SELECT_COMMENTORICHIESTA_WHERE =
		"SELECT commentoRichiesta FROM CommentoRichiesta commentoRichiesta WHERE ";

	private static final String _SQL_COUNT_COMMENTORICHIESTA =
		"SELECT COUNT(commentoRichiesta) FROM CommentoRichiesta commentoRichiesta";

	private static final String _SQL_COUNT_COMMENTORICHIESTA_WHERE =
		"SELECT COUNT(commentoRichiesta) FROM CommentoRichiesta commentoRichiesta WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "commentoRichiesta.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommentoRichiesta exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommentoRichiesta exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommentoRichiestaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CommentoRichiestaModelArgumentsResolver
		_commentoRichiestaModelArgumentsResolver;

}