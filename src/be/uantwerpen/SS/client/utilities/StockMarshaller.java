package be.uantwerpen.SS.client.utilities;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import be.uantwerpen.SS.client.model.stock.Stock;

import java.io.*;


public class StockMarshaller {
	JAXBContext context = null;
    public void marshalStockToXML(Stock stock) {
        StringWriter writer = new StringWriter();
        try {
            context = JAXBContext.newInstance("be.uantwerpen.SS.client.model.stock");
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(stock, writer);
            File file = new File("stock.xml");
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

    public Stock unmarshalStockToXML(){
    	JAXBContext context = null;
        Stock stock = null;
        File file = new File("stock.xml");
        try {
            context = JAXBContext.newInstance("be.uantwerpen.SS.client.model.stock");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            stock = (Stock) unmarshaller.unmarshal(file);
            return stock;
        } catch (JAXBException e) {
            System.err.printf("\nSomething went wrong initializing the unmarshaller.\n%s", e.getMessage());
            e.printStackTrace();
        }
        return stock;
    }
}
