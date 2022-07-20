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

package it.servizidigitali.profiloutente.service.persistence.impl;

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

import it.servizidigitali.profiloutente.exception.NoSuchUtenteOrganizzazioneException;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneTable;
import it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneImpl;
import it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneModelImpl;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePersistence;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneUtil;
import it.servizidigitali.profiloutente.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the utente organizzazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {UtenteOrganizzazionePersistence.class, BasePersistence.class}
)
public class UtenteOrganizzazionePersistenceImpl
	extends BasePersistenceImpl<UtenteOrganizzazione>
	implements UtenteOrganizzazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UtenteOrganizzazioneUtil</code> to access the utente organizzazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UtenteOrganizzazioneImpl.class.getName();

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
	 * Returns all the utente organizzaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		List<UtenteOrganizzazione> list = null;

		if (useFinderCache) {
			list = (List<UtenteOrganizzazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazione utenteOrganizzazione : list) {
					if (!uuid.equals(utenteOrganizzazione.getUuid())) {
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

			sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

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
				sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
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

				list = (List<UtenteOrganizzazione>)QueryUtil.list(
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
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUuid_First(
			String uuid,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUuid_First(
			uuid, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUuid_First(
		String uuid,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		List<UtenteOrganizzazione> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUuid_Last(
			String uuid,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUuid_Last(
			uuid, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUuid_Last(
		String uuid,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazione> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where uuid = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione[] findByUuid_PrevAndNext(
			UtenteOrganizzazionePK utenteOrganizzazionePK, String uuid,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		uuid = Objects.toString(uuid, "");

		UtenteOrganizzazione utenteOrganizzazione = findByPrimaryKey(
			utenteOrganizzazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazione[] array = new UtenteOrganizzazioneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, utenteOrganizzazione, uuid, orderByComparator, true);

			array[1] = utenteOrganizzazione;

			array[2] = getByUuid_PrevAndNext(
				session, utenteOrganizzazione, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UtenteOrganizzazione getByUuid_PrevAndNext(
		Session session, UtenteOrganizzazione utenteOrganizzazione, String uuid,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

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
			sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UtenteOrganizzazione utenteOrganizzazione :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(utenteOrganizzazione);
		}
	}

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching utente organizzaziones
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE);

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
		"utenteOrganizzazione.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(utenteOrganizzazione.uuid IS NULL OR utenteOrganizzazione.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUUID_G(String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUUID_G(
			uuid, groupId);

		if (utenteOrganizzazione == null) {
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

			throw new NoSuchUtenteOrganizzazioneException(sb.toString());
		}

		return utenteOrganizzazione;
	}

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the utente organizzazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUUID_G(
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

		if (result instanceof UtenteOrganizzazione) {
			UtenteOrganizzazione utenteOrganizzazione =
				(UtenteOrganizzazione)result;

			if (!Objects.equals(uuid, utenteOrganizzazione.getUuid()) ||
				(groupId != utenteOrganizzazione.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

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

				List<UtenteOrganizzazione> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					UtenteOrganizzazione utenteOrganizzazione = list.get(0);

					result = utenteOrganizzazione;

					cacheResult(utenteOrganizzazione);
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
			return (UtenteOrganizzazione)result;
		}
	}

	/**
	 * Removes the utente organizzazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the utente organizzazione that was removed
	 */
	@Override
	public UtenteOrganizzazione removeByUUID_G(String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = findByUUID_G(uuid, groupId);

		return remove(utenteOrganizzazione);
	}

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching utente organizzaziones
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE);

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
		"utenteOrganizzazione.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(utenteOrganizzazione.uuid IS NULL OR utenteOrganizzazione.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"utenteOrganizzazione.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		List<UtenteOrganizzazione> list = null;

		if (useFinderCache) {
			list = (List<UtenteOrganizzazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazione utenteOrganizzazione : list) {
					if (!uuid.equals(utenteOrganizzazione.getUuid()) ||
						(companyId != utenteOrganizzazione.getCompanyId())) {

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

			sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

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
				sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
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

				list = (List<UtenteOrganizzazione>)QueryUtil.list(
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
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		List<UtenteOrganizzazione> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazione> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione[] findByUuid_C_PrevAndNext(
			UtenteOrganizzazionePK utenteOrganizzazionePK, String uuid,
			long companyId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		uuid = Objects.toString(uuid, "");

		UtenteOrganizzazione utenteOrganizzazione = findByPrimaryKey(
			utenteOrganizzazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazione[] array = new UtenteOrganizzazioneImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, utenteOrganizzazione, uuid, companyId,
				orderByComparator, true);

			array[1] = utenteOrganizzazione;

			array[2] = getByUuid_C_PrevAndNext(
				session, utenteOrganizzazione, uuid, companyId,
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

	protected UtenteOrganizzazione getByUuid_C_PrevAndNext(
		Session session, UtenteOrganizzazione utenteOrganizzazione, String uuid,
		long companyId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

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
			sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UtenteOrganizzazione utenteOrganizzazione :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(utenteOrganizzazione);
		}
	}

	/**
	 * Returns the number of utente organizzaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching utente organizzaziones
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE);

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
		"utenteOrganizzazione.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(utenteOrganizzazione.uuid IS NULL OR utenteOrganizzazione.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"utenteOrganizzazione.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the utente organizzaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId) {

		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		List<UtenteOrganizzazione> list = null;

		if (useFinderCache) {
			list = (List<UtenteOrganizzazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazione utenteOrganizzazione : list) {
					if (organizationId !=
							utenteOrganizzazione.getOrganizationId()) {

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

			sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list = (List<UtenteOrganizzazione>)QueryUtil.list(
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
	 * Returns the first utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByOrganizationId_First(
			long organizationId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByOrganizationId_First(
			organizationId, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		List<UtenteOrganizzazione> list = findByOrganizationId(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByOrganizationId_Last(
			organizationId, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazione> list = findByOrganizationId(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where organizationId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione[] findByOrganizationId_PrevAndNext(
			UtenteOrganizzazionePK utenteOrganizzazionePK, long organizationId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = findByPrimaryKey(
			utenteOrganizzazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazione[] array = new UtenteOrganizzazioneImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, utenteOrganizzazione, organizationId,
				orderByComparator, true);

			array[1] = utenteOrganizzazione;

			array[2] = getByOrganizationId_PrevAndNext(
				session, utenteOrganizzazione, organizationId,
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

	protected UtenteOrganizzazione getByOrganizationId_PrevAndNext(
		Session session, UtenteOrganizzazione utenteOrganizzazione,
		long organizationId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

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
			sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (UtenteOrganizzazione utenteOrganizzazione :
				findByOrganizationId(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(utenteOrganizzazione);
		}
	}

	/**
	 * Returns the number of utente organizzaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzaziones
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE);

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
		"utenteOrganizzazione.id.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByUtenteId;
	private FinderPath _finderPathWithoutPaginationFindByUtenteId;
	private FinderPath _finderPathCountByUtenteId;

	/**
	 * Returns all the utente organizzaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUtenteId(long utenteId) {
		return findByUtenteId(
			utenteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end) {

		return findByUtenteId(utenteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return findByUtenteId(utenteId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUtenteId;
				finderArgs = new Object[] {utenteId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUtenteId;
			finderArgs = new Object[] {utenteId, start, end, orderByComparator};
		}

		List<UtenteOrganizzazione> list = null;

		if (useFinderCache) {
			list = (List<UtenteOrganizzazione>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazione utenteOrganizzazione : list) {
					if (utenteId != utenteOrganizzazione.getUtenteId()) {
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

			sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_UTENTEID_UTENTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(utenteId);

				list = (List<UtenteOrganizzazione>)QueryUtil.list(
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
	 * Returns the first utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUtenteId_First(
			long utenteId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUtenteId_First(
			utenteId, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("utenteId=");
		sb.append(utenteId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the first utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUtenteId_First(
		long utenteId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		List<UtenteOrganizzazione> list = findByUtenteId(
			utenteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByUtenteId_Last(
			long utenteId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByUtenteId_Last(
			utenteId, orderByComparator);

		if (utenteOrganizzazione != null) {
			return utenteOrganizzazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("utenteId=");
		sb.append(utenteId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneException(sb.toString());
	}

	/**
	 * Returns the last utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByUtenteId_Last(
		long utenteId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		int count = countByUtenteId(utenteId);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazione> list = findByUtenteId(
			utenteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzaziones before and after the current utente organizzazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteOrganizzazionePK the primary key of the current utente organizzazione
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione[] findByUtenteId_PrevAndNext(
			UtenteOrganizzazionePK utenteOrganizzazionePK, long utenteId,
			OrderByComparator<UtenteOrganizzazione> orderByComparator)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = findByPrimaryKey(
			utenteOrganizzazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazione[] array = new UtenteOrganizzazioneImpl[3];

			array[0] = getByUtenteId_PrevAndNext(
				session, utenteOrganizzazione, utenteId, orderByComparator,
				true);

			array[1] = utenteOrganizzazione;

			array[2] = getByUtenteId_PrevAndNext(
				session, utenteOrganizzazione, utenteId, orderByComparator,
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

	protected UtenteOrganizzazione getByUtenteId_PrevAndNext(
		Session session, UtenteOrganizzazione utenteOrganizzazione,
		long utenteId,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

		sb.append(_FINDER_COLUMN_UTENTEID_UTENTEID_2);

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
			sb.append(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(utenteId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						utenteOrganizzazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzaziones where utenteId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 */
	@Override
	public void removeByUtenteId(long utenteId) {
		for (UtenteOrganizzazione utenteOrganizzazione :
				findByUtenteId(
					utenteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(utenteOrganizzazione);
		}
	}

	/**
	 * Returns the number of utente organizzaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the number of matching utente organizzaziones
	 */
	@Override
	public int countByUtenteId(long utenteId) {
		FinderPath finderPath = _finderPathCountByUtenteId;

		Object[] finderArgs = new Object[] {utenteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_UTENTEID_UTENTEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(utenteId);

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

	private static final String _FINDER_COLUMN_UTENTEID_UTENTEID_2 =
		"utenteOrganizzazione.id.utenteId = ?";

	private FinderPath _finderPathFetchByO_U_P;
	private FinderPath _finderPathCountByO_U_P;

	/**
	 * Returns the utente organizzazione where organizationId = &#63; and utenteId = &#63; and preferito = &#63; or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @param utenteId the utente ID
	 * @param preferito the preferito
	 * @return the matching utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione findByO_U_P(
			long organizationId, long utenteId, boolean preferito)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByO_U_P(
			organizationId, utenteId, preferito);

		if (utenteOrganizzazione == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("organizationId=");
			sb.append(organizationId);

			sb.append(", utenteId=");
			sb.append(utenteId);

			sb.append(", preferito=");
			sb.append(preferito);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUtenteOrganizzazioneException(sb.toString());
		}

		return utenteOrganizzazione;
	}

	/**
	 * Returns the utente organizzazione where organizationId = &#63; and utenteId = &#63; and preferito = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param utenteId the utente ID
	 * @param preferito the preferito
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByO_U_P(
		long organizationId, long utenteId, boolean preferito) {

		return fetchByO_U_P(organizationId, utenteId, preferito, true);
	}

	/**
	 * Returns the utente organizzazione where organizationId = &#63; and utenteId = &#63; and preferito = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param utenteId the utente ID
	 * @param preferito the preferito
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione, or <code>null</code> if a matching utente organizzazione could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByO_U_P(
		long organizationId, long utenteId, boolean preferito,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {organizationId, utenteId, preferito};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByO_U_P, finderArgs);
		}

		if (result instanceof UtenteOrganizzazione) {
			UtenteOrganizzazione utenteOrganizzazione =
				(UtenteOrganizzazione)result;

			if ((organizationId != utenteOrganizzazione.getOrganizationId()) ||
				(utenteId != utenteOrganizzazione.getUtenteId()) ||
				(preferito != utenteOrganizzazione.isPreferito())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_O_U_P_ORGANIZATIONID_2);

			sb.append(_FINDER_COLUMN_O_U_P_UTENTEID_2);

			sb.append(_FINDER_COLUMN_O_U_P_PREFERITO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				queryPos.add(utenteId);

				queryPos.add(preferito);

				List<UtenteOrganizzazione> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByO_U_P, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									organizationId, utenteId, preferito
								};
							}

							_log.warn(
								"UtenteOrganizzazionePersistenceImpl.fetchByO_U_P(long, long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UtenteOrganizzazione utenteOrganizzazione = list.get(0);

					result = utenteOrganizzazione;

					cacheResult(utenteOrganizzazione);
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
			return (UtenteOrganizzazione)result;
		}
	}

	/**
	 * Removes the utente organizzazione where organizationId = &#63; and utenteId = &#63; and preferito = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param utenteId the utente ID
	 * @param preferito the preferito
	 * @return the utente organizzazione that was removed
	 */
	@Override
	public UtenteOrganizzazione removeByO_U_P(
			long organizationId, long utenteId, boolean preferito)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = findByO_U_P(
			organizationId, utenteId, preferito);

		return remove(utenteOrganizzazione);
	}

	/**
	 * Returns the number of utente organizzaziones where organizationId = &#63; and utenteId = &#63; and preferito = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param utenteId the utente ID
	 * @param preferito the preferito
	 * @return the number of matching utente organizzaziones
	 */
	@Override
	public int countByO_U_P(
		long organizationId, long utenteId, boolean preferito) {

		FinderPath finderPath = _finderPathCountByO_U_P;

		Object[] finderArgs = new Object[] {
			organizationId, utenteId, preferito
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_O_U_P_ORGANIZATIONID_2);

			sb.append(_FINDER_COLUMN_O_U_P_UTENTEID_2);

			sb.append(_FINDER_COLUMN_O_U_P_PREFERITO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				queryPos.add(utenteId);

				queryPos.add(preferito);

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

	private static final String _FINDER_COLUMN_O_U_P_ORGANIZATIONID_2 =
		"utenteOrganizzazione.id.organizationId = ? AND ";

	private static final String _FINDER_COLUMN_O_U_P_UTENTEID_2 =
		"utenteOrganizzazione.id.utenteId = ? AND ";

	private static final String _FINDER_COLUMN_O_U_P_PREFERITO_2 =
		"utenteOrganizzazione.preferito = ?";

	public UtenteOrganizzazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UtenteOrganizzazione.class);

		setModelImplClass(UtenteOrganizzazioneImpl.class);
		setModelPKClass(UtenteOrganizzazionePK.class);

		setTable(UtenteOrganizzazioneTable.INSTANCE);
	}

	/**
	 * Caches the utente organizzazione in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazione the utente organizzazione
	 */
	@Override
	public void cacheResult(UtenteOrganizzazione utenteOrganizzazione) {
		entityCache.putResult(
			UtenteOrganizzazioneImpl.class,
			utenteOrganizzazione.getPrimaryKey(), utenteOrganizzazione);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				utenteOrganizzazione.getUuid(),
				utenteOrganizzazione.getGroupId()
			},
			utenteOrganizzazione);

		finderCache.putResult(
			_finderPathFetchByO_U_P,
			new Object[] {
				utenteOrganizzazione.getOrganizationId(),
				utenteOrganizzazione.getUtenteId(),
				utenteOrganizzazione.isPreferito()
			},
			utenteOrganizzazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the utente organizzaziones in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzaziones the utente organizzaziones
	 */
	@Override
	public void cacheResult(List<UtenteOrganizzazione> utenteOrganizzaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (utenteOrganizzaziones.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UtenteOrganizzazione utenteOrganizzazione :
				utenteOrganizzaziones) {

			if (entityCache.getResult(
					UtenteOrganizzazioneImpl.class,
					utenteOrganizzazione.getPrimaryKey()) == null) {

				cacheResult(utenteOrganizzazione);
			}
		}
	}

	/**
	 * Clears the cache for all utente organizzaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UtenteOrganizzazioneImpl.class);

		finderCache.clearCache(UtenteOrganizzazioneImpl.class);
	}

	/**
	 * Clears the cache for the utente organizzazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UtenteOrganizzazione utenteOrganizzazione) {
		entityCache.removeResult(
			UtenteOrganizzazioneImpl.class, utenteOrganizzazione);
	}

	@Override
	public void clearCache(List<UtenteOrganizzazione> utenteOrganizzaziones) {
		for (UtenteOrganizzazione utenteOrganizzazione :
				utenteOrganizzaziones) {

			entityCache.removeResult(
				UtenteOrganizzazioneImpl.class, utenteOrganizzazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UtenteOrganizzazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UtenteOrganizzazioneImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UtenteOrganizzazioneModelImpl utenteOrganizzazioneModelImpl) {

		Object[] args = new Object[] {
			utenteOrganizzazioneModelImpl.getUuid(),
			utenteOrganizzazioneModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, utenteOrganizzazioneModelImpl);

		args = new Object[] {
			utenteOrganizzazioneModelImpl.getOrganizationId(),
			utenteOrganizzazioneModelImpl.getUtenteId(),
			utenteOrganizzazioneModelImpl.isPreferito()
		};

		finderCache.putResult(_finderPathCountByO_U_P, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByO_U_P, args, utenteOrganizzazioneModelImpl);
	}

	/**
	 * Creates a new utente organizzazione with the primary key. Does not add the utente organizzazione to the database.
	 *
	 * @param utenteOrganizzazionePK the primary key for the new utente organizzazione
	 * @return the new utente organizzazione
	 */
	@Override
	public UtenteOrganizzazione create(
		UtenteOrganizzazionePK utenteOrganizzazionePK) {

		UtenteOrganizzazione utenteOrganizzazione =
			new UtenteOrganizzazioneImpl();

		utenteOrganizzazione.setNew(true);
		utenteOrganizzazione.setPrimaryKey(utenteOrganizzazionePK);

		String uuid = PortalUUIDUtil.generate();

		utenteOrganizzazione.setUuid(uuid);

		utenteOrganizzazione.setCompanyId(CompanyThreadLocal.getCompanyId());

		return utenteOrganizzazione;
	}

	/**
	 * Removes the utente organizzazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione remove(
			UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws NoSuchUtenteOrganizzazioneException {

		return remove((Serializable)utenteOrganizzazionePK);
	}

	/**
	 * Removes the utente organizzazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the utente organizzazione
	 * @return the utente organizzazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione remove(Serializable primaryKey)
		throws NoSuchUtenteOrganizzazioneException {

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazione utenteOrganizzazione =
				(UtenteOrganizzazione)session.get(
					UtenteOrganizzazioneImpl.class, primaryKey);

			if (utenteOrganizzazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUtenteOrganizzazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(utenteOrganizzazione);
		}
		catch (NoSuchUtenteOrganizzazioneException noSuchEntityException) {
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
	protected UtenteOrganizzazione removeImpl(
		UtenteOrganizzazione utenteOrganizzazione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(utenteOrganizzazione)) {
				utenteOrganizzazione = (UtenteOrganizzazione)session.get(
					UtenteOrganizzazioneImpl.class,
					utenteOrganizzazione.getPrimaryKeyObj());
			}

			if (utenteOrganizzazione != null) {
				session.delete(utenteOrganizzazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (utenteOrganizzazione != null) {
			clearCache(utenteOrganizzazione);
		}

		return utenteOrganizzazione;
	}

	@Override
	public UtenteOrganizzazione updateImpl(
		UtenteOrganizzazione utenteOrganizzazione) {

		boolean isNew = utenteOrganizzazione.isNew();

		if (!(utenteOrganizzazione instanceof UtenteOrganizzazioneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(utenteOrganizzazione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					utenteOrganizzazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in utenteOrganizzazione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UtenteOrganizzazione implementation " +
					utenteOrganizzazione.getClass());
		}

		UtenteOrganizzazioneModelImpl utenteOrganizzazioneModelImpl =
			(UtenteOrganizzazioneModelImpl)utenteOrganizzazione;

		if (Validator.isNull(utenteOrganizzazione.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			utenteOrganizzazione.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (utenteOrganizzazione.getCreateDate() == null)) {
			if (serviceContext == null) {
				utenteOrganizzazione.setCreateDate(date);
			}
			else {
				utenteOrganizzazione.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!utenteOrganizzazioneModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				utenteOrganizzazione.setModifiedDate(date);
			}
			else {
				utenteOrganizzazione.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(utenteOrganizzazione);
			}
			else {
				utenteOrganizzazione = (UtenteOrganizzazione)session.merge(
					utenteOrganizzazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UtenteOrganizzazioneImpl.class, utenteOrganizzazioneModelImpl,
			false, true);

		cacheUniqueFindersCache(utenteOrganizzazioneModelImpl);

		if (isNew) {
			utenteOrganizzazione.setNew(false);
		}

		utenteOrganizzazione.resetOriginalValues();

		return utenteOrganizzazione;
	}

	/**
	 * Returns the utente organizzazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUtenteOrganizzazioneException {

		UtenteOrganizzazione utenteOrganizzazione = fetchByPrimaryKey(
			primaryKey);

		if (utenteOrganizzazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUtenteOrganizzazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return utenteOrganizzazione;
	}

	/**
	 * Returns the utente organizzazione with the primary key or throws a <code>NoSuchUtenteOrganizzazioneException</code> if it could not be found.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione
	 * @throws NoSuchUtenteOrganizzazioneException if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione findByPrimaryKey(
			UtenteOrganizzazionePK utenteOrganizzazionePK)
		throws NoSuchUtenteOrganizzazioneException {

		return findByPrimaryKey((Serializable)utenteOrganizzazionePK);
	}

	/**
	 * Returns the utente organizzazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utenteOrganizzazionePK the primary key of the utente organizzazione
	 * @return the utente organizzazione, or <code>null</code> if a utente organizzazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazione fetchByPrimaryKey(
		UtenteOrganizzazionePK utenteOrganizzazionePK) {

		return fetchByPrimaryKey((Serializable)utenteOrganizzazionePK);
	}

	/**
	 * Returns all the utente organizzaziones.
	 *
	 * @return the utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @return the range of utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzaziones
	 * @param end the upper bound of the range of utente organizzaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente organizzaziones
	 */
	@Override
	public List<UtenteOrganizzazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazione> orderByComparator,
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

		List<UtenteOrganizzazione> list = null;

		if (useFinderCache) {
			list = (List<UtenteOrganizzazione>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_UTENTEORGANIZZAZIONE;

				sql = sql.concat(UtenteOrganizzazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UtenteOrganizzazione>)QueryUtil.list(
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
	 * Removes all the utente organizzaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UtenteOrganizzazione utenteOrganizzazione : findAll()) {
			remove(utenteOrganizzazione);
		}
	}

	/**
	 * Returns the number of utente organizzaziones.
	 *
	 * @return the number of utente organizzaziones
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
					_SQL_COUNT_UTENTEORGANIZZAZIONE);

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
		return "utenteOrganizzazionePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_UTENTEORGANIZZAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UtenteOrganizzazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the utente organizzazione persistence.
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

		_finderPathWithPaginationFindByUtenteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUtenteId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"utenteId"}, true);

		_finderPathWithoutPaginationFindByUtenteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUtenteId",
			new String[] {Long.class.getName()}, new String[] {"utenteId"},
			true);

		_finderPathCountByUtenteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUtenteId",
			new String[] {Long.class.getName()}, new String[] {"utenteId"},
			false);

		_finderPathFetchByO_U_P = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByO_U_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"organizationId", "utenteId", "preferito"}, true);

		_finderPathCountByO_U_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByO_U_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"organizationId", "utenteId", "preferito"}, false);

		_setUtenteOrganizzazioneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUtenteOrganizzazioneUtilPersistence(null);

		entityCache.removeCache(UtenteOrganizzazioneImpl.class.getName());
	}

	private void _setUtenteOrganizzazioneUtilPersistence(
		UtenteOrganizzazionePersistence utenteOrganizzazionePersistence) {

		try {
			Field field = UtenteOrganizzazioneUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, utenteOrganizzazionePersistence);
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

	private static final String _SQL_SELECT_UTENTEORGANIZZAZIONE =
		"SELECT utenteOrganizzazione FROM UtenteOrganizzazione utenteOrganizzazione";

	private static final String _SQL_SELECT_UTENTEORGANIZZAZIONE_WHERE =
		"SELECT utenteOrganizzazione FROM UtenteOrganizzazione utenteOrganizzazione WHERE ";

	private static final String _SQL_COUNT_UTENTEORGANIZZAZIONE =
		"SELECT COUNT(utenteOrganizzazione) FROM UtenteOrganizzazione utenteOrganizzazione";

	private static final String _SQL_COUNT_UTENTEORGANIZZAZIONE_WHERE =
		"SELECT COUNT(utenteOrganizzazione) FROM UtenteOrganizzazione utenteOrganizzazione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"utenteOrganizzazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UtenteOrganizzazione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UtenteOrganizzazione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UtenteOrganizzazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"utenteId", "organizationId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private UtenteOrganizzazioneModelArgumentsResolver
		_utenteOrganizzazioneModelArgumentsResolver;

}