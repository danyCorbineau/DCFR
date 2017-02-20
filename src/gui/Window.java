package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import sqlite.GestionBDD;
import technique.LiaisonBdGui;
import technique.WindowFrListener;

public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionBDD bdd;
	private MainPan mp;
	
	
	public Window(GestionBDD gbdd)
	{
		this.setTitle("Fr project");	// nom de la fenetre
		this.setSize(200*4, 200*2);	// taille initiale de la fenetre
		this.setMinimumSize(new Dimension(400,100));
		
		bdd=gbdd;
		mp=new MainPan(bdd,this);
		this.setContentPane(mp);
		
	}
	
	
	
	public void reactualise()
	{
		this.invalidate();
		this.validate();
		this.repaint();	
	}
	
	public void setInformations(String []info)
	{
		mp.setInformations(info);
	}
	public void setWords(String word[])
	{
		mp.setWords(word);
	}
	public void changeMotActuel(int key)
	{
		mp.changeCurentWord(mp.getWordAtKey(key));
	}
	
	
}
