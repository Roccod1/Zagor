<%@ include file="init.jsp" %>

<%
	List<Organization> listaEnti = (List<Organization>) renderRequest.getAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_ORGANIZZAZIONI);
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="aggiungiModificaURL">
	<portlet:param name="mvcRenderCommandName" value="<%=ProfiloUtentePreferenzePortletKeys.RENDER_INSERISCI_MODIFICA %>" />
</portlet:renderURL>

<div class="container pl-0 pr-0 mb-4 mt-4">	
	<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaEnti.size()%>" iteratorURL="${iteratorURL}" >
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaEnti, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
		<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.Organization" modelVar="ente" >
			<liferay-ui:search-container-column-text property="name" name="nome"/>
			<portlet:renderURL var="modificaURL">
				<portlet:param name="mvcRenderCommandName" value="<%=ProfiloUtentePreferenzePortletKeys.RENDER_INSERISCI_MODIFICA %>" />
				<portlet:param name="<%=ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID %>" value="${ente.organizationId}" />	
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${modificaURL}'><i class='icon-edit'></i></a>"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

<%-- 	<aui:button-row cssClass="text-right"> --%>
<%-- 		<aui:button type="button" value="nuovo" href="${aggiungiModificaURL}"/> --%>
<%-- 	</aui:button-row> --%>
</div>