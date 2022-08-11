package labyrinth;

public class TKreuzung extends Gangkarte {

	private static String[] schatznamen = {"Zwerg","Flaschengeist","Fledermaus", "Geist", 
			"Drache", "Einhorn"};
	
	private static String[] schatznamenFest = {"Ring", "Zaubertrank", "Kerzenstaender", "Schatztruhe",
			"Krone", "Buch", "Ritterhelm", "Rubin", "Schluessel", "Muenzbeutel", "Dolch", "Kelch"};
	
	public TKreuzung() {
		nordausgang = true;
		ostausgang = true;
		suedausgang = false;
		westausgang = true;
	}
	
	public static Gangkarte[] erzeugeTFestSet() {
		Gangkarte[] neu = new Gangkarte[schatznamenFest.length];
		for(int i=0; i < schatznamenFest.length; i++) {
			neu[i] = new TKreuzung();
			neu[i].schatz = schatznamenFest[i];
			switch(i) {
			case 0,1,4:
				neu[i].drehung = 1;
				neu[i].gangkarte90GradDrehenNachRechts();
				break;
			case 2,3,6:
				neu[i].gangkarte90GradDrehenNachRechts();
				break;
			case 5,8,9:
				neu[i].drehung = 2;
				neu[i].gangkarte90GradDrehenNachRechts();
				break;
			case 7,10,11:
				break;
			}
		}
		return neu;
	}
	
	public static Gangkarte[] erzeugeTKreuzungSet() {
		Gangkarte[] neu = new Gangkarte[schatznamen.length];
		for(int i=0; i < schatznamen.length; i++) {
			neu[i] = new TKreuzung();
			neu[i].schatz = schatznamen[i];
		}
		return neu;
	}

	@Override
	public void gangkarte90GradDrehenNachRechts() {
		this.drehung = (this.drehung + 1)%4;
		switch(this.drehung) {
		case 0:
			this.suedausgang = false;
			this.ostausgang = true;
			break;
		case 1:
			this.westausgang = false;
			this.suedausgang = true;
			break;
		case 2:
			this.nordausgang = false;
			this.westausgang = true;
			break;
		case 3:
			this.ostausgang = false;
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
			this.westausgang = true;
			break;
		case 1:
			this.westausgang = false;
			this.nordausgang = true;
			break;
		case 2:
			this.nordausgang = false;
			this.ostausgang = true;
			break;
		case 3:
			this.ostausgang = false;
			this.suedausgang = true;
			break;
		}
	}
	
}
