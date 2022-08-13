package labyrinth;

import java.util.ArrayList;
import java.util.List;

//import labyrinth.Karte;

public class LabyrinthDaten {

	private int spieleranzahl; 
	private List<Spieler> spielerliste = new ArrayList<Spieler>();
	private List<Karte> kartendeck;
	private Spielfeld spielfeld = new Spielfeld();
	private Spieler aktuellerSpieler;
	
	public Spieler getAktuellerSpieler() {
		return aktuellerSpieler;
	}

	public void setAktuellerSpieler(Spieler aktuellerSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
	}

	public LabyrinthDaten() {
		spielfeld.gaengekartenAuslegen();
	}

	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
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
	
	public boolean schrittMoeglichOben() {
		boolean rueckgabe = false;
		int x = aktuellerSpieler.getPositionX();
		int y = aktuellerSpieler.getPositionY();
		
		if(y == 0) {
			rueckgabe = false;
		}else {
			if(spielfeld.getMatrix()[x][y].nordausgang && spielfeld.getMatrix()[x][y-1].suedausgang){
				rueckgabe = true;
			}else {
				rueckgabe = false;
			}
		}
		return rueckgabe;
	}
	
	public boolean schrittMoeglichUnten() {
		boolean rueckgabe = false;
		int x = aktuellerSpieler.getPositionX();
		int y = aktuellerSpieler.getPositionY();
		
		if(y == 6) {
			rueckgabe = false;
		}else {
			if(spielfeld.getMatrix()[x][y].suedausgang && spielfeld.getMatrix()[x][y+1].nordausgang){
				rueckgabe = true;
			}else {
				rueckgabe = false;
			}
		}
		return rueckgabe;
	}
	
	public boolean schrittMoeglichLinks() {
		boolean rueckgabe = false;
		int x = aktuellerSpieler.getPositionX();
		int y = aktuellerSpieler.getPositionY();
		
		if(x == 0) {
			rueckgabe = false;
		}else {
			if(spielfeld.getMatrix()[x][y].westausgang && spielfeld.getMatrix()[x-1][y].ostausgang){
				rueckgabe = true;
			}else {
				rueckgabe = false;
			}
		}
		return rueckgabe;
	}
	
	public boolean schrittMoeglichRechts() {
		boolean rueckgabe = false;
		int x = aktuellerSpieler.getPositionX();
		int y = aktuellerSpieler.getPositionY();
		
		if(x == 6) {
			rueckgabe = false;
		}else {
			if(spielfeld.getMatrix()[x][y].ostausgang && spielfeld.getMatrix()[x+1][y].westausgang){
				rueckgabe = true;
			}else {
				rueckgabe = false;
			}
		}
		return rueckgabe;
	}
	
	public void schrittMachen(String richtung) {
		switch(richtung) {
		case "oben": 
			aktuellerSpieler.schrittNachOben();
			break;
		case "unten": 
			aktuellerSpieler.schrittNachUnten();
			break;
		case "links": 
			aktuellerSpieler.schrittNachLinks();
			break;
		case "rechts":
			aktuellerSpieler.schrittNachRechts();
			break;
		default:
			break;
		}
	}
	
	
	public void spielerVerschieben(int x, int y) {
		
		
	}

	
}
