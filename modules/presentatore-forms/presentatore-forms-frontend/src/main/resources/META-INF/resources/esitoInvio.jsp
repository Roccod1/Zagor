<%@ include file="./init.jsp" %>

<%-- <portlet:resourceURL var="serviceEvaluationUrl"	id="serviceEvaluation" escapeXml="false"> --%>
<%-- 	<portlet:param name="idServizio" value="${idServizio}" /> --%>
<%-- </portlet:resourceURL> --%>

<script type="text/javascript">
// 	$(document).ready(function() {
// 		$("#evaluationServiceDownloadLink").click(function(e){
// 			e.preventDefault();
// 			var url = '${serviceEvaluationUrl}';
// 			jQuery.ajax({
// 			   type: 'POST',
// 			   url: url,
// 			   async: false,
// 			   success: 
// 				 function(data){ 
// 				   window.open(data, '_blank');	   
// 		   	 	},
// 			   	error: function (jqXHR, exception) {
// 	          	        console.log('ERRORE: ' + exception);
//           	    }
// 			});	
// 		});	
// 	});
	</script>

<aui:row>
	<aui:col span="12">
		<div class="page-header">
			<h2 class="noMargin">${titoloPortletServizio}</h2>
		</div>
		<aui:row>
			<aui:col span="12">
				<div class="control-group">
					<c:if test="${!empty dichiarazioneRisposta}">
						<div class="mt-3 mb-3">	
							<liferay-ui:message key="label.esito.invio.dichiarazione.info" />
						</div>
						<ul>
							<c:if test="${!empty dichiarazioneRisposta.idPratica}">
								<li><liferay-ui:message key="label.esito.invio.dichiarazione.idPratica" />: <b><c:out value="${dichiarazioneRisposta.idPratica}"/></b></li>
							</c:if>
							<c:if test="${!empty dichiarazioneRisposta.dataInserimento}">
								<li><liferay-ui:message key="label.esito.invio.dichiarazione.dataInserimento.pratica" />: <b><fmt:formatDate value="${dichiarazioneRisposta.dataInserimento}" pattern="dd/MM/yyyy"/></b></li>
							</c:if>
							<c:if test="${!empty dichiarazioneRisposta.numeroProtocollo}">
								<li><liferay-ui:message key="label.esito.invio.dichiarazione.numero.protocollo" />: <b><c:out value="${dichiarazioneRisposta.numeroProtocollo}"/></b></li>
							</c:if>
							<c:if test="${!empty dichiarazioneRisposta.dataProtocollo}">
								<li><liferay-ui:message key="label.esito.invio.dichiarazione.data.protocollo" />: <b><fmt:formatDate value="${dichiarazioneRisposta.dataProtocollo}" pattern="dd/MM/yyyy HH:mm"/></b></li>
							</c:if>
							<c:if test="${!empty dichiarazioneRisposta.infoAggiuntive}">
								<c:forEach var="infoAggiuntiva" items="${dichiarazioneRisposta.infoAggiuntive}">
									<li><c:out value="${infoAggiuntiva.value.descrizione}"/>: <b><c:out value="${infoAggiuntiva.value.valore}"/></b></li>
								</c:forEach>
							</c:if>
						</ul>
					</c:if>
					
					<c:if test="${invioIstanza}">
						<div class="alert">
							<liferay-ui:message key="success.inserimentoIstanza" />
						</div>
					
					</c:if>
					
					<c:if test="${not invioIstanza}">
						<div class="alert">
							<liferay-ui:message key="error.salvataggioIstanza" />
						</div>
					
					</c:if>
					
					<c:if test="${!empty pathScrivaniaVirtuale}">
						<aui:row cssClass="text-center">
							<a class="btn btn-custom" href="${pathScrivaniaVirtuale}">Scrivania Virtuale</a>
						</aui:row>
					</c:if>
				</div>
			</aui:col>
		</aui:row>
		<div class="form-actions text-center">
			<button class="btn btn-custom" id="evaluationServiceDownloadLink">
				<spring:message	code="button.valutaServizio" />
			</button>
		</div>
	</aui:col>
</aui:row>
