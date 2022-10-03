package it.servizidigitali.catalogoservizi.frontend.portlet.friendlyurl;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import it.servizidigitali.catalogoservizi.frontend.constants.CatalogoServiziPortletKeys;

/**
 * @author pindi
 *
 */
@Component(//
		property = { //
				"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml", //
				"javax.portlet.name=" + CatalogoServiziPortletKeys.CATALOGOSERVIZI }, //
		service = FriendlyURLMapper.class//
) //
public class SchedaServizioFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "scheda-servizio";
}