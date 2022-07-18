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

package it.servizidigitali.gestioneforms.model.impl;

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

import it.servizidigitali.gestioneforms.model.DefinizioneAllegato;
import it.servizidigitali.gestioneforms.model.DefinizioneAllegatoModel;

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
 * The base model implementation for the DefinizioneAllegato service. Represents a row in the &quot;definizione_allegato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DefinizioneAllegatoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DefinizioneAllegatoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DefinizioneAllegatoImpl
 * @generated
 */
public class DefinizioneAllegatoModelImpl
	extends BaseModelImpl<DefinizioneAllegato>
	implements DefinizioneAllegatoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a definizione allegato model instance should use the <code>DefinizioneAllegato</code> interface instead.
	 */
	public static final String TABLE_NAME = "definizione_allegato";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"definizioneAllegatoId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"denominazione", Types.VARCHAR}, {"fileEntryId", Types.BIGINT},
		{"filenameModello", Types.VARCHAR}, {"tipiFileAmmessi", Types.VARCHAR},
		{"codiciTipologiaDocumento", Types.VARCHAR},
		{"obbligatorio", Types.BOOLEAN}, {"eliminato", Types.BOOLEAN},
		{"organizationId", Types.BIGINT}, {"formId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("definizioneAllegatoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("denominazione", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("filenameModello", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tipiFileAmmessi", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("codiciTipologiaDocumento", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("obbligatorio", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("eliminato", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("formId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table definizione_allegato (uuid_ VARCHAR(75) null,definizioneAllegatoId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,denominazione VARCHAR(75) null,fileEntryId LONG,filenameModello VARCHAR(75) null,tipiFileAmmessi VARCHAR(75) null,codiciTipologiaDocumento VARCHAR(75) null,obbligatorio BOOLEAN,eliminato BOOLEAN,organizationId LONG,formId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table definizione_allegato";

	public static final String ORDER_BY_JPQL =
		" ORDER BY definizioneAllegato.definizioneAllegatoId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY definizione_allegato.definizioneAllegatoId ASC";

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
	public static final long FORMID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEFINIZIONEALLEGATOID_COLUMN_BITMASK = 16L;

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

	public DefinizioneAllegatoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _definizioneAllegatoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDefinizioneAllegatoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _definizioneAllegatoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DefinizioneAllegato.class;
	}

	@Override
	public String getModelClassName() {
		return DefinizioneAllegato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DefinizioneAllegato, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DefinizioneAllegato, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DefinizioneAllegato, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DefinizioneAllegato)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DefinizioneAllegato, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DefinizioneAllegato, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DefinizioneAllegato)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DefinizioneAllegato, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DefinizioneAllegato, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DefinizioneAllegato>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DefinizioneAllegato.class.getClassLoader(),
			DefinizioneAllegato.class, ModelWrapper.class);

		try {
			Constructor<DefinizioneAllegato> constructor =
				(Constructor<DefinizioneAllegato>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DefinizioneAllegato, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DefinizioneAllegato, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DefinizioneAllegato, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DefinizioneAllegato, Object>>();
		Map<String, BiConsumer<DefinizioneAllegato, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DefinizioneAllegato, ?>>();

		attributeGetterFunctions.put("uuid", DefinizioneAllegato::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DefinizioneAllegato, String>)
				DefinizioneAllegato::setUuid);
		attributeGetterFunctions.put(
			"definizioneAllegatoId",
			DefinizioneAllegato::getDefinizioneAllegatoId);
		attributeSetterBiConsumers.put(
			"definizioneAllegatoId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setDefinizioneAllegatoId);
		attributeGetterFunctions.put(
			"groupId", DefinizioneAllegato::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DefinizioneAllegato::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setCompanyId);
		attributeGetterFunctions.put("userId", DefinizioneAllegato::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setUserId);
		attributeGetterFunctions.put(
			"userName", DefinizioneAllegato::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DefinizioneAllegato, String>)
				DefinizioneAllegato::setUserName);
		attributeGetterFunctions.put(
			"createDate", DefinizioneAllegato::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DefinizioneAllegato, Date>)
				DefinizioneAllegato::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DefinizioneAllegato::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DefinizioneAllegato, Date>)
				DefinizioneAllegato::setModifiedDate);
		attributeGetterFunctions.put(
			"denominazione", DefinizioneAllegato::getDenominazione);
		attributeSetterBiConsumers.put(
			"denominazione",
			(BiConsumer<DefinizioneAllegato, String>)
				DefinizioneAllegato::setDenominazione);
		attributeGetterFunctions.put(
			"fileEntryId", DefinizioneAllegato::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setFileEntryId);
		attributeGetterFunctions.put(
			"filenameModello", DefinizioneAllegato::getFilenameModello);
		attributeSetterBiConsumers.put(
			"filenameModello",
			(BiConsumer<DefinizioneAllegato, String>)
				DefinizioneAllegato::setFilenameModello);
		attributeGetterFunctions.put(
			"tipiFileAmmessi", DefinizioneAllegato::getTipiFileAmmessi);
		attributeSetterBiConsumers.put(
			"tipiFileAmmessi",
			(BiConsumer<DefinizioneAllegato, String>)
				DefinizioneAllegato::setTipiFileAmmessi);
		attributeGetterFunctions.put(
			"codiciTipologiaDocumento",
			DefinizioneAllegato::getCodiciTipologiaDocumento);
		attributeSetterBiConsumers.put(
			"codiciTipologiaDocumento",
			(BiConsumer<DefinizioneAllegato, String>)
				DefinizioneAllegato::setCodiciTipologiaDocumento);
		attributeGetterFunctions.put(
			"obbligatorio", DefinizioneAllegato::getObbligatorio);
		attributeSetterBiConsumers.put(
			"obbligatorio",
			(BiConsumer<DefinizioneAllegato, Boolean>)
				DefinizioneAllegato::setObbligatorio);
		attributeGetterFunctions.put(
			"eliminato", DefinizioneAllegato::getEliminato);
		attributeSetterBiConsumers.put(
			"eliminato",
			(BiConsumer<DefinizioneAllegato, Boolean>)
				DefinizioneAllegato::setEliminato);
		attributeGetterFunctions.put(
			"organizationId", DefinizioneAllegato::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setOrganizationId);
		attributeGetterFunctions.put("formId", DefinizioneAllegato::getFormId);
		attributeSetterBiConsumers.put(
			"formId",
			(BiConsumer<DefinizioneAllegato, Long>)
				DefinizioneAllegato::setFormId);

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
	public long getDefinizioneAllegatoId() {
		return _definizioneAllegatoId;
	}

	@Override
	public void setDefinizioneAllegatoId(long definizioneAllegatoId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_definizioneAllegatoId = definizioneAllegatoId;
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
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileEntryId = fileEntryId;
	}

	@Override
	public String getFilenameModello() {
		if (_filenameModello == null) {
			return "";
		}
		else {
			return _filenameModello;
		}
	}

	@Override
	public void setFilenameModello(String filenameModello) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_filenameModello = filenameModello;
	}

	@Override
	public String getTipiFileAmmessi() {
		if (_tipiFileAmmessi == null) {
			return "";
		}
		else {
			return _tipiFileAmmessi;
		}
	}

	@Override
	public void setTipiFileAmmessi(String tipiFileAmmessi) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tipiFileAmmessi = tipiFileAmmessi;
	}

	@Override
	public String getCodiciTipologiaDocumento() {
		if (_codiciTipologiaDocumento == null) {
			return "";
		}
		else {
			return _codiciTipologiaDocumento;
		}
	}

	@Override
	public void setCodiciTipologiaDocumento(String codiciTipologiaDocumento) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_codiciTipologiaDocumento = codiciTipologiaDocumento;
	}

	@Override
	public boolean getObbligatorio() {
		return _obbligatorio;
	}

	@Override
	public boolean isObbligatorio() {
		return _obbligatorio;
	}

	@Override
	public void setObbligatorio(boolean obbligatorio) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_obbligatorio = obbligatorio;
	}

	@Override
	public boolean getEliminato() {
		return _eliminato;
	}

	@Override
	public boolean isEliminato() {
		return _eliminato;
	}

	@Override
	public void setEliminato(boolean eliminato) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_eliminato = eliminato;
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
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_formId = formId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFormId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("formId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DefinizioneAllegato.class.getName()));
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
			getCompanyId(), DefinizioneAllegato.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DefinizioneAllegato toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DefinizioneAllegato>
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
		DefinizioneAllegatoImpl definizioneAllegatoImpl =
			new DefinizioneAllegatoImpl();

		definizioneAllegatoImpl.setUuid(getUuid());
		definizioneAllegatoImpl.setDefinizioneAllegatoId(
			getDefinizioneAllegatoId());
		definizioneAllegatoImpl.setGroupId(getGroupId());
		definizioneAllegatoImpl.setCompanyId(getCompanyId());
		definizioneAllegatoImpl.setUserId(getUserId());
		definizioneAllegatoImpl.setUserName(getUserName());
		definizioneAllegatoImpl.setCreateDate(getCreateDate());
		definizioneAllegatoImpl.setModifiedDate(getModifiedDate());
		definizioneAllegatoImpl.setDenominazione(getDenominazione());
		definizioneAllegatoImpl.setFileEntryId(getFileEntryId());
		definizioneAllegatoImpl.setFilenameModello(getFilenameModello());
		definizioneAllegatoImpl.setTipiFileAmmessi(getTipiFileAmmessi());
		definizioneAllegatoImpl.setCodiciTipologiaDocumento(
			getCodiciTipologiaDocumento());
		definizioneAllegatoImpl.setObbligatorio(isObbligatorio());
		definizioneAllegatoImpl.setEliminato(isEliminato());
		definizioneAllegatoImpl.setOrganizationId(getOrganizationId());
		definizioneAllegatoImpl.setFormId(getFormId());

		definizioneAllegatoImpl.resetOriginalValues();

		return definizioneAllegatoImpl;
	}

	@Override
	public DefinizioneAllegato cloneWithOriginalValues() {
		DefinizioneAllegatoImpl definizioneAllegatoImpl =
			new DefinizioneAllegatoImpl();

		definizioneAllegatoImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		definizioneAllegatoImpl.setDefinizioneAllegatoId(
			this.<Long>getColumnOriginalValue("definizioneAllegatoId"));
		definizioneAllegatoImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		definizioneAllegatoImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		definizioneAllegatoImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		definizioneAllegatoImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		definizioneAllegatoImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		definizioneAllegatoImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		definizioneAllegatoImpl.setDenominazione(
			this.<String>getColumnOriginalValue("denominazione"));
		definizioneAllegatoImpl.setFileEntryId(
			this.<Long>getColumnOriginalValue("fileEntryId"));
		definizioneAllegatoImpl.setFilenameModello(
			this.<String>getColumnOriginalValue("filenameModello"));
		definizioneAllegatoImpl.setTipiFileAmmessi(
			this.<String>getColumnOriginalValue("tipiFileAmmessi"));
		definizioneAllegatoImpl.setCodiciTipologiaDocumento(
			this.<String>getColumnOriginalValue("codiciTipologiaDocumento"));
		definizioneAllegatoImpl.setObbligatorio(
			this.<Boolean>getColumnOriginalValue("obbligatorio"));
		definizioneAllegatoImpl.setEliminato(
			this.<Boolean>getColumnOriginalValue("eliminato"));
		definizioneAllegatoImpl.setOrganizationId(
			this.<Long>getColumnOriginalValue("organizationId"));
		definizioneAllegatoImpl.setFormId(
			this.<Long>getColumnOriginalValue("formId"));

		return definizioneAllegatoImpl;
	}

	@Override
	public int compareTo(DefinizioneAllegato definizioneAllegato) {
		long primaryKey = definizioneAllegato.getPrimaryKey();

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

		if (!(object instanceof DefinizioneAllegato)) {
			return false;
		}

		DefinizioneAllegato definizioneAllegato = (DefinizioneAllegato)object;

		long primaryKey = definizioneAllegato.getPrimaryKey();

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
	public CacheModel<DefinizioneAllegato> toCacheModel() {
		DefinizioneAllegatoCacheModel definizioneAllegatoCacheModel =
			new DefinizioneAllegatoCacheModel();

		definizioneAllegatoCacheModel.uuid = getUuid();

		String uuid = definizioneAllegatoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			definizioneAllegatoCacheModel.uuid = null;
		}

		definizioneAllegatoCacheModel.definizioneAllegatoId =
			getDefinizioneAllegatoId();

		definizioneAllegatoCacheModel.groupId = getGroupId();

		definizioneAllegatoCacheModel.companyId = getCompanyId();

		definizioneAllegatoCacheModel.userId = getUserId();

		definizioneAllegatoCacheModel.userName = getUserName();

		String userName = definizioneAllegatoCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			definizioneAllegatoCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			definizioneAllegatoCacheModel.createDate = createDate.getTime();
		}
		else {
			definizioneAllegatoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			definizioneAllegatoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			definizioneAllegatoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		definizioneAllegatoCacheModel.denominazione = getDenominazione();

		String denominazione = definizioneAllegatoCacheModel.denominazione;

		if ((denominazione != null) && (denominazione.length() == 0)) {
			definizioneAllegatoCacheModel.denominazione = null;
		}

		definizioneAllegatoCacheModel.fileEntryId = getFileEntryId();

		definizioneAllegatoCacheModel.filenameModello = getFilenameModello();

		String filenameModello = definizioneAllegatoCacheModel.filenameModello;

		if ((filenameModello != null) && (filenameModello.length() == 0)) {
			definizioneAllegatoCacheModel.filenameModello = null;
		}

		definizioneAllegatoCacheModel.tipiFileAmmessi = getTipiFileAmmessi();

		String tipiFileAmmessi = definizioneAllegatoCacheModel.tipiFileAmmessi;

		if ((tipiFileAmmessi != null) && (tipiFileAmmessi.length() == 0)) {
			definizioneAllegatoCacheModel.tipiFileAmmessi = null;
		}

		definizioneAllegatoCacheModel.codiciTipologiaDocumento =
			getCodiciTipologiaDocumento();

		String codiciTipologiaDocumento =
			definizioneAllegatoCacheModel.codiciTipologiaDocumento;

		if ((codiciTipologiaDocumento != null) &&
			(codiciTipologiaDocumento.length() == 0)) {

			definizioneAllegatoCacheModel.codiciTipologiaDocumento = null;
		}

		definizioneAllegatoCacheModel.obbligatorio = isObbligatorio();

		definizioneAllegatoCacheModel.eliminato = isEliminato();

		definizioneAllegatoCacheModel.organizationId = getOrganizationId();

		definizioneAllegatoCacheModel.formId = getFormId();

		return definizioneAllegatoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DefinizioneAllegato, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DefinizioneAllegato, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DefinizioneAllegato, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DefinizioneAllegato)this);

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
		Map<String, Function<DefinizioneAllegato, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DefinizioneAllegato, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DefinizioneAllegato, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DefinizioneAllegato)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DefinizioneAllegato>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _definizioneAllegatoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _denominazione;
	private long _fileEntryId;
	private String _filenameModello;
	private String _tipiFileAmmessi;
	private String _codiciTipologiaDocumento;
	private boolean _obbligatorio;
	private boolean _eliminato;
	private long _organizationId;
	private long _formId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DefinizioneAllegato, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DefinizioneAllegato)this);
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
			"definizioneAllegatoId", _definizioneAllegatoId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("denominazione", _denominazione);
		_columnOriginalValues.put("fileEntryId", _fileEntryId);
		_columnOriginalValues.put("filenameModello", _filenameModello);
		_columnOriginalValues.put("tipiFileAmmessi", _tipiFileAmmessi);
		_columnOriginalValues.put(
			"codiciTipologiaDocumento", _codiciTipologiaDocumento);
		_columnOriginalValues.put("obbligatorio", _obbligatorio);
		_columnOriginalValues.put("eliminato", _eliminato);
		_columnOriginalValues.put("organizationId", _organizationId);
		_columnOriginalValues.put("formId", _formId);
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

		columnBitmasks.put("definizioneAllegatoId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("denominazione", 256L);

		columnBitmasks.put("fileEntryId", 512L);

		columnBitmasks.put("filenameModello", 1024L);

		columnBitmasks.put("tipiFileAmmessi", 2048L);

		columnBitmasks.put("codiciTipologiaDocumento", 4096L);

		columnBitmasks.put("obbligatorio", 8192L);

		columnBitmasks.put("eliminato", 16384L);

		columnBitmasks.put("organizationId", 32768L);

		columnBitmasks.put("formId", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DefinizioneAllegato _escapedModel;

}