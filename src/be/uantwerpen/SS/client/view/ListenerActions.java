package be.uantwerpen.SS.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ListenerActions implements ActionListener {
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
			Main.load_program();
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
			String kader = Main.getKader();
			String wiel = Main.getWiel();
			ImageTest frameBike = new ImageTest(kader, wiel, "bad", "bad");
			frameBike.setVisible(true);
		}
    }
}
