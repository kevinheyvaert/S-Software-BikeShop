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
		}
		else if(event.getActionCommand().equals("min")){
			Main.decProduct();
		}
		else if(event.getActionCommand().equals("addProduct")){
			System.out.println("product add");
			Main.addProduct();
			Main.load_list();
			Main.enable_combo();
		}
		else if(event.getActionCommand().equals("removeProduct")){
			System.out.println("product remove");
		}
		else if(event.getActionCommand().equals("credits")){
			System.out.println("credit");
			guiVieuw.display();
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
			
			assembleGUI frameBike = new assembleGUI(kader, wiel, rem, licht, "bad");
			frameBike.setVisible(true);
		}
		
		else if(event.getActionCommand().equals("comboID")){
			Main.load_id_data();
		}
    }
}
