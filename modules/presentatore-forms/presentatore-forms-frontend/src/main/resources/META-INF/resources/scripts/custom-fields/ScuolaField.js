(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.ScuolaField = Alpaca.Fields.SelectField.extend(
    /**
     * @lends Alpaca.Fields.SelectField.prototype
     */
    {
        /**
         * @see Alpaca.Fields.TextField#getFieldType
         */
        getFieldType: function() {
            return "scuola";
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Scuola field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Scuola Field.";
        }
        
    });

    Alpaca.registerFieldClass("scuola", Alpaca.Fields.ScuolaField);

})(jQuery);