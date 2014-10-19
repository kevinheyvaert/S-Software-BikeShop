package be.uantwerpen.SS.client.model;

public class Basisonderdelen extends Product {
	private String type;
	
	public Basisonderdelen(String iD, String naam) {
		super(iD, naam);
		type = "basisset 1";
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
