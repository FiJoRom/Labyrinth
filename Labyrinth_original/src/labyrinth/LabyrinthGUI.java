package labyrinth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class LabyrinthGUI extends JFrame {

	private LabyrinthDaten daten;

	// Menueleiste
	private JMenuBar menueLeiste;
	private JMenu spielMenue;
	private JMenuItem beenden;
	private JMenuItem neuesSpiel;
	private JMenuItem hilfe;
	private JButton oben;
	private JButton unten;
	private JButton links;
	private JButton rechts;
	private JButton fertig;
	private JPanel p1;
	
	private Willkommen willkommen;
	
	public LabyrinthGUI(LabyrinthDaten model) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Das Verr¸ckte Labyrinth");
		this.daten = model;
		
		// JFrame-Konfiguration
		this.setSize(1500, 1000);
		this.setLocation(200, 20);
		
		//Icons
		ImageIcon obenIcon = new ImageIcon("iconOben.png");
		ImageIcon untenIcon = new ImageIcon("iconUnten.png");
		ImageIcon linksIcon = new ImageIcon("iconLinks.png");
		ImageIcon rechtsIcon = new ImageIcon("iconRechts.png");
		ImageIcon fertigIcon = new ImageIcon("iconFertig.png");
		
		// Menue
		menueLeiste = new JMenuBar();
		spielMenue = new JMenu("Spiel");
		neuesSpiel = new JMenuItem("Neues Spiel");
		hilfe = new JMenuItem("Hilfe");
		beenden = new JMenuItem("Beenden");
		
		oben = new JButton(obenIcon);
		unten = new JButton(untenIcon);
		rechts = new JButton(rechtsIcon);
		links = new JButton(linksIcon);
		fertig = new JButton(fertigIcon);
		
		//Panel
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		p1.setBackground(Color.lightGray);
		
		//Joystick
		oben.setBounds(1250, 690, 52, 52);
		oben.setBorderPainted(false);
		oben.setContentAreaFilled(false);
		oben.setFocusPainted(false);
		oben.setOpaque(false);
		
		unten.setBounds(1250, 810, 52, 52);
		unten.setBorderPainted(false);
		unten.setContentAreaFilled(false);
		unten.setFocusPainted(false);
		unten.setOpaque(false);
		
		rechts.setBounds(1310, 750, 52, 52);
		rechts.setBorderPainted(false);
		rechts.setContentAreaFilled(false);
		rechts.setFocusPainted(false);
		rechts.setOpaque(false);
		
		links.setBounds(1190, 750, 52, 52);
		links.setBorderPainted(false);
		links.setContentAreaFilled(false);
		links.setFocusPainted(false);
		links.setOpaque(false);
		
		fertig.setBounds(1250, 750, 52, 52);
		fertig.setBorderPainted(false);
		fertig.setContentAreaFilled(false);
		fertig.setFocusPainted(false);
		fertig.setOpaque(false);
		
		//ActionListener
		neuesSpiel.addActionListener(e -> {System.exit(0);});
		hilfe.addActionListener(e -> {System.exit(0);});
		beenden.addActionListener(e -> {beenden();});
		
		oben.addActionListener(e -> {System.exit(0);});
		unten.addActionListener(e -> {System.exit(0);});
		rechts.addActionListener(e -> {System.exit(0);});
		links.addActionListener(e -> {System.exit(0);});
		fertig.addActionListener(e -> {System.exit(0);});
		
		//Menueleiste Zuordnung
		menueLeiste.add(spielMenue);
		spielMenue.add(neuesSpiel);
		spielMenue.add(hilfe);
		spielMenue.add(beenden);
		
		p1.add(oben);
		p1.add(unten);
		p1.add(rechts);
		p1.add(links);
		p1.add(fertig);
		
		// zum Fenster hinzufuegen
		this.setJMenuBar(menueLeiste);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				beenden();
			}
		});
		
		//Willkommens-Fenster
		willkommen = new Willkommen();
		willkommen.setVisible(true);
		willkommen.setAlwaysOnTop(true);
		
	}
	
	
	
	private class Willkommen extends JDialog{
		
		private JPanel bildpanel;
		private JPanel abfragepanel;		
		
		//Abfrage 1
		private JLabel spielerAnzahl;
		private JButton zweiSpieler;
		private JButton dreiSpieler;
		private JButton vierSpieler;
		
		//Abfrage 2
		private JLabel spielerNamelabel;
		private JLabel spielerFarbe;
		private JTextArea spielerNametext;
		private JComboBox<String> spielerFarbeAuswahl;
		private String[] farben = {"Rot","Blau","Gr¸n","Gelb"};
		private JButton fertig;
		
		
		Willkommen(){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setTitle("Das Verr¸ckte LabyrINTh");
			
			// JFrame-Konfiguration
			this.setSize(1200, 800);
			this.setLocation(400, 100);
			this.setLayout(new GridLayout(2, 1));
			
			String imagePath = "Labyrinth_Logo.png";
			try {
				BufferedImage logo = ImageIO.read(new File(imagePath));
				JLabel picLabel = new JLabel(new ImageIcon(logo));
				bildpanel = new JPanel();
				this.add(bildpanel);
				bildpanel.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			spielerAnzahl = new JLabel ("Wie viele Spieler seid ihr?");
			zweiSpieler = new JButton("Zwei Spieler");
			dreiSpieler = new JButton("Drei Spieler");
			vierSpieler = new JButton("Vier Spieler");
			
			spielerAnzahl.setBounds(530, 5, 300, 30);
			zweiSpieler.setBounds(400, 100, 110, 20);
			dreiSpieler.setBounds(550, 100, 110, 20);
			vierSpieler.setBounds(700, 100, 110, 20);
			
			abfragepanel = new JPanel();
			abfragepanel.setLayout(null);
			this.add(abfragepanel);
			
			abfragepanel.add(spielerAnzahl);
			abfragepanel.add(zweiSpieler);
			abfragepanel.add(dreiSpieler);
			abfragepanel.add(vierSpieler);
			
			zweiSpieler.addActionListener(e -> spielerAnzahlSetzen(2));
			dreiSpieler.addActionListener(e -> spielerAnzahlSetzen(3));
			vierSpieler.addActionListener(e -> spielerAnzahlSetzen(4));
			
			
						
		}
		
		private void spielerAnzahlSetzen(int spAnzahl){
			daten.setSpieleranzahl(spAnzahl);
			abfragepanel.removeAll();
			repaint();
			spielerEigenschaftenSetzen(1);
		}
		
		private void spielerEigenschaftenSetzen(int spielerNummer) {
						
			spielerNamelabel = new JLabel ("Wie heiﬂt Spieler " + spielerNummer + "?");
			spielerFarbe = new JLabel ("Farbe:");
			spielerNametext = new JTextArea();
			spielerFarbeAuswahl = new JComboBox<String>(farben);
			fertig = new JButton("Fertig");
			
			spielerNamelabel.setBounds(330, 5, 300, 30);
			spielerFarbe.setBounds(750, 5, 300, 30);
			spielerNametext.setBounds(330, 45, 400, 30);
			spielerFarbeAuswahl.setBounds(750, 45, 300, 30);
			fertig.setBounds(500, 100, 100, 30);
			
			abfragepanel.add(spielerNamelabel);
			abfragepanel.add(spielerFarbe);
			abfragepanel.add(spielerNametext);
			abfragepanel.add(spielerFarbeAuswahl);
			abfragepanel.add(fertig);
						
			fertig.addActionListener(e -> spielerEigenschaftenSpeichern(1));			
		}
		
		private void spielerEigenschaftenSpeichern(int spielerNummer) {
			
			String name = spielerNametext.getText();
			int indexFarbe = spielerFarbeAuswahl.getSelectedIndex();
			String farbe = spielerFarbeAuswahl.getItemAt(indexFarbe);
			daten.getSpielerliste().add(new Spieler(name, farbe));
			
			//nochmal
			if(daten.getSpielerliste().size() < daten.getSpieleranzahl()) {
				String[] neueFarbauswahl = new String[farben.length - 1];
				int j = 0;
				for(int i = 0; i < farben.length; i++) {
					if (!farbe.equals(farben[i])) {
						neueFarbauswahl[j] = farben[i];
						j++;
					}
				}
				farben = neueFarbauswahl;
				spielerNametext.setText("");
				abfragepanel.removeAll();
				repaint();
				spielerEigenschaftenSetzen(spielerNummer + 1);
			} else {
				willkommenSchlieﬂen();
			}
		}
		
		
	}
	
	private void willkommenSchlieﬂen() {
		this.willkommen.setVisible(false);
	}
	
	private void beenden() {
		System.exit(0);		
	}
	
	//TODO: Abbruch Abfrage Spielereigenschaften und Spielbeginn, wenn Spieleranzahl erreicht
}
