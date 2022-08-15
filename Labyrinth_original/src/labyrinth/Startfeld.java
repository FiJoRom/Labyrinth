package labyrinth;

public class Startfeld extends Ecke {

	protected String farbe;
	
	public Startfeld() {
		schatz = "keinSchatz";
	}
	
	public static Startfeld[] erzeugeStartfeldSet() {
		Startfeld[] neu = new Startfeld[4];
		neu[0] = StartfeldGruen.getInstance();
		neu[1] = StartfeldGelb.getInstance();
		neu[2] = StartfeldBlau.getInstance();
		neu[3] = StartfeldRot.getInstance();
		return neu;
	}

}