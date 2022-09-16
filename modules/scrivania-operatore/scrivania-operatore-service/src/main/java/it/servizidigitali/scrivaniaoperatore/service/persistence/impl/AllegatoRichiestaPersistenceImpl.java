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
import it.servizidigitali.scrivaniaoperatore.service.persistence.AllegatoRichiestaPK;
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
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByUuid_PrevAndNext(
			AllegatoRichiestaPK allegatoRichiestaPK, String uuid,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		uuid = Objects.toString(uuid, "");

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaPK);

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
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByUuid_C_PrevAndNext(
			AllegatoRichiestaPK allegatoRichiestaPK, String uuid,
			long companyId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		uuid = Objects.toString(uuid, "");

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaPK);

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

	private FinderPath _finderPathFetchByR_P_G;
	private FinderPath _finderPathCountByR_P_G;

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; or throws a <code>NoSuchAllegatoRichiestaException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_P_G(
			long richiestaId, boolean principale, long groupId)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_P_G(
			richiestaId, principale, groupId);

		if (allegatoRichiesta == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("richiestaId=");
			sb.append(richiestaId);

			sb.append(", principale=");
			sb.append(principale);

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
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_P_G(
		long richiestaId, boolean principale, long groupId) {

		return fetchByR_P_G(richiestaId, principale, groupId, true);
	}

	/**
	 * Returns the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_P_G(
		long richiestaId, boolean principale, long groupId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {richiestaId, principale, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByR_P_G, finderArgs);
		}

		if (result instanceof AllegatoRichiesta) {
			AllegatoRichiesta allegatoRichiesta = (AllegatoRichiesta)result;

			if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
				(principale != allegatoRichiesta.isPrincipale()) ||
				(groupId != allegatoRichiesta.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_P_G_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_P_G_PRINCIPALE_2);

			sb.append(_FINDER_COLUMN_R_P_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(principale);

				queryPos.add(groupId);

				List<AllegatoRichiesta> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByR_P_G, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									richiestaId, principale, groupId
								};
							}

							_log.warn(
								"AllegatoRichiestaPersistenceImpl.fetchByR_P_G(long, boolean, long, boolean) with parameters (" +
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
	 * Removes the allegato richiesta where richiestaId = &#63; and principale = &#63; and groupId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the allegato richiesta that was removed
	 */
	@Override
	public AllegatoRichiesta removeByR_P_G(
			long richiestaId, boolean principale, long groupId)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByR_P_G(
			richiestaId, principale, groupId);

		return remove(allegatoRichiesta);
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and principale = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param principale the principale
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByR_P_G(
		long richiestaId, boolean principale, long groupId) {

		FinderPath finderPath = _finderPathCountByR_P_G;

		Object[] finderArgs = new Object[] {richiestaId, principale, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_P_G_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_P_G_PRINCIPALE_2);

			sb.append(_FINDER_COLUMN_R_P_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(principale);

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

	private static final String _FINDER_COLUMN_R_P_G_RICHIESTAID_2 =
		"allegatoRichiesta.id.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_R_P_G_PRINCIPALE_2 =
		"allegatoRichiesta.principale = ? AND ";

	private static final String _FINDER_COLUMN_R_P_G_GROUPID_2 =
		"allegatoRichiesta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByR_G;
	private FinderPath _finderPathWithoutPaginationFindByR_G;
	private FinderPath _finderPathCountByR_G;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G(long richiestaId, long groupId) {
		return findByR_G(
			richiestaId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId, int start, int end) {

		return findByR_G(richiestaId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByR_G(
			richiestaId, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G(
		long richiestaId, long groupId, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_G;
				finderArgs = new Object[] {richiestaId, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_G;
			finderArgs = new Object[] {
				richiestaId, groupId, start, end, orderByComparator
			};
		}

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(groupId != allegatoRichiesta.getGroupId())) {

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

			sb.append(_FINDER_COLUMN_R_G_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_GROUPID_2);

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

				queryPos.add(groupId);

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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_First(
			long richiestaId, long groupId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_First(
			richiestaId, groupId, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_First(
		long richiestaId, long groupId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByR_G(
			richiestaId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_Last(
			long richiestaId, long groupId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_Last(
			richiestaId, groupId, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_Last(
		long richiestaId, long groupId,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByR_G(richiestaId, groupId);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByR_G(
			richiestaId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByR_G_PrevAndNext(
			AllegatoRichiestaPK allegatoRichiestaPK, long richiestaId,
			long groupId,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaPK);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByR_G_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId,
				orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByR_G_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId,
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

	protected AllegatoRichiesta getByR_G_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		long groupId, OrderByComparator<AllegatoRichiesta> orderByComparator,
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

		sb.append(_FINDER_COLUMN_R_G_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_R_G_GROUPID_2);

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

		queryPos.add(groupId);

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
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByR_G(long richiestaId, long groupId) {
		for (AllegatoRichiesta allegatoRichiesta :
				findByR_G(
					richiestaId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByR_G(long richiestaId, long groupId) {
		FinderPath finderPath = _finderPathCountByR_G;

		Object[] finderArgs = new Object[] {richiestaId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_G_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

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

	private static final String _FINDER_COLUMN_R_G_RICHIESTAID_2 =
		"allegatoRichiesta.id.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_GROUPID_2 =
		"allegatoRichiesta.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByR_G_I;
	private FinderPath _finderPathWithoutPaginationFindByR_G_I;
	private FinderPath _finderPathCountByR_G_I;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno) {

		return findByR_G_I(
			richiestaId, groupId, interno, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno, int start, int end) {

		return findByR_G_I(richiestaId, groupId, interno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByR_G_I(
			richiestaId, groupId, interno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I(
		long richiestaId, long groupId, boolean interno, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_G_I;
				finderArgs = new Object[] {richiestaId, groupId, interno};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_G_I;
			finderArgs = new Object[] {
				richiestaId, groupId, interno, start, end, orderByComparator
			};
		}

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(groupId != allegatoRichiesta.getGroupId()) ||
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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_G_I_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_I_GROUPID_2);

			sb.append(_FINDER_COLUMN_R_G_I_INTERNO_2);

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

				queryPos.add(groupId);

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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_I_First(
			long richiestaId, long groupId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_I_First(
			richiestaId, groupId, interno, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_I_First(
		long richiestaId, long groupId, boolean interno,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByR_G_I(
			richiestaId, groupId, interno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_I_Last(
			long richiestaId, long groupId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_I_Last(
			richiestaId, groupId, interno, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_I_Last(
		long richiestaId, long groupId, boolean interno,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByR_G_I(richiestaId, groupId, interno);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByR_G_I(
			richiestaId, groupId, interno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByR_G_I_PrevAndNext(
			AllegatoRichiestaPK allegatoRichiestaPK, long richiestaId,
			long groupId, boolean interno,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaPK);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByR_G_I_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId, interno,
				orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByR_G_I_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId, interno,
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

	protected AllegatoRichiesta getByR_G_I_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		long groupId, boolean interno,
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

		sb.append(_FINDER_COLUMN_R_G_I_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_R_G_I_GROUPID_2);

		sb.append(_FINDER_COLUMN_R_G_I_INTERNO_2);

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

		queryPos.add(groupId);

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
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 */
	@Override
	public void removeByR_G_I(long richiestaId, long groupId, boolean interno) {
		for (AllegatoRichiesta allegatoRichiesta :
				findByR_G_I(
					richiestaId, groupId, interno, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByR_G_I(long richiestaId, long groupId, boolean interno) {
		FinderPath finderPath = _finderPathCountByR_G_I;

		Object[] finderArgs = new Object[] {richiestaId, groupId, interno};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_G_I_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_I_GROUPID_2);

			sb.append(_FINDER_COLUMN_R_G_I_INTERNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_R_G_I_RICHIESTAID_2 =
		"allegatoRichiesta.id.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_I_GROUPID_2 =
		"allegatoRichiesta.groupId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_I_INTERNO_2 =
		"allegatoRichiesta.interno = ?";

	private FinderPath _finderPathWithPaginationFindByR_G_V;
	private FinderPath _finderPathWithoutPaginationFindByR_G_V;
	private FinderPath _finderPathCountByR_G_V;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile) {

		return findByR_G_V(
			richiestaId, groupId, visibile, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile, int start, int end) {

		return findByR_G_V(richiestaId, groupId, visibile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByR_G_V(
			richiestaId, groupId, visibile, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_V(
		long richiestaId, long groupId, boolean visibile, int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_G_V;
				finderArgs = new Object[] {richiestaId, groupId, visibile};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_G_V;
			finderArgs = new Object[] {
				richiestaId, groupId, visibile, start, end, orderByComparator
			};
		}

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(groupId != allegatoRichiesta.getGroupId()) ||
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

			sb.append(_FINDER_COLUMN_R_G_V_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_V_GROUPID_2);

			sb.append(_FINDER_COLUMN_R_G_V_VISIBILE_2);

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

				queryPos.add(groupId);

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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_V_First(
			long richiestaId, long groupId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_V_First(
			richiestaId, groupId, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_V_First(
		long richiestaId, long groupId, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByR_G_V(
			richiestaId, groupId, visibile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_V_Last(
			long richiestaId, long groupId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_V_Last(
			richiestaId, groupId, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_V_Last(
		long richiestaId, long groupId, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByR_G_V(richiestaId, groupId, visibile);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByR_G_V(
			richiestaId, groupId, visibile, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByR_G_V_PrevAndNext(
			AllegatoRichiestaPK allegatoRichiestaPK, long richiestaId,
			long groupId, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaPK);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByR_G_V_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId, visibile,
				orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByR_G_V_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId, visibile,
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

	protected AllegatoRichiesta getByR_G_V_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		long groupId, boolean visibile,
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

		sb.append(_FINDER_COLUMN_R_G_V_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_R_G_V_GROUPID_2);

		sb.append(_FINDER_COLUMN_R_G_V_VISIBILE_2);

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

		queryPos.add(groupId);

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
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 */
	@Override
	public void removeByR_G_V(
		long richiestaId, long groupId, boolean visibile) {

		for (AllegatoRichiesta allegatoRichiesta :
				findByR_G_V(
					richiestaId, groupId, visibile, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByR_G_V(long richiestaId, long groupId, boolean visibile) {
		FinderPath finderPath = _finderPathCountByR_G_V;

		Object[] finderArgs = new Object[] {richiestaId, groupId, visibile};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_G_V_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_V_GROUPID_2);

			sb.append(_FINDER_COLUMN_R_G_V_VISIBILE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_R_G_V_RICHIESTAID_2 =
		"allegatoRichiesta.id.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_V_GROUPID_2 =
		"allegatoRichiesta.groupId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_V_VISIBILE_2 =
		"allegatoRichiesta.visibile = ?";

	private FinderPath _finderPathWithPaginationFindByR_G_I_V;
	private FinderPath _finderPathWithoutPaginationFindByR_G_I_V;
	private FinderPath _finderPathCountByR_G_I_V;

	/**
	 * Returns all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile) {

		return findByR_G_I_V(
			richiestaId, groupId, interno, visibile, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @return the range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		int start, int end) {

		return findByR_G_I_V(
			richiestaId, groupId, interno, visibile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		return findByR_G_I_V(
			richiestaId, groupId, interno, visibile, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllegatoRichiestaModelImpl</code>.
	 * </p>
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param start the lower bound of the range of allegato richiestas
	 * @param end the upper bound of the range of allegato richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allegato richiestas
	 */
	@Override
	public List<AllegatoRichiesta> findByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		int start, int end,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_G_I_V;
				finderArgs = new Object[] {
					richiestaId, groupId, interno, visibile
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_G_I_V;
			finderArgs = new Object[] {
				richiestaId, groupId, interno, visibile, start, end,
				orderByComparator
			};
		}

		List<AllegatoRichiesta> list = null;

		if (useFinderCache) {
			list = (List<AllegatoRichiesta>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AllegatoRichiesta allegatoRichiesta : list) {
					if ((richiestaId != allegatoRichiesta.getRichiestaId()) ||
						(groupId != allegatoRichiesta.getGroupId()) ||
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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_G_I_V_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_I_V_GROUPID_2);

			sb.append(_FINDER_COLUMN_R_G_I_V_INTERNO_2);

			sb.append(_FINDER_COLUMN_R_G_I_V_VISIBILE_2);

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

				queryPos.add(groupId);

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
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_I_V_First(
			long richiestaId, long groupId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_I_V_First(
			richiestaId, groupId, interno, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the first allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_I_V_First(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		List<AllegatoRichiesta> list = findByR_G_I_V(
			richiestaId, groupId, interno, visibile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta findByR_G_I_V_Last(
			long richiestaId, long groupId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = fetchByR_G_I_V_Last(
			richiestaId, groupId, interno, visibile, orderByComparator);

		if (allegatoRichiesta != null) {
			return allegatoRichiesta;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("richiestaId=");
		sb.append(richiestaId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", interno=");
		sb.append(interno);

		sb.append(", visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchAllegatoRichiestaException(sb.toString());
	}

	/**
	 * Returns the last allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allegato richiesta, or <code>null</code> if a matching allegato richiesta could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByR_G_I_V_Last(
		long richiestaId, long groupId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator) {

		int count = countByR_G_I_V(richiestaId, groupId, interno, visibile);

		if (count == 0) {
			return null;
		}

		List<AllegatoRichiesta> list = findByR_G_I_V(
			richiestaId, groupId, interno, visibile, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the allegato richiestas before and after the current allegato richiesta in the ordered set where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param allegatoRichiestaPK the primary key of the current allegato richiesta
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta[] findByR_G_I_V_PrevAndNext(
			AllegatoRichiestaPK allegatoRichiestaPK, long richiestaId,
			long groupId, boolean interno, boolean visibile,
			OrderByComparator<AllegatoRichiesta> orderByComparator)
		throws NoSuchAllegatoRichiestaException {

		AllegatoRichiesta allegatoRichiesta = findByPrimaryKey(
			allegatoRichiestaPK);

		Session session = null;

		try {
			session = openSession();

			AllegatoRichiesta[] array = new AllegatoRichiestaImpl[3];

			array[0] = getByR_G_I_V_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId, interno,
				visibile, orderByComparator, true);

			array[1] = allegatoRichiesta;

			array[2] = getByR_G_I_V_PrevAndNext(
				session, allegatoRichiesta, richiestaId, groupId, interno,
				visibile, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AllegatoRichiesta getByR_G_I_V_PrevAndNext(
		Session session, AllegatoRichiesta allegatoRichiesta, long richiestaId,
		long groupId, boolean interno, boolean visibile,
		OrderByComparator<AllegatoRichiesta> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_ALLEGATORICHIESTA_WHERE);

		sb.append(_FINDER_COLUMN_R_G_I_V_RICHIESTAID_2);

		sb.append(_FINDER_COLUMN_R_G_I_V_GROUPID_2);

		sb.append(_FINDER_COLUMN_R_G_I_V_INTERNO_2);

		sb.append(_FINDER_COLUMN_R_G_I_V_VISIBILE_2);

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

		queryPos.add(groupId);

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
	 * Removes all the allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 */
	@Override
	public void removeByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile) {

		for (AllegatoRichiesta allegatoRichiesta :
				findByR_G_I_V(
					richiestaId, groupId, interno, visibile, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(allegatoRichiesta);
		}
	}

	/**
	 * Returns the number of allegato richiestas where richiestaId = &#63; and groupId = &#63; and interno = &#63; and visibile = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @param groupId the group ID
	 * @param interno the interno
	 * @param visibile the visibile
	 * @return the number of matching allegato richiestas
	 */
	@Override
	public int countByR_G_I_V(
		long richiestaId, long groupId, boolean interno, boolean visibile) {

		FinderPath finderPath = _finderPathCountByR_G_I_V;

		Object[] finderArgs = new Object[] {
			richiestaId, groupId, interno, visibile
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_ALLEGATORICHIESTA_WHERE);

			sb.append(_FINDER_COLUMN_R_G_I_V_RICHIESTAID_2);

			sb.append(_FINDER_COLUMN_R_G_I_V_GROUPID_2);

			sb.append(_FINDER_COLUMN_R_G_I_V_INTERNO_2);

			sb.append(_FINDER_COLUMN_R_G_I_V_VISIBILE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_R_G_I_V_RICHIESTAID_2 =
		"allegatoRichiesta.id.richiestaId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_I_V_GROUPID_2 =
		"allegatoRichiesta.groupId = ? AND ";

	private static final String _FINDER_COLUMN_R_G_I_V_INTERNO_2 =
		"allegatoRichiesta.interno = ? AND ";

	private static final String _FINDER_COLUMN_R_G_I_V_VISIBILE_2 =
		"allegatoRichiesta.visibile = ?";

	public AllegatoRichiestaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AllegatoRichiesta.class);

		setModelImplClass(AllegatoRichiestaImpl.class);
		setModelPKClass(AllegatoRichiestaPK.class);

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
			_finderPathFetchByR_P_G,
			new Object[] {
				allegatoRichiesta.getRichiestaId(),
				allegatoRichiesta.isPrincipale(), allegatoRichiesta.getGroupId()
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
			allegatoRichiestaModelImpl.isPrincipale(),
			allegatoRichiestaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByR_P_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByR_P_G, args, allegatoRichiestaModelImpl);
	}

	/**
	 * Creates a new allegato richiesta with the primary key. Does not add the allegato richiesta to the database.
	 *
	 * @param allegatoRichiestaPK the primary key for the new allegato richiesta
	 * @return the new allegato richiesta
	 */
	@Override
	public AllegatoRichiesta create(AllegatoRichiestaPK allegatoRichiestaPK) {
		AllegatoRichiesta allegatoRichiesta = new AllegatoRichiestaImpl();

		allegatoRichiesta.setNew(true);
		allegatoRichiesta.setPrimaryKey(allegatoRichiestaPK);

		String uuid = PortalUUIDUtil.generate();

		allegatoRichiesta.setUuid(uuid);

		allegatoRichiesta.setCompanyId(CompanyThreadLocal.getCompanyId());

		return allegatoRichiesta;
	}

	/**
	 * Removes the allegato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta that was removed
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta remove(AllegatoRichiestaPK allegatoRichiestaPK)
		throws NoSuchAllegatoRichiestaException {

		return remove((Serializable)allegatoRichiestaPK);
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
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta
	 * @throws NoSuchAllegatoRichiestaException if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta findByPrimaryKey(
			AllegatoRichiestaPK allegatoRichiestaPK)
		throws NoSuchAllegatoRichiestaException {

		return findByPrimaryKey((Serializable)allegatoRichiestaPK);
	}

	/**
	 * Returns the allegato richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allegatoRichiestaPK the primary key of the allegato richiesta
	 * @return the allegato richiesta, or <code>null</code> if a allegato richiesta with the primary key could not be found
	 */
	@Override
	public AllegatoRichiesta fetchByPrimaryKey(
		AllegatoRichiestaPK allegatoRichiestaPK) {

		return fetchByPrimaryKey((Serializable)allegatoRichiestaPK);
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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "allegatoRichiestaPK";
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

		_finderPathFetchByR_P_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByR_P_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			new String[] {"richiestaId", "principale", "groupId"}, true);

		_finderPathCountByR_P_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_P_G",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			new String[] {"richiestaId", "principale", "groupId"}, false);

		_finderPathWithPaginationFindByR_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"richiestaId", "groupId"}, true);

		_finderPathWithoutPaginationFindByR_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"richiestaId", "groupId"}, true);

		_finderPathCountByR_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"richiestaId", "groupId"}, false);

		_finderPathWithPaginationFindByR_G_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_G_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"richiestaId", "groupId", "interno"}, true);

		_finderPathWithoutPaginationFindByR_G_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_G_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"richiestaId", "groupId", "interno"}, true);

		_finderPathCountByR_G_I = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_G_I",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"richiestaId", "groupId", "interno"}, false);

		_finderPathWithPaginationFindByR_G_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_G_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"richiestaId", "groupId", "visibile"}, true);

		_finderPathWithoutPaginationFindByR_G_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_G_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"richiestaId", "groupId", "visibile"}, true);

		_finderPathCountByR_G_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_G_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"richiestaId", "groupId", "visibile"}, false);

		_finderPathWithPaginationFindByR_G_I_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_G_I_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"richiestaId", "groupId", "interno", "visibile"},
			true);

		_finderPathWithoutPaginationFindByR_G_I_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_G_I_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Boolean.class.getName()
			},
			new String[] {"richiestaId", "groupId", "interno", "visibile"},
			true);

		_finderPathCountByR_G_I_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_G_I_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Boolean.class.getName()
			},
			new String[] {"richiestaId", "groupId", "interno", "visibile"},
			false);

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
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"richiestaId", "fileEntryId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AllegatoRichiestaModelArgumentsResolver
		_allegatoRichiestaModelArgumentsResolver;

}