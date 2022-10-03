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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchDestinazioneUsoServizioEnteException;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnte;
import it.servizidigitali.scrivaniaoperatore.model.DestinazioneUsoServizioEnteTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.DestinazioneUsoServizioEnteModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoServizioEntePK;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoServizioEntePersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.DestinazioneUsoServizioEnteUtil;
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
 * The persistence implementation for the destinazione uso servizio ente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {
		DestinazioneUsoServizioEntePersistence.class, BasePersistence.class
	}
)
public class DestinazioneUsoServizioEntePersistenceImpl
	extends BasePersistenceImpl<DestinazioneUsoServizioEnte>
	implements DestinazioneUsoServizioEntePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DestinazioneUsoServizioEnteUtil</code> to access the destinazione uso servizio ente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DestinazioneUsoServizioEnteImpl.class.getName();

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
	 * Returns all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
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

		List<DestinazioneUsoServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUsoServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
						list) {

					if (!uuid.equals(destinazioneUsoServizioEnte.getUuid())) {
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

			sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
				sb.append(DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
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

				list = (List<DestinazioneUsoServizioEnte>)QueryUtil.list(
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
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByUuid_First(
			String uuid,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByUuid_First(uuid, orderByComparator);

		if (destinazioneUsoServizioEnte != null) {
			return destinazioneUsoServizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByUuid_First(
		String uuid,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		List<DestinazioneUsoServizioEnte> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByUuid_Last(
			String uuid,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByUuid_Last(uuid, orderByComparator);

		if (destinazioneUsoServizioEnte != null) {
			return destinazioneUsoServizioEnte;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByUuid_Last(
		String uuid,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUsoServizioEnte> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where uuid = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte[] findByUuid_PrevAndNext(
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			String uuid,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		uuid = Objects.toString(uuid, "");

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			findByPrimaryKey(destinazioneUsoServizioEntePK);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUsoServizioEnte[] array =
				new DestinazioneUsoServizioEnteImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, destinazioneUsoServizioEnte, uuid, orderByComparator,
				true);

			array[1] = destinazioneUsoServizioEnte;

			array[2] = getByUuid_PrevAndNext(
				session, destinazioneUsoServizioEnte, uuid, orderByComparator,
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

	protected DestinazioneUsoServizioEnte getByUuid_PrevAndNext(
		Session session,
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte, String uuid,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
			sb.append(DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
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
						destinazioneUsoServizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUsoServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione uso servizio entes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(destinazioneUsoServizioEnte);
		}
	}

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching destinazione uso servizio entes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
		"destinazioneUsoServizioEnte.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(destinazioneUsoServizioEnte.uuid IS NULL OR destinazioneUsoServizioEnte.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte = fetchByUUID_G(
			uuid, groupId);

		if (destinazioneUsoServizioEnte == null) {
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

			throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
		}

		return destinazioneUsoServizioEnte;
	}

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByUUID_G(
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

		if (result instanceof DestinazioneUsoServizioEnte) {
			DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
				(DestinazioneUsoServizioEnte)result;

			if (!Objects.equals(uuid, destinazioneUsoServizioEnte.getUuid()) ||
				(groupId != destinazioneUsoServizioEnte.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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

				List<DestinazioneUsoServizioEnte> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
						list.get(0);

					result = destinazioneUsoServizioEnte;

					cacheResult(destinazioneUsoServizioEnte);
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
			return (DestinazioneUsoServizioEnte)result;
		}
	}

	/**
	 * Removes the destinazione uso servizio ente where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the destinazione uso servizio ente that was removed
	 */
	@Override
	public DestinazioneUsoServizioEnte removeByUUID_G(String uuid, long groupId)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte = findByUUID_G(
			uuid, groupId);

		return remove(destinazioneUsoServizioEnte);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
		"destinazioneUsoServizioEnte.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(destinazioneUsoServizioEnte.uuid IS NULL OR destinazioneUsoServizioEnte.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"destinazioneUsoServizioEnte.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
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

		List<DestinazioneUsoServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUsoServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
						list) {

					if (!uuid.equals(destinazioneUsoServizioEnte.getUuid()) ||
						(companyId !=
							destinazioneUsoServizioEnte.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
				sb.append(DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
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

				list = (List<DestinazioneUsoServizioEnte>)QueryUtil.list(
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
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (destinazioneUsoServizioEnte != null) {
			return destinazioneUsoServizioEnte;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		List<DestinazioneUsoServizioEnte> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (destinazioneUsoServizioEnte != null) {
			return destinazioneUsoServizioEnte;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUsoServizioEnte> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte[] findByUuid_C_PrevAndNext(
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
			String uuid, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		uuid = Objects.toString(uuid, "");

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			findByPrimaryKey(destinazioneUsoServizioEntePK);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUsoServizioEnte[] array =
				new DestinazioneUsoServizioEnteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, destinazioneUsoServizioEnte, uuid, companyId,
				orderByComparator, true);

			array[1] = destinazioneUsoServizioEnte;

			array[2] = getByUuid_C_PrevAndNext(
				session, destinazioneUsoServizioEnte, uuid, companyId,
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

	protected DestinazioneUsoServizioEnte getByUuid_C_PrevAndNext(
		Session session,
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte, String uuid,
		long companyId,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
			sb.append(DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
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
						destinazioneUsoServizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUsoServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione uso servizio entes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(destinazioneUsoServizioEnte);
		}
	}

	/**
	 * Returns the number of destinazione uso servizio entes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

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
		"destinazioneUsoServizioEnte.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(destinazioneUsoServizioEnte.uuid IS NULL OR destinazioneUsoServizioEnte.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"destinazioneUsoServizioEnte.companyId = ?";

	private FinderPath
		_finderPathFetchByDestinazioneUsoIdServizioIdOrganizationId;
	private FinderPath
		_finderPathCountByDestinazioneUsoIdServizioIdOrganizationId;

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
			findByDestinazioneUsoIdServizioIdOrganizationId(
				long destinazioneUsoId, long servizioId, long organizationId)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByDestinazioneUsoIdServizioIdOrganizationId(
				destinazioneUsoId, servizioId, organizationId);

		if (destinazioneUsoServizioEnte == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("destinazioneUsoId=");
			sb.append(destinazioneUsoId);

			sb.append(", servizioId=");
			sb.append(servizioId);

			sb.append(", organizationId=");
			sb.append(organizationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
		}

		return destinazioneUsoServizioEnte;
	}

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
		fetchByDestinazioneUsoIdServizioIdOrganizationId(
			long destinazioneUsoId, long servizioId, long organizationId) {

		return fetchByDestinazioneUsoIdServizioIdOrganizationId(
			destinazioneUsoId, servizioId, organizationId, true);
	}

	/**
	 * Returns the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
		fetchByDestinazioneUsoIdServizioIdOrganizationId(
			long destinazioneUsoId, long servizioId, long organizationId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				destinazioneUsoId, servizioId, organizationId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDestinazioneUsoIdServizioIdOrganizationId,
				finderArgs);
		}

		if (result instanceof DestinazioneUsoServizioEnte) {
			DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
				(DestinazioneUsoServizioEnte)result;

			if ((destinazioneUsoId !=
					destinazioneUsoServizioEnte.getDestinazioneUsoId()) ||
				(servizioId != destinazioneUsoServizioEnte.getServizioId()) ||
				(organizationId !=
					destinazioneUsoServizioEnte.getOrganizationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

			sb.append(
				_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_DESTINAZIONEUSOID_2);

			sb.append(
				_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_SERVIZIOID_2);

			sb.append(
				_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinazioneUsoId);

				queryPos.add(servizioId);

				queryPos.add(organizationId);

				List<DestinazioneUsoServizioEnte> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDestinazioneUsoIdServizioIdOrganizationId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									destinazioneUsoId, servizioId,
									organizationId
								};
							}

							_log.warn(
								"DestinazioneUsoServizioEntePersistenceImpl.fetchByDestinazioneUsoIdServizioIdOrganizationId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
						list.get(0);

					result = destinazioneUsoServizioEnte;

					cacheResult(destinazioneUsoServizioEnte);
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
			return (DestinazioneUsoServizioEnte)result;
		}
	}

	/**
	 * Removes the destinazione uso servizio ente where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the destinazione uso servizio ente that was removed
	 */
	@Override
	public DestinazioneUsoServizioEnte
			removeByDestinazioneUsoIdServizioIdOrganizationId(
				long destinazioneUsoId, long servizioId, long organizationId)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			findByDestinazioneUsoIdServizioIdOrganizationId(
				destinazioneUsoId, servizioId, organizationId);

		return remove(destinazioneUsoServizioEnte);
	}

	/**
	 * Returns the number of destinazione uso servizio entes where destinazioneUsoId = &#63; and servizioId = &#63; and organizationId = &#63;.
	 *
	 * @param destinazioneUsoId the destinazione uso ID
	 * @param servizioId the servizio ID
	 * @param organizationId the organization ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	@Override
	public int countByDestinazioneUsoIdServizioIdOrganizationId(
		long destinazioneUsoId, long servizioId, long organizationId) {

		FinderPath finderPath =
			_finderPathCountByDestinazioneUsoIdServizioIdOrganizationId;

		Object[] finderArgs = new Object[] {
			destinazioneUsoId, servizioId, organizationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

			sb.append(
				_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_DESTINAZIONEUSOID_2);

			sb.append(
				_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_SERVIZIOID_2);

			sb.append(
				_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinazioneUsoId);

				queryPos.add(servizioId);

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

	private static final String
		_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_DESTINAZIONEUSOID_2 =
			"destinazioneUsoServizioEnte.id.destinazioneUsoId = ? AND ";

	private static final String
		_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_SERVIZIOID_2 =
			"destinazioneUsoServizioEnte.id.servizioId = ? AND ";

	private static final String
		_FINDER_COLUMN_DESTINAZIONEUSOIDSERVIZIOIDORGANIZATIONID_ORGANIZATIONID_2 =
			"destinazioneUsoServizioEnte.id.organizationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByOrganizationIdGroupIdCompanyId;
	private FinderPath
		_finderPathWithoutPaginationFindByOrganizationIdGroupIdCompanyId;
	private FinderPath _finderPathCountByOrganizationIdGroupIdCompanyId;

	/**
	 * Returns all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId) {

		return findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end) {

		return findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return findByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte>
		findByOrganizationIdGroupIdCompanyId(
			long organizationId, long groupId, long companyId, int start,
			int end,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByOrganizationIdGroupIdCompanyId;
				finderArgs = new Object[] {organizationId, groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByOrganizationIdGroupIdCompanyId;
			finderArgs = new Object[] {
				organizationId, groupId, companyId, start, end,
				orderByComparator
			};
		}

		List<DestinazioneUsoServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUsoServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
						list) {

					if ((organizationId !=
							destinazioneUsoServizioEnte.getOrganizationId()) ||
						(groupId != destinazioneUsoServizioEnte.getGroupId()) ||
						(companyId !=
							destinazioneUsoServizioEnte.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

			sb.append(
				_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_ORGANIZATIONID_2);

			sb.append(_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_GROUPID_2);

			sb.append(
				_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<DestinazioneUsoServizioEnte>)QueryUtil.list(
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
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
			findByOrganizationIdGroupIdCompanyId_First(
				long organizationId, long groupId, long companyId,
				OrderByComparator<DestinazioneUsoServizioEnte>
					orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByOrganizationIdGroupIdCompanyId_First(
				organizationId, groupId, companyId, orderByComparator);

		if (destinazioneUsoServizioEnte != null) {
			return destinazioneUsoServizioEnte;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
	}

	/**
	 * Returns the first destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
		fetchByOrganizationIdGroupIdCompanyId_First(
			long organizationId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		List<DestinazioneUsoServizioEnte> list =
			findByOrganizationIdGroupIdCompanyId(
				organizationId, groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
			findByOrganizationIdGroupIdCompanyId_Last(
				long organizationId, long groupId, long companyId,
				OrderByComparator<DestinazioneUsoServizioEnte>
					orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByOrganizationIdGroupIdCompanyId_Last(
				organizationId, groupId, companyId, orderByComparator);

		if (destinazioneUsoServizioEnte != null) {
			return destinazioneUsoServizioEnte;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDestinazioneUsoServizioEnteException(sb.toString());
	}

	/**
	 * Returns the last destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinazione uso servizio ente, or <code>null</code> if a matching destinazione uso servizio ente could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte
		fetchByOrganizationIdGroupIdCompanyId_Last(
			long organizationId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		int count = countByOrganizationIdGroupIdCompanyId(
			organizationId, groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<DestinazioneUsoServizioEnte> list =
			findByOrganizationIdGroupIdCompanyId(
				organizationId, groupId, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinazione uso servizio entes before and after the current destinazione uso servizio ente in the ordered set where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the current destinazione uso servizio ente
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte[]
			findByOrganizationIdGroupIdCompanyId_PrevAndNext(
				DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK,
				long organizationId, long groupId, long companyId,
				OrderByComparator<DestinazioneUsoServizioEnte>
					orderByComparator)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			findByPrimaryKey(destinazioneUsoServizioEntePK);

		Session session = null;

		try {
			session = openSession();

			DestinazioneUsoServizioEnte[] array =
				new DestinazioneUsoServizioEnteImpl[3];

			array[0] = getByOrganizationIdGroupIdCompanyId_PrevAndNext(
				session, destinazioneUsoServizioEnte, organizationId, groupId,
				companyId, orderByComparator, true);

			array[1] = destinazioneUsoServizioEnte;

			array[2] = getByOrganizationIdGroupIdCompanyId_PrevAndNext(
				session, destinazioneUsoServizioEnte, organizationId, groupId,
				companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DestinazioneUsoServizioEnte
		getByOrganizationIdGroupIdCompanyId_PrevAndNext(
			Session session,
			DestinazioneUsoServizioEnte destinazioneUsoServizioEnte,
			long organizationId, long groupId, long companyId,
			OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
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

		sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

		sb.append(
			_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_ORGANIZATIONID_2);

		sb.append(_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_GROUPID_2);

		sb.append(_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_COMPANYID_2);

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
			sb.append(DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organizationId);

		queryPos.add(groupId);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						destinazioneUsoServizioEnte)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DestinazioneUsoServizioEnte> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByOrganizationIdGroupIdCompanyId(
		long organizationId, long groupId, long companyId) {

		for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
				findByOrganizationIdGroupIdCompanyId(
					organizationId, groupId, companyId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(destinazioneUsoServizioEnte);
		}
	}

	/**
	 * Returns the number of destinazione uso servizio entes where organizationId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching destinazione uso servizio entes
	 */
	@Override
	public int countByOrganizationIdGroupIdCompanyId(
		long organizationId, long groupId, long companyId) {

		FinderPath finderPath =
			_finderPathCountByOrganizationIdGroupIdCompanyId;

		Object[] finderArgs = new Object[] {organizationId, groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE_WHERE);

			sb.append(
				_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_ORGANIZATIONID_2);

			sb.append(_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_GROUPID_2);

			sb.append(
				_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				queryPos.add(groupId);

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

	private static final String
		_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_ORGANIZATIONID_2 =
			"destinazioneUsoServizioEnte.id.organizationId = ? AND ";

	private static final String
		_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_GROUPID_2 =
			"destinazioneUsoServizioEnte.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_ORGANIZATIONIDGROUPIDCOMPANYID_COMPANYID_2 =
			"destinazioneUsoServizioEnte.companyId = ?";

	public DestinazioneUsoServizioEntePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DestinazioneUsoServizioEnte.class);

		setModelImplClass(DestinazioneUsoServizioEnteImpl.class);
		setModelPKClass(DestinazioneUsoServizioEntePK.class);

		setTable(DestinazioneUsoServizioEnteTable.INSTANCE);
	}

	/**
	 * Caches the destinazione uso servizio ente in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsoServizioEnte the destinazione uso servizio ente
	 */
	@Override
	public void cacheResult(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		entityCache.putResult(
			DestinazioneUsoServizioEnteImpl.class,
			destinazioneUsoServizioEnte.getPrimaryKey(),
			destinazioneUsoServizioEnte);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				destinazioneUsoServizioEnte.getUuid(),
				destinazioneUsoServizioEnte.getGroupId()
			},
			destinazioneUsoServizioEnte);

		finderCache.putResult(
			_finderPathFetchByDestinazioneUsoIdServizioIdOrganizationId,
			new Object[] {
				destinazioneUsoServizioEnte.getDestinazioneUsoId(),
				destinazioneUsoServizioEnte.getServizioId(),
				destinazioneUsoServizioEnte.getOrganizationId()
			},
			destinazioneUsoServizioEnte);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the destinazione uso servizio entes in the entity cache if it is enabled.
	 *
	 * @param destinazioneUsoServizioEntes the destinazione uso servizio entes
	 */
	@Override
	public void cacheResult(
		List<DestinazioneUsoServizioEnte> destinazioneUsoServizioEntes) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (destinazioneUsoServizioEntes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
				destinazioneUsoServizioEntes) {

			if (entityCache.getResult(
					DestinazioneUsoServizioEnteImpl.class,
					destinazioneUsoServizioEnte.getPrimaryKey()) == null) {

				cacheResult(destinazioneUsoServizioEnte);
			}
		}
	}

	/**
	 * Clears the cache for all destinazione uso servizio entes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DestinazioneUsoServizioEnteImpl.class);

		finderCache.clearCache(DestinazioneUsoServizioEnteImpl.class);
	}

	/**
	 * Clears the cache for the destinazione uso servizio ente.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		entityCache.removeResult(
			DestinazioneUsoServizioEnteImpl.class, destinazioneUsoServizioEnte);
	}

	@Override
	public void clearCache(
		List<DestinazioneUsoServizioEnte> destinazioneUsoServizioEntes) {

		for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
				destinazioneUsoServizioEntes) {

			entityCache.removeResult(
				DestinazioneUsoServizioEnteImpl.class,
				destinazioneUsoServizioEnte);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DestinazioneUsoServizioEnteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DestinazioneUsoServizioEnteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DestinazioneUsoServizioEnteModelImpl
			destinazioneUsoServizioEnteModelImpl) {

		Object[] args = new Object[] {
			destinazioneUsoServizioEnteModelImpl.getUuid(),
			destinazioneUsoServizioEnteModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			destinazioneUsoServizioEnteModelImpl);

		args = new Object[] {
			destinazioneUsoServizioEnteModelImpl.getDestinazioneUsoId(),
			destinazioneUsoServizioEnteModelImpl.getServizioId(),
			destinazioneUsoServizioEnteModelImpl.getOrganizationId()
		};

		finderCache.putResult(
			_finderPathCountByDestinazioneUsoIdServizioIdOrganizationId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDestinazioneUsoIdServizioIdOrganizationId, args,
			destinazioneUsoServizioEnteModelImpl);
	}

	/**
	 * Creates a new destinazione uso servizio ente with the primary key. Does not add the destinazione uso servizio ente to the database.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key for the new destinazione uso servizio ente
	 * @return the new destinazione uso servizio ente
	 */
	@Override
	public DestinazioneUsoServizioEnte create(
		DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK) {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			new DestinazioneUsoServizioEnteImpl();

		destinazioneUsoServizioEnte.setNew(true);
		destinazioneUsoServizioEnte.setPrimaryKey(
			destinazioneUsoServizioEntePK);

		String uuid = PortalUUIDUtil.generate();

		destinazioneUsoServizioEnte.setUuid(uuid);

		destinazioneUsoServizioEnte.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return destinazioneUsoServizioEnte;
	}

	/**
	 * Removes the destinazione uso servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte remove(
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws NoSuchDestinazioneUsoServizioEnteException {

		return remove((Serializable)destinazioneUsoServizioEntePK);
	}

	/**
	 * Removes the destinazione uso servizio ente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente that was removed
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte remove(Serializable primaryKey)
		throws NoSuchDestinazioneUsoServizioEnteException {

		Session session = null;

		try {
			session = openSession();

			DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
				(DestinazioneUsoServizioEnte)session.get(
					DestinazioneUsoServizioEnteImpl.class, primaryKey);

			if (destinazioneUsoServizioEnte == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDestinazioneUsoServizioEnteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(destinazioneUsoServizioEnte);
		}
		catch (NoSuchDestinazioneUsoServizioEnteException
					noSuchEntityException) {

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
	protected DestinazioneUsoServizioEnte removeImpl(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(destinazioneUsoServizioEnte)) {
				destinazioneUsoServizioEnte =
					(DestinazioneUsoServizioEnte)session.get(
						DestinazioneUsoServizioEnteImpl.class,
						destinazioneUsoServizioEnte.getPrimaryKeyObj());
			}

			if (destinazioneUsoServizioEnte != null) {
				session.delete(destinazioneUsoServizioEnte);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (destinazioneUsoServizioEnte != null) {
			clearCache(destinazioneUsoServizioEnte);
		}

		return destinazioneUsoServizioEnte;
	}

	@Override
	public DestinazioneUsoServizioEnte updateImpl(
		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte) {

		boolean isNew = destinazioneUsoServizioEnte.isNew();

		if (!(destinazioneUsoServizioEnte instanceof
				DestinazioneUsoServizioEnteModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					destinazioneUsoServizioEnte.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					destinazioneUsoServizioEnte);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in destinazioneUsoServizioEnte proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DestinazioneUsoServizioEnte implementation " +
					destinazioneUsoServizioEnte.getClass());
		}

		DestinazioneUsoServizioEnteModelImpl
			destinazioneUsoServizioEnteModelImpl =
				(DestinazioneUsoServizioEnteModelImpl)
					destinazioneUsoServizioEnte;

		if (Validator.isNull(destinazioneUsoServizioEnte.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			destinazioneUsoServizioEnte.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (destinazioneUsoServizioEnte.getCreateDate() == null)) {
			if (serviceContext == null) {
				destinazioneUsoServizioEnte.setCreateDate(date);
			}
			else {
				destinazioneUsoServizioEnte.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!destinazioneUsoServizioEnteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				destinazioneUsoServizioEnte.setModifiedDate(date);
			}
			else {
				destinazioneUsoServizioEnte.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(destinazioneUsoServizioEnte);
			}
			else {
				destinazioneUsoServizioEnte =
					(DestinazioneUsoServizioEnte)session.merge(
						destinazioneUsoServizioEnte);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DestinazioneUsoServizioEnteImpl.class,
			destinazioneUsoServizioEnteModelImpl, false, true);

		cacheUniqueFindersCache(destinazioneUsoServizioEnteModelImpl);

		if (isNew) {
			destinazioneUsoServizioEnte.setNew(false);
		}

		destinazioneUsoServizioEnte.resetOriginalValues();

		return destinazioneUsoServizioEnte;
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDestinazioneUsoServizioEnteException {

		DestinazioneUsoServizioEnte destinazioneUsoServizioEnte =
			fetchByPrimaryKey(primaryKey);

		if (destinazioneUsoServizioEnte == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDestinazioneUsoServizioEnteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return destinazioneUsoServizioEnte;
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key or throws a <code>NoSuchDestinazioneUsoServizioEnteException</code> if it could not be found.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente
	 * @throws NoSuchDestinazioneUsoServizioEnteException if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte findByPrimaryKey(
			DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK)
		throws NoSuchDestinazioneUsoServizioEnteException {

		return findByPrimaryKey((Serializable)destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns the destinazione uso servizio ente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param destinazioneUsoServizioEntePK the primary key of the destinazione uso servizio ente
	 * @return the destinazione uso servizio ente, or <code>null</code> if a destinazione uso servizio ente with the primary key could not be found
	 */
	@Override
	public DestinazioneUsoServizioEnte fetchByPrimaryKey(
		DestinazioneUsoServizioEntePK destinazioneUsoServizioEntePK) {

		return fetchByPrimaryKey((Serializable)destinazioneUsoServizioEntePK);
	}

	/**
	 * Returns all the destinazione uso servizio entes.
	 *
	 * @return the destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @return the range of destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the destinazione uso servizio entes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DestinazioneUsoServizioEnteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinazione uso servizio entes
	 * @param end the upper bound of the range of destinazione uso servizio entes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of destinazione uso servizio entes
	 */
	@Override
	public List<DestinazioneUsoServizioEnte> findAll(
		int start, int end,
		OrderByComparator<DestinazioneUsoServizioEnte> orderByComparator,
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

		List<DestinazioneUsoServizioEnte> list = null;

		if (useFinderCache) {
			list = (List<DestinazioneUsoServizioEnte>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE;

				sql = sql.concat(
					DestinazioneUsoServizioEnteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DestinazioneUsoServizioEnte>)QueryUtil.list(
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
	 * Removes all the destinazione uso servizio entes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DestinazioneUsoServizioEnte destinazioneUsoServizioEnte :
				findAll()) {

			remove(destinazioneUsoServizioEnte);
		}
	}

	/**
	 * Returns the number of destinazione uso servizio entes.
	 *
	 * @return the number of destinazione uso servizio entes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE);

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
		return "destinazioneUsoServizioEntePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DestinazioneUsoServizioEnteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the destinazione uso servizio ente persistence.
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

		_finderPathFetchByDestinazioneUsoIdServizioIdOrganizationId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByDestinazioneUsoIdServizioIdOrganizationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"destinazioneUsoId", "servizioId", "organizationId"
				},
				true);

		_finderPathCountByDestinazioneUsoIdServizioIdOrganizationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByDestinazioneUsoIdServizioIdOrganizationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"destinazioneUsoId", "servizioId", "organizationId"
				},
				false);

		_finderPathWithPaginationFindByOrganizationIdGroupIdCompanyId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByOrganizationIdGroupIdCompanyId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"organizationId", "groupId", "companyId"}, true);

		_finderPathWithoutPaginationFindByOrganizationIdGroupIdCompanyId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByOrganizationIdGroupIdCompanyId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"organizationId", "groupId", "companyId"}, true);

		_finderPathCountByOrganizationIdGroupIdCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationIdGroupIdCompanyId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"organizationId", "groupId", "companyId"}, false);

		_setDestinazioneUsoServizioEnteUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDestinazioneUsoServizioEnteUtilPersistence(null);

		entityCache.removeCache(
			DestinazioneUsoServizioEnteImpl.class.getName());
	}

	private void _setDestinazioneUsoServizioEnteUtilPersistence(
		DestinazioneUsoServizioEntePersistence
			destinazioneUsoServizioEntePersistence) {

		try {
			Field field =
				DestinazioneUsoServizioEnteUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, destinazioneUsoServizioEntePersistence);
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

	private static final String _SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE =
		"SELECT destinazioneUsoServizioEnte FROM DestinazioneUsoServizioEnte destinazioneUsoServizioEnte";

	private static final String _SQL_SELECT_DESTINAZIONEUSOSERVIZIOENTE_WHERE =
		"SELECT destinazioneUsoServizioEnte FROM DestinazioneUsoServizioEnte destinazioneUsoServizioEnte WHERE ";

	private static final String _SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE =
		"SELECT COUNT(destinazioneUsoServizioEnte) FROM DestinazioneUsoServizioEnte destinazioneUsoServizioEnte";

	private static final String _SQL_COUNT_DESTINAZIONEUSOSERVIZIOENTE_WHERE =
		"SELECT COUNT(destinazioneUsoServizioEnte) FROM DestinazioneUsoServizioEnte destinazioneUsoServizioEnte WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"destinazioneUsoServizioEnte.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DestinazioneUsoServizioEnte exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DestinazioneUsoServizioEnte exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DestinazioneUsoServizioEntePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"destinazioneUsoId", "servizioId", "organizationId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DestinazioneUsoServizioEnteModelArgumentsResolver
		_destinazioneUsoServizioEnteModelArgumentsResolver;

}