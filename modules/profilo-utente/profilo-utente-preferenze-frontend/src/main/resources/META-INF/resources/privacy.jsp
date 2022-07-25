<%@page import="com.liferay.portal.kernel.service.persistence.PortletUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=ProfiloUtentePreferenzePortletKeys.ACTION_SALVA_PRIVACY %>" var="salvaURL">
</portlet:actionURL>

<div class="container pl-0 pr-0 mb-4 mt-4">	
	<liferay-journal:journal-article articleId="${privacyArticleId }" groupId="${privacyArticleGroupId }" /> 
	
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