package labyrinth;

public class StartfeldRot extends Startfeld {

	private static StartfeldRot instance = null;
	
	private StartfeldRot() {
		nordausgang = true;
		ostausgang = false;
		suedausgang = false;
		westausgang = true;
		schatz = "keinSchatz";
		drehung = 3;
		farbe = "rot";
	}
	
	public static StartfeldRot getInstance() {
		if(instance == null) {
			instance = new StartfeldRot();
		}
		return instance;
	}

}
