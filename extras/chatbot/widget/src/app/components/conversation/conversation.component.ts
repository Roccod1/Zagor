// tslint:disable-next-line:max-line-length
import { NgZone, HostListener, ElementRef, Component, OnInit, OnChanges, AfterViewInit, Input, Output, ViewChild, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { Observable} from 'rxjs/Rx';
import { timer } from 'rxjs/observable/timer';


import { Globals } from '../../utils/globals';

// import { MessagingService } from '../../providers/messaging.service';
import { GenericMessagingService } from '../../providers/generic-messaging.service';
import { ConversationsService } from '../../providers/conversations.service';
import { AppConfigService } from '../../providers/app-config.service';
import { AudioRecorderService } from '../../providers/audio-recorder.service';

import {
  CHANNEL_TYPE_DIRECT, CHANNEL_TYPE_GROUP, TYPE_MSG_TEXT, TYPE_MSG_AUDIO, TYPE_MSG_BUTTON,
  MSG_STATUS_SENT, MSG_STATUS_RETURN_RECEIPT, MSG_STATUS_SENT_SERVER,
  TYPE_MSG_IMAGE, MAX_WIDTH_IMAGES, IMG_PROFILE_BOT, IMG_PROFILE_DEFAULT, TYPE_MSG_FILE
} from '../../utils/constants';
import { UploadService } from '../../providers/upload.service';
import { ContactService } from '../../providers/contact.service';
import { AgentAvailabilityService } from '../../providers/agent-availability.service';
import { StarRatingWidgetService } from '../../components/star-rating-widget/star-rating-widget.service';

// models
import { ConversationModel } from '../../../models/conversation';
import { MessageModel } from '../../../models/message';
import { UploadModel } from '../../../models/upload';

// utils
// tslint:disable-next-line:max-line-length
import { createGuid, fromNumberToTime, getImageUrlThumb, convertColorToRGBA, isPopupUrl, searchIndexInArrayForUid, replaceBr } from '../../utils/utils';


// Import the resized event model
import { ResizedEvent } from 'angular-resize-event/resized-event';

import {DomSanitizer} from '@angular/platform-browser';

import { AppComponent } from '../../app.component';
import { StorageService } from '../../providers/storage.service';
import { DepartmentModel } from '../../../models/department';

declare var startRecording: any;
declare var stopRecording: any;
declare var setBaseLocation: any;

declare var startSpeechToText: any;



@Component({
  selector: 'tiledeskwidget-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.scss'],
  // tslint:disable-next-line:use-host-property-decorator
  host: {'(window:resize)': 'onResize($event)'}
})
export class ConversationComponent implements OnInit, AfterViewInit, OnChanges {
  @ViewChild('scrollMe') private scrollMe: ElementRef; // l'ID del div da scrollare
  @ViewChild('afConversationComponent') private afConversationComponent: ElementRef; // l'ID del div da scrollare
  @ViewChild('audio_msg') private audioMessage: ElementRef;
  // @ViewChild('audio_send') private audioSend: ElementRef;

  // @HostListener('window:resize', ['$event'])
  // ========= begin:: Input/Output values
  @Output() eventClose = new EventEmitter();
  @Output() eventCloseWidget = new EventEmitter();
  @Input() recipientId: string; // uid conversazione ex: support-group-LOT8SLRhIqXtR1NO...
  @Input() elRoot: ElementRef;
  @Input() conversation: ConversationModel;
  @Input() isOpen: boolean;
  // @Input() senderId: string;    // uid utente ex: JHFFkYk2RBUn87LCWP2WZ546M7d2
  // @Input() departmentSelected: string;
  // ========= end:: Input/Output values

  // projectid: string;   // uid progetto passato come parametro getVariablesFromSettings o getVariablesFromAttributeHtml
  // channelType: string; // tipo di conversazione ( group / direct ) a seconda che recipientId contenga o meno 'group'
  writingMessage = '';    // messaggio sta scrivendo...
  isMenuShow = false;
  isScrolling = false;
  isRecording = false;
  timer = Observable.timer(1000, 1000);
  subTimer: Subscription;
  urlAudiorepo: String;

  // ========= begin:: gestione scroll view messaggi ======= //
  startScroll = true; // indica lo stato dello scroll: true/false -> è in movimento/ è fermo
  idDivScroll = 'c21-contentScroll'; // id div da scrollare #c21-contentScroll
  showButtonToBottom = false;
  NUM_BADGES = 0;
  audio: any;
  uidAudioPlayng: string;
  // ========= end:: gestione scroll view messaggi ======= //


  // ========= begin:: send image ======= //
  selectedFiles: FileList;
  isFilePendingToUpload: Boolean = false;
  arrayFilesLoad: Array<any>;
  isFileSelected: Boolean = false;
  // ========= end:: send image ========= //




  // text used within the html
  private LABEL_PLACEHOLDER: string;
  private API_URL: string;

  userEmail: string;
  userFullname: string;
  preChatForm = false;
  themeColor50: string;
  textInputTextArea: String;
  HEIGHT_DEFAULT = '22px';
  conversationWith: string;
  isPopupUrl = isPopupUrl;
  IMG_PROFILE_SUPPORT = 'https://user-images.githubusercontent.com/32448495/39111365-214552a0-46d5-11e8-9878-e5c804adfe6a.png';
  isNewConversation = true;
  // availableAgentsStatus = false; // indica quando è impostato lo stato degli agenti nel subscribe
  messages: Array<MessageModel>;
  recipient_fullname: String;

  // attributes: any;
  // GUEST_LABEL = '';

  CLIENT_BROWSER: string = navigator.userAgent;

  // devo inserirle nel globals
  subscriptions: Subscription[] = [];


  // ========= begin::agent availability
  // public areAgentsAvailableText: string;
  // public areAgentsAvailable: Boolean = false;
  // ========= end::agent availability


  // ========== begin:: set icon status message
  MSG_STATUS_SENT = MSG_STATUS_SENT;
  MSG_STATUS_SENT_SERVER = MSG_STATUS_SENT_SERVER;
  MSG_STATUS_RETURN_RECEIPT = MSG_STATUS_RETURN_RECEIPT;
  // ========== end:: icon status message

  lastMsg = false;
  isNwMsg = false;

  playMessageActived = true;

  

  isIE = /msie\s|trident\//i.test(window.navigator.userAgent);
  firstScroll = true;

  linky_options = {newWindow: true, replaceFn: function(match:any){
    let return_value : any;
    let currentDomain = window.location.hostname;
    switch( match.getType() ) {
      case 'url' :
        console.log( "url: ", match.getUrl() );
    
        var tag = match.buildTag();
        tag.setAttr( 'rel', 'nofollow' );
		if (match.getUrl().indexOf(currentDomain) >= 1){
        	tag.setAttr( 'target', '_PARENT' );
		}
		else {
        	tag.setAttr( 'target', '_BLANK' );
		}

        return_value = tag;
        break
       
      default:
        return_value = true;
        break
      }
      return return_value;
    }
  }

  constructor(
    public el: ElementRef,
    public g: Globals,
    private ngZone: NgZone,
    public messagingService: GenericMessagingService,
    public upSvc: UploadService,
    public contactService: ContactService,
    private agentAvailabilityService: AgentAvailabilityService,
    public starRatingWidgetService: StarRatingWidgetService,
    public sanitizer: DomSanitizer,
    public appComponent: AppComponent,
    public storageService: StorageService,
    public conversationsService: ConversationsService,
    public appConfigService: AppConfigService,
    public audioRecorderService: AudioRecorderService,
  ) {
    this.API_URL = this.appConfigService.getConfig().apiUrl;
    
    this.initAll();
    // this.soundMessage(); // SOLO UN TEST DA ELIMINARE!!!
  }

  ngOnInit() {
    // this.initAll();
    this.g.wdLog([' ---------------- 5: setAvailableAgentsStatus ---------------- ']);
    this.setAvailableAgentsStatus();


    this.g.wdLog([' ngOnInit: app-conversation ', this.g]);
    const that = this;
    this.isNwMsg = false;
    // set base location in audio.js
    setBaseLocation(this.g.baseLocation);

    this.ngZone.run(() => {
      //const objDiv = document.getElementById(that.idDivScroll);
      //objDiv.style.display = 'none';
      //that.scrollToBottom();
    });
    const subscriptionEndRenderMessage = this.appComponent.obsEndRenderMessage.subscribe(() => {
    // this.ngZone.run(() => {
    //   that.scrollToBottom();
    // });
    });
    this.subscriptions.push(subscriptionEndRenderMessage);
    this.setFocusOnId('chat21-main-message-context');
    // this.attributes = this.setAttributes();
    this.updateConversationBadge();
  }

