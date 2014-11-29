package be.uantwerpen.SS.client.view;

import java.awt.EventQueue;
import java.util.List;

import be.uantwerpen.SS.client.model.stock.Basisonderdelen;
import be.uantwerpen.SS.client.model.stock.Kader;
import be.uantwerpen.SS.client.model.stock.Licht;
import be.uantwerpen.SS.client.model.stock.Product;
import be.uantwerpen.SS.client.model.stock.Rem;
import be.uantwerpen.SS.client.model.stock.Stock;
import be.uantwerpen.SS.client.model.stock.Wiel;
import be.uantwerpen.SS.client.model.verkoopsRapport.Fiets;
import be.uantwerpen.SS.client.model.verkoopsRapport.Klant;
import be.uantwerpen.SS.client.model.verkoopsRapport.Verkoop;
import be.uantwerpen.SS.client.model.verkoopsRapport.VerkoopsRapport;
import be.uantwerpen.SS.client.view.GuiView;

public class Main {
	public static GuiView frame = new GuiView();
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

		for(int i=0; i<bikeShopStock1.getNumberOfInstance(Product.class); i++){
			list_combobox_update(bikeShopStock1.getProductList().get(i).getId());	//add id to listbox
		}
	}
	
	
	public static void load_list(){
		frame.clearModel();
		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
			Product currentProduct = bikeShopStock1.getProductList().get(i);
			if(currentProduct instanceof Kader) frame.list_kader(currentProduct.getOmschrijving()+ " : " + currentProduct.getAantal());
			if(currentProduct instanceof Rem) frame.list_remmen(currentProduct.getOmschrijving()+ " : " + currentProduct.getAantal());
			if(currentProduct instanceof Wiel) frame.list_wielen(currentProduct.getOmschrijving()+ " : " + currentProduct.getAantal());
			if(currentProduct instanceof Licht) frame.list_lichten(currentProduct.getOmschrijving()+ " : " + currentProduct.getAantal());
			if(currentProduct instanceof Basisonderdelen) frame.list_basis(currentProduct.getOmschrijving()+ " : " + currentProduct.getAantal());
		}		
	}
	
	public static void addProduct()
	{		
		//FIXME bij eerste klik op add word maar 1 product toegevoegd en bij 2de klik pas de eigenlijke amount
		String typeProduct = frame.comboProduct();
		int Amount = Integer.parseInt(frame.get_textValue());
		String strPriceSell= frame.get_textValueProduct();
		String strPriceBuy= frame.get_textValueProduct();
		String strOmschrijving = frame.get_textDescription();
		String idProduct = frame.get_ID();

		boolean addedSuccesfull=false;

		if(strPriceBuy.length()!=0 && strPriceSell.length()!=0 && strOmschrijving.length()!=0 && idProduct.length()!=0){
			if (typeProduct.equals("Kader")) {
				Kader newKader = new Kader(idProduct, "Kader", strOmschrijving,strPriceBuy,strPriceSell, Amount);
				addedSuccesfull= bikeShopStock1.addProduct(newKader);
			}
			else if (typeProduct.equals("Wielen")) {
				Wiel newWiel = new Wiel(idProduct, "Wielen", strOmschrijving,strPriceBuy,strPriceSell, Amount);
				addedSuccesfull = bikeShopStock1.addProduct(newWiel);
			}
			else if (typeProduct.equals("Remmen")) {
				Rem newRem = new Rem(idProduct, "remmen", strOmschrijving,strPriceBuy,strPriceSell, Amount);
				addedSuccesfull = bikeShopStock1.addProduct(newRem);
			}
			else if (typeProduct.equals("Lichten")) {
				Licht newLicht = new Licht(idProduct, "Lichten", strOmschrijving,strPriceBuy,strPriceSell, Amount);
				addedSuccesfull = bikeShopStock1.addProduct(newLicht);
			}
			else if (typeProduct.equals("Basis")) {
				Basisonderdelen newBasisonderdelen = new Basisonderdelen(idProduct, "Basis", strOmschrijving,strPriceBuy,strPriceSell, Amount);
				addedSuccesfull = bikeShopStock1.addProduct(newBasisonderdelen);
			}

			if (addedSuccesfull) { //the product trying to be added was a new product?
				list_combobox_update(idProduct);	//add id to listbox
				load_list();
			}
			else { //alter an existing product
				changeProduct();
			}
		}
	}
	
	public static void changeProduct()
	{	
		//FIXME bij eerste klik op add word maar 1 product toegevoegd en bij 2de klik pas de eigenlijke amount
		String typeProduct = frame.comboProduct();
		int Amount = Integer.parseInt(frame.get_textValue());
		String strPriceSell= frame.get_textValueProduct();
		String strPriceBuy= frame.get_textValueProduct();
		String strOmschrijving = frame.get_textDescription();
		String idProduct = frame.get_ID();

		for(int i=0; i < bikeShopStock1.getProductList().size(); i++) {
			Product currentProduct = bikeShopStock1.getProductList().get(i);
			if (currentProduct.getId().equals(idProduct)) {
				currentProduct.Bewerken(Amount, strPriceBuy, strPriceSell, strOmschrijving);
				load_list();
			}
		}
	}
		
		
		
	

	/**
	 * Product incrementen op gui
	 */
	public static void incProduct() {
		
		int amount = Integer.parseInt(frame.get_textValue());
		amount +=1;
		
		String strAmount = ""+amount;
	
		frame.inc_dec_Product("+");
		changeProduct();
		
	}

	/**
	 * Product decrementen op gui
	 */
	public static void decProduct() {

		int amount = Integer.parseInt(frame.get_textValue());
		amount -=1;
		
		String strAmount = ""+amount;
		frame.inc_dec_Product("-");
		changeProduct();	
	}
	
	//FIXME is een test methode
	public static void MakeBike()
	{
		aantalFietsen = aantalFietsen +1;
		
		String strName = frame.get_textNaam();
		String strNumber = frame.get_textNummer();
		String strAddress = frame.get_textAdress();
		
		//FIXME \t werkt precies niet in frames
		frame.list_log_client("ID : " + aantalFietsen + "      Fiets"+aantalFietsen + "                       " +strName +"    " + strNumber  + "          " + strAddress);
		
		
		// dit moet rechtstreeks in stock gebeuren, ik heb hiervoor de ID's van de geselecteerde onderdelen nodig.
		//TODO @KEVIN R kan je zorgen dat ik de geselecteerde ID's krijg
		/*declaratie.aantalKaders[0] -= 1;
		declaratie.aantalWielen[0] -= 1;
		declaratie.aantalLichten[0] -= 1;
		declaratie.aantalBasisonderdelen[0] -= 1;
		declaratie.aantalRemmen[0] -= 1;*/
		
		
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
	
	public static String getBasisOnderdelen() {
		String strReturn = frame.get_lstSelected_basisonderdelen();
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
			if (bikeShopStock1.getProductList().get(i).getId() == getID){
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

	public static void saveXml() {
		
		bikeShopStock1.saveStockToXml();
		System.out.println("XML opgeslagen");
	}

	
}
