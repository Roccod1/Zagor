var index = 0;

var addRow = function(namespace) {

	var cfField = $('#codiceFiscale');
	var cf = cfField.val();

	if (validCodiceFiscale(cf)) {

		var newCfField = '<input class="field form-control" name="' + namespace
				+ 'codiceFiscale' + index + '" value="' + cf + '" readonly >';

		var row = $('<tr>')
				.append('<td class="table-cell first">' + newCfField)
				.append('<td class="table-cell">')
				.append('<td class="table-cell">')
				.append(
						'<td class="table-cell text-center last"><a><i class="icon-trash"></i></a>');

		row.insertBefore(".insert-row");

		var newRowsIndex = $('#' + namespace + 'newRowsIndex');
		newRowsIndex.val(newRowsIndex.val() + index++ + ',');

		// reset field
		cfField.val('');
	}
};

var validCodiceFiscale = function(cf) {
	return true;
}
