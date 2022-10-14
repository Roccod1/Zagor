package it.servizidigitali.presentatoreforms.common.util;

/**
 * Utils per bytes.
 * @author Davide Pastore
 *
 */
public class ByteUtil {

	/**
	 * Restituisce una stringa leggibile con il numero di byte.
	 * @param bytes Il numero di byte.
	 * @param si Se si deve utilizzare la notazione SI.
	 * @return Restituisce una stringa leggibile con il numero di byte.
	 * @see https://stackoverflow.com/a/3758880/1992780
	 */
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
