package be.uantwerpen.SS.client.model.stock;

import java.io.Serializable;

import be.uantwerpen.SS.client.utilities.StockMarshaller;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stock")
public class Stock implements Serializable {

	/**
	 * Auto generated serialVersionUID
	 */
	private static final long serialVersionUID = -706270532090639321L;
	
	private List<Product> productList;

	public Stock() {
		this.productList = new ArrayList<Product>();
	}
	
	public boolean addProduct(Product product) {
		for (Product currentProduct : productList) {
			if (currentProduct.getId().equals(product.getId())) { //do not allow 2 products with same ID
				return false;
			}
		}
		productList.add(product);
		return true;
	}
	
	public void removeProduct(Product product) {
		productList.remove(product);
	}
	
	@XmlElementRef
	public List<Product> getProductList() {
		return productList;
	}
	
	public List<Product> getListOfInstance(Class classToMatch) {
		List<Product> filteredList = new ArrayList<Product>();
		if (classToMatch.equals(Product.class)) { //fast way to return complete list of Products without iterating
			return productList;
		}
		else {	
			for (Product product : productList) {
				if (classToMatch.isInstance(product)) {
					filteredList.add(product);
				}
			}
		}
		return filteredList;
	}

	
	public int getNumberOfInstance(Class classToMatch) {
		int numberOfInstances=0;
		if (classToMatch.equals(Product.class)) { //fast way to count total number of Products without iterating
			numberOfInstances = productList.size();
		}
		else {	
			for (Product product : productList) {
				if (classToMatch.isInstance(product)) {
					numberOfInstances++;
				}
			}
		}
		return numberOfInstances;
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
		Stock tempStock = (Stock) xmlMarshaller.unmarshalStockFromXML();

		if (tempStock != null) {
			this.productList = tempStock.getProductList();
			return true;
		}
		return false;
	}
}
