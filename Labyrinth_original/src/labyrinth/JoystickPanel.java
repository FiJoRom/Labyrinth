package labyrinth;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JoystickPanel extends JPanel{
	
	private JButton oben;
	private JButton unten;
	private JButton links;
	private JButton rechts;
	private JButton fertig;
	//neu
	private BorderLayout layout;

	public JoystickPanel(){
		
		layout = new BorderLayout();
		
		this.setLayout(layout);
		layout.setHgap(-10);
		this.setBounds(1100, 450, 200, 180);
		
		//Icons
		ImageIcon fertigIcon = new ImageIcon("Bilder/iconfertig.png");
		ImageIcon obenIcon = new ImageIcon("Bilder/iconoben.png");
		ImageIcon untenIcon = new ImageIcon("Bilder/iconunten.png");
		ImageIcon linksIcon = new ImageIcon("Bilder/iconlinks.png");
		ImageIcon rechtsIcon = new ImageIcon("Bilder/iconrechts.png");
		
		ImageIcon fertigIconMouseover = new ImageIcon("Bilder/iconfertig_mouseover.png");
		ImageIcon obenIconMouseover = new ImageIcon("Bilder/iconoben_mouseover.png");
		ImageIcon untenIconMouseover = new ImageIcon("Bilder/iconunten_mouseover.png");
		ImageIcon linksIconMouseover = new ImageIcon("Bilder/iconlinks_mouseover.png");
		ImageIcon rechtsIconMouseover = new ImageIcon("Bilder/iconrechts_mouseover.png");
		
		ImageIcon fertigIconLocked = new ImageIcon("Bilder/iconfertig_locked.png");
		ImageIcon obenIconLocked = new ImageIcon("Bilder/iconoben_locked.png");
		ImageIcon untenIconLocked = new ImageIcon("Bilder/iconunten_locked.png");
		ImageIcon linksIconLocked = new ImageIcon("Bilder/iconlinks_locked.png");
		ImageIcon rechtsIconLocked = new ImageIcon("Bilder/iconrechts_locked.png");
		
		fertig = new JButton(fertigIcon);
		oben = new JButton(obenIcon);
		unten = new JButton(untenIcon);
		rechts = new JButton(rechtsIcon);
		links = new JButton(linksIcon);
		
		
		//Joystick
		fertig.setSize(52,52);
		fertig.setBorderPainted(false);
		fertig.setContentAreaFilled(false);
		fertig.setFocusPainted(false);
		fertig.setOpaque(false);
		fertig.setRolloverIcon(fertigIconMouseover);
		fertig.setDisabledIcon(fertigIconLocked);
		this.add(fertig, BorderLayout.CENTER);
		
		oben.setSize(52,52);
		oben.setBorderPainted(false);
		oben.setContentAreaFilled(false);
		oben.setFocusPainted(false);
		oben.setOpaque(false);
		oben.setRolloverIcon(obenIconMouseover);
		oben.setDisabledIcon(obenIconLocked);
		this.add(oben, BorderLayout.NORTH);
		
		unten.setSize(52,52);
		unten.setBorderPainted(false);
		unten.setContentAreaFilled(false);
		unten.setFocusPainted(false);
		unten.setOpaque(false);
		unten.setRolloverIcon(untenIconMouseover);
		unten.setDisabledIcon(untenIconLocked);
		this.add(unten, BorderLayout.SOUTH);
		
		rechts.setSize(52,52);
		rechts.setBorderPainted(false);
		rechts.setContentAreaFilled(false);
		rechts.setFocusPainted(false);
		rechts.setOpaque(false);
		rechts.setRolloverIcon(rechtsIconMouseover);
		rechts.setDisabledIcon(rechtsIconLocked);
		this.add(rechts, BorderLayout.EAST);
		
		links.setSize(52,52);
		links.setBorderPainted(false);
		links.setContentAreaFilled(false);
		links.setFocusPainted(false);
		links.setOpaque(false);
		links.setRolloverIcon(linksIconMouseover);
		links.setDisabledIcon(linksIconLocked);
		this.add(links, BorderLayout.WEST);
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
	

