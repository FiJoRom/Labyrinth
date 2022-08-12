package labyrinth;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GangUebrigPanel extends JPanel {
	private JButton linksdrehung;
	private JButton rechtsdrehung;
	private GangPanel ganguebrig;
	
	public GangUebrigPanel() {
		this.setLayout(new BorderLayout());
		this.setBounds(1050, 100, 280, 115);
		
		ImageIcon linksdrehungIcon = new ImageIcon("Bilder/iconDrehungLinks.png");
		ImageIcon rechtsdrehungIcon = new ImageIcon("Bilder/iconDrehungRechts.png");
		ImageIcon linksdrehungsIconRollover = new ImageIcon("Bilder/iconDrehungLinks_mouseover.png");
		ImageIcon rechtsdrehungsIconRollover = new ImageIcon("Bilder/iconDrehungRechts_mouseover.png");
		
		ganguebrig = new GangPanel("Bilder/blau_g.png");
		this.add(ganguebrig);
		
		linksdrehung = new JButton(linksdrehungIcon);
		rechtsdrehung = new JButton(rechtsdrehungIcon);
	
		linksdrehung.setBorderPainted(false);
		linksdrehung.setContentAreaFilled(false);
		linksdrehung.setFocusPainted(false);
		linksdrehung.setOpaque(false);
		linksdrehung.setRolloverIcon(linksdrehungsIconRollover);
		linksdrehung.addActionListener(e -> {System.exit(0);});
		this.add(linksdrehung, BorderLayout.WEST );
	
		rechtsdrehung.setBorderPainted(false);
		rechtsdrehung.setContentAreaFilled(false);
		rechtsdrehung.setFocusPainted(false);
		rechtsdrehung.setOpaque(false);
		rechtsdrehung.setRolloverIcon(rechtsdrehungsIconRollover);
		rechtsdrehung.addActionListener(e -> {System.exit(0);});
		this.add(rechtsdrehung, BorderLayout.EAST);
		
	}
	
	
}
