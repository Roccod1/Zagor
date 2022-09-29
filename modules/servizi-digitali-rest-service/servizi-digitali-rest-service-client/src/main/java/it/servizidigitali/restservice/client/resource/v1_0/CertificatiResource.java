package it.servizidigitali.restservice.client.resource.v1_0;

import it.servizidigitali.restservice.client.dto.v1_0.RichiestaCertificato;
import it.servizidigitali.restservice.client.http.HttpInvoker;
import it.servizidigitali.restservice.client.problem.Problem;
import it.servizidigitali.restservice.client.serdes.v1_0.RichiestaCertificatoSerDes;

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
public interface CertificatiResource {

	public static Builder builder() {
		return new Builder();
	}

	public RichiestaCertificato checkInvioCertificato(
			String userToken, String nomeComune, Long idDestinazioneUso,
			String codiceServizio, String amministrazione, String codiceFiscale)
		throws Exception;

	public HttpInvoker.HttpResponse checkInvioCertificatoHttpResponse(
			String userToken, String nomeComune, Long idDestinazioneUso,
			String codiceServizio, String amministrazione, String codiceFiscale)
		throws Exception;

	public RichiestaCertificato invioCertificato(
			String userToken, String nomeComune, Long idDestinazioneUso,
			String codiceServizio, String amministrazione, String codiceFiscale)
		throws Exception;

	public HttpInvoker.HttpResponse invioCertificatoHttpResponse(
			String userToken, String nomeComune, Long idDestinazioneUso,
			String codiceServizio, String amministrazione, String codiceFiscale)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public CertificatiResource build() {
			return new CertificatiResourceImpl(this);
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

	public static class CertificatiResourceImpl implements CertificatiResource {

		public RichiestaCertificato checkInvioCertificato(
				String userToken, String nomeComune, Long idDestinazioneUso,
				String codiceServizio, String amministrazione,
				String codiceFiscale)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				checkInvioCertificatoHttpResponse(
					userToken, nomeComune, idDestinazioneUso, codiceServizio,
					amministrazione, codiceFiscale);

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
				return RichiestaCertificatoSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse checkInvioCertificatoHttpResponse(
				String userToken, String nomeComune, Long idDestinazioneUso,
				String codiceServizio, String amministrazione,
				String codiceFiscale)
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

			if (idDestinazioneUso != null) {
				httpInvoker.parameter(
					"idDestinazioneUso", String.valueOf(idDestinazioneUso));
			}

			if (codiceServizio != null) {
				httpInvoker.parameter(
					"codiceServizio", String.valueOf(codiceServizio));
			}

			if (amministrazione != null) {
				httpInvoker.parameter(
					"amministrazione", String.valueOf(amministrazione));
			}

			if (codiceFiscale != null) {
				httpInvoker.parameter(
					"codiceFiscale", String.valueOf(codiceFiscale));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/servizi-digitali-rest-service/v1.0/certificati/check-invio");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public RichiestaCertificato invioCertificato(
				String userToken, String nomeComune, Long idDestinazioneUso,
				String codiceServizio, String amministrazione,
				String codiceFiscale)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				invioCertificatoHttpResponse(
					userToken, nomeComune, idDestinazioneUso, codiceServizio,
					amministrazione, codiceFiscale);

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
				return RichiestaCertificatoSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse invioCertificatoHttpResponse(
				String userToken, String nomeComune, Long idDestinazioneUso,
				String codiceServizio, String amministrazione,
				String codiceFiscale)
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

			if (idDestinazioneUso != null) {
				httpInvoker.parameter(
					"idDestinazioneUso", String.valueOf(idDestinazioneUso));
			}

			if (codiceServizio != null) {
				httpInvoker.parameter(
					"codiceServizio", String.valueOf(codiceServizio));
			}

			if (amministrazione != null) {
				httpInvoker.parameter(
					"amministrazione", String.valueOf(amministrazione));
			}

			if (codiceFiscale != null) {
				httpInvoker.parameter(
					"codiceFiscale", String.valueOf(codiceFiscale));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/servizi-digitali-rest-service/v1.0/certificati/invio");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private CertificatiResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			CertificatiResource.class.getName());

		private Builder _builder;

	}

}