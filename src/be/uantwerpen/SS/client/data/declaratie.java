package be.uantwerpen.SS.client.data;

import be.uantwerpen.SS.client.model.stock.Stock;

public class declaratie {

	public static Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public static int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren

	public static int stock = 2500;
	
	public static int[] aantalLichten = new int[stock];
	public static String[] productLichten = new String[stock];
	public static int[] aantalKaders = new int[stock];
	public static String[] productKaders = new String[stock];
	public static int[] aantalRemmen = new int[stock];
	public static String[] productRemmen = new String[stock];
	public static int[] aantalBasisonderdelen = new int[stock];
	public static String[] productBasisonderdelen = new String[stock];
	public static int[] aantalWielen = new int[stock];
	public static String[] productWielen = new String[stock];
	
	public int get_aantalKaders(int index){
		return aantalKaders[index];
	}
	
	public int get_aantalRemmen(int index){
		return aantalRemmen[index];
	}
	
	public int get_aantalBasisonderdelen(int index){
		return aantalBasisonderdelen[index];
	}
	
	public int get_aantalWielen(int index){
		return aantalWielen[index];
	}
	
	public int get_aantalLichten(int index){
		return aantalLichten[index];
	}
}
