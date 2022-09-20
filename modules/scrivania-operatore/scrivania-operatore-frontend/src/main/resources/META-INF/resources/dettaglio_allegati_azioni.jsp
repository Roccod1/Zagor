<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AllegatoDTO allegato = (AllegatoDTO) row.getObject();
%>

<a href="<%= allegato.getUrl() %>">
	<i class="fas fa-download"></i>
</a>