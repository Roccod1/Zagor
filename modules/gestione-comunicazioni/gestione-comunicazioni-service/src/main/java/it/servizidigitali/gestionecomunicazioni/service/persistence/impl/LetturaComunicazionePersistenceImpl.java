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
import com.liferay.portal.kernel.util.SetUtil;

import it.servizidigitali.gestionecomunicazioni.exception.NoSuchLetturaComunicazioneException;
import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazione;
import it.servizidigitali.gestionecomunicazioni.model.LetturaComunicazioneTable;
import it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneImpl;
import it.servizidigitali.gestionecomunicazioni.model.impl.LetturaComunicazioneModelImpl;
import it.servizidigitali.gestionecomunicazioni.service.persistence.LetturaComunicazionePK;
import it.servizidigitali.gestionecomunicazioni.service.persistence.LetturaComunicazionePersistence;
import it.servizidigitali.gestionecomunicazioni.service.persistence.LetturaComunicazioneUtil;
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
 * The persistence implementation for the lettura comunicazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {LetturaComunicazionePersistence.class, BasePersistence.class}
)
public class LetturaComunicazionePersistenceImpl
	extends BasePersistenceImpl<LetturaComunicazione>
	implements LetturaComunicazionePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LetturaComunicazioneUtil</code> to access the lettura comunicazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LetturaComunicazioneImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public LetturaComunicazionePersistenceImpl() {
		setModelClass(LetturaComunicazione.class);

		setModelImplClass(LetturaComunicazioneImpl.class);
		setModelPKClass(LetturaComunicazionePK.class);

		setTable(LetturaComunicazioneTable.INSTANCE);
	}

	/**
	 * Caches the lettura comunicazione in the entity cache if it is enabled.
	 *
	 * @param letturaComunicazione the lettura comunicazione
	 */
	@Override
	public void cacheResult(LetturaComunicazione letturaComunicazione) {
		entityCache.putResult(
			LetturaComunicazioneImpl.class,
			letturaComunicazione.getPrimaryKey(), letturaComunicazione);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lettura comunicaziones in the entity cache if it is enabled.
	 *
	 * @param letturaComunicaziones the lettura comunicaziones
	 */
	@Override
	public void cacheResult(List<LetturaComunicazione> letturaComunicaziones) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (letturaComunicaziones.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LetturaComunicazione letturaComunicazione :
				letturaComunicaziones) {

			if (entityCache.getResult(
					LetturaComunicazioneImpl.class,
					letturaComunicazione.getPrimaryKey()) == null) {

				cacheResult(letturaComunicazione);
			}
		}
	}

	/**
	 * Clears the cache for all lettura comunicaziones.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LetturaComunicazioneImpl.class);

		finderCache.clearCache(LetturaComunicazioneImpl.class);
	}

	/**
	 * Clears the cache for the lettura comunicazione.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LetturaComunicazione letturaComunicazione) {
		entityCache.removeResult(
			LetturaComunicazioneImpl.class, letturaComunicazione);
	}

	@Override
	public void clearCache(List<LetturaComunicazione> letturaComunicaziones) {
		for (LetturaComunicazione letturaComunicazione :
				letturaComunicaziones) {

			entityCache.removeResult(
				LetturaComunicazioneImpl.class, letturaComunicazione);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LetturaComunicazioneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				LetturaComunicazioneImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lettura comunicazione with the primary key. Does not add the lettura comunicazione to the database.
	 *
	 * @param letturaComunicazionePK the primary key for the new lettura comunicazione
	 * @return the new lettura comunicazione
	 */
	@Override
	public LetturaComunicazione create(
		LetturaComunicazionePK letturaComunicazionePK) {

		LetturaComunicazione letturaComunicazione =
			new LetturaComunicazioneImpl();

		letturaComunicazione.setNew(true);
		letturaComunicazione.setPrimaryKey(letturaComunicazionePK);

		return letturaComunicazione;
	}

	/**
	 * Removes the lettura comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public LetturaComunicazione remove(
			LetturaComunicazionePK letturaComunicazionePK)
		throws NoSuchLetturaComunicazioneException {

		return remove((Serializable)letturaComunicazionePK);
	}

	/**
	 * Removes the lettura comunicazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lettura comunicazione
	 * @return the lettura comunicazione that was removed
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public LetturaComunicazione remove(Serializable primaryKey)
		throws NoSuchLetturaComunicazioneException {

		Session session = null;

		try {
			session = openSession();

			LetturaComunicazione letturaComunicazione =
				(LetturaComunicazione)session.get(
					LetturaComunicazioneImpl.class, primaryKey);

			if (letturaComunicazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLetturaComunicazioneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(letturaComunicazione);
		}
		catch (NoSuchLetturaComunicazioneException noSuchEntityException) {
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
	protected LetturaComunicazione removeImpl(
		LetturaComunicazione letturaComunicazione) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(letturaComunicazione)) {
				letturaComunicazione = (LetturaComunicazione)session.get(
					LetturaComunicazioneImpl.class,
					letturaComunicazione.getPrimaryKeyObj());
			}

			if (letturaComunicazione != null) {
				session.delete(letturaComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (letturaComunicazione != null) {
			clearCache(letturaComunicazione);
		}

		return letturaComunicazione;
	}

	@Override
	public LetturaComunicazione updateImpl(
		LetturaComunicazione letturaComunicazione) {

		boolean isNew = letturaComunicazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(letturaComunicazione);
			}
			else {
				letturaComunicazione = (LetturaComunicazione)session.merge(
					letturaComunicazione);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LetturaComunicazioneImpl.class, letturaComunicazione, false, true);

		if (isNew) {
			letturaComunicazione.setNew(false);
		}

		letturaComunicazione.resetOriginalValues();

		return letturaComunicazione;
	}

	/**
	 * Returns the lettura comunicazione with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lettura comunicazione
	 * @return the lettura comunicazione
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public LetturaComunicazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLetturaComunicazioneException {

		LetturaComunicazione letturaComunicazione = fetchByPrimaryKey(
			primaryKey);

		if (letturaComunicazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLetturaComunicazioneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return letturaComunicazione;
	}

	/**
	 * Returns the lettura comunicazione with the primary key or throws a <code>NoSuchLetturaComunicazioneException</code> if it could not be found.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione
	 * @throws NoSuchLetturaComunicazioneException if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public LetturaComunicazione findByPrimaryKey(
			LetturaComunicazionePK letturaComunicazionePK)
		throws NoSuchLetturaComunicazioneException {

		return findByPrimaryKey((Serializable)letturaComunicazionePK);
	}

	/**
	 * Returns the lettura comunicazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param letturaComunicazionePK the primary key of the lettura comunicazione
	 * @return the lettura comunicazione, or <code>null</code> if a lettura comunicazione with the primary key could not be found
	 */
	@Override
	public LetturaComunicazione fetchByPrimaryKey(
		LetturaComunicazionePK letturaComunicazionePK) {

		return fetchByPrimaryKey((Serializable)letturaComunicazionePK);
	}

	/**
	 * Returns all the lettura comunicaziones.
	 *
	 * @return the lettura comunicaziones
	 */
	@Override
	public List<LetturaComunicazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @return the range of lettura comunicaziones
	 */
	@Override
	public List<LetturaComunicazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lettura comunicaziones
	 */
	@Override
	public List<LetturaComunicazione> findAll(
		int start, int end,
		OrderByComparator<LetturaComunicazione> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lettura comunicaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LetturaComunicazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lettura comunicaziones
	 * @param end the upper bound of the range of lettura comunicaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lettura comunicaziones
	 */
	@Override
	public List<LetturaComunicazione> findAll(
		int start, int end,
		OrderByComparator<LetturaComunicazione> orderByComparator,
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

		List<LetturaComunicazione> list = null;

		if (useFinderCache) {
			list = (List<LetturaComunicazione>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LETTURACOMUNICAZIONE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LETTURACOMUNICAZIONE;

				sql = sql.concat(LetturaComunicazioneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LetturaComunicazione>)QueryUtil.list(
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
	 * Removes all the lettura comunicaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LetturaComunicazione letturaComunicazione : findAll()) {
			remove(letturaComunicazione);
		}
	}

	/**
	 * Returns the number of lettura comunicaziones.
	 *
	 * @return the number of lettura comunicaziones
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
					_SQL_COUNT_LETTURACOMUNICAZIONE);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "letturaComunicazionePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LETTURACOMUNICAZIONE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LetturaComunicazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lettura comunicazione persistence.
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

		_setLetturaComunicazioneUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLetturaComunicazioneUtilPersistence(null);

		entityCache.removeCache(LetturaComunicazioneImpl.class.getName());
	}

	private void _setLetturaComunicazioneUtilPersistence(
		LetturaComunicazionePersistence letturaComunicazionePersistence) {

		try {
			Field field = LetturaComunicazioneUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, letturaComunicazionePersistence);
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

	private static final String _SQL_SELECT_LETTURACOMUNICAZIONE =
		"SELECT letturaComunicazione FROM LetturaComunicazione letturaComunicazione";

	private static final String _SQL_COUNT_LETTURACOMUNICAZIONE =
		"SELECT COUNT(letturaComunicazione) FROM LetturaComunicazione letturaComunicazione";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"letturaComunicazione.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LetturaComunicazione exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		LetturaComunicazionePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"comunicazioneId", "userId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private LetturaComunicazioneModelArgumentsResolver
		_letturaComunicazioneModelArgumentsResolver;

}