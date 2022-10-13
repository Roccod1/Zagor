<portlet:actionURL name="<%=PagamentoEbolloFrontendPortletKeys.UPLOAD_FILE_ACTION_COMMAND %>" var="uploadFileURL" />

<aui:form  action="${uploadFileURL}" id="uploadFileForm"  name="uploadFileForm" enctype="multipart/form-data">
	<aui:fieldset>
		<aui:container>
			<aui:row>
				<aui:col md="12">
					<aui:input label="label.file.upload" id="<%=PagamentoEbolloFrontendPortletKeys.FILE_TO_UPLOAD_ATTRIBUTE %>" name="<%=PagamentoEbolloFrontendPortletKeys.FILE_TO_UPLOAD_ATTRIBUTE %>" type="file" required="true"/>
				</aui:col>
			</aui:row>
		</aui:container>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="button.form.upload" id="UploadFileSubmitButton"/>
	</aui:button-row>
 </aui:form>