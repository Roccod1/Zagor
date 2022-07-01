<%@ include file="init.jsp" %>

<portlet:actionURL name="/salvaModifica" var="salvaModificaURL" />

<div class="page-header">
				<h2><liferay-ui:message key="form"/></h2>
</div>

<liferay-ui:success key="eseguito-correttamente" message="operazione-eseguita-correttamente"/>
<liferay-ui:error key="errore-salvataggio" message="compilare-tutti-i-campi-obbligatori" />


<div class="container mb-4 pl-0 pr-0">
	<aui:form action="${salvaModificaURL}" id="form" name="fm">
		<div class="row">
		
		<aui:input id="idform" name="idform" type="hidden" value="${form.formId}"/>
	
			<div class="col-6">
				<div class="form-group">
					<c:choose>
						<c:when test="${form.formId > 0}">
							<aui:input label="codice-identificativo" id="codice-identificativo" name="codice-identificativo" type="text" value="${form.nome}" readonly="true">
							<aui:validator name="required"/>
							</aui:input>	 
						</c:when>
						<c:otherwise>
							<aui:input label="codice-identificativo" id="codice-identificativo" name="codice-identificativo" type="text" value="${form.nome}">
							<aui:validator name="required"/>
							</aui:input>
						</c:otherwise>
					</c:choose>
					
					
				</div>
			</div>
			

			<div class="col-6">
				<div class="form-group ">
					<aui:input label="nome" id="nome" name="nome" value="${form.descrizione}" type="text">
					<aui:validator name="required"/>
					</aui:input>			
				</div>	
			</div>
				
		</div>
		
		<div class ="row">
		
			<div class="col-6">			
				<div class="form-group form-check">	
					<c:choose>
						<c:when test="${form.principale eq true }">
							<aui:input label="principale" type="checkbox" id="principale" name="principale" checked="true"/>					
						</c:when>
						<c:otherwise>
							<aui:input label="principale" type="checkbox" id="principale" name="principale"/>
						</c:otherwise>
					</c:choose>									
				</div>
			</div>
			
			<div class="col-6">			
				<div class="form-group form-check">	
					<c:choose>
						<c:when test="${form.multiutente eq true}">
							<aui:input label="multiente" type="checkbox" id="multiente" name="multiente" checked="true"/>	
						</c:when>						
						<c:otherwise>
							<aui:input label="multiente" type="checkbox" id="multiente" name="multiente" />	
						</c:otherwise>
					</c:choose>						
				</div>
			</div>
		
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button value="annulla" id="annulla" href="${urlTornaIndietro}"/>
			<aui:button type="submit" value="salva" id="salva"/>
		</aui:button-row>
	
	</aui:form>
</div>