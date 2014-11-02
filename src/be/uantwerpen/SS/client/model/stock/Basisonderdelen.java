package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlRootElement;
import be.uantwerpen.SS.client.model.stock.Product;


@XmlRootElement
public class Basisonderdelen extends Product {
	private String type;
	
	public Basisonderdelen(String iD, String naam) {
		super(iD, naam);
		type = "Type 1";
	}
	
	public Basisonderdelen() {
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
