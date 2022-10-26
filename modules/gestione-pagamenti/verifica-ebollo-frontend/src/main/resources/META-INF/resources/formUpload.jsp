<portlet:actionURL
	name="<%=VerificaEbolloFrontendPortletKeys.UPLOAD_FILES_ACTION_COMMAND%>"
	var="uploadFilesURL" />
	
<c:if test="${checkDone}">
	<c:choose>
		<c:when test="${isSignatureValid}">
			<div class="alert alert-success" role="alert">
				<liferay-ui:message key="message.signature.valid" />
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger" role="alert">
				<liferay-ui:message key="message.signature.unvalid" />
			</div>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${isFileHashMatch}">
			<div class="alert alert-success" role="alert">
				<liferay-ui:message key="message.fileHash.match" />
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger" role="alert">
				<liferay-ui:message key="message.fileHash.mismatch" />
			</div>
		</c:otherwise>
	</c:choose>
</c:if>

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