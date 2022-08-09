package labyrinth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Karte {

	private String schatz;
	private String[] schatznamen = {
			"Schatztruhe", "Zwerg" , "Drache", "Einhorn", "Geist", "Kerzenstaender", 
			"Ritterhelm", "Zaubertrank", "Buch", "Spinne", "Krone", "Dolch", "Kelch", 
			"Maus", "Kater", "Ring", "Muenzbeutel", "Schluessel", "Kaefer", "Eule", 
			"Rubin", "Flaschengeist", "Fledermaus", "Salamander" 
	};
	private int schatznamenstelle;
	
	public Karte(int Schatznamenstelle){
		this.schatz = this.schatznamen[Schatznamenstelle];
	}
	
	public String getSchatz() {
		return this.schatz;
	}
	
	public String[] getSchatznamen() {
		return this.schatznamen;
	}
	
	public static List<Karte> erstelleKartenDeck(){
		
		List<Karte> Kartendeck = new ArrayList<Karte>();
			
		for(int i = 0; i < 24; i++)
		{
			Kartendeck.add(new Karte(i));
		}
		
		return Kartendeck;
	}
	
	//Fisher-Yates-Shuffle
	public static void shuffleKartenDeck(List<Karte> kartendeck){
			
			Random zufall = new Random();
			
			for(int i = kartendeck.size() - 1; i >= 0; i--)
			{
				int j = zufall.nextInt(i+1);
				Karte tmp = kartendeck.get(i);
				kartendeck.set(i, kartendeck.get(j));
				kartendeck.set(j, tmp);
			}
		}
	
	//Ausgabeoverride fuer Karten
	@Override
	public String toString() {
		return this.schatz;
	}
}
	
	
