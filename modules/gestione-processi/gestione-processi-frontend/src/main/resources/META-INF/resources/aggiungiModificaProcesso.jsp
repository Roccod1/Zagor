<%@ include file="init.jsp" %>

	<link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/css/diagram-js.css"
  	/>
  	
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/css/bpmn.css"
    />
    
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/dist/bpmn-js-properties-panel/assets/element-templates.css"
    />
    
    <link
      rel="stylesheet"
      href="<%=request.getContextPath()%>/dist/bpmn-js-properties-panel/assets/properties-panel.css"
    />
    
    <script src="<%=request.getContextPath()%>/app/bpmn-modeler.development.js"></script>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/dist/bpmn-js-properties-panel/bpmn-js-properties-panel.umd.js" /></script>

     
<portlet:actionURL name="<%=GestioneProcessiPortletKeys.SALVA_CREA_ACTION_COMMAND %>" var="salvaModificaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>

<liferay-ui:error key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_CAMUNDA %>" message="impossibile-effettuare-salvataggio-camunda" />
<liferay-ui:error key="<%=GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_PROCESSO_CODICE_ESISTENTE %>" message="esiste-gia-un-processo-con-codice-specificato" />

<div class="page-header">
	<h2><liferay-ui:message key="processo"/></h2>
</div>

<div class="container mb-4 pl-0 pr-0">
	<aui:form action="${salvaModificaURL}" id="form" name="fm">
		<div class="row">
		
		<aui:input id="idProcesso" name="idProcesso" type="hidden" value="${processo.processoId}"/>
	
			<div class="col-6">
				<div class="form-group">
					<c:choose>
						<c:when test="${processo.processoId > 0}">
							<aui:input label="codice" name="<%=GestioneProcessiPortletKeys.CODICE %>" type="text" value="${processo.codice}" readonly="true">
							<aui:validator name="required"/>
							</aui:input>	 
						</c:when>
						<c:otherwise>
							<aui:input label="codice" name="<%=GestioneProcessiPortletKeys.CODICE %>" type="text" value="${processo.codice}">
							<aui:validator name="required"/>
							</aui:input>
						</c:otherwise>
					</c:choose>
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
			<c:if test="${processo.modificabile}">
				<aui:button type="submit" value="salva" id="salva"/>
			</c:if>
		</aui:button-row>
	
	</aui:form>
</div>

<aui:row>
	<aui:col span="8">
		<div id="canvas"></div>
	</aui:col>
	
	<aui:col span="4">
		<div id="js-properties-panel"></div>
	</aui:col>

</aui:row>

<script>
	var inputText = $('#<portlet:namespace />modelloXml');
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/dist/index.js"></script>