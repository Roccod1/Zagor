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

package it.servizidigitali.gestionecomunicazioni.service.persistence.impl;

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

import it.servizidigitali.gestionecomunicazioni.exception.NoSuchComunicazioneException;
import it.servizidigitali.gestionecomunicazioni.model.Comunicazione;
import it.servizidigitali.gestionecomunicazioni.model.ComunicazioneTable;
import it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneImpl;
import it.servizidigitali.gestionecomunicazioni.model.impl.ComunicazioneModelImpl;
import it.servizidigitali.gestionecomunicazioni.service.persistence.ComunicazionePersistence;
import it.servizidigitali.gestionecomunicazioni.service.persistence.ComunicazioneUtil;
import it.servizidigitali.gestionecomunicazioni.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ComunicazionePersistence.class, BasePersistence.class})
public class ComunicazionePersistenceImpl
	extends BasePersistenceImpl<Comunicazione>
	implements ComunicazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ComunicazioneUtil</code> to access the comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ComunicazioneImpl.class.getName();

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
	 * Returns all the comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
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

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comunicazione comunicazione : list) {
					if (!uuid.equals(comunicazione.getUuid())) {
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

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

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
				sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
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

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Returns the first comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByUuid_First(
			String uuid, OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByUuid_First(
			uuid, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByUuid_First(
		String uuid, OrderByComparator<Comunicazione> orderByComparator) {

		List<Comunicazione> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByUuid_Last(
			String uuid, OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByUuid_Last(uuid, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByUuid_Last(
		String uuid, OrderByComparator<Comunicazione> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Comunicazione> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione[] findByUuid_PrevAndNext(
			long comunicazioneId, String uuid,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		uuid = Objects.toString(uuid, "");

		Comunicazione comunicazione = findByPrimaryKey(comunicazioneId);

		Session session = null;

		try {
			session = openSession();

			Comunicazione[] array = new ComunicazioneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, comunicazione, uuid, orderByComparator, true);

			array[1] = comunicazione;

			array[2] = getByUuid_PrevAndNext(
				session, comunicazione, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comunicazione getByUuid_PrevAndNext(
		Session session, Comunicazione comunicazione, String uuid,
		OrderByComparator<Comunicazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

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
			sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
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
						comunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Comunicazione comunicazione :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

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
		"comunicazione.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(comunicazione.uuid IS NULL OR comunicazione.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByUUID_G(String uuid, long groupId)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByUUID_G(uuid, groupId);

		if (comunicazione == null) {
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

			throw new NoSuchComunicazioneException(sb.toString());
		}

		return comunicazione;
	}

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByUUID_G(
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

		if (result instanceof Comunicazione) {
			Comunicazione comunicazione = (Comunicazione)result;

			if (!Objects.equals(uuid, comunicazione.getUuid()) ||
				(groupId != comunicazione.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

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

				List<Comunicazione> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Comunicazione comunicazione = list.get(0);

					result = comunicazione;

					cacheResult(comunicazione);
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
			return (Comunicazione)result;
		}
	}

	/**
	 * Removes the comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comunicazione that was removed
	 */
	@Override
	public Comunicazione removeByUUID_G(String uuid, long groupId)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = findByUUID_G(uuid, groupId);

		return remove(comunicazione);
	}

	/**
	 * Returns the number of comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

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
		"comunicazione.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(comunicazione.uuid IS NULL OR comunicazione.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"comunicazione.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
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

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comunicazione comunicazione : list) {
					if (!uuid.equals(comunicazione.getUuid()) ||
						(companyId != comunicazione.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

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
				sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
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

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Returns the first comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Comunicazione> orderByComparator) {

		List<Comunicazione> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Comunicazione> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Comunicazione> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione[] findByUuid_C_PrevAndNext(
			long comunicazioneId, String uuid, long companyId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		uuid = Objects.toString(uuid, "");

		Comunicazione comunicazione = findByPrimaryKey(comunicazioneId);

		Session session = null;

		try {
			session = openSession();

			Comunicazione[] array = new ComunicazioneImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, comunicazione, uuid, companyId, orderByComparator,
				true);

			array[1] = comunicazione;

			array[2] = getByUuid_C_PrevAndNext(
				session, comunicazione, uuid, companyId, orderByComparator,
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

	protected Comunicazione getByUuid_C_PrevAndNext(
		Session session, Comunicazione comunicazione, String uuid,
		long companyId, OrderByComparator<Comunicazione> orderByComparator,
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

		sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

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
			sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
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
						comunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Comunicazione comunicazione :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

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
		"comunicazione.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(comunicazione.uuid IS NULL OR comunicazione.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"comunicazione.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByOrganizationId(long organizationId) {
		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
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

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comunicazione comunicazione : list) {
					if (organizationId != comunicazione.getOrganizationId()) {
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

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Returns the first comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByOrganizationId_First(
			long organizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		List<Comunicazione> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<Comunicazione> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione[] findByOrganizationId_PrevAndNext(
			long comunicazioneId, long organizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = findByPrimaryKey(comunicazioneId);

		Session session = null;

		try {
			session = openSession();

			Comunicazione[] array = new ComunicazioneImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, comunicazione, organizationId, orderByComparator,
				true);

			array[1] = comunicazione;

			array[2] = getByOrganizationId_PrevAndNext(
				session, comunicazione, organizationId, orderByComparator,
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

	protected Comunicazione getByOrganizationId_PrevAndNext(
		Session session, Comunicazione comunicazione, long organizationId,
		OrderByComparator<Comunicazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

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
			sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						comunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunicaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (Comunicazione comunicazione :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

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
		"comunicazione.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByTipologiaComunicazioneId;
	private FinderPath
		_finderPathWithoutPaginationFindByTipologiaComunicazioneId;
	private FinderPath _finderPathCountByTipologiaComunicazioneId;

	/**
	 * Returns all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @return the matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId) {

		return findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end) {

		return findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByTipologiaComunicazioneId(
		long tipologiaComunicazioneId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTipologiaComunicazioneId;
				finderArgs = new Object[] {tipologiaComunicazioneId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTipologiaComunicazioneId;
			finderArgs = new Object[] {
				tipologiaComunicazioneId, start, end, orderByComparator
			};
		}

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comunicazione comunicazione : list) {
					if (tipologiaComunicazioneId !=
							comunicazione.getTipologiaComunicazioneId()) {

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

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

			sb.append(
				_FINDER_COLUMN_TIPOLOGIACOMUNICAZIONEID_TIPOLOGIACOMUNICAZIONEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tipologiaComunicazioneId);

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Returns the first comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByTipologiaComunicazioneId_First(
			long tipologiaComunicazioneId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByTipologiaComunicazioneId_First(
			tipologiaComunicazioneId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipologiaComunicazioneId=");
		sb.append(tipologiaComunicazioneId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByTipologiaComunicazioneId_First(
		long tipologiaComunicazioneId,
		OrderByComparator<Comunicazione> orderByComparator) {

		List<Comunicazione> list = findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByTipologiaComunicazioneId_Last(
			long tipologiaComunicazioneId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByTipologiaComunicazioneId_Last(
			tipologiaComunicazioneId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tipologiaComunicazioneId=");
		sb.append(tipologiaComunicazioneId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByTipologiaComunicazioneId_Last(
		long tipologiaComunicazioneId,
		OrderByComparator<Comunicazione> orderByComparator) {

		int count = countByTipologiaComunicazioneId(tipologiaComunicazioneId);

		if (count == 0) {
			return null;
		}

		List<Comunicazione> list = findByTipologiaComunicazioneId(
			tipologiaComunicazioneId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where tipologiaComunicazioneId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione[] findByTipologiaComunicazioneId_PrevAndNext(
			long comunicazioneId, long tipologiaComunicazioneId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = findByPrimaryKey(comunicazioneId);

		Session session = null;

		try {
			session = openSession();

			Comunicazione[] array = new ComunicazioneImpl[3];

			array[0] = getByTipologiaComunicazioneId_PrevAndNext(
				session, comunicazione, tipologiaComunicazioneId,
				orderByComparator, true);

			array[1] = comunicazione;

			array[2] = getByTipologiaComunicazioneId_PrevAndNext(
				session, comunicazione, tipologiaComunicazioneId,
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

	protected Comunicazione getByTipologiaComunicazioneId_PrevAndNext(
		Session session, Comunicazione comunicazione,
		long tipologiaComunicazioneId,
		OrderByComparator<Comunicazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

		sb.append(
			_FINDER_COLUMN_TIPOLOGIACOMUNICAZIONEID_TIPOLOGIACOMUNICAZIONEID_2);

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
			sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tipologiaComunicazioneId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						comunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunicaziones where tipologiaComunicazioneId = &#63; from the database.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 */
	@Override
	public void removeByTipologiaComunicazioneId(
		long tipologiaComunicazioneId) {

		for (Comunicazione comunicazione :
				findByTipologiaComunicazioneId(
					tipologiaComunicazioneId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones where tipologiaComunicazioneId = &#63;.
	 *
	 * @param tipologiaComunicazioneId the tipologia comunicazione ID
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByTipologiaComunicazioneId(long tipologiaComunicazioneId) {
		FinderPath finderPath = _finderPathCountByTipologiaComunicazioneId;

		Object[] finderArgs = new Object[] {tipologiaComunicazioneId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

			sb.append(
				_FINDER_COLUMN_TIPOLOGIACOMUNICAZIONEID_TIPOLOGIACOMUNICAZIONEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tipologiaComunicazioneId);

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
		_FINDER_COLUMN_TIPOLOGIACOMUNICAZIONEID_TIPOLOGIACOMUNICAZIONEID_2 =
			"comunicazione.tipologiaComunicazioneId = ?";

	private FinderPath
		_finderPathWithPaginationFindByDestinatarioOrganizationId;
	private FinderPath
		_finderPathWithoutPaginationFindByDestinatarioOrganizationId;
	private FinderPath _finderPathCountByDestinatarioOrganizationId;

	/**
	 * Returns all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @return the matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioOrganizationId(
		Long destinatarioUserId) {

		return findByDestinatarioOrganizationId(
			destinatarioUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioOrganizationId(
		Long destinatarioUserId, int start, int end) {

		return findByDestinatarioOrganizationId(
			destinatarioUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioOrganizationId(
		Long destinatarioUserId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findByDestinatarioOrganizationId(
			destinatarioUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioOrganizationId(
		Long destinatarioUserId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDestinatarioOrganizationId;
				finderArgs = new Object[] {destinatarioUserId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDestinatarioOrganizationId;
			finderArgs = new Object[] {
				destinatarioUserId, start, end, orderByComparator
			};
		}

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comunicazione comunicazione : list) {
					if (!Objects.equals(
							destinatarioUserId,
							comunicazione.getDestinatarioUserId())) {

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

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

			sb.append(
				_FINDER_COLUMN_DESTINATARIOORGANIZATIONID_DESTINATARIOUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatarioUserId.longValue());

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Returns the first comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByDestinatarioOrganizationId_First(
			Long destinatarioUserId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByDestinatarioOrganizationId_First(
			destinatarioUserId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatarioUserId=");
		sb.append(destinatarioUserId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByDestinatarioOrganizationId_First(
		Long destinatarioUserId,
		OrderByComparator<Comunicazione> orderByComparator) {

		List<Comunicazione> list = findByDestinatarioOrganizationId(
			destinatarioUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByDestinatarioOrganizationId_Last(
			Long destinatarioUserId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByDestinatarioOrganizationId_Last(
			destinatarioUserId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatarioUserId=");
		sb.append(destinatarioUserId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByDestinatarioOrganizationId_Last(
		Long destinatarioUserId,
		OrderByComparator<Comunicazione> orderByComparator) {

		int count = countByDestinatarioOrganizationId(destinatarioUserId);

		if (count == 0) {
			return null;
		}

		List<Comunicazione> list = findByDestinatarioOrganizationId(
			destinatarioUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where destinatarioUserId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param destinatarioUserId the destinatario user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione[] findByDestinatarioOrganizationId_PrevAndNext(
			long comunicazioneId, Long destinatarioUserId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = findByPrimaryKey(comunicazioneId);

		Session session = null;

		try {
			session = openSession();

			Comunicazione[] array = new ComunicazioneImpl[3];

			array[0] = getByDestinatarioOrganizationId_PrevAndNext(
				session, comunicazione, destinatarioUserId, orderByComparator,
				true);

			array[1] = comunicazione;

			array[2] = getByDestinatarioOrganizationId_PrevAndNext(
				session, comunicazione, destinatarioUserId, orderByComparator,
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

	protected Comunicazione getByDestinatarioOrganizationId_PrevAndNext(
		Session session, Comunicazione comunicazione, Long destinatarioUserId,
		OrderByComparator<Comunicazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

		sb.append(
			_FINDER_COLUMN_DESTINATARIOORGANIZATIONID_DESTINATARIOUSERID_2);

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
			sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(destinatarioUserId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						comunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunicaziones where destinatarioUserId = &#63; from the database.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 */
	@Override
	public void removeByDestinatarioOrganizationId(Long destinatarioUserId) {
		for (Comunicazione comunicazione :
				findByDestinatarioOrganizationId(
					destinatarioUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones where destinatarioUserId = &#63;.
	 *
	 * @param destinatarioUserId the destinatario user ID
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByDestinatarioOrganizationId(Long destinatarioUserId) {
		FinderPath finderPath = _finderPathCountByDestinatarioOrganizationId;

		Object[] finderArgs = new Object[] {destinatarioUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

			sb.append(
				_FINDER_COLUMN_DESTINATARIOORGANIZATIONID_DESTINATARIOUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatarioUserId.longValue());

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
		_FINDER_COLUMN_DESTINATARIOORGANIZATIONID_DESTINATARIOUSERID_2 =
			"comunicazione.destinatarioUserId = ?";

	private FinderPath _finderPathWithPaginationFindByDestinatarioUserId;
	private FinderPath _finderPathWithoutPaginationFindByDestinatarioUserId;
	private FinderPath _finderPathCountByDestinatarioUserId;

	/**
	 * Returns all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @return the matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId) {

		return findByDestinatarioUserId(
			destinatarioOrganizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end) {

		return findByDestinatarioUserId(
			destinatarioOrganizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findByDestinatarioUserId(
			destinatarioOrganizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comunicaziones
	 */
	@Override
	public List<Comunicazione> findByDestinatarioUserId(
		long destinatarioOrganizationId, int start, int end,
		OrderByComparator<Comunicazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDestinatarioUserId;
				finderArgs = new Object[] {destinatarioOrganizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDestinatarioUserId;
			finderArgs = new Object[] {
				destinatarioOrganizationId, start, end, orderByComparator
			};
		}

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Comunicazione comunicazione : list) {
					if (destinatarioOrganizationId !=
							comunicazione.getDestinatarioOrganizationId()) {

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

			sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

			sb.append(
				_FINDER_COLUMN_DESTINATARIOUSERID_DESTINATARIOORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatarioOrganizationId);

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Returns the first comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByDestinatarioUserId_First(
			long destinatarioOrganizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByDestinatarioUserId_First(
			destinatarioOrganizationId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatarioOrganizationId=");
		sb.append(destinatarioOrganizationId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the first comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByDestinatarioUserId_First(
		long destinatarioOrganizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		List<Comunicazione> list = findByDestinatarioUserId(
			destinatarioOrganizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione
	 * @throws NoSuchComunicazioneException if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione findByDestinatarioUserId_Last(
			long destinatarioOrganizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByDestinatarioUserId_Last(
			destinatarioOrganizationId, orderByComparator);

		if (comunicazione != null) {
			return comunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destinatarioOrganizationId=");
		sb.append(destinatarioOrganizationId);

		sb.append("}");

		throw new NoSuchComunicazioneException(sb.toString());
	}

	/**
	 * Returns the last comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comunicazione, or <code>null</code> if a matching comunicazione could not be found
	 */
	@Override
	public Comunicazione fetchByDestinatarioUserId_Last(
		long destinatarioOrganizationId,
		OrderByComparator<Comunicazione> orderByComparator) {

		int count = countByDestinatarioUserId(destinatarioOrganizationId);

		if (count == 0) {
			return null;
		}

		List<Comunicazione> list = findByDestinatarioUserId(
			destinatarioOrganizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comunicaziones before and after the current comunicazione in the ordered set where destinatarioOrganizationId = &#63;.
	 *
	 * @param comunicazioneId the primary key of the current comunicazione
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione[] findByDestinatarioUserId_PrevAndNext(
			long comunicazioneId, long destinatarioOrganizationId,
			OrderByComparator<Comunicazione> orderByComparator)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = findByPrimaryKey(comunicazioneId);

		Session session = null;

		try {
			session = openSession();

			Comunicazione[] array = new ComunicazioneImpl[3];

			array[0] = getByDestinatarioUserId_PrevAndNext(
				session, comunicazione, destinatarioOrganizationId,
				orderByComparator, true);

			array[1] = comunicazione;

			array[2] = getByDestinatarioUserId_PrevAndNext(
				session, comunicazione, destinatarioOrganizationId,
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

	protected Comunicazione getByDestinatarioUserId_PrevAndNext(
		Session session, Comunicazione comunicazione,
		long destinatarioOrganizationId,
		OrderByComparator<Comunicazione> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMUNICAZIONE_WHERE);

		sb.append(
			_FINDER_COLUMN_DESTINATARIOUSERID_DESTINATARIOORGANIZATIONID_2);

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
			sb.append(ComunicazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(destinatarioOrganizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						comunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Comunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comunicaziones where destinatarioOrganizationId = &#63; from the database.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 */
	@Override
	public void removeByDestinatarioUserId(long destinatarioOrganizationId) {
		for (Comunicazione comunicazione :
				findByDestinatarioUserId(
					destinatarioOrganizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones where destinatarioOrganizationId = &#63;.
	 *
	 * @param destinatarioOrganizationId the destinatario organization ID
	 * @return the number of matching comunicaziones
	 */
	@Override
	public int countByDestinatarioUserId(long destinatarioOrganizationId) {
		FinderPath finderPath = _finderPathCountByDestinatarioUserId;

		Object[] finderArgs = new Object[] {destinatarioOrganizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMUNICAZIONE_WHERE);

			sb.append(
				_FINDER_COLUMN_DESTINATARIOUSERID_DESTINATARIOORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(destinatarioOrganizationId);

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
		_FINDER_COLUMN_DESTINATARIOUSERID_DESTINATARIOORGANIZATIONID_2 =
			"comunicazione.destinatarioOrganizationId = ?";

	public ComunicazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Comunicazione.class);

		setModelImplClass(ComunicazioneImpl.class);
		setModelPKClass(long.class);

		setTable(ComunicazioneTable.INSTANCE);
	}

	/**
	 * Caches the comunicazione in the entity cache if it is enabled.
	 *
	 * @param comunicazione the comunicazione
	 */
	@Override
	public void cacheResult(Comunicazione comunicazione) {
		entityCache.putResult(
			ComunicazioneImpl.class, comunicazione.getPrimaryKey(),
			comunicazione);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {comunicazione.getUuid(), comunicazione.getGroupId()},
			comunicazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the comunicaziones in the entity cache if it is enabled.
	 *
	 * @param comunicaziones the comunicaziones
	 */
	@Override
	public void cacheResult(List<Comunicazione> comunicaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (comunicaziones.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Comunicazione comunicazione : comunicaziones) {
			if (entityCache.getResult(
					ComunicazioneImpl.class, comunicazione.getPrimaryKey()) ==
						null) {

				cacheResult(comunicazione);
			}
		}
	}

	/**
	 * Clears the cache for all comunicaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ComunicazioneImpl.class);

		finderCache.clearCache(ComunicazioneImpl.class);
	}

	/**
	 * Clears the cache for the comunicazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comunicazione comunicazione) {
		entityCache.removeResult(ComunicazioneImpl.class, comunicazione);
	}

	@Override
	public void clearCache(List<Comunicazione> comunicaziones) {
		for (Comunicazione comunicazione : comunicaziones) {
			entityCache.removeResult(ComunicazioneImpl.class, comunicazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ComunicazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ComunicazioneImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ComunicazioneModelImpl comunicazioneModelImpl) {

		Object[] args = new Object[] {
			comunicazioneModelImpl.getUuid(),
			comunicazioneModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, comunicazioneModelImpl);
	}

	/**
	 * Creates a new comunicazione with the primary key. Does not add the comunicazione to the database.
	 *
	 * @param comunicazioneId the primary key for the new comunicazione
	 * @return the new comunicazione
	 */
	@Override
	public Comunicazione create(long comunicazioneId) {
		Comunicazione comunicazione = new ComunicazioneImpl();

		comunicazione.setNew(true);
		comunicazione.setPrimaryKey(comunicazioneId);

		String uuid = PortalUUIDUtil.generate();

		comunicazione.setUuid(uuid);

		comunicazione.setCompanyId(CompanyThreadLocal.getCompanyId());

		return comunicazione;
	}

	/**
	 * Removes the comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione that was removed
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione remove(long comunicazioneId)
		throws NoSuchComunicazioneException {

		return remove((Serializable)comunicazioneId);
	}

	/**
	 * Removes the comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comunicazione
	 * @return the comunicazione that was removed
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione remove(Serializable primaryKey)
		throws NoSuchComunicazioneException {

		Session session = null;

		try {
			session = openSession();

			Comunicazione comunicazione = (Comunicazione)session.get(
				ComunicazioneImpl.class, primaryKey);

			if (comunicazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComunicazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(comunicazione);
		}
		catch (NoSuchComunicazioneException noSuchEntityException) {
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
	protected Comunicazione removeImpl(Comunicazione comunicazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(comunicazione)) {
				comunicazione = (Comunicazione)session.get(
					ComunicazioneImpl.class, comunicazione.getPrimaryKeyObj());
			}

			if (comunicazione != null) {
				session.delete(comunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (comunicazione != null) {
			clearCache(comunicazione);
		}

		return comunicazione;
	}

	@Override
	public Comunicazione updateImpl(Comunicazione comunicazione) {
		boolean isNew = comunicazione.isNew();

		if (!(comunicazione instanceof ComunicazioneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(comunicazione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					comunicazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in comunicazione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Comunicazione implementation " +
					comunicazione.getClass());
		}

		ComunicazioneModelImpl comunicazioneModelImpl =
			(ComunicazioneModelImpl)comunicazione;

		if (Validator.isNull(comunicazione.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			comunicazione.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (comunicazione.getCreateDate() == null)) {
			if (serviceContext == null) {
				comunicazione.setCreateDate(date);
			}
			else {
				comunicazione.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!comunicazioneModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				comunicazione.setModifiedDate(date);
			}
			else {
				comunicazione.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(comunicazione);
			}
			else {
				comunicazione = (Comunicazione)session.merge(comunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ComunicazioneImpl.class, comunicazioneModelImpl, false, true);

		cacheUniqueFindersCache(comunicazioneModelImpl);

		if (isNew) {
			comunicazione.setNew(false);
		}

		comunicazione.resetOriginalValues();

		return comunicazione;
	}

	/**
	 * Returns the comunicazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comunicazione
	 * @return the comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComunicazioneException {

		Comunicazione comunicazione = fetchByPrimaryKey(primaryKey);

		if (comunicazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComunicazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return comunicazione;
	}

	/**
	 * Returns the comunicazione with the primary key or throws a <code>NoSuchComunicazioneException</code> if it could not be found.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione
	 * @throws NoSuchComunicazioneException if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione findByPrimaryKey(long comunicazioneId)
		throws NoSuchComunicazioneException {

		return findByPrimaryKey((Serializable)comunicazioneId);
	}

	/**
	 * Returns the comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param comunicazioneId the primary key of the comunicazione
	 * @return the comunicazione, or <code>null</code> if a comunicazione with the primary key could not be found
	 */
	@Override
	public Comunicazione fetchByPrimaryKey(long comunicazioneId) {
		return fetchByPrimaryKey((Serializable)comunicazioneId);
	}

	/**
	 * Returns all the comunicaziones.
	 *
	 * @return the comunicaziones
	 */
	@Override
	public List<Comunicazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @return the range of comunicaziones
	 */
	@Override
	public List<Comunicazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comunicaziones
	 */
	@Override
	public List<Comunicazione> findAll(
		int start, int end,
		OrderByComparator<Comunicazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comunicaziones
	 * @param end the upper bound of the range of comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comunicaziones
	 */
	@Override
	public List<Comunicazione> findAll(
		int start, int end, OrderByComparator<Comunicazione> orderByComparator,
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

		List<Comunicazione> list = null;

		if (useFinderCache) {
			list = (List<Comunicazione>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMUNICAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMUNICAZIONE;

				sql = sql.concat(ComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Comunicazione>)QueryUtil.list(
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
	 * Removes all the comunicaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Comunicazione comunicazione : findAll()) {
			remove(comunicazione);
		}
	}

	/**
	 * Returns the number of comunicaziones.
	 *
	 * @return the number of comunicaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMUNICAZIONE);

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
		return "comunicazioneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMUNICAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ComunicazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comunicazione persistence.
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

		_finderPathWithPaginationFindByTipologiaComunicazioneId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTipologiaComunicazioneId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"tipologiaComunicazioneId"}, true);

		_finderPathWithoutPaginationFindByTipologiaComunicazioneId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTipologiaComunicazioneId",
				new String[] {Long.class.getName()},
				new String[] {"tipologiaComunicazioneId"}, true);

		_finderPathCountByTipologiaComunicazioneId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTipologiaComunicazioneId",
			new String[] {Long.class.getName()},
			new String[] {"tipologiaComunicazioneId"}, false);

		_finderPathWithPaginationFindByDestinatarioOrganizationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDestinatarioOrganizationId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"destinatarioUserId"}, true);

		_finderPathWithoutPaginationFindByDestinatarioOrganizationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDestinatarioOrganizationId",
				new String[] {Long.class.getName()},
				new String[] {"destinatarioUserId"}, true);

		_finderPathCountByDestinatarioOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDestinatarioOrganizationId",
			new String[] {Long.class.getName()},
			new String[] {"destinatarioUserId"}, false);

		_finderPathWithPaginationFindByDestinatarioUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDestinatarioUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"destinatarioOrganizationId"}, true);

		_finderPathWithoutPaginationFindByDestinatarioUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDestinatarioUserId", new String[] {Long.class.getName()},
			new String[] {"destinatarioOrganizationId"}, true);

		_finderPathCountByDestinatarioUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDestinatarioUserId", new String[] {Long.class.getName()},
			new String[] {"destinatarioOrganizationId"}, false);

		_setComunicazioneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setComunicazioneUtilPersistence(null);

		entityCache.removeCache(ComunicazioneImpl.class.getName());
	}

	private void _setComunicazioneUtilPersistence(
		ComunicazionePersistence comunicazionePersistence) {

		try {
			Field field = ComunicazioneUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, comunicazionePersistence);
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

	private static final String _SQL_SELECT_COMUNICAZIONE =
		"SELECT comunicazione FROM Comunicazione comunicazione";

	private static final String _SQL_SELECT_COMUNICAZIONE_WHERE =
		"SELECT comunicazione FROM Comunicazione comunicazione WHERE ";

	private static final String _SQL_COUNT_COMUNICAZIONE =
		"SELECT COUNT(comunicazione) FROM Comunicazione comunicazione";

	private static final String _SQL_COUNT_COMUNICAZIONE_WHERE =
		"SELECT COUNT(comunicazione) FROM Comunicazione comunicazione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "comunicazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Comunicazione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Comunicazione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ComunicazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ComunicazioneModelArgumentsResolver
		_comunicazioneModelArgumentsResolver;

}