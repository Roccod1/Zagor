<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<!-- Java Import -->
<%@ page import="it.servizidigitali.profiloutente.preferenze.frontend.constants.ProfiloUtentePreferenzePortletKeys"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.model.Organization"%>
<%@ page import="it.servizidigitali.profiloutente.model.CanaleComunicazione"%>
<%@ page import="it.servizidigitali.profiloutente.model.UtenteOrganizzazioneCanaleComunicazione"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<liferay-ui:success key="salvataggio-avvenuto-con-successo" message="salvataggio-avvenuto-con-successo" />
<liferay-ui:error key="salvataggio-errore" message="errore-salvataggio"/>
<liferay-ui:error key="impossibile-ottenere-dettaglio-organizzazione" message="impossibile-ottenere-dettaglio-organizzazione"/>
<liferay-ui:error key="errore-generico" message="errore-generico="/>
