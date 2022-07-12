<%@ include file="init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=GestioneEntiPortletKeys.JSP_HOME %>" />
	<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_NOME_RICERCA %>" value="${nomeOrganizzazioneRicerca}"/>
	<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_CODICE_IPA_RICERCA %>" value="${codiceIpaOrganizzazioneRicerca}"/>
</liferay-portlet:renderURL>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<liferay-ui:search-container delta="10" emptyResultsMessage="nessun-risultato-trovato" total="<%=organizzazioni.size()%>" iteratorURL="${iteratorURL}" >
		<liferay-ui:search-container-results results="<%=ListUtil.subList(organizzazioni, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
		<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.Organization" modelVar="organizzazione" >
			<liferay-ui:search-container-column-text property="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_NOME %>" name="name" orderable="true" orderableProperty="nome"/>
			<portlet:renderURL var="aggiungiModificaUrl">
				<portlet:param name="mvcRenderCommandName" value="<%=GestioneEntiPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME %>" />
				<portlet:param name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_ID %>" value="${organizzazione.organizationId}"/>
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="azioni" align="center" value="<a href='${aggiungiModificaUrl}'><i class='icon-edit'></i></a>"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>