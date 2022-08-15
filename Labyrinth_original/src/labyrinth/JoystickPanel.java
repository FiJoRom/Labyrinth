package labyrinth;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JoystickPanel extends JPanel{
	
	private JButton oben;
	private JButton unten;
	private JButton links;
	private JButton rechts;
	private JButton fertig;
	private BorderLayout layout;
	
	private static final long serialVersionUID = -5468751874669759931L;

	public JoystickPanel(){
		layout = new BorderLayout();	
		this.setLayout(layout);
		layout.setHgap(-10);
		this.setBounds(1100, 460, 200, 180);
		this.setOpaque(false);	
			
		ImageIcon fertigIcon = new ImageIcon("Bilder/iconfertig.png");
		fertig = new JButton(fertigIcon);
		eigenschaftenButton(fertig, "Bilder/iconfertig_mouseover.png", "Bilder/iconfertig_locked.png");
		this.add(fertig, BorderLayout.CENTER);
		
		ImageIcon obenIcon = new ImageIcon("Bilder/iconoben.png");
		oben = new JButton(obenIcon);
		eigenschaftenButton(oben, "Bilder/iconoben_mouseover.png", "Bilder/iconoben_locked.png");
		this.add(oben, BorderLayout.NORTH);
		
		ImageIcon untenIcon = new ImageIcon("Bilder/iconunten.png");
		unten = new JButton(untenIcon);
		eigenschaftenButton(unten, "Bilder/iconunten_mouseover.png", "Bilder/iconunten_locked.png");
		this.add(unten, BorderLayout.SOUTH);
		
		ImageIcon rechtsIcon = new ImageIcon("Bilder/iconrechts.png");
		rechts = new JButton(rechtsIcon);
		eigenschaftenButton(rechts, "Bilder/iconrechts_mouseover.png", "Bilder/iconrechts_locked.png");
		this.add(rechts, BorderLayout.EAST);
		
		ImageIcon linksIcon = new ImageIcon("Bilder/iconlinks.png");
		links = new JButton(linksIcon);
		eigenschaftenButton(links, "Bilder/iconlinks_mouseover.png", "Bilder/iconlinks_locked.png");
		this.add(links, BorderLayout.WEST);
	}
	
	private void eigenschaftenButton(JButton button, String mouseover, String locked) {
		button.setSize(52,52);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
		
		ImageIcon iconMouseover = new ImageIcon(mouseover);
		button.setRolloverIcon(iconMouseover);
		ImageIcon iconLocked = new ImageIcon(locked);
		button.setDisabledIcon(iconLocked);
	}

	public JButton getOben() {
		return oben;
	}

	public void setOben(JButton oben) {
		this.oben = oben;
	}

	public JButton getUnten() {
		return unten;
	}

	public void setUnten(JButton unten) {
		this.unten = unten;
	}

	public JButton getLinks() {
		return links;
	}

	public void setLinks(JButton links) {
		this.links = links;
	}

	public JButton getRechts() {
		return rechts;
	}

	public void setRechts(JButton rechts) {
		this.rechts = rechts;
	}

	public JButton getFertig() {
		return fertig;
	}

	public void setFertig(JButton fertig) {
		this.fertig = fertig;
	}
}