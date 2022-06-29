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
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.gestioneservizi.exception.NoSuchTipologiaException;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.model.TipologiaTable;
import it.servizidigitali.gestioneservizi.model.impl.TipologiaImpl;
import it.servizidigitali.gestioneservizi.model.impl.TipologiaModelImpl;
import it.servizidigitali.gestioneservizi.service.persistence.TipologiaPersistence;
import it.servizidigitali.gestioneservizi.service.persistence.TipologiaUtil;
import it.servizidigitali.gestioneservizi.service.persistence.impl.constants.ServiziDigitaliGestioneServiziPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
 * The persistence implementation for the tipologia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TipologiaPersistence.class, BasePersistence.class})
public class TipologiaPersistenceImpl
	extends BasePersistenceImpl<Tipologia> implements TipologiaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TipologiaUtil</code> to access the tipologia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TipologiaImpl.class.getName();

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
	 * Returns all the tipologias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tipologia> orderByComparator,
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

		List<Tipologia> list = null;

		if (useFinderCache) {
			list = (List<Tipologia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Tipologia tipologia : list) {
					if (!uuid.equals(tipologia.getUuid())) {
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

			sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

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
				sb.append(TipologiaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Tipologia>)QueryUtil.list(
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
	 * Returns the first tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByUuid_First(
			String uuid, OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByUuid_First(uuid, orderByComparator);

		if (tipologia != null) {
			return tipologia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipologiaException(sb.toString());
	}

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByUuid_First(
		String uuid, OrderByComparator<Tipologia> orderByComparator) {

		List<Tipologia> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByUuid_Last(
			String uuid, OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByUuid_Last(uuid, orderByComparator);

		if (tipologia != null) {
			return tipologia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipologiaException(sb.toString());
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByUuid_Last(
		String uuid, OrderByComparator<Tipologia> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Tipologia> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where uuid = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia[] findByUuid_PrevAndNext(
			long tipologiaId, String uuid,
			OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		uuid = Objects.toString(uuid, "");

		Tipologia tipologia = findByPrimaryKey(tipologiaId);

		Session session = null;

		try {
			session = openSession();

			Tipologia[] array = new TipologiaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tipologia, uuid, orderByComparator, true);

			array[1] = tipologia;

			array[2] = getByUuid_PrevAndNext(
				session, tipologia, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tipologia getByUuid_PrevAndNext(
		Session session, Tipologia tipologia, String uuid,
		OrderByComparator<Tipologia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

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
			sb.append(TipologiaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tipologia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Tipologia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipologias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Tipologia tipologia :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipologia);
		}
	}

	/**
	 * Returns the number of tipologias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipologias
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPOLOGIA_WHERE);

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
		"tipologia.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tipologia.uuid IS NULL OR tipologia.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipologiaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByUUID_G(String uuid, long groupId)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByUUID_G(uuid, groupId);

		if (tipologia == null) {
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

			throw new NoSuchTipologiaException(sb.toString());
		}

		return tipologia;
	}

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tipologia where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByUUID_G(
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

		if (result instanceof Tipologia) {
			Tipologia tipologia = (Tipologia)result;

			if (!Objects.equals(uuid, tipologia.getUuid()) ||
				(groupId != tipologia.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

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

				List<Tipologia> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Tipologia tipologia = list.get(0);

					result = tipologia;

					cacheResult(tipologia);
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
			return (Tipologia)result;
		}
	}

	/**
	 * Removes the tipologia where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipologia that was removed
	 */
	@Override
	public Tipologia removeByUUID_G(String uuid, long groupId)
		throws NoSuchTipologiaException {

		Tipologia tipologia = findByUUID_G(uuid, groupId);

		return remove(tipologia);
	}

	/**
	 * Returns the number of tipologias where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipologias
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIPOLOGIA_WHERE);

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
		"tipologia.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(tipologia.uuid IS NULL OR tipologia.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"tipologia.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Tipologia> orderByComparator,
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

		List<Tipologia> list = null;

		if (useFinderCache) {
			list = (List<Tipologia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Tipologia tipologia : list) {
					if (!uuid.equals(tipologia.getUuid()) ||
						(companyId != tipologia.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

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
				sb.append(TipologiaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Tipologia>)QueryUtil.list(
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
	 * Returns the first tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (tipologia != null) {
			return tipologia;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTipologiaException(sb.toString());
	}

	/**
	 * Returns the first tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Tipologia> orderByComparator) {

		List<Tipologia> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (tipologia != null) {
			return tipologia;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTipologiaException(sb.toString());
	}

	/**
	 * Returns the last tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Tipologia> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Tipologia> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia[] findByUuid_C_PrevAndNext(
			long tipologiaId, String uuid, long companyId,
			OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		uuid = Objects.toString(uuid, "");

		Tipologia tipologia = findByPrimaryKey(tipologiaId);

		Session session = null;

		try {
			session = openSession();

			Tipologia[] array = new TipologiaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, tipologia, uuid, companyId, orderByComparator, true);

			array[1] = tipologia;

			array[2] = getByUuid_C_PrevAndNext(
				session, tipologia, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tipologia getByUuid_C_PrevAndNext(
		Session session, Tipologia tipologia, String uuid, long companyId,
		OrderByComparator<Tipologia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

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
			sb.append(TipologiaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tipologia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Tipologia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipologias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Tipologia tipologia :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tipologia);
		}
	}

	/**
	 * Returns the number of tipologias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipologias
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIPOLOGIA_WHERE);

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
		"tipologia.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(tipologia.uuid IS NULL OR tipologia.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"tipologia.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByVisibile;
	private FinderPath _finderPathWithoutPaginationFindByVisibile;
	private FinderPath _finderPathCountByVisibile;

	/**
	 * Returns all the tipologias where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @return the matching tipologias
	 */
	@Override
	public List<Tipologia> findByVisibile(boolean visibile) {
		return findByVisibile(
			visibile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByVisibile(
		boolean visibile, int start, int end) {

		return findByVisibile(visibile, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByVisibile(
		boolean visibile, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return findByVisibile(visibile, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologias where visibile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param visibile the visibile
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipologias
	 */
	@Override
	public List<Tipologia> findByVisibile(
		boolean visibile, int start, int end,
		OrderByComparator<Tipologia> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVisibile;
				finderArgs = new Object[] {visibile};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVisibile;
			finderArgs = new Object[] {visibile, start, end, orderByComparator};
		}

		List<Tipologia> list = null;

		if (useFinderCache) {
			list = (List<Tipologia>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Tipologia tipologia : list) {
					if (visibile != tipologia.isVisibile()) {
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

			sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

			sb.append(_FINDER_COLUMN_VISIBILE_VISIBILE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TipologiaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(visibile);

				list = (List<Tipologia>)QueryUtil.list(
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
	 * Returns the first tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByVisibile_First(
			boolean visibile, OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByVisibile_First(
			visibile, orderByComparator);

		if (tipologia != null) {
			return tipologia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchTipologiaException(sb.toString());
	}

	/**
	 * Returns the first tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByVisibile_First(
		boolean visibile, OrderByComparator<Tipologia> orderByComparator) {

		List<Tipologia> list = findByVisibile(
			visibile, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia
	 * @throws NoSuchTipologiaException if a matching tipologia could not be found
	 */
	@Override
	public Tipologia findByVisibile_Last(
			boolean visibile, OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByVisibile_Last(visibile, orderByComparator);

		if (tipologia != null) {
			return tipologia;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visibile=");
		sb.append(visibile);

		sb.append("}");

		throw new NoSuchTipologiaException(sb.toString());
	}

	/**
	 * Returns the last tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipologia, or <code>null</code> if a matching tipologia could not be found
	 */
	@Override
	public Tipologia fetchByVisibile_Last(
		boolean visibile, OrderByComparator<Tipologia> orderByComparator) {

		int count = countByVisibile(visibile);

		if (count == 0) {
			return null;
		}

		List<Tipologia> list = findByVisibile(
			visibile, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipologias before and after the current tipologia in the ordered set where visibile = &#63;.
	 *
	 * @param tipologiaId the primary key of the current tipologia
	 * @param visibile the visibile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia[] findByVisibile_PrevAndNext(
			long tipologiaId, boolean visibile,
			OrderByComparator<Tipologia> orderByComparator)
		throws NoSuchTipologiaException {

		Tipologia tipologia = findByPrimaryKey(tipologiaId);

		Session session = null;

		try {
			session = openSession();

			Tipologia[] array = new TipologiaImpl[3];

			array[0] = getByVisibile_PrevAndNext(
				session, tipologia, visibile, orderByComparator, true);

			array[1] = tipologia;

			array[2] = getByVisibile_PrevAndNext(
				session, tipologia, visibile, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tipologia getByVisibile_PrevAndNext(
		Session session, Tipologia tipologia, boolean visibile,
		OrderByComparator<Tipologia> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPOLOGIA_WHERE);

		sb.append(_FINDER_COLUMN_VISIBILE_VISIBILE_2);

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
			sb.append(TipologiaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(visibile);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tipologia)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Tipologia> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipologias where visibile = &#63; from the database.
	 *
	 * @param visibile the visibile
	 */
	@Override
	public void removeByVisibile(boolean visibile) {
		for (Tipologia tipologia :
				findByVisibile(
					visibile, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipologia);
		}
	}

	/**
	 * Returns the number of tipologias where visibile = &#63;.
	 *
	 * @param visibile the visibile
	 * @return the number of matching tipologias
	 */
	@Override
	public int countByVisibile(boolean visibile) {
		FinderPath finderPath = _finderPathCountByVisibile;

		Object[] finderArgs = new Object[] {visibile};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPOLOGIA_WHERE);

			sb.append(_FINDER_COLUMN_VISIBILE_VISIBILE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_VISIBILE_VISIBILE_2 =
		"tipologia.visibile = ?";

	public TipologiaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Tipologia.class);

		setModelImplClass(TipologiaImpl.class);
		setModelPKClass(long.class);

		setTable(TipologiaTable.INSTANCE);
	}

	/**
	 * Caches the tipologia in the entity cache if it is enabled.
	 *
	 * @param tipologia the tipologia
	 */
	@Override
	public void cacheResult(Tipologia tipologia) {
		entityCache.putResult(
			TipologiaImpl.class, tipologia.getPrimaryKey(), tipologia);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {tipologia.getUuid(), tipologia.getGroupId()},
			tipologia);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tipologias in the entity cache if it is enabled.
	 *
	 * @param tipologias the tipologias
	 */
	@Override
	public void cacheResult(List<Tipologia> tipologias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tipologias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Tipologia tipologia : tipologias) {
			if (entityCache.getResult(
					TipologiaImpl.class, tipologia.getPrimaryKey()) == null) {

				cacheResult(tipologia);
			}
		}
	}

	/**
	 * Clears the cache for all tipologias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipologiaImpl.class);

		finderCache.clearCache(TipologiaImpl.class);
	}

	/**
	 * Clears the cache for the tipologia.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tipologia tipologia) {
		entityCache.removeResult(TipologiaImpl.class, tipologia);
	}

	@Override
	public void clearCache(List<Tipologia> tipologias) {
		for (Tipologia tipologia : tipologias) {
			entityCache.removeResult(TipologiaImpl.class, tipologia);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TipologiaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TipologiaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TipologiaModelImpl tipologiaModelImpl) {

		Object[] args = new Object[] {
			tipologiaModelImpl.getUuid(), tipologiaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, tipologiaModelImpl);
	}

	/**
	 * Creates a new tipologia with the primary key. Does not add the tipologia to the database.
	 *
	 * @param tipologiaId the primary key for the new tipologia
	 * @return the new tipologia
	 */
	@Override
	public Tipologia create(long tipologiaId) {
		Tipologia tipologia = new TipologiaImpl();

		tipologia.setNew(true);
		tipologia.setPrimaryKey(tipologiaId);

		String uuid = PortalUUIDUtil.generate();

		tipologia.setUuid(uuid);

		tipologia.setCompanyId(CompanyThreadLocal.getCompanyId());

		return tipologia;
	}

	/**
	 * Removes the tipologia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia that was removed
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia remove(long tipologiaId) throws NoSuchTipologiaException {
		return remove((Serializable)tipologiaId);
	}

	/**
	 * Removes the tipologia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipologia
	 * @return the tipologia that was removed
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia remove(Serializable primaryKey)
		throws NoSuchTipologiaException {

		Session session = null;

		try {
			session = openSession();

			Tipologia tipologia = (Tipologia)session.get(
				TipologiaImpl.class, primaryKey);

			if (tipologia == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipologiaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tipologia);
		}
		catch (NoSuchTipologiaException noSuchEntityException) {
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
	protected Tipologia removeImpl(Tipologia tipologia) {
		tipologiaToServizioTableMapper.deleteLeftPrimaryKeyTableMappings(
			tipologia.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipologia)) {
				tipologia = (Tipologia)session.get(
					TipologiaImpl.class, tipologia.getPrimaryKeyObj());
			}

			if (tipologia != null) {
				session.delete(tipologia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tipologia != null) {
			clearCache(tipologia);
		}

		return tipologia;
	}

	@Override
	public Tipologia updateImpl(Tipologia tipologia) {
		boolean isNew = tipologia.isNew();

		if (!(tipologia instanceof TipologiaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tipologia.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tipologia);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tipologia proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Tipologia implementation " +
					tipologia.getClass());
		}

		TipologiaModelImpl tipologiaModelImpl = (TipologiaModelImpl)tipologia;

		if (Validator.isNull(tipologia.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tipologia.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (tipologia.getCreateDate() == null)) {
			if (serviceContext == null) {
				tipologia.setCreateDate(date);
			}
			else {
				tipologia.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!tipologiaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tipologia.setModifiedDate(date);
			}
			else {
				tipologia.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tipologia);
			}
			else {
				tipologia = (Tipologia)session.merge(tipologia);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TipologiaImpl.class, tipologiaModelImpl, false, true);

		cacheUniqueFindersCache(tipologiaModelImpl);

		if (isNew) {
			tipologia.setNew(false);
		}

		tipologia.resetOriginalValues();

		return tipologia;
	}

	/**
	 * Returns the tipologia with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia
	 * @return the tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipologiaException {

		Tipologia tipologia = fetchByPrimaryKey(primaryKey);

		if (tipologia == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipologiaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tipologia;
	}

	/**
	 * Returns the tipologia with the primary key or throws a <code>NoSuchTipologiaException</code> if it could not be found.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia
	 * @throws NoSuchTipologiaException if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia findByPrimaryKey(long tipologiaId)
		throws NoSuchTipologiaException {

		return findByPrimaryKey((Serializable)tipologiaId);
	}

	/**
	 * Returns the tipologia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipologiaId the primary key of the tipologia
	 * @return the tipologia, or <code>null</code> if a tipologia with the primary key could not be found
	 */
	@Override
	public Tipologia fetchByPrimaryKey(long tipologiaId) {
		return fetchByPrimaryKey((Serializable)tipologiaId);
	}

	/**
	 * Returns all the tipologias.
	 *
	 * @return the tipologias
	 */
	@Override
	public List<Tipologia> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @return the range of tipologias
	 */
	@Override
	public List<Tipologia> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologias
	 */
	@Override
	public List<Tipologia> findAll(
		int start, int end, OrderByComparator<Tipologia> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologias
	 * @param end the upper bound of the range of tipologias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipologias
	 */
	@Override
	public List<Tipologia> findAll(
		int start, int end, OrderByComparator<Tipologia> orderByComparator,
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

		List<Tipologia> list = null;

		if (useFinderCache) {
			list = (List<Tipologia>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIPOLOGIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOLOGIA;

				sql = sql.concat(TipologiaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Tipologia>)QueryUtil.list(
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
	 * Removes all the tipologias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tipologia tipologia : findAll()) {
			remove(tipologia);
		}
	}

	/**
	 * Returns the number of tipologias.
	 *
	 * @return the number of tipologias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TIPOLOGIA);

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

	/**
	 * Returns the primaryKeys of servizios associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return long[] of the primaryKeys of servizios associated with the tipologia
	 */
	@Override
	public long[] getServizioPrimaryKeys(long pk) {
		long[] pks = tipologiaToServizioTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * @param pk the primary key of the servizio
	 * @return the tipologias associated with the servizio
	 */
	@Override
	public List<Tipologia> getServizioTipologias(long pk) {
		return getServizioTipologias(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the servizio
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @return the range of tipologias associated with the servizio
	 */
	@Override
	public List<Tipologia> getServizioTipologias(long pk, int start, int end) {
		return getServizioTipologias(pk, start, end, null);
	}

	/**
	 * Returns all the tipologia associated with the servizio.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the servizio
	 * @param start the lower bound of the range of servizios
	 * @param end the upper bound of the range of servizios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologias associated with the servizio
	 */
	@Override
	public List<Tipologia> getServizioTipologias(
		long pk, int start, int end,
		OrderByComparator<Tipologia> orderByComparator) {

		return tipologiaToServizioTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of servizios associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @return the number of servizios associated with the tipologia
	 */
	@Override
	public int getServiziosSize(long pk) {
		long[] pks = tipologiaToServizioTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the servizio is associated with the tipologia.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 * @return <code>true</code> if the servizio is associated with the tipologia; <code>false</code> otherwise
	 */
	@Override
	public boolean containsServizio(long pk, long servizioPK) {
		return tipologiaToServizioTableMapper.containsTableMapping(
			pk, servizioPK);
	}

	/**
	 * Returns <code>true</code> if the tipologia has any servizios associated with it.
	 *
	 * @param pk the primary key of the tipologia to check for associations with servizios
	 * @return <code>true</code> if the tipologia has any servizios associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsServizios(long pk) {
		if (getServiziosSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 */
	@Override
	public void addServizio(long pk, long servizioPK) {
		Tipologia tipologia = fetchByPrimaryKey(pk);

		if (tipologia == null) {
			tipologiaToServizioTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, servizioPK);
		}
		else {
			tipologiaToServizioTableMapper.addTableMapping(
				tipologia.getCompanyId(), pk, servizioPK);
		}
	}

	/**
	 * Adds an association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizio the servizio
	 */
	@Override
	public void addServizio(long pk, Servizio servizio) {
		Tipologia tipologia = fetchByPrimaryKey(pk);

		if (tipologia == null) {
			tipologiaToServizioTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				servizio.getPrimaryKey());
		}
		else {
			tipologiaToServizioTableMapper.addTableMapping(
				tipologia.getCompanyId(), pk, servizio.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios
	 */
	@Override
	public void addServizios(long pk, long[] servizioPKs) {
		long companyId = 0;

		Tipologia tipologia = fetchByPrimaryKey(pk);

		if (tipologia == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = tipologia.getCompanyId();
		}

		tipologiaToServizioTableMapper.addTableMappings(
			companyId, pk, servizioPKs);
	}

	/**
	 * Adds an association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios
	 */
	@Override
	public void addServizios(long pk, List<Servizio> servizios) {
		addServizios(
			pk, ListUtil.toLongArray(servizios, Servizio.SERVIZIO_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the tipologia and its servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia to clear the associated servizios from
	 */
	@Override
	public void clearServizios(long pk) {
		tipologiaToServizioTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPK the primary key of the servizio
	 */
	@Override
	public void removeServizio(long pk, long servizioPK) {
		tipologiaToServizioTableMapper.deleteTableMapping(pk, servizioPK);
	}

	/**
	 * Removes the association between the tipologia and the servizio. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizio the servizio
	 */
	@Override
	public void removeServizio(long pk, Servizio servizio) {
		tipologiaToServizioTableMapper.deleteTableMapping(
			pk, servizio.getPrimaryKey());
	}

	/**
	 * Removes the association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios
	 */
	@Override
	public void removeServizios(long pk, long[] servizioPKs) {
		tipologiaToServizioTableMapper.deleteTableMappings(pk, servizioPKs);
	}

	/**
	 * Removes the association between the tipologia and the servizios. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios
	 */
	@Override
	public void removeServizios(long pk, List<Servizio> servizios) {
		removeServizios(
			pk, ListUtil.toLongArray(servizios, Servizio.SERVIZIO_ID_ACCESSOR));
	}

	/**
	 * Sets the servizios associated with the tipologia, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizioPKs the primary keys of the servizios to be associated with the tipologia
	 */
	@Override
	public void setServizios(long pk, long[] servizioPKs) {
		Set<Long> newServizioPKsSet = SetUtil.fromArray(servizioPKs);
		Set<Long> oldServizioPKsSet = SetUtil.fromArray(
			tipologiaToServizioTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeServizioPKsSet = new HashSet<Long>(oldServizioPKsSet);

		removeServizioPKsSet.removeAll(newServizioPKsSet);

		tipologiaToServizioTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeServizioPKsSet));

		newServizioPKsSet.removeAll(oldServizioPKsSet);

		long companyId = 0;

		Tipologia tipologia = fetchByPrimaryKey(pk);

		if (tipologia == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = tipologia.getCompanyId();
		}

		tipologiaToServizioTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newServizioPKsSet));
	}

	/**
	 * Sets the servizios associated with the tipologia, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tipologia
	 * @param servizios the servizios to be associated with the tipologia
	 */
	@Override
	public void setServizios(long pk, List<Servizio> servizios) {
		try {
			long[] servizioPKs = new long[servizios.size()];

			for (int i = 0; i < servizios.size(); i++) {
				Servizio servizio = servizios.get(i);

				servizioPKs[i] = servizio.getPrimaryKey();
			}

			setServizios(pk, servizioPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
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
		return "tipologiaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIPOLOGIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TipologiaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipologia persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		tipologiaToServizioTableMapper = TableMapperFactory.getTableMapper(
			"ServiziDigitaliGestioneServizi_servizio_tipologia#tipologiaId",
			"ServiziDigitaliGestioneServizi_servizio_tipologia", "companyId",
			"tipologiaId", "servizioId", this, Servizio.class);

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

		_finderPathWithPaginationFindByVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisibile",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"visibile"}, true);

		_finderPathWithoutPaginationFindByVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisibile",
			new String[] {Boolean.class.getName()}, new String[] {"visibile"},
			true);

		_finderPathCountByVisibile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisibile",
			new String[] {Boolean.class.getName()}, new String[] {"visibile"},
			false);

		_setTipologiaUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTipologiaUtilPersistence(null);

		entityCache.removeCache(TipologiaImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"ServiziDigitaliGestioneServizi_servizio_tipologia#tipologiaId");
	}

	private void _setTipologiaUtilPersistence(
		TipologiaPersistence tipologiaPersistence) {

		try {
			Field field = TipologiaUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tipologiaPersistence);
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

	protected TableMapper<Tipologia, Servizio> tipologiaToServizioTableMapper;

	private static final String _SQL_SELECT_TIPOLOGIA =
		"SELECT tipologia FROM Tipologia tipologia";

	private static final String _SQL_SELECT_TIPOLOGIA_WHERE =
		"SELECT tipologia FROM Tipologia tipologia WHERE ";

	private static final String _SQL_COUNT_TIPOLOGIA =
		"SELECT COUNT(tipologia) FROM Tipologia tipologia";

	private static final String _SQL_COUNT_TIPOLOGIA_WHERE =
		"SELECT COUNT(tipologia) FROM Tipologia tipologia WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tipologia.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Tipologia exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Tipologia exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TipologiaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TipologiaModelArgumentsResolver _tipologiaModelArgumentsResolver;

}