package be.uantwerpen.SS.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.JList;

public class guiVieuw extends JFrame {
	public static final long serialVersionUID = 1L;
	
	public JPanel contentPane;
	public JMenuBar menuBar;
	
	public JPanel stockPane;
	public JComboBox comboProduct;
	public JButton	btnMoreProduct;
	public JButton btnMoreStock;
	public JButton btnLessStock;
	public JButton btnEditDescription;
	public JButton btnEditType;
	public JButton btnEditID;
	public JButton btnAddItemStock;
	public JButton btnRemoveItemStock;
	public JTextField txtValueProduct;
	public JFormattedTextField txtValueInput;
	public NumberFormat amountFormat;
	public JTextField txtDescription;
	public JTextField txtType;
	public JTextField txtID;
	public JLabel lblValueProduct;
	public JLabel lblDescription;
	public JLabel lblType;
	public JLabel lblID;

	public JPanel assamblerPane;
	public JPanel panelKader;
	public JPanel panelWielen;
	public JPanel panelRemmen;
	public JPanel panelLichten;
	public JPanel panelBasic;
	public JList<Object> lstKader;
	public JList<Object> lstWielen;
	public JList<Object> lstRemmen;
	public JList<Object> lstLichten;
	public JList<Object> lstBasic;
	public DefaultListModel<String> modelKader = new DefaultListModel<String>();
	public DefaultListModel<String> modelWielen = new DefaultListModel<String>();
	public DefaultListModel<String> modelRemmen = new DefaultListModel<String>();
	public DefaultListModel<String> modelLichten = new DefaultListModel<String>();
	public DefaultListModel<String> modelBasic = new DefaultListModel<String>();
	public JScrollPane scrollKader;
	public JScrollPane scrollWielen;
	public JScrollPane scrollRemmen;
	public JScrollPane scrollLichten;
	public JScrollPane scrollBasis;
	public JLabel lblKader;
	public JLabel lblWielen;
	public JLabel lblRemmen;
	public JLabel lblLichten;
	public JLabel lblBasic;
	
	public JPanel northPane;
	public JPanel logPane;
	public JList<Object> lstLog;
	public DefaultListModel<String> modelLog = new DefaultListModel<String>();
	public JScrollPane scrollLog;
	
	public JPanel clientPane;
	public JTextField txtClientName;
	public JTextField txtClientNumber;
	public JTextField txtClientAdress;
	public JLabel lblClientPane;
	public JButton btnAssemble;
	public JButton btnAssembleSave;
	public JLabel lblLog;
	

	/**
	 * Create the frame.
	 */
	public guiVieuw() {
		guiInit();
				
		guiMenu();
		
		guiStock();
		
		guiAssebler();

		guiClient();
		
		contentPane.add(stockPane, BorderLayout.NORTH);
		contentPane.add(assamblerPane, BorderLayout.CENTER);
	    contentPane.add(northPane, BorderLayout.SOUTH);
	}
	
