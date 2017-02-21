package graphique;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CenterPan extends JPanel{
	public CenterPan()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.blue);
	}
	public void addJTextArea(JTextArea jta)
	{
		this.add(jta,BorderLayout.CENTER);
	}
	
}
