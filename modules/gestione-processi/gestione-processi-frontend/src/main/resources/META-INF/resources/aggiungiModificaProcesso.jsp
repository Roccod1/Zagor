<%@ include file="init.jsp" %>

 <!-- required modeler styles -->
<!--     <link rel="stylesheet" href="https://unpkg.com/bpmn-js@9.3.1/dist/assets/diagram-js.css"> -->
<!--     <link rel="stylesheet" href="https://unpkg.com/bpmn-js@9.3.1/dist/assets/bpmn-js.css"> -->
<!--     <link rel="stylesheet" href="https://unpkg.com/bpmn-js@9.3.1/dist/assets/bpmn-font/css/bpmn.css"> -->
    
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/diagram-js.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/vendor/bpmn-font/css/bpmn.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/vendor/bpmn-font/css/bpmn-embedded.css">

    <!-- modeler distro -->
<!--     <script src="https://unpkg.com/bpmn-js@9.3.1/dist/bpmn-modeler.development.js"></script> -->
<!--     <script src="https://unpkg.com/bpmn-js/dist/bpmn-viewer.development.js"></script> -->
    

<portlet:actionURL name="<%=GestioneProcessiPortletKeys.SALVA_CREA_ACTION_COMMAND %>" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>

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
				
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button value="annulla" id="annulla" href="${homeURL}"/>
			<aui:button type="submit" value="salva" id="salva"/>
		</aui:button-row>
	
	</aui:form>
</div>

<div class="content" id="js-drop-zone">
		<div class="message intro">
		  	<div class="note">
		    	Carica un diagramma BPMN dal tuo desktop o <a id="js-create-diagram" href="">crea un nuovo diagramma</a> per iniziare.
		    	
			</div>
		</div>
	
		<div class="message error">
			<div class="note">
		    	<p>Ooops, non &egrave; possibile visualizzare il diagramma BPMN 2.0</p>
		    	<div class="details">
					<span>Causa del problema</span>
		      		<pre></pre>
		    	</div>
		  	</div>
		</div>
	
	    <div class="canvas" id="js-canvas"></div>
	    <div id="js-properties-panel"></div>
	</div>

	<ul class="buttons hidden">
		<li>
		  	Download
		</li>
		<li>
		  	<a id="js-download-diagram" href title="download BPMN diagram">
		    	Diagramma BPMN
		  	</a>
		</li>
		<li>
		  	<a id="js-download-svg" href title="download as SVG image">
		    	SVG image
		  	</a>
		</li>
	</ul>

  <script type="text/javascript" src="<%=request.getContextPath()%>/dist/index.js">
  </script>