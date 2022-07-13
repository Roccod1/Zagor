(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.UrlDocumentoField = Alpaca.Fields.URLField.extend(
    /**
     * @lends Alpaca.Fields.UrlDocumentoField.prototype
     */
    {
    	/**
         * @see Alpaca.Fields.TextField#setup
         */
    	setup: function() {
    		this.base();
    		this.options.validate = false;
    	},
    	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "urldocumentofield";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "URL Documento Field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "URL Documento Field.";
        }
        
    });

    Alpaca.registerFieldClass("urldocumentofield", Alpaca.Fields.UrlDocumentoField);

})(jQuery);