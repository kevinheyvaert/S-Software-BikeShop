package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlRootElement;

import be.uantwerpen.SS.client.model.stock.Product;

@XmlRootElement
public class Wiel extends Product {
	private String type;
	private String maat;
	
	public Wiel(String iD, String naam) {
		super(iD, naam);
		type = "standaardwiel";
		maat = "universeel";
	}
	
	public Wiel() {
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

	/**
	 * @return de maat opvragen
	 */
	public String getMaat() {
		return maat;
	}

	/**
	 * @param maat de maat aanpassen
	 */
	public void setMaat(String maat) {
		this.maat = maat;
	}

}
