package labyrinth;

public class StartfeldGelb extends Startfeld {

	private static StartfeldGelb instance = null;
	
	public StartfeldGelb() {
		nordausgang = false;
		ostausgang = false;
		suedausgang = true;
		westausgang = true;
		schatz = "keinSchatz";
		drehung = 2;
		farbe = "gelb";
	}

	public static StartfeldGelb getInstance() {
		if(instance == null) {
			instance = new StartfeldGelb();
		}
		return instance;
	}
}
