package labyrinth;

import java.util.List;
import java.util.Random;

public class Spielfeld {
	
	private static Gangkarte[] tKreuzungFest = TKreuzung.erzeugeTFestSet();
	private static Gangkarte[] startfelderFest = Startfeld.erzeugeStartfeldSet();
	
	private Gangkarte[] gaengeLose;
	private Gangkarte[][] matrix;
	private Gangkarte rest;
	
	public Spielfeld() {
		matrix = new Gangkarte[7][7];
		int iTKreuzung = 0;
		int iStart = 0;
		for(int i = 0; i < 7; i++) {
			for(int k = 0; k < 7; k++) {
				if(((i == 0)||(i == 6)) && ((k == 0)||(k == 6))) {
					matrix[i][k] = startfelderFest[iStart];
					iStart++;
				} else {
					matrix[i][k] = tKreuzungFest[iTKreuzung];
					iTKreuzung++;
				}
				k++;
			}
			i++;
		}
		gaengeLose = Gangkarte.erzeugeGaengekartenSet();
	}
	
	public void gaengekartenAuslegen() {
		gaengekartenMischen();
		int iGaengeLose = 0;
		for(int i = 0; i < 7; i++) {
			for(int k = 0; k < 7; k++) {
				if(this.matrix[i][k] == null) {
					this.matrix[i][k] = this.gaengeLose[iGaengeLose];
					iGaengeLose++;
				} 
			}
		}
		this.setRest(this.gaengeLose[33]);
	}

		
	public void gaengekartenMischen() {
		Random zufall = new Random();
		for(int i = this.gaengeLose.length - 1; i >= 0; i--) {
			int j = zufall.nextInt(i+1);
			Gangkarte tmp = this.gaengeLose[i];
			this.gaengeLose[i] = this.gaengeLose[j];
			this.gaengeLose[j] = tmp;
		}
		for(int j = 0; j < this.gaengeLose.length; j++) {
			this.gaengeLose[j].gangkarteWirbeln();
		}
	}
	
	public void schiebenInXRichtungVonLinks(int y) {
		Gangkarte kopieN1 =this.matrix[y][0];
		Gangkarte kopieN2;
		this.matrix[y][0] = this.rest;
		this.rest = this.matrix[y][6];
		for(int i = 1; i < 7; i++) {
			kopieN2 = kopieN1;
			kopieN1 = matrix[y][i];
			matrix[y][i] = kopieN2;
		}
	}
	
	public void schiebenInXRichtungVonRechts(int y) {
		Gangkarte kopieN1 =this.matrix[y][6];
		Gangkarte kopieN2;
		this.matrix[y][6] = this.rest;
		this.rest = this.matrix[y][0];
		for(int i = 5; i >= 0; i--) {
			kopieN2 = kopieN1;
			kopieN1 = matrix[y][i];
			matrix[y][i] = kopieN2;
		}
	}
	
	public void schiebenInYRichtungVonOben(int x) {
		Gangkarte kopieN1 =this.matrix[0][x];
		Gangkarte kopieN2;
		this.matrix[0][x] = this.rest;
		this.rest = this.matrix[6][x];
		for(int i = 1; i < 7; i++) {
			kopieN2 = kopieN1;
			kopieN1 = matrix[i][x];
			matrix[i][x] = kopieN2;
		}
	}
	
	public void schiebenInYRichtungVonUnten(int x) {
		Gangkarte kopieN1 =this.matrix[6][x];
		Gangkarte kopieN2;
		this.matrix[6][x] = this.rest;
		this.rest = this.matrix[0][x];
		for(int i = 5; i > 0; i--) {
			kopieN2 = kopieN1;
			kopieN1 = matrix[i][x];
			matrix[i][x] = kopieN2;
		}
	}

	public Gangkarte getRest() {
		return rest;
	}

	public void setRest(Gangkarte rest) {
		this.rest = rest;
	}
	
	public Gangkarte[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Gangkarte[][] matrix) {
		this.matrix = matrix;
	}
}
