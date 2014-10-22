package be.uantwerpen.SS.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "kader")
public class Kader extends Product {
	@XmlElement(name="graverenDefaultWaarde")
	private boolean graverenDefaultWaarde;
	@XmlElement(name="kleur")
	private String kleur;

	public Kader(String iD, String naam) {
		super(iD, naam);
		graverenDefaultWaarde = false;
		kleur = "wit";
	}

	/**
	 * @return de graverenDefaultWaarde opvragen
	 */
	public boolean isGraverenDefaultWaarde() {
		return graverenDefaultWaarde;
	}

	/**
	 * @param graverenDefaultWaarde de graverenDefaultWaarde aanpassen
	 */
	public void setGraverenDefaultWaarde(boolean graverenDefaultWaarde) {
		this.graverenDefaultWaarde = graverenDefaultWaarde;
	}

	/**
	 * @return de kleur opvragen
	 */
	public String getKleur() {
		return kleur;
	}

	/**
	 * @param kleur de kleur aanpassen
	 */
	public void setKleur(String kleur) {
		this.kleur = kleur;
	}


}
