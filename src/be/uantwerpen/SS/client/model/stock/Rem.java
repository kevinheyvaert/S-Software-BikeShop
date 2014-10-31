package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rem extends Product {
	private String type;
	
	public Rem(String iD, String naam) {
		super(iD, naam);
		type = "blokjes remmen";
	}
	
	public Rem() {
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
