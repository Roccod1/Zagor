<%@ include file="/init.jsp"%>

<div class="page-header">
	<h3>
		<liferay-ui:message key="label.titoloEsito" />
	</h3>
</div>

<aui:container>
	<aui:row>
		<aui:col md="12">
			<c:choose>
				<c:when test="${esitoPagamento == 'ERROR' || esitoPagamento == 'KO'}">
					<div class="alert alert-danger" role="alert">
						<liferay-ui:message key="label.errorePagamento" />
					</div>
				</c:when>
				<c:when test="${pagamentoAnnullato}">
					<div class="alert alert-warning" role="alert">
						<liferay-ui:message key="label.annullaPagamento" />
					</div>
				</c:when>
				<c:when test="${esitoPagamento == 'OK'}">
					<div class="alert alert-success" role="alert">
						<liferay-ui:message key="label.esitoPagamento" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" role="alert">
						<liferay-ui:message key="label.esitoPagamento" />
					</div>
				</c:otherwise>
			</c:choose>
		</aui:col>
	</aui:row>
</aui:container>