<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@page import="it.servizidigitali.gestionecomunicazioni.model.Comunicazione"%>
<%@page import="it.servizidigitali.scrivaniacittadino.frontend.constants.ScrivaniaCittadinoPortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<script id="alertTemplate" type="text/x-jsrender">
	<div class="alert alert-{{>tipo}}" role="alert">
 		{{>message}}
 	</div>
</script>

<script type="text/javascript">
	var messages = {
			noResult:	"<liferay-ui:message key='nessun-risultato-da-visualizzare'/>"
	}
	
	//registro template
 	$.templates({			
			alert: "#alertTemplate"
		}
	);
	
	$.views.converters(
		{
			localDate: function(date){
// 				, hour: 'numeric', minute: 'numeric' 
				const options = { year: 'numeric', month: 'numeric', day: 'numeric'};
				var date = new Date(date);
				var formatted = date.toLocaleDateString(navigator.language, options);
				return formatted;			
			}
		}
	);

</script>