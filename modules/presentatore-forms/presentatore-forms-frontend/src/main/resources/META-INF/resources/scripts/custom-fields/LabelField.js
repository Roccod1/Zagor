(function($) {

    var Alpaca = $.alpaca;

    Alpaca.Fields.LabelField = Alpaca.Fields.TextField.extend(
    /**
     * @lends Alpaca.Fields.LabelField.prototype
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
            return "label";
        },
        
        /**
         * @see Alpaca.Fields.TextField#postRender
         */
        afterRenderControl: function(model, callback) {

            var self = this;

            var field = this.getControlEl();

            this.base(model, function() {
            	//$(field).parent().find( "label" ).css( "color", "red" );
                $(field).remove();

                callback();

            });
        },

        /**
         * @see Alpaca.Fields.TextField#getTitle
         */
        getTitle: function() {
            return "Label Field";
        },

        /**
         * @see Alpaca.Fields.TextField#getDescription
         */
        getDescription: function() {
            return "Label Field.";
        }
        
    });

    Alpaca.registerFieldClass("label", Alpaca.Fields.LabelField);

})(jQuery);