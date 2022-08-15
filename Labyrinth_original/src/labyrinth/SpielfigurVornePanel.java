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
	
	private static final long serialVersionUID = 3126452588110585123L;
	
	public SpielfigurVornePanel() {
		this.setOpaque(false);
		this.setSize(30,50);
		this.bilddateipfad = "Bilder/leeres_Bild_Spielfigur.png";
		this.bilddatei = new File(bilddateipfad);
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