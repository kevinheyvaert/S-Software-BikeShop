package be.uantwerpen.SS.client.utilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import be.uantwerpen.SS.client.model.verkoopsRapport.VerkoopsRapport;

import java.io.*;

public class VerkoopsRapportMarshaller {
	JAXBContext context = null;
    public void marshalVerkoopsRapportToXML(VerkoopsRapport verkoopsRapport) {
        StringWriter writer = new StringWriter();
        try {
            context = JAXBContext.newInstance("be.uantwerpen.SS.client.model.verkoopsRapport");
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(verkoopsRapport, writer);
            File file = new File("verkoopsRapport.xml");
            FileWriter fw =null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(writer.toString());
                bw.close();
            } catch (IOException e) {
                System.err.printf("\nSomething went wrong writing the files.\n%s",e.getMessage());
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            System.err.printf("\nSomething went wrong initializing the marshaller.\n%s", e.getMessage());
            e.printStackTrace();
        }
    }

    public VerkoopsRapport unmarshalVerkoopsRapportFromXML(){
    	JAXBContext context = null;
        VerkoopsRapport verkoopsRapport = null;
        File file = new File("verkoopsRapport.xml");
        try {
            context = JAXBContext.newInstance("be.uantwerpen.SS.client.model.verkoopsRapport");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            verkoopsRapport = (VerkoopsRapport) unmarshaller.unmarshal(file);
            return verkoopsRapport;
        } catch (JAXBException e) {
            System.err.printf("\nSomething went wrong initializing the unmarshaller.\n%s", e.getMessage());
            e.printStackTrace();
        }
        return verkoopsRapport;
    }
}
