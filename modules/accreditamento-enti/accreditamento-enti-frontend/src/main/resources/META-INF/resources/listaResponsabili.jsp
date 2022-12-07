<%@ include file="init.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/nuovoResponsabile.js"></script>

<aui:container>

	<div id="utility">
		<aui:input type="hidden" name="<%=AccreditamentoEntiFrontendPortletKeys.NEW_ROWS_INDEX %>" />
	</div>

	<table class="table table-bordered table-hover table-striped"
		id="listaResponsabili">
		<thead class="table-columns">
			<tr>
				<th class="table-first-header"><liferay-ui:message
						key="codiceFiscale" /></th>
				<th class="table-first-header"><liferay-ui:message key="nome" /></th>
				<th class="table-first-header"><liferay-ui:message
						key="cognome" /></th>
				<th class="table-first-header"><liferay-ui:message key="azioni" /></th>
			</tr>
		</thead>
		<tbody class="table-data">
			<c:forEach items="${responsabili}" var="responsabile">
				<tr>
					<td class="table-cell first upper">${ responsabile.screenName }</td>
					<td class="table-cell">${ responsabile.firstName }</td>
					<td class="table-cell">${ responsabile.lastName }</td>
					<td class="table-cell text-center last"><a><i
							class="icon-trash"></i></a></td>
				</tr>
			</c:forEach>

			<!-- add new -->

			<tr class="insert-row">
				<td class="table-cell first"><input id="codiceFiscale"
					class="field form-control" type="text" /></td>

				<td><input class="field form-control" disabled /></td>

				<td><input class="field form-control" disabled /></td>

				<td class="table-cell last add-responsabile"><aui:button
						value="aggiungiResponsabile" /></td>
			</tr>
		</tbody>
	</table>
</aui:container>

<script type="text/javascript">
	$(document).ready(function() {
		var portletNamespace = '<portlet:namespace/>';
		console.log('Portlet namespace' + portletNamespace);

		$('.add-responsabile').on('click', function() {
			addRow(portletNamespace);
		});
	});
</script>


