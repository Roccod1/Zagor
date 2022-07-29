package it.servizidigitali.file.utility.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.servizidigitali.file.utility.pdf.PDFConverter;

/**
 *
 * @author pindi
 *
 */
public class PDFonverterTest {

	private PDFConverter pdfConverter;

	@Before
	public void setUp() {
		pdfConverter = new PDFConverter();
	}

	@Test
	public void test() throws IOException {

		byte[] pdf = pdfConverter.generatePDF(Files.readString(Paths.get("/tmp/temp.html")));

		Files.write(Paths.get("/tmp/temp.pdf"), pdf);

		Assert.assertNotNull(pdf);
	}

}
