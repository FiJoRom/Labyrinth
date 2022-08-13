package labyrinth;

import java.util.Random;

public abstract class Gangkarte {

	protected boolean nordausgang;
	protected boolean ostausgang;
	protected boolean suedausgang;
	protected boolean westausgang;
	public static Random zufall = new Random();
	
	protected String schatz;
	protected int drehung;
	
	public int getDrehung() {
		return drehung;
	}

	public void setDrehung(int drehung) {
		this.drehung = drehung;
	}

	public Gangkarte() {
		drehung = 0;
	}

	abstract public void gangkarte90GradDrehenNachRechts();
	abstract public void gangkarte90GradDrehenNachLinks();
	
	public void gangkarteWirbeln() {
		int drehen = zufall.nextInt(4);
		for(int i = 0; i < drehen - 1; i++) {
			gangkarte90GradDrehenNachRechts();
		}
	}
	
	public static Gangkarte[] erzeugeGaengekartenSet() {
		Gangkarte[] neu = new Gangkarte[34];
		for(int i = 0; i < 12; i++) {
			neu[i] = new Gerade();
		}
		Gangkarte[] eneu = Ecke.erzeugeEckeSet();
		for(int j = 0; j < eneu.length; j++) {
			neu[j+12] = eneu[j];
		}
		Gangkarte[] tneu = TKreuzung.erzeugeTKreuzungSet();
		for(int k = 0; k < tneu.length; k++) {
			neu[k+28] = tneu[k];
		}
		return neu;
	}
}
