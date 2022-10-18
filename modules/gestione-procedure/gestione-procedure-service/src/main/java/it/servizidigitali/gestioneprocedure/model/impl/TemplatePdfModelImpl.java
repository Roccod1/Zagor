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

package it.servizidigitali.gestioneprocedure.model.impl;

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

import it.servizidigitali.gestioneprocedure.model.TemplatePdf;
import it.servizidigitali.gestioneprocedure.model.TemplatePdfModel;

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
 * The base model implementation for the TemplatePdf service. Represents a row in the &quot;template_pdf&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TemplatePdfModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TemplatePdfImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplatePdfImpl
 * @generated
 */
public class TemplatePdfModelImpl
	extends BaseModelImpl<TemplatePdf> implements TemplatePdfModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a template pdf model instance should use the <code>TemplatePdf</code> interface instead.
	 */
	public static final String TABLE_NAME = "template_pdf";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"templatePdfId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"fileEntryId", Types.BIGINT}, {"proceduraId", Types.BIGINT},
		{"templatePdfParentId", Types.BIGINT}, {"tipoTemplate", Types.VARCHAR},
		{"tipoTemplateNativo", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("templatePdfId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("proceduraId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("templatePdfParentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tipoTemplate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tipoTemplateNativo", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table template_pdf (uuid_ VARCHAR(75) null,templatePdfId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,fileEntryId LONG,proceduraId LONG,templatePdfParentId LONG,tipoTemplate VARCHAR(75) null,tipoTemplateNativo VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table template_pdf";

	public static final String ORDER_BY_JPQL =
		" ORDER BY templatePdf.templatePdfId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY template_pdf.templatePdfId ASC";

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
	public static final long PROCEDURAID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TEMPLATEPDFPARENTID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TIPOTEMPLATE_COLUMN_BITMASK = 16L;

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
	public static final long TEMPLATEPDFID_COLUMN_BITMASK = 64L;

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

	public TemplatePdfModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _templatePdfId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplatePdfId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templatePdfId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TemplatePdf.class;
	}

	@Override
	public String getModelClassName() {
		return TemplatePdf.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TemplatePdf, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TemplatePdf, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TemplatePdf, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TemplatePdf)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TemplatePdf, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TemplatePdf, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TemplatePdf)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TemplatePdf, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TemplatePdf, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TemplatePdf>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TemplatePdf.class.getClassLoader(), TemplatePdf.class,
			ModelWrapper.class);

		try {
			Constructor<TemplatePdf> constructor =
				(Constructor<TemplatePdf>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TemplatePdf, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TemplatePdf, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TemplatePdf, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TemplatePdf, Object>>();
		Map<String, BiConsumer<TemplatePdf, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TemplatePdf, ?>>();

		attributeGetterFunctions.put("uuid", TemplatePdf::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<TemplatePdf, String>)TemplatePdf::setUuid);
		attributeGetterFunctions.put(
			"templatePdfId", TemplatePdf::getTemplatePdfId);
		attributeSetterBiConsumers.put(
			"templatePdfId",
			(BiConsumer<TemplatePdf, Long>)TemplatePdf::setTemplatePdfId);
		attributeGetterFunctions.put("groupId", TemplatePdf::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<TemplatePdf, Long>)TemplatePdf::setGroupId);
		attributeGetterFunctions.put("companyId", TemplatePdf::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TemplatePdf, Long>)TemplatePdf::setCompanyId);
		attributeGetterFunctions.put("userId", TemplatePdf::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TemplatePdf, Long>)TemplatePdf::setUserId);
		attributeGetterFunctions.put("userName", TemplatePdf::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TemplatePdf, String>)TemplatePdf::setUserName);
		attributeGetterFunctions.put("createDate", TemplatePdf::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TemplatePdf, Date>)TemplatePdf::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TemplatePdf::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TemplatePdf, Date>)TemplatePdf::setModifiedDate);
		attributeGetterFunctions.put(
			"fileEntryId", TemplatePdf::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<TemplatePdf, Long>)TemplatePdf::setFileEntryId);
		attributeGetterFunctions.put(
			"proceduraId", TemplatePdf::getProceduraId);
		attributeSetterBiConsumers.put(
			"proceduraId",
			(BiConsumer<TemplatePdf, Long>)TemplatePdf::setProceduraId);
		attributeGetterFunctions.put(
			"templatePdfParentId", TemplatePdf::getTemplatePdfParentId);
		attributeSetterBiConsumers.put(
			"templatePdfParentId",
			(BiConsumer<TemplatePdf, Long>)TemplatePdf::setTemplatePdfParentId);
		attributeGetterFunctions.put(
			"tipoTemplate", TemplatePdf::getTipoTemplate);
		attributeSetterBiConsumers.put(
			"tipoTemplate",
			(BiConsumer<TemplatePdf, String>)TemplatePdf::setTipoTemplate);
		attributeGetterFunctions.put(
			"tipoTemplateNativo", TemplatePdf::getTipoTemplateNativo);
		attributeSetterBiConsumers.put(
			"tipoTemplateNativo",
			(BiConsumer<TemplatePdf, String>)
				TemplatePdf::setTipoTemplateNativo);

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
	public long getTemplatePdfId() {
		return _templatePdfId;
	}

	@Override
	public void setTemplatePdfId(long templatePdfId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_templatePdfId = templatePdfId;
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
	public long getProceduraId() {
		return _proceduraId;
	}

	@Override
	public void setProceduraId(long proceduraId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_proceduraId = proceduraId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProceduraId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("proceduraId"));
	}

	@Override
	public long getTemplatePdfParentId() {
		return _templatePdfParentId;
	}

	@Override
	public void setTemplatePdfParentId(long templatePdfParentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_templatePdfParentId = templatePdfParentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTemplatePdfParentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("templatePdfParentId"));
	}

	@Override
	public String getTipoTemplate() {
		if (_tipoTemplate == null) {
			return "";
		}
		else {
			return _tipoTemplate;
		}
	}

	@Override
	public void setTipoTemplate(String tipoTemplate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tipoTemplate = tipoTemplate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTipoTemplate() {
		return getColumnOriginalValue("tipoTemplate");
	}

	@Override
	public String getTipoTemplateNativo() {
		if (_tipoTemplateNativo == null) {
			return "";
		}
		else {
			return _tipoTemplateNativo;
		}
	}

	@Override
	public void setTipoTemplateNativo(String tipoTemplateNativo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tipoTemplateNativo = tipoTemplateNativo;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(TemplatePdf.class.getName()));
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
			getCompanyId(), TemplatePdf.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TemplatePdf toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TemplatePdf>
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
		TemplatePdfImpl templatePdfImpl = new TemplatePdfImpl();

		templatePdfImpl.setUuid(getUuid());
		templatePdfImpl.setTemplatePdfId(getTemplatePdfId());
		templatePdfImpl.setGroupId(getGroupId());
		templatePdfImpl.setCompanyId(getCompanyId());
		templatePdfImpl.setUserId(getUserId());
		templatePdfImpl.setUserName(getUserName());
		templatePdfImpl.setCreateDate(getCreateDate());
		templatePdfImpl.setModifiedDate(getModifiedDate());
		templatePdfImpl.setFileEntryId(getFileEntryId());
		templatePdfImpl.setProceduraId(getProceduraId());
		templatePdfImpl.setTemplatePdfParentId(getTemplatePdfParentId());
		templatePdfImpl.setTipoTemplate(getTipoTemplate());
		templatePdfImpl.setTipoTemplateNativo(getTipoTemplateNativo());

		templatePdfImpl.resetOriginalValues();

		return templatePdfImpl;
	}

	@Override
	public TemplatePdf cloneWithOriginalValues() {
		TemplatePdfImpl templatePdfImpl = new TemplatePdfImpl();

		templatePdfImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		templatePdfImpl.setTemplatePdfId(
			this.<Long>getColumnOriginalValue("templatePdfId"));
		templatePdfImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		templatePdfImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		templatePdfImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		templatePdfImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		templatePdfImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		templatePdfImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		templatePdfImpl.setFileEntryId(
			this.<Long>getColumnOriginalValue("fileEntryId"));
		templatePdfImpl.setProceduraId(
			this.<Long>getColumnOriginalValue("proceduraId"));
		templatePdfImpl.setTemplatePdfParentId(
			this.<Long>getColumnOriginalValue("templatePdfParentId"));
		templatePdfImpl.setTipoTemplate(
			this.<String>getColumnOriginalValue("tipoTemplate"));
		templatePdfImpl.setTipoTemplateNativo(
			this.<String>getColumnOriginalValue("tipoTemplateNativo"));

		return templatePdfImpl;
	}

	@Override
	public int compareTo(TemplatePdf templatePdf) {
		long primaryKey = templatePdf.getPrimaryKey();

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

		if (!(object instanceof TemplatePdf)) {
			return false;
		}

		TemplatePdf templatePdf = (TemplatePdf)object;

		long primaryKey = templatePdf.getPrimaryKey();

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
	public CacheModel<TemplatePdf> toCacheModel() {
		TemplatePdfCacheModel templatePdfCacheModel =
			new TemplatePdfCacheModel();

		templatePdfCacheModel.uuid = getUuid();

		String uuid = templatePdfCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			templatePdfCacheModel.uuid = null;
		}

		templatePdfCacheModel.templatePdfId = getTemplatePdfId();

		templatePdfCacheModel.groupId = getGroupId();

		templatePdfCacheModel.companyId = getCompanyId();

		templatePdfCacheModel.userId = getUserId();

		templatePdfCacheModel.userName = getUserName();

		String userName = templatePdfCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			templatePdfCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			templatePdfCacheModel.createDate = createDate.getTime();
		}
		else {
			templatePdfCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			templatePdfCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			templatePdfCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		templatePdfCacheModel.fileEntryId = getFileEntryId();

		templatePdfCacheModel.proceduraId = getProceduraId();

		templatePdfCacheModel.templatePdfParentId = getTemplatePdfParentId();

		templatePdfCacheModel.tipoTemplate = getTipoTemplate();

		String tipoTemplate = templatePdfCacheModel.tipoTemplate;

		if ((tipoTemplate != null) && (tipoTemplate.length() == 0)) {
			templatePdfCacheModel.tipoTemplate = null;
		}

		templatePdfCacheModel.tipoTemplateNativo = getTipoTemplateNativo();

		String tipoTemplateNativo = templatePdfCacheModel.tipoTemplateNativo;

		if ((tipoTemplateNativo != null) &&
			(tipoTemplateNativo.length() == 0)) {

			templatePdfCacheModel.tipoTemplateNativo = null;
		}

		return templatePdfCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TemplatePdf, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TemplatePdf, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TemplatePdf, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((TemplatePdf)this);

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
		Map<String, Function<TemplatePdf, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TemplatePdf, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TemplatePdf, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TemplatePdf)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TemplatePdf>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _templatePdfId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _fileEntryId;
	private long _proceduraId;
	private long _templatePdfParentId;
	private String _tipoTemplate;
	private String _tipoTemplateNativo;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TemplatePdf, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TemplatePdf)this);
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
		_columnOriginalValues.put("templatePdfId", _templatePdfId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("fileEntryId", _fileEntryId);
		_columnOriginalValues.put("proceduraId", _proceduraId);
		_columnOriginalValues.put("templatePdfParentId", _templatePdfParentId);
		_columnOriginalValues.put("tipoTemplate", _tipoTemplate);
		_columnOriginalValues.put("tipoTemplateNativo", _tipoTemplateNativo);
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

		columnBitmasks.put("templatePdfId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("fileEntryId", 256L);

		columnBitmasks.put("proceduraId", 512L);

		columnBitmasks.put("templatePdfParentId", 1024L);

		columnBitmasks.put("tipoTemplate", 2048L);

		columnBitmasks.put("tipoTemplateNativo", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TemplatePdf _escapedModel;

}