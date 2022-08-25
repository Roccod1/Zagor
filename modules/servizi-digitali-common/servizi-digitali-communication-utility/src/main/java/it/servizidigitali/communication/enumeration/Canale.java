package it.servizidigitali.communication.enumeration;

public enum Canale {
	
	EMAIL("email"),
	PUSH("push"),
	CKAN("ckan"),
	PEC("pec"),
	FACEBOOK("facebook"),
	TWITTER("twitter");
	
	private String name;
	
	private Canale(String name){
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
	
	public static Canale getSupportedChannel(String channel){
		for(Canale ch : values()){
			if(ch.getName().equalsIgnoreCase(channel)){
				return ch;
			}
		}
		
		return null;
	}

}
