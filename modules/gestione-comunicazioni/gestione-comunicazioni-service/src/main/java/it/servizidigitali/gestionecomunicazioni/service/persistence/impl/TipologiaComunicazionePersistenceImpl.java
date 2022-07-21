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

package it.servizidigitali.gestionecomunicazioni.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import it.servizidigitali.gestionecomunicazioni.exception.NoSuchTipologiaComunicazioneException;
import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazione;
import it.servizidigitali.gestionecomunicazioni.model.TipologiaComunicazioneTable;
import it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneImpl;
import it.servizidigitali.gestionecomunicazioni.model.impl.TipologiaComunicazioneModelImpl;
import it.servizidigitali.gestionecomunicazioni.service.persistence.TipologiaComunicazionePersistence;
import it.servizidigitali.gestionecomunicazioni.service.persistence.TipologiaComunicazioneUtil;
import it.servizidigitali.gestionecomunicazioni.service.persistence.impl.constants.PersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the tipologia comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {TipologiaComunicazionePersistence.class, BasePersistence.class}
)
public class TipologiaComunicazionePersistenceImpl
	extends BasePersistenceImpl<TipologiaComunicazione>
	implements TipologiaComunicazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TipologiaComunicazioneUtil</code> to access the tipologia comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TipologiaComunicazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TipologiaComunicazionePersistenceImpl() {
		setModelClass(TipologiaComunicazione.class);

		setModelImplClass(TipologiaComunicazioneImpl.class);
		setModelPKClass(long.class);

		setTable(TipologiaComunicazioneTable.INSTANCE);
	}

	/**
	 * Caches the tipologia comunicazione in the entity cache if it is enabled.
	 *
	 * @param tipologiaComunicazione the tipologia comunicazione
	 */
	@Override
	public void cacheResult(TipologiaComunicazione tipologiaComunicazione) {
		entityCache.putResult(
			TipologiaComunicazioneImpl.class,
			tipologiaComunicazione.getPrimaryKey(), tipologiaComunicazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tipologia comunicaziones in the entity cache if it is enabled.
	 *
	 * @param tipologiaComunicaziones the tipologia comunicaziones
	 */
	@Override
	public void cacheResult(
		List<TipologiaComunicazione> tipologiaComunicaziones) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tipologiaComunicaziones.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TipologiaComunicazione tipologiaComunicazione :
				tipologiaComunicaziones) {

			if (entityCache.getResult(
					TipologiaComunicazioneImpl.class,
					tipologiaComunicazione.getPrimaryKey()) == null) {

				cacheResult(tipologiaComunicazione);
			}
		}
	}

	/**
	 * Clears the cache for all tipologia comunicaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipologiaComunicazioneImpl.class);

		finderCache.clearCache(TipologiaComunicazioneImpl.class);
	}

	/**
	 * Clears the cache for the tipologia comunicazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipologiaComunicazione tipologiaComunicazione) {
		entityCache.removeResult(
			TipologiaComunicazioneImpl.class, tipologiaComunicazione);
	}

	@Override
	public void clearCache(
		List<TipologiaComunicazione> tipologiaComunicaziones) {

		for (TipologiaComunicazione tipologiaComunicazione :
				tipologiaComunicaziones) {

			entityCache.removeResult(
				TipologiaComunicazioneImpl.class, tipologiaComunicazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TipologiaComunicazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TipologiaComunicazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new tipologia comunicazione with the primary key. Does not add the tipologia comunicazione to the database.
	 *
	 * @param tipologiaComunicazioneId the primary key for the new tipologia comunicazione
	 * @return the new tipologia comunicazione
	 */
	@Override
	public TipologiaComunicazione create(long tipologiaComunicazioneId) {
		TipologiaComunicazione tipologiaComunicazione =
			new TipologiaComunicazioneImpl();

		tipologiaComunicazione.setNew(true);
		tipologiaComunicazione.setPrimaryKey(tipologiaComunicazioneId);

		return tipologiaComunicazione;
	}

	/**
	 * Removes the tipologia comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 * @throws NoSuchTipologiaComunicazioneException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public TipologiaComunicazione remove(long tipologiaComunicazioneId)
		throws NoSuchTipologiaComunicazioneException {

		return remove((Serializable)tipologiaComunicazioneId);
	}

	/**
	 * Removes the tipologia comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione that was removed
	 * @throws NoSuchTipologiaComunicazioneException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public TipologiaComunicazione remove(Serializable primaryKey)
		throws NoSuchTipologiaComunicazioneException {

		Session session = null;

		try {
			session = openSession();

			TipologiaComunicazione tipologiaComunicazione =
				(TipologiaComunicazione)session.get(
					TipologiaComunicazioneImpl.class, primaryKey);

			if (tipologiaComunicazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipologiaComunicazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tipologiaComunicazione);
		}
		catch (NoSuchTipologiaComunicazioneException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TipologiaComunicazione removeImpl(
		TipologiaComunicazione tipologiaComunicazione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipologiaComunicazione)) {
				tipologiaComunicazione = (TipologiaComunicazione)session.get(
					TipologiaComunicazioneImpl.class,
					tipologiaComunicazione.getPrimaryKeyObj());
			}

			if (tipologiaComunicazione != null) {
				session.delete(tipologiaComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tipologiaComunicazione != null) {
			clearCache(tipologiaComunicazione);
		}

		return tipologiaComunicazione;
	}

	@Override
	public TipologiaComunicazione updateImpl(
		TipologiaComunicazione tipologiaComunicazione) {

		boolean isNew = tipologiaComunicazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tipologiaComunicazione);
			}
			else {
				tipologiaComunicazione = (TipologiaComunicazione)session.merge(
					tipologiaComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TipologiaComunicazioneImpl.class, tipologiaComunicazione, false,
			true);

		if (isNew) {
			tipologiaComunicazione.setNew(false);
		}

		tipologiaComunicazione.resetOriginalValues();

		return tipologiaComunicazione;
	}

	/**
	 * Returns the tipologia comunicazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione
	 * @throws NoSuchTipologiaComunicazioneException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public TipologiaComunicazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipologiaComunicazioneException {

		TipologiaComunicazione tipologiaComunicazione = fetchByPrimaryKey(
			primaryKey);

		if (tipologiaComunicazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipologiaComunicazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tipologiaComunicazione;
	}

	/**
	 * Returns the tipologia comunicazione with the primary key or throws a <code>NoSuchTipologiaComunicazioneException</code> if it could not be found.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione
	 * @throws NoSuchTipologiaComunicazioneException if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public TipologiaComunicazione findByPrimaryKey(
			long tipologiaComunicazioneId)
		throws NoSuchTipologiaComunicazioneException {

		return findByPrimaryKey((Serializable)tipologiaComunicazioneId);
	}

	/**
	 * Returns the tipologia comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipologiaComunicazioneId the primary key of the tipologia comunicazione
	 * @return the tipologia comunicazione, or <code>null</code> if a tipologia comunicazione with the primary key could not be found
	 */
	@Override
	public TipologiaComunicazione fetchByPrimaryKey(
		long tipologiaComunicazioneId) {

		return fetchByPrimaryKey((Serializable)tipologiaComunicazioneId);
	}

	/**
	 * Returns all the tipologia comunicaziones.
	 *
	 * @return the tipologia comunicaziones
	 */
	@Override
	public List<TipologiaComunicazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @return the range of tipologia comunicaziones
	 */
	@Override
	public List<TipologiaComunicazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipologia comunicaziones
	 */
	@Override
	public List<TipologiaComunicazione> findAll(
		int start, int end,
		OrderByComparator<TipologiaComunicazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipologia comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipologiaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipologia comunicaziones
	 * @param end the upper bound of the range of tipologia comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipologia comunicaziones
	 */
	@Override
	public List<TipologiaComunicazione> findAll(
		int start, int end,
		OrderByComparator<TipologiaComunicazione> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TipologiaComunicazione> list = null;

		if (useFinderCache) {
			list = (List<TipologiaComunicazione>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIPOLOGIACOMUNICAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOLOGIACOMUNICAZIONE;

				sql = sql.concat(TipologiaComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TipologiaComunicazione>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tipologia comunicaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipologiaComunicazione tipologiaComunicazione : findAll()) {
			remove(tipologiaComunicazione);
		}
	}

	/**
	 * Returns the number of tipologia comunicaziones.
	 *
	 * @return the number of tipologia comunicaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_TIPOLOGIACOMUNICAZIONE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "tipologiaComunicazioneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIPOLOGIACOMUNICAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TipologiaComunicazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipologia comunicazione persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setTipologiaComunicazioneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTipologiaComunicazioneUtilPersistence(null);

		entityCache.removeCache(TipologiaComunicazioneImpl.class.getName());
	}

	private void _setTipologiaComunicazioneUtilPersistence(
		TipologiaComunicazionePersistence tipologiaComunicazionePersistence) {

		try {
			Field field = TipologiaComunicazioneUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, tipologiaComunicazionePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PersistenceConstants.SERVICE_CONFIGURATION_FILTER, unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TIPOLOGIACOMUNICAZIONE =
		"SELECT tipologiaComunicazione FROM TipologiaComunicazione tipologiaComunicazione";

	private static final String _SQL_COUNT_TIPOLOGIACOMUNICAZIONE =
		"SELECT COUNT(tipologiaComunicazione) FROM TipologiaComunicazione tipologiaComunicazione";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"tipologiaComunicazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TipologiaComunicazione exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TipologiaComunicazionePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TipologiaComunicazioneModelArgumentsResolver
		_tipologiaComunicazioneModelArgumentsResolver;

}