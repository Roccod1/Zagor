<%@ include file="init.jsp" %>

<h2>
	<liferay-ui:message key="dati-dettaglio-pratica" arguments="${titleArgs}" />
</h2>

<%@ include file="dettaglio_azioni_carico.jsp" %>

<portlet:actionURL var="salvaURL" name="/action/aggiornaRichiesta">
</portlet:actionURL>

<aui:form action="${salvaURL}">
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
		<div class="col-6 form-group">
			<fmt:formatDate value="${richiesta.dataProtocollo}" pattern="yyyy-MM-dd'T'HH:mm" var="richiestaDataProtocollo" />
			<label><liferay-ui:message key="data-protocollo-richiesta" /></label>
			<input readonly
				   class="form-control"
		           value="${richiestaDataProtocollo}">
		</div>
	</div>
	
	<c:choose>
		<c:when test="${inCarico}">
			<c:set var="readonlyAttr" value="" />
		</c:when>
		<c:otherwise>
			<c:set var="readonlyAttr" value="readonly" />
		</c:otherwise>
	</c:choose>
	
	<div class="row">
		<div class="col-6 form-group">
			<label class="control-label"><liferay-ui:message key="num-protocollo-esito" /></label>
			<input name="<portlet:namespace />numProtocolloEsito"
			       id="<portlet:namespace />numProtocolloEsito"
			       value="${richiesta.numeroProtocolloEsterno}"
			       ${readonlyAttr}
			       class="form-control">
		</div>
		<div class="col-6 form-group">
			<fmt:formatDate value="${richiesta.dataProtocolloEsterno}" pattern="yyyy-MM-dd'T'HH:mm" var="richiestaDataProtocolloEsterno" />
			<label><liferay-ui:message key="data-protocollo-esito" /></label>
			<input type="datetime-local"
		           ${readonlyAttr}
		           class="form-control"
		           id="<portlet:namespace/>dataProtocolloEsito"
		           name="<portlet:namespace/>dataProtocolloEsito"
		           value="${richiestaDataProtocolloEsterno}">
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">
			<div class="d-flex justify-content-end">
				
				<portlet:resourceURL id="/downloadFileModelloCompilato" var="downloadFileModelloCompilatoUrl">
					<portlet:param name="richiestaId" value="${richiesta.id}"/>
				</portlet:resourceURL>
				
				<aui:button-row cssClass="text-right">
					<aui:button value="scarica-visualizza-modello-compilato-cittadino" type="button" href="${downloadFileModelloCompilatoUrl}" target="_blank"/>
					<aui:button type="submit" value="salva-dati-protocollo"/>
				</aui:button-row>
			</div>
		</div>
	</div>
	
	<aui:input type="hidden" name="id" value="${richiesta.id}" />
</aui:form>

<%@ include file="dettaglio_azioni_carico.jsp" %>
