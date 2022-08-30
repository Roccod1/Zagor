<%@ include file="init.jsp" %>
<div class="container pl-0 pr-0 mb-4 mt-4">	
	<c:choose>
		<c:when test="${currentOrganizationId == 0}">
			<%@ include file="preferenzeLista.jsp" %>
		</c:when>
		<c:otherwise>
			<%@ include file="preferenzeDettaglio.jsp" %>
		</c:otherwise>
	</c:choose>
</div>