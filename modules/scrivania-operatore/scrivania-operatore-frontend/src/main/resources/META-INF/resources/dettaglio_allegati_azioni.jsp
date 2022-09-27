<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AllegatoDTO allegato = (AllegatoDTO) row.getObject();
%>

<portlet:resourceURL id="/downloadFile" var="downloadFileUrl">
	<portlet:param name="idDocumentale" value="<%= allegato.getIdDocumentale()%>"/>
</portlet:resourceURL>

<a href="${downloadFileUrl}" target="_blank">
	<i class="fas fa-download"></i>
</a>