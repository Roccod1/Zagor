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

import it.servizidigitali.restservice.client.dto.v1_0.InfoServizioEnte;
import it.servizidigitali.restservice.client.http.HttpInvoker;
import it.servizidigitali.restservice.client.pagination.Page;
import it.servizidigitali.restservice.client.resource.v1_0.ServiziResource;

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
public abstract class BaseServiziResourceTestCase {

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

		_serviziResource.setContextCompany(testCompany);

		ServiziResource.Builder builder = ServiziResource.builder();

		serviziResource = builder.authentication(
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
	public void testGetServiziEnte() throws Exception {
		Page<Servizi> page = serviziResource.getServiziEnte(
			RandomTestUtil.randomString(), null, null, null,
			RandomTestUtil.randomString());

		long totalCount = page.getTotalCount();

		Servizi servizi1 = testGetServiziEnte_addServizi(randomServizi());

		Servizi servizi2 = testGetServiziEnte_addServizi(randomServizi());

		page = serviziResource.getServiziEnte(null, null, null, null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(servizi1, (List<Servizi>)page.getItems());
		assertContains(servizi2, (List<Servizi>)page.getItems());
		assertValid(page);
	}

	protected Servizi testGetServiziEnte_addServizi(Servizi servizi)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetCountServizioEnte() throws Exception {
		Page<Servizi> page = serviziResource.getCountServizioEnte(
			RandomTestUtil.randomString());

		long totalCount = page.getTotalCount();

		Servizi servizi1 = testGetCountServizioEnte_addServizi(randomServizi());

		Servizi servizi2 = testGetCountServizioEnte_addServizi(randomServizi());

		page = serviziResource.getCountServizioEnte(null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(servizi1, (List<Servizi>)page.getItems());
		assertContains(servizi2, (List<Servizi>)page.getItems());
		assertValid(page);
	}

	protected Servizi testGetCountServizioEnte_addServizi(Servizi servizi)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetInfoServizioEnte() throws Exception {
		Servizi postServizi = testGetServizi_addServizi();

		InfoServizioEnte postInfoServizioEnte =
			testGetInfoServizioEnte_addInfoServizioEnte(
				postServizi.getId(), randomInfoServizioEnte());

		InfoServizioEnte getInfoServizioEnte =
			serviziResource.getInfoServizioEnte(postServizi.getId());

		assertEquals(postInfoServizioEnte, getInfoServizioEnte);
		assertValid(getInfoServizioEnte);
	}

	protected InfoServizioEnte testGetInfoServizioEnte_addInfoServizioEnte(
			long serviziId, InfoServizioEnte infoServizioEnte)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Object servizi, List<Object> servizis) {
		boolean contains = false;

		for (Object item : servizis) {
			if (equals(servizi, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(servizis + " does not contain " + servizi, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object servizi1, Object servizi2) {
		Assert.assertTrue(
			servizi1 + " does not equal " + servizi2,
			equals(servizi1, servizi2));
	}

	protected void assertEquals(
		List<Object> servizis1, List<Object> servizis2) {

		Assert.assertEquals(servizis1.size(), servizis2.size());

		for (int i = 0; i < servizis1.size(); i++) {
			Object servizi1 = servizis1.get(i);
			Object servizi2 = servizis2.get(i);

			assertEquals(servizi1, servizi2);
		}
	}

	protected void assertEquals(
		InfoServizioEnte infoServizioEnte1,
		InfoServizioEnte infoServizioEnte2) {

		Assert.assertTrue(
			infoServizioEnte1 + " does not equal " + infoServizioEnte2,
			equals(infoServizioEnte1, infoServizioEnte2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> servizis1, List<Object> servizis2) {

		Assert.assertEquals(servizis1.size(), servizis2.size());

		for (Object servizi1 : servizis1) {
			boolean contains = false;

			for (Object servizi2 : servizis2) {
				if (equals(servizi1, servizi2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				servizis2 + " does not contain " + servizi1, contains);
		}
	}

	protected void assertValid(Object servizi) throws Exception {
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

		java.util.Collection<Object> servizis = page.getItems();

		int size = servizis.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(InfoServizioEnte infoServizioEnte) {
		boolean valid = true;

		if (infoServizioEnte.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalInfoServizioEnteAssertFieldNames()) {

			if (Objects.equals("active", additionalAssertFieldName)) {
				if (infoServizioEnte.getActive() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("chatbotInline", additionalAssertFieldName)) {
				if (infoServizioEnte.getChatbotInline() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"chatbotInlineIntent", additionalAssertFieldName)) {

				if (infoServizioEnte.getChatbotInlineIntent() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (infoServizioEnte.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("codiceIpa", additionalAssertFieldName)) {
				if (infoServizioEnte.getCodiceIpa() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"correlatedPaymentServiceCode",
					additionalAssertFieldName)) {

				if (infoServizioEnte.getCorrelatedPaymentServiceCode() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (infoServizioEnte.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("destinazioneUsos", additionalAssertFieldName)) {
				if (infoServizioEnte.getDestinazioneUsos() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nomeComune", additionalAssertFieldName)) {
				if (infoServizioEnte.getNomeComune() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("serviceCardUrl", additionalAssertFieldName)) {
				if (infoServizioEnte.getServiceCardUrl() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("serviceOnlineUrl", additionalAssertFieldName)) {
				if (infoServizioEnte.getServiceOnlineUrl() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (infoServizioEnte.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("usableByChatbot", additionalAssertFieldName)) {
				if (infoServizioEnte.getUsableByChatbot() == null) {
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

	protected String[] getAdditionalInfoServizioEnteAssertFieldNames() {
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

	protected boolean equals(Object servizi1, Object servizi2) {
		if (servizi1 == servizi2) {
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
		InfoServizioEnte infoServizioEnte1,
		InfoServizioEnte infoServizioEnte2) {

		if (infoServizioEnte1 == infoServizioEnte2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalInfoServizioEnteAssertFieldNames()) {

			if (Objects.equals("active", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getActive(),
						infoServizioEnte2.getActive())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("chatbotInline", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getChatbotInline(),
						infoServizioEnte2.getChatbotInline())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"chatbotInlineIntent", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						infoServizioEnte1.getChatbotInlineIntent(),
						infoServizioEnte2.getChatbotInlineIntent())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getCode(),
						infoServizioEnte2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("codiceIpa", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getCodiceIpa(),
						infoServizioEnte2.getCodiceIpa())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"correlatedPaymentServiceCode",
					additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						infoServizioEnte1.getCorrelatedPaymentServiceCode(),
						infoServizioEnte2.getCorrelatedPaymentServiceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getDescription(),
						infoServizioEnte2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("destinazioneUsos", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getDestinazioneUsos(),
						infoServizioEnte2.getDestinazioneUsos())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getId(), infoServizioEnte2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nomeComune", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getNomeComune(),
						infoServizioEnte2.getNomeComune())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("serviceCardUrl", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getServiceCardUrl(),
						infoServizioEnte2.getServiceCardUrl())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("serviceOnlineUrl", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getServiceOnlineUrl(),
						infoServizioEnte2.getServiceOnlineUrl())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getTitle(),
						infoServizioEnte2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("usableByChatbot", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						infoServizioEnte1.getUsableByChatbot(),
						infoServizioEnte2.getUsableByChatbot())) {

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

		if (!(_serviziResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_serviziResource;

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
		EntityField entityField, String operator, Object servizi) {

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

	protected InfoServizioEnte randomInfoServizioEnte() throws Exception {
		return new InfoServizioEnte() {
			{
				active = RandomTestUtil.randomBoolean();
				chatbotInline = RandomTestUtil.randomBoolean();
				chatbotInlineIntent = RandomTestUtil.randomString();
				code = RandomTestUtil.randomString();
				codiceIpa = RandomTestUtil.randomString();
				correlatedPaymentServiceCode = RandomTestUtil.randomString();
				description = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				nomeComune = RandomTestUtil.randomString();
				serviceCardUrl = RandomTestUtil.randomString();
				serviceOnlineUrl = RandomTestUtil.randomString();
				title = RandomTestUtil.randomString();
				usableByChatbot = RandomTestUtil.randomBoolean();
			}
		};
	}

	protected ServiziResource serviziResource;
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
		LogFactoryUtil.getLog(BaseServiziResourceTestCase.class);

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
	private it.servizidigitali.restservice.resource.v1_0.ServiziResource
		_serviziResource;

}