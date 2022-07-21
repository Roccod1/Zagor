package it.servizidigitali.backoffice.integration.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author pindi
 *
 */
public class DateUtils {

	/**
	 *
	 * @param calendar
	 * @return
	 */
	public static Date getUniversalDateFromCalendar(Calendar calendar) {

		if (calendar == null) {
			return null;
		}
		Calendar newCalendar = Calendar.getInstance();
		newCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

		return newCalendar.getTime();

	}

}
