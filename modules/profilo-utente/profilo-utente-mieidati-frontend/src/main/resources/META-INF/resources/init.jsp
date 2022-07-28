<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<!-- Java Import -->
<%@ page import="it.servizidigitali.profiloutente.mieidati.frontend.constants.ProfiloUtenteMieiDatiPortletKeys"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="it.servizidigitali.backoffice.integration.model.anagrafe.DatiAnagrafici"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.expando.kernel.model.ExpandoBridge"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />