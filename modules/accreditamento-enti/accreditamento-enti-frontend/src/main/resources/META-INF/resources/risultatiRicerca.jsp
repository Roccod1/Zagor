<%@ include file="init.jsp"%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="nessun-risultato-trovato"
	total="${totEnti}" iteratorURL="${iteratorURL}">
	<liferay-ui:search-container-results results="<%=enti%>" />

	<liferay-ui:search-container-row
		className="it.servizidigitali.accreditamentoenti.model.Ente"
		modelVar="ente">

		<liferay-ui:search-container-column-text property="denominazione"
			name="denominazione" orderable="true"
			orderableProperty="denominazione" />

		<liferay-ui:search-container-column-text property="tipo" name="tipo"
			orderable="true" orderableProperty="tipo" />

		<liferay-ui:search-container-column-text
			property="strutturaRiferimento" name="strutturaRiferimento"
			orderable="true" orderableProperty="strutturaRiferimento" />

		<portlet:renderURL var="aggiungiModificaUrl">
			<portlet:param name="mvcRenderCommandName"
				value="<%=AccreditamentoEntiFrontendPortletKeys.AGGIUNGI_MODIFICA_RENDER_COMMAND_NAME%>" />
			<portlet:param
				name="<%=AccreditamentoEntiFrontendPortletKeys.ENTE_ID %>"
				value="${ente.enteId }" />
			<portlet:param
				name="<%=AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE %>"
				value="${homeURL}" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			name="<%=AccreditamentoEntiFrontendPortletKeys.AZIONI %>"
			align="center"
			value="<a href='${aggiungiModificaUrl}'><i class='icon-edit' ></i></a>" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>