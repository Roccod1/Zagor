<%@ include file="init.jsp" %>

<%
	List<ServizioEnte> serviziEnte = (List<ServizioEnte>) renderRequest.getAttribute(GestioneEntiPortletKeys.SERVIZI_ENTE);
	List<Organization> organizzazioni = (List<Organization>) renderRequest.getAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONI);
%>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<portlet:actionURL name="/salva" var="salvaURL">
</portlet:actionURL>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="${salvaURL}" id="inserisciModificaServizioForm">
		<aui:input type="hidden" name="organizationId" value="${organizzazione.organizationId}"/>
	
		<div class="row">
			<div class="col">
				<div class="form-group">
					<c:out value="${organizzazione.name}"/>
				</div>
			</div>
		</div>
		
		<div class="container pl-0 pr-0 mb-4 mt-4">
			<aui:button-row cssClass="text-right">
				<aui:button type="button" value="nuovo" href="${aggiungiModificaUrl}"/>
			</aui:button-row>
			
			<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=serviziEnte.size()%>" iteratorURL="${iteratorURL}" >
				<liferay-ui:search-container-results results="<%=ListUtil.subList(serviziEnte, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
				<liferay-ui:search-container-row className="it.servizidigitali.gestioneenti.model.ServizioEnte" modelVar="servizioEnte" >
					<liferay-ui:search-container-column-text property="name" name="nome" orderable="true" orderableProperty="nome"/>
					<portlet:renderURL var="rimuoviUrl">
						<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
						<portlet:param name="organizationId" value="${organizzazione.organizationId}"/>
					</portlet:renderURL>
					<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit'></i></a>"/>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>