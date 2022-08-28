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

import it.servizidigitali.scrivaniaoperatore.exception.NoSuchIstanzaFormException;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaForm;
import it.servizidigitali.scrivaniaoperatore.model.IstanzaFormTable;
import it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormImpl;
import it.servizidigitali.scrivaniaoperatore.model.impl.IstanzaFormModelImpl;
import it.servizidigitali.scrivaniaoperatore.service.persistence.IstanzaFormPersistence;
import it.servizidigitali.scrivaniaoperatore.service.persistence.IstanzaFormUtil;
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
 * The persistence implementation for the istanza form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {IstanzaFormPersistence.class, BasePersistence.class})
public class IstanzaFormPersistenceImpl
	extends BasePersistenceImpl<IstanzaForm> implements IstanzaFormPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IstanzaFormUtil</code> to access the istanza form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IstanzaFormImpl.class.getName();

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
	 * Returns all the istanza forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator,
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

		List<IstanzaForm> list = null;

		if (useFinderCache) {
			list = (List<IstanzaForm>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (IstanzaForm istanzaForm : list) {
					if (!uuid.equals(istanzaForm.getUuid())) {
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

			sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

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
				sb.append(IstanzaFormModelImpl.ORDER_BY_JPQL);
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

				list = (List<IstanzaForm>)QueryUtil.list(
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
	 * Returns the first istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByUuid_First(
			String uuid, OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByUuid_First(uuid, orderByComparator);

		if (istanzaForm != null) {
			return istanzaForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIstanzaFormException(sb.toString());
	}

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByUuid_First(
		String uuid, OrderByComparator<IstanzaForm> orderByComparator) {

		List<IstanzaForm> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByUuid_Last(
			String uuid, OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByUuid_Last(uuid, orderByComparator);

		if (istanzaForm != null) {
			return istanzaForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIstanzaFormException(sb.toString());
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByUuid_Last(
		String uuid, OrderByComparator<IstanzaForm> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<IstanzaForm> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where uuid = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm[] findByUuid_PrevAndNext(
			long istanzaFormId, String uuid,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		uuid = Objects.toString(uuid, "");

		IstanzaForm istanzaForm = findByPrimaryKey(istanzaFormId);

		Session session = null;

		try {
			session = openSession();

			IstanzaForm[] array = new IstanzaFormImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, istanzaForm, uuid, orderByComparator, true);

			array[1] = istanzaForm;

			array[2] = getByUuid_PrevAndNext(
				session, istanzaForm, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IstanzaForm getByUuid_PrevAndNext(
		Session session, IstanzaForm istanzaForm, String uuid,
		OrderByComparator<IstanzaForm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

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
			sb.append(IstanzaFormModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(istanzaForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IstanzaForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the istanza forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (IstanzaForm istanzaForm :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(istanzaForm);
		}
	}

	/**
	 * Returns the number of istanza forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching istanza forms
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISTANZAFORM_WHERE);

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
		"istanzaForm.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(istanzaForm.uuid IS NULL OR istanzaForm.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByUUID_G(String uuid, long groupId)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByUUID_G(uuid, groupId);

		if (istanzaForm == null) {
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

			throw new NoSuchIstanzaFormException(sb.toString());
		}

		return istanzaForm;
	}

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the istanza form where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByUUID_G(
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

		if (result instanceof IstanzaForm) {
			IstanzaForm istanzaForm = (IstanzaForm)result;

			if (!Objects.equals(uuid, istanzaForm.getUuid()) ||
				(groupId != istanzaForm.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

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

				List<IstanzaForm> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					IstanzaForm istanzaForm = list.get(0);

					result = istanzaForm;

					cacheResult(istanzaForm);
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
			return (IstanzaForm)result;
		}
	}

	/**
	 * Removes the istanza form where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the istanza form that was removed
	 */
	@Override
	public IstanzaForm removeByUUID_G(String uuid, long groupId)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = findByUUID_G(uuid, groupId);

		return remove(istanzaForm);
	}

	/**
	 * Returns the number of istanza forms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching istanza forms
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ISTANZAFORM_WHERE);

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
		"istanzaForm.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(istanzaForm.uuid IS NULL OR istanzaForm.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"istanzaForm.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator,
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

		List<IstanzaForm> list = null;

		if (useFinderCache) {
			list = (List<IstanzaForm>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (IstanzaForm istanzaForm : list) {
					if (!uuid.equals(istanzaForm.getUuid()) ||
						(companyId != istanzaForm.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

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
				sb.append(IstanzaFormModelImpl.ORDER_BY_JPQL);
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

				list = (List<IstanzaForm>)QueryUtil.list(
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
	 * Returns the first istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (istanzaForm != null) {
			return istanzaForm;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIstanzaFormException(sb.toString());
	}

	/**
	 * Returns the first istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IstanzaForm> orderByComparator) {

		List<IstanzaForm> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (istanzaForm != null) {
			return istanzaForm;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIstanzaFormException(sb.toString());
	}

	/**
	 * Returns the last istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IstanzaForm> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<IstanzaForm> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm[] findByUuid_C_PrevAndNext(
			long istanzaFormId, String uuid, long companyId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		uuid = Objects.toString(uuid, "");

		IstanzaForm istanzaForm = findByPrimaryKey(istanzaFormId);

		Session session = null;

		try {
			session = openSession();

			IstanzaForm[] array = new IstanzaFormImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, istanzaForm, uuid, companyId, orderByComparator, true);

			array[1] = istanzaForm;

			array[2] = getByUuid_C_PrevAndNext(
				session, istanzaForm, uuid, companyId, orderByComparator,
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

	protected IstanzaForm getByUuid_C_PrevAndNext(
		Session session, IstanzaForm istanzaForm, String uuid, long companyId,
		OrderByComparator<IstanzaForm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

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
			sb.append(IstanzaFormModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(istanzaForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IstanzaForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the istanza forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (IstanzaForm istanzaForm :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(istanzaForm);
		}
	}

	/**
	 * Returns the number of istanza forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching istanza forms
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ISTANZAFORM_WHERE);

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
		"istanzaForm.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(istanzaForm.uuid IS NULL OR istanzaForm.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"istanzaForm.companyId = ?";

	private FinderPath _finderPathFetchByRichiestaId;
	private FinderPath _finderPathCountByRichiestaId;

	/**
	 * Returns the istanza form where richiestaId = &#63; or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByRichiestaId(long richiestaId)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByRichiestaId(richiestaId);

		if (istanzaForm == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("richiestaId=");
			sb.append(richiestaId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIstanzaFormException(sb.toString());
		}

		return istanzaForm;
	}

	/**
	 * Returns the istanza form where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByRichiestaId(long richiestaId) {
		return fetchByRichiestaId(richiestaId, true);
	}

	/**
	 * Returns the istanza form where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByRichiestaId(
		long richiestaId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {richiestaId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRichiestaId, finderArgs);
		}

		if (result instanceof IstanzaForm) {
			IstanzaForm istanzaForm = (IstanzaForm)result;

			if (richiestaId != istanzaForm.getRichiestaId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				List<IstanzaForm> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRichiestaId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {richiestaId};
							}

							_log.warn(
								"IstanzaFormPersistenceImpl.fetchByRichiestaId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IstanzaForm istanzaForm = list.get(0);

					result = istanzaForm;

					cacheResult(istanzaForm);
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
			return (IstanzaForm)result;
		}
	}

	/**
	 * Removes the istanza form where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the istanza form that was removed
	 */
	@Override
	public IstanzaForm removeByRichiestaId(long richiestaId)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = findByRichiestaId(richiestaId);

		return remove(istanzaForm);
	}

	/**
	 * Returns the number of istanza forms where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching istanza forms
	 */
	@Override
	public int countByRichiestaId(long richiestaId) {
		FinderPath finderPath = _finderPathCountByRichiestaId;

		Object[] finderArgs = new Object[] {richiestaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISTANZAFORM_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

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

	private static final String _FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2 =
		"istanzaForm.richiestaId = ?";

	private FinderPath _finderPathWithPaginationFindByFormId;
	private FinderPath _finderPathWithoutPaginationFindByFormId;
	private FinderPath _finderPathCountByFormId;

	/**
	 * Returns all the istanza forms where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByFormId(long formId) {
		return findByFormId(formId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByFormId(long formId, int start, int end) {
		return findByFormId(formId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByFormId(
		long formId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator) {

		return findByFormId(formId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the istanza forms where formId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param formId the form ID
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching istanza forms
	 */
	@Override
	public List<IstanzaForm> findByFormId(
		long formId, int start, int end,
		OrderByComparator<IstanzaForm> orderByComparator,
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

		List<IstanzaForm> list = null;

		if (useFinderCache) {
			list = (List<IstanzaForm>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (IstanzaForm istanzaForm : list) {
					if (formId != istanzaForm.getFormId()) {
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

			sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

			sb.append(_FINDER_COLUMN_FORMID_FORMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IstanzaFormModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formId);

				list = (List<IstanzaForm>)QueryUtil.list(
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
	 * Returns the first istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByFormId_First(
			long formId, OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByFormId_First(
			formId, orderByComparator);

		if (istanzaForm != null) {
			return istanzaForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("formId=");
		sb.append(formId);

		sb.append("}");

		throw new NoSuchIstanzaFormException(sb.toString());
	}

	/**
	 * Returns the first istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByFormId_First(
		long formId, OrderByComparator<IstanzaForm> orderByComparator) {

		List<IstanzaForm> list = findByFormId(formId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form
	 * @throws NoSuchIstanzaFormException if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm findByFormId_Last(
			long formId, OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByFormId_Last(formId, orderByComparator);

		if (istanzaForm != null) {
			return istanzaForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("formId=");
		sb.append(formId);

		sb.append("}");

		throw new NoSuchIstanzaFormException(sb.toString());
	}

	/**
	 * Returns the last istanza form in the ordered set where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching istanza form, or <code>null</code> if a matching istanza form could not be found
	 */
	@Override
	public IstanzaForm fetchByFormId_Last(
		long formId, OrderByComparator<IstanzaForm> orderByComparator) {

		int count = countByFormId(formId);

		if (count == 0) {
			return null;
		}

		List<IstanzaForm> list = findByFormId(
			formId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the istanza forms before and after the current istanza form in the ordered set where formId = &#63;.
	 *
	 * @param istanzaFormId the primary key of the current istanza form
	 * @param formId the form ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm[] findByFormId_PrevAndNext(
			long istanzaFormId, long formId,
			OrderByComparator<IstanzaForm> orderByComparator)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = findByPrimaryKey(istanzaFormId);

		Session session = null;

		try {
			session = openSession();

			IstanzaForm[] array = new IstanzaFormImpl[3];

			array[0] = getByFormId_PrevAndNext(
				session, istanzaForm, formId, orderByComparator, true);

			array[1] = istanzaForm;

			array[2] = getByFormId_PrevAndNext(
				session, istanzaForm, formId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IstanzaForm getByFormId_PrevAndNext(
		Session session, IstanzaForm istanzaForm, long formId,
		OrderByComparator<IstanzaForm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ISTANZAFORM_WHERE);

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
			sb.append(IstanzaFormModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(formId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(istanzaForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IstanzaForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the istanza forms where formId = &#63; from the database.
	 *
	 * @param formId the form ID
	 */
	@Override
	public void removeByFormId(long formId) {
		for (IstanzaForm istanzaForm :
				findByFormId(
					formId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(istanzaForm);
		}
	}

	/**
	 * Returns the number of istanza forms where formId = &#63;.
	 *
	 * @param formId the form ID
	 * @return the number of matching istanza forms
	 */
	@Override
	public int countByFormId(long formId) {
		FinderPath finderPath = _finderPathCountByFormId;

		Object[] finderArgs = new Object[] {formId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISTANZAFORM_WHERE);

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
		"istanzaForm.formId = ?";

	public IstanzaFormPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(IstanzaForm.class);

		setModelImplClass(IstanzaFormImpl.class);
		setModelPKClass(long.class);

		setTable(IstanzaFormTable.INSTANCE);
	}

	/**
	 * Caches the istanza form in the entity cache if it is enabled.
	 *
	 * @param istanzaForm the istanza form
	 */
	@Override
	public void cacheResult(IstanzaForm istanzaForm) {
		entityCache.putResult(
			IstanzaFormImpl.class, istanzaForm.getPrimaryKey(), istanzaForm);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {istanzaForm.getUuid(), istanzaForm.getGroupId()},
			istanzaForm);

		finderCache.putResult(
			_finderPathFetchByRichiestaId,
			new Object[] {istanzaForm.getRichiestaId()}, istanzaForm);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the istanza forms in the entity cache if it is enabled.
	 *
	 * @param istanzaForms the istanza forms
	 */
	@Override
	public void cacheResult(List<IstanzaForm> istanzaForms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (istanzaForms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (IstanzaForm istanzaForm : istanzaForms) {
			if (entityCache.getResult(
					IstanzaFormImpl.class, istanzaForm.getPrimaryKey()) ==
						null) {

				cacheResult(istanzaForm);
			}
		}
	}

	/**
	 * Clears the cache for all istanza forms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IstanzaFormImpl.class);

		finderCache.clearCache(IstanzaFormImpl.class);
	}

	/**
	 * Clears the cache for the istanza form.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IstanzaForm istanzaForm) {
		entityCache.removeResult(IstanzaFormImpl.class, istanzaForm);
	}

	@Override
	public void clearCache(List<IstanzaForm> istanzaForms) {
		for (IstanzaForm istanzaForm : istanzaForms) {
			entityCache.removeResult(IstanzaFormImpl.class, istanzaForm);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(IstanzaFormImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IstanzaFormImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		IstanzaFormModelImpl istanzaFormModelImpl) {

		Object[] args = new Object[] {
			istanzaFormModelImpl.getUuid(), istanzaFormModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, istanzaFormModelImpl);

		args = new Object[] {istanzaFormModelImpl.getRichiestaId()};

		finderCache.putResult(
			_finderPathCountByRichiestaId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByRichiestaId, args, istanzaFormModelImpl);
	}

	/**
	 * Creates a new istanza form with the primary key. Does not add the istanza form to the database.
	 *
	 * @param istanzaFormId the primary key for the new istanza form
	 * @return the new istanza form
	 */
	@Override
	public IstanzaForm create(long istanzaFormId) {
		IstanzaForm istanzaForm = new IstanzaFormImpl();

		istanzaForm.setNew(true);
		istanzaForm.setPrimaryKey(istanzaFormId);

		String uuid = PortalUUIDUtil.generate();

		istanzaForm.setUuid(uuid);

		istanzaForm.setCompanyId(CompanyThreadLocal.getCompanyId());

		return istanzaForm;
	}

	/**
	 * Removes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm remove(long istanzaFormId)
		throws NoSuchIstanzaFormException {

		return remove((Serializable)istanzaFormId);
	}

	/**
	 * Removes the istanza form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the istanza form
	 * @return the istanza form that was removed
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm remove(Serializable primaryKey)
		throws NoSuchIstanzaFormException {

		Session session = null;

		try {
			session = openSession();

			IstanzaForm istanzaForm = (IstanzaForm)session.get(
				IstanzaFormImpl.class, primaryKey);

			if (istanzaForm == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIstanzaFormException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(istanzaForm);
		}
		catch (NoSuchIstanzaFormException noSuchEntityException) {
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
	protected IstanzaForm removeImpl(IstanzaForm istanzaForm) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(istanzaForm)) {
				istanzaForm = (IstanzaForm)session.get(
					IstanzaFormImpl.class, istanzaForm.getPrimaryKeyObj());
			}

			if (istanzaForm != null) {
				session.delete(istanzaForm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (istanzaForm != null) {
			clearCache(istanzaForm);
		}

		return istanzaForm;
	}

	@Override
	public IstanzaForm updateImpl(IstanzaForm istanzaForm) {
		boolean isNew = istanzaForm.isNew();

		if (!(istanzaForm instanceof IstanzaFormModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(istanzaForm.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(istanzaForm);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in istanzaForm proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IstanzaForm implementation " +
					istanzaForm.getClass());
		}

		IstanzaFormModelImpl istanzaFormModelImpl =
			(IstanzaFormModelImpl)istanzaForm;

		if (Validator.isNull(istanzaForm.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			istanzaForm.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (istanzaForm.getCreateDate() == null)) {
			if (serviceContext == null) {
				istanzaForm.setCreateDate(date);
			}
			else {
				istanzaForm.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!istanzaFormModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				istanzaForm.setModifiedDate(date);
			}
			else {
				istanzaForm.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(istanzaForm);
			}
			else {
				istanzaForm = (IstanzaForm)session.merge(istanzaForm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IstanzaFormImpl.class, istanzaFormModelImpl, false, true);

		cacheUniqueFindersCache(istanzaFormModelImpl);

		if (isNew) {
			istanzaForm.setNew(false);
		}

		istanzaForm.resetOriginalValues();

		return istanzaForm;
	}

	/**
	 * Returns the istanza form with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the istanza form
	 * @return the istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIstanzaFormException {

		IstanzaForm istanzaForm = fetchByPrimaryKey(primaryKey);

		if (istanzaForm == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIstanzaFormException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return istanzaForm;
	}

	/**
	 * Returns the istanza form with the primary key or throws a <code>NoSuchIstanzaFormException</code> if it could not be found.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form
	 * @throws NoSuchIstanzaFormException if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm findByPrimaryKey(long istanzaFormId)
		throws NoSuchIstanzaFormException {

		return findByPrimaryKey((Serializable)istanzaFormId);
	}

	/**
	 * Returns the istanza form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param istanzaFormId the primary key of the istanza form
	 * @return the istanza form, or <code>null</code> if a istanza form with the primary key could not be found
	 */
	@Override
	public IstanzaForm fetchByPrimaryKey(long istanzaFormId) {
		return fetchByPrimaryKey((Serializable)istanzaFormId);
	}

	/**
	 * Returns all the istanza forms.
	 *
	 * @return the istanza forms
	 */
	@Override
	public List<IstanzaForm> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @return the range of istanza forms
	 */
	@Override
	public List<IstanzaForm> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of istanza forms
	 */
	@Override
	public List<IstanzaForm> findAll(
		int start, int end, OrderByComparator<IstanzaForm> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the istanza forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IstanzaFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of istanza forms
	 * @param end the upper bound of the range of istanza forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of istanza forms
	 */
	@Override
	public List<IstanzaForm> findAll(
		int start, int end, OrderByComparator<IstanzaForm> orderByComparator,
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

		List<IstanzaForm> list = null;

		if (useFinderCache) {
			list = (List<IstanzaForm>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ISTANZAFORM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ISTANZAFORM;

				sql = sql.concat(IstanzaFormModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IstanzaForm>)QueryUtil.list(
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
	 * Removes all the istanza forms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IstanzaForm istanzaForm : findAll()) {
			remove(istanzaForm);
		}
	}

	/**
	 * Returns the number of istanza forms.
	 *
	 * @return the number of istanza forms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ISTANZAFORM);

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
		return "istanzaFormId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ISTANZAFORM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IstanzaFormModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the istanza form persistence.
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

		_finderPathFetchByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRichiestaId",
			new String[] {Long.class.getName()}, new String[] {"richiestaId"},
			true);

		_finderPathCountByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRichiestaId",
			new String[] {Long.class.getName()}, new String[] {"richiestaId"},
			false);

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

		_setIstanzaFormUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setIstanzaFormUtilPersistence(null);

		entityCache.removeCache(IstanzaFormImpl.class.getName());
	}

	private void _setIstanzaFormUtilPersistence(
		IstanzaFormPersistence istanzaFormPersistence) {

		try {
			Field field = IstanzaFormUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, istanzaFormPersistence);
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

	private static final String _SQL_SELECT_ISTANZAFORM =
		"SELECT istanzaForm FROM IstanzaForm istanzaForm";

	private static final String _SQL_SELECT_ISTANZAFORM_WHERE =
		"SELECT istanzaForm FROM IstanzaForm istanzaForm WHERE ";

	private static final String _SQL_COUNT_ISTANZAFORM =
		"SELECT COUNT(istanzaForm) FROM IstanzaForm istanzaForm";

	private static final String _SQL_COUNT_ISTANZAFORM_WHERE =
		"SELECT COUNT(istanzaForm) FROM IstanzaForm istanzaForm WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "istanzaForm.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IstanzaForm exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No IstanzaForm exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IstanzaFormPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private IstanzaFormModelArgumentsResolver
		_istanzaFormModelArgumentsResolver;

}