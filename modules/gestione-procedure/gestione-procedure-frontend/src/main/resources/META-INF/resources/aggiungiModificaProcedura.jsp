<%@ include file="init.jsp" %>

<div class="page-header">
	<h2><liferay-ui:message key="procedura"/></h2>
</div>


<aui:row>

	<aui:col span="12">
	
		<aui:form id="nuovaProceduraForm" action="" name="formConfiguraProcedura">
			<fieldset>
				<legend><liferay-ui:message key="dati-identificativi"/></legend>
				<aui:row>
					<aui:col span="6">
							<aui:input label="nome" name="<%=GestioneProcedurePortletKeys.NOME %>" type="text" value=""> 
							<aui:validator name="required"/>
							</aui:input>
					</aui:col>
					<aui:col span="6">
							<aui:input label="pec" name="<%=GestioneProcedurePortletKeys.PEC %>" type="text" value="">
							<aui:validator name="required"/>
							</aui:input> 
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
								<aui:input label="attiva-procedura" name="<%=GestioneProcedurePortletKeys.ATTIVA_PROCEDURA %>" type="checkbox"/>
					</aui:col>
				</aui:row>
			</fieldset>
			
			<fieldset>
				<legend><liferay-ui:message key="configurazione-procedura"/></legend>
				<aui:row>
					<aui:col span="6">
								<aui:select label="servizio" name="<%=GestioneProcedurePortletKeys.SERVIZIO %>">
									<aui:option value="" label="seleziona" disabled="true" selected="true"/>
										<c:forEach items="${listaServizi }" var="servizio">
											<aui:option value="${servizio.servizioId }" label="${servizio.nome }"/>
										</c:forEach>
								<aui:validator name="required"/>
								</aui:select>
					</aui:col>
					
					<aui:col span="6">
								<aui:select label="processo-bpmn" name="<%=GestioneProcedurePortletKeys.PROCESSO_BPMN %>">
									<aui:option value="" label="seleziona" disabled="true" selected="true"/>
										<c:forEach items="${listaProcessi }" var="processo">
											<aui:option value="${processo.processoId }">${processo.nome}</aui:option>
										</c:forEach>
								</aui:select>
						</aui:col>
					</aui:row>
				
				<aui:row>
					<aui:col span="6">
								<aui:select label="identificativo-form-principale" name="<%=GestioneProcedurePortletKeys.IDENTIFICATIVO_FORM_PRINCIPALE %>">
									<aui:option value="" label="seleziona" disabled="true" selected="true"/>
										<c:forEach items="${listaFormPrincipali}" var="form">
											<aui:option value="${form.formId}">${form.nome}</aui:option>
										</c:forEach>
								<aui:validator name="required"/>
								</aui:select>
					</aui:col>
				
					<aui:col span="6">
								<aui:select label="identificativi-form-integrativi" name="<%=GestioneProcedurePortletKeys.IDENTIFICATIVI_FORM_INTEGRATIVI %>" multiple="true">
									<aui:option value="" label="seleziona" disabled="true" selected="true"/>
										<c:forEach items="${listaFormIntegrativi}" var="form">
											<aui:option value="${form.formId}">${form.nome}</aui:option>
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
								<aui:input label="step1" type="checkbox" name="<%=GestioneProcedurePortletKeys.CONFIGURAZIONE_STEP1_ATTIVO %>"/>
						</aui:col>
						<aui:col span="6">
								<aui:select label="filtro-componenti-nucleo-familiare" name="<%=GestioneProcedurePortletKeys.FILTRO_COMPONENTI_NUCLEO_FAMILIARE %>">
									<aui:option value="">Lista componenti nucleo familiare</aui:option>
								</aui:select>
						</aui:col>
					</aui:row>
				</div>
				
				<div>
					<h3><liferay-ui:message key="step2"/></h3>
					<aui:row>
						<aui:col span="6">
								<aui:select label="tipologia-servizio" name="<%=GestioneProcedurePortletKeys.TIPOLOGIA_SERVIZIO %>">
									<aui:option value="">Tipologia Servizio</aui:option>
								</aui:select>
						</aui:col>
						<aui:col span="6">
								<aui:select label="tipi-integrazioni-con-backoffice" name="<%=GestioneProcedurePortletKeys.TIPI_INTEGRAZIONI_BACKOFFICE %>" multiple="true">
									<aui:option value="">Tipi integrazioni con backoffice</aui:option>
								</aui:select>
						</aui:col>
					</aui:row>
				</div>	
				
				<div>
					<h3><liferay-ui:message key="tipo-integrazione-caricamento-nucleo-familiare"/></h3>
					<aui:row>
						<aui:col span="6">
								<aui:select label="caricamento-da" name="<%=GestioneProcedurePortletKeys.CARICAMENTO_DA %>">
									<aui:option>Caricamento da</aui:option>
								</aui:select>
						</aui:col>
						
						<aui:col span="6">
							<aui:input label="abilita-cache-integrazioni-backoffice" type="checkbox" name="<%=GestioneProcedurePortletKeys.ABILITA_CACHE_INTEGRAZIONI_BACKOFFICE %>"/>	
						</aui:col>
					</aui:row>

					<h3><liferay-ui:message key="tipo-di-generazione-template-pdf"/></h3>
					<aui:row>
						<aui:col span="6">
								<aui:select label="generazione-template" name="<%=GestioneProcedurePortletKeys.TIPI_GENERAZIONE_TEMPLATE %>" onchange="handleAttachments(this)" class="col-12" id="select-template">
									<aui:option value="S1"><liferay-ui:message key="generazione-automatica-template"/></aui:option>
									<aui:option value="S2"><liferay-ui:message key="jasper-report"/></aui:option>
								</aui:select>
						</aui:col>
						
						<aui:col span="6">
								<aui:input label="abilita-pagamento" type="checkbox" name="<%=GestioneProcedurePortletKeys.ABILITA_PAGAMENTO %>"/>
						</aui:col>
					</aui:row>

