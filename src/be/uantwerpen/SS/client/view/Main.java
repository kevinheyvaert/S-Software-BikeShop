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
	public static int aantalFietsen;
	public static boolean debug;
	public static void main(String[] args) {
		if (args.length ==1){
			debug = (args[0].equals("-d"));
		}
		else {
			debug = false;
		}
			
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
		if (debug) System.out.println("Loading stock :");
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			if (debug) System.out.println("Stock Contains:");
			if (bikeShopStock1.getProductList().get(i) instanceof Kader){
				declaratie.aantalKaders +=1;
				if (debug){	
					System.out.println("kader with properties: ");
					System.out.println("ID: " + bikeShopStock1.getProductList().get(i).getiD());
					System.out.println("Aantal in stock: " + bikeShopStock1.getProductList().get(i).getAantal());
					System.out.println("Inkoopprijs: " + bikeShopStock1.getProductList().get(i).getInkoopPrijs());
					System.out.println("Kleur: " + bikeShopStock1.getProductList().get(i).getKleur());
					System.out.println("Maat: " + bikeShopStock1.getProductList().get(i).getMaat());
					System.out.println("Naam: " + bikeShopStock1.getProductList().get(i).getNaam());
					System.out.println("Omschrijving: " + bikeShopStock1.getProductList().get(i).getOmschrijving());
					System.out.println("Type: " + bikeShopStock1.getProductList().get(i).getType());
					System.out.println("Verkoopprijs: " + bikeShopStock1.getProductList().get(i).getVerkoopPrijs());
				}
			}

			if (bikeShopStock1.getProductList().get(i) instanceof Wiel)
				declaratie.aantalWielen +=1;
			
			if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen)
				declaratie.aantalBasisonderdelen +=1;
			
			if (bikeShopStock1.getProductList().get(i) instanceof Rem)
				declaratie.aantalRemmen +=1;
			
			if (bikeShopStock1.getProductList().get(i) instanceof Licht)
				declaratie.aantalLichten +=1;
		} 
	}
	
	
	public static void load_program(){
		frame.modelBasic.clear();
		frame.modelKader.clear();
		frame.modelRemmen.clear();
		frame.modelWielen.clear();
		frame.modelLichten.clear();
		
		//TODO MOET NOG HELEMAAL AANGEPAST WORDEN
		
		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
    		
			if (bikeShopStock1.getProductList().get(i) instanceof Kader) {
    			//frame.list_kader(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +" \t\t" +"\n");
				//if (bikeShopStock1.getProductList().get(i).getiD() == "12")
					//aantalKaderId12 = aantalKaderId12 +1;  
					
    		}
    		
    		if (bikeShopStock1.getProductList().get(i) instanceof Wiel) {
    			//frame.list_wielen(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Rem) {
				//frame.list_remmen(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Licht) {
				//frame.list_lichten(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
    		if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen) {
				//frame.list_basis(bikeShopStock1.getProductList().get(i).getiD() + " : \t " + bikeShopStock1.getProductList().get(i).getOmschrijving() +"\t\t" +"\n");
    		}
		}
			frame.list_kader( "Basic Kader : "+ declaratie.aantalKaders );
			frame.list_wielen( "Basic wiel : "+ declaratie.aantalWielen );
			frame.list_remmen( "Basic remmen : "+ declaratie.aantalRemmen );
			frame.list_lichten( "Basic lichten : "+ declaratie.aantalLichten );
			frame.list_basis( "Basic Basisonderdelen : "+ declaratie.aantalBasisonderdelen );
	}
	
	public static void addProduct()
    {		
		//FIXME bij eerste klik op add word maar 1 product toegevoegd en bij 2de klik pas de eigenlijke amount
		
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
		    		Kader nieuwekader = new Kader(""+strID, "kader", strOmschrijving,strPrice,"");
		    		nieuwekader.setAantal(amount);
		    		bikeShopStock1.addProduct(nieuwekader);
	    		declaratie.aantalKaders += amount;
	    	}
	    	
	    	if (typeProduct .equals("Wielen")){
		    		Wiel nieuwWiel = new Wiel(""+strID, "wiel", strOmschrijving,strPrice,"");
		    		bikeShopStock1.addProduct(nieuwWiel);
	    		declaratie.aantalWielen += amount;
	    	}
	    	
	    	if (typeProduct .equals("Remmen"))
	    	{
		    		Rem nieuweRemmen = new Rem(""+strID, "remmen", strOmschrijving,strPrice,"");
		    		nieuweRemmen.setAantal(amount);
		    		bikeShopStock1.addProduct(nieuweRemmen);
	    		declaratie.aantalRemmen += amount;
	    	}
	    	
	    	if (typeProduct .equals("Lichten"))
	    	{
		    		Licht nieuweLichten = new Licht(""+strID, "lichten", strOmschrijving,strPrice,"");
		    		nieuweLichten.setAantal(amount);
		    		bikeShopStock1.addProduct(nieuweLichten);
	    		declaratie.aantalLichten += amount;
	    	}
	    	
	    	if (typeProduct .equals("Basis"))
	    	{
		    		Basisonderdelen nieuweBasisOnderdelen = new Basisonderdelen(""+strID, "basisonderdelen", strOmschrijving,"","");
		    		nieuweBasisOnderdelen.setAantal(amount);
		    		bikeShopStock1.addProduct(nieuweBasisOnderdelen);
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
	
	//FIXME is een test methode
	public static void MakeBike()
	{
		aantalFietsen = aantalFietsen +1;
		
		String strName = frame.get_textNaam();
		String strNumber = frame.get_textNummer();
		String strAdress = frame.get_textAdress();
		
		
		//FIXME \t werkt precies niet in frames
		frame.list_log_client("ID : " + aantalFietsen + "      Fiets"+aantalFietsen + "                       " + declaratie.aantalKaders + "      "+strName +"    " + strNumber  + "          " + strAdress);
		
		declaratie.aantalKaders = declaratie.aantalKaders - 1;
		declaratie.aantalWielen = declaratie.aantalWielen - 1;
		declaratie.aantalLichten = declaratie.aantalLichten - 1;
		declaratie.aantalBasisonderdelen = declaratie.aantalBasisonderdelen -1;
		declaratie.aantalRemmen = declaratie.aantalRemmen -1;
		frame.list_log_client(""+declaratie.aantalKaders);
		
		
		
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
