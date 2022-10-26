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

package it.servizidigitali.gestionepagamenti.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.servizidigitali.gestionepagamenti.model.Pagamento;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pagamento service. This utility wraps <code>it.servizidigitali.gestionepagamenti.service.persistence.impl.PagamentoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PagamentoPersistence
 * @generated
 */
public class PagamentoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Pagamento pagamento) {
		getPersistence().clearCache(pagamento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Pagamento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Pagamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Pagamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Pagamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Pagamento update(Pagamento pagamento) {
		return getPersistence().update(pagamento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Pagamento update(
		Pagamento pagamento, ServiceContext serviceContext) {

		return getPersistence().update(pagamento, serviceContext);
	}

	/**
	 * Returns all the pagamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Pagamento> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Pagamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Pagamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByUuid_First(
			String uuid, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByUuid_First(
		String uuid, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByUuid_Last(
			String uuid, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByUuid_Last(
		String uuid, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Pagamento[] findByUuid_PrevAndNext(
			long pagamentoId, String uuid,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUuid_PrevAndNext(
			pagamentoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of pagamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pagamentos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the pagamento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pagamento that was removed
	 */
	public static Pagamento removeByUUID_G(String uuid, long groupId)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of pagamentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Pagamento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Pagamento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Pagamento[] findByUuid_C_PrevAndNext(
			long pagamentoId, String uuid, long companyId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			pagamentoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pagamentos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the pagamentos where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByIdCredito(String idCredito) {
		return getPersistence().findByIdCredito(idCredito);
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
	public static List<Pagamento> findByIdCredito(
		String idCredito, int start, int end) {

		return getPersistence().findByIdCredito(idCredito, start, end);
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
	public static List<Pagamento> findByIdCredito(
		String idCredito, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByIdCredito(
			idCredito, start, end, orderByComparator);
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
	public static List<Pagamento> findByIdCredito(
		String idCredito, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIdCredito(
			idCredito, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIdCredito_First(
			String idCredito, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdCredito_First(
			idCredito, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdCredito_First(
		String idCredito, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIdCredito_First(
			idCredito, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIdCredito_Last(
			String idCredito, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdCredito_Last(
			idCredito, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdCredito_Last(
		String idCredito, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIdCredito_Last(
			idCredito, orderByComparator);
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
	public static Pagamento[] findByIdCredito_PrevAndNext(
			long pagamentoId, String idCredito,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdCredito_PrevAndNext(
			pagamentoId, idCredito, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where idCredito = &#63; from the database.
	 *
	 * @param idCredito the id credito
	 */
	public static void removeByIdCredito(String idCredito) {
		getPersistence().removeByIdCredito(idCredito);
	}

	/**
	 * Returns the number of pagamentos where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @return the number of matching pagamentos
	 */
	public static int countByIdCredito(String idCredito) {
		return getPersistence().countByIdCredito(idCredito);
	}

	/**
	 * Returns all the pagamentos where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente) {

		return getPersistence().findByIdFiscaleCliente(idFiscaleCliente);
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
	public static List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end) {

		return getPersistence().findByIdFiscaleCliente(
			idFiscaleCliente, start, end);
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
	public static List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByIdFiscaleCliente(
			idFiscaleCliente, start, end, orderByComparator);
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
	public static List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIdFiscaleCliente(
			idFiscaleCliente, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIdFiscaleCliente_First(
			String idFiscaleCliente,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdFiscaleCliente_First(
			idFiscaleCliente, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdFiscaleCliente_First(
		String idFiscaleCliente,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIdFiscaleCliente_First(
			idFiscaleCliente, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIdFiscaleCliente_Last(
			String idFiscaleCliente,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdFiscaleCliente_Last(
			idFiscaleCliente, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdFiscaleCliente_Last(
		String idFiscaleCliente,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIdFiscaleCliente_Last(
			idFiscaleCliente, orderByComparator);
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
	public static Pagamento[] findByIdFiscaleCliente_PrevAndNext(
			long pagamentoId, String idFiscaleCliente,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdFiscaleCliente_PrevAndNext(
			pagamentoId, idFiscaleCliente, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where idFiscaleCliente = &#63; from the database.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 */
	public static void removeByIdFiscaleCliente(String idFiscaleCliente) {
		getPersistence().removeByIdFiscaleCliente(idFiscaleCliente);
	}

	/**
	 * Returns the number of pagamentos where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @return the number of matching pagamentos
	 */
	public static int countByIdFiscaleCliente(String idFiscaleCliente) {
		return getPersistence().countByIdFiscaleCliente(idFiscaleCliente);
	}

	/**
	 * Returns all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId) {

		return getPersistence().findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId);
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
	public static List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end) {

		return getPersistence().findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, start, end);
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
	public static List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, start, end, orderByComparator);
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
	public static List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId, start, end, orderByComparator,
			useFinderCache);
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
	public static Pagamento findByIdFiscaleClienteGroupId_First(
			String idFiscaleCliente, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdFiscaleClienteGroupId_First(
			idFiscaleCliente, groupId, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdFiscaleClienteGroupId_First(
		String idFiscaleCliente, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIdFiscaleClienteGroupId_First(
			idFiscaleCliente, groupId, orderByComparator);
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
	public static Pagamento findByIdFiscaleClienteGroupId_Last(
			String idFiscaleCliente, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdFiscaleClienteGroupId_Last(
			idFiscaleCliente, groupId, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdFiscaleClienteGroupId_Last(
		String idFiscaleCliente, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIdFiscaleClienteGroupId_Last(
			idFiscaleCliente, groupId, orderByComparator);
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
	public static Pagamento[] findByIdFiscaleClienteGroupId_PrevAndNext(
			long pagamentoId, String idFiscaleCliente, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdFiscaleClienteGroupId_PrevAndNext(
			pagamentoId, idFiscaleCliente, groupId, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63; from the database.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 */
	public static void removeByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId) {

		getPersistence().removeByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId);
	}

	/**
	 * Returns the number of pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	public static int countByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId) {

		return getPersistence().countByIdFiscaleClienteGroupId(
			idFiscaleCliente, groupId);
	}

	/**
	 * Returns all the pagamentos where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByEmailInviata(boolean emailInviata) {
		return getPersistence().findByEmailInviata(emailInviata);
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
	public static List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end) {

		return getPersistence().findByEmailInviata(emailInviata, start, end);
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
	public static List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByEmailInviata(
			emailInviata, start, end, orderByComparator);
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
	public static List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmailInviata(
			emailInviata, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByEmailInviata_First(
			boolean emailInviata,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByEmailInviata_First(
			emailInviata, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByEmailInviata_First(
		boolean emailInviata, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByEmailInviata_First(
			emailInviata, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByEmailInviata_Last(
			boolean emailInviata,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByEmailInviata_Last(
			emailInviata, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByEmailInviata_Last(
		boolean emailInviata, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByEmailInviata_Last(
			emailInviata, orderByComparator);
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
	public static Pagamento[] findByEmailInviata_PrevAndNext(
			long pagamentoId, boolean emailInviata,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByEmailInviata_PrevAndNext(
			pagamentoId, emailInviata, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where emailInviata = &#63; from the database.
	 *
	 * @param emailInviata the email inviata
	 */
	public static void removeByEmailInviata(boolean emailInviata) {
		getPersistence().removeByEmailInviata(emailInviata);
	}

	/**
	 * Returns the number of pagamentos where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @return the number of matching pagamentos
	 */
	public static int countByEmailInviata(boolean emailInviata) {
		return getPersistence().countByEmailInviata(emailInviata);
	}

	/**
	 * Returns all the pagamentos where iud = &#63;.
	 *
	 * @param iud the iud
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByIud(String iud) {
		return getPersistence().findByIud(iud);
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
	public static List<Pagamento> findByIud(String iud, int start, int end) {
		return getPersistence().findByIud(iud, start, end);
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
	public static List<Pagamento> findByIud(
		String iud, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByIud(iud, start, end, orderByComparator);
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
	public static List<Pagamento> findByIud(
		String iud, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIud(
			iud, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIud_First(
			String iud, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIud_First(iud, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIud_First(
		String iud, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIud_First(iud, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIud_Last(
			String iud, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIud_Last(iud, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIud_Last(
		String iud, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByIud_Last(iud, orderByComparator);
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
	public static Pagamento[] findByIud_PrevAndNext(
			long pagamentoId, String iud,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIud_PrevAndNext(
			pagamentoId, iud, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where iud = &#63; from the database.
	 *
	 * @param iud the iud
	 */
	public static void removeByIud(String iud) {
		getPersistence().removeByIud(iud);
	}

	/**
	 * Returns the number of pagamentos where iud = &#63;.
	 *
	 * @param iud the iud
	 * @return the number of matching pagamentos
	 */
	public static int countByIud(String iud) {
		return getPersistence().countByIud(iud);
	}

	/**
	 * Returns the pagamento where iuv = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param iuv the iuv
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIuv(String iuv)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIuv(iuv);
	}

	/**
	 * Returns the pagamento where iuv = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param iuv the iuv
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIuv(String iuv) {
		return getPersistence().fetchByIuv(iuv);
	}

	/**
	 * Returns the pagamento where iuv = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param iuv the iuv
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIuv(String iuv, boolean useFinderCache) {
		return getPersistence().fetchByIuv(iuv, useFinderCache);
	}

	/**
	 * Removes the pagamento where iuv = &#63; from the database.
	 *
	 * @param iuv the iuv
	 * @return the pagamento that was removed
	 */
	public static Pagamento removeByIuv(String iuv)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().removeByIuv(iuv);
	}

	/**
	 * Returns the number of pagamentos where iuv = &#63;.
	 *
	 * @param iuv the iuv
	 * @return the number of matching pagamentos
	 */
	public static int countByIuv(String iuv) {
		return getPersistence().countByIuv(iuv);
	}

	/**
	 * Returns the pagamento where idSessione = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param idSessione the id sessione
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByIdSessione(String idSessione)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByIdSessione(idSessione);
	}

	/**
	 * Returns the pagamento where idSessione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idSessione the id sessione
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdSessione(String idSessione) {
		return getPersistence().fetchByIdSessione(idSessione);
	}

	/**
	 * Returns the pagamento where idSessione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idSessione the id sessione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByIdSessione(
		String idSessione, boolean useFinderCache) {

		return getPersistence().fetchByIdSessione(idSessione, useFinderCache);
	}

	/**
	 * Removes the pagamento where idSessione = &#63; from the database.
	 *
	 * @param idSessione the id sessione
	 * @return the pagamento that was removed
	 */
	public static Pagamento removeByIdSessione(String idSessione)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().removeByIdSessione(idSessione);
	}

	/**
	 * Returns the number of pagamentos where idSessione = &#63;.
	 *
	 * @param idSessione the id sessione
	 * @return the number of matching pagamentos
	 */
	public static int countByIdSessione(String idSessione) {
		return getPersistence().countByIdSessione(idSessione);
	}

	/**
	 * Returns the pagamento where richiestaId = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByRichiestaId(long richiestaId)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByRichiestaId(richiestaId);
	}

	/**
	 * Returns the pagamento where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByRichiestaId(long richiestaId) {
		return getPersistence().fetchByRichiestaId(richiestaId);
	}

	/**
	 * Returns the pagamento where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByRichiestaId(
		long richiestaId, boolean useFinderCache) {

		return getPersistence().fetchByRichiestaId(richiestaId, useFinderCache);
	}

	/**
	 * Removes the pagamento where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the pagamento that was removed
	 */
	public static Pagamento removeByRichiestaId(long richiestaId)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().removeByRichiestaId(richiestaId);
	}

	/**
	 * Returns the number of pagamentos where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching pagamentos
	 */
	public static int countByRichiestaId(long richiestaId) {
		return getPersistence().countByRichiestaId(richiestaId);
	}

	/**
	 * Returns all the pagamentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByStato(String stato) {
		return getPersistence().findByStato(stato);
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
	public static List<Pagamento> findByStato(
		String stato, int start, int end) {

		return getPersistence().findByStato(stato, start, end);
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
	public static List<Pagamento> findByStato(
		String stato, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator);
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
	public static List<Pagamento> findByStato(
		String stato, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStato(
			stato, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByStato_First(
			String stato, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByStato_First(
		String stato, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByStato_First(stato, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public static Pagamento findByStato_Last(
			String stato, OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByStato_Last(stato, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByStato_Last(
		String stato, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByStato_Last(stato, orderByComparator);
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
	public static Pagamento[] findByStato_PrevAndNext(
			long pagamentoId, String stato,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByStato_PrevAndNext(
			pagamentoId, stato, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public static void removeByStato(String stato) {
		getPersistence().removeByStato(stato);
	}

	/**
	 * Returns the number of pagamentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching pagamentos
	 */
	public static int countByStato(String stato) {
		return getPersistence().countByStato(stato);
	}

	/**
	 * Returns all the pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @return the matching pagamentos
	 */
	public static List<Pagamento> findByStatoGroupId(
		String stato, long groupId) {

		return getPersistence().findByStatoGroupId(stato, groupId);
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
	public static List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end) {

		return getPersistence().findByStatoGroupId(stato, groupId, start, end);
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
	public static List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findByStatoGroupId(
			stato, groupId, start, end, orderByComparator);
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
	public static List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end,
		OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatoGroupId(
			stato, groupId, start, end, orderByComparator, useFinderCache);
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
	public static Pagamento findByStatoGroupId_First(
			String stato, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByStatoGroupId_First(
			stato, groupId, orderByComparator);
	}

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByStatoGroupId_First(
		String stato, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByStatoGroupId_First(
			stato, groupId, orderByComparator);
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
	public static Pagamento findByStatoGroupId_Last(
			String stato, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByStatoGroupId_Last(
			stato, groupId, orderByComparator);
	}

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public static Pagamento fetchByStatoGroupId_Last(
		String stato, long groupId,
		OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().fetchByStatoGroupId_Last(
			stato, groupId, orderByComparator);
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
	public static Pagamento[] findByStatoGroupId_PrevAndNext(
			long pagamentoId, String stato, long groupId,
			OrderByComparator<Pagamento> orderByComparator)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByStatoGroupId_PrevAndNext(
			pagamentoId, stato, groupId, orderByComparator);
	}

	/**
	 * Removes all the pagamentos where stato = &#63; and groupId = &#63; from the database.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 */
	public static void removeByStatoGroupId(String stato, long groupId) {
		getPersistence().removeByStatoGroupId(stato, groupId);
	}

	/**
	 * Returns the number of pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	public static int countByStatoGroupId(String stato, long groupId) {
		return getPersistence().countByStatoGroupId(stato, groupId);
	}

	/**
	 * Caches the pagamento in the entity cache if it is enabled.
	 *
	 * @param pagamento the pagamento
	 */
	public static void cacheResult(Pagamento pagamento) {
		getPersistence().cacheResult(pagamento);
	}

	/**
	 * Caches the pagamentos in the entity cache if it is enabled.
	 *
	 * @param pagamentos the pagamentos
	 */
	public static void cacheResult(List<Pagamento> pagamentos) {
		getPersistence().cacheResult(pagamentos);
	}

	/**
	 * Creates a new pagamento with the primary key. Does not add the pagamento to the database.
	 *
	 * @param pagamentoId the primary key for the new pagamento
	 * @return the new pagamento
	 */
	public static Pagamento create(long pagamentoId) {
		return getPersistence().create(pagamentoId);
	}

	/**
	 * Removes the pagamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento that was removed
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public static Pagamento remove(long pagamentoId)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().remove(pagamentoId);
	}

	public static Pagamento updateImpl(Pagamento pagamento) {
		return getPersistence().updateImpl(pagamento);
	}

	/**
	 * Returns the pagamento with the primary key or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public static Pagamento findByPrimaryKey(long pagamentoId)
		throws it.servizidigitali.gestionepagamenti.exception.
			NoSuchPagamentoException {

		return getPersistence().findByPrimaryKey(pagamentoId);
	}

	/**
	 * Returns the pagamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento, or <code>null</code> if a pagamento with the primary key could not be found
	 */
	public static Pagamento fetchByPrimaryKey(long pagamentoId) {
		return getPersistence().fetchByPrimaryKey(pagamentoId);
	}

	/**
	 * Returns all the pagamentos.
	 *
	 * @return the pagamentos
	 */
	public static List<Pagamento> findAll() {
		return getPersistence().findAll();
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
	public static List<Pagamento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Pagamento> findAll(
		int start, int end, OrderByComparator<Pagamento> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Pagamento> findAll(
		int start, int end, OrderByComparator<Pagamento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pagamentos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pagamentos.
	 *
	 * @return the number of pagamentos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PagamentoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PagamentoPersistence _persistence;

}