<!-- 					<div class="form-group" id="container-allegati-template"> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-12 text-left"> -->
<!-- 				       			 <button id="btn-add-attachment" type="button" class="btn btn-primary"> -->
<%-- 				       			 	<i class="fa fa-plus-circle"></i><liferay-ui:message key="aggiungi-allegato"/> --%>
<!-- 				       			 </button> -->
<!-- 							</div> -->
<!-- 						</div> -->
						
<!-- 						<div class="row"> -->
<!-- 							<div class="col-12"> -->
<!-- 								<div id="container-btn-upload"> -->
<%-- 									<c:forEach varStatus="loop"	items="${formConfiguraProcedura.datiReportTemplates}" var="datiReportTemplate"> --%>
<%-- 										<div id="div-allegato-${loop.index}"> --%>
<%-- 										<form:hidden path="datiReportTemplates[${loop.index}].id"/> --%>
<%-- 										<form:hidden path="datiReportTemplates[${loop.index}].attivoString"/> --%>
<%-- 											<br> <form:input id="allegato-${loop.index}" type="file" nomefile="${datiReportTemplate.nomeFile}" --%>
<%-- 												path="datiReportTemplates[${loop.index}].multipartFile"/> --%>
<%-- 											<div id="kv-error-${loop.index}" style="display: none;"></div> --%>
<!-- 											<div> -->
<%-- 												<form:hidden path="datiReportTemplates[${loop.index}].padreString" /> --%>
<%-- 												<input type="checkbox" name="isPadre" ${"padre".equalsIgnoreCase(datiReportTemplate.padreString) ? 'checked' : ''} onchange="handleChecks(this)"/>  --%>
<!-- 												<span style="padding-left: 8px; vertical-align: sub;">Principale</span> -->
<!-- 											</div> -->
<!-- 										</div> -->
<%-- 									</c:forEach> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
			</fieldset>
			<aui:button-row cssClass="text-right">
				<aui:button value="annulla" id="annulla" href="${homeURL}"/>
				<aui:button type="submit" value="salva" id="salva"/>
			</aui:button-row>
		</aui:form>
	
	</aui:col>

</aui:row>
