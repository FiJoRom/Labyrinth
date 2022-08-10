package labyrinth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class LabyrinthGUI extends JFrame {

	private LabyrinthDaten daten;

	//Attribute Hauptfenster
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
	
	private JLabel spielernummer1;
	private JPanel kartenuebrig1;
	private JLabel spielername1;
	private JLabel kartenanzahl1;
	private JLabel spielernummer2;
	private JPanel kartenuebrig2;
	private JLabel spielername2;
	private JLabel kartenanzahl2;
	private JLabel spielernummer3;
	private JPanel kartenuebrig3;
	private JLabel spielername3;
	private JLabel kartenanzahl3;
	private JLabel spielernummer4;
	private JPanel kartenuebrig4;
	private JLabel spielername4;
	private JLabel kartenanzahl4;
	
	
	private JLabel aktuellerspielername; 
	
	private Willkommen willkommen;
	
	
	public LabyrinthGUI(LabyrinthDaten model) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Das Verrueckte Labyrinth");
		this.daten = model;
		
		// JFrame-Konfiguration
		this.setSize(1500, 1000);
		this.setLocation(200, 20);
		
		//BackgroundPanel
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		//p1.setBackground(Color.lightGray);
		
		//Spieler 1
		spielernummer1 = new JLabel("Spieler 1");	
		spielernummer1.setBounds(20, 35, 200, 30);
		spielernummer1.setFont(spielernummer1.getFont().deriveFont((float) 22));
		p1.add(spielernummer1);	
		kartenuebrig1 = new JPanel();
		String imagePathRueckseite = "Bilder/rueckseite_k.png";
		generiereGangbilder(kartenuebrig1, imagePathRueckseite);
		kartenuebrig1.setBounds(180, 10, 63, 110);
		p1.add(kartenuebrig1);
		kartenanzahl1 = new JLabel("6",SwingConstants.CENTER);
		kartenanzahl1.setBounds(180, 10, 40, 110);
		kartenanzahl1.setFont(kartenanzahl1.getFont().deriveFont((float) 27));
		kartenanzahl1.setForeground(Color.white);
		kartenuebrig1.add(kartenanzahl1);
		spielername1 = new JLabel("Spielername 1");
		spielername1.setBounds(20, 65, 200, 25);
		spielername1.setFont(spielernummer1.getFont().deriveFont((float) 15));
		p1.add(spielername1); 
		
		//Spieler2
		spielernummer2 = new JLabel("Spieler 2");	
		spielernummer2.setBounds(20, 160, 200, 30);
		spielernummer2.setFont(spielernummer2.getFont().deriveFont((float) 22));
		p1.add(spielernummer2);	
		kartenuebrig2 = new JPanel();
		generiereGangbilder(kartenuebrig2, imagePathRueckseite);
		kartenuebrig2.setBounds(180, 135, 63, 110);
		p1.add(kartenuebrig2); 
		spielername2 = new JLabel("Spielername 2");
		spielername2.setBounds(20, 190, 200, 25);
		spielername2.setFont(spielernummer2.getFont().deriveFont((float) 15));
		p1.add(spielername2); 		
		
		//Spieler3
		spielernummer3 = new JLabel("Spieler 3");	
		spielernummer3.setBounds(20, 285, 200, 30);
		spielernummer3.setFont(spielernummer3.getFont().deriveFont((float) 22));
		p1.add(spielernummer3);	
		kartenuebrig3 = new JPanel();
		generiereGangbilder(kartenuebrig3, imagePathRueckseite);	
		kartenuebrig3.setBounds(180, 260, 63, 110);
		p1.add(kartenuebrig3); 
		spielername3 = new JLabel("Spielername 3");
		spielername3.setBounds(20, 315, 200, 25);
		spielername3.setFont(spielernummer3.getFont().deriveFont((float) 15));
		p1.add(spielername3); 	
		
		
		//Spieler4
		spielernummer4 = new JLabel("Spieler 4");
		spielernummer4.setBounds(20, 410, 200, 30);
		spielernummer4.setFont(spielernummer4.getFont().deriveFont((float) 22));
		p1.add(spielernummer4);	
		kartenuebrig4 = new JPanel();
		generiereGangbilder(kartenuebrig4, imagePathRueckseite);
		kartenuebrig4.setBounds(180, 385, 63, 110);
		p1.add(kartenuebrig4); 
		spielername4 = new JLabel("Spielername 4");
		spielername4.setBounds(20, 440, 200, 25);
		spielername4.setFont(spielernummer4.getFont().deriveFont((float) 15));
		p1.add(spielername4); 
		
		
		//Spielfeld
		//Erste Zeile
		//Festes
		JPanel gang00 = new JPanel();
		String imagePath00 = "Bilder/gruen_g.png";
		generiereGangbilder(gang00, imagePath00);
		gang00.setBounds(470, 30, 80, 85);
		p1.add(gang00); 
		
		JPanel gang10 = new JPanel();
		String imagePath10 = "Bilder/gruen_g.png";
		generiereGangbilder(gang10, imagePath10);
		gang10.setBounds(550, 30, 80, 85);
		p1.add(gang10); 
		
		//Festes
		JPanel gang20 = new JPanel();
		String imagePath20 = "Bilder/ring_g.png";
		generiereGangbilder(gang20, imagePath20);
		gang20.setBounds(630, 30, 80, 85);
		p1.add(gang20); 
		
		JPanel gang30 = new JPanel();
		String imagePath30 = "Bilder/gruen_g.png";
		generiereGangbilder(gang30, imagePath30);
		gang30.setBounds(710, 30, 80, 85);
		p1.add(gang30); 
		
		//Festes
		JPanel gang40 = new JPanel();
		String imagePath40 = "Bilder/zaubertrank_g.png";
		generiereGangbilder(gang40, imagePath40);
		gang40.setBounds(790, 30, 80, 85);
		p1.add(gang40); 
		
		JPanel gang50 = new JPanel();
		String imagePath50 = "Bilder/gruen_g.png";
		generiereGangbilder(gang50, imagePath50);
		gang50.setBounds(870, 30, 80, 85);
		p1.add(gang50); 
		
		//Festes
		JPanel gang60 = new JPanel();
		String imagePath60 = "Bilder/gelb_g.png";
		generiereGangbilder(gang60, imagePath60);
		gang60.setBounds(950, 30, 80, 85);
		p1.add(gang60);
		
		//Zweite Zeile
		JPanel gang01 = new JPanel();
		String imagePath01 = "Bilder/gruen_g.png";
		generiereGangbilder(gang01, imagePath01);
		gang01.setBounds(470, 110, 80, 85);
		p1.add(gang01); 
		
		JPanel gang11 = new JPanel();
		String imagePath11 = "Bilder/gruen_g.png";
		generiereGangbilder(gang11, imagePath11);
		gang11.setBounds(550, 110, 80, 85);
		p1.add(gang11); 
		
		JPanel gang21 = new JPanel();
		String imagePath21 = "Bilder/gruen_g.png";
		generiereGangbilder(gang21, imagePath21);
		gang21.setBounds(630, 110, 80, 85);
		p1.add(gang21); 
		
		JPanel gang31 = new JPanel();
		String imagePath31 = "Bilder/gruen_g.png";
		generiereGangbilder(gang31, imagePath31);
		gang31.setBounds(710, 110, 80, 85);
		p1.add(gang31); 
		
		JPanel gang41 = new JPanel();
		String imagePath41 = "Bilder/gruen_g.png";
		generiereGangbilder(gang41, imagePath41);
		gang41.setBounds(790, 110, 80, 85);
		p1.add(gang41); 
		
		JPanel gang51 = new JPanel();
		String imagePath51 = "Bilder/gruen_g.png";
		generiereGangbilder(gang51, imagePath51);
		gang51.setBounds(870, 110, 80, 85);
		p1.add(gang51); 
		
		JPanel gang61 = new JPanel();
		String imagePath61 = "Bilder/gruen_g.png";
		generiereGangbilder(gang61, imagePath61);
		gang61.setBounds(950, 110, 80, 85);
		p1.add(gang61);
		
		//Dritte Zeile
		//Festes
		JPanel gang02 = new JPanel();
		String imagePath02 = "Bilder/kerzenstaender_g.png";
		generiereGangbilder(gang02, imagePath02);
		gang02.setBounds(470, 190, 80, 85);
		p1.add(gang02); 
		
		JPanel gang12 = new JPanel();
		String imagePath12 = "Bilder/gruen_g.png";
		generiereGangbilder(gang12, imagePath12);
		gang12.setBounds(550, 190, 80, 85);
		p1.add(gang12); 
		
		//Festes
		JPanel gang22 = new JPanel();
		String imagePath22 = "Bilder/schatztruhe_g.png";
		generiereGangbilder(gang22, imagePath22);
		gang22.setBounds(630, 190, 80, 85);
		p1.add(gang22); 
		
		JPanel gang32 = new JPanel();
		String imagePath32 = "Bilder/gruen_g.png";
		generiereGangbilder(gang32, imagePath32);
		gang32.setBounds(710, 190, 80, 85);
		p1.add(gang32); 
		
		//Festes
		JPanel gang42 = new JPanel();
		String imagePath42 = "Bilder/krone_g.png";
		generiereGangbilder(gang42, imagePath42);
		gang42.setBounds(790, 190, 80, 85);
		p1.add(gang42); 
		
		JPanel gang52 = new JPanel();
		String imagePath52 = "Bilder/gruen_g.png";
		generiereGangbilder(gang52, imagePath52);
		gang52.setBounds(870, 190, 80, 85);
		p1.add(gang52); 
		
		//Festes
		JPanel gang62 = new JPanel();
		String imagePath62 = "Bilder/buch_g.png";
		generiereGangbilder(gang62, imagePath62);
		gang62.setBounds(950, 190, 80, 85);
		p1.add(gang62);
		
		//Vierte Zeile
		JPanel gang03 = new JPanel();
		String imagePath03 = "Bilder/gruen_g.png";
		generiereGangbilder(gang03, imagePath03);
		gang03.setBounds(470, 270, 80, 85);
		p1.add(gang03); 
		
		JPanel gang13 = new JPanel();
		String imagePath13 = "Bilder/gruen_g.png";
		generiereGangbilder(gang13, imagePath13);
		gang13.setBounds(550, 270, 80, 85);
		p1.add(gang13); 
		
		JPanel gang23 = new JPanel();
		String imagePath23 = "Bilder/gruen_g.png";
		generiereGangbilder(gang23, imagePath23);
		gang23.setBounds(630, 270, 80, 85);
		p1.add(gang23); 
		
		JPanel gang33 = new JPanel();
		String imagePath33 = "Bilder/gruen_g.png";
		generiereGangbilder(gang33, imagePath33);
		gang33.setBounds(710, 270, 80, 85);
		p1.add(gang33); 
		
		JPanel gang43 = new JPanel();
		String imagePath43 = "Bilder/gruen_g.png";
		generiereGangbilder(gang43, imagePath43);
		gang43.setBounds(790, 270, 80, 85);
		p1.add(gang43); 
		
		JPanel gang53 = new JPanel();
		String imagePath53 = "Bilder/gruen_g.png";
		generiereGangbilder(gang53, imagePath53);
		gang53.setBounds(870, 270, 80, 85);
		p1.add(gang53); 
		
		JPanel gang63 = new JPanel();
		String imagePath63 = "Bilder/gruen_g.png";
		generiereGangbilder(gang63, imagePath63);
		gang63.setBounds(950, 270, 80, 85);
		p1.add(gang63);
		
		//Fuenfte Zeile
		//Festes
		JPanel gang04 = new JPanel();
		String imagePath04 = "Bilder/ritterhelm_g.png";
		generiereGangbilder(gang04, imagePath04);
		gang04.setBounds(470, 350, 80, 85);
		p1.add(gang04); 
		
		JPanel gang14 = new JPanel();
		String imagePath14 = "Bilder/gruen_g.png";
		generiereGangbilder(gang14, imagePath14);
		gang14.setBounds(550, 350, 80, 85);
		p1.add(gang14); 
		
		//Festes
		JPanel gang24 = new JPanel();
		String imagePath24 = "Bilder/rubin_g.png";
		generiereGangbilder(gang24, imagePath24);
		gang24.setBounds(630, 350, 80, 85);
		p1.add(gang24); 
		
		JPanel gang34 = new JPanel();
		String imagePath34 = "Bilder/gruen_g.png";
		generiereGangbilder(gang34, imagePath34);
		gang34.setBounds(710, 350, 80, 85);
		p1.add(gang34); 
		
		//Festes
		JPanel gang44 = new JPanel();
		String imagePath44 = "Bilder/schluessel_g.png";
		generiereGangbilder(gang44, imagePath44);
		gang44.setBounds(790, 350, 80, 85);
		p1.add(gang44); 
		
		JPanel gang54 = new JPanel();
		String imagePath54 = "Bilder/gruen_g.png";
		generiereGangbilder(gang54, imagePath54);
		gang54.setBounds(870, 350, 80, 85);
		p1.add(gang54); 
		
		//Festes
		JPanel gang64 = new JPanel();
		String imagePath64 = "Bilder/muenzbeutel_g.png";
		generiereGangbilder(gang64, imagePath64);
		gang64.setBounds(950, 350, 80, 85);
		p1.add(gang64);
		
		//Sechste Zeile
		JPanel gang05 = new JPanel();
		String imagePath05 = "Bilder/gruen_g.png";
		generiereGangbilder(gang05, imagePath05);
		gang05.setBounds(470, 430, 80, 85);
		p1.add(gang05); 
		
		JPanel gang15 = new JPanel();
		String imagePath15 = "Bilder/gruen_g.png";
		generiereGangbilder(gang15, imagePath15);
		gang15.setBounds(550, 430, 80, 85);
		p1.add(gang15); 
		
		JPanel gang25 = new JPanel();
		String imagePath25 = "Bilder/gruen_g.png";
		generiereGangbilder(gang25, imagePath25);
		gang25.setBounds(630, 430, 80, 85);
		p1.add(gang25); 
		
		JPanel gang35 = new JPanel();
		String imagePath35 = "Bilder/gruen_g.png";
		generiereGangbilder(gang35, imagePath35);
		gang35.setBounds(710, 430, 80, 85);
		p1.add(gang35); 
		
		JPanel gang45 = new JPanel();
		String imagePath45 = "Bilder/gruen_g.png";
		generiereGangbilder(gang45, imagePath45);
		gang45.setBounds(790, 430, 80, 85);
		p1.add(gang45); 
		
		JPanel gang55 = new JPanel();
		String imagePath55 = "Bilder/gruen_g.png";
		generiereGangbilder(gang55, imagePath55);
		gang55.setBounds(870, 430, 80, 85);
		p1.add(gang55); 
		
		JPanel gang65 = new JPanel();
		String imagePath65 = "Bilder/gruen_g.png";
		generiereGangbilder(gang65, imagePath65);
		gang65.setBounds(950, 430, 80, 85);
		p1.add(gang65);
		
		//Siebte Zeile
		//Festes
		JPanel gang06 = new JPanel();
		String imagePath06 = "Bilder/blau_g.png";
		generiereGangbilder(gang06, imagePath06);
		gang06.setBounds(470, 510, 80, 85);
		p1.add(gang06);
		
		JPanel gang16 = new JPanel();
		String imagePath16 = "Bilder/gruen_g.png";
		generiereGangbilder(gang16, imagePath16);
		gang16.setBounds(550, 510, 80, 85);
		p1.add(gang16); 
		
		//Festes
		JPanel gang26 = new JPanel();
		String imagePath26 = "Bilder/dolch_g.png";
		generiereGangbilder(gang26, imagePath26);
		gang26.setBounds(630, 510, 80, 85);
		p1.add(gang26); 
		
		JPanel gang36 = new JPanel();
		String imagePath36 = "Bilder/gruen_g.png";
		generiereGangbilder(gang36, imagePath36);
		gang36.setBounds(710, 510, 80, 85);
		p1.add(gang36); 
		
		//Festes
		JPanel gang46 = new JPanel();
		String imagePath46 = "Bilder/kelch_g.png";
		generiereGangbilder(gang46, imagePath46);
		gang46.setBounds(790, 510, 80, 85);
		p1.add(gang46); 
		
		JPanel gang56 = new JPanel();
		String imagePath56 = "Bilder/gruen_g.png";
		generiereGangbilder(gang56, imagePath56);
		gang56.setBounds(870, 510, 80, 85);
		p1.add(gang56); 
		
		//Festes
		JPanel gang66 = new JPanel();
		String imagePath66 = "Bilder/rot_g.png";
		generiereGangbilder(gang66, imagePath66);
		gang66.setBounds(950, 510, 80, 85);
		p1.add(gang66);
		
		
		//EinschiebeGang
		
		
		
		
		//AktuellerSpielerPanel
		JLabel aktuellerSpieler = new JLabel("Aktueller Spieler");
		aktuellerSpieler.setBounds(530, 740, 200, 30);
		aktuellerSpieler.setFont(aktuellerSpieler.getFont().deriveFont((float) 22));
		aktuellerspielername = new JLabel("Name Spieler 1");
		aktuellerspielername.setBounds(530, 770, 200, 25);
		aktuellerspielername.setFont(aktuellerspielername.getFont().deriveFont((float) 18));
		p1.add(aktuellerSpieler);
		p1.add(aktuellerspielername);
		
		JPanel aktuelleSchatzkarte = new JPanel();
		String imagePathSchatzkarte = "Bilder/rueckseite2_k.png";
		generiereGangbilder(aktuelleSchatzkarte, imagePathSchatzkarte);
		aktuelleSchatzkarte.setBounds(780, 670, 127, 205);
		p1.add(aktuelleSchatzkarte);
		
		
		//Joysticks Panel
		
		
		
		//Icons
		ImageIcon obenIcon = new ImageIcon("Bilder/iconoben.png");
		ImageIcon untenIcon = new ImageIcon("Bilder/iconunten.png");
		ImageIcon linksIcon = new ImageIcon("Bilder/iconlinks.png");
		ImageIcon rechtsIcon = new ImageIcon("Bilder/iconrechts.png");
		ImageIcon fertigIcon = new ImageIcon("Bilder/iconfertig.png");
		
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
		private String[] farben = {"Rot","Blau","Gruen","Gelb"};
		private JButton fertig;
		private GridBagLayout gbl;
		
		
		private GridBagConstraints gbc;
		private GridBagConstraints gbcZwei;
		
		Willkommen(){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setTitle("Das Verrueckte LabyrINTh");
			
			// JFrame-Konfiguration
			this.setSize(1200, 800);
			this.setLocation(400, 100);
			gbl = new GridBagLayout();
			this.setLayout(gbl);
						
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(5,5,5,5);
			
			gbcEigenschaftenSetzen(0,0,3,1);
			//gbc.gridx = 0;
			//gbc.gridy = 0;
			//gbc.gridwidth = 3;
			//gbc.gridheight = 1;
			String imagePath = "Bilder/Labyrinth_Logo.png";
			try {
				BufferedImage logo = ImageIO.read(new File(imagePath));
				JLabel picLabel = new JLabel(new ImageIcon(logo));
				bildpanel = new JPanel();
				gbl.setConstraints(bildpanel, gbc);
				this.add(bildpanel);
				bildpanel.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
						
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 3;
			gbc.gridheight = 1;
			gbc.insets = new Insets(5,30,5,5);
			spielerAnzahl = new JLabel ("Wie viele Spieler seid ihr?");
			spielerAnzahl.setSize(300, 30);
			gbl.setConstraints(spielerAnzahl, gbc);
			this.add(spielerAnzahl);
						
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.insets = new Insets(15,30,30,15);
			zweiSpieler = new JButton("Zwei Spieler");
			zweiSpieler.setSize(200, 20);
			zweiSpieler.addActionListener(e -> spielerAnzahlSetzen(2));
			gbl.setConstraints(zweiSpieler, gbc);
			this.add(zweiSpieler);
					
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.insets = new Insets(15,15,30,15);
			dreiSpieler = new JButton("Drei Spieler");
			dreiSpieler.setSize(200, 20);
			dreiSpieler.addActionListener(e -> spielerAnzahlSetzen(3));
			gbl.setConstraints(dreiSpieler, gbc);
			this.add(dreiSpieler);
			
			gbc.gridx = 2;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.insets = new Insets(15,15,30,30);
			vierSpieler = new JButton("Vier Spieler");
			vierSpieler.setSize(200, 20);
			vierSpieler.addActionListener(e -> spielerAnzahlSetzen(4));
			gbl.setConstraints(vierSpieler, gbc);
			this.add(vierSpieler);
			
			pack();			
		}
		
		private void spielerAnzahlSetzen(int spAnzahl){
			daten.setSpieleranzahl(spAnzahl);
			
			gbl.removeLayoutComponent(bildpanel);
			this.remove(bildpanel);
			gbl.removeLayoutComponent(spielerAnzahl);
			this.remove(spielerAnzahl);
			gbl.removeLayoutComponent(zweiSpieler);
			this.remove(zweiSpieler);
			gbl.removeLayoutComponent(dreiSpieler);
			this.remove(dreiSpieler);
			gbl.removeLayoutComponent(vierSpieler);
			this.remove(vierSpieler);
			
			//repaint();
			spielerEigenschaftenSetzen(1);
		}
		
		private void spielerEigenschaftenSetzen(int spielerNummer) {
				
			gbcZwei = new GridBagConstraints();
			gbcZwei.fill = GridBagConstraints.HORIZONTAL;
			gbcZwei.insets = new Insets(5,5,5,5);
			
			gbcZwei.gridx = 0;
			gbcZwei.gridy = 0;
			gbcZwei.gridwidth = 4;
			gbcZwei.gridheight = 1;
			gbl.setConstraints(bildpanel, gbcZwei);
			this.add(bildpanel);
			
			gbcZwei.gridx = 0;
			gbcZwei.gridy = 1;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerNamelabel = new JLabel ("Wie heisst Spieler " + spielerNummer + "?");
			//spielerNamelabel.setSize(300, 30);
			gbl.setConstraints(spielerNamelabel, gbcZwei);
			this.add(spielerNamelabel);
			
			gbcZwei.gridx = 2;
			gbcZwei.gridy = 1;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerFarbe = new JLabel ("Farbe:");
			//spielerFarbe.setSize(300, 30);
			gbl.setConstraints(spielerFarbe, gbcZwei);
			this.add(spielerFarbe);
			
			gbcZwei.gridx = 0;
			gbcZwei.gridy = 2;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerNametext = new JTextArea();
			//spielerNametext.setSize(400, 30);
			gbl.setConstraints(spielerNametext, gbcZwei);
			this.add(spielerNametext);
			
			gbcZwei.gridx = 2;
			gbcZwei.gridy = 2;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerFarbeAuswahl = new JComboBox<String>(farben);
			//spielerFarbeAuswahl.setSize(300, 30);
			gbl.setConstraints(spielerFarbeAuswahl, gbcZwei);
			this.add(spielerFarbeAuswahl);
			
			
			gbcZwei.gridx = 3;
			gbcZwei.gridy = 3;
			gbcZwei.gridwidth = 1;
			gbcZwei.gridheight = 1;
			gbcZwei.insets = new Insets(5,130,15,30);
			fertig = new JButton("Fertig");
			//fertig.setSize(100, 30);
			fertig.addActionListener(e -> spielerEigenschaftenSpeichern(spielerNummer));
			gbl.setConstraints(fertig, gbcZwei);
			this.add(fertig);
			
			pack();
		
		}
		
		private void spielerEigenschaftenSpeichern(int spielerNummer) {
			
			String name = spielerNametext.getText();
			int indexFarbe = spielerFarbeAuswahl.getSelectedIndex();
			String farbe = spielerFarbeAuswahl.getItemAt(indexFarbe);
			daten.getSpielerliste().add(new Spieler(name, farbe));
	

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
				gbl.removeLayoutComponent(bildpanel);
				this.remove(bildpanel);
				gbl.removeLayoutComponent(spielerNamelabel);
				this.remove(spielerNamelabel);
				gbl.removeLayoutComponent(spielerFarbe);
				this.remove(spielerFarbe);
				gbl.removeLayoutComponent(spielerNametext);
				this.remove(spielerNametext);
				gbl.removeLayoutComponent(spielerFarbeAuswahl);
				this.remove(spielerFarbeAuswahl);
				gbl.removeLayoutComponent(fertig);
				this.remove(fertig);
				
				//repaint();
				spielerEigenschaftenSetzen(spielerNummer + 1);
			} else {
				willkommenSchliessen();
				System.out.println(daten.getSpielerliste());
			}
		}
		
		private void gbcEigenschaftenSetzen(int x, int y, int width, int height) {
			this.gbc.gridx = x;
			this.gbc.gridy = y;
			this.gbc.gridwidth = width;
			this.gbc.gridheight = height;
		}
		
		private void gbcZweiEigenschaftenSetzen(int x, int y, int width, int height) {
			this.gbcZwei.gridx = x;
			this.gbcZwei.gridy = y;
			this.gbcZwei.gridwidth = width;
			this.gbcZwei.gridheight = height;
		}
		
		
	}
	
	private void willkommenSchliessen() {
		this.willkommen.setVisible(false);
		spielGenerieren();
	}
	
	private void spielUebersichtGenerieren() {
		switch (daten.getSpieleranzahl()) {
			case 2: 
				p1.remove(spielernummer3);
				p1.remove(kartenuebrig3);
				p1.remove(spielername3);
				p1.remove(spielernummer4);
				p1.remove(kartenuebrig4);
				p1.remove(spielername4);
				repaint();
				spielername1.setText(daten.getSpielerliste().get(0).getName());
				spielername2.setText(daten.getSpielerliste().get(1).getName());
				aktuellerspielername.setText(daten.getSpielerliste().get(0).getName());
				break;
			
			case 3:
				p1.remove(spielernummer4);
				p1.remove(kartenuebrig4);
				p1.remove(spielername4);
				repaint();
				spielername1.setText(daten.getSpielerliste().get(0).getName());
				spielername2.setText(daten.getSpielerliste().get(1).getName());
				spielername3.setText(daten.getSpielerliste().get(2).getName());
				aktuellerspielername.setText(daten.getSpielerliste().get(0).getName());
				break;
				
			case 4:
				spielername1.setText(daten.getSpielerliste().get(0).getName());
				spielername2.setText(daten.getSpielerliste().get(1).getName());
				spielername3.setText(daten.getSpielerliste().get(2).getName());
				spielername4.setText(daten.getSpielerliste().get(3).getName());
				aktuellerspielername.setText(daten.getSpielerliste().get(0).getName());
				break;
			
			default:
				break;
		}
	}
	
	private void spielGenerieren() {
		spielUebersichtGenerieren();
		daten.setKartendeck(Karte.erstelleKartenDeck()); 
		Karte.shuffleKartenDeck(daten.getKartendeck());
		daten.schatzkartenAusteilen(daten.getKartendeck());
		
		System.out.println(daten.getSpielerliste());
	}
	
	//Spielfeld
	private void generiereGangbilder(JPanel gangpanel, String gangpath) {
		try {
			BufferedImage logo = ImageIO.read(new File(gangpath));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			p1.add(gangpanel);
			gangpanel.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	private void beenden() {
		System.exit(0);		
	}
	
}
