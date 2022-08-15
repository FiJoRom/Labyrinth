package labyrinth;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AnleitungButton extends JButton{
	
	private static final long serialVersionUID = -8831760154371122500L;

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
