<%@ include file="init.jsp" %>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<portlet:actionURL name="<%=GestioneAreeTematichePortletKeys.SALVA_ACTION_COMMAND_PATH %>" var="salvaURL">
	<portlet:param name="<%=GestioneAreeTematichePortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
</portlet:actionURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="${salvaURL}">
	
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" readOnly="true" name="<%=GestioneAreeTematichePortletKeys.AREA_TEMATICA_ID %>" label="identificativo" value="${areaTematica.areaTematicaId}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="<%=GestioneAreeTematichePortletKeys.NOME %>" label="nome" value="${areaTematica.nome}">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="<%=GestioneAreeTematichePortletKeys.DESCRIZIONE %>" label="descrizione" value="${areaTematica.descrizione}" />
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="number" min="1" name="<%=GestioneAreeTematichePortletKeys.ORDINE %>" label="ordine" value="${areaTematica.ordine}">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="<%=GestioneAreeTematichePortletKeys.VISIBILE %>" label="visibile" value="${areaTematica.visibile}"/>
				</div>
			</div>
		</div>
				
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>