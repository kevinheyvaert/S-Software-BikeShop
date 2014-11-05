package be.uantwerpen.SS.client.model;

import be.uantwerpen.SS.client.model.stock.Kader;
import be.uantwerpen.SS.client.model.stock.Stock;

//import be.uantwerpen.SS.client.view.MainCommandLine;


public class BikeShopMain {
	public static void main(String[] args) {
		Stock bikeShopStock1 = new Stock();
		System.out.println("BikeShop gestart");
		bikeShopStock1.getStockFromXml();
		int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock();
		Kader nieuwekader = new Kader(""+(numberOfProductsInStock+1), "kader_test"+(numberOfProductsInStock+1),"","","");
		bikeShopStock1.addProduct(nieuwekader);
		
		System.out.println("Product " +(numberOfProductsInStock+1) + " toegevoegd");
		bikeShopStock1.saveStockToXml();
		
		
    }
}