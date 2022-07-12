<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<!-- Java Import -->
<%@page import="it.servizidigitali.gestioneenti.frontend.constants.GestioneEntiPortletKeys"%>
<%@page import="it.servizidigitali.gestioneenti.model.ServizioEnte"%>
<%@page import="it.servizidigitali.gestioneservizi.model.Servizio"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="it.servizidigitali.gestioneservizi.service.ServizioLocalServiceUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<!-- url home portlet -->
<liferay-portlet:renderURL varImpl="homeURL">
</liferay-portlet:renderURL>