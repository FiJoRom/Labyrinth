package labyrinth;

import javax.swing.JFrame;

public class WillkommenGUI extends JFrame {
	
	private LabyrinthDaten daten;

	public WillkommenGUI(LabyrinthDaten model) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Willkommen beim Verrückten Labyrinth");
		this.daten = model;
		
		// JFrame-Konfiguration
		this.setSize(1500, 1000);
		this.setLocation(200, 20);
	}

}
