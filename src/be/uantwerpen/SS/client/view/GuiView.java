package be.uantwerpen.SS.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Font;

public class GuiView extends JFrame {
	
	/**
	 * Auto generated serialVersionUID
	 */
	private static final long serialVersionUID = -5303356999041974564L;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	
	private JPanel stockPane;
	private JComboBox<String> comboID;
	private JComboBox<String> comboSelectID;
	private JComboBox<String> comboSelectType;
	private JButton btnMoreStock;
	private JButton btnLessStock;
	private JButton btnEdit;
	private JButton btnAddItemStock;
	private JButton btnNewItemStock;
	private JButton btnRemoveItemStock;
	private JTextField txtPriceBuy;
	private JFormattedTextField txtValueInput;
	private NumberFormat amountFormat;
	private JTextField txtDescription;
	private JLabel lblValueProduct;
	private JLabel lblAantal;
	private JLabel lblAk;
	private JLabel lblVk;
	
	private JLabel lblDescription;
	private JLabel lblType;
	private JLabel lblID;

	private JPanel assamblerPane;
	private JPanel panelKader;
	private JPanel panelWielen;
	private JPanel panelRemmen;
	private JPanel panelLichten;
	private JPanel panelBasic;
	private JList<String> lstKader;
	private JList<String> lstWielen;
	private JList<String> lstRemmen;
	private JList<String> lstLichten;
	private JList<String> lstBasic;
	private DefaultListModel<String> modelKader = new DefaultListModel<String>();
	private DefaultListModel<String> modelWielen = new DefaultListModel<String>();
	private DefaultListModel<String> modelRemmen = new DefaultListModel<String>();
	private DefaultListModel<String> modelLichten = new DefaultListModel<String>();
	private DefaultListModel<String> modelBasic = new DefaultListModel<String>();
	private JScrollPane scrollKader;
	private JScrollPane scrollWielen;
	private JScrollPane scrollRemmen;
	private JScrollPane scrollLichten;
	private JScrollPane scrollBasis;
	private JLabel lblKader;
	private JLabel lblWielen;
	private JLabel lblRemmen;
	private JLabel lblLichten;
	private JLabel lblBasic;
	
	private JPanel northPane;
	private JPanel logPane;
	private JList<String> lstLog;
	private DefaultListModel<String> modelLog = new DefaultListModel<String>();
	
	private JPanel clientPane;
	private JTextField txtClientName;
	private JTextField txtClientNumber;
	private JTextField txtClientAdress;
	private JLabel lblClientPane;
	private JButton btnAssemble;
	private JButton btnAssembleSave;
	private JLabel lblLog;
	
	private String selectType;
	private String selectID;
	private JTextField txtPriceSell;

	/**
	 * Create the frame.
	 */
	public GuiView() {
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
        eMenuItem.addActionListener(new ActionListenerControl());
        
        JMenuItem mntmOpen = new JMenuItem("Open");
        mntmOpen.setToolTipText("Een project openen"); 
        mntmOpen.setActionCommand("openProject");
        mntmOpen.addActionListener(new ActionListenerControl());
        file.add(mntmOpen);

        file.add(eMenuItem);

        menuBar.add(file);
        
        JMenu mnKlanten = new JMenu("Klanten");
        menuBar.add(mnKlanten);
        
        JMenuItem mntmBeheren = new JMenuItem("Beheren");
        mntmBeheren.setToolTipText("Klantenlijst beheren"); 
        mntmBeheren.setActionCommand("openClient");
        mntmBeheren.addActionListener(new ActionListenerControl());
        mnKlanten.add(mntmBeheren);
        
        JMenuItem mntmInstellingen = new JMenuItem("Instellingen");
        mntmInstellingen.setToolTipText("Klantenlijst instellen"); 
        mntmInstellingen.setActionCommand("settingClient");
        mntmInstellingen.addActionListener(new ActionListenerControl());
        mnKlanten.add(mntmInstellingen);
        
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        JMenuItem mntmCredits = new JMenuItem("Credits");
        mntmCredits.setActionCommand("credits");
        mntmCredits.addActionListener(new ActionListenerControl());
        mnHelp.add(mntmCredits);
        
        JMenuItem mntmHelpf = new JMenuItem("Help (F1)");
        mntmHelpf.setToolTipText("Helpfunctie voor begeleiding programma"); 
        mntmHelpf.setActionCommand("help");
        mntmHelpf.addActionListener(new ActionListenerControl());
        mnHelp.add(mntmHelpf);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(menuBar);
    }
	
