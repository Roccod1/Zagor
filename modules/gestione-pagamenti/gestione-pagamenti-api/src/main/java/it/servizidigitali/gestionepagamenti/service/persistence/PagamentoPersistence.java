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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.servizidigitali.gestionepagamenti.exception.NoSuchPagamentoException;
import it.servizidigitali.gestionepagamenti.model.Pagamento;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pagamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PagamentoUtil
 * @generated
 */
@ProviderType
public interface PagamentoPersistence extends BasePersistence<Pagamento> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PagamentoUtil} to access the pagamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pagamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByUuid(String uuid);

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
	public java.util.List<Pagamento> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Pagamento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where uuid = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento[] findByUuid_PrevAndNext(
			long pagamentoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of pagamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pagamentos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByUUID_G(String uuid, long groupId)
		throws NoSuchPagamentoException;

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the pagamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the pagamento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pagamento that was removed
	 */
	public Pagamento removeByUUID_G(String uuid, long groupId)
		throws NoSuchPagamentoException;

	/**
	 * Returns the number of pagamentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public Pagamento[] findByUuid_C_PrevAndNext(
			long pagamentoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of pagamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pagamentos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the pagamentos where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByIdCredito(String idCredito);

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
	public java.util.List<Pagamento> findByIdCredito(
		String idCredito, int start, int end);

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
	public java.util.List<Pagamento> findByIdCredito(
		String idCredito, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByIdCredito(
		String idCredito, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdCredito_First(
			String idCredito,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdCredito_First(
		String idCredito,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdCredito_Last(
			String idCredito,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdCredito_Last(
		String idCredito,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where idCredito = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param idCredito the id credito
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento[] findByIdCredito_PrevAndNext(
			long pagamentoId, String idCredito,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where idCredito = &#63; from the database.
	 *
	 * @param idCredito the id credito
	 */
	public void removeByIdCredito(String idCredito);

	/**
	 * Returns the number of pagamentos where idCredito = &#63;.
	 *
	 * @param idCredito the id credito
	 * @return the number of matching pagamentos
	 */
	public int countByIdCredito(String idCredito);

	/**
	 * Returns all the pagamentos where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente);

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
	public java.util.List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end);

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
	public java.util.List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByIdFiscaleCliente(
		String idFiscaleCliente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdFiscaleCliente_First(
			String idFiscaleCliente,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdFiscaleCliente_First(
		String idFiscaleCliente,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdFiscaleCliente_Last(
			String idFiscaleCliente,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdFiscaleCliente_Last(
		String idFiscaleCliente,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where idFiscaleCliente = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento[] findByIdFiscaleCliente_PrevAndNext(
			long pagamentoId, String idFiscaleCliente,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where idFiscaleCliente = &#63; from the database.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 */
	public void removeByIdFiscaleCliente(String idFiscaleCliente);

	/**
	 * Returns the number of pagamentos where idFiscaleCliente = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @return the number of matching pagamentos
	 */
	public int countByIdFiscaleCliente(String idFiscaleCliente);

	/**
	 * Returns all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId);

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
	public java.util.List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end);

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
	public java.util.List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdFiscaleClienteGroupId_First(
			String idFiscaleCliente, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdFiscaleClienteGroupId_First(
		String idFiscaleCliente, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdFiscaleClienteGroupId_Last(
			String idFiscaleCliente, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdFiscaleClienteGroupId_Last(
		String idFiscaleCliente, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public Pagamento[] findByIdFiscaleClienteGroupId_PrevAndNext(
			long pagamentoId, String idFiscaleCliente, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where idFiscaleCliente = &#63; and groupId = &#63; from the database.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 */
	public void removeByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId);

	/**
	 * Returns the number of pagamentos where idFiscaleCliente = &#63; and groupId = &#63;.
	 *
	 * @param idFiscaleCliente the id fiscale cliente
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	public int countByIdFiscaleClienteGroupId(
		String idFiscaleCliente, long groupId);

	/**
	 * Returns all the pagamentos where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByEmailInviata(boolean emailInviata);

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
	public java.util.List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end);

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
	public java.util.List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByEmailInviata(
		boolean emailInviata, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByEmailInviata_First(
			boolean emailInviata,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByEmailInviata_First(
		boolean emailInviata,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByEmailInviata_Last(
			boolean emailInviata,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByEmailInviata_Last(
		boolean emailInviata,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where emailInviata = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param emailInviata the email inviata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento[] findByEmailInviata_PrevAndNext(
			long pagamentoId, boolean emailInviata,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where emailInviata = &#63; from the database.
	 *
	 * @param emailInviata the email inviata
	 */
	public void removeByEmailInviata(boolean emailInviata);

	/**
	 * Returns the number of pagamentos where emailInviata = &#63;.
	 *
	 * @param emailInviata the email inviata
	 * @return the number of matching pagamentos
	 */
	public int countByEmailInviata(boolean emailInviata);

	/**
	 * Returns all the pagamentos where iud = &#63;.
	 *
	 * @param iud the iud
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByIud(String iud);

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
	public java.util.List<Pagamento> findByIud(String iud, int start, int end);

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
	public java.util.List<Pagamento> findByIud(
		String iud, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByIud(
		String iud, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIud_First(
			String iud,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIud_First(
		String iud,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIud_Last(
			String iud,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where iud = &#63;.
	 *
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIud_Last(
		String iud,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where iud = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param iud the iud
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento[] findByIud_PrevAndNext(
			long pagamentoId, String iud,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where iud = &#63; from the database.
	 *
	 * @param iud the iud
	 */
	public void removeByIud(String iud);

	/**
	 * Returns the number of pagamentos where iud = &#63;.
	 *
	 * @param iud the iud
	 * @return the number of matching pagamentos
	 */
	public int countByIud(String iud);

	/**
	 * Returns the pagamento where iuv = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param iuv the iuv
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIuv(String iuv) throws NoSuchPagamentoException;

	/**
	 * Returns the pagamento where iuv = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param iuv the iuv
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIuv(String iuv);

	/**
	 * Returns the pagamento where iuv = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param iuv the iuv
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIuv(String iuv, boolean useFinderCache);

	/**
	 * Removes the pagamento where iuv = &#63; from the database.
	 *
	 * @param iuv the iuv
	 * @return the pagamento that was removed
	 */
	public Pagamento removeByIuv(String iuv) throws NoSuchPagamentoException;

	/**
	 * Returns the number of pagamentos where iuv = &#63;.
	 *
	 * @param iuv the iuv
	 * @return the number of matching pagamentos
	 */
	public int countByIuv(String iuv);

	/**
	 * Returns the pagamento where idSessione = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param idSessione the id sessione
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByIdSessione(String idSessione)
		throws NoSuchPagamentoException;

	/**
	 * Returns the pagamento where idSessione = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idSessione the id sessione
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdSessione(String idSessione);

	/**
	 * Returns the pagamento where idSessione = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idSessione the id sessione
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByIdSessione(
		String idSessione, boolean useFinderCache);

	/**
	 * Removes the pagamento where idSessione = &#63; from the database.
	 *
	 * @param idSessione the id sessione
	 * @return the pagamento that was removed
	 */
	public Pagamento removeByIdSessione(String idSessione)
		throws NoSuchPagamentoException;

	/**
	 * Returns the number of pagamentos where idSessione = &#63;.
	 *
	 * @param idSessione the id sessione
	 * @return the number of matching pagamentos
	 */
	public int countByIdSessione(String idSessione);

	/**
	 * Returns the pagamento where richiestaId = &#63; or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByRichiestaId(long richiestaId)
		throws NoSuchPagamentoException;

	/**
	 * Returns the pagamento where richiestaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByRichiestaId(long richiestaId);

	/**
	 * Returns the pagamento where richiestaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param richiestaId the richiesta ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByRichiestaId(
		long richiestaId, boolean useFinderCache);

	/**
	 * Removes the pagamento where richiestaId = &#63; from the database.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the pagamento that was removed
	 */
	public Pagamento removeByRichiestaId(long richiestaId)
		throws NoSuchPagamentoException;

	/**
	 * Returns the number of pagamentos where richiestaId = &#63;.
	 *
	 * @param richiestaId the richiesta ID
	 * @return the number of matching pagamentos
	 */
	public int countByRichiestaId(long richiestaId);

	/**
	 * Returns all the pagamentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByStato(String stato);

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
	public java.util.List<Pagamento> findByStato(
		String stato, int start, int end);

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
	public java.util.List<Pagamento> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByStato(
		String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByStato_First(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByStato_First(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByStato_Last(
			String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63;.
	 *
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByStato_Last(
		String stato,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the pagamentos before and after the current pagamento in the ordered set where stato = &#63;.
	 *
	 * @param pagamentoId the primary key of the current pagamento
	 * @param stato the stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento[] findByStato_PrevAndNext(
			long pagamentoId, String stato,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where stato = &#63; from the database.
	 *
	 * @param stato the stato
	 */
	public void removeByStato(String stato);

	/**
	 * Returns the number of pagamentos where stato = &#63;.
	 *
	 * @param stato the stato
	 * @return the number of matching pagamentos
	 */
	public int countByStato(String stato);

	/**
	 * Returns all the pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @return the matching pagamentos
	 */
	public java.util.List<Pagamento> findByStatoGroupId(
		String stato, long groupId);

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
	public java.util.List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end);

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
	public java.util.List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findByStatoGroupId(
		String stato, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByStatoGroupId_First(
			String stato, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the first pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByStatoGroupId_First(
		String stato, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento
	 * @throws NoSuchPagamentoException if a matching pagamento could not be found
	 */
	public Pagamento findByStatoGroupId_Last(
			String stato, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Returns the last pagamento in the ordered set where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pagamento, or <code>null</code> if a matching pagamento could not be found
	 */
	public Pagamento fetchByStatoGroupId_Last(
		String stato, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public Pagamento[] findByStatoGroupId_PrevAndNext(
			long pagamentoId, String stato, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
				orderByComparator)
		throws NoSuchPagamentoException;

	/**
	 * Removes all the pagamentos where stato = &#63; and groupId = &#63; from the database.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 */
	public void removeByStatoGroupId(String stato, long groupId);

	/**
	 * Returns the number of pagamentos where stato = &#63; and groupId = &#63;.
	 *
	 * @param stato the stato
	 * @param groupId the group ID
	 * @return the number of matching pagamentos
	 */
	public int countByStatoGroupId(String stato, long groupId);

	/**
	 * Caches the pagamento in the entity cache if it is enabled.
	 *
	 * @param pagamento the pagamento
	 */
	public void cacheResult(Pagamento pagamento);

	/**
	 * Caches the pagamentos in the entity cache if it is enabled.
	 *
	 * @param pagamentos the pagamentos
	 */
	public void cacheResult(java.util.List<Pagamento> pagamentos);

	/**
	 * Creates a new pagamento with the primary key. Does not add the pagamento to the database.
	 *
	 * @param pagamentoId the primary key for the new pagamento
	 * @return the new pagamento
	 */
	public Pagamento create(long pagamentoId);

	/**
	 * Removes the pagamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento that was removed
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento remove(long pagamentoId) throws NoSuchPagamentoException;

	public Pagamento updateImpl(Pagamento pagamento);

	/**
	 * Returns the pagamento with the primary key or throws a <code>NoSuchPagamentoException</code> if it could not be found.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento
	 * @throws NoSuchPagamentoException if a pagamento with the primary key could not be found
	 */
	public Pagamento findByPrimaryKey(long pagamentoId)
		throws NoSuchPagamentoException;

	/**
	 * Returns the pagamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pagamentoId the primary key of the pagamento
	 * @return the pagamento, or <code>null</code> if a pagamento with the primary key could not be found
	 */
	public Pagamento fetchByPrimaryKey(long pagamentoId);

	/**
	 * Returns all the pagamentos.
	 *
	 * @return the pagamentos
	 */
	public java.util.List<Pagamento> findAll();

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
	public java.util.List<Pagamento> findAll(int start, int end);

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
	public java.util.List<Pagamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator);

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
	public java.util.List<Pagamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pagamento>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pagamentos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pagamentos.
	 *
	 * @return the number of pagamentos
	 */
	public int countAll();

}