package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import technique.LiaisonBdGui;

public class WordPan extends JPanel{
	private String text[]=new String[10];
	private MainPan mp;
	private JList<String> list;
	private JButton jbAffInfo=new JButton("Informations");
	
	public WordPan(MainPan mp)
	{
		this.mp=mp;
		
		this.setLayout(new BorderLayout());
		
		for(int j=0;j<10;j++)
		{
			text[j]=new String("");
			
		}
		
		list = new JList<>(text); //data has type Object[]
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		jbAffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()>=0)
					LiaisonBdGui.changeInformation((list.getSelectedValue().substring(3)));
			}
		});
		
		
		this.add(list,BorderLayout.CENTER);
		this.add(jbAffInfo,BorderLayout.SOUTH);
		
	}
	
	public void setWords(String []texts)
	{
		int j;
		for(j=0;j<texts.length;j++)
		{
			text[j]=j+": "+texts[j];
		}
		for(;j<10;j++)
			text[j]="";
		
		this.remove(list);
		list=new JList<>(text); 
		this.add(list);
	}
	
	public String getWordAt(int index)
	{
		String word="";
		if(index>=0&&index<10)
		{
			if(text[index].compareTo("")!=0)
			{
				word=text[index].substring(3);
			}
		}
		return word;
	}
	
	
}
