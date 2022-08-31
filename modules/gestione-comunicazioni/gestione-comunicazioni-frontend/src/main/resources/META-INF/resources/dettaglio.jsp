<%@ include file="/init.jsp" %>

<div class="row">
	<div class="col-4">
		<c:choose>
			<c:when test="${comunicazione.dataInvio != null}">
				<fmt:formatDate value="${comunicazione.dataInvio}" pattern="dd/MM/yyyy HH:mm" var="comunicazioneDataInvio" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataInvio" value="-" />
			</c:otherwise>
		</c:choose>
		<aui:input name="dataInvio" value="${comunicazioneDataInvio}" readonly="true" />
	</div>
	<div class="col-4">
		<aui:input name="titolo" value="${comunicazione.titolo}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-4">
		<aui:input name="tipologia" value="${comunicazione.tipologia}"  readonly="true" />
	</div>
	<div class="col-4">
		<aui:input name="stato" value="${stato}"  readonly="true" />
	</div>
</div>
<div class="row">
	<div class="col-12">
		<liferay-editor:editor name="descrizione"
							   contents="${comunicazione.descrizione}"
	   		                   placeholder="descrizione"
	                     	   editorName="ckeditor" />
	</div>
</div>

<div class="row">
	<div class="col-4">
		<c:choose>
			<c:when test="${comunicazione.dataInizio != null}">
				<fmt:formatDate value="${comunicazione.dataInizio}" pattern="dd/MM/yyyy HH:mm" var="comunicazioneDataInizio" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataInizio" value="-" />
			</c:otherwise>
		</c:choose>
		<aui:input name="dataInizio" value="${comunicazioneDataInizio}"  readonly="true" />
	</div>
	<div class="col-4">
		<c:choose>
			<c:when test="${comunicazione.dataFine != null}">
				<fmt:formatDate value="${comunicazione.dataFine}" pattern="dd/MM/yyyy HH:mm" var="comunicazioneDataFine" />
			</c:when>
			<c:otherwise>
				<c:set var="comunicazioneDataFine" value="-" />
			</c:otherwise>
		</c:choose>
		<aui:input name="dataFine" value="${comunicazioneDataFine}"  readonly="true" />
	</div>
</div>

<portlet:renderURL var="indietroURL">
</portlet:renderURL>

<a href="${indietroURL}" class="btn btn-secondary"><liferay-ui:message key="indietro" /></a>