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

import it.servizidigitali.gestioneforms.model.Form;
import it.servizidigitali.gestioneforms.model.FormModel;

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
 * The base model implementation for the Form service. Represents a row in the &quot;form&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FormModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormImpl
 * @generated
 */
public class FormModelImpl extends BaseModelImpl<Form> implements FormModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form model instance should use the <code>Form</code> interface instead.
	 */
	public static final String TABLE_NAME = "form";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"formId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"nome", Types.VARCHAR}, {"descrizione", Types.VARCHAR},
		{"codice", Types.VARCHAR}, {"json", Types.VARCHAR},
		{"principale", Types.BOOLEAN}, {"organizationId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("codice", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("json", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("principale", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table form (uuid_ VARCHAR(75) null,formId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,nome VARCHAR(75) null,descrizione VARCHAR(75) null,codice VARCHAR(75) null,json VARCHAR(75) null,principale BOOLEAN,organizationId LONG)";

	public static final String TABLE_SQL_DROP = "drop table form";

	public static final String ORDER_BY_JPQL = " ORDER BY form.nome ASC";

	public static final String ORDER_BY_SQL = " ORDER BY form.nome ASC";

	public static final String DATA_SOURCE = "servizidigitaliDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CODICE_COLUMN_BITMASK = 1L;

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
	public static final long PRINCIPALE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NOME_COLUMN_BITMASK = 32L;

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

	public FormModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _formId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Form.class;
	}

	@Override
	public String getModelClassName() {
		return Form.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Form, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Form, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Form, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Form)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Form, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Form, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Form)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Form, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Form, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Form>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Form.class.getClassLoader(), Form.class, ModelWrapper.class);

		try {
			Constructor<Form> constructor =
				(Constructor<Form>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Form, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Form, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Form, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Form, Object>>();
		Map<String, BiConsumer<Form, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Form, ?>>();

		attributeGetterFunctions.put("uuid", Form::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Form, String>)Form::setUuid);
		attributeGetterFunctions.put("formId", Form::getFormId);
		attributeSetterBiConsumers.put(
			"formId", (BiConsumer<Form, Long>)Form::setFormId);
		attributeGetterFunctions.put("groupId", Form::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Form, Long>)Form::setGroupId);
		attributeGetterFunctions.put("companyId", Form::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Form, Long>)Form::setCompanyId);
		attributeGetterFunctions.put("userId", Form::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Form, Long>)Form::setUserId);
		attributeGetterFunctions.put("userName", Form::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Form, String>)Form::setUserName);
		attributeGetterFunctions.put("createDate", Form::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Form, Date>)Form::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Form::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Form, Date>)Form::setModifiedDate);
		attributeGetterFunctions.put("nome", Form::getNome);
		attributeSetterBiConsumers.put(
			"nome", (BiConsumer<Form, String>)Form::setNome);
		attributeGetterFunctions.put("descrizione", Form::getDescrizione);
		attributeSetterBiConsumers.put(
			"descrizione", (BiConsumer<Form, String>)Form::setDescrizione);
		attributeGetterFunctions.put("codice", Form::getCodice);
		attributeSetterBiConsumers.put(
			"codice", (BiConsumer<Form, String>)Form::setCodice);
		attributeGetterFunctions.put("json", Form::getJson);
		attributeSetterBiConsumers.put(
			"json", (BiConsumer<Form, String>)Form::setJson);
		attributeGetterFunctions.put("principale", Form::getPrincipale);
		attributeSetterBiConsumers.put(
			"principale", (BiConsumer<Form, Boolean>)Form::setPrincipale);
		attributeGetterFunctions.put("organizationId", Form::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId", (BiConsumer<Form, Long>)Form::setOrganizationId);

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
	public String getNome() {
		if (_nome == null) {
			return "";
		}
		else {
			return _nome;
		}
	}

	@Override
	public void setNome(String nome) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nome = nome;
	}

	@Override
	public String getDescrizione() {
		if (_descrizione == null) {
			return "";
		}
		else {
			return _descrizione;
		}
	}

	@Override
	public void setDescrizione(String descrizione) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_descrizione = descrizione;
	}

	@Override
	public String getCodice() {
		if (_codice == null) {
			return "";
		}
		else {
			return _codice;
		}
	}

	@Override
	public void setCodice(String codice) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_codice = codice;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCodice() {
		return getColumnOriginalValue("codice");
	}

	@Override
	public String getJson() {
		if (_json == null) {
			return "";
		}
		else {
			return _json;
		}
	}

	@Override
	public void setJson(String json) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_json = json;
	}

	@Override
	public boolean getPrincipale() {
		return _principale;
	}

	@Override
	public boolean isPrincipale() {
		return _principale;
	}

	@Override
	public void setPrincipale(boolean principale) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_principale = principale;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalPrincipale() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("principale"));
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
			PortalUtil.getClassNameId(Form.class.getName()));
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
			getCompanyId(), Form.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Form toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Form>
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
		FormImpl formImpl = new FormImpl();

		formImpl.setUuid(getUuid());
		formImpl.setFormId(getFormId());
		formImpl.setGroupId(getGroupId());
		formImpl.setCompanyId(getCompanyId());
		formImpl.setUserId(getUserId());
		formImpl.setUserName(getUserName());
		formImpl.setCreateDate(getCreateDate());
		formImpl.setModifiedDate(getModifiedDate());
		formImpl.setNome(getNome());
		formImpl.setDescrizione(getDescrizione());
		formImpl.setCodice(getCodice());
		formImpl.setJson(getJson());
		formImpl.setPrincipale(isPrincipale());
		formImpl.setOrganizationId(getOrganizationId());

		formImpl.resetOriginalValues();

		return formImpl;
	}

	@Override
	public Form cloneWithOriginalValues() {
		FormImpl formImpl = new FormImpl();

		formImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		formImpl.setFormId(this.<Long>getColumnOriginalValue("formId"));
		formImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		formImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		formImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		formImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		formImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		formImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		formImpl.setNome(this.<String>getColumnOriginalValue("nome"));
		formImpl.setDescrizione(
			this.<String>getColumnOriginalValue("descrizione"));
		formImpl.setCodice(this.<String>getColumnOriginalValue("codice"));
		formImpl.setJson(this.<String>getColumnOriginalValue("json"));
		formImpl.setPrincipale(
			this.<Boolean>getColumnOriginalValue("principale"));
		formImpl.setOrganizationId(
			this.<Long>getColumnOriginalValue("organizationId"));

		return formImpl;
	}

	@Override
	public int compareTo(Form form) {
		int value = 0;

		value = getNome().compareTo(form.getNome());

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

		if (!(object instanceof Form)) {
			return false;
		}

		Form form = (Form)object;

		long primaryKey = form.getPrimaryKey();

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
	public CacheModel<Form> toCacheModel() {
		FormCacheModel formCacheModel = new FormCacheModel();

		formCacheModel.uuid = getUuid();

		String uuid = formCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			formCacheModel.uuid = null;
		}

		formCacheModel.formId = getFormId();

		formCacheModel.groupId = getGroupId();

		formCacheModel.companyId = getCompanyId();

		formCacheModel.userId = getUserId();

		formCacheModel.userName = getUserName();

		String userName = formCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			formCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			formCacheModel.createDate = createDate.getTime();
		}
		else {
			formCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			formCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			formCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		formCacheModel.nome = getNome();

		String nome = formCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			formCacheModel.nome = null;
		}

		formCacheModel.descrizione = getDescrizione();

		String descrizione = formCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			formCacheModel.descrizione = null;
		}

		formCacheModel.codice = getCodice();

		String codice = formCacheModel.codice;

		if ((codice != null) && (codice.length() == 0)) {
			formCacheModel.codice = null;
		}

		formCacheModel.json = getJson();

		String json = formCacheModel.json;

		if ((json != null) && (json.length() == 0)) {
			formCacheModel.json = null;
		}

		formCacheModel.principale = isPrincipale();

		formCacheModel.organizationId = getOrganizationId();

		return formCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Form, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Form, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Form, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Form)this);

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
		Map<String, Function<Form, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Form, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Form, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Form)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Form>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _formId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _nome;
	private String _descrizione;
	private String _codice;
	private String _json;
	private boolean _principale;
	private long _organizationId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Form, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Form)this);
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
		_columnOriginalValues.put("formId", _formId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("nome", _nome);
		_columnOriginalValues.put("descrizione", _descrizione);
		_columnOriginalValues.put("codice", _codice);
		_columnOriginalValues.put("json", _json);
		_columnOriginalValues.put("principale", _principale);
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

		columnBitmasks.put("formId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("nome", 256L);

		columnBitmasks.put("descrizione", 512L);

		columnBitmasks.put("codice", 1024L);

		columnBitmasks.put("json", 2048L);

		columnBitmasks.put("principale", 4096L);

		columnBitmasks.put("organizationId", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Form _escapedModel;

}