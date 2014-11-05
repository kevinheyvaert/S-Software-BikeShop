package be.uantwerpen.SS.client.view;

import java.util.Scanner;

import be.uantwerpen.SS.client.model.stock.Basisonderdelen;
import be.uantwerpen.SS.client.model.stock.Kader;
import be.uantwerpen.SS.client.model.stock.Rem;
import be.uantwerpen.SS.client.model.stock.Stock;
import be.uantwerpen.SS.client.model.stock.Wiel;

public class MainCommandLine {
	
	public static final String NOT_AN_OPTION = "This is not an option, please try again.";
	private Scanner in;
	
	Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren
	
	public int aantalKaders, aantalRemmen, aantalBasisonderdelen, aantalWielen = 0;
	
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
					+ "3. Zie stock per type onderdeel\n"
					+ "4. Save stock to file:\n"
					+ "5. Stop this client\n", lines);
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
					showSpecs();
					break;
				case 4:
					save();
					break;
				case 5:
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
    	
    	System.out.println("Aantal producten voor Load: " + bikeShopStock1.getProductList().size() );
    	bikeShopStock1.getStockFromXml();
    	System.out.println("Aantal producten na Load: " + bikeShopStock1.getProductList().size() );
    	
    	for(int i=0;i<bikeShopStock1.getProductList().size();i++){
    		
    		if (bikeShopStock1.getProductList().get(i) instanceof Kader)
    			aantalKaders = aantalKaders + 1;
    		
    		
    		if (bikeShopStock1.getProductList().get(i) instanceof Wiel)
    			aantalWielen = aantalWielen + 1;
    		
    		if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen)
    			aantalBasisonderdelen = aantalBasisonderdelen + 1;
    		
    		if (bikeShopStock1.getProductList().get(i) instanceof Rem)
    			aantalRemmen = aantalRemmen + 1;
    	} 
    	
    	
    	
    	System.out.println("Data geload");
  
    	System.out.println("Stockoverview : \n Aantal kaders : "+aantalKaders+ "\n Aantal Wielen : " + aantalWielen + "\n Aantal Remmen : " + aantalRemmen + "\n Aantal Basisonderedelen : " + aantalBasisonderdelen);
    	
    }
    
    public void addProduct()
    {
    	System.out.println("Product what do you want to restock: ");
		String typeProduct = askInput();
		System.out.println("Amount: ");
		String stringAmount = askInput();
		
		int amount = Integer.parseInt(stringAmount);
		
    	if (typeProduct .equals("Kader")){
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Kader nieuwekader = new Kader(""+(numberOfProductsInStock+1), "kader","","","");
	    		bikeShopStock1.addProduct(nieuwekader);
    		}
    		aantalKaders = aantalKaders + amount;
    	}
    	
    	if (typeProduct .equals("Wiel")){
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Wiel nieuwWiel = new Wiel(""+(numberOfProductsInStock+1), "wiel","","","");
	    		bikeShopStock1.addProduct(nieuwWiel);
    		}
    		aantalWielen = aantalWielen + amount;
    	}
    	
    	if (typeProduct .equals("Remmen")){
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Rem nieuweRemmen = new Rem(""+(numberOfProductsInStock+1), "remmen","","","");
	    		bikeShopStock1.addProduct(nieuweRemmen);
    		}
    		aantalRemmen = aantalRemmen + amount;
    	}
    	
    	if (typeProduct .equals("Basisonderdelen")){
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Basisonderdelen nieuweBasisOnderdelen = new Basisonderdelen(""+(numberOfProductsInStock+1), "basisonderdelen","","","");
	    		bikeShopStock1.addProduct(nieuweBasisOnderdelen);
    		}
    		aantalBasisonderdelen = aantalBasisonderdelen + amount;
    	}
    }
    
    public void save()
    {
    	bikeShopStock1.saveStockToXml();
    	System.out.println("Data gesaved");
    }
    
    public void showSpecs()
    {
    	System.out.printf("Product what do you want to see :");
		String typeProduct = askInput();

    	if (typeProduct .equals("Kader")){    		
    		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    			if (bikeShopStock1.getProductList().get(i) instanceof Kader){
    				System.out.printf(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
    			}
    		}
    	 }
    				
    	if (typeProduct .equals("Wiel")){    		
    		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    			if (bikeShopStock1.getProductList().get(i) instanceof Wiel){
    				System.out.printf(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
    			}
    		}
    	 }	
    		
    	if (typeProduct .equals("Remmen")){    		
    		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    			if (bikeShopStock1.getProductList().get(i) instanceof Rem){
    				System.out.printf(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
    			}
    		}
    	 }		
    		
    	if (typeProduct .equals("Basisonderdelen")){    		
    		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    			if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen){
    				System.out.printf(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
    			}
    		}
    	 }		   		
    }
}
