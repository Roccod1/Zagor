<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/init.jsp" %>

<!-- <div class="debug" style="border: 1px dashed gray;"> -->

<%-- 	<c:out value="${chatbotConfigurationModel}" /> --%>

<!-- </div> -->

<c:if test="${chatbotConfigurationModel.active}">
	<c:if test="${startFromServlet}">
		<script type="text/javascript" src="${servletUrl}/js/jquery-1.12.2.min.js"></script>
	</c:if>
	<base href="./">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script id="tiledesk-jssdk" src="${chatbotConfigurationModel.launchJsPath}"></script>
	<script type="application/javascript">
		var startFromHome = false;
		var messages = localStorage.getItem("tiledesk_widget_sv1_bot_conversation_messages");
		var startFromServlet = "${startFromServlet}";
		var isOpen = false;
		if (startFromServlet) {
			isOpen = true;
		}
		if (!messages || startFromServlet) {
			startFromHome = true;
		}
		console.log('startFromHome 1: ' + startFromHome);
		
		var agentId = "${chatbotConfigurationModel.agentId}";
		
		console.log('agentId: ' + agentId);
		
		var customAttributes = ${chatbotConfigurationModel.customAttributesString};
		console.log('customAttributes PRIMA: ', JSON.stringify(customAttributes));
		if (messages && agentId) {
			/* Verifica avvio chatbot da home in base ai messaggi appartenenti ad un dato chatbot userId */
			var messagesObject = JSON.parse(messages);
			console.log('MESSAGES PRIMA: ' + messagesObject + ', LENGTH: ' + messagesObject.length + ', agentId: ' + agentId);
			/* Filtro in base alla data di creazione e se maggiore di un giorno elimino i messaggi */
			messagesObject = messagesObject.filter(message => {
				
				var date = null;
				var timestamp = message.timestamp;
				if (timestamp) {
					try {
						date = new Date(timestamp);
					}
					catch (e) {
						date = Date.parsetimestamp(timestamp);
					}
				}
				
				console.log('CONDIZIONE MESSAGE: ' + (date != null && !isDateBeforeToday(date)));
				
				return (date != null && !isDateBeforeToday(date))
			});
			
			console.log('MESSAGES DOPO PRIMO FILTRO: ' + messagesObject + ', LENGTH: ' + messagesObject.length + ', agentId: ' + agentId);
			
			/* Eliminazione messaggi più vecchi di oggi da localstorage */
			localStorage.setItem("tiledesk_widget_sv1_bot_conversation_messages", JSON.stringify(messagesObject));
			
			/* Filtro in base all'Agent ID 
			messagesObject = messagesObject.filter(message => {
				return (message.agent === agentId || message.sender === agentId)
			});*/
			console.log('MESSAGES DOPO SECONDO FILTRO: ' + messagesObject + ', LENGTH: ' + messagesObject.length + ', agentId: ' + agentId);

			console.log('MESSAGES LENGTH: ' + messagesObject.length);
			
			
			var sendStartHiddenMessage = customAttributes.start_hidden_message != null;
			
			/* Setto variabile startFromHome se messagesObject (per agentID) è vuoto */
			if (messagesObject.length === 0){
	  			startFromHome = true;
			}
			else {
				var lastMessage = messagesObject[messagesObject.length-1];
				if (lastMessage.agent === agentId || lastMessage.sender === agentId) {
					sendStartHiddenMessage = false;
				}
			}
			console.log('sendStartHiddenMessage: ', sendStartHiddenMessage);
			
			if (!sendStartHiddenMessage) {
				customAttributes.start_hidden_message = '';
			}
			console.log('customAttributes DOPO: ', JSON.stringify(customAttributes));
			
			messages = JSON.stringify(messagesObject);
		}
		console.log('startFromHome 2: ' + startFromHome);
		
		var showPopup = ${chatbotConfigurationModel.showPopup};
		var popupClosedFirstTime = false;
		var chatbotCookieFirstTime = getCookie('chatbot-popup-cookie-first-time');
		if (chatbotCookieFirstTime != null) {
			popupClosedFirstTime = true;
		}
		
		window.tiledeskSettings = {
			    projectid: "${chatbotConfigurationModel.projectId}",
			    persistence: "local",
			    userId: "${chatbotConfigurationModel.userId}",
			    isLogEnabled: true,
			    logoChat: "${chatbotConfigurationModel.logoPath}",
			    welcomeTitle: "${chatbotConfigurationModel.welcomeTitle}",
			    welcomeMsg: "${chatbotConfigurationModel.welcomeMsg}",
			    calloutTitle: "${chatbotConfigurationModel.calloutTitle}",
			    calloutMsg: "${chatbotConfigurationModel.calloutMsg}",
			    allowTranscriptDownload: false,
			    widgetTitle: "${chatbotConfigurationModel.widgetTitle}",
			    poweredBy: "",
			    showLogoutOption: false,
			    startFromHome: startFromHome,
			    customAttributes: customAttributes,
			    marginX: "80px",
			    marginY: "20px",
			    hideAttachButton: true,
			    showMicButton: true,
			    showResetConversation: true,
			    isOpen: isOpen
			};
			(function(d, s, id) {
				var startFromHome = false;
			    var js, fjs = d.getElementsByTagName(s)[0];
			    if (d.getElementById(id)) return;
			    js = d.createElement(s);
			    js.id = id;
			    js.src = "${chatbotConfigurationModel.launchJsPath}";
			    fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'tiledesk-jssdk'));
	
			window.tileDeskAsyncInit = function() {
			    window.tiledesk.on('getImageUrlThumb', function(event_data) {
			        var message = event_data.detail.message;
			        if (message.sender === window.tiledeskSettings.customAttributes.agent) {
			            message.sender_urlImage = "${chatbotConfigurationModel.senderUrlImage}";
			        }
			    });
			    window.tiledesk.on('loadParams', function(event_data) {
			    	if (showPopup) {
				    	setTimeout(function() {
				        	var chatbotCookieFirstTime = getCookie('chatbot-popup-cookie-first-time');
				        	if (chatbotCookieFirstTime == null) {
			          			window.tiledesk.showCallout();
				        	}
				        }, 3000)
			        }
		      	});
			    if (showPopup) {
				    /* Set cookie per salvataggio variabile chiusura popup */
					window.tiledesk.on('onClosedEyeCatcher', function(event_data) {
						if (!popupClosedFirstTime){
							console.log('SET chatbot first time COOKIE');
							setCookie('chatbot-popup-cookie-first-time', 'POPUP-CLOSED', 1);
							popupClosedFirstTime = true;
						}
						else {
							console.log('SET chatbot second time COOKIE');
							setCookie('chatbot-popup-cookie-second-time', 'POPUP-CLOSED', 1);
						}
					});
			    }
			};
			
			/* Abilitazione popup dopo periodo di inattività */
			if (showPopup) {
				$('body').bind('mousemove click mouseup mousedown keydown keypress keyup submit change mouseenter scroll resize dblclick', isActiveEvent);
				
				var delay = ${chatbotConfigurationModel.popupIdleTimeout};
				var timer = null;
	
				function isActiveEvent(e) {
					if (timer) {
						clearTimeout(timer);
					}
					timer = setTimeout(function(t) {
						console.log('TIMEOUT INATTIVITA\' SCADUTO');
						var chatbotCookie = getCookie('chatbot-popup-cookie-second-time');
			        	if (chatbotCookie == null) {
					  		window.tiledesk.showCallout();
			        	}
					}, delay);
				};
			}
			
			function isDateBeforeToday(date) {
			    return new Date(date.toDateString()) < new Date(new Date().toDateString());
			}
			
			function localStorageSupported() {
				try {
  					return "localStorage" in window && window["localStorage"] !== null;
 				} 
				catch (e) {
					return false;
				}
			}
			
			$(function() {
		  		function manipIframe() {
			    	el = $('body', $('iframe').contents());
			    	if (el.length != 1) {
			      		setTimeout(manipIframe, 100);
			      		return;
			    	}
			   		$('#tiledeskiframe').contents().find("head").append($('<link rel="stylesheet" type="text/css" href="/o/it.servizidigitali.chatbot.frontend/css/iframe.css">'));
			  	}
			  	manipIframe();
			});
			
			
			var chatbotWidgetInitialized = false;
			Liferay.Portlet.ready(function(portletId, node) {
				var portletNamespace = '<portlet:namespace/>';
				var thisPortletId = '<%= PortalUtil.getPortletId(renderRequest)%>';
				if(portletId === thisPortletId && !chatbotWidgetInitialized) {
					setTimeout(function() {					
						initWidget();
					}, 1000); 
					chatbotWidgetInitialized=true;
				}
				console.log('Portlet namespace', '<portlet:namespace/>');
				console.log('Portlet id and node', portletId, node);
			});
			
	</script>
</c:if>


