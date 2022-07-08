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
		<liferay-ui:search-container-column-text property="<%=GestioneAreeTematichePortletKeys.ORDINE %>" name="ordine" />
		
		<c:set value="${tipologia.visibile eq true ? \"<i class='icon-ok' ></i></a>\" : \"<i class=\'icon-remove\' ></i></a>\"}" var="icona" />
		<liferay-ui:search-container-column-text name="<%=GestioneAreeTematichePortletKeys.VISIBILE %>" align="center" value="${icona}" orderable="true" orderableProperty="attivo"/>
		
		<portlet:renderURL var="aggiungiModificaUrl">
			<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
			<portlet:param name="<%=GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID %>" value="${areaTematica.areaTematicaId }"/>
			<portlet:param name="<%=GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit' ></i></a>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>