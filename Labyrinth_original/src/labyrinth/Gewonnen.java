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
	private JLabel ersterPlatz;
	private JLabel zweiterPlatz;
	private JLabel dritterPlatz;
	private JLabel vierterPlatz;
	private JLabel banderole;
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
		ergebnissePanel.setSize(400,400);
		ergebnissePanel.setBackground(Color.decode("#ffc04f"));
		ergebnissePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.add(ergebnissePanel);
		
		banderole = new JLabel();
		
		ersterPlatz = new JLabel(erster,SwingConstants.CENTER);
		ersterPlatz.setSize(120, 30);
		ersterPlatz.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
		ersterPlatz.setFont(ersterPlatz.getFont().deriveFont((float) 30));
		ergebnissePanel.add(ersterPlatz,BorderLayout.NORTH);	
		
		hatgewonnen = new JLabel("HAT GEWONNEN",SwingConstants.CENTER);
		hatgewonnen.setSize(120, 30);
		hatgewonnen.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
		hatgewonnen.setFont(hatgewonnen.getFont().deriveFont((float) 30));
		hatgewonnen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		ergebnissePanel.add(hatgewonnen,BorderLayout.CENTER);	
		
		siegerfigurPanel = new SpielfigurVornePanel();
		siegerfigur = new DekoBild(36 , 70, imagePathErster);
		siegerfigur.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
		

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
}
