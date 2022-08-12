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
		this.setBounds(1050, 700, 200, 180);
		
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
		this.add(fertig, BorderLayout.CENTER);
		
		oben.setSize(52,52);
		oben.setBorderPainted(false);
		oben.setContentAreaFilled(false);
		oben.setFocusPainted(false);
		oben.setOpaque(false);
		this.add(oben, BorderLayout.NORTH);
		
		unten.setSize(52,52);
		unten.setBorderPainted(false);
		unten.setContentAreaFilled(false);
		unten.setFocusPainted(false);
		unten.setOpaque(false);
		this.add(unten, BorderLayout.SOUTH);
		
		rechts.setSize(52,52);
		rechts.setBorderPainted(false);
		rechts.setContentAreaFilled(false);
		rechts.setFocusPainted(false);
		rechts.setOpaque(false);
		this.add(rechts, BorderLayout.EAST);
		
		links.setSize(52,52);
		links.setBorderPainted(false);
		links.setContentAreaFilled(false);
		links.setFocusPainted(false);
		links.setOpaque(false);
		this.add(links, BorderLayout.WEST);
				
		fertig.addActionListener(e -> {System.exit(0);});
		oben.addActionListener(e -> {System.exit(0);});
		unten.addActionListener(e -> {System.exit(0);});
		rechts.addActionListener(e -> {System.exit(0);});
		links.addActionListener(e -> {System.exit(0);});
	}
}
	

