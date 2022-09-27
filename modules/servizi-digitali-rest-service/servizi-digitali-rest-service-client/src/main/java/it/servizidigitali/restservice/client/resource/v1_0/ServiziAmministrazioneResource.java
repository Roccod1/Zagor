package it.servizidigitali.restservice.client.resource.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.CountServizioAmministrazione;
import it.servizidigitali.restservice.client.dto.v1_0.InfoServizioAmministrazione;
import it.servizidigitali.restservice.client.http.HttpInvoker;
import it.servizidigitali.restservice.client.pagination.Page;
import it.servizidigitali.restservice.client.problem.Problem;
import it.servizidigitali.restservice.client.serdes.v1_0.CountServizioAmministrazioneSerDes;
import it.servizidigitali.restservice.client.serdes.v1_0.InfoServizioAmministrazioneSerDes;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author pindi
 * @generated
 */
@Generated("")
public interface ServiziAmministrazioneResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<InfoServizioAmministrazione> getServiziAmministrazione(
			String nomeComune, Long codiceTipologiaServizio,
			String amministrazione)
		throws Exception;

	public HttpInvoker.HttpResponse getServiziAmministrazioneHttpResponse(
			String nomeComune, Long codiceTipologiaServizio,
			String amministrazione)
		throws Exception;

	public InfoServizioAmministrazione getInfoServizioAmministrazione(
			String codiceServizio, String nomeComune, String amministrazione)
		throws Exception;

	public HttpInvoker.HttpResponse getInfoServizioAmministrazioneHttpResponse(
			String codiceServizio, String nomeComune, String amministrazione)
		throws Exception;

	public Page<CountServizioAmministrazione> getCountServizioAmministrazione(
			String codiceServizio)
		throws Exception;

	public HttpInvoker.HttpResponse getCountServizioAmministrazioneHttpResponse(
			String codiceServizio)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public ServiziAmministrazioneResource build() {
			return new ServiziAmministrazioneResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		public Builder parameters(String... parameters) {
			if ((parameters.length % 2) != 0) {
				throw new IllegalArgumentException(
					"Parameters length is not an even number");
			}

			for (int i = 0; i < parameters.length; i += 2) {
				String parameterName = String.valueOf(parameters[i]);
				String parameterValue = String.valueOf(parameters[i + 1]);

				_parameters.put(parameterName, parameterValue);
			}

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class ServiziAmministrazioneResourceImpl
		implements ServiziAmministrazioneResource {

		public Page<InfoServizioAmministrazione> getServiziAmministrazione(
				String nomeComune, Long codiceTipologiaServizio,
				String amministrazione)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getServiziAmministrazioneHttpResponse(
					nomeComune, codiceTipologiaServizio, amministrazione);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(
					content, InfoServizioAmministrazioneSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getServiziAmministrazioneHttpResponse(
				String nomeComune, Long codiceTipologiaServizio,
				String amministrazione)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (nomeComune != null) {
				httpInvoker.parameter("nomeComune", String.valueOf(nomeComune));
			}

			if (codiceTipologiaServizio != null) {
				httpInvoker.parameter(
					"codiceTipologiaServizio",
					String.valueOf(codiceTipologiaServizio));
			}

			if (amministrazione != null) {
				httpInvoker.parameter(
					"amministrazione", String.valueOf(amministrazione));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/servizi-digitali-rest-service/v1.0/servizi-amministrazione");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public InfoServizioAmministrazione getInfoServizioAmministrazione(
				String codiceServizio, String nomeComune,
				String amministrazione)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getInfoServizioAmministrazioneHttpResponse(
					codiceServizio, nomeComune, amministrazione);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return InfoServizioAmministrazioneSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse
				getInfoServizioAmministrazioneHttpResponse(
					String codiceServizio, String nomeComune,
					String amministrazione)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (nomeComune != null) {
				httpInvoker.parameter("nomeComune", String.valueOf(nomeComune));
			}

			if (amministrazione != null) {
				httpInvoker.parameter(
					"amministrazione", String.valueOf(amministrazione));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/servizi-digitali-rest-service/v1.0/servizi-amministrazione/{codiceServizio}");

			httpInvoker.path("codiceServizio", codiceServizio);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<CountServizioAmministrazione>
				getCountServizioAmministrazione(String codiceServizio)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getCountServizioAmministrazioneHttpResponse(codiceServizio);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(
					content, CountServizioAmministrazioneSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse
				getCountServizioAmministrazioneHttpResponse(
					String codiceServizio)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			if (codiceServizio != null) {
				httpInvoker.parameter(
					"codiceServizio", String.valueOf(codiceServizio));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/servizi-digitali-rest-service/v1.0/servizi-amministrazione/count");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private ServiziAmministrazioneResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			ServiziAmministrazioneResource.class.getName());

		private Builder _builder;

	}

}