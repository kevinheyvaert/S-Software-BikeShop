package be.uantwerpen.SS.client.data;

import be.uantwerpen.SS.client.model.stock.Stock;

public class declaratie {

	public static Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public static int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren

	public static int aantalLichten;
	public static int aantalKaders;
	public static int aantalRemmen;
	public static int aantalBasisonderdelen;
	public static int aantalWielen = 0;
	
	public int get_aantalKaders(){
		return aantalKaders;
	}
	
	public int get_aantalRemmen(){
		return aantalRemmen;
	}
	
	public int get_aantalBasisonderdelen(){
		return aantalBasisonderdelen;
	}
	
	public int get_aantalWielen(){
		return aantalWielen;
	}
	
	public int get_aantalLichten(){
		return aantalLichten;
	}
	
}
