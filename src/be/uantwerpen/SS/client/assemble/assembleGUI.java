package be.uantwerpen.SS.client.assemble;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class assembleGUI extends JFrame{
	public static final long serialVersionUID = 1L; 
	
    private JLayeredPane lpane = new JLayeredPane();
    private ImagePanel panelC;
    private ImagePanel panelK;
    private ImagePanel panelW1;
    private ImagePanel panelW2;
    private ImagePanel panelL;
    private ImagePanel panelZ;
    private ImagePanel panelR;
    
    
    public assembleGUI(String kader, String wiel, String rem, String licht, String zadel)
    {
    	System.out.println("assebmele" + kader + wiel +rem +licht +zadel);
    	panelC = new ImagePanel(new ImageIcon("fiets/volledig.png").getImage());
        setPreferredSize(new Dimension(600, 400));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 600, 400);
        panelC.setBounds(0, 0, 497, 294);
        panelC.setOpaque(true);
        lpane.add(panelC, new Integer(0), 0);
        
        put_weel(wiel);
        put_base(kader);
        put_rem(rem);
        put_licht(licht);
        put_zadel(zadel);
        put_warning();
        
        pack();
    }
    private void put_warning()
    {
	    String[] warning = new String[1];
	    warning[0] = "Maak een keuze uit elke onderdelenlijst!";
	    JList<Object> list = new JList<Object>(warning);
		 list.setBackground(SystemColor.control);
		list.setBounds(70, 320, 400, 20);
		list.setFont(new Font("Tahoma", Font.BOLD, 18));
		lpane.add(new JLabel("Waarschuwing"));
		lpane.add(list);
    }
    private void put_weel(String format) {
    	if(format !=null){
	    	panelW1 = new ImagePanel(new ImageIcon("fiets/wielGood.png").getImage()); 
	    	panelW2 = new ImagePanel(new ImageIcon("fiets/wielGood.png").getImage()); 
    	}
    	else{
    		panelW1 = new ImagePanel(new ImageIcon("fiets/wielBad.png").getImage()); 
    		panelW2 = new ImagePanel(new ImageIcon("fiets/wielBad.png").getImage()); 
    	}
    	panelW1.setBounds(0, 106, 188, 187);
        panelW1.setOpaque(true);
        panelW1.addMouseListener(new MyMouseListener("wiel"));  
        panelW2.setBounds(309, 106, 188, 187);
        panelW2.setOpaque(true);
        panelW2.addMouseListener(new MyMouseListener("wiel"));  
        lpane.add(panelW1, new Integer(1), 0);
        lpane.add(panelW2, new Integer(1), 0);
    }
    
    public void put_base(String format) {
    	if(format !=null){
    		panelK = new ImagePanel(new ImageIcon("fiets/kaderGood.png").getImage()); 
    	}
    	else{
    		panelK = new ImagePanel(new ImageIcon("fiets/kaderBad.png").getImage()); 
    	}
        panelK.setBounds(83, 0, 343, 259);
        panelK.setOpaque(true);
        panelK.addMouseListener(new MyMouseListener("kader")); 
        lpane.add(panelK, new Integer(2), 0);
    }
    
    private void put_licht(String format) {
    	if(format !=null){
    		panelL = new ImagePanel(new ImageIcon("fiets/lichtFGood.png").getImage()); 
    	}
    	else{
    		panelL = new ImagePanel(new ImageIcon("fiets/lichtFBad.png").getImage()); 
    	}
        panelL.setBounds(111, 59, 25, 31);
        panelL.setOpaque(true);
        panelL.addMouseListener(new MyMouseListener("licht")); 
        lpane.add(panelL, new Integer(3), 0);
    }
    
    private void put_rem(String format) {
    	if(format !=null){
    		panelR = new ImagePanel(new ImageIcon("fiets/remGood.png").getImage()); 
    	}
    	else{
    		panelR = new ImagePanel(new ImageIcon("fiets/remBad.png").getImage()); 
    	}
    	panelR.setBounds(0, 0, 0, 0);
    	panelR.setOpaque(true);
        panelR.addMouseListener(new MyMouseListener("rem")); 
        lpane.add(panelR, new Integer(4), 0);
	}

    private void put_zadel(String format) {
    	if(format !=null){
    		panelZ = new ImagePanel(new ImageIcon("fiets/zadelGood.png").getImage()); 
    	}
    	else{
    		panelZ = new ImagePanel(new ImageIcon("fiets/zadelBad.png").getImage()); 
    	}
    	panelZ.setBounds(291, 0, 91, 35);
    	panelZ.setOpaque(true);
        panelZ.addMouseListener(new MyMouseListener("zadel")); 
        lpane.add(panelZ, new Integer(5), 0);
    }
}