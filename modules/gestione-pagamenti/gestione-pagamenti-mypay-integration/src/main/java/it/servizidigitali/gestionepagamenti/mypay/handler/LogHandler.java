package it.servizidigitali.gestionepagamenti.mypay.handler;

import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.utils.Messages;

public class LogHandler extends BasicHandler {

	private static final long serialVersionUID = 1L;

	@Override
	public void invoke(MessageContext msgContext) throws AxisFault {
		try {
			logMessage(msgContext);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void logMessage(MessageContext msgContext) throws Exception {
		Message inMsg = msgContext.getRequestMessage();
		Message outMsg = msgContext.getResponseMessage();
		if (outMsg == null) {
			System.out.println("============================= REQUEST ================================================");
			System.out.println(Messages.getMessage("inMsg00", (inMsg == null ? "" : inMsg.getSOAPEnvelope().getAsString())));
			System.out.println("============================= END REQUEST ============================================");
		}
		else {
			System.out.println("=================================== RESPONSE ==========================================");
			System.out.println(Messages.getMessage("outMsg00", (outMsg == null ? "" : outMsg.getSOAPEnvelope().getAsString())));
			System.out.println("=================================== END RESPONSE ======================================");
		}
	}

	@Override
	public void onFault(MessageContext msgContext) {
		super.onFault(msgContext);
		try {
			logMessage(msgContext);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}