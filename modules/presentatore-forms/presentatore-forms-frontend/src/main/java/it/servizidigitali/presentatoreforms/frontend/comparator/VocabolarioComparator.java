package it.servizidigitali.presentatoreforms.frontend.comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * {@link Comparator} per le mappe {@link Map} contenenti i vocabolari. Utilizzabile solo con mappe
 * le cui chiavi, seppur {@link String}, definiscono dei numeri.
 *
 * @author Gianluca Pindinelli
 *
 */
public class VocabolarioComparator implements Comparator<String> {

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2) {
		return new Integer(Integer.parseInt(o1)).compareTo(new Integer(Integer.parseInt(o2)));
	}

}
