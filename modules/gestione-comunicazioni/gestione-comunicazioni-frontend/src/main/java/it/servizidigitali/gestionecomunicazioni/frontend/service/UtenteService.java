package it.servizidigitali.gestionecomunicazioni.frontend.service;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestionecomunicazioni.frontend.dto.UtenteDTO;

@Component(immediate = true, service = UtenteService.class)
public class UtenteService {

	@Reference
	private UserLocalService userLocalService;
	
	public List<UtenteDTO> ricerca(ServiceContext ctx, long organizzazione, String query, int limit) throws PortalException {
		ClassLoader classLoader = getClass().getClassLoader();
		
		String pattern = StringPool.PERCENT + query + StringPool.PERCENT;
		
		long[] orgUsers = userLocalService.getOrganizationUserIds(organizzazione);
		
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class, classLoader);
		Criterion fullnameLike = RestrictionsFactoryUtil.or(
				RestrictionsFactoryUtil.ilike("firstName", pattern),
				RestrictionsFactoryUtil.ilike("lastName", pattern)
		);
		Criterion userLike = RestrictionsFactoryUtil.or(
				RestrictionsFactoryUtil.ilike("screenName", pattern),
				fullnameLike
		);
		
		userQuery.add(userLike);
		userQuery.add(PropertyFactoryUtil.forName("userId").in(orgUsers));
		userQuery.addOrder(OrderFactoryUtil.asc("lastName"));
		
		List<User> users = userLocalService.dynamicQuery(userQuery, 0, limit);
		return users.stream().map(UtenteDTO::new).collect(Collectors.toList());
	}

}
