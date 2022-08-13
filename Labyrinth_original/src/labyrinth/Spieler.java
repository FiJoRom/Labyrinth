package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	
	private String name = new String();
	private String farbe = new String();
	private int positionX;
	private int positionY;
	private List<Karte> kartenblatt = new ArrayList<Karte>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public List<Karte> getKartenblatt() {
		return kartenblatt;
	}

	public void setKartenblatt(List<Karte> kartenblatt) {
		this.kartenblatt = kartenblatt;
	}

	public Spieler(String NameEingabe, String FarbeEingabe) {
		
		this.name = NameEingabe;
		this.farbe = FarbeEingabe;
		
		if(this.farbe == "Gruen"){
			this.positionX = 0; 
			this.positionY = 0;
		}
		
		if(this.farbe == "Gelb"){
			this.positionX = 6; 
			this.positionY = 0;
		}
		
		if(this.farbe == "Blau"){
			this.positionX = 0; 
			this.positionY = 6;
		}
		
		if(this.farbe == "Rot"){
			this.positionX = 6; 
			this.positionY = 6;
		}
	}

	public void schrittNachOben() {
		this.positionY = (this.positionY + 1)%7;
	}
	
	public void schrittNachUnten() {
		
		if(positionY == 0)
		{
			this.positionY = 6;
		}else {
		this.positionY = (this.positionY - 1);
		}
	}
	
	public void schrittNachLinks() {
		this.positionX = (this.positionX + 1)%7;
	}
	
	public void schrittNachRechts() {
		if(positionX == 0)
		{
			this.positionX = 6;
		}else {
		this.positionX = (this.positionX - 1);
		}
	}
	
	
	@Override
	public String toString() {
		String Ausgabe = new String();
		Ausgabe = this.name + " " + this.farbe + " " + positionX + " " + positionY + " " + this.kartenblatt; 
		return Ausgabe;
	}

}
