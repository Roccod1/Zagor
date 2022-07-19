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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.servizidigitali.profiloutente.exception.NoSuchUtenteOrganizzazioneCanaleComunicazioneException;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazioneTable;
import it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneImpl;
import it.servizidigitali.profiloutente.model.impl.UtenteOrganizzazioneCanaleComunicazioneModelImpl;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneCanaleComunicazionePK;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneCanaleComunicazionePersistence;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazioneCanaleComunicazioneUtil;
import it.servizidigitali.profiloutente.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the utente organizzazione canale comunicazione service.
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
		UtenteOrganizzazioneCanaleComunicazionePersistence.class,
		BasePersistence.class
	}
)
public class UtenteOrganizzazioneCanaleComunicazionePersistenceImpl
	extends BasePersistenceImpl<UtenteOrganizzazioneCanaleComunicazione>
	implements UtenteOrganizzazioneCanaleComunicazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UtenteOrganizzazioneCanaleComunicazioneUtil</code> to access the utente organizzazione canale comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UtenteOrganizzazioneCanaleComunicazioneImpl.class.getName();

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
	 * Returns all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid) {

		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		List<UtenteOrganizzazioneCanaleComunicazione> list = null;

		if (useFinderCache) {
			list =
				(List<UtenteOrganizzazioneCanaleComunicazione>)
					finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione : list) {

					if (!uuid.equals(
							utenteOrganizzazioneCanaleComunicazione.
								getUuid())) {

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

			sb.append(
				_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
				sb.append(
					UtenteOrganizzazioneCanaleComunicazioneModelImpl.
						ORDER_BY_JPQL);
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

				list =
					(List<UtenteOrganizzazioneCanaleComunicazione>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_First(
			String uuid,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUuid_First(
				uuid, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_First(
		String uuid,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		List<UtenteOrganizzazioneCanaleComunicazione> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_Last(
			String uuid,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUuid_Last(
				uuid, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_Last(
		String uuid,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where uuid = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione[] findByUuid_PrevAndNext(
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK,
			String uuid,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		uuid = Objects.toString(uuid, "");

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = findByPrimaryKey(
				utenteOrganizzazioneCanaleComunicazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazioneCanaleComunicazione[] array =
				new UtenteOrganizzazioneCanaleComunicazioneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione, uuid,
				orderByComparator, true);

			array[1] = utenteOrganizzazioneCanaleComunicazione;

			array[2] = getByUuid_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione, uuid,
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

	protected UtenteOrganizzazioneCanaleComunicazione getByUuid_PrevAndNext(
		Session session,
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione,
		String uuid,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
			sb.append(
				UtenteOrganizzazioneCanaleComunicazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazioneCanaleComunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(utenteOrganizzazioneCanaleComunicazione);
		}
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
		"utenteOrganizzazioneCanaleComunicazione.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(utenteOrganizzazioneCanaleComunicazione.uuid IS NULL OR utenteOrganizzazioneCanaleComunicazione.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUtenteOrganizzazioneCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUUID_G(
			String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUUID_G(
				uuid, groupId);

		if (utenteOrganizzazioneCanaleComunicazione == null) {
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

			throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
				sb.toString());
		}

		return utenteOrganizzazioneCanaleComunicazione;
	}

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUUID_G(
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

		if (result instanceof UtenteOrganizzazioneCanaleComunicazione) {
			UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione =
					(UtenteOrganizzazioneCanaleComunicazione)result;

			if (!Objects.equals(
					uuid, utenteOrganizzazioneCanaleComunicazione.getUuid()) ||
				(groupId !=
					utenteOrganizzazioneCanaleComunicazione.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(
				_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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

				List<UtenteOrganizzazioneCanaleComunicazione> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione = list.get(0);

					result = utenteOrganizzazioneCanaleComunicazione;

					cacheResult(utenteOrganizzazioneCanaleComunicazione);
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
			return (UtenteOrganizzazioneCanaleComunicazione)result;
		}
	}

	/**
	 * Removes the utente organizzazione canale comunicazione where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the utente organizzazione canale comunicazione that was removed
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = findByUUID_G(
				uuid, groupId);

		return remove(utenteOrganizzazioneCanaleComunicazione);
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
		"utenteOrganizzazioneCanaleComunicazione.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(utenteOrganizzazioneCanaleComunicazione.uuid IS NULL OR utenteOrganizzazioneCanaleComunicazione.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"utenteOrganizzazioneCanaleComunicazione.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		List<UtenteOrganizzazioneCanaleComunicazione> list = null;

		if (useFinderCache) {
			list =
				(List<UtenteOrganizzazioneCanaleComunicazione>)
					finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione : list) {

					if (!uuid.equals(
							utenteOrganizzazioneCanaleComunicazione.
								getUuid()) ||
						(companyId !=
							utenteOrganizzazioneCanaleComunicazione.
								getCompanyId())) {

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

			sb.append(
				_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
				sb.append(
					UtenteOrganizzazioneCanaleComunicazioneModelImpl.
						ORDER_BY_JPQL);
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

				list =
					(List<UtenteOrganizzazioneCanaleComunicazione>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		List<UtenteOrganizzazioneCanaleComunicazione> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione[] findByUuid_C_PrevAndNext(
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK,
			String uuid, long companyId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		uuid = Objects.toString(uuid, "");

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = findByPrimaryKey(
				utenteOrganizzazioneCanaleComunicazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazioneCanaleComunicazione[] array =
				new UtenteOrganizzazioneCanaleComunicazioneImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione, uuid,
				companyId, orderByComparator, true);

			array[1] = utenteOrganizzazioneCanaleComunicazione;

			array[2] = getByUuid_C_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione, uuid,
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

	protected UtenteOrganizzazioneCanaleComunicazione getByUuid_C_PrevAndNext(
		Session session,
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione,
		String uuid, long companyId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
			sb.append(
				UtenteOrganizzazioneCanaleComunicazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazioneCanaleComunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(utenteOrganizzazioneCanaleComunicazione);
		}
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
		"utenteOrganizzazioneCanaleComunicazione.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(utenteOrganizzazioneCanaleComunicazione.uuid IS NULL OR utenteOrganizzazioneCanaleComunicazione.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"utenteOrganizzazioneCanaleComunicazione.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganizationId;
	private FinderPath _finderPathWithoutPaginationFindByOrganizationId;
	private FinderPath _finderPathCountByOrganizationId;

	/**
	 * Returns all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByOrganizationId(
		long organizationId) {

		return findByOrganizationId(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByOrganizationId(
		long organizationId, int start, int end) {

		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return findByOrganizationId(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		List<UtenteOrganizzazioneCanaleComunicazione> list = null;

		if (useFinderCache) {
			list =
				(List<UtenteOrganizzazioneCanaleComunicazione>)
					finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione : list) {

					if (organizationId !=
							utenteOrganizzazioneCanaleComunicazione.
								getOrganizationId()) {

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

			sb.append(
				_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					UtenteOrganizzazioneCanaleComunicazioneModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(organizationId);

				list =
					(List<UtenteOrganizzazioneCanaleComunicazione>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByOrganizationId_First(
			long organizationId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione =
				fetchByOrganizationId_First(organizationId, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		List<UtenteOrganizzazioneCanaleComunicazione> list =
			findByOrganizationId(organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione =
				fetchByOrganizationId_Last(organizationId, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("organizationId=");
		sb.append(organizationId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list =
			findByOrganizationId(
				organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where organizationId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione[]
			findByOrganizationId_PrevAndNext(
				UtenteOrganizzazioneCanaleComunicazionePK
					utenteOrganizzazioneCanaleComunicazionePK,
				long organizationId,
				OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
					orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = findByPrimaryKey(
				utenteOrganizzazioneCanaleComunicazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazioneCanaleComunicazione[] array =
				new UtenteOrganizzazioneCanaleComunicazioneImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione,
				organizationId, orderByComparator, true);

			array[1] = utenteOrganizzazioneCanaleComunicazione;

			array[2] = getByOrganizationId_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione,
				organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UtenteOrganizzazioneCanaleComunicazione
		getByOrganizationId_PrevAndNext(
			Session session,
			UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione,
			long organizationId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
			sb.append(
				UtenteOrganizzazioneCanaleComunicazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazioneCanaleComunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByOrganizationId(long organizationId) {
		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione :
					findByOrganizationId(
						organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(utenteOrganizzazioneCanaleComunicazione);
		}
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public int countByOrganizationId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrganizationId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
		"utenteOrganizzazioneCanaleComunicazione.id.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByUtenteId;
	private FinderPath _finderPathWithoutPaginationFindByUtenteId;
	private FinderPath _finderPathCountByUtenteId;

	/**
	 * Returns all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId) {

		return findByUtenteId(
			utenteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId, int start, int end) {

		return findByUtenteId(utenteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return findByUtenteId(utenteId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param utenteId the utente ID
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findByUtenteId(
		long utenteId, int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		List<UtenteOrganizzazioneCanaleComunicazione> list = null;

		if (useFinderCache) {
			list =
				(List<UtenteOrganizzazioneCanaleComunicazione>)
					finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UtenteOrganizzazioneCanaleComunicazione
						utenteOrganizzazioneCanaleComunicazione : list) {

					if (utenteId !=
							utenteOrganizzazioneCanaleComunicazione.
								getUtenteId()) {

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

			sb.append(
				_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

			sb.append(_FINDER_COLUMN_UTENTEID_UTENTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					UtenteOrganizzazioneCanaleComunicazioneModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(utenteId);

				list =
					(List<UtenteOrganizzazioneCanaleComunicazione>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUtenteId_First(
			long utenteId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUtenteId_First(
				utenteId, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("utenteId=");
		sb.append(utenteId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the first utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUtenteId_First(
		long utenteId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		List<UtenteOrganizzazioneCanaleComunicazione> list = findByUtenteId(
			utenteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByUtenteId_Last(
			long utenteId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByUtenteId_Last(
				utenteId, orderByComparator);

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			return utenteOrganizzazioneCanaleComunicazione;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("utenteId=");
		sb.append(utenteId);

		sb.append("}");

		throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
			sb.toString());
	}

	/**
	 * Returns the last utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente organizzazione canale comunicazione, or <code>null</code> if a matching utente organizzazione canale comunicazione could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByUtenteId_Last(
		long utenteId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		int count = countByUtenteId(utenteId);

		if (count == 0) {
			return null;
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = findByUtenteId(
			utenteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the utente organizzazione canale comunicaziones before and after the current utente organizzazione canale comunicazione in the ordered set where utenteId = &#63;.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the current utente organizzazione canale comunicazione
	 * @param utenteId the utente ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione[] findByUtenteId_PrevAndNext(
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK,
			long utenteId,
			OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
				orderByComparator)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = findByPrimaryKey(
				utenteOrganizzazioneCanaleComunicazionePK);

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazioneCanaleComunicazione[] array =
				new UtenteOrganizzazioneCanaleComunicazioneImpl[3];

			array[0] = getByUtenteId_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione, utenteId,
				orderByComparator, true);

			array[1] = utenteOrganizzazioneCanaleComunicazione;

			array[2] = getByUtenteId_PrevAndNext(
				session, utenteOrganizzazioneCanaleComunicazione, utenteId,
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

	protected UtenteOrganizzazioneCanaleComunicazione getByUtenteId_PrevAndNext(
		Session session,
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione,
		long utenteId,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
			sb.append(
				UtenteOrganizzazioneCanaleComunicazioneModelImpl.ORDER_BY_JPQL);
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
						utenteOrganizzazioneCanaleComunicazione)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UtenteOrganizzazioneCanaleComunicazione> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the utente organizzazione canale comunicaziones where utenteId = &#63; from the database.
	 *
	 * @param utenteId the utente ID
	 */
	@Override
	public void removeByUtenteId(long utenteId) {
		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione :
					findByUtenteId(
						utenteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(utenteOrganizzazioneCanaleComunicazione);
		}
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones where utenteId = &#63;.
	 *
	 * @param utenteId the utente ID
	 * @return the number of matching utente organizzazione canale comunicaziones
	 */
	@Override
	public int countByUtenteId(long utenteId) {
		FinderPath finderPath = _finderPathCountByUtenteId;

		Object[] finderArgs = new Object[] {utenteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE);

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
		"utenteOrganizzazioneCanaleComunicazione.id.utenteId = ?";

	public UtenteOrganizzazioneCanaleComunicazionePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UtenteOrganizzazioneCanaleComunicazione.class);

		setModelImplClass(UtenteOrganizzazioneCanaleComunicazioneImpl.class);
		setModelPKClass(UtenteOrganizzazioneCanaleComunicazionePK.class);

		setTable(UtenteOrganizzazioneCanaleComunicazioneTable.INSTANCE);
	}

	/**
	 * Caches the utente organizzazione canale comunicazione in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazione the utente organizzazione canale comunicazione
	 */
	@Override
	public void cacheResult(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		entityCache.putResult(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class,
			utenteOrganizzazioneCanaleComunicazione.getPrimaryKey(),
			utenteOrganizzazioneCanaleComunicazione);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				utenteOrganizzazioneCanaleComunicazione.getUuid(),
				utenteOrganizzazioneCanaleComunicazione.getGroupId()
			},
			utenteOrganizzazioneCanaleComunicazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the utente organizzazione canale comunicaziones in the entity cache if it is enabled.
	 *
	 * @param utenteOrganizzazioneCanaleComunicaziones the utente organizzazione canale comunicaziones
	 */
	@Override
	public void cacheResult(
		List<UtenteOrganizzazioneCanaleComunicazione>
			utenteOrganizzazioneCanaleComunicaziones) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (utenteOrganizzazioneCanaleComunicaziones.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione :
					utenteOrganizzazioneCanaleComunicaziones) {

			if (entityCache.getResult(
					UtenteOrganizzazioneCanaleComunicazioneImpl.class,
					utenteOrganizzazioneCanaleComunicazione.getPrimaryKey()) ==
						null) {

				cacheResult(utenteOrganizzazioneCanaleComunicazione);
			}
		}
	}

	/**
	 * Clears the cache for all utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class);

		finderCache.clearCache(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class);
	}

	/**
	 * Clears the cache for the utente organizzazione canale comunicazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		entityCache.removeResult(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class,
			utenteOrganizzazioneCanaleComunicazione);
	}

	@Override
	public void clearCache(
		List<UtenteOrganizzazioneCanaleComunicazione>
			utenteOrganizzazioneCanaleComunicaziones) {

		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione :
					utenteOrganizzazioneCanaleComunicaziones) {

			entityCache.removeResult(
				UtenteOrganizzazioneCanaleComunicazioneImpl.class,
				utenteOrganizzazioneCanaleComunicazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UtenteOrganizzazioneCanaleComunicazioneImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UtenteOrganizzazioneCanaleComunicazioneModelImpl
			utenteOrganizzazioneCanaleComunicazioneModelImpl) {

		Object[] args = new Object[] {
			utenteOrganizzazioneCanaleComunicazioneModelImpl.getUuid(),
			utenteOrganizzazioneCanaleComunicazioneModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			utenteOrganizzazioneCanaleComunicazioneModelImpl);
	}

	/**
	 * Creates a new utente organizzazione canale comunicazione with the primary key. Does not add the utente organizzazione canale comunicazione to the database.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key for the new utente organizzazione canale comunicazione
	 * @return the new utente organizzazione canale comunicazione
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione create(
		UtenteOrganizzazioneCanaleComunicazionePK
			utenteOrganizzazioneCanaleComunicazionePK) {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione =
				new UtenteOrganizzazioneCanaleComunicazioneImpl();

		utenteOrganizzazioneCanaleComunicazione.setNew(true);
		utenteOrganizzazioneCanaleComunicazione.setPrimaryKey(
			utenteOrganizzazioneCanaleComunicazionePK);

		String uuid = PortalUUIDUtil.generate();

		utenteOrganizzazioneCanaleComunicazione.setUuid(uuid);

		utenteOrganizzazioneCanaleComunicazione.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return utenteOrganizzazioneCanaleComunicazione;
	}

	/**
	 * Removes the utente organizzazione canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione remove(
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return remove((Serializable)utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Removes the utente organizzazione canale comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione that was removed
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione remove(
			Serializable primaryKey)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		Session session = null;

		try {
			session = openSession();

			UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione =
					(UtenteOrganizzazioneCanaleComunicazione)session.get(
						UtenteOrganizzazioneCanaleComunicazioneImpl.class,
						primaryKey);

			if (utenteOrganizzazioneCanaleComunicazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(utenteOrganizzazioneCanaleComunicazione);
		}
		catch (NoSuchUtenteOrganizzazioneCanaleComunicazioneException
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
	protected UtenteOrganizzazioneCanaleComunicazione removeImpl(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(utenteOrganizzazioneCanaleComunicazione)) {
				utenteOrganizzazioneCanaleComunicazione =
					(UtenteOrganizzazioneCanaleComunicazione)session.get(
						UtenteOrganizzazioneCanaleComunicazioneImpl.class,
						utenteOrganizzazioneCanaleComunicazione.
							getPrimaryKeyObj());
			}

			if (utenteOrganizzazioneCanaleComunicazione != null) {
				session.delete(utenteOrganizzazioneCanaleComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (utenteOrganizzazioneCanaleComunicazione != null) {
			clearCache(utenteOrganizzazioneCanaleComunicazione);
		}

		return utenteOrganizzazioneCanaleComunicazione;
	}

	@Override
	public UtenteOrganizzazioneCanaleComunicazione updateImpl(
		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione) {

		boolean isNew = utenteOrganizzazioneCanaleComunicazione.isNew();

		if (!(utenteOrganizzazioneCanaleComunicazione instanceof
				UtenteOrganizzazioneCanaleComunicazioneModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					utenteOrganizzazioneCanaleComunicazione.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					utenteOrganizzazioneCanaleComunicazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in utenteOrganizzazioneCanaleComunicazione proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UtenteOrganizzazioneCanaleComunicazione implementation " +
					utenteOrganizzazioneCanaleComunicazione.getClass());
		}

		UtenteOrganizzazioneCanaleComunicazioneModelImpl
			utenteOrganizzazioneCanaleComunicazioneModelImpl =
				(UtenteOrganizzazioneCanaleComunicazioneModelImpl)
					utenteOrganizzazioneCanaleComunicazione;

		if (Validator.isNull(
				utenteOrganizzazioneCanaleComunicazione.getUuid())) {

			String uuid = PortalUUIDUtil.generate();

			utenteOrganizzazioneCanaleComunicazione.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(utenteOrganizzazioneCanaleComunicazione.getCreateDate() == null)) {

			if (serviceContext == null) {
				utenteOrganizzazioneCanaleComunicazione.setCreateDate(date);
			}
			else {
				utenteOrganizzazioneCanaleComunicazione.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!utenteOrganizzazioneCanaleComunicazioneModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				utenteOrganizzazioneCanaleComunicazione.setModifiedDate(date);
			}
			else {
				utenteOrganizzazioneCanaleComunicazione.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(utenteOrganizzazioneCanaleComunicazione);
			}
			else {
				utenteOrganizzazioneCanaleComunicazione =
					(UtenteOrganizzazioneCanaleComunicazione)session.merge(
						utenteOrganizzazioneCanaleComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class,
			utenteOrganizzazioneCanaleComunicazioneModelImpl, false, true);

		cacheUniqueFindersCache(
			utenteOrganizzazioneCanaleComunicazioneModelImpl);

		if (isNew) {
			utenteOrganizzazioneCanaleComunicazione.setNew(false);
		}

		utenteOrganizzazioneCanaleComunicazione.resetOriginalValues();

		return utenteOrganizzazioneCanaleComunicazione;
	}

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		UtenteOrganizzazioneCanaleComunicazione
			utenteOrganizzazioneCanaleComunicazione = fetchByPrimaryKey(
				primaryKey);

		if (utenteOrganizzazioneCanaleComunicazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUtenteOrganizzazioneCanaleComunicazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return utenteOrganizzazioneCanaleComunicazione;
	}

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or throws a <code>NoSuchUtenteOrganizzazioneCanaleComunicazioneException</code> if it could not be found.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione
	 * @throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione findByPrimaryKey(
			UtenteOrganizzazioneCanaleComunicazionePK
				utenteOrganizzazioneCanaleComunicazionePK)
		throws NoSuchUtenteOrganizzazioneCanaleComunicazioneException {

		return findByPrimaryKey(
			(Serializable)utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns the utente organizzazione canale comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param utenteOrganizzazioneCanaleComunicazionePK the primary key of the utente organizzazione canale comunicazione
	 * @return the utente organizzazione canale comunicazione, or <code>null</code> if a utente organizzazione canale comunicazione with the primary key could not be found
	 */
	@Override
	public UtenteOrganizzazioneCanaleComunicazione fetchByPrimaryKey(
		UtenteOrganizzazioneCanaleComunicazionePK
			utenteOrganizzazioneCanaleComunicazionePK) {

		return fetchByPrimaryKey(
			(Serializable)utenteOrganizzazioneCanaleComunicazionePK);
	}

	/**
	 * Returns all the utente organizzazione canale comunicaziones.
	 *
	 * @return the utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @return the range of utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the utente organizzazione canale comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UtenteOrganizzazioneCanaleComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente organizzazione canale comunicaziones
	 * @param end the upper bound of the range of utente organizzazione canale comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of utente organizzazione canale comunicaziones
	 */
	@Override
	public List<UtenteOrganizzazioneCanaleComunicazione> findAll(
		int start, int end,
		OrderByComparator<UtenteOrganizzazioneCanaleComunicazione>
			orderByComparator,
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

		List<UtenteOrganizzazioneCanaleComunicazione> list = null;

		if (useFinderCache) {
			list =
				(List<UtenteOrganizzazioneCanaleComunicazione>)
					finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE;

				sql = sql.concat(
					UtenteOrganizzazioneCanaleComunicazioneModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<UtenteOrganizzazioneCanaleComunicazione>)
						QueryUtil.list(query, getDialect(), start, end);

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
	 * Removes all the utente organizzazione canale comunicaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UtenteOrganizzazioneCanaleComunicazione
				utenteOrganizzazioneCanaleComunicazione : findAll()) {

			remove(utenteOrganizzazioneCanaleComunicazione);
		}
	}

	/**
	 * Returns the number of utente organizzazione canale comunicaziones.
	 *
	 * @return the number of utente organizzazione canale comunicaziones
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
					_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE);

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
		return "utenteOrganizzazioneCanaleComunicazionePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UtenteOrganizzazioneCanaleComunicazioneModelImpl.
			TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the utente organizzazione canale comunicazione persistence.
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

		_setUtenteOrganizzazioneCanaleComunicazioneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUtenteOrganizzazioneCanaleComunicazioneUtilPersistence(null);

		entityCache.removeCache(
			UtenteOrganizzazioneCanaleComunicazioneImpl.class.getName());
	}

	private void _setUtenteOrganizzazioneCanaleComunicazioneUtilPersistence(
		UtenteOrganizzazioneCanaleComunicazionePersistence
			utenteOrganizzazioneCanaleComunicazionePersistence) {

		try {
			Field field =
				UtenteOrganizzazioneCanaleComunicazioneUtil.class.
					getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, utenteOrganizzazioneCanaleComunicazionePersistence);
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

	private static final String
		_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE =
			"SELECT utenteOrganizzazioneCanaleComunicazione FROM UtenteOrganizzazioneCanaleComunicazione utenteOrganizzazioneCanaleComunicazione";

	private static final String
		_SQL_SELECT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE =
			"SELECT utenteOrganizzazioneCanaleComunicazione FROM UtenteOrganizzazioneCanaleComunicazione utenteOrganizzazioneCanaleComunicazione WHERE ";

	private static final String
		_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE =
			"SELECT COUNT(utenteOrganizzazioneCanaleComunicazione) FROM UtenteOrganizzazioneCanaleComunicazione utenteOrganizzazioneCanaleComunicazione";

	private static final String
		_SQL_COUNT_UTENTEORGANIZZAZIONECANALECOMUNICAZIONE_WHERE =
			"SELECT COUNT(utenteOrganizzazioneCanaleComunicazione) FROM UtenteOrganizzazioneCanaleComunicazione utenteOrganizzazioneCanaleComunicazione WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"utenteOrganizzazioneCanaleComunicazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UtenteOrganizzazioneCanaleComunicazione exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UtenteOrganizzazioneCanaleComunicazione exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UtenteOrganizzazioneCanaleComunicazionePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"utenteId", "organizationId", "canaleComunicazioneId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private UtenteOrganizzazioneCanaleComunicazioneModelArgumentsResolver
		_utenteOrganizzazioneCanaleComunicazioneModelArgumentsResolver;

}