  ngAfterViewInit() {
    this.g.wdLog([' --------ngAfterViewInit-------- ']);
    // console.log('attributes: ', this.g.attributes);
    this.startSpeechToText();
    setTimeout(() => {
      if (this.afConversationComponent) {
        this.afConversationComponent.nativeElement.focus();
      }
    }, 1000);

  }


  ngOnChanges() {
    // console.log('ngOnChanges');
    if (this.isOpen === true) {
      this.updateConversationBadge();
      //this.scrollToBottom(true);
    }
  }

  updateConversationBadge() {
    if (this.conversation) {
      this.conversationsService.updateIsNew(this.conversation);
      this.conversationsService.updateConversationBadge();
    }
  }


  /**
   * do per scontato che this.userId esiste!!!
   */
  initAll() {
    const themeColor = this.g.themeColor;
    this.themeColor50 = convertColorToRGBA(themeColor, 50);
    this.messages = [];

    this.g.wdLog([' ---------------- 2: setConversation ---------------------- ']);
    this.setConversation();

    this.g.wdLog([' ---------------- 3: connectConversation ---------------------- ']);
    this.connectConversation();

    this.g.wdLog([' ---------------- 4: initializeChatManager ------------------- ']);
    this.initializeChatManager();


    // this.g.wdLog([' ---------------- 5: setAvailableAgentsStatus ---------------- ']);
    // this.setAvailableAgentsStatus();

    this.g.setParameter('activeConversation', this.conversationWith);
    // this.checkListMessages();


    try {
      this.g.recipientFullname = this.g.customAttributes.recipient_fullname;
      this.urlAudiorepo = this.g.customAttributes.url_audiorepo;
      this.g.wdLog(['> this.urlAudiorepo: ', this.urlAudiorepo]);
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
    }
    // try {
    //   JSON.parse(this.g.customAttributes, (key, value) => {
    //     if (key === 'recipient_fullname') {
    //       this.g.recipientFullname = value;
    //     }
    //     if (key === 'url_audiorepo') {
    //       this.urlAudiorepo = value;
    //     }
    //   });
    // } catch (error) {
    //     console.log('> Error is handled attributes: ', error);
    // }
  }

  onResize(event) {
    // tslint:disable-next-line:no-unused-expression
    this.g.wdLog(['RESIZE ----------> ' + event.target.innerWidth]);
    setTimeout(() => {
      this.g.wdLog([' --------scrollToBottom XXXXXX-------- ']);
      this.scrollToBottom();
    }, 0);
  }

  /**
   * OLD: mi sottoscrivo al nodo /projects/' + projectId + '/users/availables
   * i dipartimenti e gli agenti disponibili sono già stati impostati nello step precedente
   * recuperati dal server (/widget) e settati in global
   * imposto il messaggio online/offline a seconda degli agenti disponibili
   * aggiungo il primo messaggio alla conversazione
   */
  private setAvailableAgentsStatus() {

    const departmentDefault: DepartmentModel =  this.g.departmentDefault;
    this.g.wdLog(['departmentDefault', departmentDefault]);
    this.g.wdLog(['messages1: ', this.g.online_msg, this.g.offline_msg]);
    if (!this.g.online_msg || this.g.online_msg === 'undefined' || this.g.online_msg === '') {
      this.g.online_msg = this.g.LABEL_FIRST_MSG;
    }
    if (!this.g.offline_msg || this.g.offline_msg === 'undefined' || this.g.offline_msg === '') {
      this.g.offline_msg = this.g.LABEL_FIRST_MSG_NO_AGENTS;
    }
    this.g.wdLog(['messages2: ', this.g.online_msg, this.g.offline_msg]);
    const availableAgentsForDep = this.g.availableAgents;

    if (availableAgentsForDep && availableAgentsForDep.length <= 0) {
      this.addFirstMessage(this.g.offline_msg);
      this.g.areAgentsAvailableText = this.g.AGENT_NOT_AVAILABLE;
    } else {
      this.addFirstMessage(this.g.online_msg);
      this.g.areAgentsAvailableText = this.g.AGENT_AVAILABLE;
    }

    if ( this.g.recipientId.includes('_bot') || this.g.recipientId.includes('bot_') ) {
      this.g.areAgentsAvailableText = '';
    }
    this.g.wdLog(['messages: ', this.g.online_msg, this.g.offline_msg]);

    // this.getAvailableAgentsForDepartment();

  }

    /**
   * mi sottoscrivo al nodo /departments/' + idDepartmentSelected + '/operators/';
   * per verificare se c'è un agent disponibile
   */
  // private getAvailableAgentsForDepartment() {
  //   const that = this;
  //   const projectid = this.g.projectid;
  //   const departmentSelectedId = this.g.attributes.departmentId;
  //   this.g.wdLog(['departmentSelectedId: ', departmentSelectedId, 'projectid: ', projectid]);

  //   this.agentAvailabilityService
  //   .getAvailableAgentsForDepartment(projectid, departmentSelectedId)
  //   .subscribe( (availableAgents) => {
  //     const availableAgentsForDep = availableAgents['available_agents'];
  //     if (availableAgentsForDep && availableAgentsForDep.length <= 0) {
  //       that.addFirstMessage(that.g.LABEL_FIRST_MSG_NO_AGENTS);
  //     } else {
  //       that.addFirstMessage(that.g.LABEL_FIRST_MSG);
  //     }
  //   }, (error) => {
  //     console.error('2 setOnlineStatus::setAvailableAgentsStatus', error);
  //   }, () => {
  //   });
  // }

  /**
   * mi sottoscrivo al nodo /projects/' + projectId + '/users/availables
   * per verificare se c'è un agent disponibile
   */
  // private setAvailableAgentsStatus() {
  //   const that = this;
  //   this.agentAvailabilityService
  //   .getAvailableAgents(this.g.projectid)
  //   .subscribe( (availableAgents) => {
  //     that.g.wdLog(['availableAgents->', availableAgents]);
  //     if (availableAgents.length <= 0) {
  //       that.areAgentsAvailable = false;
  //       that.areAgentsAvailableText = that.g.AGENT_NOT_AVAILABLE;
  //       that.addFirstMessage(that.g.LABEL_FIRST_MSG_NO_AGENTS);
  //     } else {
  //       that.areAgentsAvailable = true;
  //       that.areAgentsAvailableText = that.g.AGENT_AVAILABLE;
  //       // add first message
  //       this.g.availableAgents = availableAgents;
  //       that.addFirstMessage(that.g.LABEL_FIRST_MSG);
  //     }
  //     that.availableAgentsStatus = true;
  //     that.g.wdLog(['AppComponent::setAvailableAgentsStatus::areAgentsAvailable:', that.areAgentsAvailableText]);
  //   }, (error) => {
  //     console.error('setOnlineStatus::setAvailableAgentsStatus', error);
  //   }, () => {
  //   });
  // }

  addFirstMessage(text) {
    if (1 === 1) {
      try {
        this.g.start_hidden_message = this.g.customAttributes.start_hidden_message;
      } catch (error) {
        // this.g.wdLog(['> Error is: ', error]);
      }
      setTimeout(() => {
        // if (this.messages.length === 0) {
          this.sendMessage(this.g.start_hidden_message, TYPE_MSG_TEXT);
        // }
      }, 1000);
    } else {
      const lang = this.g.lang;
      const channelType = this.g.channelType;
      const projectid = this.g.projectid;
      text = replaceBr(text);
      const timestampSendingMessage = new Date('01/01/2000').getTime();
      const msg = new MessageModel(
        '000000',
        lang,
        this.conversationWith,
        'Bot',
        '', // sender
        'Bot', // sender fullname
        '200', // status
        '', // metadata
        text,
        timestampSendingMessage,
        '',
        TYPE_MSG_TEXT,
        '', // attributes
        channelType,
        projectid
      );
      this.g.wdLog(['addFirstMessage ----------> ' + text]);
      this.messages.unshift(msg);
    }
  }

