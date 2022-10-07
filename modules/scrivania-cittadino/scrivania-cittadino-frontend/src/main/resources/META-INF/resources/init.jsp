<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="it.servizidigitali.gestionecomunicazioni.model.Comunicazione"%>
<%@page import="it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="it.servizidigitali.scrivaniaoperatore.model.CommentoRichiesta"%>
<%@page import="it.servizidigitali.scrivaniaoperatore.model.AttivitaRichiesta"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />


