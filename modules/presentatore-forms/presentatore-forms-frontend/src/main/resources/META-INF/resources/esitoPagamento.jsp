<%@ include file="./init.jsp" %>

<script type="text/javascript">
</script>

<aui:row>
	<aui:col span="12">
		<div class="page-header">
			<h2 class="noMargin"><liferay-ui:message key="label.titoloEsito"/></h2>
		</div>
		<aui:row>
			<aui:col span="12">
				<div class="control-group">
					<c:choose>
						<c:when test="${esitoPagamento == 'ERROR' || esitoPagamento == 'KO'}">
							<div class="alert alert-error">
								<liferay-ui:message key="label.errorePagamento"/>
							</div>
						</c:when>
						<c:when test="${sitoPagamento == 'ANNULLATO'}">
							<div class="alert alert-warning">
								<liferay-ui:message key="label.annullaPagamento"/>
							</div>
						</c:when>
						<c:when test="${esitoPagamento == 'OK'}">
							<div class="alert alert-success">
								<liferay-ui:message key="label.esitoPagamento"/>
							</div>
							<div class="alert alert-success"><liferay-ui:message key="success.emissioneCertificato.attesa.pagamento"/></div>
						</c:when>
					</c:choose>
				</div>
			</aui:col>
		</aui:row>
		<div class="form-actions text-center">
			<aui:button type="submit" href="/la-mia-scrivania" value="button.scrivania.virtuale"/>
			<aui:button type="submit" href="" value="button.valutaServizio"/>
		</div>
	</aui:col>
</aui:row>
