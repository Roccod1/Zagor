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

package it.servizidigitali.gestioneservizi.model.impl;

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

import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.model.TipologiaModel;

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
 * The base model implementation for the Tipologia service. Represents a row in the &quot;tipologia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TipologiaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipologiaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaImpl
 * @generated
 */
public class TipologiaModelImpl
	extends BaseModelImpl<Tipologia> implements TipologiaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipologia model instance should use the <code>Tipologia</code> interface instead.
	 */
	public static final String TABLE_NAME = "tipologia";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"tipologiaId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"nome", Types.VARCHAR}, {"descrizione", Types.VARCHAR},
		{"visibile", Types.BOOLEAN}, {"invioEmailCittadino", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tipologiaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("visibile", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("invioEmailCittadino", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table tipologia (uuid_ VARCHAR(75) null,tipologiaId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,nome VARCHAR(75) null,descrizione VARCHAR(75) null,visibile BOOLEAN,invioEmailCittadino BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table tipologia";

	public static final String ORDER_BY_JPQL = " ORDER BY tipologia.nome ASC";

	public static final String ORDER_BY_SQL = " ORDER BY tipologia.nome ASC";

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
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VISIBILE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NOME_COLUMN_BITMASK = 16L;

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

	public static final String
		MAPPING_TABLE_SERVIZIDIGITALIGESTIONESERVIZI_SERVIZIO_TIPOLOGIA_NAME =
			"ServiziDigitaliGestioneServizi_servizio_tipologia";

	public static final Object[][]
		MAPPING_TABLE_SERVIZIDIGITALIGESTIONESERVIZI_SERVIZIO_TIPOLOGIA_COLUMNS =
			{
				{"companyId", Types.BIGINT}, {"servizioId", Types.BIGINT},
				{"tipologiaId", Types.BIGINT}
			};

	public static final String
		MAPPING_TABLE_SERVIZIDIGITALIGESTIONESERVIZI_SERVIZIO_TIPOLOGIA_SQL_CREATE =
			"create table ServiziDigitaliGestioneServizi_servizio_tipologia (companyId LONG not null,servizioId LONG not null,tipologiaId LONG not null,primary key (servizioId, tipologiaId))";

	public TipologiaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tipologiaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTipologiaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipologiaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Tipologia.class;
	}

	@Override
	public String getModelClassName() {
		return Tipologia.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Tipologia, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Tipologia, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Tipologia, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Tipologia)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Tipologia, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Tipologia, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Tipologia)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Tipologia, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Tipologia, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Tipologia>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Tipologia.class.getClassLoader(), Tipologia.class,
			ModelWrapper.class);

		try {
			Constructor<Tipologia> constructor =
				(Constructor<Tipologia>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Tipologia, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Tipologia, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Tipologia, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Tipologia, Object>>();
		Map<String, BiConsumer<Tipologia, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Tipologia, ?>>();

		attributeGetterFunctions.put("uuid", Tipologia::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Tipologia, String>)Tipologia::setUuid);
		attributeGetterFunctions.put("tipologiaId", Tipologia::getTipologiaId);
		attributeSetterBiConsumers.put(
			"tipologiaId",
			(BiConsumer<Tipologia, Long>)Tipologia::setTipologiaId);
		attributeGetterFunctions.put("groupId", Tipologia::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Tipologia, Long>)Tipologia::setGroupId);
		attributeGetterFunctions.put("companyId", Tipologia::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Tipologia, Long>)Tipologia::setCompanyId);
		attributeGetterFunctions.put("userId", Tipologia::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Tipologia, Long>)Tipologia::setUserId);
		attributeGetterFunctions.put("userName", Tipologia::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Tipologia, String>)Tipologia::setUserName);
		attributeGetterFunctions.put("createDate", Tipologia::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Tipologia, Date>)Tipologia::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Tipologia::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Tipologia, Date>)Tipologia::setModifiedDate);
		attributeGetterFunctions.put("nome", Tipologia::getNome);
		attributeSetterBiConsumers.put(
			"nome", (BiConsumer<Tipologia, String>)Tipologia::setNome);
		attributeGetterFunctions.put("descrizione", Tipologia::getDescrizione);
		attributeSetterBiConsumers.put(
			"descrizione",
			(BiConsumer<Tipologia, String>)Tipologia::setDescrizione);
		attributeGetterFunctions.put("visibile", Tipologia::getVisibile);
		attributeSetterBiConsumers.put(
			"visibile", (BiConsumer<Tipologia, Boolean>)Tipologia::setVisibile);
		attributeGetterFunctions.put(
			"invioEmailCittadino", Tipologia::getInvioEmailCittadino);
		attributeSetterBiConsumers.put(
			"invioEmailCittadino",
			(BiConsumer<Tipologia, Boolean>)Tipologia::setInvioEmailCittadino);

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
	public long getTipologiaId() {
		return _tipologiaId;
	}

	@Override
	public void setTipologiaId(long tipologiaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tipologiaId = tipologiaId;
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
	public boolean getVisibile() {
		return _visibile;
	}

	@Override
	public boolean isVisibile() {
		return _visibile;
	}

	@Override
	public void setVisibile(boolean visibile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_visibile = visibile;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalVisibile() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("visibile"));
	}

	@Override
	public boolean getInvioEmailCittadino() {
		return _invioEmailCittadino;
	}

	@Override
	public boolean isInvioEmailCittadino() {
		return _invioEmailCittadino;
	}

	@Override
	public void setInvioEmailCittadino(boolean invioEmailCittadino) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_invioEmailCittadino = invioEmailCittadino;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Tipologia.class.getName()));
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
			getCompanyId(), Tipologia.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Tipologia toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Tipologia>
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
		TipologiaImpl tipologiaImpl = new TipologiaImpl();

		tipologiaImpl.setUuid(getUuid());
		tipologiaImpl.setTipologiaId(getTipologiaId());
		tipologiaImpl.setGroupId(getGroupId());
		tipologiaImpl.setCompanyId(getCompanyId());
		tipologiaImpl.setUserId(getUserId());
		tipologiaImpl.setUserName(getUserName());
		tipologiaImpl.setCreateDate(getCreateDate());
		tipologiaImpl.setModifiedDate(getModifiedDate());
		tipologiaImpl.setNome(getNome());
		tipologiaImpl.setDescrizione(getDescrizione());
		tipologiaImpl.setVisibile(isVisibile());
		tipologiaImpl.setInvioEmailCittadino(isInvioEmailCittadino());

		tipologiaImpl.resetOriginalValues();

		return tipologiaImpl;
	}

	@Override
	public Tipologia cloneWithOriginalValues() {
		TipologiaImpl tipologiaImpl = new TipologiaImpl();

		tipologiaImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		tipologiaImpl.setTipologiaId(
			this.<Long>getColumnOriginalValue("tipologiaId"));
		tipologiaImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		tipologiaImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		tipologiaImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		tipologiaImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		tipologiaImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		tipologiaImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		tipologiaImpl.setNome(this.<String>getColumnOriginalValue("nome"));
		tipologiaImpl.setDescrizione(
			this.<String>getColumnOriginalValue("descrizione"));
		tipologiaImpl.setVisibile(
			this.<Boolean>getColumnOriginalValue("visibile"));
		tipologiaImpl.setInvioEmailCittadino(
			this.<Boolean>getColumnOriginalValue("invioEmailCittadino"));

		return tipologiaImpl;
	}

	@Override
	public int compareTo(Tipologia tipologia) {
		int value = 0;

		value = getNome().compareTo(tipologia.getNome());

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

		if (!(object instanceof Tipologia)) {
			return false;
		}

		Tipologia tipologia = (Tipologia)object;

		long primaryKey = tipologia.getPrimaryKey();

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
	public CacheModel<Tipologia> toCacheModel() {
		TipologiaCacheModel tipologiaCacheModel = new TipologiaCacheModel();

		tipologiaCacheModel.uuid = getUuid();

		String uuid = tipologiaCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tipologiaCacheModel.uuid = null;
		}

		tipologiaCacheModel.tipologiaId = getTipologiaId();

		tipologiaCacheModel.groupId = getGroupId();

		tipologiaCacheModel.companyId = getCompanyId();

		tipologiaCacheModel.userId = getUserId();

		tipologiaCacheModel.userName = getUserName();

		String userName = tipologiaCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tipologiaCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tipologiaCacheModel.createDate = createDate.getTime();
		}
		else {
			tipologiaCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tipologiaCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tipologiaCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tipologiaCacheModel.nome = getNome();

		String nome = tipologiaCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			tipologiaCacheModel.nome = null;
		}

		tipologiaCacheModel.descrizione = getDescrizione();

		String descrizione = tipologiaCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			tipologiaCacheModel.descrizione = null;
		}

		tipologiaCacheModel.visibile = isVisibile();

		tipologiaCacheModel.invioEmailCittadino = isInvioEmailCittadino();

		return tipologiaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Tipologia, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Tipologia, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Tipologia, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Tipologia)this);

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
		Map<String, Function<Tipologia, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Tipologia, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Tipologia, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Tipologia)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Tipologia>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _tipologiaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _nome;
	private String _descrizione;
	private boolean _visibile;
	private boolean _invioEmailCittadino;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Tipologia, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Tipologia)this);
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
		_columnOriginalValues.put("tipologiaId", _tipologiaId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("nome", _nome);
		_columnOriginalValues.put("descrizione", _descrizione);
		_columnOriginalValues.put("visibile", _visibile);
		_columnOriginalValues.put("invioEmailCittadino", _invioEmailCittadino);
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

		columnBitmasks.put("tipologiaId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("nome", 256L);

		columnBitmasks.put("descrizione", 512L);

		columnBitmasks.put("visibile", 1024L);

		columnBitmasks.put("invioEmailCittadino", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Tipologia _escapedModel;

}