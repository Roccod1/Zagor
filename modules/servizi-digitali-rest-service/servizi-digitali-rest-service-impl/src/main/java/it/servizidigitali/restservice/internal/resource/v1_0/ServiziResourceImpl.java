package it.servizidigitali.restservice.internal.resource.v1_0;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import it.servizidigitali.common.utility.OrganizationUtility;
import it.servizidigitali.gestioneenti.model.ServizioEnte;
import it.servizidigitali.gestioneenti.service.ServizioEnteLocalService;
import it.servizidigitali.gestioneenti.service.persistence.ServizioEntePK;
import it.servizidigitali.gestioneservizi.model.Servizio;
import it.servizidigitali.gestioneservizi.model.Tipologia;
import it.servizidigitali.gestioneservizi.service.ServizioLocalService;
import it.servizidigitali.gestioneservizi.service.TipologiaLocalService;
import it.servizidigitali.restservice.dto.v1_0.CountServizioEnte;
import it.servizidigitali.restservice.dto.v1_0.InfoServizioEnte;
import it.servizidigitali.restservice.internal.constant.ServiziDigitaliRestConstants;
import it.servizidigitali.restservice.internal.converter.EntityToSchemaModelConverter;
import it.servizidigitali.restservice.internal.util.MessageUtil;
import it.servizidigitali.restservice.resource.v1_0.ServiziResource;

/**
 * @author pindi
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/servizi.properties", scope = ServiceScope.PROTOTYPE, service = ServiziResource.class)
public class ServiziResourceImpl extends BaseServiziResourceImpl {

	@Reference
	private ServizioEnteLocalService servizioEnteLocalService;

	@Reference
	private ServizioLocalService servizioLocalService;

	@Reference
	private OrganizationLocalService organizationLocalService;

	@Reference
	private CompanyLocalService companyLocalService;

	@Reference
	private OrganizationUtility _organizationUtility;

	@Reference
	private EntityToSchemaModelConverter entityToSchemaModelConverter;
	
	@Reference
	private ExpandoValueLocalService expandoValueLocalService;

	@Override
	public Page<InfoServizioEnte> getServiziEnte(String nomeComune, @NotNull Long codiceTipologiaServizio, String amministrazione) throws Exception {
		DynamicQuery seQuery = servizioEnteLocalService.dynamicQuery();

		filterByTipologia(codiceTipologiaServizio, seQuery);
		filterByAmministrazione(amministrazione, seQuery);

		List<ServizioEnte> servizioEntes = servizioEnteLocalService.dynamicQuery(seQuery);
		
		List<InfoServizioEnte> payload = new ArrayList<>();
		for (ServizioEnte servizioEnte : servizioEntes) {
			Servizio servizio = servizioLocalService.fetchServizio(servizioEnte.getServizioId());
			payload.add(entityToSchemaModelConverter.getInfoServizioEnte(servizioEnte, servizioEnte.getOrganization(), servizio));
		}
		
		Page<InfoServizioEnte> page = Page.of(payload, Pagination.of(1, payload.size()), payload.size());
		return page;
	}

	private void filterByTipologia(Long codiceTipologiaServizio, DynamicQuery seQuery) {
		List<Long> serviziTipologia = servizioLocalService
				.getTipologiaServizios(codiceTipologiaServizio)
				.stream()
				.map(x -> x.getServizioId())
				.collect(Collectors.toList());

		seQuery.add(RestrictionsFactoryUtil.in("primaryKey.servizioId", serviziTipologia));
	}

	private void filterByAmministrazione(String amministrazione, DynamicQuery seQuery) {
		if (amministrazione != null && !amministrazione.isBlank()) {
			ClassLoader classLoader = getClass().getClassLoader();

			DynamicQuery expandoColumn = DynamicQueryFactoryUtil.forClass(ExpandoColumn.class, classLoader);
			expandoColumn.add(RestrictionsFactoryUtil.eq("name", "codiceIPA"));
			expandoColumn.setProjection(ProjectionFactoryUtil.property("columnId"));

			DynamicQuery expandoValue = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, classLoader);
			expandoValue.add(RestrictionsFactoryUtil.like("data", StringPool.PERCENT + amministrazione + StringPool.PERCENT));
			expandoValue.add(PropertyFactoryUtil.forName("columnId").in(expandoColumn));
			expandoValue.setProjection(ProjectionFactoryUtil.property("classPK"));

			List<Long> organizationIds = expandoValueLocalService.dynamicQuery(expandoValue);
			seQuery.add(RestrictionsFactoryUtil.in("organizationId", organizationIds));
		}
	}

	@Override
	public Page<CountServizioEnte> getCountServizioEnte(String codiceServizio) throws Exception {
		// TODO Auto-generated method stub
		return super.getCountServizioEnte(codiceServizio);
	}

	@Override
	public InfoServizioEnte getInfoServizioEnte(@NotNull String codiceServizio, String nomeComune, String amministrazione) throws Exception {

		MessageUtil messageUtil = new MessageUtil(ServiziDigitaliRestConstants.BUNDLE_SYMBOLIC_NAME, null);

		Organization organization = _organizationUtility.getByName(nomeComune);

		// Amministrazione = codice ipa = query su expando bridge

		if (Validator.isNull(organization)) {

			String message = messageUtil.getMessage("resourceNotFoundMessage", "Organization");

			throw new NotFoundException(message);
		}

		Servizio servizio = servizioLocalService.getServizioByCodice(codiceServizio);
		if (servizio == null) {
			String message = messageUtil.getMessage("resourceNotFoundMessage", "Servizio");
			throw new NotFoundException(message);
		}
		ServizioEntePK servizioEntePK = new ServizioEntePK(servizio.getServizioId(), organization.getOrganizationId());
		ServizioEnte servizioEnte = servizioEnteLocalService.getServizioEnte(servizioEntePK);

		if (servizioEnte == null || !servizioEnte.isAttivo()) {
			String message = messageUtil.getMessage("resourceNotFoundMessage", "Servizio ente");
			throw new NotFoundException(message);
		}

		InfoServizioEnte infoServizioEnte = entityToSchemaModelConverter.getInfoServizioEnte(servizioEnte, organization, servizio);

		return infoServizioEnte;
	}

}