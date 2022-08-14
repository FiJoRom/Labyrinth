package labyrinth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpielfigurVornePanel extends JPanel {

	private JLabel jlabel;
	private BufferedImage bufferedimage;
	private File bilddatei;
	private ImageIcon imageicon;
	private String bilddateipfad;
	
	public SpielfigurVornePanel() {
		
		//this.setBounds(30, y, 270, 115);
		this.setOpaque(false);
		this.bilddateipfad = "Bilder/leeres_Bild_Spielfigur.png";
		this.bilddatei = new File("Bilder/leeres_Bild_Spielfigur.png");
		try {
			this.bufferedimage = ImageIO.read(bilddatei);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageicon = new ImageIcon(bufferedimage);
		this.jlabel = new RotatedLabel(imageicon);
		this.add(jlabel);
		
	}
	
	public void bildaendern(String neu) {
		this.removeAll();
		repaint();
		this.bilddatei = new File(neu);
		try {
			this.bufferedimage = ImageIO.read(bilddatei);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageicon = new ImageIcon(bufferedimage);
		this.jlabel = new RotatedLabel(imageicon);
		this.jlabel.setVisible(true);
		this.add(jlabel);
	}
}
