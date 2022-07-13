<%@ include file="init.jsp" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.8.0/leaflet.css" integrity="sha512-hoalWLoI8r4UszCkZ5kL8vayOGVae1oxXe/2A4AO6J9+580uKHDO3JdHb7NzwwzK5xr/Fs0W40kiNHxM9vyTtQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Make sure you put this AFTER Leaflet's CSS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.8.0/leaflet.js" integrity="sha512-BB3hKbKWOc9Ez/TAwyWxNXeoV9c1v6FIeYiBieIWkpLjauysF18NzgR1MBNBXf8/KABdlkX68nAhlwcDFLGPCQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	

<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js" integrity="sha256-eTyxS0rkjpLEo16uXTS0uVCS4815lc40K2iVpWDvdSY=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.7.1/ace.js" integrity="sha512-FKkEO4RZEQjFmU1hoUYdx6HJLdpHpNzgWspgnQCxx7OOkDVz4kiGJxR97yWc5bzjwcCpJC/CRCiQzuoGYAChhQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/alpaca/1.5.27/bootstrap/alpaca.min.css" integrity="sha512-PehAqXRAv5QxF18trM6o/TGFqwG7s7g0c1+L4bGYLvYX+cMY0v4iwVMfqOTWjfzwoSFX4ruVt2wlalxzusntjw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/alpaca@1.5.27/dist/alpaca/bootstrap/alpaca.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/init.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/test.js"></script>

 <script src="https://cdnjs.cloudflare.com/ajax/libs/js-beautify/1.14.4/beautifier.js" integrity="sha512-2TxlS1gnPpEDnoOu9Z6UuhkfyENUo42SUKpaJw1ixwtIS1wRd72+AYxrMYrH4lAHg50YfRpohrBUr3Wkl/u77A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/js-beautify/1.14.4/beautify-css.js" integrity="sha512-RRHgUVWUkA5uYRO5gjIo24YrHNKDjv4r63pobxW0zA4ytvgkDKAbST81xmy4dtmPuAunSzQlydFBS0p3oPSsug==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<div>
	                <ul class="nav nav-tabs">
	                    <li><a href="#source" data-toggle="tab" class="nav-item nav-link tab-item tab-item-source">Source</a></li>
	                    <li><a href="#designer" data-toggle="tab" class="nav-item nav-link active tab-item tab-item-designer">Designer</a></li>
	                    <li><a href="#view" data-toggle="tab" class="nav-item nav-link tab-item tab-item-view">View</a></li>
	                    <li><a href="#code" data-toggle="tab" class="nav-item nav-link tab-item tab-item-code">Code</a></li>
	                    <li><a href="#attachments" data-toggle="tab" class="nav-item nav-link tab-item tab-item-attachments">Attachments</a></li>
	                    <li class="hidden"><a href="#loadsave" data-toggle="tab" class="nav-item nav-link tab-item tab-item-loadsave">Load / Save</a></li>
	                </ul>
	            </div>
	            <div class="tab-content">
	                <div class="tab-pane" id="source">
	                    <div class="row">
	                        <div class="col-md-6">
	                            <div>
	                                <ul class="nav nav-tabs">
	                                    <li><a href="#schema" data-toggle="tab" class="nav-item nav-link active tab-source-schema">Schema</a></li>
	                                    <li><a href="#options" data-toggle="tab" class="nav-item nav-link tab-source-options">Options</a></li>
	                                    <li><a href="#source-view" data-toggle="tab" class="nav-item nav-link tab-source-view">View</a></li>
	                                    <li><a href="#data" data-toggle="tab" class="nav-item nav-link tab-source-data">Data</a></li>
	                                </ul>
	                            </div>
	                            <div class="tab-content">
	                                <div class="tab-pane active" id="schema">
	                                </div>
	                                <div class="tab-pane" id="options">
	                                </div>
	                                <div class="tab-pane" id="source-view">
	                                </div>
	                                <div class="tab-pane" id="data">
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-md-6">
	                            <div>
	                                <ul class="nav nav-tabs">
	                                    <li><a href="#preview" class="nav-item nav-link active" data-toggle="tab">Preview</a></li>
	                                </ul>
	                            </div>
	                            <div class="tab-content">
	                                <div class="tab-pane active" id="preview">
	                                    <div class="row">
	                                        <div class="col-md-12">
	                                            <div id="previewDiv"></div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane active" id="designer">
	                    <div class="row">
	                        <div class="col-md-8">
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <div id="designerDiv"></div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-md-4">
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <div>
	                                        <ul class="nav nav-tabs">
	                                            <li><a href="#types" class="nav-item nav-link active" data-toggle="tab">Types</a></li>
	                                            <li><a href="#basic" class="nav-item nav-link" data-toggle="tab">Basic</a></li>
	                                            <li><a href="#advanced" class="nav-item nav-link" data-toggle="tab">Advanced</a></li>
	                                            <li><a href="#layouts" class="nav-item nav-link" data-toggle="tab">Layouts</a></li>
	                                        </ul>
	                                    </div>
	                                    <div class="tab-content" id="alpaca-right-menu">
	                                        <div class="tab-pane active" id="types"></div>
	                                        <div class="tab-pane" id="basic"></div>
	                                        <div class="tab-pane" id="advanced"></div>
	                                        <div class="tab-pane" id="layouts"></div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="view">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div id="viewDiv"></div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="code">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div id="codeDiv"></div>
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="loadsave">
	                    <div class="row">
	                        <div class="col-md-12">
	
	                            <button class="btn btn-custom load-button">Load Form</button>
	                            <br/>
	                            <br/>
	                            <button class="btn btn-custom save-button">Save Form</button>
	                            <br/>
	
	                        </div>
	                    </div>
	                </div>
	                <div class="tab-pane" id="attachments">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div id="attachmentsDiv">
	                            	<div class="table-responsive attachment-table">
	                            		<table class="table table-hover">
	                            			<thead>
	                            				<tr>
	                            					<th>ID</th>
	                            					<th>Denominazione</th>
	                            					<th>Obbligatorio</th>
	                            					<th>Tipi file ammessi</th>
	                            					<th>Tipologia documento</th>
	                            					<th>File</th>
	                            					<th>Azioni</th>
	                            				</tr>
	                            			</thead>
	                            			<tbody class="attachment-tbody">
