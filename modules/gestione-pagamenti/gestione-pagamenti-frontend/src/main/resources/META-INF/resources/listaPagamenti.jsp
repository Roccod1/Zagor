<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA %>" value="${dataInserimentoDaCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA %>" value="${dataInserimentoACerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA %>" value="${dataOperazioneDaCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA %>" value="${dataOperazioneACerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA %>" value="${selectOrganizzazioneCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA %>" value="${selectCategoriaCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA %>" value="${selectStatoCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA %>" value="${selectGatewayCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA %>" value="${selectCanaleCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA %>" value="${codiceFiscaleCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.IDENTIFICATIVO_PAGAMENTO_CERCA %>" value="${identificativoPagamentoCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA %>" value="${codiceIuvCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA %>" value="${idPagamentoCerca}"/>
	<portlet:param name="mvcPath" value="/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:search-container delta="${delta}"
	emptyResultsMessage="message.listaPagamenti.empty"
	total="${totalCountPagamenti}" cssClass="mt-2" iteratorURL="${iteratorURL}">
	
	<liferay-ui:search-container-results results="${listaPagamenti}" />
	
	<liferay-ui:search-container-row
		className="it.servizidigitali.gestionepagamenti.model.Pagamento"
		modelVar="pagamento">

		<liferay-ui:search-container-column-text property="idFiscaleCliente" name="gestionePagamenti.cerca.codiceFiscale" orderable="true" orderableProperty="idFiscaleCliente"/>
		<liferay-ui:search-container-column-text property="causale" name="gestionePagamenti.searchContainer.causale" orderable="true" orderableProperty="causale"/>
		<liferay-ui:search-container-column-text property="iuv" name="gestionePagamenti.searchContainer.codiceIuv" orderable="true" orderableProperty="iuv"/>
		<liferay-ui:search-container-column-text name="gestionePagamenti.searchContainer.dataInserimento" orderable="true" orderableProperty="createDate">
			<fmt:formatDate value="${pagamento.createDate}" pattern="dd/MM/yyyy HH:mm"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="importo" name="gestionePagamenti.searchContainer.importoTotale" orderable="true" orderableProperty="importo"/>
		<liferay-ui:search-container-column-text property="stato" name="gestionePagamenti.searchContainer.stato" orderable="true" orderableProperty="stato"/>
		<c:if test = "${siteOrganizationId == 0}">
			<liferay-ui:search-container-column-text property="nomeOrganizzazione" name="gestionePagamenti.searchContainer.nomeOrganizzazione"/>
		</c:if>

	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>