  /**
    * this.g.recipientId:
    * this.g.senderId:
    * this.g.channelType:
    * this.g.tenant
    * 1 - setto channelTypeTEMP ( group / direct )
    *    a seconda che recipientId contenga o meno 'group'
    * 2 - setto conversationWith
    * 2 - setto conversationWith
    *    uguale a recipientId se esiste
    *    uguale al senderId nel this.storageService se esiste
    *    generateUidConversation
  */
  private setConversation() {
    const recipientId = this.g.recipientId;
    const channelType = this.g.channelType;
    this.g.wdLog(['setConversation recipientId: ', recipientId, channelType]);
    if ( !recipientId ) { this.g.setParameter('recipientId', this.setRecipientId()); }
    if ( !channelType ) { this.g.setParameter('channelType', this.setChannelType()); }
    this.conversationWith = recipientId as string;
  }

  /**
   *
   */
  private setRecipientId() {
    let recipientIdTEMP: string;
    const senderId = this.g.senderId;
    recipientIdTEMP = this.storageService.getItem(senderId);
    if (!recipientIdTEMP) {
      // questa deve essere sincrona!!!!
      recipientIdTEMP = this.messagingService.generateUidConversation(senderId);
    }
    return recipientIdTEMP;
  }

  /**
   *
   */
  private setChannelType() {
    let channelTypeTEMP = CHANNEL_TYPE_GROUP;
    const projectid = this.g.projectid;
    if (this.recipientId && this.recipientId.indexOf('group') !== -1) {
      channelTypeTEMP = CHANNEL_TYPE_GROUP;
    } else if (!projectid) {
      channelTypeTEMP = CHANNEL_TYPE_DIRECT;
    }
    return channelTypeTEMP;
  }


  /**
   *  1 - init messagingService
   *  2 - connect: recupero ultimi X messaggi
   */
  private connectConversation() {
      const senderId = this.g.senderId;
      const tenant = this.g.tenant;
      const channelType = this.g.channelType;

      this.messagingService.initialize( senderId, tenant, channelType );
      this.upSvc.initialize(senderId, tenant, this.conversationWith);
      // this.contactService.initialize(senderId, tenant, this.conversationWith);
      this.messagingService.connect( this.conversationWith );
      this.messages = this.messagingService.messages;
      //this.scrollToBottomStart();
      // this.messages.concat(this.messagingService.messages);
      // this.messagingService.resetBadge(this.conversationWith);
  }


  /**
   * inizializzo variabili
   * effettuo il login anonimo su firebase
   * se il login è andato a buon fine recupero id utente
   */
  initializeChatManager() {
    this.arrayFilesLoad = [];
    this.setSubscriptions();
    this.checkWritingMessages();
  }

  /**
   *
   */
  // setAttributes(): any {
  //   if (!this.g.attributes || this.g.attributes === 'undefined') {
  //     let attributes: any = JSON.parse(this.storageService.getItem('attributes'));
  //     if (!attributes || attributes === 'undefined') {
  //       attributes = {
  //         client: this.CLIENT_BROWSER,
  //         sourcePage: location.href,
  //         projectId: this.g.projectid
  //       };
  //     }
  //     if (this.g.userEmail) {
  //       attributes['userEmail'] = this.g.userEmail;
  //     }
  //     if (this.g.userFullname) {
  //       attributes['userFullname'] = this.g.userFullname;
  //     }
  //     if (this.g.senderId) {
  //       attributes['requester_id'] = this.g.senderId;
  //     }
  //     that.g.wdLog(['>>>>>>>>>>>>>> setAttributes: ', JSON.stringify(attributes)]);
  //     this.storageService.setItem('attributes', JSON.stringify(attributes));
  //     return attributes;
  //   }
  //   return this.g.attributes;
  // }

  /**
   * imposto le sottoscrizioni
   * 1 - conversazione chiusa (CHAT CHIUSA)
   * 2 - nuovo messaggio
   */
  setSubscriptions() {
    const that = this;
    this.starRatingWidgetService.setOsservable(false);
    // CHIUSURA CONVERSAZIONE (ELIMINAZIONE UTENTE DAL GRUPPO)
    // tslint:disable-next-line:max-line-length
    that.g.wdLog(['setSubscriptions!!!! StartRating', this.starRatingWidgetService.obsCloseConversation, this.starRatingWidgetService]);
    const subscriptionisOpenStartRating: Subscription = this.starRatingWidgetService.obsCloseConversation
    .subscribe(isOpenStartRating => {
      that.g.setParameter('isOpenStartRating', isOpenStartRating);
      if (isOpenStartRating === false) {
          that.g.wdLog(['CHIUDOOOOO!!!! StartRating']);
      } else if (isOpenStartRating === true) {
          that.g.wdLog(['APROOOOOOOO!!!! StartRating']);
      }
    });
    this.subscriptions.push(subscriptionisOpenStartRating);

    // NUOVO MESSAGGIO!!
    /**
     * se:          non sto già scrollando oppure il messaggio l'ho inviato io -> scrollToBottom
     * altrimenti:  se esiste scrollMe (div da scrollare) verifico la posizione
     *  se:         sono alla fine della pagina scrollo alla fine
     *  altrimenti: aumento il badge
     */
    const obsAddedMessage: Subscription = this.messagingService.obsAdded
    .subscribe(newMessage => {
      that.g.wdLog(['Subscription NEW MSG', newMessage]);
      // aggingo writingMessage quando invio un nw msg e lo elimino quando ricevo una risposta
      that.writingMessage = '';
      const senderId = that.g.senderId;
      if ( that.startScroll || newMessage.sender === senderId) {
        that.g.wdLog(['1-------', that.isNwMsg]);
        that.scrollToBottom(true);
        setTimeout(function () {
          // if (that.isNwMsg === true) {
          //   that.playAudioMessage(newMessage);
          // }
        }, 200);
      } else if (that.scrollMe) {
        const divScrollMe = that.scrollMe.nativeElement;
        const checkContentScrollPosition = that.checkContentScrollPosition(divScrollMe);
        if (checkContentScrollPosition) {
          that.g.wdLog(['2-------', that.isNwMsg]);
          // https://developer.mozilla.org/it/docs/Web/API/Element/scrollHeight
          that.scrollToBottom();
          setTimeout(function () {
            if (that.isNwMsg === true) {
              that.playAudioMessage(newMessage);
            }
          }, 200);
        } else {
          that.g.wdLog(['3-------']);
          that.scrollToBottom();
          setTimeout(function () {
            if (that.isNwMsg === true) {
              that.playAudioMessage(newMessage);
            }
          }, 200);
          // that.NUM_BADGES++;
          // that.soundMessage();
        }
      }


    });

    this.subscriptions.push(obsAddedMessage);
  }

  playAudioMessage(newMessage) {
    /**
     * imposto il focus sull'ultimo msg ricevuto se c'è testo per l'accessibilità
     * cioè permetto l'autolettura dell'ultimo messaggio!!!
     */
    // && that.lastMsg
    // that.g.wdLog(['4------- newMessage: ' + newMessage + ' that.lastMsg: ' + that.lastMsg]);
    this.g.wdLog(['1------- playAudioMessage', newMessage]);
    const that = this;
    // that.scrollToBottom();
    this.g.wdLog(['---------scrollo sino alla fine prima di cambiare il focus e attivare l autoplay']);
    if (newMessage && newMessage.text ) {
      this.g.wdLog(['4------- controllo focus']);
      setTimeout(function () {
        let messaggio = '';
        const testFocus = ((document.getElementById('testFocus') as HTMLInputElement));
        const altTextArea = ((document.getElementById('altTextArea') as HTMLInputElement));
        if (altTextArea && testFocus) {
          setTimeout(function () {
            if (newMessage.sender !== that.g.senderId) {
              messaggio += 'messaggio ricevuto da operatore: ' + that.g.recipientFullname;
              altTextArea.innerHTML =  messaggio + ',  testo messaggio: ' + newMessage.text;
              //testFocus.focus(); //dopo il focus c'è tutta la view si sposta in su di qualche px
              //that.playPausaAudioMsg(newMessage.uid);
              that.g.wdLog([' --------setTimeout-------- 6']);
            }
          }, 1000);
        }
      }, 1000);
    }
  }

 
  // autoplay() {
  //    // TEST TEST TEST
  //    try {
  //       const audioPlayer = this.audioSend.nativeElement;
  //       console.log('this.audioSend.nativeElement:: ' + this.audioSend.nativeElement);

