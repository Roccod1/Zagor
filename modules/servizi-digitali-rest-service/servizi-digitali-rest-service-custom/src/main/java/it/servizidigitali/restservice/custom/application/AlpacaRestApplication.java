package it.servizidigitali.restservice.custom.application;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import it.servizidigitali.common.model.Comune;
import it.servizidigitali.common.model.ComuneEstero;
import it.servizidigitali.common.model.Provincia;
import it.servizidigitali.common.model.StatoEstero;
import it.servizidigitali.common.service.ComuneEsteroLocalService;
import it.servizidigitali.common.service.ComuneLocalService;
import it.servizidigitali.common.service.ProvinciaLocalService;
import it.servizidigitali.common.service.StatoEsteroLocalService;
import it.servizidigitali.restservice.custom.model.AlpacaDatasource;
import it.servizidigitali.restservice.custom.model.ProvinciaDatasource;

@Component(//
		property = { //
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/alpaca", //
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=Alpaca.Rest"//
		}, //
		service = Application.class//
) //
public class AlpacaRestApplication extends Application {

	private static final Log log = LogFactoryUtil.getLog(AlpacaRestApplication.class.getName());

	@Reference
	private StatoEsteroLocalService statoEsteroLocalService;

	@Reference
	private ProvinciaLocalService provinciaLocalService;

	@Reference
	private ComuneLocalService comuneLocalService;

	@Reference
	private ComuneEsteroLocalService comuneEsteroLocalService;

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object> singleton(this);
	}

	@GET
	@Path("/stati-esteri")
	@Produces("application/json")
	public List<AlpacaDatasource> getStatiEsteri() {

		List<AlpacaDatasource> alpacaDatasources = new ArrayList<AlpacaDatasource>();

		List<StatoEstero> statiEsteri = statoEsteroLocalService.getStatoEsteros(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (StatoEstero statoEstero : statiEsteri) {
			alpacaDatasources.add(new AlpacaDatasource(statoEstero.getDenominazione(), String.valueOf(statoEstero.getStatoEsteroId())));
		}

		return alpacaDatasources;
	}

	@GET
	@Path("/province")
	@Produces("application/json")
	public List<ProvinciaDatasource> getProvince() {

		List<ProvinciaDatasource> alpacaDatasources = new ArrayList<ProvinciaDatasource>();

		List<Provincia> province = provinciaLocalService.getProvincias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Provincia provincia : province) {
			alpacaDatasources.add(new ProvinciaDatasource(provincia.getDenominazioneProvincia(), provincia.getSigla(), provincia.getProvinciaId()));
		}

		return alpacaDatasources;
	}

	@GET
	@Path("/comuni")
	@Produces("application/json")
	public List<AlpacaDatasource> getComuni() {

		List<AlpacaDatasource> alpacaDatasources = new ArrayList<AlpacaDatasource>();

		List<Comune> comuni = comuneLocalService.getComunes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Comune comune : comuni) {
			alpacaDatasources.add(new AlpacaDatasource(comune.getDenominazione(), String.valueOf(comune.getComuneId())));
		}

		return alpacaDatasources;
	}

	@GET
	@Path("/comuni/{siglaProvincia}")
	@Produces("application/json")
	public List<AlpacaDatasource> getComuniBySiglaProvincia(@PathParam(value = "siglaProvincia") String siglaProvincia) {

		List<AlpacaDatasource> alpacaDatasources = new ArrayList<AlpacaDatasource>();

		Provincia provinciaBySigla = provinciaLocalService.getProvinciaBySigla(siglaProvincia);
		if (provinciaBySigla != null) {
			List<Comune> comuni = comuneLocalService.getComuniByProvinciaId(provinciaBySigla.getProvinciaId());
			for (Comune comune : comuni) {
				alpacaDatasources.add(new AlpacaDatasource(comune.getDenominazione(), String.valueOf(comune.getComuneId())));
			}
		}

		return alpacaDatasources;
	}

	@GET
	@Path("/years")
	@Produces("application/json")
	public List<AlpacaDatasource> getYears() {

		List<AlpacaDatasource> alpacaDatasources = new ArrayList<AlpacaDatasource>();

		try {
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);

			for (int i = 1950; i < year + 1; i++) {
				AlpacaDatasource elem = new AlpacaDatasource(String.valueOf(i), String.valueOf(i));
				alpacaDatasources.add(elem);
			}
		}
		catch (Exception e) {
			log.error("getYears :: " + e.getMessage(), e);
		}

		return alpacaDatasources;
	}

	@GET
	@Path("/five-years")
	@Produces("application/json")
	public List<AlpacaDatasource> getFiveYears() {

		List<AlpacaDatasource> alpacaDatasources = new ArrayList<AlpacaDatasource>();

		try {
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);

			for (int i = year - 4; i < year + 1; i++) {
				AlpacaDatasource elem = new AlpacaDatasource(String.valueOf(i), String.valueOf(i));
				alpacaDatasources.add(elem);
			}
		}
		catch (Exception e) {
			log.error("getFiveYears :: " + e.getMessage(), e);
		}

		return alpacaDatasources;
	}

	@GET
	@Path("/comuni-esteri/{denominazione}")
	@Produces("application/json")
	public List<AlpacaDatasource> getComuniEsteriByDenominazione(@PathParam(value = "denominazione") String denominazione) {

		List<AlpacaDatasource> alpacaDatasources = new ArrayList<AlpacaDatasource>();

		List<ComuneEstero> comuni = comuneEsteroLocalService.getComuniEsteriByDenominazione(denominazione);
		for (ComuneEstero comune : comuni) {
			alpacaDatasources.add(new AlpacaDatasource(comune.getDenominazione(), String.valueOf(comune.getCodice())));
		}

		return alpacaDatasources;
	}

}
