package graphique;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private JMenu jmRecherhe = new JMenu("Rechercher");
	public Menu()
	{
		this.add(jmRecherhe);
	}
	
	public void addButton(JMenuItem jmi[])
	{
		for(JMenuItem j : jmi)
			jmRecherhe.add(j);
	}
	
}
