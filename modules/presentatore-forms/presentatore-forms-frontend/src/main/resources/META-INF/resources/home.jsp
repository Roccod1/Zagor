<%@ include file="./init.jsp" %>

<portlet:renderURL var="caricaCompilaIstanzaBozzaUrl">
		<portlet:param name="mvcRenderCommandName" value="/caricaCompilaIstanza" />
		<portlet:param name="isBozza" value="true" />
</portlet:renderURL>

<portlet:renderURL var="caricaCompilaIstanzaUrl">
		<portlet:param name="mvcRenderCommandName" value="/caricaCompilaIstanza" />
</portlet:renderURL>

<aui:row>
	<aui:col span="12">
		<div class="page-header">
			<h2 class="noMargin">${titoloPortletServizio}</h2>
		</div>
		<aui:row>
			<aui:col span="12">
				${descrizioneServizio}
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col span="12">
				<liferay-ui:message key="bozza.isPresent"/>
			</aui:col>
		</aui:row>
				
		<aui:button-row cssClass="text-right">
			<aui:button id="caricaBozza" href="${caricaCompilaIstanzaBozzaUrl}" value="button.caricaBozza"/>
			<aui:button id="compilaIstanza" href="${caricaCompilaIstanzaUrl}" value="button.compilaIstanza"/>
		</aui:button-row>
	
	</aui:col>
</aui:row>
