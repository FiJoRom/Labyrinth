package labyrinth;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabyrinthGUI extends JFrame{

	private LabyrinthDaten daten;

	//Attribute Hauptfenster
	private JPanel p1;
	
	private GangPanel[][] organisationGaenge;
	private AktuelleKarte aktuelleKarte;
	
	private JButton dreieckOben1;
	private JButton dreieckOben2;
	private JButton dreieckOben3;
	private JButton dreieckRechts1;
	private JButton dreieckRechts2;
	private JButton dreieckRechts3;
	private JButton dreieckUnten1;
	private JButton dreieckUnten2;
	private JButton dreieckUnten3;
	private JButton dreieckLinks1;
	private JButton dreieckLinks2;
	private JButton dreieckLinks3;
	private JButton[] organisationDreiecke;
	
	private JPanel spielfeldHintergrund;
	private JLabel aktuellerspielername; 
	
	private SpielerPanel spielerPanel1;
	private SpielerPanel spielerPanel2;
	private SpielerPanel spielerPanel3;
	private SpielerPanel spielerPanel4;
	
	private SpielfigurPanel spielfigurRot;
	private SpielfigurPanel spielfigurBlau;
	private SpielfigurPanel spielfigurGelb;
	private SpielfigurPanel spielfigurGruen;
	
	private Willkommen willkommen;
	private GangUebrigPanel ganguebrigpanel;
	private JoystickPanel joystickPanel;
	private AnleitungButton anleitungButton;
	private Gewonnen gewonnen;	
	private HintergrundPanel hintergrundPanel;
	
	private static final long serialVersionUID = 5864611138466679238L;
	
	public LabyrinthGUI(LabyrinthDaten model) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Das Verrueckte Labyrinth");
		this.daten = model;
		this.setResizable(false);
		
		this.setSize(1386, 1050);
		this.setLocation(200, 20);
		
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		
		spielerPanel1 = new SpielerPanel(77,"Spieler 1", "Spielername");
		p1.add(spielerPanel1);
		spielerPanel2 = new SpielerPanel(238,"Spieler 2", "Spielername");
		p1.add(spielerPanel2);
		spielerPanel3 = new SpielerPanel(399,"Spieler 3", "Spielername");
		p1.add(spielerPanel3);
		spielerPanel4 = new SpielerPanel(561,"Spieler 4", "Spielername");
		p1.add(spielerPanel4);
		
		//Spielfiguren
		spielfigurRot = new SpielfigurPanel();
		p1.add(spielfigurRot);
		spielfigurGruen = new SpielfigurPanel();
		p1.add(spielfigurGruen);
		spielfigurGelb = new SpielfigurPanel();
		p1.add(spielfigurGelb);
		spielfigurBlau = new SpielfigurPanel();
		p1.add(spielfigurBlau);
		
		//Dreieckbuttons
		organisationDreiecke = new JButton[12];
		//Dreiecke Oben
		ImageIcon DreieckObenIcon = new ImageIcon("Bilder/pfeil_oben.png");
		ImageIcon DreieckObenIconRollover = new ImageIcon("Bilder/pfeil_oben_mouseover.png");
		dreieckOben1 = new JButton(DreieckObenIcon);
		dreieckOben1.addActionListener(e -> schiebenMitSpieler("oben", 1, 8));
		dreieckOben1.setRolloverIcon(DreieckObenIconRollover);
		dreieckButtonEigenschaften(dreieckOben1, 490, 28, 30, 30);
		organisationDreiecke[0] = dreieckOben1; 
		dreieckOben2 = new JButton(DreieckObenIcon);
		dreieckOben2.addActionListener(e -> schiebenMitSpieler("oben", 3, 7));
		dreieckButtonEigenschaften(dreieckOben2, 670, 28, 30, 30);
		dreieckOben2.setRolloverIcon(DreieckObenIconRollover);
		organisationDreiecke[1] = dreieckOben2; 
		dreieckOben3 = new JButton(DreieckObenIcon);
		dreieckOben3.addActionListener(e -> schiebenMitSpieler("oben", 5, 6));
		dreieckButtonEigenschaften(dreieckOben3, 850, 28, 30, 30);
		dreieckOben3.setRolloverIcon(DreieckObenIconRollover);
		organisationDreiecke[2] = dreieckOben3; 
		
		//Dreiecke Rechts
		ImageIcon DreieckRechtsIcon = new ImageIcon("Bilder/pfeil_rechts.png");
		ImageIcon DreieckRechtsIconRollover = new ImageIcon("Bilder/pfeil_rechts_mouseover.png");
		dreieckRechts1 = new JButton(DreieckRechtsIcon);
		dreieckRechts1.addActionListener(e -> schiebenMitSpieler("rechts", 1, 11));
		dreieckRechts1.setRolloverIcon(DreieckRechtsIconRollover);
		dreieckButtonEigenschaften(dreieckRechts1, 998, 176, 30, 30);
		organisationDreiecke[3] = dreieckRechts1; 
		dreieckRechts2 = new JButton(DreieckRechtsIcon);
		dreieckRechts2.addActionListener(e -> schiebenMitSpieler("rechts", 3, 10));
		dreieckRechts2.setRolloverIcon(DreieckRechtsIconRollover);
		dreieckButtonEigenschaften(dreieckRechts2, 998, 356, 30, 30);
		organisationDreiecke[4] = dreieckRechts2; 
		dreieckRechts3 = new JButton(DreieckRechtsIcon);
		dreieckRechts3.addActionListener(e -> schiebenMitSpieler("rechts", 5, 9));
		dreieckButtonEigenschaften(dreieckRechts3, 998, 536, 30, 30);
		dreieckRechts3.setRolloverIcon(DreieckRechtsIconRollover);
		organisationDreiecke[5] = dreieckRechts3; 
		
		//Dreiecke Unten
		ImageIcon DreieckUntenIcon = new ImageIcon("Bilder/pfeil_unten.png");
		ImageIcon DreieckUntenIconRollover = new ImageIcon("Bilder/pfeil_unten_mouseover.png");
		dreieckUnten1 = new JButton(DreieckUntenIcon);
		dreieckUnten1.addActionListener(e -> schiebenMitSpieler("unten", 1, 0));
		dreieckUnten1.setRolloverIcon(DreieckUntenIconRollover);
		dreieckButtonEigenschaften(dreieckUnten1, 490, 688, 30, 30);
		organisationDreiecke[8] = dreieckUnten1; 
		dreieckUnten2 = new JButton(DreieckUntenIcon);
		dreieckUnten2.addActionListener(e -> schiebenMitSpieler("unten", 3, 1));
		dreieckButtonEigenschaften(dreieckUnten2, 670, 688, 30, 30);
		dreieckUnten2.setRolloverIcon(DreieckUntenIconRollover);
		organisationDreiecke[7] = dreieckUnten2; 
		dreieckUnten3 = new JButton(DreieckUntenIcon);
		dreieckUnten3.addActionListener(e -> schiebenMitSpieler("unten", 5, 2));
		dreieckButtonEigenschaften(dreieckUnten3, 850, 688, 30, 30);
		dreieckUnten3.setRolloverIcon(DreieckUntenIconRollover);
		organisationDreiecke[6] = dreieckUnten3; 
		
		//Dreiecke Links
		ImageIcon DreieckLinksIcon = new ImageIcon("Bilder/pfeil_links.png");
		ImageIcon DreieckLinksIconRollover = new ImageIcon("Bilder/pfeil_links_mouseover.png");
		dreieckLinks1 = new JButton(DreieckLinksIcon);
		dreieckLinks1.addActionListener(e -> schiebenMitSpieler("links", 1, 3));
		dreieckLinks1.setRolloverIcon(DreieckLinksIconRollover);
		dreieckButtonEigenschaften(dreieckLinks1, 342, 176, 30, 30);
		organisationDreiecke[11] = dreieckLinks1; 
		dreieckLinks2 = new JButton(DreieckLinksIcon);
		dreieckLinks2.addActionListener(e -> schiebenMitSpieler("links", 3, 4));
		dreieckButtonEigenschaften(dreieckLinks2, 342, 356, 30, 30);
		dreieckLinks2.setRolloverIcon(DreieckLinksIconRollover);
		organisationDreiecke[10] = dreieckLinks2; 
		dreieckLinks3 = new JButton(DreieckLinksIcon);
		dreieckLinks3.addActionListener(e -> schiebenMitSpieler("links", 5, 5));
		dreieckButtonEigenschaften(dreieckLinks3, 342, 536, 30, 30);
		dreieckLinks3.setRolloverIcon(DreieckLinksIconRollover);
		organisationDreiecke[9] = dreieckLinks3; 

		//Spielfeld
		//Erste Zeile
		//Festes
		GangPanel gang00 = new GangPanel(370,55,"Bilder/gruen_g.png");
		p1.add(gang00); 
		organisationGaenge = new GangPanel[7][7];
      	organisationGaenge[0][0] = gang00;
      	
      	GangPanel gang01 = new GangPanel(460,55,"Bilder/rueckeite_g.png");
		p1.add(gang01); 
		organisationGaenge[0][1] = gang01;
		
		//Festes
		GangPanel gang02 = new GangPanel(550,55,"Bilder/ring_g.png");
		p1.add(gang02); 
		organisationGaenge[0][2] = gang02;
		
		GangPanel gang03 = new GangPanel(640,55,"Bilder/rueckeite_g.png");
		p1.add(gang03); 
		organisationGaenge[0][3] = gang03;
		
		//Festes
		GangPanel gang04 = new GangPanel(730,55,"Bilder/zaubertrank_g.png");
		p1.add(gang04); 
		organisationGaenge[0][4] = gang04;
		
		GangPanel gang05 = new GangPanel(820,55,"Bilder/rueckeite_g.png");
		p1.add(gang05); 
		organisationGaenge[0][5] = gang05;
		
		//Festes
		GangPanel gang06 = new GangPanel(910,55,"Bilder/gelb_g.png");
		p1.add(gang06);
		organisationGaenge[0][6] = gang06;
		
		//Zweite Zeile
		GangPanel gang10 = new GangPanel(370,145,"Bilder/rueckeite_g.png");
		p1.add(gang10); 
		organisationGaenge[1][0] = gang10;
		
		GangPanel gang11 = new GangPanel(460,145,"Bilder/rueckeite_g.png");
		p1.add(gang11); 
		organisationGaenge[1][1] = gang11;
		
		GangPanel gang12 = new GangPanel(550,145,"Bilder/rueckeite_g.png");
		p1.add(gang12); 
		organisationGaenge[1][2] = gang12;
		
		GangPanel gang13 = new GangPanel(640,145,"Bilder/rueckeite_g.png");
		p1.add(gang13); 
		organisationGaenge[1][3] = gang13;
		
		GangPanel gang14 = new GangPanel(730,145,"Bilder/rueckeite_g.png");
		p1.add(gang14); 
		organisationGaenge[1][4] = gang14;
		
		GangPanel gang15 = new GangPanel(820,145,"Bilder/rueckeite_g.png");
		p1.add(gang15); 
		organisationGaenge[1][5] = gang15;
		
		GangPanel gang16 = new GangPanel(910,145,"Bilder/rueckeite_g.png");
		p1.add(gang16);
		organisationGaenge[1][6] = gang16;
		
		//Dritte Zeile
		//Festes
		GangPanel gang20 = new GangPanel(370,235,"Bilder/kerzenstaender_g.png");
		p1.add(gang20); 
		organisationGaenge[2][0] = gang20;
		
		GangPanel gang21 = new GangPanel(460,235,"Bilder/rueckeite_g.png");
		p1.add(gang21); 
		organisationGaenge[2][1] = gang21;
		
		//Festes
		GangPanel gang22 = new GangPanel(550,235,"Bilder/schatztruhe_g.png");
		p1.add(gang22); 
		organisationGaenge[2][2] = gang22;
		
		GangPanel gang23 = new GangPanel(640,235,"Bilder/rueckeite_g.png");
		p1.add(gang23); 
		organisationGaenge[2][3] = gang23;
		
		//Festes
		GangPanel gang24 = new GangPanel(730,235,"Bilder/krone_g.png");
		p1.add(gang24); 
		organisationGaenge[2][4] = gang24;
		
		GangPanel gang25 = new GangPanel(820,235,"Bilder/rueckeite_g.png");
		p1.add(gang25); 
		organisationGaenge[2][5] = gang25;
		
		//Festes
		GangPanel gang26 = new GangPanel(910,235,"Bilder/buch_g.png");
		p1.add(gang26);
		organisationGaenge[2][6] = gang26;
		
		//Vierte Zeile
		GangPanel gang30 = new GangPanel(370,325,"Bilder/rueckeite_g.png");
		p1.add(gang30); 
		organisationGaenge[3][0] = gang30;
		
		GangPanel gang31 = new GangPanel(460,325,"Bilder/rueckeite_g.png");
		p1.add(gang31); 
		organisationGaenge[3][1] = gang31;
		
		GangPanel gang32 = new GangPanel(550,325,"Bilder/rueckeite_g.png");
		p1.add(gang32); 
		organisationGaenge[3][2] = gang32;
		
		GangPanel gang33 = new GangPanel(640,325,"Bilder/rueckeite_g.png");
		p1.add(gang33); 
		organisationGaenge[3][3] = gang33;
		
		GangPanel gang34 = new GangPanel(730,325,"Bilder/rueckeite_g.png");
		p1.add(gang34); 
		organisationGaenge[3][4] = gang34;
		
		GangPanel gang35 = new GangPanel(820,325,"Bilder/rueckeite_g.png");
		p1.add(gang35); 
		organisationGaenge[3][5] = gang35;
		
		GangPanel gang36 = new GangPanel(910,325,"Bilder/rueckeite_g.png");
		p1.add(gang36);
		organisationGaenge[3][6] = gang36;
		
		//Fuenfte Zeile
		//Festes
		GangPanel gang40 = new GangPanel(370,415,"Bilder/ritterhelm_g.png");
		p1.add(gang40); 
		organisationGaenge[4][0] = gang40;
		
		GangPanel gang41 = new GangPanel(460,415,"Bilder/rueckeite_g.png");
		p1.add(gang41);
		organisationGaenge[4][1] = gang41;
		
		//Festes
		GangPanel gang42 = new GangPanel(550,415,"Bilder/rubin_g.png");
		p1.add(gang42); 
		organisationGaenge[4][2] = gang42;
		
		GangPanel gang43 = new GangPanel(640,415,"Bilder/rueckeite_g.png");
		p1.add(gang43); 
		organisationGaenge[4][3] = gang43;
		
		//Festes
		GangPanel gang44 = new GangPanel(730,415,"Bilder/schluessel_g.png");
		p1.add(gang44); 
		organisationGaenge[4][4] = gang44;
		
		GangPanel gang45 = new GangPanel(820,415,"Bilder/rueckeite_g.png");
		p1.add(gang45); 
		organisationGaenge[4][5] = gang45;
		
		//Festes
		GangPanel gang46 = new GangPanel(910,415,"Bilder/muenzbeutel_g.png");
		p1.add(gang46);
		organisationGaenge[4][6] = gang46;
		
		//Sechste Zeile
		GangPanel gang50 = new GangPanel(370,505,"Bilder/rueckeite_g.png");
		p1.add(gang50); 
		organisationGaenge[5][0] = gang50;
		
		GangPanel gang51 = new GangPanel(460,505,"Bilder/rueckeite_g.png");
		p1.add(gang51); 
		organisationGaenge[5][1] = gang51;
		
		GangPanel gang52 = new GangPanel(550,505,"Bilder/rueckeite_g.png");
		p1.add(gang52); 
		organisationGaenge[5][2] = gang52;
		
		GangPanel gang53 = new GangPanel(640,505,"Bilder/rueckeite_g.png");
		p1.add(gang53);
		organisationGaenge[5][3] = gang53;
		
		GangPanel gang54 = new GangPanel(730,505,"Bilder/rueckeite_g.png");
		p1.add(gang54); 
		organisationGaenge[5][4] = gang54;
		
		GangPanel gang55 = new GangPanel(820,505,"Bilder/rueckeite_g.png");
		p1.add(gang55); 
		organisationGaenge[5][5] = gang55;
		
		GangPanel gang56 = new GangPanel(910,505,"Bilder/rueckeite_g.png");
		p1.add(gang56);
		organisationGaenge[5][6] = gang56;
		
		//Siebte Zeile
		//Festes
		GangPanel gang60 = new GangPanel(370,595,"Bilder/blau_g.png");
		p1.add(gang60);
		organisationGaenge[6][0] = gang60;
		
		GangPanel gang61 = new GangPanel(460,595,"Bilder/rueckeite_g.png");
		p1.add(gang61); 
		organisationGaenge[6][1] = gang61;
		
		//Festes
		GangPanel gang62 = new GangPanel(550,595,"Bilder/dolch_g.png");
		p1.add(gang62); 
		organisationGaenge[6][2] = gang62;
		
		GangPanel gang63 = new GangPanel(640,595,"Bilder/rueckeite_g.png");
		p1.add(gang63); 
		organisationGaenge[6][3] = gang63;
		
		//Festes
		GangPanel gang64 = new GangPanel(730,595,"Bilder/kelch_g.png");
		p1.add(gang64); 
		organisationGaenge[6][4] = gang64;
		
		GangPanel gang65 = new GangPanel(820,595,"Bilder/rueckeite_g.png");
		p1.add(gang65); 
		organisationGaenge[6][5] = gang65;
		
		//Festes
		GangPanel gang66 = new GangPanel(910,595,"Bilder/rot_g.png");
		p1.add(gang66);
		organisationGaenge[6][6] = gang66;
		
		//EinschiebeGang
		this.ganguebrigpanel = new GangUebrigPanel();
		p1.add(ganguebrigpanel);	
		ganguebrigpanel.getLinksdrehung().addActionListener(e -> linksDrehung());
		ganguebrigpanel.getRechtsdrehung().addActionListener(e -> rechtsDrehung());
		
		//JoystickPanel
		this.joystickPanel = new JoystickPanel();
		joystickPanel.getFertig().addActionListener(e -> fertigButtonPress());
		joystickPanel.getOben().addActionListener(e -> aktuelleSpielerbewegung("oben"));
		joystickPanel.getUnten().addActionListener(e -> aktuelleSpielerbewegung("unten"));
		joystickPanel.getRechts().addActionListener(e -> aktuelleSpielerbewegung("rechts"));
		joystickPanel.getLinks().addActionListener(e -> aktuelleSpielerbewegung("links"));
		p1.add(joystickPanel);
		sperrenButtons();
		
		//AktuellerSpielerPanel
		JLabel aktuellerSpieler = new JLabel("Aktueller Spieler");
		aktuellerSpieler.setBounds(505, 810, 200, 30);
		aktuellerSpieler.setFont(aktuellerSpieler.getFont().deriveFont((float) 22));
		aktuellerspielername = new JLabel("Name Spieler 1");
		aktuellerspielername.setBounds(505, 840, 200, 25);
		aktuellerspielername.setFont(aktuellerspielername.getFont().deriveFont((float) 18));
		p1.add(aktuellerSpieler);
		p1.add(aktuellerspielername);
		aktuelleKarte = new AktuelleKarte("Bilder/rueckseite2_k.png");
        p1.add(aktuelleKarte);
        
        //DracheUntenLinks
        ImageIcon dracheMitSchatz = new ImageIcon("Bilder/DracheMitSchatz.png");
        ImageIcon dracheMitSchatzMouseover = new ImageIcon("Bilder/DracheMitSchatz_mouseover.png");
        ButtonMitMouseover drachenButton = new ButtonMitMouseover(dracheMitSchatz ,50, 645, 430, 341, dracheMitSchatzMouseover);
        drachenButton.addActionListener(e -> Sound.soundAbspielen("Sounds/drachenRoar.wav"));
        p1.add(drachenButton);
        
        //SpinneObenRechts
        ImageIcon spinneEckeBild = new ImageIcon("Bilder/spinneMitNetz.png");
        ImageIcon spinneEckeBildMouseover = new ImageIcon("Bilder/spinneMitNetz_mouseover.png");
        ButtonMitMouseover spinneEckeButton = new ButtonMitMouseover(spinneEckeBild ,1087, 0, 284, 270, spinneEckeBildMouseover);
        spinneEckeButton.addActionListener(e -> Sound.soundAbspielen("Sounds/spinne.wav"));
        p1.add(spinneEckeButton);
		
		//Anleitung
		ImageIcon buch = new ImageIcon("Bilder/buchAnleitung.png");
		anleitungButton = new AnleitungButton(buch);
		anleitungButton.addActionListener(e -> new Spielanleitung());
		p1.add(anleitungButton);
		
		//Hintergrund Spielfeld Blau
		spielfeldHintergrund = new JPanel();
		spielfeldHintergrund.setBackground(Color.decode("#2a4071"));
		spielfeldHintergrund.setBounds(342, 27, 686, 691);
		p1.add(spielfeldHintergrund);
		
		//Willkommens-Fenster
		willkommen = new Willkommen(this.daten, this);
		willkommen.setVisible(true);
		willkommen.setAlwaysOnTop(true);
	
		//Hintergrund
		this.hintergrundPanel = new HintergrundPanel("#ff9137", "#ffcc40");
		hintergrundPanel.setSize(1400, 1050);
		hintergrundPanel.setVisible(true);
		hintergrundPanel.setOpaque(true);
		p1.add(hintergrundPanel);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void spielUebersichtGenerieren() {
		switch (daten.getSpieleranzahl()) {
			case 2: 
				p1.remove(spielerPanel3);
				p1.remove(spielerPanel4);
				repaint();
				spielerPanel1.getSpielername().setText(daten.getSpielerliste().get(0).getName());
				spielerPanel1.getKartenanzahl().setText("12");
				spielerPanel2.getSpielername().setText(daten.getSpielerliste().get(1).getName());
				spielerPanel2.getKartenanzahl().setText("12");
				aktuellerspielername.setText(daten.getSpielerliste().get(0).getName());
				spielfigurenSetzen();
				break;
			case 3:
				p1.remove(spielerPanel4);
				repaint();
				spielerPanel1.getSpielername().setText(daten.getSpielerliste().get(0).getName());
				spielerPanel1.getKartenanzahl().setText("8");
				spielerPanel2.getSpielername().setText(daten.getSpielerliste().get(1).getName());
				spielerPanel2.getKartenanzahl().setText("8");
				spielerPanel3.getSpielername().setText(daten.getSpielerliste().get(2).getName());
				spielerPanel3.getKartenanzahl().setText("8");
				aktuellerspielername.setText(daten.getSpielerliste().get(0).getName());
				spielfigurenSetzen();
				break;
			case 4:
				spielerPanel1.getSpielername().setText(daten.getSpielerliste().get(0).getName());
				spielerPanel2.getSpielername().setText(daten.getSpielerliste().get(1).getName());
				spielerPanel3.getSpielername().setText(daten.getSpielerliste().get(2).getName());
				spielerPanel4.getSpielername().setText(daten.getSpielerliste().get(3).getName());
				aktuellerspielername.setText(daten.getSpielerliste().get(0).getName());
				spielfigurenSetzen();
				break;
			default:
				break;
		}
	}
	
	private void sperrenButtons() {
		joystickPanel.getOben().setEnabled(false);
		joystickPanel.getRechts().setEnabled(false);
		joystickPanel.getUnten().setEnabled(false);
		joystickPanel.getLinks().setEnabled(false);
		joystickPanel.getFertig().setEnabled(false);
	}
	
	public void willkommenSchliessen() {
		this.willkommen.setVisible(false);
		spielGenerieren();
	}
	
	private void spielGenerieren() {
		spielUebersichtGenerieren();
		daten.setKartendeck(Karte.erstelleKartenDeck()); 
		Karte.shuffleKartenDeck(daten.getKartendeck());
		daten.schatzkartenAusteilen(daten.getKartendeck());
		daten.setAktuellerSpieler(daten.getSpielerliste().get(0));
		spielfeldVorbereiten();
		aktualisiereGanguebrig();
		daten.setAktuellerSpieler(daten.getSpielerliste().get(0));
		aktualisiereDreiecke(true);	
		aktuelleKarte.addMouseListener(new MouseHandler());
	}
	
	public void spielfigurAnzeigenSetzen(int spielerZahl, String farbe) {	
		
		switch(spielerZahl) {
		case 0: 
			String URI0 = "Bilder/spielfigur_" + farbe + "_vorne.png";
			spielerPanel1.getSpielfigurAnzeige().bildaendern(URI0);
			break;
		case 1:
			String URI1 = "Bilder/spielfigur_" + farbe + "_vorne.png";
			spielerPanel2.getSpielfigurAnzeige().bildaendern(URI1);
			break;
		case 2:
			String URI2 = "Bilder/spielfigur_" + farbe + "_vorne.png";
			spielerPanel3.getSpielfigurAnzeige().bildaendern(URI2);
			break;
		case 3:
			String URI3 = "Bilder/spielfigur_" + farbe + "_vorne.png";
			spielerPanel4.getSpielfigurAnzeige().bildaendern(URI3);
			break;
		default:
			break;
		}
	}

	private void spielfeldVorbereiten() {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if((i%2) == 0) {
					if(j < 5) {
						j++;
						String imagepath = pfadBestimmen(i,j);
						this.organisationGaenge[i][j].bildaendern(imagepath);
						int zustand = daten.getSpielfeld().getMatrix()[i][j].getDrehung();
						this.organisationGaenge[i][j].drehen(zustand);
					}
				} else {
					String imagepath = pfadBestimmen(i,j);
					this.organisationGaenge[i][j].bildaendern(imagepath);
					int zustand = daten.getSpielfeld().getMatrix()[i][j].getDrehung();
					this.organisationGaenge[i][j].drehen(zustand);
				}
			}
		}
	}
	
	private String pfadBestimmen(int i, int j) {
		String pfad = "";
		if(!(daten.getSpielfeld().getMatrix()[i][j].schatz.equals("keinSchatz"))) {
			pfad = "Bilder/" + daten.getSpielfeld().getMatrix()[i][j].schatz + "_g.png";
		} else {
			if(daten.getSpielfeld().getMatrix()[i][j] instanceof Ecke ) {
				pfad = "Bilder/ecke_g.png";
			} else {
				pfad = "Bilder/gerade_g.png";
			}
		}
		return pfad;
	}
	

	public void dreieckButtonEigenschaften(JButton dreieck, int x, int y, int breite, int hoehe) {
		dreieck.setBounds(x, y, breite, hoehe);
		dreieck.setBorderPainted(false);
		dreieck.setContentAreaFilled(false);
		dreieck.setFocusPainted(false);
		dreieck.setOpaque(false);
		dreieck.setEnabled(false);
		p1.add(dreieck);
	}
	
	public void spielfigurenSetzen() {
		
		for(int i = 0; i < daten.getSpielerliste().size(); i++) {
			
			switch(daten.getSpielerliste().get(i).getFarbe()) {
			case "Rot": 
				spielfigurRot.setBounds(925, 583, 55, 70);
				spielfigurRot.bildaendern("Bilder/spielfigur_rot.png");
				spielfigurAnzeigenSetzen(daten.getSpielerliste().get(i).getSpielerNummer(), "rot");
				break;
			case "Gruen":
				spielfigurGruen.setBounds(389, 43, 55, 70);
				spielfigurGruen.bildaendern("Bilder/spielfigur_gruen.png");
				spielfigurAnzeigenSetzen(daten.getSpielerliste().get(i).getSpielerNummer(), "gruen");
				break;
			case "Blau":
				spielfigurBlau.setBounds(389, 583, 55, 70);
				spielfigurBlau.bildaendern("Bilder/spielfigur_blau.png");
				spielfigurAnzeigenSetzen(daten.getSpielerliste().get(i).getSpielerNummer(), "blau");
				break;
			case "Gelb":
				spielfigurGelb.setBounds(925, 43, 55, 70);
				spielfigurGelb.bildaendern("Bilder/spielfigur_gelb.png");
				spielfigurAnzeigenSetzen(daten.getSpielerliste().get(i).getSpielerNummer(), "gelb");
				break;
			default: 
				break;
			}
		}	
	}
	
	private class MouseHandler implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {
			String gesuchterSchatzName = daten.getAktuellerSpieler().getKartenblatt().get(0).getSchatz();
	        System.out.println("mouse entered!");
	        String URI = "Bilder/" + gesuchterSchatzName + "_k.png";
	        aktuelleKarte.bildaendern(URI);
	        validate();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			aktuelleKarte.bildaendern("Bilder/rueckseite2_k.png");
			validate();
		}
	}
	
	public void linksDrehung() {
		this.daten.getSpielfeld().getRest().gangkarte90GradDrehenNachLinks();
		ganguebrigpanel.getGanguebrig().drehen(this.daten.getSpielfeld().getRest().drehung);
		repaint();
	}
	
	public void rechtsDrehung() {
		this.daten.getSpielfeld().getRest().gangkarte90GradDrehenNachRechts();
		ganguebrigpanel.getGanguebrig().drehen(this.daten.getSpielfeld().getRest().drehung);
		repaint();
	}
	
	private void schiebenMitSpieler(String richtung, int eingabeStelle, int dreieck) {
		switch(richtung) {
		case "oben":
			daten.getSpielfeld().schiebenInYRichtungVonOben(eingabeStelle);
			einschiebenYRichtung(eingabeStelle);
			break;
		case "rechts":
			daten.getSpielfeld().schiebenInXRichtungVonRechts(eingabeStelle);
			einschiebenXRichtung(eingabeStelle);
			break;
		case "unten":
			daten.getSpielfeld().schiebenInYRichtungVonUnten(eingabeStelle);
			einschiebenYRichtung(eingabeStelle);
			break;
		case "links":
			daten.getSpielfeld().schiebenInXRichtungVonLinks(eingabeStelle);
			einschiebenXRichtung(eingabeStelle);
			break;
		}
		daten.SpielerMitGangVerschieben(richtung, eingabeStelle);
		spielerGrafischAnpassen();
		daten.setVerboten(dreieck);
		organisationDreiecke[dreieck].setEnabled(false);
		aktualisiereDreiecke(false);
		aktualisiereButtons();
		joystickPanel.getFertig().setEnabled(true);
		validate();
	}
	
	public void einschiebenXRichtung(int eingabeStelle) {
		
		for(int i = 0; i < 7; i++) {
			String imagepath = pfadBestimmen(eingabeStelle,i);
			this.organisationGaenge[eingabeStelle][i].bildaendern(imagepath);
			repaint();
			int zustand = daten.getSpielfeld().getMatrix()[eingabeStelle][i].getDrehung();
			this.organisationGaenge[eingabeStelle][i].drehen(zustand);
			validate();
		}
		aktualisiereGanguebrig();
		validate();
	}
	
	public void einschiebenYRichtung(int eingabeStelle) {
		
		for(int i = 0; i < 7; i++) {
			String imagepath = pfadBestimmen(i,eingabeStelle);
			this.organisationGaenge[i][eingabeStelle].bildaendern(imagepath);
			repaint();
			int zustand = daten.getSpielfeld().getMatrix()[i][eingabeStelle].getDrehung();
			this.organisationGaenge[i][eingabeStelle].drehen(zustand);
			validate();
		}
		aktualisiereGanguebrig();
		validate();
	}
	
	private void spielerGrafischAnpassen() {
		for(int i = 0; i < daten.getSpielerliste().size(); i++) {
			if(daten.getSpielerliste().get(i).isVerschoben()) {
				int x = daten.getSpielerliste().get(i).getPositionX();
				int y = daten.getSpielerliste().get(i).getPositionY();
				String farbe = daten.getSpielerliste().get(i).getFarbe();
				spielerBewegungGrafisch(x, y, farbe);
				daten.getSpielerliste().get(i).setVerschoben(false);
			}
		}
	}
	
	private void aktualisiereGanguebrig() {
		String pfad = "";
		if(!(daten.getSpielfeld().getRest().schatz.equals("keinSchatz"))) {
			pfad = "Bilder/" + daten.getSpielfeld().getRest().schatz + "_g.png";
		} else {
			if(daten.getSpielfeld().getRest() instanceof Ecke ) {
				pfad = "Bilder/ecke_g.png";
			} else {
				pfad = "Bilder/gerade_g.png";
			}
		}
		ganguebrigpanel.getGanguebrig().bildaendern(pfad);
		ganguebrigpanel.getGanguebrig().drehen(daten.getSpielfeld().getRest().drehung);
	}
	
	public void aktualisiereDreiecke(boolean wechsel) {
		for(int i = 0; i < organisationDreiecke.length; i++) {
			if(i != daten.getVerboten()) {
				organisationDreiecke[i].setEnabled(wechsel);
			}
		}
	}
	
	public void aktualisiereButtons() {
		if(daten.schrittMoeglichOben()){
			joystickPanel.getOben().setEnabled(true);
		} else {
			joystickPanel.getOben().setEnabled(false);
		}
		if(daten.schrittMoeglichRechts()){
			joystickPanel.getRechts().setEnabled(true);
		} else {
			joystickPanel.getRechts().setEnabled(false);
		}
		if(daten.schrittMoeglichUnten()){
			joystickPanel.getUnten().setEnabled(true);
		} else {
			joystickPanel.getUnten().setEnabled(false);
		}
		if(daten.schrittMoeglichLinks()){
			joystickPanel.getLinks().setEnabled(true);
		} else {
			joystickPanel.getLinks().setEnabled(false);
		}
	}
	
	private void aktuelleSpielerbewegung(String richtung) {
		daten.schrittMachen(richtung);
		int eingabeX = daten.getAktuellerSpieler().getPositionX();
		int eingabeY = daten.getAktuellerSpieler().getPositionY();
		String farbe = daten.getAktuellerSpieler().getFarbe();
		spielerBewegungGrafisch(eingabeX, eingabeY, farbe);
	}
	
	private void spielerBewegungGrafisch(int eingabeX, int eingabeY, String farbe) {
		switch(farbe) {
		case "Rot":
			spielfigurRot.position(eingabeX,eingabeY,farbe);
			break;
		case "Gruen":
			spielfigurGruen.position(eingabeX,eingabeY,farbe);
			break;
		case "Blau":
			spielfigurBlau.position(eingabeX,eingabeY,farbe);
			break;
		case "Gelb":
			spielfigurGelb.position(eingabeX,eingabeY,farbe);
			break;
		}
		repaint();
		aktualisiereButtons();
	}
	
	private void fertigButtonPress() {
		
		gesuchterSchatzPruefen();
		spielerWeitersetzen();
	}
	
