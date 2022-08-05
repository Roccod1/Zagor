<%@ include file="init.jsp" %>

<link
      rel="stylesheet"
      href="https://unpkg.com/bpmn-js@5.1.2/dist/assets/diagram-js.css"
  	/>
    <link
      rel="stylesheet"
      href="https://unpkg.com/bpmn-js@5.1.2/dist/assets/bpmn-font/css/bpmn.css"
    />
    
    <link rel="stylesheet" href="https://unpkg.com/bpmn-js-properties-panel/dist/assets/properties-panel.css">

    <!-- modeler distro -->
    <script src="https://unpkg.com/bpmn-js@5.1.2/dist/bpmn-modeler.development.js"></script>
    
    

<portlet:actionURL name="<%=GestioneProcessiPortletKeys.SALVA_CREA_ACTION_COMMAND %>" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>

<liferay-ui:success key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_RECUPERO_PROCESSO_REPOSITORY %>" message="impossibile-recuperare-processo-da-sistema"/>


<div class="page-header">
				<h2><liferay-ui:message key="processo"/></h2>
</div>

<div class="container mb-4 pl-0 pr-0">
	<aui:form action="${salvaModificaURL}" id="form" name="fm">
		<div class="row">
		
		<aui:input id="idProcesso" name="idProcesso" type="hidden" value="${processo.processoId}"/>
	
			<div class="col-6">
				<div class="form-group">
					<aui:input label="codice" id="codice" name="<%=GestioneProcessiPortletKeys.CODICE %>" type="text" value="${processo.codice}">
					<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
			

			<div class="col-6">
				<div class="form-group ">
					<aui:input label="nome" id="nome" name="<%=GestioneProcessiPortletKeys.NOME %>" value="${processo.nome}" type="text">
					<aui:validator name="required"/>
					</aui:input>			
				</div>	
			</div>
			
			<aui:input type="hidden" id="modelloXml" value="${modelloXml}" name="modelloXml"/>
				
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button value="annulla" id="annulla" href="${homeURL}"/>
			<aui:button type="submit" value="salva" id="salva"/>
		</aui:button-row>
	
	</aui:form>
</div>

<div id="canvas"></div>
<div id="js-properties-panel"></div>

<script>

var inputText = $('#<portlet:namespace />modelloXml');

</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/dist/index.js">
  </script>



 

 
  
  