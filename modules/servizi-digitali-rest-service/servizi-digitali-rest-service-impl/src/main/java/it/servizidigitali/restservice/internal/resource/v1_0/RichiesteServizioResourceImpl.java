package it.servizidigitali.restservice.internal.resource.v1_0;

import it.servizidigitali.restservice.dto.v1_0.InsertRichiestaServizioRequest;
import it.servizidigitali.restservice.dto.v1_0.RichiestaServizio;
import it.servizidigitali.restservice.dto.v1_0.UpdateRichiestaServizioRequest;
import it.servizidigitali.restservice.resource.v1_0.RichiesteServizioResource;
import it.servizidigitali.scrivaniaoperatore.model.Richiesta;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

/**
 * @author pindi
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/richieste-servizio.properties",
		scope = ServiceScope.PROTOTYPE, service = RichiesteServizioResource.class
		)
public class RichiesteServizioResourceImpl
extends BaseRichiesteServizioResourceImpl {

	@Override
	public Page<RichiestaServizio> searchRichiesteServizio(Integer page, Integer size, String q) {

		ArrayList<RichiestaServizio> l = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			RichiestaServizio r = new RichiestaServizio();
			r.setId(Long.valueOf(i));
			
			if(Validator.isNotNull(user)) {
				r.setStato(user.getScreenName());
			}
			
			l.add(r);
		}
		return Page.of(l);

	}
	
	@Override
		public RichiestaServizio insertRichiestaServizio(InsertRichiestaServizioRequest insertRichiestaServizioRequest)
				throws Exception {
		
			
			RichiestaServizio r = new RichiestaServizio();
			r.setId(99l);
			
			return r;
		
		}

	@Override
	public RichiestaServizio getRichiestaServizio( Long id) throws Exception {

		RichiestaServizio r = new RichiestaServizio();
		r.setId(99L);
		return r;
	}

	@Override
	public RichiestaServizio updateRichiestaServizio(@NotNull Long id,
			UpdateRichiestaServizioRequest updateRichiestaServizioRequest) throws Exception {
		
		RichiestaServizio r = new RichiestaServizio();
		r.setId(99L);
		return r;
		
	}
	
	@Override
	public RichiestaServizio patchRichiestaServizio(@NotNull Long id,
			UpdateRichiestaServizioRequest updateRichiestaServizioRequest) throws Exception {
		RichiestaServizio r = new RichiestaServizio();
		r.setId(99L);
		r.setStato(updateRichiestaServizioRequest.getStato());
		return r;
	}
	
	@Context
	private User user;

}