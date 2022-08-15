package labyrinth;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Spielanleitung extends JDialog {
	
		private HintergrundPanel fenster;
		private JScrollPane scrollPane;
		private JLabel ueberschrift;
		private JLabel text;
		private GridBagLayout gbl;
		private GridBagConstraints gbc;
		
		Spielanleitung(){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setTitle("Anleitung"); 
			this.setVisible(true);
			this.setAlwaysOnTop(true);
			
			this.setSize(700, 500);
			this.setLocation(600, 250);
			fenster = new HintergrundPanel("#9cd2ff", "#bce1ff");
			fenster.setOpaque(true);
			this.add(fenster);
			scrollPane = new JScrollPane(fenster);
			scrollPane.getVerticalScrollBar().setUnitIncrement(16);
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
			text.setOpaque(false);
			text.setBounds(350, 40, 400, 200);
			text.setSize(300, 500);
			text.setFont(text.getFont().deriveFont((float) 15));
			text.setText("<html><body><p style=\\\"width:300px\\\">"
					+ "ZIEL<br>"
					+ "  In einem verwunschenen Irrgarten geht ihr auf die"
					+ "  Suche nach geheimnisvollen Gegenstaenden und"
					+ "  Lebewesen. Jeder versucht sich durch geschicktes"
					+ "  Verschieben der Gaenge den Weg freizumachen und zu"
					+ "  seinem gesuchten Schatz zu ziehen. Es gewinnt,"
					+ "  wer als Erster alle seine Schaetze findet und seine"
					+ "  Spielfigur wieder zu ihrem Startfeld zurueckbringt.<br><br><br>"
					+ "VORBEREITUNG<br>"
					+ "  Die 34 Gaengekarten werden gemischt und offen auf"
					+ "  die freien Felder des Spielfelds gelegt, sodass ein"
					+ "  zufaelliges Labyrinth entsteht.<br>"
					+ "  Eine Gaengekarte bleibt uebrig. Sie wird zum Verschieben"
					+ "  der Labyrinthgaenge benutzt. Auch die 24 Schatzkarten"
					+ "  werden gemischt und gleichmaessig an alle Spieler verteilt."
					+ "  Eure Schatzkarten liegen als verdeckter Stapel vor euch."
					+ "  Ihr koennt euch die oberste Karte ansehen, indem ihr mit"
					+ "  der Maus ueber die Karte unten geht, wenn ihr an der Reihe seid.<br>"
					+ "  Jetzt kann es losgehen!<br><br><br>"
					+ "ABLAUF<br>"
					+ "  Spieler 1 beginnt. Er schaut sich nun geheim "
					+ "  die oberste Schatzkarte seines Stapels an. Sie "
					+ "  zeigt den Schatz, den er als Erstes finden muss. <br>"
					+ "  Ein Zug besteht immer aus zwei Schritten:<br><br>"
					+ "  	1. Gaenge verschieben<br>"
					+ "	    2. Spielfigur ziehen<br><br>"
					+ "  Wenn du an der Reihe bist, versuchst du auf das Feld im"
					+ "  Labyrinth zu gelangen, das denselben Schatz wie deine"
					+ "  aktuelle Schatzkarte zeigt. Dazu verschiebst du immer"
					+ "  zuerst eine Reihe der Gaengekarten im Labyrinth und"
					+ "  ziehst danach deine Figur.<br><br>"
					+ "  1. Gaenge verschieben<br>"
					+ "  Am Spielfeldrand befinden sich 12 Pfeile. Sie markieren"
					+ "  die Reihen, in welche die freie Gaengekarte eingeschoben"
					+ "  werden kann.<br>"
					+ "  Bist du am Zug, entscheidest du dich fuer eine Reihe und"
					+ "  schiebst die Gaengekarte ein, indem du auf den Pfeil klickst. "
					+ "  Auf der gegenueberliegenden Seite wird wieder genau eine "
					+ "  Gaengekarte herausgeschoben.<br>"
					+ "  Einzige Einschraenkung: Die Gaengekarte darf nicht an die"
					+ "  Stelle zurueckgeschoben werden, aus der sie im vorherigen"
					+ "  Zug herausgeschoben wurde.<br>"
					+ "  Wird beim Verschieben die eigene oder eine fremde"
					+ "  Spielfigur aus dem Labyrinth herausgeschoben?<br>"
					+ "  Dann wird sie sofort auf der gegenueberliegenden Seite"
					+ "  auf die neu eingeschobene Gaengekarte gestellt.<br><br>"
					+ "  Achtung: Die freie Gaengekarte muss in jedem Fall"
					+ "  eingeschoben werden. Das gilt auch, wenn der Schatz"
					+ "  ohne Verschieben der Gaenge erreichbar waere.<br><br>"
					+ "  2. Spielfigur ziehen<br>"
					+ "  Nach dem Verschieben darfst du mit deiner Spielfigur"
					+ "  auf jedes Feld ziehen, das du durch einen ununterbrochenen"
					+ "  Gang im Labyrinth erreichen kannst. Du darfst soweit ziehen, "
					+ "  wie du moechtest und dabei auch an anderen Spielfiguren vorbeiziehen. "
					+ "  Du kannst aber auch stehen bleiben.<br>"
					+ "  Beendest du deinen Zug auf dem gesuchten Schatz, hast"
					+ "  du ihn gefunden. Die Anzahl der noch uebrigen Schatzkarten"
					+ "  verringert sich und du kannst dir deine neue Schatzkarte ansehen.<br><br>"
					+ "  Tipp: Du kannst dein Ziel in deinem Zug nicht erreichen?"
					+ "  Dann solltest du versuchen, dir eine moeglichst gute"
					+ "  Ausgangsposition fuer deinen naechsten Zug zu verschaffen.<br><br>"
					+ "  Nun geht mit dem naechsten Spieler weiter: Erst die freie"
					+ "  Gaengekarte einschieben, dann die Spielfigur ziehen usw.<br><br><br>"
					+ "SPIELENDE<br>"
					+ "  Du hast alle deine Schaetze gefunden? Nun musst du nur"
					+ "  noch zurueck zu deinem Startfeld.<br>"
					+ "  Schaffst du es als Erster zurueck zu deinem Startfeld,"
					+ "  endet das Spiel sofort und du hast gewonnen!<br><br><br>"
					+ "</p></body></html>");
			gbl.setConstraints(text, gbc);
			
			fenster.add(text);
		}
	}
