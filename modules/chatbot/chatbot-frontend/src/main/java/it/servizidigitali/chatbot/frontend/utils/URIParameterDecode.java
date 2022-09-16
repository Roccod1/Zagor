package it.servizidigitali.chatbot.frontend.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class URIParameterDecode {
	/**
	 * Decode parameters in query part of a URI into a map from parameter name to its parameter values.
	 * For parameters that occur multiple times each value is collected.
	 * Proper decoding of the parameters is performed.
	 * 
	 * Example
	 *   <pre>a=1&b=2&c=&a=4</pre>
	 * is converted into
	 *   <pre>{a=[Optional[1], Optional[4]], b=[Optional[2]], c=[Optional.empty]}</pre>
	 * @param query the query part of an URI 
	 * @return map of parameters names into a list of their values.
	 *         
	 */
	public static Map<String, List<Optional<String>>> splitQuery(String query) {
		if (query == null || query.isEmpty()) {
			return Collections.emptyMap();
		}

		return Arrays.stream(query.split("&"))
				.map(p -> splitQueryParameter(p))
				.collect(Collectors.groupingBy(e -> e.get0(), // group by parameter name
						Collectors.mapping(e -> e.get1(), Collectors.toList())));// keep parameter values and assemble into list
	}

	public static Pair<String, Optional<String>> splitQueryParameter(String parameter) {
		final String enc = "UTF-8";
		List<String> keyValue = Arrays.stream(parameter.split("="))
				.map(e -> {
					try {
						return URLDecoder.decode(e, enc);
					} catch (UnsupportedEncodingException ex) {
						throw new RuntimeUnsupportedEncodingException(ex);
					}
				}).collect(Collectors.toList());

		if (keyValue.size() == 2) {
			return new Pair(keyValue.get(0), Optional.of(keyValue.get(1)));
		} else {
			return new Pair(keyValue.get(0), Optional.empty());
		}
	}

	/** Runtime exception (instead of checked exception) to denote unsupported enconding */
	public static class RuntimeUnsupportedEncodingException extends RuntimeException {
		public RuntimeUnsupportedEncodingException(Throwable cause) {
			super(cause);
		}
	}

	/**
	 * A simple pair of two elements
	 * @param <U> first element
	 * @param <V> second element
	 */
	public static class Pair<U, V> {
		U a;
		V b;

		public Pair(U u, V v) {
			this.a = u;
			this.b = v;
		}

		public U get0() {
			return a;
		}

		public V get1() {
			return b;
		}
	}
}
