(function($) {

	var Alpaca = $.alpaca;

	Alpaca.Fields.NonRipetibilitaServizioMultiminorePerAnnoScolasticoField = Alpaca.Fields.ObjectField
			.extend(
			/**
			 * @lends Alpaca.Fields.NonRipetibilitaServizioMultiminorePerAnnoScolasticoField.prototype
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
					return "nonRipetibilitaServizioMultiminorePerAnnoScolasticoField";
				},

				/**
				 * @see Alpaca.Fields.TextField#getTitle
				 */
				getTitle : function() {
					return "Non Ripetibilita Servizio per Anno Scolastico Field";
				},

				/**
				 * @see Alpaca.Fields.TextField#getDescription
				 */
				getDescription : function() {
					return "Custom Field per il controllo dell'unicità della domanda "
							+ "di iscrizione per l'anno scolastico corrente su servizi a singolo minore iscritto.";
				}

			});

	Alpaca.registerFieldClass("nonRipetibilitaServizioMultiminorePerAnnoScolasticoField",
			Alpaca.Fields.NonRipetibilitaServizioMultiminorePerAnnoScolasticoField);

})(jQuery);