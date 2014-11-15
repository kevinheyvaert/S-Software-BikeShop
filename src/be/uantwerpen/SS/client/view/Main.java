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
				declaratie.aantalKaders[0] += 1;	//Totaal
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalKaders[Integer.parseInt(getID)] = getAantal;
				declaratie.productKaders[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
				
				if (debug){			
					System.out.println("kader with properties: ");
					System.out.println("ID: " + getID);
					System.out.println("Aantal in stock: " + getAantal);
					System.out.println("Inkoopprijs: " + bikeShopStock1.getProductList().get(i).getInkoopPrijs());
					System.out.println("Kleur: " + bikeShopStock1.getProductList().get(i).getKleur());
					System.out.println("Maat: " + bikeShopStock1.getProductList().get(i).getMaat());
					System.out.println("Naam: " + bikeShopStock1.getProductList().get(i).getNaam());
					System.out.println("Omschrijving: " + getOms);
					System.out.println("Type: " + bikeShopStock1.getProductList().get(i).getType());
					System.out.println("Verkoopprijs: " + bikeShopStock1.getProductList().get(i).getVerkoopPrijs());
				}
			}

			if (bikeShopStock1.getProductList().get(i) instanceof Wiel){
				declaratie.aantalWielen[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalWielen[Integer.parseInt(getID)] = getAantal;
				System.out.println(getOms + " : " + getAantal);
				declaratie.productWielen[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
			
			if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen){
				declaratie.aantalBasisonderdelen[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalBasisonderdelen[Integer.parseInt(getID)] = getAantal;
				System.out.println(getOms + " : " + getAantal);
				declaratie.productBasisonderdelen[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
			
			if (bikeShopStock1.getProductList().get(i) instanceof Rem){
				declaratie.aantalRemmen[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalRemmen[Integer.parseInt(getID)] = getAantal;
				System.out.println(getOms + " : " + getAantal);
				declaratie.productRemmen[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
			
			if (bikeShopStock1.getProductList().get(i) instanceof Licht){
				declaratie.aantalLichten[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalLichten[Integer.parseInt(getID)] = getAantal;
				System.out.println(getOms + " : " + getAantal);
				declaratie.productLichten[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
		} 
	}
	
	
	public static void load_program(){
		frame.modelBasic.clear();
		frame.modelKader.clear();
		frame.modelRemmen.clear();
		frame.modelWielen.clear();
		frame.modelLichten.clear();
		
		//TODO MOET NOG HELEMAAL AANGEPAST WORDEN
		frame.list_kader( "Totaal Kader : "+ declaratie.aantalKaders[0]);
		frame.list_wielen( "Totaal wiel : "+ declaratie.aantalWielen[0]);
		frame.list_remmen( "Totaal remmen : "+ declaratie.aantalRemmen[0]);
		frame.list_lichten( "Totaal lichten : "+ declaratie.aantalLichten[0]);
		frame.list_basis( "Totaal Basisonderdelen : "+ declaratie.aantalBasisonderdelen[0]);
			
		for(int i=0; i < declaratie.stock; i++){
			if(declaratie.productKaders[i] != null)
				frame.list_kader(declaratie.productKaders[i]+ " : " + declaratie.aantalKaders[i]); 
			
			if(declaratie.productRemmen[i] != null)
				frame.list_remmen(declaratie.productRemmen[i]+ " : " + declaratie.aantalRemmen[i]); 
			
			if(declaratie.productWielen[i] != null)
				frame.list_wielen(declaratie.productWielen[i]+ " : " + declaratie.aantalWielen[i]); 
			
			if(declaratie.productLichten[i] != null)
				frame.list_lichten(declaratie.productLichten[i]+ " : " + declaratie.aantalLichten[i]); 
			
			if(declaratie.productBasisonderdelen[i] != null)
				frame.list_basis(declaratie.productBasisonderdelen[i]+ " : " + declaratie.aantalBasisonderdelen[i]); 
		}
			
	}
	
	public static void addProduct()
    {		
		//FIXME bij eerste klik op add word maar 1 product toegevoegd en bij 2de klik pas de eigenlijke amount
		
		String typeProduct = frame.comboProduct();
		String strAmount = frame.get_textValue();
		String strPrice= frame.get_textValueProduct();
		String strOmschrijving = frame.get_textDescription();
		String idProduct = frame.get_ID();
		
		if(strAmount.length()==0 || strPrice.length()==0 || strOmschrijving.length()==0 || idProduct.length()==0){
			
		}
		else{
			int amount = Integer.parseInt(strAmount);
			
	    	if (typeProduct.equals("Kader")){
	    		Kader nieuwkader = new Kader(""+idProduct, "kader", strOmschrijving,strPrice,"");
		    	nieuwkader.setAantal(amount);
		    	bikeShopStock1.addProduct(nieuwkader);	
	    				    		
	    		int producID = Integer.parseInt(idProduct);
		    	declaratie.aantalKaders[producID] = amount;
				declaratie.productKaders[producID] = strOmschrijving;
		    	frame.list_kader(strOmschrijving + " : " + amount); 
				list_combobox_update(idProduct);	//add id to listbox
		    		
		    	declaratie.aantalKaders[0] += 1;
	    	}
	    	
	    	if (typeProduct.equals("Wielen")){
	    		Wiel nieuwWiel = new Wiel(""+idProduct, "wiel", strOmschrijving,strPrice,"");
	    		nieuwWiel.setAantal(amount);
	    		bikeShopStock1.addProduct(nieuwWiel);
	    		
		    		
		    	int producID = Integer.parseInt(idProduct);
		    	declaratie.aantalWielen[producID] = amount;
				declaratie.productWielen[producID] = strOmschrijving;
		    	frame.list_kader(strOmschrijving + " : " + amount); 
				list_combobox_update(idProduct);	//add id to listbox
		    	
		    	declaratie.aantalWielen[0] += 1;
	    	}
	    	
	    	if (typeProduct.equals("Remmen")){
	    		Rem nieuwRemmen = new Rem(""+idProduct, "remmen", strOmschrijving,strPrice,"");
		    	nieuwRemmen.setAantal(amount);
		    	bikeShopStock1.addProduct(nieuwRemmen);
		    	
	    		int producID = Integer.parseInt(idProduct);
		    	declaratie.aantalRemmen[producID] = amount;
				declaratie.productRemmen[producID] = strOmschrijving;
		    	frame.list_kader(strOmschrijving + " : " + amount); 
				list_combobox_update(idProduct);	//add id to listbox
		    	
		    	declaratie.aantalRemmen[0] += 1;
	    	}
	    	
	    	if (typeProduct.equals("Lichten")){
	    		Licht nieuwLichten = new Licht(""+idProduct, "lichten", strOmschrijving,strPrice,"");
		    	nieuwLichten.setAantal(amount);
		    	bikeShopStock1.addProduct(nieuwLichten);
	    		
	    		int producID = Integer.parseInt(idProduct);
		    	declaratie.aantalLichten[producID] = amount;
				declaratie.productLichten[producID] = strOmschrijving;
		    	frame.list_kader(strOmschrijving + " : " + amount); 
				list_combobox_update(idProduct);	//add id to listbox
		    		
		    	declaratie.aantalLichten[0] += 1;
	    	}
	    	
	    	if (typeProduct.equals("Basis")){
	    		Basisonderdelen nieuwBasisOnderdelen = new Basisonderdelen(""+idProduct, "basisonderdelen", strOmschrijving,"","");
		    	nieuwBasisOnderdelen.setAantal(amount);
		    	bikeShopStock1.addProduct(nieuwBasisOnderdelen);
	    		
		    	int producID = Integer.parseInt(idProduct);
		    	declaratie.aantalBasisonderdelen[producID] = amount;
				declaratie.productBasisonderdelen[producID] = strOmschrijving;
		    	frame.list_kader(strOmschrijving + " : " + amount);
				list_combobox_update(idProduct);	//add id to listbox 
		    		
		    	declaratie.aantalBasisonderdelen[0] += 1;
	    	}
	    	
	    	bikeShopStock1.saveStockToXml();
		}
    }
	
	private static boolean checkForExisting(String idProduct) {
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			String getID = frame.get_editID();
			if (bikeShopStock1.getProductList().get(i).getiD() == getID){
				return true;
			}
		}
		return false;
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
		
		declaratie.aantalKaders[0] -= 1;
		declaratie.aantalWielen[0] -= 1;
		declaratie.aantalLichten[0] -= 1;
		declaratie.aantalBasisonderdelen[0] -= 1;
		declaratie.aantalRemmen[0] -= 1;

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
	
	public static void list_combobox_update(String data){
		frame.add_to_list_combobox(data);
	}

	public static void load_id_data() {
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			String getID = frame.get_editID();
			if (bikeShopStock1.getProductList().get(i).getiD() == getID){
				
				String getPrice = bikeShopStock1.getProductList().get(i).getVerkoopPrijs();
				String getDesc = bikeShopStock1.getProductList().get(i).getOmschrijving();
				String getType = bikeShopStock1.getProductList().get(i).getNaam();
				
				frame.set_info_comboID(getPrice, getDesc, getType, getID);	
			}
		}
			
	}

	public static void enable_combo() {
		frame.enable_combo();
	}
}
