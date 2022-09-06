<portlet:actionURL name="<%=GestioneProcedurePortletKeys.RICERCA_ACTION_COMMAND %>" var="ricercaURL" />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<portlet:renderURL var="dettaglioNuovoURL">
		<portlet:param name="mvcRenderCommandName" value="<%=GestioneProcedurePortletKeys.DETTAGLIO_NUOVO_RENDER_COMMAND %>" />
		<portlet:param name="idProcedura" value="0" />
</portlet:renderURL>

<div class="container mb-4 pl-0 pr-0">
	<aui:form action="${ricercaURL}" id="form" name="fm">
	<aui:row>
	
			<aui:col span="6">
					<aui:input label="nome" id="nome" name="<%=GestioneProcedurePortletKeys.NOME_RICERCA %>" type="text"/>	
			</aui:col>
			
			<aui:col span="6">
			
				<aui:select label="stato" id="stato" name="<%=GestioneProcedurePortletKeys.STATO_RICERCA %>">
					<aui:option value="-1" selected="true">Tutte</aui:option>
					<aui:option value="1">Attive</aui:option>
					<aui:option value="0" >Inattive</aui:option>
				</aui:select>
			
			</aui:col>
			
			

	</aui:row>
	
	
	<aui:row>
	
		<aui:col span="3">
					<aui:input value="${dataInserimentoDa}" label="data-inserimento-da" id="dataInserimentoDa" name="<%=GestioneProcedurePortletKeys.DATA_INSERIMENTO_DA %>" type="date"/>	
		</aui:col>
				

		<aui:col span="3">
					<aui:input label="data-inserimento-a" value="${dataInserimentoA}" id="dataInserimentoA" name="<%=GestioneProcedurePortletKeys.DATA_INSERIMENTO_A %>" type="date"/>	
		</aui:col>
	
	
	</aui:row>
	
	<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="cerca" id="cerca"/>
			<aui:button type="button" value="reset" id="reset" href="${homeURL}" />
			<aui:button value="nuovo" id="nuovo" href="${dettaglioNuovoURL}"/>
	</aui:button-row>
	
 </aui:form>
</div>