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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchAttivitaRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiestaTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.AttivitaRichiestaImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.AttivitaRichiestaModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AttivitaRichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AttivitaRichiestaUtil;
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
 * The persistence implementation for the attivita richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AttivitaRichiestaPersistence.class, BasePersistence.class}
)
public class AttivitaRichiestaPersistenceImpl
	extends BasePersistenceImpl<AttivitaRichiesta>
	implements AttivitaRichiestaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AttivitaRichiestaUtil</code> to access the attivita richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AttivitaRichiestaImpl.class.getName();

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
	 * Returns all the attivita richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		List<AttivitaRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AttivitaRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AttivitaRichiesta attivitaRichiesta : list) {
					if (!uuid.equals(attivitaRichiesta.getUuid())) {
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

			sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

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
				sb.append(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<AttivitaRichiesta>)QueryUtil.list(
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
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByUuid_First(
			String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByUuid_First(
			uuid, orderByComparator);

		if (attivitaRichiesta != null) {
			return attivitaRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAttivitaRichiestaException(sb.toString());
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByUuid_First(
		String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator) {

		List<AttivitaRichiesta> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByUuid_Last(
			String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByUuid_Last(
			uuid, orderByComparator);

		if (attivitaRichiesta != null) {
			return attivitaRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAttivitaRichiestaException(sb.toString());
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByUuid_Last(
		String uuid, OrderByComparator<AttivitaRichiesta> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AttivitaRichiesta> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta[] findByUuid_PrevAndNext(
			long attivitaRichiestaId, String uuid,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		uuid = Objects.toString(uuid, "");

		AttivitaRichiesta attivitaRichiesta = findByPrimaryKey(
			attivitaRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AttivitaRichiesta[] array = new AttivitaRichiestaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, attivitaRichiesta, uuid, orderByComparator, true);

			array[1] = attivitaRichiesta;

			array[2] = getByUuid_PrevAndNext(
				session, attivitaRichiesta, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttivitaRichiesta getByUuid_PrevAndNext(
		Session session, AttivitaRichiesta attivitaRichiesta, String uuid,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

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
			sb.append(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
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
						attivitaRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AttivitaRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attivita richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AttivitaRichiesta attivitaRichiesta :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(attivitaRichiesta);
		}
	}

	/**
	 * Returns the number of attivita richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching attivita richiestas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ATTIVITARICHIESTA_WHERE);

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
		"attivitaRichiesta.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(attivitaRichiesta.uuid IS NULL OR attivitaRichiesta.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAttivitaRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByUUID_G(uuid, groupId);

		if (attivitaRichiesta == null) {
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

			throw new NoSuchAttivitaRichiestaException(sb.toString());
		}

		return attivitaRichiesta;
	}

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the attivita richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByUUID_G(
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

		if (result instanceof AttivitaRichiesta) {
			AttivitaRichiesta attivitaRichiesta = (AttivitaRichiesta)result;

			if (!Objects.equals(uuid, attivitaRichiesta.getUuid()) ||
				(groupId != attivitaRichiesta.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

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

				List<AttivitaRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AttivitaRichiesta attivitaRichiesta = list.get(0);

					result = attivitaRichiesta;

					cacheResult(attivitaRichiesta);
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
			return (AttivitaRichiesta)result;
		}
	}

	/**
	 * Removes the attivita richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the attivita richiesta that was removed
	 */
	@Override
	public AttivitaRichiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = findByUUID_G(uuid, groupId);

		return remove(attivitaRichiesta);
	}

	/**
	 * Returns the number of attivita richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching attivita richiestas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ATTIVITARICHIESTA_WHERE);

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
		"attivitaRichiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(attivitaRichiesta.uuid IS NULL OR attivitaRichiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"attivitaRichiesta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		List<AttivitaRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AttivitaRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AttivitaRichiesta attivitaRichiesta : list) {
					if (!uuid.equals(attivitaRichiesta.getUuid()) ||
						(companyId != attivitaRichiesta.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

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
				sb.append(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<AttivitaRichiesta>)QueryUtil.list(
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
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (attivitaRichiesta != null) {
			return attivitaRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAttivitaRichiestaException(sb.toString());
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		List<AttivitaRichiesta> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (attivitaRichiesta != null) {
			return attivitaRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAttivitaRichiestaException(sb.toString());
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AttivitaRichiesta> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta[] findByUuid_C_PrevAndNext(
			long attivitaRichiestaId, String uuid, long companyId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		uuid = Objects.toString(uuid, "");

		AttivitaRichiesta attivitaRichiesta = findByPrimaryKey(
			attivitaRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AttivitaRichiesta[] array = new AttivitaRichiestaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, attivitaRichiesta, uuid, companyId, orderByComparator,
				true);

			array[1] = attivitaRichiesta;

			array[2] = getByUuid_C_PrevAndNext(
				session, attivitaRichiesta, uuid, companyId, orderByComparator,
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

	protected AttivitaRichiesta getByUuid_C_PrevAndNext(
		Session session, AttivitaRichiesta attivitaRichiesta, String uuid,
		long companyId, OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

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
			sb.append(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
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
						attivitaRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AttivitaRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attivita richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AttivitaRichiesta attivitaRichiesta :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(attivitaRichiesta);
		}
	}

	/**
	 * Returns the number of attivita richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching attivita richiestas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ATTIVITARICHIESTA_WHERE);

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
		"attivitaRichiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(attivitaRichiesta.uuid IS NULL OR attivitaRichiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"attivitaRichiesta.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRichiestaId;
	private FinderPath _finderPathWithoutPaginationFindByRichiestaId;
	private FinderPath _finderPathCountByRichiestaId;

	/**
	 * Returns all the attivita richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByRichiestaId(long richiestaId) {
		return findByRichiestaId(
			richiestaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end) {

		return findByRichiestaId(richiestaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return findByRichiestaId(
			richiestaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		List<AttivitaRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AttivitaRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AttivitaRichiesta attivitaRichiesta : list) {
					if (richiestaId != attivitaRichiesta.getRichiestaId()) {
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

			sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				list = (List<AttivitaRichiesta>)QueryUtil.list(
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
	 * Returns the first attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByRichiestaId_First(
			long richiestaId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByRichiestaId_First(
			richiestaId, orderByComparator);

		if (attivitaRichiesta != null) {
			return attivitaRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append("}");

		throw new NoSuchAttivitaRichiestaException(sb.toString());
	}

	/**
	 * Returns the first attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByRichiestaId_First(
		long richiestaId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		List<AttivitaRichiesta> list = findByRichiestaId(
			richiestaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta findByRichiestaId_Last(
			long richiestaId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByRichiestaId_Last(
			richiestaId, orderByComparator);

		if (attivitaRichiesta != null) {
			return attivitaRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append("}");

		throw new NoSuchAttivitaRichiestaException(sb.toString());
	}

	/**
	 * Returns the last attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attivita richiesta, or <code>null</code> if a matching attivita richiesta could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		int count = countByRichiestaId(richiestaId);

		if (count == 0) {
			return null;
		}

		List<AttivitaRichiesta> list = findByRichiestaId(
			richiestaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attivita richiestas before and after the current attivita richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param attivitaRichiestaId the primary key of the current attivita richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta[] findByRichiestaId_PrevAndNext(
			long attivitaRichiestaId, long richiestaId,
			OrderByComparator<AttivitaRichiesta> orderByComparator)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = findByPrimaryKey(
			attivitaRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AttivitaRichiesta[] array = new AttivitaRichiestaImpl[3];

			array[0] = getByRichiestaId_PrevAndNext(
				session, attivitaRichiesta, richiestaId, orderByComparator,
				true);

			array[1] = attivitaRichiesta;

			array[2] = getByRichiestaId_PrevAndNext(
				session, attivitaRichiesta, richiestaId, orderByComparator,
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

	protected AttivitaRichiesta getByRichiestaId_PrevAndNext(
		Session session, AttivitaRichiesta attivitaRichiesta, long richiestaId,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ATTIVITARICHIESTA_WHERE);

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
			sb.append(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
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
						attivitaRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AttivitaRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attivita richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	@Override
	public void removeByRichiestaId(long richiestaId) {
		for (AttivitaRichiesta attivitaRichiesta :
				findByRichiestaId(
					richiestaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(attivitaRichiesta);
		}
	}

	/**
	 * Returns the number of attivita richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching attivita richiestas
	 */
	@Override
	public int countByRichiestaId(long richiestaId) {
		FinderPath finderPath = _finderPathCountByRichiestaId;

		Object[] finderArgs = new Object[] {richiestaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ATTIVITARICHIESTA_WHERE);

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
		"attivitaRichiesta.richiestaId = ?";

	public AttivitaRichiestaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AttivitaRichiesta.class);

		setModelImplClass(AttivitaRichiestaImpl.class);
		setModelPKClass(long.class);

		setTable(AttivitaRichiestaTable.INSTANCE);
	}

	/**
	 * Caches the attivita richiesta in the entity cache if it is enabled.
	 *
	 * @param attivitaRichiesta the attivita richiesta
	 */
	@Override
	public void cacheResult(AttivitaRichiesta attivitaRichiesta) {
		entityCache.putResult(
			AttivitaRichiestaImpl.class, attivitaRichiesta.getPrimaryKey(),
			attivitaRichiesta);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				attivitaRichiesta.getUuid(), attivitaRichiesta.getGroupId()
			},
			attivitaRichiesta);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the attivita richiestas in the entity cache if it is enabled.
	 *
	 * @param attivitaRichiestas the attivita richiestas
	 */
	@Override
	public void cacheResult(List<AttivitaRichiesta> attivitaRichiestas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (attivitaRichiestas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AttivitaRichiesta attivitaRichiesta : attivitaRichiestas) {
			if (entityCache.getResult(
					AttivitaRichiestaImpl.class,
					attivitaRichiesta.getPrimaryKey()) == null) {

				cacheResult(attivitaRichiesta);
			}
		}
	}

	/**
	 * Clears the cache for all attivita richiestas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttivitaRichiestaImpl.class);

		finderCache.clearCache(AttivitaRichiestaImpl.class);
	}

	/**
	 * Clears the cache for the attivita richiesta.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttivitaRichiesta attivitaRichiesta) {
		entityCache.removeResult(
			AttivitaRichiestaImpl.class, attivitaRichiesta);
	}

	@Override
	public void clearCache(List<AttivitaRichiesta> attivitaRichiestas) {
		for (AttivitaRichiesta attivitaRichiesta : attivitaRichiestas) {
			entityCache.removeResult(
				AttivitaRichiestaImpl.class, attivitaRichiesta);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AttivitaRichiestaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AttivitaRichiestaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AttivitaRichiestaModelImpl attivitaRichiestaModelImpl) {

		Object[] args = new Object[] {
			attivitaRichiestaModelImpl.getUuid(),
			attivitaRichiestaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, attivitaRichiestaModelImpl);
	}

	/**
	 * Creates a new attivita richiesta with the primary key. Does not add the attivita richiesta to the database.
	 *
	 * @param attivitaRichiestaId the primary key for the new attivita richiesta
	 * @return the new attivita richiesta
	 */
	@Override
	public AttivitaRichiesta create(long attivitaRichiestaId) {
		AttivitaRichiesta attivitaRichiesta = new AttivitaRichiestaImpl();

		attivitaRichiesta.setNew(true);
		attivitaRichiesta.setPrimaryKey(attivitaRichiestaId);

		String uuid = PortalUUIDUtil.generate();

		attivitaRichiesta.setUuid(uuid);

		attivitaRichiesta.setCompanyId(CompanyThreadLocal.getCompanyId());

		return attivitaRichiesta;
	}

	/**
	 * Removes the attivita richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta that was removed
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta remove(long attivitaRichiestaId)
		throws NoSuchAttivitaRichiestaException {

		return remove((Serializable)attivitaRichiestaId);
	}

	/**
	 * Removes the attivita richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attivita richiesta
	 * @return the attivita richiesta that was removed
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta remove(Serializable primaryKey)
		throws NoSuchAttivitaRichiestaException {

		Session session = null;

		try {
			session = openSession();

			AttivitaRichiesta attivitaRichiesta =
				(AttivitaRichiesta)session.get(
					AttivitaRichiestaImpl.class, primaryKey);

			if (attivitaRichiesta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttivitaRichiestaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(attivitaRichiesta);
		}
		catch (NoSuchAttivitaRichiestaException noSuchEntityException) {
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
	protected AttivitaRichiesta removeImpl(
		AttivitaRichiesta attivitaRichiesta) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attivitaRichiesta)) {
				attivitaRichiesta = (AttivitaRichiesta)session.get(
					AttivitaRichiestaImpl.class,
					attivitaRichiesta.getPrimaryKeyObj());
			}

			if (attivitaRichiesta != null) {
				session.delete(attivitaRichiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (attivitaRichiesta != null) {
			clearCache(attivitaRichiesta);
		}

		return attivitaRichiesta;
	}

	@Override
	public AttivitaRichiesta updateImpl(AttivitaRichiesta attivitaRichiesta) {
		boolean isNew = attivitaRichiesta.isNew();

		if (!(attivitaRichiesta instanceof AttivitaRichiestaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(attivitaRichiesta.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					attivitaRichiesta);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in attivitaRichiesta proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AttivitaRichiesta implementation " +
					attivitaRichiesta.getClass());
		}

		AttivitaRichiestaModelImpl attivitaRichiestaModelImpl =
			(AttivitaRichiestaModelImpl)attivitaRichiesta;

		if (Validator.isNull(attivitaRichiesta.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			attivitaRichiesta.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (attivitaRichiesta.getCreateDate() == null)) {
			if (serviceContext == null) {
				attivitaRichiesta.setCreateDate(date);
			}
			else {
				attivitaRichiesta.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!attivitaRichiestaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				attivitaRichiesta.setModifiedDate(date);
			}
			else {
				attivitaRichiesta.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(attivitaRichiesta);
			}
			else {
				attivitaRichiesta = (AttivitaRichiesta)session.merge(
					attivitaRichiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AttivitaRichiestaImpl.class, attivitaRichiestaModelImpl, false,
			true);

		cacheUniqueFindersCache(attivitaRichiestaModelImpl);

		if (isNew) {
			attivitaRichiesta.setNew(false);
		}

		attivitaRichiesta.resetOriginalValues();

		return attivitaRichiesta;
	}

	/**
	 * Returns the attivita richiesta with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attivita richiesta
	 * @return the attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttivitaRichiestaException {

		AttivitaRichiesta attivitaRichiesta = fetchByPrimaryKey(primaryKey);

		if (attivitaRichiesta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttivitaRichiestaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return attivitaRichiesta;
	}

	/**
	 * Returns the attivita richiesta with the primary key or throws a <code>NoSuchAttivitaRichiestaException</code> if it could not be found.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta
	 * @throws NoSuchAttivitaRichiestaException if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta findByPrimaryKey(long attivitaRichiestaId)
		throws NoSuchAttivitaRichiestaException {

		return findByPrimaryKey((Serializable)attivitaRichiestaId);
	}

	/**
	 * Returns the attivita richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attivitaRichiestaId the primary key of the attivita richiesta
	 * @return the attivita richiesta, or <code>null</code> if a attivita richiesta with the primary key could not be found
	 */
	@Override
	public AttivitaRichiesta fetchByPrimaryKey(long attivitaRichiestaId) {
		return fetchByPrimaryKey((Serializable)attivitaRichiestaId);
	}

	/**
	 * Returns all the attivita richiestas.
	 *
	 * @return the attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @return the range of attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findAll(
		int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attivita richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttivitaRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attivita richiestas
	 * @param end the upper bound of the range of attivita richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attivita richiestas
	 */
	@Override
	public List<AttivitaRichiesta> findAll(
		int start, int end,
		OrderByComparator<AttivitaRichiesta> orderByComparator,
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

		List<AttivitaRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AttivitaRichiesta>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ATTIVITARICHIESTA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ATTIVITARICHIESTA;

				sql = sql.concat(AttivitaRichiestaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AttivitaRichiesta>)QueryUtil.list(
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
	 * Removes all the attivita richiestas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttivitaRichiesta attivitaRichiesta : findAll()) {
			remove(attivitaRichiesta);
		}
	}

	/**
	 * Returns the number of attivita richiestas.
	 *
	 * @return the number of attivita richiestas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ATTIVITARICHIESTA);

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
		return "attivitaRichiestaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ATTIVITARICHIESTA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AttivitaRichiestaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attivita richiesta persistence.
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

		_setAttivitaRichiestaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAttivitaRichiestaUtilPersistence(null);

		entityCache.removeCache(AttivitaRichiestaImpl.class.getName());
	}

	private void _setAttivitaRichiestaUtilPersistence(
		AttivitaRichiestaPersistence attivitaRichiestaPersistence) {

		try {
			Field field = AttivitaRichiestaUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, attivitaRichiestaPersistence);
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

	private static final String _SQL_SELECT_ATTIVITARICHIESTA =
		"SELECT attivitaRichiesta FROM AttivitaRichiesta attivitaRichiesta";

	private static final String _SQL_SELECT_ATTIVITARICHIESTA_WHERE =
		"SELECT attivitaRichiesta FROM AttivitaRichiesta attivitaRichiesta WHERE ";

	private static final String _SQL_COUNT_ATTIVITARICHIESTA =
		"SELECT COUNT(attivitaRichiesta) FROM AttivitaRichiesta attivitaRichiesta";

	private static final String _SQL_COUNT_ATTIVITARICHIESTA_WHERE =
		"SELECT COUNT(attivitaRichiesta) FROM AttivitaRichiesta attivitaRichiesta WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "attivitaRichiesta.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AttivitaRichiesta exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AttivitaRichiesta exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AttivitaRichiestaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AttivitaRichiestaModelArgumentsResolver
		_attivitaRichiestaModelArgumentsResolver;

}