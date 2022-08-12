package labyrinth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import labyrinth.RotatedLabel.Direction;

public class GangPanel extends JPanel{

	private RotatedLabel jlabel;
	private BufferedImage bufferedimage;
	private File bilddatei;
	private ImageIcon imageicon;
	private String bilddateipfad;
	
	
	public GangPanel(int x, int y, String imagepath) {
		this.setBounds(x, y, 90, 95);
		this.setOpaque(false);
		this.bilddateipfad = imagepath;
		this.bilddatei = new File(imagepath);
		try {
			this.bufferedimage = ImageIO.read(bilddatei);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageicon = new ImageIcon(bufferedimage);
		this.jlabel = new RotatedLabel(imageicon);
		
		//jlabel.setDirection(Direction.VERTICAL_DOWN);
		//jlabel.setDirection(Direction.VERTICAL_UP);
		//jlabel.setDirection(Direction.BACKWARDS);
		//jlabel.setDirection(Direction.HORIZONTAL);

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
		this.add(jlabel);
	}

}
