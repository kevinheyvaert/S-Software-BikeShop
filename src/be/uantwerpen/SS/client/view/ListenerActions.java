package be.uantwerpen.SS.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ListenerActions implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("exitProgram")){
			System.exit(0);
		}
		else if(event.getActionCommand().equals("addProduct")){
			System.out.println("product add");
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
    }
}
