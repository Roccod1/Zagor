<%@ include file="init.jsp" %>

<h1><liferay-ui:message key="dati-richiedente" /></h1>

<div class="row">
	<div class="col-6">
		<aui:input name="denominazione-richiedente" />
	</div>
	<div class="col-6">
		<aui:input name="codice-fiscale" />
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

<h1><liferay-ui:message key="dati-richiesta" /></h1>

<div class="row">
	<div class="col-6">
		<aui:input name="id-richiesta" />
	</div>
	<div class="col-6">
		<aui:input name="stato" />
	</div>
</div>

<div class="row">
	<div class="col-3">
		<aui:input name="data-inserimento" />
	</div>
	<div class="col-3">
		<aui:input name="data-ultimo-aggiornamento" />
	</div>
	<div class="col-6">
		<aui:input name="servizio" />
	</div>
</div>

<div class="row">
	<div class="col-12">
		<aui:input name="oggetto" />
	</div>
</div>

<div class="row">
	<div class="col-12">
		<aui:input type="textarea" name="note" />
	</div>
</div>

<div class="row">
	<div class="col-6">
		<aui:input name="num-protocollo-richiesta" />
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

