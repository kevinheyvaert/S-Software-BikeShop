package be.uantwerpen.SS.client.model.verkoopsRapport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Klant {
	@XmlElement
	private String naam;
	@XmlElement
	private String nummer;
	@XmlElement
	private String adres;
	
	public Klant(){
	}
	
	public Klant (String naam, String nummer, String adres){
		this.naam = naam;
		this.nummer = nummer;
		this.adres = adres;
	}

}
