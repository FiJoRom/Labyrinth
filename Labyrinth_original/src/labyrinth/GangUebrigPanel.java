package labyrinth;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GangUebrigPanel extends JPanel {
	private JButton linksdrehung;
	private JButton rechtsdrehung;
	private GangPanel ganguebrig;
	
	public GangUebrigPanel() {
		this.setLayout(new BorderLayout());
		this.setBounds(1150, 100, 230, 115);
		
		ImageIcon linksdrehungIcon = new ImageIcon("Bilder/iconDrehungLinks.png");
		ImageIcon rechtsdrehungIcon = new ImageIcon("Bilder/iconDrehungRechts.png");
		
		linksdrehung = new JButton(linksdrehungIcon);
		rechtsdrehung = new JButton(rechtsdrehungIcon);
		
		linksdrehung.setSize(52, 52);
		linksdrehung.setBorderPainted(false);
		linksdrehung.setContentAreaFilled(false);
		linksdrehung.setFocusPainted(false);
		linksdrehung.setOpaque(false);
		linksdrehung.addActionListener(e -> {System.exit(0);});
		this.add(linksdrehung,BorderLayout.WEST );
		
		rechtsdrehung.setSize(52, 52);
		rechtsdrehung.setBorderPainted(false);
		rechtsdrehung.setContentAreaFilled(false);
		rechtsdrehung.setFocusPainted(false);
		rechtsdrehung.setOpaque(false);
		rechtsdrehung.addActionListener(e -> {System.exit(0);});
		this.add(rechtsdrehung, BorderLayout.EAST);
		
		ganguebrig = new GangPanel("Bilder/blau_g.png");
		this.add(ganguebrig);
		
	}
	
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
            System.out.println("mouse entered!");
            //String gesuchterSchatzName = aktuellerSpielerAmZug.getKartenblatt().get(0).getSchatz();
            String URI = "Bilder/iconDrehungLinks_mouseover.png";

            System.out.println(URI);

            //linksdrehung.bildaendern(URI);
            validate();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//aktuelleKarte.bildaendern("Bilder/rueckseite2_k.png");
			validate();
		}
		
	}
}
