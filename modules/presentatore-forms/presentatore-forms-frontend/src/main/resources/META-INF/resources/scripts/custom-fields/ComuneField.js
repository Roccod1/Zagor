(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.ComuneField = Alpaca.Fields.SelectField.extend(
    /**
     * @lends Alpaca.Fields.SelectField.prototype
     */
    { 	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "comune";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Comune field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Comune Field.";
        }
        
    });

    Alpaca.registerFieldClass("comune", Alpaca.Fields.ComuneField);

})(jQuery);