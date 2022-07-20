<%@ include file="init.jsp" %>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="">
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:select name="<%=ProfiloUtentePreferenzePortletKeys.ORGANIZATION_ID %>" value="${organizzazione.organizationId }" label="organizzazione">
						<aui:option value="" selected="true" disabled="true" label="seleziona"/>
						<c:forEach items="${listaEnti }" var="organizzazione">
							<aui:option value="${organizzazione.organizationId }" label="${organizzazione.name }"/>
						</c:forEach>
					</aui:select>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">		
				<div class="form-group form-check">
					<aui:input type="checkbox" name="<%=ProfiloUtentePreferenzePortletKeys.DEFAULT %>" label="default"/> 
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
					<%
						List<CanaleComunicazione> listaCanaliComunicazione = (List<CanaleComunicazione>) renderRequest.getAttribute(ProfiloUtentePreferenzePortletKeys.LISTA_CANALI_COMUNICAZIONE);
						
						for(CanaleComunicazione canaleComunicazione : listaCanaliComunicazione){
							
						}
					
					%>
					<c:forEach items="${listaCanaliComunicazione }" var="canaleComunicazione">
						<c:set value="<%=ProfiloUtentePreferenzePortletKeys.CANALE_COMUNICAZIONE %>" var="canaleComunicazioneNome"/>
						<aui:input 
							type="checkbox" 
							name="<%=ProfiloUtentePreferenzePortletKeys.CANALE_COMUNICAZIONE %>" 
							label="${canaleComunicazione.nome }" 
							value="${canaleComunicazione.canaleComunicazioneId }"
							id="${canaleComunicazioneNome}_${canaleComunicazione.canaleComunicazioneId }"
						/>
					</c:forEach>
				</div>
			</div>
		</div>
				
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>