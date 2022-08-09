package labyrinth;

import java.util.ArrayList;
import java.util.List;

//import labyrinth.Karte;

public class LabyrinthDaten {

	private int spieleranzahl; 
	private List<Spieler> spielerliste = new ArrayList<Spieler>();
	private List<Karte> kartendeck;
	
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

	public List<Spieler> getSpielerliste() {
		return spielerliste;
	}

	public void setSpielerliste(List<Spieler> spielerlisteEingabe) {
		spielerliste = spielerlisteEingabe;
	}

	public List<Karte> getKartendeck() {
		return kartendeck;
	}

	public void setKartendeck(List<Karte> kartendeckEingabe) {
		kartendeck = kartendeckEingabe;
	}
	
	public void schatzkartenAusteilen(List<Karte> kartendeck) {
		int j = 0;
		do
		{
			for(int i = 0; i < getSpieleranzahl(); i++) {
				spielerliste.get(i).getKartenblatt().add(kartendeck.get(j));
				j++;
			}
		}
		while(j < 24);
	}

	
}
