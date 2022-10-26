package it.servizidigitali.gestionepagamenti.mypay.handler;

import java.util.Iterator;

import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;

import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

/**
 * Handler per manipolare la request (errata) generata per il servizio
 * paaSILChiediPagatiConRicevuta.
 *
 * @author pindi
 *
 */
public class PaaSILChiediPagatiConRicevutaHandler extends BasicHandler {

	private static final long serialVersionUID = 1L;

	@Override
	public void invoke(MessageContext msgContext) throws AxisFault {
		try {
			editMessage(msgContext);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void editMessage(MessageContext msgContext) throws Exception {
		Message inMsg = msgContext.getRequestMessage();
		Message outMsg = msgContext.getResponseMessage();
		if (outMsg == null) {

			SOAPPart soapPart = inMsg.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();

			SOAPBody body = envelope.getBody();

			SOAPElement bodyElement = body.addChildElement(envelope.createName("paaSILChiediPagatiConRicevuta", "ns1", "http://www.regione.veneto.it/pagamenti/ente/"));
			Iterator<Node> childElements = body.getChildElements();
			while (childElements.hasNext()) {
				Node node = childElements.next();
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					SOAPElement soapElement = (SOAPElement) node;
					bodyElement.addChildElement(soapElement);
					body.removeChild(node);
				}
			}

			inMsg.saveChanges();
		}
	}
}