  //       audioPlayer.pause();
  //       setTimeout(() => {
  //         audioPlayer.play();
  //         audioPlayer.currentTime = 0;
  //       }, 1000);
  //     } catch (e) {
  //       console.log(e);
  //     }
  // }

  /**
   *
   */
  private checkWritingMessages() {
    const that = this;
    const tenant = this.g.tenant;
    try {
      const messagesRef = this.messagingService.checkWritingMessages(tenant, this.conversationWith);
      if (messagesRef) {
        messagesRef.on('value', function (writing) {
          if (writing.exists()) {
              that.writingMessage = that.g.LABEL_WRITING;
          } else {
              that.writingMessage = '';
          }
        });
      }
    } catch (e) {
      console.error('Error checkWritingMessages ', e);
    }
  }


  /**
   *
   */
  checkListMessages() {
    // const that = this;
    // this.messagingService.checkListMessages(this.conversationWith)
    // .then(function (snapshot) {
    //       that.g.wdLog(['checkListMessages: ', snapshot);
    //     if (snapshot.exists()) {
    //         that.isNewConversation = false;
    //           that.g.wdLog(['IS NOT NEW CONVERSATION ?', that.isNewConversation);
    //         setTimeout(function () {
    //             if (that.messages.length === 0) {
    //                 that.isNewConversation = true;
    //             }
    //         }, 2000);
    //         // that.isLogged = true;
    //         //   that.g.wdLog(['IS_LOGGED', 'AppComponent:createConversation:snapshot.exists-if', that.isLogged);
    //         // that.setFocusOnId('chat21-main-message-context');
    //     } else {
    //         /**
    //          * se è una nuova conversazione:
    //          * verifico se departmentId e projectid sono settati
    //          * focus sul input messaggio
    //          */
    //         that.isNewConversation = true;
    //           that.g.wdLog(['IS NEW CONVERSATION ?', that.isNewConversation);
    //         //if (that.g.projectid && !that.g.attributes.departmentId) {
    //             // that.isLogged = false;
    //             //   that.g.wdLog(["IS_LOGGED", "AppComponent:createConversation:snapshot.exists-else-!department", that.isLogged);
    //             //that.getMongDbDepartments();
    //         //} else {
    //             that.setFocusOnId('chat21-main-message-context');
    //             //that.isLogged = true;
    //             //  that.g.wdLog(['IS_LOGGED', 'AppComponent:createConversation:snapshot.exists-else-department', that.isLogged);
    //         //}
    //     }

    //     setTimeout(function () {
    //           that.g.wdLog(['GET listMessages: ', that.conversationWith);
    //         that.messagingService.listMessages(that.conversationWith);
    //     }, 500);


    // }).catch(function (error) {
    //     console.error('checkListMessages ERROR: ', error);
    // });
  }

  /** controllo se è l'ultimo messaggio appena ricevuto
   * imposto autoplay
   */
  isAutoplay(last: boolean) {
    if (last === true && this.isNwMsg === true) {
      if (this.g.autoplay_activated && this.g.autoplay_activated === true) {
        return true;
      }
    }
    return false;
  }
  //vetereg 2021-11-30
  //muto l'audio in riproduzione
  toggleAutoplay() {
    if (this.g.autoplay_activated === true) {
      this.g.autoplay_activated = false;
      this.muteAudioMsg();
    } else {
      this.g.autoplay_activated = true;
      this.muteAudioMsg();
    }
    this.g.setParameter('autoplay_activated', this.g.autoplay_activated);
  }


  setFocusOnId(id) {
    setTimeout(function () {
        const textarea = document.getElementById(id);
        if (textarea) {
            //   that.g.wdLog(['1--------> FOCUSSSSSS : ', textarea);
            textarea.setAttribute('value', ' ');
            textarea.focus();
        }
    }, 500);
  }




/**
     * quando premo un tasto richiamo questo metodo che:
     * verifica se è stato premuto 'invio'
     * se si azzera testo
     * imposta altezza campo come min di default
     * leva il focus e lo reimposta dopo pochi attimi
     * (questa è una toppa per mantenere il focus e eliminare il br dell'invio!!!)
     * invio messaggio
     * @param event
     */
    onkeypress(event) {
      const keyCode = event.which || event.keyCode;
      this.textInputTextArea = ((document.getElementById('chat21-main-message-context') as HTMLInputElement).value);
      // this.g.wdLog(['onkeypress **************', this.textInputTextArea]);
      if (keyCode === 13) {
          this.performSendingMessage();
      } else if (keyCode === 9) {
        event.preventDefault();
      }
  }

  private performSendingMessage() {
      // const msg = document.getElementsByClassName('f21textarea')[0];
      let msg = ((document.getElementById('chat21-main-message-context') as HTMLInputElement).value);
      if (msg && msg.trim() !== '') {
          //   that.g.wdLog(['sendMessage -> ', this.textInputTextArea);
          // this.resizeInputField();
          // this.messagingService.sendMessage(msg, TYPE_MSG_TEXT);
          // this.setDepartment();
          msg = replaceBr(msg);
          this.sendMessage(msg, TYPE_MSG_TEXT);
          //this.restoreTextArea();
          //this.scrollToBottom();
      }
      // (<HTMLInputElement>document.getElementById('chat21-main-message-context')).value = '';
      // this.textInputTextArea = '';
      // this.restoreTextArea();
  }

  private restoreTextArea() {
    //   that.g.wdLog(['AppComponent:restoreTextArea::restoreTextArea');
    this.resizeInputField();
    const textArea = (<HTMLInputElement>document.getElementById('chat21-main-message-context'));
    this.textInputTextArea = ''; // clear the textarea
    if (textArea) {
        textArea.value = '';  // clear the textarea
        textArea.placeholder = this.g.LABEL_PLACEHOLDER;  // restore the placholder
        this.g.wdLog(['AppComponent:restoreTextArea::restoreTextArea::textArea:', 'restored']);
    } else {
      this.g.wdLog(['AppComponent:restoreTextArea::restoreTextArea::textArea:', 'not restored']);
    }
    this.setFocusOnId('chat21-main-message-context');
  }


  /**
     * invio del messaggio
     * @param msg
     * @param type
     * @param metadata
     */
    sendMessage(msg, type, metadata?) {
      // stoppo l'audio se è in play
      this.pauseAudioMsg(null);
      const that = this;
      setTimeout(function () {
        // aggingo writingMessage quando invio un nw msg e lo elimino quando ricevo una risposta
        if (that.messages.length === 0 || msg.trim() === '') {
          that.writingMessage = '';
        } else {
          that.writingMessage = that.g.LABEL_WRITING;
        }
      }, 300);

      (metadata) ? metadata = metadata : metadata = '';
      this.g.wdLog(['------> SEND MESSAGE: ', msg, type, metadata]);
      // if (msg && msg.trim() !== '' || type === TYPE_MSG_IMAGE || type === TYPE_MSG_FILE ) {
      if (msg && msg.trim() !== '' || type !== TYPE_MSG_TEXT ) {
          let recipientFullname = this.g.GUEST_LABEL;
          const attributes = this.g.attributes;
          const projectid = this.g.projectid;
          const channelType = this.g.channelType;
          const userFullname = this.g.userFullname;
          const userEmail = this.g.userEmail;
          const showWidgetNameInConversation = this.g.showWidgetNameInConversation;
          const widgetTitle = this.g.widgetTitle;
          const conversationWith = this.conversationWith;
          this.triggerBeforeSendMessageEvent(
            recipientFullname,
            msg,
            type,
            metadata,
            conversationWith,
            recipientFullname,
            attributes,
            projectid,
            channelType
          );
          if (userFullname) {
            recipientFullname = userFullname;
          } else if (userEmail) {
            recipientFullname = userEmail;
          } else if (attributes && attributes.userFullname) {
            recipientFullname = attributes.userFullname;
          } else {
            recipientFullname = this.g.GUEST_LABEL;
          }
          if (showWidgetNameInConversation && showWidgetNameInConversation === true) {
            recipientFullname += ' - ' + widgetTitle;
          }
          const messageSent = this.messagingService.sendMessage(
            recipientFullname,
            msg,
            type,
            metadata,
            conversationWith,
            recipientFullname,
            attributes,
            projectid,
            channelType
            );
          this.triggerAfterSendMessageEvent(messageSent);
          this.isNewConversation = false;
          this.isNwMsg = true;

          try {
            const target = document.getElementById('chat21-main-message-context') as HTMLInputElement;
            target.value = '';
            target.style.height = this.HEIGHT_DEFAULT;
            console.log('target.style.height: ', target.style.height);
          } catch (e) {
            this.g.wdLog(['> Error :' + e]);
          }

          this.restoreTextArea();
      }
  }

