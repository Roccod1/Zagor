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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchAllegatoRichiestaException;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiesta;
import it.servizidigitali.scrivaniaoperatore.model.AllegatoRichiestaTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.AllegatoRichiestaModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaUtil;
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
 * The persistence implementation for the allegato richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AllegatoRichiestaPersistence.class, BasePersistence.class}
)
public class AllegatoRichiestaPersistenceImpl
	extends BasePersistenceImpl<AllegatoRichiesta>
	implements AllegatoRichiestaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AllegatoRichiestaUtil</code> to access the allegato richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AllegatoRichiestaImpl.class.getName();

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
	 * Returns all the allegato richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if (!uuid.equals(allegatoRichiesta.getUuid())) {
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

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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
				sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByUuid_First(
			String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByUuid_First(
			uuid, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUuid_First(
		String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByUuid_Last(
			String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByUuid_Last(
			uuid, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUuid_Last(
		String uuid, OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where uuid = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByUuid_PrevAndNext(
			long allegatoRichiestaId, String uuid,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		uuid = Objects.toString(uuid, "");

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, allegatoRichiesta, uuid, orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByUuid_PrevAndNext(
				session, allegatoRichiesta, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllegatoRichiesta getByUuid_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, String uuid,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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
			sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
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
						allegatoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllegatoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allegato richiestas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AllegatoRichiesta allegatoRichiesta :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

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
		"allegatoRichiesta.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(allegatoRichiesta.uuid IS NULL OR allegatoRichiesta.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByUUID_G(String uuid, long groupId)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByUUID_G(uuid, groupId);

		if (allegatoRichiesta == null) {
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

			throw new NoSuchAllegatoRichiestaException(sb.toString());
		}

		return allegatoRichiesta;
	}

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the allegato richiesta where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUUID_G(
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

		if (result instanceof AllegatoRichiesta) {
			AllegatoRichiesta allegatoRichiesta = (AllegatoRichiesta)result;

			if (!Objects.equals(uuid, allegatoRichiesta.getUuid()) ||
				(groupId != allegatoRichiesta.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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

				List<AllegatoRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AllegatoRichiesta allegatoRichiesta = list.get(0);

					result = allegatoRichiesta;

					cacheResult(allegatoRichiesta);
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
			return (AllegatoRichiesta)result;
		}
	}

	/**
	 * Removes the allegato richiesta where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allegato richiesta that was removed
	 */
	@Override
	public AllegatoRichiesta removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByUUID_G(uuid, groupId);

		return remove(allegatoRichiesta);
	}

	/**
	 * Returns the number of allegato richiestas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

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
		"allegatoRichiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(allegatoRichiesta.uuid IS NULL OR allegatoRichiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"allegatoRichiesta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if (!uuid.equals(allegatoRichiesta.getUuid()) ||
						(companyId != allegatoRichiesta.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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
				sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
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

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByUuid_C_PrevAndNext(
			long allegatoRichiestaId, String uuid, long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		uuid = Objects.toString(uuid, "");

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, allegatoRichiesta, uuid, companyId, orderByComparator,
				true);

			array[1] = allegatoRichiesta;

			array[2] = getByUuid_C_PrevAndNext(
				session, allegatoRichiesta, uuid, companyId, orderByComparator,
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

	protected AllegatoRichiesta getByUuid_C_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, String uuid,
		long companyId, OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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
			sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
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
						allegatoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllegatoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allegato richiestas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AllegatoRichiesta allegatoRichiesta :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

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
		"allegatoRichiesta.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(allegatoRichiesta.uuid IS NULL OR allegatoRichiesta.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"allegatoRichiesta.companyId = ?";

	private FinderPath _finderPathFetchByIdDocumentale;
	private FinderPath _finderPathCountByIdDocumentale;

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param idDocumentale the id documentale
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByIdDocumentale(String idDocumentale)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByIdDocumentale(
			idDocumentale);

		if (allegatoRichiesta == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("idDocumentale=");
			sb.append(idDocumentale);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAllegatoRichiestaException(sb.toString());
		}

		return allegatoRichiesta;
	}

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idDocumentale the id documentale
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByIdDocumentale(String idDocumentale) {
		return fetchByIdDocumentale(idDocumentale, true);
	}

	/**
	 * Returns the allegato richiesta where idDocumentale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idDocumentale the id documentale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByIdDocumentale(
		String idDocumentale, boolean useFinderCache) {

		idDocumentale = Objects.toString(idDocumentale, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {idDocumentale};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByIdDocumentale, finderArgs);
		}

		if (result instanceof AllegatoRichiesta) {
			AllegatoRichiesta allegatoRichiesta = (AllegatoRichiesta)result;

			if (!Objects.equals(
					idDocumentale, allegatoRichiesta.getIdDocumentale())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			boolean bindIdDocumentale = false;

			if (idDocumentale.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDDOCUMENTALE_IDDOCUMENTALE_3);
			}
			else {
				bindIdDocumentale = true;

				sb.append(_FINDER_COLUMN_IDDOCUMENTALE_IDDOCUMENTALE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdDocumentale) {
					queryPos.add(idDocumentale);
				}

				List<AllegatoRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByIdDocumentale, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {idDocumentale};
							}

							_log.warn(
								"AllegatoRichiestaPersistenceImpl.fetchByIdDocumentale(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AllegatoRichiesta allegatoRichiesta = list.get(0);

					result = allegatoRichiesta;

					cacheResult(allegatoRichiesta);
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
			return (AllegatoRichiesta)result;
		}
	}

	/**
	 * Removes the allegato richiesta where idDocumentale = &#63; from the database.
	 *
	 * @param idDocumentale the id documentale
	 * @return the allegato richiesta that was removed
	 */
	@Override
	public AllegatoRichiesta removeByIdDocumentale(String idDocumentale)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByIdDocumentale(
			idDocumentale);

		return remove(allegatoRichiesta);
	}

	/**
	 * Returns the number of allegato richiestas where idDocumentale = &#63;.
	 *
	 * @param idDocumentale the id documentale
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByIdDocumentale(String idDocumentale) {
		idDocumentale = Objects.toString(idDocumentale, "");

		FinderPath finderPath = _finderPathCountByIdDocumentale;

		Object[] finderArgs = new Object[] {idDocumentale};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			boolean bindIdDocumentale = false;

			if (idDocumentale.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDDOCUMENTALE_IDDOCUMENTALE_3);
			}
			else {
				bindIdDocumentale = true;

				sb.append(_FINDER_COLUMN_IDDOCUMENTALE_IDDOCUMENTALE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdDocumentale) {
					queryPos.add(idDocumentale);
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

	private static final String _FINDER_COLUMN_IDDOCUMENTALE_IDDOCUMENTALE_2 =
		"allegatoRichiesta.idDocumentale = ?";

	private static final String _FINDER_COLUMN_IDDOCUMENTALE_IDDOCUMENTALE_3 =
		"(allegatoRichiesta.idDocumentale IS NULL OR allegatoRichiesta.idDocumentale = '')";

	private FinderPath _finderPathFetchByUrl;
	private FinderPath _finderPathCountByUrl;

	/**
	 * Returns the allegato richiesta where url = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param url the url
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByUrl(String url)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByUrl(url);

		if (allegatoRichiesta == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("url=");
			sb.append(url);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAllegatoRichiestaException(sb.toString());
		}

		return allegatoRichiesta;
	}

	/**
	 * Returns the allegato richiesta where url = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param url the url
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUrl(String url) {
		return fetchByUrl(url, true);
	}

	/**
	 * Returns the allegato richiesta where url = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param url the url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByUrl(String url, boolean useFinderCache) {
		url = Objects.toString(url, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {url};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByUrl, finderArgs);
		}

		if (result instanceof AllegatoRichiesta) {
			AllegatoRichiesta allegatoRichiesta = (AllegatoRichiesta)result;

			if (!Objects.equals(url, allegatoRichiesta.getUrl())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			boolean bindUrl = false;

			if (url.isEmpty()) {
				sb.append(_FINDER_COLUMN_URL_URL_3);
			}
			else {
				bindUrl = true;

				sb.append(_FINDER_COLUMN_URL_URL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUrl) {
					queryPos.add(url);
				}

				List<AllegatoRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUrl, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {url};
							}

							_log.warn(
								"AllegatoRichiestaPersistenceImpl.fetchByUrl(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AllegatoRichiesta allegatoRichiesta = list.get(0);

					result = allegatoRichiesta;

					cacheResult(allegatoRichiesta);
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
			return (AllegatoRichiesta)result;
		}
	}

	/**
	 * Removes the allegato richiesta where url = &#63; from the database.
	 *
	 * @param url the url
	 * @return the allegato richiesta that was removed
	 */
	@Override
	public AllegatoRichiesta removeByUrl(String url)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByUrl(url);

		return remove(allegatoRichiesta);
	}

	/**
	 * Returns the number of allegato richiestas where url = &#63;.
	 *
	 * @param url the url
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByUrl(String url) {
		url = Objects.toString(url, "");

		FinderPath finderPath = _finderPathCountByUrl;

		Object[] finderArgs = new Object[] {url};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			boolean bindUrl = false;

			if (url.isEmpty()) {
				sb.append(_FINDER_COLUMN_URL_URL_3);
			}
			else {
				bindUrl = true;

				sb.append(_FINDER_COLUMN_URL_URL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUrl) {
					queryPos.add(url);
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

	private static final String _FINDER_COLUMN_URL_URL_2 =
		"allegatoRichiesta.url = ?";

	private static final String _FINDER_COLUMN_URL_URL_3 =
		"(allegatoRichiesta.url IS NULL OR allegatoRichiesta.url = '')";

	private FinderPath _finderPathFetchByRichiestaIdPrincipale;
	private FinderPath _finderPathCountByRichiestaIdPrincipale;

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdPrincipale(
			long richiestaId, boolean principale)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaIdPrincipale(
			richiestaId, principale);

		if (allegatoRichiesta == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("richiestaId=");
			sb.append(richiestaId);

			sb.append(", principale=");
			sb.append(principale);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAllegatoRichiestaException(sb.toString());
		}

		return allegatoRichiesta;
	}

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdPrincipale(
		long richiestaId, boolean principale) {

		return fetchByRichiestaIdPrincipale(richiestaId, principale, true);
	}

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdPrincipale(
		long richiestaId, boolean principale, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {richiestaId, principale};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRichiestaIdPrincipale, finderArgs);
		}

		if (result instanceof AllegatoRichiesta) {
			AllegatoRichiesta allegatoRichiesta = (AllegatoRichiesta)result;

			if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
				(principale != allegatoRichiesta.isPrincipale())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDPRINCIPALE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDPRINCIPALE_PRINCIPALE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(principale);

				List<AllegatoRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRichiestaIdPrincipale, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									richiestaId, principale
								};
							}

							_log.warn(
								"AllegatoRichiestaPersistenceImpl.fetchByRichiestaIdPrincipale(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AllegatoRichiesta allegatoRichiesta = list.get(0);

					result = allegatoRichiesta;

					cacheResult(allegatoRichiesta);
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
			return (AllegatoRichiesta)result;
		}
	}

	/**
	 * Removes the allegato richiesta where richiestaId = &#63; and principale = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @return the allegato richiesta that was removed
	 */
	@Override
	public AllegatoRichiesta removeByRichiestaIdPrincipale(
			long richiestaId, boolean principale)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByRichiestaIdPrincipale(
			richiestaId, principale);

		return remove(allegatoRichiesta);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and principale = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByRichiestaIdPrincipale(
		long richiestaId, boolean principale) {

		FinderPath finderPath = _finderPathCountByRichiestaIdPrincipale;

		Object[] finderArgs = new Object[] {richiestaId, principale};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDPRINCIPALE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDPRINCIPALE_PRINCIPALE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(principale);

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
		_FINDER_COLUMN_RICHIESTAIDPRINCIPALE_RICHIESTAID_2 =
			"allegatoRichiesta.richiestaId = ? AND ";

	private static final String
		_FINDER_COLUMN_RICHIESTAIDPRINCIPALE_PRINCIPALE_2 =
			"allegatoRichiesta.principale = ?";

	private FinderPath _finderPathWithPaginationFindByRichiestaId;
	private FinderPath _finderPathWithoutPaginationFindByRichiestaId;
	private FinderPath _finderPathCountByRichiestaId;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaId(long richiestaId) {
		return findByRichiestaId(
			richiestaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end) {

		return findByRichiestaId(richiestaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByRichiestaId(
			richiestaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaId(
		long richiestaId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if (richiestaId != allegatoRichiesta.getRichiestaId()) {
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

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaId_First(
			long richiestaId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaId_First(
			richiestaId, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaId_First(
		long richiestaId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByRichiestaId(
			richiestaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaId_Last(
			long richiestaId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaId_Last(
			richiestaId, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaId_Last(
		long richiestaId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByRichiestaId(richiestaId);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByRichiestaId(
			richiestaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByRichiestaId_PrevAndNext(
			long allegatoRichiestaId, long richiestaId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByRichiestaId_PrevAndNext(
				session, allegatoRichiesta, richiestaId, orderByComparator,
				true);

			array[1] = allegatoRichiesta;

			array[2] = getByRichiestaId_PrevAndNext(
				session, allegatoRichiesta, richiestaId, orderByComparator,
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

	protected AllegatoRichiesta getByRichiestaId_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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
			sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
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
						allegatoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllegatoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 */
	@Override
	public void removeByRichiestaId(long richiestaId) {
		for (AllegatoRichiesta allegatoRichiesta :
				findByRichiestaId(
					richiestaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByRichiestaId(long richiestaId) {
		FinderPath finderPath = _finderPathCountByRichiestaId;

		Object[] finderArgs = new Object[] {richiestaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

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
		"allegatoRichiesta.richiestaId = ?";

	private FinderPath _finderPathWithPaginationFindByRichiestaIdInterno;
	private FinderPath _finderPathWithoutPaginationFindByRichiestaIdInterno;
	private FinderPath _finderPathCountByRichiestaIdInterno;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno) {

		return findByRichiestaIdInterno(
			richiestaId, interno, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno, int start, int end) {

		return findByRichiestaIdInterno(richiestaId, interno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByRichiestaIdInterno(
			richiestaId, interno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInterno(
		long richiestaId, boolean interno, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRichiestaIdInterno;
				finderArgs = new Object[] {richiestaId, interno};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRichiestaIdInterno;
			finderArgs = new Object[] {
				richiestaId, interno, start, end, orderByComparator
			};
		}

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(interno != allegatoRichiesta.isInterno())) {

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

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNO_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNO_INTERNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(interno);

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdInterno_First(
			long richiestaId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaIdInterno_First(
			richiestaId, interno, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdInterno_First(
		long richiestaId, boolean interno,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByRichiestaIdInterno(
			richiestaId, interno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdInterno_Last(
			long richiestaId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaIdInterno_Last(
			richiestaId, interno, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdInterno_Last(
		long richiestaId, boolean interno,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByRichiestaIdInterno(richiestaId, interno);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByRichiestaIdInterno(
			richiestaId, interno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByRichiestaIdInterno_PrevAndNext(
			long allegatoRichiestaId, long richiestaId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByRichiestaIdInterno_PrevAndNext(
				session, allegatoRichiesta, richiestaId, interno,
				orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByRichiestaIdInterno_PrevAndNext(
				session, allegatoRichiesta, richiestaId, interno,
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

	protected AllegatoRichiesta getByRichiestaIdInterno_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		boolean interno, OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNO_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNO_INTERNO_2);

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
			sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(richiestaId);

		queryPos.add(interno);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						allegatoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllegatoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and interno = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 */
	@Override
	public void removeByRichiestaIdInterno(long richiestaId, boolean interno) {
		for (AllegatoRichiesta allegatoRichiesta :
				findByRichiestaIdInterno(
					richiestaId, interno, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByRichiestaIdInterno(long richiestaId, boolean interno) {
		FinderPath finderPath = _finderPathCountByRichiestaIdInterno;

		Object[] finderArgs = new Object[] {richiestaId, interno};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNO_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNO_INTERNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(interno);

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
		_FINDER_COLUMN_RICHIESTAIDINTERNO_RICHIESTAID_2 =
			"allegatoRichiesta.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_RICHIESTAIDINTERNO_INTERNO_2 =
		"allegatoRichiesta.interno = ?";

	private FinderPath _finderPathWithPaginationFindByRichiestaIdVisibile;
	private FinderPath _finderPathWithoutPaginationFindByRichiestaIdVisibile;
	private FinderPath _finderPathCountByRichiestaIdVisibile;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		return findByRichiestaIdVisibile(
			richiestaId, visibile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end) {

		return findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByRichiestaIdVisibile(
			richiestaId, visibile, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdVisibile(
		long richiestaId, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(visibile != allegatoRichiesta.isVisibile())) {

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

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDVISIBILE_VISIBILE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(visibile);

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdVisibile_First(
			long richiestaId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaIdVisibile_First(
			richiestaId, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdVisibile_First(
		long richiestaId, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByRichiestaIdVisibile(
			richiestaId, visibile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdVisibile_Last(
			long richiestaId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByRichiestaIdVisibile_Last(
			richiestaId, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdVisibile_Last(
		long richiestaId, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByRichiestaIdVisibile(richiestaId, visibile);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByRichiestaIdVisibile(
			richiestaId, visibile, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByRichiestaIdVisibile_PrevAndNext(
			long allegatoRichiestaId, long richiestaId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByRichiestaIdVisibile_PrevAndNext(
				session, allegatoRichiesta, richiestaId, visibile,
				orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByRichiestaIdVisibile_PrevAndNext(
				session, allegatoRichiesta, richiestaId, visibile,
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

	protected AllegatoRichiesta getByRichiestaIdVisibile_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

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
			sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
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
						allegatoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllegatoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 */
	@Override
	public void removeByRichiestaIdVisibile(
		long richiestaId, boolean visibile) {

		for (AllegatoRichiesta allegatoRichiesta :
				findByRichiestaIdVisibile(
					richiestaId, visibile, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByRichiestaIdVisibile(long richiestaId, boolean visibile) {
		FinderPath finderPath = _finderPathCountByRichiestaIdVisibile;

		Object[] finderArgs = new Object[] {richiestaId, visibile};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

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
			"allegatoRichiesta.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_RICHIESTAIDVISIBILE_VISIBILE_2 =
		"allegatoRichiesta.visibile = ?";

	private FinderPath
		_finderPathWithPaginationFindByRichiestaIdInternoVisibile;
	private FinderPath
		_finderPathWithoutPaginationFindByRichiestaIdInternoVisibile;
	private FinderPath _finderPathCountByRichiestaIdInternoVisibile;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile) {

		return findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile, int start,
		int end) {

		return findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRichiestaIdInternoVisibile;
				finderArgs = new Object[] {richiestaId, interno, visibile};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRichiestaIdInternoVisibile;
			finderArgs = new Object[] {
				richiestaId, interno, visibile, start, end, orderByComparator
			};
		}

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(interno != allegatoRichiesta.isInterno()) ||
						(visibile != allegatoRichiesta.isVisibile())) {

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

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_INTERNO_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_VISIBILE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(interno);

				queryPos.add(visibile);

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdInternoVisibile_First(
			long richiestaId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta =
			fetchByRichiestaIdInternoVisibile_First(
				richiestaId, interno, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdInternoVisibile_First(
		long richiestaId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByRichiestaIdInternoVisibile_Last(
			long richiestaId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta =
			fetchByRichiestaIdInternoVisibile_Last(
				richiestaId, interno, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByRichiestaIdInternoVisibile_Last(
		long richiestaId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByRichiestaIdInternoVisibile(
			richiestaId, interno, visibile, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaId the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByRichiestaIdInternoVisibile_PrevAndNext(
			long allegatoRichiestaId, long richiestaId, boolean interno,
			boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaId);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByRichiestaIdInternoVisibile_PrevAndNext(
				session, allegatoRichiesta, richiestaId, interno, visibile,
				orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByRichiestaIdInternoVisibile_PrevAndNext(
				session, allegatoRichiesta, richiestaId, interno, visibile,
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

	protected AllegatoRichiesta getByRichiestaIdInternoVisibile_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_INTERNO_2);

		sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_VISIBILE_2);

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
			sb.append(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(richiestaId);

		queryPos.add(interno);

		queryPos.add(visibile);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						allegatoRichiesta)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AllegatoRichiesta> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 */
	@Override
	public void removeByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile) {

		for (AllegatoRichiesta allegatoRichiesta :
				findByRichiestaIdInternoVisibile(
					richiestaId, interno, visibile, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByRichiestaIdInternoVisibile(
		long richiestaId, boolean interno, boolean visibile) {

		FinderPath finderPath = _finderPathCountByRichiestaIdInternoVisibile;

		Object[] finderArgs = new Object[] {richiestaId, interno, visibile};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_INTERNO_2);

			sb.append(_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_VISIBILE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(interno);

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
		_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_RICHIESTAID_2 =
			"allegatoRichiesta.richiestaId = ? AND ";

	private static final String
		_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_INTERNO_2 =
			"allegatoRichiesta.interno = ? AND ";

	private static final String
		_FINDER_COLUMN_RICHIESTAIDINTERNOVISIBILE_VISIBILE_2 =
			"allegatoRichiesta.visibile = ?";

	public AllegatoRichiestaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AllegatoRichiesta.class);

		setModelImplClass(AllegatoRichiestaImpl.class);
		setModelPKClass(long.class);

		setTable(AllegatoRichiestaTable.INSTANCE);
	}

	/**
	 * Caches the allegato richiesta in the entity cache if it is enabled.
	 *
	 * @param allegatoRichiesta the allegato richiesta
	 */
	@Override
	public void cacheResult(AllegatoRichiesta allegatoRichiesta) {
		entityCache.putResult(
			AllegatoRichiestaImpl.class, allegatoRichiesta.getPrimaryKey(),
			allegatoRichiesta);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				allegatoRichiesta.getUuid(), allegatoRichiesta.getGroupId()
			},
			allegatoRichiesta);

		finderCache.putResult(
			_finderPathFetchByIdDocumentale,
			new Object[] {allegatoRichiesta.getIdDocumentale()},
			allegatoRichiesta);

		finderCache.putResult(
			_finderPathFetchByUrl, new Object[] {allegatoRichiesta.getUrl()},
			allegatoRichiesta);

		finderCache.putResult(
			_finderPathFetchByRichiestaIdPrincipale,
			new Object[] {
				allegatoRichiesta.getRichiestaId(),
				allegatoRichiesta.isPrincipale()
			},
			allegatoRichiesta);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the allegato richiestas in the entity cache if it is enabled.
	 *
	 * @param allegatoRichiestas the allegato richiestas
	 */
	@Override
	public void cacheResult(List<AllegatoRichiesta> allegatoRichiestas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (allegatoRichiestas.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AllegatoRichiesta allegatoRichiesta : allegatoRichiestas) {
			if (entityCache.getResult(
					AllegatoRichiestaImpl.class,
					allegatoRichiesta.getPrimaryKey()) == null) {

				cacheResult(allegatoRichiesta);
			}
		}
	}

	/**
	 * Clears the cache for all allegato richiestas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AllegatoRichiestaImpl.class);

		finderCache.clearCache(AllegatoRichiestaImpl.class);
	}

	/**
	 * Clears the cache for the allegato richiesta.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AllegatoRichiesta allegatoRichiesta) {
		entityCache.removeResult(
			AllegatoRichiestaImpl.class, allegatoRichiesta);
	}

	@Override
	public void clearCache(List<AllegatoRichiesta> allegatoRichiestas) {
		for (AllegatoRichiesta allegatoRichiesta : allegatoRichiestas) {
			entityCache.removeResult(
				AllegatoRichiestaImpl.class, allegatoRichiesta);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AllegatoRichiestaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AllegatoRichiestaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AllegatoRichiestaModelImpl allegatoRichiestaModelImpl) {

		Object[] args = new Object[] {
			allegatoRichiestaModelImpl.getUuid(),
			allegatoRichiestaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, allegatoRichiestaModelImpl);

		args = new Object[] {allegatoRichiestaModelImpl.getIdDocumentale()};

		finderCache.putResult(
			_finderPathCountByIdDocumentale, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByIdDocumentale, args, allegatoRichiestaModelImpl);

		args = new Object[] {allegatoRichiestaModelImpl.getUrl()};

		finderCache.putResult(_finderPathCountByUrl, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUrl, args, allegatoRichiestaModelImpl);

		args = new Object[] {
			allegatoRichiestaModelImpl.getRichiestaId(),
			allegatoRichiestaModelImpl.isPrincipale()
		};

		finderCache.putResult(
			_finderPathCountByRichiestaIdPrincipale, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByRichiestaIdPrincipale, args,
			allegatoRichiestaModelImpl);
	}

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaId the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	@Override
	public AllegatoRichiesta create(long allegatoRichiestaId) {
		AllegatoRichiesta allegatoRichiesta = new AllegatoRichiestaImpl();

		allegatoRichiesta.setNew(true);
		allegatoRichiesta.setPrimaryKey(allegatoRichiestaId);

		String uuid = PortalUUIDUtil.generate();

		allegatoRichiesta.setUuid(uuid);

		allegatoRichiesta.setCompanyId(CompanyThreadLocal.getCompanyId());

		return allegatoRichiesta;
	}

	/**
	 * Removes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta remove(long allegatoRichiestaId)
		throws NoSuchAllegatoRichiestaException {

		return remove((Serializable)allegatoRichiestaId);
	}

	/**
	 * Removes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta remove(Serializable primaryKey)
		throws NoSuchAllegatoRichiestaException {

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta allegatoRichiesta =
				(AllegatoRichiesta)session.get(
					AllegatoRichiestaImpl.class, primaryKey);

			if (allegatoRichiesta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAllegatoRichiestaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(allegatoRichiesta);
		}
		catch (NoSuchAllegatoRichiestaException noSuchEntityException) {
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
	protected AllegatoRichiesta removeImpl(
		AllegatoRichiesta allegatoRichiesta) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(allegatoRichiesta)) {
				allegatoRichiesta = (AllegatoRichiesta)session.get(
					AllegatoRichiestaImpl.class,
					allegatoRichiesta.getPrimaryKeyObj());
			}

			if (allegatoRichiesta != null) {
				session.delete(allegatoRichiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (allegatoRichiesta != null) {
			clearCache(allegatoRichiesta);
		}

		return allegatoRichiesta;
	}

	@Override
	public AllegatoRichiesta updateImpl(AllegatoRichiesta allegatoRichiesta) {
		boolean isNew = allegatoRichiesta.isNew();

		if (!(allegatoRichiesta instanceof AllegatoRichiestaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(allegatoRichiesta.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					allegatoRichiesta);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in allegatoRichiesta proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AllegatoRichiesta implementation " +
					allegatoRichiesta.getClass());
		}

		AllegatoRichiestaModelImpl allegatoRichiestaModelImpl =
			(AllegatoRichiestaModelImpl)allegatoRichiesta;

		if (Validator.isNull(allegatoRichiesta.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			allegatoRichiesta.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (allegatoRichiesta.getCreateDate() == null)) {
			if (serviceContext == null) {
				allegatoRichiesta.setCreateDate(date);
			}
			else {
				allegatoRichiesta.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!allegatoRichiestaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				allegatoRichiesta.setModifiedDate(date);
			}
			else {
				allegatoRichiesta.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(allegatoRichiesta);
			}
			else {
				allegatoRichiesta = (AllegatoRichiesta)session.merge(
					allegatoRichiesta);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AllegatoRichiestaImpl.class, allegatoRichiestaModelImpl, false,
			true);

		cacheUniqueFindersCache(allegatoRichiestaModelImpl);

		if (isNew) {
			allegatoRichiesta.setNew(false);
		}

		allegatoRichiesta.resetOriginalValues();

		return allegatoRichiesta;
	}

	/**
	 * Returns the allegato richiesta with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByPrimaryKey(primaryKey);

		if (allegatoRichiesta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAllegatoRichiestaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return allegatoRichiesta;
	}

	/**
	 * Returns the allegato richiesta with the primary key or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta findByPrimaryKey(long allegatoRichiestaId)
		throws NoSuchAllegatoRichiestaException {

		return findByPrimaryKey((Serializable)allegatoRichiestaId);
	}

	/**
	 * Returns the allegato richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allegatoRichiestaId the primary key of the allegato richiesta
	 * @return the allegato richiesta, or <code>null</code> if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByPrimaryKey(long allegatoRichiestaId) {
		return fetchByPrimaryKey((Serializable)allegatoRichiestaId);
	}

	/**
	 * Returns all the allegato richiestas.
	 *
	 * @return the allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findAll(
		int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findAll(
		int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALLEGATORICHIESTA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALLEGATORICHIESTA;

				sql = sql.concat(AllegatoRichiestaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AllegatoRichiesta>)QueryUtil.list(
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
	 * Removes all the allegato richiestas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AllegatoRichiesta allegatoRichiesta : findAll()) {
			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas.
	 *
	 * @return the number of allegato richiestas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALLEGATORICHIESTA);

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
		return "allegatoRichiestaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALLEGATORICHIESTA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AllegatoRichiestaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the allegato richiesta persistence.
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

		_finderPathFetchByIdDocumentale = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByIdDocumentale",
			new String[] {String.class.getName()},
			new String[] {"idDocumentale"}, true);

		_finderPathCountByIdDocumentale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdDocumentale",
			new String[] {String.class.getName()},
			new String[] {"idDocumentale"}, false);

		_finderPathFetchByUrl = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUrl",
			new String[] {String.class.getName()}, new String[] {"url"}, true);

		_finderPathCountByUrl = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUrl",
			new String[] {String.class.getName()}, new String[] {"url"}, false);

		_finderPathFetchByRichiestaIdPrincipale = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRichiestaIdPrincipale",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"richiestaId", "principale"}, true);

		_finderPathCountByRichiestaIdPrincipale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRichiestaIdPrincipale",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"richiestaId", "principale"}, false);

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

		_finderPathWithPaginationFindByRichiestaIdInterno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRichiestaIdInterno",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"richiestaId", "interno"}, true);

		_finderPathWithoutPaginationFindByRichiestaIdInterno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRichiestaIdInterno",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"richiestaId", "interno"}, true);

		_finderPathCountByRichiestaIdInterno = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRichiestaIdInterno",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"richiestaId", "interno"}, false);

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

		_finderPathWithPaginationFindByRichiestaIdInternoVisibile =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRichiestaIdInternoVisibile",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Boolean.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"richiestaId", "interno", "visibile"}, true);

		_finderPathWithoutPaginationFindByRichiestaIdInternoVisibile =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRichiestaIdInternoVisibile",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Boolean.class.getName()
				},
				new String[] {"richiestaId", "interno", "visibile"}, true);

		_finderPathCountByRichiestaIdInternoVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRichiestaIdInternoVisibile",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"richiestaId", "interno", "visibile"}, false);

		_setAllegatoRichiestaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAllegatoRichiestaUtilPersistence(null);

		entityCache.removeCache(AllegatoRichiestaImpl.class.getName());
	}

	private void _setAllegatoRichiestaUtilPersistence(
		AllegatoRichiestaPersistence allegatoRichiestaPersistence) {

		try {
			Field field = AllegatoRichiestaUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, allegatoRichiestaPersistence);
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

	private static final String _SQL_SELECT_ALLEGATORICHIESTA =
		"SELECT allegatoRichiesta FROM AllegatoRichiesta allegatoRichiesta";

	private static final String _SQL_SELECT_ALLEGATORICHIESTA_WHERE =
		"SELECT allegatoRichiesta FROM AllegatoRichiesta allegatoRichiesta WHERE ";

	private static final String _SQL_COUNT_ALLEGATORICHIESTA =
		"SELECT COUNT(allegatoRichiesta) FROM AllegatoRichiesta allegatoRichiesta";

	private static final String _SQL_COUNT_ALLEGATORICHIESTA_WHERE =
		"SELECT COUNT(allegatoRichiesta) FROM AllegatoRichiesta allegatoRichiesta WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "allegatoRichiesta.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AllegatoRichiesta exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AllegatoRichiesta exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AllegatoRichiestaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AllegatoRichiestaModelArgumentsResolver
		_allegatoRichiestaModelArgumentsResolver;

}