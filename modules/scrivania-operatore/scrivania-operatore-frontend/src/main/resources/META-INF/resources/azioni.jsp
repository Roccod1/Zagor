<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	RichiestaDTO richiesta = (RichiestaDTO) row.getObject();
%>

<portlet:renderURL var="dettaglioURL">
	<portlet:param name="mvcRenderCommandName" value="/render/dettaglio" />
	<portlet:param name="id" value="<%= String.valueOf(richiesta.getId()) %>" />
	<portlet:param name="isMain" value="false" />
</portlet:renderURL>

<portlet:actionURL var="prendiInCaricoURL" name="/action/prendiInCarico">
</portlet:actionURL>

<portlet:actionURL var="rilasciaURL" name="/action/rilascia">
</portlet:actionURL>

<div class="d-flex justify-content-start">
	<a href="${dettaglioURL}" title="<liferay-ui:message key="vai-a-dettaglio" />">
		<i class="fas fa-search"></i>
	</a>

	<c:if test="${queryTab == 'in-arrivo'}">
		<aui:form action="${prendiInCaricoURL}">
			<input type="hidden" name="<portlet:namespace />taskId" value="<%= richiesta.getTaskId() %>"> 
	
			<button type="submit"
					class="border-0 bg-white"
			        title="<liferay-ui:message key="prendi-in-carico" />">
				<i class="far fa-hand-rock"></i>
			</button>
		</aui:form>
	</c:if>
	<c:if test="${queryTab == 'in-carico'}">
		<aui:form action="${rilasciaURL}">
			<input type="hidden" name="<portlet:namespace />taskId" value="<%= richiesta.getTaskId() %>"> 
	
			<button type="submit"
					class="border-0 bg-white"
			        title="<liferay-ui:message key="rilascia" />">
				<i class="far fa-hand-paper"></i>
			</button>
		</aui:form>
	</c:if>
</div>