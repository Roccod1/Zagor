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

package it.servizidigitali.gestioneprocessi.service.persistence.impl;

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

import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.model.ProcessoTable;
import it.servizidigitali.gestioneprocessi.model.impl.ProcessoImpl;
import it.servizidigitali.gestioneprocessi.model.impl.ProcessoModelImpl;
import it.servizidigitali.gestioneprocessi.service.persistence.ProcessoPersistence;
import it.servizidigitali.gestioneprocessi.service.persistence.ProcessoUtil;
import it.servizidigitali.gestioneprocessi.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the processo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProcessoPersistence.class, BasePersistence.class})
public class ProcessoPersistenceImpl
	extends BasePersistenceImpl<Processo> implements ProcessoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProcessoUtil</code> to access the processo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProcessoImpl.class.getName();

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
	 * Returns all the processos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching processos
	 */
	@Override
	public List<Processo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	@Override
	public List<Processo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

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

		List<Processo> list = null;

		if (useFinderCache) {
			list = (List<Processo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Processo processo : list) {
					if (!uuid.equals(processo.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCESSO_WHERE);

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
				sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Processo>)QueryUtil.list(
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
	 * Returns the first processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByUuid_First(
			String uuid, OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByUuid_First(uuid, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the first processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByUuid_First(
		String uuid, OrderByComparator<Processo> orderByComparator) {

		List<Processo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByUuid_Last(
			String uuid, OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByUuid_Last(uuid, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByUuid_Last(
		String uuid, OrderByComparator<Processo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Processo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where uuid = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo[] findByUuid_PrevAndNext(
			long processoId, String uuid,
			OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		uuid = Objects.toString(uuid, "");

		Processo processo = findByPrimaryKey(processoId);

		Session session = null;

		try {
			session = openSession();

			Processo[] array = new ProcessoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, processo, uuid, orderByComparator, true);

			array[1] = processo;

			array[2] = getByUuid_PrevAndNext(
				session, processo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Processo getByUuid_PrevAndNext(
		Session session, Processo processo, String uuid,
		OrderByComparator<Processo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCESSO_WHERE);

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
			sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(processo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Processo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the processos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Processo processo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(processo);
		}
	}

	/**
	 * Returns the number of processos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching processos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCESSO_WHERE);

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
		"processo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(processo.uuid IS NULL OR processo.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByUUID_G(String uuid, long groupId)
		throws NoSuchProcessoException {

		Processo processo = fetchByUUID_G(uuid, groupId);

		if (processo == null) {
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

			throw new NoSuchProcessoException(sb.toString());
		}

		return processo;
	}

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the processo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByUUID_G(
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

		if (result instanceof Processo) {
			Processo processo = (Processo)result;

			if (!Objects.equals(uuid, processo.getUuid()) ||
				(groupId != processo.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCESSO_WHERE);

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

				List<Processo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Processo processo = list.get(0);

					result = processo;

					cacheResult(processo);
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
			return (Processo)result;
		}
	}

	/**
	 * Removes the processo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the processo that was removed
	 */
	@Override
	public Processo removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcessoException {

		Processo processo = findByUUID_G(uuid, groupId);

		return remove(processo);
	}

	/**
	 * Returns the number of processos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching processos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCESSO_WHERE);

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
		"processo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(processo.uuid IS NULL OR processo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"processo.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching processos
	 */
	@Override
	public List<Processo> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	@Override
	public List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the processos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

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

		List<Processo> list = null;

		if (useFinderCache) {
			list = (List<Processo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Processo processo : list) {
					if (!uuid.equals(processo.getUuid()) ||
						(companyId != processo.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCESSO_WHERE);

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
				sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Processo>)QueryUtil.list(
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
	 * Returns the first processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the first processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Processo> orderByComparator) {

		List<Processo> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the last processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Processo> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Processo> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo[] findByUuid_C_PrevAndNext(
			long processoId, String uuid, long companyId,
			OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		uuid = Objects.toString(uuid, "");

		Processo processo = findByPrimaryKey(processoId);

		Session session = null;

		try {
			session = openSession();

			Processo[] array = new ProcessoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, processo, uuid, companyId, orderByComparator, true);

			array[1] = processo;

			array[2] = getByUuid_C_PrevAndNext(
				session, processo, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Processo getByUuid_C_PrevAndNext(
		Session session, Processo processo, String uuid, long companyId,
		OrderByComparator<Processo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROCESSO_WHERE);

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
			sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(processo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Processo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the processos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Processo processo :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(processo);
		}
	}

	/**
	 * Returns the number of processos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching processos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCESSO_WHERE);

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
		"processo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(processo.uuid IS NULL OR processo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"processo.companyId = ?";

	private FinderPath _finderPathFetchByCodice;
	private FinderPath _finderPathCountByCodice;

	/**
	 * Returns the processo where codice = &#63; or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param codice the codice
	 * @return the matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByCodice(String codice) throws NoSuchProcessoException {
		Processo processo = fetchByCodice(codice);

		if (processo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("codice=");
			sb.append(codice);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProcessoException(sb.toString());
		}

		return processo;
	}

	/**
	 * Returns the processo where codice = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codice the codice
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByCodice(String codice) {
		return fetchByCodice(codice, true);
	}

	/**
	 * Returns the processo where codice = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codice the codice
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByCodice(String codice, boolean useFinderCache) {
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

		if (result instanceof Processo) {
			Processo processo = (Processo)result;

			if (!Objects.equals(codice, processo.getCodice())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROCESSO_WHERE);

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

				List<Processo> list = query.list();

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
								"ProcessoPersistenceImpl.fetchByCodice(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Processo processo = list.get(0);

					result = processo;

					cacheResult(processo);
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
			return (Processo)result;
		}
	}

	/**
	 * Removes the processo where codice = &#63; from the database.
	 *
	 * @param codice the codice
	 * @return the processo that was removed
	 */
	@Override
	public Processo removeByCodice(String codice)
		throws NoSuchProcessoException {

		Processo processo = findByCodice(codice);

		return remove(processo);
	}

	/**
	 * Returns the number of processos where codice = &#63;.
	 *
	 * @param codice the codice
	 * @return the number of matching processos
	 */
	@Override
	public int countByCodice(String codice) {
		codice = Objects.toString(codice, "");

		FinderPath finderPath = _finderPathCountByCodice;

		Object[] finderArgs = new Object[] {codice};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCESSO_WHERE);

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
		"processo.codice = ?";

	private static final String _FINDER_COLUMN_CODICE_CODICE_3 =
		"(processo.codice IS NULL OR processo.codice = '')";

	private FinderPath _finderPathWithPaginationFindByStato;
	private FinderPath _finderPathWithoutPaginationFindByStato;
	private FinderPath _finderPathCountByStato;

	/**
	 * Returns all the processos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching processos
	 */
	@Override
	public List<Processo> findByStato(String stato) {
		return findByStato(stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	@Override
	public List<Processo> findByStato(String stato, int start, int end) {
		return findByStato(stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByStato(
		String stato, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return findByStato(stato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the processos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByStato(
		String stato, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

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

		List<Processo> list = null;

		if (useFinderCache) {
			list = (List<Processo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Processo processo : list) {
					if (!stato.equals(processo.getStato())) {
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

			sb.append(_SQL_SELECT_PROCESSO_WHERE);

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
				sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Processo>)QueryUtil.list(
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
	 * Returns the first processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByStato_First(
			String stato, OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByStato_First(stato, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the first processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByStato_First(
		String stato, OrderByComparator<Processo> orderByComparator) {

		List<Processo> list = findByStato(stato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByStato_Last(
			String stato, OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByStato_Last(stato, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the last processo in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByStato_Last(
		String stato, OrderByComparator<Processo> orderByComparator) {

		int count = countByStato(stato);

		if (count == 0) {
			return null;
		}

		List<Processo> list = findByStato(
			stato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where stato = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo[] findByStato_PrevAndNext(
			long processoId, String stato,
			OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		stato = Objects.toString(stato, "");

		Processo processo = findByPrimaryKey(processoId);

		Session session = null;

		try {
			session = openSession();

			Processo[] array = new ProcessoImpl[3];

			array[0] = getByStato_PrevAndNext(
				session, processo, stato, orderByComparator, true);

			array[1] = processo;

			array[2] = getByStato_PrevAndNext(
				session, processo, stato, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Processo getByStato_PrevAndNext(
		Session session, Processo processo, String stato,
		OrderByComparator<Processo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCESSO_WHERE);

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
			sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(processo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Processo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the processos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	@Override
	public void removeByStato(String stato) {
		for (Processo processo :
				findByStato(
					stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(processo);
		}
	}

	/**
	 * Returns the number of processos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching processos
	 */
	@Override
	public int countByStato(String stato) {
		stato = Objects.toString(stato, "");

		FinderPath finderPath = _finderPathCountByStato;

		Object[] finderArgs = new Object[] {stato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCESSO_WHERE);

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
		"processo.stato = ?";

	private static final String _FINDER_COLUMN_STATO_STATO_3 =
		"(processo.stato IS NULL OR processo.stato = '')";

	private FinderPath _finderPathWithPaginationFindByAttivo;
	private FinderPath _finderPathWithoutPaginationFindByAttivo;
	private FinderPath _finderPathCountByAttivo;

	/**
	 * Returns all the processos where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching processos
	 */
	@Override
	public List<Processo> findByAttivo(boolean attivo) {
		return findByAttivo(attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of matching processos
	 */
	@Override
	public List<Processo> findByAttivo(boolean attivo, int start, int end) {
		return findByAttivo(attivo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Processo> orderByComparator) {

		return findByAttivo(attivo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the processos where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching processos
	 */
	@Override
	public List<Processo> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<Processo> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAttivo;
				finderArgs = new Object[] {attivo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAttivo;
			finderArgs = new Object[] {attivo, start, end, orderByComparator};
		}

		List<Processo> list = null;

		if (useFinderCache) {
			list = (List<Processo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Processo processo : list) {
					if (attivo != processo.isAttivo()) {
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

			sb.append(_SQL_SELECT_PROCESSO_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

				list = (List<Processo>)QueryUtil.list(
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
	 * Returns the first processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByAttivo_First(
			boolean attivo, OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByAttivo_First(attivo, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the first processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByAttivo_First(
		boolean attivo, OrderByComparator<Processo> orderByComparator) {

		List<Processo> list = findByAttivo(attivo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo
	 * @throws NoSuchProcessoException if a matching processo could not be found
	 */
	@Override
	public Processo findByAttivo_Last(
			boolean attivo, OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = fetchByAttivo_Last(attivo, orderByComparator);

		if (processo != null) {
			return processo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("attivo=");
		sb.append(attivo);

		sb.append("}");

		throw new NoSuchProcessoException(sb.toString());
	}

	/**
	 * Returns the last processo in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching processo, or <code>null</code> if a matching processo could not be found
	 */
	@Override
	public Processo fetchByAttivo_Last(
		boolean attivo, OrderByComparator<Processo> orderByComparator) {

		int count = countByAttivo(attivo);

		if (count == 0) {
			return null;
		}

		List<Processo> list = findByAttivo(
			attivo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the processos before and after the current processo in the ordered set where attivo = &#63;.
	 *
	 * @param processoId the primary key of the current processo
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo[] findByAttivo_PrevAndNext(
			long processoId, boolean attivo,
			OrderByComparator<Processo> orderByComparator)
		throws NoSuchProcessoException {

		Processo processo = findByPrimaryKey(processoId);

		Session session = null;

		try {
			session = openSession();

			Processo[] array = new ProcessoImpl[3];

			array[0] = getByAttivo_PrevAndNext(
				session, processo, attivo, orderByComparator, true);

			array[1] = processo;

			array[2] = getByAttivo_PrevAndNext(
				session, processo, attivo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Processo getByAttivo_PrevAndNext(
		Session session, Processo processo, boolean attivo,
		OrderByComparator<Processo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCESSO_WHERE);

		sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

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
			sb.append(ProcessoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(attivo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(processo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Processo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the processos where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	@Override
	public void removeByAttivo(boolean attivo) {
		for (Processo processo :
				findByAttivo(
					attivo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(processo);
		}
	}

	/**
	 * Returns the number of processos where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching processos
	 */
	@Override
	public int countByAttivo(boolean attivo) {
		FinderPath finderPath = _finderPathCountByAttivo;

		Object[] finderArgs = new Object[] {attivo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCESSO_WHERE);

			sb.append(_FINDER_COLUMN_ATTIVO_ATTIVO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attivo);

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

	private static final String _FINDER_COLUMN_ATTIVO_ATTIVO_2 =
		"processo.attivo = ?";

	public ProcessoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Processo.class);

		setModelImplClass(ProcessoImpl.class);
		setModelPKClass(long.class);

		setTable(ProcessoTable.INSTANCE);
	}

	/**
	 * Caches the processo in the entity cache if it is enabled.
	 *
	 * @param processo the processo
	 */
	@Override
	public void cacheResult(Processo processo) {
		entityCache.putResult(
			ProcessoImpl.class, processo.getPrimaryKey(), processo);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {processo.getUuid(), processo.getGroupId()}, processo);

		finderCache.putResult(
			_finderPathFetchByCodice, new Object[] {processo.getCodice()},
			processo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the processos in the entity cache if it is enabled.
	 *
	 * @param processos the processos
	 */
	@Override
	public void cacheResult(List<Processo> processos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (processos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Processo processo : processos) {
			if (entityCache.getResult(
					ProcessoImpl.class, processo.getPrimaryKey()) == null) {

				cacheResult(processo);
			}
		}
	}

	/**
	 * Clears the cache for all processos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcessoImpl.class);

		finderCache.clearCache(ProcessoImpl.class);
	}

	/**
	 * Clears the cache for the processo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Processo processo) {
		entityCache.removeResult(ProcessoImpl.class, processo);
	}

	@Override
	public void clearCache(List<Processo> processos) {
		for (Processo processo : processos) {
			entityCache.removeResult(ProcessoImpl.class, processo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProcessoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProcessoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcessoModelImpl processoModelImpl) {

		Object[] args = new Object[] {
			processoModelImpl.getUuid(), processoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, processoModelImpl);

		args = new Object[] {processoModelImpl.getCodice()};

		finderCache.putResult(_finderPathCountByCodice, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCodice, args, processoModelImpl);
	}

	/**
	 * Creates a new processo with the primary key. Does not add the processo to the database.
	 *
	 * @param processoId the primary key for the new processo
	 * @return the new processo
	 */
	@Override
	public Processo create(long processoId) {
		Processo processo = new ProcessoImpl();

		processo.setNew(true);
		processo.setPrimaryKey(processoId);

		String uuid = PortalUUIDUtil.generate();

		processo.setUuid(uuid);

		processo.setCompanyId(CompanyThreadLocal.getCompanyId());

		return processo;
	}

	/**
	 * Removes the processo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo that was removed
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo remove(long processoId) throws NoSuchProcessoException {
		return remove((Serializable)processoId);
	}

	/**
	 * Removes the processo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the processo
	 * @return the processo that was removed
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo remove(Serializable primaryKey)
		throws NoSuchProcessoException {

		Session session = null;

		try {
			session = openSession();

			Processo processo = (Processo)session.get(
				ProcessoImpl.class, primaryKey);

			if (processo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcessoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(processo);
		}
		catch (NoSuchProcessoException noSuchEntityException) {
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
	protected Processo removeImpl(Processo processo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(processo)) {
				processo = (Processo)session.get(
					ProcessoImpl.class, processo.getPrimaryKeyObj());
			}

			if (processo != null) {
				session.delete(processo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (processo != null) {
			clearCache(processo);
		}

		return processo;
	}

	@Override
	public Processo updateImpl(Processo processo) {
		boolean isNew = processo.isNew();

		if (!(processo instanceof ProcessoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(processo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(processo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in processo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Processo implementation " +
					processo.getClass());
		}

		ProcessoModelImpl processoModelImpl = (ProcessoModelImpl)processo;

		if (Validator.isNull(processo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			processo.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (processo.getCreateDate() == null)) {
			if (serviceContext == null) {
				processo.setCreateDate(date);
			}
			else {
				processo.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!processoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				processo.setModifiedDate(date);
			}
			else {
				processo.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(processo);
			}
			else {
				processo = (Processo)session.merge(processo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProcessoImpl.class, processoModelImpl, false, true);

		cacheUniqueFindersCache(processoModelImpl);

		if (isNew) {
			processo.setNew(false);
		}

		processo.resetOriginalValues();

		return processo;
	}

	/**
	 * Returns the processo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the processo
	 * @return the processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcessoException {

		Processo processo = fetchByPrimaryKey(primaryKey);

		if (processo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcessoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return processo;
	}

	/**
	 * Returns the processo with the primary key or throws a <code>NoSuchProcessoException</code> if it could not be found.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo
	 * @throws NoSuchProcessoException if a processo with the primary key could not be found
	 */
	@Override
	public Processo findByPrimaryKey(long processoId)
		throws NoSuchProcessoException {

		return findByPrimaryKey((Serializable)processoId);
	}

	/**
	 * Returns the processo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processoId the primary key of the processo
	 * @return the processo, or <code>null</code> if a processo with the primary key could not be found
	 */
	@Override
	public Processo fetchByPrimaryKey(long processoId) {
		return fetchByPrimaryKey((Serializable)processoId);
	}

	/**
	 * Returns all the processos.
	 *
	 * @return the processos
	 */
	@Override
	public List<Processo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @return the range of processos
	 */
	@Override
	public List<Processo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of processos
	 */
	@Override
	public List<Processo> findAll(
		int start, int end, OrderByComparator<Processo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the processos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of processos
	 * @param end the upper bound of the range of processos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of processos
	 */
	@Override
	public List<Processo> findAll(
		int start, int end, OrderByComparator<Processo> orderByComparator,
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

		List<Processo> list = null;

		if (useFinderCache) {
			list = (List<Processo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCESSO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCESSO;

				sql = sql.concat(ProcessoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Processo>)QueryUtil.list(
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
	 * Removes all the processos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Processo processo : findAll()) {
			remove(processo);
		}
	}

	/**
	 * Returns the number of processos.
	 *
	 * @return the number of processos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROCESSO);

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
		return "processoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCESSO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcessoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the processo persistence.
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

		_finderPathWithPaginationFindByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAttivo",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"attivo"}, true);

		_finderPathWithoutPaginationFindByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAttivo",
			new String[] {Boolean.class.getName()}, new String[] {"attivo"},
			true);

		_finderPathCountByAttivo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAttivo",
			new String[] {Boolean.class.getName()}, new String[] {"attivo"},
			false);

		_setProcessoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProcessoUtilPersistence(null);

		entityCache.removeCache(ProcessoImpl.class.getName());
	}

	private void _setProcessoUtilPersistence(
		ProcessoPersistence processoPersistence) {

		try {
			Field field = ProcessoUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, processoPersistence);
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

	private static final String _SQL_SELECT_PROCESSO =
		"SELECT processo FROM Processo processo";

	private static final String _SQL_SELECT_PROCESSO_WHERE =
		"SELECT processo FROM Processo processo WHERE ";

	private static final String _SQL_COUNT_PROCESSO =
		"SELECT COUNT(processo) FROM Processo processo";

	private static final String _SQL_COUNT_PROCESSO_WHERE =
		"SELECT COUNT(processo) FROM Processo processo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "processo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Processo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Processo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProcessoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProcessoModelArgumentsResolver _processoModelArgumentsResolver;

}