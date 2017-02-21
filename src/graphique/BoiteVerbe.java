package graphique;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class BoiteVerbe extends JDialog{
	public BoiteVerbe(String title)
	{
		super((JFrame)null, title, true);
		this.setSize((int) ((int)200*1.5), 80*3);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	}
	
	public void reactualiser()
	{
		this.invalidate();
		this.validate();
		this.repaint();	
	}
	
}
