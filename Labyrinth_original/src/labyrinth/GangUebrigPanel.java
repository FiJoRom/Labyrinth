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
	
	public GangPanel getGanguebrig() {
		return ganguebrig;
	}

	public void setGanguebrig(GangPanel ganguebrig) {
		this.ganguebrig = ganguebrig;
	}

	public GangUebrigPanel() {
		this.setLayout(new BorderLayout());
		this.setBounds(1050, 100, 280, 115);
		
		ImageIcon linksdrehungIcon = new ImageIcon("Bilder/iconDrehungLinks.png");
		ImageIcon rechtsdrehungIcon = new ImageIcon("Bilder/iconDrehungRechts.png");
		ImageIcon linksdrehungsIconRollover = new ImageIcon("Bilder/iconDrehungLinks_mouseover.png");
		ImageIcon rechtsdrehungsIconRollover = new ImageIcon("Bilder/iconDrehungRechts_mouseover.png");
		
		ganguebrig = new GangPanel("Bilder/rueckseite_gang.png");
		this.add(ganguebrig);
		
		linksdrehung = new JButton(linksdrehungIcon);
		rechtsdrehung = new JButton(rechtsdrehungIcon);
	
		linksdrehung.setBorderPainted(false);
		linksdrehung.setContentAreaFilled(false);
		linksdrehung.setFocusPainted(false);
		linksdrehung.setOpaque(false);
		linksdrehung.setRolloverIcon(linksdrehungsIconRollover);
		this.add(linksdrehung, BorderLayout.EAST );
	
		rechtsdrehung.setBorderPainted(false);
		rechtsdrehung.setContentAreaFilled(false);
		rechtsdrehung.setFocusPainted(false);
		rechtsdrehung.setOpaque(false);
		rechtsdrehung.setRolloverIcon(rechtsdrehungsIconRollover);
		this.add(rechtsdrehung, BorderLayout.WEST);
		
	}
	
	public JButton getLinksdrehung() {
		return linksdrehung;
	}

	public void setLinksdrehung(JButton linksdrehung) {
		this.linksdrehung = linksdrehung;
	}

	public JButton getRechtsdrehung() {
		return rechtsdrehung;
	}

	public void setRechtsdrehung(JButton rechtsdrehung) {
		this.rechtsdrehung = rechtsdrehung;
	}
}
