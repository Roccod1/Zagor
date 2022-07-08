<%@ include file="/init.jsp" %>

<%
	List<Organization> organizzazioni = (List<Organization>) renderRequest.getAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI);
%>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
</portlet:renderURL>

<h2><liferay-ui:message key="elenco-enti"/></h2>

<%@ include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:button-row cssClass="text-right">
		<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
	</aui:button-row>
	
	<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=organizzazioni.size()%>" iteratorURL="${iteratorURL}" >
		<liferay-ui:search-container-results results="<%=ListUtil.subList(organizzazioni, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
		<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.Organization" modelVar="organizzazione" >
			<liferay-ui:search-container-column-text property="name" name="nome" orderable="true" orderableProperty="nome"/>
			<portlet:renderURL var="aggiungiModificaUrl">
				<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
				<portlet:param name="organizationId" value="${organizzazione.organizationId}"/>
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit'></i></a>"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>