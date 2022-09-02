<%@ include file="init.jsp" %>

<h1><liferay-ui:message key="dati-richiedente" /></h1>

<div class="row">
	<div class="col-6">
		<aui:input name="denominazione-richiedente" value="${richiesta.richiedente}" />
	</div>
	<div class="col-6">
		<aui:input name="codice-fiscale" value="${richiesta.cf}" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="partita-iva" />
	</div>
	<div class="col-6">
		<aui:input name="comune-residenza" />
	</div>
</div>

<div class="row">
	<div class="col-5">
		<aui:input name="indirizzo-residenza" />
	</div>
	<div class="col-1">
		<aui:input name="n" />
	</div>
	<div class="col-6">
		<aui:input name="telefono" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="email" />
	</div>
	<div class="col-6">
		<aui:input name="pec" />
	</div>
</div>

<h1><liferay-ui:message key="dati-richiesta" /></h1>

<div class="row">
	<div class="col-6">
		<aui:input name="id-richiesta" value="${richiesta.id}" />
	</div>
	<div class="col-6">
		<label for="<portlet:namespace />stato"><liferay-ui:message key="stato" /></label>
		<input name="<portlet:namespace />stato"
		       id="<portlet:namespace />stato"
		       class="form-control"
		       value="<liferay-ui:message key="stato-richiesta-${richiesta.stato}" />">
	</div>
</div>

<div class="row">
	<div class="col-3">
		<fmt:formatDate value="${richiesta.dataInserimento}" pattern="dd/MM/yyyy HH:mm" var="richiestaDataInserimento" />
		<aui:input name="data-inserimento" value="${richiestaDataInserimento}" />
	</div>
	<div class="col-3">
		<fmt:formatDate value="${richiesta.dataUltimoAggiornamento}" pattern="dd/MM/yyyy HH:mm" var="richiestaDataUltimoAggiornamento" />
		<aui:input name="data-ultimo-aggiornamento" value="${richiestaDataUltimoAggiornamento}" />
	</div>
	<div class="col-6">
		<aui:input name="servizio" />
	</div>
</div>

<div class="row">
	<div class="col-12">
		<aui:input name="oggetto" value="${richiesta.oggetto}" />
	</div>
</div>

<div class="row">
	<div class="col-12">
		<aui:input type="textarea" name="note" value="${richiesta.note}" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="num-protocollo-richiesta" value="${richiesta.numeroProtocollo}" />
	</div>
	<div class="col-6">
		<aui:input name="data-protocollo-richiesta" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="num-protocollo-esito" />
	</div>
	<div class="col-6">
		<aui:input name="data-protocollo-esito" />
	</div>
</div>

