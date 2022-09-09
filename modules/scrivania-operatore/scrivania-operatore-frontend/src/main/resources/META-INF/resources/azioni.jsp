<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	RichiestaDTO richiesta = (RichiestaDTO) row.getObject();
%>

<portlet:renderURL var="dettaglioURL">
	<portlet:param name="mvcRenderCommandName" value="/render/dettaglio" />
	<portlet:param name="id" value="<%= String.valueOf(richiesta.getId()) %>" />
</portlet:renderURL>

<div class="d-flex justify-content-start">
	<a href="${dettaglioURL}" title="<liferay-ui:message key="vai-a-dettaglio" />">
		<clay:icon symbol="search" />
	</a>

	<a href="#" class="ml-1" title="<liferay-ui:message key="prendi-in-carico" />">
		<i class='icon-edit'></i>
	</a>
</div>