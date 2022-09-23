package it.servizidigitali.restservice.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pindi
 * @generated
 */
@Generated("")
@GraphQLName("ComponenteNucleoFamiliareLight")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ComponenteNucleoFamiliareLight")
public class ComponenteNucleoFamiliareLight implements Serializable {

	public static ComponenteNucleoFamiliareLight toDTO(String json) {
		return ObjectMapperUtil.readValue(
			ComponenteNucleoFamiliareLight.class, json);
	}

	public static ComponenteNucleoFamiliareLight unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			ComponenteNucleoFamiliareLight.class, json);
	}

	@Schema(description = "Codice fiscale")
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@JsonIgnore
	public void setCodiceFiscale(
		UnsafeSupplier<String, Exception> codiceFiscaleUnsafeSupplier) {

		try {
			codiceFiscale = codiceFiscaleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Codice fiscale")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String codiceFiscale;

	@Schema(description = "Cognome")
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@JsonIgnore
	public void setCognome(
		UnsafeSupplier<String, Exception> cognomeUnsafeSupplier) {

		try {
			cognome = cognomeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Cognome")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String cognome;

	@Schema(description = "Data di nascita")
	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@JsonIgnore
	public void setDataNascita(
		UnsafeSupplier<Date, Exception> dataNascitaUnsafeSupplier) {

		try {
			dataNascita = dataNascitaUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Data di nascita")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dataNascita;

	@Schema(description = "Nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonIgnore
	public void setNome(UnsafeSupplier<String, Exception> nomeUnsafeSupplier) {
		try {
			nome = nomeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Nome")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String nome;

	@Schema(description = "Sesso")
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	@JsonIgnore
	public void setSesso(
		UnsafeSupplier<String, Exception> sessoUnsafeSupplier) {

		try {
			sesso = sessoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Sesso")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String sesso;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComponenteNucleoFamiliareLight)) {
			return false;
		}

		ComponenteNucleoFamiliareLight componenteNucleoFamiliareLight =
			(ComponenteNucleoFamiliareLight)object;

		return Objects.equals(
			toString(), componenteNucleoFamiliareLight.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (codiceFiscale != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codiceFiscale\": ");

			sb.append("\"");

			sb.append(_escape(codiceFiscale));

			sb.append("\"");
		}

		if (cognome != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cognome\": ");

			sb.append("\"");

			sb.append(_escape(cognome));

			sb.append("\"");
		}

		if (dataNascita != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dataNascita\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dataNascita));

			sb.append("\"");
		}

		if (nome != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nome\": ");

			sb.append("\"");

			sb.append(_escape(nome));

			sb.append("\"");
		}

		if (sesso != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sesso\": ");

			sb.append("\"");

			sb.append(_escape(sesso));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "it.servizidigitali.restservice.dto.v1_0.ComponenteNucleoFamiliareLight",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}