package be.uantwerpen.SS.client.view;

import java.awt.EventQueue;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.UIManager;

import be.uantwerpen.SS.client.facade.BikeShop;
import be.uantwerpen.SS.client.view.GuiView;

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
