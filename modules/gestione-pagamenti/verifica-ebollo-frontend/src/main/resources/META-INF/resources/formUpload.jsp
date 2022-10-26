<portlet:actionURL
	name="<%=VerificaEbolloFrontendPortletKeys.UPLOAD_FILES_ACTION_COMMAND%>"
	var="uploadFilesURL" />

<aui:form action="${uploadFilesURL}" id="uploadFileForm"
	name="uploadFileForm" enctype="multipart/form-data">
	<aui:fieldset>
		<aui:container>
			<aui:row>
				<aui:col md="6">
					<aui:input label="label.file.documento.upload"
						id="<%=VerificaEbolloFrontendPortletKeys.UPLOAD_DOCUMENTO_ATTRIBUTE%>"
						name="<%=VerificaEbolloFrontendPortletKeys.UPLOAD_DOCUMENTO_ATTRIBUTE%>"
						type="file" required="true" />
				</aui:col>
				<aui:col md="6">
					<aui:input label="label.file.xml.bollo.upload"
						id="<%=VerificaEbolloFrontendPortletKeys.UPLOAD_XML_BOLLO_ATTRIBUTE%>"
						name="<%=VerificaEbolloFrontendPortletKeys.UPLOAD_XML_BOLLO_ATTRIBUTE%>"
						type="file" required="true" />
				</aui:col>
			</aui:row>
		</aui:container>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="button.form.upload"
			id="UploadFilesSubmitButton" />
	</aui:button-row>
</aui:form>