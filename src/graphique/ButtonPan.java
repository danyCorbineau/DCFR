package graphique;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPan extends JPanel{
	
	public ButtonPan()
	{
		this.setLayout(new GridLayout(7,1));
	}
	
	public void addButons(JButton[] jb)
	{
		for( JButton j: jb)
			this.add(j);
	}
	
}
