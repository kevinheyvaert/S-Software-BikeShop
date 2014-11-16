package be.uantwerpen.SS.client.model.verkoopsRapport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;


import be.uantwerpen.SS.client.utilities.VerkoopsRapportMarshaller;



@XmlRootElement(name = "verkoopsRapport")
public class VerkoopsRapport implements Serializable {
	private List<Verkoop> verkoopList;

	public VerkoopsRapport() {
		this.verkoopList = new ArrayList <Verkoop>();
	}
	
	public void addVerkoop(Verkoop verkoop) {
		verkoopList.add(verkoop);
	}
	
	public void removeVerkoop(Verkoop verkoop) {
		verkoopList.remove(verkoop);
	}
	
	@XmlElementRef
	public List<Verkoop> getVerkoopList() {
		return verkoopList;
	}
	
	public int getTotalNumberOfVerkopen() {
		return verkoopList.size();
	}
	
	/**
	 * Saves all nodes on this server to an xml file so they can be recovered
	 * later.
	 */
	public void saveVerkoopsRapportToXml() {
		VerkoopsRapportMarshaller xmlMarshaller = new VerkoopsRapportMarshaller();
		xmlMarshaller.marshalVerkoopsRapportToXML(this);
	}
	
	public boolean getVerkoopsRapportFromXml() {
		VerkoopsRapportMarshaller xmlMarshaller = new VerkoopsRapportMarshaller();
		VerkoopsRapport tempVerkoopsRapport = (VerkoopsRapport) xmlMarshaller.unmarshalVerkoopsRapportFromXML();

		if (tempVerkoopsRapport != null) {
			this.verkoopList = tempVerkoopsRapport.getVerkoopList();
			return true;
		}
		return false;
	}
}