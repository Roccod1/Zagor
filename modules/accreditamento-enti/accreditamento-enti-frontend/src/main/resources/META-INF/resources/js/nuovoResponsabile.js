var index = 0;

var addRow = function(namespace) {

	var cfField = $('#codiceFiscale');
	var cf = cfField.val();

	if (validCodiceFiscale(cf)) {

		var inputName = namespace + 'codiceFiscale' + index;

		var newCfField = $('<input>').addClass('field form-control')//
		.attr('name', inputName).attr('value', cf).attr('readonly', true);

		var row = $('<tr>').append($('<td>').append(newCfField)).append(
				$('<td>').addClass('table-cell')).append(
				$('<td>').addClass('table-cell')).append(
				$('<td>').addClass('table-cell text-center last').append(
						$('<a>').attr('onclick', 'deleteNewResponsabile()')
								.append($('<i>').addClass('icon-trash'))));

		row.insertBefore(".insert-row");

		var newRowsIndex = $('.new-rows-index');
		newRowsIndex.val(newRowsIndex.val() + index++ + ',');

		// reset field
		cfField.val('');
	}
};

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