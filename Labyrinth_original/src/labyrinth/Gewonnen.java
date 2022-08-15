package labyrinth;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Gewonnen extends JDialog{
	
	private JPanel ergebnissePanel;
	private JPanel gewinnerPanel;
	private JPanel gewinnerPanelUnten;
	private DekoBild banderole;
	private JLabel ersterPlatz;
	private JLabel zweiterPlatz;
	private JLabel dritterPlatz;
	private JLabel vierterPlatz;
	private JLabel hatgewonnen;
	private SpielfigurVornePanel siegerfigurPanel;
	private DekoBild siegerfigur;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	private JPanel platzierungen;
	
	public Gewonnen(String erster, String farbeErster, String zweiter, String dritter, String vierter) {
				
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("SPIEL VORBEI"); 
		this.setResizable(false);
		this.setSize(800, 800);
		this.setLocation(530, 200);
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();
		//layout.setVgap(-10);
		
		String imagePathErster = "Bilder/figurspieler_" + farbeErster + "_gewinner.png";		
		
		
		
		ergebnissePanel = new JPanel();
		ergebnissePanel.setLayout(layout);
		ergebnissePanel.setSize(800,800);
		ergebnissePanel.setBackground(Color.decode("#ffc04f"));
		//ergebnissePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.add(ergebnissePanel);		
		
		
		
		/*gewinnerPanel = new JPanel();
		gewinnerPanel.setSize(750,600);
		gewinnerPanel.setLayout(new BorderLayout());
		gewinnerPanel.setOpaque(false);
		gewinnerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ergebnissePanel.add(gewinnerPanel,BorderLayout.NORTH);
		*/
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(225,5,0,5);
		ersterPlatz = new JLabel(erster,SwingConstants.CENTER);
		ersterPlatz.setSize(120, 30);
		//ersterPlatz.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		ersterPlatz.setFont(ersterPlatz.getFont().deriveFont((float) 30));
		layout.setConstraints(ersterPlatz, gbc);
		ergebnissePanel.add(ersterPlatz);
		
		/*
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		banderole = new DekoBild(750,500,"Bilder/gewinner_banner.png");
		//generiereGangbilder(banderole, "Bilder/gewinner_banner.png");
		//banderole.setSize(750,500);
		//banderole.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		banderole.setOpaque(false);
		layout.setConstraints(banderole, gbc);
		ergebnissePanel.add(banderole);
		*/
		
		
		/*
		gewinnerPanelUnten = new JPanel();
		gewinnerPanelUnten.setSize(200,300);
		gewinnerPanelUnten.setLayout(new BorderLayout());
		gewinnerPanelUnten.setOpaque(false);
		//gewinnerPanelUnten.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ergebnissePanel.add(gewinnerPanelUnten,BorderLayout.CENTER);
		*/
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0,5,225,5);
		hatgewonnen = new JLabel("HAT GEWONNEN",SwingConstants.CENTER);
		hatgewonnen.setSize(120, 200);
		//hatgewonnen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		hatgewonnen.setFont(hatgewonnen.getFont().deriveFont((float) 30));
		layout.setConstraints(hatgewonnen, gbc);
		ergebnissePanel.add(hatgewonnen);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10,5,5,5);
		siegerfigur = new DekoBild(36 , 70, imagePathErster);
		siegerfigur.setOpaque(false);
		//siegerfigur.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		layout.setConstraints(siegerfigur, gbc);
		ergebnissePanel.add(siegerfigur);
			
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0,5,50,5);
		platzierungen = new JPanel();
		platzierungen.setLayout(new BorderLayout());
		platzierungen.setOpaque(false);
		platzierungen.setSize(120, 200);
		//platzierungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 22, 0));
		layout.setConstraints(platzierungen, gbc);
		ergebnissePanel.add(platzierungen);
		
		zweiterPlatz = new JLabel("Platz 2: " + zweiter,SwingConstants.CENTER);
		zweiterPlatz.setSize(120, 25);	
		zweiterPlatz.setBorder(BorderFactory.createEmptyBorder(0, 0, 22, 0));
		zweiterPlatz.setFont(zweiterPlatz.getFont().deriveFont((float) 22));
		platzierungen.add(zweiterPlatz,BorderLayout.NORTH);
		
		dritterPlatz = new JLabel("Platz 3: " + dritter,SwingConstants.CENTER);
		dritterPlatz.setSize(120, 25);
		dritterPlatz.setBorder(BorderFactory.createEmptyBorder(0, 0,22, 0));
		dritterPlatz.setFont(dritterPlatz.getFont().deriveFont((float) 22));
		platzierungen.add(dritterPlatz,BorderLayout.CENTER);
		
		vierterPlatz = new JLabel("Platz 4: " + vierter,SwingConstants.CENTER);
		vierterPlatz.setSize(120, 25);
		vierterPlatz.setFont(vierterPlatz.getFont().deriveFont((float) 22));
		vierterPlatz.setBorder(BorderFactory.createEmptyBorder(0, 0, 22 , 0));
		platzierungen.add(vierterPlatz,BorderLayout.SOUTH);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.insets = new Insets(0,0,100,0);
		banderole = new DekoBild(750,500,"Bilder/gewinner_banner.png");
		//generiereGangbilder(banderole, "Bilder/gewinner_banner.png");
		//banderole.setSize(750,500);
		//banderole.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		banderole.setOpaque(false);
		layout.setConstraints(banderole, gbc);
		ergebnissePanel.add(banderole);
		
	}
	
	private void generiereGangbilder(JPanel gangpanel, String gangpath) {
		try {
			BufferedImage logo = ImageIO.read(new File(gangpath));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			gangpanel.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
}
