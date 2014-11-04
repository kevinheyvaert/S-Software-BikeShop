package be.uantwerpen.SS.client.view;

import java.awt.EventQueue;

import be.uantwerpen.SS.client.model.stock.Basisonderdelen;
import be.uantwerpen.SS.client.model.stock.Kader;
import be.uantwerpen.SS.client.model.stock.Rem;
import be.uantwerpen.SS.client.model.stock.Stock;
import be.uantwerpen.SS.client.model.stock.Wiel;
import be.uantwerpen.SS.client.data.declaratie;

public class Main {
	public static guiVieuw frame = new guiVieuw();
	public static Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public static int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren
	
	public static void main(String args[]) {
			
	//MainCommandLine command = new MainCommandLine();
	
		//Start GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.list_log_client("test");
					init_program();
					load_program();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}
	
	public static void init_program(){
		bikeShopStock1.getStockFromXml();
		
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			
			if (bikeShopStock1.getProductList().get(i) instanceof Kader)
				declaratie.aantalKaders +=1;
			
			if (bikeShopStock1.getProductList().get(i) instanceof Wiel)
				declaratie.aantalWielen +=1;
			
			if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen)
				declaratie.aantalBasisonderdelen +=1;
			
			if (bikeShopStock1.getProductList().get(i) instanceof Rem)
				declaratie.aantalRemmen +=1;
		} 
	}
	
	
	public static void load_program(){
		frame.modelBasic.clear();
		frame.modelKader.clear();
		frame.modelRemmen.clear();
		frame.modelWielen.clear();
		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    		if (bikeShopStock1.getProductList().get(i) instanceof Kader) {
    			frame.list_kader(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Wiel) {
    			frame.list_wielen(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Rem) {
				frame.list_remmen(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
			}
    		if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen) {
				frame.list_basis(bikeShopStock1.getProductList().get(i).getiD() + "\t" + bikeShopStock1.getProductList().get(i).getNaam() +"\t\t" + bikeShopStock1.getProductList().get(i).getOmschrijving() + "\t" + bikeShopStock1.getProductList().get(i).getType() +"\t\t"+ bikeShopStock1.getProductList().get(i).getMaat() + "\t\t" + bikeShopStock1.getProductList().get(i).getKleur() +"\t" + bikeShopStock1.getProductList().get(i).getInkoopPrijs() + "\t" + bikeShopStock1.getProductList().get(i).getVerkoopPrijs()+"\n");
			}
		}
	}
	
	public static void addProduct()
    {
		Object typeProduct = frame.comboProduct();
		System.out.printf("Amount: ");
		String stringAmount = frame.get_textValue();
		
		int amount = Integer.parseInt(stringAmount);
		
    	if (typeProduct .equals("Kader")){
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Kader nieuwekader = new Kader(""+(numberOfProductsInStock+1), "kader");
	    		bikeShopStock1.addProduct(nieuwekader);
    		}
    		declaratie.aantalKaders += amount;
    	}
    	
    	if (typeProduct .equals("Wielen")){
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Wiel nieuwWiel = new Wiel(""+(numberOfProductsInStock+1), "wiel");
	    		bikeShopStock1.addProduct(nieuwWiel);
    		}
    		declaratie.aantalWielen += amount;
    	}
    	
    	if (typeProduct .equals("Remmen"))
    	{
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Rem nieuweRemmen = new Rem(""+(numberOfProductsInStock+1), "remmen");
	    		bikeShopStock1.addProduct(nieuweRemmen);
    		}
    		declaratie.aantalRemmen += amount;
    	}
    	
    	if (typeProduct .equals("Basis"))
    	{
    		for(int i=0; i < amount; i++){
	    		numberOfProductsInStock = numberOfProductsInStock + 1;	
	    		Basisonderdelen nieuweBasisOnderdelen = new Basisonderdelen(""+(numberOfProductsInStock+1), "basisonderdelen");
	    		bikeShopStock1.addProduct(nieuweBasisOnderdelen);
	    	}
    		declaratie.aantalBasisonderdelen += amount;
    	}
    	
    	bikeShopStock1.saveStockToXml();
    }
	
	public static void incProduct() {
		int amount = Integer.parseInt(frame.txtValueInput.getText());
		amount +=1;
		String put = ""+amount;
		frame.txtValueInput.setText(put);
	}

	public static void decProduct() {
		int amount = Integer.parseInt(frame.txtValueInput.getText());
		if(amount == 0){
			//NOTHING can't go under 0
		}
		else{
			amount -=1;
			String put = ""+amount;
			frame.txtValueInput.setText(put);
		}
	}

}
