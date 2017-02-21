package graphique;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class WordPan extends JPanel{
	
	public WordPan()
	{
		this.setLayout(new GridLayout(1,1));
	}
	
	public void addList(JList<String> jl)
	{
		this.removeAll();
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl.setFont(new Font("Arial", Font.PLAIN, 16));
		this.add(jl);
	}
	
	
}
