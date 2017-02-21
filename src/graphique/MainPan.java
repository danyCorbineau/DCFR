package graphique;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPan extends JPanel{
	
	public MainPan()
	{
		this.setLayout(new BorderLayout());
	}
	
	public void addPanels(JPanel[] jps)
	{
		if(jps.length>0)
			this.add(jps[0],BorderLayout.CENTER);
		
		if(jps.length>1)
			this.add(jps[1],BorderLayout.SOUTH);
		
		if(jps.length>2)
			this.add(jps[2],BorderLayout.WEST);
		
		if(jps.length>3)
			this.add(jps[3],BorderLayout.EAST);
	}
	
	
}
