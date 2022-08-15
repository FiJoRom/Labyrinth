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
	private BorderLayout layout;
	private JPanel platzierungen;
	
	public Gewonnen(String erster, String farbeErster, String zweiter, String dritter, String vierter) {
				
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("SPIEL VORBEI"); 
		
		this.setSize(800, 600);
		this.setLocation(530, 200);
		layout = new BorderLayout();
		layout.setVgap(-10);
		
		String imagePathErster = "Bilder/spielfigur_" + farbeErster + "_vorne.png";		
		
		
		
		
		ergebnissePanel = new JPanel();
		ergebnissePanel.setLayout(layout);
		ergebnissePanel.setSize(800,600);
		ergebnissePanel.setBackground(Color.decode("#ffc04f"));
		ergebnissePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.add(ergebnissePanel);		
		
		
		
		gewinnerPanel = new JPanel();
		gewinnerPanel.setSize(750,600);
		gewinnerPanel.setLayout(new BorderLayout());
		gewinnerPanel.setOpaque(false);
		gewinnerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ergebnissePanel.add(gewinnerPanel,BorderLayout.NORTH);
		
		ersterPlatz = new JLabel(erster,SwingConstants.CENTER);
		ersterPlatz.setSize(120, 30);
		ersterPlatz.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		ersterPlatz.setFont(ersterPlatz.getFont().deriveFont((float) 30));
		gewinnerPanel.add(ersterPlatz,BorderLayout.NORTH);
		
		banderole = new DekoBild(750,500,"Bilder/gewinner_banner.png");
		//generiereGangbilder(banderole, "Bilder/gewinner_banner.png");
		//banderole.setSize(750,500);
		banderole.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		banderole.setOpaque(false);
		gewinnerPanel.add(banderole,BorderLayout.NORTH);
		
		
		
		
		gewinnerPanelUnten = new JPanel();
		gewinnerPanelUnten.setSize(200,300);
		gewinnerPanelUnten.setLayout(new BorderLayout());
		gewinnerPanelUnten.setOpaque(false);
		gewinnerPanelUnten.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ergebnissePanel.add(gewinnerPanelUnten,BorderLayout.CENTER);
		
		hatgewonnen = new JLabel("HAT GEWONNEN",SwingConstants.CENTER);
		hatgewonnen.setSize(120, 200);
		hatgewonnen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		hatgewonnen.setFont(hatgewonnen.getFont().deriveFont((float) 30));
		gewinnerPanelUnten.add(hatgewonnen,BorderLayout.NORTH);	
		
		siegerfigurPanel = new SpielfigurVornePanel();
		siegerfigur = new DekoBild(36 , 70, imagePathErster);
		siegerfigur.setOpaque(false);
		siegerfigur.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		siegerfigurPanel.add(siegerfigur);
		gewinnerPanelUnten.add(siegerfigurPanel,BorderLayout.CENTER);
			
		
		
		
		
		platzierungen = new JPanel();
		platzierungen.setLayout(new BorderLayout());
		platzierungen.setOpaque(false);
		platzierungen.setSize(120, 200);
		platzierungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 22, 0));
		ergebnissePanel.add(platzierungen,BorderLayout.SOUTH);
		
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
