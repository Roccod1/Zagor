<%@ include file="/init.jsp" %>

<portlet:renderURL var="portletURL">
</portlet:renderURL>

<aui:form action="${portletURL}">
	<aui:input name="queryNome" label="cerca-servizio" value="${queryNome}" />
	<aui:button type="submit" value="cerca" />
</aui:form>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="queryNome" value="${queryNome}" />
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="9"
							 total="${serviziCount}"
							 iteratorURL="${iteratorURL}"
							 deltaConfigurable="false"
							 emptyResultsMessage="nessun-servizio">
	<liferay-ui:search-container-results results="${servizi}" />
	
	<liferay-ui:search-container-row className="it.servizidigitali.catalogoservizi.frontend.dto.ServizioDTO" 
	                                 modelVar="servizio">
    	${servizio.nome}
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>