package be.uantwerpen.SS.client.view;

import be.uantwerpen.SS.client.facade.BikeShop;

public class Main {
	public static boolean debug;
	
	public static void main(String[] args) {
        //switch debugging by argument
		if (args.length ==1) debug = (args[0].equals("-d"));
		else debug = false;
		
        BikeShop bikeShop1 = new BikeShop();
        bikeShop1.start();
	}

	

	
}
