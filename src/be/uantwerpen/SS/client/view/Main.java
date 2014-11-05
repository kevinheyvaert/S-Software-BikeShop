package be.uantwerpen.SS.client.view;

import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import be.uantwerpen.SS.client.model.stock.Basisonderdelen;
import be.uantwerpen.SS.client.model.stock.Kader;
import be.uantwerpen.SS.client.model.stock.Licht;
import be.uantwerpen.SS.client.model.stock.Rem;
import be.uantwerpen.SS.client.model.stock.Stock;
import be.uantwerpen.SS.client.model.stock.Wiel;
import be.uantwerpen.SS.client.data.declaratie;

public class Main {
	public static guiVieuw frame = new guiVieuw();
	public static Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public static int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock(); //TODO : From BikeshopMain --> beter implementeren
	public static int aantalKaderId12;
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
		frame.modelLichten.clear();
		
		
		
		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    		
			if (bikeShopStock1.getProductList().get(i) instanceof Kader) {
    			//frame.list_kader(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +" \t\t" +"\n");
				//if (bikeShopStock1.getProductList().get(i).getiD() == "12")
					aantalKaderId12 = aantalKaderId12 +1;  
					
    		}
    		
    		if (bikeShopStock1.getProductList().get(i) instanceof Wiel) {
    			frame.list_wielen(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Rem) {
				frame.list_remmen(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Licht) {
				frame.list_lichten(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen) {
				frame.list_basis(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
		}
		frame.list_kader("aantal : " + aantalKaderId12 );
		
	}
	
	public static void addProduct()
    {		
		Object typeProduct = frame.comboProduct();
		String strAmount = frame.get_textValue();
		String strPrice= frame.get_textValueProduct();
		String strOmschrijving = frame.get_textDescription();
		String strID = frame.get_textID();
		
		if(strAmount.length()==0 || strPrice.length()==0 || strOmschrijving.length()==0 || strID.length()==0){
			
		}
		else{
			int amount = Integer.parseInt(strAmount);
			
	    	if (typeProduct .equals("Kader")){
	    		for(int i=0; i < amount; i++){
		    		numberOfProductsInStock = numberOfProductsInStock + 1;	
		    		Kader nieuwekader = new Kader(""+strID, "kader", strOmschrijving,strPrice,"");
		    		bikeShopStock1.addProduct(nieuwekader);
	    		}
	    		declaratie.aantalKaders += amount;
	    	}
	    	
	    	if (typeProduct .equals("Wielen")){
	    		for(int i=0; i < amount; i++){
		    		numberOfProductsInStock = numberOfProductsInStock + 1;	
		    		Wiel nieuwWiel = new Wiel(""+strID, "wiel", strOmschrijving,strPrice,"");
		    		bikeShopStock1.addProduct(nieuwWiel);
	    		}
	    		declaratie.aantalWielen += amount;
	    	}
	    	
	    	if (typeProduct .equals("Remmen"))
	    	{
	    		for(int i=0; i < amount; i++){
		    		numberOfProductsInStock = numberOfProductsInStock + 1;	
		    		Rem nieuweRemmen = new Rem(""+strID, "remmen", strOmschrijving,strPrice,"");
		    		bikeShopStock1.addProduct(nieuweRemmen);
	    		}
	    		declaratie.aantalRemmen += amount;
	    	}
	    	
	    	if (typeProduct .equals("Lichten"))
	    	{
	    		for(int i=0; i < amount; i++){
		    		numberOfProductsInStock = numberOfProductsInStock + 1;	
		    		Licht nieuweLichten = new Licht(""+strID, "lichten", strOmschrijving,strPrice,"");
		    		bikeShopStock1.addProduct(nieuweLichten);
	    		}
	    		declaratie.aantalLichten += amount;
	    	}
	    	
	    	if (typeProduct .equals("Basis"))
	    	{
	    		for(int i=0; i < amount; i++){
		    		numberOfProductsInStock = numberOfProductsInStock + 1;	
		    		Basisonderdelen nieuweBasisOnderdelen = new Basisonderdelen(""+strID, "basisonderdelen", strOmschrijving,"","");
		    		bikeShopStock1.addProduct(nieuweBasisOnderdelen);
		    	}
	    		declaratie.aantalBasisonderdelen += amount;
	    	}
	    	
	    	bikeShopStock1.saveStockToXml();
		}
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

	public static String getKader() {
		String strReturn = frame.get_lstSelected_kader();
		return strReturn;
	}

	public static String getWiel() {
		String strReturn = frame.get_lstSelected_wielen();
		return strReturn;
	}

	public static String getRem() {
		String strReturn = frame.get_lstSelected_remmen();
		return strReturn;
	}

	public static String getLicht() {
		String strReturn = frame.get_lstSelected_lichten();
		return strReturn;
	}
}
