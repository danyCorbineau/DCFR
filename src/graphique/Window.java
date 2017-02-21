package graphique;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	public Window()
	{
		this.setTitle("Fr project v2.0");	// nom de la fenetre
		this.setSize(200*4, 200*2);	// taille initiale de la fenetre
		this.setMinimumSize(new Dimension(400,100));
	}
	
	public void reactualise()
	{
		this.invalidate();
		this.validate();
		this.repaint();	
	}
	
	public void addPanelAndBar(JPanel jp,JMenuBar jmb)
	{
		this.setContentPane(jp);
		this.setJMenuBar(jmb);
	}
	
}
