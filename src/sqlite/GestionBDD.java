package sqlite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBDD {
	private Connection c = null;
	
	public GestionBDD(String dbName)
	{
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+dbName+".db");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Getclass error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connexion error ");
		}
	}
	
	public void closeDbConnexion()
	{
		if(c!=null)
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void creatTable()
	{
		//INTEGER / REAL / TEXT
		try {
			Statement stmt=c.createStatement();
			//stmt.executeUpdate("CREATE TABLE lexique (ortographe TEXT, phonetique TEXT, lemme TEXT, categorie_grammatical TEXT, genre TEXT, nombre TEXT, frequence_lemme_film REAL, frequence_lemme_livre REAL, frequence_film REAL, frequence_livre REAL,  infoverbe TEXT, nombre_homographe INTEGER, nombre_homophone INTEGER, islem INTEGER, nb_lettre INTEGER, nb_phoneme INTEGER, cvcv TEXT, p_cvcv TEXT, nombre_voisin_orthographique INTEGER, nombre_voisin_phonetique INTEGER, point_unicite_orthographique INTEGER, point_unicite_phonetique INTEGER, forme_phonologique_silab TEXT, nombre_sylabe INTEGER, cv_cv TEXT, orthrenv TEXT, phonrenv TEXT, forme_orthographique_syllabee TEXT)");
			
			//stmt.executeUpdate("DROP VIEW ortho");
			//stmt.executeUpdate("CREATE VIEW ortho AS SELECT ortographe FROM lexique WHERE ortographe LIKE 'p%'");
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ortographe / phonétique / lemme / catégori grammatical / genre / nombre / fréquence lemme filme / 
				// fréquence lemme livre / fréquence livre / fréquence film / infover (modes temps personnes) / nombre d'homographe
				// nombre d'homophone / islem (indique si c'est un lem) / nb lettre / nb phonème ( diférence phonétique) / cvcv structure ortho
				// p-cvcv structure phonologique / voisorth nombre voisin orthographique / voisphon nombre de voisin phonétique
				// puort point d'unité orthographique / puphon point d'unicité phonétique / forme phonologique silab / 
				// nbsyll nombre sylabe / cv-cv structure phonologique syllabée / orthrenv forme orthographique inverse /
				// phonrenv fome phonétique invercé / forme orthographique syllabée
	}
	
	public void instertLine(String[] data)
	{
		Statement stmt;
		String rqt="INSERT INTO lexique VALUES (";
		
		for(int j=0;j<data.length;j++)
		{
			rqt+="'"+data[j]+"'";
			if(j!=data.length-1)
				rqt+=" , ";
			
		}
		rqt+=")";
		
		try {
			System.out.println(data[0]);
			stmt = c.createStatement();
			stmt.executeUpdate(rqt);
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void affTable()
	{
		Statement stmt=null; int j;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT ortographe FROM lexique WHERE ortographe LIKE 'ph%' ORDER BY frequence_lemme_livre DESC LIMIT 10;" );
			
			j=0;
			while ( rs.next() ) {
				j++;
				
				System.out.println(j+": "+rs.getString(1));
				
				
			}
			
			rs.close();
		    stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void loadFile(String fName)
	{
		try {
			
			InputStream fis = new FileInputStream(fName);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			
			BufferedReader br = new BufferedReader(isr);
			String line;
			line=br.readLine();
			while( (line=br.readLine()) !=null)
			{
				line =line.replace("'", " ");
				String table[]=line.split("\t");
				String use[]=new String[28];
				for(int j=0;j<28 && j<table.length;j++)
					use[j]=table[j];
				this.instertLine(use);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet selectWord(String start, int lim,boolean order,Statement stmt)
	{
		ResultSet rs=null;
		String rqt;
		
		if (order)
			rqt="SELECT ortographe FROM lexique WHERE ortographe LIKE '"+start+"%' ORDER BY frequence_livre DESC LIMIT "+lim+";";
		else
			rqt="SELECT ortographe FROM lexique WHERE ortographe LIKE '"+start+"%' LIMIT "+lim+";";
				
		try {
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(rqt);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet selectWordComplet(String word,Statement stmt)
	{
		ResultSet rs=null;
		String rqt;
		rqt="SELECT ortographe AS Orthographe,lemme AS Lemme, categorie_grammatical AS \"Catégorie grammaticale\", genre AS Genre, nombre AS Nombre, infoverbe AS \"Information verbe\" FROM lexique WHERE ortographe='"+word+"';";
				
		try {
			stmt = c.createStatement();
			
			rs = stmt.executeQuery(rqt);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
