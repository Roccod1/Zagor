<%@ include file="init.jsp" %>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<aui:form method="post" action="" modelAttribute="">
		<div class="row">
			<div class="col">
				<div class="form-group required">
					<aui:input type="text" name="nome" label="nome">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
			<div class="col">
				<div class="form-group required">
					<aui:input type="text" name="codiceServizio" label="codice-servizio">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="textarea" resizable="false" name="descrizione" label="descrizione">
						<aui:validator name="required"/>
					</aui:input>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:select type="text" name="areaTematica" label="area-tematica">
						<aui:validator name="required"/>
						<aui:option value="" selected="true" label="seleziona"/>
					</aui:select>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="textarea" resizable="false" name="descrizioneEstesa" label="descrizione-estesa"/>				
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="uriPrivata" label="uri-privata"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="uriPubblica" label="uri-pubblica"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group">
					<aui:input type="text" name="uriScheda" label="uri-scheda"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="autenticazione" label="autenticazione"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="attivo" label="attivo"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="date" name="dataInizioAttivazione" label="data-inizio-attivazione"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="cittadino" label="cittadino"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="azienda" label="azienda"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group">
					<aui:input type="date" name="dataFineAttivazione" label="data-fine-attivazione"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="delega" label="delega"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="allegatoDelegaObbligatorio" label="allegato-delega-obbligatorio"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="privacyDelegaAttivazione" label="privacy-servizio-delega"/>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="prenotabile" label="prenotabile"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="chatbot" label="chatbot"/>
				</div>
			</div>
			<div class="col">
				<div class="form-group form-check">
					<aui:input type="checkbox" name="gestibileDaBackoffice" label="gestibile-da-backoffice"/>
				</div>
			</div>
		</div>
	</aui:form>
</div>

<div class="container pl-0 pr-0 mb-4 mt-4">
	<table>
		<thead>
			<tr>
				<th></th>
				<th><liferay-ui:message key="nome"/></th>
			</tr>
		</thead>
		
		<tbody>
			<tr></tr>
		</tbody>
	</table>
</div>