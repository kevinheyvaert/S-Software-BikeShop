package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rem extends Product {
	private String type;
	
	public Rem(String iD, String naam, String omschrijving, String inkoopPrijs, String verkoopPrijs, int aantal) {
		super(iD, naam, omschrijving, inkoopPrijs, verkoopPrijs, aantal);
		type = "V-Brakes";
	}
	
	public Rem() {
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
