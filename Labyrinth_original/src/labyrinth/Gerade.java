package labyrinth;

public class Gerade extends Gangkarte {

	public Gerade() {
		nordausgang = true;
		ostausgang = false;
		suedausgang = true;
		westausgang = false;
		schatz = "keinSchatz";
	}

	@Override
	public void gangkarte90GradDrehenNachRechts() {
		this.drehung = (this.drehung + 1)%4;
		switch(this.drehung%2) {
		case 0:
			this.nordausgang = true;
			this.ostausgang = false;
			this.suedausgang = true;
			this.westausgang = false;
			break;
		case 1:
			this.nordausgang = false;
			this.ostausgang = true;
			this.suedausgang = false;
			this.westausgang = true;
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
		switch(this.drehung%2) {
		case 0:
			this.nordausgang = true;
			this.ostausgang = false;
			this.suedausgang = true;
			this.westausgang = false;
			break;
		case 1:
			this.nordausgang = false;
			this.ostausgang = true;
			this.suedausgang = false;
			this.westausgang = true;
			break;
		}
	}

}
