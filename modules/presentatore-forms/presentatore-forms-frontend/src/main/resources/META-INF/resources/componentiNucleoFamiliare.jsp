<%@ include file="./init.jsp" %>

<div class="row-fluid">
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
		
		<aui:form method="post" action="${salvaURL}">		
			<aui:fieldset>		
				<aui:container>			
					<aui:row cssClass="justify-content-center">	
						<aui:col md="6">						
							<aui:select name="<%=PresentatoreFormsPortletKeys.SELECT_COMPONENTI_NUCLEO_FAMILIARE %>" cssClass="ml-2" inlineLabel="left" showEmptyOption="true" label="Seleziona il componente del nucleo familiare:">
								<c:forEach items="${componentiNucleoFamiliare}" var="componenteNucleoFamiliare">
									<aui:option value="${componenteNucleoFamiliare.codiceFiscale}" label="${componenteNucleoFamiliare.nome} ${componenteNucleoFamiliare.cognome}"/>
								</c:forEach>								
							</aui:select>						
						</aui:col>					
					</aui:row>			
				</aui:container>			
			</aui:fieldset>		
		</aui:form>
	</div>
</div>