  printMessage(message, messageEl, component) {
    // console.log('messageEl', messageEl);
    // console.log('component', component);

    this.triggerBeforeMessageRender(message, messageEl, component);

    const messageText = message.text;
    // console.log('triggerBeforeMessageRender after');
    // TODO Aggiungi linky
    this.triggerAfterMessageRender(message, messageEl, component);

    return messageText;
  }

  triggerBeforeMessageRender(message, messageEl, component) {
    // console.log('triggerBeforeMessageRender');
    try {
      // tslint:disable-next-line:max-line-length
      const beforeMessageRender = new CustomEvent('beforeMessageRender',
        { detail: { message: message, sanitizer: this.sanitizer, messageEl: messageEl, component: component} });

      const returnEventValue = this.elRoot.nativeElement.dispatchEvent(beforeMessageRender);
      // console.log('returnEventValue', returnEventValue);
    } catch (e) {
        console.error('Error triggering triggerBeforeMessageRender', e);
    }
  }

  triggerAfterMessageRender(message, messageEl, component) {
    try {
      // tslint:disable-next-line:max-line-length
      const afterMessageRender = new CustomEvent('afterMessageRender',
        { detail: { message: message, sanitizer: this.sanitizer, messageEl: messageEl, component: component} });

      const returnEventValue = this.elRoot.nativeElement.dispatchEvent(afterMessageRender);


      // console.log('returnEventValue', returnEventValue);
    } catch (e) {
        console.error('Error triggering triggerAfterMessageRender', e);
    }
  }



  // tslint:disable-next-line:max-line-length
  private triggerBeforeSendMessageEvent(senderFullname, text, type, metadata, conversationWith, recipientFullname, attributes, projectid, channel_type) {
    try {
        // tslint:disable-next-line:max-line-length
        const beforeMessageSend = new CustomEvent('beforeMessageSend', { detail: { senderFullname: senderFullname, text: text, type: type, metadata, conversationWith: conversationWith, recipientFullname: recipientFullname, attributes: attributes, projectid: projectid, channelType: channel_type } });
        this.el.nativeElement.dispatchEvent(beforeMessageSend);
    } catch (e) {
        console.error('Error triggering triggerBeforeSendMessageEvent', e);
    }
  }

  // tslint:disable-next-line:max-line-length
  private triggerAfterSendMessageEvent(message) {
    try {
        // tslint:disable-next-line:max-line-length
        const afterMessageSend = new CustomEvent('afterMessageSend', { detail: { message: message } });
        this.el.nativeElement.dispatchEvent(afterMessageSend);
    } catch (e) {
        console.error('Error triggering triggerAfterSendMessageEvent', e);
    }
  }

  /**
   *
   */

  onSendPressed(event) {
    this.g.wdLog(['onSendPressed:event', event]);
    this.g.wdLog(['AppComponent::onSendPressed::isFilePendingToUpload:', this.isFilePendingToUpload]);
    if (this.isFilePendingToUpload) {
      this.g.wdLog(['AppComponent::onSendPressed', 'is a file']);
      // its a file
      this.loadFile();
      this.isFilePendingToUpload = false;
      // disabilito pulsanti
      this.g.wdLog(['AppComponent::onSendPressed::isFilePendingToUpload:', this.isFilePendingToUpload]);
    } else {
      if ( this.textInputTextArea.length > 0 ) {
        this.g.wdLog(['AppComponent::onSendPressed', 'is a message']);
        // its a message
        this.performSendingMessage();
        // restore the text area
        // this.restoreTextArea();
      }
    }
  }

    /**
     * recupero url immagine profilo
     * @param uid
     */
    getUrlImgProfile(uid): string {
      const baseLocation = this.g.baseLocation;
      if (!uid || uid === 'system' ) {
        return baseLocation + IMG_PROFILE_BOT;
      } else if ( uid === 'error') {
        return baseLocation + IMG_PROFILE_DEFAULT;
      } else {
          return getImageUrlThumb(uid);
      }
    }

  /**
     * ridimensiona la textarea
     * chiamato ogni volta che cambia il contenuto della textarea
     */
    resizeInputField() {
      const target = document.getElementById('chat21-main-message-context');
      if (!target) {
          return;
      }
      // tslint:disable-next-line:max-line-length
      //   that.g.wdLog(['H:: this.textInputTextArea', (document.getElementById('chat21-main-message-context') as HTMLInputElement).value , target.style.height, target.scrollHeight, target.offsetHeight, target.clientHeight);
      target.style.height = '100%';
      if ((document.getElementById('chat21-main-message-context') as HTMLInputElement).value === '\n') {
          //   that.g.wdLog(['PASSO 0');
          (document.getElementById('chat21-main-message-context') as HTMLInputElement).value = '';
          target.style.height = this.HEIGHT_DEFAULT;
      } else if (target.scrollHeight > target.offsetHeight) {
          this.g.wdLog(['PASSO 2']);
          target.style.height = target.scrollHeight  + 'px';
      } else {
          //   that.g.wdLog(['PASSO 3');
          target.style.height = this.HEIGHT_DEFAULT;
          // segno sto scrivendo
          // target.offsetHeight - 15 + 'px';
      }
      // tslint:disable-next-line:max-line-length
      //   that.g.wdLog(['H:: this.textInputTextArea', this.textInputTextArea, target.style.height, target.scrollHeight, target.offsetHeight, target.clientHeight);
  }



  // ================================ //


  // ========= begin:: functions scroll position ======= //
  /**
   *
   */
  // LISTEN TO SCROLL POSITION
  onScroll(event: any): void {
    const that = this;
    this.startScroll = false;
    setTimeout(function () {
      // console.log('onScroll: ', event);
      if (that.scrollMe) {
        const divScrollMe = that.scrollMe.nativeElement;
        // console.log(divScrollMe.scrollTop);
        // console.log(event);
        // console.log(divScrollMe.scrollHeight);
        if (!divScrollMe) { return; }
        const checkContentScrollPosition = that.checkContentScrollPosition(divScrollMe);
        if (checkContentScrollPosition) {
          that.showButtonToBottom = false;
          that.NUM_BADGES = 0;
        } else {
          that.showButtonToBottom = true;
        }
      }
    }, 100);
  }

  /**
   *
   */
  checkContentScrollPosition(divScrollMe): boolean {
    //   that.g.wdLog(['checkContentScrollPosition ::', divScrollMe);
    //   that.g.wdLog(['divScrollMe.diff ::', divScrollMe.scrollHeight - divScrollMe.scrollTop);
    //   that.g.wdLog(['divScrollMe.clientHeight ::', divScrollMe.clientHeight);
    if (divScrollMe.scrollHeight - divScrollMe.scrollTop <= (divScrollMe.clientHeight + 40)) {
      this.g.wdLog(['SONO ALLA FINE ::']);
        return true;
    } else {
      this.g.wdLog([' NON SONO ALLA FINE ::']);
        return false;
    }
  }

  /**
   * scrollo la lista messaggi all'ultimo
   * chiamato in maniera ricorsiva sino a quando non risponde correttamente
  */

  // scrollToBottomStart_old() {
  //   const that = this;
  //   if ( this.isScrolling === false ) {
  //     setTimeout(function () {
  //       try {
  //         that.isScrolling = true;
  //         const objDiv = document.getElementById(that.idDivScroll);
  //         setTimeout(function () {
  //           that.g.wdLog(['objDiv::', objDiv.scrollHeight]);
  //           objDiv.scrollIntoView(false);
  //           objDiv.style.opacity = '1';
  //         }, 200);
  //         that.isScrolling = false;
  //       } catch (err) {
  //         this.g.wdLog(['> Error is: ', err]);
  //       }
  //     }, 300);
  //   }
  // }

