package it.servizidigitali.restservice.custom.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/alpaca",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Alpaca.Rest"
	},
	service = Application.class
)
public class AlpacaRestApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@GET
	@Path("/stati-esteri")
	@Produces("application/json")
	public List<String> getStatiEsteri() {
		List<String> res = new ArrayList<>();
		res.add("12345");
		return res;
	}
	
}
