<portlet:actionURL var="cercaPagamentiActionURL"
	name="<%=GestionePagamentiFrontendPortletKeys.CERCA_PAGAMENTI_ACTION_COMMAND%>">
</portlet:actionURL>

<portlet:renderURL var="homeURL">
	<portlet:param name="mvcPath" value="<%=GestionePagamentiFrontendPortletKeys.HOME_VIEW %>" />
</portlet:renderURL>

<portlet:renderURL var="fillWithRandomDataURL">
	<portlet:param name="mvcRenderCommandName"
		value="/pagamento/fillWithRandomData" />
</portlet:renderURL>

<aui:form method="post" action="${cercaPagamentiActionURL}"
	name="formCercaPagamenti">
	<aui:fieldset>
		<aui:container>
			<aui:row>
				<aui:col md="3">
					<aui:input value="${dataInserimentoDaCerca}"
						label="gestionePagamenti.cerca.dataInserimentoDa"
						id="dataInserimentoDa"
						name="<%=GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_DA_CERCA %>"
						type="date" />
				</aui:col>
				<aui:col md="3">
					<aui:input value="${dataInserimentoACerca}"
						label="gestionePagamenti.cerca.dataInserimentoA"
						id="dataInserimentoA"
						name="<%=GestionePagamentiFrontendPortletKeys.DATA_INSERIMENTO_A_CERCA %>"
						type="date" />
				</aui:col>
				<aui:col md="3">
					<aui:input value="${dataOperazioneDaCerca}"
						label="gestionePagamenti.cerca.dataOperazioneDa"
						id="dataOperazioneDa"
						name="<%=GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_DA_CERCA %>"
						type="date" />
				</aui:col>
				<aui:col md="3">
					<aui:input value="${dataOperazioneACerca}"
						label="gestionePagamenti.cerca.dataOperazioneA"
						id="dataOperazioneA"
						name="<%=GestionePagamentiFrontendPortletKeys.DATA_OPERAZIONE_A_CERCA %>"
						type="date" />
				</aui:col>
			</aui:row>
			<aui:row>
				<c:choose>
					<c:when test="${siteOrganizationId == 0}">
						<aui:col md="3">
							<aui:select value="${selectOrganizzazioneCerca}"
								label="gestionePagamenti.cerca.select.organizzazione"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_ORGANIZZAZIONE_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="${listaOrganizzazioni}"
									var="organizzazioneCerca">
									<aui:option value="${organizzazioneCerca.organizationId}"
										label="${organizzazioneCerca.name}" />
								</c:forEach>
							</aui:select>
						</aui:col>
						<aui:col md="3">
							<aui:select value="${selectCategoriaCerca}"
								label="gestionePagamenti.cerca.select.categoria"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA%>"
								showEmptyOption="true">
							</aui:select>
						</aui:col>
						<aui:col md="2">
							<aui:select value="${selectStatoCerca}"
								label="gestionePagamenti.cerca.select.stato"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="<%=StatoPagamento.values()%>" var="statoCerca">
									<aui:option value="${statoCerca}"
										label="label.statoPagamento.${statoCerca}" />
								</c:forEach>
							</aui:select>
						</aui:col>
						<aui:col md="2">
							<aui:select value="${selectGatewayCerca}"
								label="gestionePagamenti.cerca.select.gateway"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="<%=TipoPagamentiClient.values()%>"
									var="gatewayCerca">
									<aui:option value="${gatewayCerca}"
										label="${gatewayCerca.descrizione}" />
								</c:forEach>
							</aui:select>
						</aui:col>
						<aui:col md="2">
							<aui:select value="${selectCanaleCerca}"
								label="gestionePagamenti.cerca.select.canale"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="<%=CanalePagamento.values()%>"
									var="canaleCerca">
									<aui:option value="${canaleCerca}"
										label="${canaleCerca.descrizione}" />
								</c:forEach>
							</aui:select>
						</aui:col>
					</c:when>
					<c:otherwise>
						<aui:col md="3">
							<aui:select value="${selectCategoriaCerca}"
								label="gestionePagamenti.cerca.select.categoria"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_CATEGORIA_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="${listaServizi}" var="servizioCerca">
									<aui:option value="${servizioCerca.servizioId}"
										label="${servizioCerca.nome}" />
								</c:forEach>
							</aui:select>
						</aui:col>
						<aui:col md="3">
							<aui:select value="${selectStatoCerca}"
								label="gestionePagamenti.cerca.select.stato"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_STATO_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="<%=StatoPagamento.values()%>" var="statoCerca">
									<aui:option value="${statoCerca}"
										label="label.statoPagamento.${statoCerca}" />
								</c:forEach>
							</aui:select>
						</aui:col>
						<aui:col md="3">
							<aui:select value="${selectGatewayCerca}"
								label="gestionePagamenti.cerca.select.gateway"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_GATEWAY_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="<%=TipoPagamentiClient.values()%>"
									var="gatewayCerca">
									<aui:option value="${gatewayCerca}"
										label="${gatewayCerca.descrizione}" />
								</c:forEach>
							</aui:select>
						</aui:col>
						<aui:col md="3">
							<aui:select value="${selectCanaleCerca}"
								label="gestionePagamenti.cerca.select.canale"
								name="<%=GestionePagamentiFrontendPortletKeys.SELECT_CANALE_CERCA%>"
								showEmptyOption="true">
								<c:forEach items="<%=CanalePagamento.values()%>"
									var="canaleCerca">
									<aui:option value="${canaleCerca}"
										label="${canaleCerca.descrizione}" />
								</c:forEach>
							</aui:select>
						</aui:col>
					</c:otherwise>
				</c:choose>
			</aui:row>
			<aui:row>
				<aui:col md="4">
					<aui:input value="${codiceFiscaleCerca}"
						label="gestionePagamenti.cerca.codiceFiscale" id="codiceFiscale"
						name="<%=GestionePagamentiFrontendPortletKeys.CODICE_FISCALE_CERCA%>"
						type="text" />
				</aui:col>
				<aui:col md="4">
					<aui:input value="${codiceIuvCerca}"
						label="gestionePagamenti.cerca.codiceIuv" id="codiceIuv"
						name="<%=GestionePagamentiFrontendPortletKeys.CODICE_IUV_CERCA%>"
						type="text" />
				</aui:col>
				<aui:col md="4">
					<aui:input value="${idPagamentoCerca}"
						label="gestionePagamenti.cerca.idPagamento" id="idPagamento"
						name="<%=GestionePagamentiFrontendPortletKeys.ID_PAGAMENTO_CERCA%>"
						type="number" />
				</aui:col>
			</aui:row>
		</aui:container>
	</aui:fieldset>

	<aui:button-row cssClass="text-right">
		<aui:button type="submit" value="gestionePagamenti.cerca.button" />
		<aui:button type="button" value="gestionePagamenti.reset.button"
			id="resetButton" href="${homeURL}" />
		<aui:button type="button" value="Fill With Random Data"
			id="fillWithRandomDataButton" href="${fillWithRandomDataURL}" />
	</aui:button-row>
</aui:form>