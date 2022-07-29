(function($) {

	var Alpaca = $.alpaca;

	Alpaca.Fields.VerificaRangeDateAperturaServizioField = Alpaca.Fields.ObjectField
			.extend(
			/**
			 * @lends Alpaca.Fields.VerificaRangeDateAperturaServizioField.prototype
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
					return "verificaRangeDateAperturaServizioField";
				},

				/**
				 * @see Alpaca.Fields.TextField#getTitle
				 */
				getTitle : function() {
					return "Verifica apertura del periodo di iscrizione al Servizio";
				},

				/**
				 * @see Alpaca.Fields.TextField#getDescription
				 */
				getDescription : function() {
					return "Custom Field per il controllo dell'apertura o meno del periodo"
							+ "di iscrizioni al Servizio scolastico";
				}

			});

	Alpaca.registerFieldClass("verificaRangeDateAperturaServizioField",
			Alpaca.Fields.VerificaRangeDateAperturaServizioField);

})(jQuery);