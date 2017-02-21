package graphique;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ZoneSaisie extends JTextArea{
	
	public ZoneSaisie()
	{
		super(5,5);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setLineWrap(true);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Zone de text");
		title = BorderFactory.createTitledBorder(
                this.getBorder(), "Zone de text");
		title.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(title);
	}
	
}
