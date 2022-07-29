<%@ include file="init.jsp" %>

<%
	List<Organization> organizzazioni = (List<Organization>) renderRequest.getAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI);
%>

<h2><liferay-ui:message key="elenco-enti"/></h2>

<%@ include file="formRicerca.jsp" %>
<%@ include file="risultatiRicerca.jsp" %>