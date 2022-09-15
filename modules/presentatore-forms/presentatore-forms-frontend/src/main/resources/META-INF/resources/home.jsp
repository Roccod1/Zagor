<%@ include file="./init.jsp" %>

<aui:row>
	<aui:col span="12">
		<div class="page-header">
			<h2 class="noMargin">${titoloPortletServizio}</h2>
		</div>
<%-- 		<c:if test="${not empty concorsoAttivo}"> --%>
<!-- 			<div class="row-fluid"> -->
<!-- 				<div class="span12 text-right"> -->
<!-- 					<spring:message code="label.concorso.validita" />:&nbsp; -->
<%-- 					<spring:message code="label.concorso.validita.da" />&nbsp;<fmt:formatDate value="${concorsoAttivo.dataApertura}" pattern="dd/MM/yyyy HH:mm"/>&nbsp; --%>
<%-- 					<spring:message code="label.concorso.validita.a" />&nbsp;<fmt:formatDate value="${concorsoAttivo.dataChiusura}" pattern="dd/MM/yyyy HH:mm"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<%-- 		</c:if> --%>
	
		<aui:row>
			<aui:col span="12">
				${descrizioneServizio}
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col span="12">
				<liferay-ui:message key="bozza.isPresent"/>
			</aui:col>
		</aui:row>
		
		<aui:button-row cssClass="text-right">
			<c:if test="${bozzaPresente}">
				<aui:button href="" value="button.caricaBozza"/>
<%-- 				<a class="btn btn-default" href="${renderizzaFormJsonUrl}&caricaBozza=true&idRichiestaServizio=${idRichiestaServizio}"><spring:message code="button.caricaBozza" /></a> --%>
			</c:if>
			<aui:button href="" value="button.compilaIstanza"/>
<%-- 			<a class="btn btn-custom" href="${home}&caricaBozza=false&idRichiestaServizio=${idRichiestaServizio}"><spring:message code="button.compilaIstanza" /></a> --%>
		</aui:button-row>
	
	</aui:col>
</aui:row>