// var fs = require('fs');

var modeler = new BpmnJS({
        container: "#canvas"
      });

	  var diagram = `__DIAGRAM_XML__`;  /*fs.readFileSync(__dirname + '/../bpmn/newDiagram.bpmn', 'utf-8');*/
      var eventBus = modeler.get("eventBus");

      if(inputText.val()){
    	  modeler.importXML(inputText.val(), function(err) {

    		    if (err) {
    		      console.log("errore caricamento xml esistente");
    		    } else {
    		    	console.log("caricamento xml esistente avvenuto correttamente");
    		    }


    		  });
      }else{
    	  modeler.importXML(diagram, function(err) {

  		    if (err) {
  		      console.log("errore caricamento xml vuoto");
  		    } else {
  		    	console.log("caricamento xml vuoto avvenuto correttamente");
  		    }


  		  });
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