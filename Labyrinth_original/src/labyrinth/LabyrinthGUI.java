package labyrinth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class LabyrinthGUI extends JFrame{

	private LabyrinthDaten daten;

	//Attribute Hauptfenster
	private JMenuBar menueLeiste;
	private JMenu spielMenue;
	private JMenuItem beenden;
	private JMenuItem neuesSpiel;
	private JMenuItem hilfe;
	private JPanel p1;
	
	//private GangPanel gang00;
	
	//neu
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
	
	private JPanel drachenBild;
	
	private Willkommen willkommen;
	private Anleitung anleitung;	
	private GangUebrigPanel ganguebrigpanel;
	private JoystickPanel joystickPanel;
	
	public LabyrinthGUI(LabyrinthDaten model) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Das Verrueckte Labyrinth");
		this.daten = model;
		
		// JFrame-Konfiguration
		this.setSize(1400, 1050);
		this.setLocation(200, 20);
		
		//BackgroundPanel
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		//p1.setBackground(Color.lightGray);
		
		spielerPanel1 = new SpielerPanel(77,"Spieler 1", "Spielername");
		p1.add(spielerPanel1);
		/*
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
		*/
		
		spielerPanel2 = new SpielerPanel(238,"Spieler 2", "Spielername");
		p1.add(spielerPanel2);
		/*
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
		*/
		
		spielerPanel3 = new SpielerPanel(399,"Spieler 3", "Spielername");
		p1.add(spielerPanel3);
		
		spielerPanel4 = new SpielerPanel(561,"Spieler 4", "Spielername");
		p1.add(spielerPanel4);
		
		/*
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
		*/
		
		//Spielfiguren
		
		//spielfigurRot = new SpielfigurPanel(397, 60, 40, 51, "Bilder/spielfigur_rot.png");
		spielfigurRot = new SpielfigurPanel();
		p1.add(spielfigurRot);
		spielfigurGruen = new SpielfigurPanel();
		p1.add(spielfigurGruen);
		spielfigurGelb = new SpielfigurPanel();
		p1.add(spielfigurGelb);
		spielfigurBlau = new SpielfigurPanel();
		p1.add(spielfigurBlau);
		
		
		//Dreieckbuttons
		//Dreiecke Oben
		ImageIcon DreieckObenIcon = new ImageIcon("Bilder/pfeil_oben.png");
		ImageIcon DreieckObenIconRollover = new ImageIcon("Bilder/pfeil_oben_mouseover.png");
		dreieckOben1 = new JButton(DreieckObenIcon);
		dreieckOben1.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInYRichtungVonOben(1);einschiebenYRichtung(1);});
		dreieckOben1.setRolloverIcon(DreieckObenIconRollover);
		dreieckButtonEigenschaften(dreieckOben1, 490, 28, 30, 30);
		dreieckOben2 = new JButton(DreieckObenIcon);
		dreieckOben2.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInYRichtungVonOben(3);einschiebenYRichtung(3);});
		dreieckButtonEigenschaften(dreieckOben2, 670, 28, 30, 30);
		dreieckOben2.setRolloverIcon(DreieckObenIconRollover);
		dreieckOben3 = new JButton(DreieckObenIcon);
		dreieckOben3.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInYRichtungVonOben(5);einschiebenYRichtung(5);});
		dreieckButtonEigenschaften(dreieckOben3, 850, 28, 30, 30);
		dreieckOben3.setRolloverIcon(DreieckObenIconRollover);
		
		//Dreiecke Rechts
		ImageIcon DreieckRechtsIcon = new ImageIcon("Bilder/pfeil_rechts.png");
		ImageIcon DreieckRechtsIconRollover = new ImageIcon("Bilder/pfeil_rechts_mouseover.png");
		dreieckRechts1 = new JButton(DreieckRechtsIcon);
		dreieckRechts1.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInXRichtungVonRechts(1);einschiebenXRichtung(1);});
		dreieckRechts1.setRolloverIcon(DreieckRechtsIconRollover);
		dreieckButtonEigenschaften(dreieckRechts1, 998, 176, 30, 30);
		dreieckRechts2 = new JButton(DreieckRechtsIcon);
		dreieckRechts2.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInXRichtungVonRechts(3);einschiebenXRichtung(3);});
		dreieckRechts2.setRolloverIcon(DreieckRechtsIconRollover);
		dreieckButtonEigenschaften(dreieckRechts2, 998, 356, 30, 30);
		dreieckRechts3 = new JButton(DreieckRechtsIcon);
		dreieckRechts3.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInXRichtungVonRechts(5);einschiebenXRichtung(5);});
		dreieckButtonEigenschaften(dreieckRechts3, 998, 536, 30, 30);
		dreieckRechts3.setRolloverIcon(DreieckRechtsIconRollover);
		
		//Dreiecke Unten
		ImageIcon DreieckUntenIcon = new ImageIcon("Bilder/pfeil_unten.png");
		ImageIcon DreieckUntenIconRollover = new ImageIcon("Bilder/pfeil_unten_mouseover.png");
		dreieckUnten1 = new JButton(DreieckUntenIcon);
		dreieckUnten1.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInYRichtungVonUnten(1);einschiebenYRichtung(1);});
		dreieckUnten1.setRolloverIcon(DreieckUntenIconRollover);
		dreieckButtonEigenschaften(dreieckUnten1, 490, 688, 30, 30);
		dreieckUnten2 = new JButton(DreieckUntenIcon);
		dreieckUnten2.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInYRichtungVonUnten(3);einschiebenYRichtung(3);});
		dreieckButtonEigenschaften(dreieckUnten2, 670, 688, 30, 30);
		dreieckUnten2.setRolloverIcon(DreieckUntenIconRollover);
		dreieckUnten3 = new JButton(DreieckUntenIcon);
		dreieckUnten3.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInYRichtungVonUnten(5);einschiebenYRichtung(5);});
		dreieckButtonEigenschaften(dreieckUnten3, 850, 688, 30, 30);
		dreieckUnten3.setRolloverIcon(DreieckUntenIconRollover);
		
		//Dreiecke Links
		ImageIcon DreieckLinksIcon = new ImageIcon("Bilder/pfeil_links.png");
		ImageIcon DreieckLinksIconRollover = new ImageIcon("Bilder/pfeil_links_mouseover.png");
		dreieckLinks1 = new JButton(DreieckLinksIcon);
		dreieckLinks1.addActionListener(e -> 
			{daten.getSpielfeld().schiebenInXRichtungVonLinks(1);einschiebenXRichtung(1);});
		dreieckLinks1.setRolloverIcon(DreieckLinksIconRollover);
		dreieckButtonEigenschaften(dreieckLinks1, 342, 176, 30, 30);
		dreieckLinks2 = new JButton(DreieckLinksIcon);
		dreieckLinks2.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInXRichtungVonLinks(3);einschiebenXRichtung(3);});
		dreieckButtonEigenschaften(dreieckLinks2, 342, 356, 30, 30);
		dreieckLinks2.setRolloverIcon(DreieckLinksIconRollover);
		dreieckLinks3 = new JButton(DreieckLinksIcon);
		dreieckLinks3.addActionListener(e -> 
		{daten.getSpielfeld().schiebenInXRichtungVonLinks(5);einschiebenXRichtung(5);});
		dreieckButtonEigenschaften(dreieckLinks3, 342, 536, 30, 30);
		dreieckLinks3.setRolloverIcon(DreieckLinksIconRollover);

		//Spielfeld
		//Erste Zeile
		//Festes
		GangPanel gang00 = new GangPanel(370,55,"Bilder/gruen_g.png");
		/*
		gang00 = new JPanel();
		String imagePath00 = "Bilder/gruen_g.png";
		generiereGangbilder(gang00, imagePath00);
		gang00.setBounds(370, 55, 90, 95);
		gang00.setOpaque(false);
		*/
		p1.add(gang00); 
		organisationGaenge = new GangPanel[7][7];
      	organisationGaenge[0][0] = gang00;
		
      	GangPanel gang01 = new GangPanel(460,55,"Bilder/rueckeite_g.png");
      	/*
		String imagePath10 = "Bilder/gruen_g.png";
		generiereGangbilder(gang01, imagePath10);
		gang01.setBounds(460, 55, 90, 95);
		gang01.setOpaque(false);
		*/
		p1.add(gang01); 
		organisationGaenge[0][1] = gang01;
		
		//Festes
		GangPanel gang02 = new GangPanel(550,55,"Bilder/ring_g.png");
		/*
		String imagePath20 = "Bilder/ring_g.png";
		generiereGangbilder(gang02, imagePath20);
		gang02.setBounds(550, 55, 90, 95);
		gang02.setOpaque(false);
		*/
		p1.add(gang02); 
		organisationGaenge[0][2] = gang02;
		
		GangPanel gang03 = new GangPanel(640,55,"Bilder/rueckeite_g.png");
		/*
		String imagePath30 = "Bilder/gruen_g.png";
		generiereGangbilder(gang03, imagePath30);
		gang03.setBounds(640, 55, 90, 95);
		gang03.setOpaque(false);
		*/
		p1.add(gang03); 
		organisationGaenge[0][3] = gang03;
		
		//Festes
		GangPanel gang04 = new GangPanel(730,55,"Bilder/zaubertrank_g.png");
		/*
		String imagePath40 = "Bilder/zaubertrank_g.png";
		generiereGangbilder(gang04, imagePath40);
		gang04.setBounds(730, 55, 90, 95);
		gang04.setOpaque(false);
		*/
		p1.add(gang04); 
		organisationGaenge[0][4] = gang04;
		
		GangPanel gang05 = new GangPanel(820,55,"Bilder/rueckeite_g.png");
		/*
		String imagePath50 = "Bilder/gruen_g.png";
		generiereGangbilder(gang05, imagePath50);
		gang05.setBounds(820, 55, 90, 95);
		gang05.setOpaque(false);
		*/
		p1.add(gang05); 
		organisationGaenge[0][5] = gang05;
		
		//Festes
		GangPanel gang06 = new GangPanel(910,55,"Bilder/gelb_g.png");
		/*
		String imagePath60 = "Bilder/gelb_g.png";
		generiereGangbilder(gang06, imagePath60);
		gang06.setBounds(910, 55, 90, 95);
		gang06.setOpaque(false);
		*/
		p1.add(gang06);
		organisationGaenge[0][6] = gang06;
		
		//Zweite Zeile
		GangPanel gang10 = new GangPanel(370,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath01 = "Bilder/gruen_g.png";
		generiereGangbilder(gang10, imagePath01);
		gang10.setBounds(370, 145, 90, 95);
		gang10.setOpaque(false);
		*/
		p1.add(gang10); 
		organisationGaenge[1][0] = gang10;
		
		GangPanel gang11 = new GangPanel(460,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath11 = "Bilder/gruen_g.png";
		generiereGangbilder(gang11, imagePath11);
		gang11.setBounds(460, 145, 90, 95);
		gang11.setOpaque(false);
		*/
		p1.add(gang11); 
		organisationGaenge[1][1] = gang11;
		
		GangPanel gang12 = new GangPanel(550,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath21 = "Bilder/gruen_g.png";
		generiereGangbilder(gang12, imagePath21);
		gang12.setBounds(550, 145, 90, 95);
		gang12.setOpaque(false);
		*/
		p1.add(gang12); 
		organisationGaenge[1][2] = gang12;
		
		GangPanel gang13 = new GangPanel(640,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath31 = "Bilder/gruen_g.png";
		generiereGangbilder(gang13, imagePath31);
		gang13.setBounds(640, 145, 90, 95);
		gang13.setOpaque(false);
		*/
		p1.add(gang13); 
		organisationGaenge[1][3] = gang13;
		
		GangPanel gang14 = new GangPanel(730,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath41 = "Bilder/gruen_g.png";
		generiereGangbilder(gang14, imagePath41);
		gang14.setBounds(730, 145, 90, 95);
		gang14.setOpaque(false);
		*/
		p1.add(gang14); 
		organisationGaenge[1][4] = gang14;
		
		GangPanel gang15 = new GangPanel(820,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath51 = "Bilder/gruen_g.png";
		generiereGangbilder(gang15, imagePath51);
		gang15.setBounds(820, 145, 90, 95);
		gang15.setOpaque(false);
		*/
		p1.add(gang15); 
		organisationGaenge[1][5] = gang15;
		
		GangPanel gang16 = new GangPanel(910,145,"Bilder/rueckeite_g.png");
		/*
		String imagePath61 = "Bilder/gruen_g.png";
		generiereGangbilder(gang16, imagePath61);
		gang16.setBounds(910, 145, 90, 95);
		gang16.setOpaque(false);
		*/
		p1.add(gang16);
		organisationGaenge[1][6] = gang16;
		
		//Dritte Zeile
		//Festes
		GangPanel gang20 = new GangPanel(370,235,"Bilder/kerzenstaender_g.png");
		/*
		String imagePath02 = "Bilder/kerzenstaender_g.png";
		generiereGangbilder(gang20, imagePath02);
		gang20.setBounds(370, 235, 90, 95);
		gang20.setOpaque(false);
		*/
		p1.add(gang20); 
		organisationGaenge[2][0] = gang20;
		
		GangPanel gang21 = new GangPanel(460,235,"Bilder/rueckeite_g.png");
		/*
		String imagePath12 = "Bilder/gruen_g.png";
		generiereGangbilder(gang21, imagePath12);
		gang21.setBounds(460, 235, 90, 95);
		gang21.setOpaque(false);
		*/
		p1.add(gang21); 
		organisationGaenge[2][1] = gang21;
		
		//Festes
		GangPanel gang22 = new GangPanel(550,235,"Bilder/schatztruhe_g.png");
		/*
		String imagePath22 = "Bilder/schatztruhe_g.png";
		generiereGangbilder(gang22, imagePath22);
		gang22.setBounds(550, 235, 90, 95);
		gang22.setOpaque(false);
		*/
		p1.add(gang22); 
		organisationGaenge[2][2] = gang22;
		
		GangPanel gang23 = new GangPanel(640,235,"Bilder/rueckeite_g.png");
		/*
		String imagePath32 = "Bilder/gruen_g.png";
		generiereGangbilder(gang23, imagePath32);
		gang23.setBounds(640, 235, 90, 95);
		gang23.setOpaque(false);
		*/
		p1.add(gang23); 
		organisationGaenge[2][3] = gang23;
		
		//Festes
		GangPanel gang24 = new GangPanel(730,235,"Bilder/krone_g.png");
		/*
		String imagePath42 = "Bilder/krone_g.png";
		generiereGangbilder(gang24, imagePath42);
		gang24.setBounds(730, 235, 90, 95);
		gang24.setOpaque(false);
		*/
		p1.add(gang24); 
		organisationGaenge[2][4] = gang24;
		
		GangPanel gang25 = new GangPanel(820,235,"Bilder/rueckeite_g.png");
		/*
		JPanel gang25 = new JPanel();
		String imagePath52 = "Bilder/gruen_g.png";
		generiereGangbilder(gang25, imagePath52);
		gang25.setBounds(820, 235, 90, 95);
		gang25.setOpaque(false);
		*/
		p1.add(gang25); 
		organisationGaenge[2][5] = gang25;
		
		//Festes
		GangPanel gang26 = new GangPanel(910,235,"Bilder/buch_g.png");
		/*
		JPanel gang26 = new JPanel();
		String imagePath62 = "Bilder/buch_g.png";
		generiereGangbilder(gang26, imagePath62);
		gang26.setBounds(910, 235, 90, 95);
		gang26.setOpaque(false);
		*/
		p1.add(gang26);
		organisationGaenge[2][6] = gang26;
		
		//Vierte Zeile
		GangPanel gang30 = new GangPanel(370,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang30 = new JPanel();
		String imagePath03 = "Bilder/gruen_g.png";
		generiereGangbilder(gang30, imagePath03);
		gang30.setBounds(370, 325, 90, 95);
		gang30.setOpaque(false);
		*/
		p1.add(gang30); 
		organisationGaenge[3][0] = gang30;
		
		GangPanel gang31 = new GangPanel(460,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang31 = new JPanel();
		String imagePath13 = "Bilder/gruen_g.png";
		generiereGangbilder(gang31, imagePath13);
		gang31.setBounds(460, 325, 90, 95);
		gang31.setOpaque(false);
		*/
		p1.add(gang31); 
		organisationGaenge[3][1] = gang31;
		
		GangPanel gang32 = new GangPanel(550,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang32 = new JPanel();
		String imagePath23 = "Bilder/gruen_g.png";
		generiereGangbilder(gang32, imagePath23);
		gang32.setBounds(550, 325, 90, 95);
		gang32.setOpaque(false);
		*/
		p1.add(gang32); 
		organisationGaenge[3][2] = gang32;
		
		GangPanel gang33 = new GangPanel(640,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang33 = new JPanel();
		String imagePath33 = "Bilder/gruen_g.png";
		generiereGangbilder(gang33, imagePath33);
		gang33.setBounds(640, 325, 90, 95);
		gang33.setOpaque(false);
		*/
		p1.add(gang33); 
		organisationGaenge[3][3] = gang33;
		
		GangPanel gang34 = new GangPanel(730,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang34 = new JPanel();
		String imagePath43 = "Bilder/gruen_g.png";
		generiereGangbilder(gang34, imagePath43);
		gang34.setBounds(730, 325, 90, 95);
		gang34.setOpaque(false);
		*/
		p1.add(gang34); 
		organisationGaenge[3][4] = gang34;
		
		GangPanel gang35 = new GangPanel(820,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang35 = new JPanel();
		String imagePath53 = "Bilder/gruen_g.png";
		generiereGangbilder(gang35, imagePath53);
		gang35.setBounds(820, 325, 90, 95);
		gang35.setOpaque(false);
		*/
		p1.add(gang35); 
		organisationGaenge[3][5] = gang35;
		
		GangPanel gang36 = new GangPanel(910,325,"Bilder/rueckeite_g.png");
		/*
		JPanel gang36 = new JPanel();
		String imagePath63 = "Bilder/gruen_g.png";
		generiereGangbilder(gang36, imagePath63);
		gang36.setBounds(910, 325, 90, 95);
		gang36.setOpaque(false);
		*/
		p1.add(gang36);
		organisationGaenge[3][6] = gang36;
		
		//Fuenfte Zeile
		//Festes
		GangPanel gang40 = new GangPanel(370,415,"Bilder/ritterhelm_g.png");
		/*
		JPanel gang40 = new JPanel();
		String imagePath04 = "Bilder/ritterhelm_g.png";
		generiereGangbilder(gang40, imagePath04);
		gang40.setBounds(370, 415, 90, 95);
		gang40.setOpaque(false);
		*/
		p1.add(gang40); 
		organisationGaenge[4][0] = gang40;
		
		GangPanel gang41 = new GangPanel(460,415,"Bilder/rueckeite_g.png");
		/*
		JPanel gang41 = new JPanel();
		String imagePath14 = "Bilder/gruen_g.png";
		generiereGangbilder(gang41, imagePath14);
		gang41.setBounds(460, 415, 90, 95);
		gang41.setOpaque(false);
		*/
		p1.add(gang41);
		organisationGaenge[4][1] = gang41;
		
		//Festes
		GangPanel gang42 = new GangPanel(550,415,"Bilder/rubin_g.png");
		/*
		JPanel gang42 = new JPanel();
		String imagePath24 = "Bilder/rubin_g.png";
		generiereGangbilder(gang42, imagePath24);
		gang42.setBounds(550, 415, 90, 95);
		gang42.setOpaque(false);
		*/
		p1.add(gang42); 
		organisationGaenge[4][2] = gang42;
		
		GangPanel gang43 = new GangPanel(640,415,"Bilder/rueckeite_g.png");
		/*
		JPanel gang43 = new JPanel();
		String imagePath34 = "Bilder/gruen_g.png";
		generiereGangbilder(gang43, imagePath34);
		gang43.setBounds(640, 415, 90, 95);
		gang43.setOpaque(false);
		*/
		p1.add(gang43); 
		organisationGaenge[4][3] = gang43;
		
		//Festes
		GangPanel gang44 = new GangPanel(730,415,"Bilder/schluessel_g.png");
		/*
		JPanel gang44 = new JPanel();
		String imagePath44 = "Bilder/schluessel_g.png";
		generiereGangbilder(gang44, imagePath44);
		gang44.setBounds(730, 415, 90, 95);
		gang44.setOpaque(false);
		*/
		p1.add(gang44); 
		organisationGaenge[4][4] = gang44;
		
		GangPanel gang45 = new GangPanel(820,415,"Bilder/rueckeite_g.png");
		/*
		JPanel gang45 = new JPanel();
		String imagePath54 = "Bilder/gruen_g.png";
		generiereGangbilder(gang45, imagePath54);
		gang45.setBounds(820, 415, 90, 95);
		gang45.setOpaque(false);
		*/
		p1.add(gang45); 
		organisationGaenge[4][5] = gang45;
		
		//Festes
		GangPanel gang46 = new GangPanel(910,415,"Bilder/muenzbeutel_g.png");
		/*
		JPanel gang46 = new JPanel();
		String imagePath64 = "Bilder/muenzbeutel_g.png";
		generiereGangbilder(gang46, imagePath64);
		gang46.setBounds(910, 415, 90, 95);
		gang46.setOpaque(false);
		*/
		p1.add(gang46);
		organisationGaenge[4][6] = gang46;
		
		//Sechste Zeile
		GangPanel gang50 = new GangPanel(370,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang50 = new JPanel();
		String imagePath05 = "Bilder/gruen_g.png";
		generiereGangbilder(gang50, imagePath05);
		gang50.setBounds(370, 505, 90, 95);
		gang50.setOpaque(false);
		*/
		p1.add(gang50); 
		organisationGaenge[5][0] = gang50;
		
		GangPanel gang51 = new GangPanel(460,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang51 = new JPanel();
		String imagePath15 = "Bilder/gruen_g.png";
		generiereGangbilder(gang51, imagePath15);
		gang51.setBounds(460, 505, 90, 95);
		gang51.setOpaque(false);
		*/
		p1.add(gang51); 
		organisationGaenge[5][1] = gang51;
		
		GangPanel gang52 = new GangPanel(550,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang52 = new JPanel();
		String imagePath25 = "Bilder/gruen_g.png";
		generiereGangbilder(gang52, imagePath25);
		gang52.setBounds(550, 505, 90, 95);
		gang52.setOpaque(false);
		*/
		p1.add(gang52); 
		organisationGaenge[5][2] = gang52;
		
		GangPanel gang53 = new GangPanel(640,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang53 = new JPanel();
		String imagePath35 = "Bilder/gruen_g.png";
		generiereGangbilder(gang53, imagePath35);
		gang53.setBounds(640, 505, 90, 95);
		gang53.setOpaque(false);
		*/
		p1.add(gang53);
		organisationGaenge[5][3] = gang53;
		
		GangPanel gang54 = new GangPanel(730,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang54 = new JPanel();
		String imagePath45 = "Bilder/gruen_g.png";
		generiereGangbilder(gang54, imagePath45);
		gang54.setBounds(730, 505, 90, 95);
		gang54.setOpaque(false);
		*/
		p1.add(gang54); 
		organisationGaenge[5][4] = gang54;
		
		GangPanel gang55 = new GangPanel(820,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang55 = new JPanel();
		String imagePath55 = "Bilder/gruen_g.png";
		generiereGangbilder(gang55, imagePath55);
		gang55.setBounds(820, 505, 90, 95);
		gang55.setOpaque(false);
		*/
		p1.add(gang55); 
		organisationGaenge[5][5] = gang55;
		
		GangPanel gang56 = new GangPanel(910,505,"Bilder/rueckeite_g.png");
		/*
		JPanel gang56 = new JPanel();
		String imagePath65 = "Bilder/gruen_g.png";
		generiereGangbilder(gang56, imagePath65);
		gang56.setBounds(910, 505, 90, 95);
		gang56.setOpaque(false);
		*/
		p1.add(gang56);
		organisationGaenge[5][6] = gang56;
		
		//Siebte Zeile
		//Festes
		GangPanel gang60 = new GangPanel(370,595,"Bilder/blau_g.png");
		/*
		JPanel gang60 = new JPanel();
		String imagePath06 = "Bilder/blau_g.png";
		generiereGangbilder(gang60, imagePath06);
		gang60.setBounds(370, 595, 90, 95);
		gang60.setOpaque(false);
		*/
		p1.add(gang60);
		organisationGaenge[6][0] = gang60;
		
		GangPanel gang61 = new GangPanel(460,595,"Bilder/rueckeite_g.png");
		/*
		JPanel gang61 = new JPanel();
		String imagePath16 = "Bilder/gruen_g.png";
		generiereGangbilder(gang61, imagePath16);
		gang61.setBounds(460, 595, 90, 95);
		gang61.setOpaque(false);
		*/
		p1.add(gang61); 
		organisationGaenge[6][1] = gang61;
		
		//Festes
		GangPanel gang62 = new GangPanel(550,595,"Bilder/dolch_g.png");
		/*
		JPanel gang62 = new JPanel();
		String imagePath26 = "Bilder/dolch_g.png";
		generiereGangbilder(gang62, imagePath26);
		gang62.setBounds(550, 595, 90, 95);
		gang62.setOpaque(false);
		*/
		p1.add(gang62); 
		organisationGaenge[6][2] = gang62;
		
		GangPanel gang63 = new GangPanel(640,595,"Bilder/rueckeite_g.png");
		/*
		JPanel gang63 = new JPanel();
		String imagePath36 = "Bilder/gruen_g.png";
		generiereGangbilder(gang63, imagePath36);
		gang63.setBounds(640, 595, 90, 95);
		gang63.setOpaque(false);
		*/
		p1.add(gang63); 
		organisationGaenge[6][3] = gang63;
		
		//Festes
		GangPanel gang64 = new GangPanel(730,595,"Bilder/kelch_g.png");
		/*
		JPanel gang64 = new JPanel();
		String imagePath46 = "Bilder/kelch_g.png";
		generiereGangbilder(gang64, imagePath46);
		gang64.setBounds(730, 595, 90, 95);
		gang64.setOpaque(false);
		*/
		p1.add(gang64); 
		organisationGaenge[6][4] = gang64;
		
		GangPanel gang65 = new GangPanel(820,595,"Bilder/rueckeite_g.png");
		/*
		JPanel gang65 = new JPanel();
		String imagePath56 = "Bilder/gruen_g.png";
		generiereGangbilder(gang65, imagePath56);
		gang65.setBounds(820, 595, 90, 95);
		gang65.setOpaque(false);
		*/
		p1.add(gang65); 
		organisationGaenge[6][5] = gang65;
		
		//Festes
		GangPanel gang66 = new GangPanel(910,595,"Bilder/rot_g.png");
		/*
		JPanel gang66 = new JPanel();
		String imagePath66 = "Bilder/rot_g.png";
		generiereGangbilder(gang66, imagePath66);
		gang66.setBounds(910, 595, 90, 95);
		gang66.setOpaque(false);
		*/
		p1.add(gang66);
		organisationGaenge[6][6] = gang66;
		
		//EinschiebeGang
		this.ganguebrigpanel = new GangUebrigPanel();
		p1.add(ganguebrigpanel);	
		ganguebrigpanel.getLinksdrehung().addActionListener(e -> linksDrehung());
		ganguebrigpanel.getRechtsdrehung().addActionListener(e -> rechtsDrehung());
		
		//JoystickPanel
		this.joystickPanel = new JoystickPanel();
		
		joystickPanel.getFertig().addActionListener(e -> {System.exit(0);});
		joystickPanel.getOben().addActionListener(e -> aktuelleSpielerbewegung("oben"));
		joystickPanel.getUnten().addActionListener(e -> aktuelleSpielerbewegung("unten"));
		joystickPanel.getRechts().addActionListener(e -> aktuelleSpielerbewegung("rechts"));
		joystickPanel.getLinks().addActionListener(e -> aktuelleSpielerbewegung("links"));
		p1.add(joystickPanel);
		
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
		//neu
        p1.add(aktuelleKarte);
        aktuelleKarte.addMouseListener(new MouseHandler());
        
        
        this.drachenBild = new DekoBild(50, 645, 430, 341, "Bilder/DracheMitSchatz.png");
		p1.add(drachenBild);
		
        
        /*
        aktuelleKarte.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {

                Spieler aktuellerSpielerAmZug = daten.getSpielerliste().get(0);
                System.out.println("mouse entered!");
                String gesuchterSchatzName = aktuellerSpielerAmZug.getKartenblatt().get(0).getSchatz();
                String URI = "Bilder/" + gesuchterSchatzName + "_k.png";

                System.out.println(URI);

                aktuelleKarte.bildaendern(URI);
                repaint();
            } 

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouse exited!");
                //aktuelleSchatzkarte.bildaendern("Bilder/rueckseite2_k.png");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            
        });
		*/
		
		//Joysticks Panel
		
	
		
		// Menue
		menueLeiste = new JMenuBar();
		spielMenue = new JMenu("Spiel");
		neuesSpiel = new JMenuItem("Neues Spiel");
		hilfe = new JMenuItem("Hilfe");
		beenden = new JMenuItem("Beenden");
		
		//ActionListener
		neuesSpiel.addActionListener(e -> {System.exit(0);});
		hilfe.addActionListener(e -> hilfe());
		beenden.addActionListener(e -> {beenden();});
		
		//Menueleiste Zuordnung
		menueLeiste.add(spielMenue);
		spielMenue.add(neuesSpiel);
		spielMenue.add(hilfe);
		spielMenue.add(beenden);
		
		//Hintergrund Spielfeld Blau
		spielfeldHintergrund = new JPanel();
		spielfeldHintergrund.setBackground(Color.decode("#2a4071"));
		//spielfeldHintergrund.setBounds(450, 10, 600, 605);
		spielfeldHintergrund.setBounds(342, 27, 686, 691);
		p1.add(spielfeldHintergrund);
		
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
	
private class Anleitung extends JDialog{			//NEU
		
		private JPanel fenster;
		private JScrollPane scrollPane;
		private JLabel ueberschrift;
		private JLabel text;
		private GridBagLayout gbl;
		private GridBagConstraints gbc;
		
		Anleitung(){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setTitle("Anleitung"); 
			
			this.setSize(700, 500);
			this.setLocation(600, 250);
			fenster = new JPanel();
			fenster.setBackground(Color.decode("#ffc04f"));
			this.add(fenster);
			scrollPane = new JScrollPane(fenster);
			add(scrollPane);
			gbl = new GridBagLayout();
			fenster.setLayout(gbl);
						
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(10,10,10,10);
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			String imagePath = "Bilder/eule.png";
			try {
				BufferedImage logo = ImageIO.read(new File(imagePath));
				JLabel picLabel = new JLabel(new ImageIcon(logo));
				//picLabel.setBounds(100, 20, 173, 200);
				gbl.setConstraints(picLabel, gbc);
				fenster.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			this.gbc.gridx = 1;
			this.gbc.gridy = 0;
			this.gbc.gridwidth = 1;
			this.gbc.gridheight = 1;
			gbc.insets = new Insets(50,5,5,5);
			ueberschrift = new JLabel ("Wie spielt man?");
			ueberschrift.setBounds(350, 20, 200, 30);
			ueberschrift.setFont(ueberschrift.getFont().deriveFont((float) 22));
			gbl.setConstraints(ueberschrift, gbc);
			ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
			fenster.add(ueberschrift);
			
			this.gbc.gridx = 0;
			this.gbc.gridy = 1;
			this.gbc.gridwidth = 2;
			this.gbc.gridheight = 1;
			gbc.insets = new Insets(20,5,5,5);
			text = new JLabel ();
			text.setBounds(350, 40, 400, 200);
			text.setSize(300, 500);
			text.setFont(text.getFont().deriveFont((float) 15));
			text.setText("<html><body><p style=\\\"width:300px\\\">"
					+ "ZIEL<br>"
					+ "  In einem verwunschenen Irrgarten geht ihr auf die"
					+ "  Suche nach geheimnisvollen Gegenständen und"
					+ "  Lebewesen. Jeder versucht sich durch geschicktes"
					+ "  Verschieben der Gänge den Weg freizumachen und zu"
					+ "  seinem gesuchten Schatz zu ziehen. Es gewinnt,"
					+ "  wer als Erster alle seine Schätze findet und seine"
					+ "  Spielfigur wieder zu ihrem Startfeld zurückbringt.<br><br>"
					+ "VORBEREITUNG<br>"
					+ "  Die 34 Gängekarten werden gemischt und offen auf"
					+ "  die freien Felder des Spielplans gelegt, sodass ein"
					+ "  zufälliges Labyrinth entsteht.<br>"
					+ "  Eine Gängekarte bleibt übrig. Sie wird zum Verschieben"
					+ "  der Labyrinthgänge benutzt. Auch die 24 Schatzkarten"
					+ "  werden gemischt und gleichmäßig an alle Spieler verteilt."
					+ "  Eure Schatzkarten liegen als verdeckter Stapel vor euch."
					+ "  Ihr könnt euch die oberste Karte ansehen, indem ihr mit"
					+ "  der Maus drüber geht, wenn ihr an der Reihe seid.<br>"
					+ "  Jetzt kann’s losgehen!<br><br>"
					+ "ABLAUF<br>"
					+ "  Spieler 1 beginnt. Er schaut sich nun geheim "
					+ "  die oberste Schatzkarte seines Stapels an. Sie "
					+ "  zeigt den Schatz, den er als Erstes finden muss. <br>"
					+ "  Ein Zug besteht immer aus zwei Schritten:<br>"
					+ "  	1. Gänge verschieben<br>"
					+ "	    2. Spielfigur ziehen<br>"
					+ "  Wenn du an der Reihe bist, versuchst du auf das Feld im"
					+ "  Labyrinth zu gelangen, das denselben Schatz wie deine"
					+ "  aktuelle Schatzkarte zeigt. Dazu verschiebst du immer"
					+ "  zuerst eine Reihe der Gängekarten im Labyrinth und"
					+ "  ziehst danach deine Figur.<br><br>"
					+ "  1. Gänge verschieben<br>"
					+ "  Am Spielplanrand befinden sich 12 Pfeile. Sie markieren"
					+ "  die Reihen, in welche die freie Gängekarte eingeschoben"
					+ "  werden kann.<br>"
					+ "  Bist du am Zug, entscheidest du dich für eine Reihe und"
					+ "  schiebst die Gängekarte ein, indem du auf den Pfeil klickst. "
					+ "  Auf der gegenüberliegenden Seite wird wieder genau eine "
					+ "  Gängekarte herausgeschoben.<br>"
					+ "  Einzige Einschränkung: Die Gängekarte darf nicht an die"
					+ "  Stelle zurückgeschoben werden, aus der sie im vorherigen"
					+ "  Zug herausgeschoben wurde.<br>"
					+ "  Wird beim Verschieben die eigene oder eine fremde"
					+ "  Spielfigur aus dem Labyrinth herausgeschoben?<br>"
					+ "  Dann wird sie sofort auf der gegenüberliegenden Seite"
					+ "  auf die neu eingeschobene Gängekarte gestellt. Dieses"
					+ "  Versetzen gilt nicht als Zug!<br>"
					+ "  Achtung: Die freie Gängekarte muss in jedem Fall"
					+ "  eingeschoben werden. Das gilt auch, wenn der Schatz"
					+ "  ohne Verschieben der Gänge erreichbar wäre.<br><br>"
					+ "  2. Spielfigur ziehen<br>"
					+ "  Nach dem Verschieben darfst du mit deiner Spielfigur"
					+ "  auf jedes Feld ziehen, das du durch einen ununterbrochenen"
					+ "  Gang im Labyrinth erreichen kannst. Jedoch darf dort"
					+ "  bereits keine andere Spielfigur stehen. Du"
					+ "  darfst soweit ziehen, wie du möchtest und dabei auch"
					+ "  an anderen Spielfiguren vorbeiziehen. Du kannst auch"
					+ "  stehen bleiben.<br>"
					+ "  Beendest du deinen Zug auf dem gesuchten Schatz, hast"
					+ "  du ihn gefunden. Die Anzahl der noch übrigen Schatzkarten"
					+ "  verringert sich und du kannst dir deine neue Schatzkarte ansehen.<br>"
					+ "  Tipp: Du kannst dein Ziel in deinem Zug nicht erreichen?"
					+ "  Dann solltest du versuchen, dir eine möglichst gute"
					+ "  Ausgangsposition für deinen nächsten Zug zu verschaffen."
					+ "  Nun geht mit dem nächsten Spieler weiter: Erst die freie"
					+ "  Gängekarte einschieben, dann die Spielfigur ziehen usw.<br><br>"
					+ "SPIELENDE<br>"
					+ "  Du hast alle deine Schätze gefunden? Nun musst du nur"
					+ "  noch zurück zu deinem Startfeld.<br>"
					+ "  Schaffst du es als Erster zurück zu deinem Startfeld,"
					+ "  endet das Spiel sofort und du hast gewonnen!"
					+ "</p></body></html>");
			gbl.setConstraints(text, gbc);
			fenster.add(text);
		}
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
	
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			String gesuchterSchatzName = daten.getAktuellerSpieler().getKartenblatt().get(0).getSchatz();
			//Spieler aktuellerSpielerAmZug = daten.getSpielerliste().get(0);
            System.out.println("mouse entered!");
            //String gesuchterSchatzName = aktuellerSpielerAmZug.getKartenblatt().get(0).getSchatz();
            String URI = "Bilder/" + gesuchterSchatzName + "_k.png";

            System.out.println(URI);

            aktuelleKarte.bildaendern(URI);
            validate();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			aktuelleKarte.bildaendern("Bilder/rueckseite2_k.png");
			validate();
		}
		
	}
	
	private void willkommenSchliessen() {
		this.willkommen.setVisible(false);
		spielGenerieren();
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
	
	private void spielGenerieren() {
		spielUebersichtGenerieren();
		daten.setKartendeck(Karte.erstelleKartenDeck()); 
		Karte.shuffleKartenDeck(daten.getKartendeck());
		daten.schatzkartenAusteilen(daten.getKartendeck());
		daten.setAktuellerSpieler(daten.getSpielerliste().get(0));
		spielfeldVorbereiten();
		aktualisiereGanguebrig();
		daten.setAktuellerSpieler(daten.getSpielerliste().get(0));
		aktualisiereButtons();
		
		System.out.println(daten.getSpielerliste());
		System.out.println("oben " + daten.getSpielfeld().getMatrix()[5][6].nordausgang);
		System.out.println("oben " + daten.getSpielfeld().getMatrix()[5][6].ostausgang);
		System.out.println("oben " + daten.getSpielfeld().getMatrix()[5][6].suedausgang);
		System.out.println("oben " + daten.getSpielfeld().getMatrix()[5][6].westausgang);
		System.out.println("oben " + daten.getSpielfeld().getMatrix()[5][6].drehung);
		System.out.println("links " + daten.getSpielfeld().getMatrix()[6][5].nordausgang);
		System.out.println("links " + daten.getSpielfeld().getMatrix()[6][5].ostausgang);
		System.out.println("links " + daten.getSpielfeld().getMatrix()[6][5].suedausgang);
		System.out.println("links " + daten.getSpielfeld().getMatrix()[6][5].westausgang);
		System.out.println("links " + daten.getSpielfeld().getMatrix()[6][5].drehung);
	}
	
	
	public void spielfigurenSetzen() {
		
		for(int i = 0; i < daten.getSpielerliste().size(); i++) {
			
			switch(daten.getSpielerliste().get(i).getFarbe()) {
			
			case "Rot": 
				spielfigurRot.setBounds(925, 583, 55, 70);
				spielfigurRot.bildaendern("Bilder/spielfigur_rot.png");
				break;
			case "Gruen":
				spielfigurGruen.setBounds(389, 43, 55, 70);
				spielfigurGruen.bildaendern("Bilder/spielfigur_gruen.png");
				break;
			case "Blau":
				spielfigurBlau.setBounds(389, 583, 55, 70);
				spielfigurBlau.bildaendern("Bilder/spielfigur_blau.png");
				break;
			case "Gelb":
				spielfigurGelb.setBounds(925, 43, 55, 70);
				spielfigurGelb.bildaendern("Bilder/spielfigur_gelb.png");
				break;
			default: 
				break;
			}
		}	
	}
	
	public void positionAendern() {
		
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
	
	public void aktualisiereButtons() {
		//vier mal
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
	
	private void aktuelleSpielerbewegung(String richtung) {
		daten.schrittMachen(richtung);
		spielerBewegungGrafisch();
		/*int eingabeX = daten.getAktuellerSpieler().getPositionX();
		int eingabeY = daten.getAktuellerSpieler().getPositionY();
		String farbe = daten.getAktuellerSpieler().getFarbe();
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
		aktualisiereButtons();*/
	}
	
	private void spielerBewegungGrafisch() {
		int eingabeX = daten.getAktuellerSpieler().getPositionX();
		int eingabeY = daten.getAktuellerSpieler().getPositionY();
		String farbe = daten.getAktuellerSpieler().getFarbe();
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
	
	private void schiebenMitSpieler(String richtung, int eingabeStelle) {
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
		List<String> info = daten.SpielerMitGangVerschieben(richtung, eingabeStelle);
		
		for(int i = 0; i < info.size(); i++) {
			spielerBewegungGrafisch();
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
	
	//Spielfeld
	private void generiereGangbilder(JPanel gangpanel, String gangpath) {
		try {
			BufferedImage logo = ImageIO.read(new File(gangpath));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			//p1.add(gangpanel);
			gangpanel.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dreieckButtonEigenschaften(JButton dreieck, int x, int y, int breite, int hoehe) {
		dreieck.setBounds(x, y, breite, hoehe);
		dreieck.setBorderPainted(false);
		dreieck.setContentAreaFilled(false);
		dreieck.setFocusPainted(false);
		dreieck.setOpaque(false);
		p1.add(dreieck);
	}
	
	/*
	public void pfadKarteBestimmen() {
		
		String gesuchterSchatzName = daten.getSpielerliste().get(0).getKartenblatt().get(0).getSchatz();
		String URI = "Bilder/" + gesuchterSchatzName + "_k.png";
		stringuebergabe(URI);
		
	}
	*/
	
	private void hilfe() {								//NEU
		anleitung = new Anleitung();
		anleitung.setVisible(true);
		anleitung.setAlwaysOnTop(true);
	}
	
	private void beenden() {
		System.exit(0);		
	}
	/*

	@Override
	public void mouseClicked(MouseEvent e) {
        
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Spieler aktuellerSpielerAmZug = daten.getSpielerliste().get(0);
        System.out.println("mouse entered!");
        String gesuchterSchatzName = aktuellerSpielerAmZug.getKartenblatt().get(0).getSchatz();
        String URI = "Bilder/" + gesuchterSchatzName + "_k.png";

        System.out.println(URI);

        aktuelleKarte.bildaendern(URI);
        
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	*/
	
}
