<%@ include file="/init.jsp" %>

<portlet:renderURL var="homeURL">
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
	<portlet:param name="<%=SearchContainer.DEFAULT_CUR_PARAM %>" value="${cur}"/>
	<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM %>" value="${delta}"/>
	<portlet:param name="<%=SearchContainer.DEFAULT_ORDER_BY_COL_PARAM %>" value="${orderByCol}"/>
	<portlet:param name="<%=SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM %>" value="${orderByType}"/>
	<portlet:param name="mvcPath" value="<%=GestionePagamentiFrontendPortletKeys.HOME_VIEW %>"/>
</portlet:renderURL>

<% Pagamento dettaglioPagamento = (Pagamento) renderRequest.getAttribute(GestionePagamentiFrontendPortletKeys.DETTAGLIO_PAGAMENTO); %>

<aui:container>
	<aui:row>
		<aui:col md="3">
			<aui:input label="gestionePagamenti.dettaglioPagamento.id" name="dettaglioPagamentoId" value="${dettaglioPagamento.pagamentoId}"  readonly="true" />
		</aui:col>
		<aui:col md="3">
			<fmt:formatDate value='${dettaglioPagamento.createDate}' pattern='dd/MM/yyyy HH:mm' var="formattedDataInserimento"/>
			<aui:input label="gestionePagamenti.dettaglioPagamento.dataInserimento" name="dettaglioPagamentoDataInserimento" value="${formattedDataInserimento}" readonly="true"/>
		</aui:col>
		<aui:col md="3">
			<fmt:formatDate value='${dettaglioPagamento.modifiedDate}' pattern='dd/MM/yyyy HH:mm' var="formattedDataOperazione"/>
			<aui:input label="gestionePagamenti.dettaglioPagamento.dataOperazione" name="dettaglioPagamentoDataOperazione" value="${formattedDataOperazione}" readonly="true"/>
		</aui:col>
		<aui:col md="3">
			<aui:input label="gestionePagamenti.dettaglioPagamento.statoPagamento" name="dettaglioPagamentoStatoPagamento" value="<%=StatoPagamento.getDescrizioneByName(dettaglioPagamento.getStato()) %>"  readonly="true" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.servizioId" name="dettaglioPagamentosServizioId" value="${dettaglioPagamento.servizioId}"  readonly="true" />
		</aui:col>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.categoria" name="dettaglioPagamentoCategoria" value="${dettaglioPagamento.nomeServizio}"  readonly="true" />
		</aui:col>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.causale" name="dettaglioPagamentoCausale" value="${dettaglioPagamento.causale}"  readonly="true" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.canale" name="dettaglioPagamentoCanale" value="${dettaglioPagamento.canale}"  readonly="true" />
		</aui:col>
		<fmt:formatNumber type="currency" currencyCode="EUR" value="${dettaglioPagamento.importo}" var="importoServizioFormatted"/>
		<fmt:formatNumber type="currency" currencyCode="EUR" value="${dettaglioPagamento.commissioni}" var="importoCommissioniFormatted"/>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.importoServizio" name="dettaglioPagamentoImportoServizio" value="${importoServizioFormatted}"  readonly="true" />
		</aui:col>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.importoGateway" name="dettaglioPagamentoImportoGateway" value="${importoCommissioniFormatted}"  readonly="true" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.codiceFiscale" name="dettaglioPagamentoCodiceFiscale" value="${dettaglioPagamento.idFiscaleCliente}"  readonly="true" />
		</aui:col>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.cliente" name="dettaglioPagamentoCliente" value="${dettaglioPagamento.denominazioneCliente}"  readonly="true" />
		</aui:col>
		<aui:col md="4">
			<aui:input label="gestionePagamenti.dettaglioPagamento.emailQuitetanza" name="dettaglioPagamentoEmailQuitetanza" value="${dettaglioPagamento.emailQuietanza}"  readonly="true" />
		</aui:col>
	</aui:row>
	<aui:row>
		<c:if test="${siteOrganizationId == 0}">
			<aui:col md="4">
				<aui:input label="gestionePagamenti.dettaglioPagamento.organizzazione" name="dettaglioPagamentoOrganizzazione" value="${dettaglioPagamento.nomeOrganizzazione}"  readonly="true" />
			</aui:col>
		</c:if>
	</aui:row>
	<aui:row>
		<aui:col md="2">
			<aui:button type="button" value="gestionePagamenti.dettaglioPagamento.backButton"
				id="dettaglioPagamentoBackButton" href="${homeURL}" />
		</aui:col>
	</aui:row>
</aui:container>