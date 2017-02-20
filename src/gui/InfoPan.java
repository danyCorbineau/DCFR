package gui;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPan extends JPanel{
	
	private JLabel[] texts=new JLabel[6];
	
	
	public InfoPan()
	{
		GridLayout gl = new GridLayout(2, 3);
		gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(5);
		
		this.setLayout(gl);
		
		for(int j=0;j<6;j++)
		{
			texts[j]=new JLabel("");
			this.add(texts[j]);
		}
		
			
	}
	
	public void setText(String[] texts)
	{
		for(int j=0;j<6;j++)
			this.texts[j].setText(texts[j]);
	}
	

}
