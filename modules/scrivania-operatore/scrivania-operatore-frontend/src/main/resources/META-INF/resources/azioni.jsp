<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	RichiestaDTO richiesta = (RichiestaDTO) row.getObject();
%>

<portlet:renderURL var="dettaglioURL">
	<portlet:param name="mvcRenderCommandName" value="/render/dettaglio" />
	<portlet:param name="id" value="<%= String.valueOf(richiesta.getId()) %>" />
</portlet:renderURL>

<portlet:actionURL var="prendiInCaricoURL" name="/action/prendiInCarico">
</portlet:actionURL>

<portlet:actionURL var="rilasciaURL" name="/action/rilascia">
</portlet:actionURL>

<div class="d-flex justify-content-start">
	<a href="${dettaglioURL}" title="<liferay-ui:message key="vai-a-dettaglio" />">
		<clay:icon symbol="search" />
	</a>

	<c:if test="${queryTab == 'in-arrivo'}">
		<aui:form action="${prendiInCaricoURL}">
			<input type="hidden" name="<portlet:namespace />taskId" value="<%= richiesta.getTaskId() %>"> 
	
			<button class="icon-edit border-0 bg-white" type="submit" title="<liferay-ui:message key="prendi-in-carico" />">
			</button>
		</aui:form>
	</c:if>
	<c:if test="${queryTab == 'in-carico'}">
		<aui:form action="${rilasciaURL}">
			<input type="hidden" name="<portlet:namespace />taskId" value="<%= richiesta.getTaskId() %>"> 
	
			<button class="icon-share-alt border-0 bg-white" type="submit" title="<liferay-ui:message key="rilascia" />">
			</button>
		</aui:form>
	</c:if>
</div>