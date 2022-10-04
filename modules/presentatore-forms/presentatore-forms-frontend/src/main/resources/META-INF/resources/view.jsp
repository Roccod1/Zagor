<script>

$.blockUI({ 
		message: "<div style='padding:20px 0; color: #ae1d3f; background-color: #FFF '> Attendere...</div>",
    	baseZ:2000,
     	css: { 
            border: 'none', 
            fontFamily: "'Titillium Web',sans-serif",
            opacity: .7, 
            color: '#ae1d3f',
        } 
  	});	
  	
$(document).ready(function() {
	$.unblockUI();
});

</script>