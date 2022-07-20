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

package it.servizidigitali.profiloutente.model.impl;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.servizidigitali.profiloutente.model.UtenteOrganizzazione;
import it.servizidigitali.profiloutente.model.UtenteOrganizzazioneModel;
import it.servizidigitali.profiloutente.service.persistence.UtenteOrganizzazionePK;

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
 * The base model implementation for the UtenteOrganizzazione service. Represents a row in the &quot;utente_organizzazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UtenteOrganizzazioneModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UtenteOrganizzazioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteOrganizzazioneImpl
 * @generated
 */
public class UtenteOrganizzazioneModelImpl
	extends BaseModelImpl<UtenteOrganizzazione>
	implements UtenteOrganizzazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a utente organizzazione model instance should use the <code>UtenteOrganizzazione</code> interface instead.
	 */
	public static final String TABLE_NAME = "utente_organizzazione";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"utenteId", Types.BIGINT},
		{"organizationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"preferito", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("utenteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("preferito", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table utente_organizzazione (uuid_ VARCHAR(75) null,utenteId LONG not null,organizationId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,preferito BOOLEAN,primary key (utenteId, organizationId))";

	public static final String TABLE_SQL_DROP =
		"drop table utente_organizzazione";

	public static final String ORDER_BY_JPQL =
		" ORDER BY utenteOrganizzazione.id.utenteId ASC, utenteOrganizzazione.id.organizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY utente_organizzazione.utenteId ASC, utente_organizzazione.organizationId ASC";

	public static final String DATA_SOURCE = "servizidigitaliDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ORGANIZATIONID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PREFERITO_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UTENTEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

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

	public UtenteOrganizzazioneModelImpl() {
	}

	@Override
	public UtenteOrganizzazionePK getPrimaryKey() {
		return new UtenteOrganizzazionePK(_utenteId, _organizationId);
	}

	@Override
	public void setPrimaryKey(UtenteOrganizzazionePK primaryKey) {
		setUtenteId(primaryKey.utenteId);
		setOrganizationId(primaryKey.organizationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UtenteOrganizzazionePK(_utenteId, _organizationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UtenteOrganizzazionePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UtenteOrganizzazione.class;
	}

	@Override
	public String getModelClassName() {
		return UtenteOrganizzazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UtenteOrganizzazione, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UtenteOrganizzazione, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UtenteOrganizzazione, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((UtenteOrganizzazione)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UtenteOrganizzazione, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UtenteOrganizzazione, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UtenteOrganizzazione)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UtenteOrganizzazione, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UtenteOrganizzazione, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UtenteOrganizzazione>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UtenteOrganizzazione.class.getClassLoader(),
			UtenteOrganizzazione.class, ModelWrapper.class);

		try {
			Constructor<UtenteOrganizzazione> constructor =
				(Constructor<UtenteOrganizzazione>)proxyClass.getConstructor(
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

	private static final Map<String, Function<UtenteOrganizzazione, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UtenteOrganizzazione, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UtenteOrganizzazione, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<UtenteOrganizzazione, Object>>();
		Map<String, BiConsumer<UtenteOrganizzazione, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<UtenteOrganizzazione, ?>>();

		attributeGetterFunctions.put("uuid", UtenteOrganizzazione::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<UtenteOrganizzazione, String>)
				UtenteOrganizzazione::setUuid);
		attributeGetterFunctions.put(
			"utenteId", UtenteOrganizzazione::getUtenteId);
		attributeSetterBiConsumers.put(
			"utenteId",
			(BiConsumer<UtenteOrganizzazione, Long>)
				UtenteOrganizzazione::setUtenteId);
		attributeGetterFunctions.put(
			"organizationId", UtenteOrganizzazione::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<UtenteOrganizzazione, Long>)
				UtenteOrganizzazione::setOrganizationId);
		attributeGetterFunctions.put(
			"groupId", UtenteOrganizzazione::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<UtenteOrganizzazione, Long>)
				UtenteOrganizzazione::setGroupId);
		attributeGetterFunctions.put(
			"companyId", UtenteOrganizzazione::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<UtenteOrganizzazione, Long>)
				UtenteOrganizzazione::setCompanyId);
		attributeGetterFunctions.put("userId", UtenteOrganizzazione::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<UtenteOrganizzazione, Long>)
				UtenteOrganizzazione::setUserId);
		attributeGetterFunctions.put(
			"userName", UtenteOrganizzazione::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<UtenteOrganizzazione, String>)
				UtenteOrganizzazione::setUserName);
		attributeGetterFunctions.put(
			"createDate", UtenteOrganizzazione::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<UtenteOrganizzazione, Date>)
				UtenteOrganizzazione::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", UtenteOrganizzazione::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<UtenteOrganizzazione, Date>)
				UtenteOrganizzazione::setModifiedDate);
		attributeGetterFunctions.put(
			"preferito", UtenteOrganizzazione::getPreferito);
		attributeSetterBiConsumers.put(
			"preferito",
			(BiConsumer<UtenteOrganizzazione, Boolean>)
				UtenteOrganizzazione::setPreferito);

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
	public long getUtenteId() {
		return _utenteId;
	}

	@Override
	public void setUtenteId(long utenteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_utenteId = utenteId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUtenteId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("utenteId"));
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOrganizationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("organizationId"));
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
	public boolean getPreferito() {
		return _preferito;
	}

	@Override
	public boolean isPreferito() {
		return _preferito;
	}

	@Override
	public void setPreferito(boolean preferito) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_preferito = preferito;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalPreferito() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("preferito"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(UtenteOrganizzazione.class.getName()));
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
	public UtenteOrganizzazione toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UtenteOrganizzazione>
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
		UtenteOrganizzazioneImpl utenteOrganizzazioneImpl =
			new UtenteOrganizzazioneImpl();

		utenteOrganizzazioneImpl.setUuid(getUuid());
		utenteOrganizzazioneImpl.setUtenteId(getUtenteId());
		utenteOrganizzazioneImpl.setOrganizationId(getOrganizationId());
		utenteOrganizzazioneImpl.setGroupId(getGroupId());
		utenteOrganizzazioneImpl.setCompanyId(getCompanyId());
		utenteOrganizzazioneImpl.setUserId(getUserId());
		utenteOrganizzazioneImpl.setUserName(getUserName());
		utenteOrganizzazioneImpl.setCreateDate(getCreateDate());
		utenteOrganizzazioneImpl.setModifiedDate(getModifiedDate());
		utenteOrganizzazioneImpl.setPreferito(isPreferito());

		utenteOrganizzazioneImpl.resetOriginalValues();

		return utenteOrganizzazioneImpl;
	}

	@Override
	public UtenteOrganizzazione cloneWithOriginalValues() {
		UtenteOrganizzazioneImpl utenteOrganizzazioneImpl =
			new UtenteOrganizzazioneImpl();

		utenteOrganizzazioneImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		utenteOrganizzazioneImpl.setUtenteId(
			this.<Long>getColumnOriginalValue("utenteId"));
		utenteOrganizzazioneImpl.setOrganizationId(
			this.<Long>getColumnOriginalValue("organizationId"));
		utenteOrganizzazioneImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		utenteOrganizzazioneImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		utenteOrganizzazioneImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		utenteOrganizzazioneImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		utenteOrganizzazioneImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		utenteOrganizzazioneImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		utenteOrganizzazioneImpl.setPreferito(
			this.<Boolean>getColumnOriginalValue("preferito"));

		return utenteOrganizzazioneImpl;
	}

	@Override
	public int compareTo(UtenteOrganizzazione utenteOrganizzazione) {
		UtenteOrganizzazionePK primaryKey =
			utenteOrganizzazione.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UtenteOrganizzazione)) {
			return false;
		}

		UtenteOrganizzazione utenteOrganizzazione =
			(UtenteOrganizzazione)object;

		UtenteOrganizzazionePK primaryKey =
			utenteOrganizzazione.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
	public CacheModel<UtenteOrganizzazione> toCacheModel() {
		UtenteOrganizzazioneCacheModel utenteOrganizzazioneCacheModel =
			new UtenteOrganizzazioneCacheModel();

		utenteOrganizzazioneCacheModel.utenteOrganizzazionePK = getPrimaryKey();

		utenteOrganizzazioneCacheModel.uuid = getUuid();

		String uuid = utenteOrganizzazioneCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			utenteOrganizzazioneCacheModel.uuid = null;
		}

		utenteOrganizzazioneCacheModel.utenteId = getUtenteId();

		utenteOrganizzazioneCacheModel.organizationId = getOrganizationId();

		utenteOrganizzazioneCacheModel.groupId = getGroupId();

		utenteOrganizzazioneCacheModel.companyId = getCompanyId();

		utenteOrganizzazioneCacheModel.userId = getUserId();

		utenteOrganizzazioneCacheModel.userName = getUserName();

		String userName = utenteOrganizzazioneCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			utenteOrganizzazioneCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			utenteOrganizzazioneCacheModel.createDate = createDate.getTime();
		}
		else {
			utenteOrganizzazioneCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			utenteOrganizzazioneCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			utenteOrganizzazioneCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		utenteOrganizzazioneCacheModel.preferito = isPreferito();

		return utenteOrganizzazioneCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UtenteOrganizzazione, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UtenteOrganizzazione, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UtenteOrganizzazione, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(UtenteOrganizzazione)this);

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
		Map<String, Function<UtenteOrganizzazione, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UtenteOrganizzazione, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UtenteOrganizzazione, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((UtenteOrganizzazione)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UtenteOrganizzazione>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _utenteId;
	private long _organizationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _preferito;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<UtenteOrganizzazione, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((UtenteOrganizzazione)this);
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
		_columnOriginalValues.put("utenteId", _utenteId);
		_columnOriginalValues.put("organizationId", _organizationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("preferito", _preferito);
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

		columnBitmasks.put("utenteId", 2L);

		columnBitmasks.put("organizationId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("preferito", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private UtenteOrganizzazione _escapedModel;

}