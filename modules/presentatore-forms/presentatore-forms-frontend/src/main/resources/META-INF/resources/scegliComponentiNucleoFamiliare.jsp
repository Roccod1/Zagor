<%@ include file="./init.jsp" %>

<portlet:actionURL var="scegliComponenteActionURL" name="<%=PresentatoreFormsPortletKeys.SCEGLI_COMPONENTE_ACTION_COMMAND %>">
</portlet:actionURL>

<liferay-ui:error key="<%=PresentatoreFormsPortletKeys.SELEZIONARE_COMPONENTE_NUCLEO %>" message="error.componenteNucleoFamiliare.required" />

<div class="row-fluid">
	<div class="page-header">
		<h2 class="noMargin">${titoloPortletServizio}<c:if test="${not empty denominazioneComuneServizio}"> - ${denominazioneComuneServizio}</c:if></h2>
	</div>
	<div class="span12 formpresenter-portlet">
		<div class="alpaca-wizard">
			<div class="alpaca-wizard-nav">
	           <nav class="navbar navbar-default" role="navigation">
	               <div class="container-fluid alpaca-wizard-back">
	                   <ul class="nav navbar-nav">
	                       <li class="active visited" data-alpaca-wizard-step-index="0" >
	                           <div class="holder">
	                               <div class="title"><liferay-ui:message key="label.step.primoStep"/></div>
	                               <div class="description"><liferay-ui:message key="label.selezionaFamiliare"/></div>
	                           </div>
	                           <div class="chevron"></div> 
	                       </li>
	                       <li  data-alpaca-wizard-step-index="1" class="disabled">
	                           <div class="holder">
	                               <div class="title">...</div>
	                               <div class="description"></div>
	                           </div>
	                           <div class="chevron"></div>
	                       </li>
	                   </ul>
	               </div>
	           </nav>
			</div>
		</div>
		
		<div class="alpaca-wizard-progress-bar">
			<div class="progress">
				<div class="progress-bar" role="progressbar" style="width: 10%;" aria-valuemax="10" aria-valuenow="10" aria-valuemin="10"></div>
			</div>
		</div>
		
		<aui:form method="post" action="${scegliComponenteActionURL}" name="formScegliComponentiNucleo">		
			<aui:fieldset>		
				<aui:container>			
					<aui:row cssClass="justify-content-center">	
						<aui:col md="6">						
							<aui:select name="<%=PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE %>" cssClass="ml-2" inlineLabel="left" showEmptyOption="true" label="${filtroComponentiFamiliari eq 'FIGLI' ? 'label.componenteNucleoFamiliare.figli.seleziona' : 'label.componenteNucleoFamiliare.seleziona'}">
								<c:forEach items="${componentiNucleoFamiliare}" var="componenteNucleoFamiliare">
									<aui:option value="${componenteNucleoFamiliare.codiceFiscale}" label="${componenteNucleoFamiliare.nome} ${componenteNucleoFamiliare.cognome}"/>
								</c:forEach>								
							</aui:select>					
						</aui:col>					
					</aui:row>	
				</aui:container>			
			</aui:fieldset>
			
			<div class="alpaca-form-buttons-container">
				<aui:button cssClass="pull-right" type="submit" value="button.componenteNucleoFamiliare.avanti" />
			</div>
			
			
		</aui:form>
	</div>
</div>