<%-- 	                            				<c:forEach items="${definizioneForm.definizioneAllegati}" var="allegato"> --%>
<!-- 	                            					<tr> -->
<%-- 	                            						<td>${ allegato.id }</td> --%>
<%-- 	                            						<td>${ allegato.denominazione }</td> --%>
<%-- 	                            						<td>${ allegato.obbligatorio }</td> --%>
<%-- 	                            						<td>${ allegato.tipiFileAmmessi }</td> --%>
<%-- 	                            						<td>${ allegato.codiciTipologiaDocumento }</td> --%>
<%-- 	                            						<td>${ allegato.fileName}</td> --%>
<!-- 	                            						<td> -->
<!-- 	                            							<button class="btn btn-custom btn-inverted delete-attachment" type="button" aria-label="Elimina"> -->
<!-- 	                            								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
<!-- 	                            							</button> -->
	                            							
<!-- 	                            							<button class="btn btn-custom edit-attachment" type="button" aria-label="Modifica"> -->
<!-- 	                            								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> -->
<!-- 	                            							</button> -->
<!-- 	                            						</td> -->
<!-- 	                            					</tr> -->
<%-- 												    ${item}<br> --%>
<%-- 												</c:forEach> --%>
	                            			</tbody>
	                            		</table>
	                            	</div>
	                            	<br/>
	                            	
	                            	<button class="btn btn-custom add-attachment">Nuovo</button>
	                            	
	                            	<form class="form-horizontal hidden attachment-form">
	                            		<input type="hidden" name="attachment-id" id="attachment-id" class="form-control" required="required">
	                            	
		                            	<div class="control-group">
										    <label class="control-label" for="attachment-name">
										    	Denominazione
										    </label>
										    <div class="controls">
										   		<input type="text" name="attachment-name" id="attachment-name" class="form-control" required="required">
										   	</div>
									    </div>
									    <div class="control-group">
									    	<div class="controls">
									    		<label class="checkbox" for="attachment-mandatory">
									    			<input type="checkbox" value="true" id="attachment-mandatory" name="attachment-mandatory">
									    			Obbligatorio
									    		</label>
									    	</div>
									    </div>
									    <div class="control-group">
										    <label class="control-label" for="attachment-filetype">
										    	File Ammessi
										    </label>
										    <div class="controls">
										    	<select id="attachment-filetype" name="attachment-filetype" multiple="multiple" class="form-control" required="required" size="7">
<%-- 										    		<c:forEach items="${attachmentFileTypesMap}" var="attachmentFileType"> --%>
<%-- 										    			<option value="${attachmentFileType.key}">${attachmentFileType.value}</option> --%>
<%-- 										    		</c:forEach> --%>
										    	</select>
										   	</div>
									    </div>

									    <div class="control-group">
										    <label class="control-label" for="attachment-codetype">
										    	Tipologia Documento
										    </label>
										    <div class="controls">
										    	<select id="attachment-codetype" name="attachment-codetype" multiple="multiple" class="form-control">
<%-- 										    		<c:forEach items="${tipoDocumentoList}" var="tipoDocumento"> --%>
<%-- 											    		<option value="${tipoDocumento.codice}">${tipoDocumento.nome}</option> --%>
<%-- 										    		</c:forEach> --%>
										    	</select>
										   	</div>
									    </div>
									    
									    <div class="control-group">
									  		<label class="control-label" for="attachment-file">File</label>
									  	  	<div class="controls">
												<input type="hidden" class="allegato" name="fileName">
												<input type="file" class="file-loading" id="attachment-file" name="file" class="form-control">
												<div id="kv-error-uploadFileModello" style="display: none;"></div>
										    	<div id="modello-container" class="alert alert-info hidden">
										    		File archiviato
									    		</div>
											</div>
										</div>
									    
									    <div class="control-group">
										    <div class="controls">
										    	<button class="btn btn-custom save-attachment" type="submit">
										    		Salva
										    	</button>
										    </div>
									    </div>
									</form>
									<br/>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="modal fade form-builder-modal" role="dialog" style="display: none;">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	                <h4 class="modal-title"></h4>
	            </div>
	            <div class="modal-body">
	            </div>
	            <div class="modal-footer">
	            </div>
	        </div>
	    </div>
	</div>
</div>
