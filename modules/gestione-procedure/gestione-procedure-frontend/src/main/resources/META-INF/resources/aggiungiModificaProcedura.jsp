<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=GestioneProcedurePortletKeys.SALVA_CREA_ACTION_COMMAND %>" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>

<liferay-ui:error key="<%=GestioneProcedurePortletKeys.SESSION_ERROR_CAMPI_OBBLIGATORI %>" message="compilare-campi-obbligatori" />
<liferay-ui:error key="<%=GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_SERVIZI %>" message="impossibile-recuperare-servizi" />
<liferay-ui:error key="<%=GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_PROCESSI %>" message="impossibile-recuperare-processi" />
<liferay-ui:error key="<%=GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_FORM_PRINCIPALI %>" message="impossibile-recuperare-form-principali" />
<liferay-ui:error key="<%=GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_FORM_INTEGRATIVI %>" message="impossibile-recuperare-form-integrativi" />
<liferay-ui:error key="<%=GestioneProcedurePortletKeys.SESSION_ERROR_IMPOSSIBILE_RECUPERARE_PROCEDURA %>" message="impossibile-recuperare-procedura" />



<div class="page-header">
	<h2><liferay-ui:message key="procedura"/></h2>
</div>


<aui:row>

	<aui:col span="12">
	
		<aui:form id="nuovaProceduraForm" action="${salvaModificaURL}" name="formConfiguraProcedura">
			<fieldset>
				<legend><liferay-ui:message key="dati-identificativi"/></legend>
				<aui:input name="idProcedura" type="hidden" value="${procedura.proceduraId}" />
				<aui:row>
					<aui:col span="6">
							<aui:input label="nome" name="<%=GestioneProcedurePortletKeys.NOME %>" type="text" value="${procedura.nome}"> 
							<aui:validator name="required"/>
							</aui:input>
					</aui:col>
					<aui:col span="6">
							<aui:input label="pec" name="<%=GestioneProcedurePortletKeys.PEC %>" type="email" value="${procedura.pecDestinazione}">
							<aui:validator name="required"/>
							</aui:input> 
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
								<aui:input label="attiva-procedura" name="<%=GestioneProcedurePortletKeys.ATTIVA_PROCEDURA %>" type="checkbox" value="${procedura.attiva}"/>
					</aui:col>
				</aui:row>
			</fieldset>
			
			<fieldset>
				<legend><liferay-ui:message key="configurazione-procedura"/></legend>
				<aui:row>
					<aui:col span="6">
								<aui:select label="servizio" name="<%=GestioneProcedurePortletKeys.SERVIZIO %>" value="${procedura.servizioId}">
										<aui:option value="" label="seleziona" disabled="true" selected="true"/>
										<c:forEach items="${listaServizi }" var="servizio">
											<aui:option value="${servizio.servizioId}" label="${servizio.nome}"/>
										</c:forEach>
								<aui:validator name="required"/>
								</aui:select>
					</aui:col>
					
					<aui:col span="6">
								<aui:select name="<%=GestioneProcedurePortletKeys.PROCESSO_BPMN %>" value="${procedura.processoId}" showEmptyOption="true" label="processo-bpmn">
										<c:forEach items="${listaProcessi}" var="processo">
											<aui:option value="${processo.processoId}" label="${processo.nome}"></aui:option>
										</c:forEach>
								</aui:select>
						</aui:col>
					</aui:row>
				
				<aui:row>
					<aui:col span="6">
								<aui:select label="identificativo-form-principale" name="<%=GestioneProcedurePortletKeys.IDENTIFICATIVO_FORM_PRINCIPALE %>" value="${idFormPrincipale}">
									<aui:option value="" label="seleziona" disabled="true" selected="true"/>
										<c:forEach items="${listaFormPrincipali}" var="form">
											<aui:option value="${form.formId}" label="${form.nome}"></aui:option>
										</c:forEach>
								<aui:validator name="required"/>
								</aui:select>
					</aui:col>
				
					<aui:col span="6">
								<aui:select id="listaFormIntegrativiProcedura" label="identificativi-form-integrativi" name="<%=GestioneProcedurePortletKeys.IDENTIFICATIVI_FORM_INTEGRATIVI %>" multiple="true" showEmptyOption="true">
										<c:forEach items="${listaFormIntegrativi}" var="form">
											<aui:option value="${form.formId}" label="${form.nome}"></aui:option>
										</c:forEach>
								</aui:select>
					</aui:col>
				</aui:row>
			</fieldset>
			
			<fieldset>
				<legend><liferay-ui:message key="configurazione-pagina-servizio"/></legend>
				
				<div>
					<h3><liferay-ui:message key="step1"/></h3>
					<aui:row>
						<aui:col span="6">
								<aui:input label="step1" type="checkbox" name="<%=GestioneProcedurePortletKeys.CONFIGURAZIONE_STEP1_ATTIVO %>" value="${procedura.step1Attivo}"/>
						</aui:col>
						<aui:col span="6">
								<aui:select label="filtro-componenti-nucleo-familiare" name="<%=GestioneProcedurePortletKeys.FILTRO_COMPONENTI_NUCLEO_FAMILIARE %>" value="${procedura.step1TipoComponentiNucleoFamiliare}" showEmptyOption="true">
										<c:forEach items="${listaTipoComponentiFamiliari}" var="filtroComponentiNucleoFamiliare">
											<aui:option value="${filtroComponentiNucleoFamiliare}" label="${filtroComponentiNucleoFamiliare}"></aui:option>
										</c:forEach>
								</aui:select>
						</aui:col>
					</aui:row>
				</div>
				
				<div>
					<h3><liferay-ui:message key="step2"/></h3>
					<aui:row>
						<aui:col span="6">
								<aui:select label="tipologia-servizio" name="<%=GestioneProcedurePortletKeys.TIPOLOGIA_SERVIZIO %>" value="${procedura.step2TipoServizio}" showEmptyOption="true">
										<c:forEach items="${listaTipoServizio}" var="tipoServizio">
											<c:set var="labelTipoServizio" value="tipo-servizio_${tipoServizio}" />
											<aui:option value="${tipoServizio}" label="${labelTipoServizio}"></aui:option>
										</c:forEach>
								</aui:select>
						</aui:col>
						<aui:col span="6">
								<aui:select id="tipiIntegrazioneBackoffice" label="tipi-integrazioni-con-backoffice" name="<%=GestioneProcedurePortletKeys.TIPI_INTEGRAZIONI_BACKOFFICE %>" multiple="true" value="${listaTipoIntegrazioneBackofficeProcedura}" showEmptyOption="true">
										<c:forEach items="${listaTipoIntegrazioneBackoffice}" var="tipoIntegrazioneBackoffice">
											<c:set var="labelTipoIntegrazioneBackoffice" value="tipo-integrazione-backoffice_${tipoIntegrazioneBackoffice}" />
											<aui:option value="${tipoIntegrazioneBackoffice}" label="${labelTipoIntegrazioneBackoffice}"></aui:option>
										</c:forEach>
								</aui:select>
						</aui:col>
					</aui:row>
				</div>	
				
				<div>
					<aui:row>
						<aui:col span="6">
							<aui:input label="abilita-cache-integrazioni-backoffice" type="checkbox" name="<%=GestioneProcedurePortletKeys.ABILITA_CACHE_INTEGRAZIONI_BACKOFFICE %>" value="${procedura.abilitaCacheIntegrazioneBackoffice}"/>	
						</aui:col>
					</aui:row>

					<h3><liferay-ui:message key="tipo-di-generazione-template-pdf"/></h3>
					<aui:row>
						<aui:col span="6">
								<aui:select id="tipiGenerazioneTemplate" label="generazione-template" name="<%=GestioneProcedurePortletKeys.TIPI_GENERAZIONE_TEMPLATE %>" value="${procedura.tipoGenerazionePDF}" showEmptyOption="true" onchange="handleAttachments(this);">
										<c:forEach items="${listaTipoGenerazionePDF}" var="tipoGenerazionePDF">
											<c:set var="labelTipoGenerazionePDF" value="generazione-template_${tipoGenerazionePDF}" />
											<aui:option value="${tipoGenerazionePDF}" label="${labelTipoGenerazionePDF}"></aui:option>
										</c:forEach>
								</aui:select>
						</aui:col>
					</aui:row>

				</div>
				
				<div id="container-allegati-template" class="invisible">
						
						<aui:row>
							<aui:col span="12" id="container-upload-allegati">
							
									<c:choose>
									
										<c:when test="${not empty listaTemplatePdf}">
											<c:forEach items="${listaTemplatePdf}" var="templatePdf" varStatus="loop">
												<div class="lfr-form-row lfr-form-row-inline">
													<aui:input type="hidden" name="idAllegatoJasper${loop.index}" value="${templatePdf.templatePdfId}"/>
													<p>${templatePdf.nomeFile}</p>
													<aui:input type="file" name="jasperReportFile${loop.index}" label="allegato-jasper-report">
													<aui:validator name="acceptFiles">
													'jrxml'
													</aui:validator>	
													</aui:input>
													<c:choose>
														<c:when test="${templatePdf.templatePdfParentId==0}">
															<aui:input label="principale" type="checkbox" id="allegatoPrincipale${loop.index}" name="allegatoPrincipale${loop.index}" cssClass="checkboxPrincipaleAllegati" onClick="checkboxJasperReport(this);" checked="true"/>
														</c:when>
												
														<c:otherwise>
															<aui:input label="principale" type="checkbox" id="allegatoPrincipale${loop.index}" name="allegatoPrincipale${loop.index}" cssClass="checkboxPrincipaleAllegati" onClick="checkboxJasperReport(this);"/>
														</c:otherwise>
											
													</c:choose>
												</div>
											</c:forEach>
										
										</c:when>
										
										<c:otherwise>
											<div class="lfr-form-row lfr-form-row-inline">
													<aui:input type="hidden" name="idAllegatoJasper0" value="0"/>
													<aui:input type="file" name="jasperReportFile0" label="allegato-jasper-report">
													<aui:validator name="acceptFiles">
													'jrxml'
													</aui:validator>	
													</aui:input>
													<aui:input label="principale" type="checkbox" id="allegatoPrincipale0" name="allegatoPrincipale0" cssClass="checkboxPrincipaleAllegati" onClick="checkboxJasperReport(this);"/>
											</div>
										</c:otherwise>
									
									</c:choose>
							
									

							</aui:col>
						</aui:row>
					
				</div>
				
			</fieldset>
			<aui:button-row cssClass="text-right">
				<aui:button value="annulla" id="annulla" href="${homeURL}"/>
				<aui:button type="submit" value="salva" id="salva"/>
			</aui:button-row>
		</aui:form>
	
	</aui:col>