  scrollToBottom(withoutAnimation?: boolean) {
    console.log('scrollToBottom: ');
    const that = this;
     try {
      that.isScrolling = true;
      const objDiv = document.getElementById(that.idDivScroll) as HTMLElement;
      // const element = objDiv[0] as HTMLElement;
      if (!objDiv) { return; }
      setTimeout(function () {
        console.log('objDiv.scrollHeight: ' + objDiv.scrollHeight);
        console.log('objDiv.clientHeight: ' + objDiv.parentElement.clientHeight);
        console.log('objDiv.scrollTop: ' + objDiv.scrollBy);
        if (that.isIE === true || withoutAnimation === true || that.firstScroll === true) {
          objDiv.parentElement.classList.add('withoutAnimation');
        } else {
          objDiv.parentElement.classList.remove('withoutAnimation');
        }
        objDiv.parentElement.scrollTop = objDiv.scrollHeight;
        objDiv.style.opacity = '1';
        // element.animate({
        //   scrollTop: element.scrollHeight // - element.clientHeight
        // }, delayTime);
        that.firstScroll = false;
      }, 0);
    } catch (err) {
      that.g.wdLog(['> Error :' + err]);
    }
    that.isScrolling = false;
   }

  // scrollToBottom_old(withoutAnimation?: boolean) {
  //   this.g.wdLog([' scrollToBottom: ', this.isScrolling]);
  //   const that = this;
  //   // const divScrollMe = this.scrollMe.nativeElement;

  //   if ( this.isScrolling === false ) {
  //     // const divScrollMe = this.scrollMe.nativeElement;
  //     setTimeout(function () {
  //       try {
  //         that.isScrolling = true;
  //         const objDiv = document.getElementById(that.idDivScroll);
  //         setTimeout(function () {
  //           if (that.isIE === true || withoutAnimation === true) {
  //             objDiv.scrollIntoView(false);
  //           } else {
  //             objDiv.scrollIntoView({behavior: 'smooth', block: 'end'});
  //           }
  //           that.g.wdLog(['objDiv::', objDiv.scrollHeight]);
  //           // objDiv.scrollIntoView(false);
  //         }, 0);
  //         that.isScrolling = false;

  //         //// https://developer.mozilla.org/en-US/docs/Web/API/Element/scrollIntoView
  //         // setTimeout(function () {
  //         //   objDiv.scrollIntoView({behavior: 'smooth', block: 'end'});
  //         // }, 500);

  //         // let checkContentScrollPosition = false;
  //         // do {
  //         //   setTimeout(function () {
  //         //     that.g.wdLog(['RIPROVO dopo 1 sec::']);
  //         //     objDiv.scrollIntoView({behavior: 'smooth', block: 'end'});
  //         //     checkContentScrollPosition = that.checkContentScrollPosition(divScrollMe);
  //         //   }, 1000);
  //         // }
  //         // while (checkContentScrollPosition === false);
  //         // that.isScrolling = false;

  //         //   that.g.wdLog(['checkContentScrollPosition ::', this.divScrollMe);
  //         //   that.g.wdLog(['divScrollMe.diff ::', this.divScrollMe.scrollHeight - this.divScrollMe.scrollTop);
  //         //   that.g.wdLog(['divScrollMe.clientHeight ::', this.divScrollMe.clientHeight);
  //         // try {
  //         //   this.divScrollMe.nativeElement.scrollToTop = this.divScrollMe.nativeElement.scrollHeight;
  //         // } catch ( err ) { }
  //         // // that.badgeNewMessages = 0;
  //         // console.log(objDiv);
  //       } catch (err) {
  //           this.g.wdLog(['> Error is: ', err]);
  //           setTimeout(function () {
  //             that.isScrolling = false;
  //           }, 0);
  //         //that.scrollToBottom();
  //       }
  //     }, 0);
  //   }
  // }

  // ========= end:: functions scroll position ======= //




// ========= begin:: functions send image ======= //
  // START LOAD IMAGE //
  /**
   * carico in locale l'immagine selezionata e apro pop up anteprima
   */
  detectFiles(event) {
    this.g.wdLog(['detectFiles: ', event]);

    if (event) {
        this.selectedFiles = event.target.files;
        this.g.wdLog(['AppComponent:detectFiles::selectedFiles', this.selectedFiles]);
        if (this.selectedFiles == null) {
          this.isFilePendingToUpload = false;
        } else {
          this.isFilePendingToUpload = true;
        }
        this.g.wdLog(['AppComponent:detectFiles::selectedFiles::isFilePendingToUpload', this.isFilePendingToUpload]);
        this.g.wdLog(['fileChange: ', event.target.files]);
        if (event.target.files.length <= 0) {
          this.isFilePendingToUpload = false;
        } else {
          this.isFilePendingToUpload = true;
        }
        const that = this;
        if (event.target.files && event.target.files[0]) {
            const nameFile = event.target.files[0].name;
            const typeFile = event.target.files[0].type;
            const reader = new FileReader();
              that.g.wdLog(['OK preload: ', nameFile, typeFile, reader]);
            reader.addEventListener('load', function () {
                that.g.wdLog(['addEventListener load', reader.result]);
              that.isFileSelected = true;
              // se inizia con image
              if (typeFile.startsWith('image')) {
                const imageXLoad = new Image;
                that.g.wdLog(['onload ', imageXLoad]);
                imageXLoad.src = reader.result.toString();
                imageXLoad.title = nameFile;
                that.g.wdLog(['imageXLoad.src ', imageXLoad.src]);
                imageXLoad.onload = function () {
                  that.g.wdLog(['onload immagine']);
                  // that.arrayFilesLoad.push(imageXLoad);
                  const uid = (new Date().getTime()).toString(36); // imageXLoad.src.substring(imageXLoad.src.length - 16);
                  that.arrayFilesLoad[0] = { uid: uid, file: imageXLoad, type: typeFile };
                  that.g.wdLog(['OK: ', that.arrayFilesLoad[0]]);
                  // INVIO MESSAGGIO
                  that.loadFile();
                };
              } else {
                that.g.wdLog(['onload file']);
                const fileXLoad = {
                  src: reader.result.toString(),
                  title: nameFile
                };
                that.g.wdLog(['fileXLoad.src ', fileXLoad.src]);
                // that.arrayFilesLoad.push(imageXLoad);
                const uid = (new Date().getTime()).toString(36); // fileXLoad.src.substring(fileXLoad.src.length - 16);
                that.arrayFilesLoad[0] = { uid: uid, file: fileXLoad, type: typeFile };
                that.g.wdLog(['OK: ', that.arrayFilesLoad[0]]);
                // INVIO MESSAGGIO
                that.loadFile();
              }
            }, false);

            if (event.target.files[0]) {
              reader.readAsDataURL(event.target.files[0]);
                that.g.wdLog(['reader-result: ', event.target.files[0]]);
            }
        }
    }
  }


  loadFile() {
    this.g.wdLog(['that.fileXLoad: ', this.arrayFilesLoad]);
        // al momento gestisco solo il caricamento di un'immagine alla volta
        if (this.arrayFilesLoad[0] && this.arrayFilesLoad[0].file) {
            const fileXLoad = this.arrayFilesLoad[0].file;
            const uid = this.arrayFilesLoad[0].uid;
            const type = this.arrayFilesLoad[0].type;
            this.g.wdLog(['that.fileXLoad: ', type]);
            let metadata;
            if (type.startsWith('image')) {
                metadata = {
                    'name': fileXLoad.title,
                    'src': fileXLoad.src,
                    'width': fileXLoad.width,
                    'height': fileXLoad.height,
                    'type': type
                    // 'uid': uid
                };
            } else {
                metadata = {
                    'name': fileXLoad.title,
                    'src': fileXLoad.src,
                    'type': type
                    // 'uid': uid
                };
            }
            this.g.wdLog(['metadata -------> ', metadata]);
            //this.scrollToBottom();
            // 1 - aggiungo messaggio localmente
            // this.addLocalMessageImage(metadata);
            // 2 - carico immagine
            const file = this.selectedFiles.item(0);
            this.uploadSingle(metadata, file);
            // this.isSelected = false;
        }
    }


