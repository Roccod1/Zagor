<%@page import="java.util.Collections"%>
<%@ include file="/init.jsp"%>

<%
	List<Ente> enti = (List<Ente>) renderRequest.getAttribute(AccreditamentoEntiFrontendPortletKeys.LISTA_ENTI);
%>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName"
		value="<%=AccreditamentoEntiFrontendPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME%>" />
	<portlet:param
		name="<%=AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE %>"
		value="${homeURL}" />
</portlet:renderURL>

<h2>
	<liferay-ui:message key="accreditamento-enti" />
</h2>

<liferay-ui:success
	key="<%=AccreditamentoEntiFrontendPortletKeys.SALVATAGGIO_SUCCESSO%>"
	message="salvataggio-avvenuto-con-successo" />

<liferay-ui:error
	key="<%=AccreditamentoEntiFrontendPortletKeys.ERRORE_SALVATAGGIO %>"
	message="errore-salvataggio" />

<liferay-ui:error
	key="<%=AccreditamentoEntiFrontendPortletKeys.ERRORE_IMPOSSIBILE_OTTENERE_ENTE%>"
	message="errore-impossibile-ottenere-ente" />

<liferay-ui:error
	key="<%=AccreditamentoEntiFrontendPortletKeys.ERRORE_CAMPI_OBBLIGATORI%>"
	message="compilare-tutti-i-campi-per-procedere" />

<aui:button-row cssClass="text-right">
	<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}" />
</aui:button-row>

<%@ include file="risultatiRicerca.jsp"%>