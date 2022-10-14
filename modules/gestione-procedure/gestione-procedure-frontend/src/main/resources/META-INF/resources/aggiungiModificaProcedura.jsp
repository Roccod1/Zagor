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
				
				<div id="alertTemplateDefault" class="alert alert-success hidden" role="alert">
					<liferay-ui:message key="alert-template-default"/>
				</div>
				
				<div id="alertTemplateCertificato" class="alert alert-success hidden" role="alert">
					<liferay-ui:message key="alert-template-certificato"/>
				</div>
				
				<div id="alertTemplateAutodichiarazione" class="alert alert-success hidden" role="alert">
					<liferay-ui:message key="alert-template-autodichiarazione"/>
				</div>
				
				<aui:input type="hidden" id="countJasperReport" name="countJasperReport"/>
				
				<div id="container-allegati-template" class="hidden">
						
						<aui:row>
							<aui:col span="12" id="container-upload-allegati">
							
									<c:choose>
									
										<c:when test="${not empty listaTemplateJasperReportPdf}">
											<c:forEach items="${listaTemplateJasperReportPdf}" var="templatePdf" varStatus="loop">
												<div  id="jasperDiv${loop.index}">
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
													
													<aui:row>
													
														<aui:col span="1">
														    <a class="aggiungiJasper" onclick="aggiungiRigaJasper();">Aggiungi</a>
														</aui:col>
														
														<aui:col span="1">
                											<a id="rimuoviJasper${loop.index}" onclick="eliminaRigaJasperReport(this); ">Rimuovi</a>
														</aui:col>
														
            										</aui:row>
												</div>
											</c:forEach>
										
										</c:when>
									
									</c:choose>
							
									

							</aui:col>
						</aui:row>
					
				</div>
				
				<aui:input type="hidden" id="countTemplateNativi" name="countTemplateNativi"/>
				
				<div id="container-allegati-template-nativi" class="hidden">
					
					<c:choose>
					
						<c:when test="${not empty listaTemplatePdf}">
							<c:forEach items="${listaTemplatePdf}" var="templatePdf" varStatus="loop">
							
										<div  id="allegatoTemplateNativo${loop.index}">
											<aui:input type="hidden" id="idAllegatoTemplateNativo${loop.index}" name="idAllegatoTemplateNativo${loop.index}" value="${templatePdf.templatePdfId}" />
											
											<p id="nomeFileTemplateNativo${loop.index}" class="mt-3">${templatePdf.nomeFile}</p>
											
											<aui:input type="hidden" id="tipoTemplateNativo${loop.index}" name="tipoTemplateNativo${loop.index}" value="${templatePdf.tipoTemplateNativo}"/>
											
											<c:choose>
												<c:when test="${templatePdf.tipoTemplateNativo == 'DEFAULT'}">
													<aui:input type="file" id="templateNativoFile${loop.index}" name="templateNativoFile${loop.index}" label="template-default">
													<aui:validator name="acceptFiles">
													'ftl'
													</aui:validator>	
													</aui:input>
													
													<aui:row>
														
														<aui:col span="1">
                											<a id="rimuoviTemplateNativo${loop.index}" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a>
														</aui:col>
														
            										</aui:row>			
												</c:when>	
												
												<c:when test="${templatePdf.tipoTemplateNativo == 'CERTIFICATO'}">
													<aui:input type="file" id="templateNativoFile${loop.index}" name="templateNativoFile${loop.index}" label="template-certificato">
													<aui:validator name="acceptFiles">
													'ftl'
													</aui:validator>	
													</aui:input>	
													
													<aui:row>
														
														<aui:col span="1">
                											<a id="rimuoviTemplateNativo${loop.index}" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a>
														</aui:col>
														
            										</aui:row>		
												</c:when>
												
												<c:when test="${templatePdf.tipoTemplateNativo == 'AUTO_DICHIARAZIONE'}">
													<aui:input type="file" id="templateNativoFile${loop.index}" name="templateNativoFile${loop.index}" label="template-autodichiarazione">
													<aui:validator name="acceptFiles">
													'ftl'
													</aui:validator>	
													</aui:input>
													
													<aui:row>
														
														<aui:col span="1">
                											<a id="rimuoviTemplateNativo${loop.index}" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a>
														</aui:col>
														
            										</aui:row>	
												</c:when>
											</c:choose>												
																						
											
										
										</div>								
							</c:forEach>				
										
						</c:when>
						
						<c:otherwise>
							<div id="allegatoTemplateNativo0">
								<aui:input type="hidden" id="idAllegatoTemplateNativo0" name="idAllegatoTemplateNativo0" value="0" />
							
								<aui:input type="hidden" id="tipoTemplateNativo0" name="tipoTemplateNativo0" value="<%=TipoTemplateNativo.DEFAULT.name() %>"/>
								<aui:input type="file" id="templateNativoFile0" name="templateNativoFile0" label="template-default">
								<aui:validator name="acceptFiles">
								'ftl'
								</aui:validator>	
								</aui:input>
								
								<aui:row>
									<aui:col span="1">
										<a id="rimuoviTemplateNativo0" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a>
									</aui:col>
								</aui:row>

							</div>
					
							<div id="allegatoTemplateNativo1">
								<aui:input type="hidden" id="idAllegatoTemplateNativo1" name="idAllegatoTemplateNativo1" value="0" />
							
								<aui:input type="hidden" id="tipoTemplateNativo1" name="tipoTemplateNativo1" value="<%=TipoTemplateNativo.CERTIFICATO.name() %>"/>
								<aui:input type="file" id="templateNativoFile1" name="templateNativoFile1" label="template-certificato">
								<aui:validator name="acceptFiles">
								'ftl'
								</aui:validator>	
								</aui:input>
								
								<aui:row>
									<aui:col span="1">
										<a id="rimuoviTemplateNativo1" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a>
									</aui:col>
								</aui:row>
							</div>
					
							<div id="allegatoTemplateNativo2">
								<aui:input type="hidden" id="idAllegatoTemplateNativo2" name="idAllegatoTemplateNativo2" value="0" />
							
								<aui:input type="hidden" id="tipoTemplateNativo2" name="tipoTemplateNativo2" value="<%=TipoTemplateNativo.AUTO_DICHIARAZIONE.name() %>"/>
								<aui:input type="file" id="templateNativoFile2" name="templateNativoFile2" label="template-auto-dichiarazione">
								<aui:validator name="acceptFiles">
								'ftl'
								</aui:validator>	
								</aui:input>
								
								<aui:row>
									<aui:col span="1">
										<a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a>
									</aui:col>
								</aui:row>

							</div>
						
						</c:otherwise>
					
					</c:choose>
					
				
				</div>
				
			</fieldset>
			<aui:button-row cssClass="text-right">
				<aui:button value="annulla" id="annulla" href="${homeURL}"/>
				<aui:button type="submit" value="salva" id="salva"/>
			</aui:button-row>
		</aui:form>
	
	</aui:col>

