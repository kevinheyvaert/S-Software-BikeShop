package be.uantwerpen.SS.client.model.stock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Kader extends Product {

	private boolean graverenDefaultWaarde;

	private String kleur;

	public Kader(String iD, String naam) {
		super(iD, naam);
		graverenDefaultWaarde = false;
		kleur = "wit";
	}
	
	public Kader() {
		
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
	@Override
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
