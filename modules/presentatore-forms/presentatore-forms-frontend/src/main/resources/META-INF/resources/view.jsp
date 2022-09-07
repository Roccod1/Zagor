<%@ include file="./init.jsp" %>

<portlet:resourceURL id="<%=PresentatoreFormsPortletKeys.SUBMIT_FORM_RESOURCE_COMMAND %>" var="submitFormUrl">
</portlet:resourceURL>

<portlet:renderURL var="scegliAllegatiUrl">
		<portlet:param name="mvcRenderCommandName" value="<%=PresentatoreFormsPortletKeys.SCEGLI_ALLEGATI_RENDER_COMMAND %>" />
</portlet:renderURL>