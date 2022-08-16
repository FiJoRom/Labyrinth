package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthDaten {

	private int spieleranzahl; 
	private List<Spieler> spielerliste = new ArrayList<Spieler>();
	private List<Karte> kartendeck;
	private Spielfeld spielfeld = new Spielfeld();
	private Spieler aktuellerSpieler;
	private boolean darfSchieben;
	private int verboten;
	
	public LabyrinthDaten() {
		spielfeld.gaengekartenAuslegen();
		darfSchieben = true;
		verboten = 42;
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
			if(spielfeld.getMatrix()[y][x].nordausgang && spielfeld.getMatrix()[y-1][x].suedausgang){
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
			if(spielfeld.getMatrix()[y][x].suedausgang && spielfeld.getMatrix()[y+1][x].nordausgang){
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
			if(spielfeld.getMatrix()[y][x].westausgang && spielfeld.getMatrix()[y][x-1].ostausgang){
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
			if(spielfeld.getMatrix()[y][x].ostausgang && spielfeld.getMatrix()[y][x+1].westausgang){
				rueckgabe = true;
			}else {
				rueckgabe = false;
			}
		}
		return rueckgabe;
	}
	
	public boolean fertigMoeglich() {
        boolean rueckgabe = true;
        int x = aktuellerSpieler.getPositionX();
        int y = aktuellerSpieler.getPositionY();
        int anzahlSpielerDiesePosition = 0;
        for(int i = 0; i < spielerliste.size(); i++) {
            int xVergleich = spielerliste.get(i).getPositionX();
            int yVergleich = spielerliste.get(i).getPositionY();
            if((x == xVergleich) && (y == yVergleich)) {
                anzahlSpielerDiesePosition++;
            }
        }
        if(anzahlSpielerDiesePosition > 1) {
            rueckgabe = false;
        }
        return rueckgabe;
    }
	
	public void SpielerMitGangVerschieben(String richtung, int eingabeStelle) {
		for(int i = 0; i < this.spielerliste.size(); i++) {
			switch(richtung) {
			case "oben": 
				if(this.spielerliste.get(i).getPositionX() == eingabeStelle) {
					this.spielerliste.get(i).schrittNachUnten();
					this.spielerliste.get(i).setVerschoben(true);
				}
				break;
			case "unten": 
				if(this.spielerliste.get(i).getPositionX() == eingabeStelle) {
					this.spielerliste.get(i).schrittNachOben();
					this.spielerliste.get(i).setVerschoben(true);
				}
				break;
			case "links": 
				if(this.spielerliste.get(i).getPositionY() == eingabeStelle) {
					this.spielerliste.get(i).schrittNachRechts();
					this.spielerliste.get(i).setVerschoben(true);
				}
				break;
			case "rechts":
				if(this.spielerliste.get(i).getPositionY() == eingabeStelle) {
					this.spielerliste.get(i).schrittNachLinks();
					this.spielerliste.get(i).setVerschoben(true);
				}
				break;
			default:
				break;
			}
		}
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
	
	public void spielerReset() {
        for(int i = 0; i < this.spielerliste.size(); i++) {
            this.spielerliste.get(i).kartenblattLeeren();
        }
    }
	
	public boolean isDarfSchieben() {
		return darfSchieben;
	}

	public void setDarfSchieben(boolean darfSchieben) {
		this.darfSchieben = darfSchieben;
	}

	public int getVerboten() {
		return verboten;
	}

	public void setVerboten(int verboten) {
		this.verboten = verboten;
	}

	public Spieler getAktuellerSpieler() {
		return aktuellerSpieler;
	}

	public void setAktuellerSpieler(Spieler aktuellerSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
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
}
