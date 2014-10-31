package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
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
	
	/* Constructor */
	public Product(String iD, String naam) {
		this.iD = iD;
		this.naam = naam;
		
		omschrijving="changeMe";
		inkoopPrijs="changeMe";
		verkoopPrijs="changeMe";
	}
	
	/* No-arg Constructor needed for XML marshalling */
	public Product() {
	}
	
	//volgens mij zijn dit geen methode die deel uitmaken van de klasse product horen eerder apparte classes te zijn in controller
	public void Bekijken(){
	}
	public void Bewerken(){
	}
	public void Vewijderen(){
	}
	public void Vermeerderen(){
	}
	public void Verminderen(){
	}
		
}
