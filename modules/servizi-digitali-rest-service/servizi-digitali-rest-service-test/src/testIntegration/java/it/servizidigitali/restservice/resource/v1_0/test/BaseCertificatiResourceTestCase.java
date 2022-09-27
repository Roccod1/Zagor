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

import it.servizidigitali.restservice.client.dto.v1_0.RichiestaCertificato;
import it.servizidigitali.restservice.client.http.HttpInvoker;
import it.servizidigitali.restservice.client.pagination.Page;
import it.servizidigitali.restservice.client.resource.v1_0.CertificatiResource;

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
public abstract class BaseCertificatiResourceTestCase {

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

		_certificatiResource.setContextCompany(testCompany);

		CertificatiResource.Builder builder = CertificatiResource.builder();

		certificatiResource = builder.authentication(
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
	public void testCheckInvioCertificato() throws Exception {
		Certificati postCertificati = testGetCertificati_addCertificati();

		RichiestaCertificato postRichiestaCertificato =
			testCheckInvioCertificato_addRichiestaCertificato(
				postCertificati.getId(), randomRichiestaCertificato());

		RichiestaCertificato getRichiestaCertificato =
			certificatiResource.checkInvioCertificato(postCertificati.getId());

		assertEquals(postRichiestaCertificato, getRichiestaCertificato);
		assertValid(getRichiestaCertificato);
	}

	protected RichiestaCertificato
			testCheckInvioCertificato_addRichiestaCertificato(
				long certificatiId, RichiestaCertificato richiestaCertificato)
		throws Exception {

		return certificatiResource.checkInvioCertificato(
			certificatiId, richiestaCertificato);
	}

	@Test
	public void testInvioCertificato() throws Exception {
		Certificati postCertificati = testGetCertificati_addCertificati();

		RichiestaCertificato postRichiestaCertificato =
			testInvioCertificato_addRichiestaCertificato(
				postCertificati.getId(), randomRichiestaCertificato());

		RichiestaCertificato getRichiestaCertificato =
			certificatiResource.invioCertificato(postCertificati.getId());

		assertEquals(postRichiestaCertificato, getRichiestaCertificato);
		assertValid(getRichiestaCertificato);
	}

	protected RichiestaCertificato testInvioCertificato_addRichiestaCertificato(
			long certificatiId, RichiestaCertificato richiestaCertificato)
		throws Exception {

		return certificatiResource.invioCertificato(
			certificatiId, richiestaCertificato);
	}

	protected void assertContains(
		Object certificati, List<Object> certificatis) {

		boolean contains = false;

		for (Object item : certificatis) {
			if (equals(certificati, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			certificatis + " does not contain " + certificati, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object certificati1, Object certificati2) {
		Assert.assertTrue(
			certificati1 + " does not equal " + certificati2,
			equals(certificati1, certificati2));
	}

	protected void assertEquals(
		List<Object> certificatis1, List<Object> certificatis2) {

		Assert.assertEquals(certificatis1.size(), certificatis2.size());

		for (int i = 0; i < certificatis1.size(); i++) {
			Object certificati1 = certificatis1.get(i);
			Object certificati2 = certificatis2.get(i);

			assertEquals(certificati1, certificati2);
		}
	}

	protected void assertEquals(
		RichiestaCertificato richiestaCertificato1,
		RichiestaCertificato richiestaCertificato2) {

		Assert.assertTrue(
			richiestaCertificato1 + " does not equal " + richiestaCertificato2,
			equals(richiestaCertificato1, richiestaCertificato2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> certificatis1, List<Object> certificatis2) {

		Assert.assertEquals(certificatis1.size(), certificatis2.size());

		for (Object certificati1 : certificatis1) {
			boolean contains = false;

			for (Object certificati2 : certificatis2) {
				if (equals(certificati1, certificati2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				certificatis2 + " does not contain " + certificati1, contains);
		}
	}

	protected void assertValid(Object certificati) throws Exception {
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

		java.util.Collection<Object> certificatis = page.getItems();

		int size = certificatis.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(RichiestaCertificato richiestaCertificato) {
		boolean valid = true;

		if (richiestaCertificato.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalRichiestaCertificatoAssertFieldNames()) {

			if (Objects.equals(
					"dataAggiornamento", additionalAssertFieldName)) {

				if (richiestaCertificato.getDataAggiornamento() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dataInserimento", additionalAssertFieldName)) {
				if (richiestaCertificato.getDataInserimento() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (richiestaCertificato.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("messaggio", additionalAssertFieldName)) {
				if (richiestaCertificato.getMessaggio() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("stato", additionalAssertFieldName)) {
				if (richiestaCertificato.getStato() == null) {
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

	protected String[] getAdditionalRichiestaCertificatoAssertFieldNames() {
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

	protected boolean equals(Object certificati1, Object certificati2) {
		if (certificati1 == certificati2) {
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
		RichiestaCertificato richiestaCertificato1,
		RichiestaCertificato richiestaCertificato2) {

		if (richiestaCertificato1 == richiestaCertificato2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalRichiestaCertificatoAssertFieldNames()) {

			if (Objects.equals(
					"dataAggiornamento", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						richiestaCertificato1.getDataAggiornamento(),
						richiestaCertificato2.getDataAggiornamento())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dataInserimento", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaCertificato1.getDataInserimento(),
						richiestaCertificato2.getDataInserimento())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaCertificato1.getEmail(),
						richiestaCertificato2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaCertificato1.getId(),
						richiestaCertificato2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("messaggio", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaCertificato1.getMessaggio(),
						richiestaCertificato2.getMessaggio())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("stato", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						richiestaCertificato1.getStato(),
						richiestaCertificato2.getStato())) {

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

		if (!(_certificatiResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_certificatiResource;

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
		EntityField entityField, String operator, Object certificati) {

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

	protected RichiestaCertificato randomRichiestaCertificato()
		throws Exception {

		return new RichiestaCertificato() {
			{
				dataAggiornamento = RandomTestUtil.nextDate();
				dataInserimento = RandomTestUtil.nextDate();
				email = RandomTestUtil.randomString();
				id = RandomTestUtil.randomLong();
				messaggio = RandomTestUtil.randomString();
				stato = RandomTestUtil.randomString();
			}
		};
	}

	protected CertificatiResource certificatiResource;
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
		LogFactoryUtil.getLog(BaseCertificatiResourceTestCase.class);

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
	private it.servizidigitali.restservice.resource.v1_0.CertificatiResource
		_certificatiResource;

}