import gui.Window;
import sqlite.GestionBDD;

public class FrMain {

	public static void main(String[] args) {
		GestionBDD g=new GestionBDD("testLex");

		
		Window w=new Window(g);
		
		
		
		w.setVisible(true);
	}

}