</aui:row>

<aui:script use="liferay-auto-fields">
	new Liferay.AutoFields({
		contentBox: '#<portlet:namespace />container-upload-allegati',
		fieldIndexes: '<portlet:namespace />rowIndexes',
		 on: {
       		'clone': function(event) {
       			var ultimoInputFile = $("#container-allegati-template").find('input[type=file]:last');
       			var nomeFile = $("#container-allegati-template").find('p:last');
       			$(ultimoInputFile).val("");
       			nomeFile.remove();
       		},
       		'delete': function(event) {
       			 console.log(event);
	       		 var rowEliminata = event.deletedRow;
	       		 rowEliminata = rowEliminata.replace('DIV','');
	       		 console.log("Riga eliminata: " + rowEliminata);
       		}
       	}
	}).render();
</aui:script>

<script>

	var listaFormIdIntegrativi = ${listaFormIntegrativiProcedura};
	var listaTipiIntegrazioneBackoffice = ${listaTipoIntegrazioneBackofficeProcedura};
	var valueSelectAllegati = $('#<portlet:namespace />tipiGenerazioneTemplate').val();


	$(document).ready(function() {
		if (valueSelectAllegati == "JASPER_REPORT") {
			$('#container-allegati-template').removeClass("invisible");
		}
	});

	function checkboxJasperReport(checkbox) {

		var idCheckboxSelezionata = $(checkbox).attr('id');
		$(checkbox).prop("checked", true);

		$('.checkboxPrincipaleAllegati').each(function() {
			if (idCheckboxSelezionata != $(this).attr('id')) {
				$(this).prop("checked", false);
			}
		});

		return false;
	}

	function handleAttachments(selectObj) {
		if (selectObj.value === "JASPER_REPORT") {
			$('#container-allegati-template').removeClass("invisible");
			$('#<portlet:namespace />allegatoPrincipale0')
					.prop("checked", true);
		} else {
			$('#container-allegati-template').addClass("invisible");
		}
	}

	if (listaFormIdIntegrativi !== "listaVuota") {
		var arrayIdFormString = JSON.stringify(listaFormIdIntegrativi);
		var jsonArray = JSON.parse(arrayIdFormString);
		$('#<portlet:namespace />listaFormIntegrativiProcedura').val(jsonArray);
	}

	if (listaTipiIntegrazioneBackoffice !== "listaVuota") {
		var arrayTipiIntegrazioneBackoffice = JSON
				.stringify(listaTipiIntegrazioneBackoffice);
		var tipiIntegrazioneBackoffice = JSON
				.parse(arrayTipiIntegrazioneBackoffice);
		console
				.log("tipiIntegrazioneBackoffice: "
						+ tipiIntegrazioneBackoffice);
		$('#<portlet:namespace />tipiIntegrazioneBackoffice').val(
				tipiIntegrazioneBackoffice);
	}
</script>