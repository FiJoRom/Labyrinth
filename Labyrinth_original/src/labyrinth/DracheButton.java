package labyrinth;

import javax.swing.Icon;
import javax.swing.JButton;

public class DracheButton extends JButton{

	private static final long serialVersionUID = -7763744151240246035L;

	public DracheButton(Icon icon, int x, int y, int width, int height) {
		
		super(icon);
		this.setBounds(x, y, width, height);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setOpaque(false);
	}
}
