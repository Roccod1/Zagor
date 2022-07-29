(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.ProvinciaField = Alpaca.Fields.SelectField.extend(
    /**
     * @lends Alpaca.Fields.SelectField.prototype
     */
    {    	
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "provincia";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Provincia field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Provincia Field.";
        }
        
    });

    Alpaca.registerFieldClass("provincia", Alpaca.Fields.ProvinciaField);

})(jQuery);