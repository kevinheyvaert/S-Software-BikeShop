package be.uantwerpen.SS.client.model;

public class Remmen extends Product {
	private String type;
	
	public Remmen(String iD, String naam) {
		super(iD, naam);
		type = "blokjes remmen";
	}

	/**
	 * @return het type opvragen
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type het type aanpassen
	 */
	public void setType(String type) {
		this.type = type;
	}

	

}
