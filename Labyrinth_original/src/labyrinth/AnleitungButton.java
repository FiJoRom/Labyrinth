package labyrinth;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AnleitungButton extends JButton{
	
	public AnleitungButton(Icon icon) {
		super(icon);
		this.setBounds(1090,740,230,230);
		ImageIcon buchMouseover = new ImageIcon("Bilder/buchAnleitung_mouseover.png");
	
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
		this.setRolloverIcon(buchMouseover);
	}

}
