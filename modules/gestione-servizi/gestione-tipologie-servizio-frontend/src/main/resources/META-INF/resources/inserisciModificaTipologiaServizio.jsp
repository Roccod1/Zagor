<%@ include file="init.jsp" %>

<portlet:renderURL var="homeURL">
</portlet:renderURL>

<portlet:actionURL name="<%=GestioneTipologieServizioPortletKeys.SALVA_ACTION_COMMAND_NAME %>" var="salvaURL">
	<portlet:param name="<%=GestioneTipologieServizioPortletKeys.INDIRIZZO_PRECEDENTE %>" value="${homeURL}"/>
</portlet:actionURL>


<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="${salvaURL}">
	
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" readOnly="true" name="<%=GestioneTipologieServizioPortletKeys.TIPOLOGIA_ID %>" value="${tipologia.tipologiaId}" label="identificativo"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="<%=GestioneTipologieServizioPortletKeys.NOME %>" label="nome" value="${tipologia.nome}">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="<%=GestioneTipologieServizioPortletKeys.DESCRIZIONE %>" label="descrizione" value="${tipologia.descrizione}" />
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="text" name="<%=GestioneTipologieServizioPortletKeys.CHATBOT_INLINE_INTENT %>" label="descrizione" value="${tipologia.descrizione}" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="<%=GestioneTipologieServizioPortletKeys.VISIBILE %>" label="visibile" value="${tipologia.visibile}"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="<%=GestioneTipologieServizioPortletKeys.INVIO_EMAIL_CITTADINO %>" label="invio-email-al-cittadino" value="${tipologia.invioEmailCittadino}"/>
				</div>
			</div>
		</div>
				
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva" />
			<aui:button type="cancel" value="annulla" href="${homeURL}"/>
		</aui:button-row>
	</aui:form>
</div>