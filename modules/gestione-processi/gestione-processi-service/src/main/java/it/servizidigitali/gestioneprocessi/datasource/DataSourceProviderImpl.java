package it.servizidigitali.gestioneprocessi.datasource;

import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceProvider;
import com.liferay.portal.kernel.util.PropsUtil;

import javax.sql.DataSource;

public class DataSourceProviderImpl implements DataSourceProvider {

	@Override
	public DataSource getDataSource() {

		DataSource dataSource = null;

		try {

			dataSource = DataSourceFactoryUtil.initDataSource(PropsUtil.getProperties("jdbc.servizidigitali.", true));

			// **Note:** Sometimes above line dosn't work in some environments, then follow below
			// approach. In this case above Step(5) is not required because it's directly making
			// lookup into server's context.

			// InitialContext initialContext = new InitialContext();
			// dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/myDataSource");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return dataSource;
	}
}