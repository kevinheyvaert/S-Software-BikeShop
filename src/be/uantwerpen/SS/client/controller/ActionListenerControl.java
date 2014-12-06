package be.uantwerpen.SS.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.uantwerpen.SS.client.facade.BikeShop;
import be.uantwerpen.SS.client.view.GuiView;

public class ActionListenerControl implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("exitProgram")){
			System.exit(0);
		}
		else if(event.getActionCommand().equals("plus")){
			BikeShop.incProduct();
		}
		else if(event.getActionCommand().equals("min")){
			BikeShop.decProduct();
		}
		else if(event.getActionCommand().equals("newProduct")){
			System.out.println("product New");
			BikeShop.newProduct();
			BikeShop.enable_combo();
		}
		else if(event.getActionCommand().equals("addProduct")){
			System.out.println("product add");
			BikeShop.addProduct();
			BikeShop.enable_combo();
		}
		else if(event.getActionCommand().equals("editProduct")){
			System.out.println("product edit");
			BikeShop.changeProduct();
			BikeShop.enable_combo();
		}
		else if(event.getActionCommand().equals("removeProduct")){
			System.out.println("product remove");
			BikeShop.removeProduct();
		}
		else if(event.getActionCommand().equals("credits")){
			System.out.println("credit");
			GuiView.display();
		}
		else if(event.getActionCommand().equals("help")){
			System.out.println("hulp gevraagd");
		}
		else if(event.getActionCommand().equals("assemble")){
			System.out.println("bikeFrame");
			BikeShop.makeBike();
		}
		
		else if(event.getActionCommand().equals("comboID")){
			BikeShop.load_id_data();
		}
		else if(event.getActionCommand().equals("save")){
			BikeShop.saveXml();
		}
    }
}
