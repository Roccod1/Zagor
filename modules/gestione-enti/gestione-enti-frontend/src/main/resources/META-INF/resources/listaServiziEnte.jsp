<%@ include file="init.jsp" %>

<%
	List<ServizioEnte> listaServiziEnte = (List<ServizioEnte>) renderRequest.getAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE_SERVIZI);
%>

<portlet:renderURL var="aggiungiUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=GestioneEntiPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
	<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${organizzazione.organizationId}"/>
</portlet:renderURL>
<div class="container pl-0 pr-0 mb-4 mt-4">

	<div class="row d-flex align-items-center">
		<div class="col">
			<h4>${organizzazione.name }</h4>
		</div>
		
		<div class="col text-right">
			<aui:button type="button" href="${aggiungiUrl }" value="aggiungi-servizio"/>
		</div>
	</div>
	
	<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaServiziEnte.size()%>" iteratorURL="${iteratorURL}" >
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaServiziEnte, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
		<liferay-ui:search-container-row className="it.servizidigitali.gestioneenti.model.ServizioEnte" modelVar="servizioEnte" >
			<c:forEach items="${listaServizi }" var="servizio">
				<c:if test="${servizio.servizioId eq servizioEnte.servizioId }">
					<c:set value="${servizio.nome}" var="nomeServizio"/>
				</c:if>
			</c:forEach>
			
		<portlet:renderURL var="modificaUrl">
			<portlet:param name="mvcRenderCommandName" value="<%=GestioneEntiPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
			<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${servizioEnte.organizationId}"/>
			<portlet:param name="<%=GestioneEntiPortletKeys.SERVIZIO_ID %>" value="${servizioEnte.servizioId}"/>
		</portlet:renderURL>
		
		<portlet:renderURL var="eliminaServizioEnteUrl">
			<portlet:param name="mvcRenderCommandName" value="<%=GestioneEntiPortletKeys.LISTA_SERVIZI_ENTE_RENDER_COMMAND %>" />
			<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${servizioEnte.organizationId}"/>
			<portlet:param name="<%=GestioneEntiPortletKeys.SERVIZIO_ID %>" value="${servizioEnte.servizioId}"/>
			<portlet:param name="<%=GestioneEntiPortletKeys.DELETE_TOGGLE %>" value="true" />
		</portlet:renderURL>	
		<liferay-ui:search-container-column-text value="${nomeServizio }" name="nome"/>
		<liferay-ui:search-container-column-text name="azioni" align="center" value="
				<a href='${modificaUrl}'><i class='icon-edit'></i></a>
				<a href='${eliminaServizioEnteUrl}'><i class='icon-trash'></i></a>
			"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
