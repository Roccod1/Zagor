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

import it.servizidigitali.gestioneforms.exception.NoSuchTipoDocumentoException;
import it.servizidigitali.gestioneforms.model.TipoDocumento;
import it.servizidigitali.gestioneforms.model.TipoDocumentoTable;
import it.servizidigitali.gestioneforms.model.impl.TipoDocumentoImpl;
import it.servizidigitali.gestioneforms.model.impl.TipoDocumentoModelImpl;
import it.servizidigitali.gestioneforms.service.persistence.TipoDocumentoPersistence;
import it.servizidigitali.gestioneforms.service.persistence.TipoDocumentoUtil;
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
 * The persistence implementation for the tipo documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TipoDocumentoPersistence.class, BasePersistence.class})
public class TipoDocumentoPersistenceImpl
	extends BasePersistenceImpl<TipoDocumento>
	implements TipoDocumentoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TipoDocumentoUtil</code> to access the tipo documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TipoDocumentoImpl.class.getName();

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
	 * Returns all the tipo documentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator,
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

		List<TipoDocumento> list = null;

		if (useFinderCache) {
			list = (List<TipoDocumento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TipoDocumento tipoDocumento : list) {
					if (!uuid.equals(tipoDocumento.getUuid())) {
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

			sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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
				sb.append(TipoDocumentoModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipoDocumento>)QueryUtil.list(
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
	 * Returns the first tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findByUuid_First(
			String uuid, OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchByUuid_First(
			uuid, orderByComparator);

		if (tipoDocumento != null) {
			return tipoDocumento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipoDocumentoException(sb.toString());
	}

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchByUuid_First(
		String uuid, OrderByComparator<TipoDocumento> orderByComparator) {

		List<TipoDocumento> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findByUuid_Last(
			String uuid, OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchByUuid_Last(uuid, orderByComparator);

		if (tipoDocumento != null) {
			return tipoDocumento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipoDocumentoException(sb.toString());
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchByUuid_Last(
		String uuid, OrderByComparator<TipoDocumento> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TipoDocumento> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where uuid = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento[] findByUuid_PrevAndNext(
			long tipoDocumentoId, String uuid,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		uuid = Objects.toString(uuid, "");

		TipoDocumento tipoDocumento = findByPrimaryKey(tipoDocumentoId);

		Session session = null;

		try {
			session = openSession();

			TipoDocumento[] array = new TipoDocumentoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tipoDocumento, uuid, orderByComparator, true);

			array[1] = tipoDocumento;

			array[2] = getByUuid_PrevAndNext(
				session, tipoDocumento, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipoDocumento getByUuid_PrevAndNext(
		Session session, TipoDocumento tipoDocumento, String uuid,
		OrderByComparator<TipoDocumento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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
			sb.append(TipoDocumentoModelImpl.ORDER_BY_JPQL);
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
						tipoDocumento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoDocumento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo documentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TipoDocumento tipoDocumento :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipoDocumento);
		}
	}

	/**
	 * Returns the number of tipo documentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipo documentos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPODOCUMENTO_WHERE);

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
		"tipoDocumento.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tipoDocumento.uuid IS NULL OR tipoDocumento.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipoDocumentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findByUUID_G(String uuid, long groupId)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchByUUID_G(uuid, groupId);

		if (tipoDocumento == null) {
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

			throw new NoSuchTipoDocumentoException(sb.toString());
		}

		return tipoDocumento;
	}

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tipo documento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchByUUID_G(
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

		if (result instanceof TipoDocumento) {
			TipoDocumento tipoDocumento = (TipoDocumento)result;

			if (!Objects.equals(uuid, tipoDocumento.getUuid()) ||
				(groupId != tipoDocumento.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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

				List<TipoDocumento> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TipoDocumento tipoDocumento = list.get(0);

					result = tipoDocumento;

					cacheResult(tipoDocumento);
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
			return (TipoDocumento)result;
		}
	}

	/**
	 * Removes the tipo documento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipo documento that was removed
	 */
	@Override
	public TipoDocumento removeByUUID_G(String uuid, long groupId)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = findByUUID_G(uuid, groupId);

		return remove(tipoDocumento);
	}

	/**
	 * Returns the number of tipo documentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipo documentos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIPODOCUMENTO_WHERE);

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
		"tipoDocumento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(tipoDocumento.uuid IS NULL OR tipoDocumento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"tipoDocumento.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator,
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

		List<TipoDocumento> list = null;

		if (useFinderCache) {
			list = (List<TipoDocumento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TipoDocumento tipoDocumento : list) {
					if (!uuid.equals(tipoDocumento.getUuid()) ||
						(companyId != tipoDocumento.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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
				sb.append(TipoDocumentoModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipoDocumento>)QueryUtil.list(
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
	 * Returns the first tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (tipoDocumento != null) {
			return tipoDocumento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTipoDocumentoException(sb.toString());
	}

	/**
	 * Returns the first tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TipoDocumento> orderByComparator) {

		List<TipoDocumento> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (tipoDocumento != null) {
			return tipoDocumento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTipoDocumentoException(sb.toString());
	}

	/**
	 * Returns the last tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TipoDocumento> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TipoDocumento> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento[] findByUuid_C_PrevAndNext(
			long tipoDocumentoId, String uuid, long companyId,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		uuid = Objects.toString(uuid, "");

		TipoDocumento tipoDocumento = findByPrimaryKey(tipoDocumentoId);

		Session session = null;

		try {
			session = openSession();

			TipoDocumento[] array = new TipoDocumentoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, tipoDocumento, uuid, companyId, orderByComparator,
				true);

			array[1] = tipoDocumento;

			array[2] = getByUuid_C_PrevAndNext(
				session, tipoDocumento, uuid, companyId, orderByComparator,
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

	protected TipoDocumento getByUuid_C_PrevAndNext(
		Session session, TipoDocumento tipoDocumento, String uuid,
		long companyId, OrderByComparator<TipoDocumento> orderByComparator,
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

		sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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
			sb.append(TipoDocumentoModelImpl.ORDER_BY_JPQL);
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
						tipoDocumento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoDocumento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo documentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TipoDocumento tipoDocumento :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tipoDocumento);
		}
	}

	/**
	 * Returns the number of tipo documentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipo documentos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIPODOCUMENTO_WHERE);

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
		"tipoDocumento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(tipoDocumento.uuid IS NULL OR tipoDocumento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"tipoDocumento.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBystato;
	private FinderPath _finderPathWithoutPaginationFindBystato;
	private FinderPath _finderPathCountBystato;

	/**
	 * Returns all the tipo documentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findBystato(String stato) {
		return findBystato(stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findBystato(String stato, int start, int end) {
		return findBystato(stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findBystato(
		String stato, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return findBystato(stato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo documentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo documentos
	 */
	@Override
	public List<TipoDocumento> findBystato(
		String stato, int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator,
		boolean useFinderCache) {

		stato = Objects.toString(stato, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystato;
				finderArgs = new Object[] {stato};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystato;
			finderArgs = new Object[] {stato, start, end, orderByComparator};
		}

		List<TipoDocumento> list = null;

		if (useFinderCache) {
			list = (List<TipoDocumento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TipoDocumento tipoDocumento : list) {
					if (!stato.equals(tipoDocumento.getStato())) {
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

			sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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
				sb.append(TipoDocumentoModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipoDocumento>)QueryUtil.list(
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
	 * Returns the first tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findBystato_First(
			String stato, OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchBystato_First(
			stato, orderByComparator);

		if (tipoDocumento != null) {
			return tipoDocumento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchTipoDocumentoException(sb.toString());
	}

	/**
	 * Returns the first tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchBystato_First(
		String stato, OrderByComparator<TipoDocumento> orderByComparator) {

		List<TipoDocumento> list = findBystato(stato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento
	 * @throws NoSuchTipoDocumentoException if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento findBystato_Last(
			String stato, OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchBystato_Last(
			stato, orderByComparator);

		if (tipoDocumento != null) {
			return tipoDocumento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchTipoDocumentoException(sb.toString());
	}

	/**
	 * Returns the last tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo documento, or <code>null</code> if a matching tipo documento could not be found
	 */
	@Override
	public TipoDocumento fetchBystato_Last(
		String stato, OrderByComparator<TipoDocumento> orderByComparator) {

		int count = countBystato(stato);

		if (count == 0) {
			return null;
		}

		List<TipoDocumento> list = findBystato(
			stato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipo documentos before and after the current tipo documento in the ordered set where stato = &#63;.
	 *
	 * @param tipoDocumentoId the primary key of the current tipo documento
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento[] findBystato_PrevAndNext(
			long tipoDocumentoId, String stato,
			OrderByComparator<TipoDocumento> orderByComparator)
		throws NoSuchTipoDocumentoException {

		stato = Objects.toString(stato, "");

		TipoDocumento tipoDocumento = findByPrimaryKey(tipoDocumentoId);

		Session session = null;

		try {
			session = openSession();

			TipoDocumento[] array = new TipoDocumentoImpl[3];

			array[0] = getBystato_PrevAndNext(
				session, tipoDocumento, stato, orderByComparator, true);

			array[1] = tipoDocumento;

			array[2] = getBystato_PrevAndNext(
				session, tipoDocumento, stato, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipoDocumento getBystato_PrevAndNext(
		Session session, TipoDocumento tipoDocumento, String stato,
		OrderByComparator<TipoDocumento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPODOCUMENTO_WHERE);

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
			sb.append(TipoDocumentoModelImpl.ORDER_BY_JPQL);
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
						tipoDocumento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipoDocumento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipo documentos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	@Override
	public void removeBystato(String stato) {
		for (TipoDocumento tipoDocumento :
				findBystato(
					stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipoDocumento);
		}
	}

	/**
	 * Returns the number of tipo documentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching tipo documentos
	 */
	@Override
	public int countBystato(String stato) {
		stato = Objects.toString(stato, "");

		FinderPath finderPath = _finderPathCountBystato;

		Object[] finderArgs = new Object[] {stato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPODOCUMENTO_WHERE);

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
		"tipoDocumento.stato = ?";

	private static final String _FINDER_COLUMN_STATO_STATO_3 =
		"(tipoDocumento.stato IS NULL OR tipoDocumento.stato = '')";

	public TipoDocumentoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("estensioniFile", "estensioni_file");
		dbColumnNames.put("numeroRequired", "numero_required");
		dbColumnNames.put("dataScadenzaRequired", "data_scadenza_required");

		setDBColumnNames(dbColumnNames);

		setModelClass(TipoDocumento.class);

		setModelImplClass(TipoDocumentoImpl.class);
		setModelPKClass(long.class);

		setTable(TipoDocumentoTable.INSTANCE);
	}

	/**
	 * Caches the tipo documento in the entity cache if it is enabled.
	 *
	 * @param tipoDocumento the tipo documento
	 */
	@Override
	public void cacheResult(TipoDocumento tipoDocumento) {
		entityCache.putResult(
			TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey(),
			tipoDocumento);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {tipoDocumento.getUuid(), tipoDocumento.getGroupId()},
			tipoDocumento);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tipo documentos in the entity cache if it is enabled.
	 *
	 * @param tipoDocumentos the tipo documentos
	 */
	@Override
	public void cacheResult(List<TipoDocumento> tipoDocumentos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tipoDocumentos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TipoDocumento tipoDocumento : tipoDocumentos) {
			if (entityCache.getResult(
					TipoDocumentoImpl.class, tipoDocumento.getPrimaryKey()) ==
						null) {

				cacheResult(tipoDocumento);
			}
		}
	}

	/**
	 * Clears the cache for all tipo documentos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipoDocumentoImpl.class);

		finderCache.clearCache(TipoDocumentoImpl.class);
	}

	/**
	 * Clears the cache for the tipo documento.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoDocumento tipoDocumento) {
		entityCache.removeResult(TipoDocumentoImpl.class, tipoDocumento);
	}

	@Override
	public void clearCache(List<TipoDocumento> tipoDocumentos) {
		for (TipoDocumento tipoDocumento : tipoDocumentos) {
			entityCache.removeResult(TipoDocumentoImpl.class, tipoDocumento);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TipoDocumentoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TipoDocumentoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TipoDocumentoModelImpl tipoDocumentoModelImpl) {

		Object[] args = new Object[] {
			tipoDocumentoModelImpl.getUuid(),
			tipoDocumentoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, tipoDocumentoModelImpl);
	}

	/**
	 * Creates a new tipo documento with the primary key. Does not add the tipo documento to the database.
	 *
	 * @param tipoDocumentoId the primary key for the new tipo documento
	 * @return the new tipo documento
	 */
	@Override
	public TipoDocumento create(long tipoDocumentoId) {
		TipoDocumento tipoDocumento = new TipoDocumentoImpl();

		tipoDocumento.setNew(true);
		tipoDocumento.setPrimaryKey(tipoDocumentoId);

		String uuid = PortalUUIDUtil.generate();

		tipoDocumento.setUuid(uuid);

		tipoDocumento.setCompanyId(CompanyThreadLocal.getCompanyId());

		return tipoDocumento;
	}

	/**
	 * Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento remove(long tipoDocumentoId)
		throws NoSuchTipoDocumentoException {

		return remove((Serializable)tipoDocumentoId);
	}

	/**
	 * Removes the tipo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo documento
	 * @return the tipo documento that was removed
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento remove(Serializable primaryKey)
		throws NoSuchTipoDocumentoException {

		Session session = null;

		try {
			session = openSession();

			TipoDocumento tipoDocumento = (TipoDocumento)session.get(
				TipoDocumentoImpl.class, primaryKey);

			if (tipoDocumento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoDocumentoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tipoDocumento);
		}
		catch (NoSuchTipoDocumentoException noSuchEntityException) {
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
	protected TipoDocumento removeImpl(TipoDocumento tipoDocumento) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipoDocumento)) {
				tipoDocumento = (TipoDocumento)session.get(
					TipoDocumentoImpl.class, tipoDocumento.getPrimaryKeyObj());
			}

			if (tipoDocumento != null) {
				session.delete(tipoDocumento);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tipoDocumento != null) {
			clearCache(tipoDocumento);
		}

		return tipoDocumento;
	}

	@Override
	public TipoDocumento updateImpl(TipoDocumento tipoDocumento) {
		boolean isNew = tipoDocumento.isNew();

		if (!(tipoDocumento instanceof TipoDocumentoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tipoDocumento.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					tipoDocumento);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tipoDocumento proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TipoDocumento implementation " +
					tipoDocumento.getClass());
		}

		TipoDocumentoModelImpl tipoDocumentoModelImpl =
			(TipoDocumentoModelImpl)tipoDocumento;

		if (Validator.isNull(tipoDocumento.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tipoDocumento.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (tipoDocumento.getCreateDate() == null)) {
			if (serviceContext == null) {
				tipoDocumento.setCreateDate(date);
			}
			else {
				tipoDocumento.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!tipoDocumentoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tipoDocumento.setModifiedDate(date);
			}
			else {
				tipoDocumento.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tipoDocumento);
			}
			else {
				tipoDocumento = (TipoDocumento)session.merge(tipoDocumento);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TipoDocumentoImpl.class, tipoDocumentoModelImpl, false, true);

		cacheUniqueFindersCache(tipoDocumentoModelImpl);

		if (isNew) {
			tipoDocumento.setNew(false);
		}

		tipoDocumento.resetOriginalValues();

		return tipoDocumento;
	}

	/**
	 * Returns the tipo documento with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipoDocumentoException {

		TipoDocumento tipoDocumento = fetchByPrimaryKey(primaryKey);

		if (tipoDocumento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipoDocumentoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tipoDocumento;
	}

	/**
	 * Returns the tipo documento with the primary key or throws a <code>NoSuchTipoDocumentoException</code> if it could not be found.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento
	 * @throws NoSuchTipoDocumentoException if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento findByPrimaryKey(long tipoDocumentoId)
		throws NoSuchTipoDocumentoException {

		return findByPrimaryKey((Serializable)tipoDocumentoId);
	}

	/**
	 * Returns the tipo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipoDocumentoId the primary key of the tipo documento
	 * @return the tipo documento, or <code>null</code> if a tipo documento with the primary key could not be found
	 */
	@Override
	public TipoDocumento fetchByPrimaryKey(long tipoDocumentoId) {
		return fetchByPrimaryKey((Serializable)tipoDocumentoId);
	}

	/**
	 * Returns all the tipo documentos.
	 *
	 * @return the tipo documentos
	 */
	@Override
	public List<TipoDocumento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @return the range of tipo documentos
	 */
	@Override
	public List<TipoDocumento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo documentos
	 */
	@Override
	public List<TipoDocumento> findAll(
		int start, int end,
		OrderByComparator<TipoDocumento> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoDocumentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo documentos
	 * @param end the upper bound of the range of tipo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipo documentos
	 */
	@Override
	public List<TipoDocumento> findAll(
		int start, int end, OrderByComparator<TipoDocumento> orderByComparator,
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

		List<TipoDocumento> list = null;

		if (useFinderCache) {
			list = (List<TipoDocumento>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIPODOCUMENTO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIPODOCUMENTO;

				sql = sql.concat(TipoDocumentoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TipoDocumento>)QueryUtil.list(
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
	 * Removes all the tipo documentos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipoDocumento tipoDocumento : findAll()) {
			remove(tipoDocumento);
		}
	}

	/**
	 * Returns the number of tipo documentos.
	 *
	 * @return the number of tipo documentos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TIPODOCUMENTO);

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
		return "tipoDocumentoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIPODOCUMENTO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TipoDocumentoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipo documento persistence.
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

		_finderPathWithPaginationFindBystato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystato",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stato"}, true);

		_finderPathWithoutPaginationFindBystato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystato",
			new String[] {String.class.getName()}, new String[] {"stato"},
			true);

		_finderPathCountBystato = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystato",
			new String[] {String.class.getName()}, new String[] {"stato"},
			false);

		_setTipoDocumentoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTipoDocumentoUtilPersistence(null);

		entityCache.removeCache(TipoDocumentoImpl.class.getName());
	}

	private void _setTipoDocumentoUtilPersistence(
		TipoDocumentoPersistence tipoDocumentoPersistence) {

		try {
			Field field = TipoDocumentoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, tipoDocumentoPersistence);
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

	private static final String _SQL_SELECT_TIPODOCUMENTO =
		"SELECT tipoDocumento FROM TipoDocumento tipoDocumento";

	private static final String _SQL_SELECT_TIPODOCUMENTO_WHERE =
		"SELECT tipoDocumento FROM TipoDocumento tipoDocumento WHERE ";

	private static final String _SQL_COUNT_TIPODOCUMENTO =
		"SELECT COUNT(tipoDocumento) FROM TipoDocumento tipoDocumento";

	private static final String _SQL_COUNT_TIPODOCUMENTO_WHERE =
		"SELECT COUNT(tipoDocumento) FROM TipoDocumento tipoDocumento WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoDocumento.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TipoDocumento exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TipoDocumento exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TipoDocumentoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "estensioniFile", "numeroRequired", "dataScadenzaRequired"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TipoDocumentoModelArgumentsResolver
		_tipoDocumentoModelArgumentsResolver;

}