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

package it.servizidigitali.gestioneforms.service.persistence.impl;

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

import it.servizidigitali.gestioneforms.exception.NoSuchDefinizioneAllegatoException;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegatoTable;
import it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoImpl;
import it.servizidigitali.gestioneforms.model.impl.DefinizioneAllegatoModelImpl;
import it.servizidigitali.gestioneforms.service.persistence.DefinizioneAllegatoPersistence;
import it.servizidigitali.gestioneforms.service.persistence.DefinizioneAllegatoUtil;
import it.servizidigitali.gestioneforms.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the definizione allegato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {DefinizioneAllegatoPersistence.class, BasePersistence.class}
)
public class DefinizioneAllegatoPersistenceImpl
	extends BasePersistenceImpl<DefinizioneAllegato>
	implements DefinizioneAllegatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DefinizioneAllegatoUtil</code> to access the definizione allegato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DefinizioneAllegatoImpl.class.getName();

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
	 * Returns all the definizione allegatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		List<DefinizioneAllegato> list = null;

		if (useFinderCache) {
			list = (List<DefinizioneAllegato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DefinizioneAllegato definizioneAllegato : list) {
					if (!uuid.equals(definizioneAllegato.getUuid())) {
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

			sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

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
				sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<DefinizioneAllegato>)QueryUtil.list(
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
	 * Returns the first definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByUuid_First(
			String uuid,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByUuid_First(
			uuid, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByUuid_First(
		String uuid, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		List<DefinizioneAllegato> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByUuid_Last(
			String uuid,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByUuid_Last(
			uuid, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByUuid_Last(
		String uuid, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DefinizioneAllegato> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where uuid = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato[] findByUuid_PrevAndNext(
			long definizioneAllegatoId, String uuid,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		uuid = Objects.toString(uuid, "");

		DefinizioneAllegato definizioneAllegato = findByPrimaryKey(
			definizioneAllegatoId);

		Session session = null;

		try {
			session = openSession();

			DefinizioneAllegato[] array = new DefinizioneAllegatoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, definizioneAllegato, uuid, orderByComparator, true);

			array[1] = definizioneAllegato;

			array[2] = getByUuid_PrevAndNext(
				session, definizioneAllegato, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DefinizioneAllegato getByUuid_PrevAndNext(
		Session session, DefinizioneAllegato definizioneAllegato, String uuid,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

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
			sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
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
						definizioneAllegato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DefinizioneAllegato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the definizione allegatos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DefinizioneAllegato definizioneAllegato :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(definizioneAllegato);
		}
	}

	/**
	 * Returns the number of definizione allegatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching definizione allegatos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEFINIZIONEALLEGATO_WHERE);

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
		"definizioneAllegato.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(definizioneAllegato.uuid IS NULL OR definizioneAllegato.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDefinizioneAllegatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByUUID_G(String uuid, long groupId)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByUUID_G(uuid, groupId);

		if (definizioneAllegato == null) {
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

			throw new NoSuchDefinizioneAllegatoException(sb.toString());
		}

		return definizioneAllegato;
	}

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the definizione allegato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByUUID_G(
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

		if (result instanceof DefinizioneAllegato) {
			DefinizioneAllegato definizioneAllegato =
				(DefinizioneAllegato)result;

			if (!Objects.equals(uuid, definizioneAllegato.getUuid()) ||
				(groupId != definizioneAllegato.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

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

				List<DefinizioneAllegato> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DefinizioneAllegato definizioneAllegato = list.get(0);

					result = definizioneAllegato;

					cacheResult(definizioneAllegato);
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
			return (DefinizioneAllegato)result;
		}
	}

	/**
	 * Removes the definizione allegato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the definizione allegato that was removed
	 */
	@Override
	public DefinizioneAllegato removeByUUID_G(String uuid, long groupId)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = findByUUID_G(uuid, groupId);

		return remove(definizioneAllegato);
	}

	/**
	 * Returns the number of definizione allegatos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching definizione allegatos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEFINIZIONEALLEGATO_WHERE);

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
		"definizioneAllegato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(definizioneAllegato.uuid IS NULL OR definizioneAllegato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"definizioneAllegato.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		List<DefinizioneAllegato> list = null;

		if (useFinderCache) {
			list = (List<DefinizioneAllegato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DefinizioneAllegato definizioneAllegato : list) {
					if (!uuid.equals(definizioneAllegato.getUuid()) ||
						(companyId != definizioneAllegato.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

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
				sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<DefinizioneAllegato>)QueryUtil.list(
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
	 * Returns the first definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the first definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		List<DefinizioneAllegato> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the last definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DefinizioneAllegato> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato[] findByUuid_C_PrevAndNext(
			long definizioneAllegatoId, String uuid, long companyId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		uuid = Objects.toString(uuid, "");

		DefinizioneAllegato definizioneAllegato = findByPrimaryKey(
			definizioneAllegatoId);

		Session session = null;

		try {
			session = openSession();

			DefinizioneAllegato[] array = new DefinizioneAllegatoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, definizioneAllegato, uuid, companyId,
				orderByComparator, true);

			array[1] = definizioneAllegato;

			array[2] = getByUuid_C_PrevAndNext(
				session, definizioneAllegato, uuid, companyId,
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

	protected DefinizioneAllegato getByUuid_C_PrevAndNext(
		Session session, DefinizioneAllegato definizioneAllegato, String uuid,
		long companyId,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

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
			sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
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
						definizioneAllegato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DefinizioneAllegato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the definizione allegatos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DefinizioneAllegato definizioneAllegato :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(definizioneAllegato);
		}
	}

	/**
	 * Returns the number of definizione allegatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching definizione allegatos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEFINIZIONEALLEGATO_WHERE);

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
		"definizioneAllegato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(definizioneAllegato.uuid IS NULL OR definizioneAllegato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"definizioneAllegato.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFormId;
	private FinderPath _finderPathWithoutPaginationFindByFormId;
	private FinderPath _finderPathCountByFormId;

	/**
	 * Returns all the definizione allegatos where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormId(long formId) {
		return findByFormId(formId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the definizione allegatos where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormId(
		long formId, int start, int end) {

		return findByFormId(formId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormId(
		long formId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return findByFormId(formId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormId(
		long formId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFormId;
				finderArgs = new Object[] {formId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFormId;
			finderArgs = new Object[] {formId, start, end, orderByComparator};
		}

		List<DefinizioneAllegato> list = null;

		if (useFinderCache) {
			list = (List<DefinizioneAllegato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DefinizioneAllegato definizioneAllegato : list) {
					if (formId != definizioneAllegato.getFormId()) {
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

			sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

			sb.append(_FINDER_COLUMN_FORMID_FORMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formId);

				list = (List<DefinizioneAllegato>)QueryUtil.list(
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
	 * Returns the first definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByFormId_First(
			long formId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByFormId_First(
			formId, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("formId=");
		sb.append(formId);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the first definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByFormId_First(
		long formId, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		List<DefinizioneAllegato> list = findByFormId(
			formId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByFormId_Last(
			long formId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByFormId_Last(
			formId, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("formId=");
		sb.append(formId);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByFormId_Last(
		long formId, OrderByComparator<DefinizioneAllegato> orderByComparator) {

		int count = countByFormId(formId);

		if (count == 0) {
			return null;
		}

		List<DefinizioneAllegato> list = findByFormId(
			formId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where formId = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato[] findByFormId_PrevAndNext(
			long definizioneAllegatoId, long formId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = findByPrimaryKey(
			definizioneAllegatoId);

		Session session = null;

		try {
			session = openSession();

			DefinizioneAllegato[] array = new DefinizioneAllegatoImpl[3];

			array[0] = getByFormId_PrevAndNext(
				session, definizioneAllegato, formId, orderByComparator, true);

			array[1] = definizioneAllegato;

			array[2] = getByFormId_PrevAndNext(
				session, definizioneAllegato, formId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DefinizioneAllegato getByFormId_PrevAndNext(
		Session session, DefinizioneAllegato definizioneAllegato, long formId,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

		sb.append(_FINDER_COLUMN_FORMID_FORMID_2);

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
			sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(formId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						definizioneAllegato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DefinizioneAllegato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the definizione allegatos where formId = &#63; from the database.
	 *
	 * @param formId the form ID
	 */
	@Override
	public void removeByFormId(long formId) {
		for (DefinizioneAllegato definizioneAllegato :
				findByFormId(
					formId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(definizioneAllegato);
		}
	}

	/**
	 * Returns the number of definizione allegatos where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the number of matching definizione allegatos
	 */
	@Override
	public int countByFormId(long formId) {
		FinderPath finderPath = _finderPathCountByFormId;

		Object[] finderArgs = new Object[] {formId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEFINIZIONEALLEGATO_WHERE);

			sb.append(_FINDER_COLUMN_FORMID_FORMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formId);

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

	private static final String _FINDER_COLUMN_FORMID_FORMID_2 =
		"definizioneAllegato.formId = ?";

	private FinderPath _finderPathWithPaginationFindByFormIdOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByFormIdOrganizationId;
	private FinderPath _finderPathCountByFormIdOrganizationId;

	/**
	 * Returns all the definizione allegatos where formId = &#63; and organizationId = &#63;.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @return the matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormIdOrganizationId(
		long formId, long organizationId) {

		return findByFormIdOrganizationId(
			formId, organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the definizione allegatos where formId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormIdOrganizationId(
		long formId, long organizationId, int start, int end) {

		return findByFormIdOrganizationId(
			formId, organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormIdOrganizationId(
		long formId, long organizationId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return findByFormIdOrganizationId(
			formId, organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos where formId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findByFormIdOrganizationId(
		long formId, long organizationId, int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFormIdOrganizationId;
				finderArgs = new Object[] {formId, organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFormIdOrganizationId;
			finderArgs = new Object[] {
				formId, organizationId, start, end, orderByComparator
			};
		}

		List<DefinizioneAllegato> list = null;

		if (useFinderCache) {
			list = (List<DefinizioneAllegato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DefinizioneAllegato definizioneAllegato : list) {
					if ((formId != definizioneAllegato.getFormId()) ||
						(organizationId !=
							definizioneAllegato.getOrganizationId())) {

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

			sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

			sb.append(_FINDER_COLUMN_FORMIDORGANIZATIONID_FORMID_2);

			sb.append(_FINDER_COLUMN_FORMIDORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formId);

				queryPos.add(organizationId);

				list = (List<DefinizioneAllegato>)QueryUtil.list(
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
	 * Returns the first definizione allegato in the ordered set where formId = &#63; and organizationId = &#63;.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByFormIdOrganizationId_First(
			long formId, long organizationId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato =
			fetchByFormIdOrganizationId_First(
				formId, organizationId, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("formId=");
		sb.append(formId);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the first definizione allegato in the ordered set where formId = &#63; and organizationId = &#63;.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByFormIdOrganizationId_First(
		long formId, long organizationId,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		List<DefinizioneAllegato> list = findByFormIdOrganizationId(
			formId, organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63; and organizationId = &#63;.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato findByFormIdOrganizationId_Last(
			long formId, long organizationId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato =
			fetchByFormIdOrganizationId_Last(
				formId, organizationId, orderByComparator);

		if (definizioneAllegato != null) {
			return definizioneAllegato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("formId=");
		sb.append(formId);

		sb.append(", organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchDefinizioneAllegatoException(sb.toString());
	}

	/**
	 * Returns the last definizione allegato in the ordered set where formId = &#63; and organizationId = &#63;.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching definizione allegato, or <code>null</code> if a matching definizione allegato could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByFormIdOrganizationId_Last(
		long formId, long organizationId,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		int count = countByFormIdOrganizationId(formId, organizationId);

		if (count == 0) {
			return null;
		}

		List<DefinizioneAllegato> list = findByFormIdOrganizationId(
			formId, organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the definizione allegatos before and after the current definizione allegato in the ordered set where formId = &#63; and organizationId = &#63;.
	 *
	 * @param definizioneAllegatoId the primary key of the current definizione allegato
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato[] findByFormIdOrganizationId_PrevAndNext(
			long definizioneAllegatoId, long formId, long organizationId,
			OrderByComparator<DefinizioneAllegato> orderByComparator)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = findByPrimaryKey(
			definizioneAllegatoId);

		Session session = null;

		try {
			session = openSession();

			DefinizioneAllegato[] array = new DefinizioneAllegatoImpl[3];

			array[0] = getByFormIdOrganizationId_PrevAndNext(
				session, definizioneAllegato, formId, organizationId,
				orderByComparator, true);

			array[1] = definizioneAllegato;

			array[2] = getByFormIdOrganizationId_PrevAndNext(
				session, definizioneAllegato, formId, organizationId,
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

	protected DefinizioneAllegato getByFormIdOrganizationId_PrevAndNext(
		Session session, DefinizioneAllegato definizioneAllegato, long formId,
		long organizationId,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO_WHERE);

		sb.append(_FINDER_COLUMN_FORMIDORGANIZATIONID_FORMID_2);

		sb.append(_FINDER_COLUMN_FORMIDORGANIZATIONID_ORGANIZATIONID_2);

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
			sb.append(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(formId);

		queryPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						definizioneAllegato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DefinizioneAllegato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the definizione allegatos where formId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByFormIdOrganizationId(long formId, long organizationId) {
		for (DefinizioneAllegato definizioneAllegato :
				findByFormIdOrganizationId(
					formId, organizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(definizioneAllegato);
		}
	}

	/**
	 * Returns the number of definizione allegatos where formId = &#63; and organizationId = &#63;.
	 *
	 * @param formId the form ID
	 * @param organizationId the organization ID
	 * @return the number of matching definizione allegatos
	 */
	@Override
	public int countByFormIdOrganizationId(long formId, long organizationId) {
		FinderPath finderPath = _finderPathCountByFormIdOrganizationId;

		Object[] finderArgs = new Object[] {formId, organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEFINIZIONEALLEGATO_WHERE);

			sb.append(_FINDER_COLUMN_FORMIDORGANIZATIONID_FORMID_2);

			sb.append(_FINDER_COLUMN_FORMIDORGANIZATIONID_ORGANIZATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formId);

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

	private static final String _FINDER_COLUMN_FORMIDORGANIZATIONID_FORMID_2 =
		"definizioneAllegato.formId = ? AND ";

	private static final String
		_FINDER_COLUMN_FORMIDORGANIZATIONID_ORGANIZATIONID_2 =
			"definizioneAllegato.organizationId = ?";

	public DefinizioneAllegatoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DefinizioneAllegato.class);

		setModelImplClass(DefinizioneAllegatoImpl.class);
		setModelPKClass(long.class);

		setTable(DefinizioneAllegatoTable.INSTANCE);
	}

	/**
	 * Caches the definizione allegato in the entity cache if it is enabled.
	 *
	 * @param definizioneAllegato the definizione allegato
	 */
	@Override
	public void cacheResult(DefinizioneAllegato definizioneAllegato) {
		entityCache.putResult(
			DefinizioneAllegatoImpl.class, definizioneAllegato.getPrimaryKey(),
			definizioneAllegato);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				definizioneAllegato.getUuid(), definizioneAllegato.getGroupId()
			},
			definizioneAllegato);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the definizione allegatos in the entity cache if it is enabled.
	 *
	 * @param definizioneAllegatos the definizione allegatos
	 */
	@Override
	public void cacheResult(List<DefinizioneAllegato> definizioneAllegatos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (definizioneAllegatos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DefinizioneAllegato definizioneAllegato : definizioneAllegatos) {
			if (entityCache.getResult(
					DefinizioneAllegatoImpl.class,
					definizioneAllegato.getPrimaryKey()) == null) {

				cacheResult(definizioneAllegato);
			}
		}
	}

	/**
	 * Clears the cache for all definizione allegatos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DefinizioneAllegatoImpl.class);

		finderCache.clearCache(DefinizioneAllegatoImpl.class);
	}

	/**
	 * Clears the cache for the definizione allegato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DefinizioneAllegato definizioneAllegato) {
		entityCache.removeResult(
			DefinizioneAllegatoImpl.class, definizioneAllegato);
	}

	@Override
	public void clearCache(List<DefinizioneAllegato> definizioneAllegatos) {
		for (DefinizioneAllegato definizioneAllegato : definizioneAllegatos) {
			entityCache.removeResult(
				DefinizioneAllegatoImpl.class, definizioneAllegato);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DefinizioneAllegatoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DefinizioneAllegatoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DefinizioneAllegatoModelImpl definizioneAllegatoModelImpl) {

		Object[] args = new Object[] {
			definizioneAllegatoModelImpl.getUuid(),
			definizioneAllegatoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, definizioneAllegatoModelImpl);
	}

	/**
	 * Creates a new definizione allegato with the primary key. Does not add the definizione allegato to the database.
	 *
	 * @param definizioneAllegatoId the primary key for the new definizione allegato
	 * @return the new definizione allegato
	 */
	@Override
	public DefinizioneAllegato create(long definizioneAllegatoId) {
		DefinizioneAllegato definizioneAllegato = new DefinizioneAllegatoImpl();

		definizioneAllegato.setNew(true);
		definizioneAllegato.setPrimaryKey(definizioneAllegatoId);

		String uuid = PortalUUIDUtil.generate();

		definizioneAllegato.setUuid(uuid);

		definizioneAllegato.setCompanyId(CompanyThreadLocal.getCompanyId());

		return definizioneAllegato;
	}

	/**
	 * Removes the definizione allegato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato that was removed
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato remove(long definizioneAllegatoId)
		throws NoSuchDefinizioneAllegatoException {

		return remove((Serializable)definizioneAllegatoId);
	}

	/**
	 * Removes the definizione allegato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the definizione allegato
	 * @return the definizione allegato that was removed
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato remove(Serializable primaryKey)
		throws NoSuchDefinizioneAllegatoException {

		Session session = null;

		try {
			session = openSession();

			DefinizioneAllegato definizioneAllegato =
				(DefinizioneAllegato)session.get(
					DefinizioneAllegatoImpl.class, primaryKey);

			if (definizioneAllegato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDefinizioneAllegatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(definizioneAllegato);
		}
		catch (NoSuchDefinizioneAllegatoException noSuchEntityException) {
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
	protected DefinizioneAllegato removeImpl(
		DefinizioneAllegato definizioneAllegato) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(definizioneAllegato)) {
				definizioneAllegato = (DefinizioneAllegato)session.get(
					DefinizioneAllegatoImpl.class,
					definizioneAllegato.getPrimaryKeyObj());
			}

			if (definizioneAllegato != null) {
				session.delete(definizioneAllegato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (definizioneAllegato != null) {
			clearCache(definizioneAllegato);
		}

		return definizioneAllegato;
	}

	@Override
	public DefinizioneAllegato updateImpl(
		DefinizioneAllegato definizioneAllegato) {

		boolean isNew = definizioneAllegato.isNew();

		if (!(definizioneAllegato instanceof DefinizioneAllegatoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(definizioneAllegato.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					definizioneAllegato);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in definizioneAllegato proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DefinizioneAllegato implementation " +
					definizioneAllegato.getClass());
		}

		DefinizioneAllegatoModelImpl definizioneAllegatoModelImpl =
			(DefinizioneAllegatoModelImpl)definizioneAllegato;

		if (Validator.isNull(definizioneAllegato.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			definizioneAllegato.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (definizioneAllegato.getCreateDate() == null)) {
			if (serviceContext == null) {
				definizioneAllegato.setCreateDate(date);
			}
			else {
				definizioneAllegato.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!definizioneAllegatoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				definizioneAllegato.setModifiedDate(date);
			}
			else {
				definizioneAllegato.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(definizioneAllegato);
			}
			else {
				definizioneAllegato = (DefinizioneAllegato)session.merge(
					definizioneAllegato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DefinizioneAllegatoImpl.class, definizioneAllegatoModelImpl, false,
			true);

		cacheUniqueFindersCache(definizioneAllegatoModelImpl);

		if (isNew) {
			definizioneAllegato.setNew(false);
		}

		definizioneAllegato.resetOriginalValues();

		return definizioneAllegato;
	}

	/**
	 * Returns the definizione allegato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the definizione allegato
	 * @return the definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDefinizioneAllegatoException {

		DefinizioneAllegato definizioneAllegato = fetchByPrimaryKey(primaryKey);

		if (definizioneAllegato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDefinizioneAllegatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return definizioneAllegato;
	}

	/**
	 * Returns the definizione allegato with the primary key or throws a <code>NoSuchDefinizioneAllegatoException</code> if it could not be found.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato
	 * @throws NoSuchDefinizioneAllegatoException if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato findByPrimaryKey(long definizioneAllegatoId)
		throws NoSuchDefinizioneAllegatoException {

		return findByPrimaryKey((Serializable)definizioneAllegatoId);
	}

	/**
	 * Returns the definizione allegato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param definizioneAllegatoId the primary key of the definizione allegato
	 * @return the definizione allegato, or <code>null</code> if a definizione allegato with the primary key could not be found
	 */
	@Override
	public DefinizioneAllegato fetchByPrimaryKey(long definizioneAllegatoId) {
		return fetchByPrimaryKey((Serializable)definizioneAllegatoId);
	}

	/**
	 * Returns all the definizione allegatos.
	 *
	 * @return the definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @return the range of definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findAll(
		int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the definizione allegatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DefinizioneAllegatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of definizione allegatos
	 * @param end the upper bound of the range of definizione allegatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of definizione allegatos
	 */
	@Override
	public List<DefinizioneAllegato> findAll(
		int start, int end,
		OrderByComparator<DefinizioneAllegato> orderByComparator,
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

		List<DefinizioneAllegato> list = null;

		if (useFinderCache) {
			list = (List<DefinizioneAllegato>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEFINIZIONEALLEGATO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEFINIZIONEALLEGATO;

				sql = sql.concat(DefinizioneAllegatoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DefinizioneAllegato>)QueryUtil.list(
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
	 * Removes all the definizione allegatos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DefinizioneAllegato definizioneAllegato : findAll()) {
			remove(definizioneAllegato);
		}
	}

	/**
	 * Returns the number of definizione allegatos.
	 *
	 * @return the number of definizione allegatos
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
					_SQL_COUNT_DEFINIZIONEALLEGATO);

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
		return "definizioneAllegatoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEFINIZIONEALLEGATO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DefinizioneAllegatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the definizione allegato persistence.
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

		_finderPathWithPaginationFindByFormId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFormId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"formId"}, true);

		_finderPathWithoutPaginationFindByFormId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFormId",
			new String[] {Long.class.getName()}, new String[] {"formId"}, true);

		_finderPathCountByFormId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFormId",
			new String[] {Long.class.getName()}, new String[] {"formId"},
			false);

		_finderPathWithPaginationFindByFormIdOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFormIdOrganizationId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"formId", "organizationId"}, true);

		_finderPathWithoutPaginationFindByFormIdOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFormIdOrganizationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"formId", "organizationId"}, true);

		_finderPathCountByFormIdOrganizationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFormIdOrganizationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"formId", "organizationId"}, false);

		_setDefinizioneAllegatoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDefinizioneAllegatoUtilPersistence(null);

		entityCache.removeCache(DefinizioneAllegatoImpl.class.getName());
	}

	private void _setDefinizioneAllegatoUtilPersistence(
		DefinizioneAllegatoPersistence definizioneAllegatoPersistence) {

		try {
			Field field = DefinizioneAllegatoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, definizioneAllegatoPersistence);
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

	private static final String _SQL_SELECT_DEFINIZIONEALLEGATO =
		"SELECT definizioneAllegato FROM DefinizioneAllegato definizioneAllegato";

	private static final String _SQL_SELECT_DEFINIZIONEALLEGATO_WHERE =
		"SELECT definizioneAllegato FROM DefinizioneAllegato definizioneAllegato WHERE ";

	private static final String _SQL_COUNT_DEFINIZIONEALLEGATO =
		"SELECT COUNT(definizioneAllegato) FROM DefinizioneAllegato definizioneAllegato";

	private static final String _SQL_COUNT_DEFINIZIONEALLEGATO_WHERE =
		"SELECT COUNT(definizioneAllegato) FROM DefinizioneAllegato definizioneAllegato WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "definizioneAllegato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DefinizioneAllegato exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DefinizioneAllegato exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DefinizioneAllegatoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DefinizioneAllegatoModelArgumentsResolver
		_definizioneAllegatoModelArgumentsResolver;

}