	private void guiStock() {
		
		comboID = new JComboBox<>();
		comboID.setBounds(10, 21, 106, 25);
		comboID.addItem("");
		comboID.setActionCommand("comboID");
		comboID.addActionListener(new ActionListenerControl());
		stockPane.add(comboID);
		
		comboSelectType = new JComboBox<>();
		comboSelectType.setEditable(true);
		comboSelectType.setBounds(333, 102, 158, 22);
		comboSelectType.addItem("Kader");
		comboSelectType.addItem("Wielen");
		comboSelectType.addItem("Remmen");
		comboSelectType.addItem("Lichten");
		comboSelectType.addItem("Basis");
		comboSelectType.addActionListener(new ActionListener(){
			@Override
	        public void actionPerformed(ActionEvent e) {
	         	selectType = comboSelectType.getSelectedItem().toString();
	          	if (comboSelectType.getSelectedItem().equals("") != true){
	           		comboSelectType.setEnabled(false);
	           	}
	        }
	    });
		stockPane.add(comboSelectType);
		
		comboSelectID = new JComboBox<>();
		comboSelectID.setEditable(true);
		comboSelectID.setBounds(333, 127, 158, 25);
		comboSelectID.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
        		selectID = comboSelectID.getSelectedItem().toString();
            	if (comboSelectID.getSelectedItem().equals("") != true){
            		comboSelectID.setEnabled(false);
            	}
            }
        });
		stockPane.add(comboSelectID);
		
		lblAantal = new JLabel("Aantal");
		lblAantal.setBounds(534, 21, 67, 25);
		stockPane.add(lblAantal);
		
		lblAk = new JLabel("AK");
		lblAk.setBounds(411, 21, 21, 25);
		stockPane.add(lblAk);
		
		lblVk = new JLabel("VK");
		lblVk.setBounds(335, 20, 21, 25);
		stockPane.add(lblVk);
		
		//-----------------------------------
		lblValueProduct = new JLabel("Prijs");
		lblValueProduct.setBounds(247, 21, 41, 25);
		stockPane.add(lblValueProduct);
		
		txtPriceBuy = new JTextField();
		txtPriceBuy.setBounds(352, 22, 54, 25);
		stockPane.add(txtPriceBuy);
		
		btnMoreStock = new JButton("+");
		btnMoreStock.setBounds(501, 46, 41, 25);
		btnMoreStock.setActionCommand("plus");
		//btnLessStock.setActionCommand("veranderAantal");
		btnMoreStock.addActionListener(new ActionListenerControl());
		stockPane.add(btnMoreStock);
		
		txtPriceSell = new JTextField();
		txtPriceSell.setBounds(429, 21, 62, 25);
		stockPane.add(txtPriceSell);
		
		btnLessStock = new JButton("-");
		btnLessStock.setBounds(546, 46, 41, 25);
		btnLessStock.setActionCommand("min");
		//btnLessStock.setActionCommand("veranderAantal");
		btnLessStock.addActionListener(new ActionListenerControl());
		stockPane.add(btnLessStock);
		
		amountFormat = NumberFormat.getNumberInstance();
		txtValueInput = new JFormattedTextField(amountFormat);
		txtValueInput.setText("0");
		txtValueInput.setBounds(597, 46, 41, 25);
		stockPane.add(txtValueInput);
		
		//-----------------------------------
		lblDescription = new JLabel("Omschrijving");
		lblDescription.setBounds(247, 47, 87, 25);
		stockPane.add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(333, 53, 158, 43);
		
		stockPane.add(txtDescription);
		
		btnEdit = new JButton("Bewerken");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.setBackground(Color.CYAN);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setOpaque(true);
		btnEdit.setActionCommand("editProduct");
		btnEdit.addActionListener(new ActionListenerControl());
		btnEdit.setBounds(659, 68, 100, 34);
		stockPane.add(btnEdit);
		//-----------------------------------
		lblType = new JLabel("Type");
		lblType.setBounds(247, 101, 100, 25);
		stockPane.add(lblType);
		//-----------------------------------
		lblID = new JLabel("ID");
		lblID.setBounds(247, 127, 100, 25);
		stockPane.add(lblID);
		
		//-----------------------------------
		btnNewItemStock = new JButton("Nieuw");
		btnNewItemStock.addActionListener(new ActionListenerControl());
		btnNewItemStock.setActionCommand("newProduct");
		btnNewItemStock.setBounds(112, 20, 67, 27);
		stockPane.add(btnNewItemStock);

		btnAddItemStock = new JButton("Toevoegen");
		btnAddItemStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddItemStock.setBackground(Color.GREEN);
		btnAddItemStock.setContentAreaFilled(false);
		btnAddItemStock.setOpaque(true);
		btnAddItemStock.setBounds(659, 21, 100, 36);
		btnAddItemStock.setActionCommand("addProduct");
		btnAddItemStock.addActionListener(new ActionListenerControl());
		stockPane.add(btnAddItemStock);
		
		btnRemoveItemStock = new JButton("Verwijderen");
		btnRemoveItemStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveItemStock.setBackground(Color.RED);
		btnRemoveItemStock.setContentAreaFilled(false);
		btnRemoveItemStock.setOpaque(true);
		btnRemoveItemStock.setBounds(659, 116, 100, 36);
		btnRemoveItemStock.setActionCommand("removeProduct");
		btnRemoveItemStock.addActionListener(new ActionListenerControl());
		stockPane.add(btnRemoveItemStock);
	}
	
	private void guiAssebler() {
		
		lblKader = new JLabel("Kader");
		lblKader.setBounds(24, 12, 56, 16);
		panelKader.add(lblKader);
		lstKader = new JList<String>(modelKader);
		scrollKader = new JScrollPane(lstKader);
		scrollKader.setBounds(15, 30, 175, 250);
		panelKader.add(scrollKader);

		lblWielen = new JLabel("Wielen");
		lblWielen.setBounds(24, 12, 56, 16);
		panelWielen.add(lblWielen);
		lstWielen = new JList<String>(modelWielen);
		scrollWielen = new JScrollPane(lstWielen);
		scrollWielen.setBounds(15, 30, 175, 250);
		panelWielen.add(scrollWielen);

		lblRemmen = new JLabel("Remmen");
		lblRemmen.setBounds(24, 12, 56, 16);
		panelRemmen.add(lblRemmen);
		lstRemmen = new JList<String>(modelRemmen);
		scrollRemmen = new JScrollPane(lstRemmen);
		scrollRemmen.setBounds(15, 30, 175, 250);
		panelRemmen.add(scrollRemmen);

		lblLichten = new JLabel("Lichten");
		lblLichten.setBounds(24, 12, 56, 16);
		panelLichten.add(lblLichten);
		lstLichten = new JList<String>(modelLichten);
		scrollLichten = new JScrollPane(lstLichten);
		scrollLichten.setBounds(15, 30, 175, 250);
		panelLichten.add(scrollLichten);

		lblBasic = new JLabel("Basis");
		lblBasic.setBounds(24, 12, 56, 16);
		panelBasic.add(lblBasic);
		lstBasic = new JList<String>(modelBasic);
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
		lstLog = new JList<String>(modelLog);
		lstLog.setBounds(24, 20, 526, 120);
	    logPane.add(lstLog);

		btnAssemble = new JButton("Assemble");
		btnAssemble.setBounds(121, 112, 117, 25);
		btnAssemble.setActionCommand("assemble");
		btnAssemble.addActionListener(new ActionListenerControl());
	    clientPane.add(btnAssemble);
	    
	    btnAssembleSave = new JButton("Save");
	    btnAssembleSave.setBounds(12, 112, 97, 25);
	    btnAssembleSave.setActionCommand("save");
		btnAssembleSave.addActionListener(new ActionListenerControl());
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
	    txtClientAdress.setBounds(12, 75, 226, 25);    
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
	
	public void warningMessage(String warning) {
        String[] items = new String[1];
        items[0] = warning;
        JList<Object> list = new JList<Object>(items);
		list.setBackground(SystemColor.control);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Waarschuwing"));
        panel.add(list);
        JOptionPane.showMessageDialog(null, panel);
    }
	
	public void add_to_list_combobox(String data){
		comboID.addItem(data);
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

	public String get_textValue() {
		String textFieldValue = txtValueInput.getText();
		return textFieldValue;
	}

	public String get_textDescription() {
		String textFieldDescription = txtDescription.getText();
		return textFieldDescription;
	}

	public String comboProduct() {
		String cmboitem = selectType;
		return cmboitem;
	}
	
	public String get_ID() {
		String ID = selectID;
		return ID;
	}
	
	public String get_editID() {
		if (comboID.getSelectedItem() != null) {
			String ID = comboID.getSelectedItem().toString();
			return ID;
		}
		else {
			return null;
		}
	}

	public String getTextPriceBuy() {
		String textFieldValue = txtPriceBuy.getText();
		return textFieldValue;
	}
	
	public String getTextPriceSell() {
		String textFieldValue = txtPriceSell.getText();
		return textFieldValue;
	}
	
	public String get_textNaam() {
		String textFieldNaam = txtClientName.getText();
		return textFieldNaam;
	}
	
	public String get_textNummer() {
		String textFieldNummer = txtClientNumber.getText();
		return textFieldNummer;
	}
	
	public String get_textAdress() {
		String textFieldAdress = txtClientAdress.getText();
		return textFieldAdress;
	}

	public String get_lstSelected_kader() {
		String select = lstKader.getSelectedValue();
		System.out.println(select);
		return select;
	}
	
	public String get_lstSelected_wielen() {
		String select = lstWielen.getSelectedValue();
		System.out.println(select);
		return select;
	}

	public String get_lstSelected_remmen() {
		String select = lstRemmen.getSelectedValue();
		System.out.println(select);
		return select;
	}

	public String get_lstSelected_lichten() {
		String select = lstLichten.getSelectedValue();
		System.out.println(select);
		return select;
	}
	
	public String get_lstSelected_basisonderdelen() {
		String select = lstBasic.getSelectedValue();
		System.out.println(select);
		return select;
	}
	
	public String get_selected(int index){
		if (index < 0){
	        return "bad";
	    }
	    else{
	        return "good";
	    }
	}
	
	
	
	public void enable_combo(){
		comboSelectType.setEnabled(true);
		comboSelectID.setEnabled(true);
	}
	
	public void set_info_comboID(String priceBuy, String priceSell, String descrition, String type, String id, String amount){
		txtValueInput.setText(amount);
		txtPriceBuy.setText(priceBuy);
		txtPriceSell.setText(priceSell);
		txtDescription.setText(descrition);
		comboSelectType.setSelectedItem(type);
		comboSelectType.setEnabled(false);
		comboSelectID.setSelectedItem(id);
		comboSelectID.setEnabled(false);
	}

	public void clearModel() {
		modelKader.clear();
		modelWielen.clear();
		modelRemmen.clear(); 
		modelLichten.clear();
		modelBasic.clear();
	}
	
	public void clearProductFields() {
		txtPriceSell.setText("0");
		txtPriceBuy.setText("0");
		txtDescription.setText("Voer de eigenschappen in");
		comboSelectID.setSelectedItem("ENTERID");
		comboSelectType.setSelectedItem("Kies type");
		txtValueInput.setText("0");
	}
	
	public void ClearSaleReportList() {
		modelLog.clear();
	}
	
	public void clearIdListComboBox() {
		comboID.removeAllItems();
	}
	
	public void inc_dec_Product(String sign){
		if(sign == "+"){
			int amount = Integer.parseInt(txtValueInput.getText());
			amount +=1;
			String put = ""+amount;
			txtValueInput.setText(put);
		}
		else if(sign == "-"){
			int amount = Integer.parseInt(txtValueInput.getText());
			if(amount == 0){
				//NOTHING can't go under 0
			}
			else{
				amount -=1;
				String put = ""+amount;
				txtValueInput.setText(put);
			}
		}
		
	}
}