  /**
   *
   */
    uploadSingle(metadata, file) {
        const that = this;
        const send_order_btn = <HTMLInputElement>document.getElementById('chat21-start-upload-doc');
        send_order_btn.disabled = true;
        that.g.wdLog(['AppComponent::uploadSingle::', metadata, file]);
        // const file = this.selectedFiles.item(0);
        const currentUpload = new UploadModel(file);
        // console.log(currentUpload.file);

        const uploadTask = this.upSvc.pushUpload(currentUpload);
        uploadTask.then(snapshot => {
            return snapshot.ref.getDownloadURL();   // Will return a promise with the download link
        })
            .then(downloadURL => {
                  that.g.wdLog(['AppComponent::uploadSingle:: downloadURL', downloadURL]);
                  that.g.wdLog([`Successfully uploaded file and got download link - ${downloadURL}`]);

                metadata.src = downloadURL;
                let type_message = TYPE_MSG_TEXT;
                let message = 'File: ' + metadata.src;
                if (metadata.type.startsWith('image')) {
                    type_message = TYPE_MSG_IMAGE;
                    // message = 'Image: ' + metadata.src;
                    message = '';
                }
                that.sendMessage(message, type_message, metadata);
                //that.scrollToBottom();
                that.isFilePendingToUpload = false;
                // return downloadURL;
            })
            .catch(error => {
                // Use to signal error if something goes wrong.
                this.g.wdLog(['> Error is: ', error]);
                // console.error(`AppComponent::uploadSingle:: Failed to upload file and get link - ${error}`);
            });
      // this.resetLoadImage();
        that.g.wdLog(['reader-result: ', file]);
    }


    /**
     *
     * @param message
     */
    getSizeImg(message): any {
      const metadata = message.metadata;
      // const MAX_WIDTH_IMAGES = 300;
      const sizeImage = {
          width: metadata.width,
          height: metadata.height
      };
      //   that.g.wdLog(['message::: ', metadata);
      if (metadata.width && metadata.width > MAX_WIDTH_IMAGES) {
          const rapporto = (metadata['width'] / metadata['height']);
          sizeImage.width = MAX_WIDTH_IMAGES;
          sizeImage.height = MAX_WIDTH_IMAGES / rapporto;
      }
      // this.scrollToBottom();
      return sizeImage; // h.toString();
  }

  /**
     * aggiorno messaggio: uid, status, timestamp, headerDate
     * richiamata alla sottoscrizione dell'aggiunta di un nw messaggio
     * in caso in cui il messaggio è un'immagine ed è stata inviata dall'utente
     */
    updateMessage(message) {
      this.g.wdLog(['UPDATE MSG:', message.metadata.uid]);
      const index = searchIndexInArrayForUid(this.messages, message.metadata.uid);
      if (index > -1) {
          this.messages[index].uid = message.uid;
          this.messages[index].status = message.status;
          this.messages[index].timestamp = message.timestamp;
          this.messages[index].headerDate = message.headerDate;
          this.g.wdLog(['UPDATE ok:', this.messages[index]]);
      } else {
          this.messages.push(message);
      }
  }




  /**
     *
     */
  // resetLoadImage() {
  //     this.nameFile = '';
  //     this.selectedFiles = null;
  //       that.g.wdLog(['1 selectedFiles: ', this.selectedFiles);

  //     delete this.arrayFiles4Load[0];
  //     document.getElementById('chat21-file').nodeValue = null;
  //     // event.target.files[0].name, event.target.files
  //     this.isSelected = false;

  //     this.isFilePendingToUpload = false;
  //       that.g.wdLog(['AppComponent::resetLoadImage::isFilePendingToUpload:', this.isFilePendingToUpload);

  //     // this.restoreTextArea();
  // }

  /**
     * salvo un messaggio localmente nell'array dei msg
     * @param metadata
     */
  //   addLocalMessageImage(metadata) {

  //     const now: Date = new Date();
  //     const timestamp = now.valueOf();
  //     const language = document.documentElement.lang;

  //     let recipientFullname;
  //     if (this.userFullname) {
  //         recipientFullname = this.userFullname;
  //     } else if (this.userEmail) {
  //         recipientFullname = this.userEmail;
  //     } else {
  //         recipientFullname = this.GUEST_LABEL;
  //     }
  //     // const projectname = (this.projectname) ? this.projectname : this.projectid;
  //     if (this.showWidgetNameInConversation && this.showWidgetNameInConversation === true) {
  //         recipientFullname += ' - ' + this.widgetTitle;
  //     }

  //     // set senderFullname
  //     const senderFullname = recipientFullname;

  //     const message = new MessageModel(
  //         metadata.uid, // uid
  //         language, // language
  //         this.conversationWith, // recipient
  //         recipientFullname, // recipient_fullname
  //         this.senderId, // sender
  //         senderFullname, // sender_fullname
  //         '', // status
  //         metadata, // metadata
  //         '', // text
  //         timestamp, // timestamp
  //         '', // headerDate
  //         TYPE_MSG_IMAGE, // type
  //         '',
  //         this.channelType,
  //         this.projectid
  //     );
  //     // this.messages.push(message);
  //     // message.metadata.uid = message.uid;
  //       that.g.wdLog(['addLocalMessageImage: ', this.messages);
  //     this.isSelected = true;
  //     this.scrollToBottom();
  // }


  private loadJS() {
    // You can load multiple scripts by just providing the key as argument into load method of the service
    this.audioRecorderService.load('WebAudioRecorder', 'audio').then(data => {
      // Script Loaded Successfully
      // console.log(data);
    }).catch(error => this.g.wdLog(['> Error is: ', error]) );
  }

  recording(e: any) {
    // console.log('1 startRecording');
    const that = this;
    const textArea = (<HTMLInputElement>document.getElementById('chat21-main-message-context'));
    if (this.isRecording === true) {
      this.isRecording = false;
      this.subTimer.unsubscribe();
      textArea.readOnly = false;
      if (textArea) {
        textArea.value = '';
        textArea.placeholder = this.g.LABEL_PLACEHOLDER;
      }
      try {
        stopRecording();
        this.isNwMsg = true;
        const btnStopRecord = (<HTMLInputElement>document.getElementById('chat21-start-mic'));
        btnStopRecord.focus();
      } catch (error) {
        this.g.wdLog(['> Error is: ', error]);
      }
    } else {
      this.isRecording = true;
      // console.log('2 startRecording');
      // cambio icona
      // inizio registrazione
      // visualizzo time rec come placeholder e desabilito input testo
      textArea.readOnly = true;

      navigator.mediaDevices.getUserMedia({ audio: true })
      .then(function(stream) {
        that.subTimer = that.timer.subscribe(val => {
          if (textArea) {
              textArea.value = '';  // clear the textarea
              textArea.placeholder = fromNumberToTime(val); // .toString();  // restore the placholder
          }
        });
        that.subscriptions.push(that.subTimer);
      })
      .catch(function(err) {
        this.g.wdLog(['> Error is: ', err]);
      });
      const uid = createGuid();
      // stoppo l'audio se è in play
      this.pauseAudioMsg(null);
      try {
        startRecording(this.urlAudiorepo, uid, function(uuid: string, filename: string) {
          const url = that.urlAudiorepo + '/audio/' + filename;
          const metadata = {
            'src': url,
            'type': TYPE_MSG_AUDIO,
            'uid': uuid
          };
          metadata.src = url;
          const message = null; // 'Audio: ' + url;
          that.sendMessage(message, TYPE_MSG_AUDIO, metadata);
          const btnStartRecord = (<HTMLInputElement>document.getElementById('chat21-start-mic'));
          btnStartRecord.focus();
        });
      } catch (error) {
        this.g.wdLog(['> Error is: ', error]);
      }
    }
  }



