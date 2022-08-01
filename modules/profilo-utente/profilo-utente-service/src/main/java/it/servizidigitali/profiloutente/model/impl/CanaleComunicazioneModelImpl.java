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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.servizidigitali.profiloutente.model.CanaleComunicazione;
import it.servizidigitali.profiloutente.model.CanaleComunicazioneModel;

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
 * The base model implementation for the CanaleComunicazione service. Represents a row in the &quot;canale_comunicazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CanaleComunicazioneModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CanaleComunicazioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanaleComunicazioneImpl
 * @generated
 */
public class CanaleComunicazioneModelImpl
	extends BaseModelImpl<CanaleComunicazione>
	implements CanaleComunicazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a canale comunicazione model instance should use the <code>CanaleComunicazione</code> interface instead.
	 */
	public static final String TABLE_NAME = "canale_comunicazione";

	public static final Object[][] TABLE_COLUMNS = {
		{"canaleComunicazioneId", Types.BIGINT}, {"nome", Types.VARCHAR},
		{"codice", Types.VARCHAR}, {"attivo", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("canaleComunicazioneId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("codice", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("attivo", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table canale_comunicazione (canaleComunicazioneId LONG not null primary key,nome VARCHAR(75) null,codice VARCHAR(75) null,attivo BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table canale_comunicazione";

	public static final String ORDER_BY_JPQL =
		" ORDER BY canaleComunicazione.canaleComunicazioneId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY canale_comunicazione.canaleComunicazioneId ASC";

	public static final String DATA_SOURCE = "servizidigitaliDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ATTIVO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CODICE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CANALECOMUNICAZIONEID_COLUMN_BITMASK = 4L;

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

	public CanaleComunicazioneModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _canaleComunicazioneId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCanaleComunicazioneId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _canaleComunicazioneId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CanaleComunicazione.class;
	}

	@Override
	public String getModelClassName() {
		return CanaleComunicazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CanaleComunicazione, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CanaleComunicazione, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CanaleComunicazione, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CanaleComunicazione)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CanaleComunicazione, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CanaleComunicazione, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CanaleComunicazione)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CanaleComunicazione, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CanaleComunicazione, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CanaleComunicazione>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CanaleComunicazione.class.getClassLoader(),
			CanaleComunicazione.class, ModelWrapper.class);

		try {
			Constructor<CanaleComunicazione> constructor =
				(Constructor<CanaleComunicazione>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CanaleComunicazione, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CanaleComunicazione, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CanaleComunicazione, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CanaleComunicazione, Object>>();
		Map<String, BiConsumer<CanaleComunicazione, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CanaleComunicazione, ?>>();

		attributeGetterFunctions.put(
			"canaleComunicazioneId",
			CanaleComunicazione::getCanaleComunicazioneId);
		attributeSetterBiConsumers.put(
			"canaleComunicazioneId",
			(BiConsumer<CanaleComunicazione, Long>)
				CanaleComunicazione::setCanaleComunicazioneId);
		attributeGetterFunctions.put("nome", CanaleComunicazione::getNome);
		attributeSetterBiConsumers.put(
			"nome",
			(BiConsumer<CanaleComunicazione, String>)
				CanaleComunicazione::setNome);
		attributeGetterFunctions.put("codice", CanaleComunicazione::getCodice);
		attributeSetterBiConsumers.put(
			"codice",
			(BiConsumer<CanaleComunicazione, String>)
				CanaleComunicazione::setCodice);
		attributeGetterFunctions.put("attivo", CanaleComunicazione::getAttivo);
		attributeSetterBiConsumers.put(
			"attivo",
			(BiConsumer<CanaleComunicazione, Boolean>)
				CanaleComunicazione::setAttivo);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCanaleComunicazioneId() {
		return _canaleComunicazioneId;
	}

	@Override
	public void setCanaleComunicazioneId(long canaleComunicazioneId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_canaleComunicazioneId = canaleComunicazioneId;
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
	public boolean getAttivo() {
		return _attivo;
	}

	@Override
	public boolean isAttivo() {
		return _attivo;
	}

	@Override
	public void setAttivo(boolean attivo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attivo = attivo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalAttivo() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("attivo"));
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
			0, CanaleComunicazione.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CanaleComunicazione toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CanaleComunicazione>
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
		CanaleComunicazioneImpl canaleComunicazioneImpl =
			new CanaleComunicazioneImpl();

		canaleComunicazioneImpl.setCanaleComunicazioneId(
			getCanaleComunicazioneId());
		canaleComunicazioneImpl.setNome(getNome());
		canaleComunicazioneImpl.setCodice(getCodice());
		canaleComunicazioneImpl.setAttivo(isAttivo());

		canaleComunicazioneImpl.resetOriginalValues();

		return canaleComunicazioneImpl;
	}

	@Override
	public CanaleComunicazione cloneWithOriginalValues() {
		CanaleComunicazioneImpl canaleComunicazioneImpl =
			new CanaleComunicazioneImpl();

		canaleComunicazioneImpl.setCanaleComunicazioneId(
			this.<Long>getColumnOriginalValue("canaleComunicazioneId"));
		canaleComunicazioneImpl.setNome(
			this.<String>getColumnOriginalValue("nome"));
		canaleComunicazioneImpl.setCodice(
			this.<String>getColumnOriginalValue("codice"));
		canaleComunicazioneImpl.setAttivo(
			this.<Boolean>getColumnOriginalValue("attivo"));

		return canaleComunicazioneImpl;
	}

	@Override
	public int compareTo(CanaleComunicazione canaleComunicazione) {
		long primaryKey = canaleComunicazione.getPrimaryKey();

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

		if (!(object instanceof CanaleComunicazione)) {
			return false;
		}

		CanaleComunicazione canaleComunicazione = (CanaleComunicazione)object;

		long primaryKey = canaleComunicazione.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CanaleComunicazione> toCacheModel() {
		CanaleComunicazioneCacheModel canaleComunicazioneCacheModel =
			new CanaleComunicazioneCacheModel();

		canaleComunicazioneCacheModel.canaleComunicazioneId =
			getCanaleComunicazioneId();

		canaleComunicazioneCacheModel.nome = getNome();

		String nome = canaleComunicazioneCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			canaleComunicazioneCacheModel.nome = null;
		}

		canaleComunicazioneCacheModel.codice = getCodice();

		String codice = canaleComunicazioneCacheModel.codice;

		if ((codice != null) && (codice.length() == 0)) {
			canaleComunicazioneCacheModel.codice = null;
		}

		canaleComunicazioneCacheModel.attivo = isAttivo();

		return canaleComunicazioneCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CanaleComunicazione, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CanaleComunicazione, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CanaleComunicazione, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CanaleComunicazione)this);

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
		Map<String, Function<CanaleComunicazione, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CanaleComunicazione, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CanaleComunicazione, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CanaleComunicazione)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CanaleComunicazione>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _canaleComunicazioneId;
	private String _nome;
	private String _codice;
	private boolean _attivo;

	public <T> T getColumnValue(String columnName) {
		Function<CanaleComunicazione, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CanaleComunicazione)this);
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

		_columnOriginalValues.put(
			"canaleComunicazioneId", _canaleComunicazioneId);
		_columnOriginalValues.put("nome", _nome);
		_columnOriginalValues.put("codice", _codice);
		_columnOriginalValues.put("attivo", _attivo);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("canaleComunicazioneId", 1L);

		columnBitmasks.put("nome", 2L);

		columnBitmasks.put("codice", 4L);

		columnBitmasks.put("attivo", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CanaleComunicazione _escapedModel;

}