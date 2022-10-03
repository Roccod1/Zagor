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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchDestinazioneUsoException;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUso;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoUtil;
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
 * The persistence implementation for the destinazione uso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DestinazioneUsoPersistence.class, BasePersistence.class})
public class DestinazioneUsoPersistenceImpl
	extends BasePersistenceImpl<DestinazioneUso>
	implements DestinazioneUsoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DestinazioneUsoUtil</code> to access the destinazione uso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DestinazioneUsoImpl.class.getName();

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
	 * Returns all the destinazione usos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
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

		List<DestinazioneUso> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUso>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUso destinazioneUso : list) {
					if (!uuid.equals(destinazioneUso.getUuid())) {
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

			sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

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
				sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
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

				list = (List<DestinazioneUso>)QueryUtil.list(
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
	 * Returns the first destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByUuid_First(
			String uuid, OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByUuid_First(
			uuid, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByUuid_First(
		String uuid, OrderByComparator<DestinazioneUso> orderByComparator) {

		List<DestinazioneUso> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByUuid_Last(
			String uuid, OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByUuid_Last(
			uuid, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByUuid_Last(
		String uuid, OrderByComparator<DestinazioneUso> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUso> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where uuid = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso[] findByUuid_PrevAndNext(
			long destinazioneUsoId, String uuid,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		uuid = Objects.toString(uuid, "");

		DestinazioneUso destinazioneUso = findByPrimaryKey(destinazioneUsoId);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUso[] array = new DestinazioneUsoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, destinazioneUso, uuid, orderByComparator, true);

			array[1] = destinazioneUso;

			array[2] = getByUuid_PrevAndNext(
				session, destinazioneUso, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DestinazioneUso getByUuid_PrevAndNext(
		Session session, DestinazioneUso destinazioneUso, String uuid,
		OrderByComparator<DestinazioneUso> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

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
			sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
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
						destinazioneUso)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUso> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione usos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DestinazioneUso destinazioneUso :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(destinazioneUso);
		}
	}

	/**
	 * Returns the number of destinazione usos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching destinazione usos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESTINAZIONEUSO_WHERE);

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
		"destinazioneUso.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(destinazioneUso.uuid IS NULL OR destinazioneUso.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDestinazioneUsoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByUUID_G(uuid, groupId);

		if (destinazioneUso == null) {
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

			throw new NoSuchDestinazioneUsoException(sb.toString());
		}

		return destinazioneUso;
	}

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the destinazione uso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByUUID_G(
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

		if (result instanceof DestinazioneUso) {
			DestinazioneUso destinazioneUso = (DestinazioneUso)result;

			if (!Objects.equals(uuid, destinazioneUso.getUuid()) ||
				(groupId != destinazioneUso.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

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

				List<DestinazioneUso> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DestinazioneUso destinazioneUso = list.get(0);

					result = destinazioneUso;

					cacheResult(destinazioneUso);
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
			return (DestinazioneUso)result;
		}
	}

	/**
	 * Removes the destinazione uso where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the destinazione uso that was removed
	 */
	@Override
	public DestinazioneUso removeByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = findByUUID_G(uuid, groupId);

		return remove(destinazioneUso);
	}

	/**
	 * Returns the number of destinazione usos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching destinazione usos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESTINAZIONEUSO_WHERE);

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
		"destinazioneUso.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(destinazioneUso.uuid IS NULL OR destinazioneUso.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"destinazioneUso.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
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

		List<DestinazioneUso> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUso>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUso destinazioneUso : list) {
					if (!uuid.equals(destinazioneUso.getUuid()) ||
						(companyId != destinazioneUso.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

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
				sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
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

				list = (List<DestinazioneUso>)QueryUtil.list(
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
	 * Returns the first destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		List<DestinazioneUso> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUso> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso[] findByUuid_C_PrevAndNext(
			long destinazioneUsoId, String uuid, long companyId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		uuid = Objects.toString(uuid, "");

		DestinazioneUso destinazioneUso = findByPrimaryKey(destinazioneUsoId);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUso[] array = new DestinazioneUsoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, destinazioneUso, uuid, companyId, orderByComparator,
				true);

			array[1] = destinazioneUso;

			array[2] = getByUuid_C_PrevAndNext(
				session, destinazioneUso, uuid, companyId, orderByComparator,
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

	protected DestinazioneUso getByUuid_C_PrevAndNext(
		Session session, DestinazioneUso destinazioneUso, String uuid,
		long companyId, OrderByComparator<DestinazioneUso> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

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
			sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
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
						destinazioneUso)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUso> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione usos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DestinazioneUso destinazioneUso :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(destinazioneUso);
		}
	}

	/**
	 * Returns the number of destinazione usos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching destinazione usos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESTINAZIONEUSO_WHERE);

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
		"destinazioneUso.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(destinazioneUso.uuid IS NULL OR destinazioneUso.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"destinazioneUso.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the destinazione usos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<DestinazioneUso> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUso>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUso destinazioneUso : list) {
					if (groupId != destinazioneUso.getGroupId()) {
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

			sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<DestinazioneUso>)QueryUtil.list(
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
	 * Returns the first destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByGroupId_First(
			long groupId, OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByGroupId_First(
			groupId, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByGroupId_First(
		long groupId, OrderByComparator<DestinazioneUso> orderByComparator) {

		List<DestinazioneUso> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByGroupId_Last(
			long groupId, OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByGroupId_Last(
		long groupId, OrderByComparator<DestinazioneUso> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUso> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where groupId = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso[] findByGroupId_PrevAndNext(
			long destinazioneUsoId, long groupId,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = findByPrimaryKey(destinazioneUsoId);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUso[] array = new DestinazioneUsoImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, destinazioneUso, groupId, orderByComparator, true);

			array[1] = destinazioneUso;

			array[2] = getByGroupId_PrevAndNext(
				session, destinazioneUso, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DestinazioneUso getByGroupId_PrevAndNext(
		Session session, DestinazioneUso destinazioneUso, long groupId,
		OrderByComparator<DestinazioneUso> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						destinazioneUso)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUso> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione usos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (DestinazioneUso destinazioneUso :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(destinazioneUso);
		}
	}

	/**
	 * Returns the number of destinazione usos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching destinazione usos
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESTINAZIONEUSO_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"destinazioneUso.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPagamentoBollo;
	private FinderPath _finderPathWithoutPaginationFindByPagamentoBollo;
	private FinderPath _finderPathCountByPagamentoBollo;

	/**
	 * Returns all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @return the matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByPagamentoBollo(boolean pagamentoBollo) {
		return findByPagamentoBollo(
			pagamentoBollo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end) {

		return findByPagamentoBollo(pagamentoBollo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return findByPagamentoBollo(
			pagamentoBollo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione usos where pagamentoBollo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findByPagamentoBollo(
		boolean pagamentoBollo, int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPagamentoBollo;
				finderArgs = new Object[] {pagamentoBollo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPagamentoBollo;
			finderArgs = new Object[] {
				pagamentoBollo, start, end, orderByComparator
			};
		}

		List<DestinazioneUso> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUso>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUso destinazioneUso : list) {
					if (pagamentoBollo != destinazioneUso.isPagamentoBollo()) {
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

			sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

			sb.append(_FINDER_COLUMN_PAGAMENTOBOLLO_PAGAMENTOBOLLO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(pagamentoBollo);

				list = (List<DestinazioneUso>)QueryUtil.list(
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
	 * Returns the first destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByPagamentoBollo_First(
			boolean pagamentoBollo,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByPagamentoBollo_First(
			pagamentoBollo, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pagamentoBollo=");
		sb.append(pagamentoBollo);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByPagamentoBollo_First(
		boolean pagamentoBollo,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		List<DestinazioneUso> list = findByPagamentoBollo(
			pagamentoBollo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso findByPagamentoBollo_Last(
			boolean pagamentoBollo,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByPagamentoBollo_Last(
			pagamentoBollo, orderByComparator);

		if (destinazioneUso != null) {
			return destinazioneUso;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pagamentoBollo=");
		sb.append(pagamentoBollo);

		sb.append("}");

		throw new NoSuchDestinazioneUsoException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso, or <code>null</code> if a matching destinazione uso could not be found
	 */
	@Override
	public DestinazioneUso fetchByPagamentoBollo_Last(
		boolean pagamentoBollo,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		int count = countByPagamentoBollo(pagamentoBollo);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUso> list = findByPagamentoBollo(
			pagamentoBollo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione usos before and after the current destinazione uso in the ordered set where pagamentoBollo = &#63;.
	 *
	 * @param destinazioneUsoId the primary key of the current destinazione uso
	 * @param pagamentoBollo the pagamento bollo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso[] findByPagamentoBollo_PrevAndNext(
			long destinazioneUsoId, boolean pagamentoBollo,
			OrderByComparator<DestinazioneUso> orderByComparator)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = findByPrimaryKey(destinazioneUsoId);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUso[] array = new DestinazioneUsoImpl[3];

			array[0] = getByPagamentoBollo_PrevAndNext(
				session, destinazioneUso, pagamentoBollo, orderByComparator,
				true);

			array[1] = destinazioneUso;

			array[2] = getByPagamentoBollo_PrevAndNext(
				session, destinazioneUso, pagamentoBollo, orderByComparator,
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

	protected DestinazioneUso getByPagamentoBollo_PrevAndNext(
		Session session, DestinazioneUso destinazioneUso,
		boolean pagamentoBollo,
		OrderByComparator<DestinazioneUso> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSO_WHERE);

		sb.append(_FINDER_COLUMN_PAGAMENTOBOLLO_PAGAMENTOBOLLO_2);

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
			sb.append(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(pagamentoBollo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						destinazioneUso)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUso> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione usos where pagamentoBollo = &#63; from the database.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 */
	@Override
	public void removeByPagamentoBollo(boolean pagamentoBollo) {
		for (DestinazioneUso destinazioneUso :
				findByPagamentoBollo(
					pagamentoBollo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(destinazioneUso);
		}
	}

	/**
	 * Returns the number of destinazione usos where pagamentoBollo = &#63;.
	 *
	 * @param pagamentoBollo the pagamento bollo
	 * @return the number of matching destinazione usos
	 */
	@Override
	public int countByPagamentoBollo(boolean pagamentoBollo) {
		FinderPath finderPath = _finderPathCountByPagamentoBollo;

		Object[] finderArgs = new Object[] {pagamentoBollo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESTINAZIONEUSO_WHERE);

			sb.append(_FINDER_COLUMN_PAGAMENTOBOLLO_PAGAMENTOBOLLO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(pagamentoBollo);

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

	private static final String _FINDER_COLUMN_PAGAMENTOBOLLO_PAGAMENTOBOLLO_2 =
		"destinazioneUso.pagamentoBollo = ?";

	public DestinazioneUsoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DestinazioneUso.class);

		setModelImplClass(DestinazioneUsoImpl.class);
		setModelPKClass(long.class);

		setTable(DestinazioneUsoTable.INSTANCE);
	}

	/**
	 * Caches the destinazione uso in the entity cache if it is enabled.
	 *
	 * @param destinazioneUso the destinazione uso
	 */
	@Override
	public void cacheResult(DestinazioneUso destinazioneUso) {
		entityCache.putResult(
			DestinazioneUsoImpl.class, destinazioneUso.getPrimaryKey(),
			destinazioneUso);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				destinazioneUso.getUuid(), destinazioneUso.getGroupId()
			},
			destinazioneUso);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the destinazione usos in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsos the destinazione usos
	 */
	@Override
	public void cacheResult(List<DestinazioneUso> destinazioneUsos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (destinazioneUsos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DestinazioneUso destinazioneUso : destinazioneUsos) {
			if (entityCache.getResult(
					DestinazioneUsoImpl.class,
					destinazioneUso.getPrimaryKey()) == null) {

				cacheResult(destinazioneUso);
			}
		}
	}

	/**
	 * Clears the cache for all destinazione usos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DestinazioneUsoImpl.class);

		finderCache.clearCache(DestinazioneUsoImpl.class);
	}

	/**
	 * Clears the cache for the destinazione uso.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DestinazioneUso destinazioneUso) {
		entityCache.removeResult(DestinazioneUsoImpl.class, destinazioneUso);
	}

	@Override
	public void clearCache(List<DestinazioneUso> destinazioneUsos) {
		for (DestinazioneUso destinazioneUso : destinazioneUsos) {
			entityCache.removeResult(
				DestinazioneUsoImpl.class, destinazioneUso);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DestinazioneUsoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DestinazioneUsoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DestinazioneUsoModelImpl destinazioneUsoModelImpl) {

		Object[] args = new Object[] {
			destinazioneUsoModelImpl.getUuid(),
			destinazioneUsoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, destinazioneUsoModelImpl);
	}

	/**
	 * Creates a new destinazione uso with the primary key. Does not add the destinazione uso to the database.
	 *
	 * @param destinazioneUsoId the primary key for the new destinazione uso
	 * @return the new destinazione uso
	 */
	@Override
	public DestinazioneUso create(long destinazioneUsoId) {
		DestinazioneUso destinazioneUso = new DestinazioneUsoImpl();

		destinazioneUso.setNew(true);
		destinazioneUso.setPrimaryKey(destinazioneUsoId);

		String uuid = PortalUUIDUtil.generate();

		destinazioneUso.setUuid(uuid);

		destinazioneUso.setCompanyId(CompanyThreadLocal.getCompanyId());

		return destinazioneUso;
	}

	/**
	 * Removes the destinazione uso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso that was removed
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso remove(long destinazioneUsoId)
		throws NoSuchDestinazioneUsoException {

		return remove((Serializable)destinazioneUsoId);
	}

	/**
	 * Removes the destinazione uso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the destinazione uso
	 * @return the destinazione uso that was removed
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso remove(Serializable primaryKey)
		throws NoSuchDestinazioneUsoException {

		Session session = null;

		try {
			session = openSession();

			DestinazioneUso destinazioneUso = (DestinazioneUso)session.get(
				DestinazioneUsoImpl.class, primaryKey);

			if (destinazioneUso == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDestinazioneUsoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(destinazioneUso);
		}
		catch (NoSuchDestinazioneUsoException noSuchEntityException) {
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
	protected DestinazioneUso removeImpl(DestinazioneUso destinazioneUso) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(destinazioneUso)) {
				destinazioneUso = (DestinazioneUso)session.get(
					DestinazioneUsoImpl.class,
					destinazioneUso.getPrimaryKeyObj());
			}

			if (destinazioneUso != null) {
				session.delete(destinazioneUso);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (destinazioneUso != null) {
			clearCache(destinazioneUso);
		}

		return destinazioneUso;
	}

	@Override
	public DestinazioneUso updateImpl(DestinazioneUso destinazioneUso) {
		boolean isNew = destinazioneUso.isNew();

		if (!(destinazioneUso instanceof DestinazioneUsoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(destinazioneUso.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					destinazioneUso);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in destinazioneUso proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DestinazioneUso implementation " +
					destinazioneUso.getClass());
		}

		DestinazioneUsoModelImpl destinazioneUsoModelImpl =
			(DestinazioneUsoModelImpl)destinazioneUso;

		if (Validator.isNull(destinazioneUso.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			destinazioneUso.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (destinazioneUso.getCreateDate() == null)) {
			if (serviceContext == null) {
				destinazioneUso.setCreateDate(date);
			}
			else {
				destinazioneUso.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!destinazioneUsoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				destinazioneUso.setModifiedDate(date);
			}
			else {
				destinazioneUso.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(destinazioneUso);
			}
			else {
				destinazioneUso = (DestinazioneUso)session.merge(
					destinazioneUso);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DestinazioneUsoImpl.class, destinazioneUsoModelImpl, false, true);

		cacheUniqueFindersCache(destinazioneUsoModelImpl);

		if (isNew) {
			destinazioneUso.setNew(false);
		}

		destinazioneUso.resetOriginalValues();

		return destinazioneUso;
	}

	/**
	 * Returns the destinazione uso with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the destinazione uso
	 * @return the destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDestinazioneUsoException {

		DestinazioneUso destinazioneUso = fetchByPrimaryKey(primaryKey);

		if (destinazioneUso == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDestinazioneUsoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return destinazioneUso;
	}

	/**
	 * Returns the destinazione uso with the primary key or throws a <code>NoSuchDestinazioneUsoException</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso
	 * @throws NoSuchDestinazioneUsoException if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso findByPrimaryKey(long destinazioneUsoId)
		throws NoSuchDestinazioneUsoException {

		return findByPrimaryKey((Serializable)destinazioneUsoId);
	}

	/**
	 * Returns the destinazione uso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the primary key of the destinazione uso
	 * @return the destinazione uso, or <code>null</code> if a destinazione uso with the primary key could not be found
	 */
	@Override
	public DestinazioneUso fetchByPrimaryKey(long destinazioneUsoId) {
		return fetchByPrimaryKey((Serializable)destinazioneUsoId);
	}

	/**
	 * Returns all the destinazione usos.
	 *
	 * @return the destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @return the range of destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione usos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione usos
	 * @param end the upper bound of the range of destinazione usos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of destinazione usos
	 */
	@Override
	public List<DestinazioneUso> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUso> orderByComparator,
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

		List<DestinazioneUso> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUso>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESTINAZIONEUSO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESTINAZIONEUSO;

				sql = sql.concat(DestinazioneUsoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DestinazioneUso>)QueryUtil.list(
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
	 * Removes all the destinazione usos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DestinazioneUso destinazioneUso : findAll()) {
			remove(destinazioneUso);
		}
	}

	/**
	 * Returns the number of destinazione usos.
	 *
	 * @return the number of destinazione usos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESTINAZIONEUSO);

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
		return "destinazioneUsoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESTINAZIONEUSO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DestinazioneUsoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the destinazione uso persistence.
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

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByPagamentoBollo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPagamentoBollo",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"pagamentoBollo"}, true);

		_finderPathWithoutPaginationFindByPagamentoBollo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPagamentoBollo",
			new String[] {Boolean.class.getName()},
			new String[] {"pagamentoBollo"}, true);

		_finderPathCountByPagamentoBollo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPagamentoBollo",
			new String[] {Boolean.class.getName()},
			new String[] {"pagamentoBollo"}, false);

		_setDestinazioneUsoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDestinazioneUsoUtilPersistence(null);

		entityCache.removeCache(DestinazioneUsoImpl.class.getName());
	}

	private void _setDestinazioneUsoUtilPersistence(
		DestinazioneUsoPersistence destinazioneUsoPersistence) {

		try {
			Field field = DestinazioneUsoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, destinazioneUsoPersistence);
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

	private static final String _SQL_SELECT_DESTINAZIONEUSO =
		"SELECT destinazioneUso FROM DestinazioneUso destinazioneUso";

	private static final String _SQL_SELECT_DESTINAZIONEUSO_WHERE =
		"SELECT destinazioneUso FROM DestinazioneUso destinazioneUso WHERE ";

	private static final String _SQL_COUNT_DESTINAZIONEUSO =
		"SELECT COUNT(destinazioneUso) FROM DestinazioneUso destinazioneUso";

	private static final String _SQL_COUNT_DESTINAZIONEUSO_WHERE =
		"SELECT COUNT(destinazioneUso) FROM DestinazioneUso destinazioneUso WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "destinazioneUso.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DestinazioneUso exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DestinazioneUso exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DestinazioneUsoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DestinazioneUsoModelArgumentsResolver
		_destinazioneUsoModelArgumentsResolver;

}