  startSpeechToText() {
      console.log('startSpeechToText ' + this.isRecording);
      const that = this;
      const transcript = (<HTMLInputElement>document.getElementById('chat21-main-message-context'));
      const micButton = 'playbutton';
      try {
        startSpeechToText(micButton, function(streamed_text: string) {
          console.log('startSpeechToText1' + streamed_text);
          transcript.value = streamed_text;
          that.isRecording = true;
          that.resizeInputField();
        },
        function(final_text) {
          console.log('startSpeechToText2' + final_text);
          transcript.value = final_text;
          const message = final_text; // 'Audio: ' + url;
          that.isRecording = false;
          that.sendMessage(message, TYPE_MSG_TEXT);
          that.restoreTextArea();
        });
      } catch (error) {
        this.g.wdLog(['startSpeechToText > Error is: ', error]);
      }

  }

  // ========= end:: functions send image ======= //

  returnHome() {
    this.g.setParameter('activeConversation', null);
    this.eventClose.emit();
  }

  returnCloseWidget() {
    this.g.setParameter('activeConversation', null);
    this.eventCloseWidget.emit();
  }

  dowloadTranscript() {
    const url = this.API_URL + 'public/requests/' + this.conversationWith + '/messages.html';
    const windowContext = this.g.windowContext;
    windowContext.open(url, '_blank');
    this.isMenuShow  = false;
  }

  toggleSound() {
    this.g.setParameter('isSoundActive', !this.g.isSoundActive);
    this.isMenuShow  = false;
    // this.g.isSoundActive = !this.g.isSoundActive;
    // if ( this.g.isSoundActive === false ) {
    //   this.storageService.setItem('isSoundActive', false);
    // } else {
    //   this.storageService.setItem('isSoundActive', true);
    // }
  }

  toggleMenu() {
    this.isMenuShow = !this.isMenuShow;
  }

  openInputFiles() {
    alert('ok');
    if (document.getElementById('chat21-file')) {
     const docInput = document.getElementById('chat21-file');
     docInput.style.display = 'block';
    }
  }



  // ========= begin:: DESTROY ALL SUBSCRIPTIONS ============//
  /**
   * elimino tutte le sottoscrizioni
   */
  // tslint:disable-next-line:use-life-cycle-interface
  ngOnDestroy() {
    this.g.wdLog(['ngOnDestroy ------------------> this.subscriptions', this.subscriptions]);
    this.unsubscribe();
  }


  /** */
  unsubscribe() {
    this.subscriptions.forEach(function (subscription) {
      try {
        subscription.unsubscribe();
      } catch (error) {
        this.g.wdLog(['> Error is: ', error]);
      }
    });
    this.subscriptions.length = 0;
    this.messagingService.unsubscribeAllReferences();
    this.g.wdLog(['this.subscriptions', this.subscriptions]);
  }
  // ========= end:: DESTROY ALL SUBSCRIPTIONS ============//



  /**
   * regola sound message:
   * se lo invio io -> NO SOUND
   * se non sono nella conversazione -> SOUND
   * se sono nella conversazione in fondo alla pagina -> NO SOUND
   * altrimenti -> SOUND
   */
  soundMessage() {
    const isSoundActive = this.g.isSoundActive;
    const baseLocation = this.g.baseLocation;
    if ( isSoundActive ) {
      const that = this;
      this.audio = new Audio();
      this.audio.src = baseLocation + '/assets/sounds/Carme.mp3';
      that.g.wdLog(['****** soundMessage *****', this.audio.src]);
      this.audio.load();
      // console.log('conversation play');
      setTimeout(function() {
        that.audio.play();
      }, 0);
    }
  }

  hideMenuOptions() {
    this.g.wdLog(['hideMenuOptions']);
    this.isMenuShow  = false;
  }

  resetConversation() {
    this.g.wdLog(['resetConversation']);
    this.sendMessage('reset', TYPE_MSG_TEXT, null);
    this.isMenuShow  = false;
  }

  isLastMessage(idMessage: string) {
    // console.log('idMessage: ' + idMessage + 'id LAST Message: ' + this.messages[this.messages.length - 1].uid);
    if (idMessage === this.messages[this.messages.length - 1].uid) {
      return true;
    }
    return false;
  }

  /** */
  isClassClean(message: MessageModel) {
    // [class.clean]= "message.type !== 'text' && !message.attributes.alwaysShowText"
    // [class.clean]= "message.type !== 'text' && !message.attributes.alwaysShowText"
    try {
        if (message && message.type !== 'text' && message.attributes && !message.attributes.alwaysShowText) {
          return true;
        } else {
          return false;
        }
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
      return false;
    }
  }

  /** */
  isTypeText(message: MessageModel) {
    // *ngIf="message.type !== 'image' && message.type != 'audio' || (message.type == 'audio' && message.attributes.alwaysShowText)"
    try {
        // if (message.type !== 'image' && message.type !== 'audio' || (message.type === 'audio' && message.attributes.alwaysShowText)) {
        if (message.type === 'text' || (message.type === 'audio' && message.attributes.alwaysShowText)) {
          return true;
        } else {
          return false;
        }
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
      return false;
    }
  }

  /** */
  isAlwaysShowText(message: MessageModel) {
    try {
        // if (message.type !== 'image' && message.type !== 'audio' || (message.type === 'audio' && message.attributes.alwaysShowText)) {
        if (message.attributes.alwaysShowText) {
          return message.attributes.alwaysShowText;
        } else {
          return false;
        }
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
      return false;
    }
  }


  /** */
  returnOpenAttachment($event: String) {
    if ($event) {
      const metadata = {
        'button': true
      };
      this.sendMessage($event, TYPE_MSG_TEXT, metadata);
    }
  }

  /**
   * play audio msg
   * @param e
   */
  playAudioMsg(e) {
    // stop all audio
    if (this.uidAudioPlayng) {
      const divPlay = (<HTMLAudioElement>document.getElementById(this.uidAudioPlayng));
      divPlay.pause();
      // console.log('> pausa: ', divPlay);
    }
    try {
      // console.log(e.target.id);
      // set uid audio playng
      this.uidAudioPlayng = e.target.id;
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
    }
  }


  toggleRecording(e) {
    this.isRecording = !this.isRecording;
  }
  /**
   *
   * @param e
   */
  pauseAudioMsg(e) {
    try {
      // stop all audio
      if (this.uidAudioPlayng) {
        const divPlay = (<HTMLAudioElement>document.getElementById(this.uidAudioPlayng));
        divPlay.pause();
        // console.log('> pausa: ', divPlay);
      }
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
    }

    try {
      // console.log(e.target.id);
      if (this.uidAudioPlayng) {
        this.uidAudioPlayng = '';
      }
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
    }
  }

  //vetereg 2021-11-30
  //muto l'audio in riproduzione
  muteAudioMsg() {
    try {
      // stop all audio
      if (this.uidAudioPlayng) {
        const divPlay = (<HTMLAudioElement>document.getElementById(this.uidAudioPlayng));
        divPlay.muted = !divPlay.muted;
      }
    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
    }
  }

  /**
   *
   * @param uid
   */
  playPausaAudioMsg(uid: string) {
    // console.log('playPausaAudioMsg: ', uid);
    const that = this;
    try {
      const divPause = (<HTMLAudioElement>document.getElementById(that.uidAudioPlayng));
      const divPlay = (<HTMLAudioElement>document.getElementById(uid));
      if (divPause) {
        divPause.pause();
      }

      if (that.uidAudioPlayng === uid) {
        that.uidAudioPlayng = '';
      } else {
        if (divPlay) {
          setTimeout(function() {
            if (that.g.autoplay_activated) {
              divPlay.play();
            }
            this.uidAudioPlayng = uid;
          }, 300);
        }
      }

    } catch (error) {
      this.g.wdLog(['> Error is: ', error]);
    }
    // try {
    //   const divPause = (<HTMLAudioElement>document.getElementById(this.uidAudioPlayng));
    //   if (divPause) {
    //     divPause.pause();
    //   }
    // } catch (error) {
    //   this.g.wdLog(['> Error is: ', error]);
    // }
    // try {
    //   const divPlay = (<HTMLAudioElement>document.getElementById(uid));
    //   console.log('divPlay: ', divPlay);
    //   if (divPlay) {
    //     setTimeout(function() {
    //       if (that.g.autoplay_activated) {
    //         divPlay.play();
    //       }
    //       this.uidAudioPlayng = uid;
    //     }, 300);
    //   }
    // } catch (error) {
    //   this.g.wdLog(['> Error is: ', error]);
    // }

  }



}
