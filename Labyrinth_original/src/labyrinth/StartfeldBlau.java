package labyrinth;

public class StartfeldBlau extends Startfeld {

	private static StartfeldBlau instance = null;
	
	private StartfeldBlau() {
		nordausgang = true;
		ostausgang = true;
		suedausgang = false;
		westausgang = false;
		schatz = "keinSchatz";
		drehung = 0;
		farbe = "blau";
	}
	
	public static StartfeldBlau getInstance() {
		if(instance == null) {
			instance = new StartfeldBlau();
		}
		return instance;
	}

}