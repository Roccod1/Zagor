<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=ProfiloUtentePreferenzePortletKeys.ACTION_SALVA_PRIVACY %>" var="salvaURL">
</portlet:actionURL>

<div class="container pl-0 pr-0 mb-4 mt-4">	
	<p>
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ac dui et nunc blandit consectetur. Mauris molestie lorem turpis, in dapibus elit tincidunt quis. Ut non magna augue. Sed tempor fringilla bibendum. Quisque ac felis auctor, lacinia ligula sed, dictum lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et dolor vel arcu vestibulum semper at sit amet eros. Suspendisse vitae massa sollicitudin, aliquet felis sit amet, malesuada nisi. Integer ut turpis vel elit porttitor hendrerit quis sed sapien. In vehicula, erat et varius porta, ipsum mi porta nisl, et consectetur tortor odio sed odio. Vestibulum posuere tellus ac quam placerat, et mollis erat vestibulum.
	</p>
	
	<aui:form method="post" action="${salvaURL }">
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox"
						name="<%=ProfiloUtentePreferenzePortletKeys.UTENTE_ACCETTA_PRIVACY %>"
						label="conferma-presa-visione-privacy"
						value="${utenteAccettaPrivacy }"
						/>
				</div>
			</div>
		</div>
		
		<aui:button-row cssClass="text-right">
			<aui:button type="submit" value="salva"/>
		</aui:button-row>
	</aui:form>
</div>