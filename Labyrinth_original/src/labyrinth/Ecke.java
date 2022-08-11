package labyrinth;

public class Ecke extends Gangkarte {
	
	private static String[] schatznamenEcke = {"spinne","kater","maus", "eule", "kaefer", "salamander"};
	
	public Ecke() {
		nordausgang = true;
		ostausgang = true;
		suedausgang = false;
		westausgang = false;
	}
	
	public static Gangkarte[] erzeugeEckeSet() {
		Gangkarte[] neu = new Gangkarte[16];
		for(int i=0; i < neu.length; i++) {
			if(i < 6) {
				neu[i] = new Ecke();
				neu[i].schatz = schatznamenEcke[i];
			} else {
				neu[i] = new Ecke();
				neu[i].schatz = "keinSchatz";
			}
		}
		return neu;
	}

	@Override
	public void gangkarte90GradDrehenNachRechts() {
		this.drehung = (this.drehung + 1)%4;
		switch(this.drehung) {
		case 0:
			this.westausgang = false;
			this.ostausgang = true;
			break;
		case 1:
			this.nordausgang = false;
			this.suedausgang = true;
			break;
		case 2:
			this.ostausgang = false;
			this.westausgang = true;
			break;
		case 3:
			this.suedausgang = false;
			this.nordausgang = true;
			break;
		}
	}

	@Override
	public void gangkarte90GradDrehenNachLinks() {
		if(this.drehung == 0) {
			this.drehung = 3;
		} else {
			this.drehung -= 1;
		}
		switch(this.drehung) {
		case 0:
			this.suedausgang = false;
			this.nordausgang = true;
			break;
		case 1:
			this.westausgang = false;
			this.ostausgang = true;
			break;
		case 2:
			this.nordausgang = false;
			this.suedausgang = true;
			break;
		case 3:
			this.ostausgang = false;
			this.westausgang = true;
			break;
		}
		
	}
	
	//oder extra Funktion schatzZuordnen()
	/*
	 * public void schatzZuordnen(){
	 * 		this.schatz = schatznamen[i];
	 * 		if(i < 4){
	 * 			i++;
	 * 		}
	 * }
	 */

}
