package be.uantwerpen.SS.client.model;

import java.io.Serializable;

import be.uantwerpen.SS.client.model.Kader;
import be.uantwerpen.SS.client.utilities.StockMarshaller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stock")
public class Stock implements Serializable {
	@XmlElement(name = "products")
	private List<Product> productList = new ArrayList <Product>();
	
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public int getTotalNumberOfProductsInStock() {
		return productList.size();
	}
	
	/**
	 * Saves all nodes on this server to an xml file so they can be recovered
	 * later.
	 */
	public void saveStockToXml() {
		StockMarshaller xmlMarshaller = new StockMarshaller();
		xmlMarshaller.marshalStockToXML(this);
	}
	
	public boolean getStockFromXml() {
		StockMarshaller xmlMarshaller = new StockMarshaller();
		Stock tempStock = (Stock) xmlMarshaller.unmarshalStockToXML();

		if (tempStock != null) {
			this.productList = tempStock.getProductList();
			return true;
		}
		return false;
	}
}
