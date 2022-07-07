<%@ include file="init.jsp" %>

<portlet:actionURL name="/salvaModifica" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<div class="page-header">
				<h2><liferay-ui:message key="form"/></h2>
</div>

<div class="container mb-4 pl-0 pr-0">
	<aui:form action="${salvaModificaURL}" id="form" name="fm">
		<div class="row">
		
		<aui:input id="idform" name="idform" type="hidden" value="${form.formId}"/>
	
			<div class="col-6">
				<div class="form-group">
					<c:choose>
						<c:when test="${form.formId > 0}">
							<aui:input label="codice-identificativo" id="codice-identificativo" name="codice-identificativo" type="text" value="${form.codice}" readonly="true">
							<aui:validator name="required"/>
							</aui:input>	 
						</c:when>
						<c:otherwise>
							<aui:input label="codice-identificativo" id="codice-identificativo" name="codice-identificativo" type="text" value="${form.codice}">
							<aui:validator name="required"/>
							</aui:input>
						</c:otherwise>
					</c:choose>
					
					
				</div>
			</div>
			

			<div class="col-6">
				<div class="form-group ">
					<aui:input label="descrizione" id="descrizione" name="descrizione" value="${form.descrizione}" type="text">
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
							<aui:input label="principale" type="checkbox" id="principale" name="principale"/>					
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
			<aui:button value="annulla" id="annulla" href="${homeURL}"/>
			<aui:button type="submit" value="salva" id="salva"/>
		</aui:button-row>
	
	</aui:form>
</div>

<%@ include file="editor.jsp" %>