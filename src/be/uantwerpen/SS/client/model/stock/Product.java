package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlElement;

//@XmlTransient
public abstract class Product {
	@XmlElement(name="iD")
	private String iD;
	
	@XmlElement(name="naam")
	private String naam;
	
	@XmlElement(name="omschrijving")
	private String omschrijving;
	
	@XmlElement(name="inkoopPrijs")
	private String inkoopPrijs;
	
	@XmlElement(name="verkoopPrijs")
	private String verkoopPrijs;
	
	private int aantal;
	
	/* Constructor */
	public Product(String iD, String naam, String omschrijving, String inkoopPrijs, String verkoopPrijs, int aantal) {
		this.iD = iD;
		this.naam = naam;
		this.omschrijving= omschrijving;
		
		this.inkoopPrijs=inkoopPrijs;
		this.verkoopPrijs=verkoopPrijs;
		this.aantal=aantal;
	}
	
	/* No-arg Constructor needed for XML marshalling */
	public Product() {
	}
	
	//volgens mij zijn dit geen methode die deel uitmaken van de klasse product horen eerder apparte classes te zijn in controller
	
	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public String getId(){
		return iD;	
	}
	
	public String getNaam(){
		return naam;
	}
	
	public String getOmschrijving(){
		return omschrijving;	
	}
	
	public String getInkoopPrijs(){
		return inkoopPrijs;	
	}
	
	public String getVerkoopPrijs(){
		return verkoopPrijs;	
	}
	
	public String getKleur(){
		return null;
	}
	
	public String getType(){
		return null;
	}
	
	public String getMaat(){
		return null;
	}
	
	
	public void Bekijken(){
	}
	
	public void Bewerken(int aantal, String inkoopPrijs, String verkoopPrijs, String omschrijving){
		this.aantal = aantal;
		this.inkoopPrijs = inkoopPrijs;
		this.verkoopPrijs = verkoopPrijs;
		this.omschrijving = omschrijving;
	}
	
	public void Vewijderen(){
	}
	public void Vermeerderen(){
	}
	public void Verminderen(){
	}
		
}
