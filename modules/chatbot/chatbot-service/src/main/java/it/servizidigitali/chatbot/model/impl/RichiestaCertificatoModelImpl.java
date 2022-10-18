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

package it.servizidigitali.chatbot.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.servizidigitali.chatbot.model.RichiestaCertificato;
import it.servizidigitali.chatbot.model.RichiestaCertificatoModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RichiestaCertificato service. Represents a row in the &quot;richiesta_certificato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RichiestaCertificatoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RichiestaCertificatoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaCertificatoImpl
 * @generated
 */
public class RichiestaCertificatoModelImpl
	extends BaseModelImpl<RichiestaCertificato>
	implements RichiestaCertificatoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a richiesta certificato model instance should use the <code>RichiestaCertificato</code> interface instead.
	 */
	public static final String TABLE_NAME = "richiesta_certificato";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"richiestaCertificatoId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"codiceFiscale", Types.VARCHAR}, {"stato", Types.VARCHAR},
		{"errore", Types.VARCHAR}, {"servizioId", Types.BIGINT},
		{"organizationId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("richiestaCertificatoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("codiceFiscale", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stato", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("errore", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("servizioId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table richiesta_certificato (uuid_ VARCHAR(75) null,richiestaCertificatoId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,codiceFiscale VARCHAR(75) null,stato VARCHAR(75) null,errore VARCHAR(75) null,servizioId LONG,organizationId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table richiesta_certificato";

	public static final String ORDER_BY_JPQL =
		" ORDER BY richiestaCertificato.richiestaCertificatoId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY richiesta_certificato.richiestaCertificatoId ASC";

	public static final String DATA_SOURCE = "servizidigitaliDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CODICEFISCALE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SERVIZIOID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATO_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RICHIESTACERTIFICATOID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public RichiestaCertificatoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _richiestaCertificatoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRichiestaCertificatoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiestaCertificatoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RichiestaCertificato.class;
	}

	@Override
	public String getModelClassName() {
		return RichiestaCertificato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RichiestaCertificato, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RichiestaCertificato, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RichiestaCertificato, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RichiestaCertificato)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RichiestaCertificato, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RichiestaCertificato, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RichiestaCertificato)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RichiestaCertificato, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RichiestaCertificato, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RichiestaCertificato>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RichiestaCertificato.class.getClassLoader(),
			RichiestaCertificato.class, ModelWrapper.class);

		try {
			Constructor<RichiestaCertificato> constructor =
				(Constructor<RichiestaCertificato>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<RichiestaCertificato, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RichiestaCertificato, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RichiestaCertificato, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<RichiestaCertificato, Object>>();
		Map<String, BiConsumer<RichiestaCertificato, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<RichiestaCertificato, ?>>();

		attributeGetterFunctions.put("uuid", RichiestaCertificato::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<RichiestaCertificato, String>)
				RichiestaCertificato::setUuid);
		attributeGetterFunctions.put(
			"richiestaCertificatoId",
			RichiestaCertificato::getRichiestaCertificatoId);
		attributeSetterBiConsumers.put(
			"richiestaCertificatoId",
			(BiConsumer<RichiestaCertificato, Long>)
				RichiestaCertificato::setRichiestaCertificatoId);
		attributeGetterFunctions.put(
			"groupId", RichiestaCertificato::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<RichiestaCertificato, Long>)
				RichiestaCertificato::setGroupId);
		attributeGetterFunctions.put(
			"companyId", RichiestaCertificato::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<RichiestaCertificato, Long>)
				RichiestaCertificato::setCompanyId);
		attributeGetterFunctions.put("userId", RichiestaCertificato::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<RichiestaCertificato, Long>)
				RichiestaCertificato::setUserId);
		attributeGetterFunctions.put(
			"userName", RichiestaCertificato::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<RichiestaCertificato, String>)
				RichiestaCertificato::setUserName);
		attributeGetterFunctions.put(
			"createDate", RichiestaCertificato::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<RichiestaCertificato, Date>)
				RichiestaCertificato::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", RichiestaCertificato::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<RichiestaCertificato, Date>)
				RichiestaCertificato::setModifiedDate);
		attributeGetterFunctions.put(
			"codiceFiscale", RichiestaCertificato::getCodiceFiscale);
		attributeSetterBiConsumers.put(
			"codiceFiscale",
			(BiConsumer<RichiestaCertificato, String>)
				RichiestaCertificato::setCodiceFiscale);
		attributeGetterFunctions.put("stato", RichiestaCertificato::getStato);
		attributeSetterBiConsumers.put(
			"stato",
			(BiConsumer<RichiestaCertificato, String>)
				RichiestaCertificato::setStato);
		attributeGetterFunctions.put("errore", RichiestaCertificato::getErrore);
		attributeSetterBiConsumers.put(
			"errore",
			(BiConsumer<RichiestaCertificato, String>)
				RichiestaCertificato::setErrore);
		attributeGetterFunctions.put(
			"servizioId", RichiestaCertificato::getServizioId);
		attributeSetterBiConsumers.put(
			"servizioId",
			(BiConsumer<RichiestaCertificato, Long>)
				RichiestaCertificato::setServizioId);
		attributeGetterFunctions.put(
			"organizationId", RichiestaCertificato::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<RichiestaCertificato, Long>)
				RichiestaCertificato::setOrganizationId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getRichiestaCertificatoId() {
		return _richiestaCertificatoId;
	}

	@Override
	public void setRichiestaCertificatoId(long richiestaCertificatoId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_richiestaCertificatoId = richiestaCertificatoId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getCodiceFiscale() {
		if (_codiceFiscale == null) {
			return "";
		}
		else {
			return _codiceFiscale;
		}
	}

	@Override
	public void setCodiceFiscale(String codiceFiscale) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_codiceFiscale = codiceFiscale;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCodiceFiscale() {
		return getColumnOriginalValue("codiceFiscale");
	}

	@Override
	public String getStato() {
		if (_stato == null) {
			return "";
		}
		else {
			return _stato;
		}
	}

	@Override
	public void setStato(String stato) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_stato = stato;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStato() {
		return getColumnOriginalValue("stato");
	}

	@Override
	public String getErrore() {
		if (_errore == null) {
			return "";
		}
		else {
			return _errore;
		}
	}

	@Override
	public void setErrore(String errore) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_errore = errore;
	}

	@Override
	public long getServizioId() {
		return _servizioId;
	}

	@Override
	public void setServizioId(long servizioId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_servizioId = servizioId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalServizioId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("servizioId"));
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_organizationId = organizationId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(RichiestaCertificato.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), RichiestaCertificato.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RichiestaCertificato toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RichiestaCertificato>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RichiestaCertificatoImpl richiestaCertificatoImpl =
			new RichiestaCertificatoImpl();

		richiestaCertificatoImpl.setUuid(getUuid());
		richiestaCertificatoImpl.setRichiestaCertificatoId(
			getRichiestaCertificatoId());
		richiestaCertificatoImpl.setGroupId(getGroupId());
		richiestaCertificatoImpl.setCompanyId(getCompanyId());
		richiestaCertificatoImpl.setUserId(getUserId());
		richiestaCertificatoImpl.setUserName(getUserName());
		richiestaCertificatoImpl.setCreateDate(getCreateDate());
		richiestaCertificatoImpl.setModifiedDate(getModifiedDate());
		richiestaCertificatoImpl.setCodiceFiscale(getCodiceFiscale());
		richiestaCertificatoImpl.setStato(getStato());
		richiestaCertificatoImpl.setErrore(getErrore());
		richiestaCertificatoImpl.setServizioId(getServizioId());
		richiestaCertificatoImpl.setOrganizationId(getOrganizationId());

		richiestaCertificatoImpl.resetOriginalValues();

		return richiestaCertificatoImpl;
	}

	@Override
	public RichiestaCertificato cloneWithOriginalValues() {
		RichiestaCertificatoImpl richiestaCertificatoImpl =
			new RichiestaCertificatoImpl();

		richiestaCertificatoImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		richiestaCertificatoImpl.setRichiestaCertificatoId(
			this.<Long>getColumnOriginalValue("richiestaCertificatoId"));
		richiestaCertificatoImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		richiestaCertificatoImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		richiestaCertificatoImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		richiestaCertificatoImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		richiestaCertificatoImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		richiestaCertificatoImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		richiestaCertificatoImpl.setCodiceFiscale(
			this.<String>getColumnOriginalValue("codiceFiscale"));
		richiestaCertificatoImpl.setStato(
			this.<String>getColumnOriginalValue("stato"));
		richiestaCertificatoImpl.setErrore(
			this.<String>getColumnOriginalValue("errore"));
		richiestaCertificatoImpl.setServizioId(
			this.<Long>getColumnOriginalValue("servizioId"));
		richiestaCertificatoImpl.setOrganizationId(
			this.<Long>getColumnOriginalValue("organizationId"));

		return richiestaCertificatoImpl;
	}

	@Override
	public int compareTo(RichiestaCertificato richiestaCertificato) {
		long primaryKey = richiestaCertificato.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RichiestaCertificato)) {
			return false;
		}

		RichiestaCertificato richiestaCertificato =
			(RichiestaCertificato)object;

		long primaryKey = richiestaCertificato.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<RichiestaCertificato> toCacheModel() {
		RichiestaCertificatoCacheModel richiestaCertificatoCacheModel =
			new RichiestaCertificatoCacheModel();

		richiestaCertificatoCacheModel.uuid = getUuid();

		String uuid = richiestaCertificatoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			richiestaCertificatoCacheModel.uuid = null;
		}

		richiestaCertificatoCacheModel.richiestaCertificatoId =
			getRichiestaCertificatoId();

		richiestaCertificatoCacheModel.groupId = getGroupId();

		richiestaCertificatoCacheModel.companyId = getCompanyId();

		richiestaCertificatoCacheModel.userId = getUserId();

		richiestaCertificatoCacheModel.userName = getUserName();

		String userName = richiestaCertificatoCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			richiestaCertificatoCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			richiestaCertificatoCacheModel.createDate = createDate.getTime();
		}
		else {
			richiestaCertificatoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			richiestaCertificatoCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			richiestaCertificatoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		richiestaCertificatoCacheModel.codiceFiscale = getCodiceFiscale();

		String codiceFiscale = richiestaCertificatoCacheModel.codiceFiscale;

		if ((codiceFiscale != null) && (codiceFiscale.length() == 0)) {
			richiestaCertificatoCacheModel.codiceFiscale = null;
		}

		richiestaCertificatoCacheModel.stato = getStato();

		String stato = richiestaCertificatoCacheModel.stato;

		if ((stato != null) && (stato.length() == 0)) {
			richiestaCertificatoCacheModel.stato = null;
		}

		richiestaCertificatoCacheModel.errore = getErrore();

		String errore = richiestaCertificatoCacheModel.errore;

		if ((errore != null) && (errore.length() == 0)) {
			richiestaCertificatoCacheModel.errore = null;
		}

		richiestaCertificatoCacheModel.servizioId = getServizioId();

		richiestaCertificatoCacheModel.organizationId = getOrganizationId();

		return richiestaCertificatoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RichiestaCertificato, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RichiestaCertificato, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RichiestaCertificato, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(RichiestaCertificato)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<RichiestaCertificato, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RichiestaCertificato, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RichiestaCertificato, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((RichiestaCertificato)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RichiestaCertificato>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _richiestaCertificatoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _codiceFiscale;
	private String _stato;
	private String _errore;
	private long _servizioId;
	private long _organizationId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<RichiestaCertificato, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RichiestaCertificato)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"richiestaCertificatoId", _richiestaCertificatoId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("codiceFiscale", _codiceFiscale);
		_columnOriginalValues.put("stato", _stato);
		_columnOriginalValues.put("errore", _errore);
		_columnOriginalValues.put("servizioId", _servizioId);
		_columnOriginalValues.put("organizationId", _organizationId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("richiestaCertificatoId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("codiceFiscale", 256L);

		columnBitmasks.put("stato", 512L);

		columnBitmasks.put("errore", 1024L);

		columnBitmasks.put("servizioId", 2048L);

		columnBitmasks.put("organizationId", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RichiestaCertificato _escapedModel;

}