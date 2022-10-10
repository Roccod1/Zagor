<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_RICHIESTE %>" var="getRichiesteUtenteResourceCommandUrl">
</portlet:resourceURL>

<portlet:resourceURL id="<%=ScrivaniaCittadinoPortletKeys.RESOURCE_COMMAND_GET_PAGAMENTI %>" var="getPagamentiUtenteResourceCommandUrl">
</portlet:resourceURL>

<div class="container">
	<div class="row">
		<div class="col-11">
			<h3><liferay-ui:message key="pratiche"/></h3>						
		</div>	
		<div class="col-1">
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filterCollapseRichieste" aria-expanded="false"><liferay-ui:message key="filtri"/></button>
		</div>
	</div>
	<div class="row collapse" id="filterCollapseRichieste">
		<div class="col-5">
			<aui:input type="text" name="filterOggettoRichiesta" label="titolo-o-descrizione"/>				
		</div>
		
		<div class="col">
			<aui:select name="filterStatoRichiesta" label="stato">
				<aui:option value=""><liferay-ui:message key="seleziona-opzione"/></aui:option>
				<c:forEach items="${listaStato }" var="statoRichiesta">
					<aui:option value="${statoRichiesta}">${statoRichiesta.toString().replace("_", " ")}</aui:option>
				</c:forEach>
			</aui:select>			
		</div>
		
		<div class="col">
			<aui:select name="sortByNameRichiesta" label="ordina-per">
				<aui:option value=""><liferay-ui:message key="seleziona-opzione"/></aui:option>
				<aui:option value="createDate"><liferay-ui:message key="data-creazione"/></aui:option>
				<aui:option value="modifiedDate"><liferay-ui:message key="data-modifica"/></aui:option>
			</aui:select>			
		</div>
		
		<div class="col">
			<label><liferay-ui:message key="direzione"/></label>
			<input type="hidden" id="<portlet:namespace/>orderByTypeRichiesta"/>
			<div class="form-check">
				<aui:input type="radio" name="orderByType" id="orderByTypeAscRichiesta" class="form-check-input" label="crescente" value="asc" onclick="setSortTypeValue('orderByTypeRichiesta',this)"/>
			</div>
			<div class="form-check">
				<aui:input type="radio" name="orderByType" id="orderByTypeDescRichiesta" class="form-check-input" label="decrescente" value="desc" onclick="setSortTypeValue('orderByTypeRichiesta',this)"/>
			</div>			
		</div>
		
		<div class="col-12 mb-3">
			<button class="btn btn-primary" type="button" onclick="getRichiesteUtente(1)"><liferay-ui:message key="cerca"/></button>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div id="<portlet:namespace/>accordionContainerRichieste"></div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-11">
			<h3><liferay-ui:message key="pagamenti"/></h3>						
		</div>
		<div class="col-1">
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filterCollapsePagamenti" aria-expanded="false">Filtri</button>
		</div>
	</div>
	<div class="row collapse" id="filterCollapsePagamenti">
		<div class="col-5">
			<aui:input type="text" name="filterOggettoPagamento" label="titolo-o-descrizione"/>				
		</div>
		
		<div class="col">
			<aui:select name="filterStatoPagamento" label="stato">
				<aui:option value=""><liferay-ui:message key="seleziona-opzione"/></aui:option>
				<c:forEach items="${listaStato }" var="statoRichiesta">
					<aui:option value="${statoRichiesta}">${statoRichiesta.toString().replace("_", " ")}</aui:option>
				</c:forEach>
			</aui:select>			
		</div>
		
		<div class="col">
			<aui:select name="sortByNamePagamento" label="ordina-per">
				<aui:option value=""><liferay-ui:message key="seleziona-opzione"/></aui:option>
				<aui:option value="createDate"><liferay-ui:message key="data-creazione"/></aui:option>
				<aui:option value="modifiedDate"><liferay-ui:message key="data-modifica"/></aui:option>
			</aui:select>			
		</div>
		
		<div class="col">
			<label><liferay-ui:message key="direzione"/></label>
			<input type="hidden" id="<portlet:namespace/>orderByTypePagamento"/>
			<div class="form-check">
				<aui:input type="radio" name="orderByType" id="orderByTypeAscPagamento" class="form-check-input" label="crescente" value="asc" onclick="setSortTypeValue('orderByTypePagamento',this)"/>
			</div>
			<div class="form-check">
				<aui:input type="radio" name="orderByType" id="orderByTypeDescPagamento" class="form-check-input" label="decrescente" value="desc" onclick="setSortTypeValue('orderByTypePagamento',this)"/>
			</div>			
		</div>
		
		<div class="col-12 mb-3">
			<button class="btn btn-primary" type="button" onclick="getPagamentiUtente(1)"><liferay-ui:message key="cerca"/></button>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div id="<portlet:namespace/>accordionContainerPagamenti"></div>
		</div>
	</div>
