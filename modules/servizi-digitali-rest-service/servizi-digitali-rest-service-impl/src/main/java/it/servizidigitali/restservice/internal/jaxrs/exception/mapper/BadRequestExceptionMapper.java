package it.servizidigitali.restservice.internal.jaxrs.exception.mapper;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import it.servizidigitali.restservice.dto.v1_0.Error;

@Component(
		property = {
				"osgi.jaxrs.application.select=(osgi.jaxrs.name=ServiziDigitaliRestService)",
				"osgi.jaxrs.extension=true",
				"osgi.jaxrs.name=ServiziDigitaliRestService.BadRequestExceptionMapper"
			},
		service = ExceptionMapper.class
	)
public class BadRequestExceptionMapper extends BaseExceptionMapper<BadRequestException> {

	@Override
	protected Problem getProblem(BadRequestException exception) {
		
		Problem p = new Problem(Response.Status.BAD_REQUEST, BadRequestException.class.getName());
		p.setDetail(exception.getMessage());
		return p;
	}
	
	@Override
	public Response toResponse(BadRequestException exception) {
		Error error = new Error();
		error.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
		error.setMessage(exception.getMessage());
		
		Response response = Response.status(Response.Status.BAD_REQUEST).entity(error).type(MediaType.APPLICATION_JSON).build();
		return response;
	}

}
