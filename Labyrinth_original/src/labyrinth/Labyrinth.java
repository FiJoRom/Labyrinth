package labyrinth;

public class Labyrinth {
	
	private LabyrinthDaten model;
	private LabyrinthGUI view;
	
	public Labyrinth() {
		model = new LabyrinthDaten();
		view = new LabyrinthGUI(model);
	}
	
	public static void main(String[] args) {
		Labyrinth controller = new Labyrinth();
		controller.view.setVisible(true);
	}

}