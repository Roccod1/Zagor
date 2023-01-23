const CODICE_FISCALE_FIELD_ID = '#codiceFiscale';
var index = 0;

var addRow = function(namespace, getUserByCF) {

	var cf = $(CODICE_FISCALE_FIELD_ID).val();

	lockUI("<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '>Attendere...</div>");

	var cfParamKey = namespace + 'cf';
	var params = {};
	params[cfParamKey] = cf;

	$.ajax({
		method : 'GET',
		url : getUserByCF,
		data : params,
		async : true,
		success : function(result, status, xhr) {
			try {
				var user = JSON.parse(result);				
				buildRow(namespace, cf, user);
			} catch (e) {
				console.log(e);
				unlockUI();
			}
		},
		error : function(xhr, status, error) {
			console.log("error: ", error);
			console.log("status: ", status);
			console.log("xhr: ", xhr);
			// TODO error
		}
	}).always(function() {
		unlockUI();
	});

};

function buildRow(namespace, cf, user) {
	var inputName = namespace + 'codiceFiscale' + index;

	var newCfField = $('<input>').addClass('field form-control')//
	.attr('name', inputName).attr('value', cf).attr('readonly', true);

	var row = $('<tr>').append($('<td>').append(newCfField)).append(
			$('<td>').addClass('table-cell').html(user.nome)).append(
			$('<td>').addClass('table-cell').html(user.cognome)).append(
			$('<td>').addClass('table-cell text-center last').append(
					$('<a>').attr('onclick', 'deleteNewResponsabile()').append(
							$('<i>').addClass('icon-trash'))));

	row.insertBefore(".insert-row");

	var newRowsIndex = $('.new-rows-index');
	newRowsIndex.val(newRowsIndex.val() + index++ + ',');

	// reset field
	$(CODICE_FISCALE_FIELD_ID).val('');
}

var validCodiceFiscale = function(cf) {
	return true;
}

var deleteNewResponsabile = function() {
	var td = $(event.target).parent().parent();
	td.parent().remove();
}

var deleteResponsabile = function() {
	var td = $(event.target).parent().parent();
	var tr = td.parent();

	var cf = tr.find('.cf-cell').html();
	var responsabiliToDelete = $('.responsabili-to-delete');
	responsabiliToDelete.val(responsabiliToDelete.val() + cf + ',');

	tr.remove();
}

function lockUI(message) {
	$('body').block({
		message : message
	});
}

function unlockUI() {
	$('body').unblock();
}