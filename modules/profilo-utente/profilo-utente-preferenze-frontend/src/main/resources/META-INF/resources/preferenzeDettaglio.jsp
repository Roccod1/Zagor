<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=ProfiloUtentePreferenzePortletKeys.ACTION_SALVA %>" var="salvaURL">
</portlet:actionURL>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="${salvaURL }">
		<aui:input name="<%=ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID%>" value="${organizzazione.organizationId}" type="hidden"/>
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input 
						name="organizationName" 
						value="${organizzazione.name }"
						type="input"
						readOnly="true"
						label="organizzazione"
					/>								
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">		
				<div class="form-group form-check">
					<aui:input type="checkbox" name="<%=ProfiloUtentePreferenzePortletKeys.PREFERITO %>" label="preferito" value="${utenteOrganizzazione.preferito }"/> 
				</div>		
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div>
					<label>
						<liferay-ui:message key="canali-di-comunicazione"/>					
					</label>
				</div>
				<div class="form-group form-check">
					<c:forEach items="${listaCanaliComunicazione }" var="canaleComunicazione">
						<aui:input 
 							type="checkbox"  
 							name="<%=ProfiloUtentePreferenzePortletKeys.CANALE_COMUNICAZIONE %>"  
 							label="${canaleComunicazione.nome }"  
 							value="${canaleComunicazione.canaleComunicazioneId }" 
 							id="canaleComunicazione_${canaleComunicazione.canaleComunicazioneId }"
 						/> 
 					</c:forEach> 
				</div>
			</div>
		</div>
				
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" disabled="${empty listaOrganizzazioni and empty utenteOrganizzazione.organizationId ? true : false }"/>
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>

<script type="text/javascript">

	var listaCanaliComunicazioneAttivi = JSON.parse('${listaUtenteOrganizzazioneCanaleComunicazione}');

	$(function(){
		checkCanaliComunicazioneAttivi();
	});
	
	function checkCanaliComunicazioneAttivi(){
		$.each(listaCanaliComunicazioneAttivi, function (){
			$("#<portlet:namespace />canaleComunicazione_" + this.canaleComunicazioneId).prop("checked", true);			
		});
	}
</script>