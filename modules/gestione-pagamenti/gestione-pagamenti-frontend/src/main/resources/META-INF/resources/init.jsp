<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="it.servizidigitali.gestionepagamenti.frontend.constants.GestionePagamentiFrontendPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="it.servizidigitali.gestionepagamenti.model.Pagamento"%>
<%@page import="it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento"%>
<%@page import="it.servizidigitali.gestionepagamenti.integration.common.client.enumeration.TipoPagamentiClient"%>
<%@page import="it.servizidigitali.gestionepagamenti.common.enumeration.CanalePagamento"%>
<%@page import="it.servizidigitali.gestioneservizi.model.Servizio"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />