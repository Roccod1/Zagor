(function($) {

	var Alpaca = $.alpaca;

	Alpaca.Fields.VerificaPresenzaMinoriIscrivibiliServizioField = Alpaca.Fields.ObjectField
			.extend(
			/**
			 * @lends Alpaca.Fields.VerificaPresenzaMinoriIscrivibiliServizioField.prototype
			 */
			{
				/**
				 * @see Alpaca.Fields.TextField#setup
				 */
				setup : function() {
					this.base();
					this.options.validate = false;

					this.schema = {
						"title" : "",
						"description" : "",
						"type" : "object",
						"required" : false
					};

					Alpaca
							.merge(
									this.options,
									{
										"focus": false,
						                "validate": true,
						                "disabled": false,
						                "showMessages": true,
						                "collapsible": false,
						                "legendStyle": "button",
						                "label": "",
										"helpers" : [],
										"fieldClass" : "noBorderContainers",
										"hidden" : true,
										"order" : 100,
										"fields" : {}
									});
				},

				/**
				 * @see Alpaca.Fields.TextField#getFieldType
				 */
				getFieldType : function() {
					return "verificaPresenzaMinoriIscrivibiliServizioField";
				},

				/**
				 * @see Alpaca.Fields.TextField#getTitle
				 */
				getTitle : function() {
					return "Verifica presenza di minori iscrivibili al Servizio";
				},

				/**
				 * @see Alpaca.Fields.TextField#getDescription
				 */
				getDescription : function() {
					return "Custom Field per il controllo dell'esistenza nel proprio nucleo famigliare"
							+ "di minori iscrivibili al Servizio scolastico";
				}

			});

	Alpaca.registerFieldClass("verificaPresenzaMinoriIscrivibiliServizioField",
			Alpaca.Fields.VerificaPresenzaMinoriIscrivibiliServizioField);

})(jQuery);