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

package it.servizidigitali.gestionepagamenti.service.persistence.impl;

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

import it.servizidigitali.gestionepagamenti.exception.NoSuchPagamentoException;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestionepagamenti.model.PagamentoTable;
import it.servizidigitali.gestionepagamenti.model.impl.PagamentoImpl;
import it.servizidigitali.gestionepagamenti.model.impl.PagamentoModelImpl;
import it.servizidigitali.gestionepagamenti.service.persistence.PagamentoPersistence;
import it.servizidigitali.gestionepagamenti.service.persistence.PagamentoUtil;
import it.servizidigitali.gestionepagamenti.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the pagamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PagamentoPersistence.class, BasePersistence.class})
public class PagamentoPersistenceImpl
	extends BasePersistenceImpl<Pagamento> implements PagamentoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PagamentoUtil</code> to access the pagamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PagamentoImpl.class.getName();

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
	 * Returns all the pagamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
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

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!uuid.equals(pagamento.getUuid())) {
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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByUuid_First(
			String uuid, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByUuid_First(uuid, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByUuid_First(
		String uuid, OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByUuid_Last(
			String uuid, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByUuid_Last(uuid, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByUuid_Last(
		String uuid, OrderByComparator<Pagamento> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByUuid_PrevAndNext(
			long pagamentoId, String uuid,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		uuid = Objects.toString(uuid, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, pagamento, uuid, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByUuid_PrevAndNext(
				session, pagamento, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByUuid_PrevAndNext(
		Session session, Pagamento pagamento, String uuid,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Pagamento pagamento :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

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
		"pagamento.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(pagamento.uuid IS NULL OR pagamento.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByUUID_G(String uuid, long groupId)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByUUID_G(uuid, groupId);

		if (pagamento == null) {
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

			throw new NoSuchPagamentoException(sb.toString());
		}

		return pagamento;
	}

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByUUID_G(
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

		if (result instanceof Pagamento) {
			Pagamento pagamento = (Pagamento)result;

			if (!Objects.equals(uuid, pagamento.getUuid()) ||
				(groupId != pagamento.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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

				List<Pagamento> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Pagamento pagamento = list.get(0);

					result = pagamento;

					cacheResult(pagamento);
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
			return (Pagamento)result;
		}
	}

	/**
	 * Removes the pagamento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pagamento that was removed
	 */
	@Override
	public Pagamento removeByUUID_G(String uuid, long groupId)
		throws NoSuchPagamentoException {

		Pagamento pagamento = findByUUID_G(uuid, groupId);

		return remove(pagamento);
	}

	/**
	 * Returns the number of pagamentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

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
		"pagamento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(pagamento.uuid IS NULL OR pagamento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"pagamento.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
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

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!uuid.equals(pagamento.getUuid()) ||
						(companyId != pagamento.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Pagamento> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByUuid_C_PrevAndNext(
			long pagamentoId, String uuid, long companyId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		uuid = Objects.toString(uuid, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, pagamento, uuid, companyId, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByUuid_C_PrevAndNext(
				session, pagamento, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByUuid_C_PrevAndNext(
		Session session, Pagamento pagamento, String uuid, long companyId,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Pagamento pagamento :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

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
		"pagamento.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(pagamento.uuid IS NULL OR pagamento.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"pagamento.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByIdCredito;
	private FinderPath _finderPathWithoutPaginationFindByIdCredito;
	private FinderPath _finderPathCountByIdCredito;

	/**
	 * Returns all the pagamentos where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdCredito(String idCredito) {
		return findByIdCredito(
			idCredito, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where idCredito = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idCredito the id credito
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdCredito(
		String idCredito, int start, int end) {

		return findByIdCredito(idCredito, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where idCredito = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idCredito the id credito
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdCredito(
		String idCredito, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByIdCredito(idCredito, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where idCredito = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idCredito the id credito
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdCredito(
		String idCredito, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		idCredito = Objects.toString(idCredito, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIdCredito;
				finderArgs = new Object[] {idCredito};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIdCredito;
			finderArgs = new Object[] {
				idCredito, start, end, orderByComparator
			};
		}

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!idCredito.equals(pagamento.getIdCredito())) {
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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindIdCredito = false;

			if (idCredito.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDCREDITO_IDCREDITO_3);
			}
			else {
				bindIdCredito = true;

				sb.append(_FINDER_COLUMN_IDCREDITO_IDCREDITO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdCredito) {
					queryPos.add(idCredito);
				}

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdCredito_First(
			String idCredito, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdCredito_First(
			idCredito, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idCredito=");
		sb.append(idCredito);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdCredito_First(
		String idCredito, OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByIdCredito(
			idCredito, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdCredito_Last(
			String idCredito, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdCredito_Last(
			idCredito, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idCredito=");
		sb.append(idCredito);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdCredito_Last(
		String idCredito, OrderByComparator<Pagamento> orderByComparator) {

		int count = countByIdCredito(idCredito);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByIdCredito(
			idCredito, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByIdCredito_PrevAndNext(
			long pagamentoId, String idCredito,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		idCredito = Objects.toString(idCredito, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByIdCredito_PrevAndNext(
				session, pagamento, idCredito, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByIdCredito_PrevAndNext(
				session, pagamento, idCredito, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByIdCredito_PrevAndNext(
		Session session, Pagamento pagamento, String idCredito,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

		boolean bindIdCredito = false;

		if (idCredito.isEmpty()) {
			sb.append(_FINDER_COLUMN_IDCREDITO_IDCREDITO_3);
		}
		else {
			bindIdCredito = true;

			sb.append(_FINDER_COLUMN_IDCREDITO_IDCREDITO_2);
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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdCredito) {
			queryPos.add(idCredito);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where idCredito = &#63; from the database.
	 *
	 * @param idCredito the id credito
	 */
	@Override
	public void removeByIdCredito(String idCredito) {
		for (Pagamento pagamento :
				findByIdCredito(
					idCredito, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByIdCredito(String idCredito) {
		idCredito = Objects.toString(idCredito, "");

		FinderPath finderPath = _finderPathCountByIdCredito;

		Object[] finderArgs = new Object[] {idCredito};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindIdCredito = false;

			if (idCredito.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDCREDITO_IDCREDITO_3);
			}
			else {
				bindIdCredito = true;

				sb.append(_FINDER_COLUMN_IDCREDITO_IDCREDITO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdCredito) {
					queryPos.add(idCredito);
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

	private static final String _FINDER_COLUMN_IDCREDITO_IDCREDITO_2 =
		"pagamento.idCredito = ?";

	private static final String _FINDER_COLUMN_IDCREDITO_IDCREDITO_3 =
		"(pagamento.idCredito IS NULL OR pagamento.idCredito = '')";

	private FinderPath _finderPathWithPaginationFindByIdFiscaleCliente;
	private FinderPath _finderPathWithoutPaginationFindByIdFiscaleCliente;
	private FinderPath _finderPathCountByIdFiscaleCliente;

	/**
	 * Returns all the pagamentos where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleCliente(String idFiscaleCliente) {
		return findByIdFiscaleCliente(
			idFiscaleCliente, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where idFiscaleCliente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end) {

		return findByIdFiscaleCliente(idFiscaleCliente, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where idFiscaleCliente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByIdFiscaleCliente(
			idFiscaleCliente, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where idFiscaleCliente = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		idFiscaleCliente = Objects.toString(idFiscaleCliente, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIdFiscaleCliente;
				finderArgs = new Object[] {idFiscaleCliente};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIdFiscaleCliente;
			finderArgs = new Object[] {
				idFiscaleCliente, start, end, orderByComparator
			};
		}

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!idFiscaleCliente.equals(
							pagamento.getIdFiscaleCliente())) {

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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindIdFiscaleCliente = false;

			if (idFiscaleCliente.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_3);
			}
			else {
				bindIdFiscaleCliente = true;

				sb.append(_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdFiscaleCliente) {
					queryPos.add(idFiscaleCliente);
				}

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdFiscaleCliente_First(
			String idFiscaleCliente,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdFiscaleCliente_First(
			idFiscaleCliente, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idFiscaleCliente=");
		sb.append(idFiscaleCliente);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdFiscaleCliente_First(
		String idFiscaleCliente,
		OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByIdFiscaleCliente(
			idFiscaleCliente, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdFiscaleCliente_Last(
			String idFiscaleCliente,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdFiscaleCliente_Last(
			idFiscaleCliente, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idFiscaleCliente=");
		sb.append(idFiscaleCliente);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdFiscaleCliente_Last(
		String idFiscaleCliente,
		OrderByComparator<Pagamento> orderByComparator) {

		int count = countByIdFiscaleCliente(idFiscaleCliente);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByIdFiscaleCliente(
			idFiscaleCliente, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByIdFiscaleCliente_PrevAndNext(
			long pagamentoId, String idFiscaleCliente,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		idFiscaleCliente = Objects.toString(idFiscaleCliente, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByIdFiscaleCliente_PrevAndNext(
				session, pagamento, idFiscaleCliente, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByIdFiscaleCliente_PrevAndNext(
				session, pagamento, idFiscaleCliente, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByIdFiscaleCliente_PrevAndNext(
		Session session, Pagamento pagamento, String idFiscaleCliente,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

		boolean bindIdFiscaleCliente = false;

		if (idFiscaleCliente.isEmpty()) {
			sb.append(_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_3);
		}
		else {
			bindIdFiscaleCliente = true;

			sb.append(_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_2);
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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdFiscaleCliente) {
			queryPos.add(idFiscaleCliente);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where idFiscaleCliente = &#63; from the database.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 */
	@Override
	public void removeByIdFiscaleCliente(String idFiscaleCliente) {
		for (Pagamento pagamento :
				findByIdFiscaleCliente(
					idFiscaleCliente, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByIdFiscaleCliente(String idFiscaleCliente) {
		idFiscaleCliente = Objects.toString(idFiscaleCliente, "");

		FinderPath finderPath = _finderPathCountByIdFiscaleCliente;

		Object[] finderArgs = new Object[] {idFiscaleCliente};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindIdFiscaleCliente = false;

			if (idFiscaleCliente.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_3);
			}
			else {
				bindIdFiscaleCliente = true;

				sb.append(_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdFiscaleCliente) {
					queryPos.add(idFiscaleCliente);
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

	private static final String
		_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_2 =
			"pagamento.idFiscaleCliente = ?";

	private static final String
		_FINDER_COLUMN_IDFISCALECLIENTE_IDFISCALECLIENTE_3 =
			"(pagamento.idFiscaleCliente IS NULL OR pagamento.idFiscaleCliente = '')";

	private FinderPath _finderPathWithPaginationFindByIdFiscaleClienteGroupId;
	private FinderPath
		_finderPathWithoutPaginationFindByIdFiscaleClienteGroupId;
	private FinderPath _finderPathCountByIdFiscaleClienteGroupId;

	/**
	 * Returns all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId) {

		return findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end) {

		return findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		idFiscaleCliente = Objects.toString(idFiscaleCliente, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByIdFiscaleClienteGroupId;
				finderArgs = new Object[] {idFiscaleCliente, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIdFiscaleClienteGroupId;
			finderArgs = new Object[] {
				idFiscaleCliente, groupId, start, end, orderByComparator
			};
		}

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!idFiscaleCliente.equals(
							pagamento.getIdFiscaleCliente()) ||
						(groupId != pagamento.getGroupId())) {

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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindIdFiscaleCliente = false;

			if (idFiscaleCliente.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_3);
			}
			else {
				bindIdFiscaleCliente = true;

				sb.append(
					_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_2);
			}

			sb.append(_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdFiscaleCliente) {
					queryPos.add(idFiscaleCliente);
				}

				queryPos.add(groupId);

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdFiscaleClienteGroupId_First(
			String idFiscaleCliente, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdFiscaleClienteGroupId_First(
			idFiscaleCliente, groupId, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idFiscaleCliente=");
		sb.append(idFiscaleCliente);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdFiscaleClienteGroupId_First(
		String idFiscaleCliente, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdFiscaleClienteGroupId_Last(
			String idFiscaleCliente, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdFiscaleClienteGroupId_Last(
			idFiscaleCliente, groupId, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("idFiscaleCliente=");
		sb.append(idFiscaleCliente);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdFiscaleClienteGroupId_Last(
		String idFiscaleCliente, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		int count = countByIdFiscaleClienteGroupId(idFiscaleCliente, groupId);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByIdFiscaleClienteGroupId_PrevAndNext(
			long pagamentoId, String idFiscaleCliente, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		idFiscaleCliente = Objects.toString(idFiscaleCliente, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByIdFiscaleClienteGroupId_PrevAndNext(
				session, pagamento, idFiscaleCliente, groupId,
				orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByIdFiscaleClienteGroupId_PrevAndNext(
				session, pagamento, idFiscaleCliente, groupId,
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

	protected Pagamento getByIdFiscaleClienteGroupId_PrevAndNext(
		Session session, Pagamento pagamento, String idFiscaleCliente,
		long groupId, OrderByComparator<Pagamento> orderByComparator,
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

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

		boolean bindIdFiscaleCliente = false;

		if (idFiscaleCliente.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_3);
		}
		else {
			bindIdFiscaleCliente = true;

			sb.append(
				_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_2);
		}

		sb.append(_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_GROUPID_2);

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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIdFiscaleCliente) {
			queryPos.add(idFiscaleCliente);
		}

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63; from the database.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 */
	@Override
	public void removeByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId) {

		for (Pagamento pagamento :
				findByIdFiscaleClienteGroupId(
					idFiscaleCliente, groupId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId) {

		idFiscaleCliente = Objects.toString(idFiscaleCliente, "");

		FinderPath finderPath = _finderPathCountByIdFiscaleClienteGroupId;

		Object[] finderArgs = new Object[] {idFiscaleCliente, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindIdFiscaleCliente = false;

			if (idFiscaleCliente.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_3);
			}
			else {
				bindIdFiscaleCliente = true;

				sb.append(
					_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_2);
			}

			sb.append(_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdFiscaleCliente) {
					queryPos.add(idFiscaleCliente);
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
		_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_2 =
			"pagamento.idFiscaleCliente = ? AND ";

	private static final String
		_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_IDFISCALECLIENTE_3 =
			"(pagamento.idFiscaleCliente IS NULL OR pagamento.idFiscaleCliente = '') AND ";

	private static final String
		_FINDER_COLUMN_IDFISCALECLIENTEGROUPID_GROUPID_2 =
			"pagamento.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByEmailInviata;
	private FinderPath _finderPathWithoutPaginationFindByEmailInviata;
	private FinderPath _finderPathCountByEmailInviata;

	/**
	 * Returns all the pagamentos where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByEmailInviata(boolean emailInviata) {
		return findByEmailInviata(
			emailInviata, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where emailInviata = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param emailInviata the email inviata
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end) {

		return findByEmailInviata(emailInviata, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where emailInviata = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param emailInviata the email inviata
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByEmailInviata(
			emailInviata, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where emailInviata = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param emailInviata the email inviata
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmailInviata;
				finderArgs = new Object[] {emailInviata};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmailInviata;
			finderArgs = new Object[] {
				emailInviata, start, end, orderByComparator
			};
		}

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (emailInviata != pagamento.isEmailInviata()) {
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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			sb.append(_FINDER_COLUMN_EMAILINVIATA_EMAILINVIATA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(emailInviata);

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByEmailInviata_First(
			boolean emailInviata,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByEmailInviata_First(
			emailInviata, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailInviata=");
		sb.append(emailInviata);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByEmailInviata_First(
		boolean emailInviata, OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByEmailInviata(
			emailInviata, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByEmailInviata_Last(
			boolean emailInviata,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByEmailInviata_Last(
			emailInviata, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailInviata=");
		sb.append(emailInviata);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByEmailInviata_Last(
		boolean emailInviata, OrderByComparator<Pagamento> orderByComparator) {

		int count = countByEmailInviata(emailInviata);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByEmailInviata(
			emailInviata, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByEmailInviata_PrevAndNext(
			long pagamentoId, boolean emailInviata,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByEmailInviata_PrevAndNext(
				session, pagamento, emailInviata, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByEmailInviata_PrevAndNext(
				session, pagamento, emailInviata, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByEmailInviata_PrevAndNext(
		Session session, Pagamento pagamento, boolean emailInviata,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

		sb.append(_FINDER_COLUMN_EMAILINVIATA_EMAILINVIATA_2);

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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(emailInviata);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where emailInviata = &#63; from the database.
	 *
	 * @param emailInviata the email inviata
	 */
	@Override
	public void removeByEmailInviata(boolean emailInviata) {
		for (Pagamento pagamento :
				findByEmailInviata(
					emailInviata, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByEmailInviata(boolean emailInviata) {
		FinderPath finderPath = _finderPathCountByEmailInviata;

		Object[] finderArgs = new Object[] {emailInviata};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			sb.append(_FINDER_COLUMN_EMAILINVIATA_EMAILINVIATA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(emailInviata);

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

	private static final String _FINDER_COLUMN_EMAILINVIATA_EMAILINVIATA_2 =
		"pagamento.emailInviata = ?";

	private FinderPath _finderPathWithPaginationFindByIud;
	private FinderPath _finderPathWithoutPaginationFindByIud;
	private FinderPath _finderPathCountByIud;

	/**
	 * Returns all the pagamentos where iud = &#63;.
	 *
	 * @param iud the iud
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIud(String iud) {
		return findByIud(iud, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where iud = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param iud the iud
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIud(String iud, int start, int end) {
		return findByIud(iud, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where iud = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param iud the iud
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIud(
		String iud, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByIud(iud, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where iud = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param iud the iud
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByIud(
		String iud, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		iud = Objects.toString(iud, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIud;
				finderArgs = new Object[] {iud};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIud;
			finderArgs = new Object[] {iud, start, end, orderByComparator};
		}

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!iud.equals(pagamento.getIud())) {
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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindIud = false;

			if (iud.isEmpty()) {
				sb.append(_FINDER_COLUMN_IUD_IUD_3);
			}
			else {
				bindIud = true;

				sb.append(_FINDER_COLUMN_IUD_IUD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIud) {
					queryPos.add(iud);
				}

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIud_First(
			String iud, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIud_First(iud, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("iud=");
		sb.append(iud);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIud_First(
		String iud, OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByIud(iud, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIud_Last(
			String iud, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIud_Last(iud, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("iud=");
		sb.append(iud);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIud_Last(
		String iud, OrderByComparator<Pagamento> orderByComparator) {

		int count = countByIud(iud);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByIud(
			iud, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where iud = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByIud_PrevAndNext(
			long pagamentoId, String iud,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		iud = Objects.toString(iud, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByIud_PrevAndNext(
				session, pagamento, iud, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByIud_PrevAndNext(
				session, pagamento, iud, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByIud_PrevAndNext(
		Session session, Pagamento pagamento, String iud,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

		boolean bindIud = false;

		if (iud.isEmpty()) {
			sb.append(_FINDER_COLUMN_IUD_IUD_3);
		}
		else {
			bindIud = true;

			sb.append(_FINDER_COLUMN_IUD_IUD_2);
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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIud) {
			queryPos.add(iud);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where iud = &#63; from the database.
	 *
	 * @param iud the iud
	 */
	@Override
	public void removeByIud(String iud) {
		for (Pagamento pagamento :
				findByIud(iud, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where iud = &#63;.
	 *
	 * @param iud the iud
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByIud(String iud) {
		iud = Objects.toString(iud, "");

		FinderPath finderPath = _finderPathCountByIud;

		Object[] finderArgs = new Object[] {iud};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindIud = false;

			if (iud.isEmpty()) {
				sb.append(_FINDER_COLUMN_IUD_IUD_3);
			}
			else {
				bindIud = true;

				sb.append(_FINDER_COLUMN_IUD_IUD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIud) {
					queryPos.add(iud);
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

	private static final String _FINDER_COLUMN_IUD_IUD_2 = "pagamento.iud = ?";

	private static final String _FINDER_COLUMN_IUD_IUD_3 =
		"(pagamento.iud IS NULL OR pagamento.iud = '')";

	private FinderPath _finderPathFetchByIuv;
	private FinderPath _finderPathCountByIuv;

	/**
	 * Returns the pagamento where iuv = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param iuv the iuv
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIuv(String iuv) throws NoSuchPagamentoException {
		Pagamento pagamento = fetchByIuv(iuv);

		if (pagamento == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("iuv=");
			sb.append(iuv);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPagamentoException(sb.toString());
		}

		return pagamento;
	}

	/**
	 * Returns the pagamento where iuv = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param iuv the iuv
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIuv(String iuv) {
		return fetchByIuv(iuv, true);
	}

	/**
	 * Returns the pagamento where iuv = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param iuv the iuv
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIuv(String iuv, boolean useFinderCache) {
		iuv = Objects.toString(iuv, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {iuv};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByIuv, finderArgs);
		}

		if (result instanceof Pagamento) {
			Pagamento pagamento = (Pagamento)result;

			if (!Objects.equals(iuv, pagamento.getIuv())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindIuv = false;

			if (iuv.isEmpty()) {
				sb.append(_FINDER_COLUMN_IUV_IUV_3);
			}
			else {
				bindIuv = true;

				sb.append(_FINDER_COLUMN_IUV_IUV_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIuv) {
					queryPos.add(iuv);
				}

				List<Pagamento> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByIuv, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {iuv};
							}

							_log.warn(
								"PagamentoPersistenceImpl.fetchByIuv(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Pagamento pagamento = list.get(0);

					result = pagamento;

					cacheResult(pagamento);
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
			return (Pagamento)result;
		}
	}

	/**
	 * Removes the pagamento where iuv = &#63; from the database.
	 *
	 * @param iuv the iuv
	 * @return the pagamento that was removed
	 */
	@Override
	public Pagamento removeByIuv(String iuv) throws NoSuchPagamentoException {
		Pagamento pagamento = findByIuv(iuv);

		return remove(pagamento);
	}

	/**
	 * Returns the number of pagamentos where iuv = &#63;.
	 *
	 * @param iuv the iuv
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByIuv(String iuv) {
		iuv = Objects.toString(iuv, "");

		FinderPath finderPath = _finderPathCountByIuv;

		Object[] finderArgs = new Object[] {iuv};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindIuv = false;

			if (iuv.isEmpty()) {
				sb.append(_FINDER_COLUMN_IUV_IUV_3);
			}
			else {
				bindIuv = true;

				sb.append(_FINDER_COLUMN_IUV_IUV_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIuv) {
					queryPos.add(iuv);
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

	private static final String _FINDER_COLUMN_IUV_IUV_2 = "pagamento.iuv = ?";

	private static final String _FINDER_COLUMN_IUV_IUV_3 =
		"(pagamento.iuv IS NULL OR pagamento.iuv = '')";

	private FinderPath _finderPathFetchByIdSessione;
	private FinderPath _finderPathCountByIdSessione;

	/**
	 * Returns the pagamento where idSessione = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param idSessione the id sessione
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByIdSessione(String idSessione)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByIdSessione(idSessione);

		if (pagamento == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("idSessione=");
			sb.append(idSessione);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPagamentoException(sb.toString());
		}

		return pagamento;
	}

	/**
	 * Returns the pagamento where idSessione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idSessione the id sessione
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdSessione(String idSessione) {
		return fetchByIdSessione(idSessione, true);
	}

	/**
	 * Returns the pagamento where idSessione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idSessione the id sessione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByIdSessione(
		String idSessione, boolean useFinderCache) {

		idSessione = Objects.toString(idSessione, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {idSessione};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByIdSessione, finderArgs);
		}

		if (result instanceof Pagamento) {
			Pagamento pagamento = (Pagamento)result;

			if (!Objects.equals(idSessione, pagamento.getIdSessione())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindIdSessione = false;

			if (idSessione.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDSESSIONE_IDSESSIONE_3);
			}
			else {
				bindIdSessione = true;

				sb.append(_FINDER_COLUMN_IDSESSIONE_IDSESSIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdSessione) {
					queryPos.add(idSessione);
				}

				List<Pagamento> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByIdSessione, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {idSessione};
							}

							_log.warn(
								"PagamentoPersistenceImpl.fetchByIdSessione(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Pagamento pagamento = list.get(0);

					result = pagamento;

					cacheResult(pagamento);
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
			return (Pagamento)result;
		}
	}

	/**
	 * Removes the pagamento where idSessione = &#63; from the database.
	 *
	 * @param idSessione the id sessione
	 * @return the pagamento that was removed
	 */
	@Override
	public Pagamento removeByIdSessione(String idSessione)
		throws NoSuchPagamentoException {

		Pagamento pagamento = findByIdSessione(idSessione);

		return remove(pagamento);
	}

	/**
	 * Returns the number of pagamentos where idSessione = &#63;.
	 *
	 * @param idSessione the id sessione
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByIdSessione(String idSessione) {
		idSessione = Objects.toString(idSessione, "");

		FinderPath finderPath = _finderPathCountByIdSessione;

		Object[] finderArgs = new Object[] {idSessione};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindIdSessione = false;

			if (idSessione.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDSESSIONE_IDSESSIONE_3);
			}
			else {
				bindIdSessione = true;

				sb.append(_FINDER_COLUMN_IDSESSIONE_IDSESSIONE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdSessione) {
					queryPos.add(idSessione);
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

	private static final String _FINDER_COLUMN_IDSESSIONE_IDSESSIONE_2 =
		"pagamento.idSessione = ?";

	private static final String _FINDER_COLUMN_IDSESSIONE_IDSESSIONE_3 =
		"(pagamento.idSessione IS NULL OR pagamento.idSessione = '')";

	private FinderPath _finderPathFetchByRichiestaId;
	private FinderPath _finderPathCountByRichiestaId;

	/**
	 * Returns the pagamento where richiestaId = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByRichiestaId(long richiestaId)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByRichiestaId(richiestaId);

		if (pagamento == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("richiestaId=");
			sb.append(richiestaId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPagamentoException(sb.toString());
		}

		return pagamento;
	}

	/**
	 * Returns the pagamento where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByRichiestaId(long richiestaId) {
		return fetchByRichiestaId(richiestaId, true);
	}

	/**
	 * Returns the pagamento where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByRichiestaId(
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

		if (result instanceof Pagamento) {
			Pagamento pagamento = (Pagamento)result;

			if (richiestaId != pagamento.getRichiestaId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			sb.append(_FINDER_COLUMN_RICHIESTAID_RICHIESTAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(richiestaId);

				List<Pagamento> list = query.list();

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
								"PagamentoPersistenceImpl.fetchByRichiestaId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Pagamento pagamento = list.get(0);

					result = pagamento;

					cacheResult(pagamento);
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
			return (Pagamento)result;
		}
	}

	/**
	 * Removes the pagamento where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the pagamento that was removed
	 */
	@Override
	public Pagamento removeByRichiestaId(long richiestaId)
		throws NoSuchPagamentoException {

		Pagamento pagamento = findByRichiestaId(richiestaId);

		return remove(pagamento);
	}

	/**
	 * Returns the number of pagamentos where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByRichiestaId(long richiestaId) {
		FinderPath finderPath = _finderPathCountByRichiestaId;

		Object[] finderArgs = new Object[] {richiestaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

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
		"pagamento.richiestaId = ?";

	private FinderPath _finderPathWithPaginationFindByStato;
	private FinderPath _finderPathWithoutPaginationFindByStato;
	private FinderPath _finderPathCountByStato;

	/**
	 * Returns all the pagamentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStato(String stato) {
		return findByStato(stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStato(String stato, int start, int end) {
		return findByStato(stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStato(
		String stato, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByStato(stato, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStato(
		String stato, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
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

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!stato.equals(pagamento.getStato())) {
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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByStato_First(
			String stato, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByStato_First(stato, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByStato_First(
		String stato, OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByStato(stato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByStato_Last(
			String stato, OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByStato_Last(stato, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByStato_Last(
		String stato, OrderByComparator<Pagamento> orderByComparator) {

		int count = countByStato(stato);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByStato(
			stato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where stato = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByStato_PrevAndNext(
			long pagamentoId, String stato,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		stato = Objects.toString(stato, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByStato_PrevAndNext(
				session, pagamento, stato, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByStato_PrevAndNext(
				session, pagamento, stato, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByStato_PrevAndNext(
		Session session, Pagamento pagamento, String stato,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	@Override
	public void removeByStato(String stato) {
		for (Pagamento pagamento :
				findByStato(
					stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByStato(String stato) {
		stato = Objects.toString(stato, "");

		FinderPath finderPath = _finderPathCountByStato;

		Object[] finderArgs = new Object[] {stato};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

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
		"pagamento.stato = ?";

	private static final String _FINDER_COLUMN_STATO_STATO_3 =
		"(pagamento.stato IS NULL OR pagamento.stato = '')";

	private FinderPath _finderPathWithPaginationFindByStatoGroupId;
	private FinderPath _finderPathWithoutPaginationFindByStatoGroupId;
	private FinderPath _finderPathCountByStatoGroupId;

	/**
	 * Returns all the pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @return the matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStatoGroupId(String stato, long groupId) {
		return findByStatoGroupId(
			stato, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end) {

		return findByStatoGroupId(stato, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return findByStatoGroupId(
			stato, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pagamentos
	 */
	@Override
	public List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		stato = Objects.toString(stato, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatoGroupId;
				finderArgs = new Object[] {stato, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatoGroupId;
			finderArgs = new Object[] {
				stato, groupId, start, end, orderByComparator
			};
		}

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Pagamento pagamento : list) {
					if (!stato.equals(pagamento.getStato()) ||
						(groupId != pagamento.getGroupId())) {

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

			sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

			boolean bindStato = false;

			if (stato.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATOGROUPID_STATO_3);
			}
			else {
				bindStato = true;

				sb.append(_FINDER_COLUMN_STATOGROUPID_STATO_2);
			}

			sb.append(_FINDER_COLUMN_STATOGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(groupId);

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Returns the first pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByStatoGroupId_First(
			String stato, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByStatoGroupId_First(
			stato, groupId, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByStatoGroupId_First(
		String stato, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		List<Pagamento> list = findByStatoGroupId(
			stato, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	@Override
	public Pagamento findByStatoGroupId_Last(
			String stato, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByStatoGroupId_Last(
			stato, groupId, orderByComparator);

		if (pagamento != null) {
			return pagamento;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stato=");
		sb.append(stato);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPagamentoException(sb.toString());
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	@Override
	public Pagamento fetchByStatoGroupId_Last(
		String stato, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		int count = countByStatoGroupId(stato, groupId);

		if (count == 0) {
			return null;
		}

		List<Pagamento> list = findByStatoGroupId(
			stato, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento[] findByStatoGroupId_PrevAndNext(
			long pagamentoId, String stato, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws NoSuchPagamentoException {

		stato = Objects.toString(stato, "");

		Pagamento pagamento = findByPrimaryKey(pagamentoId);

		Session session = null;

		try {
			session = openSession();

			Pagamento[] array = new PagamentoImpl[3];

			array[0] = getByStatoGroupId_PrevAndNext(
				session, pagamento, stato, groupId, orderByComparator, true);

			array[1] = pagamento;

			array[2] = getByStatoGroupId_PrevAndNext(
				session, pagamento, stato, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Pagamento getByStatoGroupId_PrevAndNext(
		Session session, Pagamento pagamento, String stato, long groupId,
		OrderByComparator<Pagamento> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PAGAMENTO_WHERE);

		boolean bindStato = false;

		if (stato.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATOGROUPID_STATO_3);
		}
		else {
			bindStato = true;

			sb.append(_FINDER_COLUMN_STATOGROUPID_STATO_2);
		}

		sb.append(_FINDER_COLUMN_STATOGROUPID_GROUPID_2);

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
			sb.append(PagamentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStato) {
			queryPos.add(stato);
		}

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pagamento)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Pagamento> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pagamentos where stato = &#63; and groupId = &#63; from the database.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 */
	@Override
	public void removeByStatoGroupId(String stato, long groupId) {
		for (Pagamento pagamento :
				findByStatoGroupId(
					stato, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	@Override
	public int countByStatoGroupId(String stato, long groupId) {
		stato = Objects.toString(stato, "");

		FinderPath finderPath = _finderPathCountByStatoGroupId;

		Object[] finderArgs = new Object[] {stato, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAGAMENTO_WHERE);

			boolean bindStato = false;

			if (stato.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATOGROUPID_STATO_3);
			}
			else {
				bindStato = true;

				sb.append(_FINDER_COLUMN_STATOGROUPID_STATO_2);
			}

			sb.append(_FINDER_COLUMN_STATOGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStato) {
					queryPos.add(stato);
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

	private static final String _FINDER_COLUMN_STATOGROUPID_STATO_2 =
		"pagamento.stato = ? AND ";

	private static final String _FINDER_COLUMN_STATOGROUPID_STATO_3 =
		"(pagamento.stato IS NULL OR pagamento.stato = '') AND ";

	private static final String _FINDER_COLUMN_STATOGROUPID_GROUPID_2 =
		"pagamento.groupId = ?";

	public PagamentoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Pagamento.class);

		setModelImplClass(PagamentoImpl.class);
		setModelPKClass(long.class);

		setTable(PagamentoTable.INSTANCE);
	}

	/**
	 * Caches the pagamento in the entity cache if it is enabled.
	 *
	 * @param pagamento the pagamento
	 */
	@Override
	public void cacheResult(Pagamento pagamento) {
		entityCache.putResult(
			PagamentoImpl.class, pagamento.getPrimaryKey(), pagamento);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {pagamento.getUuid(), pagamento.getGroupId()},
			pagamento);

		finderCache.putResult(
			_finderPathFetchByIuv, new Object[] {pagamento.getIuv()},
			pagamento);

		finderCache.putResult(
			_finderPathFetchByIdSessione,
			new Object[] {pagamento.getIdSessione()}, pagamento);

		finderCache.putResult(
			_finderPathFetchByRichiestaId,
			new Object[] {pagamento.getRichiestaId()}, pagamento);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pagamentos in the entity cache if it is enabled.
	 *
	 * @param pagamentos the pagamentos
	 */
	@Override
	public void cacheResult(List<Pagamento> pagamentos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pagamentos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Pagamento pagamento : pagamentos) {
			if (entityCache.getResult(
					PagamentoImpl.class, pagamento.getPrimaryKey()) == null) {

				cacheResult(pagamento);
			}
		}
	}

	/**
	 * Clears the cache for all pagamentos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PagamentoImpl.class);

		finderCache.clearCache(PagamentoImpl.class);
	}

	/**
	 * Clears the cache for the pagamento.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pagamento pagamento) {
		entityCache.removeResult(PagamentoImpl.class, pagamento);
	}

	@Override
	public void clearCache(List<Pagamento> pagamentos) {
		for (Pagamento pagamento : pagamentos) {
			entityCache.removeResult(PagamentoImpl.class, pagamento);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PagamentoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PagamentoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PagamentoModelImpl pagamentoModelImpl) {

		Object[] args = new Object[] {
			pagamentoModelImpl.getUuid(), pagamentoModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, pagamentoModelImpl);

		args = new Object[] {pagamentoModelImpl.getIuv()};

		finderCache.putResult(_finderPathCountByIuv, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByIuv, args, pagamentoModelImpl);

		args = new Object[] {pagamentoModelImpl.getIdSessione()};

		finderCache.putResult(
			_finderPathCountByIdSessione, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByIdSessione, args, pagamentoModelImpl);

		args = new Object[] {pagamentoModelImpl.getRichiestaId()};

		finderCache.putResult(
			_finderPathCountByRichiestaId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByRichiestaId, args, pagamentoModelImpl);
	}

	/**
	 * Creates a new pagamento with the primary key. Does not add the pagamento to the database.
	 *
	 * @param pagamentoId the primary key for the new pagamento
	 * @return the new pagamento
	 */
	@Override
	public Pagamento create(long pagamentoId) {
		Pagamento pagamento = new PagamentoImpl();

		pagamento.setNew(true);
		pagamento.setPrimaryKey(pagamentoId);

		String uuid = PortalUUIDUtil.generate();

		pagamento.setUuid(uuid);

		pagamento.setCompanyId(CompanyThreadLocal.getCompanyId());

		return pagamento;
	}

	/**
	 * Removes the pagamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento that was removed
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento remove(long pagamentoId) throws NoSuchPagamentoException {
		return remove((Serializable)pagamentoId);
	}

	/**
	 * Removes the pagamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pagamento
	 * @return the pagamento that was removed
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento remove(Serializable primaryKey)
		throws NoSuchPagamentoException {

		Session session = null;

		try {
			session = openSession();

			Pagamento pagamento = (Pagamento)session.get(
				PagamentoImpl.class, primaryKey);

			if (pagamento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPagamentoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pagamento);
		}
		catch (NoSuchPagamentoException noSuchEntityException) {
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
	protected Pagamento removeImpl(Pagamento pagamento) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pagamento)) {
				pagamento = (Pagamento)session.get(
					PagamentoImpl.class, pagamento.getPrimaryKeyObj());
			}

			if (pagamento != null) {
				session.delete(pagamento);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pagamento != null) {
			clearCache(pagamento);
		}

		return pagamento;
	}

	@Override
	public Pagamento updateImpl(Pagamento pagamento) {
		boolean isNew = pagamento.isNew();

		if (!(pagamento instanceof PagamentoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pagamento.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pagamento);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pagamento proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Pagamento implementation " +
					pagamento.getClass());
		}

		PagamentoModelImpl pagamentoModelImpl = (PagamentoModelImpl)pagamento;

		if (Validator.isNull(pagamento.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			pagamento.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (pagamento.getCreateDate() == null)) {
			if (serviceContext == null) {
				pagamento.setCreateDate(date);
			}
			else {
				pagamento.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!pagamentoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pagamento.setModifiedDate(date);
			}
			else {
				pagamento.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pagamento);
			}
			else {
				pagamento = (Pagamento)session.merge(pagamento);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PagamentoImpl.class, pagamentoModelImpl, false, true);

		cacheUniqueFindersCache(pagamentoModelImpl);

		if (isNew) {
			pagamento.setNew(false);
		}

		pagamento.resetOriginalValues();

		return pagamento;
	}

	/**
	 * Returns the pagamento with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pagamento
	 * @return the pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPagamentoException {

		Pagamento pagamento = fetchByPrimaryKey(primaryKey);

		if (pagamento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPagamentoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pagamento;
	}

	/**
	 * Returns the pagamento with the primary key or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento findByPrimaryKey(long pagamentoId)
		throws NoSuchPagamentoException {

		return findByPrimaryKey((Serializable)pagamentoId);
	}

	/**
	 * Returns the pagamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento, or <code>null</code> if a pagamento with the primary key could not be found
	 */
	@Override
	public Pagamento fetchByPrimaryKey(long pagamentoId) {
		return fetchByPrimaryKey((Serializable)pagamentoId);
	}

	/**
	 * Returns all the pagamentos.
	 *
	 * @return the pagamentos
	 */
	@Override
	public List<Pagamento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pagamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @return the range of pagamentos
	 */
	@Override
	public List<Pagamento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pagamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pagamentos
	 */
	@Override
	public List<Pagamento> findAll(
		int start, int end, OrderByComparator<Pagamento> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pagamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PagamentoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pagamentos
	 * @param end the upper bound of the range of pagamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pagamentos
	 */
	@Override
	public List<Pagamento> findAll(
		int start, int end, OrderByComparator<Pagamento> orderByComparator,
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

		List<Pagamento> list = null;

		if (useFinderCache) {
			list = (List<Pagamento>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAGAMENTO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAGAMENTO;

				sql = sql.concat(PagamentoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Pagamento>)QueryUtil.list(
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
	 * Removes all the pagamentos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Pagamento pagamento : findAll()) {
			remove(pagamento);
		}
	}

	/**
	 * Returns the number of pagamentos.
	 *
	 * @return the number of pagamentos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAGAMENTO);

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
		return "pagamentoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAGAMENTO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PagamentoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pagamento persistence.
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

		_finderPathWithPaginationFindByIdCredito = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdCredito",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idCredito"}, true);

		_finderPathWithoutPaginationFindByIdCredito = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdCredito",
			new String[] {String.class.getName()}, new String[] {"idCredito"},
			true);

		_finderPathCountByIdCredito = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdCredito",
			new String[] {String.class.getName()}, new String[] {"idCredito"},
			false);

		_finderPathWithPaginationFindByIdFiscaleCliente = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdFiscaleCliente",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"idFiscaleCliente"}, true);

		_finderPathWithoutPaginationFindByIdFiscaleCliente = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdFiscaleCliente",
			new String[] {String.class.getName()},
			new String[] {"idFiscaleCliente"}, true);

		_finderPathCountByIdFiscaleCliente = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdFiscaleCliente", new String[] {String.class.getName()},
			new String[] {"idFiscaleCliente"}, false);

		_finderPathWithPaginationFindByIdFiscaleClienteGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdFiscaleClienteGroupId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"idFiscaleCliente", "groupId"}, true);

		_finderPathWithoutPaginationFindByIdFiscaleClienteGroupId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByIdFiscaleClienteGroupId",
				new String[] {String.class.getName(), Long.class.getName()},
				new String[] {"idFiscaleCliente", "groupId"}, true);

		_finderPathCountByIdFiscaleClienteGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdFiscaleClienteGroupId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"idFiscaleCliente", "groupId"}, false);

		_finderPathWithPaginationFindByEmailInviata = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailInviata",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"emailInviata"}, true);

		_finderPathWithoutPaginationFindByEmailInviata = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailInviata",
			new String[] {Boolean.class.getName()},
			new String[] {"emailInviata"}, true);

		_finderPathCountByEmailInviata = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailInviata",
			new String[] {Boolean.class.getName()},
			new String[] {"emailInviata"}, false);

		_finderPathWithPaginationFindByIud = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIud",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"iud"}, true);

		_finderPathWithoutPaginationFindByIud = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIud",
			new String[] {String.class.getName()}, new String[] {"iud"}, true);

		_finderPathCountByIud = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIud",
			new String[] {String.class.getName()}, new String[] {"iud"}, false);

		_finderPathFetchByIuv = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByIuv",
			new String[] {String.class.getName()}, new String[] {"iuv"}, true);

		_finderPathCountByIuv = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIuv",
			new String[] {String.class.getName()}, new String[] {"iuv"}, false);

		_finderPathFetchByIdSessione = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByIdSessione",
			new String[] {String.class.getName()}, new String[] {"idSessione"},
			true);

		_finderPathCountByIdSessione = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdSessione",
			new String[] {String.class.getName()}, new String[] {"idSessione"},
			false);

		_finderPathFetchByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRichiestaId",
			new String[] {Long.class.getName()}, new String[] {"richiestaId"},
			true);

		_finderPathCountByRichiestaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRichiestaId",
			new String[] {Long.class.getName()}, new String[] {"richiestaId"},
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

		_finderPathWithPaginationFindByStatoGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatoGroupId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"stato", "groupId"}, true);

		_finderPathWithoutPaginationFindByStatoGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatoGroupId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"stato", "groupId"}, true);

		_finderPathCountByStatoGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatoGroupId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"stato", "groupId"}, false);

		_setPagamentoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPagamentoUtilPersistence(null);

		entityCache.removeCache(PagamentoImpl.class.getName());
	}

	private void _setPagamentoUtilPersistence(
		PagamentoPersistence pagamentoPersistence) {

		try {
			Field field = PagamentoUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, pagamentoPersistence);
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

	private static final String _SQL_SELECT_PAGAMENTO =
		"SELECT pagamento FROM Pagamento pagamento";

	private static final String _SQL_SELECT_PAGAMENTO_WHERE =
		"SELECT pagamento FROM Pagamento pagamento WHERE ";

	private static final String _SQL_COUNT_PAGAMENTO =
		"SELECT COUNT(pagamento) FROM Pagamento pagamento";

	private static final String _SQL_COUNT_PAGAMENTO_WHERE =
		"SELECT COUNT(pagamento) FROM Pagamento pagamento WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pagamento.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Pagamento exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Pagamento exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PagamentoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PagamentoModelArgumentsResolver _pagamentoModelArgumentsResolver;

}