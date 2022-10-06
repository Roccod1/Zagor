package it.servizidigitali.restservice.custom.model;

/**
 * 
 * @author pindi
 *
 */
public class ProvinciaDatasource extends AlpacaDatasource {
	
	public ProvinciaDatasource() {};

	public ProvinciaDatasource(String text, String value, Long idProvincia) {
		super(text, value);
		this.idProvincia = idProvincia;
	}
	
	private Long idProvincia;

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
}
