<%@ include file="init.jsp"%>

<%
	List<User> responsabili = (List<User>) renderRequest.getAttribute(AccreditamentoEntiFrontendPortletKeys.RESPONSABILI);
%>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<portlet:actionURL name="<%=AccreditamentoEntiFrontendPortletKeys.SALVA_ACTION_COMMAND_NAME %>" var="salvaURL">
	<portlet:param name="<%=AccreditamentoEntiFrontendPortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
</portlet:actionURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="${salvaURL}">

		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" readOnly="true"
						name="<%=AccreditamentoEntiFrontendPortletKeys.ENTE_ID %>"
						label="identificativo" value="${ente.enteId}" />
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text"
						name="<%=AccreditamentoEntiFrontendPortletKeys.DENOMINAZIONE %>"
						label="denominazione" value="${ente.denominazione}">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text"
						name="<%=AccreditamentoEntiFrontendPortletKeys.TIPO %>"
						label="tipo" value="${ente.tipo}">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text"
						name="<%=AccreditamentoEntiFrontendPortletKeys.CODICE_IPA %>"
						label="codiceIPA" value="${ente.codiceIPA}">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text"
						name="<%=AccreditamentoEntiFrontendPortletKeys.STRUTTURA_DI_RIFERIMENTO %>"
						label="strutturaRiferimento" value="${ente.strutturaRiferimento}" />
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text"
						name="<%=AccreditamentoEntiFrontendPortletKeys.PEC %>"
						label="pec" value="${ente.pec}">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text"
						name="<%=AccreditamentoEntiFrontendPortletKeys.SITO_WEB %>"
						label="sitoWeb" value="${ente.sitoWeb}" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<h5>
						<liferay-ui:message key="lista-responsabili" />
					</h5>
					<%@ include file="listaResponsabili.jsp"%>
				</div>
			</div>
		</div>

		<div>
			<aui:button-row cssClass="text-right">
				<aui:button type="submit" value="salva" />
				<aui:button type="cancel" value="annulla" href="${homeURL}" />
			</aui:button-row>
		</div>
	</aui:form>
</div>
