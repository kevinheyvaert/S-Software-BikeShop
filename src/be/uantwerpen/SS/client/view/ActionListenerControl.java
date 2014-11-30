package be.uantwerpen.SS.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.uantwerpen.SS.client.assemble.assembleGUI;

class ActionListenerControl implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("exitProgram")){
			System.exit(0);
		}
		else if(event.getActionCommand().equals("plus")){
			Main.incProduct();
			Main.updateProductSelectorView();
		}
		else if(event.getActionCommand().equals("min")){
			Main.decProduct();
			Main.updateProductSelectorView();
		}
		else if(event.getActionCommand().equals("newProduct")){
			System.out.println("product New");
			Main.newProduct();
			Main.enable_combo();
		}
		else if(event.getActionCommand().equals("addProduct")){
			System.out.println("product add");
			Main.addProduct();
			Main.enable_combo();
		}
		else if(event.getActionCommand().equals("editProduct")){
			System.out.println("product edit");
			Main.changeProduct();
			Main.enable_combo();
		}
		else if(event.getActionCommand().equals("removeProduct")){
			System.out.println("product remove");
			Main.removeProduct();
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
			Main.MakeBike();
			String kader = Main.getKader();
			String wiel = Main.getWiel();
			String rem = Main.getRem();
			String licht = Main.getLicht();
			String basis = Main.getBasisOnderdelen();
			Main.updateProductSelectorView();
		}
		
		else if(event.getActionCommand().equals("comboID")){
			Main.load_id_data();
		}
		else if(event.getActionCommand().equals("save")){
			Main.saveXml();
		}
    }
}
