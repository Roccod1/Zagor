<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<div class="d-flex justify-content-start">
	<h3><liferay-ui:message key="dati-richiedente" /></h3>
	<c:choose>
		<c:when test="${richiesta.accesso}">
			<i class="fas fa-lock ml-2 mt-2" title="<liferay-ui:message key="invio-con-autenticazione" />"></i>
		</c:when>
		<c:otherwise>
			<i class="fas fa-lock-open ml-2 mt-2" title="<liferay-ui:message key="invio-senza-autenticazione" />"></i>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="${inCarico}">
	<div class="row">
		<c:if test="${hasAssegnaAltroResponsabile}">
			<button class="btn btn-primary mr-1 mt-1">
				<liferay-ui:message key="assegna-altro-responsabile" />
			</button>
		</c:if>
		
		<c:if test="${hasAssegnaResponsabile}">
			<button class="btn btn-primary mr-1 mt-1">
				<liferay-ui:message key="assegna-responsabile" />
			</button>
		</c:if>
				
		<c:if test="${hasEsitoPositivo}">
			<button class="btn btn-primary mr-1 mt-1">
				<liferay-ui:message key="chiudi-esito-positivo" />
			</button>
		</c:if>
		
		<c:if test="${hasEsitoNegativo}">
			<button class="btn btn-primary mr-1 mt-1">
				<liferay-ui:message key="chiudi-esito-negativo" />
			</button>
		</c:if>
		
		<c:if test="${hasRichiediModificheRichiedente}">
			<button class="btn btn-primary mr-1 mt-1">
				<liferay-ui:message key="richiedi-modifiche-integrazioni-richiedente" />
			</button>
		</c:if>
		
		<c:if test="${hasRilascia}">
			<button class="btn btn-primary mr-1 mt-1">
				<liferay-ui:message key="rilascia" />
			</button>
		</c:if>
	</div>
</c:if>

<div class="row">
	<div class="col-6">
		<aui:input name="denominazione-richiedente" value="${richiesta.richiedente}" readonly="true" />
	</div>
	<div class="col-6">
		<aui:input name="codice-fiscale" value="${richiesta.cf}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="partita-iva" value="${richiesta.parIVA}" readonly="true" />
	</div>
	<div class="col-6">
		<aui:input name="comune-residenza" value="${richiesta.comuneResidenza}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-5">
		<aui:input name="indirizzo-residenza" value="${richiesta.indirizzoResidenza}" readonly="true" />
	</div>
	<div class="col-1">
		<aui:input name="n" value="${richiesta.civicoResidenza}" readonly="true" />
	</div>
	<div class="col-6">
		<aui:input name="telefono" value="${richiesta.telefono}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="email" value="${richiesta.email}" readonly="true" />
	</div>
	<div class="col-6">
		<aui:input name="pec" value="${richiesta.pec}" readonly="true" />
	</div>
</div>

<h3><liferay-ui:message key="dati-richiesta" /></h3>

<div class="row">
	<div class="col-6">
		<aui:input name="id-richiesta" value="${richiesta.id}" readonly="true" />
	</div>
	<div class="col-6">
		<label for="<portlet:namespace />stato"><liferay-ui:message key="stato" /></label>
		<input name="<portlet:namespace />stato"
		       id="<portlet:namespace />stato"
		       class="form-control"
		       readonly
		       value="<liferay-ui:message key="stato-richiesta-${richiesta.stato}" />">
	</div>
</div>

<div class="row">
	<div class="col-3">
		<fmt:formatDate value="${richiesta.dataInserimento}" pattern="dd/MM/yyyy HH:mm" var="richiestaDataInserimento" />
		<aui:input name="data-inserimento" value="${richiestaDataInserimento}" readonly="true" />
	</div>
	<div class="col-3">
		<fmt:formatDate value="${richiesta.dataUltimoAggiornamento}" pattern="dd/MM/yyyy HH:mm" var="richiestaDataUltimoAggiornamento" />
		<aui:input name="data-ultimo-aggiornamento" value="${richiestaDataUltimoAggiornamento}" readonly="true" />
	</div>
	<div class="col-6">
		<aui:input name="servizio" value="${richiesta.servizio}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-12">
		<aui:input name="oggetto" value="${richiesta.oggetto}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-12">
		<aui:input type="textarea" name="note" value="${richiesta.note}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="num-protocollo-richiesta" value="${richiesta.numeroProtocollo}" readonly="true" />
	</div>
	<div class="col-6">
		<fmt:formatDate value="${richiesta.dataProtocollo}" pattern="dd/MM/yyyy HH:mm" var="richiestaDataProtocollo" />
		<aui:input name="data-protocollo-richiesta" value="${richiestaDataProtocollo}" readonly="true" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="num-protocollo-esito" value="${richiesta.numeroProtocolloEsterno}" readonly="true" />
	</div>
	<div class="col-6">
		<fmt:formatDate value="${richiesta.dataProtocolloEsterno}" pattern="dd/MM/yyyy HH:mm" var="richiestaDataProtocolloEsterno" />
		<aui:input name="data-protocollo-esito" value="${richiestaDataProtocolloEsterno}" readonly="true" />
	</div>
</div>

<div class="row d-flex justify-content-end">
	<button class="btn btn-primary mr-1">
		<i class="fas fa-download"></i>
		<liferay-ui:message key="scarica-visualizza-modello-compilato-cittadino" arguments="${modelloArgs}" />
	</button>
	<button class="btn btn-primary">
		<liferay-ui:message key="salva-dati-protocollo" />
	</button>
</div>


