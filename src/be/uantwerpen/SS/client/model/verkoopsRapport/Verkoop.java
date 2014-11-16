package be.uantwerpen.SS.client.model.verkoopsRapport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Verkoop {
	@XmlElement
	private Klant klant;
	
	@XmlElement
	private Fiets fiets;
	
	private int aantal;
	
	/* Constructor */
	public Verkoop(Klant klant, Fiets fiets) {
		this.fiets = fiets;
		this.klant = klant;
	}
	
	/* No-arg Constructor needed for XML marshalling */
	public Verkoop() {
	}		
}