</div>


<script type="text/javascript">
	
// 	on documentReady
	$(function(){
		getPagamentiUtente(1);
		getRichiesteUtente(1);
	});
	
	function getRichiesteUtente(cur){
		
		var params = {
			'<portlet:namespace/>cur': cur,
			'<portlet:namespace/>orderByCol': $("#<portlet:namespace/>sortByNameRichiesta").val(),
			'<portlet:namespace/>orderByType': $("#<portlet:namespace/>orderByTypeRichiesta").val(),
			'<portlet:namespace/>filterOggettoRichiesta': $("#<portlet:namespace/>filterOggettoRichiesta").val(),
			'<portlet:namespace/>filterStatoRichiesta': $("#<portlet:namespace/>filterStatoRichiesta").val(),
		}
		
		var accordionContainer = "#<portlet:namespace/>accordionContainerRichieste";
		
		var html = '';
		
		$.ajax({
			method: 'GET',
			url: '${getRichiesteUtenteResourceCommandUrl}',
			data: params,
			async: true,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				
				result = JSON.parse(result);

				if(Array.isArray(result.listaRichieste) && result.listaRichieste.length > 0){
					html = $.render.accordion({
							dataToRender:result.listaRichieste, 
							templateName:"richiesta", 
							cur:result.cur,
							hasNext:result.hasNext,
							methodName:"getRichiesteUtente"
						});
				}else{
					html = $.render.alert({tipo: "secondary", message: messages.noResult});
				}
			},
			error: function(xhr, status, error){
				console.log("error: ", error);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				html = $.render.alert({tipo: "secondary", message: messages.noResult});
			},
			complete: function(xhr, status){
				$(accordionContainer).html(html);
			}
		});
	}
	
	function getPagamentiUtente(cur){
		
		var params = {
			'<portlet:namespace/>cur': cur,
			'<portlet:namespace/>orderByCol': $("#<portlet:namespace/>sortByNamePagamento").val(),
			'<portlet:namespace/>orderByType': $("#<portlet:namespace/>orderByTypePagamento").val(),
			'<portlet:namespace/>filterOggettoPagamento': $("#<portlet:namespace/>filterOggettoPagamento").val(),
			'<portlet:namespace/>filterStatoPagamento': $("#<portlet:namespace/>filterStatoPagamento").val(),
		}
		
		var accordionContainer = "#<portlet:namespace/>accordionContainerPagamenti";
		
		var html = '';
		
		$.ajax({
			method: 'GET',
			url: '${getPagamentiUtenteResourceCommandUrl}',
			data: params,
			async: true,
			success: function(result, status, xhr){
				console.log("result: ", result);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				
				result = JSON.parse(result);

				if(Array.isArray(result.listaPagamenti) && result.listaPagamenti.length > 0){
					html = $.render.accordion({
						dataToRender:result.listaPagamenti, 
						templateName:"pagamento", 
						cur:result.cur,
						hasNext:result.hasNext,
						methodName:"getPagamentiUtente"
					});
				}else{
					html = $.render.alert({tipo: "secondary", message: "<liferay-ui:message key='nessun-risultato-da-visualizzare'/>"});
				}
			},
			error: function(xhr, status, error){
				console.log("error: ", error);
				console.log("status: ", status);
				console.log("xhr: ", xhr);
				html = $.render.alert({tipo: "secondary", message: "<liferay-ui:message key='nessun-risultato-da-visualizzare'/>"});
			},
			complete: function(xhr, status){
				$(accordionContainer).html(html);
			}
		});
	}
	
	function setSortTypeValue(fieldName, self){
		$("#<portlet:namespace/>"+fieldName).val(self.value);
	}

</script>

