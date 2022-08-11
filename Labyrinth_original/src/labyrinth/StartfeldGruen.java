package labyrinth;

public class StartfeldGruen extends Startfeld {

	private static StartfeldGruen instance = null;
	
	public StartfeldGruen() {
		nordausgang = false;
		ostausgang = true;
		suedausgang = true;
		westausgang = false;
		schatz = "keinSchatz";
		drehung = 1;
		farbe = "gruen";
	}
	
	public static StartfeldGruen getInstance() {
		if(instance == null) {
			instance = new StartfeldGruen();
		}
		return instance;
	}

}
