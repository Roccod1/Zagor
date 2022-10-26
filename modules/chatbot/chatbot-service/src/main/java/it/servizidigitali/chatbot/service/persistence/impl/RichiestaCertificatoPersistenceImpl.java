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

package it.servizidigitali.chatbot.service.persistence.impl;

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

import it.servizidigitali.chatbot.exception.NoSuchRichiestaCertificatoException;
import it.servizidigitali.chatbot.model.RichiestaCertificato;
import it.servizidigitali.chatbot.model.RichiestaCertificatoTable;
import it.servizidigitali.chatbot.model.impl.RichiestaCertificatoImpl;
import it.servizidigitali.chatbot.model.impl.RichiestaCertificatoModelImpl;
import it.servizidigitali.chatbot.service.persistence.RichiestaCertificatoPersistence;
import it.servizidigitali.chatbot.service.persistence.RichiestaCertificatoUtil;
import it.servizidigitali.chatbot.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the richiesta certificato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {RichiestaCertificatoPersistence.class, BasePersistence.class}
)
public class RichiestaCertificatoPersistenceImpl
	extends BasePersistenceImpl<RichiestaCertificato>
	implements RichiestaCertificatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RichiestaCertificatoUtil</code> to access the richiesta certificato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RichiestaCertificatoImpl.class.getName();

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
	 * Returns all the richiesta certificatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaCertificato richiestaCertificato : list) {
					if (!uuid.equals(richiestaCertificato.getUuid())) {
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

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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
				sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByUuid_First(
			String uuid,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByUuid_First(
			uuid, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByUuid_First(
		String uuid,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		List<RichiestaCertificato> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByUuid_Last(
			String uuid,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByUuid_Last(
			uuid, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByUuid_Last(
		String uuid,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RichiestaCertificato> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where uuid = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato[] findByUuid_PrevAndNext(
			long richiestaCertificatoId, String uuid,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		uuid = Objects.toString(uuid, "");

		RichiestaCertificato richiestaCertificato = findByPrimaryKey(
			richiestaCertificatoId);

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato[] array = new RichiestaCertificatoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, richiestaCertificato, uuid, orderByComparator, true);

			array[1] = richiestaCertificato;

			array[2] = getByUuid_PrevAndNext(
				session, richiestaCertificato, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaCertificato getByUuid_PrevAndNext(
		Session session, RichiestaCertificato richiestaCertificato, String uuid,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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
			sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
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
						richiestaCertificato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RichiestaCertificato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta certificatos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RichiestaCertificato richiestaCertificato :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

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
		"richiestaCertificato.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(richiestaCertificato.uuid IS NULL OR richiestaCertificato.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByUUID_G(
			uuid, groupId);

		if (richiestaCertificato == null) {
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

			throw new NoSuchRichiestaCertificatoException(sb.toString());
		}

		return richiestaCertificato;
	}

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the richiesta certificato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByUUID_G(
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

		if (result instanceof RichiestaCertificato) {
			RichiestaCertificato richiestaCertificato =
				(RichiestaCertificato)result;

			if (!Objects.equals(uuid, richiestaCertificato.getUuid()) ||
				(groupId != richiestaCertificato.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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

				List<RichiestaCertificato> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RichiestaCertificato richiestaCertificato = list.get(0);

					result = richiestaCertificato;

					cacheResult(richiestaCertificato);
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
			return (RichiestaCertificato)result;
		}
	}

	/**
	 * Removes the richiesta certificato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the richiesta certificato that was removed
	 */
	@Override
	public RichiestaCertificato removeByUUID_G(String uuid, long groupId)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = findByUUID_G(uuid, groupId);

		return remove(richiestaCertificato);
	}

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

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
		"richiestaCertificato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(richiestaCertificato.uuid IS NULL OR richiestaCertificato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"richiestaCertificato.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaCertificato richiestaCertificato : list) {
					if (!uuid.equals(richiestaCertificato.getUuid()) ||
						(companyId != richiestaCertificato.getCompanyId())) {

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

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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
				sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		List<RichiestaCertificato> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RichiestaCertificato> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato[] findByUuid_C_PrevAndNext(
			long richiestaCertificatoId, String uuid, long companyId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		uuid = Objects.toString(uuid, "");

		RichiestaCertificato richiestaCertificato = findByPrimaryKey(
			richiestaCertificatoId);

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato[] array = new RichiestaCertificatoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, richiestaCertificato, uuid, companyId,
				orderByComparator, true);

			array[1] = richiestaCertificato;

			array[2] = getByUuid_C_PrevAndNext(
				session, richiestaCertificato, uuid, companyId,
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

	protected RichiestaCertificato getByUuid_C_PrevAndNext(
		Session session, RichiestaCertificato richiestaCertificato, String uuid,
		long companyId,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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
			sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
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
						richiestaCertificato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RichiestaCertificato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta certificatos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RichiestaCertificato richiestaCertificato :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

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
		"richiestaCertificato.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(richiestaCertificato.uuid IS NULL OR richiestaCertificato.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"richiestaCertificato.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCodiceFiscale;
	private FinderPath _finderPathWithoutPaginationFindByCodiceFiscale;
	private FinderPath _finderPathCountByCodiceFiscale;

	/**
	 * Returns all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale) {

		return findByCodiceFiscale(
			codiceFiscale, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end) {

		return findByCodiceFiscale(codiceFiscale, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findByCodiceFiscale(
			codiceFiscale, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscale(
		String codiceFiscale, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		codiceFiscale = Objects.toString(codiceFiscale, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCodiceFiscale;
				finderArgs = new Object[] {codiceFiscale};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodiceFiscale;
			finderArgs = new Object[] {
				codiceFiscale, start, end, orderByComparator
			};
		}

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaCertificato richiestaCertificato : list) {
					if (!codiceFiscale.equals(
							richiestaCertificato.getCodiceFiscale())) {

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

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

			boolean bindCodiceFiscale = false;

			if (codiceFiscale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3);
			}
			else {
				bindCodiceFiscale = true;

				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscale) {
					queryPos.add(codiceFiscale);
				}

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByCodiceFiscale_First(
			String codiceFiscale,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByCodiceFiscale_First(
			codiceFiscale, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscale=");
		sb.append(codiceFiscale);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByCodiceFiscale_First(
		String codiceFiscale,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		List<RichiestaCertificato> list = findByCodiceFiscale(
			codiceFiscale, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByCodiceFiscale_Last(
			String codiceFiscale,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByCodiceFiscale_Last(
			codiceFiscale, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscale=");
		sb.append(codiceFiscale);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByCodiceFiscale_Last(
		String codiceFiscale,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		int count = countByCodiceFiscale(codiceFiscale);

		if (count == 0) {
			return null;
		}

		List<RichiestaCertificato> list = findByCodiceFiscale(
			codiceFiscale, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where codiceFiscale = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param codiceFiscale the codice fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato[] findByCodiceFiscale_PrevAndNext(
			long richiestaCertificatoId, String codiceFiscale,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		codiceFiscale = Objects.toString(codiceFiscale, "");

		RichiestaCertificato richiestaCertificato = findByPrimaryKey(
			richiestaCertificatoId);

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato[] array = new RichiestaCertificatoImpl[3];

			array[0] = getByCodiceFiscale_PrevAndNext(
				session, richiestaCertificato, codiceFiscale, orderByComparator,
				true);

			array[1] = richiestaCertificato;

			array[2] = getByCodiceFiscale_PrevAndNext(
				session, richiestaCertificato, codiceFiscale, orderByComparator,
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

	protected RichiestaCertificato getByCodiceFiscale_PrevAndNext(
		Session session, RichiestaCertificato richiestaCertificato,
		String codiceFiscale,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

		boolean bindCodiceFiscale = false;

		if (codiceFiscale.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3);
		}
		else {
			bindCodiceFiscale = true;

			sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2);
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
			sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCodiceFiscale) {
			queryPos.add(codiceFiscale);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						richiestaCertificato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RichiestaCertificato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta certificatos where codiceFiscale = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 */
	@Override
	public void removeByCodiceFiscale(String codiceFiscale) {
		for (RichiestaCertificato richiestaCertificato :
				findByCodiceFiscale(
					codiceFiscale, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos where codiceFiscale = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByCodiceFiscale(String codiceFiscale) {
		codiceFiscale = Objects.toString(codiceFiscale, "");

		FinderPath finderPath = _finderPathCountByCodiceFiscale;

		Object[] finderArgs = new Object[] {codiceFiscale};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

			boolean bindCodiceFiscale = false;

			if (codiceFiscale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3);
			}
			else {
				bindCodiceFiscale = true;

				sb.append(_FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscale) {
					queryPos.add(codiceFiscale);
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

	private static final String _FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_2 =
		"richiestaCertificato.codiceFiscale = ?";

	private static final String _FINDER_COLUMN_CODICEFISCALE_CODICEFISCALE_3 =
		"(richiestaCertificato.codiceFiscale IS NULL OR richiestaCertificato.codiceFiscale = '')";

	private FinderPath _finderPathWithPaginationFindByCodiceFiscaleGroupId;
	private FinderPath _finderPathWithoutPaginationFindByCodiceFiscaleGroupId;
	private FinderPath _finderPathCountByCodiceFiscaleGroupId;

	/**
	 * Returns all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @return the matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId) {

		return findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end) {

		return findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		codiceFiscale = Objects.toString(codiceFiscale, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCodiceFiscaleGroupId;
				finderArgs = new Object[] {codiceFiscale, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodiceFiscaleGroupId;
			finderArgs = new Object[] {
				codiceFiscale, groupId, start, end, orderByComparator
			};
		}

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaCertificato richiestaCertificato : list) {
					if (!codiceFiscale.equals(
							richiestaCertificato.getCodiceFiscale()) ||
						(groupId != richiestaCertificato.getGroupId())) {

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

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

			boolean bindCodiceFiscale = false;

			if (codiceFiscale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_3);
			}
			else {
				bindCodiceFiscale = true;

				sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_2);
			}

			sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscale) {
					queryPos.add(codiceFiscale);
				}

				queryPos.add(groupId);

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByCodiceFiscaleGroupId_First(
			String codiceFiscale, long groupId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato =
			fetchByCodiceFiscaleGroupId_First(
				codiceFiscale, groupId, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscale=");
		sb.append(codiceFiscale);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByCodiceFiscaleGroupId_First(
		String codiceFiscale, long groupId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		List<RichiestaCertificato> list = findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByCodiceFiscaleGroupId_Last(
			String codiceFiscale, long groupId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato =
			fetchByCodiceFiscaleGroupId_Last(
				codiceFiscale, groupId, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("codiceFiscale=");
		sb.append(codiceFiscale);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByCodiceFiscaleGroupId_Last(
		String codiceFiscale, long groupId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		int count = countByCodiceFiscaleGroupId(codiceFiscale, groupId);

		if (count == 0) {
			return null;
		}

		List<RichiestaCertificato> list = findByCodiceFiscaleGroupId(
			codiceFiscale, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato[] findByCodiceFiscaleGroupId_PrevAndNext(
			long richiestaCertificatoId, String codiceFiscale, long groupId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		codiceFiscale = Objects.toString(codiceFiscale, "");

		RichiestaCertificato richiestaCertificato = findByPrimaryKey(
			richiestaCertificatoId);

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato[] array = new RichiestaCertificatoImpl[3];

			array[0] = getByCodiceFiscaleGroupId_PrevAndNext(
				session, richiestaCertificato, codiceFiscale, groupId,
				orderByComparator, true);

			array[1] = richiestaCertificato;

			array[2] = getByCodiceFiscaleGroupId_PrevAndNext(
				session, richiestaCertificato, codiceFiscale, groupId,
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

	protected RichiestaCertificato getByCodiceFiscaleGroupId_PrevAndNext(
		Session session, RichiestaCertificato richiestaCertificato,
		String codiceFiscale, long groupId,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

		boolean bindCodiceFiscale = false;

		if (codiceFiscale.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_3);
		}
		else {
			bindCodiceFiscale = true;

			sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_2);
		}

		sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_GROUPID_2);

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
			sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCodiceFiscale) {
			queryPos.add(codiceFiscale);
		}

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						richiestaCertificato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RichiestaCertificato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta certificatos where codiceFiscale = &#63; and groupId = &#63; from the database.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 */
	@Override
	public void removeByCodiceFiscaleGroupId(
		String codiceFiscale, long groupId) {

		for (RichiestaCertificato richiestaCertificato :
				findByCodiceFiscaleGroupId(
					codiceFiscale, groupId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos where codiceFiscale = &#63; and groupId = &#63;.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByCodiceFiscaleGroupId(String codiceFiscale, long groupId) {
		codiceFiscale = Objects.toString(codiceFiscale, "");

		FinderPath finderPath = _finderPathCountByCodiceFiscaleGroupId;

		Object[] finderArgs = new Object[] {codiceFiscale, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

			boolean bindCodiceFiscale = false;

			if (codiceFiscale.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_3);
			}
			else {
				bindCodiceFiscale = true;

				sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_2);
			}

			sb.append(_FINDER_COLUMN_CODICEFISCALEGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCodiceFiscale) {
					queryPos.add(codiceFiscale);
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

	private static final String
		_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_2 =
			"richiestaCertificato.codiceFiscale = ? AND ";

	private static final String
		_FINDER_COLUMN_CODICEFISCALEGROUPID_CODICEFISCALE_3 =
			"(richiestaCertificato.codiceFiscale IS NULL OR richiestaCertificato.codiceFiscale = '') AND ";

	private static final String _FINDER_COLUMN_CODICEFISCALEGROUPID_GROUPID_2 =
		"richiestaCertificato.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStato;
	private FinderPath _finderPathWithoutPaginationFindByStato;
	private FinderPath _finderPathCountByStato;

	/**
	 * Returns all the richiesta certificatos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByStato(String stato) {
		return findByStato(stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByStato(
		String stato, int start, int end) {

		return findByStato(stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByStato(
		String stato, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findByStato(stato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByStato(
		String stato, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

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

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaCertificato richiestaCertificato : list) {
					if (!stato.equals(richiestaCertificato.getStato())) {
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

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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
				sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
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

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Returns the first richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByStato_First(
			String stato,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByStato_First(
			stato, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByStato_First(
		String stato,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		List<RichiestaCertificato> list = findByStato(
			stato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByStato_Last(
			String stato,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByStato_Last(
			stato, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByStato_Last(
		String stato,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		int count = countByStato(stato);

		if (count == 0) {
			return null;
		}

		List<RichiestaCertificato> list = findByStato(
			stato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where stato = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato[] findByStato_PrevAndNext(
			long richiestaCertificatoId, String stato,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		stato = Objects.toString(stato, "");

		RichiestaCertificato richiestaCertificato = findByPrimaryKey(
			richiestaCertificatoId);

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato[] array = new RichiestaCertificatoImpl[3];

			array[0] = getByStato_PrevAndNext(
				session, richiestaCertificato, stato, orderByComparator, true);

			array[1] = richiestaCertificato;

			array[2] = getByStato_PrevAndNext(
				session, richiestaCertificato, stato, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaCertificato getByStato_PrevAndNext(
		Session session, RichiestaCertificato richiestaCertificato,
		String stato, OrderByComparator<RichiestaCertificato> orderByComparator,
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

		sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

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
			sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						richiestaCertificato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RichiestaCertificato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta certificatos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	@Override
	public void removeByStato(String stato) {
		for (RichiestaCertificato richiestaCertificato :
				findByStato(
					stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByStato(String stato) {
		stato = Objects.toString(stato, "");

		FinderPath finderPath = _finderPathCountByStato;

		Object[] finderArgs = new Object[] {stato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

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
		"richiestaCertificato.stato = ?";

	private static final String _FINDER_COLUMN_STATO_STATO_3 =
		"(richiestaCertificato.stato IS NULL OR richiestaCertificato.stato = '')";

	private FinderPath _finderPathWithPaginationFindByServizioId;
	private FinderPath _finderPathWithoutPaginationFindByServizioId;
	private FinderPath _finderPathCountByServizioId;

	/**
	 * Returns all the richiesta certificatos where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByServizioId(long servizioId) {
		return findByServizioId(
			servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end) {

		return findByServizioId(servizioId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findByServizioId(
			servizioId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos where servizioId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param servizioId the servizio ID
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findByServizioId(
		long servizioId, int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByServizioId;
				finderArgs = new Object[] {servizioId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByServizioId;
			finderArgs = new Object[] {
				servizioId, start, end, orderByComparator
			};
		}

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaCertificato richiestaCertificato : list) {
					if (servizioId != richiestaCertificato.getServizioId()) {
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

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Returns the first richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByServizioId_First(
			long servizioId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByServizioId_First(
			servizioId, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the first richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByServizioId_First(
		long servizioId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		List<RichiestaCertificato> list = findByServizioId(
			servizioId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByServizioId_Last(
			long servizioId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByServizioId_Last(
			servizioId, orderByComparator);

		if (richiestaCertificato != null) {
			return richiestaCertificato;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("servizioId=");
		sb.append(servizioId);

		sb.append("}");

		throw new NoSuchRichiestaCertificatoException(sb.toString());
	}

	/**
	 * Returns the last richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByServizioId_Last(
		long servizioId,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		int count = countByServizioId(servizioId);

		if (count == 0) {
			return null;
		}

		List<RichiestaCertificato> list = findByServizioId(
			servizioId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta certificatos before and after the current richiesta certificato in the ordered set where servizioId = &#63;.
	 *
	 * @param richiestaCertificatoId the primary key of the current richiesta certificato
	 * @param servizioId the servizio ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato[] findByServizioId_PrevAndNext(
			long richiestaCertificatoId, long servizioId,
			OrderByComparator<RichiestaCertificato> orderByComparator)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = findByPrimaryKey(
			richiestaCertificatoId);

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato[] array = new RichiestaCertificatoImpl[3];

			array[0] = getByServizioId_PrevAndNext(
				session, richiestaCertificato, servizioId, orderByComparator,
				true);

			array[1] = richiestaCertificato;

			array[2] = getByServizioId_PrevAndNext(
				session, richiestaCertificato, servizioId, orderByComparator,
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

	protected RichiestaCertificato getByServizioId_PrevAndNext(
		Session session, RichiestaCertificato richiestaCertificato,
		long servizioId,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

		sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

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
			sb.append(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(servizioId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						richiestaCertificato)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RichiestaCertificato> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta certificatos where servizioId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 */
	@Override
	public void removeByServizioId(long servizioId) {
		for (RichiestaCertificato richiestaCertificato :
				findByServizioId(
					servizioId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos where servizioId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByServizioId(long servizioId) {
		FinderPath finderPath = _finderPathCountByServizioId;

		Object[] finderArgs = new Object[] {servizioId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

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

	private static final String _FINDER_COLUMN_SERVIZIOID_SERVIZIOID_2 =
		"richiestaCertificato.servizioId = ?";

	private FinderPath _finderPathFetchByServizioIdGroupId;
	private FinderPath _finderPathCountByServizioIdGroupId;

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the matching richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato findByServizioIdGroupId(
			long servizioId, long groupId)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByServizioIdGroupId(
			servizioId, groupId);

		if (richiestaCertificato == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("servizioId=");
			sb.append(servizioId);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRichiestaCertificatoException(sb.toString());
		}

		return richiestaCertificato;
	}

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByServizioIdGroupId(
		long servizioId, long groupId) {

		return fetchByServizioIdGroupId(servizioId, groupId, true);
	}

	/**
	 * Returns the richiesta certificato where servizioId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching richiesta certificato, or <code>null</code> if a matching richiesta certificato could not be found
	 */
	@Override
	public RichiestaCertificato fetchByServizioIdGroupId(
		long servizioId, long groupId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {servizioId, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByServizioIdGroupId, finderArgs);
		}

		if (result instanceof RichiestaCertificato) {
			RichiestaCertificato richiestaCertificato =
				(RichiestaCertificato)result;

			if ((servizioId != richiestaCertificato.getServizioId()) ||
				(groupId != richiestaCertificato.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RICHIESTACERTIFICATO_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOIDGROUPID_SERVIZIOID_2);

			sb.append(_FINDER_COLUMN_SERVIZIOIDGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

				queryPos.add(groupId);

				List<RichiestaCertificato> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByServizioIdGroupId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {servizioId, groupId};
							}

							_log.warn(
								"RichiestaCertificatoPersistenceImpl.fetchByServizioIdGroupId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RichiestaCertificato richiestaCertificato = list.get(0);

					result = richiestaCertificato;

					cacheResult(richiestaCertificato);
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
			return (RichiestaCertificato)result;
		}
	}

	/**
	 * Removes the richiesta certificato where servizioId = &#63; and groupId = &#63; from the database.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the richiesta certificato that was removed
	 */
	@Override
	public RichiestaCertificato removeByServizioIdGroupId(
			long servizioId, long groupId)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = findByServizioIdGroupId(
			servizioId, groupId);

		return remove(richiestaCertificato);
	}

	/**
	 * Returns the number of richiesta certificatos where servizioId = &#63; and groupId = &#63;.
	 *
	 * @param servizioId the servizio ID
	 * @param groupId the group ID
	 * @return the number of matching richiesta certificatos
	 */
	@Override
	public int countByServizioIdGroupId(long servizioId, long groupId) {
		FinderPath finderPath = _finderPathCountByServizioIdGroupId;

		Object[] finderArgs = new Object[] {servizioId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RICHIESTACERTIFICATO_WHERE);

			sb.append(_FINDER_COLUMN_SERVIZIOIDGROUPID_SERVIZIOID_2);

			sb.append(_FINDER_COLUMN_SERVIZIOIDGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(servizioId);

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

	private static final String _FINDER_COLUMN_SERVIZIOIDGROUPID_SERVIZIOID_2 =
		"richiestaCertificato.servizioId = ? AND ";

	private static final String _FINDER_COLUMN_SERVIZIOIDGROUPID_GROUPID_2 =
		"richiestaCertificato.groupId = ?";

	public RichiestaCertificatoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RichiestaCertificato.class);

		setModelImplClass(RichiestaCertificatoImpl.class);
		setModelPKClass(long.class);

		setTable(RichiestaCertificatoTable.INSTANCE);
	}

	/**
	 * Caches the richiesta certificato in the entity cache if it is enabled.
	 *
	 * @param richiestaCertificato the richiesta certificato
	 */
	@Override
	public void cacheResult(RichiestaCertificato richiestaCertificato) {
		entityCache.putResult(
			RichiestaCertificatoImpl.class,
			richiestaCertificato.getPrimaryKey(), richiestaCertificato);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				richiestaCertificato.getUuid(),
				richiestaCertificato.getGroupId()
			},
			richiestaCertificato);

		finderCache.putResult(
			_finderPathFetchByServizioIdGroupId,
			new Object[] {
				richiestaCertificato.getServizioId(),
				richiestaCertificato.getGroupId()
			},
			richiestaCertificato);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the richiesta certificatos in the entity cache if it is enabled.
	 *
	 * @param richiestaCertificatos the richiesta certificatos
	 */
	@Override
	public void cacheResult(List<RichiestaCertificato> richiestaCertificatos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (richiestaCertificatos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RichiestaCertificato richiestaCertificato :
				richiestaCertificatos) {

			if (entityCache.getResult(
					RichiestaCertificatoImpl.class,
					richiestaCertificato.getPrimaryKey()) == null) {

				cacheResult(richiestaCertificato);
			}
		}
	}

	/**
	 * Clears the cache for all richiesta certificatos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiestaCertificatoImpl.class);

		finderCache.clearCache(RichiestaCertificatoImpl.class);
	}

	/**
	 * Clears the cache for the richiesta certificato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiestaCertificato richiestaCertificato) {
		entityCache.removeResult(
			RichiestaCertificatoImpl.class, richiestaCertificato);
	}

	@Override
	public void clearCache(List<RichiestaCertificato> richiestaCertificatos) {
		for (RichiestaCertificato richiestaCertificato :
				richiestaCertificatos) {

			entityCache.removeResult(
				RichiestaCertificatoImpl.class, richiestaCertificato);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RichiestaCertificatoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				RichiestaCertificatoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RichiestaCertificatoModelImpl richiestaCertificatoModelImpl) {

		Object[] args = new Object[] {
			richiestaCertificatoModelImpl.getUuid(),
			richiestaCertificatoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, richiestaCertificatoModelImpl);

		args = new Object[] {
			richiestaCertificatoModelImpl.getServizioId(),
			richiestaCertificatoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByServizioIdGroupId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByServizioIdGroupId, args,
			richiestaCertificatoModelImpl);
	}

	/**
	 * Creates a new richiesta certificato with the primary key. Does not add the richiesta certificato to the database.
	 *
	 * @param richiestaCertificatoId the primary key for the new richiesta certificato
	 * @return the new richiesta certificato
	 */
	@Override
	public RichiestaCertificato create(long richiestaCertificatoId) {
		RichiestaCertificato richiestaCertificato =
			new RichiestaCertificatoImpl();

		richiestaCertificato.setNew(true);
		richiestaCertificato.setPrimaryKey(richiestaCertificatoId);

		String uuid = PortalUUIDUtil.generate();

		richiestaCertificato.setUuid(uuid);

		richiestaCertificato.setCompanyId(CompanyThreadLocal.getCompanyId());

		return richiestaCertificato;
	}

	/**
	 * Removes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato remove(long richiestaCertificatoId)
		throws NoSuchRichiestaCertificatoException {

		return remove((Serializable)richiestaCertificatoId);
	}

	/**
	 * Removes the richiesta certificato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta certificato
	 * @return the richiesta certificato that was removed
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato remove(Serializable primaryKey)
		throws NoSuchRichiestaCertificatoException {

		Session session = null;

		try {
			session = openSession();

			RichiestaCertificato richiestaCertificato =
				(RichiestaCertificato)session.get(
					RichiestaCertificatoImpl.class, primaryKey);

			if (richiestaCertificato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiestaCertificatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(richiestaCertificato);
		}
		catch (NoSuchRichiestaCertificatoException noSuchEntityException) {
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
	protected RichiestaCertificato removeImpl(
		RichiestaCertificato richiestaCertificato) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiestaCertificato)) {
				richiestaCertificato = (RichiestaCertificato)session.get(
					RichiestaCertificatoImpl.class,
					richiestaCertificato.getPrimaryKeyObj());
			}

			if (richiestaCertificato != null) {
				session.delete(richiestaCertificato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (richiestaCertificato != null) {
			clearCache(richiestaCertificato);
		}

		return richiestaCertificato;
	}

	@Override
	public RichiestaCertificato updateImpl(
		RichiestaCertificato richiestaCertificato) {

		boolean isNew = richiestaCertificato.isNew();

		if (!(richiestaCertificato instanceof RichiestaCertificatoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(richiestaCertificato.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					richiestaCertificato);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in richiestaCertificato proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RichiestaCertificato implementation " +
					richiestaCertificato.getClass());
		}

		RichiestaCertificatoModelImpl richiestaCertificatoModelImpl =
			(RichiestaCertificatoModelImpl)richiestaCertificato;

		if (Validator.isNull(richiestaCertificato.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			richiestaCertificato.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (richiestaCertificato.getCreateDate() == null)) {
			if (serviceContext == null) {
				richiestaCertificato.setCreateDate(date);
			}
			else {
				richiestaCertificato.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!richiestaCertificatoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				richiestaCertificato.setModifiedDate(date);
			}
			else {
				richiestaCertificato.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(richiestaCertificato);
			}
			else {
				richiestaCertificato = (RichiestaCertificato)session.merge(
					richiestaCertificato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RichiestaCertificatoImpl.class, richiestaCertificatoModelImpl,
			false, true);

		cacheUniqueFindersCache(richiestaCertificatoModelImpl);

		if (isNew) {
			richiestaCertificato.setNew(false);
		}

		richiestaCertificato.resetOriginalValues();

		return richiestaCertificato;
	}

	/**
	 * Returns the richiesta certificato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiestaCertificatoException {

		RichiestaCertificato richiestaCertificato = fetchByPrimaryKey(
			primaryKey);

		if (richiestaCertificato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiestaCertificatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return richiestaCertificato;
	}

	/**
	 * Returns the richiesta certificato with the primary key or throws a <code>NoSuchRichiestaCertificatoException</code> if it could not be found.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato
	 * @throws NoSuchRichiestaCertificatoException if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato findByPrimaryKey(long richiestaCertificatoId)
		throws NoSuchRichiestaCertificatoException {

		return findByPrimaryKey((Serializable)richiestaCertificatoId);
	}

	/**
	 * Returns the richiesta certificato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param richiestaCertificatoId the primary key of the richiesta certificato
	 * @return the richiesta certificato, or <code>null</code> if a richiesta certificato with the primary key could not be found
	 */
	@Override
	public RichiestaCertificato fetchByPrimaryKey(long richiestaCertificatoId) {
		return fetchByPrimaryKey((Serializable)richiestaCertificatoId);
	}

	/**
	 * Returns all the richiesta certificatos.
	 *
	 * @return the richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @return the range of richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findAll(
		int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta certificatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RichiestaCertificatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta certificatos
	 * @param end the upper bound of the range of richiesta certificatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of richiesta certificatos
	 */
	@Override
	public List<RichiestaCertificato> findAll(
		int start, int end,
		OrderByComparator<RichiestaCertificato> orderByComparator,
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

		List<RichiestaCertificato> list = null;

		if (useFinderCache) {
			list = (List<RichiestaCertificato>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RICHIESTACERTIFICATO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTACERTIFICATO;

				sql = sql.concat(RichiestaCertificatoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RichiestaCertificato>)QueryUtil.list(
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
	 * Removes all the richiesta certificatos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiestaCertificato richiestaCertificato : findAll()) {
			remove(richiestaCertificato);
		}
	}

	/**
	 * Returns the number of richiesta certificatos.
	 *
	 * @return the number of richiesta certificatos
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
					_SQL_COUNT_RICHIESTACERTIFICATO);

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
		return "richiestaCertificatoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RICHIESTACERTIFICATO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RichiestaCertificatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta certificato persistence.
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

		_finderPathWithPaginationFindByCodiceFiscale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodiceFiscale",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"codiceFiscale"}, true);

		_finderPathWithoutPaginationFindByCodiceFiscale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodiceFiscale",
			new String[] {String.class.getName()},
			new String[] {"codiceFiscale"}, true);

		_finderPathCountByCodiceFiscale = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodiceFiscale",
			new String[] {String.class.getName()},
			new String[] {"codiceFiscale"}, false);

		_finderPathWithPaginationFindByCodiceFiscaleGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCodiceFiscaleGroupId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"codiceFiscale", "groupId"}, true);

		_finderPathWithoutPaginationFindByCodiceFiscaleGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCodiceFiscaleGroupId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"codiceFiscale", "groupId"}, true);

		_finderPathCountByCodiceFiscaleGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCodiceFiscaleGroupId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"codiceFiscale", "groupId"}, false);

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

		_finderPathWithPaginationFindByServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServizioId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"servizioId"}, true);

		_finderPathWithoutPaginationFindByServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServizioId",
			new String[] {Long.class.getName()}, new String[] {"servizioId"},
			true);

		_finderPathCountByServizioId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServizioId",
			new String[] {Long.class.getName()}, new String[] {"servizioId"},
			false);

		_finderPathFetchByServizioIdGroupId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByServizioIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"servizioId", "groupId"}, true);

		_finderPathCountByServizioIdGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServizioIdGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"servizioId", "groupId"}, false);

		_setRichiestaCertificatoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRichiestaCertificatoUtilPersistence(null);

		entityCache.removeCache(RichiestaCertificatoImpl.class.getName());
	}

	private void _setRichiestaCertificatoUtilPersistence(
		RichiestaCertificatoPersistence richiestaCertificatoPersistence) {

		try {
			Field field = RichiestaCertificatoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, richiestaCertificatoPersistence);
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

	private static final String _SQL_SELECT_RICHIESTACERTIFICATO =
		"SELECT richiestaCertificato FROM RichiestaCertificato richiestaCertificato";

	private static final String _SQL_SELECT_RICHIESTACERTIFICATO_WHERE =
		"SELECT richiestaCertificato FROM RichiestaCertificato richiestaCertificato WHERE ";

	private static final String _SQL_COUNT_RICHIESTACERTIFICATO =
		"SELECT COUNT(richiestaCertificato) FROM RichiestaCertificato richiestaCertificato";

	private static final String _SQL_COUNT_RICHIESTACERTIFICATO_WHERE =
		"SELECT COUNT(richiestaCertificato) FROM RichiestaCertificato richiestaCertificato WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"richiestaCertificato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RichiestaCertificato exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RichiestaCertificato exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RichiestaCertificatoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private RichiestaCertificatoModelArgumentsResolver
		_richiestaCertificatoModelArgumentsResolver;

}