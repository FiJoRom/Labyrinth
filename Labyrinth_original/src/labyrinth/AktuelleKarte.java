package labyrinth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AktuelleKarte extends JPanel{
	
	private JLabel jlabel;
	private BufferedImage bufferedimage;
	private File bilddatei;
	private ImageIcon imageicon;
	private String bilddateipfad;
	
	private static final long serialVersionUID = -3632372322736727440L;

	public AktuelleKarte(String imagepath) {
		this.setBounds(713, 740, 127, 205);
		this.setOpaque(false);
		bilddateipfad = new String();
		this.bilddateipfad = imagepath;
		this.bilddatei = new File(bilddateipfad);
		try {
			this.bufferedimage = ImageIO.read(bilddatei);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageicon = new ImageIcon(bufferedimage);
		this.jlabel = new JLabel(imageicon);
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
		this.jlabel = new JLabel(imageicon);
		this.add(jlabel);
	}
}
