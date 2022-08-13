package labyrinth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpielfigurPanel extends JPanel {

	private JLabel jlabel;
	private BufferedImage bufferedimage;
	private File bilddatei;
	private ImageIcon imageicon;
	private String bilddateipfad;
	
	private static int xPositionenRotGelb[]= {385, 475, 565, 655, 745, 835, 925};
	private static int xPositionenGruenBlau[] = {389, 479, 569, 659, 749, 839, 929};
	private static int yPositionen[]= {43, 133, 223, 313, 403, 493, 583};

	SpielfigurPanel(int x, int y, int width, int height, String imagePath){
		
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
	
	SpielfigurPanel(){
		this.setOpaque(false);
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
	
	public void position(int eingabeX, int eingabeY, String farbe) {
		
		if(farbe.equals("Rot") || farbe.equals("Gelb")) {
			//this.setAlignmentX(xPositionenRotGelb[eingabeX]);
			this.setLocation(xPositionenRotGelb[eingabeX], yPositionen[eingabeY]);
		}else {
			this.setLocation(xPositionenGruenBlau[eingabeX],yPositionen[eingabeY]);
		}
		
		//this.setAlignmentY(yPositionen[eingabeY]);
		validate();
	}
	
	
}
