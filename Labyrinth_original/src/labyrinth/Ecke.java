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
		zustandAktualisieren();		
	}

	@Override
	public void gangkarte90GradDrehenNachLinks() {
		if(this.drehung == 0) {
			this.drehung = 3;
		} else {
			this.drehung -= 1;
		}
		zustandAktualisieren();		
	}

	@Override
	public void zustandAktualisieren() {
		switch(this.drehung) {
		case 0:
			this.nordausgang = true;
			this.ostausgang = true;
			this.suedausgang = false;
			this.westausgang = false;	
			break;
		case 1:
			this.nordausgang = false;
			this.ostausgang = true;
			this.suedausgang = true;
			this.westausgang = false;
			break;
		case 2:
			this.nordausgang = false;
			this.ostausgang = false;
			this.suedausgang = true;
			this.westausgang = true;
			break;
		case 3:
			this.nordausgang = true;
			this.ostausgang = false;
			this.suedausgang = false;
			this.westausgang = true;
			break;
		}	
	}
	
}