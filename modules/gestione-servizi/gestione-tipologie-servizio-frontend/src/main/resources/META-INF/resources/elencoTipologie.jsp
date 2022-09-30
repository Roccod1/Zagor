<%@ include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=GestioneTipologieServizioPortletKeys.JSP_HOME %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="${totaleElementi}" iteratorURL="${iteratorURL}" >
	<liferay-ui:search-container-results results="<%=listaTipologie%>"/>
	<liferay-ui:search-container-row className="it.servizidigitali.gestioneservizi.model.Tipologia" modelVar="tipologia" >
		<liferay-ui:search-container-column-text property="<%=GestioneTipologieServizioPortletKeys.TIPOLOGIA_ID %>" name="identificativo" orderable="true" orderableProperty="<%=GestioneTipologieServizioPortletKeys.TIPOLOGIA_ID %>"/>
		<liferay-ui:search-container-column-text property="<%=GestioneTipologieServizioPortletKeys.NOME %>" name="nome" orderable="true" orderableProperty="<%=GestioneTipologieServizioPortletKeys.NOME %>"/>
		<liferay-ui:search-container-column-text property="<%=GestioneTipologieServizioPortletKeys.DESCRIZIONE %>" name="descrizione" orderable="true" orderableProperty="<%=GestioneTipologieServizioPortletKeys.DESCRIZIONE %>"/>
		
		<c:set value="${tipologia.visibile eq true ? \"<i class='icon-ok' ></i></a>\" : \"<i class=\'icon-remove\' ></i></a>\"}" var="icona" />
		<liferay-ui:search-container-column-text name="<%=GestioneTipologieServizioPortletKeys.VISIBILE %>" align="center" value="${icona}" orderable="true" orderableProperty="<%=GestioneTipologieServizioPortletKeys.VISIBILE %>"/>
		
		<portlet:renderURL var="aggiungiModificaUrl">
			<portlet:param name="mvcRenderCommandName" value="<%=GestioneTipologieServizioPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
			<portlet:param name="<%=GestioneTipologieServizioPortletKeys.TIPOLOGIA_ID %>" value="${tipologia.tipologiaId }"/>
			<portlet:param name="<%=GestioneTipologieServizioPortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit' ></i></a>"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>