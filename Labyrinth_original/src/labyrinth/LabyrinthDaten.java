package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthDaten {

	private int spieleranzahl; 
	private static List<Spieler> spielerliste = new ArrayList<Spieler>();
	
	public LabyrinthDaten() {
		// TODO Auto-generated constructor stub
	}

	public int getSpieleranzahl() {
		return spieleranzahl;
	}

	public void setSpieleranzahl(int spAnzahl) {
		spieleranzahl = spAnzahl;
		System.out.println("Spieleranzahl: " + spieleranzahl);
	}

	public static List<Spieler> getSpielerliste() {
		return spielerliste;
	}

	public static void setSpielerliste(List<Spieler> spielerliste) {
		LabyrinthDaten.spielerliste = spielerliste;
	}

	
}
