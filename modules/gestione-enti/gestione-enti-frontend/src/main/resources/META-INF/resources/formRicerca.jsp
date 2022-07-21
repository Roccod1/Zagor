<%-- <%@ include file="init.jsp" %> --%>

<portlet:actionURL name="<%=GestioneEntiPortletKeys.CERCA_ACTION_COMMAND_NAME %>" var="cercaURL">
</portlet:actionURL>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form id="ricercaServiziForm" action="${cercaURL}" method="post" >
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_NOME_RICERCA %>" label="nome"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="<%=GestioneEntiPortletKeys.ORGANIZZAZIONE_CODICE_IPA_RICERCA %>" label="codice-ipa"></aui:input>
				</div>
			</div>
		</div>	
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="cerca" />
			<aui:button type="button" value="reset" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>