	private void guiInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 1024, 768);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		stockPane = new JPanel();
		stockPane.setPreferredSize(new Dimension(1000, 175));
		stockPane.setLayout(null);
		
		assamblerPane = new JPanel(new GridLayout(0,5));
		assamblerPane.setPreferredSize(new Dimension(750, 450));
		panelKader = new JPanel();
		panelKader.setLayout(null);
		panelWielen = new JPanel();
		panelWielen.setLayout(null);
		panelRemmen = new JPanel();
		panelRemmen.setLayout(null);
		panelLichten = new JPanel();
		panelLichten.setLayout(null);
		panelBasic = new JPanel();
		panelBasic.setLayout(null);
		
		northPane = new JPanel(new BorderLayout());
		
		logPane = new JPanel();
		logPane.setPreferredSize(new Dimension(550, 150));
		logPane.setLayout(null);
		
		clientPane = new JPanel();
		clientPane.setPreferredSize(new Dimension(250, 150));
		clientPane.setLayout(null);
		
	}
	
	private void guiMenu() {

		menuBar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setToolTipText("Exit application"); 
        eMenuItem.setActionCommand("exitProgram");
        eMenuItem.addActionListener(new ListenerActions());
        
        JMenuItem mntmOpen = new JMenuItem("Open");
        mntmOpen.setToolTipText("Een project openen"); 
        mntmOpen.setActionCommand("openProject");
        mntmOpen.addActionListener(new ListenerActions());
        file.add(mntmOpen);

        file.add(eMenuItem);

        menuBar.add(file);
        
        JMenu mnKlanten = new JMenu("Klanten");
        menuBar.add(mnKlanten);
        
        JMenuItem mntmBeheren = new JMenuItem("Beheren");
        mntmBeheren.setToolTipText("Klantenlijst beheren"); 
        mntmBeheren.setActionCommand("openClient");
        mntmBeheren.addActionListener(new ListenerActions());
        mnKlanten.add(mntmBeheren);
        
        JMenuItem mntmInstellingen = new JMenuItem("Instellingen");
        mntmInstellingen.setToolTipText("Klantenlijst instellen"); 
        mntmInstellingen.setActionCommand("settingClient");
        mntmInstellingen.addActionListener(new ListenerActions());
        mnKlanten.add(mntmInstellingen);
        
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        JMenuItem mntmCredits = new JMenuItem("Credits");
        mntmCredits.setActionCommand("credits");
        mntmCredits.addActionListener(new ListenerActions());
        mnHelp.add(mntmCredits);
        
        JMenuItem mntmHelpf = new JMenuItem("Help (F1)");
        mntmHelpf.setToolTipText("Helpfunctie voor begeleiding programma"); 
        mntmHelpf.setActionCommand("help");
        mntmHelpf.addActionListener(new ListenerActions());
        mnHelp.add(mntmHelpf);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(menuBar);
    }
	
	private void guiStock() {
		//-----------------------------------
		comboProduct = new JComboBox();			//dropdownmunue
		comboProduct.addItem("Kader");
		comboProduct.addItem("Wielen");
		comboProduct.addItem("Remmen");
		comboProduct.addItem("Lichten");
		comboProduct.addItem("Basis");
		comboProduct.setBounds(15, 20, 100, 25);
		stockPane.add(comboProduct);
		
		btnMoreProduct = new JButton("...");
		btnMoreProduct.setBounds(115, 20, 20, 25);
		stockPane.add(btnMoreProduct);
		//-----------------------------------
		lblValueProduct = new JLabel("Aantal");
		lblValueProduct.setBounds(160, 20, 100, 25);
		stockPane.add(lblValueProduct);
		
		txtValueProduct = new JTextField();
		txtValueProduct.setEnabled(false);
		txtValueProduct.setBounds(232, 20, 50, 25);
		stockPane.add(txtValueProduct);
		
		btnMoreStock = new JButton("+");
		btnMoreStock.setBounds(403, 20, 30, 25);
		btnMoreStock.setActionCommand("plus");
		btnMoreStock.addActionListener(new ListenerActions());
		stockPane.add(btnMoreStock);
		
		btnLessStock = new JButton("-");
		btnLessStock.setBounds(438, 20, 30, 25);
		btnLessStock.setActionCommand("min");
		btnLessStock.addActionListener(new ListenerActions());
		stockPane.add(btnLessStock);
		
		amountFormat = NumberFormat.getNumberInstance();
		txtValueInput = new JFormattedTextField(amountFormat);
		txtValueInput.setText("0");
		txtValueInput.setBounds(473, 20, 30, 25);
		stockPane.add(txtValueInput);
		
		//-----------------------------------
		lblDescription = new JLabel("Onschrijving");
		lblDescription.setBounds(160, 45, 100, 25);
		stockPane.add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setEnabled(false);
		txtDescription.setBounds(232, 45, 150, 50);
		
		stockPane.add(txtDescription);
		
		btnEditDescription = new JButton("bewerk");
		btnEditDescription.setBounds(403, 45, 100, 25);
		stockPane.add(btnEditDescription);
		//-----------------------------------
		lblType = new JLabel("Type");
		lblType.setBounds(160, 100, 100, 25);
		stockPane.add(lblType);
		
		txtType = new JTextField();
		txtType.setEnabled(false);
		txtType.setBounds(232, 100, 150, 25);
		stockPane.add(txtType);
		
		btnEditType = new JButton("bewerk");
		btnEditType.setBounds(403, 100, 100, 25);
		stockPane.add(btnEditType);
		//-----------------------------------
		lblID = new JLabel("ID");
		lblID.setBounds(160, 125, 100, 25);
		stockPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(232, 125, 150, 25);
		stockPane.add(txtID);
		
		btnEditID = new JButton("bewerk");
		btnEditID.setBounds(403, 125, 100, 25);
		stockPane.add(btnEditID);
		
		//-----------------------------------

		btnAddItemStock = new JButton("toevoegen");
		btnAddItemStock.setBackground(Color.GREEN);
		btnAddItemStock.setBounds(540, 20, 100, 50);
		btnAddItemStock.setActionCommand("addProduct");
		btnAddItemStock.addActionListener(new ListenerActions());
		stockPane.add(btnAddItemStock);
		
		btnRemoveItemStock = new JButton("verwijderen");
		btnRemoveItemStock.setBackground(Color.RED);
		btnRemoveItemStock.setBounds(540, 100, 100, 50);
		btnRemoveItemStock.setActionCommand("removeProduct");
		btnRemoveItemStock.addActionListener(new ListenerActions());
		stockPane.add(btnRemoveItemStock);
	}
	
	private void guiAssebler() {
		
		lblKader = new JLabel("Kader");
		lblKader.setBounds(24, 12, 56, 16);
		panelKader.add(lblKader);
		lstKader = new JList(modelKader);
		scrollKader = new JScrollPane(lstKader);
		scrollKader.setBounds(15, 30, 175, 250);
		panelKader.add(scrollKader);

		lblWielen = new JLabel("Wielen");
		lblWielen.setBounds(24, 12, 56, 16);
		panelWielen.add(lblWielen);
		lstWielen = new JList(modelWielen);
		scrollWielen = new JScrollPane(lstWielen);
		scrollWielen.setBounds(15, 30, 175, 250);
		panelWielen.add(scrollWielen);

		lblRemmen = new JLabel("Remmen");
		lblRemmen.setBounds(24, 12, 56, 16);
		panelRemmen.add(lblRemmen);
		lstRemmen = new JList(modelRemmen);
		scrollRemmen = new JScrollPane(lstRemmen);
		scrollRemmen.setBounds(15, 30, 175, 250);
		panelRemmen.add(scrollRemmen);

		lblLichten = new JLabel("Lichten");
		lblLichten.setBounds(24, 12, 56, 16);
		panelLichten.add(lblLichten);
		lstLichten = new JList(modelLichten);
		scrollLichten = new JScrollPane(lstLichten);
		scrollLichten.setBounds(15, 30, 175, 250);
		panelLichten.add(scrollLichten);

		lblBasic = new JLabel("Basis");
		lblBasic.setBounds(24, 12, 56, 16);
		panelBasic.add(lblBasic);
		lstBasic = new JList(modelBasic);
		scrollBasis = new JScrollPane(lstBasic);
		scrollBasis.setBounds(15, 30, 175, 250);
		panelBasic.add(scrollBasis);
		
		assamblerPane.add(panelKader);	
		assamblerPane.add(panelWielen);	
		assamblerPane.add(panelRemmen);	
		assamblerPane.add(panelLichten);
		assamblerPane.add(panelBasic);
	}
	
	private void guiClient() {
		lstLog = new JList(modelLog);
		lstLog.setBounds(24, 20, 520, 120);
	    logPane.add(lstLog);

		btnAssemble = new JButton("Assemble");
		btnAssemble.setBounds(121, 112, 117, 25);
		btnMoreStock.setActionCommand("assemble");
		btnMoreStock.addActionListener(new ListenerActions());
	    clientPane.add(btnAssemble);
	    
	    btnAssembleSave = new JButton("Save");
	    btnAssembleSave.setBounds(12, 112, 97, 25);
	    clientPane.add(btnAssembleSave);
	    
	    lblClientPane = new JLabel("Klantengegevens");
	    lblClientPane.setBounds(12, 8, 110, 16);
	    clientPane.add(lblClientPane);
	    
	    txtClientName = new JTextField();
	    txtClientName.setText("Naam");
	    txtClientName.setBounds(122, 5, 116, 22);
	    txtClientName.setColumns(10);
	    clientPane.add(txtClientName);
	    
	    txtClientNumber = new JTextField();
	    txtClientNumber.setText("Nummer");
	    txtClientNumber.setBounds(122, 40, 116, 22);	    
	    txtClientNumber.setColumns(10);
	    clientPane.add(txtClientNumber);

	    txtClientAdress = new JTextField();
	    txtClientAdress.setText("Adres");
	    txtClientAdress.setBounds(122, 75, 116, 22);    
	    txtClientAdress.setColumns(10);
	    clientPane.add(txtClientAdress);
	    
	    northPane.add(logPane, BorderLayout.WEST);
	    
	    lblLog = new JLabel("Verkoopsrapport");
	    lblLog.setBounds(26, 0, 138, 16);
	    logPane.add(lblLog);
	    northPane.add(clientPane, BorderLayout.EAST);
	}
	
	public static void display() {
        String[] items = {"Kevin Reyntjens", "Kevin Heyvaert", "Matthias de Schepper"};
        JList<Object> list = new JList<Object>(items);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Makers:"));
        panel.add(list);
        JOptionPane.showMessageDialog(null, panel);
    }
	
	public void list_log_client(String data) {
		modelLog.addElement(data);
	}
	
	public void list_kader(String data) {
		modelKader.addElement(data);
	}
	
	public void list_wielen(String data) {
		modelWielen.addElement(data);
	}
	
	public void list_lichten(String data) {
		modelLichten.addElement(data);
	}
	
	public void list_remmen(String data) {
		modelRemmen.addElement(data);
	}
	
	public void list_basis(String data) {
		modelBasic.addElement(data);
	}

	public Object comboProduct() {
		Object cmboitem = comboProduct.getSelectedItem();
		return cmboitem;
	}

	public String get_textValue() {
		String textFieldValue = txtValueInput.getText();
		return textFieldValue;
	}
}
