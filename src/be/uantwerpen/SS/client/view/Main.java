package be.uantwerpen.SS.client.view;

import java.awt.EventQueue;
import java.util.List;

import javax.sound.sampled.Line;

import be.uantwerpen.SS.client.assemble.assembleGUI;
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
					updateProductSelectorView();
					updateSalesReportView();
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
			updateIdListComboBox();	//update combobox
		}
	}
	
	
	public static void updateProductSelectorView(){
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
	
	public static void updateSalesReportView(){
		frame.ClearSaleReportList();
		for(int i=0; i < bikeShopVerkoopsRapport1.getVerkoopList().size(); i++){
			Verkoop verkoop = bikeShopVerkoopsRapport1.getVerkoopList().get(i);
			frame.list_log_client("ID : " + verkoop.getFiets().getFietsNaam() + "      Klant:  " +verkoop.getKlant().getNaam() +"    " + verkoop.getKlant().getNummer()  + "          " + verkoop.getKlant().getAdres());
		}		
	}
	
	public static void updateIdListComboBox(){	
		frame.clearIdListComboBox();
		for(int i=0; i < bikeShopStock1.getProductList().size(); i++){
			frame.add_to_list_combobox(bikeShopStock1.getProductList().get(i).getId());
		}
		
	}
	
	public static void newProduct() {
		frame.clearProductFields();
	}
	
	public static void addProduct()
	{		
		//FIXME bij eerste klik op add word maar 1 product toegevoegd en bij 2de klik pas de eigenlijke amount
		String typeProduct = frame.comboProduct();
		int Amount = Integer.parseInt(frame.get_textValue());
		String strPriceSell= frame.getTextPriceSell();
		String strPriceBuy= frame.getTextPriceBuy();
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
				updateIdListComboBox();	//add id to listbox
				updateProductSelectorView();
			}
			else { 
				//TODO kan voor deze error een pop-up venster gemaakt worden.
				System.out.println("Als je een artikel wilt bewerken, klik dan bewerken. Als je een artikel wil toevoegen klik dan eerst Nieuw");
			}
		}
	}
	
	public static void changeProduct()
	{	
		int Amount = Integer.parseInt(frame.get_textValue());
		String strPriceSell= frame.getTextPriceSell();
		String strPriceBuy= frame.getTextPriceBuy();
		String strOmschrijving = frame.get_textDescription();
		String idProduct = frame.get_ID();

		for(int i=0; i < bikeShopStock1.getProductList().size(); i++) {
			Product currentProduct = bikeShopStock1.getProductList().get(i);
			if (currentProduct.getId().equals(idProduct)) {
				currentProduct.Bewerken(Amount, strPriceBuy, strPriceSell, strOmschrijving);
				updateProductSelectorView();
			}
		}
	}
	
	public static void removeProduct()
	{	
		String idProduct = frame.get_ID();

		for(int i=0; i < bikeShopStock1.getProductList().size(); i++) {
			Product currentProduct = bikeShopStock1.getProductList().get(i);
			if (currentProduct.getId().equals(idProduct)) {
				bikeShopStock1.getProductList().remove(i);
				updateProductSelectorView();
				updateIdListComboBox();
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
	public static void MakeBike() {
		aantalFietsen = aantalFietsen +1;
		
		String strName = frame.get_textNaam();
		String strNumber = frame.get_textNummer();
		String strAddress = frame.get_textAdress();
		
		String selectedRemOmschrijving = parseSelectedProduct(frame.get_lstSelected_remmen());
		String selectedKaderOmschrijving = parseSelectedProduct(frame.get_lstSelected_kader());
		String selectedWielOmschrijving = parseSelectedProduct(frame.get_lstSelected_wielen());
		String selectedLichtOmschrijving = parseSelectedProduct(frame.get_lstSelected_lichten());
		String selectedBaisonderdelenOmschrijving = parseSelectedProduct(frame.get_lstSelected_basisonderdelen());
		String selectedRemId=null, selectedKaderId=null, selectedWielId= null, selectedLichtId=null, selectedBasisonderdelenId=null;
		
		//beter zou zijn te iteraten over ID ipv op Omschrijving. Omschrijving is namelijk niet verplicht uniek. uniek maken?
		for(int i=0; i < bikeShopStock1.getProductList().size(); i++) {
			Product currentProduct = bikeShopStock1.getProductList().get(i);
			if (currentProduct.getOmschrijving().equals(selectedRemOmschrijving)) {
				System.out.println("Rem match");
				selectedRemId = currentProduct.getId();
				currentProduct.Verminderen(); 
			}
			else if (currentProduct.getOmschrijving().equals(selectedKaderOmschrijving)) {
				selectedKaderId = currentProduct.getId();
				currentProduct.Verminderen(); 
			}
			else if (currentProduct.getOmschrijving().equals(selectedWielOmschrijving)) {
				selectedWielId = currentProduct.getId();
				currentProduct.Verminderen(); 
			}
			else if (currentProduct.getOmschrijving().equals(selectedLichtOmschrijving)) {
				selectedLichtId = currentProduct.getId();
				currentProduct.Verminderen(); 
			}
			else if (currentProduct.getOmschrijving().equals(selectedBaisonderdelenOmschrijving)) {
				selectedBasisonderdelenId = currentProduct.getId();
				currentProduct.Verminderen(); 
			}
			
		}
		
		if (selectedKaderId!=null && selectedWielId!=null && selectedRemId!=null && selectedLichtId!=null && selectedBasisonderdelenId!=null) {
			Klant klant = new Klant(strName, strNumber, strAddress);
			String fietsNaam = "FIETS" + bikeShopVerkoopsRapport1.getVerkoopList().size();
			Fiets fiets	= new Fiets(fietsNaam, selectedKaderId, selectedWielId, selectedRemId, selectedLichtId, selectedBasisonderdelenId);
			bikeShopVerkoopsRapport1.addVerkoop(new Verkoop(klant, fiets));	
			updateSalesReportView();
		}
		else {
			System.out.println("Niet alle nodige onderdelen zijn gekozen. Kies een onderdeel uit elke categorie");
			assembleGUI frameBike = new assembleGUI(selectedKaderId, selectedWielId, selectedRemId, selectedLichtId, selectedBasisonderdelenId);
			frameBike.setVisible(true);
		}
		updateProductSelectorView(); //FIXME om aantal in aantalveld stock up te daten na een assembly --> werkt niet :(
	}
	
	private static String parseSelectedProduct(String productOmschrijving) {
		String parsedString;
		if (productOmschrijving!=null){
			String splitProductOmschrijving[] = productOmschrijving.split(" :");
			if (splitProductOmschrijving[0] != null) {
				parsedString = splitProductOmschrijving[0];
			}
			else {
				parsedString = null;
			}
		}
		else {
			parsedString = null;
		}
		return parsedString;
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
		bikeShopVerkoopsRapport1.saveVerkoopsRapportToXml();
		System.out.println("XML opgeslagen");
	}

	
}
