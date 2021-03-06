package be.uantwerpen.SS.client.model.verkoopsRapport;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fiets {
	@XmlElement
	private String fietsNaam;
	@XmlElement
	private List<String> onderdeleniDList;
	
	public Fiets(){
	}

	public Fiets(String fietsNaam, String kaderId, String wielId, String remId, String lichtId, String basisonderdelenId){
		this.fietsNaam = fietsNaam;
		onderdeleniDList = new ArrayList <String>();
		onderdeleniDList.add(kaderId);
		onderdeleniDList.add(wielId);
		onderdeleniDList.add(remId);
		onderdeleniDList.add(lichtId);
		onderdeleniDList.add(basisonderdelenId);
	}
	
	/**
	 * @return the fietsNaam
	 */
	public String getFietsNaam() {
		return fietsNaam;
	}

	public void addOnderdeel(String iD) {
		onderdeleniDList.add(iD);
	}
	
	public void removeOnderdeel(String iD) {
		onderdeleniDList.remove(iD);
	}
	
	public List<String> getOnderdelenList() {
		return onderdeleniDList;
	}
	
	public int getTotalNumberOfOnderdelen() {
		return onderdeleniDList.size();
	}
}
