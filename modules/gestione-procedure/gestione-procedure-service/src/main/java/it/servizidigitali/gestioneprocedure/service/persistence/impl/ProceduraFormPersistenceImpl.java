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

package it.servizidigitali.gestioneprocedure.service.persistence.impl;

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

import it.servizidigitali.gestioneprocedure.exception.NoSuchProceduraFormException;
import it.servizidigitali.gestioneprocedure.model.ProceduraForm;
import it.servizidigitali.gestioneprocedure.model.ProceduraFormTable;
import it.servizidigitali.gestioneprocedure.model.impl.ProceduraFormImpl;
import it.servizidigitali.gestioneprocedure.model.impl.ProceduraFormModelImpl;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPK;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormPersistence;
import it.servizidigitali.gestioneprocedure.service.persistence.ProceduraFormUtil;
import it.servizidigitali.gestioneprocedure.service.persistence.impl.constants.PersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the procedura form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProceduraFormPersistence.class, BasePersistence.class})
public class ProceduraFormPersistenceImpl
	extends BasePersistenceImpl<ProceduraForm>
	implements ProceduraFormPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProceduraFormUtil</code> to access the procedura form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProceduraFormImpl.class.getName();

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
	 * Returns all the procedura forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator,
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

		List<ProceduraForm> list = null;

		if (useFinderCache) {
			list = (List<ProceduraForm>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduraForm proceduraForm : list) {
					if (!uuid.equals(proceduraForm.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCEDURAFORM_WHERE);

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
				sb.append(ProceduraFormModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProceduraForm>)QueryUtil.list(
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
	 * Returns the first procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm findByUuid_First(
			String uuid, OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByUuid_First(
			uuid, orderByComparator);

		if (proceduraForm != null) {
			return proceduraForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProceduraFormException(sb.toString());
	}

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm fetchByUuid_First(
		String uuid, OrderByComparator<ProceduraForm> orderByComparator) {

		List<ProceduraForm> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm findByUuid_Last(
			String uuid, OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByUuid_Last(uuid, orderByComparator);

		if (proceduraForm != null) {
			return proceduraForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProceduraFormException(sb.toString());
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm fetchByUuid_Last(
		String uuid, OrderByComparator<ProceduraForm> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProceduraForm> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where uuid = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm[] findByUuid_PrevAndNext(
			ProceduraFormPK proceduraFormPK, String uuid,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		uuid = Objects.toString(uuid, "");

		ProceduraForm proceduraForm = findByPrimaryKey(proceduraFormPK);

		Session session = null;

		try {
			session = openSession();

			ProceduraForm[] array = new ProceduraFormImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, proceduraForm, uuid, orderByComparator, true);

			array[1] = proceduraForm;

			array[2] = getByUuid_PrevAndNext(
				session, proceduraForm, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProceduraForm getByUuid_PrevAndNext(
		Session session, ProceduraForm proceduraForm, String uuid,
		OrderByComparator<ProceduraForm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCEDURAFORM_WHERE);

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
			sb.append(ProceduraFormModelImpl.ORDER_BY_JPQL);
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
						proceduraForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduraForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedura forms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProceduraForm proceduraForm :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(proceduraForm);
		}
	}

	/**
	 * Returns the number of procedura forms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedura forms
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDURAFORM_WHERE);

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
		"proceduraForm.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(proceduraForm.uuid IS NULL OR proceduraForm.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator,
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

		List<ProceduraForm> list = null;

		if (useFinderCache) {
			list = (List<ProceduraForm>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduraForm proceduraForm : list) {
					if (!uuid.equals(proceduraForm.getUuid()) ||
						(companyId != proceduraForm.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCEDURAFORM_WHERE);

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
				sb.append(ProceduraFormModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProceduraForm>)QueryUtil.list(
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
	 * Returns the first procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (proceduraForm != null) {
			return proceduraForm;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProceduraFormException(sb.toString());
	}

	/**
	 * Returns the first procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProceduraForm> orderByComparator) {

		List<ProceduraForm> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (proceduraForm != null) {
			return proceduraForm;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProceduraFormException(sb.toString());
	}

	/**
	 * Returns the last procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProceduraForm> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProceduraForm> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm[] findByUuid_C_PrevAndNext(
			ProceduraFormPK proceduraFormPK, String uuid, long companyId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		uuid = Objects.toString(uuid, "");

		ProceduraForm proceduraForm = findByPrimaryKey(proceduraFormPK);

		Session session = null;

		try {
			session = openSession();

			ProceduraForm[] array = new ProceduraFormImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, proceduraForm, uuid, companyId, orderByComparator,
				true);

			array[1] = proceduraForm;

			array[2] = getByUuid_C_PrevAndNext(
				session, proceduraForm, uuid, companyId, orderByComparator,
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

	protected ProceduraForm getByUuid_C_PrevAndNext(
		Session session, ProceduraForm proceduraForm, String uuid,
		long companyId, OrderByComparator<ProceduraForm> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCEDURAFORM_WHERE);

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
			sb.append(ProceduraFormModelImpl.ORDER_BY_JPQL);
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
						proceduraForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduraForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedura forms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProceduraForm proceduraForm :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(proceduraForm);
		}
	}

	/**
	 * Returns the number of procedura forms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedura forms
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCEDURAFORM_WHERE);

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
		"proceduraForm.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(proceduraForm.uuid IS NULL OR proceduraForm.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"proceduraForm.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByproceduraId;
	private FinderPath _finderPathWithoutPaginationFindByproceduraId;
	private FinderPath _finderPathCountByproceduraId;

	/**
	 * Returns all the procedura forms where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByproceduraId(long proceduraId) {
		return findByproceduraId(
			proceduraId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedura forms where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByproceduraId(
		long proceduraId, int start, int end) {

		return findByproceduraId(proceduraId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedura forms where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByproceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return findByproceduraId(
			proceduraId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedura forms where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedura forms
	 */
	@Override
	public List<ProceduraForm> findByproceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByproceduraId;
				finderArgs = new Object[] {proceduraId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByproceduraId;
			finderArgs = new Object[] {
				proceduraId, start, end, orderByComparator
			};
		}

		List<ProceduraForm> list = null;

		if (useFinderCache) {
			list = (List<ProceduraForm>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProceduraForm proceduraForm : list) {
					if (proceduraId != proceduraForm.getProceduraId()) {
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

			sb.append(_SQL_SELECT_PROCEDURAFORM_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProceduraFormModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

				list = (List<ProceduraForm>)QueryUtil.list(
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
	 * Returns the first procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm findByproceduraId_First(
			long proceduraId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByproceduraId_First(
			proceduraId, orderByComparator);

		if (proceduraForm != null) {
			return proceduraForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append("}");

		throw new NoSuchProceduraFormException(sb.toString());
	}

	/**
	 * Returns the first procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm fetchByproceduraId_First(
		long proceduraId, OrderByComparator<ProceduraForm> orderByComparator) {

		List<ProceduraForm> list = findByproceduraId(
			proceduraId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form
	 * @throws NoSuchProceduraFormException if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm findByproceduraId_Last(
			long proceduraId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByproceduraId_Last(
			proceduraId, orderByComparator);

		if (proceduraForm != null) {
			return proceduraForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append("}");

		throw new NoSuchProceduraFormException(sb.toString());
	}

	/**
	 * Returns the last procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedura form, or <code>null</code> if a matching procedura form could not be found
	 */
	@Override
	public ProceduraForm fetchByproceduraId_Last(
		long proceduraId, OrderByComparator<ProceduraForm> orderByComparator) {

		int count = countByproceduraId(proceduraId);

		if (count == 0) {
			return null;
		}

		List<ProceduraForm> list = findByproceduraId(
			proceduraId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procedura forms before and after the current procedura form in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraFormPK the primary key of the current procedura form
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm[] findByproceduraId_PrevAndNext(
			ProceduraFormPK proceduraFormPK, long proceduraId,
			OrderByComparator<ProceduraForm> orderByComparator)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = findByPrimaryKey(proceduraFormPK);

		Session session = null;

		try {
			session = openSession();

			ProceduraForm[] array = new ProceduraFormImpl[3];

			array[0] = getByproceduraId_PrevAndNext(
				session, proceduraForm, proceduraId, orderByComparator, true);

			array[1] = proceduraForm;

			array[2] = getByproceduraId_PrevAndNext(
				session, proceduraForm, proceduraId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProceduraForm getByproceduraId_PrevAndNext(
		Session session, ProceduraForm proceduraForm, long proceduraId,
		OrderByComparator<ProceduraForm> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCEDURAFORM_WHERE);

		sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

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
			sb.append(ProceduraFormModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(proceduraId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						proceduraForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProceduraForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procedura forms where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	@Override
	public void removeByproceduraId(long proceduraId) {
		for (ProceduraForm proceduraForm :
				findByproceduraId(
					proceduraId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(proceduraForm);
		}
	}

	/**
	 * Returns the number of procedura forms where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching procedura forms
	 */
	@Override
	public int countByproceduraId(long proceduraId) {
		FinderPath finderPath = _finderPathCountByproceduraId;

		Object[] finderArgs = new Object[] {proceduraId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCEDURAFORM_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

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

	private static final String _FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2 =
		"proceduraForm.id.proceduraId = ?";

	public ProceduraFormPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProceduraForm.class);

		setModelImplClass(ProceduraFormImpl.class);
		setModelPKClass(ProceduraFormPK.class);

		setTable(ProceduraFormTable.INSTANCE);
	}

	/**
	 * Caches the procedura form in the entity cache if it is enabled.
	 *
	 * @param proceduraForm the procedura form
	 */
	@Override
	public void cacheResult(ProceduraForm proceduraForm) {
		entityCache.putResult(
			ProceduraFormImpl.class, proceduraForm.getPrimaryKey(),
			proceduraForm);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the procedura forms in the entity cache if it is enabled.
	 *
	 * @param proceduraForms the procedura forms
	 */
	@Override
	public void cacheResult(List<ProceduraForm> proceduraForms) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (proceduraForms.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProceduraForm proceduraForm : proceduraForms) {
			if (entityCache.getResult(
					ProceduraFormImpl.class, proceduraForm.getPrimaryKey()) ==
						null) {

				cacheResult(proceduraForm);
			}
		}
	}

	/**
	 * Clears the cache for all procedura forms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProceduraFormImpl.class);

		finderCache.clearCache(ProceduraFormImpl.class);
	}

	/**
	 * Clears the cache for the procedura form.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProceduraForm proceduraForm) {
		entityCache.removeResult(ProceduraFormImpl.class, proceduraForm);
	}

	@Override
	public void clearCache(List<ProceduraForm> proceduraForms) {
		for (ProceduraForm proceduraForm : proceduraForms) {
			entityCache.removeResult(ProceduraFormImpl.class, proceduraForm);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProceduraFormImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProceduraFormImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new procedura form with the primary key. Does not add the procedura form to the database.
	 *
	 * @param proceduraFormPK the primary key for the new procedura form
	 * @return the new procedura form
	 */
	@Override
	public ProceduraForm create(ProceduraFormPK proceduraFormPK) {
		ProceduraForm proceduraForm = new ProceduraFormImpl();

		proceduraForm.setNew(true);
		proceduraForm.setPrimaryKey(proceduraFormPK);

		String uuid = PortalUUIDUtil.generate();

		proceduraForm.setUuid(uuid);

		proceduraForm.setCompanyId(CompanyThreadLocal.getCompanyId());

		return proceduraForm;
	}

	/**
	 * Removes the procedura form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form that was removed
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm remove(ProceduraFormPK proceduraFormPK)
		throws NoSuchProceduraFormException {

		return remove((Serializable)proceduraFormPK);
	}

	/**
	 * Removes the procedura form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procedura form
	 * @return the procedura form that was removed
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm remove(Serializable primaryKey)
		throws NoSuchProceduraFormException {

		Session session = null;

		try {
			session = openSession();

			ProceduraForm proceduraForm = (ProceduraForm)session.get(
				ProceduraFormImpl.class, primaryKey);

			if (proceduraForm == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProceduraFormException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(proceduraForm);
		}
		catch (NoSuchProceduraFormException noSuchEntityException) {
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
	protected ProceduraForm removeImpl(ProceduraForm proceduraForm) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proceduraForm)) {
				proceduraForm = (ProceduraForm)session.get(
					ProceduraFormImpl.class, proceduraForm.getPrimaryKeyObj());
			}

			if (proceduraForm != null) {
				session.delete(proceduraForm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (proceduraForm != null) {
			clearCache(proceduraForm);
		}

		return proceduraForm;
	}

	@Override
	public ProceduraForm updateImpl(ProceduraForm proceduraForm) {
		boolean isNew = proceduraForm.isNew();

		if (!(proceduraForm instanceof ProceduraFormModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(proceduraForm.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					proceduraForm);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in proceduraForm proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProceduraForm implementation " +
					proceduraForm.getClass());
		}

		ProceduraFormModelImpl proceduraFormModelImpl =
			(ProceduraFormModelImpl)proceduraForm;

		if (Validator.isNull(proceduraForm.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			proceduraForm.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(proceduraForm);
			}
			else {
				proceduraForm = (ProceduraForm)session.merge(proceduraForm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProceduraFormImpl.class, proceduraFormModelImpl, false, true);

		if (isNew) {
			proceduraForm.setNew(false);
		}

		proceduraForm.resetOriginalValues();

		return proceduraForm;
	}

	/**
	 * Returns the procedura form with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procedura form
	 * @return the procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProceduraFormException {

		ProceduraForm proceduraForm = fetchByPrimaryKey(primaryKey);

		if (proceduraForm == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProceduraFormException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return proceduraForm;
	}

	/**
	 * Returns the procedura form with the primary key or throws a <code>NoSuchProceduraFormException</code> if it could not be found.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form
	 * @throws NoSuchProceduraFormException if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm findByPrimaryKey(ProceduraFormPK proceduraFormPK)
		throws NoSuchProceduraFormException {

		return findByPrimaryKey((Serializable)proceduraFormPK);
	}

	/**
	 * Returns the procedura form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proceduraFormPK the primary key of the procedura form
	 * @return the procedura form, or <code>null</code> if a procedura form with the primary key could not be found
	 */
	@Override
	public ProceduraForm fetchByPrimaryKey(ProceduraFormPK proceduraFormPK) {
		return fetchByPrimaryKey((Serializable)proceduraFormPK);
	}

	/**
	 * Returns all the procedura forms.
	 *
	 * @return the procedura forms
	 */
	@Override
	public List<ProceduraForm> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @return the range of procedura forms
	 */
	@Override
	public List<ProceduraForm> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedura forms
	 */
	@Override
	public List<ProceduraForm> findAll(
		int start, int end,
		OrderByComparator<ProceduraForm> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procedura forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduraFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedura forms
	 * @param end the upper bound of the range of procedura forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedura forms
	 */
	@Override
	public List<ProceduraForm> findAll(
		int start, int end, OrderByComparator<ProceduraForm> orderByComparator,
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

		List<ProceduraForm> list = null;

		if (useFinderCache) {
			list = (List<ProceduraForm>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCEDURAFORM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCEDURAFORM;

				sql = sql.concat(ProceduraFormModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProceduraForm>)QueryUtil.list(
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
	 * Removes all the procedura forms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProceduraForm proceduraForm : findAll()) {
			remove(proceduraForm);
		}
	}

	/**
	 * Returns the number of procedura forms.
	 *
	 * @return the number of procedura forms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROCEDURAFORM);

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
		return "proceduraFormPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCEDURAFORM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProceduraFormModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procedura form persistence.
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

		_finderPathWithPaginationFindByproceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByproceduraId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"proceduraId"}, true);

		_finderPathWithoutPaginationFindByproceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproceduraId",
			new String[] {Long.class.getName()}, new String[] {"proceduraId"},
			true);

		_finderPathCountByproceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproceduraId",
			new String[] {Long.class.getName()}, new String[] {"proceduraId"},
			false);

		_setProceduraFormUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProceduraFormUtilPersistence(null);

		entityCache.removeCache(ProceduraFormImpl.class.getName());
	}

	private void _setProceduraFormUtilPersistence(
		ProceduraFormPersistence proceduraFormPersistence) {

		try {
			Field field = ProceduraFormUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, proceduraFormPersistence);
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

	private static final String _SQL_SELECT_PROCEDURAFORM =
		"SELECT proceduraForm FROM ProceduraForm proceduraForm";

	private static final String _SQL_SELECT_PROCEDURAFORM_WHERE =
		"SELECT proceduraForm FROM ProceduraForm proceduraForm WHERE ";

	private static final String _SQL_COUNT_PROCEDURAFORM =
		"SELECT COUNT(proceduraForm) FROM ProceduraForm proceduraForm";

	private static final String _SQL_COUNT_PROCEDURAFORM_WHERE =
		"SELECT COUNT(proceduraForm) FROM ProceduraForm proceduraForm WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "proceduraForm.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProceduraForm exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProceduraForm exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProceduraFormPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"proceduraId", "formId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProceduraFormModelArgumentsResolver
		_proceduraFormModelArgumentsResolver;

}