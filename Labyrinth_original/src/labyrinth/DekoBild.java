package labyrinth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DekoBild extends JPanel{
	
	private JLabel jlabel;
	private BufferedImage bufferedimage;
	private File bilddatei;
	private ImageIcon imageicon;
	private String bilddateipfad;
	
	public DekoBild(int x, int y, int width, int height, String imagePath){

		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.bilddateipfad = imagePath;
		this.bilddatei = new File(imagePath);
		try {
			this.bufferedimage = ImageIO.read(bilddatei);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageicon = new ImageIcon(bufferedimage);
		this.jlabel = new JLabel(imageicon);
		this.add(jlabel);
	
	}
	
	public DekoBild(int width, int height, String imagePath){

		this.setSize(width, height);
		this.setOpaque(false);
		this.bilddateipfad = imagePath;
		this.bilddatei = new File(imagePath);
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
