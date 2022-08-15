package labyrinth;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gewonnen extends JDialog{

	private JPanel ergebnissePanel;
	private DekoBild banderole;
	private JLabel ersterPlatz;
	private JLabel zweiterPlatz;
	private JLabel dritterPlatz;
	private JLabel vierterPlatz;
	private JLabel hatgewonnen;
	private DekoBild siegerfigur;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	private JPanel platzierungen;
	private static final long serialVersionUID = 4934581066663011381L;
	
	public Gewonnen(List<Spieler> spielerListe) {
				
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("SPIEL VORBEI"); 
		this.setResizable(false);
		this.setSize(800, 800);
		this.setLocation(530, 200);
		
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		//Bubblesort
		boolean warSortiert = true;
		do {
			warSortiert = true;
			
			for(int i = 0; i < spielerListe.size() - 1; i++) {
				
				if(spielerListe.get(i).getKartenblatt().size() > spielerListe.get(i+1).getKartenblatt().size()) {
				
					//if (i > spielerListe.size()) {
				Spieler zwischenspeicher = spielerListe.get(i);
				spielerListe.set(i, spielerListe.get(i+1));
				spielerListe.set(i + 1, zwischenspeicher);
				warSortiert = false;
				}
			}
		}while(!warSortiert);
		
		String imagePathErster = "Bilder/figurspieler_" + spielerListe.get(0).getFarbe() + "_gewinner.png";		
		
		ergebnissePanel = new JPanel();
		ergebnissePanel.setLayout(layout);
		ergebnissePanel.setSize(800,800);
		ergebnissePanel.setBackground(Color.decode("#ffc04f"));
		this.add(ergebnissePanel);		
		
		gbcEigenschaftenSetzen(0, 0, 1, 1);
		gbc.insets = new Insets(225,5,0,5);
		ersterPlatz = new JLabel(spielerListe.get(1).getName(),SwingConstants.CENTER);
		ersterPlatz.setSize(120, 30);
		ersterPlatz.setFont(ersterPlatz.getFont().deriveFont((float) 30));
		layout.setConstraints(ersterPlatz, gbc);
		ergebnissePanel.add(ersterPlatz);
		
		gbcEigenschaftenSetzen(0, 1, 1, 1);
		gbc.insets = new Insets(0,5,225,5);
		hatgewonnen = new JLabel("HAT GEWONNEN",SwingConstants.CENTER);
		hatgewonnen.setSize(120, 200);
		hatgewonnen.setFont(hatgewonnen.getFont().deriveFont((float) 30));
		layout.setConstraints(hatgewonnen, gbc);
		ergebnissePanel.add(hatgewonnen);
		
		gbcEigenschaftenSetzen(0, 1, 1, 1);
		gbc.insets = new Insets(10,5,5,5);
		siegerfigur = new DekoBild(36 , 70, imagePathErster);
		siegerfigur.setOpaque(false);
		layout.setConstraints(siegerfigur, gbc);
		ergebnissePanel.add(siegerfigur);
			
		gbcEigenschaftenSetzen(0, 2, 1, 1);
		gbc.insets = new Insets(0,5,50,5);
		platzierungen = new JPanel();
		platzierungen.setLayout(new BorderLayout());
		platzierungen.setOpaque(false);
		platzierungen.setSize(120, 200);
		layout.setConstraints(platzierungen, gbc);
		ergebnissePanel.add(platzierungen);
		
		zweiterPlatz = new JLabel("Platz 2: " + spielerListe.get(1).getName(),SwingConstants.CENTER);
		zweiterPlatz.setSize(120, 25);	
		zweiterPlatz.setBorder(BorderFactory.createEmptyBorder(0, 0, 22, 0));
		zweiterPlatz.setFont(zweiterPlatz.getFont().deriveFont((float) 22));
		platzierungen.add(zweiterPlatz,BorderLayout.NORTH);
		
		dritterPlatz = new JLabel("Platz 3: ",SwingConstants.CENTER);
		dritterPlatz.setSize(120, 25);
		dritterPlatz.setBorder(BorderFactory.createEmptyBorder(0, 0,22, 0));
		dritterPlatz.setFont(dritterPlatz.getFont().deriveFont((float) 22));
		dritterPlatz.setForeground(Color.decode("#ffc04f"));
		platzierungen.add(dritterPlatz,BorderLayout.CENTER);
		
		if(spielerListe.size() > 2) {
			dritterPlatz.setText("Platz 3: " + spielerListe.get(2).getName());
			dritterPlatz.setForeground(Color.BLACK);
		}
		
		vierterPlatz = new JLabel("Platz 4: ",SwingConstants.CENTER);
		vierterPlatz.setSize(120, 25);
		vierterPlatz.setFont(vierterPlatz.getFont().deriveFont((float) 22));
		vierterPlatz.setBorder(BorderFactory.createEmptyBorder(0, 0, 22 , 0));
		vierterPlatz.setForeground(Color.decode("#ffc04f"));
		platzierungen.add(vierterPlatz,BorderLayout.SOUTH);
		
		if(spielerListe.size() > 3) {
			vierterPlatz.setText("Platz 4: " + spielerListe.get(3).getName());
			vierterPlatz.setForeground(Color.BLACK);
		}
		
		gbcEigenschaftenSetzen(0,0,1,2);
		gbc.insets = new Insets(0,0,100,0);
		banderole = new DekoBild(750,500,"Bilder/gewinner_banner.png");
		banderole.setOpaque(false);
		layout.setConstraints(banderole, gbc);
		ergebnissePanel.add(banderole);
	}
	
	private void gbcEigenschaftenSetzen(int x, int y, int width, int height) {
		this.gbc.gridx = x;
		this.gbc.gridy = y;
		this.gbc.gridwidth = width;
		this.gbc.gridheight = height;
	}
}
