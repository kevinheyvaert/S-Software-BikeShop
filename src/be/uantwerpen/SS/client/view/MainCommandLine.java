package be.uantwerpen.SS.client.view;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import be.uantwerpen.SS.client.model.Basisonderdelen;
import be.uantwerpen.SS.client.model.Kader;
import be.uantwerpen.SS.client.model.Product;
import be.uantwerpen.SS.client.model.Remmen;
import be.uantwerpen.SS.client.model.Stock;
import be.uantwerpen.SS.client.model.Wiel;

public class MainCommandLine {
	
	public static final String NOT_AN_OPTION = "This is not an option, please try again.";
	private Scanner in;
	
	Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren
	
	public int aantalKaders, aantalRemmen, aantalBasisonderdelen, aantalWielen;
	
	private static final String lines = "\n-----------------------------------\n";

	public MainCommandLine() {
		in = new Scanner(System.in);
		view();
	}

	public void view() {
		System.out.println("Client started.");
		mainMenuView();
	}
	
	public static Integer tryParseInteger(String s){
        try{
            return Integer.parseInt(s);
        }catch (NumberFormatException ex) {
            return null;
        }
    }

	private void mainMenuView() {
		System.out.println("BikeShop gestart");
		while (true) {
			System.out.printf("\n\nMain menu%s\n"
					+ "1. Load stock into program\n"
					+ "2. Zet nieuw product in de stock\n" 
					+ "3. Save stock to file:\n"
					+ "4. Stop this client\n", lines);
			Integer mm = tryParseInteger(askInput());
			if (mm != null) {
				switch (mm) {
				case 1:
					load(); //TODO MOET NOG MOOI IN METHODES WORDEN GESTOKEN
					break;
				case 2:
					addProduct();
					break;
				case 3:
					save();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println(NOT_AN_OPTION);
                    askInput();
				}
			} else {
				System.out.println(NOT_AN_OPTION);
				askInput();
			}
			
		}
	}


    private String askInput() {
        System.out.print("\n>");
        return in.nextLine();
    }
    
    public void load()
    {
    	bikeShopStock1.getStockFromXml();
    	System.out.println("Data geload");
    	//int aantalKaders = Collections.frequency( bikeShopStock1, Kader);
    	//int aantalWielen = Collections.frequency((Collection<?>) bikeShopStock1, Wiel);
    	//int aantalBasisonderdelen = Collections.frequency((Collection<?>) bikeShopStock1, Basisonderdelen);
    	//int aantalRemmen = Collections.frequency((Collection<?>) bikeShopStock1, Remmen);
    	System.out.println("Stockoverview : \n Aantal kaders : "+aantalKaders+ "\n Aantal Wielen : " + aantalWielen + "\n Aantal Remmen : " + aantalRemmen + "\n Aantal Basisonderedelen : " + aantalBasisonderdelen);
    	
    }
    
    public void addProduct()
    {
    	int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock();
    	
    	System.out.printf("Product what do you want to restock :");
		String typeProduct = askInput();
		System.out.printf("Amount: ");
		String stringAmount = askInput();
		
		int amount = Integer.parseInt(stringAmount);
		
    	if (typeProduct .equals("Kader"))
    	{
    		for(int i=0; i < amount; i++)
    		{
    		numberOfProductsInStock = numberOfProductsInStock + 1;	
    		Kader nieuwekader = new Kader(""+(numberOfProductsInStock+1), "kader");
    		bikeShopStock1.addProduct(nieuwekader);
    		
    		
    		}
    		aantalKaders = aantalKaders + amount;
    	}
    	
    	if (typeProduct .equals("Wiel"))
    	{
    		for(int i=0; i < amount; i++)
    		{
    		numberOfProductsInStock = numberOfProductsInStock + 1;	
    		Wiel nieuwWiel = new Wiel(""+(numberOfProductsInStock+1), "wiel");
    		bikeShopStock1.addProduct(nieuwWiel);
    		
    		
    		}
    		aantalWielen = aantalWielen + amount;
    	}
    	
    	if (typeProduct .equals("Remmen"))
    	{
    		for(int i=0; i < amount; i++)
    		{
    		numberOfProductsInStock = numberOfProductsInStock + 1;	
    		Remmen nieuweRemmen = new Remmen(""+(numberOfProductsInStock+1), "remmen");
    		bikeShopStock1.addProduct(nieuweRemmen);
    		
    		
    		}
    		aantalRemmen = aantalRemmen + amount;
    	}
    	
    	if (typeProduct .equals("Basisonderdelen"))
    	{
    		for(int i=0; i < amount; i++)
    		{
    		numberOfProductsInStock = numberOfProductsInStock + 1;	
    		Basisonderdelen nieuweBasisOnderdelen = new Basisonderdelen(""+(numberOfProductsInStock+1), "basisonderdelen");
    		bikeShopStock1.addProduct(nieuweBasisOnderdelen);
    		
    		
    		}
    		aantalBasisonderdelen = aantalBasisonderdelen + amount;
    	}
    	
    	System.out.println("Product <" + typeProduct +"> toegevoegd met hoeveelheid "+(amount) + ". Totaal aantal producten in stock zijn : "+numberOfProductsInStock);
    	System.out.println("Stockoverview : \n Aantal kaders : "+aantalKaders+ "\n Aantal Wielen : " + aantalWielen + "\n Aantal Remmen : " + aantalRemmen + "\n Aantal Basisonderedelen : " + aantalBasisonderdelen);
    }
    
    public void save()
    {
    	bikeShopStock1.saveStockToXml();
    	System.out.println("Data gesaved");
    }

}
