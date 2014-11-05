package be.uantwerpen.SS.client.model.stock;

//import be.uantwerpen.SS.client.view.MainCommandLine;


public class BikeShopMain {
	public static void main(String[] args) {
		Stock bikeShopStock1 = new Stock();
		System.out.println("BikeShop gestart");
		bikeShopStock1.getStockFromXml();
		int numberOfProductsInStock=bikeShopStock1.getTotalNumberOfProductsInStock();
		
		if (numberOfProductsInStock%3==0){
			Kader nieuwekader = new Kader(""+(numberOfProductsInStock+1), "kader_test"+(numberOfProductsInStock+1), "", "", "");
			bikeShopStock1.addProduct(nieuwekader);
		}
		if (numberOfProductsInStock%3==1){
			Wiel nieuwWiel = new Wiel(""+(numberOfProductsInStock+1), "wiel_test"+(numberOfProductsInStock+1), "", "", "");
			bikeShopStock1.addProduct(nieuwWiel);
		}
		if (numberOfProductsInStock%3==2){
			Rem nieuweRem = new Rem(""+(numberOfProductsInStock+1), "rem_test"+(numberOfProductsInStock+1), "", "", "");
			bikeShopStock1.addProduct(nieuweRem);
		}
		
		System.out.println("Product " +(numberOfProductsInStock+1) + " toegevoegd");
		bikeShopStock1.saveStockToXml();
		
		
    }
}
