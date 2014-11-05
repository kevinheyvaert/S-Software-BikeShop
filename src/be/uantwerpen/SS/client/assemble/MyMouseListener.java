package be.uantwerpen.SS.client.assemble;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseListener implements MouseListener {  
	private String sort;
	
	MyMouseListener(String sort){
		this.sort = sort;
	}
	public void mouseClicked(MouseEvent event) {  
		System.out.println("entered: "+sort);
	}   
	public void mouseEntered(MouseEvent event) {  
	}   
	public void mouseExited(MouseEvent event) {  
	}   
	public void mousePressed(MouseEvent event) {  
	}   
	public void mouseReleased(MouseEvent event) {  
	}   
}
