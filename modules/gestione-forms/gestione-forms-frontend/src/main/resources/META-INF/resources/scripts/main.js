var setup = function(s, o, v, d)
 {
    //Alpaca.logLevel = Alpaca.DEBUG;

    var MODAL_VIEW = "bootstrap-edit-horizontal";
    //var MODAL_VIEW = "bootstrap-edit";

    var schema = typeof s !== 'undefined' ? s : {};
	var options = typeof o !== 'undefined' ? o : {};
    var view = typeof v !== 'undefined' ? v : {};
	var data = typeof d !== 'undefined' ? d : {};

	var _currentStep =  0;
	 
    
    var setupEditor = function(id, json){
        var text = "";
        if (json)
        {
            text = JSON.stringify(json, null, "    ");
        }

        var editor = ace.edit(id);
        editor.setTheme("ace/theme/textmate");
        if (json)
        {
            editor.getSession().setMode("ace/mode/json");
        }
        else
        {
            editor.getSession().setMode("ace/mode/javascript");
        }
        editor.renderer.setHScrollBarAlwaysVisible(false);
        editor.setShowPrintMargin(false);
        editor.setValue(text);

        setTimeout(function() {
            editor.clearSelection();
            editor.gotoLine(0,0);
        }, 100);

        return editor;
    };
    
    /**
     * Set the modello form value.
     * @param value The value to set.
     */
    var setModelloForm = function(value){
        modelloForm.val(JSON.stringify(value, null, "    "));
    };
    
    //If modelloForm has a value, use it
    var modelloFormVal = modelloForm.val();
    if(modelloFormVal){
    	try {
    		modelloFormVal = JSON.parse(modelloFormVal);
    		schema = modelloFormVal.schema;
    		options = modelloFormVal.options;
    		if(modelloFormVal.view){
    			view = modelloFormVal.view;
    		}
    		data = modelloFormVal.data;
        } catch(e) {
            console.log('Exception parsing modelloForm', e);
        }
    }

    var editor1 = setupEditor("schema", schema);
    var editor2 = setupEditor("options", options);
    var editor3 = setupEditor("data", data);
    var editor4 = setupEditor("codeDiv");
    var editor5 = setupEditor("source-view", view);
    setModelloForm({schema: schema, options: options, data: data, view: view});

    var mainViewField = null;
    var mainPreviewField = null;
    var mainDesignerField = null;

    var doRefresh = function(el, buildInteractionLayers, disableErrorHandling, cb)
    {
        try
        {
            schema = JSON.parse(editor1.getValue());
        }
        catch (e)
        {
        }

        try
        {
            options = JSON.parse(editor2.getValue());
        }
        catch (e)
        {
        }

        try
        {
            data = JSON.parse(editor3.getValue());
        }
        catch (e)
        {
        }
        
        try
        {
            view = JSON.parse(editor5.getValue());
        }
        catch (e)
        {
        }
        
        setModelloForm({schema: schema, options: options, data: data, view: view});
  
        if (schema)
        {
            var config = {
                "schema": schema
            };
            if (options)
            {
                config.options = options;
            }
            if (data)
            {
                config.data = data;
            }
            if (view)
            {
                config.view = view;
            }
            if (!config.options) {
                config.options = {};
            }
            config.options.focus = false;
			
            /* START FD EDIT */
			config.setupCustomWizard = function(form) {
				/*var nextBtn = $('button[data-alpaca-wizard-button-key="next"]');
				var prevBtn = $('button[data-alpaca-wizard-button-key="previous"]');
                var submitBtn = $('button[data-alpaca-wizard-button-key="submit"]');
                if (typeof form.view.wizard !== 'undefined' && form.view.wizard != null) {
                    if (form.view.wizard.hideSubmitButton) {
                        submitBtn.hide();
                    }
                }*/
			};
			/* END FD EDIT */
			
            config.postRender = function(form) {
				
				/* START FD EDIT */				
				if (typeof config.setupCustomWizard === 'function') {
					config.setupCustomWizard(form);
				}
				/* END FD EDIT */

                if (buildInteractionLayers)
                {
                    // cover every control with an interaction layer
                    form.getFieldEl().find(".alpaca-container-item").each(function(iCount) {

                        var $el = $(this);
                        var alpacaFieldId = $el.children().first().attr("data-alpaca-field-id");
                        var isCustomField = $el.children().first().attr("data-custom-field");

                        //iCount++;
                        $el.attr("icount", iCount);
						
						/* START FD EDIT */
						$($el).css({
							"position": "relative"
						});
						
						var firstNotVisibleChild = null;
						if (!$el.is(':visible')) {
							var closestVisibleParent = $el.closest(':visible');
							firstNotVisibleChild = closestVisibleParent.find('[data-alpaca-wizard-role="step"]:not(:visible)');
							if (firstNotVisibleChild.attr('data-alpaca-wizard-role') == 'step') {
								firstNotVisibleChild.show();
							}
						}
						
						var item = $el.find('.alpaca-field[data-alpaca-field-name]');
						var fieldProps = null;
						if (item.length > 0) {
							var name = item.attr('data-alpaca-field-name');
							fieldProps = getObjectProperty(options.fields, name);
						}
						// apply css style to parent
						if (fieldProps != null) {
							$el.addClass(fieldProps.fieldClass);
							item.removeClass(fieldProps.fieldClass);
						}
						/* END FD EDIT */
                        
                        var width = $el.outerWidth() - 22;
                        var height = $el.outerHeight() + 25;
                        
                        var editable = true;
                        if(isCustomField) {
                        	height = parseInt($el.children().first().attr("data-custom-field-height"));
                        	editable = false;
                        }
                        
                        var disableInteractionCustomField = $el.attr("data-disable-interaction-custom-field");
                        if(!disableInteractionCustomField) {
                        	// cover div
                        	var cover = $("<div></div>");
                        	$(cover).addClass("cover");
                        	$(cover).attr("alpaca-ref-id", alpacaFieldId);
                        	$(cover).attr("icount-ref", iCount);
                        	$el.append(cover);
                        
	                        // interaction div
	                        var interaction = $("<div class='interaction'></div>");
	                        var buttonGroup = $("<div class='btn-group pull-right'></div>");
	                        
	                        //var schemaButton = $("<button class='btn button-schema' alpaca-ref-id='" + alpacaFieldId + "'>Schema</button>");
	                        var schemaButton = $('<button class="btn btn-default btn-xs button-schema" alpaca-ref-id="' + alpacaFieldId + '"><i class="glyphicon glyphicon-list"></i></button>');
	                        //var optionsButton = $("<button class='btn button-options' alpaca-ref-id='" + alpacaFieldId + "'>Options</button>");
	                        var optionsButton = $('<button class="btn btn-default btn-xs button-options" alpaca-ref-id="' + alpacaFieldId + '"><i class="glyphicon glyphicon-wrench"></i></button>');
	                        
	                        if(editable) {
	                        	buttonGroup.append(schemaButton);
	                        	buttonGroup.append(optionsButton);
	                        }
	                        //var removeButton = $("<button class='btn btn-danger button-remove' alpaca-ref-id='" + alpacaFieldId + "'>Delete</button>");
	                        var removeButton = $('<button class="btn btn-danger btn-xs button-remove" alpaca-ref-id="' + alpacaFieldId + '"><i class="glyphicon glyphicon-remove"></i></button>');
	                        buttonGroup.append(removeButton);
	                        interaction.append(buttonGroup);
	                        interaction.append("<div style='clear:both'></div>");
	                        $(interaction).addClass("interaction");
	                        $(interaction).attr("alpaca-ref-id", alpacaFieldId);
							
                        	$(cover).css({
                        		"position": "absolute",
                        		//"margin-top": "-" + height + "px",
                        		"margin-left": "-10px",
								"right": 0,
								"bottom": "0px", 
                        		"width": "100%",
                        		"height": "100%",
                        		"opacity": 0,
                        		"background-color": "white",
                        		"z-index": 900
                        	});
	                        $(interaction).css({
	                            "position": "absolute",
	                            //"margin-top": "-" + height + "px",
	                            "margin-left": "-10px",
								"right": 0,
								"bottom": "0px", 
	                            "width": "100%",
	                            "height": "100%", //height + 10,
	                            "opacity": 1,
	                            "z-index": 901
	                        });
							
	                        $(interaction).attr("icount-ref", iCount);
	                        $el.append(interaction);
	                        $(buttonGroup).css({
								//"margin-top": (($(interaction).height() / 2) - ($(buttonGroup).height() / 2)) + "px",
								//"margin-top": ($(buttonGroup).height() / 2) + "px",
	                            "margin-right": "16px",
                        		"position": "absolute",
								//"height": "100%",
								"right": 0,
								"top": "50%",
								"transform": "translateY(-50%)",
								//"bottom": "40px"
	                        });
							$(buttonGroup).addClass("enable-pointer-events");
							
	                        $(schemaButton).off().click(function(e) {
	
	                            e.preventDefault();
	                            e.stopPropagation();
	
	                            var alpacaId = $(this).attr("alpaca-ref-id");
	
	                            editSchema(alpacaId);
	                        });
							
							// HOLD this code for now: check if the field has an option: preliminary support for field-sets
							/*if ( hasOptions($(optionsButton).attr("alpaca-ref-id")) ) {
								$(optionsButton).off().click(function(e) {
									e.preventDefault();
									e.stopPropagation();
		
									var alpacaId = $(this).attr("alpaca-ref-id");
									editOptions(alpacaId);
								});
							} else {
								$(interaction).addClass("disable-pointer-events");
								$(optionsButton).prop('disabled', true);
								$(optionsButton).off();
							}*/
							$(optionsButton).off().click(function(e) {
								e.preventDefault();
								e.stopPropagation();
	
								var alpacaId = $(this).attr("alpaca-ref-id");
								editOptions(alpacaId);
							});

	                        $(removeButton).off().click(function(e) {
	                            e.preventDefault();
	                            e.stopPropagation();
	
	                            var alpacaId = $(this).attr("alpaca-ref-id");
	                            removeField(alpacaId);
	                        });
	
	                        // when hover, highlight
	                        $(interaction).hover(function(e) {
	                            var iCount = $(interaction).attr("icount-ref");
	                            $(".cover[icount-ref='" + iCount + "']").addClass("ui-hover-state");
	                        }, function(e) {
	                            var iCount = $(interaction).attr("icount-ref");
	                            $(".cover[icount-ref='" + iCount + "']").removeClass("ui-hover-state");
	                        });
                        
                        }
						
						/* START FD EDIT */
						if (firstNotVisibleChild != null) {
							firstNotVisibleChild.hide();
						}
						/* END FD EDIT */
                    });

                    // add dashed
                    form.getFieldEl().find(".alpaca-container").addClass("dashed");
                    form.getFieldEl().find(".alpaca-container-item").addClass("dashed");

                    // for every container, add a "first" drop zone element
                    // this covers empty containers as well as 0th index insertions
                    
                    if(form.view.layout && form.view.layout.template){
                    	// Find all the empty layout zones
                        var viewLayoutTemplate = "<div>" + form.view.layout.template + "</div>";
                        var viewLayoutTemplateIds = $(viewLayoutTemplate)
                        	.find("[id]") // find html tags with ID attribute
    		                .map(function() { return this.id; }) // convert to set of IDs
    		                .get(); // convert to instance of Array (optional)
                        
                        $.each(viewLayoutTemplateIds, function(index, viewLayoutTemplateId){
                        	form.getFieldEl().find("#" + viewLayoutTemplateId).each(function(){
                        		var containerEl = this;
                        		//console.log('layoutID',viewLayoutTemplateId)
                        		// If empty add a dropzone
                        		if($(containerEl).children().length === 0){
                        			$(this).prepend("<div class='dropzone'></div>");
                        		}
                        	});
                        });
                    }
					
					/* START FD EDIT */
					var wizardStepsLength = form.getFieldEl().find(".alpaca-wizard-nav:visible ul.nav li").length;
					var wizardStepsContainersLength = $('.alpaca-wizard-steps:visible').find('[data-alpaca-wizard-role="step"]').length;
					var wzDiffLength = wizardStepsLength - wizardStepsContainersLength;
					if (wzDiffLength > 0) {
						for (var i = 0; i < wzDiffLength; i++) {
							$('.alpaca-wizard-steps').append(
								'<div data-alpaca-wizard-role="step">' +
								'</div>'
							);
						}
					}
					/* END FD EDIT */
					
                    form.getFieldEl().find(".alpaca-container, .alpaca-layout-binding-holder").each(function() {
                        var containerEl = this;
                        
                        //var customField = $el.attr("data-custom-field");
                        //console.log(':first-child', $(containerEl), $(containerEl).is(':first-child'));

                        if($(containerEl).is(':first-child')){
                        	// first insertion point
                            $(containerEl).prepend("<div class='dropzone'></div>");
                        }

                        // all others
                        $(containerEl).children(".alpaca-container-item").each(function() {
                        	var disableInteractionCustomField = $(this).attr("data-disable-interaction-custom-field");
                            if(!disableInteractionCustomField) {
								if ($(this).css('float') == 'left' && $(this).next().css('float') == 'left') {
									// not handled yet
								} else {
									$(this).after("<div class='dropzone'></div>");    
								}             	
                            }
                        });
                    });
                    
                    form.getFieldEl().find(".alpaca-container-item").each(function() {
                        var containerEl = this;
                        $(containerEl).children(".alpaca-container-item").each(function() {
                        	var disableInteractionCustomField = $(this).attr("data-disable-interaction-custom-field");
                            if(!disableInteractionCustomField) {
                            	$(this).after("<div class='dropzone'></div>");                            	
                            }
                        });
                    });
					
					//BEGIN WIZARD GS 
					 form.getFieldEl().find(".alpaca-wizard-steps").each(function(i) {
                        var containerEl = this;
                        $(containerEl).children('[data-alpaca-wizard-role]').prepend("<div class='dropzone'></div>");
                        $(containerEl).find('.alpaca-container-item').each(function(i) {
                            var disableInteractionCustomField = $(this).attr("data-disable-interaction-custom-field");
                            if(!disableInteractionCustomField) {
								if ($(this).css('float') == 'left' && $(this).next().css('float') == 'left') {
									// not handled yet
								} else {
									$(this).after("<div class='dropzone'></div>");    
								}                        	
                            } 
                        });
                    });
					//END WIZARD GS  
					
					
                    // for every zone-layout append a drop zone element
                    form.getFieldEl().find(".zone-layout").each(function() {
                    	var containerEl = this;
                    	var layoutPosition = $(containerEl).attr('id');
                    	
						if($(containerEl).children().length === 0){
							$(this).prepend("<div class='dropzone'></div>"); //data-layout-position='#"+layoutPosition+"'
							
							$(containerEl).children(".alpaca-layout-binding-holder").each(function() {
								$(this).after("<div class='dropzone'></div>"); //data-layout-position='#"+layoutPosition+"'
							});
						}
                    });

                    form.getFieldEl().find(".dropzone").droppable({
                        "tolerance": "pointer",
                        "drop": function( event, ui ) {
                            var draggable = $(ui.draggable);

                            if (draggable.hasClass("form-element")) {
                            	if($(event.target).attr("data-layout-position")) {
                            		var dataType = draggable.attr("data-type");
                                    var fieldType = draggable.attr("data-field-type");
                                    var destination = $(event.target).attr("data-layout-position");
                                    
                                    // previous
                                    var prevField = $(event.target).prev();
                            		var prevFieldName = $(prevField).attr("alpaca-layout-binding-field-name");
                            		
                                    // parent field
                                    var parentFieldAlpacaId = $(event.target).parent().parent().parent().attr("data-alpaca-field-id");
                                    var parentField = Alpaca.fieldInstances[parentFieldAlpacaId];

                                    // now do the insertion
                                    var itemKey = insertFieldinLayout(schema, options, data, dataType, fieldType, parentField, destination);

                                    //remove layout
//                                    var _string_opt_editor2 = editor2.getValue();
//                                    var _obj_opt_editor2 = JSON.parse(_string_opt_editor2);
//                                    _obj_opt_editor2.view = {};
//                                    editor2.setValue(JSON.stringify(_obj_opt_editor2, null, "    "));
//                                    editor2.clearSelection();
//                                    
//                                    setTimeout(function() {
//                                        refreshDesigner();
//                                    }, 50);

//                                    // now do the insertion
//                                    options.view= {};
//                                    insertField(schema, options, data, dataType, fieldType, parentField);
                            	} else {
                            		var dataType = draggable.attr("data-type");
                                    var fieldType = draggable.attr("data-field-type");

                                    // based on where the drop occurred, figure out the previous and next Alpaca fields surrounding
                                    // the drop target

                                    // previous
                                    var previousField = null;
                                    var previousFieldKey = null;
                                    var previousItemContainer = $(event.target).prev();
                                    if (previousItemContainer)
                                    {
                                        var previousAlpacaId = $(previousItemContainer).children().first().attr("data-alpaca-field-id");
                                        previousField = Alpaca.fieldInstances[previousAlpacaId];

                                        previousFieldKey = $(previousItemContainer).attr("data-alpaca-container-item-name");
                                    }

                                    // next
                                    var nextField = null;
                                    var nextFieldKey = null;
                                    var nextItemContainer = $(event.target).next();
                                    if (nextItemContainer)
                                    {
                                        var nextAlpacaId = $(nextItemContainer).children().first().attr("data-alpaca-field-id");
                                        nextField = Alpaca.fieldInstances[nextAlpacaId];

                                        nextFieldKey = $(nextItemContainer).attr("data-alpaca-container-item-name");
                                    }

                                    // parent field
                                    //var parentFieldAlpacaId = $(event.target).parent().parent().attr("data-alpaca-field-id");
                                    //console.log('$(event.target).parents("[data-alpaca-field-id]")', $(event.target).parents("[data-alpaca-field-id]"), $(event.target).parents("[data-alpaca-field-id]").attr("data-alpaca-field-id"));
                                    var parentFieldAlpacaId = $(event.target).parents("[data-alpaca-field-id]").attr("data-alpaca-field-id");
                                    var parentField = Alpaca.fieldInstances[parentFieldAlpacaId];
                                    
                                    var $self = $(this);

                                    // now do the insertion
									
									var itemKey = "new" + new Date().getTime();
									editFieldName(event,itemKey,function(alpacaFieldId, alpacaTemplateId){
										insertField(schema, options, data, dataType, fieldType, parentField, previousField, previousFieldKey, nextField, nextFieldKey, $self.parent(), alpacaFieldId, alpacaTemplateId);
									});
                                    
                            	}
                            } else if (draggable.hasClass("interaction")) {
                            	if($(event.target).attr("data-layout-position")) {
                            		var destination = $(event.target).attr("data-layout-position");
                            		var alpacaFieldId = draggable.attr("alpaca-ref-id");
                            		var field = Alpaca.fieldInstances[alpacaFieldId];
                            		var draggedField = field.propertyId;
                            		
                            		// update option object
                            		var _string_opt_editor2 = editor2.getValue();
                                    var _obj_opt_editor2 = JSON.parse(_string_opt_editor2);
                                    setProperty(_obj_opt_editor2,'view.layout.bindings',draggedField,destination);
                                    editor2.setValue(JSON.stringify(_obj_opt_editor2, null, "    "));
                                    editor2.clearSelection();
                                    
                                    // ordering schema object
                            		var nextField = $(event.target).next();
                            		var nextFieldName = $(nextField).attr("alpaca-layout-binding-field-name");

                            		var prevField = $(event.target).prev();
                            		var prevFieldName = $(prevField).attr("alpaca-layout-binding-field-name");
                            		
                            		var _string_sch_editor1 = editor1.getValue();
                                    var _obj_sch_editor1 = JSON.parse(_string_sch_editor1);
                                    var _obj_sch_properties = {};
                                    if(!$.isEmptyObject(_obj_sch_editor1.properties)) {

                                    	for (var key in _obj_sch_editor1.properties) {
                                    		
                                    		if(key==draggedField && (!nextFieldName || !prevFieldName)) {
                                    			_obj_sch_properties[key] = _obj_sch_editor1.properties[key];                                    			
                                    		} 
                                    		else if(key==draggedField) {
                                    			continue;                                 			
                                    		}
                                    		else if(key==nextFieldName) {
                                    			_obj_sch_properties[draggedField] = _obj_sch_editor1.properties[draggedField];
                                    			_obj_sch_properties[key] = _obj_sch_editor1.properties[key];                                    			
                                    		}
                                    		else {
                                    			_obj_sch_properties[key] = _obj_sch_editor1.properties[key];                                    			
                                    		}
                                    	}
                                    	_obj_sch_editor1.properties = _obj_sch_properties;
                                    }
                                    
                                    editor1.setValue(JSON.stringify(_obj_sch_editor1, null, "    "));
                                    editor1.clearSelection();
                                    
                                    setTimeout(function() {
                                        refreshDesigner();
                                    }, 50);
                            	} else {
                            		var draggedIndex = $(draggable).attr("icount-ref");
									var column = null;
                            		
                            		var noNextPrev = false;
                            		/*
									var prevField = $(event.target).prev();
									var prevFieldName = prevField.data('alpacaContainerItemName')
									*/
                            		// next
                            		var nextItemContainer = $(event.target).next();
                            		var prevItemContainer = $(event.target).prev();
									
									/* START FD EDIT */
    								if (nextItemContainer.length <= 0) {
    									nextItemContainer = prevItemContainer;
    								}
                            		/* END FD EDIT */
									
                            		// Layout case
                            		if(nextItemContainer.length === 0){
                            			// Carichiamo il next item container in un altro modo
                            			nextItemContainer = $(event.target).parent().next().find('[data-alpaca-container-item-index]');
                            			
                            			// If next item is still empty
                            			if(nextItemContainer.length === 0){
                            				
                            				// Check if a prev exists
                            				if(prevItemContainer.length > 0){
                            					nextItemContainer = prevItemContainer.parent().find('[data-alpaca-container-item-index]');
                                			} else {
                                				// Otherwise put it directly in the container
                                				noNextPrev = true;
                                				
                                				column = $(event.target).parent().attr("id"); //Retrieving column id
                                				nextItemContainer = $(draggable).parent(); //The same item we are moving
                                			}
                            			}
                            		}

                        			var nextItemContainerIndex = $(nextItemContainer).attr("data-alpaca-container-item-index");
                            		var nextItemAlpacaId = $(nextItemContainer).children().first().attr("data-alpaca-field-id");
                            		var nextField = Alpaca.fieldInstances[nextItemAlpacaId];
									
									//var prevItemContainerIndex = $(draggable).parent();
                            		var prevItemAlpacaId = $(draggable).attr("alpaca-ref-id");
                            		var prevField = Alpaca.fieldInstances[prevItemAlpacaId];
                            		
                            		// No next/prev case
                            		if(!noNextPrev && view && view.layout && view.layout.bindings){
                            			var insertAfterName = nextField.name;
                                		if(view.layout.bindings[insertAfterName]){
                                    		column = view.layout.bindings[insertAfterName];
                                    	}
                            		}
									
									nextItemContainerIndex = parseInt(nextItemContainerIndex);
									draggedIndex = parseInt(draggedIndex);
									//console.log('moveItem', form);
                            		
									/*TODO: FD mofificare moveItem per supportare strutture tree oltre che flat */
									form.moveItem(draggedIndex, nextItemContainerIndex, false, function() {
                            		//moveItemA(form, draggedIndex, nextItemContainerIndex, false, function() {
                            			var top = findTop(nextField);
                                		
                            			if(view && view.layout && view.layout.bindings && column){
	                                    	setProperty(view, 'layout.bindings', $(draggable).parent().attr('data-alpaca-container-item-name'), column);
	                                    	view.id = "view-" + new Date().getTime(); // Force regeneration of the view id
                            			}
										
										if(top.wizardConfigs){
											var nextPos = top.options.fields[nextField.name].order;
											//console.log('next',nextField.name)
											var prevPos =  top.options.fields[prevField.name].order;
											//console.log('prev',prevField.name);
											 
											top.options.fields[nextField.name].order = prevPos;
											top.options.fields[prevField.name].order = nextPos;
										}
                                    	
                            			regenerate(top, view);
                            		});
                            	}
                            	
                            }
                        },
                        "over": function (event, ui ) {
                            $(event.target).addClass("dropzone-hover");
                        },
                        "out": function (event, ui) {
                            $(event.target).removeClass("dropzone-hover");
                        }
                    });

                    // init any in-place draggables
                    form.getFieldEl().find(".interaction").draggable({
                        "appendTo": "body",
                        "helper": function() {
                            var iCount = $(this).attr("icount-ref");
                            var clone = $(".alpaca-container-item[icount='" + iCount + "']").clone();
                            return clone;
                        },
                        "cursorAt": {
                            "top": 100
                        },
                        "zIndex": 300,
                        "refreshPositions": true,
                        "start": function(event, ui) {
                            $(".dropzone").addClass("dropzone-highlight");
                        },
                        "stop": function(event, ui) {
                            $(".dropzone").removeClass("dropzone-highlight");
                        }
                    });

					/***** START FD EDIT *****/
					form.getFieldEl().find(".alpaca-wizard-nav ul.nav li").each(function(i) {
						var _self = $(this);
						
						// interaction div
						var interaction = $('<div class="interaction"></div>');
						var buttonGroup = $('<div class="btn-group"></div>');
						
						var editButton = $('<button class="btn btn-default btn-xs" title="Edit"><i class="glyphicon glyphicon-pencil"></i></button>');
						var cancelButton = $('<button class="btn btn-warning btn-xs" title="Cancel" style="display: none;"><i class="glyphicon glyphicon-ban-circle"></i></button>');
						var plusButton = $('<button class="btn btn-success btn-xs" title="Add"><i class="glyphicon glyphicon-plus"></i></button>');
						var minusButton = $('<button class="btn btn-danger btn-xs" title="Remove"><i class="glyphicon glyphicon-minus"></i></button>');
						
						buttonGroup.append(editButton);
						buttonGroup.append(cancelButton);
						
						if (i == form.getFieldEl().find(".alpaca-wizard-nav ul.nav li").length - 1) {
							plusButton.css({'position' : 'absolute', 'right' : '0'});
                            _self.append(plusButton);
                            var view = editor5.getValue();
                            var _obj_opt_editor5 = JSON.parse(view);
                            var enableAddStepBtn = false;
                            if (_obj_opt_editor5.wizard.bindings && Object.values(_obj_opt_editor5.wizard.bindings).indexOf(i+1) > -1) {
                                enableAddStepBtn = true;
                            }
                            if(!enableAddStepBtn){
                                plusButton.hide();
                            }else  plusButton.show();
						}
						if (i > 0) {
							buttonGroup.append(minusButton);
						}
						interaction.append(buttonGroup);
						//console.log('render view', view);
						
						editButton.on('click', function(e) {
							var _self = $(this);
							var li = _self.closest('li');
							var index = parseInt(li.index());
							editWizardStep(index, li);
						});
						
						cancelButton.on('click', function(e) {
							var _self = $(this);
							var li = _self.closest('li');
							var index = parseInt(li.index());
							cancelWizardStep(li);
						});
						
						minusButton.on('click', function(e) {
							var _self = $(this);
							var index = parseInt(_self.closest('li').index());
							removeWizardStep(index);
						});
						
						plusButton.on('click', function(e) {
							var _self = $(this);
							var index = parseInt(_self.closest('li').index());
							addWizardStep(index);
						});
						
						_self.append(interaction);

						var inputTitle = $('<div class="wz-editor" style="display: none;"><input type="text" class="no-borders wz-title" /></div>');
						var inputDescription = $('<div class="wz-editor" style="display: none;"><input type="text" class="no-borders wz-description" /></div>');
						_self.find('.holder').append(inputTitle);
						_self.find('.holder').append(inputDescription);
						
						// sortable
						var sortableElem = _self.closest('ul');
						sortableElem.addClass('alpaca-wizard');
						//_self.addClass('w-resize');
						sortableElem.sortable({
							cursor: 'w-resize',
							//connectWith: 'ul.alpaca-wizard',
							//helper: 'clone',
							//placeholder: "ui-state-highlight",
							start: function(event, ui) {
								$(ui.item).data('startindex', ui.item.index());
								//console.log("start:", ui.item.index());
							},
							stop: function(event, ui) {
								//console.log("stop:", ui.item.index(), 'from', $(ui.item).data().startindex);
								$(ui.item).data('endindex', ui.item.index());
								if (ui.item.index() != $(ui.item).data().startindex) {
									//console.log(isEmptyWizardStep($(ui.item).data().startindex + 1), isEmptyWizardStep(ui.item.index() + 1));
									if( isEmptyWizardStep($(ui.item).data().startindex + 1) == isEmptyWizardStep(ui.item.index() + 1) ) {
										swapWizardStep($(ui.item).data().startindex, ui.item.index());
										return true;
									}
								}
								return false;
							}
						});
						_self.closest('ul').disableSelection();
                    });
					/***** END FD EDIT *****/
                }
				
				/* START FD EDIT */
				$('.alpaca-wizard .alpaca-wizard-buttons:visible').find('[data-alpaca-wizard-button-key="previous"], [data-alpaca-wizard-button-key="next"]')
					.on('click', function(e) {
					//console.log('e.originalEvent', e.originalEvent);
					if (e.originalEvent != null && e.originalEvent !== 'undefined') {
						memWizardStep($(e.target));
					}
				});
				$('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li')
					.on('click', function(e) {
					memWizardStep($(e.target));
				});
				setCurrentWizardStep(form);
				$('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li').on('click', function(e) {
					restoreWizardSteps();
				});
				/* END FD EDIT */

                cb(null, form);
            };
            config.error = function(err)
            {
                Alpaca.defaultErrorCallback(err);

                cb(err);
            };

            if (disableErrorHandling)
            {
                Alpaca.defaultErrorCallback = function(error) {
                    console.log("Alpaca encountered an error while previewing form -> " + error.message);
                };
            }
            else
            {
                Alpaca.defaultErrorCallback = Alpaca.DEFAULT_ERROR_CALLBACK;
            }

            $(el).alpaca(config);
        }
    };
	
	/***** START FD EDIT *****/
	/**
	 * Workhorse method for moving an item in the array to a new index.
	 *
	 * @param {Number} sourceIndex the index of the child to be moved
	 * @param {Number} targetIndex the index to be moved to
	 * @param [Boolean] animate whether to animate
	 * @param [Function] callback called after the child is added and refresh occurs
	 */
	var moveItemA = function(self, sourceIndex, targetIndex, animate, callback)
	{
		if (typeof(animate) == "function")
		{
			callback = animate;
			animate = self.options.animate;
		}

		if (typeof(animate) == "undefined")
		{
			animate = self.options.animate ? self.options.animate : true;
		}

		if (typeof(sourceIndex) === "string")
		{
			sourceIndex = parseInt(sourceIndex, 10);
		}

		if (typeof(targetIndex) === "string")
		{
			targetIndex = parseInt(targetIndex, 10);
		}

		if (targetIndex < 0)
		{
			targetIndex = 0;
		}
		if (targetIndex >= self.children.length)
		{
			targetIndex = self.children.length - 1;
		}

		if (targetIndex === -1)
		{
			// no target index
			return;
		}

		if (sourceIndex === targetIndex)
		{
			// nothing to do
			return;
		}

		var targetChild = self.children[targetIndex];
		if (!targetChild)
		{
			// target child not found
			return;
		}

		var onComplete = function()
		{
			var adjustedTargetIndex = targetIndex;
			if (sourceIndex < targetIndex) {
				adjustedTargetIndex--;
			}

			// splice out child
			var child = self.children.splice(sourceIndex, 1)[0];
			self.children.splice(adjustedTargetIndex, 0, child);

			// set data and refresh
			self.data = self.getValue();
			self.refresh(function() {

				// refresh validation state
				self.refreshValidationState();

				// trigger update
				self.triggerUpdate();

				// dispatch event: move
				self.trigger("move");

				if (callback)
				{
					Alpaca.nextTick(function() {
						callback();
					});
				}

			});
		};

		var duration = 0;
		if (animate)
		{
			duration = 500;
		}

		if (duration > 0)
		{
			var parentFieldId = self.getId();

			// the source and target DOM elements
			var sourceContainer = self.getContainerEl().find(".alpaca-container-item[data-alpaca-container-item-index='" + sourceIndex + "'][data-alpaca-container-item-parent-field-id='" + parentFieldId + "']");
			var targetContainer = self.getContainerEl().find(".alpaca-container-item[data-alpaca-container-item-index='" + targetIndex + "'][data-alpaca-container-item-parent-field-id='" + parentFieldId + "']");

			// create two temp elements as markers for switch
			var tempSourceMarker = $("<div class='tempMarker1'></div>");
			sourceContainer.before(tempSourceMarker);
			var tempTargetMarker = $("<div class='tempMarker2'></div>");
			targetContainer.before(tempTargetMarker);

			// moves div visually
			Alpaca.animatedMove(sourceContainer, targetContainer, duration, function () {
				onComplete();
			});
		}
		else
		{
			onComplete();
		}
	};
	
	var clone = function(o) {
	  var clone = o;

	  if (Array.isArray(o)) {
		clone = o.slice(0);
	  } else if (typeof o === 'object') {
		clone = $.extend(true, {}, o);
	  }

	  return clone;
	};
	
	var getObjectProperty = function(obj, key) {
		for (var k in obj) {
			if (k == key) {
				return obj[k];
			}
		}
		return null;
	};
	
	var restoreWizardSteps = function() {
		var top = getWizardInstance();
		//console.log('restoreWizardSteps', top.wizardConfigs.completedWizardStepIndex);
		$('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li').each(function(index) {
			if (index <= top.wizardConfigs.completedWizardStepIndex) {
				if (index < top.wizardConfigs.completedWizardStepIndex) {
					/*if (!$(this).hasClass('completed')) {
						$(this).addClass('completed');
					}*/
					if (!$(this).hasClass('visited')) {
						$(this).addClass('visited');
					}
				}
				if ($(this).hasClass('disabled')) {
					$(this).removeClass('disabled');
				}
			}
		});
	};
	
	var memWizardStep = function(btn) {
		//console.log('btn', btn);
		var top = getWizardInstance();
		var currentStepIndex = $('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li.active').index();
		var completedWizardStepIndex = top.wizardConfigs.completedWizardStepIndex;
		currentStepIndex = (typeof currentStepIndex !== 'undefined' && currentStepIndex >= 0) ? currentStepIndex : 0;
		//console.log('ACTIVE currentStepIndex', currentStepIndex);
		if (btn.attr('data-alpaca-wizard-button-key') == 'next') {
			top.wizardConfigs.currentWizardStepIndex = ++currentStepIndex;
			if (completedWizardStepIndex == null || typeof completedWizardStepIndex === 'undefined' || (currentStepIndex > completedWizardStepIndex)) {
				top.wizardConfigs.completedWizardStepIndex = currentStepIndex;
			}
		} else if (btn.attr('data-alpaca-wizard-button-key') == 'previous') {
			top.wizardConfigs.currentWizardStepIndex = currentStepIndex;
        } else { // clicked on step
			var pressedBtn = btn.closest('li:not(.disabled)');
			currentStepIndex = pressedBtn.index();
			currentStepIndex = (typeof currentStepIndex !== 'undefined' && currentStepIndex >= 0) ? currentStepIndex : 0;
			top.wizardConfigs.currentWizardStepIndex = currentStepIndex;
			if (completedWizardStepIndex == null || typeof completedWizardStepIndex === 'undefined' || (currentStepIndex > completedWizardStepIndex)) {
				top.wizardConfigs.completedWizardStepIndex = currentStepIndex;
			}
		}
		//console.log('MEM currentStepIndex', top.wizardConfigs.currentWizardStepIndex, top.wizardConfigs.completedWizardStepIndex);
	};
	
	var checkWizardNextStep = function(form, top) {	
		setTimeout(function() {
			var activeWizardStepIndex = $('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li.active').index();
			activeWizardStepIndex = (typeof activeWizardStepIndex !== 'undefined' && activeWizardStepIndex >= 0) ? activeWizardStepIndex : 0;
			//console.log('INDEXES', activeWizardStepIndex, top.wizardConfigs.currentWizardStepIndex);
			restoreWizardSteps();
			if (activeWizardStepIndex >= 0) {
				if (activeWizardStepIndex < top.wizardConfigs.completedWizardStepIndex) {
					form.trigger("advanceOrSubmit");
					checkWizardNextStep(form, top);
				} else { // after complete... back to current index
					form.trigger("moveToStep", { "index": top.wizardConfigs.currentWizardStepIndex, "skipValidation": true });
				}
			}
		}, 10);
	};
	
	var setCurrentWizardStep = function(form) {
        var top = getWizardInstance();
        var currentStepIndex;
        
        if (typeof top !== 'undefined' && top != null) {
            if (typeof top.wizardConfigs !== 'undefined' && top.wizardConfigs != null) {
				if (top.wizardConfigs.currentWizardStepIndex == null || typeof top.wizardConfigs.currentWizardStepIndex === 'undefined') {
					top.wizardConfigs.currentWizardStepIndex = 0;
				}
                currentStepIndex = top.wizardConfigs.currentWizardStepIndex;
                //console.log('currentWizardStepIndex', currentStepIndex);
               
                currentStepIndex = (typeof currentStepIndex !== 'undefined' && currentStepIndex >= 0) ? currentStepIndex : 0;
                //console.log('currentStepIndex', currentStepIndex);
                if(currentStepIndex >= 0){
					form.trigger("moveToStep", { "index": currentStepIndex, "skipValidation": true }); // for safe re-set
					checkWizardNextStep(form, top);
                }
            }
        }
	}
	
	/***** start wizard step editor *****/
	var regenerateView = function(callback) {
		_schema = $.extend(true, {}, schema);
		_options = $.extend(true, {}, options);
		_data = $.extend(true, {}, data);
		
        /*editor1.setValue(JSON.stringify(_schema, null, "    "));
        editor2.setValue(JSON.stringify(_options, null, "    "));
        editor3.setValue(JSON.stringify(_data, null, "    "));*/
		
        if(_view) {
            view = _view;
        } else {
        	view = {};
        }
        editor5.setValue(JSON.stringify(view, null, "    "));
		//editor5.clearSelection();
		
		setModelloForm({schema: _schema, options: _options, data: _data, view: view});
		setTimeout(function() {
			refresh();
		}, 100);
	};
	
	var getWizardInstance = function() {
		var mapInstances = Alpaca.fieldInstances;
		for(var key in mapInstances) {
			var item = mapInstances[key];
			if (typeof item.wizardConfigs !== 'undefined' && item.wizardConfigs != null) {
				return item;
			}
		}
		return null;
	};
	
	var swapArrayElements = function(arr, startIndex, endIndex) {
		[arr[startIndex], arr[endIndex]] = [arr[endIndex], arr[startIndex]];
	}
	
	var swapWizardBindings = function(bindings, startStep, endStep) {
		// map start steps to UNUSED
		for (var key in bindings) {
			if (bindings[key] == startStep) {
				bindings[key] = -1;
			}
		}
		
		// update end step
		for (var key in bindings) {
			if (bindings[key] == endStep) {
				bindings[key] = startStep;
			}
		}
		
		// update start step
		for (var key in bindings) {
			if (bindings[key] == -1) {
				bindings[key] = endStep;
			}
		}
	};
	
	var isEmptyWizardStep = function(step) {
		var top = getWizardInstance();
		var bindings = top.wizardConfigs.bindings;
		for (var key in bindings) {
			if (bindings[key] == step) {
				return false;
			}
		}
		return true;
	};
	
	var swapWizardStep = function(startIndex, endIndex) {
		var top = getWizardInstance();
		_view = $.extend(true, {}, view); // clone
		//console.log("startIndex: " + startIndex, ' endIndex ' + endIndex);
		
		// swap steps
		swapArrayElements(_view.wizard.steps, startIndex, endIndex);
		swapArrayElements(top.wizardConfigs.steps, startIndex, endIndex);
		
		// swap bindings
		swapWizardBindings(_view.wizard.bindings, startIndex + 1, endIndex + 1);
		swapWizardBindings(top.wizardConfigs.bindings, startIndex + 1, endIndex + 1);
		
		regenerate(top, _view, function() {
			//console.log('top', top);
			//console.log('view', view, top.wizardConfigs);
		});
	};
	
	var removeWizardBindings = function(bindings, step) {
		// set prev step
		for (var key in bindings) {
			if (bindings[key] == step) {
				//console.log('delete', key);
				//delete bindings[key];
				bindings[key] = step - 1;
			}
		}
		
		// update next steps
		for (var key in bindings) {
			if (bindings[key] > step) {
				//console.log('delete', key);
				//delete bindings[key];
				bindings[key] = bindings[key] - 1;
			}
		}
	};
	
	var addWizardBindings = function(bindings, step) {
		//console.log('added step to', step);
	};
	
    var removeWizardStep = function(index) {
		var top = getWizardInstance();
		_view = $.extend(true, {}, view); // clone
		
		// remove step
		_view.wizard.steps.splice(index, 1);	
		top.wizardConfigs.steps.splice(index, 1);
		//console.log('remove...', index, _view);
		
		// delete bindings
		removeWizardBindings(_view.wizard.bindings, index + 1);
		removeWizardBindings(top.wizardConfigs.bindings, index + 1);
		
		regenerate(top, _view, function() {
			//console.log('top', top);
			//console.log('view', view, top.wizardConfigs);
		});
		
		/*regenerateView(function() {
			console.log('top', top);
		});*/
	};
	
	var addWizardStep = function(index) {
		var top = getWizardInstance();
		_view = $.extend(true, {}, view); // clone
		
		var title = 'Step ' + (index + 2);
		var description = 'step ' + (index + 2);
		var step = {
			title: title,
			description: description
		};
		
		// add step
		_view.wizard.steps.splice(index + 1, 0, $.extend(true, {}, step));	
		top.wizardConfigs.steps.splice(index + 1, 0, $.extend(true, {}, step));
		
		// update bindings
		addWizardBindings(_view.wizard.bindings, index + 1);
		addWizardBindings(top.wizardConfigs.bindings, index + 1);
		
		regenerate(top, _view, function() {
			//console.log('top', top);
			//console.log('view', view, top.wizardConfigs);
		});
	};
	
    var editWizardStep = function(index, container) {
		var top = getWizardInstance();
		_view = $.extend(true, {}, view); // clone
		//console.log('top', top);
		
		if ( !container.find('.holder').find('div.wz-editor').is(':visible') ) { // EDIT
			container.find('.holder').find('input.wz-title').val( top.wizardConfigs.steps[index].title );
			container.find('.holder').find('input.wz-description').val( top.wizardConfigs.steps[index].description );
			
			container.find('i.glyphicon-pencil').removeClass('glyphicon-pencil').addClass('glyphicon-ok').attr('title', 'Confirm');
			container.find('i.glyphicon-ban-circle').closest('button').show();
			container.find('.holder').find('div.wz-editor').show();
			container.find('.holder').find('div.title, div.description').hide();
		} else { // CONFIRM
			var title = container.find('.holder').find('input.wz-title').val();
			var description = container.find('.holder').find('input.wz-description').val();
			top.wizardConfigs.steps[index].title = _view.wizard.steps[index].title = title;
			top.wizardConfigs.steps[index].description = _view.wizard.steps[index].description = description;
			
			cancelWizardStep(container);
			
			regenerate(top, _view, function() {
				//console.log('top', top);
				//console.log(top.wizardConfigs.steps[index].description);
				//console.log('view', view, top.wizardConfigs);
			});
		}
	};
	
    var cancelWizardStep = function(container) {
		container.find('i.glyphicon-ok').removeClass('glyphicon-ok').addClass('glyphicon-pencil').closest('button').attr('title', 'Edit');
		container.find('i.glyphicon-ban-circle').closest('button').hide();
		container.find('.holder').find('div.wz-editor').hide();
		container.find('.holder').find('div.title, div.description').show();
	};
	/***** end wizard step editor *****/
	/***** END FD EDIT *****/

    var removeFunctionFields = function(schema, options)
    {
        if (schema)
        {
            if (schema.properties)
            {
                var badKeys = [];

                for (var k in schema.properties)
                {
                    if (schema.properties[k].type === "function")
                    {
                        badKeys.push(k);
                    }
                    else
                    {
                        removeFunctionFields(schema.properties[k], (options && options.fields ? options.fields[k] : null));
                    }
                }

                for (var i = 0; i < badKeys.length; i++)
                {
                    delete schema.properties[badKeys[i]];

                    if (options && options.fields) {
                        delete options.fields[badKeys[i]];
                    }
                }
            }
        }
    };
	
	var applyLayoutConfirm = function(event,callback){
		var modal = $(".form-builder-modal");
		 
		//modal.find(".modal-header").html('<span class="alert alert-warning"></span>')
		modal.find(".modal-title").html('<span class="glyphicon glyphicon-warning-sign"> Attenzione</span>');

		var confirmDialog = '<form id="form"><label>Una volta applicato il layout non può essere più rimosso.Vuoi continuare?</label></form>';
		modal.find(".modal-body").html(confirmDialog);
		
		
		
		modal.find('.modal-footer').html("<button class='btn btn-primary pull-right okay' data-dismiss='modal' aria-hidden='true'>Okay</button>");
		modal.find('.modal-footer').append("<button class='btn btn-default pull-left' data-dismiss='modal' aria-hidden='true'>Cancel</button>");

            $(modal).modal({
                keyboard: false,
				backdrop: 'static'
            });

		$(modal).find(".okay").click(function(e) {
				e.preventDefault();
				//return true;
				if (callback)
						{
							callback(true);
						}
		});
	}

	var editFieldName = function(event, alpacaFieldId, callback){
		var modal = $(".form-builder-modal");
		var isTemplatePresent = (typeof view.layout === 'undefined' || view.layout == null ||
								 typeof view.layout.template === 'undefined' || view.layout.template == null) ? false : true;
		var templateIds = [ { text: "DEFAULT", value: "", selected: true } ];
		var alpacaTemplateId = null;
		var selectTemplateId = null;
		
		modal.find(".modal-title").html('<span>Inserisci un ID al Field</span>');
		
		/* *** START FD EDIT *** */
		if (isTemplatePresent) {
			$(view.layout.template).find('[id]').each(function(i) {
				var tmpId = $(this).attr('id');
				templateIds.push({ text: tmpId, value: tmpId });
			});
			
			selectTemplateId = $('<div>').append('<select id="editTemplateId">');
			$(templateIds).each(function(i) {
				var opt = $("<option>");
				
				opt.attr('value', this.value).text(this.text);
				if (typeof this.selected !== 'undefined' && this.selected) {
					opt.attr('selected', 'selected');
				}
				selectTemplateId.find('select').append(opt);
			});
		}
		
		var modalBodyContent = '<form id="form">' +
								'<div class="row" style="margin-left:0;">' +
									'<div class="col-md-3">' +
										'<div class="form-group">' +
											'<label for="field" class="control-label">Field Name (ID)</label>' +
										'</div>' +
									'</div>' +
									'<div class="col-md-3">' +
										'<div class="form-group">' +
											'<input type="text" id="editFieldId" name="field" />' +
										'</div>' +
									'</div>' +
								'</div>' +
								
								((isTemplatePresent)
								?
								'<div class="row"  style="margin-left:0;">' +
									'<div class="col-md-3">' +
										'<div class="form-group">' +
											'<label for="field" class="control-label">Template ID</label>' +
										'</div>' +
									'</div>' +
									'<div class="col-md-3">' +
										'<div class="form-group">' +
											(selectTemplateId.html()) +
										'</div>' +
									'</div>' +
								'</div>'
								:
								'') +
									
								'<br/>' +
							'</form>';
							
		modal.find(".modal-body").html(modalBodyContent);
		$('#editFieldId').attr('value', alpacaFieldId);
		/* *** END FD EDIT *** */
		
		
		modal.find('.modal-footer').html("<button class='btn btn-primary pull-right okay' data-dismiss='modal' aria-hidden='true'>Okay</button>");
		modal.find('.modal-footer').append("<button class='btn btn-default pull-left' data-dismiss='modal' aria-hidden='true'>Cancel</button>");

		$(modal).modal({
			keyboard: false,
			backdrop: 'static'
		});
		
		$(modal).on('hidden.bs.modal', function () {
			//console.log('hide modal');
			$(event.target).removeClass("dropzone-hover");
		});
			
		$(modal).find(".okay").click(function(e) {
				e.preventDefault();
				// verifico prima se univoco
				alpacaFieldId = $('#editFieldId').val();
				alpacaTemplateId = ($('#editTemplateId').val() === "") ? null : $('#editTemplateId').val();
				 
				$.validator.addMethod('codExistss', function(value, element) {
					var findInstance = false;
					for(var key in Alpaca.fieldInstances) {
						var item = Alpaca.fieldInstances[key];
						if(item.name == alpacaFieldId){
							findInstance = true;
							break;
						}
					}
					if(findInstance) return false;
					else return true;
			    }, "The code already exists.");
				 
				$('#form').validate({
					rules: {
					  field: {					 
						required: true,
						codExistss: true
					  }
					}
				});
				 
				if ($('#form').valid()) {
					if (callback) {
						callback(alpacaFieldId, alpacaTemplateId);
					}
					$('#dialog').dialog('close');
				} else return false;
				  
            });
	}
	
    var editSchema = function(alpacaFieldId, callback)
    {
        var field = Alpaca.fieldInstances[alpacaFieldId];
		
        var fieldSchemaSchema = field.getSchemaOfSchema();
        var fieldSchemaOptions = field.getOptionsForSchema();
        removeFunctionFields(fieldSchemaSchema, fieldSchemaOptions);
        var fieldData = field.schema;

        delete fieldSchemaSchema.title;
        delete fieldSchemaSchema.description;
        if (fieldSchemaSchema.properties)
        {
            delete fieldSchemaSchema.properties.title;
            delete fieldSchemaSchema.properties.description;
            delete fieldSchemaSchema.properties.dependencies;
        }
        var fieldConfig = {
            schema: fieldSchemaSchema
        };
        if (fieldSchemaOptions)
        {
            fieldConfig.options = fieldSchemaOptions;
        }
        if (fieldData)
        {
            fieldConfig.data = fieldData;
        }
        fieldConfig.view = {
            "parent": MODAL_VIEW,
            "displayReadonly": false
        };
        fieldConfig.postRender = function(control)
        {
            var modal = $(".form-builder-modal");
            modal.find(".modal-title").html(field.getTitle());
            modal.find(".modal-body").html(control.getFieldEl());

            modal.find('.modal-footer').html("<button class='btn btn-primary pull-right okay' data-dismiss='modal' aria-hidden='true'>Okay</button>");
            modal.find('.modal-footer').append("<button class='btn btn-default pull-left' data-dismiss='modal' aria-hidden='true'>Cancel</button>");
			
			modal.find(".modal-body").find('label.alpaca-control-label').addClass('settings');

            $(modal).modal({
                "keyboard": true
            });

            $(modal).find(".okay").click(function() {
                field.schema = control.getValue();
				if (field.schema.enum != null && typeof field.schema.enum !== 'undefined') {
					if(field.schema.enum.length === 0){
						delete field.schema.enum;
					} else {
						// remove all dbl-quotes
						for(var i = 0; i < field.schema.enum.length; i++){
							field.schema.enum[i] = field.schema.enum[i].replace(/"/g, '\'');
						}
					}
				}
                
				if (field.schema.disallow != null && typeof field.schema.disallow !== 'undefined') {
					if(field.schema.disallow.length === 0){
						delete field.schema.disallow;
					}
				}

                var top = findTop(field);
                regenerate(top, view);

                if (callback)
                {
                    callback();
                }
            });

            control.getFieldEl().find("p.help-block").css({
                "display": "none"
            });
        };

        var x = $("<div><div class='fieldForm'></div></div>");
        $(x).find(".fieldForm").alpaca(fieldConfig);
    };
	
	var hasOptions = function(alpacaFieldId)
	{
        var field = Alpaca.fieldInstances[alpacaFieldId];
		if (field.options.type != 'object' && !$.isEmptyObject(field.options.fields)) {
			return false;
		}
		return true;
	};

    var editOptions = function(alpacaFieldId, callback)
    {
        var field = Alpaca.fieldInstances[alpacaFieldId];

        var fieldOptionsSchema = field.getSchemaOfOptions();
        var fieldOptionsOptions = field.getOptionsForOptions();
        removeFunctionFields(fieldOptionsSchema, fieldOptionsOptions);
        var fieldOptionsData = field.options;

        delete fieldOptionsSchema.title;
        delete fieldOptionsSchema.description;
        if (fieldOptionsSchema.properties)
        {
            delete fieldOptionsSchema.properties.title;
            delete fieldOptionsSchema.properties.description;
            delete fieldOptionsSchema.properties.dependencies;
            delete fieldOptionsSchema.properties.readonly;
            
            //Focus to false by default
			if (fieldOptionsSchema.properties.focus != null && typeof fieldOptionsSchema.properties.focus !== 'undefined') {
				fieldOptionsSchema.properties.focus['default'] = false;
			}
        }
        if (fieldOptionsOptions.fields)
        {
            delete fieldOptionsOptions.fields.title;
            delete fieldOptionsOptions.fields.description;
            delete fieldOptionsOptions.fields.dependencies;
            delete fieldOptionsOptions.fields.readonly;
        }

        var fieldConfig = {
            schema: fieldOptionsSchema
        };
        if (fieldOptionsOptions)
        {
            fieldConfig.options = fieldOptionsOptions;
        }
        if (fieldOptionsData)
        {
            fieldConfig.data = fieldOptionsData;
        }
        fieldConfig.view = {
            "parent": MODAL_VIEW,
            "displayReadonly": false
        };
        fieldConfig.postRender = function(control)
        {
            var modal = $(".form-builder-modal");
            modal.find(".modal-title").html(field.getTitle());
            modal.find(".modal-body").html(control.getFieldEl());

            modal.find('.modal-footer').html("<button class='btn btn-primary pull-right okay' data-dismiss='modal' aria-hidden='true'>Okay</button>");
            modal.find('.modal-footer').append("<button class='btn btn-default pull-left' data-dismiss='modal' aria-hidden='true'>Cancel</button>");
			
			modal.find(".modal-body").find('label.alpaca-control-label').addClass('settings');

            $(modal).modal({
                "keyboard": true
            });

            $(modal).find(".okay").click(function() {

                field.options = control.getValue();
                
                //Sort to false by default
                field.options.sort = false;

                var top = findTop(field);
                regenerate(top, view, function() {
					if(top.wizardConfigs){
						let opt = JSON.parse(editor2.getValue());
						rearrangeFields(opt);
						editor2.setValue(JSON.stringify(opt, null, "    "));
						editor2.clearSelection();
					}
				});

                if (callback)
                {
                    callback();
                }
            });

            control.getFieldEl().find("p.help-block").css({
                "display": "none"
            });
        };

        var x = $("<div><div class='fieldForm'></div></div>");
        $(x).find(".fieldForm").alpaca(fieldConfig);
    };

    var refreshView = function(callback)
    {
        if (mainViewField)
        {
            mainViewField.getFieldEl().replaceWith("<div id='viewDiv'></div>");
            mainViewField.destroy();
            mainViewField = null;
        }

        doRefresh($("#viewDiv"), false, false, function(err, form) {

            if (!err)
            {
                mainViewField = form;
            }

            if (callback)
            {
                callback();
            }

        });
    };

    var refreshPreview = function(callback)
    {
    	//console.log('refreshPreview', mainPreviewField);
        if (mainPreviewField)
        {
            mainPreviewField.getFieldEl().replaceWith("");
            mainPreviewField.destroy();
            mainPreviewField = null;
        }

        doRefresh($("#previewDiv"), false, false, function(err, form) {

            if (!err)
            {
                mainPreviewField = form;
            }

            if (callback)
            {
                callback();
            }
            
            rtProcessing = false;

        });
    };

    var refreshDesigner = function(callback)
    {
        $(".dropzone").remove();
        $(".interaction").remove();
        $(".cover").remove();

        if (mainDesignerField)
        {
            //mainDesignerField.getFieldEl().replaceWith("<div id='designerDiv'></div>");
            mainDesignerField.destroy();
            mainDesignerField = null;
        }

        doRefresh($("#designerDiv"), true, false, function(err, form) {

            if (!err)
            {
                mainDesignerField = form;
            }

            if (callback)
            {
                callback();
            }

        });
    };

    var refreshCode = function(callback)
    {
        var json = {
            "schema": schema
        };
        if (options) {
            json.options = options;
        }
        if (data) {
            json.data = data;
        }
        if (view) {
            json.view = view;
        }
        var code = "$('#div').alpaca(" + JSON.stringify(json, null, "    ") + ");";

        editor4.setValue(code);
        editor4.clearSelection();
        editor4.gotoLine(0,0);

        if (callback)
        {
            callback();
        }
    };

    var refresh = function(callback)
    {
        var current = $("UL.nav.nav-tabs LI.active A.tab-item");
        $(current).click();
    };

    var rtChange = false;
    editor1.on("change", function() {
        rtChange = true;
    });
    editor2.on("change", function() {
        rtChange = true;
    });
    editor3.on("change", function() {
        rtChange = true;
    });
    editor5.on("change", function() {
        rtChange = true;
    });

    // background "thread" to detect changes and update the preview div
    var rtProcessing = false;
    var rtFunction = function() {

        if (rtChange && !rtProcessing)
        {
            rtProcessing = true;
            //console.log('rtFunction', mainPreviewField, rtProcessing);
            if (mainPreviewField)
            {
                mainPreviewField.getFieldEl().replaceWith("");
                mainPreviewField.destroy();
                mainPreviewField = null;
            }
            doRefresh($("#previewDiv"), false, true, function(err, form) {

                if (!err)
                {
                    mainPreviewField = form;
                }

                rtChange = false;
                rtProcessing = false;
            });
        }

        setTimeout(rtFunction, 1000);

    };
    rtFunction();

    var isCoreField = function(type)
    {
        var cores = ["any", "array", "checkbox", "file", "hidden", "number", "object", "radio", "select", "text", "textarea"];

        var isCore = false;
        for (var i = 0; i < cores.length; i++)
        {
            if (cores[i] == type)
            {
                isCore = true;
            }
        }

        return isCore;
    };

    // types
    var types = [{
        "type": "string",
        "title": "String",
        "description": "A textual property"
    }, {
        "type": "number",
        "title": "Number",
        "description": "A numerical property"
    }, {
        "type": "boolean",
        "title": "Boolean",
        "description": "A true/false property"
    }, {
        "type": "object",
        "title": "Object",
        "description": "A collection of keyed sub-properties"
    }, {
        "type": "array",
        "title": "Array",
        "description": "An array of sub-properties"
    }];
    for (var i = 0; i < types.length; i++)
    {
        var title = types[i].title;
        var type = types[i].type;
        var description = types[i].description;

        var div = $("<div class='form-element draggable ui-widget-content' data-type='" + type + "'></div>");
        $(div).append("<div><span class='form-element-title'>" + title + "</span> (<span class='form-element-type'>" + type + "</span>)</div>");
        $(div).append("<div class='form-element-field-description'>" + description + "</div>");

        $("#types").append(div);
    }
    
    
    var getPathname = function(url) {
		/*var index = url.lastIndexOf("/");
		var path = url.substring(0, index);
		return path;*/
		return window.location.origin + '/' + window.location.pathname;
	};
    
    // layouts
    var layouts = [
	{
    	"id": "layout-col1",
    	"title": "Layout 1 colonna",
    	"view": {}
    },
	{
    	"id": "layout-col2",
    	"title": "Layout 2 colonne",
    	"view": {
    		"parent": "bootstrap-edit",
    	    "layout": {
    	    	"template": "<div><div class='row'><div class='col-md-6 zone-layout' id='column-1'></div><div class='col-md-6 zone-layout' id='column-2'></div></div><div class='row'><div class='col-md-12 zone-layout' id='row-default'></div></div></div>",
    	    	"bindings": {
    	    		//"email": "#column-1",
    	    		//"password": "#column-2"
    	    	}
    	    }
    	}
    },
	{
    	"id": "layout-col3",
    	"title": "Layout 3 colonne",
    	"view": {
    		"parent": "bootstrap-edit",
    	    "layout": {
    	    	"template": "<div><div class='row'><div class='col-md-4 zone-layout' id='column-1'></div><div class='col-md-4 zone-layout' id='column-2'></div><div class='col-md-4 zone-layout' id='column-3'></div></div><div class='row'><div class='col-md-12 zone-layout' id='row-default'></div></div></div>",
    	    	"bindings": {
    	    		//"email": "#column-1",
					//"username": "#column-2"
    	    		//"password": "#column-3"
    	    	}
    	    }
    	}
    },
	/*{
    	"id": "layout-col2-wz",
    	"title": "Layout 2 colonne per wizard",
    	"view": {
    		"parent": "bootstrap-edit",
    	    "layout": {
    	    	"template": getPathname(window.location.href) + '/layouts/2-columns-template-wz.html',"bindings": {}
    	    }
    	}
    },*/
	{
    	"id": "wizard-01",
    	"title": "Wizard",
		"view":{
			"id": "wizard-alpaca",
			"title": "Wizard",
			"parent": "bootstrap-edit",
			"wizard": {
						"title": "Welcome to the Wizard",
						"description": "Descrizione",
						"bindings": {},
						"labels":{
							"nextButton":"Avanti",
							"previousButton":"Indietro",
							"submitButton":"Invia"
						},
						"hideSubmitButton":true,
						"steps": [
							{
							"title": "Step 1",
							"description": "Descrizione"
							} 
						]
			}
		} 
    }];
    
    
    var setProperty = function (obj, path, key, value) {
        var schema = obj;  // a moving reference to internal objects within obj
        var pList = path.split('.');
        var len = pList.length;
        for(var i = 0; i < len-1; i++) {
            var elem = pList[i];
            if( !schema[elem] ) schema[elem] = {}
            schema = schema[elem];
        }
        schema[pList[len-1]][key]=value;
    }
    
    var setupLayoutFromButton = function(button, viewObj) {
    	$(button).off().click(function(e) {
			//console.log('top',top);
            e.preventDefault();
            e.stopPropagation();
            
			applyLayoutConfirm(event,function(result) {
				if (result) {
					if (typeof viewObj.wizard === 'undefined') {
						var _string_opt_editor2 = editor2.getValue();
						var _obj_opt_editor2 = JSON.parse(_string_opt_editor2);
						_obj_opt_editor2.view = viewObj;
						if(!$.isEmptyObject(_obj_opt_editor2.view)) {
							for (var key in _obj_opt_editor2.fields) {
								setProperty(_obj_opt_editor2,'view.layout.bindings',key,'#row-default');
							}
						}
						editor2.setValue(JSON.stringify(_obj_opt_editor2, null, "    "));
						editor2.clearSelection();
						
                        var _obj_opt_editor5 = JSON.parse(editor5.getValue());
                        _obj_opt_editor5.layout = viewObj.layout;
                        _obj_opt_editor5.parent = viewObj.parent;
						editor5.setValue(JSON.stringify(_obj_opt_editor5, null, "    "));
						editor5.clearSelection();
					} else {
						var wizardInstance = getWizardInstance();
						if(!wizardInstance) {
							var _string_opt_editor2 = editor2.getValue();
							var _obj_opt_editor2 = JSON.parse(_string_opt_editor2);
							options = rearrangeFields(_obj_opt_editor2);
							editor2.setValue(JSON.stringify(options, null, "    "));
							editor2.clearSelection();

							var _string_opt_editor5 = editor5.getValue();
							var _obj_opt_editor5 = JSON.parse(_string_opt_editor5);
							_obj_opt_editor5 = viewObj;
							//faccio il binding dei campi già presenti
							var keys = Object.keys(schema.properties)
							for(var i in keys){
								_obj_opt_editor5.wizard.bindings[keys[i]] = 1;
							}
							editor5.setValue(JSON.stringify(_obj_opt_editor5, null, "    "));
							editor5.clearSelection();
						}
					}
					setTimeout(function() {
						refreshDesigner();
					}, 50);
				}
			});
				

            
        });
    }
    
    for (var i = 0; i < layouts.length; i++)
    {
    	var id = layouts[i].id;
        var title = layouts[i].title;
        var layoutView = layouts[i].view;
		

        var div = $("<div class='layout-element'></div>");
        $(div).append("<div><span class='form-element-title'>" + title + "</span></div>");
        $(div).append("<div class='form-element-field-description'>" + title + "</div>");
        
        var buttonGroup = $("<div class='btn-group'></div>");
        var layoutButton = $("<button id='#"+id+"' class='btn btn-default btn-xs button-schema'><i class='glyphicon glyphicon-play-circle'></i></button>");
        buttonGroup.append(layoutButton);
        $(div).append(buttonGroup);
        
        $("#layouts").append(div);       
        setupLayoutFromButton(layoutButton, layoutView);
        
    }
    
    var afterAlpacaInit = function()
    {
        // show all fields
        for (var typeClass in Alpaca.fieldClassRegistry)
        {
            var instance = new Alpaca.fieldClassRegistry[typeClass]();

            var schemaSchema = instance.getSchemaOfSchema();
            var schemaOptions = instance.getOptionsForSchema();
            var optionsSchema = instance.getSchemaOfOptions();
            var optionsOptions = instance.getOptionsForOptions();
            var title = instance.getTitle();
            var description = instance.getDescription();
            var type = instance.getType();
            var fieldType = instance.getFieldType();

            var div = $("<div class='form-element draggable ui-widget-content' data-type='" + type + "' data-field-type='" + fieldType + "'></div>");
            $(div).append("<div><span class='form-element-title'>" + title + "</span> (<span class='form-element-type'>" + fieldType + "</span>)</div>");
            $(div).append("<div class='form-element-field-description'>" + description + "</div>");

            var isCore = isCoreField(fieldType);
            if (isCore)
            {
                $("#basic").append(div);
            }
            else
            {
                $("#advanced").append(div);
            }

        }
        // init all of the draggable form elements
        $(".form-element").draggable({
        	"appendTo": "body",
        	"helper": "clone",
        	"zIndex": 300,
        	"refreshPositions": true,
        	"start": function(event, ui) {
        		$(".dropzone").addClass("dropzone-highlight");
        	},
        	"stop": function(event, ui) {
        		$(".dropzone").removeClass("dropzone-highlight");
        	}
        });
        
    };

    // lil hack to force compile
    $("<div></div>").alpaca({
        "data": "test",
        "postRender": function(control)
        {
            afterAlpacaInit();
        }
    });


    $(".tab-item-source").click(function() {
    	rtProcessing = true;
    	//console.log('Acting like a monkey :D');

        // we have to monkey around a bit with ACE Editor to get it to refresh
        editor1.setValue(editor1.getValue());
        editor1.clearSelection();
        editor2.setValue(editor2.getValue());
        editor2.clearSelection();
        editor3.setValue(editor3.getValue());
        editor3.clearSelection();
        editor5.setValue(editor5.getValue());
        editor5.clearSelection();

        setTimeout(function() {
            refreshPreview();
        }, 50);
    });
    $(".tab-item-view").click(function() {
        setTimeout(function() {
            refreshView();
        }, 50);
    });
    $(".tab-item-designer").click(function() {
        setTimeout(function() {
            refreshDesigner();
        }, 50);
    });
    $(".tab-item-code").click(function() {
        setTimeout(function() {
            refreshCode();
        }, 50);
    });

    $(".tab-source-schema").click(function() {
        // we have to monkey around a bit with ACE Editor to get it to refresh
        editor1.setValue(editor1.getValue());
        editor1.clearSelection();
    });

    $(".tab-source-options").click(function() {
        // we have to monkey around a bit with ACE Editor to get it to refresh
        editor2.setValue(editor2.getValue());
        editor2.clearSelection();
    });
    
    $(".tab-source-view").click(function() {
        // we have to monkey around a bit with ACE Editor to get it to refresh
        editor5.setValue(editor5.getValue());
        editor5.clearSelection();
    });

    $(".tab-source-data").click(function() {
        // we have to monkey around a bit with ACE Editor to get it to refresh
        editor3.setValue(editor3.getValue());
        editor3.clearSelection();
    });
    
    var insertFieldinLayout = function(schema, options, data, dataType, fieldType, parentField, destination)
    {
        var itemSchema = {
            "type": dataType
        };
        var itemOptions = {};
        if (fieldType)
        {
            itemOptions.type = fieldType;
        }
        itemOptions.label = "New ";
        if (fieldType)
        {
            itemOptions.label += fieldType;
        }
        else if (dataType)
        {
            itemOptions.label += dataType;
        }
        var itemData = null;

        var itemKey = null;
        if (parentField.getType() === "array")
        {
            itemKey = 0;
            if (previousFieldKey)
            {
                itemKey = previousFieldKey + 1;
            }
        }
        else if (parentField.getType() === "object")
        {
            itemKey = "new" + new Date().getTime();
        }

        parentField.addItem(itemKey, itemSchema, itemOptions, itemData, null, function() {
        	var top = findTop(parentField);
        	
        	// backup option view object
        	var view = parentField.options.view; //$.extend(true, { }, top.options.view);
        	
        	delete view.id;
        	setProperty(view, 'layout.bindings', itemKey, destination);
        	
        	top.options.view = {};
            regenerate(top, view);
        });
        
    };
	 
    var insertField = function(schema, options, data, dataType, fieldType, parentField, previousField, previousFieldKey, nextField, nextFieldKey, layoutParent, itemKey, itemTemplateId)
    {	 
        var itemSchema = {
            "type": dataType
        };
        var itemOptions = {};
        if (fieldType)
        {
            itemOptions.type = fieldType;
        }
        itemOptions.label = "New ";
        if (fieldType)
        {
            itemOptions.label += fieldType;
        }
        else if (dataType)
        {
            itemOptions.label += dataType;
        }
        var itemData = null;

        //var itemKey = null;
        if (parentField.getType() === "array")
        {
            itemKey = 0;
            if (previousFieldKey)
            {
                itemKey = previousFieldKey + 1;
            }
        }
        else if (parentField.getType() === "object")
        {
			if(itemKey == null){
				itemKey = "new" + new Date().getTime();
			}
        }

        var insertAfterId = null;
        if (previousField)
        {
            insertAfterId = previousField.id;
        }

        parentField.addItem(itemKey, itemSchema, itemOptions, itemData, insertAfterId, function() {
        	var top = findTop(parentField);
        	
        	//console.log('view', view, previousFieldKey, nextFieldKey);
        	
        	var column = 'column-1'; //Default column
        	
        	if (view && view.layout && view.layout.template) {
				/* START FD EDIT */
				// check empty layout bindings integrity with not empty wizard bindings
				if (typeof view.layout.bindings === 'undefined' || view.layout.bindings == null) {
					// check wizard bindings
					/*if (view.wizard && view.wizard.bindings) {
						view.layout.bindings = $.extend(true, {}, view.wizard.bindings); // clone
						var firstTemplateId = $(view.layout.template).find('[id]:first').attr('id');
						for (key in view.layout.bindings) {
							view.layout.bindings[key] = (typeof firstTemplateId !== 'undefined' || firstTemplateId === null) ? firstTemplateId : "column-1";
						}
					}*/
					view.layout.bindings = {};
				}
				/* END FD EDIT */
				
	        	// Retrieve the column to use
				if (itemTemplateId) {
					column = itemTemplateId;
				} else {
					if (previousFieldKey){
						// Add after the previousFieldKey
						var insertAfterName = top.childrenById[insertAfterId].name;
						if(view.layout.bindings[insertAfterName]){
							column = view.layout.bindings[insertAfterName];
						}
					} else if(nextFieldKey){
						// Add before the nextFieldKey
						if(view.layout.bindings[nextFieldKey]){
							column = view.layout.bindings[nextFieldKey];
						}
					} else {
						// Add in the parent field
						var layoutParentId = layoutParent.attr("id");
						if(layoutParentId){
							column = layoutParentId;
						} else {
							console.log("not handled!");
						}
					}
				}
	        	console.log('Using column', column);
	        	
	        	view.id = "view-" + new Date().getTime(); // Force regeneration of the view id
	        	setProperty(view, 'layout.bindings', itemKey, column);
        	}
			
			/* START FD EDIT */
			if(view && view.wizard && view.wizard.bindings){
				// check wizard bindings integrity
				for (key in view.wizard.bindings) {
					var wzStepVal = view.wizard.bindings[key];
					var wzStepNum = 1;
					if (wzStepVal === null || typeof wzStepVal === 'string') {
						wzStepVal = wzStepVal.replace(/[^0-9]/gi, "");
						var num = parseInt(wzStepVal);
						if (!isNaN(num) && typeof num === 'number') {
							wzStepNum = num;
						}
						view.wizard.bindings[key] = wzStepNum;
					}
				}
				
				//$('.alpaca-wizard .alpaca-wizard-nav').find('nav').find('li.active.visited').data()
				
				var li = $('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li.active.visited');
				var step = li.data('alpacaWizardStepIndex') + 1;
				setProperty(view, 'wizard.bindings', itemKey, step);
				top.wizardConfigs.bindings[itemKey] = step;
			}
			/* END FD EDIT */
			
            regenerate(top, view, function(){
                //console.log('regenerate', top.wizardConfigs);
                if(top.wizardConfigs){
                    let opt = JSON.parse(editor2.getValue());
                    rearrangeFields(opt);
                    editor2.setValue(JSON.stringify(opt, null, "    "));
                    editor2.clearSelection();
                }
            });
        });
    };

    var assembleSchema = function(field, schema)
    {
        // copy any properties from this field's schema into our schema object
        for (var k in field.schema)
        {
            if (field.schema.hasOwnProperty(k) && typeof(field.schema[k]) !== "function")
            {
                schema[k] = field.schema[k];
            }
        }
        
        if(field.options.type === 'checkbox' && field.options.multiple){
        	schema.type = 'array';
        } else {
        	// a few that we handle by hand
            schema.type = field.getType();
        }
        // reset properties, we handle that one at a time
        delete schema.properties;
        schema.properties = {};
        if (field.children)
        {
            for (var i = 0; i < field.children.length; i++)
            {
                var childField = field.children[i];
                var propertyId = childField.propertyId;

                schema.properties[propertyId] = {};
                assembleSchema(childField, schema.properties[propertyId]);
            }
        }
    };

    var assembleOptions = function(field, options)
    {
        // copy any properties from this field's options into our options object
        for (var k in field.options)
        {
            if (field.options.hasOwnProperty(k) && typeof(field.options[k]) !== "function")
            {
                options[k] = field.options[k];
            }
        }
        // a few that we handle by hand
        options.type = field.getFieldType();
        // reset fields, we handle that one at a time
        delete options.fields;
        options.fields = {};
        if (field.children)
        {
            for (var i = 0; i < field.children.length; i++)
            {
                var childField = field.children[i];
                var propertyId = childField.propertyId;

                options.fields[propertyId] = {};
                assembleOptions(childField, options.fields[propertyId]);
            }
        }
    };

    var findTop = function(field)
    {
        // now get the top control
        var top = field;
        while (top.parent)
        {
            top = top.parent;
        }

        return top;
    };
	
	var exists = function(o) 
	{
		if (o != null && typeof o !== 'undefined') {
			return true;
		}
		return false;
	};

    var regenerate = function(top, _view, callback)
    {
        // walk the control tree and re-assemble the schema, options + data
        var _schema = {};
        assembleSchema(top, _schema);
        var _options = {}; 
        assembleOptions(top, _options);
		
        // data is easy
        var _data = top.getValue();
        if (!_data) {
            _data = {};
        }

        //console.log('Storing the magic view', _view);
        if(_view) {
        	view = _view;
        } else {
        	view = {};
        }
		
		// START FD EDIT
		if ( exists(_options.view) && exists(_options.view.layout) && exists(_options.view.layout.bindings) &&
			 exists(view.layout) && exists(view.layout.bindings) ) {
			if (!$.isEmptyObject(view.layout.bindings)) {
				_options.view.layout.bindings = view.layout.bindings;
			}

			if (exists(_options.view.id)) {
				delete _options.view.id;
			}
			if (exists(view.id)) {
				delete view.id;
			}
		}
		// END FD EDIT

        editor1.setValue(JSON.stringify(_schema, null, "    "));
        editor2.setValue(JSON.stringify(_options, null, "    "));
        editor3.setValue(JSON.stringify(_data, null, "    "));
        editor5.setValue(JSON.stringify(view, null, "    "));

        setModelloForm({schema: _schema, options: _options, data: _data, view: view});

        setTimeout(function() {
        	refresh();
			if (typeof callback === 'function' && callback != null) {
				callback();
			}
        }, 100);
    };
	
	var rearrangeFields = function(options){
		var count = 1;
		for(var key in options.fields) {
			options.fields[key].order = count;
			count++;
		}
		return options;
	}

    var removeField = function(alpacaId)
    {
        var field = Alpaca.fieldInstances[alpacaId];

        var parentField = field.parent;
  
		if(view.wizard != undefined && view.wizard.bindings != undefined){
			//var currentStep = $('.alpaca-wizard .alpaca-wizard-nav').find('nav').find('li.active.visited').data('alpacaWizardStepIndex')+1;
			var li = $('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li.active.visited');
			var currentStep = li.data('alpacaWizardStepIndex') + 1;
			var countFields = 0;
			for(var key in view.wizard.bindings){
					if(view.wizard.bindings[key] == currentStep){
						countFields++;
					}
			}
			if(countFields<=1){
				 alert('Attenzione!\nOgni step deve contenere almeno un elmento')
 				 return;
			}
		}
 

        parentField.removeItem(field.propertyId, function() {
            var top = findTop(field);
            
            //Remove from the view
            if(view && view.layout && view.layout.bindings && view.layout.bindings[field.propertyId]){
            	delete view.layout.bindings[field.propertyId];
            }
		
			/* START FD EDIT */
			if(view && view.wizard && view.wizard.bindings && view.wizard.bindings[field.propertyId]){
				var li = $('.alpaca-wizard .alpaca-wizard-nav:visible').find('nav').find('li.active.visited');
				var step = li.data('alpacaWizardStepIndex') + 1;
				delete view.wizard.bindings[field.propertyId];
				delete top.wizardConfigs.bindings[field.propertyId]; 
			}
			/* END FD EDIT */

			delete schema.properties[field.propertyId];
			delete options.fields[field.propertyId];
              
            regenerate(top, view,function(){
                if(top.wizardConfigs){
                    let opt = JSON.parse(editor2.getValue());
                    rearrangeFields(opt);
                    editor2.setValue(JSON.stringify(opt, null, "    "));
                    editor2.clearSelection();
                }
            });
        });
    };

    $(".tab-item-designer").click();


    // load button
    $(".load-button").off().click(function() {

        if (!localStorage)
        {
            alert("Your browser must support HTML5 local storage in order to use this feature");
            return;
        }

        var configString = localStorage.getItem("alpacaDesignerConfig");
        if (!configString)
        {
            return;
        }

        try
        {
            var config = JSON.parse(configString);
            if (!config.schema) {
                config.schema = {};
            }
            if (!config.options) {
                config.options = {};
            }
            if (!config.data) {
                config.data = {};
            }
            if (!config.view) {
                config.view = {};
            }

            editor1.setValue(JSON.stringify(config.schema, null, "    "));
            editor2.setValue(JSON.stringify(config.options, null, "    "));
            editor3.setValue(JSON.stringify(config.data, null, "    "));
            editor5.setValue(JSON.stringify(config.view, null, "    "));

            //alert("Your form was loaded from HTML5 local storage");
        }
        catch (e)
        {
            // bad value
        }

    });

    // save button
    $(".save-button").off().click(function() {

        if (!localStorage)
        {
            alert("Your browser must support HTML5 local storage in order to use this feature");
            return;
        }

        var config = {};
        if (schema)
        {
            config.schema = schema;
        }
        if (options)
        {
            config.options = options;
        }
        if (data)
        {
            config.data = data;
        }
        
        if (view)
        {
            config.view = view;
        }
        var configString = JSON.stringify(config);

        localStorage.setItem("alpacaDesignerConfig", configString);

        //alert("Your form was saved in HTML5 local storage");
    });
};


/**
 * Reset the attachment form.
 */
var resetAttachmentForm = function(){
	$('.attachment-form')[0].reset();
	$('#attachment-id').val('');
	$('[name="fileName"]').val('')
};

/**
 * Show the attachment form.
 */
var showAttachmentForm = function(){
	$('.add-attachment').addClass('hidden');
	$('.attachment-form').removeClass('hidden');
};

/**
 * Add a field to the form.
 * @param field The name of the field to add.
 * @param index The index of the field to add.
 * @param value The value of the field to add.
 */
var addFieldToForm = function(field, index, value){
	if(value){
		$('<input />').attr('type', 'hidden')
			.attr('name', 'definizioneAllegati[' + index + '].'  + field)
			.attr('value', value)
			.appendTo('#form-form');
	}
};

/**
 * Hide the attachment form.
 */
var hideAttachmentForm = function(){
	$('.add-attachment').removeClass('hidden');
	$('.attachment-form').addClass('hidden');
};


$(document).ready(function() {

    // wait a bit to allow ACE to load
    setTimeout(function() {
        setup(s, o, v, d);
    }, 200);
    
    //The index of the attachment edited
    var attachmentIndex = -1;
    
    //Load attachments tab content
    $('.add-attachment').on('click', function(){
    	resetAttachmentForm();
    	showAttachmentForm();
    	attachmentIndex = -1;
    });
    
    
    //On form submit (add/edit)
    $('.attachment-form').on('submit', function(event){
    	event.preventDefault();
    	
    	//Validate the data
    	var attachmentId = $('#attachment-id').val();
    	var attachmentName = $('#attachment-name').val();
    	var attachmentMandatory = $('#attachment-mandatory').is(':checked');
    	var attachmentFiletype = $('#attachment-filetype').val();
    	var attachmentCodetypes = $('#attachment-codetype').val();
    	var attachmentFile = $('#attachment-file').val();
    	var attachmentFileName = $('[name="fileName"]').val();
    	
    	console.log('attachmentIndex', attachmentIndex);
    	console.log('attachmentCodetypes', attachmentCodetypes);
    	
    	var $trToAdd = $('<tr>')
	    	.append($('<td>')
	    		.text(attachmentId)
	    	)
	        .append($('<td>')
	        	.text(attachmentName)
	        )
	        .append($('<td>')
	        	.text(attachmentMandatory)
	        )
	        .append($('<td>')
	        	.text(attachmentFiletype)
	        )
	        .append($('<td>')
	        		.text(attachmentCodetypes)
	        )
	        .append($('<td>')
	        	//.data('attachmentFileName', attachmentFileName)
	        	.text(attachmentFileName)
	        )
	        .append($('<td>')
	        	.append($('<button>')
	        			.addClass('btn btn-default delete-attachment')
	        			.attr('type', 'button')
	        			.attr('aria-label', 'Elimina')
	        			.append($('<span>')
	    					.addClass('glyphicon glyphicon-remove')
	            			.attr('aria-hidden', 'true')
	            		)
	        	)
	        	.append($('<button>')
	        			.addClass('btn btn-default edit-attachment')
	        			.attr('type', 'button')
	        			.attr('aria-label', 'Modifica')
	        			.append($('<span>')
	    					.addClass('glyphicon glyphicon-edit')
	            			.attr('aria-hidden', 'true')
	            		)
	        	)
	        );
    	
    	if(attachmentIndex != -1){
    		$tr = $('.attachment-tbody tr').eq(attachmentIndex);
    		var nextAll = $tr.nextAll();
    		$tr.remove();
    		
    		var trs = $('.attachment-tbody tr');
    		
    		//Check if there are attachments after the edited one
        	if(nextAll.length > 0){
        		var $trs = $('.attachment-tbody tr');
        		$tr = $trs.eq(attachmentIndex);
        		$tr.before($trToAdd);
        	} else {
        		$('.attachment-tbody')
    				.append($trToAdd);
        	}
    	} else {
    		$('.attachment-tbody')
    			.append($trToAdd);
    	}
    	
    	resetAttachmentForm();
    	hideAttachmentForm();
    	attachmentIndex = -1;
    });
    
    //Edit attachment event
    $('.attachment-tbody').on('click', '.edit-attachment', function(){
    	console.log('Edit attachment');
    	var $this = $(this);
    	var $tr = $this.closest('tr');
    	attachmentIndex = $('.attachment-tbody tr').index($tr);
    	
    	//Populate the fields with the content of the table
    	var $tds = $tr.find('td');
    	
    	$('#attachment-id').val($tds.eq(0).text());
    	$('#attachment-name').val($tds.eq(1).text());
    	$('#attachment-mandatory').prop('checked', $tds.eq(2).text());
    	var fileTypes = $tds.eq(3).text();
    	$('#attachment-filetype').val(fileTypes.split(','));
    	var documentTypes = $tds.eq(4).text();
    	$('#attachment-codetype').val(documentTypes.split(','));
    	var fileName = $tds.eq(5).text();
    	$('[name="fileName"]').val(fileName);
    	$("#modello-container").toggleClass('hidden', fileName === '');
    	
    	showAttachmentForm();
    });
    
    //Delete attachment event
    $('.attachment-tbody').on('click', '.delete-attachment', function(){
    	var $this = $(this);
    	$this.parent().parent().remove();
    });
    
    
    //Form submit
    $('#form-form').submit(function(){
    	console.log('on submit :D');
    	var $form = $(this);
    	$('.attachment-tbody tr').each(function(index, tr){
    		var $tr = $(tr);
    		var $tds = $tr.find('td');
        	
        	//Attach attachments to the form
    		addFieldToForm('id', index, $tds.eq(0).text());
        	addFieldToForm('denominazione', index, $tds.eq(1).text());
        	addFieldToForm('tipiFileAmmessi', index, $tds.eq(3).text().split(','));
        	addFieldToForm('codiciTipologiaDocumento', index, $tds.eq(4).text().split(','));
        	var fileName = $tds.eq(5).text();
        	if(fileName.trim() === ''){
        		fileName = '';
        	}
        	addFieldToForm('fileName', index, fileName);
        	addFieldToForm('obbligatorio', index, $tds.eq(2).text());
    	});
    	
    	return true;
    });
    
});
