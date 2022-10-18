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

import it.servizidigitali.gestioneprocedure.exception.NoSuchTemplatePdfException;
import it.servizidigitali.gestioneprocedure.model.TemplatePdf;
import it.servizidigitali.gestioneprocedure.model.TemplatePdfTable;
import it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfImpl;
import it.servizidigitali.gestioneprocedure.model.impl.TemplatePdfModelImpl;
import it.servizidigitali.gestioneprocedure.service.persistence.TemplatePdfPersistence;
import it.servizidigitali.gestioneprocedure.service.persistence.TemplatePdfUtil;
import it.servizidigitali.gestioneprocedure.service.persistence.impl.constants.PersistenceConstants;

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
 * The persistence implementation for the template pdf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TemplatePdfPersistence.class, BasePersistence.class})
public class TemplatePdfPersistenceImpl
	extends BasePersistenceImpl<TemplatePdf> implements TemplatePdfPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TemplatePdfUtil</code> to access the template pdf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TemplatePdfImpl.class.getName();

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
	 * Returns all the template pdfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
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

		List<TemplatePdf> list = null;

		if (useFinderCache) {
			list = (List<TemplatePdf>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TemplatePdf templatePdf : list) {
					if (!uuid.equals(templatePdf.getUuid())) {
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

			sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

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
				sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
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

				list = (List<TemplatePdf>)QueryUtil.list(
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
	 * Returns the first template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByUuid_First(
			String uuid, OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByUuid_First(uuid, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByUuid_First(
		String uuid, OrderByComparator<TemplatePdf> orderByComparator) {

		List<TemplatePdf> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByUuid_Last(
			String uuid, OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByUuid_Last(uuid, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByUuid_Last(
		String uuid, OrderByComparator<TemplatePdf> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TemplatePdf> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where uuid = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf[] findByUuid_PrevAndNext(
			long templatePdfId, String uuid,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		uuid = Objects.toString(uuid, "");

		TemplatePdf templatePdf = findByPrimaryKey(templatePdfId);

		Session session = null;

		try {
			session = openSession();

			TemplatePdf[] array = new TemplatePdfImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, templatePdf, uuid, orderByComparator, true);

			array[1] = templatePdf;

			array[2] = getByUuid_PrevAndNext(
				session, templatePdf, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TemplatePdf getByUuid_PrevAndNext(
		Session session, TemplatePdf templatePdf, String uuid,
		OrderByComparator<TemplatePdf> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

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
			sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(templatePdf)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TemplatePdf> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the template pdfs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TemplatePdf templatePdf :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(templatePdf);
		}
	}

	/**
	 * Returns the number of template pdfs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching template pdfs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEMPLATEPDF_WHERE);

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
		"templatePdf.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(templatePdf.uuid IS NULL OR templatePdf.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the template pdf where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTemplatePdfException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByUUID_G(String uuid, long groupId)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByUUID_G(uuid, groupId);

		if (templatePdf == null) {
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

			throw new NoSuchTemplatePdfException(sb.toString());
		}

		return templatePdf;
	}

	/**
	 * Returns the template pdf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the template pdf where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByUUID_G(
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

		if (result instanceof TemplatePdf) {
			TemplatePdf templatePdf = (TemplatePdf)result;

			if (!Objects.equals(uuid, templatePdf.getUuid()) ||
				(groupId != templatePdf.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

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

				List<TemplatePdf> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TemplatePdf templatePdf = list.get(0);

					result = templatePdf;

					cacheResult(templatePdf);
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
			return (TemplatePdf)result;
		}
	}

	/**
	 * Removes the template pdf where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the template pdf that was removed
	 */
	@Override
	public TemplatePdf removeByUUID_G(String uuid, long groupId)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = findByUUID_G(uuid, groupId);

		return remove(templatePdf);
	}

	/**
	 * Returns the number of template pdfs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching template pdfs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEMPLATEPDF_WHERE);

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
		"templatePdf.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(templatePdf.uuid IS NULL OR templatePdf.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"templatePdf.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
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

		List<TemplatePdf> list = null;

		if (useFinderCache) {
			list = (List<TemplatePdf>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TemplatePdf templatePdf : list) {
					if (!uuid.equals(templatePdf.getUuid()) ||
						(companyId != templatePdf.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

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
				sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
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

				list = (List<TemplatePdf>)QueryUtil.list(
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
	 * Returns the first template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the first template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		List<TemplatePdf> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the last template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TemplatePdf> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf[] findByUuid_C_PrevAndNext(
			long templatePdfId, String uuid, long companyId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		uuid = Objects.toString(uuid, "");

		TemplatePdf templatePdf = findByPrimaryKey(templatePdfId);

		Session session = null;

		try {
			session = openSession();

			TemplatePdf[] array = new TemplatePdfImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, templatePdf, uuid, companyId, orderByComparator, true);

			array[1] = templatePdf;

			array[2] = getByUuid_C_PrevAndNext(
				session, templatePdf, uuid, companyId, orderByComparator,
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

	protected TemplatePdf getByUuid_C_PrevAndNext(
		Session session, TemplatePdf templatePdf, String uuid, long companyId,
		OrderByComparator<TemplatePdf> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

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
			sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(templatePdf)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TemplatePdf> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the template pdfs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TemplatePdf templatePdf :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(templatePdf);
		}
	}

	/**
	 * Returns the number of template pdfs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching template pdfs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEMPLATEPDF_WHERE);

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
		"templatePdf.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(templatePdf.uuid IS NULL OR templatePdf.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"templatePdf.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTemplatePdfParentId;
	private FinderPath _finderPathWithoutPaginationFindByTemplatePdfParentId;
	private FinderPath _finderPathCountByTemplatePdfParentId;

	/**
	 * Returns all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @return the matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId) {

		return findByTemplatePdfParentId(
			templatePdfParentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end) {

		return findByTemplatePdfParentId(templatePdfParentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return findByTemplatePdfParentId(
			templatePdfParentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template pdfs where templatePdfParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByTemplatePdfParentId(
		long templatePdfParentId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTemplatePdfParentId;
				finderArgs = new Object[] {templatePdfParentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTemplatePdfParentId;
			finderArgs = new Object[] {
				templatePdfParentId, start, end, orderByComparator
			};
		}

		List<TemplatePdf> list = null;

		if (useFinderCache) {
			list = (List<TemplatePdf>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TemplatePdf templatePdf : list) {
					if (templatePdfParentId !=
							templatePdf.getTemplatePdfParentId()) {

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

			sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

			sb.append(_FINDER_COLUMN_TEMPLATEPDFPARENTID_TEMPLATEPDFPARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(templatePdfParentId);

				list = (List<TemplatePdf>)QueryUtil.list(
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
	 * Returns the first template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByTemplatePdfParentId_First(
			long templatePdfParentId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByTemplatePdfParentId_First(
			templatePdfParentId, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("templatePdfParentId=");
		sb.append(templatePdfParentId);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the first template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByTemplatePdfParentId_First(
		long templatePdfParentId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		List<TemplatePdf> list = findByTemplatePdfParentId(
			templatePdfParentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByTemplatePdfParentId_Last(
			long templatePdfParentId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByTemplatePdfParentId_Last(
			templatePdfParentId, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("templatePdfParentId=");
		sb.append(templatePdfParentId);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the last template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByTemplatePdfParentId_Last(
		long templatePdfParentId,
		OrderByComparator<TemplatePdf> orderByComparator) {

		int count = countByTemplatePdfParentId(templatePdfParentId);

		if (count == 0) {
			return null;
		}

		List<TemplatePdf> list = findByTemplatePdfParentId(
			templatePdfParentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param templatePdfParentId the template pdf parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf[] findByTemplatePdfParentId_PrevAndNext(
			long templatePdfId, long templatePdfParentId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = findByPrimaryKey(templatePdfId);

		Session session = null;

		try {
			session = openSession();

			TemplatePdf[] array = new TemplatePdfImpl[3];

			array[0] = getByTemplatePdfParentId_PrevAndNext(
				session, templatePdf, templatePdfParentId, orderByComparator,
				true);

			array[1] = templatePdf;

			array[2] = getByTemplatePdfParentId_PrevAndNext(
				session, templatePdf, templatePdfParentId, orderByComparator,
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

	protected TemplatePdf getByTemplatePdfParentId_PrevAndNext(
		Session session, TemplatePdf templatePdf, long templatePdfParentId,
		OrderByComparator<TemplatePdf> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

		sb.append(_FINDER_COLUMN_TEMPLATEPDFPARENTID_TEMPLATEPDFPARENTID_2);

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
			sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(templatePdfParentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(templatePdf)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TemplatePdf> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the template pdfs where templatePdfParentId = &#63; from the database.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 */
	@Override
	public void removeByTemplatePdfParentId(long templatePdfParentId) {
		for (TemplatePdf templatePdf :
				findByTemplatePdfParentId(
					templatePdfParentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(templatePdf);
		}
	}

	/**
	 * Returns the number of template pdfs where templatePdfParentId = &#63;.
	 *
	 * @param templatePdfParentId the template pdf parent ID
	 * @return the number of matching template pdfs
	 */
	@Override
	public int countByTemplatePdfParentId(long templatePdfParentId) {
		FinderPath finderPath = _finderPathCountByTemplatePdfParentId;

		Object[] finderArgs = new Object[] {templatePdfParentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEMPLATEPDF_WHERE);

			sb.append(_FINDER_COLUMN_TEMPLATEPDFPARENTID_TEMPLATEPDFPARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(templatePdfParentId);

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
		_FINDER_COLUMN_TEMPLATEPDFPARENTID_TEMPLATEPDFPARENTID_2 =
			"templatePdf.templatePdfParentId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProceduraIdAndTipoTemplate;
	private FinderPath
		_finderPathWithoutPaginationFindByProceduraIdAndTipoTemplate;
	private FinderPath _finderPathCountByProceduraIdAndTipoTemplate;

	/**
	 * Returns all the template pdfs where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @return the matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate) {

		return findByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the template pdfs where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate, int start, int end) {

		return findByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template pdfs where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return findByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template pdfs where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		tipoTemplate = Objects.toString(tipoTemplate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProceduraIdAndTipoTemplate;
				finderArgs = new Object[] {proceduraId, tipoTemplate};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProceduraIdAndTipoTemplate;
			finderArgs = new Object[] {
				proceduraId, tipoTemplate, start, end, orderByComparator
			};
		}

		List<TemplatePdf> list = null;

		if (useFinderCache) {
			list = (List<TemplatePdf>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TemplatePdf templatePdf : list) {
					if ((proceduraId != templatePdf.getProceduraId()) ||
						!tipoTemplate.equals(templatePdf.getTipoTemplate())) {

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

			sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_PROCEDURAID_2);

			boolean bindTipoTemplate = false;

			if (tipoTemplate.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_3);
			}
			else {
				bindTipoTemplate = true;

				sb.append(
					_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

				if (bindTipoTemplate) {
					queryPos.add(tipoTemplate);
				}

				list = (List<TemplatePdf>)QueryUtil.list(
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
	 * Returns the first template pdf in the ordered set where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByProceduraIdAndTipoTemplate_First(
			long proceduraId, String tipoTemplate,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByProceduraIdAndTipoTemplate_First(
			proceduraId, tipoTemplate, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append(", tipoTemplate=");
		sb.append(tipoTemplate);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the first template pdf in the ordered set where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByProceduraIdAndTipoTemplate_First(
		long proceduraId, String tipoTemplate,
		OrderByComparator<TemplatePdf> orderByComparator) {

		List<TemplatePdf> list = findByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last template pdf in the ordered set where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByProceduraIdAndTipoTemplate_Last(
			long proceduraId, String tipoTemplate,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByProceduraIdAndTipoTemplate_Last(
			proceduraId, tipoTemplate, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append(", tipoTemplate=");
		sb.append(tipoTemplate);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the last template pdf in the ordered set where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByProceduraIdAndTipoTemplate_Last(
		long proceduraId, String tipoTemplate,
		OrderByComparator<TemplatePdf> orderByComparator) {

		int count = countByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate);

		if (count == 0) {
			return null;
		}

		List<TemplatePdf> list = findByProceduraIdAndTipoTemplate(
			proceduraId, tipoTemplate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf[] findByProceduraIdAndTipoTemplate_PrevAndNext(
			long templatePdfId, long proceduraId, String tipoTemplate,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		tipoTemplate = Objects.toString(tipoTemplate, "");

		TemplatePdf templatePdf = findByPrimaryKey(templatePdfId);

		Session session = null;

		try {
			session = openSession();

			TemplatePdf[] array = new TemplatePdfImpl[3];

			array[0] = getByProceduraIdAndTipoTemplate_PrevAndNext(
				session, templatePdf, proceduraId, tipoTemplate,
				orderByComparator, true);

			array[1] = templatePdf;

			array[2] = getByProceduraIdAndTipoTemplate_PrevAndNext(
				session, templatePdf, proceduraId, tipoTemplate,
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

	protected TemplatePdf getByProceduraIdAndTipoTemplate_PrevAndNext(
		Session session, TemplatePdf templatePdf, long proceduraId,
		String tipoTemplate, OrderByComparator<TemplatePdf> orderByComparator,
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

		sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

		sb.append(_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_PROCEDURAID_2);

		boolean bindTipoTemplate = false;

		if (tipoTemplate.isEmpty()) {
			sb.append(_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_3);
		}
		else {
			bindTipoTemplate = true;

			sb.append(_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_2);
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
			sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(proceduraId);

		if (bindTipoTemplate) {
			queryPos.add(tipoTemplate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(templatePdf)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TemplatePdf> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the template pdfs where proceduraId = &#63; and tipoTemplate = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 */
	@Override
	public void removeByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate) {

		for (TemplatePdf templatePdf :
				findByProceduraIdAndTipoTemplate(
					proceduraId, tipoTemplate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(templatePdf);
		}
	}

	/**
	 * Returns the number of template pdfs where proceduraId = &#63; and tipoTemplate = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param tipoTemplate the tipo template
	 * @return the number of matching template pdfs
	 */
	@Override
	public int countByProceduraIdAndTipoTemplate(
		long proceduraId, String tipoTemplate) {

		tipoTemplate = Objects.toString(tipoTemplate, "");

		FinderPath finderPath = _finderPathCountByProceduraIdAndTipoTemplate;

		Object[] finderArgs = new Object[] {proceduraId, tipoTemplate};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEMPLATEPDF_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_PROCEDURAID_2);

			boolean bindTipoTemplate = false;

			if (tipoTemplate.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_3);
			}
			else {
				bindTipoTemplate = true;

				sb.append(
					_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

				if (bindTipoTemplate) {
					queryPos.add(tipoTemplate);
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
		_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_PROCEDURAID_2 =
			"templatePdf.proceduraId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_2 =
			"templatePdf.tipoTemplate = ?";

	private static final String
		_FINDER_COLUMN_PROCEDURAIDANDTIPOTEMPLATE_TIPOTEMPLATE_3 =
			"(templatePdf.tipoTemplate IS NULL OR templatePdf.tipoTemplate = '')";

	private FinderPath _finderPathWithPaginationFindByProceduraId;
	private FinderPath _finderPathWithoutPaginationFindByProceduraId;
	private FinderPath _finderPathCountByProceduraId;

	/**
	 * Returns all the template pdfs where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraId(long proceduraId) {
		return findByProceduraId(
			proceduraId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template pdfs where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraId(
		long proceduraId, int start, int end) {

		return findByProceduraId(proceduraId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template pdfs where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator) {

		return findByProceduraId(
			proceduraId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template pdfs where proceduraId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param proceduraId the procedura ID
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching template pdfs
	 */
	@Override
	public List<TemplatePdf> findByProceduraId(
		long proceduraId, int start, int end,
		OrderByComparator<TemplatePdf> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProceduraId;
				finderArgs = new Object[] {proceduraId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProceduraId;
			finderArgs = new Object[] {
				proceduraId, start, end, orderByComparator
			};
		}

		List<TemplatePdf> list = null;

		if (useFinderCache) {
			list = (List<TemplatePdf>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TemplatePdf templatePdf : list) {
					if (proceduraId != templatePdf.getProceduraId()) {
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

			sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

			sb.append(_FINDER_COLUMN_PROCEDURAID_PROCEDURAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proceduraId);

				list = (List<TemplatePdf>)QueryUtil.list(
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
	 * Returns the first template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByProceduraId_First(
			long proceduraId, OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByProceduraId_First(
			proceduraId, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the first template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByProceduraId_First(
		long proceduraId, OrderByComparator<TemplatePdf> orderByComparator) {

		List<TemplatePdf> list = findByProceduraId(
			proceduraId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf
	 * @throws NoSuchTemplatePdfException if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf findByProceduraId_Last(
			long proceduraId, OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByProceduraId_Last(
			proceduraId, orderByComparator);

		if (templatePdf != null) {
			return templatePdf;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proceduraId=");
		sb.append(proceduraId);

		sb.append("}");

		throw new NoSuchTemplatePdfException(sb.toString());
	}

	/**
	 * Returns the last template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template pdf, or <code>null</code> if a matching template pdf could not be found
	 */
	@Override
	public TemplatePdf fetchByProceduraId_Last(
		long proceduraId, OrderByComparator<TemplatePdf> orderByComparator) {

		int count = countByProceduraId(proceduraId);

		if (count == 0) {
			return null;
		}

		List<TemplatePdf> list = findByProceduraId(
			proceduraId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the template pdfs before and after the current template pdf in the ordered set where proceduraId = &#63;.
	 *
	 * @param templatePdfId the primary key of the current template pdf
	 * @param proceduraId the procedura ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf[] findByProceduraId_PrevAndNext(
			long templatePdfId, long proceduraId,
			OrderByComparator<TemplatePdf> orderByComparator)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = findByPrimaryKey(templatePdfId);

		Session session = null;

		try {
			session = openSession();

			TemplatePdf[] array = new TemplatePdfImpl[3];

			array[0] = getByProceduraId_PrevAndNext(
				session, templatePdf, proceduraId, orderByComparator, true);

			array[1] = templatePdf;

			array[2] = getByProceduraId_PrevAndNext(
				session, templatePdf, proceduraId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TemplatePdf getByProceduraId_PrevAndNext(
		Session session, TemplatePdf templatePdf, long proceduraId,
		OrderByComparator<TemplatePdf> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TEMPLATEPDF_WHERE);

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
			sb.append(TemplatePdfModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(proceduraId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(templatePdf)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TemplatePdf> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the template pdfs where proceduraId = &#63; from the database.
	 *
	 * @param proceduraId the procedura ID
	 */
	@Override
	public void removeByProceduraId(long proceduraId) {
		for (TemplatePdf templatePdf :
				findByProceduraId(
					proceduraId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(templatePdf);
		}
	}

	/**
	 * Returns the number of template pdfs where proceduraId = &#63;.
	 *
	 * @param proceduraId the procedura ID
	 * @return the number of matching template pdfs
	 */
	@Override
	public int countByProceduraId(long proceduraId) {
		FinderPath finderPath = _finderPathCountByProceduraId;

		Object[] finderArgs = new Object[] {proceduraId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEMPLATEPDF_WHERE);

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
		"templatePdf.proceduraId = ?";

	public TemplatePdfPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TemplatePdf.class);

		setModelImplClass(TemplatePdfImpl.class);
		setModelPKClass(long.class);

		setTable(TemplatePdfTable.INSTANCE);
	}

	/**
	 * Caches the template pdf in the entity cache if it is enabled.
	 *
	 * @param templatePdf the template pdf
	 */
	@Override
	public void cacheResult(TemplatePdf templatePdf) {
		entityCache.putResult(
			TemplatePdfImpl.class, templatePdf.getPrimaryKey(), templatePdf);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {templatePdf.getUuid(), templatePdf.getGroupId()},
			templatePdf);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the template pdfs in the entity cache if it is enabled.
	 *
	 * @param templatePdfs the template pdfs
	 */
	@Override
	public void cacheResult(List<TemplatePdf> templatePdfs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (templatePdfs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TemplatePdf templatePdf : templatePdfs) {
			if (entityCache.getResult(
					TemplatePdfImpl.class, templatePdf.getPrimaryKey()) ==
						null) {

				cacheResult(templatePdf);
			}
		}
	}

	/**
	 * Clears the cache for all template pdfs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TemplatePdfImpl.class);

		finderCache.clearCache(TemplatePdfImpl.class);
	}

	/**
	 * Clears the cache for the template pdf.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TemplatePdf templatePdf) {
		entityCache.removeResult(TemplatePdfImpl.class, templatePdf);
	}

	@Override
	public void clearCache(List<TemplatePdf> templatePdfs) {
		for (TemplatePdf templatePdf : templatePdfs) {
			entityCache.removeResult(TemplatePdfImpl.class, templatePdf);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TemplatePdfImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TemplatePdfImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TemplatePdfModelImpl templatePdfModelImpl) {

		Object[] args = new Object[] {
			templatePdfModelImpl.getUuid(), templatePdfModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, templatePdfModelImpl);
	}

	/**
	 * Creates a new template pdf with the primary key. Does not add the template pdf to the database.
	 *
	 * @param templatePdfId the primary key for the new template pdf
	 * @return the new template pdf
	 */
	@Override
	public TemplatePdf create(long templatePdfId) {
		TemplatePdf templatePdf = new TemplatePdfImpl();

		templatePdf.setNew(true);
		templatePdf.setPrimaryKey(templatePdfId);

		String uuid = PortalUUIDUtil.generate();

		templatePdf.setUuid(uuid);

		templatePdf.setCompanyId(CompanyThreadLocal.getCompanyId());

		return templatePdf;
	}

	/**
	 * Removes the template pdf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf that was removed
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf remove(long templatePdfId)
		throws NoSuchTemplatePdfException {

		return remove((Serializable)templatePdfId);
	}

	/**
	 * Removes the template pdf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the template pdf
	 * @return the template pdf that was removed
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf remove(Serializable primaryKey)
		throws NoSuchTemplatePdfException {

		Session session = null;

		try {
			session = openSession();

			TemplatePdf templatePdf = (TemplatePdf)session.get(
				TemplatePdfImpl.class, primaryKey);

			if (templatePdf == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTemplatePdfException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(templatePdf);
		}
		catch (NoSuchTemplatePdfException noSuchEntityException) {
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
	protected TemplatePdf removeImpl(TemplatePdf templatePdf) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(templatePdf)) {
				templatePdf = (TemplatePdf)session.get(
					TemplatePdfImpl.class, templatePdf.getPrimaryKeyObj());
			}

			if (templatePdf != null) {
				session.delete(templatePdf);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (templatePdf != null) {
			clearCache(templatePdf);
		}

		return templatePdf;
	}

	@Override
	public TemplatePdf updateImpl(TemplatePdf templatePdf) {
		boolean isNew = templatePdf.isNew();

		if (!(templatePdf instanceof TemplatePdfModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(templatePdf.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(templatePdf);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in templatePdf proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TemplatePdf implementation " +
					templatePdf.getClass());
		}

		TemplatePdfModelImpl templatePdfModelImpl =
			(TemplatePdfModelImpl)templatePdf;

		if (Validator.isNull(templatePdf.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			templatePdf.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (templatePdf.getCreateDate() == null)) {
			if (serviceContext == null) {
				templatePdf.setCreateDate(date);
			}
			else {
				templatePdf.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!templatePdfModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				templatePdf.setModifiedDate(date);
			}
			else {
				templatePdf.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(templatePdf);
			}
			else {
				templatePdf = (TemplatePdf)session.merge(templatePdf);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TemplatePdfImpl.class, templatePdfModelImpl, false, true);

		cacheUniqueFindersCache(templatePdfModelImpl);

		if (isNew) {
			templatePdf.setNew(false);
		}

		templatePdf.resetOriginalValues();

		return templatePdf;
	}

	/**
	 * Returns the template pdf with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the template pdf
	 * @return the template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTemplatePdfException {

		TemplatePdf templatePdf = fetchByPrimaryKey(primaryKey);

		if (templatePdf == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTemplatePdfException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return templatePdf;
	}

	/**
	 * Returns the template pdf with the primary key or throws a <code>NoSuchTemplatePdfException</code> if it could not be found.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf
	 * @throws NoSuchTemplatePdfException if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf findByPrimaryKey(long templatePdfId)
		throws NoSuchTemplatePdfException {

		return findByPrimaryKey((Serializable)templatePdfId);
	}

	/**
	 * Returns the template pdf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templatePdfId the primary key of the template pdf
	 * @return the template pdf, or <code>null</code> if a template pdf with the primary key could not be found
	 */
	@Override
	public TemplatePdf fetchByPrimaryKey(long templatePdfId) {
		return fetchByPrimaryKey((Serializable)templatePdfId);
	}

	/**
	 * Returns all the template pdfs.
	 *
	 * @return the template pdfs
	 */
	@Override
	public List<TemplatePdf> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @return the range of template pdfs
	 */
	@Override
	public List<TemplatePdf> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template pdfs
	 */
	@Override
	public List<TemplatePdf> findAll(
		int start, int end, OrderByComparator<TemplatePdf> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the template pdfs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplatePdfModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template pdfs
	 * @param end the upper bound of the range of template pdfs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of template pdfs
	 */
	@Override
	public List<TemplatePdf> findAll(
		int start, int end, OrderByComparator<TemplatePdf> orderByComparator,
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

		List<TemplatePdf> list = null;

		if (useFinderCache) {
			list = (List<TemplatePdf>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEMPLATEPDF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEMPLATEPDF;

				sql = sql.concat(TemplatePdfModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TemplatePdf>)QueryUtil.list(
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
	 * Removes all the template pdfs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TemplatePdf templatePdf : findAll()) {
			remove(templatePdf);
		}
	}

	/**
	 * Returns the number of template pdfs.
	 *
	 * @return the number of template pdfs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TEMPLATEPDF);

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
		return "templatePdfId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEMPLATEPDF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TemplatePdfModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the template pdf persistence.
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

		_finderPathWithPaginationFindByTemplatePdfParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplatePdfParentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"templatePdfParentId"}, true);

		_finderPathWithoutPaginationFindByTemplatePdfParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTemplatePdfParentId", new String[] {Long.class.getName()},
			new String[] {"templatePdfParentId"}, true);

		_finderPathCountByTemplatePdfParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTemplatePdfParentId", new String[] {Long.class.getName()},
			new String[] {"templatePdfParentId"}, false);

		_finderPathWithPaginationFindByProceduraIdAndTipoTemplate =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProceduraIdAndTipoTemplate",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"proceduraId", "tipoTemplate"}, true);

		_finderPathWithoutPaginationFindByProceduraIdAndTipoTemplate =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProceduraIdAndTipoTemplate",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"proceduraId", "tipoTemplate"}, true);

		_finderPathCountByProceduraIdAndTipoTemplate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProceduraIdAndTipoTemplate",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"proceduraId", "tipoTemplate"}, false);

		_finderPathWithPaginationFindByProceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProceduraId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"proceduraId"}, true);

		_finderPathWithoutPaginationFindByProceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProceduraId",
			new String[] {Long.class.getName()}, new String[] {"proceduraId"},
			true);

		_finderPathCountByProceduraId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProceduraId",
			new String[] {Long.class.getName()}, new String[] {"proceduraId"},
			false);

		_setTemplatePdfUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTemplatePdfUtilPersistence(null);

		entityCache.removeCache(TemplatePdfImpl.class.getName());
	}

	private void _setTemplatePdfUtilPersistence(
		TemplatePdfPersistence templatePdfPersistence) {

		try {
			Field field = TemplatePdfUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, templatePdfPersistence);
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

	private static final String _SQL_SELECT_TEMPLATEPDF =
		"SELECT templatePdf FROM TemplatePdf templatePdf";

	private static final String _SQL_SELECT_TEMPLATEPDF_WHERE =
		"SELECT templatePdf FROM TemplatePdf templatePdf WHERE ";

	private static final String _SQL_COUNT_TEMPLATEPDF =
		"SELECT COUNT(templatePdf) FROM TemplatePdf templatePdf";

	private static final String _SQL_COUNT_TEMPLATEPDF_WHERE =
		"SELECT COUNT(templatePdf) FROM TemplatePdf templatePdf WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "templatePdf.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TemplatePdf exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TemplatePdf exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TemplatePdfPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TemplatePdfModelArgumentsResolver
		_templatePdfModelArgumentsResolver;

}