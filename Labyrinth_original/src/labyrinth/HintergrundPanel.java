package labyrinth;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HintergrundPanel extends JPanel {
	
	String farbe1;
	String farbe2;
	
	HintergrundPanel(String eingabeFarbe1, String eingabeFarbe2) {
		
		this.farbe1 = eingabeFarbe1;
		this.farbe2 = eingabeFarbe2;
		
	}
	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int breite = getWidth(), hoehe = getHeight();
        //Color color1 = Color.decode("#ff561A");
        Color color1 = Color.decode(farbe1);
        Color color2 = Color.decode(farbe2);
       
        //Color color2 = Color.decode("#ffd662");
        //Color color2 = Color.decode("#ffcc40");
        
        //GradientPaint farbverlaufMitteObenUnten = new GradientPaint(breite/2, 0, color1, breite/2, hoehe, color2);
        
        GradientPaint farbverlaufMitteObenUnten = new GradientPaint(breite/2, 0, color1, breite/2, hoehe, color2);
        g2d.setPaint(farbverlaufMitteObenUnten);
        g2d.fillRect(0, 0, breite, hoehe);
    }
}
