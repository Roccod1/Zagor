<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ComunicazioneDTO comunicazione = (ComunicazioneDTO) row.getObject();
%>

<portlet:renderURL var="dettaglioURL">
	<portlet:param name="mvcRenderCommandName" value="/render/dettaglio" />
	<portlet:param name="id" value="<%= String.valueOf(comunicazione.getId()) %>" />
</portlet:renderURL>

<a href="${dettaglioURL}" class="btn btn-primary">?</a>
