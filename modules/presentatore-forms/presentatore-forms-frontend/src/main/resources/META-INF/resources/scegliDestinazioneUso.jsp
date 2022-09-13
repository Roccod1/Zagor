<%@ include file="./init.jsp" %>

<div class="row-fluid">
	<div class="span12 formpresenter-portlet nuova-istanza">
		<div class="page-header">
			<h2 class="noMargin">${titoloPortletServizio}</h2>
		</div>
<%-- 		<c:if test="${configurazioneTipoServizioStep2 == CONCORSO && not empty concorsoAttivo}"> --%>
<!-- 			<div class="row-fluid"> -->
<!-- 				<div class="span12 text-right"> -->
<!-- 					<spring:message code="label.concorso.validita" />:&nbsp; -->
<%-- 					<spring:message code="label.concorso.validita.da" />&nbsp;<fmt:formatDate value="${concorsoAttivo.dataApertura}" pattern="dd/MM/yyyy HH:mm"/>&nbsp; --%>
<%-- 					<spring:message code="label.concorso.validita.a" />&nbsp;<fmt:formatDate value="${concorsoAttivo.dataChiusura}" pattern="dd/MM/yyyy HH:mm"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<%-- 		</c:if> --%>
		<c:choose>
			<c:when	test="${empty statoRichiesta || bozzaStatus == statoRichiesta }">
				<c:if test="${configurazioneTipoServizioStep2 == 'CERTIFICATO' && not empty  destinazioniUso  }">
					<div class="row-fluid">
						<div class="span12 text-center" id="destinazioneUsoContainer">
							<aui:select name="destinazioneUso" id="destinazioneUsoSelect" label="label.destinazioneUso">
							    <aui:option value="" label="label.destinazioneUso.select.default" disabled="true" selected="true"/>
										<c:forEach items="${destinazioniUso }" var="destinazioniUso">
											<aui:option value="${destinazioniUso}" label="${destinazioniUso}"/>
										</c:forEach>
								<aui:validator name="required"/>
							</aui:select>
						</div>
					</div>
					<div class="row-fluid text-center" id="destinazioneUsoMsg">
					</div>
				</c:if>
				<div id="formIscrizione"></div>
			</c:when>
			<c:otherwise>
				<div>
					 <liferay-ui:message key="label.controlla.stato.richieste" arguments="${pathScrivaniaVirtuale}" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>