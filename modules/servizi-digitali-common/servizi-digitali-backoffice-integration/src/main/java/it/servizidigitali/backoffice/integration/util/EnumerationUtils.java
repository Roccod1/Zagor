/************************************************************************************
 * Copyright (c) 2011, 2019 Link Management & Technology S.p.A. via R. Scotellaro, 55 73100 - Lecce
 * - http://www.linksmt.it - All rights reserved.
 *
 * Contributors: Links Management & Technology S.p.A. - initial API and implementation
 *************************************************************************************/
package it.servizidigitali.backoffice.integration.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Gianluca Pindinelli
 *
 */
public class EnumerationUtils {

	private static final Log log = LogFactoryUtil.getLog(EnumerationUtils.class.getName());

	/**
	 * Ricerca un'enumeration.
	 *
	 * @param <T>
	 * @param enumeration
	 * @param search
	 * @return
	 */
	public static <T extends Enum<?>> T searchEnum(Class<T> enumeration, String search) {
		for (T each : enumeration.getEnumConstants()) {
			if (each.name().compareToIgnoreCase(search) == 0 || each.name().toLowerCase().contains(search.toLowerCase())) {
				return each;
			}
		}
		log.warn("Unable to read enumeration from '" + enumeration.getCanonicalName() + "' with text : '" + search + "'");
		return null;
	}
}
