<%@ include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=GestioneAreeTematichePortletKeys.JSP_HOME %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaAreeTematiche.size()%>" iteratorURL="${iteratorURL}" >
	<liferay-ui:search-container-results results="<%=ListUtil.subList(listaAreeTematiche, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row className="it.servizidigitali.gestioneservizi.model.AreaTematica" modelVar="areaTematica" >
		<liferay-ui:search-container-column-text property="<%=GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID %>" name="identificativo" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID %>"/>
		<liferay-ui:search-container-column-text property="<%=GestioneAreeTematichePortletKeys.NOME %>" name="nome" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.NOME %>"/>
		<liferay-ui:search-container-column-text property="<%=GestioneAreeTematichePortletKeys.DESCRIZIONE %>" name="descrizione" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.DESCRIZIONE %>"/>
		<liferay-ui:search-container-column-text property="<%=GestioneAreeTematichePortletKeys.CODICE %>" name="codice" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.CODICE %>"/>
		<liferay-ui:search-container-column-text property="<%=GestioneAreeTematichePortletKeys.ORDINE %>" name="ordine" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.ORDINE %>"/>
		
		<c:set value="${areaTematica.visibile eq true ? \"<i class='icon-ok' ></i></a>\" : \"<i class='icon-remove' ></i></a>\"}" var="iconaVisibile" />
		<liferay-ui:search-container-column-text name="<%=GestioneAreeTematichePortletKeys.VISIBILE %>" align="center" value="${iconaVisibile}" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.VISIBILE %>"/>
		
		<c:set value="${areaTematica.attiva eq true ? \"<i class='icon-ok' ></i></a>\" : \"<i class='icon-remove' ></i></a>\"}" var="iconaAttiva" />
		<liferay-ui:search-container-column-text name="<%=GestioneAreeTematichePortletKeys.ATTIVA %>" align="center" value="${iconaAttiva}" orderable="true" orderableProperty="<%=GestioneAreeTematichePortletKeys.ATTIVA %>"/>
		
		<portlet:renderURL var="aggiungiModificaUrl">
			<portlet:param name="mvcRenderCommandName" value="<%=GestioneAreeTematichePortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
			<portlet:param name="<%=GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID %>" value="${areaTematica.areaTematicaId }"/>
			<portlet:param name="<%=GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text name="<%=GestioneAreeTematichePortletKeys.AZIONI %>" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit' ></i></a>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>