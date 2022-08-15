package labyrinth;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Willkommen extends JDialog {

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
	private HintergrundPanel hintergrundPanel;
	
	private GridBagConstraints gbc;
	private GridBagConstraints gbcZwei;
	
	private LabyrinthDaten daten;
	private LabyrinthGUI gui;
	
	Willkommen(LabyrinthDaten eingabeDaten, LabyrinthGUI guiEingabe){
		
		this.daten = eingabeDaten;
		this.gui = guiEingabe;
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Das Verrueckte LabyrINTh");

		this.setSize(450, 340);
		this.setLocation(668, 300);
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		Font font = new Font("Arial", Font.BOLD,15);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5,5,5,5);
		
		gbcEigenschaftenSetzen(0,0,3,1);
		String imagePath = "Bilder/Labyrinth_Logo.png";
		try {
			BufferedImage logo = ImageIO.read(new File(imagePath));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			bildpanel = new JPanel();
			bildpanel.setOpaque(false);
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
		spielerAnzahl.setFont(font);
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
		
		this.getContentPane().setBackground(Color.decode("#6aaadd"));

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
		
		spielerEigenschaftenSetzen(1);
	}
	
	private void spielerEigenschaftenSetzen(int spielerNummer) {
		
		gbcZwei = new GridBagConstraints();
		gbcZwei.fill = GridBagConstraints.HORIZONTAL;
		gbcZwei.insets = new Insets(5,5,5,5);
		Font font = new Font("Arial", Font.BOLD,15);
		
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
		gbcZwei.insets = new Insets(0,29,5,5);
		spielerNamelabel = new JLabel ("Wie heisst Spieler " + spielerNummer + "?");
		spielerNamelabel.setFont(font);
		gbl.setConstraints(spielerNamelabel, gbcZwei);
		this.add(spielerNamelabel);
		
		gbcZwei.gridx = 2;
		gbcZwei.gridy = 1;
		gbcZwei.gridwidth = 2;
		gbcZwei.gridheight = 1;
		gbcZwei.insets = new Insets(0,100,5,14);
		spielerFarbe = new JLabel ("Farbe:");
		spielerFarbe.setFont(font);
		gbl.setConstraints(spielerFarbe, gbcZwei);
		this.add(spielerFarbe);
		
		gbcZwei.gridx = 0;
		gbcZwei.gridy = 2;
		gbcZwei.gridwidth = 2;
		gbcZwei.gridheight = 1;
		gbcZwei.ipady= 3;
		gbcZwei.insets = new Insets(5,29,15,5);
		spielerNametext = new JTextArea();
		final int MAX_LENGTH = 15;
        spielerNametext.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || spielerNametext.getText().length() >= MAX_LENGTH) {
                    return;
                }

                super.insertString(offs, str, a);
            }
        });
		spielerNametext.setCaretPosition(0);
		spielerNametext.getCaret().setVisible(true);
		spielerNametext.setFont(spielerNametext.getFont().deriveFont((float) 15));
		gbl.setConstraints(spielerNametext, gbcZwei);
		this.add(spielerNametext);
		
		gbcZwei.gridx = 2;
		gbcZwei.gridy = 2;
		gbcZwei.gridwidth = 2;
		gbcZwei.gridheight = 1;
		gbcZwei.ipady= 0;
		gbcZwei.insets = new Insets(5,100,15,29);
		spielerFarbeAuswahl = new JComboBox<String>(farben);
		gbl.setConstraints(spielerFarbeAuswahl, gbcZwei);
		this.add(spielerFarbeAuswahl);
		
		gbcZwei.gridx = 3;
		gbcZwei.gridy = 3;
		gbcZwei.gridwidth = 1;
		gbcZwei.gridheight = 1;
		gbcZwei.ipady= -1;
		gbcZwei.insets = new Insets(0,130,15,29);
		fertig = new JButton("Fertig");
		fertig.addActionListener(e -> spielerEigenschaftenSpeichern(spielerNummer));
		gbl.setConstraints(fertig, gbcZwei);
		this.add(fertig);	
		
		pack();
	
		this.setSize(450, 350);
		this.setLocation(668, 300);
	}
	
	private void spielerEigenschaftenSpeichern(int spielerNummer) {
		
		String name = spielerNametext.getText();
		int indexFarbe = spielerFarbeAuswahl.getSelectedIndex();
		String farbe = spielerFarbeAuswahl.getItemAt(indexFarbe);
		daten.getSpielerliste().add(new Spieler(name, farbe, spielerNummer));

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
			
			spielerEigenschaftenSetzen(spielerNummer + 1);
		} else {
			gui.willkommenSchliessen();
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
	
