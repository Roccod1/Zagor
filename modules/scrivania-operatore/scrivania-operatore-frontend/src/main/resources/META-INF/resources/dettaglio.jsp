<%@ include file="init.jsp" %>

<h1><liferay-ui:message key="dati-richiedente" /></h1>

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
		<aui:input name="telefono" readonly="true" />
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

<h1><liferay-ui:message key="dati-richiesta" /></h1>

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

