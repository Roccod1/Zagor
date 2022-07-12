<%@ include file="init.jsp" %>

<portlet:renderURL var="aggiungiModificaUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=GestioneEntiPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
	<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${organizzazione.organizationId}"/>
</portlet:renderURL>

<portlet:actionURL name="<%=GestioneEntiPortletKeys.SALVA_ACTION_COMMAND_NAME %>" var="salvaURL">
	<portlet:param name="mvcPath" value="<%=GestioneEntiPortletKeys.JSP_INSERIMENTO_MODIFICA %>"/>
	<portlet:param name="redirect" value="${aggiungiModificaUrl }"/>
</portlet:actionURL>


<%
	List<ServizioEnte> listaServiziEnte = (List<ServizioEnte>) renderRequest.getAttribute(GestioneEntiPortletKeys.ORGANIZZAZIONE_SERVIZI);
%>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaServiziEnte.size()%>" iteratorURL="${iteratorURL}" >
		<liferay-ui:search-container-results results="<%=ListUtil.subList(listaServiziEnte, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
		<liferay-ui:search-container-row className="it.servizidigitali.gestioneenti.model.ServizioEnte" modelVar="servizioEnte" >
			<c:forEach items="${listaServizi }" var="servizio">
				<c:if test="${servizio.servizioId eq servizioEnte.servizioId }">
					<c:set value="${servizio.nome}" var="nomeServizio"/>
				</c:if>
			</c:forEach>
			<c:set property="<%=GestioneEntiPortletKeys.SERVIZIO_ENTE_ID %>" target="${aggiungiModificaUrl}"></c:set>
			<liferay-ui:search-container-column-text value="${nomeServizio}" name="nome"/>
			<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href=''><i class='icon-edit'></i></a>"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<div class="row justify-content-between">
		<div class="col">
			<h4>${organizzazione.name }</h4>
		</div>
	</div>

	<aui:form method="post" action="${salvaURL}">
		<aui:input type="hidden" name="organizationId" value="${organizzazione.organizationId}"/>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
						<aui:select name="<%=GestioneEntiPortletKeys.SERVIZIO_ID %>" label="id-servizio">
							<aui:option value="" label="seleziona" disabled="true" selected="true"/>
							<c:forEach items="${listaServizi }" var="servizio">
								<aui:option value="${servizio.servizioId }" label="${servizio.nome }"/>
							</c:forEach>
						</aui:select>
						
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_URI %>" label="uri-privata" type="text"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_URI_GUEST %>" label="uri-pubblica" type="text"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_SCHEDA %>" label="uri-scheda" type="text"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_DATA_INIZIO_ATTIVAZIONE %>" label="data-inizio-attivazione" type="date"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_DATA_FINE_ATTIVAZIONE %>" label="data-fine-attivazione" type="date"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_CITTADINO %>" label="cittadino" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_AZIENDA %>" label="azienda" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_DELEGA %>" label="delega" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_CHATBOT %>" label="chatbot" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_PRENOTABILE %>" label="prenotabile" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_PRIVACY_DELEGA %>" label="privacy-delega" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ALLEGATO_DELEGA %>" label="allegato-delega" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_TIMBRO_CERTIFICATO %>" label="timbro-certificato" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ISEE_INPS %>" label="isee-inps" type="checkbox"/>
				        <aui:input name="<%=GestioneEntiPortletKeys.SERVIZIO_ATTIVO %>" label="attivo" type="checkbox"/>
				</div>
			</div>
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>
