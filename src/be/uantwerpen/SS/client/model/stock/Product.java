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
	
	/* Constructor */
	public Product(String iD, String naam, String omschrijving, String inkoopPrijs, String verkoopPrijs) {
		this.iD = iD;
		this.naam = naam;
		this.omschrijving= omschrijving;
		
		this.inkoopPrijs=inkoopPrijs;
		this.verkoopPrijs=verkoopPrijs;
	}
	
	/* No-arg Constructor needed for XML marshalling */
	public Product() {
	}
	
	//volgens mij zijn dit geen methode die deel uitmaken van de klasse product horen eerder apparte classes te zijn in controller
	
	public String getiD()
	{
		return iD;
		
	}
	
	public String getNaam()
	{
		return naam;
		
	}
	
	public String getOmschrijving()
	{
		return omschrijving;
		
	}
	
	public String getInkoopPrijs()
	{
		return inkoopPrijs;
		
	}
	
	public String getVerkoopPrijs()
	{
		return verkoopPrijs;
		
	}
	
	public String getKleur()
	{
		return null;

	}
	
	public String getType()
	{
		return null;

	}
	
	public String getMaat()
	{
		return null;
	}
	
	
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