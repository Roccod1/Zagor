<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AllegatoDTO allegato = (AllegatoDTO) row.getObject();
%>

<a href="#">
	<i class="fas fa-download"></i>
</a>