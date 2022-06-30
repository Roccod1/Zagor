<%@ include file="init.jsp" %>

<div class="page-header">
				<h2><liferay-ui:message key="form"/></h2>
</div>


<div class="container mb-4 pl-0 pr-0">
	<aui:form action="" id="form" name="fm">
		<div class="row">
	
			<div class="col-6">
				<div class="form-group">
					<aui:input label="codice-identificativo" id="codice-identificativo" name="codice-identificativo" type="text" disabled="true"/>	
				</div>
			</div>
			

			<div class="col-6">
				<div class="form-group ">
					<aui:input label="nome" id="nome" name="nome" type="text"/>			
				</div>	
			</div>
				

			
			

		</div>
		
		<div class ="row">
		
			<div class="col-6">			
				<div class="form-group form-check">				
					<aui:input label="principale" type="checkbox" id="principale" name="principale"/>				
				</div>
			</div>
			
			<div class="col-6">			
				<div class="form-group form-check">				
					<aui:input label="multiente" type="checkbox" id="multiente" name="multiente"/>				
				</div>
			</div>
		
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button type="reset" value="annulla" id="annulla"/>
			<aui:button value="nuova" id="nuova"/>
		</aui:button-row>
	
	</aui:form>
</div>