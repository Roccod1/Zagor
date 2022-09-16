var gumStream,recorder,input,encodingType;!function(e){var o=function(){for(var e=arguments[0],n=[].slice.call(arguments,1),i=0;i<n.length;++i){var t=n[i];for(key in t){var r=t[key];e[key]="object"==typeof r?o("object"==typeof e[key]?e[key]:{},r):r}}return e},n={wav:"WebAudioRecorderWav.min.js",ogg:"WebAudioRecorderOgg.min.js",mp3:"WebAudioRecorderMp3.min.js"},i={workerDir:"/",numChannels:2,encoding:"wav",options:{timeLimit:300,encodeAfterRecord:!1,progressInterval:1e3,bufferSize:void 0,wav:{mimeType:"audio/wav"},ogg:{mimeType:"audio/ogg",quality:.5},mp3:{mimeType:"audio/mpeg",bitRate:160}}},t=function(e,n){o(this,i,n||{}),this.context=e.context,null==this.context.createScriptProcessor&&(this.context.createScriptProcessor=this.context.createJavaScriptNode),this.input=this.context.createGain(),e.connect(this.input),this.buffer=[],this.initWorker()};o(t.prototype,{isRecording:function(){return null!=this.processor},setEncoding:function(e){this.isRecording()?this.error("setEncoding: cannot set encoding during recording"):this.encoding!==e&&(this.encoding=e,this.initWorker())},setOptions:function(e){this.isRecording()?this.error("setOptions: cannot set options during recording"):(o(this.options,e),this.worker.postMessage({command:"options",options:this.options}))},startRecording:function(){if(this.isRecording())this.error("startRecording: previous recording is running");else{var e=this.numChannels,o=this.buffer,n=this.worker;this.processor=this.context.createScriptProcessor(this.options.bufferSize,this.numChannels,this.numChannels),this.input.connect(this.processor),this.processor.connect(this.context.destination),this.processor.onaudioprocess=function(i){for(var t=0;t<e;++t)o[t]=i.inputBuffer.getChannelData(t);n.postMessage({command:"record",buffer:o})},this.worker.postMessage({command:"start",bufferSize:this.processor.bufferSize}),this.startTime=Date.now()}},recordingTime:function(){return this.isRecording()?.001*(Date.now()-this.startTime):null},cancelRecording:function(){this.isRecording()?(this.input.disconnect(),this.processor.disconnect(),delete this.processor,this.worker.postMessage({command:"cancel"})):this.error("cancelRecording: no recording is running")},finishRecording:function(){this.isRecording()?(this.input.disconnect(),this.processor.disconnect(),delete this.processor,this.worker.postMessage({command:"finish"})):this.error("finishRecording: no recording is running")},cancelEncoding:function(){this.options.encodeAfterRecord?this.isRecording()?this.error("cancelEncoding: recording is not finished"):(this.onEncodingCanceled(this),this.initWorker()):this.error("cancelEncoding: invalid method call")},initWorker:function(){null!=this.worker&&this.worker.terminate(),this.onEncoderLoading(this,this.encoding),this.worker=new Worker(this.workerDir+n[this.encoding]);var e=this;this.worker.onmessage=function(o){var n=o.data;switch(n.command){case"loaded":e.onEncoderLoaded(e,e.encoding);break;case"timeout":e.onTimeout(e);break;case"progress":e.onEncodingProgress(e,n.progress);break;case"complete":e.onComplete(e,n.blob);break;case"error":e.error(n.message)}},this.worker.postMessage({command:"init",config:{sampleRate:this.context.sampleRate,numChannels:this.numChannels},options:this.options})},error:function(e){this.onError(this,"WebAudioRecorder.min.js:"+e)},onEncoderLoading:function(e,o){},onEncoderLoaded:function(e,o){},onTimeout:function(e){e.finishRecording()},onEncodingProgress:function(e,o){},onEncodingCanceled:function(e){},onComplete:function(e,o){e.onError(e,"WebAudioRecorder.min.js: You must override .onComplete event")},onError:function(e,o){console.log(o)}}),e.WebAudioRecorder=t}(window),URL=window.URL||window.webkitURL;var audioContext,encodeAfterRecord=!0,AudioContext=window.AudioContext||window.webkitAudioContext,encodingTypeSelect="wav",baseLocation="";function setBaseLocation(e){this.baseLocation=e,console.log("setBaseLocation:"+e)}function startRecording(e,o,n){console.log("startRecording() called uid: "+e);navigator.mediaDevices.getUserMedia({audio:!0,video:!1}).then(function(i){console.log("getUserMedia() success, stream created, initializing WebAudioRecorder..."+o),audioContext=new AudioContext,gumStream=i,console.log("gumStream"+gumStream),input=audioContext.createMediaStreamSource(i),console.log("input"+input),encodingType=encodingTypeSelect,console.log("encodingType"+encodingType),(recorder=new WebAudioRecorder(input,{workerDir:this.baseLocation+"/assets/js/",encoding:encodingType,numChannels:2,onEncoderLoading:function(e,o){console.log("Loading "+o+" encoder...")},onEncoderLoaded:function(e,o){console.log(o+" encoder loaded")},onEncodingProgress:function(e,o){console.log("progress "+o)}})).onComplete=function(i,t){const r=o+"__STEREO."+i.encoding;console.log("Encoding complete : filename: "+r),sendaudio(t,e,r,function(i){console.log("callback sendaudio"+e),n(o,r)})},recorder.setOptions({timeLimit:120,encodeAfterRecord:encodeAfterRecord,ogg:{quality:.5},mp3:{bitRate:160}}),recorder.startRecording(),console.log("Recording started")}).catch(function(e){console.log("error: "+e)})}function stopRecording(){console.log("stopRecording() called"),gumStream.getAudioTracks()[0].stop(),recorder.finishRecording(),console.log("Recording stopped")}function sendaudio(e,o,n,i){let t;t=o.toLowerCase().startsWith("http")?o:this.baseLocation+o;var r=new XMLHttpRequest;r.onreadystatechange=function(){r.readyState===XMLHttpRequest.DONE&&200===r.status&&i(r.responseText)};var s=new FormData;s.append("audio_data",e,n),r.open("POST",t+"/sendaudiomessage",!0),r.send(s)}