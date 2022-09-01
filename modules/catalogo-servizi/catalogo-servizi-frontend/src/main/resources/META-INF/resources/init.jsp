<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/journal" prefix="liferay-journal" %>

<!-- Import Java -->
<%@ page import="it.servizidigitali.catalogoservizi.frontend.constants.CatalogoServiziPortletKeys"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<liferay-ui:error key="<%=CatalogoServiziPortletKeys.ERRORE_IMPOSSIBILE_CARICARE_I_DATI %>" message="impossibile-ottenere-servizio-richiesto"/>