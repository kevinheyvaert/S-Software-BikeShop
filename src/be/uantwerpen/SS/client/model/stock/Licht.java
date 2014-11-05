package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Licht extends Product {
	private String type;
	
	public Licht(String iD, String naam, String omschrijving, String inkoopPrijs, String verkoopPrijs) {
		super(iD, naam, omschrijving, inkoopPrijs, verkoopPrijs);
		type = "Smart";
	}
	
	public Licht() {
	}

	/**
	 * @return het type opvragen
	 */
	@Override
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
