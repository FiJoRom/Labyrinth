package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	
	private String Name = new String();
	private String Farbe = new String();
	private int PositionX;
	private int PositionY;
	//private List<Karte> SchatzkartenZiel = new ArrayList<Karte>();
	
	public Spieler(String NameEingabe, String FarbeEingabe) {
		
		this.Name = NameEingabe;
		this.Farbe = FarbeEingabe;
		
		if(this.Farbe == "Rot"){
			this.PositionX = 0; 
			this.PositionY = 0;
		}
		
		if(this.Farbe == "Blau"){
			this.PositionX = 6; 
			this.PositionY = 0;
		}
		
		if(this.Farbe == "Gelb"){
			this.PositionX = 0; 
			this.PositionY = 6;
		}
		
		if(this.Farbe == "Gruen"){
			this.PositionX = 6; 
			this.PositionY = 6;
		}
	}
}
