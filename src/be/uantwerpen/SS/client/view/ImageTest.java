package be.uantwerpen.SS.client.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class ImageTest extends JFrame{
    private JLayeredPane lpane = new JLayeredPane();
    private ImagePanel panelC;
    private ImagePanel panelK;
    private ImagePanel panelW1;
    
    public ImageTest(String kader, String wiel)
    {
    	panelC = new ImagePanel(new ImageIcon("fiets/volledig.png").getImage());
    	
        setPreferredSize(new Dimension(600, 400));
        setLayout(new BorderLayout());
        add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 600, 400);
        panelC.setBounds(0, 0, 497, 294);
        panelC.setOpaque(true);
        lpane.add(panelC, new Integer(0), 0);
        
        put_weel(wiel);
        put_base(kader);
        
        pack();
    }
    
    public void put_weel(String format) {
    	if(format == "good"){
	    	panelW1 = new ImagePanel(new ImageIcon("fiets/wielGood.png").getImage()); 
    	}
    	else{
    		panelW1 = new ImagePanel(new ImageIcon("fiets/wielBad.png").getImage()); 
    	}
    	panelW1.setBounds(0, 106, 188, 187);
        panelW1.setOpaque(true);
        lpane.add(panelW1, new Integer(1), 0);
    }
    
    public void put_base(String format) {
    	if(format == "good"){
    		panelK = new ImagePanel(new ImageIcon("fiets/kaderGood.png").getImage()); 
    	}
    	else{
    		panelK = new ImagePanel(new ImageIcon("fiets/kaderBad.png").getImage()); 
    	}
        panelK.setBounds(80, 0, 343, 259);
        panelK.setOpaque(true);
        lpane.add(panelK, new Integer(3), 0);
    }
}