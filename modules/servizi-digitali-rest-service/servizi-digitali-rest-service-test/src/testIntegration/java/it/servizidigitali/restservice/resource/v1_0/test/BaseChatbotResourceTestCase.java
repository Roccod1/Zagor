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

import it.servizidigitali.restservice.client.dto.v1_0.ChatbotAnswer;
import it.servizidigitali.restservice.client.dto.v1_0.ChatbotSession;
import it.servizidigitali.restservice.client.http.HttpInvoker;
import it.servizidigitali.restservice.client.pagination.Page;
import it.servizidigitali.restservice.client.resource.v1_0.ChatbotResource;

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
public abstract class BaseChatbotResourceTestCase {

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

		_chatbotResource.setContextCompany(testCompany);

		ChatbotResource.Builder builder = ChatbotResource.builder();

		chatbotResource = builder.authentication(
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
	public void testGetChatbotMessaggioServizio() throws Exception {
		Chatbot postChatbot = testGetChatbot_addChatbot();

		ChatbotAnswer postChatbotAnswer =
			testGetChatbotMessaggioServizio_addChatbotAnswer(
				postChatbot.getId(), randomChatbotAnswer());

		ChatbotAnswer getChatbotAnswer =
			chatbotResource.getChatbotMessaggioServizio(postChatbot.getId());

		assertEquals(postChatbotAnswer, getChatbotAnswer);
		assertValid(getChatbotAnswer);
	}

	protected ChatbotAnswer testGetChatbotMessaggioServizio_addChatbotAnswer(
			long chatbotId, ChatbotAnswer chatbotAnswer)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testAddChatbotSession() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(Object chatbot, List<Object> chatbots) {
		boolean contains = false;

		for (Object item : chatbots) {
			if (equals(chatbot, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(chatbots + " does not contain " + chatbot, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Object chatbot1, Object chatbot2) {
		Assert.assertTrue(
			chatbot1 + " does not equal " + chatbot2,
			equals(chatbot1, chatbot2));
	}

	protected void assertEquals(
		List<Object> chatbots1, List<Object> chatbots2) {

		Assert.assertEquals(chatbots1.size(), chatbots2.size());

		for (int i = 0; i < chatbots1.size(); i++) {
			Object chatbot1 = chatbots1.get(i);
			Object chatbot2 = chatbots2.get(i);

			assertEquals(chatbot1, chatbot2);
		}
	}

	protected void assertEquals(
		ChatbotAnswer chatbotAnswer1, ChatbotAnswer chatbotAnswer2) {

		Assert.assertTrue(
			chatbotAnswer1 + " does not equal " + chatbotAnswer2,
			equals(chatbotAnswer1, chatbotAnswer2));
	}

	protected void assertEquals(
		ChatbotSession chatbotSession1, ChatbotSession chatbotSession2) {

		Assert.assertTrue(
			chatbotSession1 + " does not equal " + chatbotSession2,
			equals(chatbotSession1, chatbotSession2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> chatbots1, List<Object> chatbots2) {

		Assert.assertEquals(chatbots1.size(), chatbots2.size());

		for (Object chatbot1 : chatbots1) {
			boolean contains = false;

			for (Object chatbot2 : chatbots2) {
				if (equals(chatbot1, chatbot2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				chatbots2 + " does not contain " + chatbot1, contains);
		}
	}

	protected void assertValid(Object chatbot) throws Exception {
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

		java.util.Collection<Object> chatbots = page.getItems();

		int size = chatbots.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(ChatbotAnswer chatbotAnswer) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalChatbotAnswerAssertFieldNames()) {

			if (Objects.equals("messaggio", additionalAssertFieldName)) {
				if (chatbotAnswer.getMessaggio() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("pathServizio", additionalAssertFieldName)) {
				if (chatbotAnswer.getPathServizio() == null) {
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

	protected void assertValid(ChatbotSession chatbotSession) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalChatbotSessionAssertFieldNames()) {

			if (Objects.equals("fallbackCount", additionalAssertFieldName)) {
				if (chatbotSession.getFallbackCount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastDate", additionalAssertFieldName)) {
				if (chatbotSession.getLastDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"lastIntentMatched", additionalAssertFieldName)) {

				if (chatbotSession.getLastIntentMatched() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastMessage", additionalAssertFieldName)) {
				if (chatbotSession.getLastMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("messageCount", additionalAssertFieldName)) {
				if (chatbotSession.getMessageCount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("negativeCount", additionalAssertFieldName)) {
				if (chatbotSession.getNegativeCount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("positiveCount", additionalAssertFieldName)) {
				if (chatbotSession.getPositiveCount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("resetCount", additionalAssertFieldName)) {
				if (chatbotSession.getResetCount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("sessionId", additionalAssertFieldName)) {
				if (chatbotSession.getSessionId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (chatbotSession.getStartDate() == null) {
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

	protected String[] getAdditionalChatbotAnswerAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalChatbotSessionAssertFieldNames() {
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

	protected boolean equals(Object chatbot1, Object chatbot2) {
		if (chatbot1 == chatbot2) {
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
		ChatbotAnswer chatbotAnswer1, ChatbotAnswer chatbotAnswer2) {

		if (chatbotAnswer1 == chatbotAnswer2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalChatbotAnswerAssertFieldNames()) {

			if (Objects.equals("messaggio", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotAnswer1.getMessaggio(),
						chatbotAnswer2.getMessaggio())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("pathServizio", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotAnswer1.getPathServizio(),
						chatbotAnswer2.getPathServizio())) {

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

	protected boolean equals(
		ChatbotSession chatbotSession1, ChatbotSession chatbotSession2) {

		if (chatbotSession1 == chatbotSession2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalChatbotSessionAssertFieldNames()) {

			if (Objects.equals("fallbackCount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getFallbackCount(),
						chatbotSession2.getFallbackCount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getLastDate(),
						chatbotSession2.getLastDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"lastIntentMatched", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						chatbotSession1.getLastIntentMatched(),
						chatbotSession2.getLastIntentMatched())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastMessage", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getLastMessage(),
						chatbotSession2.getLastMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("messageCount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getMessageCount(),
						chatbotSession2.getMessageCount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("negativeCount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getNegativeCount(),
						chatbotSession2.getNegativeCount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("positiveCount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getPositiveCount(),
						chatbotSession2.getPositiveCount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("resetCount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getResetCount(),
						chatbotSession2.getResetCount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("sessionId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getSessionId(),
						chatbotSession2.getSessionId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						chatbotSession1.getStartDate(),
						chatbotSession2.getStartDate())) {

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

		if (!(_chatbotResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_chatbotResource;

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
		EntityField entityField, String operator, Object chatbot) {

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

	protected ChatbotAnswer randomChatbotAnswer() throws Exception {
		return new ChatbotAnswer() {
			{
				messaggio = RandomTestUtil.randomString();
				pathServizio = RandomTestUtil.randomString();
			}
		};
	}

	protected ChatbotSession randomChatbotSession() throws Exception {
		return new ChatbotSession() {
			{
				fallbackCount = RandomTestUtil.randomInteger();
				lastDate = RandomTestUtil.nextDate();
				lastIntentMatched = RandomTestUtil.randomString();
				lastMessage = RandomTestUtil.randomString();
				messageCount = RandomTestUtil.randomInteger();
				negativeCount = RandomTestUtil.randomInteger();
				positiveCount = RandomTestUtil.randomInteger();
				resetCount = RandomTestUtil.randomInteger();
				sessionId = RandomTestUtil.randomString();
				startDate = RandomTestUtil.nextDate();
			}
		};
	}

	protected ChatbotResource chatbotResource;
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
		LogFactoryUtil.getLog(BaseChatbotResourceTestCase.class);

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
	private it.servizidigitali.restservice.resource.v1_0.ChatbotResource
		_chatbotResource;

}