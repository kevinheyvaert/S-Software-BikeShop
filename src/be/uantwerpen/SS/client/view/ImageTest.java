package be.uantwerpen.SS.client.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class ImageTest {
	private JFrame frame = new JFrame();
    private JLayeredPane lpane = new JLayeredPane();
    
    public ImageTest()
    {
    	ImagePanel panelC = new ImagePanel(new ImageIcon("fiets/volledig.png").getImage());
    	ImagePanel panelK = new ImagePanel(new ImageIcon("fiets/kaderGood.png").getImage());    
        ImagePanel panelW1 = new ImagePanel(new ImageIcon("fiets/wielBad.png").getImage());       
        
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 600, 400);
        panelC.setBounds(0, 0, 497, 294);
        panelC.setOpaque(true);
        panelK.setBounds(80, 0, 343, 259);
        panelK.setOpaque(true);
        panelW1.setBounds(0, 106, 188, 187);
        panelW1.setOpaque(true);
        lpane.add(panelC, new Integer(0), 0);
        lpane.add(panelW1, new Integer(1), 0);
        lpane.add(panelK, new Integer(3), 0);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ImageTest();
    }  
}