package be.uantwerpen.SS.client.view;

import java.awt.EventQueue;

import be.uantwerpen.SS.client.model.stock.Basisonderdelen;
import be.uantwerpen.SS.client.model.stock.Kader;
import be.uantwerpen.SS.client.model.stock.Licht;
import be.uantwerpen.SS.client.model.stock.Rem;
import be.uantwerpen.SS.client.model.stock.Stock;
import be.uantwerpen.SS.client.model.stock.Wiel;
import be.uantwerpen.SS.client.model.verkoopsRapport.Fiets;
import be.uantwerpen.SS.client.model.verkoopsRapport.Klant;
import be.uantwerpen.SS.client.model.verkoopsRapport.Verkoop;
import be.uantwerpen.SS.client.model.verkoopsRapport.VerkoopsRapport;
import be.uantwerpen.SS.client.data.declaratie;

public class Main {
	public static guiVieuw frame = new guiVieuw();
	public static Stock bikeShopStock1 = new Stock(); //TODO : From BikeshopMain --> beter implementeren 
	public static VerkoopsRapport bikeShopVerkoopsRapport1 = new VerkoopsRapport(); 
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
					load_list();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void init_program(){
		bikeShopStock1.getStockFromXml();
		bikeShopVerkoopsRapport1.getVerkoopsRapportFromXml();
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
				declaratie.productWielen[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
			
			if (bikeShopStock1.getProductList().get(i) instanceof Basisonderdelen){
				declaratie.aantalBasisonderdelen[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalBasisonderdelen[Integer.parseInt(getID)] = getAantal;
				declaratie.productBasisonderdelen[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
			
			if (bikeShopStock1.getProductList().get(i) instanceof Rem){
				declaratie.aantalRemmen[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalRemmen[Integer.parseInt(getID)] = getAantal;
				declaratie.productRemmen[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
			
			if (bikeShopStock1.getProductList().get(i) instanceof Licht){
				declaratie.aantalLichten[0] += 1;
			
				String getID = bikeShopStock1.getProductList().get(i).getiD();
				int getAantal = bikeShopStock1.getProductList().get(i).getAantal();
				String getOms = bikeShopStock1.getProductList().get(i).getOmschrijving();
				
				declaratie.aantalLichten[Integer.parseInt(getID)] = getAantal;
				declaratie.productLichten[Integer.parseInt(getID)] = getOms;
				
				list_combobox_update(getID);	//add id to listbox
			}
		} 
	}
	
	
	public static void load_list(){
		frame.clearModel();
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
		String strPriceSell= frame.get_textValueProduct();
		String strPriceBuy= frame.get_textValueProduct();
		String strOmschrijving = frame.get_textDescription();
		String idProduct = frame.get_ID();
		
		if(strAmount.length()==0  || strPriceBuy.length()==0 || strPriceSell.length()==0 || strOmschrijving.length()==0 || idProduct.length()==0){
			
		}
		else{
			if(checkForExisting(idProduct) == false){
				// ^nieuw product toevoegen ipv wijzigen
				addNewXMLtag(typeProduct, strAmount, strPriceBuy, strPriceSell, strOmschrijving, idProduct);	
			}
			else{
				// ^producten die al bestaan wijzigen ipv toevoegen
				changeExistingXMLtag(typeProduct, strAmount, strPriceBuy, strPriceSell, strOmschrijving, idProduct);
			}
			// stock opslaan
	    	bikeShopStock1.saveStockToXml();
		}
    }
	
	/**
	 * Functie om de te kijken of het product al reeds in het bestand zit
	 * @param idProduct
	 * @return
	 */
	public static boolean checkForExisting(String idProduct) {
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			String getID = frame.get_editID();
			if (bikeShopStock1.getProductList().get(i).getiD() == getID){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Nieuw produc toevoegen
	 * @param typeProduct
	 * @param strAmount
	 * @param strPriceBuy
	 * @param strPriceSell
	 * @param strOmschrijving
	 * @param idProduct
	 */
	public static void addNewXMLtag(String typeProduct, String strAmount, String strPriceBuy, String strPriceSell, String strOmschrijving, String idProduct){
		int amount = Integer.parseInt(strAmount);
		
    	if (typeProduct.equals("Kader")){
    		Kader nieuwkader = new Kader(idProduct, "kader", strOmschrijving,strPriceBuy,strPriceSell);
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
    		Wiel nieuwWiel = new Wiel(idProduct, "wiel", strOmschrijving,strPriceBuy,strPriceSell);
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
    		Rem nieuwRemmen = new Rem(idProduct, "remmen", strOmschrijving,strPriceBuy,strPriceSell);
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
    		Licht nieuwLichten = new Licht(idProduct, "lichten", strOmschrijving,strPriceBuy,strPriceSell);
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
    		Basisonderdelen nieuwBasisOnderdelen = new Basisonderdelen(idProduct, "basisonderdelen", strOmschrijving,strPriceBuy,strPriceSell);
	    	nieuwBasisOnderdelen.setAantal(amount);
	    	bikeShopStock1.addProduct(nieuwBasisOnderdelen);
    		
	    	int producID = Integer.parseInt(idProduct);
	    	declaratie.aantalBasisonderdelen[producID] = amount;
			declaratie.productBasisonderdelen[producID] = strOmschrijving;
	    	frame.list_kader(strOmschrijving + " : " + amount);
			list_combobox_update(idProduct);	//add id to listbox 
	    		
	    	declaratie.aantalBasisonderdelen[0] += 1;
    	}
	}
	
	/**
	 * Product aanpassen
	 * @param typeProduct
	 * @param strAmount
	 * @param strPriceBuy
	 * @param strPriceSell
	 * @param strOmschrijving
	 * @param idProduct
	 */
	public static void changeExistingXMLtag(String typeProduct, String strAmount, String strPriceBuy, String strPriceSell, String strOmschrijving, String idProduct){
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			if (typeProduct.equals("kader") || typeProduct.equals("Kader") ){
				if(bikeShopStock1.getProductList().get(i).getiD() == idProduct){
					bikeShopStock1.getProductList().get(i).Bewerken(strAmount, strPriceBuy, strPriceSell, strOmschrijving);
					declaratie.aantalKaders[Integer.parseInt(idProduct)] = Integer.parseInt(strAmount);
					declaratie.productKaders[Integer.parseInt(idProduct)] = strOmschrijving;
				}
	    	}
	    	
	    	if (typeProduct.equals("wielen") || typeProduct.equals("Wielen") ){
	    		if(bikeShopStock1.getProductList().get(i).getiD() == idProduct){
					bikeShopStock1.getProductList().get(i).Bewerken(strAmount, strPriceBuy, strPriceSell, strOmschrijving);
					declaratie.aantalWielen[Integer.parseInt(idProduct)] = Integer.parseInt(strAmount);
					declaratie.productWielen[Integer.parseInt(idProduct)] = strOmschrijving;
				}
	    	}
	    	
	    	if (typeProduct.equals("remmen") || typeProduct.equals("Remmen") ){
	    		if(bikeShopStock1.getProductList().get(i).getiD() == idProduct){
					bikeShopStock1.getProductList().get(i).Bewerken(strAmount, strPriceBuy, strPriceSell, strOmschrijving);
					declaratie.aantalRemmen[Integer.parseInt(idProduct)] = Integer.parseInt(strAmount);
					declaratie.productRemmen[Integer.parseInt(idProduct)] = strOmschrijving;
				}
	    	}
	    	
	    	if (typeProduct.equals("lichten") || typeProduct.equals("Lichten") ){
	    		if(bikeShopStock1.getProductList().get(i).getiD() == idProduct){
					bikeShopStock1.getProductList().get(i).Bewerken(strAmount, strPriceBuy, strPriceSell, strOmschrijving);
					declaratie.aantalLichten[Integer.parseInt(idProduct)] = Integer.parseInt(strAmount);
					declaratie.productLichten[Integer.parseInt(idProduct)] = strOmschrijving;
				}
	    	}
	    	
	    	if (typeProduct.equals("basis") || typeProduct.equals("Basis") ){
	    		if(bikeShopStock1.getProductList().get(i).getiD() == idProduct){
					bikeShopStock1.getProductList().get(i).Bewerken(strAmount, strPriceBuy, strPriceSell, strOmschrijving);
					declaratie.aantalBasisonderdelen[Integer.parseInt(idProduct)] = Integer.parseInt(strAmount);
					declaratie.productBasisonderdelen[Integer.parseInt(idProduct)] = strOmschrijving;
				}
	    	}
		}
	}

	/**
	 * Product incrementen op gui
	 */
	public static void incProduct() {
		frame.inc_dec_Product("+");
	}

	/**
	 * Product decrementen op gui
	 */
	public static void decProduct() {
		frame.inc_dec_Product("-");
	}
	
	//FIXME is een test methode
	public static void MakeBike()
	{
		aantalFietsen = aantalFietsen +1;
		
		String strName = frame.get_textNaam();
		String strNumber = frame.get_textNummer();
		String strAddress = frame.get_textAdress();
		
		//FIXME \t werkt precies niet in frames
		frame.list_log_client("ID : " + aantalFietsen + "      Fiets"+aantalFietsen + "                       " + declaratie.aantalKaders + "      "+strName +"    " + strNumber  + "          " + strAddress);
		
		declaratie.aantalKaders[0] -= 1;
		declaratie.aantalWielen[0] -= 1;
		declaratie.aantalLichten[0] -= 1;
		declaratie.aantalBasisonderdelen[0] -= 1;
		declaratie.aantalRemmen[0] -= 1;
		
		
		//added by MDS
		Klant klant = new Klant(strName, strNumber, strAddress);
		Fiets fiets	= new Fiets("mijn eerste fietsje", "1", "2", "3", "4", "5"); //TODO @ Kevin R kan je zorgen dat hier de geselcteerde ID's terechtkomen ipv mijn dummy 1 2 3's...?
		bikeShopVerkoopsRapport1.addVerkoop(new Verkoop(klant, fiets));	
		bikeShopVerkoopsRapport1.saveVerkoopsRapportToXml();
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

	/**
	 * Uit combobox de selectie in gui laden
	 */
	public static void load_id_data() {
		for(int i=0;i<bikeShopStock1.getProductList().size();i++){
			String getID = frame.get_editID();
			if (bikeShopStock1.getProductList().get(i).getiD() == getID){
				String getAmount = ""+bikeShopStock1.getProductList().get(i).getAantal();
				String getPriceSell = bikeShopStock1.getProductList().get(i).getVerkoopPrijs();
				String getPriceBuy = bikeShopStock1.getProductList().get(i).getInkoopPrijs();
				String getDesc = bikeShopStock1.getProductList().get(i).getOmschrijving();
				String getType = bikeShopStock1.getProductList().get(i).getNaam();
				
				frame.set_info_comboID(getPriceBuy, getPriceSell, getDesc, getType, getID, getAmount);	
			}
		}
			
	}

	/**
	 * De combobox weer actief maken zodat deze kan gebruikt worden.
	 */
	public static void enable_combo() {
		frame.enable_combo();
	}
}
