<%@ include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=listaTipologie.size()%>" iteratorURL="${iteratorURL}" >
	<liferay-ui:search-container-results results="<%=ListUtil.subList(listaTipologie, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row className="it.servizidigitali.gestioneservizi.model.Tipologia" modelVar="tipologia" >
		<liferay-ui:search-container-column-text property="tipologiaId" name="identificativo" orderable="true" orderableProperty="tipologiaId"/>
		<liferay-ui:search-container-column-text property="nome" name="nome" orderable="true" orderableProperty="nome"/>
		<liferay-ui:search-container-column-text property="descrizione" name="descrizione" orderable="true" orderableProperty="descrizione"/>
		
		<c:set value="${tipologia.visibile eq true ? \"<i class='icon-ok' ></i></a>\" : \"<i class=\'icon-remove\' ></i></a>\"}" var="icona" />
		<liferay-ui:search-container-column-text name="visibile" align="center" value="${icona}" orderable="true" orderableProperty="attivo"/>
		
		<portlet:renderURL var="aggiungiModificaUrl">
			<portlet:param name="mvcRenderCommandName" value="/aggiungiModifica" />
			<portlet:param name="tipologiaId" value="${tipologia.tipologiaId }"/>
			<portlet:param name="indirizzoPrecedente" value="${homeURL}"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit' ></i></a>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>