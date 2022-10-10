package it.servizidigitali.gestionepagamenti.frontend.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.servizidigitali.common.utility.enumeration.TipoServizio;
import it.servizidigitali.gestionepagamenti.common.enumeration.StatoPagamento;
import it.servizidigitali.gestionepagamenti.model.Pagamento;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;

@Component(name = "getOrganizzazioniService", immediate = true, service = GestionePagamentiService.class)
public class GestionePagamentiService {
	
	public static final Log LOG = LogFactoryUtil.getLog(GestionePagamentiService.class);

	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private GroupLocalService groupLocalService;
	
	@Reference
	private TipologiaLocalService tipologiaLocalService;
	
	@Reference
	private ServizioLocalService servizioLocalService;
	
	public List<Organization> getAllParentsOrganizations() {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Organization.class, this.getClass().getClassLoader());
		dynamicQuery.add(RestrictionsFactoryUtil.eq("parentOrganizationId", 0L));
		
		return organizationLocalService.dynamicQuery(dynamicQuery);
	}
	
	public Organization getOrganization(long organizationId) {
		
		Organization organization = null;
		
		try {
			organization = organizationLocalService.getOrganization(organizationId);
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
		
		return organization;
	}
	
	public List<Servizio> getAllServizi() {
		
		Tipologia tipologia = tipologiaLocalService.getTipologiaByCodice(TipoServizio.PAGAMENTO.name());
		
		return servizioLocalService.getTipologiaServizios(tipologia.getTipologiaId());
	}
	
	public void initDataForView(Pagamento pagamento) {
		
		String nomeOrganizzazione = "-";
		
		long groupId = pagamento.getGroupId();
		long organizationId = 0;
		Organization organization = null;
		
		if (groupId != 0) {
			try {
				Group group = groupLocalService.getGroup(groupId);
				
				organizationId = group.getOrganizationId();
				
			} catch (PortalException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		if (organizationId != 0) {
			organization = this.getOrganization(organizationId);
		}
		if (Validator.isNotNull(organization)) {
			nomeOrganizzazione = organization.getName();
		}
		pagamento.setNomeOrganizzazione(nomeOrganizzazione);
	}
	
	public String[] getCsvHeader() {
		return new String[] { "ID Pagamento", "Categoria", "Codice IUV", "Stato Pagamento",
				"C.F. o P.I. Cliente", "Nome Cliente", "Causale", "Data Inserimento", "Data Operazione",
				"Email Quietanza", "Importo Gateway", "Importo Totale"};
	}
	
	public List<List<String>> getValuesForCsv(List<Pagamento> listaPagamenti) {
		
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy HH:mm");
		
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("0.00", decimalFormatSymbols);
		decimalFormat.setGroupingUsed(false);
		
		List<List<String>> valuesForCsv = new ArrayList<>();
		
		listaPagamenti.forEach(pagamento -> {
			List<String> recordValues = new ArrayList<>();
			recordValues.add(String.valueOf(pagamento.getPagamentoId()));
			recordValues.add(pagamento.getNomeServizio());
			recordValues.add(pagamento.getIuv());
			recordValues.add(StatoPagamento.getDescrizioneByName(pagamento.getStato()));
			recordValues.add(pagamento.getIdFiscaleCliente());
			recordValues.add(pagamento.getDenominazioneCliente());
			recordValues.add(pagamento.getCausale());
			recordValues.add(dateFormat.format(pagamento.getCreateDate()));
			recordValues.add(dateFormat.format(pagamento.getModifiedDate()));
			recordValues.add(pagamento.getEmailQuietanza());
			recordValues.add(decimalFormat.format(pagamento.getCommissioni()));
			recordValues.add(decimalFormat.format(pagamento.getImporto()));
			
			valuesForCsv.add(recordValues);
		});
		
		return valuesForCsv;
	}
}