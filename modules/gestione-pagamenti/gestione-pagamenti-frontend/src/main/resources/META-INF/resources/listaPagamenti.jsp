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
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.SERVIZIO_CERCA %>" value="${servizioCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.CLIENTE_CERCA %>" value="${clienteCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.IDENTIFICATIVO_PAGAMENTO_CERCA %>" value="${identificativoPagamentoCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA %>" value="${codiceIuvCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA %>" value="${idPagamentoCerca}"/>
	<portlet:param name="mvcPath" value="/view.jsp"/>
</liferay-portlet:renderURL>

<portlet:renderURL var="fillWithRandomDataURL"> 
	<portlet:param name="mvcRenderCommandName" value="/persona/fillWithRandomData" />
</portlet:renderURL>

<aui:button type="button" value="Fill With Random Data" id="fillWithRandomData" href="${fillWithRandomDataURL}"/>

<liferay-ui:search-container delta="${delta}"
	emptyResultsMessage="message.listaPagamenti.empty"
	total="${totalCountPagamenti}" cssClass="mt-2" iteratorURL="${iteratorURL}">
	
	<liferay-ui:search-container-results results="${listaPagamenti}" />
	
	<liferay-ui:search-container-row
		className="it.servizidigitali.gestionepagamenti.model.Pagamento"
		modelVar="pagamento">

		<liferay-ui:search-container-column-text property="idFiscaleCliente" name="gestionePagamenti.searchContainer.cliente" orderable="true" orderableProperty="idFiscaleCliente"/>
		<liferay-ui:search-container-column-text property="causale" name="gestionePagamenti.searchContainer.causale" orderable="true" orderableProperty="causale"/>
		<liferay-ui:search-container-column-text property="iuv" name="gestionePagamenti.searchContainer.codiceIuv" orderable="true" orderableProperty="iuv"/>
		<liferay-ui:search-container-column-text property="createDate" name="gestionePagamenti.searchContainer.dataInserimento" orderable="true" orderableProperty="createDate"/>
		<liferay-ui:search-container-column-text property="importo" name="gestionePagamenti.searchContainer.importoTotale" orderable="true" orderableProperty="importo"/>
		<liferay-ui:search-container-column-text property="stato" name="gestionePagamenti.searchContainer.stato" orderable="true" orderableProperty="stato"/>

	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>