<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	RichiestaDTO richiesta = (RichiestaDTO) row.getObject();
%>

<portlet:renderURL var="dettaglioURL">
	<portlet:param name="mvcRenderCommandName" value="/render/dettaglio" />
	<portlet:param name="id" value="<%= String.valueOf(richiesta.getId()) %>" />
</portlet:renderURL>

<a href="${dettaglioURL}" class="btn btn-primary" title="vai-a-dettaglio">
	<clay:icon symbol="search" />
</a>

<button class="btn btn-primary" title="prendi-in-carico">
	?
</button>
