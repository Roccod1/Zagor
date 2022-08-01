package it.servizidigitali.gestioneprocessi.frontend.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.gestioneprocessi.exception.NoSuchProcessoException;
import it.servizidigitali.gestioneprocessi.frontend.constants.GestioneProcessiPortletKeys;
import it.servizidigitali.gestioneprocessi.model.Processo;
import it.servizidigitali.gestioneprocessi.service.ProcessoLocalService;

/**
 * @author COSTABILEE
 *
 */

@Component(immediate = true, 
property = { 
			"javax.portlet.name=" + GestioneProcessiPortletKeys.GESTIONEPROCESSI,
			"mvc.command.name=" + GestioneProcessiPortletKeys.SALVA_CREA_ACTION_COMMAND
		}, 
service = { MVCActionCommand.class }
)
public class SalvaCreaActionCommand extends BaseMVCActionCommand{
	
	public static final Log _log = LogFactoryUtil.getLog(SalvaCreaActionCommand.class);
	
	@Reference
	private ProcessoLocalService processoLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long idProcesso = ParamUtil.getLong(actionRequest, GestioneProcessiPortletKeys.ID_PROCESSO);
		String codice = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.CODICE);
		String nome = ParamUtil.getString(actionRequest, GestioneProcessiPortletKeys.NOME);
		String modelloXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <bpmn:definitions xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" id=\"Definitions_1\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"Camunda Modeler\" exporterVersion=\"1.2.0\"> <bpmn:process id=\"Process_1\" isExecutable=\"false\"> <bpmn:startEvent id=\"StartEvent_1\"> <bpmn:outgoing>SequenceFlow_0lwhyb7</bpmn:outgoing> </bpmn:startEvent> <bpmn:serviceTask id=\"ServiceTask_1x9xbnf\" name=\"Notifica al cittadino\"> <bpmn:incoming>SequenceFlow_0lwhyb7</bpmn:incoming> <bpmn:outgoing>SequenceFlow_1n9kjbn</bpmn:outgoing> </bpmn:serviceTask> <bpmn:sequenceFlow id=\"SequenceFlow_0lwhyb7\" sourceRef=\"StartEvent_1\" targetRef=\"ServiceTask_1x9xbnf\" /> <bpmn:endEvent id=\"EndEvent_01zhutr\"> <bpmn:incoming>SequenceFlow_19sgw22</bpmn:incoming> </bpmn:endEvent> <bpmn:sequenceFlow id=\"SequenceFlow_1n9kjbn\" sourceRef=\"ServiceTask_1x9xbnf\" targetRef=\"IntermediateThrowEvent_145ffo8\" /> <bpmn:intermediateCatchEvent id=\"IntermediateThrowEvent_145ffo8\"> <bpmn:incoming>SequenceFlow_1n9kjbn</bpmn:incoming> <bpmn:outgoing>SequenceFlow_19sgw22</bpmn:outgoing> <bpmn:messageEventDefinition /> </bpmn:intermediateCatchEvent> <bpmn:sequenceFlow id=\"SequenceFlow_19sgw22\" sourceRef=\"IntermediateThrowEvent_145ffo8\" targetRef=\"EndEvent_01zhutr\" /> </bpmn:process> <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\"> <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_1\"> <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_1\"> <dc:Bounds x=\"332\" y=\"168\" width=\"36\" height=\"36\" /> <bpmndi:BPMNLabel> <dc:Bounds x=\"305\" y=\"204\" width=\"90\" height=\"20\" /> </bpmndi:BPMNLabel> </bpmndi:BPMNShape> <bpmndi:BPMNShape id=\"ServiceTask_1x9xbnf_di\" bpmnElement=\"ServiceTask_1x9xbnf\"> <dc:Bounds x=\"442\" y=\"144\" width=\"100\" height=\"80\" /> </bpmndi:BPMNShape> <bpmndi:BPMNEdge id=\"SequenceFlow_0lwhyb7_di\" bpmnElement=\"SequenceFlow_0lwhyb7\"> <di:waypoint xsi:type=\"dc:Point\" x=\"368\" y=\"186\" /> <di:waypoint xsi:type=\"dc:Point\" x=\"442\" y=\"186\" /> <bpmndi:BPMNLabel> <dc:Bounds x=\"359.9740556908147\" y=\"161.0004529717172\" width=\"90\" height=\"20\" /> </bpmndi:BPMNLabel> </bpmndi:BPMNEdge> <bpmndi:BPMNShape id=\"EndEvent_01zhutr_di\" bpmnElement=\"EndEvent_01zhutr\"> <dc:Bounds x=\"724\" y=\"166\" width=\"36\" height=\"36\" /> <bpmndi:BPMNLabel> <dc:Bounds x=\"697\" y=\"202\" width=\"90\" height=\"20\" /> </bpmndi:BPMNLabel> </bpmndi:BPMNShape> <bpmndi:BPMNEdge id=\"SequenceFlow_1n9kjbn_di\" bpmnElement=\"SequenceFlow_1n9kjbn\"> <di:waypoint xsi:type=\"dc:Point\" x=\"542\" y=\"184\" /> <di:waypoint xsi:type=\"dc:Point\" x=\"629\" y=\"183\" /> <bpmndi:BPMNLabel> <dc:Bounds x=\"535.3766439911676\" y=\"173.0590319906589\" width=\"90\" height=\"20\" /> </bpmndi:BPMNLabel> </bpmndi:BPMNEdge> <bpmndi:BPMNShape id=\"IntermediateCatchEvent_0egz5ur_di\" bpmnElement=\"IntermediateThrowEvent_145ffo8\"> <dc:Bounds x=\"629\" y=\"166\" width=\"36\" height=\"36\" /> <bpmndi:BPMNLabel> <dc:Bounds x=\"601.5\" y=\"201.25\" width=\"90\" height=\"20\" /> </bpmndi:BPMNLabel> </bpmndi:BPMNShape> <bpmndi:BPMNEdge id=\"SequenceFlow_19sgw22_di\" bpmnElement=\"SequenceFlow_19sgw22\"> <di:waypoint xsi:type=\"dc:Point\" x=\"665\" y=\"184\" /> <di:waypoint xsi:type=\"dc:Point\" x=\"695\" y=\"184\" /> <di:waypoint xsi:type=\"dc:Point\" x=\"695\" y=\"187\" /> <di:waypoint xsi:type=\"dc:Point\" x=\"725\" y=\"187\" /> <bpmndi:BPMNLabel> <dc:Bounds x=\"629.5454545454545\" y=\"175.625\" width=\"90\" height=\"20\" /> </bpmndi:BPMNLabel> </bpmndi:BPMNEdge> </bpmndi:BPMNPlane> </bpmndi:BPMNDiagram> </bpmn:definitions>";
		
		FileEntry fileCaricato = null;
		
		Processo processo = null;
		
		try {
			processo = processoLocalService.getProcessoByCodice(codice);
			_log.error("Processo già esistente con codice: " + codice);
			SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_PROCESSO_CODICE_ESISTENTE);
			return;
		}catch(NoSuchProcessoException e) {
			
			if(Validator.isNull(codice)) {
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}
			
			if(Validator.isNull(nome)) {
				SessionErrors.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ERRORE_SALVATAGGIO);
				return;
			}
			
			if(Validator.isNotNull(idProcesso) && idProcesso>0) {
				processo = processoLocalService.getProcesso(idProcesso);
				SessionMessages.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
			}else {
				processo = processoLocalService.createProcesso(counterLocalService.increment());
				SessionMessages.add(actionRequest, GestioneProcessiPortletKeys.SESSION_MESSAGE_ESEGUITO_CORRETTAMENTE);
			}
			
			if(Validator.isNotNull(modelloXml)) {
				fileCaricato = processoLocalService.uploadDocumentLibrary(modelloXml, nome, nome, themeDisplay.getScopeGroup(), themeDisplay.getUserId(), serviceContext);
				processo.setFileEntryId(fileCaricato.getFileEntryId());
			}
			
			processo.setCodice(codice);
			processo.setNome(nome);
			processo.setAttivo(true);
			processo.setUserId(serviceContext.getThemeDisplay().getUserId());
			processo.setGroupId(serviceContext.getThemeDisplay().getScopeGroupId());
			processo.setUserName(serviceContext.getThemeDisplay().getUser().getScreenName());
					
			processoLocalService.updateProcesso(processo);
		}
		
		
	}

}
