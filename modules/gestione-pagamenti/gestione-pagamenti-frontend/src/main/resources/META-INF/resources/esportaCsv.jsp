<liferay-portlet:resourceURL copyCurrentRenderParameters="false" var="esportaCsvURL" id="<%=GestionePagamentiFrontendPortletKeys.ESPORTA_CSV_RESOURCE_COMMAND %>">
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
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA %>" value="${codiceIuvCerca}"/>
	<portlet:param name="<%=GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA %>" value="${idPagamentoCerca}"/>
</liferay-portlet:resourceURL>

<c:if test = "${totalCountPagamenti != 0}">
	<aui:button-row cssClass="mt-2 text-right">
		<aui:button type="button" value="gestionePagamenti.exportCsv.button"
			id="exportCsvButton" href="${esportaCsvURL}" />
	</aui:button-row>
</c:if>