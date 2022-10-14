package it.servizidigitali.presentatoreforms.common.enumeration;

public enum AlpacaOptionType {
	// Standard
		CHECKBOX("checkbox"),
		TEXT("text"),
		
		// Custom
		COMUNE("comune"),
		CONTATTI("contatti"),
		FERMATA_SCUOLA("fermataScuola"),
		NAZIONE("nazione"),
		PROVINCIA("provincia"),
		SCUOLA("scuola"),
		URL_DOCUMENTO("urldocumentofield");
		
		private String name;
		
		private AlpacaOptionType(String name){
			this.setName(name);
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
}
