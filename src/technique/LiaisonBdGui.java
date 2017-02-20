package technique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.Window;
import sqlite.GestionBDD;

public class LiaisonBdGui {
	private static GestionBDD bdd;
	private static Window w;
		
	public LiaisonBdGui(GestionBDD bdd, Window w)
	{
		this.bdd=bdd;
		this.w=w;
		
		
	}
	
	public static void addWindowEventListener(Window w)
	{
		w.addWindowListener(new WindowFrListener());
	}
	
	public static void changeInformation(String word)
	{
		Statement stm = null;
		ResultSet rs=bdd.selectWordComplet(word,stm);
		
		String change[]=new String[28];
		if(rs!=null)
		{
			try {
				while(rs.next())
				{
					for(int j=1;j<=rs.getMetaData().getColumnCount();j++)
					{
						change[j-1]=rs.getMetaData().getColumnLabel(j)+" : "+rs.getString(j);
					}
					
				}
				w.setInformations(change);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		try {
			if(stm!=null)
				stm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		w.reactualise();
	}
	
	
	public static void endWindow()
	{
		bdd.closeDbConnexion();
		w.dispose();
	}
	
	public static void updateDocument(String word,int limite,boolean order)
	{
		if(word.length()>2 && word.length()<20)
		{
			String words[];
			Statement stm = null;
			//System.out.println("word "+table[table.length-1]);
			ResultSet rs=bdd.selectWord(word, limite, order,stm);
			
			words=new String[limite];
			try {
				for(int j=0;rs.next();j++)
				{
					words[j]=rs.getString(1);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			w.setWords(words);
			try {
				if(stm!=null)
					stm.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			w.reactualise();
		}
	}
	
	public static void changeCurentWord(int key)
	{
		w.changeMotActuel(key);
	}

}
