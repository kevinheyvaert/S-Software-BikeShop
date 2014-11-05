package be.uantwerpen.SS.client.model.stock;

import java.io.Serializable;

import be.uantwerpen.SS.client.utilities.StockMarshaller;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stock")
public class Stock implements Serializable {

	private List<Product> productList;
	
	
	public Stock() {
		this.productList = new ArrayList <Product>();
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	@XmlElementRef
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