private void gesuchterSchatzPruefen() {
		
		int spielerKoordinateX = daten.getAktuellerSpieler().getPositionX();
		int spielerKoordinateY = daten.getAktuellerSpieler().getPositionY();
				
		String gesuchterSchatz = daten.getAktuellerSpieler().getKartenblatt().get(0).getSchatz();
		System.out.println(gesuchterSchatz);
		String aktuellePositionSchatz = daten.getSpielfeld().getMatrix()[spielerKoordinateY][spielerKoordinateX].schatz;
		System.out.println(aktuellePositionSchatz);
		
		if(gesuchterSchatz.equals(aktuellePositionSchatz)) {
			daten.getAktuellerSpieler().getKartenblatt().remove(0);

			switch(daten.getAktuellerSpieler().getSpielerNummer()) {
			case 0: 
				String neueKartenAnzahl1 = "" + daten.getAktuellerSpieler().getKartenblatt().size();
				spielerPanel1.getKartenanzahl().setText(neueKartenAnzahl1);
				break;
			case 1: 
				String neueKartenAnzahl2 = "" + daten.getAktuellerSpieler().getKartenblatt().size();
				spielerPanel2.getKartenanzahl().setText(neueKartenAnzahl2);
				break;
			case 2: 
				String neueKartenAnzahl3 = "" + daten.getAktuellerSpieler().getKartenblatt().size();
				spielerPanel3.getKartenanzahl().setText(neueKartenAnzahl3);
				break;
			case 3: 
				String neueKartenAnzahl4 = "" + daten.getAktuellerSpieler().getKartenblatt().size();
				spielerPanel4.getKartenanzahl().setText(neueKartenAnzahl4);
				break;
			}
		}
		
		if(daten.getAktuellerSpieler().getKartenblatt().isEmpty() &&
				daten.getSpielfeld().getMatrix()[spielerKoordinateY][spielerKoordinateX] 
				instanceof Startfeld) {
			String farbeSpieler = daten.getAktuellerSpieler().getFarbe();
			
			switch(farbeSpieler) {
			case "Rot":
				if(daten.getSpielfeld().getMatrix()[spielerKoordinateY][spielerKoordinateX] 
				   instanceof StartfeldRot) {
					gewinner();
				}
				break;
			case "Blau":
				if(daten.getSpielfeld().getMatrix()[spielerKoordinateY][spielerKoordinateX] 
				   instanceof StartfeldBlau) {
					gewinner();
				}
				break;
			case "Gelb":	
				if(daten.getSpielfeld().getMatrix()[spielerKoordinateY][spielerKoordinateX] 
				   instanceof StartfeldGelb) {
					gewinner();
				}
				break;
			case "Gruen": 
				if(daten.getSpielfeld().getMatrix()[spielerKoordinateY][spielerKoordinateX] 
				   instanceof StartfeldGruen) {
					gewinner();
				}
				break;
			default:
				break;
			}
		}
		validate();
	}
	
	private void spielerWeitersetzen() {
		
		int spielerNummerKopie = daten.getAktuellerSpieler().getSpielerNummer();
		daten.setAktuellerSpieler(daten.getSpielerliste().get((spielerNummerKopie + 1) % daten.getSpieleranzahl()));
		aktualisiereButtons();
		aktuellerspielername.setText(daten.getAktuellerSpieler().getName());
		aktualisiereDreiecke(true);
		sperrenButtons();
		validate();
	}
	
	public void gewinner() {
        gewonnen = new Gewonnen(daten.getSpielerliste());
        gewonnen.setVisible(true);
        gewonnen.setAlwaysOnTop(true);
    }
}