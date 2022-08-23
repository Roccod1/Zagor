<%@ include file="/init.jsp" %>

<div class="row">
	<div class="col-4">
		<c:choose>
			<c:when test="${comunicazione.dataInvio}">
				<fmt:formatDate value="${comunicazione.dataInvio}" pattern="dd/MM/yyyy" var="comunicazioneDataInvio" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataInvio" value="-" />
			</c:otherwise>
		</c:choose>
		<aui:input name="dataInvio" value="${comunicazioneDataInvio}" />
	</div>
	<div class="col-4">
		<aui:input name="titolo" value="${comunicazione.titolo}" />
	</div>
</div>

<div class="row">
	<div class="col-4">
		<aui:input name="tipologia" value="${comunicazione.tipologia}" />
	</div>
	<div class="col-4">
		<aui:input name="stato" value="${stato}" />
	</div>
</div>

<div class="row">
	<div class="col-4">
		<c:choose>
			<c:when test="${comunicazione.dataInizio}">
				<fmt:formatDate value="${comunicazione.dataInizio}" pattern="dd/MM/yyyy" var="comunicazioneDataInizio" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataInizio" value="-" />
			</c:otherwise>
		</c:choose>
		<aui:input name="dataInizio" value="${comunicazioneDataInizio}" />
	</div>
	<div class="col-4">
		<c:choose>
			<c:when test="${comunicazione.dataFine}">
				<fmt:formatDate value="${comunicazione.dataFine}" pattern="dd/MM/yyyy" var="comunicazioneDataFine" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataFine" value="-" />
			</c:otherwise>
		</c:choose>
		<aui:input name="dataFine" value="${comunicazioneDataFine}" />
	</div>
</div>

<portlet:renderURL var="indietroURL">
</portlet:renderURL>

<a href="${indietroURL}" class="btn btn-secondary"><liferay-ui:message key="indietro" /></a>