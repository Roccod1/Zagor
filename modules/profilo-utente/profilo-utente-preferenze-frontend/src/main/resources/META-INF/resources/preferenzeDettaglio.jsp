<%@ include file="init.jsp" %>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="">
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:select name="<%=ProfiloUtentePreferenzePortletKeys.ENTE %>" value="${ente.organizationId }">
						<aui:option value="" selected="true" disabled="true" label="seleziona"/>
						<c:forEach items="${listaEnti }" var="ente">
							<aui:option value="${ente.organizationId }" label="${ente.name }"/>
						</c:forEach>
					</aui:select>
				</div>
			</div>
			
			<div class="col">
				<div>
					<liferay-ui:message key="canale-comunicazione"/>
				</div>
				<div class="form-group form-check">
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
			
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="<%=ProfiloUtentePreferenzePortletKeys.DEFAULT %>" label="default"/> 
				</div>
			</div>
		</div>
				
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>