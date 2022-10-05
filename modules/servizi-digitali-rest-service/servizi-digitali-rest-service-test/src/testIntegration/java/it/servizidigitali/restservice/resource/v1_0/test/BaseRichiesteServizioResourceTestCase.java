package it.servizidigitali.restservice.resource.v1_0.test;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import it.servizidigitali.restservice.client.dto.v1_0.RichiestaServizio;
import it.servizidigitali.restservice.client.http.HttpInvoker;
import it.servizidigitali.restservice.client.pagination.Page;
import it.servizidigitali.restservice.client.resource.v1_0.RichiesteServizioResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public abstract class BaseRichiesteServizioResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_richiesteServizioResource.setContextCompany(testCompany);

		RichiesteServizioResource.Builder builder =
			RichiesteServizioResource.builder();

		richiesteServizioResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testSearchRichiesteServizio() throws Exception {
		Page<RichiesteServizio> page =
			richiesteServizioResource.searchRichiesteServizio(
				null, null, RandomTestUtil.randomString());

		long totalCount = page.getTotalCount();

		RichiesteServizio richiesteServizio1 =
			testSearchRichiesteServizio_addRichiesteServizio(
				randomRichiesteServizio());

		RichiesteServizio richiesteServizio2 =
			testSearchRichiesteServizio_addRichiesteServizio(
				randomRichiesteServizio());

		page = richiesteServizioResource.searchRichiesteServizio(
			null, null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			richiesteServizio1, (List<RichiesteServizio>)page.getItems());
		assertContains(
			richiesteServizio2, (List<RichiesteServizio>)page.getItems());
		assertValid(page);
	}

	protected RichiesteServizio
			testSearchRichiesteServizio_addRichiesteServizio(
				RichiesteServizio richiesteServizio)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testInsertRichiestaServizio() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetRichiestaServizio() throws Exception {
		RichiesteServizio postRichiesteServizio =
			testGetRichiesteServizio_addRichiesteServizio();

		RichiestaServizio postRichiestaServizio =
			testGetRichiestaServizio_addRichiestaServizio(
				postRichiesteServizio.getId(), randomRichiestaServizio());

		RichiestaServizio getRichiestaServizio =
			richiesteServizioResource.getRichiestaServizio(
				postRichiesteServizio.getId());

		assertEquals(postRichiestaServizio, getRichiestaServizio);
		assertValid(getRichiestaServizio);
	}

	protected RichiestaServizio testGetRichiestaServizio_addRichiestaServizio(
			long richiesteServizioId, RichiestaServizio richiestaServizio)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPatchRichiestaServizio() throws Exception {
		RichiesteServizio postRichiesteServizio =
			testPatchRichiesteServizio_addRichiesteServizio();

		testPatchRichiestaServizio_addRichiestaServizio(
			postRichiesteServizio.getId(), randomRichiestaServizio());

		RichiestaServizio randomRichiestaServizio = randomRichiestaServizio();

		RichiestaServizio patchRichiestaServizio =
			richiesteServizioResource.patchRichiestaServizio(null, null);

		assertEquals(randomRichiestaServizio, patchRichiestaServizio);
		assertValid(patchRichiestaServizio);
	}

	protected RichiestaServizio testPatchRichiestaServizio_addRichiestaServizio(
			long richiesteServizioId, RichiestaServizio richiestaServizio)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateRichiestaServizio() throws Exception {
		RichiesteServizio postRichiesteServizio =
			testPutRichiesteServizio_addRichiesteServizio();

		testUpdateRichiestaServizio_addRichiestaServizio(
			postRichiesteServizio.getId(), randomRichiestaServizio());

		RichiestaServizio randomRichiestaServizio = randomRichiestaServizio();

		RichiestaServizio putRichiestaServizio =
			richiesteServizioResource.updateRichiestaServizio(null, null);

		assertEquals(randomRichiestaServizio, putRichiestaServizio);
		assertValid(putRichiestaServizio);
	}

	protected RichiestaServizio
			testUpdateRichiestaServizio_addRichiestaServizio(
				long richiesteServizioId, RichiestaServizio richiestaServizio)
		throws Exception {

		return richiesteServizioResource.updateRichiestaServizio(
			richiesteServizioId, richiestaServizio);
	}

	protected void assertContains(
		Object richiesteServizio, List<Object> richiesteServizios) {

		boolean contains = false;

		for (Object item : richiesteServizios) {
			if (equals(richiesteServizio, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			richiesteServizios + " does not contain " + richiesteServizio,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Object richiesteServizio1, Object richiesteServizio2) {

		Assert.assertTrue(
			richiesteServizio1 + " does not equal " + richiesteServizio2,
			equals(richiesteServizio1, richiesteServizio2));
	}

	protected void assertEquals(
		List<Object> richiesteServizios1, List<Object> richiesteServizios2) {

		Assert.assertEquals(
			richiesteServizios1.size(), richiesteServizios2.size());

		for (int i = 0; i < richiesteServizios1.size(); i++) {
			Object richiesteServizio1 = richiesteServizios1.get(i);
			Object richiesteServizio2 = richiesteServizios2.get(i);

			assertEquals(richiesteServizio1, richiesteServizio2);
		}
	}

	protected void assertEquals(
		RichiestaServizio richiestaServizio1,
		RichiestaServizio richiestaServizio2) {

		Assert.assertTrue(
			richiestaServizio1 + " does not equal " + richiestaServizio2,
			equals(richiestaServizio1, richiestaServizio2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> richiesteServizios1, List<Object> richiesteServizios2) {

		Assert.assertEquals(
			richiesteServizios1.size(), richiesteServizios2.size());

		for (Object richiesteServizio1 : richiesteServizios1) {
			boolean contains = false;

			for (Object richiesteServizio2 : richiesteServizios2) {
				if (equals(richiesteServizio1, richiesteServizio2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				richiesteServizios2 + " does not contain " + richiesteServizio1,
				contains);
		}
	}

	protected void assertValid(Object richiesteServizio) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> richiesteServizios = page.getItems();

		int size = richiesteServizios.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(RichiestaServizio richiestaServizio) {
		boolean valid = true;

		if (richiestaServizio.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalRichiestaServizioAssertFieldNames()) {

			if (Objects.equals(
					"codiceAreaTematica", additionalAssertFieldName)) {

				if (richiestaServizio.getCodiceAreaTematica() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"codiceFiscaleDelegato", additionalAssertFieldName)) {

				if (richiestaServizio.getCodiceFiscaleDelegato() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"codiceFiscaleRichiedente", additionalAssertFieldName)) {

				if (richiestaServizio.getCodiceFiscaleRichiedente() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"codiceIdentificativoServizio",
					additionalAssertFieldName)) {

				if (richiestaServizio.getCodiceIdentificativoServizio() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"dataAggiornamento", additionalAssertFieldName)) {

				if (richiestaServizio.getDataAggiornamento() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dataInserimento", additionalAssertFieldName)) {
				if (richiestaServizio.getDataInserimento() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dataProtocollo", additionalAssertFieldName)) {
				if (richiestaServizio.getDataProtocollo() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"dataProtocolloEsterno", additionalAssertFieldName)) {

				if (richiestaServizio.getDataProtocolloEsterno() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneAreaTematica", additionalAssertFieldName)) {

				if (richiestaServizio.getDenominazioneAreaTematica() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneEnte", additionalAssertFieldName)) {

				if (richiestaServizio.getDenominazioneEnte() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneRichiedente", additionalAssertFieldName)) {

				if (richiestaServizio.getDenominazioneRichiedente() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneServizio", additionalAssertFieldName)) {

				if (richiestaServizio.getDenominazioneServizio() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("emailRichiedente", additionalAssertFieldName)) {
				if (richiestaServizio.getEmailRichiedente() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("idProcedura", additionalAssertFieldName)) {
				if (richiestaServizio.getIdProcedura() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"identificativoEnte", additionalAssertFieldName)) {

				if (richiestaServizio.getIdentificativoEnte() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"identificativoProcesso", additionalAssertFieldName)) {

				if (richiestaServizio.getIdentificativoProcesso() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("note", additionalAssertFieldName)) {
				if (richiestaServizio.getNote() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("numeroProtocollo", additionalAssertFieldName)) {
				if (richiestaServizio.getNumeroProtocollo() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"numeroProtocolloEsterno", additionalAssertFieldName)) {

				if (richiestaServizio.getNumeroProtocolloEsterno() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("oggetto", additionalAssertFieldName)) {
				if (richiestaServizio.getOggetto() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"partitaIvaRichiedente", additionalAssertFieldName)) {

				if (richiestaServizio.getPartitaIvaRichiedente() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("stato", additionalAssertFieldName)) {
				if (richiestaServizio.getStato() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalRichiestaServizioAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		Object richiesteServizio1, Object richiesteServizio2) {

		if (richiesteServizio1 == richiesteServizio2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(
		RichiestaServizio richiestaServizio1,
		RichiestaServizio richiestaServizio2) {

		if (richiestaServizio1 == richiestaServizio2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalRichiestaServizioAssertFieldNames()) {

			if (Objects.equals(
					"codiceAreaTematica", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getCodiceAreaTematica(),
						richiestaServizio2.getCodiceAreaTematica())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"codiceFiscaleDelegato", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getCodiceFiscaleDelegato(),
						richiestaServizio2.getCodiceFiscaleDelegato())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"codiceFiscaleRichiedente", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getCodiceFiscaleRichiedente(),
						richiestaServizio2.getCodiceFiscaleRichiedente())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"codiceIdentificativoServizio",
					additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getCodiceIdentificativoServizio(),
						richiestaServizio2.getCodiceIdentificativoServizio())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"dataAggiornamento", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getDataAggiornamento(),
						richiestaServizio2.getDataAggiornamento())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dataInserimento", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getDataInserimento(),
						richiestaServizio2.getDataInserimento())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dataProtocollo", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getDataProtocollo(),
						richiestaServizio2.getDataProtocollo())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"dataProtocolloEsterno", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getDataProtocolloEsterno(),
						richiestaServizio2.getDataProtocolloEsterno())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneAreaTematica", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getDenominazioneAreaTematica(),
						richiestaServizio2.getDenominazioneAreaTematica())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneEnte", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getDenominazioneEnte(),
						richiestaServizio2.getDenominazioneEnte())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneRichiedente", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getDenominazioneRichiedente(),
						richiestaServizio2.getDenominazioneRichiedente())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"denominazioneServizio", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getDenominazioneServizio(),
						richiestaServizio2.getDenominazioneServizio())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emailRichiedente", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getEmailRichiedente(),
						richiestaServizio2.getEmailRichiedente())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getId(),
						richiestaServizio2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("idProcedura", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getIdProcedura(),
						richiestaServizio2.getIdProcedura())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"identificativoEnte", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getIdentificativoEnte(),
						richiestaServizio2.getIdentificativoEnte())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"identificativoProcesso", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getIdentificativoProcesso(),
						richiestaServizio2.getIdentificativoProcesso())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("note", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getNote(),
						richiestaServizio2.getNote())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("numeroProtocollo", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getNumeroProtocollo(),
						richiestaServizio2.getNumeroProtocollo())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"numeroProtocolloEsterno", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getNumeroProtocolloEsterno(),
						richiestaServizio2.getNumeroProtocolloEsterno())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("oggetto", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getOggetto(),
						richiestaServizio2.getOggetto())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"partitaIvaRichiedente", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaServizio1.getPartitaIvaRichiedente(),
						richiestaServizio2.getPartitaIvaRichiedente())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("stato", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaServizio1.getStato(),
						richiestaServizio2.getStato())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_richiesteServizioResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_richiesteServizioResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Object richiesteServizio) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected RichiestaServizio randomRichiestaServizio() throws Exception {
		return new RichiestaServizio() {
			{
				codiceAreaTematica = RandomTestUtil.randomString();
				codiceFiscaleDelegato = RandomTestUtil.randomString();
				codiceFiscaleRichiedente = RandomTestUtil.randomString();
				codiceIdentificativoServizio = RandomTestUtil.randomString();
				dataAggiornamento = RandomTestUtil.nextDate();
				dataInserimento = RandomTestUtil.nextDate();
				dataProtocollo = RandomTestUtil.nextDate();
				dataProtocolloEsterno = RandomTestUtil.nextDate();
				denominazioneAreaTematica = RandomTestUtil.randomString();
				denominazioneEnte = RandomTestUtil.randomString();
				denominazioneRichiedente = RandomTestUtil.randomString();
				denominazioneServizio = RandomTestUtil.randomString();
				emailRichiedente = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				identificativoEnte = RandomTestUtil.randomString();
				identificativoProcesso = RandomTestUtil.randomString();
				note = RandomTestUtil.randomString();
				numeroProtocollo = RandomTestUtil.randomString();
				numeroProtocolloEsterno = RandomTestUtil.randomString();
				oggetto = RandomTestUtil.randomString();
				partitaIvaRichiedente = RandomTestUtil.randomString();
				stato = RandomTestUtil.randomString();
			}
		};
	}

	protected RichiesteServizioResource richiesteServizioResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseRichiesteServizioResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private
		it.servizidigitali.restservice.resource.v1_0.RichiesteServizioResource
			_richiesteServizioResource;

}