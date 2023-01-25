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

package it.servizidigitali.accreditamentoenti.model.impl;

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

import it.servizidigitali.accreditamentoenti.model.Ente;
import it.servizidigitali.accreditamentoenti.model.EnteModel;

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
 * The base model implementation for the Ente service. Represents a row in the &quot;ente&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EnteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EnteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnteImpl
 * @generated
 */
public class EnteModelImpl extends BaseModelImpl<Ente> implements EnteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ente model instance should use the <code>Ente</code> interface instead.
	 */
	public static final String TABLE_NAME = "ente";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"enteId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"denominazione", Types.VARCHAR},
		{"strutturaRiferimento", Types.VARCHAR}, {"sitoWeb", Types.VARCHAR},
		{"tipo", Types.VARCHAR}, {"codiceIPA", Types.VARCHAR},
		{"pec", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("enteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("denominazione", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("strutturaRiferimento", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sitoWeb", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tipo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("codiceIPA", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pec", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ente (uuid_ VARCHAR(75) null,enteId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,denominazione VARCHAR(75) null,strutturaRiferimento VARCHAR(75) null,sitoWeb VARCHAR(75) null,tipo VARCHAR(75) null,codiceIPA VARCHAR(75) null,pec VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table ente";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ente.denominazione ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ente.denominazione ASC";

	public static final String DATA_SOURCE = "accreditamentoentiDataSource";

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
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DENOMINAZIONE_COLUMN_BITMASK = 8L;

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

	public EnteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _enteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEnteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _enteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Ente.class;
	}

	@Override
	public String getModelClassName() {
		return Ente.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Ente, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Ente, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ente, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Ente)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Ente, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Ente, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Ente)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Ente, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Ente, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Ente>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Ente.class.getClassLoader(), Ente.class, ModelWrapper.class);

		try {
			Constructor<Ente> constructor =
				(Constructor<Ente>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Ente, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Ente, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Ente, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Ente, Object>>();
		Map<String, BiConsumer<Ente, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Ente, ?>>();

		attributeGetterFunctions.put("uuid", Ente::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Ente, String>)Ente::setUuid);
		attributeGetterFunctions.put("enteId", Ente::getEnteId);
		attributeSetterBiConsumers.put(
			"enteId", (BiConsumer<Ente, Long>)Ente::setEnteId);
		attributeGetterFunctions.put("groupId", Ente::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Ente, Long>)Ente::setGroupId);
		attributeGetterFunctions.put("companyId", Ente::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Ente, Long>)Ente::setCompanyId);
		attributeGetterFunctions.put("userId", Ente::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Ente, Long>)Ente::setUserId);
		attributeGetterFunctions.put("userName", Ente::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Ente, String>)Ente::setUserName);
		attributeGetterFunctions.put("createDate", Ente::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Ente, Date>)Ente::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Ente::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Ente, Date>)Ente::setModifiedDate);
		attributeGetterFunctions.put("denominazione", Ente::getDenominazione);
		attributeSetterBiConsumers.put(
			"denominazione", (BiConsumer<Ente, String>)Ente::setDenominazione);
		attributeGetterFunctions.put(
			"strutturaRiferimento", Ente::getStrutturaRiferimento);
		attributeSetterBiConsumers.put(
			"strutturaRiferimento",
			(BiConsumer<Ente, String>)Ente::setStrutturaRiferimento);
		attributeGetterFunctions.put("sitoWeb", Ente::getSitoWeb);
		attributeSetterBiConsumers.put(
			"sitoWeb", (BiConsumer<Ente, String>)Ente::setSitoWeb);
		attributeGetterFunctions.put("tipo", Ente::getTipo);
		attributeSetterBiConsumers.put(
			"tipo", (BiConsumer<Ente, String>)Ente::setTipo);
		attributeGetterFunctions.put("codiceIPA", Ente::getCodiceIPA);
		attributeSetterBiConsumers.put(
			"codiceIPA", (BiConsumer<Ente, String>)Ente::setCodiceIPA);
		attributeGetterFunctions.put("pec", Ente::getPec);
		attributeSetterBiConsumers.put(
			"pec", (BiConsumer<Ente, String>)Ente::setPec);

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
	public long getEnteId() {
		return _enteId;
	}

	@Override
	public void setEnteId(long enteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_enteId = enteId;
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
	public String getDenominazione() {
		if (_denominazione == null) {
			return "";
		}
		else {
			return _denominazione;
		}
	}

	@Override
	public void setDenominazione(String denominazione) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_denominazione = denominazione;
	}

	@Override
	public String getStrutturaRiferimento() {
		if (_strutturaRiferimento == null) {
			return "";
		}
		else {
			return _strutturaRiferimento;
		}
	}

	@Override
	public void setStrutturaRiferimento(String strutturaRiferimento) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_strutturaRiferimento = strutturaRiferimento;
	}

	@Override
	public String getSitoWeb() {
		if (_sitoWeb == null) {
			return "";
		}
		else {
			return _sitoWeb;
		}
	}

	@Override
	public void setSitoWeb(String sitoWeb) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sitoWeb = sitoWeb;
	}

	@Override
	public String getTipo() {
		if (_tipo == null) {
			return "";
		}
		else {
			return _tipo;
		}
	}

	@Override
	public void setTipo(String tipo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tipo = tipo;
	}

	@Override
	public String getCodiceIPA() {
		if (_codiceIPA == null) {
			return "";
		}
		else {
			return _codiceIPA;
		}
	}

	@Override
	public void setCodiceIPA(String codiceIPA) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_codiceIPA = codiceIPA;
	}

	@Override
	public String getPec() {
		if (_pec == null) {
			return "";
		}
		else {
			return _pec;
		}
	}

	@Override
	public void setPec(String pec) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_pec = pec;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Ente.class.getName()));
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
			getCompanyId(), Ente.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Ente toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Ente>
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
		EnteImpl enteImpl = new EnteImpl();

		enteImpl.setUuid(getUuid());
		enteImpl.setEnteId(getEnteId());
		enteImpl.setGroupId(getGroupId());
		enteImpl.setCompanyId(getCompanyId());
		enteImpl.setUserId(getUserId());
		enteImpl.setUserName(getUserName());
		enteImpl.setCreateDate(getCreateDate());
		enteImpl.setModifiedDate(getModifiedDate());
		enteImpl.setDenominazione(getDenominazione());
		enteImpl.setStrutturaRiferimento(getStrutturaRiferimento());
		enteImpl.setSitoWeb(getSitoWeb());
		enteImpl.setTipo(getTipo());
		enteImpl.setCodiceIPA(getCodiceIPA());
		enteImpl.setPec(getPec());

		enteImpl.resetOriginalValues();

		return enteImpl;
	}

	@Override
	public Ente cloneWithOriginalValues() {
		EnteImpl enteImpl = new EnteImpl();

		enteImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		enteImpl.setEnteId(this.<Long>getColumnOriginalValue("enteId"));
		enteImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		enteImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		enteImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		enteImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		enteImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		enteImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		enteImpl.setDenominazione(
			this.<String>getColumnOriginalValue("denominazione"));
		enteImpl.setStrutturaRiferimento(
			this.<String>getColumnOriginalValue("strutturaRiferimento"));
		enteImpl.setSitoWeb(this.<String>getColumnOriginalValue("sitoWeb"));
		enteImpl.setTipo(this.<String>getColumnOriginalValue("tipo"));
		enteImpl.setCodiceIPA(this.<String>getColumnOriginalValue("codiceIPA"));
		enteImpl.setPec(this.<String>getColumnOriginalValue("pec"));

		return enteImpl;
	}

	@Override
	public int compareTo(Ente ente) {
		int value = 0;

		value = getDenominazione().compareTo(ente.getDenominazione());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Ente)) {
			return false;
		}

		Ente ente = (Ente)object;

		long primaryKey = ente.getPrimaryKey();

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
	public CacheModel<Ente> toCacheModel() {
		EnteCacheModel enteCacheModel = new EnteCacheModel();

		enteCacheModel.uuid = getUuid();

		String uuid = enteCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			enteCacheModel.uuid = null;
		}

		enteCacheModel.enteId = getEnteId();

		enteCacheModel.groupId = getGroupId();

		enteCacheModel.companyId = getCompanyId();

		enteCacheModel.userId = getUserId();

		enteCacheModel.userName = getUserName();

		String userName = enteCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			enteCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			enteCacheModel.createDate = createDate.getTime();
		}
		else {
			enteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			enteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			enteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		enteCacheModel.denominazione = getDenominazione();

		String denominazione = enteCacheModel.denominazione;

		if ((denominazione != null) && (denominazione.length() == 0)) {
			enteCacheModel.denominazione = null;
		}

		enteCacheModel.strutturaRiferimento = getStrutturaRiferimento();

		String strutturaRiferimento = enteCacheModel.strutturaRiferimento;

		if ((strutturaRiferimento != null) &&
			(strutturaRiferimento.length() == 0)) {

			enteCacheModel.strutturaRiferimento = null;
		}

		enteCacheModel.sitoWeb = getSitoWeb();

		String sitoWeb = enteCacheModel.sitoWeb;

		if ((sitoWeb != null) && (sitoWeb.length() == 0)) {
			enteCacheModel.sitoWeb = null;
		}

		enteCacheModel.tipo = getTipo();

		String tipo = enteCacheModel.tipo;

		if ((tipo != null) && (tipo.length() == 0)) {
			enteCacheModel.tipo = null;
		}

		enteCacheModel.codiceIPA = getCodiceIPA();

		String codiceIPA = enteCacheModel.codiceIPA;

		if ((codiceIPA != null) && (codiceIPA.length() == 0)) {
			enteCacheModel.codiceIPA = null;
		}

		enteCacheModel.pec = getPec();

		String pec = enteCacheModel.pec;

		if ((pec != null) && (pec.length() == 0)) {
			enteCacheModel.pec = null;
		}

		return enteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Ente, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Ente, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ente, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Ente)this);

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
		Map<String, Function<Ente, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Ente, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ente, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Ente)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Ente>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _enteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _denominazione;
	private String _strutturaRiferimento;
	private String _sitoWeb;
	private String _tipo;
	private String _codiceIPA;
	private String _pec;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Ente, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Ente)this);
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
		_columnOriginalValues.put("enteId", _enteId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("denominazione", _denominazione);
		_columnOriginalValues.put(
			"strutturaRiferimento", _strutturaRiferimento);
		_columnOriginalValues.put("sitoWeb", _sitoWeb);
		_columnOriginalValues.put("tipo", _tipo);
		_columnOriginalValues.put("codiceIPA", _codiceIPA);
		_columnOriginalValues.put("pec", _pec);
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

		columnBitmasks.put("enteId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("denominazione", 256L);

		columnBitmasks.put("strutturaRiferimento", 512L);

		columnBitmasks.put("sitoWeb", 1024L);

		columnBitmasks.put("tipo", 2048L);

		columnBitmasks.put("codiceIPA", 4096L);

		columnBitmasks.put("pec", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Ente _escapedModel;

}