</aui:row>


<script>

	var listaFormIdIntegrativi = ${listaFormIntegrativiProcedura};
	var listaTipiIntegrazioneBackoffice = ${listaTipoIntegrazioneBackofficeProcedura};
	var valueSelectAllegati = $('#<portlet:namespace />tipiGenerazioneTemplate').val();
	indexJasperReport = 0;
	indexTemplateNativi = 0;
	
	 
	$(document).ready(function() {
		
		if (valueSelectAllegati == "JASPER_REPORT") {
			$('#container-allegati-template').removeClass("hidden");
		}
		
		if(valueSelectAllegati == "NATIVA"){
			$('#container-allegati-template-nativi').removeClass("hidden");
			
			 var countTemplateNativi = $("#container-allegati-template-nativi > div").length;
			 $("#<portlet:namespace />countTemplateNativi").val(countTemplateNativi);
		}
		
		var conteggioJasperPresenti = $("#<portlet:namespace />container-upload-allegati > div").length; 
		
		var countTemplateNativi = $("#container-allegati-template-nativi > div").length;
		$("#<portlet:namespace />countTemplateNativi").val(countTemplateNativi);

		if(conteggioJasperPresenti>0){
			indexJasperReport = conteggioJasperPresenti;
			$("#<portlet:namespace />countJasperReport").val(conteggioJasperPresenti);
		}
		
		if(countTemplateNativi==1){
			var tipoTemplateNativo = $("#<portlet:namespace />tipoTemplateNativo0").val();
			var divTemplate = $("#container-allegati-template-nativi");
			
			if(tipoTemplateNativo == 'DEFAULT'){
				var campiDaAggiungere = '<div id="allegatoTemplateNativo1"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo1" name="<portlet:namespace />tipoTemplateNativo1" value="CERTIFICATO"> <label class=" control-label" for="templateNativoFile1"> Template certificato </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile1" name="<portlet:namespace />templateNativoFile1" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo1" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div> <div id="allegatoTemplateNativo2"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo2" name="<portlet:namespace />tipoTemplateNativo2" value="AUTO_DICHIARAZIONE"> <label class=" control-label" for="templateNativoFile2"> Template autodichiarazione </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile2" name="<portlet:namespace />templateNativoFile2" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div>';
				divTemplate.append(campiDaAggiungere);
			}
			
			if(tipoTemplateNativo == 'CERTIFICATO'){
				var campiDaAggiungere = '<div id="allegatoTemplateNativo1"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo1" name="<portlet:namespace />tipoTemplateNativo1" value="DEFAULT"> <label class=" control-label" for="templateNativoFile1"> Template default </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile1" name="<portlet:namespace />templateNativoFile1" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo1" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div> <div id="allegatoTemplateNativo2"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo2" name="<portlet:namespace />tipoTemplateNativo2" value="AUTO_DICHIARAZIONE"> <label class=" control-label" for="templateNativoFile2"> Template autodichiarazione </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile2" name="<portlet:namespace />templateNativoFile2" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div>';
				divTemplate.append(campiDaAggiungere);
			}
			
			if(tipoTemplateNativo == 'AUTO_DICHIARAZIONE'){
				var campiDaAggiungere = '<div id="allegatoTemplateNativo1"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo1" name="<portlet:namespace />tipoTemplateNativo1" value="CERTIFICATO"> <label class=" control-label" for="templateNativoFile1"> Template certificato </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile1" name="<portlet:namespace />templateNativoFile1" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo1" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div> <div id="allegatoTemplateNativo2"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo2" name="<portlet:namespace />tipoTemplateNativo2" value="DEFAULT"> <label class=" control-label" for="templateNativoFile2"> Template default </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile2" name="<portlet:namespace />templateNativoFile2" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div>';
				divTemplate.append(campiDaAggiungere);
			}
			
			var countTemplateNativi = $("#container-allegati-template-nativi > div").length;
			$("#<portlet:namespace />countTemplateNativi").val(countTemplateNativi);
		}
		
		if(countTemplateNativi==2){
			var tipoTemplateNativo1 = $("#<portlet:namespace />tipoTemplateNativo0").val();
			var tipoTemplateNativo2 = $("#<portlet:namespace />tipoTemplateNativo1").val();
			var ultimoDiv = $("#container-allegati-template-nativi");

			if(tipoTemplateNativo1 == 'AUTO_DICHIARAZIONE' && tipoTemplateNativo2 == 'CERTIFICATO' || tipoTemplateNativo1 == 'CERTIFICATO' && tipoTemplateNativo2 == 'AUTO_DICHIARAZIONE'){
				var campoDaAggiungere = '<div id="allegatoTemplateNativo2"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo2" name="<portlet:namespace />tipoTemplateNativo2" value="DEFAULT"> <label class=" control-label" for="templateNativoFile2"> Template default </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile2" name="<portlet:namespace />templateNativoFile2" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div>';
				ultimoDiv.append(campoDaAggiungere);
			}
			
			if(tipoTemplateNativo1 == 'AUTO_DICHIARAZIONE' && tipoTemplateNativo2 == 'DEFAULT' || tipoTemplateNativo1 == 'DEFAULT' && tipoTemplateNativo2 == 'AUTO_DICHIARAZIONE'){
				var campoDaAggiungere = '<div id="allegatoTemplateNativo2"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo2" name="<portlet:namespace />tipoTemplateNativo2" value="CERTIFICATO"> <label class=" control-label" for="templateNativoFile2"> Template certificato </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile2" name="<portlet:namespace />templateNativoFile2" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div>';
				ultimoDiv.append(campoDaAggiungere);
			}
			
			if(tipoTemplateNativo1 == 'CERTIFICATO' && tipoTemplateNativo2 == 'DEFAULT' || tipoTemplateNativo1 == 'DEFAULT' && tipoTemplateNativo2 == 'CERTIFICATO'){
				var campoDaAggiungere = '<div id="allegatoTemplateNativo2"> <div class="form-group input-text-wrapper"> <input type="hidden" id="<portlet:namespace />tipoTemplateNativo2" name="<portlet:namespace />tipoTemplateNativo2" value="AUTO_DICHIARAZIONE"> <label class=" control-label" for="templateNativoFile2"> Template autodichiarazione </label> <input class="field form-control" id="<portlet:namespace />templateNativoFile2" name="<portlet:namespace />templateNativoFile2" type="file"> <div class="row"> <div class="col-md-1"> <a id="rimuoviTemplateNativo2" onclick="rimuoviTemplateNativo(this); ">Rimuovi</a> </div> </div> </div> </div>';
				ultimoDiv.append(campoDaAggiungere);
			}
			
			var countTemplateNativi = $("#container-allegati-template-nativi > div").length;
			$("#<portlet:namespace />countTemplateNativi").val(countTemplateNativi);
		}

	});
	
	
	function aggiungiRigaJasper(){
		 var nuovaDiv = '<div  id="jasperDiv'+ indexJasperReport +'"> <input type="hidden" id="idAllegatoJasper'+ indexJasperReport +'" name="<portlet:namespace />idAllegatoJasper'+ indexJasperReport +'" value="0"> <div class="form-group input-text-wrapper"> <label class="control-label">Allegato Jasper Report</label> <input type="file" class="field form-control" id="jasperReportFile'+ indexJasperReport +'" name="<portlet:namespace />jasperReportFile'+ indexJasperReport +'"> </div> <div class="form-group form-inline input-checkbox-wrapper"> <input type="checkbox" class="checkboxPrincipaleAllegati" id="allegatoPrincipale'+ indexJasperReport +'" name="<portlet:namespace />allegatoPrincipale'+ indexJasperReport +'" onClick="checkboxJasperReport(this);"/> <label class="ml-1">Principale</label> </div> <div class="row"> <div class="col-md-1"> <a class="aggiungiJasper" onclick="aggiungiRigaJasper();">Aggiungi</a> </div> <div class="col-md-1"> <a id="rimuoviJasper'+ indexJasperReport +'" onclick="eliminaRigaJasperReport(this);">Rimuovi</a> </div> </div> </div>';
		 indexJasperReport++;
		 $('#<portlet:namespace />container-upload-allegati').append(nuovaDiv);
		 
		 var countJasperReport = $("#<portlet:namespace />container-upload-allegati > div").length;
		 $("#<portlet:namespace />countJasperReport").val(countJasperReport);
	}
	
	function rimuoviTemplateNativo(btn){
		var id = $(btn).attr('id').replace('rimuoviTemplateNativo','');
		var indexRiga = parseInt(id);
		var tipoTemplateNativo = $("#<portlet:namespace />tipoTemplateNativo" + indexRiga).val();
		
		$("#<portlet:namespace />idAllegatoTemplateNativo" + indexRiga).val('');
		$("#nomeFileTemplateNativo" + indexRiga).remove();
		
		if(tipoTemplateNativo == 'DEFAULT'){
			$('#alertTemplateDefault').removeClass('hidden');
			
			setTimeout(function() {
				  $("#alertTemplateDefault").fadeOut().empty();
			}, 5000);
		}
		
		if(tipoTemplateNativo == 'CERTIFICATO'){
			
			$('#alertTemplateCertificato').removeClass('hidden');
			
			setTimeout(function() {
				  $("#alertTemplateCertificato").fadeOut().empty();
			}, 5000);
		}
		
		if(tipoTemplateNativo == 'AUTO_DICHIARAZIONE'){
			
			$('#alertTemplateAutodichiarazione').removeClass('hidden');
			
			setTimeout(function() {
				  $("#alertTemplateAutodichiarazione").fadeOut().empty();
			}, 5000);
		}
	}
	
	function eliminaRigaJasperReport(btn){
		var id = $(btn).attr('id').replace('rimuoviJasper','');
		var indexRiga = parseInt(id);
		var checkboxPrincipale = $('#<portlet:namespace />allegatoPrincipale' + id).is(":checked");
		var countJasperReport = $("#<portlet:namespace />container-upload-allegati > div").length;

		console.log("valore checkbox: " + checkboxPrincipale);
		
		if(countJasperReport>1){
		
			$('#jasperDiv' + id).remove();
		    shiftRowJasperReport(indexRiga);
		    indexJasperReport--;
		    
		    if(checkboxPrincipale){
				console.log("effettuare change principale");
				let elemento = $(".checkboxPrincipaleAllegati").first().prop("checked", true);
				console.log("elemento change : " + elemento);
			}
		}else{
			
			if(!checkboxPrincipale){
				$('#jasperDiv' + id).remove();
			    shiftRowJasperReport(indexRiga);
			    indexJasperReport--;
			}
		}

		$("#<portlet:namespace />countJasperReport").val(countJasperReport);
	}
	
	function shiftRowJasperReport(index) {
		let i = index +1;

	    while(i<indexJasperReport){
	    	let newIndex = i - 1;
	    	$("#jasperReportFile" + i).attr("name","<portlet:namespace />jasperReportFile" + newIndex);
	        $("#jasperReportFile" + i).attr("id","jasperReportFile" + newIndex);
	        
	        $("#allegatoPrincipale" + i).attr("name","<portlet:namespace />allegatoPrincipale" + newIndex);
	        $("#allegatoPrincipale" + i).attr("id","allegatoPrincipale" + newIndex);
	       
	        $("#idAllegatoJasper" + i).attr("name","<portlet:namespace />idAllegatoJasper" + newIndex);
	        $("#idAllegatoJasper" + i).attr("id","idAllegatoJasper" + newIndex);
	        
	        $("#jasperDiv" + i).attr("id","jasperDiv" + newIndex);
	        
	        $("#rimuoviJasper" + i).attr("id","rimuoviJasper" + newIndex);
	        
	        i++;
	    }
	  
	}

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
			$('#container-allegati-template').removeClass("hidden");
			
			var conteggioJasperPresenti = $("#<portlet:namespace />container-upload-allegati > div").length; 
			
			if(conteggioJasperPresenti==0){
				aggiungiRigaJasper();
			}
			
			$('#allegatoPrincipale0')
					.prop("checked", true);
		} else {
			$('#container-allegati-template').addClass("hidden");
		}
		
		if(selectObj.value === "NATIVA"){
			$('#container-allegati-template-nativi').removeClass("hidden");
			var countTemplateNativi = $("#container-allegati-template-nativi > div").length;
			$("#<portlet:namespace />countTemplateNativi").val(countTemplateNativi);
		}else{
			$('#container-allegati-template-nativi').addClass("hidden");
			var countTemplateNativi = $("#container-allegati-template-nativi > div").length;
			$("#<portlet:namespace />countTemplateNativi").val(countTemplateNativi);
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