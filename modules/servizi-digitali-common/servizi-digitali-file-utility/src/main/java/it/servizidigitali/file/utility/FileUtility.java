package it.servizidigitali.file.utility;

import org.osgi.service.component.annotations.Component;

/**
 * @author pindi
 *
 */
@Component(name = "fileUtility", immediate = true, service = FileUtility.class)
public class FileUtility {

	private static final long SIZE_MUL = 1000;
	private static final long KILOBYTE = SIZE_MUL;
	private static final long MEGABYTE = SIZE_MUL * KILOBYTE;
	private static final long GIGABYTE = SIZE_MUL * MEGABYTE;

	public String getHumanReadableSize(long size) {
		if (size >= GIGABYTE) {
			return String.format("%.1f GB", (float) size / GIGABYTE);
		}
		else if (size >= MEGABYTE) {
			return String.format("%.1f MB", (float) size / MEGABYTE);
		}
		else if (size >= KILOBYTE) {
			return String.format("%.1f kB", (float) size / KILOBYTE);
		}
		else {
			return size + " B";
		}
	}

}
