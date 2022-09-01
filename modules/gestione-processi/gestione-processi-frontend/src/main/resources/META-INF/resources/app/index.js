var fs = require('fs');

var camundaExtensionModule = require('camunda-bpmn-moddle/lib');
// var camundaModdle = require('camunda-bpmn-moddle/resources/camunda');

var camundaModdleDescriptorsRaw = fs.readFileSync(__dirname + '/../dist/camunda.json', 'utf-8');
var camundaModdleDescriptors = JSON.parse(camundaModdleDescriptorsRaw);

console.log('camundaExtensionModule', camundaExtensionModule);

var modeler = new BpmnJS({
        container: "#canvas",
        propertiesPanel: {
		    parent: '#js-properties-panel'
		  },
        additionalModules: [
			BpmnJSPropertiesPanel.BpmnPropertiesPanelModule,
			BpmnJSPropertiesPanel.BpmnPropertiesProviderModule,
			BpmnJSPropertiesPanel.CamundaPlatformPropertiesProviderModule
		],
		  moddleExtensions: {
	      camunda: camundaModdleDescriptors
	    }
      });

	  var diagram = fs.readFileSync(__dirname + '/../bpmn/newDiagram.bpmn', 'utf-8');
      var eventBus = modeler.get("eventBus");

      if(inputText.val()){
    	  
    	  modeler.importXML(inputText.val(), (err, warnings) => {
    		  if (err) {
    		      console.log("errore caricamento xml esistente");
    		  } else {
    		    	console.log("caricamento xml esistente avvenuto correttamente");
    		  }
    	  });
    	  
//    	  modeler.importXML(inputText.val(), function(err) {
//
//    		    if (err) {
//    		      console.log("errore caricamento xml esistente");
//    		    } else {
//    		    	console.log("caricamento xml esistente avvenuto correttamente");
//    		    }
//
//
//    		  });
      }else{
    	  
    	  modeler.importXML(diagram, (err, warnings) => {
    		  if (err) {
    		      console.log("errore caricamento xml esistente");
    		  } else {
    		    	console.log("caricamento xml esistente avvenuto correttamente");
    		  }
    	  });
    	  
//    	  modeler.importXML(diagram, function(err) {
//
//  		    if (err) {
//  		      console.log("errore caricamento xml vuoto");
//  		    } else {
//  		    	console.log("caricamento xml vuoto avvenuto correttamente");
//  		    }
//
//
//  		  });
      }
      
      eventBus.on("commandStack.changed", function(event) {
    	  modeler.saveXML({ format: true }, function(err, xml) {
    		    if(err){
    		    	console.log("errore durante il salvataggio dell'xml");
    		    }else{
    		    	console.log("Salvataggio dell'xml avvenuto correttamente!");
    		    	inputText.val(xml);
    		    }
    		  });
        });