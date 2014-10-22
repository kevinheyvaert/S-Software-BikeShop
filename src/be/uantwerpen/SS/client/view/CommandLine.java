package be.uantwerpen.SS.client.view;

import java.util.Scanner;

import be.uantwerpen.SS.client.model.Kader;
import be.uantwerpen.SS.client.model.Stock;

public class CommandLine {
	
	public static final String NOT_AN_OPTION = "This is not an option, please try again.";
	private Scanner in;
	
	Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren
	
	
	private static final String lines = "\n-----------------------------------\n";

	public CommandLine() {
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
    }
    
    public void addProduct()
    {
    	int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock();
		Kader nieuwekader = new Kader(""+(numberOfProductsInStock+1), "kader_test"+(numberOfProductsInStock+1));
		bikeShopStock1.addProduct(nieuwekader);
		
		System.out.println("Product " +(numberOfProductsInStock+1) + " toegevoegd");
    }
    
    public void save()
    {
    	bikeShopStock1.saveStockToXml();
    	System.out.println("Data gesaved");
    }

}
